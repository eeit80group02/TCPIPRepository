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
<title>學校頁面</title>
<style>
	.forinput {
		font-size:1.6em;
		font-weight:600;
		color:black;
		font-family:微軟正黑體;		
	}
</style>
</head>
<body>

	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${school.name}</h3>
	</div>	

<main>
<!-- 主要版面 -->
<div class="row" id="mainboard">
	<!-- center -->
	<div class="col l10 offset-l1">
		<!-- 重新定義row -->
		<div class="row">
		
		
		
			<!-- 圖片 -->
			<div class="row center-align">
				<img class="card-panel hoverable" id="view" src="${school.base64String }" style="height: 358px; width: 817px;border:5px solid black;padding:0;" >
			</div>	
	

			<!-- 表單本體開始 --> 
			<form class="row card-panel hoverable green lighten-5" action="<c:url value='modifySchool.do' />" method="post" enctype="multipart/form-data" style="padding:2.5em;" id="registerform">
				<div class="col l10 offset-l1">
				<div class="row">
						<!-- 學校圖片#(封面) -->
						<div class="row">
							<div class="col l2 btn yellow lighten-5 black-text tooltipped" data-position="bottom" data-delay="50"  data-tooltip="圖檔僅接受jpg、png格式，檔案大小請勿超過2M" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
								<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">封面</span>
								<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="frontCover" accept="image/x-png, image/jpeg" name="frontCover">
							</div>
							<a id="changepassworda" href="#!" class="btn yellow lighten-5 black-text" 
								onclick="Materialize.showStaggeredList('#changepassword')"><span  style="font-family:微軟正黑體;font-size:1.5em;">修改密碼</span></a>
<!-- 							 <a href="#modal2" class="col l3 btn modal-trigger yellow lighten-5 black-text" style="font-family:微軟正黑體;font-size:1.5em;" id="idcardnumberbtn">身分驗證</a> -->
						</div>
				</div>
					
				<div class="row" style="clear:both;">
				
				<!-- 印出來、不能更動 -->
				<div class="row orange lighten-2 card-panel hoverable ">
					<!-- (教育部學校代碼)(帳號) -->
					<div class="row">
							<div class="forinput col l3 right-align">學校編號:</div>
							<input class="col l7 black-text" name="schoolId" id="schoolId" type="text" readonly="readonly" style="font-size:1.6em;font-family:微軟正黑體;">
					</div>
					<!-- 學校名稱 -->
					<div class="row">
							<div class="forinput col l3 right-align">學校名稱:</div>
							<input class="col l7 black-text"name="name" id="name" type="text" readonly="readonly" style="font-size:1.6em;font-family:微軟正黑體;">
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
					<div class="row input-field" >
						<input id="url" type="text" class="validate" name="url"  value="${school.url}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.url}${MsgErr.url}</font>
						<label for="url" style="font-size:1.3em;font-weight:600;">學校網址</label>
											
					</div>
					
				<!-- 學校行政電話總機 -->
					<div class="row input-field">
						<input id="phone" type="text" class="validate" name="phone" value="${school.phone}">
<!-- 							                   		後端錯誤訊息顯示 -->
							<font color="red" size="-1">${MsgErr.errCellPhoneEmpty}</font>
						<label for="phone" style="font-size:1.3em;font-weight:600;">行政電話總機</label>					
					</div>
					
				<!-- 關於我 -->
					
					<div class="input-field row">
						<div class="row">
							<div class="forinput left-align">
								關於我
							</div>						
						</div>

						<textarea class="ckeditor" name="content" id="content">${school.aboutMe}</textarea>
						<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.textAreaLimit}</font>
					</div>

				<!-- 聯絡人姓名 -->
					<div class="row input-field">
						<input id="projectManager" type="text" class="validate" name="projectManager"
							 required value="${school.projectManager}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorEmailEmpty}${MsgErr.errorEmailExists}</font>					
						<label for="projectManager" style="font-size:1.3em;font-weight:600;">聯絡人姓名</label>	
					</div>
					
				<!-- 聯絡人電話(留學校完整電話+分機) -->
					<div class="row input-field tooltipped" data-position="left" data-delay="50" data-tooltip="請留學校電話(含分機號碼)" >
						<input id="accountContact tooltipped" type="text" class="validate" name="accountContact"
							 required value="${school.accountContact}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorAddressEmpty}</font>						
						<label for="accountContact" style="font-size:1.3em;font-weight:600;">聯絡人電話</label>
					</div>

				<!-- 聯絡人email -->
					<div class="row input-field">
						<input id="managerEmail" type="text" class="validate" name="managerEmail" required value="${school.managerEmail}">
<!-- 													後端錯誤訊息顯示 -->
						<font color="red" size="-1">${MsgErr.errorAddressEmpty}</font>						
						<label for="managerEmail" style="font-size:1.3em;font-weight:600;">email</label>
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
			//彈出修改密碼的必填欄位
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
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//學校名稱margin-top,margin-left
			var namediv = $("#membername").height();
			$("#membername").css({
				"margin-top":(pagetitleheight - namediv)/2
				,"margin-left":($(window).width()) * 0.2});
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

