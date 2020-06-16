package com.fengmiwang.test;

import com.fengmiwang.dao.GoodsTypeDao;
import com.fengmiwang.dao.impl.GoodsTypeDaoImpl;

public class IsGodsTypeExistTest {
    public static void main(String[] args) {
        GoodsTypeDao gtd = new GoodsTypeDaoImpl();
        boolean sj = gtd.isGoodsTypeExist("ss手机");
        System.out.println(sj);
    }
}
