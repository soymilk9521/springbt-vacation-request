package com.example.demo.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

public class TestEvent {
	
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	@Test
	@Deployment(resources = { "Test_Signal_Event_Definitions.bpmn20.xml" })
	public void testSignalEvent() throws InterruptedException {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_signal_event_definitions");
		assertNotNull(ins);
		List<Execution> executions = runtimeService.createExecutionQuery()
				.processDefinitionId(ins.getProcessDefinitionId()).list();
		System.out.println("executions.size() >>> " + executions.size());
		Task task = taskService.createTaskQuery().processInstanceId(ins.getId()).singleResult();
		assertEquals("Apply", task.getName());
		System.out.println("task.getName() >>> " + task.getName());
		taskService.claim(task.getId(), "manager_a");
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("applied", true);
		Execution execution = runtimeService.createExecutionQuery().signalEventSubscriptionName("alertSignal").singleResult();
		assertNull(execution);
		taskService.complete(task.getId(), vars);
		// Execution execution2 = runtimeService.createExecutionQuery().signalEventSubscriptionName("alertSignal").singleResult();
		// assertNotNull(execution2);	
	}
	
	
	@Test
	@Deployment(resources = { "Test_Variable_Start_Event.bpmn20.xml" })
	public void testStartEvent() throws InterruptedException, ParseException {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		IdentityService identityService = activitiRule.getIdentityService();
		// set variables
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("num", 10);
		vars.put("str", "hello activiti");
		vars.put("bool", true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2018-01-20");
		vars.put("dueDate", date);
		
		identityService.setAuthenticatedUserId("user");
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_variable_start_event", vars);
		// process instance can not null
		assertNotNull(ins);
		
		Map<String, Object> objVars = runtimeService.getVariables(ins.getId());
		// check variables
		assertEquals(10, objVars.get("num"));
		assertEquals("hello activiti", objVars.get("str"));
		assertEquals(true,objVars.get("bool"));
		assertEquals(date, objVars.get("dueDate"));
		
		List<String> activityIds = runtimeService.getActiveActivityIds(ins.getId());
		List<Execution> executions = runtimeService.createExecutionQuery().parentId(ins.getId()).list();
		//
		assertEquals(2, activityIds.size());
		assertEquals(2, executions.size());
		
		Map<String, Object> execVars = runtimeService.getVariables(executions.get(0).getId());
		assertEquals(5, execVars.size());
		
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(ins.getId()).list();
		for (Task task: tasks) {
			task.getCategory();
			taskService.setAssignee(task.getId(), "user");
		}
	}
	
	

}
