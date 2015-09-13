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
		
		.content
		{
			border:1px solid red; /*測試顯示用 */
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>displayPrimaryProjAll</title>
</head>
<body>
	<h3>初步計畫查看[預計只有學校可以看]</h3>
	

	<c:forEach  var="primaryProj" items="${primaryProjAll}" varStatus="count" >
		<c:url value="/primaryProj.do" var="path">
			<c:param name="type" value="display" />
			<c:param name="primaryProjId" value="${primaryProj.primaryProjId}" />
		</c:url>
		<div class="content">
			<div>
			計畫名稱:${primaryProj.title}
			</div>
			<div>
			<a href="${path}"><img src="${primaryProj.bsae64String}" class="frontImg"></a>
			</div>
			<div>
			計畫摘要 顯示在圖片上專用 ${primaryProj.projAbstract}
			</div>
		</div>
		
<!-- 		三次迴圈 執行一次 -->
		<c:if test="${(count.index + 1) % 3 == 0}">
			<br>
		</c:if>
	</c:forEach>
</body>
</html>