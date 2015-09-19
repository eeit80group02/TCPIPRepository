<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>udateFullProj</title>
</head>
<body>

			計畫編號:${fullProj.fullProjId}<br>
			
			會員編號:${fullProj.memberId}<br>

			學校編號:${fullProj.schoolId}<br>

			標題 ${fullProj.title}<br>
			<input type="text" value="${fullProj.title}"><hr>
			
			摘要${fullProj.projAbstract}<br>
			<input type="text" value="${fullProj.projAbstract}"><hr>
			
			內容${fullProj.content}<br>
			<input type="text" value="${fullProj.content}"><hr>
			
			地點${fullProj.location}<br>
			<input type="text" value="${fullProj.location}"><hr>
			
			時間${fullProj.activityStartTime}~${fullProj.activityEndTime}<br>
			<fmt:formatDate var="sTime" value="${fullProj.activityStartTime}" pattern="yyyy-MM-dd"/>
			<fmt:formatDate var="eTime" value="${fullProj.activityEndTime}" pattern="yyyy-MM-dd"/>
			<input type="text" value="${sTime}"><input type="text" value="${eTime}"><hr>
			
			招募人數${fullProj.estMember}<br>
			<input type="text" value="${fullProj.estMember}"><hr>
			
			預算${fullProj.budget}<br>
			<input type="text" value="${fullProj.budget}"><hr>
			成員架構${fullProj.orgArchitecture}<br>
			<input type="text" value="${fullProj.orgArchitecture}"><hr>
			
			<form action=""	method="post">
				<input type="hidden" value="${fullProj.fullProjId}">
			
			</form>
			<form action="/fullProj.do" method="post">
				<input type="hidden" name="type" value="displayUpdateForm">
				<input type="submit" value="補齊完整計畫">
			</form>
			
			<form action="/fullProj.do" method="post">
				<input type="hidden" name="type" value="schoolConfirm">
				<input type="submit" value="學校同意">
			</form>
			
			<form action="/fullProj.do" method="post">
				<input type="hidden" name="type" value="memberConfirm">
				<input type="submit" value="完整計畫發布">
			</form>

			<hr>
			以下Q&A
</body>
</html>