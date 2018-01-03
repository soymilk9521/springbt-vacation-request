package com.vacation.app.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SampleJavaDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		String value = (String) execution.getVariable("sampleVar");
		System.out.println(this.getClass().getSimpleName() + " >>> " + value);
		System.out.println(this.getClass().getSimpleName()  + " is running >>>");
	}


}
