package com.wis.service;

import java.sql.SQLException;

import com.wis.entity.User;
import com.wis.result.UserResult;
/*
 * 业务成接口
 */
public interface LoginService {
	public UserResult checkLogin(String name,String password) throws SQLException, Exception;
	public UserResult registerUser(String name,String password);
}
