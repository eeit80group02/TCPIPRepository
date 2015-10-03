<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重新設定密碼</title>
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
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">重新設定密碼</h1>
	</div>
	<!-- 頁面主題提示 -->
	
	<!-- 內容 -->
<main>
	<!-- 主要版面 -->
	<div class="row valign-wrapper" id="mainboard">
		<div class="col l8 offset-l2 card-panel white z-depth-3" style="min-height:40vh" id="passwordboard">
			<div class="row">
				<h2 class="col l8 offset-l2 center-align" style="font-family:微軟正黑體">請填入新密碼</h2>
			</div>
			<form class="row offset-2" action="resetSuccess.do" method="post">
				<div class="row">
					<div class="col l8 offset-l2">
						<div class="row">
							<div style="font-size:2em;" class="col l4 blue-text right-align">密碼 : </div>
	         				<input id="pw1" type="password" class="col l8 validate" name = "password">
							<font color="red">${ErrMsg.pw1Err}</font>						
						</div>
						<div class="row">
							<div style="font-size:2em;" class="col l4 blue-text right-align">密碼確認 : </div>
	         				<input id="pw2" type="password" class="col l8 validate" name="check">
							<font color="red">${ErrMsg.pw2Err}</font>						
						</div>
	      			</div>					
				</div>
				<div class="row">
					<button class="col l2 btn-large right white-text red" type="submit" style="font-size:2em;">重設密碼</button>
				</div>

			</form>		
		</div>
	</div>		
<!-- 	<main> -->
<!-- 		<div class="row" style="margin-top: 100px"> -->
<!-- 			<div class="container" style="height: 500px;border: 2px solid black; "> -->
<!-- 				<div class="container"> -->
<!-- 					<form action="resetSuccess.do" method="post"> -->
<!-- 						<div class="input-field col s12" style="margin-top: 150px"> -->
<!-- 	          				<input id="pw1" type="password" class="validate" name = "password"> -->
<!-- 	         				<label for="pw1">密碼</label> -->
<%-- 							<font color="red" size="-1">${ErrMsg.pw1Err}</font> --%>
<!--         				</div> -->
<!--         				<div class="input-field col s12" > -->
<!-- 	          				<input id="pw2" type="password" class="validate" name="check"> -->
<!-- 	         				<label for="pw2">密碼確認</label> -->
<%-- 							<font color="red" size="-1">${ErrMsg.pw2Err}</font> --%>
<!--         				</div> -->
<!--         				<button type="submit" class="waves-effect waves-light btn">重設密碼</button> -->
<!-- 					</form> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</main>


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->
	



	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//mainboard最小高度
			$("#mainboard").css("min-height","80vh");
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
		})
	</script>
</body>
</html>