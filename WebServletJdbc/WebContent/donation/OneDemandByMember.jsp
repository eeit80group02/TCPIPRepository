<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li><a href="#"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
					<li><a href="DonationWall.html"><img alt="捐獻牆" title="捐獻牆" id="DonationWallIcon" src="../images/DonationHeader02.png"></a></li>
				</ul>

				<a href="#" class="brand-logo center">問與答</a>
				<ul id="nav-mobile3" class="right hide-on-med-and-down">
					<li><a href="#"><i class="large material-icons">person</i></a></li>
				</ul>
			</div>
		</nav>
	</div>
	<br>
	<!-- 我就是標頭 end -->

	<center>
		<!-- 表格基本資料 -->
		<div class="table-responsive">
			<table id="donationDetailTable">
				<tr>
					<td rowspan="10" id="donationImage"><img alt="${OneDemand.supplyName}" title="${OneDemand.supplyName}" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}" id="donationPicture"></td>
					<td class="dataName">物資名稱：</td>
					<td class="dataValue">${OneDemand.supplyName}</td>
				</tr>
				<tr>
					<td class="dataName">剩餘需求：</td>
					<td class="dataValue">${OneDemand.demandNumber} ${OneDemand.originalDemandUnit}</td>
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
					<td class="dataValue">${OneDemand.demandTime}</td>
				</tr>
				<tr>
					<td class="dataName">募集結束時間：</td>
					<td class="dataValue">${OneDemand.expireTime}</td>
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
						
							<button type="button" name='toCart' value='insert' class="btn btn-large btn-floating">
								<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="加入捐獻背包"><i class="medium material-icons">card_giftcard</i></a>
							</button>
						</td>
						<td style="text-align: right; width: 150px; vertical-align: top; padding-top: 10px;">備註：</td>
						<td class="dataValue"><div id="remark">${OneDemand.remark}</div></td>
						
						<script>
							var addToBag = document.getElementById("addToBag");
							addToBag.addEventListener("click", insertDeamnd);
								
							function insertDeamnd(){
								var xhr = new XMLHttpRequest();
								if (xhr != null) {
										xhr.addEventListener("readystatechange", function(){
											if (xhr.readyState == 4) {
												if (xhr.status == 200) {
													 lists = xhr.responseText;
													  alert("新增購物車品項一");
												} else {
													alert("something is wrong!");
												}
											} 
										});
									xhr.open("POST", "cart.do", true);
									xhr.setRequestHeader("Content-Type", 
									"application/x-www-form-urlencoded")
									xhr.send("toCart=insert&donationId="+"${OneDemand.donationId}"+"&schoolId="+"${OneDemand.schoolId}"+"&schoolName="+"${OneDemand.schoolName}"+"&donationStatus="+"${OneDemand.donationStatus}"+"&supplyName="+"${OneDemand.supplyName}"+"&originalDemandNumber="+"${OneDemand.originalDemandNumber}"+"&originalDemandUnit="+"${OneDemand.originalDemandUnit}"+"&demandNumber="+"${OneDemand.demandNumber}"+"&size="+"${OneDemand.size}"+"&demandContent="+"${OneDemand.demandContent}"+"&supplyStatus="+"${OneDemand.supplyStatus}"+"&demandTime="+"${OneDemand.demandTime}"+"&expireTime="+"${OneDemand.expireTime}"+"&remark="+"${OneDemand.remark}");
								}
							}
						</script>
					</tr>
				</tfoot>
			</table>

		<!-- 留言板 -->
		<form id="drop-a-line" role="form">
			<div class="row">
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

		<!-- Q&A -->
		<div id="QandA" class="col s12 m9">
			<ul class="collapsible" data-collapsible="expandable">
				<c:forEach var='item' items='${AllMessages}' varStatus="vs">
					<li id='li${vs.index}'>
						<div class="collapsible-header">
							<span class="glyphicon glyphicon-question-sign"></span> <b>${item.memberName}</b>：
							<c:if test="${!empty item.schoolMessage}">
								<span class="glyphicon glyphicon-ok-sign"></span>
							</c:if>
							<br>${item.memberMessage}&nbsp;<span class="talkTime">${item.memberMessageTime}
						</div>
						<div class="collapsible-body">
							<c:choose>
								<c:when test="${empty item.schoolMessage}">
									<p>等待回覆...</p>
								</c:when>
								<c:otherwise>
									<P>${item.schoolMessage}</P>
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
			// 	var p1 = document.getElementById("p1");
			// 	var p2 = document.getElementById("p2");
			var textByMember = document.getElementById("your-message");

			var xhr = null;

			addBtn.addEventListener("click", load);

			function load() {
				xhr = new XMLHttpRequest();
				if (xhr != null) {
					xhr.addEventListener("readystatechange", returnData);
					xhr.open("POST", "messages.do", true);
					xhr.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded")
					// 假設會員id為5
					xhr
							.send("reporter=member&textarea="
									+ textByMember.value
									+ "&donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}&returnJson=true")
				}
			}

			function returnData() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						lists = xhr.responseText;
						datas = JSON.parse(lists);
						alert("ms "+datas);
						var memberId = datas[0];
						var memberMessage = datas[1];
						var memberMessageTime = datas[2];

						var tr1 = document.createElement("tr");
						var th1 = document.createElement("th");
						var p1 = document.createElement("p");
						var textP1 = document.createTextNode("會員:" + memberId
								+ " 於 " + memberMessageTime + "留言");
						tr1.appendChild(th1);
						th1.appendChild(p1)
						p1.appendChild(textP1);

						var tr2 = document.createElement("tr");
						var th2 = document.createElement("th");
						var p2 = document.createElement("p");
						var textP2 = document.createTextNode("內容:"
								+ memberMessage);
						tr1.appendChild(th2);
						th1.appendChild(p2)
						p1.appendChild(textP2);

						QandA.appendChild(tr2);
						QandA.appendChild(tr1);
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
	</center>
	<iframe name='hidden_frame' style='width: 0px; height: 0px'></iframe>
</body>
</html>