<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 標頭css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- <script type="text/javascript" src="../donationScripts/jquery-1.10.2.js"></script> -->
<script type="text/javascript" src="../donationScripts/jquery-ui.js"></script>
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
				<li class="chooseItem" value="數量"><a href="<c:url value='search.do?type=byAmount'/>">數量</a></li>
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

				<li><a class="dropdown-button" href="#!" data-activates="dropdownList03"><i class="large material-icons" id="pleaseLogin">person<i class="mdi-navigation-arrow-drop-down right"></i></i></a>
					<ul id="dropdownList03" class="dropdown-content">
						<!-- 有登入時，會有學校頁面或者個人頁面 -->
						<c:if test="${not empty LoginOK}">
							<c:if test="${LoginOK.beanName.equals('member')}">
								<li><a href="<c:url value="/personal/personmanager.jsp" />">會員頁面</a></li>
								<li><a href="<c:url value='/donation/demand.do?type=OrderDetailByMember'/>">查詢宅配</a></li>
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

	<!-- scrollamount 調整跑馬燈速度 -->
	<!-- 愛心圖示 + 感謝 + 捐獻者名字 +捐獻+ 捐獻物品 -->
	<marquee id="headMarquee" scrollamount="8">
		<c:forEach var='item' items='${ODS}'>
			<img src="../images/heart.png" width="20px">感謝 <b> ${item.name}</b>
			捐獻 
			<c:forEach var='initem' items='${item.dodbList}'>
				<b>${initem.supplyName}&nbsp;</b>
			</c:forEach>
		</c:forEach>
	</marquee>

	<center>
		<!-- Content -->
		<div class="ui-widget ui-helper-clearfix" id="donateBody">
			<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">

				<c:forEach var='item' items='${AllDemands}' varStatus='vs'>
					<li class="ui-widget-content ui-corner-tr" id="${item.donationId}" value="${item.donationId}">
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
									<a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" title="${item.supplyName} - ${item.schoolName}" class="ui-icon ui-icon-zoomin" id="${item.donationId}+${item.schoolId}+${item.schoolName}+${item.supplyStatus}+${item.supplyName}+${item.originalDemandNumber}+${item.originalDemandUnit}+${item.demandNumber}+${item.size}+${item.demandContent}+${item.supplyStatus}+${item.remark}+${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}+${item.originalDemandUnit}"></a> <a href="link/to/trash/script/when/we/have/js/off" title="加入捐獻背包" class="ui-icon ui-icon-suitcase"></a>
									<%-- 									<a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" title="${item.supplyName} - ${item.schoolName}" class="ui-icon ui-icon-zoomin" id="${item.donationId}+${item.schoolId}+${item.schoolName}+${item.supplyStatus}+${item.supplyName}+${item.originalDemandNumber}+${item.originalDemandUnit}+${item.demandNumber}+${item.size}+${item.demandContent}+${item.supplyStatus}+<fmt:formatDate value="${OneDemand.demandTime}" pattern="yyyy-MM-dd hh:mm"/>+<fmt:formatDate value="${OneDemand.expireTime}" pattern="yyyy-MM-dd"/>+${item.remark}+${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}+${item.originalDemandUnit}"></a> <a href="link/to/trash/script/when/we/have/js/off" title="加入捐獻背包" class="ui-icon ui-icon-suitcase"></a> --%>
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div id="trash" class="ui-widget-content ui-state-default">
				<div id="trashHeadTitleIcons">
					<span id="trashHeadLeftBtn">
						<button type="submit" id="donateTotal" class="btn btn-small btn-floating">
							<a href="<c:url value='checkOrder.do?linkto=stepOne'/>" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="查看捐獻明細"><i class="tiny material-icons">card_giftcard</i></a>
						</button>
					</span> <span id="trashHeadRightBtn">
						<button type="button" id="donateDelete" class="btn btn-small btn-floating">
							<a href="cart.do?toCart=deleteAll" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清空背包"><i class="tiny material-icons">delete</i></a>
						</button>
					</span>
				</div>

				<div class="alert alert-success" role="alert" id="trashBody">
					<h3 id="trashHead">
						<span id="donateBagTitle">捐獻背包</span>
					</h3>
				</div>
			</div>

			<!-- 有登入時，會有學校頁面或者個人頁面 -->
			<c:if test="${not empty LoginOK}">
				<c:if test="${LoginOK.beanName.equals('member')}">
					<!-- 會員登入 -->
					<script type="text/javascript">
						$("#donateTotal").one('mouseover', function() {
							Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>點我進行捐獻</span>', 3000, 'rounded');
						});
					</script>
				</c:if>

				<c:if test="${LoginOK.beanName.equals('school')}">
					<!-- 學校登入 -->
					<script type="text/javascript">
						$("#donateTotal").one('mouseover', function() {
							Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>請使用會員帳號登入，可進行捐獻</span>', 5000, 'rounded');
						});
						$("#donateTotal").mousedown(function() {
							alert("由首頁登入會員帳號");
							$("#TCPIP").trigger("click");
						});
					</script>
				</c:if>
			</c:if>
			<!-- 沒登入時，必須看到登入按鈕 -->
			<c:choose>
				<c:when test="${empty LoginOK}">
					<!-- 沒登入時 -->
					<script type="text/javascript">
						$("#donateTotal").one('mouseover', function() {
							Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>登入後，可進行捐獻</span>', 5000, 'rounded');
							$("#pleaseLogin").trigger("click");
						});
						$("#donateTotal").mousedown(function() {
							alert("由首頁登入會員帳號");
							$("#TCPIP").trigger("click");
						});
					</script>
				</c:when>
				<c:otherwise>
					<!-- 有登入時 -->
				</c:otherwise>
			</c:choose>

		</div>

	</center>

	<script>
		// deleteAll
		$('#donateDelete').click(function() {
			// 設定cookie值
			var now = new Date();
			now.setTime(now.getTime() - 1);
			document.cookie = "Items=;expire=" + now.toUTCString();
		});

		// 取出指定name的value
		var objName = "Items";
		var tempvalue = getCookie(objName);
		console.log("!   " + tempvalue);
		var value = tempvalue.match(/[0-9]+/g);
		for (var c = 0; c < value.length; c++) {
			console.log(value[c]);
			// 傳入已加入購物車的清單
			var i = value[c];
			var data = $("#" + i + "");
			deleteImage(data);
		}
		//獲取指定名稱的cookie的值 
		function getCookie(objName) {
			var arrStr = document.cookie.split("; ");
			for (var i = 0; i < arrStr.length; i++) {
				var temp = arrStr[i].split("=");
				if (temp[0] == objName)
					return unescape(temp[1]);
			}
		}
		// 傳入已加入購物車的清單
		// 		var i = "${item}";
		// 		var data = $("#" + i + "");
		// 		deleteImage(data);

		// there's the gallery and the trash
		var $gallery = $("#gallery"), $trash = $("#trash"), $head5 = $(".ui-widget-header");

		// let the gallery be droppable as well, accepting items from the trash
		$gallery.droppable({
			accept : "#trash li",
			activeClass : "custom-state-active",
			drop : function(event, ui) {
				recycleImage(ui.draggable);
			}
		});

		function deleteImage(data) {
			var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='取消選取' class='ui-icon ui-icon-refresh' style='float: right'></a>";
			var donationId = data.attr("value");

			addToCart(donationId);

			data.find(".fiximg div").css('visibility', 'hidden');
			data.fadeOut(function() {
				var $list = $("ul", $trash).length ? $("ul", $trash) : $("<ul class='gallery ui-helper-reset'/>").appendTo($trash);

				data.find("a.ui-icon-suitcase").remove();
				data.append(recycle_icon).appendTo($list).fadeIn(function() {
					data.animate({
						width : "190px"
					}).find("img").animate({
						height : "124px"
					});
				});
			});
		}

		function addToCart(donationId) {

			var xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.addEventListener("readystatechange", function() {
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							lists = xhr.responseText;

							// 設定cookie值
							var now = new Date();
							now.setTime(now.getTime() + 1000 * 60 * 60 * 24 * 30);
							document.cookie = "Items=" + lists + ";expire=" + now.toUTCString();

						} else {

							// 						alert("something is wrong!");
						}
					}
				});
				xhr.open("POST", "cart.do", true);
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xhr.send("toCart=insert&returnJson=true&donationId=" + donationId);
			}
		}
	</script>

	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<script type="text/javascript" src="../donationScripts/ScreenSize.js"></script>
	<script type="text/javascript" src="../donationScripts/AutoComplete.js"></script>

</body>
</html>
