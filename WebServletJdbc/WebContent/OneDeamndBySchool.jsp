<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OneMemberDemand</title>
<style>
body {
	margin:0 auto;
}
#div1 {
	border:1px solid green;
}
</style>
</head>
<body>
<center>
<center>
<h3>${OneDemand.schoolName}單一需求</h3>
<a href='index.jsp'>回首頁</a>|
<!-- <form action='demand.do' method='GET'> -->
<%-- 	<input type='text' name='schoolId' value='${param.schoolId}'> --%>
<!-- 	<input type='submit' name='findOne' value='app'> -->
<!-- </form> -->
<table style="width:200px;height:60px;background-color:#FFB7DD;">
	<tr><td>${OneDemand.donationId}</td></tr>
	<tr><td>${OneDemand.schoolId}</td></tr>
	<!-- 若為學校登入則關閉連結 -->
	<tr><td><a href="<c:url value='demand.do?type=AllDeamndBySchool&schoolId=${OneDemand.schoolId}&donationId=${OneDemand.donationId}&schoolName=${OneDemand.schoolName}'/>">${OneDemand.schoolName}全部需求</td></tr>
	<tr><td>${OneDemand.donationStatus}</td></tr>
	<tr><td>${OneDemand.supplyName}</td></tr>
	<tr><td>${OneDemand.originalDemandNumber}</td></tr>
	<tr><td>${OneDemand.originalDemandUnit}</td></tr>
	<tr><td>${OneDemand.demandNumber}</td></tr>
	<tr><td>${OneDemand.size}</td></tr>
	<tr><td>${OneDemand.demandContent}</td></tr>
	<tr><td>${OneDemand.supplyStatus}</td></tr>
	<tr><td>${OneDemand.demandTime}</td></tr>
	<tr><td>${OneDemand.expireTime}</td></tr>
	<tr><td>${OneDemand.remark}</td></tr>
<%-- 	<tr><td>${OneDemand.imageName}</td></tr> --%>
<%-- 	<tr><td>${OneDemand.imageFile}</td></tr> --%>
<%-- 	<tr><td>${OneDemand.imageLength}</td></tr> --%>
	<td><img src='${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}'></td>
</table>
<hr>
	<table>
	<c:forEach var='item' items='${AllMessages}'>
	<table style="width:800px;height:60px;background-color:#FFFF77;">
		<tr><th><P>會員:${item.memberName} 於 ${item.memberMessageTime} 留言</P></th></tr>
		<tr><th><P>${item.memberMessage}</P></th></tr>
		<!-- 學校有登陸才顯示是否有回復 -->
		
		
		<!-- 檢查學校是否有回復 -->
		<c:if test="${!empty item.schoolMessage}">
		<table style="width:800px;height:60px;background-color:#C3C3C3;">
		<tr><th><P>回復:${item.schoolId} 於 ${item.schoolMessageTime} 留言</P></th></tr>
		<tr><th><P>${item.schoolMessage}</P></th></tr>
		</table>
		</c:if>
		<c:if test="${empty item.schoolMessage}">
		<table style="width:790px;height:100px;background-color:#FF8888;">
		<form action='messages.do' method='POST'>
		<tr><th><input type='textarea' name='textarea' style="width:790px;height:60px;"></th></tr>
		<input type='hidden' name='donationId' value='${OneDemand.donationId}'>
		<input type='hidden' name='schoolId' value='${OneDemand.schoolId}'>
		<input type='hidden' name='memberId' value='${item.memberId}'>
		<input type='hidden' name='donationDiscussId' value='${item.donationDiscussId}'>
		<input type='hidden' name='memberMessage' value='${item.memberMessage}'>
		<input type='hidden' name='memberMessageTime' value=' ${item.memberMessageTime}'>
		<input type='hidden' name='reporter' value='school'>
		<tr><th><input type='submit' name='reply' value='回復'></th></tr>
		</form>
		</table>
		</c:if>

	</table>
	</c:forEach>
	</table>
	</center>
</center>
<iframe name='hidden_frame' style='width:0px;height:0px'></iframe>
</body>
</html>