<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		.error{
			color:#FF0000;
		}
		
		.frontImg {
			width:310px;
			height:210px;
 			border:1px solid red; /*測試顯示用 */
		}
	</style>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>updatePrimaryProj</title>
</head>
<body>
	<h3>編輯初步計畫</h3>
	<form id="updateForm"action="<c:url value="/primaryProj.do" />" method="post" enctype="multipart/form-data">
	
	
	<input type="hidden" name="memberId" value="${param.memberId}${primaryProj.memberId}" /><br>
	<input type="hidden" name="primaryProjId" value="${param.primaryProjId}${primaryProj.primaryProjId}" /><br>
	
	會員編號:${param.primaryProjId}${primaryProj.memberId}<br>
	計畫編號:${param.primaryProjId}${primaryProj.primaryProjId}<br>
	計畫名稱<input type="text" name="title" value="${param.title}${primaryProj.title}" /><span class="error">${error.title}</span><br>
	計畫封面<input type="file" name="imgFile" accept="image/jpeg,image/png" value=""/><span class="error">${error.imgFile}</span><br>
	
	計畫摘要<textarea rows="10" cols="100" name="projAbstract">${param.projAbstract}${primaryProj.projAbstract}</textarea><span class="error">${error.projAbstract}</span><br>
	計畫內容<textarea rows="10" cols="100" name="content">${param.content}${primaryProj.content}</textarea><span class="error">${error.content}</span><br>
	理想地點<input type="text" value="${param.location}${primaryProj.idealPlace}"  name="location"><span class="error">${error.location}</span><br>
	
	<fmt:formatDate var="startTime" value="${primaryProj.activityStartTime}"  type="date" pattern="yyyy-MM-dd" />
	<fmt:formatDate var="endTime" value="${primaryProj.activityEndTime}"  type="date" pattern="yyyy-MM-dd" />
	
	活動時間<input type="date" value="${param.startTime}${startTime}" name="startTime"><span class="error">${error.startTime}</span>
	     <input type="date" value="${param.endTime}${endTime}" name="endTime"><span class="error">${error.endTime}</span><br>
	
	
	預計人數<input type="number" value="${param.demandNum}${primaryProj.demandNum}" name="demandNum" /><span class="error">${error.demandNum}</span><br>
	活動預算<input type="number" value="${param.budget}${primaryProj.budget}" name="budget" /><span class="error">${error.budget}</span><br>
	

	<img src="${primaryProj.bsae64String}" class="frontImg">

	
	<input type="hidden" name="type" value="update" />
	<input type="submit" value="送出">
	
	</form>
</body>
</html>