package com.fengmiwang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fengmiwang.dao.AdminDao;
import com.fengmiwang.dao.BaseDao;
import com.fengmiwang.entity.Admin;
import com.fengmiwang.util.Utils;

public class AdminDaoImpl extends BaseDao implements AdminDao{

	@Override
	public int loginQuery(Admin admin) {
		int result = -1;
		String sql = "select count(1) from admin where username=? and password=?";
		Object[] obj = new Object[] {admin.getUsername(), admin.getPassword()};
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
