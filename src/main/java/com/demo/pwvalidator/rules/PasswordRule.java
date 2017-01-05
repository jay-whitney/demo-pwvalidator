package com.demo.pwvalidator.rules;

public interface PasswordRule {
	
	public boolean isCompliant(String password);
	
	public String getRuleDescription();

}
