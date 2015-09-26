<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問與答</title>
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
<!-- 標頭 css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationQA.css">
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
						<li class="chooseDropdownItem" value="會員頁面"><a href="#">會員頁面</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="登入/出"><a href="#">登入/出</a></li>
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
					<td id="addToBag">
						<button type="button" class="btn btn-large btn-floating">
							<a href="<c:url value='demand.do?type=AllDeamndByMember&schoolId=${OneDemand.schoolId}'/>" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="查看同學校的其他物資"><i class="medium material-icons">search</i></a>
						</button> &nbsp;

						<button type="button" name='toCart' value='insert' class="btn btn-large btn-floating" id="addItem">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="加入捐獻背包"><i class="medium material-icons">card_giftcard</i></a>
						</button>
					</td>
					<td style="text-align: right; width: 150px; vertical-align: top; padding-top: 10px;">備註：</td>
					<td class="dataValue"><div id="remark">${OneDemand.remark}</div></td>

					<script>
						var addToBag = document.getElementById("addItem");
						addToBag.addEventListener("click", insertDeamnd);

						function insertDeamnd() {
							var xhr = new XMLHttpRequest();
							if (xhr != null) {
								xhr.addEventListener("readystatechange", function() {
									if (xhr.readyState == 4) {
										if (xhr.status == 200) {
											lists = xhr.responseText;
											// 											alert("新增購物車品項一");
										} else {
											alert("something is wrong!");
										}
									}
								});
								xhr.open("POST", "cart.do", true);
								xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
								xhr.send("toCart=insert&donationId=" + "${OneDemand.donationId}" + "&schoolId=" + "${OneDemand.schoolId}" + "&schoolName=" + "${OneDemand.schoolName}" + "&donationStatus=" + "${OneDemand.donationStatus}" + "&supplyName=" + "${OneDemand.supplyName}" + "&originalDemandNumber=" + "${OneDemand.originalDemandNumber}" + "&originalDemandUnit="
										+ "${OneDemand.originalDemandUnit}" + "&demandNumber=" + "${OneDemand.demandNumber}" + "&size=" + "${OneDemand.size}" + "&demandContent=" + "${OneDemand.demandContent}" + "&supplyStatus=" + "${OneDemand.supplyStatus}" + "&demandTime=" + "${OneDemand.demandTime}" + "&expireTime=" + "${OneDemand.expireTime}" + "&remark=" + "${OneDemand.remark}");
							}
						}
					</script>
				</tr>
			</tfoot>
		</table>
		</div>
		<!-- 留言板 -->
		<form id="drop-a-line" role="form">
			<div class="row" id="sayBoard">
				<div class="col-md-10">
					<div class="input-field col m12 s12">
						<textarea id="your-message" class="materialize-textarea"></textarea>
						<label for="your-message" class=""><i class="medium material-icons">comment</i></label>

					</div>
				</div>
				<div class="col-md-2">
					<div id="messageGO">
						<button type="reset" class="btn btn-small btn-floating" id="send-message">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="送出"><i class="small material-icons">done</i></a>
						</button>
						<button type="reset" class="btn btn-small btn-floating" id="cancel-message">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
						</button>
					</div>

				</div>
			</div>
		</form>

		<div id="saySomething"></div>
		<div id="QandA" class="col s12 m9">
			<!-- Q&A -->
			<ul class="collapsible" data-collapsible="expandable">
				<c:forEach var='item' items='${AllMessages}' varStatus="vs">
					<li id='li${vs.index}'>

						<div class="collapsible-header">
							<i class="tiny material-icons">help</i>&nbsp;<b>${item.memberName}</b>：
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
									<p>等待回覆...</p>
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

		<script>
			var addBtn = document.getElementById("send-message");
			var QandA = document.getElementById("QandA");
			var saySomething = document.getElementById("saySomething");
			var textByMember = document.getElementById("your-message");

			var xhr = null;

			addBtn.addEventListener("click", load);

			function load() {
				xhr = new XMLHttpRequest();
				if (xhr != null) {
					xhr.addEventListener("readystatechange", returnData);
					xhr.open("POST", "messages.do", true);
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
					// 假設會員id為5
					xhr.send("reporter=member&textarea=" + textByMember.value + "&donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}&returnJson=true")
				}
			}

			function returnData() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						lists = xhr.responseText;
						datas = JSON.parse(lists);
						// 						alert("ms " + datas);
						var memberId = datas[0];
						var memberMessage = datas[1];
						var memberMessageTime = datas[2];

						var xulx = document.createElement("ul");
						xulx.setAttribute("class", "collapsible");
						xulx.setAttribute("data-collapsible", "expandable");

						var xlix = document.createElement("li");

						//上半部 start
						var xbr1x = document.createElement("br");
						var xdiv1x = document.createElement("div");
						xdiv1x.setAttribute("class", "collapsible-header");

						var xi1x = document.createElement("i");
						xi1x.setAttribute("class", "tiny material-icons");
						var xi1textx = document.createTextNode("help");

						var xb1x = document.createElement("b");
						var xb1textx = document.createTextNode(memberId + " :");

						var xdiv1textx = document.createTextNode(memberMessage);

						var xdiv2x = document.createElement("div");
						xdiv2x.setAttribute("class", "talkTime");

						var xdiv2textx = document.createTextNode(memberMessageTime.substr(0, 19));
						//上半部 end

						//下半部 start
						var xdiv3x = document.createElement("div");
						xdiv3x.setAttribute("class", "collapsible-body");
						xdiv3x.setAttribute("style", "display: block;");

						var xp1x = document.createElement("p");
						var xdiv3textx = document.createTextNode("等待回覆...");
						//下半部 end

						xi1x.appendChild(xi1textx);//icon
						xb1x.appendChild(xb1textx);//name
						xdiv2x.appendChild(xdiv2textx);//time
						xp1x.appendChild(xdiv3textx);

						xdiv1x.appendChild(xi1x);
						xdiv1x.appendChild(xb1x);
						xdiv1x.appendChild(xbr1x);
						xdiv1x.appendChild(xdiv1textx);
						xdiv1x.appendChild(xdiv2x);

						xdiv3x.appendChild(xp1x);

						xlix.appendChild(xdiv1x);
						xlix.appendChild(xdiv3x);

						xulx.appendChild(xlix);

						saySomething.appendChild(xulx);

						$(window).load(function() {
							var s1 = {
								'color' : 'green',
								'background-color' : 'orange',
								'width' : '400px',
								'text-align' : 'center'
							};
							var s2 = {
								'color' : 'purple',
								'background-color' : 'cyan',
								'width' : '400px',
								'text-align' : 'center'
							};
							$("#saySomething .collapsible-header").click(function() {
								var xxx = $("#saySomething .collapsible-body").attr("style");
								if (xxx == "display: block;") {
									$("#saySomething .collapsible-body").attr("style", "display: none;");
								} else {
									$("#saySomething .collapsible-body").attr("style", "display: block;");
								}
							});
						}(jQuery));

					} else {
						alert("something is wrong!");
					}
				}
			}
			$(function() {
				$("#send-message").click(function() {
					$("#your-message").val("");
				});
			}(jQuery));
		</script>
	</center>
	<iframe name='hidden_frame' style='width: 0px; height: 0px'></iframe>
	<script type="text/javascript" src="../donationScripts/DonationQA.js"></script>
</body>
</html>