package com.fengmiwang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
	private static final String url = "jdbc:mysql://localhost:3306/fengmiwang?"
			+ "useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	private static final String user = "root";
	private static final String pwd = "desire";
//	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String driver = "com.mysql.cj.jdbc.Driver";	

	private static Connection connection = null;

	// 数据库驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库驱动错误");
		}
	}

	// 获取数据库连接
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建数据库连接失败。");
		}
		return connection;
	}
	

	// 释放资源
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}