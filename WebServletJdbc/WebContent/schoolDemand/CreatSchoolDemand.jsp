<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="SchoolDemandServlet.do?type=create"/>" method="post">
預計參與的學生人數:<input type="text" name="participant" value="${param.participant}">${error.participant}<br>
活動主題:<input type="text" name="activityTopic" value="${param.activityTopic}">${error.activityTopic}<br>
活動地點:<input type="text" name="activityLocation" value="${param.activityLocation}">${error.activityLocation}<br>
活動適合對象:<input type="text" name="activitySuitable" value="${param.activitySuitable}">${error.activitySuitable}<br>
活動負責人:<input type="text" name="activityHost" value="${param.activityHost}">${error.activityHost}<br>
負責人聯絡方式:<input type="text" name="activityContact" value="${param.activityContact}">${error.activityContact}<br>
提供需求:住宿<input type="checkbox" name="room">活動場地<input type="checkbox" name="place">伙食<input type="checkbox" name="food"><br>
需求內容:<textarea name="content" style="width: 300px;height: 200px" >${param.content }</textarea>${error.content}
<input type="submit">
</form>
</body>
</html>