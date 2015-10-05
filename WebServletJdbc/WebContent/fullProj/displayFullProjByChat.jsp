<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>預覽完整計畫</title>
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
	#displayfulprojLimitImg img{
		max-width:100%;
	}

</style>
</head>
<body class="deep-orange lighten-5">
	<c:if test="${LoginOK.beanName.equals('member')}">
		<c:if test="${LoginOK.memberId != fullProj.memberId}">
			<c:redirect url="/error/permission.jsp" />
		</c:if>
	</c:if>

	<c:if test="${LoginOK.beanName.equals('school')}">
		<c:if test="${LoginOK.schoolId != fullProj.schoolId}">
			<c:redirect url="/error/permission.jsp" />
		</c:if>
	</c:if>
	<!-- 頁首 -->
	<c:import url="/template/header.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row black valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">預覽完整計畫</h1>
	</div>

	<!-- 內容 -->
	<main>
	<div class="row" id="mainboard">
		<!-- 第一列 -->
		<div class="row">
			<!-- 板向左偏離兩格 -->
			<div class="col l8 offset-l2">


				<!-- 固定資訊 -->
				<div class="card-panel hoverable row" style="background-color: #FFFCEC">
					<!-- 基本資訊 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white" style="background-color: #D1F0E5; font-size: 2em; font-weight: 900; font-family: 微軟正黑體">
							基本資訊
						</div>
					</div>
					<!-- 計畫編號 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">計畫編號</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									${fullProj.fullProjId}
								</div>
							</div>
						</div>
					</div>
					<!-- 計畫編號 -->



					<!-- 學校編號 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">學校編號</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									${fullProj.schoolId}
								</div>
							</div>
						</div>
					</div>
					<!-- 學校編號 -->



					<!-- 會員編號 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">會員編號</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div>${fullProj.memberId}</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 會員編號 -->

				</div>




				<!-- 計畫資訊 -->
				<div class="card-panel hoverable row head"
					style="background-color: #FFFCEC">

					<!-- 計畫資訊 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white" style="background-color: #D1F0E5; font-size: 2em; font-weight: 900; font-family: 微軟正黑體">
							計畫資訊
						</div>
					</div>
					<!-- 標題 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">計畫標題</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text" style="font-size:1.4em;">
									${fullProj.title}
								</div>
							</div>
						</div>
					</div>
					<!-- 標題 -->

					<!-- 活動地點 -->
					<div class="row">
						<div class="col l8 offset-l2">
							<div class="row">
								<div class="col l4 transparent black-text valign-wrapper">
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">活動地點</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div style="font-size:1.4em;">${fullProj.location}</div>
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
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">活動時間</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div style="font-size:1.4em;">
										<fmt:formatDate var="startTime" value="${fullProj.activityStartTime}" type="date" pattern="yyyy-MM-dd" />
										<fmt:formatDate var="endTime" value="${fullProj.activityEndTime}" type="date" pattern="yyyy-MM-dd" />
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
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">招募人數</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div style="font-size:1.4em;">${fullProj.estMember}</div>
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
									<h5 class="itemheader center-align" style="display: inline-block; margin: 0 auto;">活動預算</h5>
								</div>
								<div class="col l7 btn amber lighten-4 offset-l1 black-text">
									<div style="font-size:1.4em;">${fullProj.budget}</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 活動預算 -->

				</div>
				<!-- 成員架構 -->
				<div class="card-panel hoverable row"
					style="background-color: #FFFCEC">

					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white" style="background-color: #D1F0E5; font-size: 2em; font-weight: 900; font-family: 微軟正黑體">
							成員架構
						</div>
					</div>
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable" style="background-color: #D1F0E5;">
							<p style="font-family: 微軟正黑體; font-size: 1.4em; font-weight: 300;">
								${fullProj.orgArchitecture}
							</p>
						</div>
					</div>
				</div>
				<!-- 計畫摘要 -->
				<div class="card-panel hoverable row"
					style="background-color: #FFFCEC">

					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white" style="background-color: #D1F0E5; font-size: 2em; font-weight: 900; font-family: 微軟正黑體">
							計畫摘要
						</div>
					</div>
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable" style="background-color: #D1F0E5;">
							<p style="font-family: 微軟正黑體; font-size: 1.4em; font-weight: 300;">
								${fullProj.projAbstract}
							</p>
						</div>
					</div>
				</div>
				<!-- 計畫摘要 -->


				<!-- 計畫內容單獨一列 -->
				<div class="card-panel hoverable row"
					style="background-color: #FFFCEC">
					<!-- 計畫內容 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white" style="background-color: #D1F0E5; font-size: 2em; font-weight: 900; font-family: 微軟正黑體">
							完整計畫內容
						</div>
					</div>
					<!-- 計畫內容 -->
					<div class="row" id="displayfulprojLimitImg">
						<div class="col l8 offset-l2 card-panel hoverable" style="background-color: #D1F0E5;">
							<p style="font-family: 微軟正黑體; font-size: 1.4em; font-weight: 300;">
								${fullProj.content}
							</p>
						</div>
					</div>
				</div>

				<div class="card-panel hoverable row"
					style="background-color: #FFFCEC">
					<!-- 問與答 -->
					<div class="row">
						<div class="col l8 btn-large offset-l2 card-panel hoverable black-text white" style="background-color: #D1F0E5; font-size: 2em; font-weight: 900; font-family: 微軟正黑體">
							意見版
						</div>
					</div>
					<!-- 問與答 -->
					<div class="row">
						<div class="col l8 offset-l2 card-panel hoverable"  style="background-color:#D1F0E5;">
							<div id="discuss" class="card-panel white">
								<!-- 內容在jQuery -->
							</div>	
						</div>
					</div>
				</div>
			</div>
			<!-- 發問用按鈕 -->
			 <c:if test="${empty fullProj.createDate}">
				  <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
						<a href="#askmodal" id="askbtn" class="btn red white-text right" style="font-family:微軟正黑體;font-size:1.8em;font-weight:600">留言</a>
				  </div>
			  </c:if>
			<!-- 發問用按鈕 -->
			
			<!-- 提問用modal -->
			  <div id="askmodal" class="modal bottom-sheet" style="min-height:40vh;">
			    <div class="modal-content">
			      <h4 style="font-weight:600;font-famly:微軟正黑體;">我要<span class="red-text">留言</span>...</h4>
			      <textarea id="content" rows="10" cols="40" style="height:10em;" name=""></textarea>
			    </div>
			    <div class="modal-footer">
			   		<c:if test="${LoginOK.beanName.equals('school')}">
			      		<button id="schoolButton" class=" modal-action modal-close btn-large red white-text" type="button" style="font-size:1.6em;font-weight:600;">學校送出</button>
			     	</c:if>
			     	<c:if test="${LoginOK.beanName.equals('member')}">
			      		<button id="memberButton" class=" modal-action modal-close btn-large red white-text" type="button" style="font-size:1.6em;font-weight:600;">發起者送出</button>
			    	</c:if>
			    </div>
			  </div>			
			<!-- 提問用modal -->

			<!-- 按鈕版面 -->
			<div class="col l2">
				<!-- 學校同意按鈕 -->
				<c:if test="${LoginOK.beanName.equals('school')}">
					<c:if test="${empty fullProj.schoolConfirm}">
						<div class="card-panel white">
							<form action="<c:url value="/fullProj.do" />" method="post">
								<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}" /> 
								<input type="hidden" name="location" value="${fullProj.location}"> 
								<input type="hidden" name="orgArchitecture" value="${fullProj.orgArchitecture}"> 
								<input type="hidden" name="type" value="schoolConfirm">
								<button type="submit" class="btn-large white-text red" style="width: 100%; font-size: 1.5em; font-weight: 600; font-family: 微軟正黑體;">學校同意</button>
							</form>
						</div>
					</c:if>
				</c:if>

				<!-- 發起者發布按鈕 -->
				<c:if test="${LoginOK.beanName.equals('member')}">
					<c:if
						test="${empty fullProj.memberConfirm && fullProj.schoolConfirm == true}">
						<div class="card-panel white">
							<form action="<c:url value="/fullProj.do" />" method="post">
								<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}" /> 
								<input type="hidden" name="type" value="memberConfirm">
								<button type="submit" class="btn-large white-text red" style="width: 100%; font-size: 1.5em; font-weight: 600; font-family: 微軟正黑體;">計畫發布</button>
							</form>
						</div>
					</c:if>
				</c:if>


				<!-- 導向修改頁面，並且把這頁資料傳送過去 -->
				<c:if test="${LoginOK.beanName.equals('member')}">
					<c:if test="${LoginOK.memberId == fullProj.memberId && fullProj.projStatus.equals('洽談中') && empty fullProj.schoolConfirm}">
						<div class="card-panel white">
							<form action="<c:url value="/fullProj/updateFullProjForm.jsp" />" method="post" accept-charset="UTF-8">
								<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}"> 
								<input type="hidden" name="memberId" value="${fullProj.memberId}"> 
								<input type="hidden" name="schoolId" value="${fullProj.schoolId}"> 
								<input type="hidden" name="title" value="${fullProj.title}"> 
								<input type="hidden" name="location" value="${fullProj.location}"> 
								<input type="hidden" name="projAbstract" value="${fullProj.projAbstract}"> 
								<input type="hidden" name="content" value='${fullProj.content}'> 
								<input type="hidden" name="activityStartTime" value="<fmt:formatDate value="${fullProj.activityStartTime}" pattern="yyyy-MM-dd"/>">
								<input type="hidden" name="activityEndTime" value="<fmt:formatDate value="${fullProj.activityEndTime}" pattern="yyyy-MM-dd"/>">
								<input type="hidden" name="estMember" value="${fullProj.estMember}"> 
								<input type="hidden" name="budget" value="${fullProj.budget}"> 
								<input type="hidden" name="orgArchitecture" value='${fullProj.orgArchitecture}'> 
								<input type="hidden" name="base64String" value="${fullProj.base64String}">
								<button type="submit" class="btn-large white-text red" style="width: 100%; font-size: 1.5em; font-weight: 600; font-family: 微軟正黑體;">補齊計畫</button>
							</form>
						</div>
					</c:if>
				</c:if>
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
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>


	<script>
		// jQuery
		$(function(){
			<c:if test="${not empty sessionScope.schoolConfirm}">
				<c:remove var="schoolConfirm" scope="session"/>
				alert("發起者尚未補全計畫。");
			</c:if>
		});
		
		$(function(){
			displayMessage();
// 			var closeTimer = <fmt:formatDate value="${fullProj.createDate}" pattern="yyyy-MM-dd" />
			

			// 停計時器用 要再改 
// 			if(typeof(closeTimer) == void 0){
// 				var timer = setInterval(displayMessage,60000);
// 			}

	        
			$("#memberButton").on("click",function(){
				if($("#content").val().trim().length < 10) {
					alert("留言必須大於10個字");
				}
				else{
					addMemberMessage();
				}
			});
			
			$("#schoolButton").on("click",function(){
				if($("#content").val().trim().length < 10) {
					alert("留言必須大於10個字");
				}
				else{
					addSchoolMessage();
				}
			});
		
			function addMemberMessage(){
				$.ajax({
					"url": "<c:url value='/projModify.do' />",
					"type":"POST",
					"data":{"type":"addMember","fullProjId":"${fullProj.fullProjId}","memberId":"${fullProj.memberId}","content":$("#content").val()},
					"dataType" :"json",
					"success":function(data){
						displayMessage();
					}
				});
				$("#content").val("");
			}
			
			function addSchoolMessage(){
				$.ajax({
					"url": "<c:url value='/projModify.do' />",
					"type":"POST",
					"data":{"type":"addSchool","fullProjId":"${fullProj.fullProjId}","schoolId":"${fullProj.schoolId}","content":$("#content").val()},
					"dataType" :"json",
					"success":function(data){
						displayMessage();
					}
				});
				$("#content").val("");
			}
			
			function displayMessage(){
				$.ajax({
					"url": "<c:url value='/projModify.do' />",
					"type":"POST",
					"data":{"type":"display","fullProjId":"${fullProj.fullProjId}"},
					"dataType" :"json",
					"success":function(data){
						// data => Object
						// console.log(data);
						$("#discuss > div").remove();
						$.each(data.result,function(index,value){
							// data.result => Array[]
							// Array[index] => Object
							if(value.schoolId == "null"){
		 						var content = "<div class='col l2'>發起者</div>" + 
		 									  "<div class='col l10 card-panel' style='font-size:1.6em;font-weight:600;border-left:10px double #76ff03;'>" +
		 									  value.memberMessage + "</div>";
		 						var contentDiv = $("<div class='row'></div>").html(content);
		 						$("#discuss").append(contentDiv);
							}
						
							if(value.memberId == "null"){
								var content = "<div class='col l10 card-panel' style='font-size:1.6em;font-weight:600;border-right:10px double red;'>" + 
											   value.schoolMessage + "</div>" + 
											  "<div class='col l2'>學校</div>";
								var contentDiv = $("<div class='row'></div>").html(content);
								$("#discuss").append(contentDiv);
							}
						});
					}
				});
			}
		});
		
		$(function() {
			//註冊提問modal
			$("#askbtn").leanModal();
			//mainboard固定大小
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
</body>
</html>
