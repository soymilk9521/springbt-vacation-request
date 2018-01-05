package com.vacation.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacation.app.dao.ActIdUserDao;
import com.vacation.app.form.ApplyForm;
import com.vacation.app.model.ActIdUser;
import com.vacation.app.service.ApplyDemoService;
/**
 * Apply controller
 * 
 * @author ri
 *
 */
@Controller
public class ApplyDemoController extends BaseController {

	public static final String PROCESS_KEY = "vacation-request";

	public Logger logger = LoggerFactory.getLogger(ApplyDemoController.class);

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ActIdUserDao userDao;

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private FormService formService;

	@Autowired
    private ApplyDemoService applyService;
	
	/**
	 * show vacation request apply page
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/apply")
	public String index(Model model, @ModelAttribute(value = "form") ApplyForm form,
			@RequestParam(value = "lang", required = false) String lang) {
		logger.info( this.getClassSimpleName() + " >>> " + this.getMethod());
//		 set default form values
//		List<ActIdUser> users = userDao.findAll();
//		form.setUserList(users);
		form.setNumberOfDays(1L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		form.setStartDate(sdf.format(new Date()));
		model.addAttribute("lang", lang);
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
	public String apply(Model model, @ModelAttribute(value = "form") ApplyForm form, 
			BindingResult result) {
		logger.info(this.getClass().getSimpleName() + " >>> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!result.hasErrors()) {
			ObjectMapper objMapper = new ObjectMapper();
			Map<String, Object> vars = objMapper.convertValue(form, Map.class);
			logger.info("vars >>> " + vars);
			// set apply user
			String userId = applyService.getCurrentUserName();
			identityService.setAuthenticatedUserId(userId);
			// start apply process
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY, vars);
			logger.info("process instance id >>> " + processInstance.getId());
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
	
	@GetMapping("/apply/list")
	public String list(Model model) {
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().list();
		List<Execution> executions= runtimeService.createExecutionQuery().list();
		model.addAttribute("processInstances", processInstances);
		model.addAttribute("executions", executions);
		for (ProcessInstance ins: processInstances) {
			Task task = taskService.createTaskQuery().processInstanceId(ins.getId()).singleResult();
			logger.info("taskName >>> " + task.getName());
			logger.info("getProcessVariables() >>> " + ins.getProcessVariables());
			StartFormData data = formService.getStartFormData(ins.getProcessDefinitionId());
			Object obj = formService.getRenderedStartForm(ins.getProcessDefinitionId());
			logger.info("data.getFormKey() >>> " + data.getFormKey());
			List<FormProperty> properties = data.getFormProperties();
			logger.info("properties >>> " + properties);
		
		}
		
		return "demo/apply_list";
	}
	
	@Transactional()
	public ProcessInstanceQuery createUnFinishedProcessInstanceQuery(String userId) {
	    ProcessInstanceQuery unfinishedQuery = runtimeService.createProcessInstanceQuery().processDefinitionKey(PROCESS_KEY)
	            .active();
	    return unfinishedQuery;
	}
	
	public String getMethod() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	
	public String getClassSimpleName() {
		return this.getClass().getSimpleName();
	}
}
