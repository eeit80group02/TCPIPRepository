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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>TCPIP</title>
<style>
<style type="text/css">
	#captchaImage {
		width: 160px;
		height: 56px;
	}
	
	#checkImg{
		width: 16px;
		height: 16px;
	}
</style>

</style>



</head>


<body class="deep-orange lighten-5">
<header> <!-- 頁首 --> <nav>
	<div class="nav-wrapper grey darken-3">
		<a href="#!" class="brand-logo"> <img alt="TCPIP" title="TCPIP"
			src="${pageContext.request.contextPath}/picture/LOGO.PNG" />
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
		

	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">建立你的TCPIP帳號</h1>
	</div>

<main>
	<div class="row">
	<!-- 檢查表單填寫情況 -->
		<div class="col l3" id="validateform" style="position:absolute;">
	        <div class="card-panel" style="padding:0;margin:0;">
			  <ul id="formul" class="collapsible" data-collapsible="accordion" style="font-family:微軟正黑體;font-weight:600;margin:0;">
			    <li style="margin:0;">
			      <button class="collapsible-header deep-orange lighten-4 left-align" id="accountinfohead" style="font-size:1.4em;display:block;width:100%;padding:0;margin:0;border:2px solid #ffccbc;" autofocus><i class="material-icons">play_arrow</i>帳號</button>
			      <div class="collapsible-body cyan lighten-5 black-text"  id="accountinfo">
			      	<div style="font-size:1.2em;">
			      		<ul id="finalchk1">
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule1pic1"></i><span id="rule1text1">必須包含英文字母</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule1pic4"></i><span id="rule1text4">必須包含數字</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule1pic2"></i><span id="rule1text2">不得包含任何特殊符號及中文字元</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule1pic3"></i><span id="rule1text3">必須介於10~16個字元間</span></li>
			      		</ul>
			      	</div>
			      </div>
			    </li>
			    <li style="margin:0">
			      <button class="collapsible-header deep-orange lighten-4 left-align" id="passwordinfohead" style="font-size:1.4em;display:block;width:100%;padding:0;margin:0;border:2px solid #ffccbc;"><i class="material-icons">play_arrow</i>密碼</button>
			      <div class="collapsible-body cyan lighten-5 black-text" id="passwordinfo">
			      	<div style="font-size:1.2em;">
			      		<ul id="finalchk2">
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule2pic1"></i><span id="rule2text1">必須包含英文字母</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule2pic6"></i><span id="rule2text6">必須包含數字</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule2pic2"></i><span id="rule2text2">密碼與密碼確認必須相同</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule2pic3"></i><span id="rule2text3">必須包含至少一特殊符號</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule2pic4"></i><span id="rule2text4">不得有中文字元</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule2pic5"></i><span id="rule2text5">必須介於10~16個字元間</span></li>
			      		</ul>
			      	</div>			      
			      </div>
			    </li>
			    <li style="margin:0">
			      <button class="collapsible-header deep-orange lighten-4 left-align" id="phoneinfohead" style="font-size:1.4em;display:block;width:100%;padding:0;margin:0;border:2px solid #ffccbc;"><i class="material-icons">play_arrow</i>聯絡方式</button>
			      <div class="collapsible-body cyan lighten-5 black-text" id="phoneinfo">
			      <div style="font-size:1.2em;">
			      		<ul id="finalchk3">
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule3pic1"></i><span id="rule3text1">室內電話、手機至少擇一選填</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule3pic2"></i><span id="rule3text2">室內電話符合格式</span></li>
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule3pic3"></i><span id="rule3text3">手機符合格式</span></li>
			      		</ul>
			      	</div>	
			      </div>
			    </li>
			    <li style="margin:0">
			      <button class="collapsible-header deep-orange lighten-4 left-align" id="birthdayinfohead" style="font-size:1.4em;display:block;width:100%;padding:0;margin:0;border:2px solid #ffccbc;"><i class="material-icons">play_arrow</i>生日</button>
			      <div class="collapsible-body cyan lighten-5 black-text" id="birthdayinfo">
			      <div style="font-size:1.2em;">
			      		<ul id="finalchk4">
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule5pic1"></i><span id="rule5text1">生日符合格式</span></li>
			      		</ul>
			      	</div>	
			      </div>
			    </li>
			    <li style="margin:0">
			      <button class="collapsible-header deep-orange lighten-4 left-align" id="emailinfohead" style="font-size:1.4em;display:block;width:100%;padding:0;margin:0;border:2px solid #ffccbc;"><i class="material-icons">play_arrow</i>Email</button>
			      <div class="collapsible-body cyan lighten-5 black-text" id="emailinfo">
			      <div style="font-size:1.2em;">
			      		<ul id="finalchk5">
				      		<li><i class="material-icons" style="vertical-align:text-bottom;" id="rule4pic1"></i><span id="rule4text1">Email符合格式</span></li>
			      		</ul>
			      	</div>	
			      </div>
			    </li>
			  </ul>
	        
	        </div>
		</div>
		
		<!-- 切版面開始 -->
		<div class="col l6 offset-l3">
			<!-- 表單本體開始 -->
			<form class="card-panel hoverable green lighten-5" action="#" method="get" enctype="multipart/form-data" style="padding:2.5em;" id="registerform">

				<div class="row">
						<!-- 頭像上傳 -->
						<div class="row">
							<div class="col l2 btn yellow lighten-5 black-text tooltipped" data-position="right" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
								<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">頭像</span>
								<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="pitcture" accept="image/x-png, image/jpeg" name="pitcture">
							</div>									
							<!-- 身分證驗證按鈕 -->
							 <button data-target="modal2" class="col l3 btn modal-trigger yellow lighten-5 black-text" style="font-family:微軟正黑體;font-size:1.5em;" id="idcardnumberbtn">身分驗證</button>
