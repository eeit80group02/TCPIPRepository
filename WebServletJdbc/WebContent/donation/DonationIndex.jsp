<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<h3>首頁</h3>
	<hr>
	<a href='../index.jsp'>TCPIP入口</a>|
	<a href='InsertDonateGoods.jsp'>學校新增物資需求</a>|
	<a href="<c:url value='demand.do?type=AllDeamndBySchool&schoolId=${LoginOK.schoolId}'/>">學校查詢所刊登的需求</a>|
	<a href="<c:url value='demand.do?type=FindGoods'/>">會員查詢捐獻頁面</a>|
	
</body>
</html>