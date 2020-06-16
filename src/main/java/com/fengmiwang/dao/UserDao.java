package com.fengmiwang.dao;

import com.fengmiwang.entity.User;

public interface UserDao {
	//登录查询
	public int loginQuery(User user);
}
