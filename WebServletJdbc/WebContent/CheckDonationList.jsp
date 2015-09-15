<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckDonationList</title>

</head>
<body>
<center>
	<h3>確認捐贈清單</h3>
	<a href='index.jsp'>回首頁</a>|
	<table style="width:1000px;height:60px;background-color:#FFD382;border:1px solid black;">
<!-- 	<tr><td>donationId</td><td>schoolId</td><td>schoolName</td><td>supplyName</td><td>originalDemandNumber</td><td>originalDemandUnit</td><td>demandNumber</td><td>donateAmount</td><td>size</td><td>demandContent</td><td>supplyStatus</td><td>捐贈數量</td></tr> -->
	<tr><td>學校</td><td>需求物資</td><td>原始需求</td><td>單位</td><td>剩餘需求</td><td>捐獻數量</td><td>尺寸</td><td>物品狀態</td></tr>
	<c:forEach var='item' items='${DonationCart.content}'>
<%-- 	<tr><td>${item.value.donationId}</td></tr> --%>
	<tr>
<%-- 	<td>${item.value.donationId}</td> --%>
<%-- 	<td>${item.value.schoolId}</td> --%>
	<td>${item.value.schoolName}</td>
<%-- 	<tr><td>${item.value.donationStatus}</td></tr> --%>
	<td>${item.value.supplyName}</td>
	<td>${item.value.originalDemandNumber}</td>
	<td>${item.value.originalDemandUnit}</td>
	<td>${item.value.demandNumber}</td>
	<form action='<c:url value="cart.do"/>' method='POST'>
	<td>
	<input type='submit' name='toCart' value='delete'>
	<input type='text' name='donateAmount' value='${item.value.donateAmount}' style='width:50px'>
	<input type='hidden' name='donationId' value='${item.value.donationId}'>
	<input type='submit' name='toCart' value='update'>
	</td>
	<td>${item.value.size}</td>
<%-- 	<td>${item.value.demandContent}</td> --%>
	<td>${item.value.supplyStatus}</td>
	</form>
	</tr>
	</c:forEach>
	</table>
	<form action='<c:url value="checkOrder.do"/>' method='POST'>
	<input type='submit' name='fillOrder' value='booking'>
	</form>
</center>
</body>
</html>