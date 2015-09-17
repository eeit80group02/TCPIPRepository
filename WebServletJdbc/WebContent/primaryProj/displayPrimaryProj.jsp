<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<!-- 頁首 -->
	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->
	
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
			<fmt:formatDate var="startTime" value="${primaryProj.activityStartTime}"  type="date" pattern="yyyy-MM-dd" />
			<fmt:formatDate var="endTime" value="${primaryProj.activityEndTime}"  type="date" pattern="yyyy-MM-dd" />
			<td>活動時間</td>
			<td>${startTime} ~ ${endTime}</td>
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
	<img src="${primaryProj.base64String}" class="frontImg">
	
	<hr>
	
	<c:set var="deadline" value="900000" />
	<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set> 

<!-- 	檢查 發起者ID 跟 session id是否一致  如果是該發起者  才顯示出修改 -->
	<c:if test="${LoginOK.beanName.equals('member')}">
		<c:if test="${LoginOK.memberId == primaryProj.memberId && (primaryProj.createDate.time + deadline) - nowDate > 0}">
			<form action="<c:url value="/primaryProj.do" />" method="post">
				<input type="hidden" name="type" value="displayUpdate">
				<input type="hidden" name="primaryProjId" value="${primaryProj.primaryProjId}">
				<input type="submit" value="修改">
			</form>
		</c:if>
	</c:if>

<!-- 	檢查 登入者是否學校 -->
	<c:if test="${LoginOK.beanName.equals('school')}">
		<form action="<c:url value="/ProcessingProj.do" />" method="post">
			<input type="hidden" name="schoolId" value="${LoginOK.schoolId}">
			<input type="hidden" name="primaryProjId" value="${primaryProj.primaryProjId}">
			<input type="hidden" name="type" value="apply">
			<input type="submit" value="申請計畫洽談" >
		</form>
	</c:if>
	
	<hr>
	上面有隱藏按妞，初步計畫發布後15分內能再變更<br>
<!-- 	下面有隱藏按妞，初步計畫發布後15分內能再變更 -->
	<c:if test="${LoginOK.beanName.equals('member')}">
		<c:if test="${LoginOK.memberId == primaryProj.memberId}">
			<form action="<c:url value="/primaryProj.do" />" method="post">
				<input type="hidden" name="type" value="displayUpdate">
				<input type="hidden" name="primaryProjId" value="${primaryProj.primaryProjId}">
				<input type="submit" value="修改">
			</form>
		</c:if>
	</c:if>
	
	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->
	
	


</body>
</html>