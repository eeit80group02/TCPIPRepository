<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css" media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body class="deep-orange lighten-5">
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->
	
	<!-- 內容 -->
	<main>
	<div class="contaniner">
	<form action="/" id="postForm">
	<div class="row">
		<div class="col s12"><h2 style="text-align:center;">活動花絮</h2></div>
		<div class="col s12 m4 l8">
			<h4>花絮編輯</h4>
			<div class="input-field col s12">
				<input placeholder="" id="projName" type="text" class="validate" name="projName" readonly >
				<label for="projName" class="active">完整計畫名稱</label>
			</div>
			<div class="input-field col s12">
				<input placeholder="" id="memberName" type="text" class="validate" name="memberName" readonly >
				<label for="memberName" class="active">活動發起人</label>
			</div>
			<div class="input-field col s12">
				<input id="videoURL" type="text" class="validate" name="videoURL" >
				<label for="videoURL" class="active">影片網址(請輸入YouTube完整網址)</label>
			</div>
			<div class="col s12" >
						<div class="file-field input-field">
							<div class="btn">
								<span>封面上傳</span> <input type="file" id="picture">
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text" placeholder="請上傳封面圖片..." id="frontCoverName">
							</div>
						</div>
					</div>
			<div class="input-field col s12">
				<textarea class="ckeditor" name="content" id="content"></textarea>
			</div>
			<div class="input-field col s12">
				<input id="fullProjId" type="hidden">
				<input id="memberId" type="hidden">
				<button class="btn waves-effect waves-light" type="submit" name="action">
					送出 <i class="material-icons right">send</i>
				</button>
				<a class="waves-effect waves-light btn" id="preview">預覽</a>
			</div>
			
			<div class="input-field col s12">
				<div id="result"></div>
			</div>
		</div>
		<div class="col s12 m4 l4">
			<div class="input-field col s12">
				<h4>花絮封面預覽</h4>
				<img class="card-panel hoverable" id="frontCover" src="" style="height: 340px; width: 420px;border:5px solid black;padding:0;" >
			</div>
			<div class="input-field col s12">
				<h4>影片預覽</h4>
			</div>
			<div class="input-field col s12">
				<div class="video-container">
        			<iframe id="YouTubeURL" src="" frameborder="0" allowfullscreen></iframe>
      			</div>	
      		</div>		
		</div>
	</div>
	</form>
	</div>
	</main>


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->



	<!-- script -->
	<script src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		$(function() {
			//註冊modal事件
			$(".modal-trigger").leanModal();
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			
			// upload picture
			$("#picture").change(function(){
				var file = $("#picture")[0].files[0];
				var reader  = new FileReader();
				reader.onloadend = function () {
					console.log(reader.result);
					$("#frontCover").attr("src", reader.result);
				}
				if(file){
					reader.readAsDataURL(file);
				}
			})
			
			$("#videoURL").on("focusout",function(){
				var offset = $("#videoURL").val().indexOf("watch?v=")+8;
				console.log(offset);
				$("#YouTubeURL").attr("src","//www.youtube.com/embed/"+$("#videoURL").val().substring(offset, offset+11));
				console.log($("#YouTubeURL").attr("src"));
			});
				
			
			
			
			
			$.get("<c:url value='/ActicityHighlightCreateInitServlet' />", function(responseJson) {
				console.log(responseJson);
				$("#projName").val(responseJson.projName);	
				$("#memberName").val(responseJson.memberName);
				$("#fullProjId").val(responseJson.fullProjId);
				$("#memberId").val(responseJson.memberId);
			}); 
			
			
			$( "#postForm" ).submit(function( event ) {
				event.preventDefault();
				var check = false;
				if($("#content").val() != "" && $("#frontCover").attr("src") != "" && $("#videoURL").val() != "" ) {
					check = true;
				}
				if(check){
					$.ajax({
    					url:'<c:url value="/ActivityHighlightPostServlet" />',
    	   				type:'post',
    	   				data:{	"content" : $("#content").val(),
    	   		  	   	    	"frontCover" : $("#frontCover").attr("src"), 
    	   		  	   	    	"fullProjId" : $("#fullProjId").val(),
    	   		  	   	    	"memberId" : $("#memberId").val(),
    	   		  	   	    	"frontCoverName" : $("#frontCoverName").val(),
    	   		  	   	    	"videoURL" : $("#videoURL").val() },
    	   				dataType:'text',
    	   				success:function(result){
    						$("#result").text(result);
    	   				}
    	   
       				});
				} else {
					$("#result").text("欄位需填齊!");
				}
			});
			
			$("#preview").on("click",function(){
				var newWindow = window.open('<c:url value="/ActivityHighlightPreview.jsp" />');
				newWindow.window.content = $("#content").val();
				newWindow.window.frontCover = $("#frontCover").attr("src");
				newWindow.window.fullProjName = $("#projName").val();
				newWindow.window.memberName = $("#memberName").val();
				newWindow.window.videoURL = $("#videoURL").val();			
			});
			
		})
	</script>
</body>
</html>