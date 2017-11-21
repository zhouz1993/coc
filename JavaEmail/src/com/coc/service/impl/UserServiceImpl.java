package com.coc.service.impl;

import java.sql.SQLException;

import com.coc.dao.UserDao;
import com.coc.dao.impl.UserDaoImpl;
import com.coc.domain.User;
import com.coc.service.UserService;
import com.coc.utils.JDBCUtils;
import com.coc.utils.MailUtils;

public class UserServiceImpl implements UserService {

	// 注册实现
	public void regist(User user) throws Exception {
		//存入数据
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		
		//发送一封邮件
		MailUtils.sendMail(user.getEmail(),user.getCode());
		
	}

	@Override
	public User findUserByCode(String code) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		return userDao.findUserByCode(code);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		
	}
	
	

}
