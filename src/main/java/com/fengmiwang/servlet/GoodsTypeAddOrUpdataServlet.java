package com.fengmiwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengmiwang.service.GoodsTypeService;
import com.fengmiwang.service.impl.GoodsTypeServiceImpl;

@WebServlet("/goodstype/addOrUpdate")
public class GoodsTypeAddOrUpdataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isAdd = (boolean)req.getSession().getAttribute("isAddGoodsType");
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		String typename = req.getParameter("typename");
		int result = -1;
		if(isAdd) {
			//添加商品类型
			if(!"".equals(typename) && null != typename) {
				result = goodsTypeService.addGoodsTypeByGoodsTypeName(typename);
				resp.sendRedirect("/FengMi/after/goods_type_list.jsp");
			} else {
				//系统错误跳转回登录
				resp.sendRedirect("/FengMi/after/login.jsp");
			}
		} else {
			//修改商品类型
			System.out.println(isAdd);
			System.out.println("来这就错了");
		}
	}
}
