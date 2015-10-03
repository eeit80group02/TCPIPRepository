<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
	.btndiv {
			 
	}

</style>
</head>
<body class="deep-orange lighten-5">
	<!-- 頁首 -->
	<c:import url="/template/header.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->

	<!-- 內容 -->
	<main>

	<div class="row" id="mainboard">
		  	
		  	
		  	<div class="col l8 offset-l2" style="margin-top:5em;">
			  	<ul class="tabs" id="tabs2">
			        <li class="tab col l3"><a href="#test3" id="member2" class="blue lighten-5 black-text active" style="font-family:微軟正黑體;font-weight:600">一般會員</a></li>
			        <li class="tab col l3"><a href="#test4" id="school2" class="black-text" style="font-family:微軟正黑體;font-weight:600">學校會員</a></li>
		      	</ul>
			</div>

			<!-- 一般會員登入 -->
			<div class="col l8 offset-l2 card-panel white z-depth-3 valign-wrapper blue lighten-5" style="min-height:50vh;" id="test3">
				<c:if test="${not empty sessionScope.timeOut}">
					${sessionScope.timeOut}
				</c:if>
				<div class="col l8 offset-l2" >
					<form action="<c:url value="/LoginServlet.do" />" method="post">
						<div class="row">
							<div class="row" style="font-family:微軟正黑體;font-size:2em;">帳號</div>
							<input class="row" type="text" name="account"  value="${param.account}" style="font-family:微軟正黑體;font-size:1.5em;" /><span class="error" style="color:red;">${error.account}</span>
						</div>
						<div class="row">
							<div class="row" style="font-family:微軟正黑體;font-size:2em;">密碼</div>
							<input class="row" type="password" name="password" value="${param.password}"  style="font-family:微軟正黑體;font-size:1.5em;" /><span class="error" style="color:red;">${error.password}</span>
						</div>
						<input type="hidden" name="type" value="member">
						<div class="row"  style="font-family:微軟正黑體;font-size:1.3em;font-weight:600;">
							<button type="submit" class="btn-large amber darken-2 white-text right" style="font-family:微軟正黑體;font-size:1.2em;font-weight:600;">登入</button>
							<a href="<c:url value="/forgotPassword/forgotPassword.jsp" />" class="btn-large amber darken-2 white-text right">忘記密碼</a>	      
						    <a href="<c:url value="/register/register.jsp" />" class="btn-large amber darken-2 white-text right">註冊帳號</a>						
						</div>

					</form>				
				</div>
			</div>
			
			<!-- 學校登入 -->			
			<div class="col l8 offset-l2 card-panel white z-depth-3 valign-wrapper deep-purple lighten-4" style="min-height:50vh;" id="test4">
				<c:if test="${not empty sessionScope.timeOut}">
					${sessionScope.timeOut}
				</c:if>				
				<div class="col l8 offset-l2" >
					<form action="<c:url value="/LoginServlet.do" />" method="post">
						<div class="row">
							<div class="row" style="font-family:微軟正黑體;font-size:2em;">學校帳號</div>
							<input class="row" type="text" name="account"  value="${param.account}" style="font-family:微軟正黑體;font-size:1.5em;" /><span class="error" style="color:red;">${error.account}</span>
						</div>
						<div class="row">
							<div class="row" style="font-family:微軟正黑體;font-size:2em;">學校密碼</div>
							<input class="row" type="password" name="password" value="${param.password}"  style="font-family:微軟正黑體;font-size:1.5em;" /><span class="error" style="color:red;">${error.password}</span>
						</div>
						<input type="hidden" name="type" value="school">
						<div class="row">
							<button type="submit" class="btn-large amber darken-2 white-text right" style="font-family:微軟正黑體;font-size:1.5em;font-weight:600;margin:0">登入</button>
							<button class="btn-large amber darken-2 white-text right" style="font-family:微軟正黑體;font-size:1.5em;font-weight:600;">開通帳號</button>
						</div>
						
					</form>				
				</div>
			</div>

	</div>		
	
	
	
<%-- 		<c:if test="${not empty sessionScope.timeOut}"> --%>
<%-- 			${sessionScope.timeOut} --%>
<%-- 		</c:if> --%>
		
<%-- 		<form action="<c:url value="/LoginServlet.do" />" method="post"> --%>
<%-- 			帳號<input type="text" name="account"  value="${param.account}" /><span class="error">${error.account}</span><br> --%>
<%-- 			密碼<input type="text" name="password" value="${param.password}" /><span class="error">${error.password}</span><br> --%>
<!-- 				<input type="hidden" name="type" value="member"><br> -->
<!-- 				<input type="submit" value="登入"><br> -->
<!-- 		</form> -->
<!-- 		<hr> -->
<!-- 		下面為學校登入<br> -->
<%-- 		<c:if test="${not empty sessionScope.timeOut}"> --%>
<%-- 			${sessionScope.timeOut} --%>
<%-- 		</c:if> --%>
<%-- 		<form action="<c:url value="/LoginServlet.do" />" method="post"> --%>
<%-- 			帳號<input type="text" name="account"  value="${param.account}" /><span class="error">${error.account}</span><br> --%>
<%-- 			密碼<input type="text" name="password" value="${param.password}" /><span class="error">${error.password}</span><br> --%>
<!-- 				<input type="hidden" name="type" value="school"><br> -->
<!-- 				<input type="submit" value="登入"><br> -->
<!-- 		</form> -->
	</main>


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp"
		context="${pageContext.request.contextPath}" />
	<!-- 頁尾 -->


	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>

	
	
	<script>
		$(function() {
			//註冊tabs事件
			$("#tabs2").tabs();
			//mainboard最小高度
			$("#mainboard").css("min-height","100vh");
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			//選定登入角色時變色
			$("#tabs2").on("click",function(){
				if($("#member2").hasClass("active")){
					$("#member2").addClass("blue lighten-5")
					if($("#school2").hasClass("deep-purple lighten-4")){
						$("#school2").removeClass("deep-purple lighten-4")
					}
				}else if($("#school2").hasClass("active")){
					$("#school2").addClass("deep-purple lighten-4")
					if($("#member2").hasClass("blue lighten-5")){
						$("#member2").removeClass("blue lighten-5")
					}
				}
			})
			
			//另個變色
			$("#school2").on("click",function(){
				if($("#member2").hasClass("blue lighten-5")){
					console.log("hahaha")
					$("#member2").removeClass("blue lighten-5");
				}
			})
			
		})
	</script>
</body>
</html>