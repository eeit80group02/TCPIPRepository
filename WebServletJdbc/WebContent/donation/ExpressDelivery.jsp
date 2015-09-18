<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Express delivery</title>
</head>
<body>
<center>
<h3>Express delivery</h3>
<a href='DonationIndex.jsp'>回首頁</a>|
	<table style="width:1000px;height:60px;background-color:#66FFFF;border:1px solid black;">
		<form action='<c:url value="access.do"/>' method='POST'>
		<tr>
		<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名<input type='text' name='name' value=''></td>
		<td>取件地址<input type='text' name='address' value=''></td>
		</tr>
		<tr>
		<td>電&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;話<input type='text' name='phone' value=''></td>
		<td>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;機<input type='text' name='cellPhone' value=''></td>
		<td>電子郵件<input type='text' name='email' value=''></td>
		</tr>
		<tr>
		<td>取件時間<input type='text' name='pickTime' value=''></td>
		<td>捐獻日期<input type='text' name='donationOederDate' value=''></td>
		</tr>
		<tr>
		<td>訂單編號<input type='text' name='dealId' value=''></td>
		</tr>
		<input type='submit' name='' value='insertOrder'></td>
		</form>
	</table>
	
	<table style="width:1000px;height:60px;background-color:#66FFFF;border:1px solid black;">
<!-- 	<tr><td>donationId</td><td>schoolId</td><td>supplyName</td><td>originalDemandNumber</td><td>originalDemandUnit</td><td>demandNumber</td><td>donateAmount</td><td>size</td><td>demandContent</td><td>supplyStatus</td><td>捐贈數量</td></tr> -->
	<tr><td>學校</td><td>需求物資</td><td>原始需求</td><td>單位</td><td>剩餘需求</td><td>捐獻數量</td><td>尺寸</td><td>物品狀態</td></tr>
	<c:forEach var='item' items='${DonationCart.content}'>
	<tr>
<%-- 	<td>${item.value.donationId}</td> --%>
<%-- 	<td>${item.value.schoolId}</td> --%>
	<td>${item.value.schoolName}</td>
	<td>${item.value.supplyName}</td>
	<td>${item.value.originalDemandNumber}</td>
	<td>${item.value.originalDemandUnit}</td>
	<td>${item.value.demandNumber}</td>
	<td>${item.value.donateAmount}</td>
	<td>${item.value.size}</td>
<%-- 	<td>${item.value.demandContent}</td> --%>
	<td>${item.value.supplyStatus}</td>
	</tr>
	</c:forEach>
	</table>
</center>
</body>
</html>