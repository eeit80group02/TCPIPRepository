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
<body class="amber lighten-5">
	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
  


	
	
	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">活動花絮</h1>
	</div>
	
	
	<!-- 內容 -->
	<main>
		<!-- 主要版面 -->
		<div class="row" id="mainboard">
			

			<!-- 活動花絮列表 -->
			<div class="col l11 offset-l1" id="projlist">
				<div class="centerdiv">
				<c:forEach  var="activityHighLight" items="${activityHighLightAll}" varStatus="varStatus" >
					<c:url value="/Activity/ActivityHighlightDisplay.jsp" var="path">
						<c:param name="memberId" value="${activityHighLight.memberId}" />
						<c:param name="fullProjId" value="${activityHighLight.fullProjId}" />
					</c:url>
					
					<!-- 卡片開始 -->
						<div class="touche">
							<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
								<!-- 花絮封面圖片 -->
								<div class="card-image activator"
									style="background-image: url(${activityHighLight.base64String}); background-size: cover; background-repeat: no-repeat;cursor:pointer;">
								</div>
								<!-- 花絮的名稱(完整計畫的名稱) -->
								<div class="card-content" style="font-size: 20pt" class="truncate">
									${activityHighLight.fullProjBean.title}
								</div>
								<!-- 連結到花絮的收看頁面 -->
								<div class="card-action right-align">
									<a href="${path}">take a look</a>
								</div>
							</div>
						</div>
					<!-- 卡片結束 -->
				</c:forEach>
				</div>				
			</div>
		</div>
		<!-- 主要版面 -->
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
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			//設定主要面板高度
			$("#mainboard").css("min-height","100vh");
			
			
// 			$.get("<c:url value='/ActivityHighlightDisplayAllServlet' />", function(responseJson) {
// 				console.log(responseJson);
// 				if(responseJson.error == "尚未建立花絮!") {
// 					$("#error").html("<h4>查詢錯誤!</h4>");
// 				} else {
// 					$("#projName").append(responseJson.projName);	
// 					$("#memberName").append(responseJson.memberName);
// 					var offset = responseJson.videoURL.indexOf("watch?v=")+8;
// 					$("#YouTubeURL").attr("src","//www.youtube.com/embed/"+responseJson.videoURL.substring(offset, offset+11));
// 					$("#frontCover").attr("src", responseJson.frontCover);
// 					$("#content").html(responseJson.content);
// 				}
// 			}); 
			
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