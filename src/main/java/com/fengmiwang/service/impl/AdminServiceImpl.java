package com.fengmiwang.service.impl;

import com.fengmiwang.dao.AdminDao;
import com.fengmiwang.dao.impl.AdminDaoImpl;
import com.fengmiwang.entity.Admin;
import com.fengmiwang.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDao adminDao = new AdminDaoImpl();
	@Override
	public int loginQuery(Admin admin) {
		return adminDao.loginQuery(admin);
	}

}
