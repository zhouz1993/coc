<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加员工</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/add_submit.js"></script>
<script type="text/javascript" src="js/findAll.js"></script>
<link rel="stylesheet" href="css/background.css" />
<style type="text/css">
div{
	
}
</style>
<script type="text/javascript">


</script>
</head>
<body>
	<div align="center">
		<h1>添加员工列表</h1>
		
			<table>
				<tr>
					<td>员工编号:<input type="text" id="empno" /></td>
					<td><span id="empMsg"></span></td>
				</tr>
				<tr>
					<td>姓&nbsp;&nbsp;名:<input type="text" id="ename" /></td>
					<td style="width:150px"><span id="nameMsg"></span></td>
				</tr>
				<tr>
					<td>年&nbsp;&nbsp;龄:<input type="text" id="age" /></td>
					<td><span id="ageMsg"></span></td>
				</tr>
				<tr>
					<td>部门编号: <select id="deptno" style="width: 150px">
							<option></option>
							<option value="1101">1101</option>
							<option value="1202">1202</option>
							<option value="1303">1303</option>
							<option value="1404">1404</option>
					</select>

					</td>
				</tr>
				<tr>
					<td>入职时间:<input type="date" id="hiredate"/></td>
				</tr>
				<tr>
					<td>工&nbsp;&nbsp;资:<input type="text" id="salary" /></td>
				</tr>
				<tr align="center">
					<td><input type="button" id="save" value="save" onclick="saveEmp()"/>
					<input type="button" value="cancel" onclick="history.back(-1)"/></td>
				</tr>
			</table>
		
	</div>
</body>
</html>