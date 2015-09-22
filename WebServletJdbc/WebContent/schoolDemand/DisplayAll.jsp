<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>瀏覽學校需求</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
</head>
<body>

	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">瀏覽需求計畫</h1>
	</div>
	<!-- 頁面主題提示 -->
	
<main>
	<div class="row" id="mainboard">
		<div class="col l8 offset-l2" style="border:2px solid yellow">
          	<div class="card deep-orange accent-2 left">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>1</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2 left">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>2</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2 left">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>3</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2" style="clear:both">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
          	<div class="card deep-orange accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Card Title</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="#">This is a link</a>
	              <a href="#">This is a link</a>
	            </div>
     		</div>			
		</div>

	
	
	</div>

</main>
<!-- 志工方看的，所有的計畫需求 -->
	<c:forEach var="bean" items="${list}">
		${bean.schoolBean.name}<br>
		${bean.participant}<br>
		${bean.activityTopic}<br>
		${bean.activityLocation}<br>
		${bean.activitySuitable}<br>
		${bean.activityHost}<br>
		${bean.activityContact}<br>
		${bean.createDate}<br>
		${bean.content}<br>
		${bean.demandStatus}<br>
		${bean.offerBean.room}<br>
		${bean.offerBean.place}<br>
		${bean.offerBean.food}<hr>
	</c:forEach>

<!-- 頁尾 -->
<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
<!-- 頁尾 -->

	<script>
		$(function() {
			//mainboard最小高度
			$("#mainboard").css("min-height","100vh");
			
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
			//觸發卡片翻轉事件
			$(".touche").each(function() {
				$(this).mouseover(function() {
					$(".activator", this).trigger("click");
				})
				$(this).mouseout(function() {
					$(".card-title", this).trigger("click");
				})
			})
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
		})
	</script>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" 
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	

</body>
</html>