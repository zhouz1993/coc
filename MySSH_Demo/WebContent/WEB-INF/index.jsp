<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
   <title>用户登录界面</title>
     <style type="text/css">
     	.login{
     		font-family: Arial;
     		font-size: 14px;
     	}
     </style>
     <link rel="stylesheet" href="CSS/css3.css" style="text/css">
  </head>
  <body topmargin="150px">
  <center>
        <p></p>
    	<form action="person_login" method="post">
    	   <fieldset id="inputs" style="width: 400; height: 150" class="newStyle"><br>
    	      <legend>用户登录</legend>
      用户：<input type="text" class="login" name="user.username" placeholder="请输入用户名" autofocus required><br><br>
      密码：<input type="password" class="login" name="user.password" placeholder="请输入密码" required><br><br>
      角色：<input type="text"  class="login"  name="user.role" placeholder="请选择角色" list="searchlist" required/><br/><br>
		   	   <datalist id="searchlist">
					<option value="学生" label="学生"/> 
					<option value="教师" label="教师"/> 
					<option value="访客" label="访客"/> 
		    	   </datalist>
    	   </fieldset>
              <input type="submit" value="登录">
              <input type="reset" value="重置">
    	</form>
   </center>
  </body>
</html>