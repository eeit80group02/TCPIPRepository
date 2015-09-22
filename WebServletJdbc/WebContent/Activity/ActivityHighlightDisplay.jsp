<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活動花絮</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css" media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>
<body class="cyan lighten-5">
	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->
	
	<!-- 頁面主題提示 -->
	<div class="row black valign-wrapper" id="pagetitle">
		
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">活動花絮</h1>
	</div>		
	
	<!-- 內容 -->
	<main>
		<div class="row" id="mainboard">
		
		
		
		
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="contaniner">
	<form action="/" id="postForm">
	<div class="row">
		<div class="col s12 m4 l8">
			<div class="input-field col s12">
				<div class="input-field col s12">
					<div id="error"></div>
				</div>
				<div class="input-field col s6">
					<h4>
					<span id="projName" type="text" class="validate" ></span>
					<label for="projName" class="active">完整計畫名稱</label>
					</h4>
				</div>
				<div class="input-field col s6">
					<h4>
						<span id="memberName" type="text" class="validate"></span>
						<label for="memberName" class="active">活動發起人</label>
					</h4>
				</div>
				<div class="input-field col s12">
					<div class="video-container">
        				<iframe id="YouTubeURL" src="" frameborder="0" allowfullscreen></iframe>
      				</div>	
      			</div>
      			<div class="input-field col s12">
      				<div class="divider" ></div>
					<div id="content"></div>
				</div>
			</div>
		</div>
		<div class="col s12 m4 l4">
			<div>
				<h4>花絮封面</h4>
				<img class="card-panel hoverable" id="frontCover" src="" style="height: 340px; width: 420px;border:5px solid black;padding:0;" >
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
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			
// 			$.get("<c:url value='/ActicityHighlightDisplayServlet' />", function(responseJson) {
// 				console.log(responseJson);
// 				if(responseJson.error == "尚未建立花絮!") {
// 					$("#error").html("<h4>查詢錯誤!</h4>");
// 				} else {
// 					$("#projName").text(responseJson.projName);	
// 					$("#memberName").text(responseJson.memberName);
// 					var offset = responseJson.videoURL.indexOf("watch?v=")+8;
// 					$("#YouTubeURL").attr("src","//www.youtube.com/embed/"+responseJson.videoURL.substring(offset, offset+11));
// 					$("#frontCover").attr("src", responseJson.frontCover);
// 					$("#content").html(responseJson.content);
// 				}
// 			}); 
			
						
			
		})
	</script>
</body>
</html>