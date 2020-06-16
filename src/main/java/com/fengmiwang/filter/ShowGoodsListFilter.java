package com.fengmiwang.filter;

import com.fengmiwang.entity.Goods;
import com.fengmiwang.entity.GoodsType;
import com.fengmiwang.service.GoodsService;
import com.fengmiwang.service.impl.GoodsServiceImpl;
import com.fengmiwang.util.PageAssistant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/after/goods_list.jsp")
public class ShowGoodsListFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		GoodsService goodsService = new GoodsServiceImpl();
		PageAssistant pa = new PageAssistant();
		String condition = request.getParameter("");
		List<Goods> list = goodsService.getAllGoodsAndFuzzyQuery(pa,condition);
		String typeName;

		request.getSession().setAttribute("goodsTypelist", list);
//		System.out.println(list);
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {

	}

}
