<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OneMemberDemand</title>
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
						<li class="chooseDropdownItem" value="全新"><a href="#">學校頁面</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="不拘"><a href="#">登入/出</a></li>
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
				<td rowspan="10" id="donationImage"><img alt="${OneDemand.supplyName}" title="${OneDemand.supplyName}" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}" id="donationPicture"></td>
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
				<td class="dataValue">${OneDemand.schoolName}</td>
			</tr>
			<tr>
				<td class="dataName">需求單位地址：</td>
				<td class="dataValue">屏東縣鹽埔鄉鹽南村勝利路30號</td>
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
						<div class="collapsible-header">
							<span class="glyphicon glyphicon-question-sign"></span> <b>${item.memberName}</b>：
							<c:if test="${!empty item.schoolMessage}">
								<span class="schoolCheck"><span class="schoolCheck"><i class="small material-icons">check_circle</i></span></span>
								<!-- 								<span class="glyphicon glyphicon-ok-sign"></span> -->
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
														<textarea id="your-message" name='textarea' class="materialize-textarea"></textarea>
														<label for="your-message" class=""><i class="medium material-icons">comment</i></label>
													</div>

													<div class="messageGO">
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
		<hr>
	</center>
</body>
</html>