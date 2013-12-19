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
				
				ActionContext actionContext = ActionContext.getContext();
				Map<String, Object> session = actionContext.getSession();
				session.put("USER_ID",(int)map.get("idny"));
				
				return true;
			} else {
				return false;
			}
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return false;
		}
    }
	
	@SuppressWarnings("unchecked")
	public boolean userinfo(int userId) {
		String sql = "select * from demo.ny where idny=?";
		try {
			Map<String, Object> map = this.getJdbcTemplate().queryForMap(sql, userId);
			
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			session.put("USER_ID",(int)map.get("idny"));
			session.putAll((Map<? extends String, ? extends Object>) map.put("USER_NAME", (String)map.get("username")));
			
			return true;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

}
