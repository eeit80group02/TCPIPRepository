<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>

<!-- �Ӥu��ݪ��A�Ҧ����p�e�ݨD -->
	<form action="SchoolDemandServlet.do?type=displayAll" method="post">
	<input type="submit">
	</form>
	<c:forEach var="bean" items="${list}">
		${bean.participant}<br>
		${bean.activityTopic}<br>
		${bean.activityLocation}<br>
		${bean.activitySuitable}<br>
		${bean.activityHost}<br>
		${bean.activityContact}<br>
		${bean.createDate}<br>
		${bean.content}<br>
		${bean.demandStatus}<br>
		${bean.offerBean.room}<br>
		${bean.offerBean.place}<br>
		${bean.offerBean.food}<hr>
	</c:forEach>

</body>
</html>