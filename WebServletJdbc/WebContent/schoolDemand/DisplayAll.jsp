<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>瀏覽學校需求</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
</head>
<body>

	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">瀏覽需求計畫</h1>
	</div>
	<!-- 頁面主題提示 -->
	
<main>
	<div class="row" id="mainboard">
		
		<!-- 篩選條件置頂 -->
<!-- 		<div class="row"> -->
<!-- 				<div class="col l12 center-align"> -->
<!-- 					<button class="btn-large red" style="font-family:微軟正黑體;font-size:2em;font-weight:600">北部地區</button> -->
<!-- 					<button class="btn-large red" style="font-family:微軟正黑體;font-size:2em;font-weight:600">中部地區</button> -->
<!-- 					<button class="btn-large red" style="font-family:微軟正黑體;font-size:2em;font-weight:600">南部地區</button> -->
<!-- 					<button class="btn-large red" style="font-family:微軟正黑體;font-size:2em;font-weight:600">東部地區</button> -->
<!-- 				</div> -->
<!-- 		</div>		 -->
		
		<!-- 8欄置中 -->
		<div class="col l10 offset-l1">
          	<!-- 8欄重新定義為row -->
          	<div class="row">
          		<!-- 放卡片 -->
          		<div class="row">
          			<!-- 卡 -->
          			<c:if test="${not empty mlist}">
          				<c:forEach items="${mlist}" var="bean">
				          	<div class="col l5 white offset-l1 card-panel hoverable" style="padding:5px;">
				          		<c:url value="/schoolDemand/SchoolDemandServlet.do?type=display" var="path">
									<c:param name="type" value="mdisplay" />
									<c:param name="schoolDemandId" value="${bean.schoolDemandId}" />
									<c:param name="schoolId" value="${bean.schoolId}" />
								</c:url>
										<div class="row">
											<i class="col l2 material-icons red-text medium">
												loyalty
											</i>								
								            <div class="col l10 card-title black-text center-align" style="font-size:1.6em;font-weight:600;line-height:160%;">
								         	  	需求計畫名稱${bean.activityTopic}
								            </div>
							            </div>
							            <div class="row" style="font-size:1.4em;font-family:標楷體;font-weight:600">
							            	學校名稱:${bean.schoolBean.name}
							            </div>	            	
							            <div class="row" style="font-size:1.4em;font-family:標楷體;font-weight:600">
							            	活動地點:${bean.activityLocation}
							            </div>	            	
							            <div class="row" style="font-size:1.4em;font-family:標楷體;font-weight:600">
							            	發布時間:${bean.createDate}
							            </div>	            	
							            <div class="row right-align" style="font-size:1.4em;font-family:標楷體;font-weight:600">
							            	<a class="btn indigo" href="${path}">take a look</a>
							            </div>	            	
				     		</div>
			     		</c:forEach>
		     		</c:if>	          		
          		</div>
          	</div>
			<!-- 8欄重新定義為row -->
		
		</div>
		<!-- 8欄置中 -->
	
	
	</div>

</main>
<!-- 頁尾 -->
<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
<!-- 頁尾 -->

	<script>
		$(function() {
			//mainboard最小高度
			$("#mainboard").css("min-height","100vh");
			
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
		})
	</script>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" 
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	

</body>
</html>