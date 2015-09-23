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
<title>displayPersonalPrimaryProjByPending</title>
<style>
	.priProjName{
		font-size:3em;
		font-family:微軟正黑體;
		font-weight:600;
	}
	
	.btndiv{
		font-size:1.6em;
		font-family:微軟正黑體;
		font-weight:600;
	}
	
	.schldiv{
		font-size:1.6em;
		font-family:微軟正黑體;
		font-weight:600;
	}	

</style>
</head>
<body>
	<c:if test="${LoginOK.beanName.equals('school') }">
		<c:redirect url="/error/permission.jsp" />
	</c:if>
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${LoginOK.lastName}${LoginOK.firstName}</h3>
	</div>	

<main>
<!-- 主要版面 -->
<div class="row" id="mainboard">
	<div class="col l8 offset-l2 indigo lighten-5">
		<div class="row center-align card-panel blue-text" style="font-size:4em;">審核初步計畫</div>
		
		<!-- 查看初步計畫 -->
<!-- 		<div class="row card-panel" > -->
<!-- 			<table class="bordered highlight"> -->
<!-- 				<thead style="font-size:2em;"> -->
<!-- 					<tr> -->
<!-- 						<th>初步計畫編號</th> -->
<!-- 						<th>初步計畫標題</th> -->
<!-- 						<th>link</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody> -->
<%-- 					<c:forEach var="bean" items="${primaryProj}"> --%>
<!-- 						<tr> -->
<%-- 							<td>${bean.primaryProjId}</td> --%>
<%-- 							<td>${bean.title}</td> --%>
<%-- 								<c:url value="/primaryProj.do" var="path"> --%>
<%-- 									<c:param name="type" value="display" /> --%>
<%-- 									<c:param name="primaryProjId" value="${bean.primaryProjId}" /> --%>
<%-- 								</c:url> --%>
<%-- 							<th><a href="${path}" class="btn-large yellow lighten-5 black-text">查看</a></th> --%>
<!-- 						</tr> -->
<%-- 					</c:forEach>			 --%>
<!-- 				</tbody> -->
<!-- 			</table>			 -->
<!-- 		</div> -->
		


		<!-- 同意或拒絕 -->
		<c:forEach items="${primaryProj}" var="bean">
			<div class="row card-panel">
				<!-- 初步計畫名稱 -->
				<div class="row priProjName left-align teal-text darken-3">
					初步計畫名稱${bean.title}
				</div>
				<!-- 有意願的學校 forEach在這 -->
				<c:forEach items="${bean.processingProjBean}" var="processingProj">
					<div class="row card-panel light-blue lighten-4">
						<div class="col l4 left schldiv center-align">
							市立瑞穗國小${processingProj.schoolBean.name}
						</div>
						<div class="col l4 left schldiv" >
							台中市${processingProj.schoolBean.addressDistrict}
						</div>
						<div class="col l4 right right-align">
								<form action="<c:url value="/ProcessingProj.do" />" method="post">
									<input type="hidden" name="processingProjId" value="${processingProj.processingProjId}">
									<input type="hidden" name="type" value="cancel">
									<button class="btn red white-text btndiv right" type="submit">拒絕</button>
								</form>						
								<form action="<c:url value="/ProcessingProj.do" />" method="post">
									<input type="hidden" name="processingProjId" value="${processingProj.processingProjId}">
									<input type="hidden" name="type" value="agree">
									<button class="btn red white-text btndiv right" type="submit">同意</button>
								</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
		<!-- 同意或拒絕 -->





		
		<!-- 同意或拒絕 -->
<!-- 		<div class="row card-panel" > -->
<!-- 			<table class="bordered highlight"> -->
<!-- 				<thead style="font-size:2em;"> -->
<!-- 					<tr> -->
<!-- 						<th>初步計畫編號</th> -->
<!-- 						<th>初步計畫標題</th> -->
<!-- 						<th>接洽學校</th> -->
<!-- 						<th>所在縣市</th> -->
<!-- 						<th>是否同意</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody style="font-size:1em;"> -->
<%-- 					<c:forEach var="bean" items="${primaryProj}"> --%>
<%-- 						<c:forEach var="processingProj" items="${bean.processingProjBean}"> --%>
<!-- 							<tr> -->
<!-- 								初步計畫編號 -->
<%-- 								<td>${bean.primaryProjId}</td> --%>
<!-- 								初步計畫標題 -->
<%-- 								<td>${bean.title}</td> --%>
<!-- 								有意接洽的學校 -->
<%-- 								<td>${processingProj.schoolBean.name}</td> --%>
<!-- 								該學校的所在縣市 -->
<%-- 								<td>${processingProj.schoolBean.addressDistrict}</td> --%>
<!-- 								<td> -->
<%-- 									<form action="<c:url value="/ProcessingProj.do" />" method="post"> --%>
<%-- 										<input type="hidden" name="processingProjId" value="${processingProj.processingProjId}"> --%>
<!-- 										<input type="hidden" name="type" value="agree"> -->
<!-- 										<button class="btn yellow lighten-5 black-text" type="submit" style="font-size:1.5em;font-weight:600;font-family:微軟正黑體">同意</button> -->
<!-- 									</form> -->
<%-- 									<form action="<c:url value="/ProcessingProj.do" />" method="post"> --%>
<%-- 										<input type="hidden" name="processingProjId" value="${processingProj.processingProjId}"> --%>
<!-- 										<input type="hidden" name="type" value="cancel"> -->
<!-- 										<button class="btn red lighten-4 black-text" type="submit" style="font-size:1.5em;font-weight:600;font-family:微軟正黑體">拒絕</button> -->
<!-- 									</form>								 -->
<!-- 								</td> -->
<!-- 							</tr> -->
<%-- 						</c:forEach> --%>
<%-- 					</c:forEach>				 --%>
<!-- 				</tbody> -->
<!-- 			</table>			 -->
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
