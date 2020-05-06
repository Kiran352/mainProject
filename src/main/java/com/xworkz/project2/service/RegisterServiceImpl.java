package com.xworkz.project2.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.dao.RegisterDaoImpl;
import com.xworkz.project2.dto.RegisterDto;
import com.xworkz.project2.entity.RegisterEntity;

@Component
public class RegisterServiceImpl implements RegisterService {

	private static final int lengthOfPassword = 8;

	@Autowired
	RegisterDaoImpl daoImpl;
	private static final Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	public RegisterServiceImpl() {
		super();
		logger.info("Object created\t" + this.getClass().getSimpleName());
	}

	@Override
	public Map<String, String> validateAndSavRegisterDeatils(RegisterDto registerDto) {
		logger.info("Service method invoked");
		Map<String, String> map = new HashMap<String, String>();
		boolean status = false;
		boolean uid_exist = true;
		boolean email_exist = true;

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
					// Random random = new Random();
					String pwd = null;
					// String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					// char password[] = new char[8];
					// for (int i = 0; i < password.length; i++) {
					// password[i] = letters.charAt(random.nextInt(letters.length()));
					// pwd = password.toString();

					// }
					pwd = RegisterServiceImpl.generateRandomPassword(this.lengthOfPassword);

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


	public static String generateRandomPassword(int len) {
		// ASCII range - alphanumeric (0-9, a-z, A-Z)
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		// each iteration of loop choose a character randomly from the given ASCII range
		// and append it to StringBuilder instance

		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}
}
