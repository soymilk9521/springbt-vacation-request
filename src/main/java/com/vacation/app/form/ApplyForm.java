package com.vacation.app.form;

import java.util.List;

import com.vacation.app.model.ActIdGroup;
import com.vacation.app.model.ActIdUser;

public class ApplyForm {
	private Long numberOfDays;
	private String startDate;
	private String vacationMotivation;
	private String employeeName;
	private List<ActIdUser> userList;
	private List<ActIdGroup> groupList;
		
	public List<ActIdGroup> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<ActIdGroup> groupList) {
		this.groupList = groupList;
	}
	public List<ActIdUser> getUserList() {
		return userList;
	}
	public void setUserList(List<ActIdUser> userList) {
		this.userList = userList;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(Long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getVacationMotivation() {
		return vacationMotivation;
	}
	public void setVacationMotivation(String vacationMotivation) {
		this.vacationMotivation = vacationMotivation;
	}
	

}
