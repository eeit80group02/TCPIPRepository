<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayFullProj</title>
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body class="deep-orange lighten-5">
	<!-- 頁首 -->
	<c:import url="/template/header.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row black valign-wrapper" id="pagetitle">
		
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">${fullProj.title}</h1>
	</div>	

<!-- 內容 -->
<main>
	<div class="row" id="mainboard">

	
		<!-- 第一列 -->
		<div class="row">
			<div class="col l4 btn yellow lighten-3 black-text offset-l2">
				<fmt:formatNumber var="mid" value="${fullProj.memberId}" pattern="0000"/>
				<span style="font-family:微軟正黑體;font-size:1.5em;font-weight:600;width:100%;">發起者:${fullProj.memberBean.lastName}${fullProj.memberBean.firstName}[No.${mid}]</span>			
			</div>		
		</div>
		<!-- 第二列 -->
		<div class="row">
			<!-- 板向左偏離兩格 -->
			<div class="col l8 offset-l2">
				
				
				<!-- 雜項資訊 -->
				<div class="card-panel hoverable row" style="background-color:#FFFCEC">
					
					<!-- 活動資訊 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							活動資訊
						</div>
					</div>					
					<!-- 活動地點 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display:inline-block;margin:0 auto;">活動地點</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div>
									${fullProj.location}							
									</div>
								</div>
							</div>	
						</div>	
					</div>
					<!-- 活動地點 -->
					
					<!-- 活動時間 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display:inline-block;margin:0 auto;">活動時間</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div>
									<fmt:formatDate var="startTime" value="${fullProj.activityStartTime}"  type="date" pattern="yyyy-MM-dd" />
									<fmt:formatDate var="endTime" value="${fullProj.activityEndTime}"  type="date" pattern="yyyy-MM-dd" />									
									${startTime} ~ ${endTime}							
									</div>
								</div>
							</div>	
						</div>	
					</div>
					<!-- 活動時間 -->
					
					<!-- 招募人數 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display:inline-block;margin:0 auto;">招募人數</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div>
									${fn:length(fullProj.participatorMap.pass)}/${fullProj.estMember}							
									</div>
								</div>
							</div>	
						</div>	
					</div>
					<!-- 招募人數 -->
					
					<!-- 活動預算 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display:inline-block;margin:0 auto;">活動預算</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div>
									${fullProj.budget}							
									</div>
								</div>
							</div>	
						</div>	
					</div>					
					<!-- 活動預算 -->
				
				</div>
				<!-- GoogleMap -->
				<div class="card-panel hoverable row" style="background-color:#FFFCEC">
					
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							交通方式
						</div>
					</div>
					<!-- 這裡應該要塞googlemap -->					
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable"  style="background-color:#D1F0E5;height:500px;" id="googlemap">


						</div>
					</div>
				</div>
				<!-- 成員架構 -->
				<div class="card-panel hoverable row" style="background-color:#FFFCEC">
					
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							成員架構
						</div>
					</div>					
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable"  style="background-color:#D1F0E5;">
							<p style="font-family:微軟正黑體;font-size:1.4em;font-weight:300;">
							${fullProj.orgArchitecture}
							</p>
						</div>
					</div>
				</div>
				
								<!-- 計畫內容單獨一列 -->
				<div class="card-panel hoverable row" style="background-color:#FFFCEC">
					<!-- 計畫內容 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							完整計畫內容
						</div>
					</div>
					<!-- 計畫內容 -->
					<div class="row">
						<div class="col l12 card-panel hoverable"  style="background-color:#D1F0E5;">
							<p style="font-family:微軟正黑體;font-size:1.4em;font-weight:300;">
							${fullProj.content}
							</p>
						</div>
					</div>
				</div>



				<div class="card-panel hoverable row" style="background-color:#FFFCEC">
					<!-- 問與答 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							問與答
						</div>
					</div>

<!-- 					<div id="discuss" class="row"> -->

