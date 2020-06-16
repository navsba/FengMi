package com.fengmiwang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fengmiwang.dao.BaseDao;
import com.fengmiwang.dao.UserDao;
import com.fengmiwang.entity.User;
import com.fengmiwang.util.Utils;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public int loginQuery(User user) {
		int result = -1;
		String sql = "select count(1) from t_user where username=? and password=?";
		Object[] obj = new Object[] {user.getUsername(), user.getPassword()};
		ResultSet rs = this.query(sql, obj);
		try {
			if(rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(null, null, rs);
		}
		return result;
	}

}
