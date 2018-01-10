package com.vacation.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacation.app.form.ApplyForm;
import com.vacation.app.service.ApplyDemoService;

/**
 * Apply controller
 * 
 * @author ri
 *
 */
@Controller
public class ApplyDemoController extends BaseController {

	public Logger logger = LoggerFactory.getLogger(ApplyDemoController.class);

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
    private ApplyDemoService applyService;
	
	/**
	 * vacation request apply page
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/apply")
	public String index(Model model, @ModelAttribute(value = "form") ApplyForm form) {
		if (StringUtils.isEmpty(form.getNumberOfDays())) {
			form.setNumberOfDays(1L);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtils.isEmpty(form.getStartDate())){
			form.setStartDate(sdf.format(new Date()));
		}
		return "demo/apply";
	}

	/**
	 * vacation request apply
	 * 
	 * @param model
	 * @param form
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(Model model, @Valid @ModelAttribute(value = "form") ApplyForm form, 
			BindingResult result) {
		if (!result.hasErrors()) {
			ObjectMapper objMapper = new ObjectMapper();
			Map<String, Object> vars = objMapper.convertValue(form, Map.class);
			logger.info("vars >>> " + vars);
			// set apply user
			String userId = applyService.getCurrentUserName();
			identityService.setAuthenticatedUserId(userId);
			// start apply process
			if (StringUtils.isEmpty(form.getProcessInstanceId())) {
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY, vars);
				logger.info("process instance id >>> " + processInstance.getId());
				form.setProcessInstanceId(processInstance.getId()); // for edit
			}else {
				runtimeService.setVariables(form.getProcessInstanceId(), vars);
			}

			
			
		} else {
			// TODO show error messages
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					logger.info("fieldError.getCode() >>> " + fieldError.getCode());
				}
				if (object instanceof ObjectError) {
					ObjectError objectError = (ObjectError) object;
					logger.info("objectError.getCode() >>> " + objectError.getCode());
				}
			}
			return "demo/apply";
		}
		return "redirect:/apply/list";
	}
	
	/**
	 * applied vacation request
	 * @param model
	 * @return
	 */
	@GetMapping("/apply/list")
	public String list(Model model) {
		String userId = applyService.getCurrentUserName();
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
				.active().involvedUser(userId).list();		
		List<ApplyForm> list = new ArrayList<ApplyForm>();
		for (ProcessInstance ins: processInstances) {
			ApplyForm form = new  ApplyForm();
			form.setApplyUserId(ins.getStartUserId());
			Map<String, Object> map = new HashMap<String, Object>();
			map = runtimeService.getVariables(ins.getId());
			if (map  !=null && map.size()>0) {
				form.setProcessInstanceId(ins.getId());
				form.setNumberOfDays(map.get("numberOfDays") != null? Long.valueOf(map.get("numberOfDays").toString()): null);
				form.setStartDate(map.get("startDate") != null ? map.get("startDate").toString(): null);
				form.setVacationMotivation(map.get("vacationMotivation") != null ? map.get("vacationMotivation").toString(): null);
			}
			list.add(form);
		}
		
		model.addAttribute("list", list);
		return "demo/apply_list";
	}
}
