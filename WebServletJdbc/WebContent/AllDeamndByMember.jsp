<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OneMemberDemand</title>
<style>
#div1 {
	border:1px solid green;
}
</style>
</head>
<body>
<center>
<h3>${OneAllDemands[0].schoolName}的全部需求</h3>
<a href='index.jsp'>回首頁</a>|
<form action='demand.do' method='GET'>
	<input type='text' name='schoolId' value='${param.schoolId}'>
	<input type='submit' name='findOne' value='app'>
</form>
<c:forEach var='item' items='${OneAllDemands}'>
<table style="width:200px;height:60px;float:left;background-color:#FFD382;">
	<tr><td>-----------------</td></tr>
	<tr><td>${item.donationId}</td></tr>
	<tr><td>${item.schoolId}</td></tr>
	<tr><td>${item.schoolName}</td></tr>
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
	<tr><td><a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>">詳細內容</a></td></tr>
<%-- 	<tr><td>${item.imageName}</td></tr> --%>
<%-- 	<tr><td>${item.imageFile}</td></tr> --%>
	<form action='<c:url value="cart.do"/>' method='POST' target="hidden_frame">
	<tr><td><input type='submit' name='toCart' value='insert'></td></tr>
	<input type='hidden' name='donationId' value='${item.donationId}'>
	<input type='hidden' name='schoolId' value='${item.schoolId}'>
	<input type='hidden' name='schoolName' value='${item.schoolName}'>
	<input type='hidden' name='donationStatus' value='${item.donationStatus}'>
	<input type='hidden' name='supplyName' value='${item.supplyName}'>
	<input type='hidden' name='originalDemandNumber' value='${item.originalDemandNumber}'>
	<input type='hidden' name='originalDemandUnit' value='${item.originalDemandUnit}'>
	<input type='hidden' name='demandNumber' value='${item.demandNumber}'>
	<input type='hidden' name='size' value='${item.size}'>
	<input type='hidden' name='demandContent' value='${item.demandContent}'>
	<input type='hidden' name='supplyStatus' value='${item.supplyStatus}'>
	<input type='hidden' name='demandTime' value='${item.demandTime}'>
	<input type='hidden' name='expireTime' value='${item.expireTime}'>
	<input type='hidden' name='imageName' value='${item.imageName}'>
	<input type='hidden' name='imageFile' value='${item.imageFile}'>
	<input type='hidden' name='imageLength' value='${item.imageLength}'>
	<input type='hidden' name='remark' value='${item.remark}'>
	</form>
	<td><img src='${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}'></td>
	
<%-- 	<tr><td>${item.imageLength}</td></tr> --%>
<%-- 	<form action='<c:url value=""/>' method='POST'> --%>
<!-- 	<tr><td><input type='submit' name='hidden' value='修改'></td></tr> -->
<!-- 	</form> -->
</table>
</c:forEach>
</center>
<iframe name='hidden_frame' style='width:0px;height:0px'></iframe>
</body>
</html>