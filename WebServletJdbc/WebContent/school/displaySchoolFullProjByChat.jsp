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
<title>displaySchoolFullProjByChat</title>
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
						<th>須洽談計畫編號</th>
						<th>完整計畫標題</th>
						<th>link</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${fullProj}">
						<tr>
							<td style="font-size:1.6em;font-weight:600">${bean.fullProjId}</td>
							<td style="font-size:1.6em;font-weight:600">${bean.title}</td>
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
			
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//會員名稱margin-top,margin-left
			var namediv = $("#membername").height();
			$("#membername").css({
				"margin-top":(pagetitleheight - namediv)/2
				,"margin-left":($(window).width()) * 0.2});
			
			//表單驗證
				//密碼
				$("#passwords").on("keyup",function(){
					var passwordvalue = $("#passwords").val();
					if(passwordvalue.trim().length !== 0 ){
						//必須包含英文字母,rule1為真表示有英文字母;
						rule1 = /^(?=.*[A-Za-z]).{1,}$/;
						
						//必須包含一特殊符號,rule3為真表示有特殊符號
						rule3 = /^(?=.*[\W]).{1,}$/
						//不可以有中文字元,rule4為真表示有中文
						rule4 = /^(?=.*[\u4e00-\u9fa5)]).{1,}$/
						//密碼長度介於10~16字間
						var flag1 = false;
						if(passwordvalue.trim().length >=10 && passwordvalue.trim().length <= 16){
							flag1 = true;
						}
						//必須包含數字
						rule6 = /^(?=.*[0-9]).{1,}$/
						
						var result1 = rule1.test(passwordvalue),
							result3 = rule3.test(passwordvalue),
							result4 = rule4.test(passwordvalue),
							result6 = rule6.test(passwordvalue);
						
						var finalchk = false;
						if(result1 == true && result3 == true && result4 !== true && flag1 == true && result6 == true){
							finalchk = true;
						}
						
						console.log(finalchk);
						$("#registerform").data({passwordresults:finalchk});
						
						if(result1){
							$("#rule2pic1").text("done")
							.css("color","#43a047");
							$("#rule2text1").css("color","#43a047");								
						}else{
							$("#rule2pic1").text("info_outline")
							.css("color","#ff5252");
							$("#rule2text1").css("color","#ff5252");								
						}
						
						if(result3){
							$("#rule2pic3").text("done")
							.css("color","#43a047");
							$("#rule2text3").css("color","#43a047");								
						}else{
							$("#rule2pic3").text("info_outline")
							.css("color","#ff5252");
							$("#rule2text3").css("color","#ff5252");									
						}
						
						if(result4){
							$("#rule2pic4").text("info_outline")
							.css("color","#ff5252");
							$("#rule2text4").css("color","#ff5252");								
						}else{
							$("#rule2pic4").text("done")
							.css("color","#43a047");
							$("#rule2text4").css("color","#43a047");									
						}
						
						if(flag1){
							$("#rule2pic5").text("done")
							.css("color","#43a047");
							$("#rule2text5").css("color","#43a047");									
						}else{
							$("#rule2pic5").text("info_outline")
							.css("color","#ff5252");
							$("#rule2text5").css("color","#ff5252");									
						}
						
						if(result6){
							$("#rule2pic6").text("done")
							.css("color","#43a047");
							$("#rule2text6").css("color","#43a047");										
						}else{
							$("#rule2pic6").text("info_outline")
							.css("color","#ff5252");
							$("#rule2text6").css("color","#ff5252");	
						}
						
					}else{
						$("#rule2pic1").text("");
						$("#rule2pic2").text("");
						$("#rule2pic3").text("");
						$("#rule2pic4").text("");
						$("#rule2pic5").text("");
						$("#rule2pic6").text("");
						$("#rule2text1").css("color","black");
						$("#rule2text2").css("color","black");
						$("#rule2text3").css("color","black");
						$("#rule2text4").css("color","black");
						$("#rule2text5").css("color","black");
						$("#rule2text6").css("color","black");
					}
				
				})
				
				//密碼確認
				$("#check").on("keyup",function(){
					var checkvalue = $("#check").val(),
						passwordvalue = $("#passwords").val();
					if(checkvalue !== ""){
						var result = (checkvalue.trim() == passwordvalue.trim());
						$("#registerform").data({passwordresults2:result});
						if(result && checkvalue !== ""){
							$("#rule2pic2").css("color","#43a047").text("done");
							$("#rule2text2").css("color","#43a047");
						}else{
							$("#rule2pic2").css("color","#ff5252").text("info_outline");
							$("#rule2text2").css("color","#ff5252");
							
						}
					}else{
						$("#rule2pic2").text("");
						$("#rule2text2").css("color","black");
					}
				})
				
				//聯絡方式(sevlet內可以判斷格式是否正確再存)
				$("#idNumber").on("keyup",function(){
					rule1 = /^(02|03|037|04|049|05|06|07|08|082|0826|0836|089)-[0-9]{5,8}$/
//						rule1 = /^[0]{1}(?=.*\d).{9}/
					var result = rule1.test($("#idNumber").val());
					$("body").data("chkphone1",result);
					
					if($("#idNumber").val() !== ""){
						if(result){
							$("#rule3pic2").css("color","#43a047").text("done");
							$("#rule3text2").css("color","#43a047");	
						}else{
							$("#rule3pic2").css("color","#ff5252").text("info_outline");
							$("#rule3text2").css("color","#ff5252");							
							$("#rule3pic1").css("color","#ff5252").text("info_outline");
							$("#rule3text1").css("color","#ff5252");
						}
					}else{
						$("#rule3pic2").text("");
						$("#rule3text2").css("color","black");	
					}
					
					if($("body").data("chkphone2") || result){
						$("#registerform").data({contactresult:true});							
						$("#rule3pic1").css("color","#43a047").text("done");
						$("#rule3text1").css("color","#43a047");
					}else{
						$("#rule3pic1").text("");
						$("#rule3text1").css("color","black");							
					}
				});
				//聯絡方式(手機)
				$("#phone").on("keyup",function(){
					rule1 = /^(09)[0-9]{2}-[0-9]{6}$/
					var result = rule1.test($("#phone").val());
					$("body").data("chkphone2",result);
					
					if($("#phone").val() !== ""){
						if(result){
						$("#rule3pic3").css("color","#43a047").text("done");
						$("#rule3text3").css("color","#43a047");
						}else{
							$("#rule3pic3").css("color","#ff5252").text("info_outline");
							$("#rule3text3").css("color","#ff5252");						
							$("#rule3pic1").css("color","#ff5252").text("info_outline");
							$("#rule3text1").css("color","#ff5252");						
						}
					}else{
						$("#rule3pic3").text("");
						$("#rule3text3").css("color","black");
					}
					
					if($("body").data("chkphone1") || result){
						$("#registerform").data({contactresult:true});
						$("#rule3pic1").css("color","#43a047").text("done");
						$("#rule3text1").css("color","#43a047");
					}else{
						$("#rule3pic1").text("");
						$("#rule3text1").css("color","black");							
					}
				})
				//Email格式
				$("#email").on("keyup",function(){
					rule1 = /^[-a-z0-9~!$%^&*_=+}{\?]+(\.[-a-z0-9~!$%^&*_=+}{\?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
					var result = rule1.test($("#email").val());
					if($("#email").val() !== ""){
						if(result){
							$("#registerform").data({emailresult:true});							
							$("#rule4pic1").css("color","#43a047").text("done");
							$("#rule4text1").css("color","#43a047");							
						}else{
							$("#rule4pic1").css("color","#ff5252").text("info_outline");
							$("#rule4text1").css("color","#ff5252");							
						}
					}else{
						$("#rule4pic1").text("");
						$("#rule4text1").css("color","black");	
					}
					})
					

				//生日格式
				$("#birthday").on("keyup",function(){
					rule1 = /^[1-2]{1}[0-9]{3}-[0-9]{2}-[0-9]{2}$/
					var result = rule1.test($("#birthday").val());
					var result2 = (new Date($("#birthday").val()).toString() == "Invalid Date");
					
					if($("#birthday").val() !== ""){
						if(result && !result2){
							$("#registerform").data({birthdayresult:true});
							$("#rule5pic1").css("color","#43a047").text("done");
							$("#rule5text1").css("color","#43a047");
						}else{
							$("#rule5pic1").css("color","#ff5252").text("info_outline");
							$("#rule5text1").css("color","#ff5252");									
						}
					}else{
						$("#rule5pic1").text("");
						$("#rule5text1").css("color","black");	
					}
				})
		//送出表單前的驗證
		$("#btndiv").on({
			"mouseover":function(){
			if($("#passwords").val() !== "" || $("#check").val() !== ""){
				if(
						$("#registerform").data().passwordresults &&
						$("#registerform").data().passwordresults2 &&
						$("#registerform").data().contactresult &&
						$("#registerform").data().emailresult &&
						$("#registerform").data().birthdayresult &&
						$("#lastName").val().trim() !== "" &&
						$("#firstName").val().trim() !== "" &&
						$("#address").val().trim() !== "" 
						){
							$("#submitbtn").prop("disabled",false);
						}else{
							$("#submitbtn").prop("disabled",true);
						}				
			}else{
				if(
						$("#registerform").data().contactresult &&
						$("#registerform").data().emailresult &&
						$("#registerform").data().birthdayresult &&
						$("#lastName").val().trim() !== "" &&
						$("#firstName").val().trim() !== "" &&
						$("#address").val().trim() !== "" 
				){
						$("#submitbtn").prop("disabled",false);
				}else{
						$("#submitbtn").prop("disabled",true);
					}						
			}

		},"mouseout":function(){
			if(
				$("#registerform").data().accountresults &&
				$("#registerform").data().passwordresults &&
				$("#registerform").data().passwordresults2 &&
				$("#registerform").data().contactresult &&
				$("#registerform").data().emailresult &&
				$("#registerform").data().birthdayresult &&
				$("#lastName").val().trim() !== "" &&
				$("#firstName").val().trim() !== "" &&
				$("#address").val().trim() !== "" 
				
			){
				$("#submitbtn").prop("disabled",false);
			}else{
				$("#submitbtn").prop("disabled",true);
			}
		}
		});
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
