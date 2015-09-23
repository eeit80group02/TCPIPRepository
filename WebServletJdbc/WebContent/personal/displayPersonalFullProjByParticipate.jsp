<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayPersonalFullProjByParticipate.jsp</title>
</head>
<body>
	<c:forEach var="bean" items="${fullProj}">
<%-- 		編號 ${bean.fullProjId}<br> --%>
<%-- 		名稱 ${bean.title}<br> --%>
		
		<!-- 參加人 -->
		<c:forEach var="participatorBean" items="${bean.participatorBean}">
			編號 ${bean.fullProjId}
			名稱 ${bean.title}
			參加人 ${participatorBean.memberBean.lastName}${participatorBean.memberBean.firstName}
			<input type="button" value="同意">
			<input type="button" value="取消">
			<hr>
		</c:forEach>
	</c:forEach>
</body>
</html>