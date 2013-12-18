package net.ttny.web.java.test;

import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserinfoDaoImpl extends JdbcDaoSupport implements UserinfoDao {

	public int getinfo(int userId) {
		String sql = "select * from demo.ny where username=?";
		
		try {
			Map<String, Object> map = this.getJdbcTemplate().queryForMap(sql, new Object[] {userId});
			
			UserInfo userinfo = new UserInfo();
			userinfo.setUserId((int)map.get("idny"));
			userinfo.setUsername((String)map.get("username"));
			userinfo.setPassword((String)map.get("password"));
			
			return 0;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return 1;
		}
	}
}
