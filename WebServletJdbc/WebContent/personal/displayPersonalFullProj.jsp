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
<title>displayPersonalFullProj.jsp</title>
</head>
<body>
	<c:if test="${LoginOK.beanName.equals('school') }">
		<c:redirect url="/error/permission.jsp" />
	</c:if>
<!-- //////////////////////////////發布過的完整計畫//////////////////////// -->
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
		<div class="row center-align card-panel blue-text" style="font-size:4em;">瀏覽完整計畫</div>
		<div class="row card-panel" >
			<table class="bordered highlight centered">
				<thead style="font-size:2em;">
					<tr>
						<th>完整計畫標題</th>
						<th>時間</th>
						<th>狀態</th>
						<th>link</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${fullProj}">
						<tr>
							<td style="font-size:1.6em;font-weight:600">${bean.title}</td>
							<td><fmt:formatDate value="${bean.activityStartTime}" pattern="yyyy-MM-dd"/>~<fmt:formatDate value="${bean.activityEndTime}" pattern="yyyy-MM-dd"/></td>
							<td class="red-text" style="font-size:1.4em;font-weight:600">${bean.projStatus}</td>
							<td>
								<c:choose>
									<c:when test="${bean.projStatus.equals('洽談中')}">
										<c:url value="/fullProj.do" var="path">
											<c:param name="type" value="displayFullProjByChat" />
											<c:param name="fullProjId" value="${bean.fullProjId}" />
										</c:url>
									</c:when>
									
									<c:otherwise>
										<c:url value="/fullProj.do" var="path">
											<c:param name="type" value="display" />
											<c:param name="fullProjId" value="${bean.fullProjId}" />
										</c:url>
									</c:otherwise>
								</c:choose>
								<c:url var="activity" value="/Activity/ActivityHighlightCreate.jsp">
									<c:param name="fullProjId" value="${bean.fullProjId}" />
									<c:param name="memberId" value="${bean.memberId}" />
								</c:url>

								<c:if test="${bean.projStatus.equals('已完成')}">
									<a href="${activity}" class="btn-large red white-text" style="font-size:1.4em;font-weight:600">建立花絮</a>
								</c:if>
								
								<a href="${path}" class="btn-large yellow lighten-5 black-text" style="font-size:1.4em;font-weight:600">查看</a>
							</td>
						
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
