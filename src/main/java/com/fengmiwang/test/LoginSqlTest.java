package com.fengmiwang.test;

import com.fengmiwang.dao.AdminDao;
import com.fengmiwang.dao.impl.AdminDaoImpl;
import com.fengmiwang.entity.Admin;

public class LoginSqlTest {
	public static void main(String[] args) {
		AdminDao ad = new AdminDaoImpl();
		Admin admin = new Admin("admin", "123");
		
		System.out.println(ad.loginQuery(admin));
	}
}
