<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.uploadResult {
		width: 100%;
		background-color: gray;
	}
	.uploadResult ul {
		display: flex;
/* 		flex-flow: row; */
		flex-flow: column;
		justify-content: center;
		align-items: center;
	}
	
	.uploadResult ul li {
 		list-style: none; 
		padding: 10px;
	}
	
	.uploadResult ul li img {
		width: 20px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//확장자가 exe|sh|js 이면 업로드 금지하기 위한 정규식
		var regex = new RegExp("(.*?)\.(exe|sh|js)$");
		var maxSize = 542880;//5MB
		
		function checkExtension(fileName,fileSize){
			if(fileSize > maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if(regex.test(fileName)){
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;
		}
		
		//파일 업로드 전 초기화면 저장
		var cloneObj = $(".uploadDiv").clone();
		console.log("@# cloneObj ===>"+cloneObj);
		
		$("#uploadBtn").on("click",function(){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			//files: 파일정보
			var files = inputFile[0].files;
			console.log(files);
			
			for (var i = 0; i < files.length; i++) {
				//파일 크기와 종류 중에서 거짓이면 리턴
				if(!checkExtension(files[i].name,files[i].size)){
					return;
				}
				//파일 정보를 formData 에 추가
				formData.append("uploadFile",files[i]);
			}
			$.ajax({
				//컨트롤러단 호출
// 				url:"uploadAjaxAction"
				url:"uploadAjaxAction.json"
				//processData: 기본값: (true) key/value를 쿼리스트링으로 전송
				//			파일 전송 (false)
				,processData:false
				//contentType: 기본값: (true) "application / x-www-form-urlencoded;charset=UTF-8" 
				//			 파일 전송: (false) multipart/form-data로 전송됨 
				,contentType:false
				,data:formData
				,type:"POST"
				,success:function(result){
					alert("Uploaded");
					console.log(result);
					
					//파일정보들을 함수로 보냄
					showUploadedFile(result);
					//파일 업로드 전 초기상태로 설정
					$(".uploadDiv").html(cloneObj.html());
				}
			});//end of ajax
		});//end of click function
		
		$(".uploadResult").on("click","span",function(){
			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			var uploadResultItem = $(this).closest("li");
			console.log("@# targetFile ===>"+targetFile);
			console.log("@# type ===>"+type);
			console.log("@# uploadResultItem ===>" +uploadResultItem);
			
			$.ajax({
				url:"deleteFile"
				,data:{fileName : targetFile, type:type}
				,dataType:"text"
				,type:"POST"
				,success:function(result){
					alert(result);
					uploadResultItem.remove();
				}
			});//end of ajax
// 			uploadResultItem.remove();
		});//end of span function
		
		var uploadResult = $(".uploadResult ul");
		function showUploadedFile(uploadResultArr){
			console.log("@# uploadResultArr ===>"+uploadResultArr);
			var str = "";
			
			//업로드 파일 갯수만큼 반복 
			$(uploadResultArr).each(function(i,obj){
				//이미지 파일이 아닌 경우
				if(!obj.image){
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					console.log("@# fileCallPath ===>"+fileCallPath);
// 					str += "<li><img src='./resources/img/attach.png'>"+obj.fileName+"</li>";
// 					str += "<li><a href='./download?fileName="+fileCallPath+"'>"
// 							+"<img src='./resources/img/attach.png'>"+obj.fileName+"</a></li>";
					str += "<li><div><a href='./download?fileName="+fileCallPath+"'>"
							+"<img src='./resources/img/attach.png'>"+obj.fileName+"</a>"
							+"<span data-file=\'"+fileCallPath+"\' data-type='file'>x</span>"
							+"</div></li>";
				}else{
					//썸네일 경로 + 이름
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					console.log("@# fileCallPath ===>"+fileCallPath);
					var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
					originPath = originPath.replace(new RegExp(/\\/g),"/");
					console.log("@# originPath ===>"+originPath);
					//obj.fileName : 업로드 파일 이름
// 					str += "<li>"+obj.fileName+"</li>";
					//썸네일 경로 추가
// 					str += "<li><img src='./display?fileName="+fileCallPath+"'>"+obj.fileName+"</li>";
// 					str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='./display?fileName="+fileCallPath+"'>"+obj.fileName+"</li>";
					str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='./display?fileName="
							+fileCallPath+"'>"+obj.fileName+"</a>"
							+"<span data-file=\'"+fileCallPath+"\' data-type='image'>x</span>"
							+"</li>";
				}
			});//end of each function
			//div 클래스에 파일 목록 추가
			uploadResult.append(str);
		}//end of showUploadedFile
		
		$(".bigPictureWrapper").on("click",function(){
			$(".bigPicture").css({width:"0%",height:"0%"},0);
			
			$(".bigPictureWrapper").hide();
		});//end of .bigPictureWrapper click
		
	});//end of ready function
	function showImage(fileCallPath){
// 		alert(fileCallPath);
		$(".bigPictureWrapper").css("display","flex").show();
		//display?fileName="+encodeURI(fileCallPath) : 이미지파일을 화면에 출력
		$(".bigPicture").html("<img src='./display?fileName="+encodeURI(fileCallPath)+"'>")
						.animate({width:"100%",height:"100%"},1000);
	}
</script>
</head>
<body>
	<h1>Upload with Jquery</h1>
	<div class="bigPictureWrapper">
		<div class="bigPicture">
		</div>
	</div>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<div class="uploadResult">
		<ul></ul>
	</div>
	<button id="uploadBtn">Upload</button>
</body>
</html>