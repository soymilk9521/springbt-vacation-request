package com.vacation.app.service;

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
	
	/**
	 * ログインユーザーを取得
	 * @return
	 */
	public String getCurrentUserName() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }
}
