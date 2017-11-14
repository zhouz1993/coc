package com.wis.DAO;

import java.sql.SQLException;

import com.wis.entity.User;

//数据访问层接口  
public interface UserDAO {
	public User findByUser(String name) throws SQLException;
	public void register(User user);
}
