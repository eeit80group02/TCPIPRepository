<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
<title>personal</title>
</head>
<body>

	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">郭文豪${LoginOK.lastName}${LoginOK.firstName}</h3>
	</div>	

<main>
<!-- 主要版面 -->
<div class="row" id="mainboard">
	<!-- center -->
	<div class="col l10 offset-l1">
		
		
		
		<!-- 帳號管理 -->
		<div class="col l12" id="accountmanager">
			<!-- 圖片 -->
			<div class="col l2">
				<div class="row">
					<img class="card-panel hoverable" id="view" src="" style="height: 6.75cm; width: 5.25cm;border:5px solid black;padding:0;" >
				</div>
				<div class="row">
					<a href="<c:url value='personmanager.jsp' />" class="col l12 btn-large yellow lighten-5 black-text" style="width: 5.25cm;">
						<span  style="font-family:微軟正黑體;font-size:1.2em;">
							回會員中心
						</span>
					</a>
				</div>				
			</div>	
			<!-- 表單本體開始 --> 
			<form class="card-panel hoverable green lighten-5 col l10" action="<c:url value='register.do' />" method="post" enctype="multipart/form-data" style="padding:2.5em;" id="registerform">

				<div class="row">
						<!-- 頭像上傳 -->
						<div class="row">
							<div class="col l2 btn yellow lighten-5 black-text tooltipped" data-position="bottom" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
								<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">頭像</span>
								<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="picture" accept="image/x-png, image/jpeg" name="picture">
							</div>
							<a id="changepassworda" href="#!" class="btn yellow lighten-5 black-text" 
								onclick="Materialize.showStaggeredList('#changepassword')"><span  style="font-family:微軟正黑體;font-size:1.2em;">修改密碼</span></a>
<!-- 							 <a href="#modal2" class="col l3 btn modal-trigger yellow lighten-5 black-text" style="font-family:微軟正黑體;font-size:1.5em;" id="idcardnumberbtn">身分驗證</a> -->
						</div>
				</div>
					
					
					
						<ul id="changepassword" style="display:none;">
							<li style="opacity:0;">	
								<!-- 密碼 -->
								<div class="input-field row">
									<input id="passwords" type="password" class="validate" name="password" required>
				<!-- 														後端錯誤訊息顯示 -->
									<font color="red" size="-1">${MsgErr.errorPasswordEmpty}</font>
									<label for="passwords" style="font-size:1.3em;font-weight:600;">密碼</label>
								</div>
							</li>
							<li style="opacity:0;">							
								<!-- 密碼確認 -->
								<div class="input-field row">
									<input id="check" type="password" class="validate" name="check" required>
				<!-- 														後端錯誤訊息顯示 -->
									<font color="red" size="-1">${MsgErr.errorCheckEmpty}</font>
									<label for="check" style="font-size:1.3em;font-weight:600;">密碼確認</label>
								</div>
							</li>	
						</ul>		
					
					
					
				<div class="row" style="clear:both;">
				<!-- 姓氏 -->
					<div class="col l6 input-field left" style="padding-left:0;">
						<input id="lastName" type="text" class="validate" name="lastName" required value="${param.lastname}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorLastNameEmpty}</font>
						<label for="lastName" style="font-size:1.3em;font-weight:600;">姓氏</label>
					</div>				
				
				<!-- 名字 -->
					<div class="col l6 input-field left">
						<input id="firstName" type="text" class="validate" name="firstName" required value="${param.firstname}" >
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorFirstNameEmpty}</font>
						<label for="firstName" style="font-size:1.3em;font-weight:600;">名字</label>
					</div>
				</div>
				
				<!-- 電話 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：02-66666631" >
						<input id="idNumber" type="text" class="validate" name="phone"  value="${param.phone}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errorAccountEmpty}${MsgErr.errorAccountExists}</font>
						<label for="idNumber" style="font-size:1.3em;font-weight:600;">室內電話</label>
											
					</div>
					
				<!-- 手機 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：0912-345678">
						<input id="phone" type="text" class="validate" name="cellPhone" value="${param.cellPhone}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errCellPhoneEmpty}</font>
						<label for="phone" style="font-size:1.3em;font-weight:600;">手機</label>					
					</div>
					
				<!-- 生日 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：2015-10-07">
						<input id="birthday" type="text" class="validate" name="birthday" required value="${param.birthday}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorBirthdayStrEmpty}${MsgErr.errFormat}</font>				
						<label for="birthday" style="font-size:1.3em;font-weight:600;">生日</label>	
					</div>

				<!-- Email -->
					<div class="row input-field">
						<input id="email" type="text" class="validate" name="email" required value="${param.email}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorEmailEmpty}${MsgErr.errorEmailExists}</font>					
						<label for="email" style="font-size:1.3em;font-weight:600;">E-mail</label>	
					</div>
					
				<!-- Address -->
					<div class="row input-field">
						<input id="address" type="text" class="validate" name="address" required value="${param.address}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorAddressEmpty}</font>						
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
		
		
		
		</div>
	</div>
<!-- 主要版面 -->

</main>



	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}" ></c:import>
	<!-- 頁尾 -->


<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script>
		(function($) {
			
			//body的最小高度
			$("#mainboard").css("min-height","100vh");
			//show出修改密碼
			$("#changepassworda").on("click",function(){
				$("#changepassword").css("display","block");	
			})
			//預覽圖片
			$("#picture").change(function(){
				var file = $("#picture")[0].files[0];
				var reader  = new FileReader();
				reader.onloadend = function () {
					console.log(reader.result);
					$("#view").attr("src", reader.result);
			}
				if(file){
					reader.readAsDataURL(file);
				}
			})
			//點擊圖片也能上傳頭像
			$("#view").on("click",function(){
				$("#picture").trigger("click");
			})
			//blur
			$("input").each(function(){
				$(this).on("blur",function(){
					if($(this).val() !== "" || $(this).val().length !== 0){
						$(this).addClass("yellow lighten-4");
					}else{
						if($(this).hasClass("yellow lighten-4")){
							$(this).removeClass("yellow lighten-4")
						}
					}
				})
			})
			
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//會員名稱margin-top,margin-left
			var namediv = $("#membername").height();
			$("#membername").css({
				"margin-top":(pagetitleheight - namediv)/2
				,"margin-left":($(window).width()) * 0.2});
			
			//表單驗證
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
//						rule1 = /^[0]{1}(?=.*\d).{9}/
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
			if($("#passwords").val() !== "" || $("#check").val() !== ""){
				if(
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
			}else{
				if(
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
		})(jQuery)
	</script>
	<script>
		//响應式高度
		$(window).on("resize", function() {
			var pagetitleheight2 = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight2);
			//會員名稱margin-top,margin-left
			var namediv = $("#membername").height();
			$("#membername").css({
				"margin-top":(pagetitleheight2 - namediv)/2
				,"margin-left":($(window).width()) * 0.2});
			
		});
	</script>

</body>
</html>
