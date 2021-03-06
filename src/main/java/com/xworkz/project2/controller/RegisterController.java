package com.xworkz.project2.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.project2.dto.RegisterDto;
import com.xworkz.project2.service.RegisterService;

@Component
@RequestMapping("/")
public class RegisterController {

	
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	@Autowired
	RegisterService registerService;

	public RegisterController() {
		super();
		this.logger.info("Object created \t" + this.getClass().getSimpleName());
		
	}

	@RequestMapping("/registerUser.do")
	public String registerUser(@ModelAttribute RegisterDto registerDto, Model model) {
		this.logger.info("Controller method invoked");
		System.out.println(registerDto);
		Map<String, String> map = registerService.validateAndSavRegisterDeatils(registerDto);

		model.addAttribute("uid_err", map.get("uid"));
		model.addAttribute("email_err", map.get("email"));
		model.addAttribute("save", map.get("save"));
		model.addAttribute("agree", map.get("agree"));
		model.addAttribute("uid_exist", map.get("uid_exist"));
		model.addAttribute("email_exist", map.get("email_exist"));

		return "Registration";
	}

}
