<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayPrimaryProjAll</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<body class="deep-orange lighten-5">
	
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->  


	
	
	<!-- 頁面主題提示 -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">洽談中</h1>
	</div>
	
	
	<!-- 內容 -->
	<main>
		<div class="row">
			<c:set var="listlength" value="${fn:length(list)}" />
			<div class="col l8 offset-l2 indigo lighten-5">
				<div class="row center-align card-panel red-text" style="font-size:4em;">
					洽談中需求計畫
				</div>
				
					<!-- 同意或拒絕 -->
<%-- 		<c:forEach items="${primaryProj}" var="bean"> --%>
			<div class="row card-panel">
				<!-- 需求計畫名稱 -->
				<div class="row priProjName left-align teal-text darken-3">
					哈哈哈營隊${demand.activityTopic}
				</div>
				<!-- 有意願的志工 forEach在這 -->
<%-- 				<c:forEach items="${bean.processingProjBean}" var="processingProj"> --%>
					<div class="row card-panel light-blue lighten-4">
						<div class="col l4 left schldiv center-align">
							郭文豪${pMBean.memberBean.lastName}${pMBean.memberBean.firstName}
						</div>
						<div class="col l4 left schldiv" >
							已被推薦次數:${pMBean.memberBean.RecommendCount}
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
<%-- 				</c:forEach> --%>
			</div>
<%-- 		</c:forEach> --%>
		<!-- 同意或拒絕 -->	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
<!-- 				<div class="row card-panel"> -->
<%-- 					<c:forEach items="${list}" var="demand"> --%>
<!-- 						<div class="row card-panel yellow lighten-1"> -->
<!-- 					      <ul class="collection with-header"> -->
<%-- 					        <li class="collection-header"><h4>${demand.activityTopic}</h4></li> --%>
<%-- 					        <c:forEach items="${demand.processingMemberBean}" var="pMBean"> --%>
<!-- 					        		<li class="collection-item"> -->
<!-- 					        			<div class="row left-align"> -->
<%-- 					        				${pMBean.memberBean.lastName} --%>
<!-- 					        					<button class="secondary-content btn"> -->
<!-- 					        						同意 -->
<!-- 					        					</button> -->
<!-- 					        			</div> -->
<!-- 					        		</li> -->
<%-- 					        </c:forEach> --%>
<!-- 					      </ul> -->
<!-- 						</div> -->
<%-- 					</c:forEach> --%>
<!-- 				</div> -->
				
			</div>			
			

		</div>
	</main>


	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->  

	<!-- script -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
		})
	</script>
	<script>
		//响應式高度
		$(window).on("resize", function() {
			var pagetitleheight2 = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight2);
		});
	</script>
</body>
</html>