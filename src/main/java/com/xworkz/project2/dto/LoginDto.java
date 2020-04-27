package com.xworkz.project2.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

	private String email;
	private String password;

	public LoginDto() {
		super();
		System.out.println("Object created \t" + this.getClass().getSimpleName());
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
