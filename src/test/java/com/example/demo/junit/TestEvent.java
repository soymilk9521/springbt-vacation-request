package com.example.demo.junit;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiTestCase;
import org.activiti.engine.test.Deployment;

public class TestEvent extends ActivitiTestCase {
	
	@Deployment
	public void testTimerStartEvent() throws InterruptedException {
		// timer event
		// TestEvent.testTimerStartEvent.bpmn20.xml
		Map<String, Object> var = new HashMap<String, Object>();
		// var.put("duration", "P0Y0M0DT0H0M5S");
		var.put("startTime", "2018-01-05T17:50:00+09:00");
		ProcessInstance ins = runtimeService.startProcessInstanceByKey("timerenentdefinitions", var);
		assertNotNull("ProcessInstancess", ins);
	}

}
