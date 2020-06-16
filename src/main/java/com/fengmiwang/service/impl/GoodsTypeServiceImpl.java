package com.fengmiwang.service.impl;

import java.util.List;

import com.fengmiwang.dao.GoodsTypeDao;
import com.fengmiwang.dao.impl.GoodsTypeDaoImpl;
import com.fengmiwang.entity.GoodsType;
import com.fengmiwang.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService{
	@Override
	public List<GoodsType> getAllGoodsType() {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.getAllGoodsType();
	}

	@Override
	public int addGoodsTypeByGoodsTypeName(String typename) {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.addGoodsTypeByGoodsTypeName(typename);
	}

	@Override
	public boolean isGoodsTypeExist(String typename) {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.isGoodsTypeExist(typename);
	}

}
