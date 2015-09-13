<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<style>
		.frontImg {
			width:310px;
			height:210px;
 			border:1px solid red; /*測試顯示用 */
		}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>displayPrimaryProj</title>
</head>
<body>
	<h3>初步計畫查看</h3>
	<table>
		<tr>
			<td>初步計畫編號</td>
			<td>${primaryProj.primaryProjId}</td>
		</tr>
		<tr>
			<td>發起者</td>
			<td>${primaryProj.memberId}</td>
		</tr>
		<tr>
			<td>計畫名稱</td>
			<td>${primaryProj.title}</td>
		</tr>
		<tr>
			<td>計畫摘要</td>
			<td>${primaryProj.projAbstract}</td>
		</tr>
		<tr>
			<td>計畫內容</td>
			<td>${primaryProj.content}</td>
		</tr>
		<tr>
			<td>理想地點</td>
			<td>${primaryProj.idealPlace}</td>
		</tr>
		<tr>
			<td>活動時間</td>
			<td>${primaryProj.activityStartTime} ~ ${primaryProj.activityEndTime}</td>
		</tr>
		<tr>
			<td>活動預計人數</td>
			<td>${primaryProj.demandNum}</td>
		</tr>
		<tr>
			<td>活動預算</td>
			<td>${primaryProj.budget}</td>
		</tr>
	</table>
	<img src="${primaryProj.bsae64String}" class="frontImg">
	
<!-- 	檢查 發起者ID 跟 session id是否一致  如果是該發起者  才顯示出修改 -->
	<form action="<c:url value="/primaryProj.do" />" method="post">
		<input type="hidden" name="type" value="displayUpdate">
		<input type="hidden" name="primaryProjId" value="${primaryProj.primaryProjId}">
		<input type="submit" value="修改">
	</form>
	
<!-- 	檢查 登入者是否學校 -->
	<input type="submit" value="申請計畫洽談" >
	
	

</body>
</html>