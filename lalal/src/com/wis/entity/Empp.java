package com.wis.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Empp implements Serializable{
	
	private Integer empno;
	private String ename;
	private Integer age;
	private Integer deptno;
	private Date hiredate;
	private Double salary;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+0800")
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {		
		this.hiredate = hiredate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
