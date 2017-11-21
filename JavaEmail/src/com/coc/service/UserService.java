package com.coc.service;

import java.sql.SQLException;

import com.coc.domain.User;

public interface UserService {

	void regist(User user) throws Exception;
	
	User findUserByCode(String code) throws SQLException;

	void updateUser(User user) throws SQLException;
	
}
