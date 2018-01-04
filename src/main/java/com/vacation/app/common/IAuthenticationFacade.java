package com.vacation.app.common;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
	Authentication getAuthentication();
}
