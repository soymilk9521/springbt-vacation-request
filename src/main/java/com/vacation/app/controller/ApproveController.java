package com.vacation.app.controller;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vacation.app.dao.ActIdGroupDao;
import com.vacation.app.form.ApplyForm;
import com.vacation.app.model.ActIdGroup;
import com.vacation.app.model.ActIdUser;

@Controller
public class ApproveController {

	public static final String CANDIDATE_GROUP_ID = "group0002";
	
	public Logger logger = LoggerFactory.getLogger(ApproveController.class);

	@Autowired
	public RepositoryService repositoryService;

	@Autowired
	public RuntimeService runtimeService;

	@Autowired
	public TaskService taskService;
	
	@Autowired
	private ActIdGroupDao groupDao;

	@RequestMapping(value = "approve", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute(value = "form") ApplyForm form) {

		List<ProcessInstance> instances = runtimeService.createProcessInstanceQuery().list();
		List<Execution> executions = runtimeService.createExecutionQuery().list();
		List<Task> tasks = taskService.createTaskQuery().list();

		logger.info("Number of process instances >>> " + instances.size());
		logger.info("Number of tasks >>> " + tasks.size());
		logger.info("Description of task >>> " + tasks.get(0).getDueDate());
		// model.addAttribute("tasks", tasks);
		
		// can approve users
		ActIdGroup group = groupDao.findOne(CANDIDATE_GROUP_ID);
		List<ActIdUser> users = group.getActIdUsers();
		form.setUserList(users);
		return "approve";
	}

	@RequestMapping(value = "approve", method = RequestMethod.POST)
	public String approve(Model model, @ModelAttribute(value = "tasks") List<Task> tasks, BindingResult result) {

		return "approve";
	}
}
