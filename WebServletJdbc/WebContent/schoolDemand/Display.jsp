<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<!-- 學校查詢單筆 -->
	<form action="SchoolDemandServlet.do?type=display&schoolDemandId=${bean.schoolDemandId}" method="post">
	<input type="submit">
	</form>
	${bean}
</body>
</html>