<!-- 							 <a href="#modal2" class="col l3 btn modal-trigger yellow lighten-5 black-text" style="font-family:微軟正黑體;font-size:1.5em;" id="idcardnumberbtn">身分驗證</a> -->
						</div>
						<!-- 身分證字號 -->
						<div class="input-field row tooltipped" data-position="left" data-delay="50"  data-tooltip="請點擊身分證驗證按鈕">
							<input id="idcardNumber" type="text" class="validate" name="idcardNumber" required readonly="readonly">
							<label for="idcardNumber" style="font-size:1.3em;font-weight:600;">身分證字號</label>
						</div>
						<!-- 帳號 -->
						<div class="input-field row">
							<input id="accounts" type="text" class="validate" name="account" required>
							<label for="accounts" style="font-size:1.3em;font-weight:600;">帳號</label>
						</div>
						<!-- 密碼 -->
						<div class="input-field row">
							<input id="passwords" type="password" class="validate" name="password" required>
							<label for="passwords" style="font-size:1.3em;font-weight:600;">密碼</label>
						</div>						
						<!-- 密碼確認 -->
						<div class="input-field row">
							<input id="check" type="password" class="validate" name="check" required>
							<label for="check" style="font-size:1.3em;font-weight:600;">密碼確認</label>
						</div>
				</div>

				
				<div class="row">
				<!-- 姓氏 -->
					<div class="col l4 input-field left">
						<input id="lastName" type="text" class="validate" name="lastName" required value="${param.lastname}">
						<label for="lastName" style="font-size:1.3em;font-weight:600;">姓氏</label>
					</div>				
				
				<!-- 名字 -->
					<div class="col l4 input-field left">
						<input id="firstName" type="text" class="validate" name="firstName" required value="${param.firstname}" >
						<label for="firstName" style="font-size:1.3em;font-weight:600;">名字</label>
					</div>				
				
				<!-- 性別 -->					
					<div class="col l4 input-field left" id="genderradio">
						<input type="radio" id="boy" name="gender" value="1" />
		     			<label for="boy">男</label>
		     			<input type="radio" id="girl" name="gender" value="2"/>
		      			<label for="girl">女</label>					
					</div>				
				</div>
				
				<!-- 電話 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：02-66666631" >
						<input id="idNumber" type="text" class="validate" name="idNumber"  value="${param.idNumber}">
						<label for="idNumber" style="font-size:1.3em;font-weight:600;">室內電話</label>					
					</div>
					
				<!-- 手機 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：0912-345678">
						<input id="phone" type="text" class="validate" name="phone" value="${param.phone}">
						<label for="phone" style="font-size:1.3em;font-weight:600;">手機</label>					
					</div>
					
				<!-- 生日 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：2015-10-07">
						<input id="birthday" type="text" class="validate" name="birthday" required value="${param.birthday}">
						<label for="birthday" style="font-size:1.3em;font-weight:600;">生日</label>					
					</div>

				<!-- Email -->
					<div class="row input-field">
						<input id="email" type="text" class="validate" name="email" required value="${param.email}">
						<label for="email" style="font-size:1.3em;font-weight:600;">E-mail</label>						
					</div>
					
				<!-- Address -->
					<div class="row input-field">
						<input id="address" type="text" class="validate" name="address" required value="${param.address}">
						<label for="address" style="font-size:1.3em;font-weight:600;">地址</label>						
					</div>
					
				<!-- button -->
					<div class="row" id="btndiv">
						<button  class="col l2 btn-large waves-effect waves-light right yellow lighten-5 black-text" type="reset" name="action">
							<span style="font-family:微軟正黑體;font-size:1.3em;">取消</span>
						</button>
						<button  class="col l2 btn-large waves-effect waves-light right yellow lighten-5 black-text" type="submit" name="action" id="submitbtn">
							<span style="font-family:微軟正黑體;font-size:1.3em;">送出</span>
						</button>

					</div>
				</form>
				
				
		</div>
		<!-- 表單版面 col l6 -->		
		
		
		<!-- 圖片預覽版面  col l2-->
		<div class="col l2">
			<img class="card-panel hoverable" id="view" src="" style="height: 6.75cm; width: 5.25cm;border:5px solid black;padding:0;" >
		</div>

	</div>
