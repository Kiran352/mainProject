package com.xworkz.project2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.dao.LoginDaImpl;
import com.xworkz.project2.dto.LoginDto;
import com.xworkz.project2.entity.RegisterEntity;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDaImpl loginDaImpl;
	int count = 1;

	public LoginServiceImpl() {
		super();
		System.out.println("Object created \t" + this.getClass().getSimpleName());
	}

	@Override
	public Map<String, String> validateAndLogin(LoginDto loginDto) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("Login Service Method Invoked");
		boolean status = false;
		if (Objects.nonNull(loginDto)) {
			if (loginDto.getEmail().length() > 3 && loginDto.getEmail().endsWith(".com")) {
				status = true;
				map.put("email_err", " ");
			} else {
				map.put("email_err", "Please enter valid Email");
			}
			if (loginDto.getPassword().length() >= 4 && !loginDto.getPassword().isEmpty()) {
				status = true;
				map.put("pwd_err", " ");
			} else {
				status = true;
				map.put("pwd_err", "Please enter valid password");
			}

		}

		if (status) {
			int email_count = loginDaImpl.countOnEmail(loginDto.getEmail());
			System.out.println("Email count is" + email_count);

			if (email_count > 0) {
				RegisterEntity entity = loginDaImpl.readPasswordByEmail(loginDto.getEmail());
				while (entity.getLogin_count() <3) {
					if (entity.getPassword().equals(loginDto.getPassword())) {
						System.out.println("Inside if success");
						map.put("status", "success");
						map.put("invalid", " ");
						count = 0;
						loginDaImpl.updatePasswordCount(count, loginDto.getEmail());
						return map;
					} else {
						System.out.println("Inside else failure");

						loginDaImpl.updatePasswordCount(count, loginDto.getEmail());
						count++;
						map.put("status", " ");
						map.put("fail", "Invalid Password or Email!!!!!!!!!!");
						map.put("invalid", " ");
						return map;
					}
				}
				map.put("status", " ");
				map.put("block", "Maximum limit crossed blocked please enter forgot password");

			} else {
				map.put("status", " ");
				map.put("invalid", "Please register Before Login/Please check the email u enetered");
			}

		}

		return map;
	}

}
