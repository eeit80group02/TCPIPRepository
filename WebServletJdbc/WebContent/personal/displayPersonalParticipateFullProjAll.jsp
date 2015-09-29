<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayPersonalParticipateFullProjAll</title>
</head>
<body>

	<!-- 頁首 -->
	<c:import url="/template/header.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${LoginOK.lastName}${LoginOK.firstName}</h3>
	</div>	

<main>
	<!-- 主要版面 -->
<div class="row" id="mainboard">
	<div class="col l8 offset-l2 indigo lighten-5">
		<div class="row center-align card-panel blue-text" style="font-size:4em;">參加過的完整計畫</div>
		<div class="row card-panel" >
			<table class="bordered highlight centered">
				<thead style="font-size:2em;">
					<tr>
						<th>完整計畫名稱</th>
						<th>活動時間</th>
						<th>活動狀態</th>
						<th>link</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${participator}">
						<tr>
							<td>${bean.fullProjBean.title}</td>
							<td>
								<fmt:formatDate value="${bean.fullProjBean.activityStartTime}" pattern="yyyy-MM-dd"/>
								~
								<fmt:formatDate value="${bean.fullProjBean.activityEndTime}" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								${bean.fullProjBean.projStatus}
							</td>
						
							<td>
								<!-- 連結都還未給 -->
								<c:if test="${bean.fullProjBean.projStatus.equals('招募中')}">
									<a href="${path}" class="btn-large yellow lighten-5 black-text">
										任務板
									</a>
								</c:if>
								<c:if test="${bean.fullProjBean.projStatus.equals('已完成')}">
									<a href="${path}" class="btn-large yellow lighten-5 black-text">
										活動花序
									</a>
								</c:if>		
								
							</td>
						</tr>
					</c:forEach>			
				</tbody>
			</table>			
		</div>
	</div>
</div>
<!-- 主要版面 -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- 主要版面 -->
	<div class="row" id="mainboard">
		<!-- 6欄置中 -->
		<div class="col l6 offset-l3">
		<div class="row center-align card-panel blue-text" style="font-size:4em;">參加過的完整計畫</div>
		<c:forEach var="bean" items="${participator}">
			${bean.fullProjBean.fullProjId}暫時顯示編號 最後DEMO應該拿掉 只留名稱<br>
			${bean.fullProjBean.title}<br>
			<fmt:formatDate value="${bean.fullProjBean.activityStartTime}" pattern="yyyy-MM-dd"/><br>
			<fmt:formatDate value="${bean.fullProjBean.activityEndTime}" pattern="yyyy-MM-dd"/><br>
			${bean.fullProjBean.projStatus}<br>

			<c:if test="${bean.fullProjBean.projStatus.equals('招募中')}">
				如果招募中 進行中 有任務版連結?
			</c:if>
			
			<c:if test="${bean.fullProjBean.projStatus.equals('已完成')}">
				如果完成 有花絮?
			</c:if>
			</c:forEach>
		</div>
		<!-- 6欄置中 -->
	</div>
	<!-- 主要版面 -->
</main>

	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁尾 -->


<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script>
	$(function() {
		//mainboard固定大小
		$("#mainboard").css("min-height","100vh");
		//提示頁面主題欄的高度
		var pagetitleheight = ($(window).height() * 0.25);
		$("#pagetitle").css("height", pagetitleheight);
		//navagation上logo的高度
		$("img[title='TCPIP']").attr("height", "70");
		//設定body寬度為100%
		$("body").css("width", "100%").css("height", "100%");
		//會員名稱margin-top,margin
		var namediv = $("#membername").height();
		$("#membername").css({
			"margin-top":(pagetitleheight - namediv)/2
			,"margin-left":($(window).width()) * 0.2});
	})

</script>
<script>
	//响應式高度
	$(window).on("resize", function() {
		var pagetitleheight2 = ($(window).height() * 0.25);
		$("#pagetitle").css("height", pagetitleheight2);
		//會員名稱margin-top,margin-left
		var namediv = $("#membername").height();
		$("#membername").css({
			"margin-top":(pagetitleheight2 - namediv)/2
			,"margin-left":($(window).width()) * 0.2});
		
	});
</script>
</body>
</html>