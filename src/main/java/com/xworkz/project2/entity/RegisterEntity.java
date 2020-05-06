	package com.xworkz.project2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "user_register")
@NamedQueries({ @NamedQuery(name = "fetchByEmail", query = "select e from RegisterEntity e where e.email=:email"),
		@NamedQuery(name = "updatePassword", query = "update  RegisterEntity ent set ent.password=:password where ent.email=:email"),
		@NamedQuery(name = "updateLoginCount", query = "update RegisterEntity ent set ent.login_count=:count where ent.email=:email")

})
public class RegisterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "USER_ID")
	private String usrId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "COURSE")
	private String course;
	@Column(name = "AGREE")
	private String agree;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "LOGIN_COUNT")
	private int login_count;

	private static final Logger logger = Logger.getLogger(RegisterEntity.class);
	
	
	public RegisterEntity() {
		super();
		logger.info("Object created \t" + this.getClass().getSimpleName());
	}

	public int getLogin_count() {
		return login_count;
	}

	public void setLogin_count(int login_count) {
		this.login_count = login_count;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "RegisterEntity [id=" + id + ", usrId=" + usrId + ", email=" + email + ", phone=" + phone + ", course="
				+ course + ", agree=" + agree + ", password=" + password + "]";
	}

}
