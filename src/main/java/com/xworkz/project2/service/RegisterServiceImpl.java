package com.xworkz.project2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.dao.RegisterDaoImpl;
import com.xworkz.project2.dto.RegisterDto;
import com.xworkz.project2.entity.RegisterEntity;

@Component
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterDaoImpl daoImpl;

	public RegisterServiceImpl() {
		super();
		System.out.println("Object created\t" + this.getClass().getSimpleName());
	}

	@Override
	public Map<String, String> validateAndSavRegisterDeatils(RegisterDto registerDto) {
		System.out.println("Service method invoked");
		Map<String, String> map = new HashMap<String, String>();
		boolean status = false;
		boolean uid_exist = true;
		boolean email_exist = true;
		System.out.println(registerDto.getUsrId());

		if (registerDto.getUsrId().length() > 3 && !registerDto.getUsrId().startsWith(" ")) {
			status = true;
			map.put("uid", " ");
		} else {
			map.put("uid", "invalid user id");
			return map;
		}
		if (registerDto.getEmail().length() > 4 && !registerDto.getEmail().startsWith(" ")
				&& registerDto.getEmail().endsWith(".com")) {
			status = true;
			map.put("email", " ");
		} else {
			map.put("email", "invalid email");
			return map;
		}

		if (status) {
			if (registerDto.getAgree().equals("yes")) {
				try {
					boolean readUid = daoImpl.readUid(registerDto.getUsrId());
					System.out.println(readUid);
					uid_exist = readUid;
					if (readUid) {

						map.put("uid_exist", " Entered User Id already Exist");
					} else {
						map.put("uid_exist", " ");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					boolean email = daoImpl.readEmail(registerDto.getEmail());
					email_exist = email;
					if (email) {

						map.put("email_exist", "Entered email already exist");
					} else {
						map.put("email_exist", " ");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (uid_exist == false && email_exist == false) {
					Random random = new Random();
					String pwd = null;
					String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					char password[] = new char[8];
					for (int i = 0; i < password.length; i++) {
						password[i] = letters.charAt(random.nextInt(letters.length()));
						pwd = password.toString();

					}
					RegisterEntity entity = new RegisterEntity();
					BeanUtils.copyProperties(registerDto, entity);
					entity.setPassword(pwd);
					System.out.println(entity);
					daoImpl.saveRegisterDto(entity);
					map.put("save", "Added successfully!!!!!!!!!!");
					map.put("agree", "generated password is " + pwd);
				}

			} else {
				map.put("agree", "User Should Agree to register");
			}
		}

		return map;

	}

}
