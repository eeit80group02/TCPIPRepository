<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
a
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
	<style>
		.error{
			color:#FF0000;
		}
		
		.forinput {
			font-size:1.6em;
			font-weight:600;
			color:black;
			font-family:微軟正黑體;		
		}
		
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>createPrimaryProj</title>
</head>
<body class="pink lighten-5">
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row red accent-2 valign-wrapper" id="pagetitle">
		<h1 class="valign white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">修改需求計畫</h1>
	</div>	
<!-- 內容 -->
<main>
<!-- 主要版面 -->
		<div class="row">
			<div class="col l10 offset-l1">
				<div class="row card-panel hoverable grey lighten-4">
					<form action="<c:url value='SchoolDemandServlet.do?type=update' />" method="post" style="font-family:微軟正黑體;font-weight:600;">
						<div class="row">
							<div class="col l3" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text left-align" style="width:100%;">活動主題</div>
							</div>
							<input class="col l7" type="text" id="activityTopic" name="activityTopic" value="${Demand.activityTopic}"/>
							<div class="col l2">
								<span>${error.activityTopic}</span>
							</div>
						</div>
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">活動地點</div>
							</div>
							<input class="col l7" type="text" id="activityLocation" name="activityLocation" value="${Demand.activityLocation}"/>
							<div class="col l2">
								<span>${error.activityLocation}</span>
							</div>						
						</div>					
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">活動適合對象</div>
							</div>
							<input class="col l7" type="text" id="activitySuitable" name="activitySuitable" value="${Demand.activitySuitable}"/>
							<div class="col l2">
								<span>${error.activitySuitable}</span>
							</div>							
						</div>					
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">預計參與學生人數</div>
							</div>
							<input class="col l7" type="number" id="participant" name="participant" value="${Demand.participant}"/>
							<div class="col l2">
								<span>${error.participant}</span>
							</div>
						</div>					
						<!-- 可提供資源 -->
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">可提供資源</div>
							</div>
							<div class="col l7">
								<div class="col l2">
									<c:choose>
										<c:when test="${Demand.offerBean.room}">
											<input type="checkbox" name="room" id="room" checked="checked"/>
											<label for="room">住宿</label>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="room" id="room"/>
											<label for="room">住宿</label>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="col l2">
									<c:choose>
										<c:when test="${Demand.offerBean.place}">
											<input type="checkbox" name="place" id="place" checked="checked"/>
											<label for="place">場地</label>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="place" id="place"/>
											<label for="place">住宿</label>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="col l2">
									<c:choose>
										<c:when test="${Demand.offerBean.food}">
											<input type="checkbox" name="food" id="food" checked="checked"/>
											<label for="food">場地</label>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="food" id="food"/>
											<label for="food">住宿</label>
										</c:otherwise>
									</c:choose>
								</div>
							</div>	
						</div>					
						
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">活動負責人</div>
							</div>
							<input class="col l7" type="text" id="activityHost" name="activityHost" value="${Demand.activityHost}"/>
							<div class="col l2">
								<span>${error.activityHost}</span>
							</div>
						</div>					
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">負責人聯絡方式</div>
							</div>
							<input class="col l7 tooltipped" type="text" id="activityContact" name="activityContact" value="${Demand.activityContact}"
							 data-position="bottom" data-delay="50" data-tooltip="建議輸入email"	/>
							<div class="col l2">
								<span>${error.activityContact}</span>
							</div>
						</div>					
						<div class="row">
							<div class="col l3 center-align" style="font-size:1.4em;">
								<div class="btn cyan lighten-5 black-text" style="width:100%;">需求內容</div>
							</div>
							<textarea class="col l7" id="content" name="content">${Demand.content}</textarea>
							<div class="col l2">
								<span>${error.content}</span>
							</div>
						</div>					
						<div class="row">
							<button class="btn-large right  blue accent-2" type="submit" style="font-size:1.5em;">送出</button>
						</div>					
					
					</form>
				</div>
			</div>
		</div>
<!-- 主要版面 -->
</main>	
<!-- 內容 -->
	
	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}" ></c:import>
	<!-- 頁尾 -->
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script>
		(function($) {
		   
			//指定ckeditor()的skin
// 			CKEDITOR.replace("content",{skin:"moono"})
			
			var title = $("#activityTopic").height();
			$(".center-align").height(title);
				
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			
		})(jQuery)
</script>

</body>

		
</html>
