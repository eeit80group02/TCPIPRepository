<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>TCPIP</title>
<style>
</style>
</head>


<body class="deep-orange lighten-5">
<header> <!-- 頁首 --> <nav>
			<div class="nav-wrapper grey darken-3">
				<a href="#!" class="brand-logo"> <img alt="TCPIP" title="TCPIP"
					src="picture/LOGO.PNG" />
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
		  <div id="modal1" class="modal">
		    <div class="modal-content blue lighten-5" style="height:80%;width:100%;">
		    	<div class="row" style="margin-top:0px;">
			      <h4 class="center-align" style="font-family:微軟正黑體;font-weight:600;">登入TCPIP</h4>
			    </div>
			    <div class="divider" style="display:block;"></div>
					    <div style="width:60%;margin:0 auto;">  
					      <form class="col l6 offset-l3" id="login">
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
		    <div class="modal-footer blue lighten-5 valign-wrapper" style="height:20%;padding:0;">
		    	<div class="row valign" style="font-family:微軟正黑體;font-weight:600;">
			      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">登入</a>
				  <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">忘記密碼</a>	      
			      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">註冊帳號</a>
		    	</div>
		    </div>
		  </div>
 <!-- 登入用modal end tag-->  


	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		(function($) {
			//footer header字的大小
			$("a").css("font-size","1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//註冊modal事件
			$(".modal-trigger").leanModal();
			//帳號、密碼欄focus的背景色變化
			$("#login > div > input").each(function(){
				$(this).on({"focus":function(){
					$(this).addClass("cyan lighten-4");
				},"blur":function(){
					$(this).removeClass("cyan lighten-4");
				}})
			})
			
		})(jQuery)
	</script>


</body>
</html>