<!-- 					</div> -->
					<!-- 問與答 -->					
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable"  style="background-color:#D1F0E5;">
							<div class="card-panel white">
								
								<!-- 問題 -->
								<div class="row">
									<div class="col l2">
										<div class="btn red white-text">
											<i class="material-icons">textsms</i>
										</div>
									</div>
									<div class="col l10" style="font-size:1.6em;font-weight:600">
										要問的問題在這，如果這個問題真的十分可怕的非常長的跟長恨歌一樣的時候不知道會發生事情就來試試看
									</div>
								</div>
								<!-- 問題 -->
								<!-- 答案 -->
								<div class="row">
									<div class="col l2">
										<div class="btn green white-text">
											<i class="material-icons">chat_bubble</i>
										</div>
									</div>
									<div class="col l10" style="font-size:1.6em;font-weight:600">
										要回覆的答案在這裡，如果很長的時候不知道會不會很可怕不過不管它就是先嘗試就對了不知道會發生什麼樣的事情
									</div>
								</div>
								<!-- 答案 -->
							</div>	
						</div>
					</div>					
				</div>
			</div>
			
			<!-- 加入活動的按鈕 -->
			<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
				<!-- 檢查是否申請過 -->
				<c:if test="${LoginOK.beanName.equals('member')}">
					<c:set var="flag" value="false" />
					<c:forEach var="pending" items="${fullProj.participatorMap.pending}">
						<c:if test="${pending.memberId == LoginOK.memberId}">
							<c:set var="flag" value="true" />
						</c:if>
					</c:forEach>
					<c:forEach var="pass" items="${fullProj.participatorMap.pass}">
						<c:if test="${pass.memberId == LoginOK.memberId}">
							<c:set var="flag" value="true" />
						</c:if>
					</c:forEach>
				</c:if>
				
				<c:if test="${fn:length(fullProj.participatorMap.pass) == fullProj.estMember}">
					<c:set var="flag" value="true" />
				</c:if>
				<!-- 學校 或者 發起者看不到 -->
			    <c:if test="${not LoginOK.beanName.equals('school')}">
			    	<c:if test="${LoginOK.memberId != fullProj.memberId && not flag}">
					    <form id="participator" action="<c:url value="/participator.do" />" method="post">
							<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}">
							<input type="hidden" name="startTime" value="${startTime}">
							<input type="hidden" name="endTime" value="${endTime}">
							<input type="hidden" name="type" value="participate">
							<input id="participatorSubmit" class="btn-large white-text red accent-2" style="font-family:微軟正黑體;font-size:1.5em;width:100%" type="button" value="加入活動" >			
						</form>
			    	</c:if>
			    </c:if>
			</div>
			
			<div class="col l2">
				<form action="<c:url value="/draganddrop.jsp" />" method="get">
					<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}">
					<input class="btn-large white-text red accent-2" style="font-family:微軟正黑體;font-size:1.5em;width:100%" type="submit" value="任務板" >			
				</form>
			</div>
			
		</div>	
	</div>
</main>

	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁尾 -->

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	
	    <script>
	    	
	    	var fromJava = <%=request.getAttribute("googleMap")%>
// 	    	var jsonobj = JSON.parse(fromJava);
	    	console.log(fromJava.results[0].geometry.location.lng);
	    	console.log(fromJava.results[0].geometry.location.lat);
	    	
			function initMap() {
			  var directionsService = new google.maps.DirectionsService,
			  	  directionsDisplay = new google.maps.DirectionsRenderer,
			  	  centerlatlng = new google.maps.LatLng(23.317834,121.4510462);
			  var map = new google.maps.Map(document.getElementById('googlemap'), {
			    zoom: 14,
			    center: centerlatlng
			  });
			  
// 			  var nearbySearchService = new google.maps.places.PlacesService(map);
// 			  nearbySearchService.nearbySearch({
// 				  location:centerlatlng,
// 				  radius:
// 			  })
			  
			  calculateAndDisplayRoute(directionsService, directionsDisplay);
			  directionsDisplay.setMap(map);
			
			
			}
			
			function calculateAndDisplayRoute(directionsService, directionsDisplay) {
				
				var start = new google.maps.LatLng(25.0478642,121.5166395);
				var destination = new google.maps.LatLng(25.0469394,121.5150319);
			  directionsService.route({
			    origin: start,
			    destination: destination,
			    travelMode: google.maps.TravelMode.DRIVING
			  }, function(response, status) {
			    if (status === google.maps.DirectionsStatus.OK) {
			      directionsDisplay.setDirections(response);
			    } else {
			      window.alert('Directions request failed due to ' + status);
			    }
			  });
			}

    </script>
	
	
	
	
	
	
	
	<script>
