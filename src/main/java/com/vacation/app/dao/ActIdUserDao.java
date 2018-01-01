package com.vacation.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vacation.app.model.ActIdUser;

public interface ActIdUserDao extends JpaRepository<ActIdUser, String> {
	
	/**
	 * query ActIdUser by id(hql)
	 * @param username
	 * @return
	 */
	@Query("select t from ActIdUser t where t.id= ?")
	ActIdUser findUserByUserId(String username);
}
