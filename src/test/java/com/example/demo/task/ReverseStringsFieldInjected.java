package com.example.demo.task;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ReverseStringsFieldInjected implements JavaDelegate, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Expression text1;
	private Expression text2;
	
	@Override
	public void execute(DelegateExecution execution) {
		if (text1 != null) {
			String value1 = (String) text1.getValue(execution);
			execution.setVariable("var1", value1);
		}
		
		if (text2 != null) {
			String value2 = (String) text2.getValue(execution);
			execution.setVariable("var2", value2);
		}
		
	}
	
	public String getGenderString(String gender) {
		System.out.println("gender >>> " + gender);
		return gender;
	}

}
