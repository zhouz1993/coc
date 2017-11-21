package com.coc.dao;

import java.sql.SQLException;

import com.coc.domain.User;

public interface UserDao {

	void regist(User user) throws SQLException;
	User findUserByCode(String code) throws SQLException;
	void updateUser(User user) throws SQLException;
}
