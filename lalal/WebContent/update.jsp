<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改员工</title>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/update.js"></script>
<link rel="stylesheet" href="css/background.css" />
<style type="text/css">
</style>
<script>

</script>
</head>
<body>
	<div align="center">
		<h1>更新员工列表</h1>
		<table>
			<tr>
				<td>员工编号:<input type="text" id="emp_id"/></td>
			</tr>
			<tr>
				<td>姓&nbsp;&nbsp;名:<input type="text" id="emp_name" value=""/></td>
			</tr>
			<tr>
				<td>年&nbsp;&nbsp;龄:<input type="text" id="emp_age" /></td>
			</tr>
			<tr>
				<td>部门编号: <select id="deptno" style="width: 150px">
						<option value="1101">1101</option>
						<option value="1202">1202</option>
						<option value="1303">1303</option>
						<option value="1404">1404</option>
				</select>

				</td>
			</tr>
			<tr>
				<td>入职时间:<input type="text" id="hirdate" /></td>
			</tr>
			<tr>
				<td>工&nbsp;&nbsp;资:<input type="text" id="emp_sal" /></td>
			</tr>
			<tr align="center">
				<td><input type="button" id="update_save" value="保存" onclick="update()"/>
				<input type="button" value="取消" onclick="location.href='index.jsp'"/>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>