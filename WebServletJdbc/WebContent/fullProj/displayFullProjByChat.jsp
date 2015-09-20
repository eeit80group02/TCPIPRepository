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
			
			<!-- 導向修改頁面，並且把這頁資料傳送過去 -->
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
			
			<form action="<c:url value="/fullProj.do" />" method="post">
				<input type="hidden" name="type" value="schoolConfirm">
				<input type="submit" value="學校同意">
			</form>
			
			<form action="<c:url value="/fullProj.do" />" method="post">
				<input type="hidden" name="type" value="memberConfirm">
				<input type="submit" value="完整計畫發布">
			</form>

			<hr>
			以下Q&A
</body>
</html>