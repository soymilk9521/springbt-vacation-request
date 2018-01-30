package com.vacation.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacation.app.form.ActivitiForm;
import com.vacation.app.form.ApproveForm;
import com.vacation.app.service.ApplyDemoService;

@Controller
public class ApproveDemoController extends BaseController {

	public static final String CANDIDATE_GROUP_ID = "group0002";
	
	public Logger logger = LoggerFactory.getLogger(ApproveDemoController.class);

	@Autowired
	public RepositoryService repositoryService;

	@Autowired
	public RuntimeService runtimeService;

	@Autowired
	public TaskService taskService;
	
	@Autowired
    public ActivitiForm activitiForm;

	@Autowired
    private ApplyDemoService applyService;
	
	/**
	 * approve list
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("approve")
	public String index(Model model) {
//		String userId = applyService.getCurrentUserName();
		String userId ="admin";
		List<ProcessInstance> instances = runtimeService.createProcessInstanceQuery().involvedUser(userId).list();
		List<Task> allTasks = new ArrayList<Task>();
		for (ProcessInstance ins: instances) {
			List<Task> tasks = taskService.createTaskQuery().processInstanceId(ins.getId()).taskCandidateUser(userId).list();	
			allTasks.addAll(tasks);
		}
		model.addAttribute("tasks", allTasks);
		logger.info("Number of process instances >>> " + instances.size());
		logger.info("Number of tasks >>> " + allTasks.size());
		return "demo/approve";
	}
	
	/**
	 * preview approve
	 * @param model
	 * @param taskId
	 * @param form
	 * @return
	 */
	@GetMapping("approve/{taskId}")
	public String preApprove(Model model, @PathVariable("taskId") String taskId
			, @ModelAttribute(value = "form") ApproveForm form) {
		form.setTaskId(taskId);
		return "demo/pre_approve";
	}

	/**
	 * approve
	 * @param model
	 * @param form
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("approve")
	public String approve(Model model, @ModelAttribute(value = "form") ApproveForm form) {
//		String userId = applyService.getCurrentUserName();
		String userId ="admin";
		if (!"".equals(form.getTaskId())){
			ObjectMapper objMapper = new ObjectMapper();
			Map<String, Object> vars = objMapper.convertValue(form, Map.class);
			taskService.claim(form.getTaskId(), userId);
			taskService.complete(form.getTaskId(), vars);
		}
		return "redirect:/approve";
	}
}
