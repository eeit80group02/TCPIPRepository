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
	<a href="test.do">登入</a><br>
	<a href="CreatSchoolDemand.jsp">新增</a><br>
	<a href="<c:url value="SchoolDemandServlet.do?type=update" />">修改</a><br>

	<a href="<c:url value="SchoolDemandServlet.do?type=displayAll" />">顯示所有需求</a> <br>
	<a href="SchoolDemandServlet.do?type=displayAll">顯示所有需求</a><br>
	
	<a href="SchoolDemandServlet.do?type=displayPersonalAll">顯示需求</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalRender">待洽談</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalUnrender">洽談中</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalEnd">洽談完成</a><br>
	<a href="SchoolDemandServlet.do?type=displayPersonalFail">洽談失敗</a><br>
</body>
</html>