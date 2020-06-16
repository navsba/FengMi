package com.fengmiwang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengmiwang.entity.Admin;
import com.fengmiwang.service.AdminService;
import com.fengmiwang.service.impl.AdminServiceImpl;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin admin = new Admin();
		String username = req.getParameter("username");
		admin.setUsername(username);
		admin.setPassword(req.getParameter("password"));
		AdminService adminService = new AdminServiceImpl();
		int result = adminService.loginQuery(admin);
		if(result == 1) {
			req.getSession().setAttribute("adminUserName", username);
			req.getRequestDispatcher("/after/goods_list.jsp").forward(req, resp);
		}
	}
}