</main>
		 <!-- 身分驗證用modal --> 
		<div id="modal2" class="modal">
		   <div class="modal-content blue lighten-5" style="height:100%;width:100%;">
<%-- 		 	<c:import url="/idnumbervalidate.jsp" context="${pageContext.request.contextPath}" charEncoding="UTF-8"></c:import> --%>
<!-- 		   </div> -->
<!-- 		   <div class="modal-footer blue lighten-5 valign-wrapper" style="height:20%;padding:0;"> -->
<!-- 		   	<div class="row valign" style="font-family:微軟正黑體;font-weight:600;"> -->
<!-- 		      <a href="#!" id="backregister" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">回註冊頁</a> -->
<!-- 		   	</div> -->
<!-- 		   </div> -->
<!-- 		 </div> -->
	<!-- 主要版型 -->
	<div class="row">
			<form action="/" id="postForm" class="col l12" style="padding:2em;" >
						<!-- 第一列 -->
						<div class="row yellow lighten-2">
							<label for="idnum">統一編號</label>
							<input type="text" id="idnum" name="idnum" oninput="checkID()" required><img style="display: none;" id="checkImg"><span id="num"></span>
						</div>
						
						<!-- 第二列 -->
						<div class="row yellow lighten-2">
							<label for="datepicker">發證日期</label>
							<input type="text" id="datepicker" readonly required ><span id="date"></span>
						</div>
						
						<!-- 第三列 -->
						<div class="row yellow lighten-2">
						<div>
							<label for="siteId">發證地點</label>
							<select id="siteId" name="siteId" required >
									<option value="" disabled>請選擇</option>
									<option value="10001">北縣</option>
									<option value="10002">宜縣</option>
									<option value="10003">桃縣</option>
									<option value="10004">竹縣</option>
									<option value="10005">苗縣</option>
									<option value="10006">中縣</option>
									<option value="10007">彰縣</option>
									<option value="10008">投縣</option>
									<option value="10009">雲縣</option>
									<option value="10010">嘉縣</option>
									<option value="10011">南縣</option>
									<option value="10012">高縣</option>
									<option value="10013">屏縣</option>
									<option value="10014">東縣</option>
									<option value="10015">花縣</option>
									<option value="10016">澎縣</option>
									<option value="10017">基市</option>
									<option value="10018">竹市</option>
									<option value="10020">嘉市</option>
									<option value="09007">連江</option>
									<option value="09020">金門</option>
									<option value="63000">北市</option>
									<option value="64000">高市</option>
									<option value="65000">新北市</option>
									<option value="66000">中市</option>
									<option value="67000">南市</option>
									<option value="68000">桃市</option>
							</select><span id="site"></span>
						</div>
						</div>
						
						<!-- 第四列 -->
						<div class="row yellow lighten-2">
								<label for="applyReason">領補換類別</label>
								<select id="applyReason" name="applyReason" required>
									<option value="">請選擇</option>
									<option value="1">初發</option>
									<option value="2">補發</option>
									<option value="3">換發</option>
								</select><span id="reason"></span>
						</div>
						
						<!-- 第五列 -->
						<div class="row yellow lighten-2">
							<label for="captchaImage">驗證碼圖片: </label>
							<img id="captchaImage" name="captchaImage" title="驗證碼圖片" src="" >
								<input type="button" id="refreshCaptcha" onclick="refresh()" value="點擊換圖">
								<textarea id="captchaField" style="display:none;"></textarea>
						</div>
						
						<!-- 第六列 -->
						<div class="row yellow lighten-2">
							<label for="captchaInput">請輸入驗證碼</label>
							<input id="captchaInput" name="captchaInput" type="text" value="" size="5" maxlength="5" required><span id="captcha"></span>
						</div>
		
				<input type="hidden" id="applyTWY" name="applyTWY" value="">
				<input type="hidden" id="applyMM" name="applyMM" value="">
				<input type="hidden" id="applyDD" name="applyDD" value="">
				<input type="hidden" id="captchaKey" name="captchaKey" value=""><br>
				
				<button type="submit" class="btn right">驗證</button>				
			</form>
			<div id="result"></div>
		
		
		
		</div>
		<!-- 主要版型 -->	
		 </div>
		 <!-- modal footer -->
		 <div class="modal-footer blue lighten-5 valign-wrapper" style="height:20%;padding:0;">
		   	<div class="row valign" style="font-family:微軟正黑體;font-weight:600;">
		      <a href="#!" id="backregister" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">回註冊頁</a>
		   	</div>
		 </div>
		 </div>
		<!-- 身分驗證用modal end tag-->  		 
		 




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
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
	
			(function($) {
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
				$("~ label",this).css("opacity","0");
			}).blur(function(){
				$(this).parent().css("background-color","");
					if($(this).val().trim() == "" ){
						$("~ label",this).css("opacity","1");
					}else{
						$("~ label",this).css("opacity","0");
					}
			})
			//取消註冊pitcture的focus特效
			$("#pitcture").off("focus");
				
			//禁止使用者點擊
