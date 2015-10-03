<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
<title>洽談中完整計畫</title>
</head>
<body>

	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${LoginOK.name}</h3>
	</div>	

<main>
<!-- 主要版面 -->
<div class="row" id="mainboard">
	<div class="col l8 offset-l2 indigo lighten-5">
		<div class="row center-align card-panel blue-text" style="font-size:4em;">洽談中完整計畫</div>
		<div class="row card-panel" >
			<table class="bordered highlight centered">
				<thead style="font-size:2em;">
					<tr>
						<th>完整計畫標題</th>
						<th>發起者</th>
						<th>時間</th>
						<th>link</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${fullProj}">
						<tr>
							<td style="font-size:1.6em;font-weight:600">${bean.title}</td>
							<td>${bean.memberBean.lastName}${bean.memberBean.firstName}</td>
							<td><fmt:formatDate value="${bean.activityStartTime}" pattern="yyyy-MM-dd"/>~<fmt:formatDate value="${bean.activityEndTime}" pattern="yyyy-MM-dd"/></td>
								<c:url value="/fullProj.do" var="path">
									<c:param name="type" value="displayFullProjByChat" />
									<c:param name="fullProjId" value="${bean.fullProjId}" />
								</c:url>
							<td><a href="${path}" class="btn-large yellow lighten-5 black-text" style="font-size:1.4em;font-weight:600">洽談</a></td>	
						
						</tr>
					</c:forEach>			
				</tbody>
			</table>			
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
