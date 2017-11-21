package com.coc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.coc.dao.UserDao;
import com.coc.domain.User;
import com.coc.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	//dao中保存数据方法
	public void regist(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),
				user.getNikename(),user.getEmail(),user.getState(),user.getCode()};
		
		queryRunner.update(sql, params);
		
	}
	
	@Override
	public User findUserByCode(String code) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code=?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);//.query(sql, ,code);
		return user;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update user set username=?,password=?,nikename=?,email=?,state=?,code=? where uid=?";
		Object[] params = {user.getUsername(),user.getPassword(),
				user.getNikename(),user.getEmail(),user.getState(),user.getCode(),user.getUid()};
		queryRunner.update(sql, params);
		
	}

}
