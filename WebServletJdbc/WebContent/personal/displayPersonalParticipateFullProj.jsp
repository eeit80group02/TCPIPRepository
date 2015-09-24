<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayPersonalParticipateFullProj</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>計畫編號</th>
			<th>計畫名稱</th>
			<th>時間</th>
			<th>button</th>
		</tr>
		
		<c:forEach var="bean" items="${participator}">
			<tr>
				<td>${bean.fullProjId}</td>
				<td>${bean.fullProjBean.title}</td>
				<td><fmt:formatDate value="${bean.activityStartTime}"/>~<fmt:formatDate value="${bean.activityEndTime}"/></td>
				<td>
				
				<form action="<c:url value="/participator.do" />" method="post">
					<input type="hidden" name="participatorId" value="${bean.participatorId}">
					<input type="hidden" name="option" value="2" />
					<input type="hidden" name="type" value="cancel">
					<button class="btn red white-text btndiv right" type="submit">拒絕</button>
				</form>	</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>