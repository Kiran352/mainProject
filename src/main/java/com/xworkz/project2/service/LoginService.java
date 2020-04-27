package com.xworkz.project2.service;

import java.util.Map;

import com.xworkz.project2.dto.LoginDto;

public interface LoginService {

	public Map<String, String> validateAndLogin(LoginDto loginDto);
	
}
