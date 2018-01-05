package com.example.demo.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.DataObject;
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
	@Deployment(resources = { "Signal_Event_Definitions.bpmn20.xml" })
	public void testTimerStartEvent() throws InterruptedException {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("signaleventdefinitions");
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
//		Execution execution = runtimeService.createExecutionQuery().signalEventSubscriptionName("alertSignal").singleResult();
//		assertNull(execution);
		taskService.complete(task.getId(), vars);
//		assertNotNull(execution);
		
		
		
	}

}
