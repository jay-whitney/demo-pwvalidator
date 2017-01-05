package com.demo.pwvalidator.rules;

import org.springframework.stereotype.Component;

@Component
public class LowerCaseAlphaNumericOnlyRule implements PasswordRule {
	
	final static String ruleDescription = "Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each";

	@Override
	public boolean isCompliant(String password) {
		if  (password == null) {
			return false;
		}
		boolean hasOneLowerCaseAlpha = false;
		boolean hasOneNumeric = false;
		for (int idx = 0; idx < password.length(); idx++) {
			if (Character.isDigit(password.charAt(idx))) {
				hasOneNumeric = true;
			}
			else if (Character.isLowerCase(password.charAt(idx))) {
				hasOneLowerCaseAlpha = true;
			}
			else {
				return false;
			}
		}
		if (!hasOneLowerCaseAlpha || !hasOneNumeric) {
			return false;
		}
		return true;
	}

	@Override
	public String getRuleDescription() {
		return LowerCaseAlphaNumericOnlyRule.ruleDescription;
	}

}
