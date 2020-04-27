package com.xworkz.project2.dto;

import java.io.Serializable;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


public class RegisterDto implements Serializable {
	
	private String usrId;
	private String email;
	private String phone;
	private String course;
	private String agree;
	public RegisterDto() {
		super();
		System.out.println("Object created \t"+this.getClass().getSimpleName());
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	} 	
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "RegisterDto [usrId=" + usrId + ", email=" + email + ", phone=" + phone + ", course=" + course
				+ ", agree=" + agree + "]";
	}
	
	
	

}
