<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	${schoolId}<br>
	<a href="test.do">�n�J</a><br>
	<a href="CreatSchoolDemand.jsp">�s�W</a><br>
	
	<a href="SchoolDemandServlet.do?type=update">�ק�</a><br>
	<a href="<c:url value="SchoolDemandServlet.do?type=displayAll" />">��ܩҦ��ݨD</a> <br>
	<a href="SchoolDemandServlet.do?type=displayAll">��ܩҦ��ݨD</a><br>
	
	<a href="SchoolDemandServlet.do?type=displayPersonalAll">��ܻݨD</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalRender">�ݬ���</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalUnrender">���ͤ�</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalEnd">���ͧ���</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalFail">���ͥ���</a><br>

	<form action="Status.do?type=application" method="post">
		<input type="submit" value="�ӽ�">
	</form>
		<form action="Status.do?type=agree" method="post">
		<input type="submit" value="�P�N">
	</form>
		<form action="Status.do?type=disagree" method="post">
		<input type="submit" value="���P�N">
	</form>
		<form action="Status.do?type=cancel" method="post">
		<input type="submit" value="����">
	</form>
</body>
</html>