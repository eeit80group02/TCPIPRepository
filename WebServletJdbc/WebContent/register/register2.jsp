<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>

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
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">建立你的TCPIP帳號</h1>
	</div>

<main>
	<div class="row">
	<!-- 檢查表單填寫情況 -->
		<div class="col l3" id="validateform">
	        <div class="card-panel" style="padding:0;">
			  <ul id="formul" class="collapsible" data-collapsible="expandable" style="font-family:微軟正黑體;">
			    <li style="margin:0">
			      <div class="collapsible-header brown darken-2 white-text" id="accountinfohead" style="font-size:1.3em"><i class="material-icons">play_arrow</i>帳號</div>
			      <div class="collapsible-body"  id="accountinfo">
			      	<div style="font-size:1.3em;">
			      		<ul>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>必須包含英文字母及數字</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>不得包含特殊符號@#$%^&*</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>必須介於10~16個字元間</span></li>
			      		</ul>
			      	</div>
			      </div>
			    </li>
			    <li style="margin:0">
			      <div class="collapsible-header brown darken-2 white-text" id="passwordinfohead" style="font-size:1.3em"><i class="material-icons">play_arrow</i>密碼</div>
			      <div class="collapsible-body" id="passwordinfo">
			      	<div style="font-size:1.3em;">
			      		<ul>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>必須包含英文字母及數字</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>密碼與密碼確認必須相同</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>必須包含至少一特殊符號@#$%^&*</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>必須介於10~16個字元間</span></li>
			      		</ul>
			      	</div>			      
			      </div>
			    </li>
			    <li style="margin:0">
			      <div class="collapsible-header brown darken-2 white-text" id="phoneinfohead" style="font-size:1.3em"><i class="material-icons">play_arrow</i>聯絡方式</div>
			      <div class="collapsible-body" id="phoneinfo">
			      <div style="font-size:1.3em;">
			      		<ul>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;">info_outline</i><span>電話、手機至少擇一選填</span></li>
			      		</ul>
			      	</div>	
			      </div>
			    </li>
			  </ul>
	        
	        </div>
		</div>
		
		<!-- 切版面開始 -->
		<div class="col l7" style="border:2px solid red;">
			<!-- 表單本體開始 -->
			<form action="<c:url value='register.do' />" method="POST" enctype="multipart/form-data" style="padding:2.5em;" id="registerform">

				<div class="row">
					<!-- 左邊 -->
					<div class="left" style="width:35em;">
						<!-- 帳號 -->
						<div class="input-field row">
							<input id="accounts" type="text" class="validate" name="account" value="${param.account}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errorAccountEmpty}${MsgErr.errorAccountExists}</font>
							<label for="accounts" style="font-size:1.3em;font-weight:600;">帳號</label>
						</div>
						<!-- 密碼 -->
						<div class="input-field row">
							<input id="passwords" type="password" class="validate" name="password" >
<!-- 														後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errorPasswordEmpty}</font>
							<label for="passwords" style="font-size:1.3em;font-weight:600;">密碼</label>
						</div>						
						<!-- 密碼確認 -->
						<div class="input-field row">
							<input id="check" type="password" class="validate" name="check">
<!-- 														後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errorCheckEmpty}</font>
							<label for="check" style="font-size:1.3em;font-weight:600;">密碼確認</label>
						</div>
					</div>
					<!-- 右邊 -->
					<!-- 圖 -->
					<div class="right">
						<img id="view" src="" style="height: 6.75cm; width: 5.25cm;border:2px solid black;" >						
					</div>				
				</div>







				<!-- 按鈕 -->
<!-- 				<div class="row"> -->
<!-- 					<div class="file-field input-field" style="margin:0 auto;"> -->
<!-- 						按鈕本體 -->
<!-- 						<div class="col l3 offset-l9 btn-large yellow black-text tooltipped" data-position="bottom" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M"  -->
<!-- 							style="overflow:hidden;"> -->
<!-- 							<span style="font-family:微軟正黑體;font-size:1.3em;">上傳頭像</span> -->
<!-- 							<input class="right" type="file" id="pitcture" accept="image/x-png, image/jpeg" name="pitcture"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div>			 -->
<!-- 				帳號 -->
<!-- 				<div class="input-field row"> -->
<!-- 					<input id="accounts" type="text" class="validate" name="account"> -->
<!-- 					<label for="accounts" style="font-size:1.3em;font-weight:600;">帳號</label> -->
<!-- 				</div> -->
<!-- 				密碼 -->
<!-- 				<div class="input-field row"> -->
<!-- 					<input id="passwords" type="password" class="validate" name="password"> -->
<!-- 					<label for="passwords" style="font-size:1.3em;font-weight:600;">密碼</label> -->
<!-- 				</div> -->
<!-- 				確認密碼 -->
<!-- 				<div class="input-field row"> -->
<!-- 					<input id="check" type="password" class="validate" name="check"> -->
<!-- 					<label for="check" style="font-size:1.3em;font-weight:600;">密碼確認</label> -->
<!-- 				</div> -->
				
				<div class="row">
				<!-- 姓氏 -->
					<div class="col l3 input-field left">
						<input id="lastName" type="text" class="validate" name="lastName" value="${param.lastName}">
