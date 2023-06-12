<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sendRequest() {
		var httpRequest = new XMLHttpRequest();
		//open: 전송방식, 호출대상
		httpRequest.open("POST","request_ajax.jsp",true);
		//setRequestHeader : 기본 컨텐트 타입 설정(인코딩 기본)
		httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//send : 보내는 데이터 설정
		httpRequest.send("city=Seoul&zipcode=55775");
		//onreadystatechange : 요청, 응답 상태 변화 체크
		httpRequest.onreadystatechange = function name(){
			//XMLhttpRequest.DONE : 실행됨, httpRequest.status: 응답성공
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				document.getElementById("text").innerHTML = httpRequest.responseText;
			}
		}
	}
</script>
</head>
<body>
	<h1>POST 방식의 요청</h1>
	<button type="button" onclick="sendRequest()">POST 방식의 요청 보내기</button>
	<p id="text"></p>
</body>
</html>