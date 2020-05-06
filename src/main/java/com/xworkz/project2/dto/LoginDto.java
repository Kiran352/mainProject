package com.xworkz.project2.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class LoginDto implements Serializable {

	private String email;
	private String password;
	private static final Logger logger = Logger.getLogger(LoginDto.class);
	
	
	public LoginDto() {
		super();
		logger.info("Object created \t" + this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [email=" + email + ", password=" + password + "]";
	}

}
