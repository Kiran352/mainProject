package com.xworkz.project2.dao;


public interface ResetPasswordDao {
	
	public boolean checkUserExist(String email);
	public int updatePassword(String password,String email);
	public int updateLoginCount(String email,int count);

}
