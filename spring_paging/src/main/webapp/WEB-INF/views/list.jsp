<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.div_page ul{
			display: flex;
			list-style: none
		}
	</style>
	
</head>
<body>
<h1 align="center">바보</h1>
	<table width="500" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
<!-- 		list: 모델객체에서 보낸 이름 -->
<!-- 테스트 데이터: insert into mvc_board values(1,'a','aa','aaa',sysdate,0); -->
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bid}</td>
				<td>${dto.bname}</td>
<%-- 				<td>${dto.btitle}</td> --%>
				<td>
<%-- 					<a href="content_view?bid=${dto.bid}">${dto.btitle}</a> --%>
					<a class="move_link" href="${dto.bid}">${dto.btitle}</a>
				</td>
				<td>${dto.bdate}</td>
				<td>${dto.bhit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<a href="write_view">글작성</a>
			</td>
		</tr>
	</table>
	<div class="div_page">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button">
					<a href="${pageMaker.startPage - 1}">
						[Previous]
					</a>
				</li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
<%-- 				<li>|  ${num} |</li> --%>
<%-- 				<li ${pageMaker.cri.pageNum==num ? "style='color:red'":""}>${num}</li> --%>
				<li class="paginate_button" ${pageMaker.cri.pageNum==num ? "style='background-color:yellow'":""}>
<!-- 				클릭한 현재페이지 번호를 링크로 연결 -->
					<a href="${num}">
						[${num}]
					</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li class="paginate_button">
					<a href="${pageMaker.endPage + 1}">
						[Next]
					</a>
				</li>
			</c:if>
		</ul>
	</div>
	<form method="get" id="actionForm" action="list">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	</form>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var actionForm = $("#actionForm");
	
	//페이지 번호 처리
	$(".paginate_button a").on("click",function(e){
		e.preventDefault();
// 		console.log("click~!");
		console.log("@# href ===>"+$(this).attr("href"));
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	//게시글 처리
	$(".move_link").on("click",function(e){
		e.preventDefault();
		var targetBno = $(this).attr("href");
// 		console.log("move click~!");
// 		console.log("@# href ===>"+$(this).attr("href"));
// 		"content_view?bid=${bid}"에 있는 ?bid=의 bid 와 name 을 매칭
		actionForm.append("<input type='hidden' name='bid' value='"+targetBno+"'>");
// 		컨트롤러에 content_view로 찾아감
		actionForm.attr("action","content_view").submit();
	});
</script>
