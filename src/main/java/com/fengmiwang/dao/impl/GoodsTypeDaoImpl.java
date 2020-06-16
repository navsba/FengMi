package com.fengmiwang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fengmiwang.dao.BaseDao;
import com.fengmiwang.dao.GoodsTypeDao;
import com.fengmiwang.entity.GoodsType;
import com.fengmiwang.util.Utils;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {

	@Override
	public List<GoodsType> getAllGoodsType() {
		String sql = "select * from t_goodstype";
		ResultSet rs = this.query(sql, null);
		List<GoodsType> list = new ArrayList<GoodsType>();
		try {
			while(rs.next()) {
				GoodsType goodsType = new GoodsType();
				goodsType.setId(rs.getInt("id"));
				goodsType.setTypename(rs.getString("typename"));
				list.add(goodsType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(null, null, rs);
		}
		return list;
	}

	@Override
	public int addGoodsTypeByGoodsTypeName(String typename) {
		String sql = "insert into t_goodstype(typename) values(?)";
		Object[] obj = new Object[] {typename};
		return this.modify(sql, obj);
	}

	@Override
	public boolean isGoodsTypeExist(String typename) {
		String sql = "select 1 from t_goodstype where typename=?";
		Object[] obj = new Object[] {typename};
		boolean result = false;
		ResultSet rs = this.query(sql, obj);
		try {
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(null, null, rs);
		}
		return result;
	}

	@Override
	public String getGoodsTypeNameByTypeId(int typeId) {
		String sql = "select typename from t_goodstype where typeid = ?";
		Object[] obj = new Object[] {typeId};
		ResultSet rs = this.query(sql, obj);
		String typeName = null;
		try {
			while (rs.next()) {
				typeName = rs.getString("typename");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utils.close(null, null, rs);
		}
		return typeName;
	}

}
