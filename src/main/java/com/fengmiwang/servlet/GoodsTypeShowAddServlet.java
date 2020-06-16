package com.fengmiwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goodstype/showadd")
public class GoodsTypeShowAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//这是干啥来着的？为啥要这样？
		//到添加商品类型的页面，应该是要带东西的，但是我没有带
		req.getRequestDispatcher("/after/add_goods_type.jsp").forward(req, resp);
	}
}
