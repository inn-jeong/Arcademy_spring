<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="uploadFormAction" enctype="multipart/form-data">
<!-- 		multiple : 다중 선택 가능 -->
<!-- 		<input type="file" name="uploadFile" multiple> -->
		<input type="file" name="uploadFile">
		<button>submit</button>
	</form>
</body>
</html>