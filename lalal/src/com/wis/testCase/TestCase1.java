package com.wis.testCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wis.DAO.EmppDAO;
import com.wis.DAO.UserDAO;
import com.wis.entity.Empp;
import com.wis.entity.User;
import com.wis.result.UserResult;
import com.wis.service.LoginService;
import com.wis.util.OutputExcel;

public class TestCase1 {

	// 测试数据库连接
	@Test
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		System.out.println(ac.getBean("jdbc"));
		DataSource ds;//= ac.getBean("ds", DataSource.class);
		
	//	System.out.println(ds.getClass());
		Connection conn;
		try {
			ds = ac.getBean("dataSource", DataSource.class);
			conn = ds.getConnection();
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery("select * from user_emp");
			while (rt.next()) {
				String test2 = rt.getString(2);
				System.out.println(test2);
			}
			rt.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	public void test2() {
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");
			System.out.println("aaaa");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"123456");
		
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery("select * from emp");
			while (rt.next()) {
				String test2 = rt.getString(2);
				System.out.println(test2);
			}
			rt.close();
			st.close();
			conn.close();
			

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		System.out.println("You made it, take control your database now!");
	}
	
	@Test            //测试UserDAO
	public void test3() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO dao = ac.getBean("userDAO",UserDAO.class);
		User user = dao.findByUser("kangkang");
		System.out.println(user.getName().toString());
		System.out.println(user.getPassword());
	}
	
	@Test      
	public void test4() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService service = ac.getBean("loginService",LoginService.class);
		UserResult result = service.checkLogin("kangkang", "123");
		System.out.println(result.getData().toString());
	}
	
	
	@Test
	public void test5() throws FileNotFoundException, IOException{
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		OutputExcel dao = ac.getBean("outputExcel", OutputExcel.class);
		dao.outpExcel();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
