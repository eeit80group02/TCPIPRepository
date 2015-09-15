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
<body>
	
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

<!-- 主要版面 -->
<main>
	<!-- main row -->
	<div class="row">
		
		<!-- 建立初步計畫的表單 col l8 -->
		<div class="col l8">
			<h3>建立初步計畫</h3>
			<form action="<c:url value="/primaryProj.do" />" method="post" enctype="multipart/form-data">
			
		<!-- 	隱藏欄位 之後必須從 session 取出會員ID -->
			<input type="hidden" name="memberId" value="${LoginOK.memberId}" /><br>
			計畫名稱<input type="text" name="title" value="${param.title}" /><span class="error">${error.title}</span><br>
			計畫封面<input type="file" id="pitcture" name="imgFile" accept="image/jpeg,image/png" /><span class="error">${error.imgFile}</span><br>
			計畫摘要<textarea rows="10" cols="100" name="projAbstract">${param.projAbstract}</textarea><span class="error">${error.projAbstract}</span><br>
			計畫內容<textarea rows="10" cols="100" name="content">${param.content}</textarea><span class="error">${error.content}</span><br>
			理想地點<input type="text" value="${param.location}"  name="location"><span class="error">${error.location}</span><br>
			活動時間<input type="date" value="${param.startTime}" name="startTime"> ~ <input type="date" value="${param.endTime}" name="endTime"><span class="error">${error.startTime}${error.endTime}</span><br>
			預計人數<input type="number" value="${param.demandNum}" name="demandNum" /><span class="error">${error.demandNum}</span><br>
			活動預算<input type="number" value="${param.budget}" name="budget" /><span class="error">${error.budget}</span><br>
			<input type="hidden" name="type" value="create" />
			
				<div class="col l2">
					<img class="card-panel hoverable" id="view" src="" style="height:210px; width: 310px;border:5px solid black;padding:0;" >
				</div>
			<input type="submit" value="送出">
			</form>
		</div>
		<!-- 建立初步計畫的表單 col l8 -->
	</div>
	<!-- main row -->
</main>	
<!-- 主要版面 -->
	
	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}" ></c:import>
	<!-- 頁尾 -->
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	

</body>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>
		$(function() {
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