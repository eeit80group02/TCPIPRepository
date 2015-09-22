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
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">學校名稱 ${school.name}</h3>
	</div>	

<main>
<!-- 主要版面 -->
<div class="row" id="mainboard">
	<!-- center -->
	<div class="col l10 offset-l1">
		<div class="col l12" >
	      <ul class="tabs" id="tabsul">
	        <li class="tab col s3 yellow accent-1"><a class="black-text" href="#accountmanager" style="font-family:微軟正黑體;font-weight:600;">學校個人頁面</a></li>
	        <li class="tab col s3 "><a class="black-text" href="#projinfos" style="font-family:微軟正黑體;font-weight:600;">瀏覽計畫需求挑選發起者</a></li>
	        <li class="tab col s3 "><a class="black-text" href="#follow" style="font-family:微軟正黑體;font-weight:600;">瀏覽參予過的初步計畫</a></li>
	        <!-- 自行繼續新增 -->
<!-- 	        <li class="tab col s3"><a href="#test4">Test 4</a></li> -->
	      </ul>		
		</div>
		
			
	
	
	
	
		
		<!-- 帳號管理 -->
		<div class="col l12" id="accountmanager">
			<!-- 圖片 -->
			<div class="col l2">
				<img class="card-panel hoverable" id="view" src="${school.base64String }" style="height: 6.75cm; width: 5.25cm;border:5px solid black;padding:0;" >
			</div>	
			<!-- 表單本體開始 --> 
			<form class="card-panel hoverable green lighten-5 col l10" action="<c:url value='modifySchool.do' />" method="post" enctype="multipart/form-data" style="padding:2.5em;" id="registerform">

				<div class="row">
						<!-- 學校圖片#(封面) -->
						<div class="row">
							<div class="col l2 btn yellow lighten-5 black-text tooltipped" data-position="bottom" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
								<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">封面</span>
								<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="frontCover" accept="image/x-png, image/jpeg" name="frontCover">
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
									<input id="passwords" type="password" class="validate" name="password">
				<!-- 														後端錯誤訊息顯示 -->
									<font color="red" size="-1">${MsgErr.errorPasswordEmpty}</font>
									<label for="passwords" style="font-size:1.3em;font-weight:600;">密碼</label>
								</div>
							</li>
							<li style="opacity:0;">							
								<!-- 密碼確認 -->
								<div class="input-field row">
									<input id="check" type="password" class="validate" name="check">
				<!-- 														後端錯誤訊息顯示 -->
									<font color="red" size="-1">${MsgErr.errorCheckEmpty}</font>
									<label for="check" style="font-size:1.3em;font-weight:600;">密碼確認</label>
								</div>
							</li>	
						</ul>		
					
				<div class="row" style="clear:both;">
				
						<!-- 印出來、不能更動 -->
						<div class="row orange accent-3">
							<!-- (教育部學校代碼)(帳號) -->
							<div class="row">
								<div class="col l8">
									<div class="forinput">學校編號:</div>
									<input type="hidden" name="schoolId" value="${school.schoolId}">
								</div>
							</div>						
							<!-- 學校名稱 -->
							<div class="row">
								<div class="col l8">
									<div class="forinput">學校名稱:${param.fullProjId}</div>
									<input type="hidden" name="name" value="${school.name}">
								</div>
							</div>
						</div>						
				
				
				
				<!-- 學校地址(縣市) -->
					<div class="col l6 input-field left" style="padding-left:0;">
						<input id="addressDistrict" type="text" class="validate" name="addressDistrict" required value="${school.addressDistrict}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.addressDistrict}</font>
						<label for="addressDistrict" style="font-size:1.3em;font-weight:600;">學校地址(縣市)</label>
					</div>				
				
				<!-- 學校地址(完整) -->
					<div class="col l6 input-field left">
						<input id="addressComplete" type="text" class="validate" name="addressComplete" required value="${school.addressComplete}" >
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.addressComplete}</font>
						<label for="addressComplete" style="font-size:1.3em;font-weight:600;">學校地址(完整)</label>
					</div>
				</div>
				
				<!-- 學校網址 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="" >
						<input id="url" type="text" class="validate" name="url"  value="${school.url}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.url}${MsgErr.url}</font>
						<label for="url" style="font-size:1.3em;font-weight:600;">學校網址</label>
											
					</div>
					
				<!-- 學校行政電話總機 -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50"  data-tooltip="範例：02-66666631">
						<input id="phone" type="text" class="validate" name="phone" value="${school.phone}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errCellPhoneEmpty}</font>
						<label for="phone" style="font-size:1.3em;font-weight:600;">行政電話總機</label>					
					</div>
					
				<!-- 關於我 -->
					
					<div class="input-field row">
						<div>關於我</div>
						<textarea class="ckeditor" name="content" id="content" maxlength="10">${school.aboutMe}</textarea>
						<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.textAreaLimit}</font>
					</div>

				<!-- 聯絡人姓名 -->
					<div class="row input-field">
						<input id="email" type="text" class="validate" name="projectManager" required value="${school.projectManager}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorEmailEmpty}${MsgErr.errorEmailExists}</font>					
						<label for="email" style="font-size:1.3em;font-weight:600;">聯絡人姓名</label>	
					</div>
					
				<!-- 聯絡人電話(留學校完整電話+分機) -->
					<div class="row input-field">
						<input id="address" type="text" class="validate" name="accountContact" required value="${school.accountContact}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorAddressEmpty}</font>						
						<label for="address" style="font-size:1.3em;font-weight:600;">聯絡人電話</label>
					</div>

				<!-- 聯絡人email -->
					<div class="row input-field">
						<input id="address" type="text" class="validate" name="managerEmail" required value="${school.managerEmail}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorAddressEmpty}</font>						
						<label for="address" style="font-size:1.3em;font-weight:600;">email</label>
					</div>
					
				<!-- button -->
					<div class="row" id="btndiv">
						<button  class="col l2 btn-large right yellow lighten-5 black-text" type="reset" name="action">
							<span style="font-family:微軟正黑體;font-size:1.3em;">取消</span>
						</button>
						<button  class="col l2 btn-large right yellow lighten-5 black-text" type="submit" name="action" id="submitbtn">
							<span style="font-family:微軟正黑體;font-size:1.3em;">送出</span>
						</button>

					</div>
				</form>
				
		
		
		
		
		
		</div>
		
		
		<!-- 計畫資訊 -->