// 				$("#validateform").on({
// 					"mouseover":function(){
// 						$(".collapsible-header").prop("disabled",true);
// 					},
// 					"mouseout":function(){
// 						$(".collapsible-header").prop("disabled",false);
// 					}
// 				})
				
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
					if(!$("#phoneinfohead").hasClass("active")){
						$("#phoneinfohead").trigger("click");
					}
				})
				
				$("#phone").on("focus",function(){
					if(!$("#phoneinfohead").hasClass("active")){
						$("#phoneinfohead").trigger("click");
					}
				})
				
				$("#email").on("focus",function(){
					if(!$("#emailinfohead").hasClass("active"))
						$("#emailinfohead").trigger("click");
				})
				
				$("#birthday").on("focus",function(){
					if(!$("#birthdayinfohead").hasClass("active"))
						$("#birthdayinfohead").trigger("click");
				})

			//表單驗證
				//身分證字號
				$("#backregister").on("click",function(){
					$("label[for='idcardNumber']").text("");
					var meta = $("#backregister").data("idnumbervalidateresult");
					$("#idcardNumber").val(meta);
				})
				//帳號
					$("#accounts").on("keyup",function(){
						var accountvalue = $("#accounts").val();
						
						if(accountvalue.trim().length !== 0){
							//必須包含英文字母
							rule1 = /^(?=.*[A-Za-z]).{1,}$/
							var result = rule1.test(accountvalue);
							
							//不得有特殊符號
							rule2 = /^(?=.*[\W||\s||_]).{1,}$/
							var result2 = rule2.test(accountvalue);		

							//必須包含數字
							rule4 = /^(?=.*[0-9]).{1,}$/
							var result4 = rule4.test(accountvalue);
							
							
							//必須達到的長度
							var flag1;
							if(accountvalue.length >= 10 && accountvalue.length <= 16){
								flag1 = true;
							}else{
								flag1 = false;
							}
							
							var finalchk = false;
							if(result == true && result2 !== true && result4 == true && flag1 == true){
								finalchk = true;
							}
							
							$("#registerform").data({accountresults:finalchk});							
							
							if(result){
								$("#rule1pic1").text("done")
												.css("color","#43a047");
								$("#rule1text1").css("color","#43a047");
							}else{
								$("#rule1pic1").text("info_outline")
												.css("color","#ff5252");
								$("#rule1text1").css("color","#ff5252");
							}
							
							if(!result2){
								$("#rule1pic2").text("done").css("color","#43a047");
								$("#rule1text2").css("color","#43a047");	
							}else{
								$("#rule1pic2").text("info_outline")
								.css("color","#ff5252");
								$("#rule1text2").css("color","#ff5252");
							}
							
							if(flag1){
								$("#rule1pic3").text("done")
												.css("color","#43a047");
								$("#rule1text3").css("color","#43a047");
							}else{
								$("#rule1pic3").text("info_outline")
												.css("color","#ff5252");
								$("#rule1text3").css("color","#ff5252");
							}
							
							if(result4){
								$("#rule1pic4").text("done")
								.css("color","#43a047");
								$("#rule1text4").css("color","#43a047");
							}else{
								$("#rule1pic4").text("info_outline")
								.css("color","#ff5252");
								$("#rule1text4").css("color","#ff5252");
							}
						}else{
							$("#rule1pic1").text("");
							$("#rule1pic2").text("");
							$("#rule1pic3").text("");
							$("#rule1pic4").text("");
							$("#rule1text1").css("color","black");
							$("#rule1text2").css("color","black");
							$("#rule1text3").css("color","black");
							$("#rule1text4").css("color","black");
						}
					})
					
					//密碼
					$("#passwords").on("keyup",function(){
						var passwordvalue = $("#passwords").val();
						if(passwordvalue.trim().length !== 0 ){
							//必須包含英文字母,rule1為真表示有英文字母;
							rule1 = /^(?=.*[A-Za-z]).{1,}$/;
							
							//必須包含一特殊符號,rule3為真表示有特殊符號
							rule3 = /^(?=.*[\W]).{1,}$/
							//不可以有中文字元,rule4為真表示有中文
							rule4 = /^(?=.*[\u4e00-\u9fa5)]).{1,}$/
							//密碼長度介於10~16字間
							var flag1 = false;
							if(passwordvalue.trim().length >=10 && passwordvalue.trim().length <= 16){
								flag1 = true;
							}
							//必須包含數字
							rule6 = /^(?=.*[0-9]).{1,}$/
							
							var result1 = rule1.test(passwordvalue),
								result3 = rule3.test(passwordvalue),
								result4 = rule4.test(passwordvalue),
								result6 = rule6.test(passwordvalue);
							
							var finalchk = false;
							if(result1 == true && result3 == true && result4 !== true && flag1 == true && result6 == true){
								finalchk = true;
							}
							
							console.log(finalchk);
							$("#registerform").data({passwordresults:finalchk});
							
							if(result1){
								$("#rule2pic1").text("done")
								.css("color","#43a047");
								$("#rule2text1").css("color","#43a047");								
							}else{
								$("#rule2pic1").text("info_outline")
								.css("color","#ff5252");
								$("#rule2text1").css("color","#ff5252");								
							}
							
							if(result3){
								$("#rule2pic3").text("done")
								.css("color","#43a047");
								$("#rule2text3").css("color","#43a047");								
							}else{
								$("#rule2pic3").text("info_outline")
								.css("color","#ff5252");
								$("#rule2text3").css("color","#ff5252");									
							}
							
							if(result4){
								$("#rule2pic4").text("info_outline")
								.css("color","#ff5252");
								$("#rule2text4").css("color","#ff5252");								
							}else{
								$("#rule2pic4").text("done")
								.css("color","#43a047");
								$("#rule2text4").css("color","#43a047");									
							}
							
							if(flag1){
								$("#rule2pic5").text("done")
								.css("color","#43a047");
								$("#rule2text5").css("color","#43a047");									
							}else{
								$("#rule2pic5").text("info_outline")
								.css("color","#ff5252");
								$("#rule2text5").css("color","#ff5252");									
							}
							
							if(result6){
								$("#rule2pic6").text("done")
								.css("color","#43a047");
								$("#rule2text6").css("color","#43a047");										
							}else{
								$("#rule2pic6").text("info_outline")
								.css("color","#ff5252");
								$("#rule2text6").css("color","#ff5252");	
							}
							
						}else{
							$("#rule2pic1").text("");
							$("#rule2pic2").text("");
							$("#rule2pic3").text("");
							$("#rule2pic4").text("");
							$("#rule2pic5").text("");
							$("#rule2pic6").text("");
							$("#rule2text1").css("color","black");
							$("#rule2text2").css("color","black");
							$("#rule2text3").css("color","black");
							$("#rule2text4").css("color","black");
							$("#rule2text5").css("color","black");
							$("#rule2text6").css("color","black");
						}
					
					})
					
					//密碼確認
					$("#check").on("keyup",function(){
						var checkvalue = $("#check").val(),
							passwordvalue = $("#passwords").val();
						if(checkvalue !== ""){
							var result = (checkvalue.trim() == passwordvalue.trim());
							$("#registerform").data({passwordresults2:result});
							if(result && checkvalue !== ""){
								$("#rule2pic2").css("color","#43a047").text("done");
								$("#rule2text2").css("color","#43a047");
							}else{
								$("#rule2pic2").css("color","#ff5252").text("info_outline");
								$("#rule2text2").css("color","#ff5252");
								
							}
						}else{
							$("#rule2pic2").text("");
							$("#rule2text2").css("color","black");
						}
					})
					
					//聯絡方式(sevlet內可以判斷格式是否正確再存)
					$("#idNumber").on("keyup",function(){
						rule1 = /^(02|03|037|04|049|05|06|07|08|082|0826|0836|089)-[0-9]{5,8}$/
// 						rule1 = /^[0]{1}(?=.*\d).{9}/
						var result = rule1.test($("#idNumber").val());
						$("body").data("chkphone1",result);
						
						if($("#idNumber").val() !== ""){
							if(result){
								$("#rule3pic2").css("color","#43a047").text("done");
								$("#rule3text2").css("color","#43a047");	
							}else{
								$("#rule3pic2").css("color","#ff5252").text("info_outline");
								$("#rule3text2").css("color","#ff5252");							
								$("#rule3pic1").css("color","#ff5252").text("info_outline");
								$("#rule3text1").css("color","#ff5252");
							}
						}else{
							$("#rule3pic2").text("");
							$("#rule3text2").css("color","black");	
						}
						
						if($("body").data("chkphone2") || result){
							$("#registerform").data({contactresult:true});							
							$("#rule3pic1").css("color","#43a047").text("done");
							$("#rule3text1").css("color","#43a047");
						}else{
							$("#rule3pic1").text("");
							$("#rule3text1").css("color","black");							
						}
					});
					//聯絡方式(手機)
					$("#phone").on("keyup",function(){
						rule1 = /^(09)[0-9]{2}-[0-9]{6}$/
						var result = rule1.test($("#phone").val());
						$("body").data("chkphone2",result);
						
						if($("#phone").val() !== ""){
							if(result){
							$("#rule3pic3").css("color","#43a047").text("done");
							$("#rule3text3").css("color","#43a047");
							}else{
								$("#rule3pic3").css("color","#ff5252").text("info_outline");
								$("#rule3text3").css("color","#ff5252");						
								$("#rule3pic1").css("color","#ff5252").text("info_outline");
								$("#rule3text1").css("color","#ff5252");						
							}
						}else{
							$("#rule3pic3").text("");
							$("#rule3text3").css("color","black");
						}
						
						if($("body").data("chkphone1") || result){
							$("#registerform").data({contactresult:true});
							$("#rule3pic1").css("color","#43a047").text("done");
							$("#rule3text1").css("color","#43a047");
						}else{
							$("#rule3pic1").text("");
							$("#rule3text1").css("color","black");							
						}
					})
					//Email格式
					$("#email").on("keyup",function(){
						rule1 = /^[-a-z0-9~!$%^&*_=+}{\?]+(\.[-a-z0-9~!$%^&*_=+}{\?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
						var result = rule1.test($("#email").val());
						if($("#email").val() !== ""){
							if(result){
								$("#registerform").data({emailresult:true});							
								$("#rule4pic1").css("color","#43a047").text("done");
								$("#rule4text1").css("color","#43a047");							
							}else{
								$("#rule4pic1").css("color","#ff5252").text("info_outline");
								$("#rule4text1").css("color","#ff5252");							
							}
						}else{
							$("#rule4pic1").text("");
							$("#rule4text1").css("color","black");	
						}
						})
						

					//生日格式
					$("#birthday").on("keyup",function(){
						rule1 = /^[1-2]{1}[0-9]{3}-[0-9]{2}-[0-9]{2}$/
						var result = rule1.test($("#birthday").val());
						var result2 = (new Date($("#birthday").val()).toString() == "Invalid Date");
						
						if($("#birthday").val() !== ""){
							if(result && !result2){
								$("#registerform").data({birthdayresult:true});
								$("#rule5pic1").css("color","#43a047").text("done");
								$("#rule5text1").css("color","#43a047");
							}else{
								$("#rule5pic1").css("color","#ff5252").text("info_outline");
								$("#rule5text1").css("color","#ff5252");									
							}
						}else{
							$("#rule5pic1").text("");
							$("#rule5text1").css("color","black");	
						}
					})
			//送出表單前的驗證
			$("#btndiv").on({
				"mouseover":function(){
				if(
				$("#registerform").data().accountresults &&
				$("#registerform").data().passwordresults &&
				$("#registerform").data().passwordresults2 &&
				$("#registerform").data().contactresult &&
				$("#registerform").data().emailresult &&
				$("#registerform").data().birthdayresult &&
				$("#lastName").val().trim() !== "" &&
				$("#firstName").val().trim() !== "" &&
				$("#address").val().trim() !== "" 
				){
					$("#submitbtn").prop("disabled",false);
				}else{
					$("#submitbtn").prop("disabled",true);
				}
			},"mouseout":function(){

				if(
					$("#registerform").data().accountresults &&
					$("#registerform").data().passwordresults &&
					$("#registerform").data().passwordresults2 &&
					$("#registerform").data().contactresult &&
					$("#registerform").data().emailresult &&
					$("#registerform").data().birthdayresult &&
					$("#lastName").val().trim() !== "" &&
					$("#firstName").val().trim() !== "" &&
					$("#address").val().trim() !== "" 
					
				){
					$("#submitbtn").prop("disabled",false);
				}else{
					$("#submitbtn").prop("disabled",true);
				}
			}
			});
			
			//固定表單測試表的位置
			$(window).on("scroll", function() {
				if ($(this).scrollTop() <= $("#registerform").position().top) {
					$("#validateform").css({
						"position" : "absolute",
						"top" : $("#registerform").position().top
					});
				} else {
					$("#validateform").css({
						"position" : "fixed",
						"top" : 0
					});
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
			
// 			var a = ($("#a").width()/2) - ($("#button").width()/2);
// 			$("#button").css("margin-left",a);
			
			$('input[type="checkbox"]').on('change', function() {
				   $('input[type="checkbox"]').not(this).prop('checked', false);
				});
			//////////////////////////////////////////////////////////////////
			
			//label的css
			$("label").css({
				"font-size":"1.5em",
				"font-family":"微軟正黑體",
				"color":"black",
				"font-weight":"900"				
			})
			$('select').material_select();
			var old_generateMonthYearHeader = $.datepicker._generateMonthYearHeader;
		    var old_get = $.datepicker._get;
		    var old_CloseFn = $.datepicker._updateDatepicker;
		    $.extend($.datepicker, {
		        _generateMonthYearHeader:function (a,b,c,d,e,f,g,h) {
		            var htmlYearMonth = old_generateMonthYearHeader.apply(this, [a, b, c, d, e, f, g, h]);
		            if ($(htmlYearMonth).find(".ui-datepicker-year").length > 0) {
		                htmlYearMonth = $(htmlYearMonth).find(".ui-datepicker-year").find("option").each(function (i, e) {
		                    if (Number(e.value) - 1911 > 0) $(e).text(Number(e.innerText) - 1911);
		                }).end().end().get(0).outerHTML;
		            }
		            return htmlYearMonth;
		        },
		        _get:function (a, b) {
		            a.selectedYear = a.selectedYear - 1911 < 0 ? a.selectedYear + 1911 : a.selectedYear;
		            a.drawYear = a.drawYear - 1911 < 0 ? a.drawYear + 1911 : a.drawYear;
		            a.curreatYear = a.curreatYear - 1911 < 0 ? a.curreatYear + 1911 : a.curreatYear;
		            return old_get.apply(this, [a, b]);
		        },
		        _updateDatepicker:function (inst) {
		            old_CloseFn.call(this, inst);
		            $(this).datepicker("widget").find(".ui-datepicker-buttonpane").children(":last")
		                   .click(function (e) {
		                        inst.input.val("");
		                    });
		        },
		        _setDateDatepicker: function (a, b) {
		            if (a = this._getInst(a)) { this._setDate(a, b); this._updateDatepicker(a); this._updateAlternate(a) }
		        },
		        _widgetDatepicker: function () {
		            return this.dpDiv
		        }

		    });
		    
		    $("#datepicker").datepicker({
		        yearSuffix: "", //將年改為空白
		        yearRange: "2005:2015",
		        changeYear: true, //手動修改年
		        changeMonth: true, //手動修改月
		        firstDay: 1, //0為星期天
		        showButtonPanel: true, //顯示bottom bar
		        closeText: '清除', //將離開改為清除
		        dateFormat: "yy-m-d",
		        onSelect: function (dateText, inst) {
		            var dateFormate = inst.settings.dateFormat == null ? "yy/mm/dd" : inst.settings.dateFormat; //取出格式文字
		            var reM = /m+/g;
		            var reD = /d+/g;
		            var objDate = { y: inst.selectedYear - 1911 < 0 ? inst.selectedYear : inst.selectedYear - 1911,
		                m: String(inst.selectedMonth).length != 1 ? inst.selectedMonth + 1 :  String(inst.selectedMonth + 1),
		                d: String(inst.selectedDay).length != 1 ? inst.selectedDay : String(inst.selectedDay)
		            };
		            $.each(objDate, function (k, v) {
		                var re = new RegExp(k + "+");
		                dateFormate = dateFormate.replace(re, v);
		            });
		            inst.input.val(dateFormate);
		            
		           $("#applyTWY").val(objDate.y);
		           $("#applyMM").val(objDate.m);
		           $("#applyDD").val(objDate.d);
		        }
		    });
			
			
		})(jQuery)
	</script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	
		<script type="text/javascript">
			var imageString = document.getElementById("captchaField").innerHTML;
			document.getElementById("captchaImage").src = imageString;	

			
			$( "#postForm" ).submit(function( event ) {
				event.preventDefault();
				$("#num").text("");
				$("#date").text("");
				$("#site").text("");
				$("#reason").text("");
				$("#captcha").text("");
				
				var check = true;
				if($("#checkImg").attr("src") == "http://www.webhostingspree.com/magento/wp-content/themes/Magento/images/no.png" || $("#checkImg").attr("src") == undefined ) {
					$("#num").text("輸入身分證有誤!");
					check = false;
				}
				if($("#datepicker").val() == "" ) {
					$("#date").text("請選擇發證日期!");
					check = false;
				}
				if($("#siteId").val() == "" ) {
					$("#site").text("請選擇發證地點!");			
					check = false;
				}
				if($("#applyReason").val() == "" ) {
					$("#reason").text("請選擇類別!");
					check = false;
				}
				if($("#captchaInput").val() == "" || $("#captchaInput").val().length < 5 ) {
					$("#captcha").text("驗證碼格式錯誤!");
					check = false;
				}
				
				if(check == true) {					
					$.ajax({
		    			url:'<c:url value="/PostIdCheckerServlet" />',
		    	   		type:'post',
		    	   		data:{ "captchaKey" : $("#captchaKey").val() ,
		    	   		  	   "idnum" : $("#idnum").val() , 
		    	   		       "applyTWY" : $("#applyTWY").val() ,
		    	   		       "applyMM" : $("#applyMM").val() ,
		    	   		       "applyDD" : $("#applyDD").val() ,
		    	   		       "siteId" : $("#siteId").val() ,
		    	   		       "applyReason" : $("#applyReason").val() ,
		    	   		       "captchaInput" : $("#captchaInput").val() },
		    	   		dataType:'text',
		    	   		success:function(result){
		    					$("#result").text(result);
		    					if(result == "身分驗證正確!"){
			    					$("#backregister").data("idnumbervalidateresult",$("#idnum").val())
			    					$("#backregister").trigger("click");
			    					alert("身分驗證正確!")
		    					}
		    	   		}
		    	   
		       		});
				}
			});
	</script>
	<script>
	function checkID(id) {
  		var id = document.getElementById("idnum").value;
		//建立字母分數陣列(A~Z)
		var city = new Array(1, 10, 19, 28, 37, 46, 55, 64, 39, 73, 82,
				2, 11, 20, 48, 29, 38, 47, 56, 65, 74, 83, 21, 3, 12,
				30)
		id = id.toUpperCase();
		// 使用「正規表達式」檢驗格式
		if (id.search(/^[A-Z](1|2)\d{8}$/i) == -1) {
			console.log('基本格式錯誤');
			$("#checkImg").attr("style","");
			$("#checkImg").attr("src","http://www.webhostingspree.com/magento/wp-content/themes/Magento/images/no.png");
		} else {
			//將字串分割為陣列(IE必需這麼做才不會出錯)
			id = id.split('');
			//計算總分
			var total = city[id[0].charCodeAt(0) - 65];
			for (var i = 1; i <= 8; i++) {
				total += eval(id[i]) * (9 - i);
			}
			//補上檢查碼(最後一碼)
			total += eval(id[9]);
			//檢查比對碼(餘數應為0);
			if( ((total % 10 == 0)) ) {
				$("#checkImg").attr("style","");
				$("#checkImg").attr("src","https://ojooo.com/img/packages/yes.png");
			} else {
				$("#checkImg").attr("style","");
				$("#checkImg").attr("src","http://www.webhostingspree.com/magento/wp-content/themes/Magento/images/no.png");
			}
		}
	};

	$(function () {

		$.get("<c:url value='/GetIdCheckerCaptchaServlet' />", function(responseJson) {
			console.log(responseJson);
			$("#captchaKey").val(responseJson.captchaKey);
			$("#captchaField").text(responseJson.captchaImage);
			$("#captchaImage").attr("src",$("#captchaField").val());
		}); 
	});
	
 	function refresh() {
		$.get("<c:url value='/GetIdCheckerCaptchaServlet' />", function(responseJson) {
			console.log(responseJson);
			$("#captchaKey").val(responseJson.captchaKey);
			$("#captchaField").text(responseJson.captchaImage);
			$("#captchaImage").attr("src",$("#captchaField").val());
		}); 
				
	}
</script>
</body>
</html>