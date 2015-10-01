<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理問與答</title>
<!-- 標頭專用 top start -->
<!-- 一定要載入的 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
	!window.jQuery && document.write("<script type='text/javascript' src='../donationScripts/jquery-2.1.4.min.js'><\/script>")
</script>
<!-- Materialize -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 標頭 css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationQASchool.css">

</head>
<body>
	<!-- 我就是標頭 start -->
	<div class="navbar-fixed">
		<nav>
		<div class="nav-wrapper">
			<ul id="nav-mobile1" class="left hide-on-med-and-down">
				<li><a href="../index.jsp"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
				<li><a href="<c:url value="/donation/demand.do?type=FindGoods" />"><img alt="捐獻牆" title="捐獻牆" id="DonationWallIcon" src="../images/DonationHeader02.png"></a></li>
			</ul>

			<a href="#" class="brand-logo center">問與答</a>
			<ul id="nav-mobile3" class="right hide-on-med-and-down">
				<li><a class="dropdown-button" href="#!" data-activates="dropdownList03"><i class="large material-icons">person<i class="mdi-navigation-arrow-drop-down right"></i></i></a>
					<ul id="dropdownList03" class="dropdown-content">
						<!-- 有登入時，會有學校頁面或者個人頁面 -->
						<c:if test="${not empty LoginOK}">
							<c:if test="${LoginOK.beanName.equals('member')}">
								<li><a href="<c:url value="/personal/personmanager.jsp" />">會員頁面</a></li>
							</c:if>

							<c:if test="${LoginOK.beanName.equals('school')}">
								<li><a href="<c:url value="/school/school.jsp" />">學校頁面</a></li>
								<li class="divider"></li>
								<li><a href="<c:url value="InsertDonateGoods.jsp" />">建立需求</a></li>
								<li class="divider"></li>
								<li><a href="<c:url value='/donation/demand.do?type=AllDeamndBySchool&schoolId=${LoginOK.schoolId}'/>"> 管理物資 </a></li>
							</c:if>
						</c:if>
						<li class="divider"></li>
						<!-- 沒登入時，必須看到登入按鈕 -->
						<c:choose>
							<c:when test="${empty LoginOK}">
								<li id="loginAccount"><a href="<c:url value="/index.jsp" />" class="modal-trigger">登入</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="<c:url value="/login/logout.jsp" />">登出</a></li>
							</c:otherwise>
						</c:choose>
					</ul></li>
			</ul>
		</div>
		</nav>
	</div>
	<br>
	<!-- 我就是標頭 end -->

	<center>
		<!-- 表格基本資料 -->
		<table id="donationDetailTable">
			<tr>
				<td rowspan="9" id="donationImage"><img alt="${OneDemand.supplyName}" title="${OneDemand.supplyName}" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}" id="donationPicture"></td>
				<td class="dataName">物資名稱：</td>
				<td class="dataValue">${OneDemand.supplyName}</td>
			</tr>
			<tr>
				<td class="dataName">剩餘需求：</td>
				<td class="dataValue">${OneDemand.demandNumber}${OneDemand.originalDemandUnit}</td>
			</tr>
			<tr>
				<td class="dataName">尺寸規格：</td>
				<td class="dataValue">${OneDemand.size}</td>
			</tr>
			<tr>
				<td class="dataName">物資狀態：</td>
				<td class="dataValue">${OneDemand.supplyStatus}</td>
			</tr>
			<tr>
				<td class="dataName">需求單位：</td>
				<td class="dataValue"><a href="https://www.google.com.tw/maps/search/${OneDemand.schoolName}" target="_blank" title="${OneDemand.schoolName}">${OneDemand.schoolName}</a></td>
			</tr>
			<tr>
				<td class="dataName">募集起始時間：</td>
				<td class="dataValue"><fmt:formatDate value="${OneDemand.demandTime}" pattern="yyyy-MM-dd hh:mm" /></td>
			</tr>
			<tr>
				<td class="dataName">募集結束時間：</td>
				<td class="dataValue"><fmt:formatDate value="${OneDemand.expireTime}" pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td class="dataName">募集原因：</td>
				<td class="dataValue">${OneDemand.demandContent}</td>
			</tr>

			<tfoot>
				<tr>
					<td id="addToBag"></td>
					<td style="text-align: right; width: 150px; vertical-align: top; padding-top: 10px;">備註：</td>
					<td class="dataValue"><div id="remark">${OneDemand.remark}</div></td>
				</tr>
			</tfoot>
		</table>

		<!-- Q&A -->
		<div id="QandA" class="col s12 m9">
			<ul class="collapsible" data-collapsible="expandable">
				<c:forEach var='item' items='${AllMessages}' varStatus="vs">
					<li id='li'>
						<div class="collapsible-header" style="word-break: break-all;">
							<span class="glyphicon glyphicon-question-sign"></span> <b>${item.memberName}</b>：
							<c:if test="${!empty item.schoolMessage}">
								<span class="schoolCheck"><span class="schoolCheck"><i class="small material-icons">check_circle</i></span></span>
							</c:if>
							<br>${item.memberMessage}
							<div class="talkTime">
								<fmt:formatDate value="${item.memberMessageTime}" pattern="yyyy-MM-dd hh:mm" />
							</div>
						</div>
						<div class="collapsible-body">
							<c:choose>
								<c:when test="${empty item.schoolMessage}">
									<c:choose>
										<c:when test="${LoginOK.schoolId == item.schoolId}">
											<form class="schoolTalkBack" action='<c:url value="/donation/messages.do"/>' method='POST'>
												<div class="row">
													<div class="input-field col m10 s10">
														<textarea id="your-message${vs.index}" name='textarea' class="materialize-textarea" style="font-size: 1.2em"></textarea>
														<label for="your-message${vs.index}" class="sayBoardText${vs.index}"><i class="medium material-icons">comment</i></label>
													</div>

													<div class="messageGO">
														<button type="button" id="OneClickOneDemandBySchool${vs.index}" } class="btn btn-small btn-floating">
															<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="自動填入"><i class="tiny material-icons">whatshot</i></a>
														</button>

														<script type="text/javascript">
															$(function() {
																$("#OneClickOneDemandBySchool${vs.index}").click(function() {																	
																	$("#your-message${vs.index}").val("只要是素色的紙都可以接受，感謝您的詢問！");
																	$(".sayBoardText${vs.index}").attr("class", "active");
																});
															}(jQuery));
														</script>

														<button type="submit" class="btn btn-small btn-floating" id="send-message">
															<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="送出"><i class="small material-icons">done</i></a>
														</button>
														<button type="button" class="btn btn-small btn-floating" id="cancel-message">
															<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
														</button>
													</div>
												</div>
												<input type='hidden' name='donationId' value='${OneDemand.donationId}'> <input type='hidden' name='schoolId' value='${OneDemand.schoolId}'> <input type='hidden' name='memberId' value='${item.memberId}'> <input type='hidden' name='donationDiscussId' value='${item.donationDiscussId}'> <input type='hidden' name='memberMessage' value='${item.memberMessage}'> <input type='hidden' name='memberMessageTime' value=' ${item.memberMessageTime}'> <input type='hidden' name='reporter' value='school'>

											</form>
										</c:when>
										<c:otherwise>
											<p>等待回覆...</p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<p>${item.schoolMessage}</p>
									<div class="talkBackTime">
										<fmt:formatDate value="${item.schoolMessageTime}" pattern="yyyy-MM-dd hh:mm" />
									</div>
								</c:otherwise>
							</c:choose>
							<br>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</center>
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
</body>
</html>