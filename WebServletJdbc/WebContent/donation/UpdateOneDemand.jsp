<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateContent</title>
<style>
#div1 {
	border:1px solid green;
}
</style>
</head>
<body>
<center>
<h3>更新刊登內容</h3>
<a href='DonationIndex.jsp'>回首頁</a>|
<input type='text' name='schoolId' value='${param.schoolId}'>
<input type='submit' name='findOne' value='app'>
<hr>

<form  enctype='multipart/form-data' action='donate.do' method='POST'>
		<table id='table1'>
			<tr>
				<td>捐獻編號</td>
				<td>${OneDemand.donationId}</td>
				<td><input type='hidden' name='donationId' value='${OneDemand.donationId}'></td>
			</tr>
			<tr>
				<td>學校編號</td>
				<td>${OneDemand.schoolId}</td>
				<td><input type='hidden' name='schoolId' value='${OneDemand.schoolId}'></td>
			</tr>
			<tr>
				<td>捐獻是否完成</td>
				<td>${OneDemand.donationStatus}</td>
				<input type='hidden' name='donationStatus' value='${OneDemand.donationStatus}'>
			</tr>
			<tr>
				<td>物資名稱</td>
				<td>${OneDemand.supplyName}</td>
				<input type='hidden' name='supplyName' value='${OneDemand.supplyName}'>
			</tr>
			<tr>
				<td>原始輸入需求數量(數量)</td>
				<td>${OneDemand.originalDemandNumber}</td>
				<td><input type='hidden' name='originalDemandNumber' value='${OneDemand.originalDemandNumber}'></td>
			</tr>
			<tr>
				<td>原始輸入需求數量(單位)</td>
				<td>${OneDemand.originalDemandUnit}</td>
				<td><input type='hidden' name='originalDemandUnit' value='${OneDemand.originalDemandUnit}'></td>
			</tr>
			<tr>
				<td>現在需求數量及單位(數量)</td>
				<td>${OneDemand.demandNumber}</td>
			</tr>
			<tr>
				<td>尺寸規格(物品的大小>長*寬*高)</td>
				<td><input type='text' name='size' value='${OneDemand.size}'></td>
			</tr>
			<tr>
				<td>需求說明(為什麼需要這項物資)</td>
				<td><input type='text' name='demandContent'
					value='${OneDemand.demandContent}'></td>
			</tr>
			<tr>
				<td>物資狀態(全新/二手/不拘)</td>
				<td><input type='text' name='supplyStatus'
					value='${OneDemand.supplyStatus}'></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>募集提出需求時間(物品開始募集時間)(即刻上架)</td> -->
<!-- 				<td><input type='text' name='demandTime' -->
<%-- 					value='${OneDemand.demandTime}'></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>募集截止時間(物品結束募集時間)(當日0:00下架)</td> -->
<!-- 				<td><input type='text' name='expireTime' -->
<%-- 					value='${OneDemand.expireTime}'></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>圖片檔名</td> -->
<!-- 				<td><input type='text' name='imageName' -->
<%-- 					value='${OneDemand.imageName}'></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>圖片(需要的物品的圖片)</td>
				<td><input type='file' name='imageFile'
					value='${OneDemand.imageFile}'></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>圖片長度</td> -->
<!-- 				<td><input type='text' name='imageLength' -->
<%-- 					value='${OneDemand.imageLength}'></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>備註(可以填寫額外的訊息)</td>
				<td><input type='text' name='remark' value='${OneDemand.remark}'></td>
				<td><input type='submit' name='hidden' value='update'></td>
				<td><input type='submit' name='hidden' value='delete'></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>