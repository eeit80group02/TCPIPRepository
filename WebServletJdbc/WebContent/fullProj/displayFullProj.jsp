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

<!-- 			<!-- 發問用按鈕 -->
<%-- 			<c:if test="${LoginOK.beanName.equals('member')}"> --%>
<%-- 				<c:if test="${LoginOK.memberId != fullProj.memberId}"> --%>
<!-- 					<div class="fixed-action-btn" style="bottom: 45px; right: 24px;"> -->
<!-- 						<a href="#askmodal" id="askbtn" class="btn red white-text right" style="font-family:微軟正黑體;font-size:1.8em;font-weight:600">提問</a> -->
<!-- 					</div> -->
<%-- 				</c:if> --%>
<%-- 			</c:if> --%>
<!-- 			<!-- 發問用按鈕 -->


				<div class="card-panel hoverable row" style="background-color:#FFFCEC">
					<!-- 問與答 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white"  style="background-color:#D1F0E5;font-size:2em;font-weight:900;font-family:微軟正黑體">
							問與答
						</div>
						<c:if test="${LoginOK.beanName.equals('member')}">
							<c:if test="${LoginOK.memberId != fullProj.memberId}">
								<div class="col l2 btn-large card-panel hoverable indigo darken-4"  style="background-color:#D1F0E5;font-size:1.6em;font-weight:600;font-family:微軟正黑體;width:15%;margin-left:10px;">
									<a href="#askmodal" id="askbtn" class="white-text center-align" >
										<i class="material-icons" style="font-size:1.5em;vertical-align:middle;">live_help</i>
										我要提問
									</a>
								</div>
							</c:if>
						</c:if>
					</div>

<!-- 					<div id="discuss" class="row"> -->

<!-- 					</div> -->
					<!-- 問與答 -->					
					<div class="row" id="questiondiv">
						<div class="col l8 offset-l2 card-panel hoverable"  style="background-color:#D1F0E5;">
							<div id="discuss" class="card-panel white">
							<!-- 內容在jQuery -->
								<!-- 問題 -->
								
								<!-- 問題 -->
								<!-- 答案 -->
<!-- 								<div class="row"> -->
<!-- 									<div class="col l2"> -->
<!-- 										<div class="btn green white-text"> -->
<!-- 											<i class="material-icons">chat_bubble</i> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 									<div class="col l10" style="font-size:1.6em;font-weight:600"> -->
<!-- 										要回覆的答案在這裡，如果很長的時候不知道會不會很可怕不過不管它就是先嘗試就對了不知道會發生什麼樣的事情 -->
<!-- 									</div> -->
<!-- 								</div> -->
								<!-- 答案 -->

								<div class="row">
									<a href="#replymodal" id="replybtn" class="col l2 btn-large right black-text center-align  green accent-1" style="font-size:1.5em;font-weight:600;font-family:微軟正黑體;">
										<i class="material-icons black-text" style="font-size:1.5em;vertical-align:bottom;">input</i>
										回覆 
									</a>
								</div>
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
<!-- 					<input class="btn-large white-text blue darken-1 accent-2" style="font-family:微軟正黑體;font-size:2em;width:100%" type="submit" value="任務板" >			 -->
					<button type="submit" class="btn-large black-text  light-blue lighten-3" style="font-family:微軟正黑體;font-size:2em;width:100%">
						<i class="material-icons orange-text" style="font-size:1.5em;vertical-align:middle;">view_week</i>
						任務板
					</button>
					
				</form>
			</div>
			
		</div>	
	</div>
