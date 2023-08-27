<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>loginForm~!</h1>
	<form method="post" action="j_spring_security_check">
<%-- 	/loginForm.html?ng=987 => ng 값이 ${param.ng} 로 전송 --%>
		message :<c:out value="${param.ng}"></c:out><br>
		<c:if test="${param.ng == '987'}">
			<p>
				Login NG!<br>
			</p>
		</c:if>
		security id:<input type="text" name="j_username"><br>
		security pw:<input type="text" name="j_password"><br>
					<input type="submit" value="S login">
	</form>
</body>
</html>













