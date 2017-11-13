<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.wis.token.Token" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Token</title>

<script type="text/javascript">


</script>
</head>
<body>
	<form>  
    	<input type="hidden" name="<%=Token.TOKEN_STRING_NAME %>" value="<%=Token.getTokenString(session) %>">  
	</form>  
</body>
</html>