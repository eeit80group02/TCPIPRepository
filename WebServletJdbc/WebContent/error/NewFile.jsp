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
			
			
						<div class="row">
							<div class="col l8">
								<div class="forinput">計畫摘要<span style="font-size:0.8em;font-weight:300;">字數僅限100字內</span></div>
								<textarea class="materialize-textarea" id="content" name="projAbstract" style="font-size:1.2em;color:black;font-weight:600;" required>${param.projAbstract}</textarea>
							</div>
							<div class="col l4">	
								<span class="error">${error.projAbstract}</span>
							</div>
						</div>

						<input type="submit" value="submit">

			</form>
			
			
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

<script>
//指定ckeditor()的skin
CKEDITOR.replace(content,{skin:"moono"});
</script>

</body>
</html>