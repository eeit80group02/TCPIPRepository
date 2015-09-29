<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body class="deep-orange lighten-5">
  
	<!-- 頁首 -->
	<c:import url="/template/header.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->
	
	<!-- 內容 -->
	<main>
	
		<div class="row valign-wrapper" id="mainboard">
			<div class="col l8 offset-l2 valign card-panel white z-depth-3" style="min-height:40vh" id="cardboard">
				<div class="row center-align" style="font-family:微軟正黑體;font-size:4em;" id="msgboard">
					${LoginOK.firstName} 您好<br>您已通過驗證，數秒後導向首頁
				</div>
				<div class="row">
					<a class="col l2 offset-l5 center-align btn-large red" href="${pageContext.request.contextPath}/index.jsp" style="font-family:微軟正黑體;font-size:1.6em;font-weight:600">回首頁</a>
				</div>
			</div>		
		</div>	
	
<!-- 		<div class="row" style="margin-top: 100px"> -->
<!-- 			<div class="container" style="height: 500px;border: 2px solid black;"> -->
<!-- 				<div style="margin: 150px"> -->
<!-- 					<span></span> -->
<%-- 					<h3>親愛的會員${LoginOK.firstName} 您好，恭喜您已通過驗證，數秒後自動轉移請稍候片刻......</h3> --%>
<%-- 					<a href="<c:url value='../index.jsp'/>">如果未自動轉移轉移請點</a> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</main>


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁尾 -->

	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//置中訊息
			var carhei = $("#cardboard").height(),
				mbhei  = $("#msgboard").height();
			$("#msgboard").css("margin-top",(carhei-mbhei)/2)
			//mainboard min-height
			$("#mainboard").css("min-height","80vh");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			
 			setTimeout(function(){
				window.open("../index.jsp","_top")
			},3000) 
			
		})
		
		
		
	</script>
</body>
</html>