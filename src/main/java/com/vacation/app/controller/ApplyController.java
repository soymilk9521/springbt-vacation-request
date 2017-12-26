package com.vacation.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacation.app.dao.ActIdUserDao;
import com.vacation.app.form.ApplyForm;
import com.vacation.app.model.ActIdUser;

/**
 * Apply controller
 * 
 * @author ri
 *
 */
@Controller
public class ApplyController {
	
	public static final String PROCESS_KEY = "vacationRequest";
	
	public Logger logger = LoggerFactory.getLogger(ApplyController.class);
			
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ActIdUserDao userDao;
	
	@RequestMapping(value = "/apply", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute(value = "form") ApplyForm form) {
		logger.info("ApplyController index() >>>");
		ActIdUser user = userDao.findOne("user0001");
		form.setEmployeeName(user.getFirst() + " " + user.getLast());
		form.setNumberOfDays(1L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		form.setStartDate(sdf.format(new Date()));
		logger.info("employeeName >>>" + form.getEmployeeName());
		
		return "apply";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(Model model, @ModelAttribute(value = "form") ApplyForm form,
			BindingResult result) {
		logger.info("ApplyController apply() >>>");
		if (!result.hasErrors()) {
			ObjectMapper objMapper = new ObjectMapper();
			Map<String, Object> vars = objMapper.convertValue(form, Map.class);
			logger.info("vars >>> " + vars);
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY, vars);
			logger.info("process instance id >>> " + processInstance.getId());	
			String activityId = processInstance.getActivityId();
			logger.info("activityId >>> " + activityId);	
			
		}else {
			// TODO show error messages
			for (Object object : result.getAllErrors()) {
			    if(object instanceof FieldError) {
			        FieldError fieldError = (FieldError) object;
			        logger.info("fieldError.getCode() >>> " + fieldError.getCode());
			    }
			    if(object instanceof ObjectError) {
			        ObjectError objectError = (ObjectError) object;
			        logger.info("objectError.getCode() >>> " + objectError.getCode());
			    }
			}
			return "apply";
		}
		
		return "redirect:/approve";
	}
}
