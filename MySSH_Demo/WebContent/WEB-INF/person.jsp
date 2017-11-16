<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>个人信息列表</title>
  	<link rel="stylesheet" href="css3.css" style="text/css"> 
  </head>
  <body topmargin="100px">
  <center>
       <p><p><p>
       <fieldset style="width: 600px; height:200px;" class="newStyle" >
       <legend>Person信息列表</legend>
		<table border="1" width="100%" align="center" style="border-collapse: collapse;" bordercolor="#000000">
			<tr>
			  <th>编号</th>
			  <th>姓名</th>
			  <th>删除</th>
			</tr>
			<s:iterator value="persons" id="person">
			<tr>
		       <td><s:property value="#person.personid"/></td>
			   <td><s:property value="#person.name" /></td>
				<td align="center">
				<a href="person_del?personid=<s:property value='#person.personid'/>">删除该项</a>
			</tr>
			</s:iterator>
		</table>
	  </fieldset>
	   <input type="button" value="添加" onclick="window.location.href='person_add1'">
	   <input type="button" value="退出" onclick="window.location.href='person_toLogin'">
   </center>
  </body>
</html>