</main>


			
			<!-- 回覆用modal -->
			  <div id="replymodal" class="modal bottom-sheet" style="min-height:40vh;">
			    <div class="modal-content">
			      <h4 style="font-weight:600;font-famly:微軟正黑體;">我的<span class="red-text">回覆</span>是...</h4>
			      <textarea id="relpyContent" rows="10" cols="40" style="height:10em;" name=""></textarea>
			    </div>
			    <div class="modal-footer">
			      <button class=" modal-action modal-close btn-large red white-text" type="submit" style="font-size:1.6em;font-weight:600;">送出</button>
			    </div>
			  </div>			
			<!-- 回覆用modal -->
			<!-- 提問用modal -->
			  <div id="askmodal" class="modal bottom-sheet" style="min-height:40vh;">
			    <div class="modal-content">
			      <h4 style="font-weight:600;font-famly:微軟正黑體;">我的<span class="red-text">問題</span>是...</h4>
			      <textarea id="content" rows="10" cols="40" style="height:10em;" name=""></textarea>
			    </div>
			    <div class="modal-footer">
			      <button id="ask" class=" modal-action modal-close btn-large red white-text" type="button" style="font-size:1.6em;font-weight:600;">送出</button>
			    </div>
			  </div>			
			<!-- 提問用modal -->


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁尾 -->

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	
	
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
			//leanModal註冊
			$("#askbtn").leanModal();
			$("#replybtn").leanModal();
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
		
		$(function(){
			displayMessage();

			$("#ask").on("click",function(){
				if($("#content").val().trim().length < 10){
					alert("留言必須大於10個字");
				}else{
					postMessage();
					$("#content").val("");
				}
			});
			
			function postMessage(){
				$.ajax({
					"url":"<c:url value='/projDiscuss.do' />",
					"type":"POST",
					"data":{"type":"post","fullProjId":"${fullProj.fullProjId}","content":$("#content").val()},
					"dataType" :"json",
					"success":function(data){
						displayMessage();
					}
				});
			}
			function displayMessage(){
				$.ajax({
					"url":"<c:url value='/projDiscuss.do' />",
					"type":"POST",
					"data":{"type":"display","fullProjId":"${fullProj.fullProjId}"},
 					"dataType" :"json",
					"success":function(data){
					 // data => Object
					 // console.log(data);
// 						$("#discuss > div").remove();
						$.each(data.result,function(index,value){
// 							data.result => Array[]
// 							Array[index] => Object
							
	 						var content = "<div class='col l2'><div class='btn red white-text'>" +
	 									  "<i class='material-icons'>textsms</i></div></div>" +
	 									  "<div class='col l10' style='font-size:1.6em;font-weight:600'>" +
	 									   value.questionMember + " 問:<br>" + 
		 								   value.questionMemberContent + "<br>" +
		  								  "<div align='right'><small>" + value.questionMemberTime + "</small></div></div>";
		  					
		  					if(value.answerMemberId == "null"){
		  						content += "<a href='#replymodal' id='projDiscuss" + value.projDiscussId + "' class='col l2 btn-large right black-text center-align  green accent-1 btnmodal' style='font-size:1.5em;font-weight:600;font-family:微軟正黑體;'>" + 
		  						           "<i class='material-icons black-text' style='font-size:1.5em;vertical-align:bottom;'>input</i>回覆</a>";
// 		  						           console.log($(content));
// 		  						         $(content).children("a");
								
								$(".btnmodal").click(function(){
									$("#replymodal").openModal();
								})
								
								$("body").click(function(){
									$("#replymodal").closeModal();
								});
		  					}else{
		  						content += "<div class='col l2'><div class='btn green white-text'>" +
						           		   "<i class='material-icons'>chat_bubble</i></div></div>" +
								   		   "<div class='col l10' style='font-size:1.6em;font-weight:600'> " +
								   			value.answerMember + " 答:<br>" + 
								     		value.answerMemberContent + "<br>" +
  								  		   "<div align='right'><small>" + value.answerMemberTime + "</small></div></div>";
		  					}
		  								   
// 		 									if(value.answerMemberId == "null"){
// 	 										console.log(value.projDiscusId);
// 	 										memberContent += "<div align='right'>" +
// 	 														 "<form action='<c:url value='/projDiscuss.do' />' method='post'>" +
// 	 														 "<input type='hidden' name='projDiscuss' value='" + value.projDiscusId + "'>" + 
// 	 														 "<input type='hidden' name='type' value='reply'>" + 
// 	 														 "<button type='submit' class='btn-large white-text red' style='width:100%;font-size:1.5em;font-weight:600;font-family:微軟正黑體;'>回覆</button></form></div>";
// 	 									}
// 		  					 console.log($("#projDiscuss" + value.projDiscussId));
		  								   
	 						var contentDiv = $("<div class='row'></div>").html(content);
	 						$("#discuss").append(contentDiv);
		  															
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
		  										
							

						});
					}
				});
			}
		});
	</script>
	    <script>
	    	
	    	var fromJava = <%=request.getAttribute("googleMap")%>
	    	
			function initMap() {
			  var directionsService = new google.maps.DirectionsService,
			  	  directionsDisplay = new google.maps.DirectionsRenderer,
			  	  centerlatlng = new google.maps.LatLng(fromJava.fulprojLocation.lat,fromJava.fulprojLocation.lng);
			  var map = new google.maps.Map(document.getElementById('googlemap'), {
			    zoom: 17,
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
				
				var start = new google.maps.LatLng(fromJava.fulprojLocation.lat,fromJava.fulprojLocation.lng);
				var destination = new google.maps.LatLng(fromJava.closestStation.lat,fromJava.closestStation.lng);
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
	

	<script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
        async defer></script>
</body>
</html>
