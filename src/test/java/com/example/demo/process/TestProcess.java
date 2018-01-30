package com.example.demo.process;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class TestProcess {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	public void TestDefinedProcess() {

		HistoryService historyService = activitiRule.getHistoryService();
		List<HistoricProcessInstance> histories = historyService.createHistoricProcessInstanceQuery()
				.processDefinitionId("apply_flow_id:12:37509").list();
		assertEquals(5, histories.size());
	}

	@Test
	public void TestHistoricActivityInstanceQuery() {
		HistoryService historyService = activitiRule.getHistoryService();
		List<HistoricActivityInstance> historyActivities = historyService.createHistoricActivityInstanceQuery()
				.processDefinitionId("apply_flow_id:12:37509").processInstanceId("37538").list();
		assertEquals(5, historyActivities.size());
	}
	
	
}
