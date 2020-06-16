package com.fengmiwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengmiwang.service.GoodsTypeService;
import com.fengmiwang.service.impl.GoodsTypeServiceImpl;

@WebServlet("/addGoodsTypeInspect")
public class AddGoodsTypeAJAXServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeName = req.getParameter("typeNameInspect");
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		
		System.out.println(typeName);
		System.out.println(goodsTypeService.isGoodsTypeExist(typeName));
		
		if(null != typeName && !"".equals(typeName)) {
			if(goodsTypeService.isGoodsTypeExist(typeName)) {
				resp.getWriter().print("false");
			} else {
				resp.getWriter().print("true");
			}
		} else {
			resp.getWriter().print("dataCannotReceive");
		}
		
	}
}
