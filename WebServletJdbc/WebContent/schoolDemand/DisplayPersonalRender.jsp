<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待洽談</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body class="deep-orange lighten-5">
	
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->  


	
	
	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">待洽談</h1>
	</div>
	
	
	<!-- 內容 -->
	<main>
		<div class="row" id="mainboard">
			<c:set var="listlength" value="${fn:length(list)}" />

			<div class="col l8 offset-l2 indigo lighten-5">
				<div class="row center-align card-panel red-text" style="font-size:4em;">待洽談需求計畫</div>
				<div class="row card-panel" >
					<table class="bordered highlight centered">
						<thead style="font-size:2em;">
							<tr>
								<th>需求計畫編號</th>
								<th>需求計畫標題</th>
								<th>狀態</th>
								<th>link</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="demand" items="${list}" varStatus="varStatus">
								<tr>
									<td style="font-size:1.6em;font-weight:600">${demand.schoolDemandId}</td>
									<td style="font-size:1.6em;font-weight:600">${demand.activityTopic}</td>
									<td class="red-text" style="font-size:1.6em;font-weight:600">待洽談</td>
									<td>
										<c:url value="/SchoolDemandServlet.do" var="path">
											<c:param name="type" value="display" />
											<c:param name="schoolDemandId" value="${demand.schoolDemandId}" />
										</c:url>	
										<a href="${path}" class="btn-large yellow lighten-5 black-text" style="font-size:1.4em;font-weight:600">查看</a>
									</td>
								</tr>
							</c:forEach>			
						</tbody>
					</table>			
				</div>
			</div>



















			<!-- 初步計畫列表 -->
<!-- 			<div class="col l8 offset-l4" id="projlist"> -->
<!-- 				<div class="centerdiv"> -->
<%-- 				<c:forEach  var="demand" items="${list}" varStatus="varStatus" > --%>
<%-- 					<c:url value="/SchoolDemandServlet.do" var="path"> --%>
<%-- 						<c:param name="type" value="display" /> --%>
<%-- 						<c:param name="schoolDemandId" value="${demand.schoolDemandId}" /> --%>
<%-- 					</c:url> --%>
					
					<!-- 卡片開始 -->
<!-- 					      <div class="row"> -->
<!-- 					        <div class="col s12 m6"> -->
<!-- 					          <div class="card blue-grey darken-1"> -->
<!-- 					            <div class="card-content white-text"> -->
<%-- 					              <span class="card-title">${demand.activityTopic}</span> --%>
<%-- 					              <p>${demand.activityLocation}</p> --%>
<%-- 					              <p>${demand.activitySuitable}</p> --%>
<!-- 					            </div> -->
<!-- 					            <div class="card-action"> -->
<%-- 					              <p>${demand.demandStatus}</p> --%>
<!-- 					              <a href="#">查看</a> -->
<!-- 					            </div> -->
<!-- 					          </div> -->
<!-- 					        </div> -->
<!-- 					      </div> -->
					<!-- 卡片結束 -->
<%-- 				</c:forEach> --%>
<!-- 				</div>				 -->
<!-- 			</div> -->
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