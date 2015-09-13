<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value="/primaryProj/createPrimaryProjForm.jsp" />">建立初步計畫[會員登入才能使用]</a><br>
	<a href="<c:url value="/primaryProj.do?type=displayAll" />">檢視初步計畫[預計只有學校能看見]</a><br>
	
	<form action="<c:url value="/test" />" method="post">
		<input type="submit" value="xxxx">
	
	</form>
</body>
</html>