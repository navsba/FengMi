package com.fengmiwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fengmiwang.util.Utils;

public class BaseDao {
	ResultSet rs = null;
	Connection conn = null;
	
	public int modify(String sql, Object[] obj) {
		int result = -1;
		PreparedStatement ps = null;
		Connection connection = Utils.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for(int i = 0; i < obj.length; i++)
				ps.setObject(i+1, obj[i]);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(conn, ps,null);
		}
		return result;
	}
	
	public ResultSet query(String sql, Object[] obj) {
		PreparedStatement ps = null;
		conn = Utils.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if(obj != null)
				for(int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(conn, ps, null);
		}
		return rs;
	}
}
