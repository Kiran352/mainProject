package com.xworkz.project2.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.project2.dto.RegisterDto;
import com.xworkz.project2.service.ResetPasswordServiceImpl;

@Component
@RequestMapping("/")
public class ForgotPasswordController {

	private static final Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	ResetPasswordServiceImpl serviceImpl;
	
	public ForgotPasswordController() {
		super();
		logger.info("Object created \t" + this.getClass().getSimpleName());
	}
	@RequestMapping("/resetPassword.do")
	public String resetPassword(@ModelAttribute RegisterDto dto,Model model) {
		logger.info("inside the reset password method");
		Map<String, String> map = serviceImpl.validateAndReset(dto);
		
		model.addAttribute("success", map.get("reset"));
		
		
		
		return "PasswordResetSuccess";
		
	}

}
