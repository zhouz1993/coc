<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  <title>Login</title>
  <link rel="stylesheet" href="css3.css" style="text/css"> 
  </head>
  <body topmargin="200px">
  <center>
     <fieldset style="width: 400; height: 50" class="newStyle" >
     	<legend>登录</legend>
     	<form action="person_login" method="post">
     		<input type="text" name="user.username" placeholder="请输入姓名" autofocus required >
     		<input type="text" name="user.password" placeholder="请输入密码" autofocus required >
     	    <input type="submit" value="登录">
     	</form>
     </fieldset>
   </center>
  </body>
</html>