package com.xworkz.project2.dao;

import com.xworkz.project2.entity.RegisterEntity;

public interface RegisterDao {

	public boolean readUid(String uId);
	public boolean readEmail(String email);
	public boolean saveRegisterDto(RegisterEntity entity);
	
	
	
}
