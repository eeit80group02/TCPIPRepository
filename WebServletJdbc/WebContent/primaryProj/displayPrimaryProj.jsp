<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>displayPrimaryProj</title>
<style>
		.frontImg {
			width:310px;
			height:210px;
		}
		
		.itemheader {
			font-family:微軟正黑體;
			font-size:1.4em;
			font-weight:300;
			width:100%;
		}
</style>
</head>
<body class="light-blue lighten-5">

	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->
	
	
	<!-- 頁面主題提示 -->
	<div class="row  light-blue darken-4 valign-wrapper" id="pagetitle">
		
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">初步計畫名稱${primaryProj.title}</h1>
	</div>	
	
	
	<!-- 主要內容 -->
	<main>
	
	<!-- 主要版面 -->
	<div class="row">
		<!-- 第一列 -->
		<div class="row">
			<div class="col l2 btn yellow lighten-3 black-text offset-l2">
				<span style="font-family:微軟正黑體;font-size:1.5em;font-weight:600;width:100%;">發起者:${primaryProj.memberId}</span>			
			</div>		
		</div>
		<!-- 第二列 -->
		<div class="row">
			<!-- 板向左偏離兩格 -->
			<div class="col l8 offset-l2">
				<!-- 圖跟摘要在同一列 -->
				<div class="row card-panel hoverable" style="background-color:#F4F3DE;">
					<!-- 摘要 -->
					<div class="col l8 card-panel hoverable offset-l2" style="background-color:#D1F0E5;font-family:微軟正黑體;font-size:1.2em;font-weight:300;">
							感謝大家的支持，讓我們在3天內即達成目標接下來我們也開放大家加購鏡頭跟手工皮革手腕繩（黑／淺駝）請想要加購的朋友們直接在右邊的贊助選項中點選你想加購的品項我們會連同您原本贊助的品項一同寄出！
							${primaryProj.projAbstract}
					</div>
				</div>
				
				<!-- 計畫內容單獨一列 -->
				<div class="card-panel hoverable row" style="background-color:#F4F3DE">
					<!-- 計畫內容 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							初步計畫內容
						</div>
					</div>
					<!-- 計畫內容 -->
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable"  style="background-color:#D1F0E5;">
							<p style="font-family:微軟正黑體;font-size:1.4em;font-weight:300;">
							我們是社團法人台灣防止虐待動物協會 TSPCA，今年三月初接獲民眾通報，台中后里區有一隻被囚禁 30 多年的保育類動物馬來熊，我們赴當地調查後並將牠帶出，提供最適合牠的生活環境及專業照護讓牠可以安心養老，但由於這筆照護費用高達新台幣十萬元將由協會完全負擔，在資金缺乏的情況下，希望可由此專案透過大家的力量知道馬來熊小黑的故事，一起幫助這條無辜的生命，讓牠感受自己生命的價值。
							${primaryProj.content}
							</p>
						</div>
					</div>
				</div>
				
				<!-- 雜項資訊 -->
				<div class="card-panel hoverable row" style="background-color:#F4F3DE">
					
					<!-- 理想地點 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 btn amber darken-3 black-text">
									<span class="itemheader">理想地點</span>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1">
									<div>
									${primaryProj.idealPlace}							
									</div>
								</div>
							</div>	
						</div>	
					</div>
					<!-- 理想地點 -->
					
					<!-- 活動時間 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 btn amber darken-3 black-text itemhedaer">
									<span class="itemheader">活動時間</span>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1">
									<div>
									<fmt:formatDate var="startTime" value="${primaryProj.activityStartTime}"  type="date" pattern="yyyy-MM-dd" />
									<fmt:formatDate var="endTime" value="${primaryProj.activityEndTime}"  type="date" pattern="yyyy-MM-dd" />									
									${startTime} ~ ${endTime}							
									</div>
								</div>
							</div>	
						</div>	
					</div>
					<!-- 活動時間 -->
					
					<!-- 活動預計人數 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 btn amber darken-3 black-text itemhedaer">
									<span class="itemheader">活動預計人數</span>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1">
									<div>
									${primaryProj.demandNum}							
									</div>
								</div>
							</div>	
						</div>	
					</div>
					<!-- 活動預計人數 -->
					
					<!-- 活動預算 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 btn amber darken-3 black-text itemhedaer">
									<span class="itemheader">活動預算</span>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1">
									<div>
									${primaryProj.budget}							
									</div>
								</div>
							</div>	
						</div>	
					</div>					
					<!-- 活動預算 -->
				
				</div>
			</div>
			<div class="col l2">
				<c:set var="deadline" value="900000" />
				<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set> 
				<!-- 	檢查 登入者是否學校 -->
					<c:if test="${LoginOK.beanName.equals('school')}">
						<form action="<c:url value="/ProcessingProj.do" />" method="post">
							<input type="hidden" name="schoolId" value="${LoginOK.schoolId}">
							<input type="hidden" name="primaryProjId" value="${primaryProj.primaryProjId}">
							<input type="hidden" name="type" value="apply">
							<input class="btn-large white-text red accent-2" style="font-family:微軟正黑體;font-size:1.5em;width:100%" type="submit" value="申請計畫洽談" >
						</form>
					</c:if>
					
					<c:if test="${LoginOK.beanName.equals('member')}">
						<c:if test="${LoginOK.memberId == primaryProj.memberId && (primaryProj.createDate.time + deadline) - nowDate > 0}">
							<form action="<c:url value="/primaryProj.do" />" method="post">
								<input type="hidden" name="type" value="displayUpdate">
								<input type="hidden" name="primaryProjId" value="${primaryProj.primaryProjId}">
								<input class="btn-large white-text red accent-2" type="submit" value="修改" style="font-family:微軟正黑體;font-size:1.5em;width:100%;">
							</form>
						</c:if>
					</c:if>			

			</div>
		</div>
	
	</div>
	<!-- 主要版面 -->
	
	</main>
	<!-- 主要內容 -->	
	
	
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
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
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