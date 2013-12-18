package net.ttny.web.java.test;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

	private static final long serialVersionUID = 1L;

   private String userName;
   private String passWord;
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
    
   public UserDao getUserDao() {
	   return userDao;
    }
    
   public void setUserDao(UserDao userDao) {
	   this.userDao = userDao;
    }
    
   public String execute() throws Exception {
	   	
	   if (userDao.login(userName, passWord)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
    }
}