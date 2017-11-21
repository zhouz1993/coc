package com.coc.domain;
/**
 * 实体类
 * @author Administrator
 
 uid      | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(20) | YES  |     | NULL    |                |
| password | varchar(20) | YES  |     | NULL    |                |
| nikename | varchar(20) | YES  |     | NULL    |                |
| email    | varchar(30) | YES  |     | NULL    |                |
| state    | int(11)     | YES  |     | NULL    |                |
| code  
 */
public class User {
	private Integer uid;
	private String username;
	private String password;
	private String nikename;
	private String email;
	private Integer state;
	private String code;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", nikename=" + nikename
				+ ", email=" + email + ", state=" + state + ", code=" + code + "]";
	}
	
	
}
