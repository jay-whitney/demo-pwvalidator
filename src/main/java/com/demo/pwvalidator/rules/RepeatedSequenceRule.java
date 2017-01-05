package com.demo.pwvalidator.rules;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class RepeatedSequenceRule implements PasswordRule {
	
	final static String ruleDescription = "Must not contain any sequence of characters immediately followed by the same sequence";

	@Override
	public boolean isCompliant(String password) {
		if (password == null)
			return false;
		HashMap<String, Integer> stringindexMap = null;
		int len = password.length();
		for (int i = 1; i < len; i++) {
			stringindexMap = new HashMap<String, Integer>();
			for (int j = 0; j + i <= len; j++) {
				String sub = password.substring(j, j + i);
				if (stringindexMap.get(sub) == null) {
					stringindexMap.put(sub, j + i - 1);
				} else {
					int prevlastIndex = stringindexMap.get(sub);
					if (prevlastIndex == j - 1)
						return false;
				}
			}
		}
		return true;
	}

	@Override
	public String getRuleDescription() {
		return RepeatedSequenceRule.ruleDescription;
	}
	
}
