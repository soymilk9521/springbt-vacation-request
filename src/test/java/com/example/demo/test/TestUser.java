package com.example.demo.test;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

public class TestUser {
	
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	@Test
	@Deployment(resources = {"vacation-request.bpmn20.xml"})
	public void testCreateUser(){
		IdentityService identityService = activitiRule.getIdentityService();
		// Group group = identityService.newGroup("group0001");
		Group group = identityService.createGroupQuery().groupId("group0001").singleResult();
        group.setName("Group0001");
        group.setType("assignee");
        identityService.saveGroup(group);

        User user = identityService.createUserQuery().userId("user0001").singleResult();
        user.setFirstName("Mar");
        user.setLastName("Ri");
        user.setPassword("user0001");
        identityService.saveUser(user);
		
	}
}
