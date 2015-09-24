<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
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
	<title>updateFullProjForm</title>
</head>


<body>
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁首 -->

	<!-- 頁面主題提示 -->
	<div class="row black valign-wrapper" id="pagetitle">
		
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">編輯完整計畫</h1>
	</div>	


<!-- 主要版面 -->
<main>
	<div class="row">
		
		<!-- 切版面開始 -->
		<div class="col l8">
			<!-- 表單本體開始 -->
			<form class="card-panel hoverable" action="<c:url value="/fullProj.do" />" method="post" enctype="multipart/form-data" style="padding:2.5em;background-color:#FFFCEC;">
				<div class="row">
						<!-- 印出來、不能更動 -->
<!-- 						<div class="row orange accent-3"> -->
							<!-- 計畫編號 -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col l8"> -->
<%-- 									<div class="forinput">計畫編號:${param.fullProjId}</div> --%>
<%-- 									<input type="hidden" name="fullProjId" value="${param.fullProjId}"> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							會員編號 -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col l8"> -->
<%-- 									<div class="forinput">會員編號:${param.memberId}</div> --%>
<%-- 									<input type="hidden" name="memberId" value="${param.memberId}"> --%>
<!-- 								</div> -->
<!-- 							</div>						 -->
<!-- 							學校編號 -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col l8"> -->
<%-- 									<div class="forinput">學校編號:${param.schoolId}</div> --%>
<%-- 									<input type="hidden" name="schoolId" value="${param.schoolId}"> --%>
<!-- 								</div> -->
<!-- 							</div>						 -->
<!-- 						</div>				 -->
				
					<!-- 印出來不能動的資訊 -->
					<div class="orange lighten-2 card-panel hoverable ">
						<!-- 完整計畫編號 -->
						<div class="row">
								<div class="forinput col l3 right-align">完整計畫編號:${param.fullProjId}</div>
								<input type="hidden" name="fullProjId" value="${param.fullProjId}" />
						</div>
						<!-- 會員編號 -->
						<div class="row">
								<div class="forinput col l3 right-align">會員編號:${param.memberId}</div>
								<input type="hidden" name="memberId" value="${param.memberId}" />
						</div>
						<!-- 學校編號 -->
						<div class="row">
								<div class="forinput col l3 right-align">學校編號:${param.schoolId}</div>
								<input type="hidden" name="schoolId" value="${param.schoolId}" />
						</div>
					</div>
				
				
						<!-- 計畫封面 -->
						<div class="file-field input-field row">
							<div class="col l8">
								<div class="btn blue-grey lighten-2" style="position:relative;display:block;overflow:hidden;cursor:pointer;">
									<span style="font-family:微軟正黑體;font-size:1.5em;cursor:pointer;">封面</span>
									<input style="position:absolute;top:0;left:0;width:auto;height:100%;opacity:0;cursor:pointer;" type="file" id="picture" accept="image/jpeg,image/png" name="imgFile">
	      						</div>
							</div>
							<div class="col l4">
								<span class="error">${error.imgFile}</span>
							</div>
						</div>
						
						<!--計畫名稱  -->
<%-- 						<input type="text" name="title" value="${param.title}" /><span class="error">${error.title}</span>--%>
						<div class="row">
							<div class="col l8">
								<div class="forinput">計畫名稱</div>
								<input id="title" type="text" name="title"  value="${param.title}" style="font-size:1.2em;color:black;font-weight:600;" required />
							</div>
							<div class="col l4">	
								<span class="error">${error.title}</span>
							</div>
						</div>
						
						<!-- 活動地點 -->
<%-- 						<input type="text" value="${param.location}"  name="location"><span class="error">${error.location}</span> --%>
						<div class="row">
							<div class="col l4">
									<div id="forlocation" class="forinput">活動地點</div>
									<input class="center-align forvalue" id="location" type="text"  value="${param.location}" name="location" style="font-size:1.2em;color:black;font-weight:600;" required />	
							</div>
							<div class="col l4">	
								<span class="error">${error.location}</span>
							</div>
						</div>						
						
						<!-- 活動時間 -->
<%-- 						<input type="date" value="${param.startTime}" name="startTime"> --%>
						<div class="input-field row">
							<div class="col l4">
								<div class="forinput ">活動時間<span style="font-size:0.8em;font-weight:300;" class="right-align">活動開始時間</span></div>
								<input type="date" name="activityStartTime" id="activityStartTime" value="${param.activityStartTime}" required />
							</div>	
							<div class="col l2">
								<span class="error">${error.activityStartTime}</span>
							</div>								
							<div class="col l4">
								<div class="forinput"><span style="font-size:0.8em;font-weight:300;">活動結束時間</span></div>
								<input type="date" name="activityEndTime" id="activityEndTime" value="${param.activityEndTime}" required />
							</div>	
							<div class="col l2">
								<span class="error">${error.activityEndTime}</span>
							</div>								
						</div>

						
						<!-- 預計人數 -->
