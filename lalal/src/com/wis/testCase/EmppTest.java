package com.wis.testCase;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wis.DAO.EmppDAO;
import com.wis.entity.Empp;
import com.wis.result.EmppResult;

public class EmppTest {
	@Test    //测试查询所有的 emp 信息
	public void test1() throws SQLException {        
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmppDAO emp = ac.getBean("emppDAO", EmppDAO.class);
		// List<Empp> list = new ArrayList<Empp>();
		// String str = emp.getClass().getName().toLowerCase();
		// System.out.println(str);
		List<Empp> e = emp.findAll();
		for (Empp em : e) {
			System.out.println(em.getEmpno() + " " + em.getEname() + " "
					+ em.getDeptno() + " " + em.getAge() + " "
					+ em.getHiredate() + " " + em.getSalary());

		}
	}

	@Test          //测试增加
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmppDAO dao = ac.getBean("emppDAO", EmppDAO.class);
		Empp emp = new Empp();
		emp.setEmpno(106);
		emp.setEname("yang");
		emp.setAge(32);
		emp.setDeptno(106);
		// emp.setHiredate("2012-03-01");
		emp.setSalary(2000.00);
		dao.add(emp);

	}

	@Test      //测试删除
	public void test3() {    
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmppDAO dao = ac.getBean("emppDAO", EmppDAO.class);
		dao.delete(123);
	}

	@Test        //测试按empno查找
	public void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmppDAO dao = ac.getBean("emppDAO", EmppDAO.class);
		List<Empp> list = dao.findEmp(10);
		for (Empp em : list) {
			System.out.println(em.getEmpno() + " " + em.getEname() + " "
					+ em.getDeptno() + " " + em.getAge() + " "
					+ em.getHiredate() + " " + em.getSalary());
		}

	}

	@Test        //测试按name查找
	public void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmppDAO dao = ac.getBean("emppDAO", EmppDAO.class);
		List<Empp> list = dao.findEmpByName("关");
		for (Empp em : list) {
			System.out.println(em.getEmpno() + " " + em.getEname() + " "
					+ em.getDeptno() + " " + em.getAge() + " "
					+ em.getHiredate() + " " + em.getSalary());
		}

	}
	
	
	@Test          //测试更新数据
	public void test6() throws ParseException {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmppDAO dao = ac.getBean("emppDAO", EmppDAO.class);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
		Date hiredate =  formatter.parse("2012-12-12");
		
		Empp emp = new Empp();
		emp.setEmpno(102);
		emp.setEname("可as23213");
		emp.setAge(22);
		emp.setDeptno(106);
		emp.setHiredate(hiredate);
		emp.setSalary(2000.00);
		
		dao.update(emp);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
