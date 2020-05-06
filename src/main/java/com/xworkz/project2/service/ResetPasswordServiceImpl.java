package com.xworkz.project2.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project2.dao.ResetPasswordDaoImpl;
import com.xworkz.project2.dto.RegisterDto;

@Component
public class ResetPasswordServiceImpl implements ResetPasswordService {

	
	
	private static final Logger logger = Logger.getLogger(ResetPasswordServiceImpl.class);
	private static final int lengthOfPassword=8;
	@Autowired
	ResetPasswordDaoImpl dao;

	public ResetPasswordServiceImpl() {
		super();
		logger.info("Objcet created \t" + this.getClass().getSimpleName());
	}

	@Override
	public Map<String, String> validateAndReset(RegisterDto dto) {
		Map<String, String> map = new HashMap<String, String>();
		String password=null;
		boolean status = false;
		if (dto.getEmail().length() > 4 && dto.getEmail().endsWith(".com")) {
			status = true;
		}
		if (status) {
			try {
				boolean userExist = dao.checkUserExist(dto.getEmail());
				if (userExist) {
					password=ResetPasswordServiceImpl.generateRandomPassword(lengthOfPassword);
				    this.dao.updatePassword(password, dto.getEmail());
				    this.dao.updateLoginCount(dto.getEmail(), 0);
					map.put("reset","Password reset Successfully!!!!!!!!!!");
				}
				
				else {	
             map.put("reset"," ");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return map;
	}

	public static String generateRandomPassword(int len)
	{
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
