<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	#table1 {
		width:500px;
		border:1 solid black;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<center>
<h3>刪除物資需求</h3>
<form  enctype='multipart/form-data' action='donate.do' method='POST'>
		<table id='table1'>
			<tr>
				<td>捐獻編號</td>
				<td><input type='text' name='donationId'
					value='${param.donationId}'></td>
			</tr>
			<tr>
				<td>學校編號</td>
				<td><input type='text' name='schoolId'
					value='${param.schoolId}'></td>
			</tr>
			<tr>
				<td>捐獻是否完成
				<td><input type='text' name='donationStatus'
					value='${param.donationStatus}'></br>
			</tr>
			<tr>
				<td>物資名稱</td>
				<td><input type='text' name='supplyName'
					value='${param.supplyName}'></td>
			</tr>
			<tr>
				<td>原始輸入需求數量(數量)</td>
				<td><input type='text' name='originalDemandNumber'
					value='${param.originalDemandNumber}'></td>
			</tr>
			<tr>
				<td>原始輸入需求數量(單位)</td>
				<td><input type='text' name='originalDemandUnit'
					value='${param.originalDemandUnit}'></td>
			</tr>
			<tr>
				<td>現在需求數量及單位(數量)</td>
				<td><input type='text' name='demandNumber'
					value='${param.demandNumber}'></td>
			</tr>
			<tr>
				<td>尺寸規格(物品的大小>長*寬*高)</td>
				<td><input type='text' name='size' value='${param.size}'></td>
			</tr>
			<tr>
				<td>需求說明(為什麼需要這項物資)</td>
				<td><input type='text' name='demandContent'
					value='${param.demandContent}'></td>
			</tr>
			<tr>
				<td>物資狀態(全新/二手/不拘)</td>
				<td><input type='text' name='supplyStatus'
					value='${param.supplyStatus}'></td>
			</tr>
			<tr>
				<td>募集提出需求時間(物品開始募集時間)(即刻上架)</td>
				<td><input type='text' name='demandTime'
					value='${param.demandTime}'></td>
			</tr>
			<tr>
				<td>募集截止時間(物品結束募集時間)(當日0:00下架)</td>
				<td><input type='text' name='expireTime'
					value='${param.expireTime}'></td>
			</tr>
			<tr>
				<td>圖片檔名</td>
				<td><input type='text' name='imageName'
					value='${param.imageName}'></td>
			</tr>
			<tr>
				<td>圖片(需要的物品的圖片)</td>
				<td><input type='file' name='imageFile'
					value='${param.imageFile}'></td>
			</tr>
			<tr>
				<td>圖片長度</td>
				<td><input type='text' name='imageLength'
					value='${param.imageLength}'></td>
			</tr>
			<tr>
				<td>備註(可以填寫額外的訊息)</td>
				<td><input type='text' name='remark' value='${param.remark}'></td>
				<td><input type='hidden' name='hidden' value='insert' ></td>
				<td><input type='submit' name='check' value='送出'></td>
			</tr>
		</table>
	</form>
	<H1>${updateOK.Success}</H1>
</center>
</body>
</html>