package com.vacation.app.controller;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskDemoController {

	public static String PROCESS_KEY = "service-task-process";
	public Logger logger = LoggerFactory.getLogger(TaskDemoController.class);
			
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task")
	public String index() {

		return "task";
	}
	
	@PostMapping("/task")
	public String start() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY);
		logger.info("process instance id >>> " + processInstance.getId());

		List<Task> task = taskService.createTaskQuery().list();
		logger.info("task size >>> " + task.size());
		return "task";
	}
}
