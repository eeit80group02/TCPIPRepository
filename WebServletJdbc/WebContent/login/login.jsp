<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<style>
		.error{
			color:#FF0000;
		}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	
	<form action="<c:url value="/LoginServlet.do" />" method="post">
		帳號<input type="text" name="account"  value="${param.account}" /><span class="error">${error.account}</span><br>
		密碼<input type="text" name="password" value="${param.password}" /><span class="error">${error.password}</span><br>
			<input type="hidden" name="type" value="member"><br>
			<input type="submit" value="登入"><br>
	</form>
	
	<form action="<c:url value="/LoginServlet.do" />" method="post">
		帳號<input type="text" name="account"  value="${param.account}" /><span class="error">${error.account}</span><br>
		密碼<input type="text" name="password" value="${param.password}" /><span class="error">${error.password}</span><br>
			<input type="hidden" name="type" value="school"><br>
			<input type="submit" value="登入"><br>
	</form>
</body>
</html>