<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>

</style>
<title>UpdateDonation</title>
</head>
<body>
<center>
<h3>單一學校之物資需求</h3>
<a href='index.jsp'>回首頁</a>|
<c:forEach var='item' items='${OneAllDemands}'>
	<table style="width:200px;height:60px;float:left;background-color:#00FF00;">
	<tr><td><a href="<c:url value='demand.do?type=UpdateOneDemand&donationId=${item.donationId}&schoolId=${item.schoolId}'/>">修改</a></td></tr>
<%-- 	<tr><td>${item.donationId}</td></tr> --%>
<%-- 	<tr><td>${item.schoolId}</td></tr> --%>
<%-- 	<tr><td>${item.schoolName}</td></tr> --%>
	<tr><td>${item.donationStatus}</td></tr>
	<tr><td>${item.supplyName}</td></tr>
	<tr><td>${item.originalDemandNumber}</td></tr>
	<tr><td>${item.originalDemandUnit}</td></tr>
	<tr><td>${item.demandNumber}</td></tr>
	<tr><td>${item.size}</td></tr>
	<tr><td>${item.demandContent}</td></tr>
	<tr><td>${item.supplyStatus}</td></tr>
	<tr><td>${item.demandTime}</td></tr>
	<tr><td>${item.expireTime}</td></tr>
	<tr><td>${item.remark}</td></tr>
<%-- 	<tr><td>${item.imageName}</td></tr> --%>
<%-- 	<tr><td>${item.imageFile}Servlet</td></tr> --%>
	<tr><td><a href="<c:url value='demand.do?type=OneDeamndBySchool&donationId=${item.donationId}&schoolId=${item.schoolId}&manage=yes'/>">詳細內容</a></td></tr>
	<td><img src='${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}'></td>
<%-- 	<tr><td>${item.imageLength}</td></tr> --%>
	
<!-- 	<tr><td><input type='button' name='toCart' value='加入捐贈車'></td></tr> -->
	</table>
</c:forEach>
<H1>${updateOK.Success}</H1>
</center>
</body>
</html>