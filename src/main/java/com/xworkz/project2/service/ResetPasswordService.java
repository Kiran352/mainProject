package com.xworkz.project2.service;

import java.util.Map;

import com.xworkz.project2.dto.RegisterDto;

public interface ResetPasswordService {
	
	public Map<String,String> validateAndReset(RegisterDto dto);

}