<!-- 		<div class="col l10" id="projinfos"> -->
<!-- 			<div class="row"> -->
<!-- 				<a class="btn-large purple lighten-5 black-text"  -->
<%-- 					href="<c:url value='/primaryProj.do?type=displayPersonal&memberId=${LoginOK.memberId}' />" > --%>
<!-- 						<span style="font-family:微軟正黑體;font-size:1.5em;">曾發布的初步計畫</span> -->
<!-- 					</a> -->
<!-- 			</div> -->
<!-- 			<div class="row">	 -->
<!-- 				<a class="btn-large purple lighten-5 black-text" -->
<%-- 					href="<c:url value='/primaryProj.do?type=displayPersonalByPending&memberId=${LoginOK.memberId}' />" > --%>
<!-- 					<span style="font-family:微軟正黑體;font-size:1.5em;">待審核的初步計畫</span> -->
<!-- 					</a> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<a class="btn-large purple lighten-5 black-text" -->
<%-- 				 	href="<c:url value='/fullProj.do?type=displayPersonal&memberId=${LoginOK.memberId}' />"> --%>
<!-- 				 	<span style="font-family:微軟正黑體;font-size:1.5em;">曾發布的完整計畫</span> -->
<!-- 				 	</a> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<a class="btn-large purple lighten-5 black-text" -->
<%-- 					href="<c:url value='/fullProj.do?type=displayPersonalByChat&memberId=${LoginOK.memberId}' />" > --%>
<!-- 					<span style="font-family:微軟正黑體;font-size:1.5em;">洽談中的完整計畫</span> -->
<!-- 					</a> -->
<!-- 			</div>			 -->
<!-- 		</div> -->
		
		
		<!-- 追蹤 -->
		<div class="col l10" id="follow">
		
		
		
		
		
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
			

			//tabs中li的點擊變色
			$("#tabsul>li").each(function(){
				$(this).on("click",function(){
					$("#tabsul>li").removeClass("yellow accent-1");
					$(this).addClass("yellow accent-1");
				})
			})
			
			
			//body的最小高度
			$("#mainboard").css("min-height","100vh");
			//點擊預覽圖片也能上傳檔案
			$("#changepassworda").on("click",function(){
				$("#changepassword").css("display","block");	
			})
			
			//預覽圖片
			$("#frontCover").change(function(){
				var file = $("#frontCover")[0].files[0];
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
				$("#frontCover").trigger("click");
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
			
			
			//初始化tab
			$('ul.tabs').tabs();
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
// 		$("#btndiv").on({
// 			"mouseover":function(){
// 			if($("#passwords").val() !== "" || $("#check").val() !== ""){
// 				if(
// 						$("#registerform").data().passwordresults &&
// 						$("#registerform").data().passwordresults2 &&
// 						$("#registerform").data().contactresult &&
// 						$("#registerform").data().emailresult &&
// 						$("#registerform").data().birthdayresult &&
// 						$("#lastName").val().trim() !== "" &&
// 						$("#firstName").val().trim() !== "" &&
// 						$("#address").val().trim() !== "" 
// 						){
// 							$("#submitbtn").prop("disabled",false);
// 						}else{
// 							$("#submitbtn").prop("disabled",true);
// 						}				
// 			}else{
// 				if(
// 						$("#registerform").data().contactresult &&
// 						$("#registerform").data().emailresult &&
// 						$("#registerform").data().birthdayresult &&
// 						$("#lastName").val().trim() !== "" &&
// 						$("#firstName").val().trim() !== "" &&
// 						$("#address").val().trim() !== "" 
// 				){
// 						$("#submitbtn").prop("disabled",false);
// 				}else{
// 						$("#submitbtn").prop("disabled",true);
// 					}						
// 			}

// 		},"mouseout":function(){
// 			if(
// 				$("#registerform").data().accountresults &&
// 				$("#registerform").data().passwordresults &&
// 				$("#registerform").data().passwordresults2 &&
// 				$("#registerform").data().contactresult &&
// 				$("#registerform").data().emailresult &&
// 				$("#registerform").data().birthdayresult &&
// 				$("#lastName").val().trim() !== "" &&
// 				$("#firstName").val().trim() !== "" &&
// 				$("#address").val().trim() !== "" 
				
// 			){
// 				$("#submitbtn").prop("disabled",false);
// 			}else{
// 				$("#submitbtn").prop("disabled",true);
// 			}
// 		}
// 		});
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

