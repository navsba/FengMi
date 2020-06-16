package com.fengmiwang.dao.impl;

import com.fengmiwang.dao.BaseDao;
import com.fengmiwang.dao.GoodsDao;
import com.fengmiwang.entity.Goods;
import com.fengmiwang.util.PageAssistant;
import com.fengmiwang.util.Utils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {

    @Override
    public List<Goods> getAllGoodsByFuzzyQueryAndPaging(PageAssistant pa, String condition) {
        if(null != condition && !"".equals(condition))
            condition = " where goodsName like '%" + condition + "%'";
        String sql = "select * from t_goods " + condition + " limit ?, ?";
        Object[] obj = new Object[] {(pa.getCurrentPageNo()-1)*pa.getPageSize(), pa.getPageSize()};
        ResultSet rs = this.query(sql, obj);
        List<Goods> list = new ArrayList<Goods>();
        try {
            while(rs.next()) {
                Goods tempGood = new Goods();
                tempGood.setId(rs.getInt("id"));
                tempGood.setDeployDate(rs.getDate("deployDate"));
                tempGood.setDescription(rs.getString("description"));
                tempGood.setGoodsName(rs.getString("goodsName"));
                tempGood.setImgPath(rs.getString("imgPath"));
                tempGood.setTypeId(rs.getInt("typeid"));
                tempGood.setPrice(rs.getDouble("price"));
                list.add(tempGood);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.close(null, null, rs);
        }
        return list;
    }
}
