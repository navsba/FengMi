package com.fengmiwang.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.fengmiwang.entity.GoodsType;
import com.fengmiwang.service.GoodsTypeService;
import com.fengmiwang.service.impl.GoodsTypeServiceImpl;

@WebFilter("/after/goods_type_list.jsp")
public class ShowGoodsTypeListFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		List<GoodsType> list = new ArrayList<GoodsType>();
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		list = goodsTypeService.getAllGoodsType();
		request.getSession().setAttribute("goodsTypelist", list);
//		System.out.println(list);
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {

	}

}
