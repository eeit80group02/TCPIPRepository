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
<title>displayPersonalParticipateFullProj</title>
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
		<!-- 6欄置中 -->
		<div class="col l6 offset-l3">
		<div class="row center-align card-panel blue-text" style="font-size:4em;">參加的活動計畫</div>
		<c:forEach items="${participator}" var="bean">
			<!-- 開始列出參與的計畫 -->
			<div class="card-panel black-text light-blue lighten-4">
				<!-- 計畫編號及計畫名稱 -->
				<div class="row card-panel"  style="font-size:2.5em;font-weight:600;font-family:微軟正黑體;" >
					<div class="col l12 center-align blue-text" >
						${bean.fullProjBean.title}
					</div>
				</div>
				
				<!-- 活動時間 -->
				<div class="row"  style="font-size:2em;font-weight:600;font-family:微軟正黑體;">
					<div class="col l3 right-align">
						<i class="material-icons red-text" style="font-size:1.4em;vertical-align:bottom;">schedule</i>
					</div>
					<div class="col l9 left-align" >
						活動時間:<fmt:formatDate value="${bean.activityStartTime}"/>~<fmt:formatDate value="${bean.activityEndTime}"/>
					</div>
				</div>
				<!-- 拒絕按鈕 -->
				<div class="row">
					<form action="<c:url value="/participator.do" />" method="post">
						<input type="hidden" name="participatorId" value="${bean.participatorId}">
						<input type="hidden" name="option" value="2" />
						<input type="hidden" name="type" value="cancel">
						<button class="col l2 btn-large grey darken-4 white-text right center-align" type="submit" style="font-size:2em;font-weight:600;font-family:微軟正黑體;">拒絕</button>
					</form>					
				</div>
			</div>
			</c:forEach>
		</div>
		<!-- 6欄置中 -->
	</div>
	<!-- 主要版面 -->
</main>

<!-- 	<table border="1"> -->
<!-- 		<tr> -->
<!-- 			<th>計畫編號</th> -->
<!-- 			<th>計畫名稱</th> -->
<!-- 			<th>時間</th> -->
<!-- 			<th>button</th> -->
<!-- 		</tr> -->
		
<%-- 		<c:forEach var="bean" items="${participator}"> --%>
<!-- 			<tr> -->
<%-- 				<td>${bean.fullProjId}</td> --%>
<%-- 				<td>${bean.fullProjBean.title}</td> --%>
<%-- 				<td><fmt:formatDate value="${bean.activityStartTime}"/>~<fmt:formatDate value="${bean.activityEndTime}"/></td> --%>
<!-- 				<td> -->
				
<%-- 				<form action="<c:url value="/participator.do" />" method="post"> --%>
<%-- 					<input type="hidden" name="participatorId" value="${bean.participatorId}"> --%>
<!-- 					<input type="hidden" name="option" value="2" /> -->
<!-- 					<input type="hidden" name="type" value="cancel"> -->
<!-- 					<button class="btn red white-text btndiv right" type="submit">拒絕</button> -->
<!-- 				</form>	</td> -->
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->

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