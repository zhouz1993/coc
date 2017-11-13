package com.wis.service.implement;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wis.DAO.UserDAO;
import com.wis.entity.User;
import com.wis.result.UserResult;
import com.wis.service.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	private static final Logger  LOG = LoggerFactory.getLogger(LoginServiceImpl.class); 
	@Resource(name = "userDAO")
	private UserDAO dao;
	/**
	 * 检查用户名和密码是否正确
	 */
	public UserResult checkLogin(String username, String password) {
		UserResult result = new UserResult();
		User user;
		try {
			user = dao.findByUser(username);
			LOG.info("user:"+user);
			if (user == null) {
				LOG.warn("用户不存在！");
				result.setStatus(1);
			//	result.setData(null);
				return result;
			}
			if (!user.getPassword().equals(password)) {
				LOG.warn("密码错误！");
				result.setStatus(2);
			//	result.setData(null);
				return result;
			} else {
				LOG.info("登陆成功");
				result.setStatus(0);
				result.setData(user);
				return result;
			}
		} catch (SQLException e) {
			// System.out.println("数据库中不存在，空指针异常！！");
			e.printStackTrace();
			LOG.error("出现错误！"+e.getMessage());
		}
		return result;

	}

	@Override
	public UserResult registerUser(String name, String password) {
		UserResult result = new UserResult();
		User user = new User();
		User us;
		try {
			us = dao.findByUser(name);
			if (us == null) {
				user.setName(name);
				user.setPassword(password);
				dao.register(user);
				result.setStatus(0);
				return result;
			}else{
				result.setStatus(1);
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
