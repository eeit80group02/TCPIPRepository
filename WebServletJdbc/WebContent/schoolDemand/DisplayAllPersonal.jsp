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
<!-- �Ǯզۤv�ݦۤv�g�F�h�֭p�e -->
	<form action="SchoolDemandServlet.do?type=displayPersonalAll" method="post">
	<input type="submit">
	</form>
	<c:forEach var="bean" items="${list}">
		${bean.participant}<br>      <%-- �w�p�ѻP���ǥͤH�� --%>
		${bean.activityTopic}<br>    <%-- ���ʥD�D(���ǮէƱ�Ӥu�W�����D�D)--%>
		${bean.activityLocation}<br> <%-- ���ʦa�I(�D����) --%>
		${bean.activitySuitable}<br> <%-- ���ʾA�X��H(���ǮէƱ�Ӥu�ӱa�⪺�H���{��) --%>
		${bean.activityHost}<br>     <%-- ���ʭt�d�H(�Ǯդ�t�d�����p�e���p���H) --%>
		${bean.activityContact}<br>  <%-- �t�d�H�p���覡(���ܡB����ҥi�A�e�ݴ����ϥΪ̷̨ӿ�J���榡) --%>
		${bean.createDate}<br>       <%-- �إߤ��(�p�e�ݨD�o�G�����)- �i�H��X�C�X���I��ɶ� --%>
		${bean.content}<br>          <%-- �ݨD���e(1000�r?) --%>
		${bean.demandStatus}<br>     <%-- �p�e���A(�ݬ��͡B���ͤ��B���ͧ����B���ͥ���) --%>
		${bean.offerBean.room}<br>   <%-- ��J(1��ܴ��� 0 ��ܤ�����) --%>
		${bean.offerBean.place}<br>  <%-- ���ʳ��a(1��ܴ��� 0 ��ܤ�����) --%>
		${bean.offerBean.food}<hr>   <%-- �뭹(1��ܴ��� 0 ��ܤ�����) --%>
	</c:forEach>
</body>
</html>