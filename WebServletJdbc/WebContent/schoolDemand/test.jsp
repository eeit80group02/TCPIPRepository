<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>學校</h1>
	${schoolId}<br>
	<a href="test.do?type=s">登入</a><br>
	<a href="CreatSchoolDemand.jsp">新增</a><br>
	<a href="SchoolDemandServlet.do?type=displays">顯示需求</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalRender">顯示待洽談</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalUnrender">顯示洽談中</a><br>
	<h1>會員</h1>
	${memberId}<br>
	<a href="test.do?type=m">登入</a><br>
	<a href="<c:url value="SchoolDemandServlet.do?type=mdisplays" />">顯示學校需求</a> <br>


	<form action="Status.do?type=application" method="post">
		<input type="submit" value="申請">
	</form>
		<form action="Status.do?type=agree" method="post">
		<input type="submit" value="同意">
	</form>
		<form action="Status.do?type=disagree" method="post">
		<input type="submit" value="不同意">
	</form>
		<form action="Status.do?type=cancel" method="post">
		<input type="submit" value="取消">
	</form>
</body>
</html>