package com.example.demo.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.persistence.entity.VariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

public class TestTask {
	
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	/**
	 * activiti:class
	 */
	@Test
	@Deployment(resources = { "Test_Service_Task.bpmn20.xml" })
	public void testServiceTask() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("applyId", "321");
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_service_task", vars);
		assertNotNull(ins);
		Map<String, VariableInstance> map = runtimeService.getVariableInstances(ins.getId());
		VariableInstance varIns = map.get("var1");
		String var = (String) varIns.getValue();
		assertEquals("321", var);
	}
	
	/**
	 * activiti:delegateExpression
	 */
	@Test
	@Deployment(resources = { "Test_Service_Task2.bpmn20.xml" })
	public void testServiceTask2() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("applyId", "321");
		vars.put("reverseStringsFieldInjected", new ReverseStringsFieldInjected());
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("test_service_task2", vars);
		assertNotNull(ins);
		Map<String, VariableInstance> map = runtimeService.getVariableInstances(ins.getId());
		VariableInstance varIns = map.get("var1");
		String var = (String) varIns.getValue();
		assertEquals("321", var);
	}
}
