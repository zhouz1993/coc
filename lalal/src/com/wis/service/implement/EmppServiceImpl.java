package com.wis.service.implement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.wis.DAO.EmppDAO;
import com.wis.entity.Empp;
import com.wis.result.EmppResult;
import com.wis.service.EmppService;

/**
 * 
 * @author WH1607050
 * @Componnent 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
 */

@Service("emppService")
@Transactional
public class EmppServiceImpl implements EmppService {
	private static final Logger LOG = LoggerFactory.getLogger(EmppServiceImpl.class);
		
	@Resource
	public EmppDAO emppDAO;

	@Override
	/**
	 *  查询出所有表中的额数据，封装在result中
	 */
	@Transactional(readOnly = true)
	public EmppResult findAllEmpp() {
		List<Empp> emp;
		EmppResult result = null;
		try {
			emp = emppDAO.findAll();
			LOG.info(emp.toString());
			result = new EmppResult();
			result.setStatus(0);
			result.setMessage("findAllEmpp Success!!");
			result.setData(emp);
		} catch (SQLException e) {
			LOG.error("查询错误："+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	/**
	 *  插入数据
	 */
	public EmppResult addEmpp(Integer empno, String ename, Integer age,
			Integer deptno, String date, Double salary) throws ParseException {
		// System.out.println("addEmpp：：" + empno + " " + ename + " " + age +
		// " "
		// + deptno + " " + date + " " + salary);
		SimpleDateFormat formatter;
		Date hiredate;
		if (date != "") {
			formatter = new SimpleDateFormat("yyyy-MM-dd"); // 将页面接收的字符串转换为时间类型
			hiredate = formatter.parse(date);
		} else {
			hiredate = new Date();
		}
		EmppResult result = new EmppResult();
		Empp emp = setEmp(empno, ename, age, deptno, salary, hiredate);
		emppDAO.add(emp);
		result.setStatus(0);
		result.setMessage("add success");
		return result;
	}

	@Override
	/**
	 *  删除数据
	 */
	public EmppResult delete(int[] arr) {
		EmppResult result = new EmppResult();
		int[] ar = arr;
		int id;
		// 选择多行 将其循环删除 首先判断arr中的数据是否只有一个
		for (int i = 0; i < ar.length; i++) {
			id = ar[i];
			emppDAO.delete(id);
		}
		result.setStatus(0);
		result.setMessage("success");
		return result;
	}

	@Override
	/**
	 *  按員工編號查找
	 */
	public EmppResult findEmpp(Integer empno) {
		EmppResult result = new EmppResult();
		List<Empp> emp = emppDAO.findEmp(empno);
		if (!emp.isEmpty()) {
			result.setStatus(0);
			result.setMessage("查询成功！！！");
			result.setData(emp);
		} else {
			result.setStatus(1);
			result.setMessage("所查数据不存在！！");
		}
		return result;
	}

	@Override
	/**
	 按名字查找
	 * 
	 */
	public EmppResult findEmppByName(String name) {
		EmppResult result = new EmppResult();
		String name1;
		if(name.indexOf("%")!=-1||name.indexOf("_")!=-1){
			name1 = name.replace("%", "\\%");
			name1 = name1.replace("_", "\\_");
		}else{
			name1=name;
		}
		List<Empp> emp = emppDAO.findEmpByName(name1);
		if (!emp.isEmpty()) {
			result.setStatus(0);
			result.setMessage("查询成功！！！");
			result.setData(emp);
		} else {
			result.setStatus(1);
			result.setMessage("所查数据不存在！！！");
		}	
		return result;
	}

	@Override
	/**
	 * 修改
	 */
	public EmppResult updateEmp(Integer empno, String ename, Integer age,
			Integer deptno, String date, Double salary) throws ParseException {
		// System.out.println("又到updateEmp  "+empno+" "+ename+" "+age+" "+deptno+" "+date+" "+
		// salary);
		EmppResult result = new EmppResult();
		SimpleDateFormat formatter;
		Date hiredate;
		if (date != "") {
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			hiredate = formatter.parse(date);
		} else {
			hiredate = new Date();
		}
		// System.out.println("lakladkl"+hiredate.toString());
		Empp emp = setEmp(empno, ename, age, deptno, salary, hiredate);
		emppDAO.update(emp);
		result.setStatus(0);
		return result;
	}

	/**
	 * ctrl+shift+M
	 * 
	 * @param empno
	 * @param ename
	 * @param age
	 * @param deptno
	 * @param salary
	 * @param hiredate
	 * @return
	 */
	private Empp setEmp(Integer empno, String ename, Integer age,
			Integer deptno, Double salary, Date hiredate) {
		Empp emp = new Empp();
		emp.setEmpno(empno);
		emp.setEname(ename);
		emp.setAge(age);
		emp.setDeptno(deptno);
		emp.setHiredate(hiredate);
		emp.setSalary(salary);
		return emp;
	}

}
