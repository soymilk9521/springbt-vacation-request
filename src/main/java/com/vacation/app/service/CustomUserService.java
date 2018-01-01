package com.vacation.app.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vacation.app.dao.ActIdUserDao;
import com.vacation.app.model.ActIdUser;

public class CustomUserService implements UserDetailsService {

	@Autowired
	private ActIdUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("1");
        }
		
		ActIdUser user = userDao.findUserByUserId(username);
		
		if (user == null) {
            throw new UsernameNotFoundException("2");
        }
		return user;
	}

}
