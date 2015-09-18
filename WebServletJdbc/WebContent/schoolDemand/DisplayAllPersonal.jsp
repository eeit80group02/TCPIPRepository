<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<!-- 學校自己看自己寫了多少計畫 -->
	<form action="SchoolDemandServlet.do?type=displayPersonalAll" method="post">
	<input type="submit">
	</form>
	<c:forEach var="bean" items="${list}">
		${bean.participant}<br>      <%-- 預計參與的學生人數 --%>
		${bean.activityTopic}<br>    <%-- 活動主題(指學校希望志工規劃的主題)--%>
		${bean.activityLocation}<br> <%-- 活動地點(非必填) --%>
		${bean.activitySuitable}<br> <%-- 活動適合對象(指學校希望志工來帶領的人的程度) --%>
		${bean.activityHost}<br>     <%-- 活動負責人(學校方負責此項計畫的聯絡人) --%>
		${bean.activityContact}<br>  <%-- 負責人聯絡方式(市話、手機皆可，前端提醒使用者依照輸入的格式) --%>
		${bean.createDate}<br>       <%-- 建立日期(計畫需求發佈的日期)- 可以算出媒合期截止時間 --%>
		${bean.content}<br>          <%-- 需求內容(1000字?) --%>
		${bean.demandStatus}<br>     <%-- 計畫狀態(待洽談、洽談中、洽談完成、洽談失敗) --%>
		${bean.offerBean.room}<br>   <%-- 住宿(1表示提供 0 表示不提供) --%>
		${bean.offerBean.place}<br>  <%-- 活動場地(1表示提供 0 表示不提供) --%>
		${bean.offerBean.food}<hr>   <%-- 伙食(1表示提供 0 表示不提供) --%>
	</c:forEach>
</body>
</html>