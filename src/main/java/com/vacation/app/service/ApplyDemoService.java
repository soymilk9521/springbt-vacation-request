package com.vacation.app.service;

import java.util.List;


import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.vacation.app.common.IAuthenticationFacade;

@Component
public class ApplyDemoService {
	public Logger logger = LoggerFactory.getLogger(ApplyDemoService.class);
	
	@Autowired
    private IAuthenticationFacade authenticationFacade;
	
	public String getCurrentUserName() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }
	
	public List<ProcessInstance> getProcessInstancesOfUserName(List<ProcessInstance> processInstances) {
		String username = this.getCurrentUserName();
		
		return null;
	}
	
	
}
