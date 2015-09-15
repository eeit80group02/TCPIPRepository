<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
	<style>
		.error{
			color:#FF0000;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>createPrimaryProj</title>
</head>
<body class="light-blue lighten-5">
	
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">建立初步計畫</h1>
	</div>


<!-- 主要版面 -->
<main>
	<!-- main row -->
<!-- 	<div class="row"> -->
		
		<!-- 建立初步計畫的表單 col l8 -->
<!-- 		<div class="col l8 offset-l2"> -->
			
			<!-- 內部的row -->
<!-- 			<div class="row"> -->
<%-- 				<form action="<c:url value="/primaryProj.do" />" method="post" enctype="multipart/form-data" class="white" style="padding:2.5em;"> --%>
				
			<!-- 	隱藏欄位 之後必須從 session 取出會員ID -->
<%-- 				<input type="hidden" name="memberId" value="${LoginOK.memberId}" /><br> --%>
<%-- 				計畫名稱<input type="text" name="title" value="${param.title}" /><span class="error">${error.title}</span><br> --%>
<%-- 				計畫封面<input type="file" id="pitcture" name="imgFile" accept="image/jpeg,image/png" /><span class="error">${error.imgFile}</span><br> --%>
<%-- 				理想地點<input type="text" value="${param.location}"  name="location"><span class="error">${error.location}</span><br> --%>
<%-- 				活動時間<input type="date" value="${param.startTime}" name="startTime"> ~ <input type="date" value="${param.endTime}" name="endTime"><span class="error">${error.startTime}${error.endTime}</span><br> --%>
<%-- 				預計人數<input type="number" value="${param.demandNum}" name="demandNum" /><span class="error">${error.demandNum}</span><br> --%>
<%-- 				活動預算<input type="number" value="${param.budget}" name="budget" /><span class="error">${error.budget}</span><br> --%>
<%-- 				計畫摘要<textarea rows="10" cols="100" name="projAbstract">${param.projAbstract}</textarea><span class="error">${error.projAbstract}</span><br> --%>
<%-- 				計畫內容<textarea rows="10" cols="100" name="content">${param.content}</textarea><span class="error">${error.content}</span><br> --%>
<!-- 				<input type="hidden" name="type" value="create" /> -->
				
<!-- 					<div class="col l2"> -->
<!-- 						<img class="card-panel hoverable" id="view" src="" style="height:210px; width: 310px;border:5px solid black;padding:0;" > -->
<!-- 					</div> -->
<!-- 				<input type="submit" value="送出"> -->
<!-- 				</form> -->
				
<!-- 			</div> -->
			<!-- 內部的row -->
<!-- 		</div> -->
		<!-- 建立初步計畫的表單 col l8 -->
		
		<!-- 放預覽圖片的 -->
<!-- 		<div> -->
		
		
<!-- 		</div> -->
<!-- 	</div> -->
	<!-- main row -->
	<div class="row">
		
		<!-- 切版面開始 -->
		<div class="col l8">
			<!-- 表單本體開始 -->
			<form class="card-panel hoverable green lighten-5" action="#" method="get" enctype="multipart/form-data" style="padding:2.5em;" id="registerform">

				<div class="row">
						<!-- 計畫名稱 -->
<%-- 						<input type="text" name="title" value="${param.title}" /><span class="error">${error.title}</span>--%>
						<div class="input-field row">
							<input id="title" type="text" name="title" required value="${param.title}">
							<label for="title" style="font-size:1.3em;font-weight:600;">計畫名稱</label>
						</div>
<%-- 						<input type="file" id="pitcture" name="imgFile" accept="image/jpeg,image/png" /><span class="error">${error.imgFile}</span> --%>
						<!-- 計畫封面 -->
						<div class="file-field input-field row">
							<div class="btn" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
								<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">封面</span>
								<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="pitcture" accept="image/jpeg,image/png" name="imgFile">
      						</div>
						</div>
						<!-- 理想地點 -->
<%-- 						<input type="text" value="${param.location}"  name="location"><span class="error">${error.location}</span> --%>
						<div class="row">
						<div class="input-field">
							<label for="siteId">理想地點</label>
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
							</select>
						</div>
						</div>						
						<!-- 密碼確認 -->
						<div class="input-field row">
							<input id="check" type="password" class="validate" name="check" required>
							<label for="check" style="font-size:1.3em;font-weight:600;">密碼確認</label>
						</div>

				
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
<!-- 主要版面 -->
	
	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}" ></c:import>
	<!-- 頁尾 -->
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	

</body>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>
		$(function() {
			//初始化理想地點
			$("select").material_select();
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			
			//
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

		
</html>