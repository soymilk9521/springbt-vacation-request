package com.example.demo.mail;


import static org.junit.Assert.assertNotNull;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

public class TestEmail {
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	/**
	 * Test Parallel Execution
	 * @throws InterruptedException
	 */
	@Test
	@Deployment(resources = { "Test_Mail_Task.bpmn20.xml" })
	public void testSendEmail() throws InterruptedException {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_mail_task");
		// process instance can not be null
		assertNotNull(ins);
		
		Task task = taskService.createTaskQuery().processInstanceId(ins.getId()).singleResult();
		assertNotNull(task);
	}
	
	
}
