package com.fengmiwang.dao;

import com.fengmiwang.entity.Goods;
import com.fengmiwang.util.PageAssistant;

import java.util.List;

public interface GoodsDao {
    public List<Goods> getAllGoodsByFuzzyQueryAndPaging(PageAssistant pa, String condition);
}
