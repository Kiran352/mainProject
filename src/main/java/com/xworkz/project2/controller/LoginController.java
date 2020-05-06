package com.xworkz.project2.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.project2.dto.LoginDto;
import com.xworkz.project2.service.LoginServiceImpl;

@Component
@RequestMapping("/")
public class LoginController {

	
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	@Autowired
	LoginServiceImpl serviceImpl;
	
	public LoginController() {
		super();
		logger.info("Object created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping("/login.do")
	public String loginUser(@ModelAttribute LoginDto loginDto,Model model) {
		Map<String, String> map;
		logger.info("Login method invoked");
		//System.out.println("Form data is"+loginDto);
		map = serviceImpl.validateAndLogin(loginDto);
		String status=map.get("status");
		
		if(status.equals("success")) {
			return "HomePage";
		}
		
		
		
		
		model.addAttribute("email_err",map.get("email_err"));
		model.addAttribute("pwd_err",map.get("pwd_err"));
		
		model.addAttribute("invalid",map.get("invalid"));
		model.addAttribute("fail",map.get("fail"));
		model.addAttribute("block",map.get("block"));
		
		return "Login";
		
		
	}

}
