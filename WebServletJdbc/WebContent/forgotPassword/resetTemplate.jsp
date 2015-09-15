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
<header> <!-- 頁首 --> <nav>
	<div class="nav-wrapper grey darken-3">
		<a href="#!" class="brand-logo"> <img alt="TCPIP" title="TCPIP"
			src="../picture/LOGO.PNG" />
		</a>


		<ul class="right hide-on-med-and-down" style="font-size:1.5em;">
			<li><a href="sass.html">瀏覽</a></li>
			<li><a href="badges.html">捐贈</a></li>
			<li><a href="#modal1" class="modal-trigger">登入</a></li>
			<li><a href="#!"><i class="material-icons">search</i></a></li>
		</ul>
	</div>
	</nav>
</header>
  
 <!-- 登入用modal --> 
  <div id="modal1" class="modal modal-fixed-footer" style="height:800px;">
    <div class="modal-content blue lighten-5" style="width:100%;">
    	<div class="row" style="margin-top:0px;">
	      <h4 class="center-align" style="font-family:微軟正黑體;font-weight:600;">登入TCPIP</h4>
	    </div>
	    <div class="divider"></div>
			    <div style="width:60%;margin:0 auto;">  
			      <form class="col l6 offset-l3">
			      	<div class="input-field" style="margin-top:10%;">
			          	<input id="account" type="text" class="validate">
			          	<label for="account" style="font-size:1.5em;">帳號</label>
		        	</div>
		        	<div class="input-field">
				         <input id="password" type="password" class="validate">
				         <label for="password" style="font-size:1.5em;">密碼</label>
		        	</div>
			      </form>
		    	</div>
    </div>
    <div class="modal-footer blue lighten-5 valign-wrapper" style="height:20%;">
    	<div class="row valign">
	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn ">登入</a>
	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn ">忘記密碼</a>
	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn ">註冊帳號</a>
    	</div>
    </div>
  </div>
	
	<!-- 內容 -->
	<main>
		<div class="row" style="margin-top: 100px">
			<div class="container" style="height: 500px;border: 2px solid black;">
				<div style="margin: 150px">
					<span></span>
					<h3>親愛的會員您密碼已重設成功,本網頁將於數秒後跳轉回主頁面</h3>
					<a href="index.jsp">如果未自動轉移轉移請點</a>
				</div>
			</div>
		</div>
	</main>


	<!-- 頁尾 -->
	<footer class="page-footer grey darken-4"
		style="clear:both;margin:100px 0 0 0;">
	<div class="container">
		<!-- footer上半部的container -->
		<!-- footer左半邊 -->
		<div>
			<h2 class="blue-text text-darken-2 left"
				style="display: inline; margin: 0 10px 0 5px;">TCPIP</h2>
			<div class="left" id="taiwan">
				<p class="grey-text text-lighten-4 ">Taiwan Camp’s Project
					Innovation Platform</p>
			</div>
		</div>
		<div class="right" style="color: white;">
			<h2 class="blue-text text-darken-2 left"
				style="display: inline; margin: 0 10px 0 5px;">LINKS</h2>
			<div class="left">
				<a class="grey-text text-lighten-3" href="https://www.flyingv.cc/">FlingV</a><br />
				<a class="grey-text text-lighten-3" href="http://www.indievox.com/">iNDIEVOX</a><br />
				<a class="grey-text text-lighten-3" href="http://www.elivtw.com/">以立國際服務</a>
			</div>
		</div>
		<!-- footer下半部的container -->
		<div class="footer-copyright valign-wrapper" style="clear: both;">
			<div class="container center-align">台灣志願服務營隊計畫創新平台 © 2015
				Copyright</div>
		</div>
	</div>
	</footer>



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
			//註冊modal事件
			$(".modal-trigger").leanModal();
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			
 			setTimeout(function(){
				window.open("../index.jsp","_top")
			},3000) 
			
		})
		
		
		
	</script>
</body>
</html>