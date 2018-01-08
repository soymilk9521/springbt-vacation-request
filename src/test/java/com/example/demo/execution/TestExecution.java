package com.example.demo.execution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

public class TestExecution {
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	/**
	 * Test Parallel Execution
	 * @throws InterruptedException
	 */
	@Test
	@Deployment(resources = { "Test_Parallel_Execution.bpmn20.xml" })
	public void testParallelExecution() throws InterruptedException {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_parallel_execution");
		// process instance can not be null
		assertNotNull(ins);
		
		List<Execution> executions = runtimeService.createExecutionQuery().parentId(ins.getId()).list();
		// the size of current execution is 2
		assertEquals(2, executions.size());
		
		List<Execution> executions2 = runtimeService.createExecutionQuery()
				.processDefinitionId(ins.getProcessDefinitionId()).list();
		// the size of all execution is 3
		assertEquals(3, executions2.size());
		
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(ins.getId()).list();
		// the size of task is 2
		assertEquals(2, tasks.size());
	}
	
	/**
	 * Test Exclusive Execution
	 * @throws InterruptedException
	 */
	@Test
	@Deployment(resources = { "Test_Exclusive_Execution.bpmn20.xml" })
	public void testExclusiveExecution() throws InterruptedException {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("applied", true);
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_exclusive_execution", vars);
		// process instance can not be null
		assertNotNull(ins);
		
		List<Execution> executions = runtimeService.createExecutionQuery().parentId(ins.getId()).list();
		// the size of current execution is 1
		assertEquals(1, executions.size());
		
		List<Execution> executions2 = runtimeService.createExecutionQuery()
				.processDefinitionId(ins.getProcessDefinitionId()).list();
		// the size of all execution is 2
		assertEquals(2, executions2.size());
		
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(ins.getId()).list();
		// the size of task is 1
		assertEquals(1, tasks.size());
		
		boolean applied = (boolean) runtimeService.getVariable(executions.get(0).getId(), "applied");
		// the value of variable is true
		assertEquals(true, applied);
	}
}
