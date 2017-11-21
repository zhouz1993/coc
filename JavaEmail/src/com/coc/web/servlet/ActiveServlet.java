package com.coc.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coc.domain.User;
import com.coc.service.UserService;
import com.coc.service.impl.UserServiceImpl;


public class ActiveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//激活码
			String code = requset.getParameter("code");
			System.out.println(code);
			//根据激活码查询用户
			UserService userService = new UserServiceImpl();
			User user = userService.findUserByCode(code);
			if(user != null){
				//已查到 修改用户状态
				user.setState(1);
				user.setCode("");
				userService.updateUser(user);
				requset.setAttribute("msg", "您已经激活成功！ 请去登录！！");
			}else{
			//	 没有查到用户
				requset.setAttribute("msg", "你的验证码有误！ 请重新激活！！");
			}
			requset.getRequestDispatcher("/msg.jsp").forward(requset, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	@Override
	public void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		doGet(requset, response);
	}
}
