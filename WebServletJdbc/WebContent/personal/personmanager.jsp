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
<title>personal</title>
</head>
<body>

	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${LoginOK.lastName}${LoginOK.firstName}</h3>
	</div>	

<main>
<div class="row" id="mainboard">
			<div class="card-panel indigo lighten-5 hoverable" id="backboard">
				<div class="row" id="secondboard">
					<div class="white card-panel left" style="min-height:60vh" id="firstdiv">
						<div class="row">
							<a id="changepassworda" class="col l12 btn-large yellow lighten-5 black-text" href="<c:url value='maintainpersonal.jsp' />">
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
									修改資料
								</span>
							</a>
						</div>
					</div>
					<div class="white card-panel left" style="min-height:60vh">
						<div class="row">
							<a id="changepassworda" href="<c:url value='../primaryProj/createPrimaryProjForm.jsp' />" class="col l12 btn-large yellow lighten-5 black-text" >
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
									建立初步計畫
								</span>
							</a>
						</div>
						<div class="row divider" style="height:10px;"></div>					
						<div class="row">
							<a id="changepassworda" class="col l12 btn-large yellow lighten-5 black-text" href="<c:url value='/primaryProj.do?type=displayPersonal' />">
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
									瀏覽初步計畫
								</span>
							</a>
						</div>					
						<div class="row">
							<a id="changepassworda"  class="col l12 btn-large yellow lighten-5 black-text" href="<c:url value='/primaryProj.do?type=displayPersonalByPending' />"> 
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
									審核初步計畫
								</span>
							</a>
						</div>					
					</div>				
					<div class="white card-panel left" style="min-height:60vh">
						<div class="row">
							<a id="changepassworda"  class="col l12 btn-large yellow lighten-5 black-text" >
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
										編輯完整計畫
								</span>
							</a>											
						</div>					
						<div class="row divider" style="height:10px;"></div>
						<div class="row">
							<a id="changepassworda"  class="col l12 btn-large yellow lighten-5 black-text" href="<c:url value='/fullProj.do?type=displayPersonal' />">
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
										瀏覽完整計畫
								</span>
							</a>											
						</div>											
						<div class="row">
							<a id="changepassworda"  class="col l12 btn-large yellow lighten-5 black-text" href="<c:url value='/fullProj.do?type=displayPersonalByChat' />">
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
										洽談中
								</span>
							</a>											
						</div>
						<a href='<c:url value='/schoolDemand/SchoolDemandServlet.do?type=mdisplays'/>'>111111</a>											
					</div>				
				</div>



			</div>
		</div>
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
			//設定背板的大小
			var bodyw = $("body").width(),
			    backwid = ($("body").width())* 0.68;
			$("#backboard").css({
				"width":backwid,
				"margin":"0 auto",
				"padding":"30px 0",
				
			});
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			
			$("#secondboard>div").css({
				"width":(bodyw * 0.20),
				"margin-left":(bodyw * 0.02	)
			})
			//會員名稱margin-top,margin-left
			var namediv = $("#membername").height();
			$("#membername").css({
				"margin-top":(pagetitleheight - namediv)/2
				,"margin-left":($(window).width()) * 0.2});			
			//body的最小高度
			$("#mainboard").css("min-height","100vh");
			
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
