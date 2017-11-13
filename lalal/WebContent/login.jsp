<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<link rel="stylesheet" href="css/login.css" />
<style type="text/css">
/* body {
	background-image: url('image/pic.jpg');
	background-repeat: repeat;
} */
</style>
</head>
<body>
	<p style="width:150px;heigth:150px;" id="p1">
		<img alt="this is picture" src="image/11.jpg" style="width:100%;heigth:100%;">
	</p>
	<h1><a href="error.jsp">hello</a></h1>
	<div id="center">
		<form id="form1">
			<h1 id="hh">用户登录</h1>
			<hr></hr>
			<table>
				<tr>
					<td style="width: 100px;height:40px">用户名：</td>
					<td colspan="2"><input type="text" id="username" size="20" style="height:20px"/></td>
					<td style="width: 200px"><span id="nameMsg"></span></td>

				</tr>
				<tr>
					<td style="height:40px">密&nbsp;码:</td>
					<td colspan="2"><input type="password" id="password" size="20" style="height:20px"></td>
					<td style="width: 200px"><span id="pwdMsg"></span></td>
				</tr>
				<tr >
					<td></td>
					<td colspan="2" style="height:40px" align="center">
					<input id="sub" type="button" value="登录" />&nbsp;&nbsp;
					<input id="zc" type="button" value="注册" onclick="regist()"/></td>
					
				</tr>
			</table>
		</form>
	</div>
	
	
	<div align="center" id="div_zc" style="visibility:hidden" >
	<form id="form2">
			<h1 id="hh">用户注册</h1>
			<hr></hr>
			<table>
				<tr>
					<td style="width: 100px;height:40px">用户名：</td>
					<td colspan="2"><input type="text" id="username1" size="20" style="height:20px" maxlength="18" /></td>
					<td style="width: 200px"><span id="nameMsg1"></span></td>

				</tr>
				<tr>
					<td style="height:40px">密&nbsp;码:</td>
					<td colspan="2"><input type="password" id="password1" size="20" style="height:20px" maxlength="18"></td>
					<td style="width: 200px"><span id="pwdMsg1"></span></td>
				</tr>
				<tr>
					<td style="height:40px">确认密码:</td>
					<td colspan="2"><input type="password" id="password2" size="20" style="height:20px"></td>
					<td style="width: 200px"><span id="pwdMsg2"></span></td>
				</tr>
				<tr >
					<td></td>
					<td colspan="2" style="height:40px" align="center">
					<input id="reset" type="button" value="重置" />&nbsp;&nbsp;
					<input id="ok" type="button" value="提交" /></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>