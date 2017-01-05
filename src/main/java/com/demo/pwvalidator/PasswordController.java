package com.demo.pwvalidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.pwvalidator.model.Password;
import com.demo.pwvalidator.service.PasswordValidationResponse;
import com.demo.pwvalidator.service.PasswordValidatorService;

@Controller
@EnableAutoConfiguration
public class PasswordController {
	
	@Autowired
	PasswordValidatorService passwordValidator;

	public PasswordValidatorService getPasswordValidator() {
		return passwordValidator;
	}

	public void setPasswordValidator(PasswordValidatorService passwordValidator) {
		this.passwordValidator = passwordValidator;
	}

    @GetMapping("/password")
    public String getPassword(Model model) {
        model.addAttribute("password", new Password());
        return "password";
    }

    @PostMapping("/password")
    public String postPassword(@ModelAttribute Password password) {
    	PasswordValidationResponse response = passwordValidator.validatePassword(password.getPassword());
    	password.setValid(response.isValid());
    	password.setReason(response.getReason());
        return "validation";
    }

}
