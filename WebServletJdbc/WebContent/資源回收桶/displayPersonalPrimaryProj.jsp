<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>個人頁面查看初步計畫</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>初步計畫編號</th>
			<th>初步計畫標題</th>
			<th></th>
		</tr>
		<c:forEach var="bean" items="${primaryProj}">
			<tr>
				<th>${bean.primaryProjId}</th>
				<th>${bean.title}</th>
				
				<c:url value="/primaryProj.do" var="path">
					<c:param name="type" value="display" />
					<c:param name="primaryProjId" value="${bean.primaryProjId}" />
				</c:url>
				<th><a href="${path}">查看</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>