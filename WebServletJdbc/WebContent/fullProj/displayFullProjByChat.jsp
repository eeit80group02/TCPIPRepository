<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayFullProjByChat</title>
</head>
<body>

	計畫編號:${fullProj.fullProjId}<br>
	
	會員編號:${fullProj.memberId}<br>

	學校編號:${fullProj.schoolId}<br>

	標題 ${fullProj.title}<br>
	
	摘要${fullProj.projAbstract}<br>
	
	內容${fullProj.content}<br>
	
	地點${fullProj.location}<br>
	
	時間<br>
	<fmt:formatDate value="${fullProj.activityStartTime}" pattern="yyyy-MM-dd"/>
	<fmt:formatDate value="${fullProj.activityEndTime}" pattern="yyyy-MM-dd"/>
	
	招募人數${fullProj.estMember}<br>
	
	預算${fullProj.budget}<br>
	成員架構${fullProj.orgArchitecture}<br>
	
	${sessionScope.schoolConfirm}
	<!-- 學校同意按鈕 -->
	<c:if test="${LoginOK.beanName.equals('school')}">
		<c:if test="${empty fullProj.schoolConfirm}">
			<form action="<c:url value="/fullProj.do" />" method="post">
				<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}" />
				<input type="hidden" name="location" value="${fullProj.location}">
				<input type="hidden" name="orgArchitecture" value="${fullProj.orgArchitecture}">
				<input type="hidden" name="type" value="schoolConfirm">
				<input type="submit" value="學校同意">
			</form>
		</c:if>
	</c:if>
	
	<!-- 發起者發布按鈕 -->
	<c:if test="${LoginOK.beanName.equals('member')}">
		<c:if test="${empty fullProj.memberConfirm && fullProj.schoolConfirm == true}">
			<form action="<c:url value="/fullProj.do" />" method="post">
				<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}" />
				<input type="hidden" name="type" value="memberConfirm">
				<input type="submit" value="完整計畫發布">
			</form>
		</c:if>
	</c:if>
				
	<!-- 導向修改頁面，並且把這頁資料傳送過去 -->
	<c:if test="${LoginOK.beanName.equals('member')}">
		<c:if test="${LoginOK.memberId == fullProj.memberId && fullProj.projStatus.equals('洽談中')}">
			<form action="<c:url value="/fullProj/updateFullProjForm.jsp" />" method="post" accept-charset="UTF-8">
				<input type="hidden" name="fullProjId" value="${fullProj.fullProjId}">
				<input type="hidden" name="memberId" value="${fullProj.memberId}">
				<input type="hidden" name="schoolId" value="${fullProj.schoolId}">
				<input type="hidden" name="title" value="${fullProj.title}">
				<input type="hidden" name="projAbstract" value="${fullProj.projAbstract}">
				<input type="hidden" name="content" value="${fullProj.content}">
				<input type="hidden" name="location" value="${fullProj.location}">
				<input type="hidden" name="activityStartTime" value="<fmt:formatDate value="${fullProj.activityStartTime}" pattern="yyyy-MM-dd"/>">
				<input type="hidden" name="activityEndTime" value="<fmt:formatDate value="${fullProj.activityEndTime}" pattern="yyyy-MM-dd"/>">
				<input type="hidden" name="estMember" value="${fullProj.estMember}">
				<input type="hidden" name="budget" value="${fullProj.budget}">
				<input type="hidden" name="orgArchitecture" value="${fullProj.orgArchitecture}">
				<input type="hidden" name="base64String" value="${fullProj.base64String}">
				<input type="submit" value="補齊完整計畫">
			</form>
		</c:if>
	</c:if>
	<hr>
	以下Q&A<br>
			
	<div id="myDiv">
	</div>
	
	會員
	<textarea id="memberContent"></textarea><sapn id="memberError"></sapn><br>
	<input type="button" id="memberButton" value="傳送"><br>
	<hr>
	學校
	<textarea id="schoolContent"></textarea><sapn id="schoolError"></sapn><br>
	<input type="button" id="schoolButton" value="傳送"><br>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	
	<input type="button" id="btn" value="test"><br>
	<script>
		// jQuery
		$(function(){
			displayMessage();
			var timer = setInterval(displayMessage,60000);
	        
			$("#memberButton").on("click",function(){
				if($("#memberContent").val().length < 10) {
					$("#memberError").html("留言必須大於10個字");
				}
				else{
					$("#memberError").empty();
					addMemberMessage();
					$("#memberContent").val("");
				}
			});
			
			$("#schoolButton").on("click",function(){
				if($("#schoolContent").val().length < 10) {
					$("#schoolError").html("留言必須大於10個字");
				}
				else{
					$("#schoolError").empty();
					addSchoolMessage();
					$("#schoolContent").val("");
				}
			});
		
			function addMemberMessage(){
				$.ajax({
					"url": "<c:url value='/ProjModifyServlet.do' />",
					"type":"POST",
					"data":{"type":"addMember","fullProjId":"${fullProj.fullProjId}","memberId":"${fullProj.memberId}","content":$("#memberContent").val()},
					"dataType" :"json",
					"success":function(data){
						displayMessage();
					}
				});
			}
			
			function addSchoolMessage(){
				$.ajax({
					"url": "<c:url value='/ProjModifyServlet.do' />",
					"type":"POST",
					"data":{"type":"addSchool","fullProjId":"${fullProj.fullProjId}","schoolId":"${fullProj.schoolId}","content":$("#schoolContent").val()},
					"dataType" :"json",
					"success":function(data){
						displayMessage();
					}
				});
			}
			
			function displayMessage(){
				$.ajax({
					"url": "<c:url value='/ProjModifyServlet.do' />",
					"type":"POST",
					"data":{"type":"display","fullProjId":"${fullProj.fullProjId}"},
					"dataType" :"json",
					"success":function(data){
						// data => Object
						// console.log(data);
						$("#myDiv > div").remove();
						$.each(data.result,function(index,value){
							// data.result => Array[]
							// Array[index] => Object
							if(value.schoolId == "null"){
		 						var memberContent = "會員ID:" + value.memberId + "<br>" + 
			 										"留言:" + value.memberMessage + "<br>" +
			  										"時間:" + value.memberMessageTime + "<br>" + 
													"--------------------------------";	
		 						var contentDiv = $("<div></div>").html(memberContent);
		 						$("#myDiv").append(contentDiv);
							}
							if(value.memberId == "null"){
								var schoolContent = "學校ID:" + value.schoolId + "<br>" + 
	 												"留言:" + value.schoolMessage + "<br>" +
	  												"時間:" + value.schoolMessageTime + "<br>" + 
	  												"--------------------------------";
								var contentDiv = $("<div></div>").html(schoolContent);
								$("#myDiv").append(contentDiv);
							}
						});
					}
				});
			}
		})

	</script>
			
			
			
</body>
</html>