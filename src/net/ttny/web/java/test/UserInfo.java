package net.ttny.web.java.test;

import com.opensymphony.xwork2.ActionSupport;

public class UserInfo extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String userName;
   private String passWord;
   private int userId;
   private UserDao userDao;

   public String getUsername() {
      return userName;
    }

   public void setUsername(String userName) {
      this.userName = userName;
    }

   public String getPassword() {
      return passWord;
    }

   public void setPassword(String passWord) {
      this.passWord = passWord;
    }
    
   public int getUserId() {
      return userId;
    }
    
   public void setUserId(int userId) {
      this.userId = userId;
    }
   
   public UserDao getUserDao() {
	   return userDao;
    }
    
   public void setUserDao(UserDao userDao) {
	   this.userDao = userDao;
    }

	public String execute(Object session) throws Exception {
		if (userDao.userinfo((int)session)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
    }
}
