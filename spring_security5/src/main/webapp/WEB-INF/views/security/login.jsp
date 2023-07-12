<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	login.jsp 입니다.
<!-- 	요청한 사용자 객체 정보 -->
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>is Log-In</p>
	</c:if>
	<c:if test="${empty pageContext.request.userPrincipal}">
		<p>is Log-Out</p>
	</c:if>
<!-- 	pageContext.request.userPrincipal.name: 사용자 아이디 -->
	USER ID: ${pageContext.request.userPrincipal.name} <br>
<!-- 	pageContext.request.contextPath: 프로젝트 경로 -->
<!-- 	j_spring_security_logout: spring security에서 제공하는 로그아웃 -->
	<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
	
</body>
</html>