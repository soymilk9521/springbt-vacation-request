package com.vacation.app.form;

public class ApplyForm {
	private Long numberOfDays;
	private String startDate;
	private String vacationMotivation;
	private String applyUserId;
	private String applyUserName;
	private String lang;
	private String processInstanceId;

	public String getLang() {
		return lang;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getApplyUserId() {
		return applyUserId;
	}
	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}
	public String getApplyUserName() {
		return applyUserName;
	}
	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
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
