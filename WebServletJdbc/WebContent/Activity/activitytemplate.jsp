<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css" media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.rule.js"></script>
<script type="text/javascript" src="jquery/jquery.error.message.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body class="amber lighten-5">
	<!-- 頁首 -->
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
	<div class="row">
		<div class="col s12"><h2 style="text-align:center;">活動花絮</h2></div>
		<div class="col s12 m4 l8">
			<h4>花絮編輯</h4>
			<div class="input-field col s12">
				<input id="projName" type="text" class="validate" name="projName" readonly>
				<label for="projName" class="">完整計畫名稱</label>
			</div>
			<div class="input-field col s12">
				<input id="memberNo" type="text" class="validate" name="memberNo" readonly>
				<label for="memberNo" class="">活動發起人</label>
			</div>
			<div class="col s12" >
				<div class="col l2 btn yellow black-text tooltipped" data-position="right" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
					<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">封面</span>
					<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="pitcture" accept="image/x-png, image/jpeg" name="imgFile">
				</div>	
			</div>
			<div class="input-field col s12">
				<textarea class="ckeditor" name="content"></textarea>
			</div>
		</div>
		<div class="col s12 m4 l4">
			<div>
				<h4>花絮封面預覽</h4>
				<img class="card-panel hoverable" id="view" src="" style="height: 340px; width: 420px;border:5px solid black;padding:0;" >
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
	<script src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
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
			
			$("#pitcture").change(function(){
				var file = $("#pitcture")[0].files[0];
				var reader  = new FileReader();
				reader.onloadend = function () {
					console.log(reader.result);
					$("#view").attr("src", reader.result);
				}
				if(file){
					reader.readAsDataURL(file);
				}
			})
		})
	</script>
</body>
</html>