<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OneMemberDemand</title>
<style>
body {
	margin: 0 auto;
}

#div1 {
	border: 1px solid green;
}
</style>
<!-- 一定要載入的 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
	!window.jQuery
			&& document
					.write("<script src='scripts/jquery-2.1.4.min.js'><\/script>")
</script>

<!-- Materialize -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>


<!-- 自訂 -->
<link rel="stylesheet" href="styles/DonationQA.css">
</head>
<body>

	<center>
		<!-- 表格基本資料 -->
		<table id="DonationDetail">
			<tr>
				<td rowspan="10"><img alt="${OneDemand.supplyName}"
					title="${OneDemand.supplyName}"
					src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${OneDemand.donationId}&schoolId=${OneDemand.schoolId}"
					width="300"></td>
				<td style="text-align: right; width: 150px;">物資名稱：</td>
				<td style="width: 350px; word-break: break-all;">${OneDemand.supplyName}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;">需求數量：</td>
				<td style="width: 350px;">${OneDemand.originalDemandUnit}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;">尺寸規格：</td>
				<td style="width: 350px;">${OneDemand.size}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;">物資狀態：</td>
				<td style="width: 350px;">${OneDemand.supplyStatus}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;">募集起始時間：</td>
				<td style="width: 350px;">${OneDemand.demandTime}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;">募集結束時間：</td>
				<td style="width: 350px;">${OneDemand.expireTime}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;">募集原因：</td>
				<td style="width: 350px; word-break: break-all;">${OneDemand.demandContent}</td>
			</tr>

			<tr>
				<td><a href="<c:url value='demand.do?type=AllDeamndByMember&schoolId=${OneDemand.schoolId}&donationId=${OneDemand.donationId}&schoolName=${OneDemand.schoolName}'/>">${OneDemand.schoolName}全部需求</td>
			</tr>

			<form action='<c:url value="cart.do"/>' method='POST' target="hidden_frame">
				<tr>
					<td><input type='submit' name='toCart' value='insert'></td>
				</tr>
				<input type='hidden' name='donationId'
					value='${OneDemand.donationId}'> <input type='hidden'
					name='schoolId' value='${OneDemand.schoolId}'> <input
					type='hidden' name='schoolName' value='${OneDemand.schoolName}'>
				<input type='hidden' name='donationStatus'
					value='${OneDemand.donationStatus}'> <input type='hidden'
					name='supplyName' value='${OneDemand.supplyName}'> <input
					type='hidden' name='originalDemandNumber'
					value='${OneDemand.originalDemandNumber}'> <input
					type='hidden' name='originalDemandUnit'
					value='${OneDemand.originalDemandUnit}'> <input
					type='hidden' name='demandNumber' value='${OneDemand.demandNumber}'>
				<input type='hidden' name='size' value='${OneDemand.size}'>
				<input type='hidden' name='demandContent'
					value='${OneDemand.demandContent}'> <input type='hidden'
					name='supplyStatus' value='${OneDemand.supplyStatus}'> <input
					type='hidden' name='demandTime' value='${OneDemand.demandTime}'>
				<input type='hidden' name='expireTime'
					value='${OneDemand.expireTime}'> <input type='hidden'
					name='imageName' value='${OneDemand.imageName}'> <input
					type='hidden' name='imageFile' value='${OneDemand.imageFile}'>
				<input type='hidden' name='imageLength'
					value='${OneDemand.imageLength}'> <input type='hidden'
					name='remark' value='${OneDemand.remark}'>
			</form>
			<tfoot>
				<tr>
					<td
						style="text-align: center; vertical-align: text-top; padding-top: 20px;"></td>
					<td
						style="text-align: right; width: 150px; vertical-align: top; padding-top: 10px;">備註：</td>
					<td
						style="border: 1px solid black; padding: 5px; word-break: break-all;"><div
							style="width: 350px; height: 120px; overflow: auto;">${OneDemand.remark}</div></td>
				</tr>
			</tfoot>
		</table>

		<!-- 留言板 -->
		<form id="drop-a-line" role="form">
			<div class="input-field col m12 s12">
				<textarea id="your-message" class="materialize-textarea"
					name="textarea"></textarea>
				<label for="your-message" class=""><i
					class="large material-icons">comment</i></label>
				<div id="messageGO">
					<button type="reset" id="cancel-message"
						class="btn btn-large btn-success waves-effect waves-light">
						<i class="large material-icons">loop</i>
					</button>
					<button type="button" id="send-message"
						class="btn btn-large btn-success waves-effect waves-light">
						<i class="large material-icons">done</i>
					</button>
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