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
		
		.forinput {
			font-size:1.6em;
			font-weight:600;
			color:black;
			font-family:微軟正黑體;		
		}
		
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>createPrimaryProj</title>
</head>


<body class="pink lighten-5">

	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row amber darken-2 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">建立需求計畫</h1>
	</div>	


<!-- 內容 -->
<main>
<!-- 主要版面 -->
		<div class="row">
			<div class="col l10 offset-l1">
				<div class="row card-panel hoverable">
					<form action="SchoolDemandServlet.do?type=create" method="post">
						<div class="row">
							<div class="col l2 center-align" style="border:2px solid blue;font-size:1.4em;">
								活動主題
							</div>
							<input class="col l8" type="text" id="activityTopic"/>
						</div>
					
					
					
					
					
					
					
					
					
					
					
					
					
					</form>
				</div>
			</div>
		</div>
<!-- 主要版面 -->
</main>	
<!-- 內容 -->
	
	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}" ></c:import>
	<!-- 頁尾 -->
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script>
		(function($) {
		   
			//指定ckeditor()的skin
// 			CKEDITOR.replace("content",{skin:"moono"})
			
			var title = $("#activityTopic").height();
			$(".center-align").height(title);
				
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			
		})(jQuery)
	</script>
</body>

		
</html>
