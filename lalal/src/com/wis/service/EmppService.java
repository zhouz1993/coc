package com.wis.service;

import java.sql.SQLException;
import java.text.ParseException;

import com.wis.result.EmppResult;

public interface EmppService {
	public  EmppResult findAllEmpp() throws SQLException;
	public  EmppResult addEmpp(Integer empno,String ename,Integer age,Integer deptno,String date,Double salary) throws ParseException;
	public EmppResult delete(int[] arr);
	public EmppResult findEmpp(Integer empno);
	public EmppResult findEmppByName(String name);
	public EmppResult updateEmp(Integer empno,String ename,Integer age,Integer deptno,String date,Double salary) throws Exception;
	//public void MyTask();
}
