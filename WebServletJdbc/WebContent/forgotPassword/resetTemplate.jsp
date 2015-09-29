<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body class="deep-orange lighten-5">
	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 內容 -->
	<main>
	
		<div class="row valign-wrapper" id="mainboard">
			<div class="col l8 offset-l2 valign card-panel white z-depth-3" style="min-height:40vh" id="cardboard">
				<div class="row center-align" style="font-family:微軟正黑體;font-size:5em;" id="msgboard">
					密碼已重設成功<br>
					<span style="font-size:0.5em;">網頁將於數秒後跳轉回主頁面</span>
				</div>
				<div class="row">
					<a class="col l2 offset-l5 center-align btn-large red" href="${pageContext.request.contextPath}/index.jsp" style="font-family:微軟正黑體;font-size:1.6em;font-weight:600">回首頁</a>
				</div>
			</div>		
		</div>		
	</main>

	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->


	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="../js/materialize.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		$(function() {
			//mainboard min-height
			$("#mainboard").css("min-height","80vh");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			
 			setTimeout(function(){
				window.open("../index.jsp","_top")
			},3000) 
			
		})
		
		
		
	</script>
</body>
</html>