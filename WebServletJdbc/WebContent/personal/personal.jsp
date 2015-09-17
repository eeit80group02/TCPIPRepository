<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>personal</title>
</head>
<body>
<a href="<c:url value="/primaryProj.do?type=displayPersonal&memberId=${LoginOK.memberId}" />" >看我發布過的初步計畫</a><br>
<a href="<c:url value="/primaryProj.do?type=displayPersonalByPending&memberId=${LoginOK.memberId}" />" >看我需要審核的初步計畫</a><br>
<a href="<c:url value="/fullProj.do?type=displayPersonal&memberId=${LoginOK.memberId}" />">看我發布過的完整計畫</a><br>

<a href="<c:url value="/fullProj.do?type=displayPersonalByChat&memberId=${LoginOK.memberId}" />" >洽談中的完整計畫</a><br>
</body>
</html>