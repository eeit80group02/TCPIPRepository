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
<title>學校專區</title>
<style>
	.fontStyle {
		font-family:微軟正黑體;
		font-weight:600;
		font-size:1.4em;
	}
</style>
</head>
<body>
	<c:if test="${LoginOK.beanName.equals('member') }">
		<c:redirect url="/error/permission.jsp" />
	</c:if>
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row brown darken-4" id="pagetitle">
		<h3 class="white-text"
			id="membername" style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;display:inline-block;">${LoginOK.name}</h3>
	</div>	

	<main>
		<div class="row" id="mainboard">
			<div class="card-panel indigo lighten-5" id="backboard">
				<div class="row" id="secondboard">
					<div class="card-panel left hoverable" style="min-height:60vh" id="firstdiv">
						<div>
							<h3 class="row center-align" style="width:100%;font-weight:600;font-family:微軟正黑體;">
								活動計畫
							</h3>
							<div class="row divider red" style="opacity:0.5;height:10px;"></div>
							<div class="row">
								<a href="#" class="col l12 btn-large yellow lighten-5 black-text" >
									<span class="fontStyle">
										我申請的初步計畫
									</span>
								</a>
							</div>
							<div class="row">
								<a href="<c:url value="/fullProj.do?type=displaySchoolByChat" />" class="col l12 btn-large yellow lighten-5 black-text" >
									<span class="fontStyle">
										洽談中完整計畫
									</span>
								</a>
							</div>
						</div>
					</div>
					<div class="white card-panel left hoverable" style="min-height:60vh">
						<div>
							<h3 class="row center-align" style="width:100%;font-weight:600;font-family:微軟正黑體;">
								需求計畫
							</h3>
							<div class="row divider red" style="opacity:0.5;height:10px;"></div>
							<div class="row">
								<a href="<c:url value="/schoolDemand/CreatSchoolDemand.jsp" />" class="col l12 btn-large yellow lighten-5 black-text" >
									<span class="fontStyle">
										建立需求計畫
									</span>
								</a>
							</div>
							<div class="row">
								<a href="<c:url value="/schoolDemand/SchoolDemandServlet.do?type=displays" />" class="col l12 btn-large yellow lighten-5 black-text" >
									<span class="fontStyle">
										全部需求計畫
									</span>
								</a>
							</div>
							<div class="row">
								<a href="<c:url value='/schoolDemand/SchoolDemandServlet.do?type=displayPersonalUnrender' />" class="col l12 btn-large yellow lighten-5 black-text"> 
									<span class="fontStyle">
										洽談中
									</span>
								</a>
							</div>					
<!-- 							<div class="row"> -->
<!-- 								<a href="#!" class="col l12 btn-large yellow lighten-5 black-text" > -->
<!-- 									<span class="fontStyle"> -->
<!-- 											待洽談 -->
<!-- 									</span> -->
<!-- 								</a>											 -->
<!-- 							</div> -->
						</div>						

<!-- 						<div class="row"> -->
<!-- 							<a id="changepassworda" href="#!" class="col l12 btn-large yellow lighten-5 black-text" > -->
<!-- 								<span  style="font-family:微軟正黑體;font-size:1.2em;"> -->
<!-- 										洽談完成 -->
<!-- 								</span> -->
<!-- 							</a>											 -->
<!-- 						</div> -->
<!-- 						<div class="row"> -->
<!-- 							<a id="changepassworda" href="#!" class="col l12 btn-large yellow lighten-5 black-text" > -->
<!-- 								<span  style="font-family:微軟正黑體;font-size:1.2em;"> -->
<!-- 										洽談失敗 -->
<!-- 								</span> -->
<!-- 							</a>											 -->
<!-- 						</div> -->
					</div>	
					<div class="white card-panel left hoverable" style="min-height:60vh">
						<div>
							<h3 class="row center-align" style="width:100%;font-weight:600;font-family:微軟正黑體;">
								物資需求
							</h3>
							<div class="row divider red" style="opacity:0.5;height:10px;"></div>
							<div class="row">
								<a href="<c:url value="../donation/InsertDonateGoods.jsp" />" class="col l12 btn-large yellow lighten-5 black-text" >
									<span class="fontStyle">
										建立物資需求
									</span>
								</a>
							</div>
							<div class="row">
								<a href="<c:url value='/donation/demand.do?type=AllDeamndBySchool&schoolId=${LoginOK.schoolId}'/>" class="col l12 btn-large yellow lighten-5 black-text" >
									<span class="fontStyle">
										全部物資需求
									</span>
								</a>
							</div>
						</div>						
						
<!-- 						<div class="row"> -->
<!-- 							<a id="changepassworda" href="#!" class="col l12 btn-large yellow lighten-5 black-text" > -->
<!-- 								<span  style="font-family:微軟正黑體;font-size:1.2em;"> -->
<!-- 										已獲得物資 -->
<!-- 								</span> -->
<!-- 							</a>											 -->
<!-- 						</div>											 -->
<!-- 						<div class="row"> -->
<!-- 							<a id="changepassworda" href="#!" class="col l12 btn-large yellow lighten-5 black-text" > -->
<!-- 								<span  style="font-family:微軟正黑體;font-size:1.2em;"> -->
<!-- 										募集中物資 -->
<!-- 								</span> -->
<!-- 							</a>											 -->
<!-- 						</div>	 -->
						
<!-- 						<div class="row"> -->
<%-- 							<a id="changepassworda" href="<c:url value='/fullProj.do?type=displaySchoolByChat' />" class="col l12 btn-large yellow lighten-5 black-text" > --%>
<!-- 								<span  style="font-family:微軟正黑體;font-size:1.2em;"> -->
<!-- 										洽談中計劃 -->
<!-- 								</span> -->
<!-- 							</a>											 -->
<!-- 						</div>											 -->
					</div>
					
					<!-- 第四張 -->					
					<div class="white card-panel left" style="min-height:60vh" id="firstdiv">
							<h3 class="row center-align" style="width:100%;font-weight:600;font-family:微軟正黑體;">
								學校管理
							</h3>
							<div class="row divider red" style="opacity:0.5;height:10px;"></div>
							<a class="col l12 btn-large yellow lighten-5 black-text" href="<c:url value='/school/showSchoolData.do' />">
								<span  style="font-family:微軟正黑體;font-size:1.2em;">
									修改資料
								</span>
							</a>
						</div>
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
			
			$("#secondboard>div").css({
				"width":(bodyw * 0.20),
				"margin-left":(bodyw * 0.02	)
			})
			
			//body的最小高度
			$("#mainboard").css("min-height","100vh");
			//點擊預覽圖片也能上傳檔案
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
			
			
			//初始化tab
			$('ul.tabs').tabs();
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

