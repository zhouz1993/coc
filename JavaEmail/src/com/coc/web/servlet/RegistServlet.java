package com.coc.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coc.domain.User;
import com.coc.service.UserService;
import com.coc.service.impl.UserServiceImpl;
import com.coc.utils.UUIDUtils;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//接受数据
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nikename = request.getParameter("nickname");
			String email = request.getParameter("email");
			
			//封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNikename(nikename);
			user.setEmail(email);
			user.setState(0); //0未激活 1 激活
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
			user.setCode(code);
			
			//调用业务层处理
			UserService userService =  new UserServiceImpl();
		
			userService.regist(user);
			//页面跳转
			request.setAttribute("msg", "你已经注册成功！请去邮箱激活！！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
