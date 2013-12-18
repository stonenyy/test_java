package net.ttny.web.java.test;

import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.opensymphony.xwork2.ActionContext;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	public boolean login(String userName, String passWord) {
		String sql = "select * from demo.ny where username=?";
		try {
			Map<String, Object> map = this.getJdbcTemplate().queryForMap(sql, new Object[] {userName});

			String pass = (String)map.get("password");
			if(passWord.equals(pass)) {
			
				UserInfo userinfo = new UserInfo();
				userinfo.setUserId((int)map.get("idny"));
				
				ActionContext actionContext = ActionContext.getContext();
				Map<String, Object> session = actionContext.getSession();
				session.put("USER_INFO",userinfo.getUserId());
				
				return true;
			} else {
				return false;
			}
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public int userinfo(int userId) {
		String sql = "select * from demo.ny where idny=?";
		try {
			Map<String, Object> map = this.getJdbcTemplate().queryForMap(sql, userId);
			
			UserInfo userinfo1 = new UserInfo();
			userinfo1.setUserId((int)map.get("idny"));
			userinfo1.setUsername((String)map.get("username"));
			userinfo1.setPassword((String)map.get("password"));
			
			return 0;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return 1;
		}
	}

}
