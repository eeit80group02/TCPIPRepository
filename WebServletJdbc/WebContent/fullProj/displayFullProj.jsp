<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayProj</title>
</head>
<body>
	完整計畫顯示
	<table border="1">
		<tr>
			<th>計畫編號</th>
			<td>${fullProj.fullProjId}</td>
		</tr>
		
		<tr>
			<th>會員編號</th>
			<td>${fullProj.memberId}</td>
		</tr>

		<tr>
			<th>學校編號</th>
			<td>${fullProj.schoolId}</td>
		</tr>
		
		<tr>
			<th>摘要</th>
			<td>${fullProj.projAbstract}</td>
		</tr>
		
		<tr>
			<th>內容</th>
			<td>${fullProj.content}</td>
		</tr>
		
		<tr>
			<th>地點</th>
			<td>${fullProj.location}</td>
		</tr>
		
		<tr>
			<th>時間</th>
			<td>${fullProj.activityStartTime}~${fullProj.activityEndTime}</td>
		</tr>
		
		<tr>
			<th>招募人數</th>
			<td>0/${fullProj.estMember}</td>
		</tr>
		
		<tr>
			<th>預算</th>
			<td>0/${fullProj.budget}</td>
		</tr>
		
		<tr>
			<th>成員架構</th>
			<td>${fullProj.orgArchitecture}</td>
		</tr>
	</table>
	
	<c:if test="${LoginOK.beanName.equals('member') && LoginOK.memberId != fullProj.memberId}">
		<input type="button" value="申請當志工" />
	</c:if>
	
	
</body>
</html>