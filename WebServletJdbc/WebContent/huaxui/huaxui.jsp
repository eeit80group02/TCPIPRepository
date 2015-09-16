<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>		
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
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
  


	
	
	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">活動花絮</h1>
	</div>
	
	
	<!-- 內容 -->
	<main>
		<div class="row">
		<!-- 側邊篩選條件欄 -->
			<div class="col l3 offset-l1 z-depth-3 hide-on-med-and-down"
				style="position: absolute; top: 166; padding: 0" id="sidebar">
				<div class="collection"
					style="margin: 0 auto; font-family: 微軟正黑體; font-weight: 900;">
					<ul style="margin: 0;">
						<li class="collection-header collection-item center-align"
							style="padding: 0;"><h5 class="teal accent-2"
								style="margin: 0; display: block; padding: 15px 0 15px 0;">排序</h5></li>
						<li><a href="#!" class="collection-item">即將結束</a></li>
						<li><a href="#!" class="collection-item">活動時間</a></li>
						<li><a href="#!" class="collection-item">需求人數</a></li>
						<li><a href="#!" class="collection-item">已募集人數</a></li>
					</ul>
				</div>
				<div class="collection"
					style="margin: 0 auto; font-family: 微軟正黑體; font-weight: 900;">
					<ul style="margin: 0;">
						<!-- 提示[篩選] -->
						<li class="collection-header collection-item center-align"
							style="padding: 0;"><h5 class="teal accent-2"
								style="margin: 0; display: block; padding: 15px 0 15px 0;">篩選</h5></li>
						<li><a href="#!" class="collection-item">北部地區</a></li>
						<li><a href="#!" class="collection-item">中部地區</a></li>
						<li><a href="#!" class="collection-item">南部地區</a></li>
						<li><a href="#!" class="collection-item">東部地區</a></li>
					</ul>
				</div>
			</div>
			
			<c:set var="listlength" value="${fn:length(primaryProjAll)}" />
			<!-- 初步計畫列表 -->
			<div class="col l8 offset-l4" id="projlist">
				<div class="centerdiv">
				<c:forEach  var="primaryProj" items="${primaryProjAll}" varStatus="varStatus" >
					<c:url value="/primaryProj.do" var="path">
						<c:param name="type" value="display" />
						<c:param name="primaryProjId" value="${primaryProj.primaryProjId}" />
					</c:url>
					
					<!-- 卡片開始 -->
						<div class="touche">
							<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
								<!-- 花絮封面圖片 -->
								<div class="card-image activator"
									style="background-image: url(${primaryProj.base64String}); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
								</div>
								<!-- 花絮的名稱(完整計畫的名稱) -->
								<div class="card-content">
									<p style="font-size: 20pt" class="truncate">${primaryProj.title}</p>
								</div>
								<!-- 連結到花絮的收看頁面 -->
								<div class="card-action right-align">
									<a href="#">take a look</a>
								</div>
							</div>
						</div>
					<!-- 卡片結束 -->

					
				</c:forEach>
				</div>				
			</div>
		</div>
	</main>


	<!-- 頁尾 -->
	<c:import  url="/template/footer.jsp" context="${pageContext.request.contextPath}"/>


	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//固定側邊欄所在位置
			$(window).on("scroll", function() {
				if ($(this).scrollTop() <= $("#projlist").position().top) {
					$("#sidebar").css({
						"position" : "absolute",
						"top" : $("#projlist").position().top
					});
				} else {
					$("#sidebar").css({
						"position" : "fixed",
						"top" : 0
					});
				}
			})
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//註冊modal事件
			$(".modal-trigger").leanModal();
			//觸發卡片翻轉事件
			$(".touche").each(function() {
				$(this).mouseover(function() {
					$(".activator", this).trigger("click");
				})
				$(this).mouseout(function() {
					$(".card-title", this).trigger("click");
				})
			})
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//提示區塊的按鈕
			$(".projinfos").css("margin", "0px auto");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
		})
	</script>
	<script>
		//响應式高度
		$(window).on("resize", function() {
			var pagetitleheight2 = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight2);
		});
	</script>
</body>
</html>