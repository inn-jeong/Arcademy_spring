<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 프로젝트 경로를 contextPath 변수에 저장 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${contextPath}/js/scriptTest.js"></script>
</head>
<body>
	안녕하세요. <br>
	<h2>${message}</h2>
	<img width="200" height="200" alt="" src="${contextPath}/image/duke3.png">
	<input type="button" name="테스트" value="테스트" onclick="test();">
</body>
</html>