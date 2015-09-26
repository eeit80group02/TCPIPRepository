<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
<!-- 標頭專用 top end -->

</head>
<body>

	<div class="navbar-fixed">
		<nav>
		<div class="nav-wrapper">
			<ul id="nav-mobile1" class="left hide-on-med-and-down">
				<li><a href="../index.jsp"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
			</ul>

			<ul id="nav-mobile2" class="">
				<li><a href="<c:url value="/donation/demand.do?type=FindGoods" />"><img alt="捐獻牆" title="捐獻牆" id="DonationWallIcon" src="../images/DonationHeader02.png" class="brand-logo"></a></li>
			</ul>
			<ul id="nav-mobile3" class="right hide-on-med-and-down">
				<li>
					<form action="<c:url value='google.do'/>" method='GET' id="searchForm">
						<div class="input-field">
							<input id="searchDonation" name="searchDonation" type="search" required placeholder="輸入物品或學校" autocomplete="off"> <label for="searchDonation"> <i type='submit' class="large material-icons" id="searchIcon">search</i></label>
							<div id="div01"></div>
						</div>
					</form>
				</li>
				<li><i class="large material-icons" id="clearIcon">clear</i></li>
				<li class="chooseItem" value="需求數量"><a href="<c:url value='search.do?type=byAmount'/>">需求數量</a></li>
				<li><a class="dropdown-button" href="#!" data-activates="dropdownList01">時間<i class="mdi-navigation-arrow-drop-down right"></i></a>
					<ul id="dropdownList01" class="dropdown-content">
						<li class="chooseDropdownItem" value="最新發佈"><a href="<c:url value='search.do?type=byDemandtime'/>">最新發佈</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="即將結束"><a href="<c:url value='search.do?type=byExpiretime'/>">即將結束</a></li>
					</ul></li>
				<li><a class="dropdown-button" href="#!" data-activates="dropdownList02">物資狀態<i class="mdi-navigation-arrow-drop-down right"></i></a>
					<ul id="dropdownList02" class="dropdown-content">
						<li class="chooseDropdownItem" value="不拘"><a href="<c:url value='search.do?supplyStatus=1'/>">不拘</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="全新"><a href="<c:url value='search.do?supplyStatus=2'/>">全新</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="二手"><a href="<c:url value='search.do?supplyStatus=3'/>">二手</a></li>
					</ul></li>

				<li><a class="dropdown-button" href="#!" data-activates="dropdownList03"><i class="large material-icons">person<i class="mdi-navigation-arrow-drop-down right"></i></i></a>
					<ul id="dropdownList03" class="dropdown-content">
						<!-- 有登入時，會有學校頁面或者個人頁面 -->
						<c:if test="${not empty LoginOK}">
							<c:if test="${LoginOK.beanName.equals('member')}">
								<li><a href="<c:url value="/personal/personmanager.jsp" />">會員頁面</a></li>
							</c:if>

							<c:if test="${LoginOK.beanName.equals('school')}">
								<li><a href="<c:url value="/school/school.jsp" />">學校頁面</a></li>
							</c:if>
						</c:if>
						<li class="divider"></li>
						<!-- 沒登入時，必須看到登入按鈕 -->
						<c:choose>
							<c:when test="${empty LoginOK}">
								<li><a href="#modal1" class="modal-trigger">登入</a></li>
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

</body>
</html>