<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		
		out.print("도시 : "+city);
		out.print("우편번호 : "+zipcode);
	%>
</body>
</html>
