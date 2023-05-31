<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- action="student" => 컨트롤러단에서 @RequestMapping 의 student를 찾아감 -->
<!-- 	<form method="get" action="student"> -->
	<form method="post" action="student">
		student id: <input type="text" name="id">
		<input type="submit" value="전송">
	</form>
</body>
</html>