<!-- 													後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errorLastNameEmpty}</font>
						<label for="lastName" style="font-size:1.3em;font-weight:600;">姓氏</label>
					</div>				
				
				<!-- 名字 -->
					<div class="col l3 input-field left">
						<input id="firstName" type="text" class="validate" name="firstName" value="${param.firstName}">
<!-- 													後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errorFirstNameEmpty}</font>
						<label for="firstName" style="font-size:1.3em;font-weight:600;">名字</label>
					</div>				
				
				<!-- 性別 -->					
					<div class="col l3 input-field left" id="genderradio">
						<input type="radio" id="boy" name="gender" value="1"/>
		     			<label for="boy">男</label>
		     			<input type="radio" id="girl" name="gender" value="2"/>
		      			<label for="girl">女</label>
<!-- 		      										後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorGenderEmpty}</font>					
					</div>				
				<!-- 頭像上傳按鈕 -->
					<div class="col l3 btn yellow black-text tooltipped" data-position="bottom" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
						<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">上傳頭像</span>
						<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="pitcture" accept="image/x-png, image/jpeg" name="pitcture" >
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorPicture}${MsgErr.errorPictureType}</font>
					</div>
<!-- 			           <input type="file" id="theq" style="display:block;overflow:hidden;width:100%"/> -->
				</div>
				
				<!-- 電話 -->
					<div class="row input-field">
						<input id="idNumber" type="text" class="validate" name="phone" value="${param.phone}">
						<label for="idNumber" style="font-size:1.3em;font-weight:600;">電話</label>					
					</div>
					
				<!-- 手機 -->
					<div class="row input-field">
						<input id="phone" type="text" class="validate" name="cellPhone" value="${param.cellPhone}">
						<label for="phone" style="font-size:1.3em;font-weight:600;">手機</label>					
					</div>
					
				<!-- 生日 -->
					<div class="row input-field">
						<input id="birthday" type="text" class="validate" name="birthday" value="${param.birthday}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorBirthdayStrEmpty}${MsgErr.errFormat}</font>
						<label for="birthday" style="font-size:1.3em;font-weight:600;">生日</label>					
					</div>

				<!-- Email -->
					<div class="row input-field">
						<input id="email" type="text" class="validate" name="email" value="${param.email}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorEmailEmpty}${MsgErr.errorEmailExists}</font>
						<label for="email" style="font-size:1.3em;font-weight:600;">E-mail</label>						
					</div>
					
				<!-- Address -->
					<div class="row input-field">
						<input id="address" type="text" class="validate" name="address" value="${param.address}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorAddressEmpty}</font>
						<label for="address" style="font-size:1.3em;font-weight:600;">地址</label>						
					</div>
					
				<!-- button -->
					<div class="row">
						<button  class="col l2 btn-large waves-effect waves-light right yellow black-text" type="submit" name="action">
							<span style="font-family:微軟正黑體;font-size:1.3em;">送出</span>
						</button>
						<button  class="col l2 btn-large waves-effect waves-light right yellow black-text" type="reset" name="action">
							<span style="font-family:微軟正黑體;font-size:1.3em;">取消</span>
						</button>

					</div>
				</form>
		<!-- 主要版面 col l7 -->
		</div>
	
	
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
				var accountvalue = $("#accounts").val(),
					accountrex = /^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{10,16}$/,
					result1 = accountrex.test("123ASs");
					console.log(result1);
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
			
// 			var a = ($("#a").width()/2) - ($("#button").width()/2);
// 			$("#button").css("margin-left",a);
			
			$('input[type="checkbox"]').on('change', function() {
				   $('input[type="checkbox"]').not(this).prop('checked', false);
				});
			
		})
	</script>


</body>
</html>