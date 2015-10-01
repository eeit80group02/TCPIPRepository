<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="<c:url value='/fakeInfos.do' />" method="post">
			
			<textarea rows="100" cols="100" name="projAbstract" id="projAbstract"></textarea>
				
			<button type="submit">submit</button>
			
			</form>
			
			
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script>
	alert("hahaha");


</script>
<script>
//指定ckeditor()的skin
CKEDITOR.replace(projAbstract,{skin:"moono"});
</script>

</body>
</html>