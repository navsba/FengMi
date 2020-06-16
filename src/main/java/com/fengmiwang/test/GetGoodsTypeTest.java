package com.fengmiwang.test;

import java.util.List;

import com.fengmiwang.dao.GoodsTypeDao;
import com.fengmiwang.dao.impl.GoodsTypeDaoImpl;

public class GetGoodsTypeTest {
	public static void main(String[] args) {
		GoodsTypeDao gtd = new GoodsTypeDaoImpl();
		List list = gtd.getAllGoodsType();
		System.out.println(list);
	}
}