<%-- 						<input type="number" value="${param.demandNum}" name="demandNum" /><span class="error"> --%>
						<div class="row">
							<div class="col l8">
								<div class="forinput">招募人數</div>
								<input id="estMember" type="number" name="estMember"  value="${param.estMember}" style="font-size:1.2em;color:black;font-weight:600;" required />
							</div>
							<div class="col l4">	
								<span class="error">${error.estMember}</span>
							</div>
						</div>						


						<!-- 活動預算 -->
<%-- 						<input type="number" value="${param.budget}" name="budget" /> --%>
						<div class="row">
							<div class="col l8">
								<div class="forinput">活動預算</div>
								<input id="budget" type="number" name="budget"  value="${param.budget}" style="font-size:1.2em;color:black;font-weight:600;" required />
							</div>
							<div class="col l4">	
								<span class="error">${error.budget}</span>
							</div>
						</div>						
						
						
						<!-- 成員架構 -->
<%-- 						<textarea rows="10" cols="100" name="projAbstract">${param.projAbstract}</textarea> --%>
						<div class="row">
							<div class="col l8">
								<div class="forinput">成員架構<span style="font-size:0.8em;font-weight:300;"></span></div>
								<input id="orgArchitecture" name="orgArchitecture" type="text"  value="${param.orgArchitecture}" style="font-size:1.2em;color:black;font-weight:600;" required>
							</div>
							<div class="col l4">	
								<span class="error">${error.orgArchitecture}</span>
							</div>
						</div>


						<!-- 計畫摘要 -->
<%-- 						<textarea rows="10" cols="100" name="projAbstract">${param.projAbstract}</textarea> --%>
						<div class="row">
							<div class="col l8">
								<div class="forinput">計畫摘要<span style="font-size:0.8em;font-weight:300;">字數僅限100字內</span></div>
								<textarea class="materialize-textarea" id="projAbstract" rows="10" cols="100" name="projAbstract" style="font-size:1.2em;color:black;font-weight:600;" required>${param.projAbstract}</textarea>
							</div>
							<div class="col l4">	
								<span class="error">${error.projAbstract}</span>
							</div>
						</div>
						
						<!-- 計畫內容 -->
						<div class="row">
							<div class="col l8">
								<div class="forinput">計畫內容</div>
								<textarea class="ckeditor" id="content" rows="10" cols="100" name="content" style="font-size:1.2em;color:black;font-weight:600;" required>${param.content}</textarea>
							</div>	
							<div class="col l4">	
								<span class="error">${error.content}</span>
							</div>
						</div>
												
						<!-- hide -->
						<input type="hidden" name="type" value="update" />
<!-- 				button -->
					
					<div class="row" id="btndiv">
						<div class="col l8">
							<button  class="btn-large yellow lighten-5 black-text right" type="submit">
								<span style="font-family:微軟正黑體;font-size:1.3em;">送出</span>
							</button>
							<button  class="btn-large yellow lighten-5 black-text right" type="reset">
								<span style="font-family:微軟正黑體;font-size:1.3em;">取消</span>
							</button>
						</div>
					</div>
					</div>
					<!-- 圖片預覽用 -->
					<input type="hidden" name="base64String" value="${param.base64String}" /> 	
				</form>
			  </div>	
				<!-- 圖片預覽版面  col l2-->
				<div class="col l4">
					<h4 class="left-align blue-text" style="font-weight:600;">完整計畫封面預覽</h4>
					<img class="card-panel hoverable" id="view" src="${param.base64String}" style="height: 250px; width: 310px;border:5px solid black;padding:0;" >
				</div>				
				
		</div>
		<!-- 表單版面 col l6 -->		
		
</main>	
<!-- 主要版面 -->
	
	<!-- 頁尾 -->
		<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}" ></c:import>
	<!-- 頁尾 -->
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script>
		(function($) {
		   $("#view").on("click",function(){
			$("#picture").trigger("click");   
		   })
		   
			//指定ckeditor()的skin
			CKEDITOR.replace("content",{skin:"moono"})
			
			//test
			$("#title").on("focus",function(){
				
				console.log($("endtime").val())
			})
			
			//datepicker初始化(活動時間)
		   var $picker1 =  $('#activityStartTime').pickadate({
			   selectMonths: true, // Creates a dropdown to control month
			   selectYears: 10,
			   format: 'yyyy-mm-dd',
			   min:true,
			   max:365,
			   today:"今天",
			   clear:"重選",
			   close:"確定"
		    });
		   
		   var $picker2 = $('#activityEndTime').pickadate({
			   selectMonths: true, // Creates a dropdown to control month
			   selectYears: 3,
			   format: 'yyyy-mm-dd',
			   today:"今天",
			   clear:"重選",
			   close:"確定"
		    });

		   var picker1 = $picker1.pickadate('picker');
		   var picker2 = $picker2.pickadate('picker');
		   
		   picker1.on("set", function() {
			   var limit = picker1.get();
			   picker2.set("min",limit);
			   picker2.start();
		   })
				
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			
			//
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
			//把理想地點的值丟到input裡
			//初始化理想地點
			$('select').material_select();
			$("select").change(function(){
				if($(this).val() !== ""){
					str = $("#locationselect option:selected").text();
					$("#location").val(str);
				}
			})
		})(jQuery)
	</script>
</body>

		
</html>
