<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form method="post" action="login_process">
		<table width="300" border="1">
			<tr>
				<td align="center">사용자 ID</td>
				<td align="center">
					<input type="text" name="mem_uid">
				</td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td align="center">
					<input type="password" name="mem_pwd">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="로 그 인">
					<input type="button" value="회원가입" onclick="javascript:location.href='./register_jsp'">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>