// 	function initMap(){
		
// 		var scllocation = new google.maps.DirectionsService;
// 		var stationlocation = new google.maps.DirectionsRenderer;
// 		var centerCoordinate = new google.maps.LatLng(25.0464886,121.5172638);
// 		var mapdiv = new google.maps.Map(document.getElementById("googlemap"),{
// 				center:{lat: 25.0464886, lng: 121.5172638},
// 				zoom:17
// 			})
		
// 		var marker = new google.maps.Marker({
// 			position:centerCoordinate,
// 			title:"here is TPE Main Station"
// 		})
		
// 		marker.setMap(mapdiv);
// 	}
	</script>

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
		})
		
		$(function(){
			$("#participatorSubmit").on("click",function(){
				<c:choose>
					<c:when test="${empty LoginOK}">
						alert("你必須先登入會員");
					</c:when>
					<c:otherwise>
						$("#participator").submit();
					</c:otherwise>
				</c:choose>
			});
			
			<c:if test="${not empty sessionScope.success}">
				<c:remove var="success" scope="session"/>
				alert("已申請成功，等待發起者審核");
			</c:if>
			
			<c:if test="${not empty sessionScope.participate}">
    			<c:remove var="participate" scope="session"/>
				alert("此活動時間，亦有其他計畫進行中");
    		</c:if>
		});
		
// 		$(function(){
// 			displayMessage();
// 			function displayMessage(){
// 				$.ajax({
// 					"url": "<c:url value='/projDiscuss.do' />",
// 					"type":"POST",
// 					"data":{"type":"display","fullProjId":"${fullProj.fullProjId}"},
//  				"dataType" :"json",
// 					"success":function(data){
						// data => Object
// 						console.log(data);
// 						$("#discuss > div").remove();
// 						$.each(data.result,function(index,value){
							// data.result => Array[]
							// Array[index] => Object
							
// 	 						var memberContent = "<p style='font-family:微軟正黑體;font-size:1.4em;font-weight:300;'>" +
// 	 											value.questionMemberId + " 說:<br>" + 
// 		 									    value.questionMemberContent + "<br>" +
// 		  										"<div align='right'>" + value.questionMemberTime + "</div></p>" 
							// 可以正常跑
// 		  					<c:if test="${LoginOK.beanName.equals('member')}">
// 								<c:if test="${LoginOK.memberId == fullProj.memberId}">
// 									if(value.answerMemberId == "null"){
// 										console.log(value.projDiscusId);
// 										memberContent += "<div align='right'>" +
// 														 "<form action='<c:url value='/projDiscuss.do' />' method='post'>" +
// 														 "<input type='hidden' name='projDiscuss' value='" + value.projDiscusId + "'>" + 
// 														 "<input type='hidden' name='type' value='reply'>" + 
// 														 "<button type='submit' class='btn-large white-text red' style='width:100%;font-size:1.5em;font-weight:600;font-family:微軟正黑體;'>回覆</button></form></div>";
// 									}
// 								</c:if>
//  							</c:if>
		  										
// 	 						var contentDiv = $("<div class='col l12 card-panel hoverable' style='background-color:#D1F0E5;'></div>").html(memberContent);
// 	 						$("#discuss").append(contentDiv);
							
// 							if(value.memberId == "null"){
// 								var schoolContent = "學校ID:" + value.schoolId + "<br>" + 
// 	 												"留言:" + value.schoolMessage + "<br>" +
// 	  												"時間:" + value.schoolMessageTime + "<br>" + 
// 	  												"--------------------------------";
// 								var contentDiv = $("<div></div>").html(schoolContent);
// 								$("#discuss").append(contentDiv);
// 							}
// 						});
// 					}
// 				});
// 			}
// 		});
	</script>
	

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHkK5NA4vU8FN1pvxGhc-3eBut2VZ3RPs&callback=initMap"
        async defer></script>
</body>
</html>
