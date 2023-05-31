<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkJson").click(function(){
			var member={tno:"777"
						,owner:"홍길동"
						,grade:"337"};	
			$.ajax({
				type:"post"
				//프로젝트명+class@RequestMapping+method@RequestMapping
				//spring_15/sample/ticket
				,url:"${contextPath}/sample/ticket"
				,contentType:"application/json"
				//stringft: 객체를 json 문자열 형태로 변환
				,data:JSON.stringify(member)
				,success:function(data){}
				,error:function(){
					alert("오류가 발생했습니다.");
				}
			});//end ajax
		});//end click function
	});//end function
</script>
<body>
<!-- 	ticket_test.jsp !!! -->
	<input type="button" id="checkJson" value="회원 정보 보내기"> <br>
</body>
</html>