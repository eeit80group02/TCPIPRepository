<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayPersonalFullProjByParticipate.jsp</title>
</head>
<body>

	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->  

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${LoginOK.lastName}${LoginOK.firstName}</h3>
	</div>	

<main>
	<div class="row" id="mainboard">
		<div class="col l8 offset-l2 indigo lighten-5">
			<div class="row center-align card-panel blue-text" style="font-size:4em;">
				審核志工
			</div>
		
		
		<!-- 完整計畫 -->
		<c:forEach items="${fullProj}" var="bean">
			<div class="row card-panel">
				<!-- 完整計畫名稱 -->
				<div class="row priProjName left-align ">
					<i class="material-icons medium purple-text accent-1" style="vertical-align:middle;">
						assignment
					</i>
					${bean.title}
				</div>
					
				<!-- 待審核的志工 forEach在這 -->
				<c:forEach items="${bean.participatorMap.pending}" var="participatorBean" varStatus="i">		
					<div class="row card-panel light-blue lighten-4">
						<div class="col l4 left schldiv center-align">
							${participatorBean.memberBean.lastName}${participatorBean.memberBean.firstName}
						</div>
						<div class="col l4 left schldiv" >
 							

						</div>
						<div class="col l4 right right-align">

							<form action="<c:url value="/participator.do" />" method="post">
								<input type="hidden" name="participatorId" value="${participatorBean.participatorId}">
								<input type="hidden" name="option" value="1" />
								<input type="hidden" name="type" value="cancel">
								<button class="btn red white-text btndiv right" type="submit">拒絕</button>
							</form>						
							
							<form action="<c:url value="/participator.do" />" method="post">
								<input type="hidden" name="type" value="agree">
								<input type="hidden" name="participatorId" value="${participatorBean.participatorId}">
								<button class="btn red white-text btndiv right" type="submit">同意</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>

<%-- 			<c:forEach var="bean" items="${fullProj}"> --%>
<%-- 		編號 ${bean.fullProjId}<br> --%>
<%-- 		名稱 ${bean.title}<br> --%>
		
				<!-- 參加人 -->
<%-- 				<c:forEach var="participatorBean" items="${bean.participatorBean}"> --%>
<%-- 					編號 ${bean.fullProjId} --%>
<%-- 					名稱 ${bean.title} --%>
<%-- 					參加人 ${participatorBean.memberBean.lastName}${participatorBean.memberBean.firstName} --%>
<!-- 					<input type="button" value="同意"> -->
<!-- 					<input type="button" value="取消"> -->
<!-- 					<hr> -->
<%-- 				</c:forEach> --%>
<%-- 			</c:forEach> --%>
		</div>
	</div>
</main>
	
	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->
	
	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//mainboard最小高度
			$("#mainboard").css("min-height","100vh");
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			//會員名稱margin-top,margin-left
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
