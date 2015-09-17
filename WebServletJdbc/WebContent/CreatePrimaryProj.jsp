<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.css" />


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>TCPIP</title>




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
     <!-- 登入用modal end tag--> 
  </div>


	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">建立你的初步計畫</h1>
	</div>

<main>
	<div class="row">
		<!-- 切版面開始 -->
		<!-- 顯示封面 -->
		<form action="" method="post">
			<div class="container">
				<div class="row">
					<div class="col s12" >
						<img class="card-panel hoverable" id="view" src="" style="height: 336px; width: 496px;border:5px solid black;padding:0;" >
						<div class="col l2 btn yellow black-text tooltipped" data-position="right" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
							<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">封面</span>
							<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="pitcture" accept="image/x-png, image/jpeg" name="imgFile">
						</div>	
					</div>
					<div class="input-field col s12">
			          <input id="projname" type="text" class="validate" name="title">
			          <label for="projname">計畫名稱</label>
       				</div>
					<div class="input-field col s12">
			          <input id="ideallocation" type="text" class="validate" name="location">
			          <label for="ideallocation">理想地點</label>
       				</div>
       				<div class="input-field col s12">
       					活動時間
			        	<input type="date" class="datepicker" name="startTime">
			        	<input type="date" class="datepicker" name="endTime">
       				</div>
					<div class="input-field col s12">
			          <input id="peoples" type="text" class="validate" name="demandNum">
			          <label for="peoples">預計人數</label>
       				</div>
					<div class="input-field col s12">
			          <input id="budget" type="text" class="validate" name="budget">
			          <label for="budget">活動預算</label>
       				</div>
				</div>
				<div class="row">
				    <div class="row">
				        <div class="input-field col s12">
				          <textarea id="summary" class="materialize-textarea" name="projAbstract"></textarea>
				          <label for="summary">計畫摘要</label>
				        </div>
					</div>
				</div>
				<div class="row">
					<textarea class="ckeditor" name="content"></textarea>
				</div>
				<div class="row">
					<input type="submit">
				</div>
			</div>
		</form>
	</div>
</main>




        <footer class="page-footer grey darken-4">
          <div class="container">
            <!-- footer上半部的container -->
			<!-- footer左半邊 -->
			<div>
                <h2 class="blue-text text-darken-2 left" style="display:inline;margin:0 10px 0 5px;">TCPIP</h2>
              	<div class="left" id="taiwan">
              		<p class="grey-text text-lighten-4 ">Taiwan Camp’s Project Innovation Platform </p>
              	</div>
            </div>
			  <div class="right" style="color:white;">
				<h2 class="blue-text text-darken-2 left" style="display:inline;margin:0 10px 0 5px;">LINKS</h2>
              	<div class="left">
              	  <a class="grey-text text-lighten-3" href="https://www.flyingv.cc/">FlingV</a><br/>
                  <a class="grey-text text-lighten-3" href="http://www.indievox.com/">iNDIEVOX</a><br/>
                  <a class="grey-text text-lighten-3" href="http://www.elivtw.com/">以立國際服務</a>
			  </div>
          </div>
          <!-- footer下半部的container -->
          <div class="footer-copyright valign-wrapper" style="clear:both;">
            <div class="container center-align">
          		 台灣志願服務營隊計畫創新平台 © 2015 Copyright 
            </div>
          </div>
          </div>
          
        </footer>

	
	<script src="ckeditor/ckeditor.js"></script>
	<script src="ckeditor/samples/old/assets/uilanguages/languages.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		$(function() {
			//mouseover時，單個input元素被舉起
			$(".input-field").hover(function(){
				$(this).addClass("hoverable");
			},function(){
				$(this).removeClass("hoverable");
			})
			//取消註冊gender的hover特效
			$("#genderradio").unbind("mouseenter mouseleave");
			//開始填寫 input元素時 背景轉為白色
			$("#registerform input").focus(function(){
				$(this).parent().css("background-color","white");
				origintext = $("~ label",this).text();
				$("~ label",this).text("");
			}).blur(function(){
				$(this).parent().css("background-color","");
					if($(this).val().trim() == "" ){
						$("~ label",this).text(origintext);
					}else{
						$("~ label",this).text("");
					}
			})
			//取消註冊pitcture的focus特效
			$("#pitcture").off("focus");
			//註冊帳號focus事件時的驗證
				$("#accounts").on("focus",function(){
					if(!$("#accountinfohead").hasClass("active"))
					$("#accountinfohead").trigger("click");
				})
				
				$("#passwords").on("focus",function(){
					if(!$("#passwordinfohead").hasClass("active"))
						$("#passwordinfohead").trigger("click");
				})

				$("#check").on("focus",function(){
					if(!$("#passwordinfohead").hasClass("active"))
						$("#passwordinfohead").trigger("click");
				})
				
				$("#idNumber").on("focus",function(){
					if(!$("#phoneinfohead").hasClass("active"))
						$("#phoneinfohead").trigger("click");
				})
				
				$("#phone").on("focus",function(){
					if(!$("#phoneinfohead").hasClass("active"))
						$("#phoneinfohead").trigger("click");
				})
			//表單驗證
				//帳號
					$("#accounts").on("keyup",function(){
						var accountvalue = $("#accounts").val();
						
						if(accountvalue.trim() !== null){
							//必須包含英文字母及數字
							rule1 = /^(?=.*\d)(?=.*[A-Za-z]).{2,}$/
							var result = rule1.test(accountvalue);
							
							//不得有特殊符號
							rule2 = /^(?=.*\W)?$/
							var result2 = rule2.test(accountvalue);		
							
							//必須達到的長度
							var flag1;
							if(accountvalue.length >= 10 && accountvalue.length <= 16){
								flag1 = true;
							}else{
								flag1 = false;
							}
							
							if(result == true){
								$("#rule1pic1").text("done");
								$("#rule1text1").addClass("light-green accent-3 black-text");
							}else{
								$("#rule1pic1").text("info_outline");
								$("#rule1text1").removeClass("light-green accent-3").addClass("red");
							}
							
							if(result2 !== true){
								$("#rule1pic2").text("done");
								$("#rule1text2").addClass("light-green accent-3 black-text");
							}else{
								$("#rule1pic2").text("info_outline");
								$("#rule1text2").removeClass("light-green accent-3").addClass("red");
							}
							
							if(flag1){
								$("#rule1pic3").text("done");
								$("#rule1text3").addClass("light-green accent-3 black-text");
							}else{
								$("#rule1pic3").text("info_outline");
								$("#rule1text3").removeClass("light-green accent-3").addClass("red");
							}
						}
					})
			//footer中連結的文字大小
			$("a").css("font-size","1.2em");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%");
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
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
			

			$('input[type="checkbox"]').on('change', function() {
				   $('input[type="checkbox"]').not(this).prop('checked', false);
				});
			
		})
	</script>


</body>
</html>