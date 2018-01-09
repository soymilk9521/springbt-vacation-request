package com.vacation.app.form;

public class ApproveForm {
	private String taskId;
	private boolean vacationApproved = false;
	private String managerMotivation;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public boolean isVacationApproved() {
		return vacationApproved;
	}
	public void setVacationApproved(boolean vacationApproved) {
		this.vacationApproved = vacationApproved;
	}
	public String getManagerMotivation() {
		return managerMotivation;
	}
	public void setManagerMotivation(String managerMotivation) {
		this.managerMotivation = managerMotivation;
	}
	
}
