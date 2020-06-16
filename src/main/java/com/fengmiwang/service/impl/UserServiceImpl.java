package com.fengmiwang.service.impl;

import com.fengmiwang.dao.UserDao;
import com.fengmiwang.dao.impl.UserDaoImpl;
import com.fengmiwang.entity.User;
import com.fengmiwang.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public int loginQuery(User user) {
		return userDao.loginQuery(user);
	}

}
