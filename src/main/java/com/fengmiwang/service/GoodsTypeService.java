package com.fengmiwang.service;

import java.util.List;

import com.fengmiwang.entity.GoodsType;

public interface GoodsTypeService {
	// 查询所有商品类型
	public List<GoodsType> getAllGoodsType();

	// 添加商品类型
	public int addGoodsTypeByGoodsTypeName(String typename);
	
	//查询商品类型是否存在
	public boolean isGoodsTypeExist(String typename);
}
