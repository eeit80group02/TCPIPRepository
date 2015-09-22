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
			<!-- 8欄置中 -->
			<div class="col l8 offset-l2 valign white card-panel" style="padding:10px;">
				<!-- 活動資訊 -->
				<div class="row card-panel yellow lighten-3">
					<div class="row">	
						<div class="col l8 offset-l2">
							<div class="row card-panel brown lighten-5 center-align z-depth-1" style="font-size:2em;font-family:微軟正黑體;font-weight:600">
								需求資訊
							</div>
						</div>				
					</div>	
					<div class="row">
						<!-- 活動主題 -->
						<div class="col l10 offset-l1 card-panel valign-wrapper hoverable">
							<i class="col l1 material-icons black-text" style="font-size:5em;">
								label_outline
							</i>							
							<div class="col l2 right-align valign" style="font-size:1.6em;font-family:微軟正黑體;font-weight:600">
								活動主題
							</div>
							<div class="col l7 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								${Demand.activityTopic}
							</div>
						</div>
						<!-- 活動主題  -->
						
						
						<!-- 活動地點 -->
						<div class="col l10 offset-l1 card-panel valign-wrapper hoverable">
							<i class="col l1 material-icons red-text" style="font-size:5em;">
								location_on
							</i>							
							<div class="col l2 right-align valign" style="font-size:1.6em;font-family:微軟正黑體;font-weight:600">
								活動地點
							</div>
							<div class="col l7 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								${Demand.activityLocation}
							</div>
						</div>
						<!-- 活動地點 -->

						<!-- 提供 -->
						<div class="col l10 offset-l1 card-panel valign-wrapper hoverable">
							<i class="col l1 material-icons blue-text" style="font-size:5em;">
								thumb_up
							</i>							
							<div class="col l2 right-align valign" style="font-size:1.6em;font-family:微軟正黑體;font-weight:600">
								提供資源
							</div>
							<div class="col l3 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								住宿${Demand.offerBean.room}
							</div>
							<div class="col l3 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								場地${Demand.offerBean.place}
							</div>
							<div class="col l3 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								伙食${Demand.offerBean.food}
							</div>
						</div>
						<!-- 提供 -->
						
						<!-- 活動適合對象 -->
						<div class="col l10 offset-l1 card-panel valign-wrapper hoverable">
							<i class="col l1 material-icons green-text" style="font-size:5em;">
								android
							</i>							
							<div class="col l2 right-align valign" style="font-size:1.6em;font-family:微軟正黑體;font-weight:600">
								活動對象
							</div>
							<div class="col l7 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								${Demand.activitySuitable}
							</div>
						</div>
						<!-- 活動適合對象 -->

						<!-- 預計參與的人數 -->
						<div class="col l10 offset-l1 card-panel valign-wrapper hoverable">
							<i class="col l1 material-icons orange-text accent-1" style="font-size:5em;">
								contacts
							</i>							
							<div class="col l2 right-align valign center-align" style="font-size:1.6em;font-family:微軟正黑體;font-weight:600">
								預計參與的人數
							</div>
							<div class="col l7 left-align valign" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
								${Demand.participant}
							</div>
						</div>
						<!-- 預計參與的人數 -->
					</div>
				</div>
				<div class="row card-panel yellow lighten-3">
					<div class="row">	
						<div class="col l8 offset-l2">
							<div class="row card-panel brown lighten-5 center-align z-depth-1" style="font-size:2em;font-family:微軟正黑體;font-weight:600">
								活動內容
							</div>
						</div>				
					</div>					
				
					<div class="row">
						<div class="col l10 offset-l1 card-panel blue-text hoverable center-align" style="font-size:1.4em;font-family:微軟正黑體;font-weight:600">
							 內容${Demand.activityContact}
						</div>
					</div>
				
				</div>
				
				<div class="row">
				
				  	<div class="col l4 right-align">
					    <i class="material-icons large light-blue-text darken-4">contact_phone</i>
  					</div>
  					<div class="col l8 left-align">
  						<div class="row" style="font-size:1.6em;font-weight:900">
  							活動負責人:${Demand.activityContact}
  						</div>
  						<div class="row" style="font-size:1.6em;font-weight:900">
  							負責人聯絡電話:
  						</div>
  					</div>
				</div>
				<div class="row">
					<a class="btn-large red right" href="<c:url value='SchoolDemandServlet.do?type=updateDisplay' />" style="font-family:微軟正黑體;font-size:2em;font-weight:600">修改</a>
					<a class="btn-large red right" href="<c:url value='SchoolDemandServlet.do?type=displays' />" style="font-family:微軟正黑體;font-size:2em;font-weight:600">完成</a>				
				</div>
			</div>
		
		
		
		
		
		
		
		
		
		
		
<!-- 			<div class="col l8 offset-l2 card-panel white z-depth-3" style="min-height:40vh" id="passwordboard"> -->
<!-- 				<div class="row"> -->
<%-- 					<h2 class="col l8 offset-l2 " style="font-family:微軟正黑體">活動地點<span>${Demand.activityTopic}</span></h2> --%>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<%-- 					<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">預計參與的學生人數<span>${Demand.participant}</span></h3> --%>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<%-- 					<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">活動適合對象<span>${Demand.activityLocation}</span></h3> --%>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<%-- 					<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">活動負責人<span>${Demand.activitySuitable}</span></h3> --%>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<%-- 					<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">負責人聯絡方式<span>${Demand.activityHost}</span></h3> --%>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<%-- 					<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">內容<span>${Demand.activityContact}</span></h3> --%>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<!-- 					<h3 class="col l8 offset-l2 " style="font-family:微軟正黑體">提供 -->
<%-- 					<span>住宿${Demand.offerBean.room}</span> --%>
<%-- 					<span>場地${Demand.offerBean.place}</span> --%>
<%-- 					<span>伙食${Demand.offerBean.food}</span> --%>
<!-- 					</h3> -->
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<%-- 					<button class="col l2 btn-large right black-text yellow lighten-5" type="submit" style="font-size:2em;"><a href="<c:url value='SchoolDemandServlet.do?type=updateDisplay' />">修改</a></button> --%>
<%-- 					<button class="col l2 btn-large right black-text yellow lighten-5" type="submit" style="font-size:2em;"><a href="<c:url value='SchoolDemandServlet.do?type=displays' />">完成</button> --%>
<!-- 				</div> -->
<!-- 			</div> -->
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
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
		})
	</script>
</body>
</html>