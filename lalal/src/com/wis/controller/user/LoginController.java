package com.wis.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wis.result.UserResult;
import com.wis.service.LoginService;

/**
 * 登录功能控制类
 * 
 */
@Controller
@RequestMapping
public class LoginController {

	@Resource(name="loginService")
	private LoginService service;

	 @RequestMapping("/toLogin.do")
	 public String toLogin(){
	 return "login";
	 }

	/**
	          将UserResult对象json输出
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/login.do")
	 @ResponseBody  
	public UserResult login(String username, String password) throws Exception {
		UserResult result = service.checkLogin(username, password);
		return result;
	}

	 /**
	  * 注册
	  */
	@RequestMapping("/regist.do")      
	@ResponseBody
	public UserResult regist(String name, String password){
		UserResult result = service.registerUser(name,password);
		return result;
	}
	
	
}
