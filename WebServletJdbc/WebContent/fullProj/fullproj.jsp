<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<body class="deep-orange lighten-5">
	<!-- 頁首 -->
 <header> 
 	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
 <!--頁首  -->
<!-- <nav> -->
<!-- 	<div class="nav-wrapper grey darken-3"> -->
<!-- 		<a href="#!" class="brand-logo"> <img alt="TCPIP" title="TCPIP" -->
<%-- 			src="${pageContext.request.contextPath}/picture/LOGO.PNG" /> --%>
<!-- 		</a> -->


<!-- 		<ul class="right hide-on-med-and-down" style="font-size:1.5em;"> -->
<!-- 			<li><a href="sass.html">瀏覽</a></li> -->
<!-- 			<li><a href="badges.html">捐贈</a></li> -->
<!-- 			<li><a href="#modal1" class="modal-trigger">登入</a></li> -->
<!-- 			<li><a href="#!"><i class="material-icons">search</i></a></li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
<!-- 	</nav> -->
</header>
  
 <!-- 登入用modal --> 
<!--   <div id="modal1" class="modal modal-fixed-footer" style="height:800px;"> -->
<!--     <div class="modal-content blue lighten-5" style="width:100%;"> -->
<!--     	<div class="row" style="margin-top:0px;"> -->
<!-- 	      <h4 class="center-align" style="font-family:微軟正黑體;font-weight:600;">登入TCPIP</h4> -->
<!-- 	    </div> -->
<!-- 	    <div class="divider"></div> -->
<!-- 			    <div style="width:60%;margin:0 auto;">   -->
<!-- 			      <form class="col l6 offset-l3"> -->
<!-- 			      	<div class="input-field" style="margin-top:10%;"> -->
<!-- 			          	<input id="account" type="text" class="validate"> -->
<!-- 			          	<label for="account" style="font-size:1.5em;">帳號</label> -->
<!-- 		        	</div> -->
<!-- 		        	<div class="input-field"> -->
<!-- 				         <input id="password" type="password" class="validate"> -->
<!-- 				         <label for="password" style="font-size:1.5em;">密碼</label> -->
<!-- 		        	</div> -->
<!-- 			      </form> -->
<!-- 		    	</div> -->
<!--     </div> -->
<!--     <div class="modal-footer blue lighten-5 valign-wrapper" style="height:20%;"> -->
<!--     	<div class="row valign"> -->
<!-- 	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn ">登入</a> -->
<!-- 	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn ">忘記密碼</a> -->
<!-- 	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn ">註冊帳號</a> -->
<!--     	</div> -->
<!--     </div> -->
<!--   </div> -->

	
	
	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">募集資訊</h1>
	</div>
	
	
	<!-- 內容 -->
	<main>
	<div class="row">
		<!-- 側邊篩選條件欄 -->
		<div class="col l3 offset-l1 z-depth-3 hide-on-med-and-down"
			style="position: absolute; top: 166; padding: 0" id="sidebar">
			<div class="collection"
				style="margin: 0 auto; font-family: 微軟正黑體; font-weight: 900;">
				<ul style="margin: 0;">
					<li class="collection-header collection-item center-align"
						style="padding: 0;"><h5 class="teal accent-2"
							style="margin: 0; display: block; padding: 15px 0 15px 0;">排序</h5></li>
					<li><a href="#!" class="collection-item">即將結束</a></li>
					<li><a href="#!" class="collection-item">活動時間</a></li>
					<li><a href="#!" class="collection-item">需求人數</a></li>
					<li><a href="#!" class="collection-item">已募集人數</a></li>
				</ul>
			</div>
			<div class="collection"
				style="margin: 0 auto; font-family: 微軟正黑體; font-weight: 900;">
				<ul style="margin: 0;">
					<!-- 提示[篩選] -->
					<li class="collection-header collection-item center-align"
						style="padding: 0;"><h5 class="teal accent-2"
							style="margin: 0; display: block; padding: 15px 0 15px 0;">篩選</h5></li>
					<li><a href="#!" class="collection-item">北部地區</a></li>
					<li><a href="#!" class="collection-item">中部地區</a></li>
					<li><a href="#!" class="collection-item">南部地區</a></li>
					<li><a href="#!" class="collection-item">東部地區</a></li>
				</ul>
			</div>
		</div>
		<!-- </div> -->

		
			
		
		<!-- 募集活動列表 -->
		<div class="col l8 offset-l4" id="projlist">
			<!-- 卡片列區塊的container -->
			<div class="centerdiv">
			<c:forEach var="fullProj" items="${fullProjAll}">
				<!-- 卡片1 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('${fullProj.base64String}'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">${fullProj.title}</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/${fullProj.estMember}</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
      						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      							<p style="height:55%">${fullProj.projAbstract}</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>
					</div>
				</div>
			</c:forEach>
<!-- 				卡片2 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj2.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">讓醫院充滿笑聲:紅鼻子醫生計畫</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				卡片3 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj3.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">歡迎回家【小花門裏門外家寫真】</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

			</div>



			<!-- 	卡片列2 -->

<!-- 			<div class="centerdiv"> -->
<!-- 				卡片1 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj4.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">「來自小漁村的台灣代表隊」-國際參賽</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->


<!-- 				卡片2 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj5.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">【一趟重量不減的旅程 - -->
<!-- 								把愛找回來紀錄片】</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--        						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

				<!-- 卡片3 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj6.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 													<img src="${pageContext.request.contextPath}/picture/DEMO_Proj3.PNG"> -->
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">悅讀晨光－與一群孩子的午後約定</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 			</div> -->
			
<!-- 			<div class="centerdiv"> -->
				<!-- 卡片1 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">上學真好，部落孩子攜手教學計劃</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       							<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div> -->
<!-- 					</div> -->
<!-- 				</div> -->


				<!-- 卡片2 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj2.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">讓醫院充滿笑聲:紅鼻子醫生計畫</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

				<!-- 卡片3 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj3.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">歡迎回家【小花門裏門外家寫真】</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 			</div> -->



			<!-- 	卡片列2 -->

<!-- 			<div class="centerdiv"> -->
<!-- 				卡片1 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj4.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">「來自小漁村的台灣代表隊」-國際參賽</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->


<!-- 				卡片2 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj5.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">【一趟重量不減的旅程 - -->
<!-- 								把愛找回來紀錄片】</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--        						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				卡片3 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj6.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 													<img src="${pageContext.request.contextPath}/picture/DEMO_Proj3.PNG"> -->
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">悅讀晨光－與一群孩子的午後約定</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 			</div> -->
			
<!-- 						<div class="centerdiv"> -->
<!-- 				卡片1 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">上學真好，部落孩子攜手教學計劃</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       							<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div> -->
<!-- 					</div> -->
<!-- 				</div> -->


<!-- 				卡片2 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj2.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">讓醫院充滿笑聲:紅鼻子醫生計畫</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				卡片3 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj3.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">歡迎回家【小花門裏門外家寫真】</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 			</div> -->



			<!-- 	卡片列2 -->

<!-- 			<div class="centerdiv"> -->
<!-- 				卡片1 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj4.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">「來自小漁村的台灣代表隊」-國際參賽</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->


<!-- 				卡片2 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj5.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">【一趟重量不減的旅程 - -->
<!-- 								把愛找回來紀錄片】</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--        						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				卡片3 -->
<!-- 				<div class="touche"> -->
<!-- 					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px"> -->
<!-- 						<div class="card-image activator" -->
<%-- 							style="background-image: url('${pageContext.request.contextPath}/picture/DEMO_Proj6.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;"> --%>
<!-- 													<img src="${pageContext.request.contextPath}/picture/DEMO_Proj3.PNG"> -->
<!-- 						</div> -->
<!-- 						<div class="card-content"> -->
<!-- 							<p style="font-size: 20pt" class="truncate">悅讀晨光－與一群孩子的午後約定</p> -->
<!-- 						</div> -->
<!-- 						<div class="card-action right-align"> -->
<!-- 							<span>需求人數:10/20</span> -->
<!-- 						</div> -->
<!-- 						<div class="card-reveal lime lighten-5" style="height:100%"> -->
<!--       						<span class="card-title grey-text text-darken-4" style="height:15%"> -->
<!--       						計畫摘要 -->
<!-- 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
<!-- 	      						Follow -->
<!-- 	      						</span> -->
<!--       						</span> -->
<!--       						<div class="divider"></div> -->
<!--       						<p style="height:55%">摘要內容</p> -->
<!--       						<div class="divider"></div> -->
<!--       						<div class="center-align"> -->
<!-- 								<a href="#"><h5>more...</h5></a> -->
<!-- 							</div> -->
<!--     					</div>					 -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 			</div>	 -->

				<!-- 卡片列區塊的container -->
		</div>
	</div>
	</main>


	<!-- 頁尾 -->
	<footer>
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	</footer>
<!-- 	<footer class="page-footer grey darken-4" -->
<!-- 		style="clear:both;margin:100px 0 0 0;"> -->
<!-- 	<div class="container"> -->
<!-- 		<!-- footer上半部的container --> -->
<!-- 		<!-- footer左半邊 --> -->
<!-- 		<div> -->
<!-- 			<h2 class="blue-text text-darken-2 left" -->
<!-- 				style="display: inline; margin: 0 10px 0 5px;">TCPIP</h2> -->
<!-- 			<div class="left" id="taiwan"> -->
<!-- 				<p class="grey-text text-lighten-4 ">Taiwan Camp’s Project -->
<!-- 					Innovation Platform</p> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="right" style="color: white;"> -->
<!-- 			<h2 class="blue-text text-darken-2 left" -->
<!-- 				style="display: inline; margin: 0 10px 0 5px;">LINKS</h2> -->
<!-- 			<div class="left"> -->
<!-- 				<a class="grey-text text-lighten-3" href="https://www.flyingv.cc/">FlingV</a><br /> -->
<!-- 				<a class="grey-text text-lighten-3" href="http://www.indievox.com/">iNDIEVOX</a><br /> -->
<!-- 				<a class="grey-text text-lighten-3" href="http://www.elivtw.com/">以立國際服務</a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<!-- footer下半部的container --> -->
<!-- 		<div class="footer-copyright valign-wrapper" style="clear: both;"> -->
<!-- 			<div class="container center-align">台灣志願服務營隊計畫創新平台 © 2015 -->
<!-- 				Copyright</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	</footer> -->



	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		$(function() {
			//固定側邊欄所在位置
			$(window).on("scroll", function() {
				if ($(this).scrollTop() <= $("#projlist").position().top) {
					$("#sidebar").css({
						"position" : "absolute",
						"top" : $("#projlist").position().top
					});
				} else {
					$("#sidebar").css({
						"position" : "fixed",
						"top" : 0
					});
				}
			})
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//註冊modal事件
			$(".modal-trigger").leanModal();
			//觸發卡片翻轉事件
			$(".touche").each(function() {
				$(this).mouseover(function() {
					$(".activator", this).trigger("click");
				})
				$(this).mouseout(function() {
					$(".card-title", this).trigger("click");
				})
			})
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//提示區塊的按鈕
			$(".projinfos").css("margin", "0px auto");
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