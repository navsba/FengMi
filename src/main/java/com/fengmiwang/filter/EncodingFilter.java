package com.fengmiwang.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");//解决post请求乱码
		response.setCharacterEncoding("utf-8");//响应的乱码
		response.setContentType("text/html;charset=utf-8");//浏览器解析的乱码
		//解决get请求乱码  在tomcat  conf文件夹下 server.xml文件 
		//修改端口为 8080 添加 URIEncoding="utf-8"
		//jdbc传递数据乱码   
		//在连接数据库的 url后加上 ?characterEncoding = utf8
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
