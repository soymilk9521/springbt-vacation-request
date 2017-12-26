package com.example.demo.test;

import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiTestCase;
import org.activiti.engine.test.Deployment;

public class TestUserExtendActivitiTestCase extends ActivitiTestCase {
	@Deployment
	public void testSimpleProcess() {
		runtimeService.startProcessInstanceByKey("user-request");

		Task task = taskService.createTaskQuery().singleResult();
		assertEquals("Handle vacation request", task.getName());
	
	    taskService.complete(task.getId());
	    assertEquals(0, runtimeService.createProcessInstanceQuery().count());
	}
}
