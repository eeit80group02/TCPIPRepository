<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>udateFullProj</title>
</head>
<body>

			計畫編號${fullProj.fullProjId}<br>

			會員編號${fullProj.memberId}<br>

			學校編號${fullProj.schoolId}<br>

			摘要${fullProj.projAbstract}<br>

			內容${fullProj.content}<br>

			地點${fullProj.location}<br>

			時間${fullProj.activityStartTime}~${fullProj.activityEndTime}<br>

			招募人數${fullProj.estMember}<br>

			預算${fullProj.budget}<br>

			成員架構${fullProj.orgArchitecture}<br>
			
			<input type="button" value="補全完整計畫">
			<input type="button" value="學校同意">
			<input type="button" value="發起者發布">

			<hr>
			以下Q&A
</body>
</html>