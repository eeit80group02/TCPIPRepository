<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>�Ǯ�</h1>
	${schoolId}<br>
	<a href="test.do?type=s">�n�J</a><br>
	<a href="CreatSchoolDemand.jsp">�s�W</a><br>
	<a href="SchoolDemandServlet.do?type=displays">��ܻݨD</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalRender">��ܫݬ���</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalUnrender">��ܬ��ͤ�</a><br>
	<h1>�|��</h1>
	${memberId}<br>
	<a href="test.do?type=m">�n�J</a><br>
	<a href="<c:url value="SchoolDemandServlet.do?type=mdisplays" />">��ܾǮջݨD</a> <br>


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