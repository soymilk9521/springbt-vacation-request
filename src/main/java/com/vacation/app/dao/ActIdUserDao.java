package com.vacation.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacation.app.model.ActIdUser;

public interface ActIdUserDao extends JpaRepository<ActIdUser, String> {

}
