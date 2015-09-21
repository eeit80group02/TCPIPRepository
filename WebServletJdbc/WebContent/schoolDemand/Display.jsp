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
	
	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">${Demand.activityTopic}</h1>
	</div>
	<!-- 頁面主題提示 -->
	
	<!-- 內容 -->
	<main>
	<!-- 主要版面 -->
	<div class="row valign-wrapper" id="mainboard">
		<div class="col l8 offset-l2 card-panel white z-depth-3" style="min-height:40vh" id="passwordboard">
			<div class="row">
				<h2 class="col l8 offset-l2 " style="font-family:微軟正黑體">活動地點<span>${Demand.activityTopic}</span></h2>
			</div>
			<div class="row">
				<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">預計參與的學生人數<span>${Demand.participant}</span></h3>
			</div>
			<div class="row">
				<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">活動適合對象<span>${Demand.activityLocation}</span></h3>
			</div>
			<div class="row">
				<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">活動負責人<span>${Demand.activitySuitable}</span></h3>
			</div>
			<div class="row">
				<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">負責人聯絡方式<span>${Demand.activityHost}</span></h3>
			</div>
			<div class="row">
				<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">內容<span>${Demand.activityContact}</span></h3>
			</div>
			<div class="row">
				<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">提供
				<span>住宿${Demand.offerBean.room}</span>
				<span>場地${Demand.offerBean.place}</span>
				<span>伙食${Demand.offerBean.food}</span>
				</h3>
			</div>
			<div class="row">
				<button class="col l2 btn-large right black-text yellow lighten-5" type="submit" style="font-size:2em;"><a href="<c:url value='SchoolDemandServlet.do?type=updateDisplay' />">修改</a></button>
				<button class="col l2 btn-large right black-text yellow lighten-5" type="submit" style="font-size:2em;"><a href="<c:url value='SchoolDemandServlet.do?type=displays' />">完成</button>
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
			//mainboard最小高度
			$("#mainboard").css("min-height","80vh");
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
		})
	</script>
</body>
</html>