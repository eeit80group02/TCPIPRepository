<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�s���ǮջݨD</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">	
</head>
<body>

	<!-- ���� -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- ���� -->

	<!-- �����D�D���� -->
	<div class="row grey darken-4 valign-wrapper" id="pagetitle">
		<h1 class="valign center-align white-text"
			style="font-family: �L�n������; margin: 0 auto; font-size: 5em;">�s���ݨD�p�e</h1>
	</div>
	<!-- �����D�D���� -->
	
<main>
	<div class="row" id="mainboard">
		
		<!-- �z�����m�� -->
<!-- 		<div class="row"> -->
<!-- 				<div class="col l12 center-align"> -->
<!-- 					<button class="btn-large red" style="font-family:�L�n������;font-size:2em;font-weight:600">�_���a��</button> -->
<!-- 					<button class="btn-large red" style="font-family:�L�n������;font-size:2em;font-weight:600">�����a��</button> -->
<!-- 					<button class="btn-large red" style="font-family:�L�n������;font-size:2em;font-weight:600">�n���a��</button> -->
<!-- 					<button class="btn-large red" style="font-family:�L�n������;font-size:2em;font-weight:600">�F���a��</button> -->
<!-- 				</div> -->
<!-- 		</div>		 -->
		
		<!-- 8��m�� -->
		<div class="col l10 offset-l1">
          	<!-- 8�歫�s�w�q��row -->
          	<div class="row">
          		<!-- ��d�� -->
          		<div class="row">
          			<!-- �d -->
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
								         	  	�ݨD�p�e�W��${bean.activityTopic}
								            </div>
							            </div>
							            <div class="row" style="font-size:1.4em;font-family:�з���;font-weight:600">
							            	�ǮզW��:${bean.schoolBean.name}
							            </div>	            	
							            <div class="row" style="font-size:1.4em;font-family:�з���;font-weight:600">
							            	���ʦa�I:${bean.activityLocation}
							            </div>	            	
							            <div class="row" style="font-size:1.4em;font-family:�з���;font-weight:600">
							            	�o���ɶ�:${bean.createDate}
							            </div>	            	
							            <div class="row right-align" style="font-size:1.4em;font-family:�з���;font-weight:600">
							            	<a class="btn indigo" href="${path}">take a look</a>
							            </div>	            	
				     		</div>
			     		</c:forEach>
		     		</c:if>	          		
          		</div>
          	</div>
			<!-- 8�歫�s�w�q��row -->
		
		</div>
		<!-- 8��m�� -->
	
	
	</div>

</main>
<!-- ���� -->
<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
<!-- ���� -->

	<script>
		$(function() {
			//mainboard�̤p����
			$("#mainboard").css("min-height","100vh");
			
			//���ܭ����D�D�檺����
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//navagation�Wlogo������
			$("img[title='TCPIP']").attr("height", "70");
			//�]�wbody�e�׬�100%
			$("body").css("width", "100%").css("height", "100%");
		})
	</script>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" 
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	

</body>
</html>