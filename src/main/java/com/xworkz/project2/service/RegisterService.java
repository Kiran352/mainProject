package com.xworkz.project2.service;

import java.util.Map;

import com.xworkz.project2.dto.RegisterDto;

public interface RegisterService {
	
	public Map<String, String> validateAndSavRegisterDeatils(RegisterDto registerDto);

}
