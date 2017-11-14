<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EMP-天霸动霸tua</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/findAll.js"></script>
<script type="text/javascript" src="js/delete.js"></script>
<script type="text/javascript" src="js/modify.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/update.js"></script>
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/downExcel.js"></script>
<link rel="stylesheet" href="css/background.css" />

<script>
//$(function() {
	//findAll();
//});
</script>
<style type="text/css">
</style>

</head>
<body>
	<div align="center" class="d1" id="index1">
		<form action="" method="post">
			<div>
				<input name="add" type="button" value="增加"
					onclick="location.href='add.jsp'" />&nbsp; <input name="delete"
					type="button" value="删除" />&nbsp; <input name="modify"
					type="button" value="修改" onclick="modifyEmp()" />&nbsp;
				<input name="showAll" type="button" value="显示全部" onclick="location.href='index.jsp'"/>&nbsp; <span> <input id="txt" type="text" /> <input
					id="search" type="button" value="查询" onclick="searchEmp()" />
				</span>
				<input name="excel"
					type="button" value="导出EXCEl" />
			</div>
			<table id="tab1" cellpadding="10" border="1">
				<thead>
					<tr>
						<th><input type='checkbox' id='box2' onclick="checkAll(this.checked)"/>全选</th>
						<th>员工编号</th>
						<th>姓名</th>
						<th>年龄</th>
						<th>部门编号</th>
						<th>入职时间</th>
						<th>工资</th>
					</tr>
				</thead>
				<tbody id="tb">
				</tbody>
			</table>
			<!-- page 开始-->
		    <div class="page_nav">	
		    <input type="button" id="btn1" value="首页" >&nbsp;&nbsp;
			<input type="button" id="btn2" value="上一页">&nbsp;&nbsp;
			<input type="text" id="pageNum" style="width:80px"/>&nbsp;<input type="button" id="btn5" value="GO"/>&nbsp;&nbsp;
			<input type="button" id="btn3" value="下一页" >&nbsp;&nbsp;
			<input type="button" id="btn4" value="尾页" >
		  	</div>
		    <!-- page 结束-->
		</form>
	</div>
	
	<!-- 更新员工列表 -->
	<div align="center" id="modify" class="d2" style="visibility:hidden" >
		<h1>更新员工列表</h1>
		<table class="tb11">
			<tr>
				<td>员工编号:<input type="text" id="emp_id" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>姓&nbsp;&nbsp;名:<input type="text" id="emp_name" /></td>
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
				<td>入职时间:<input type="date" id="hirdate" /></td>
			</tr>
			<tr>
				<td>工&nbsp;&nbsp;资:<input type="text" id="emp_sal"/></td>
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