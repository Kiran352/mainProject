package com.xworkz.project2.dao;

import com.xworkz.project2.entity.RegisterEntity;

public interface LoginDao {
	
	public int countOnEmail(String email);
	public RegisterEntity readPasswordByEmail(String email);
    public void updatePasswordCount(int count,String email);
}
