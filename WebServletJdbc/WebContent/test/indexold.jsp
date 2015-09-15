<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
<!-- 檢查有無登入 -->
	<c:choose>
		<c:when test="${empty LoginOK}">
		<!-- 		沒登入必須看到登入按鈕 -->
			<a href="login/login.jsp" >登入</a>
		</c:when>
		
		<c:otherwise>
<!-- 		有登入看到個人頁面選擇 -->
			<c:if test="${LoginOK.beanName.equals('member')}">
				<a href="<c:url value="/personal/personal.jsp" />">個人頁面 ${LoginOK.memberId}你好</a> <br>
				<a href="<c:url value="/primaryProj/createPrimaryProjForm.jsp" />">建立初步計畫[會員登入才能使用]</a><br>
			</c:if>
		
			<c:if test="${LoginOK.beanName.equals('school')}">
				<a href="#"> ${LoginOK.schoolId}你好</a> <br>
				<a href="<c:url value="/primaryProj.do?type=displayAll" />">檢視初步計畫[預計只有學校能看見]</a><br>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	
<!-- 	以下單純測試用 所以全開放 -->
	<hr>
	以下單純測試用 所以全開放 <br>
	<a href="<c:url value="/primaryProj/createPrimaryProjForm.jsp" />">建立初步計畫[會員登入才能使用]</a><br>
	<a href="<c:url value="/primaryProj.do?type=displayAll" />">檢視初步計畫[預計只有學校能看見]</a><br>
	<a href="login/login.jsp" >登入</a>
	
	
</body>
</html>