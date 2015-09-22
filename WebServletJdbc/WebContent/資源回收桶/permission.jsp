<%@page import="java.util.Timer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>permission.jsp</title>
</head>
<body>
	<% 	
		response.setHeader("Refresh", "3; URL="+request.getContextPath()); 
	%>
	你沒有權限操作此頁面，3秒後導回首頁。<br>

	<a href="<c:url value="/index.jsp" />">回首頁</a>

</body>
</html>