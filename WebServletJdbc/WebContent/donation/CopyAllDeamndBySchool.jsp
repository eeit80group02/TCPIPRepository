<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>捐獻牆</title>

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
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 標頭css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- 預設 （本機）-->
<link rel="stylesheet" href="../donationStyles/jquery-ui.css">
<script type="text/javascript" src="../donationScripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../donationScripts/jquery-ui.js"></script>

<!-- 預設（遠端） -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationWall.css">
<script type="text/javascript" src="../donationScripts/Donation.js"></script>
<script type="text/javascript" src="../donationScripts/picture-big.js"></script>


<!-- 在多加載一次picture-big，比較保險 -->

<script type="text/javascript" src="../donationScripts/picture-big.js"></script>

</head>
<body>
	<!-- 我就是標頭 start -->
	<div class="navbar-fixed">
		<nav>
			<div class="nav-wrapper">
				<ul id="nav-mobile1" class="left hide-on-med-and-down">
					<li><a href="../index.jsp"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
				</ul>

				<ul id="nav-mobile2" class="">
					<li><a href="#"><img alt="捐獻牆" title="捐獻牆" id="DonationWallIcon" src="../images/DonationHeader02.png" class="brand-logo"></a></li>
				</ul>
				<ul id="nav-mobile3" class="right hide-on-med-and-down">
					<li>
						<form action="<c:url value="/donation/demand.do?type=FindGoods" />">
							<div class="input-field">
								<input id="searchDonation" type="search" required placeholder="輸入物品或學校" autocomplete="off"> <label for="search"><i class="large material-icons" id="searchIcon">search</i></label>
							</div>
						</form>
					</li>
					<li><i class="large material-icons" id="clearIcon">clear</i></li>
					<li class="chooseItem" value="熱門"><a href="#">熱門</a></li>
					<li class="chooseItem" value="需求數量"><a href="#">需求數量</a></li>
					<li><a class="dropdown-button" href="#!" data-activates="dropdownList01">時間<i class="mdi-navigation-arrow-drop-down right"></i></a>
						<ul id="dropdownList01" class="dropdown-content">
							<li class="chooseDropdownItem" value="最新發佈"><a href="#">最新發佈</a></li>
							<li class="divider"></li>
							<li class="chooseDropdownItem" value="即將結束"><a href="#">即將結束</a></li>
						</ul></li>
					<li><a class="dropdown-button" href="#!" data-activates="dropdownList02">物資狀態<i class="mdi-navigation-arrow-drop-down right"></i></a>
						<ul id="dropdownList02" class="dropdown-content">
							<li class="chooseDropdownItem" value="不拘"><a href="#">不拘</a></li>
							<li class="divider"></li>
							<li class="chooseDropdownItem" value="全新"><a href="#">全新</a></li>
							<li class="divider"></li>
							<li class="chooseDropdownItem" value="二手"><a href="#">二手</a></li>
						</ul></li>
					<li><a href="#"><i class="large material-icons">person</i></a></li>
				</ul>
			</div>
		</nav>
	</div>
	<br>
	<!-- 我就是標頭 end -->

	<!-- scrollamount 調整跑馬燈速度 -->
	<!-- 愛心圖示 + 感謝 + 捐獻者名字 +捐獻+ 捐獻物品 -->
	<marquee id="headMarquee" scrollamount="8">
		<img src="../images/heart.png" width="20px">感謝 <b> 許阿瑋 </b>捐獻 <b> 50吋 液晶電視 </b><img src="../images/heart.png" width="20px">感謝 <b> 彭翔翔 </b>捐獻 <b> A4 影印紙 </b><img src="../images/heart.png" width="20px">感謝 <b> 郭豪豪 </b>捐獻 <b> 電風扇 </b>
	</marquee>

	<center>
		<!-- Content -->
		<div class="ui-widget ui-helper-clearfix" id="donateBody">
			<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">

				<c:forEach var='item' items='${OneAllDemands}' varStatus='vs'>
					<li class="ui-widget-content ui-corner-tr" value="${item.donationId}">
						<div>
							<div class="fiximg">
								<!-- h5 標籤不能新增修改，後面設定會用 -->
								<div class="alert alert-info" role="alert">
									<h5>${item.supplyName}-${item.schoolName}</h5>
								</div>
								<img class="bigimg" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}" alt="${item.supplyName}" title="${item.supplyName}">
							</div>
							<div>
								<div class="foottext">需求數量 : ${item.demandNumber}</div>
								<div class="footIcin">
									<div id="add${vs.index}">
										<a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" title="${item.supplyName} - ${item.schoolName}" class="ui-icon ui-icon-zoomin" id="${item.donationId}+${item.schoolId}+${item.schoolName}+${item.supplyStatus}+${item.supplyName}+${item.originalDemandNumber}+${item.originalDemandUnit}+${item.demandNumber}+${item.size}+${item.demandContent}+${item.supplyStatus}+${item.demandTime}+${item.expireTime}+${item.remark}+${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}+${item.originalDemandUnit}" ></a> <a href="link/to/trash/script/when/we/have/js/off" title="加入捐獻背包" class="ui-icon ui-icon-suitcase"></a>
<%-- 										<a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" title="${item.supplyName} - ${item.schoolName}" class="ui-icon ui-icon-zoomin" id="${item.donationId}+${item.schoolId}+${item.schoolName}+${item.supplyStatus}+${item.supplyName}+${item.originalDemandNumber}+${item.originalDemandUnit}+${item.demandNumber}+${item.size}+${item.demandContent}+${item.supplyStatus}+${item.demandTime}+${item.expireTime}+${item.remark}" ></a> <a href="link/to/trash/script/when/we/have/js/off" title="加入捐獻背包" class="ui-icon ui-icon-suitcase"></a> --%>
									</div>		
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>

			<div id="trash" class="ui-widget-content ui-state-default">

				<div class="alert alert-success" role="alert" id="xx">
					<h3 id="trashHead">
						<span id="trashHeadLeftBtn">
							<button type="submit" id="donateTotal" class="btn btn-small btn-floating">
								<a href="CheckDonationList.jsp" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="加入捐獻背包"><i class="tiny material-icons">card_giftcard</i></a>
							</button>
						</span> <span id="donateBagTitle">捐獻背包</span> <span id="trashHeadRightBtn">
							<button type="reset" id="donateDelete" class="btn btn-small btn-floating">
								<a href="cart.do?toCart=deleteAll" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清空背包"><i class="tiny material-icons">delete</i></a>
							</button>
						</span>
					</h3>
				</div>
			</div>
		</div>
	</center>
	<!-- 標頭專用 bottom start -->
	<!-- 必須最後載入才有效果 -->
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js" type="text/javascript"></script>
	<!-- 標頭專用 bottom end -->


	<script type="text/javascript" src="../donationScripts/Maquee.js"></script>
	<script type="text/javascript" src="../donationScripts/ScreenSize.js"></script>
	</center>
</body>
</html>