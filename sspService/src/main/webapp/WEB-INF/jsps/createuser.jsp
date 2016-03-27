<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sspService/user/save" method="post">
		用户ID: <input name="id" type="text"/><br /> 
		用户名: <input name="username" type="text"/><br /> 
		用户密码: <input name="password" type="text"/><br />  
	           年龄: <input name="age" type="text"/><br />  
			<input type="submit" value="提交"><br /> 
	</form>
</body>
</html>