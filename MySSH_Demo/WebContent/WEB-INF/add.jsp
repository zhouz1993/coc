<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  <title>添加个人信息</title>
  <link rel="stylesheet" href="css3.css" style="text/css"> 
  </head>
  <body topmargin="200px">
  <center>
     <fieldset style="width: 400; height: 50" class="newStyle" >
     	<legend>添加个人信息</legend>
     	<form action="person_add" method="post">
     		<input type="text" name="name" placeholder="请输入姓名" autofocus required >
     	    <input type="submit" value="添加">
     	    <input type="submit" value="返回" onclick="history.back()">
     	</form>
     </fieldset>
   </center>
  </body>
</html>