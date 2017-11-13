package com.wis.controller.empp;

import java.sql.SQLException;
import java.text.ParseException;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wis.result.EmppResult;
import com.wis.service.EmppService;

/**
 * 控制层：实现对页面的请求处理及转发
 * @author WH1607050
 *
 */
@Controller
public class EmppController {
	@Resource(name = "emppService")
	public EmppService service;

	
	/**
	 *  页面请求 查询数据 返回封装数据结果
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/empp.do")
	@ResponseBody
	public EmppResult displayAll() throws SQLException {
		EmppResult result = service.findAllEmpp();
		return result;
	}

	
	/**
	 * 增加
	 * @param empno
	 * @param ename
	 * @param age
	 * @param deptno
	 * @param hiredate
	 * @param salary
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public EmppResult addEmpp(Integer empno, String ename, Integer age,
			Integer deptno, String hiredate, Double salary)
			throws ParseException {
		// System.out.println("获取页面的值："+empno+" "+ename+" "+age+" "+deptno+" "+hiredate+" "+
		// salary);
		String hiredate1 = hiredate.replaceAll("\\.", "-");
		EmppResult result = service.addEmpp(empno, ename, age, deptno,
				hiredate1, salary);
		return result;
	}

	
	/**
	 *  根据选择的员工编号进行删除
	 * @param arr
	 * @return
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public EmppResult delete(int[] arr) {
		// System.out.println(arr[0]+"   "+arr[1]);
		EmppResult result = service.delete(arr);
		
		return result;
	}

	
	/**
	 *  根据员工编号查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/search.do")
	@ResponseBody
	public EmppResult findEmpp(Integer id) {
		EmppResult result = service.findEmpp(id);
		return result;
	}
	
	 
	/**
	 * 根据名字查询
	 * @param name
	 * @return
	 */
	@RequestMapping("/searchBNm.do")
	@ResponseBody
	public EmppResult findByName(String name) {
		EmppResult result = service.findEmppByName(name);
		return result;
	}

	
	/**
	 *  数据更新
	 * @param empno
	 * @param ename
	 * @param age
	 * @param deptno
	 * @param hiredate
	 * @param salary
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public EmppResult updateEmpp(Integer empno, String ename, Integer age,
			Integer deptno, String hiredate, Double salary) throws Exception {
		// System.out.println(hiredate);
		String hiredate1 = hiredate.replaceAll("\\.", "-");
		EmppResult result = service.updateEmp(empno, ename, age, deptno,
				hiredate1, salary);
		return result;
	}

}
