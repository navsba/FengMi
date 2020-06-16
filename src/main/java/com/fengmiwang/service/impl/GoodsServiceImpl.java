package com.fengmiwang.service.impl;

import com.fengmiwang.dao.GoodsDao;
import com.fengmiwang.dao.GoodsTypeDao;
import com.fengmiwang.dao.impl.GoodsDaoImpl;
import com.fengmiwang.dao.impl.GoodsTypeDaoImpl;
import com.fengmiwang.entity.Goods;
import com.fengmiwang.entity.GoodsType;
import com.fengmiwang.service.GoodsService;
import com.fengmiwang.util.PageAssistant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService{

    @Override
    public List<Goods> getAllGoodsAndFuzzyQuery(PageAssistant pa, String condition) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        List<Goods> list = goodsDao.getAllGoodsByFuzzyQueryAndPaging(pa, condition);
        return  list;
    }

}
