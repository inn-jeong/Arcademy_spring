<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="insert">
		<table width="500" border="1">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<input type="text" name="description">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
					&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" onclick="javascript:window.location.href='./writeResult'" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>