package net.ttny.web.java.test;

public interface UserDao {
	public boolean login(String userName,String passWord);
	
	public int userinfo(int userId);
}