package com.vacation.app.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
	
	public Logger logger = LoggerFactory.getLogger(FormController.class);
			
	@Autowired
	private RuntimeService runtimeService;
	
	@GetMapping("/form")
	public String index(){

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("test_form_key");
		logger.info("process instance id >>> " + processInstance.getId());
		return "form";
	}
}
