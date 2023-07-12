<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>loginForm~!</h1>
	<form method="post" action="j_spring_security_check">
		security id:<input type="text" name="j_username"><br>
		security pw:<input type="text" name="j_password"><br>
					<input type="submit" value="S login">
	</form>
</body>
</html>