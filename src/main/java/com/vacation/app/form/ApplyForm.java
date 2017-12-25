package com.vacation.app.form;

import java.util.Date;

public class ApplyForm {
	private Long numberOfDays;
	private Date startDate;
	private String vacationMotivation;
	public Long getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(Long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getVacationMotivation() {
		return vacationMotivation;
	}
	public void setVacationMotivation(String vacationMotivation) {
		this.vacationMotivation = vacationMotivation;
	}
	

}
