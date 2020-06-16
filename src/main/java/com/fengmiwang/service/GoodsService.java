package com.fengmiwang.service;

import com.fengmiwang.entity.Goods;
import com.fengmiwang.util.PageAssistant;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    public List<Goods> getAllGoodsAndFuzzyQuery(PageAssistant pa, String condition);
}
