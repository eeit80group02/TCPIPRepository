<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>捐獻明細</title>

<!-- 標頭專用 top start -->
<!-- 一定要載入的 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
	!window.jQuery && document.write("<script type='text/javascript' src='../donationScripts/jquery-2.1.4.min.js'><\/script>")
</script>

<!-- Materialize -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>

<!-- Modal 專用 -->
<script type="text/javascript" src="../donationScripts/Modal.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- 標頭 css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationBill.css">

<!-- 宅配通top start -->
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="../jquery/jquery.validate.rule.js"></script>
<script type="text/javascript" src="../jquery/jquery.error.message.js"></script>
<script type="text/javascript">
	$(function() {
		// Get web init information 
		$.get("../GetDonationInfoServlet", function(responseJson) {
			var data1 = responseJson[0], data2 = responseJson[1];
			console.log(data2);
			$("#captchaField").text(data1.captchaImage);
			$("#captchaImage").attr("src", $("#captchaField").val());
			$("#__EVENTTARGET").val(data1.__EVENTTARGET);
			$("#__EVENTARGUMENT").val(data1.__EVENTARGUMENT);
			$("#__VIEWSTATE").val(data1.__VIEWSTATE);
			$("#__VIEWSTATEGENERATOR").val(data1.__VIEWSTATEGENERATOR);
			$("#CAPTCHA").val(data1.CAPTCHA);
			$.each(data2, function(name, value) {
				$("#ddlGetdate").append(value);
			});
		});

		// set checkbox only one checked
		$('input[type="checkbox"]').on('change', function() {
			$(this).siblings('input[type="checkbox"]').prop('checked', false);
		});

	});
</script>
<!-- 宅配通top end -->

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

			<a href="#" class="brand-logo center">捐獻明細</a>
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
		<div id="bodyContent">
			<div class="row">
				<div class="col s12">
					<br>
					<ul class="tabs">
						<li class="tab col s3" id="pageTab01"><a href="#test1" class="disabled">受贈單位</a></li>
						<li class="tab col s3" id="pageTab02"><a href="#test2" class="disabled">捐獻明細</a></li>
						<li class="tab col s3" id="pageTab04"><a href="#test4" class="active">完成捐獻</a></li>
					</ul>
					<br>

				</div>

				<!-- 第四頁 -->
				<div id="test4" class="col s12">

					<form action="">
						<table id="donationBill04" class="responsive-table">
							<thead>
								<tr>
									<td>姓名</td>
									<td>E-mail</td>
									<td>電話</td>
									<td>手機</td>
									<td>宅配單號</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${OrderDetail.name}</td>
									<td>${OrderDetail.email}</td>
									<td>${OrderDetail.phone}</td>
									<td>${OrderDetail.cellPhone}</td>
									<td><span id="resultShow">${OrderDetail.dealId}</span></td>
								</tr>
							</tbody>
						</table>
					</form>

					<br>
					<button type="button" id="page04ToPage01" class="btn btn-small btn-floating">
						<a href="<c:url value="/donation/demand.do?type=FindGoods" />" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="到捐獻背包"><i class="small material-icons">card_giftcard</i></a>
					</button>
					<button type="button" id="page04ToPage02" class="btn btn-small btn-floating">
						<a href="<c:url value='checkOrder.do?linkto=stepOne'/>" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="到捐獻清單"><i class="small material-icons">list</i></a>
					</button>

				</div>


			</div>
		</div>
	</center>

	<!-- 等畫面跑完，在載入 js 檔 -->
	<script type="text/javascript" src="../donationScripts/SexSwitch.js"></script>
	<script type="text/javascript" src="../donationScripts/DonationBill.js"></script>

	<!-- 標頭專用 bottom start -->
	<!-- 必須最後載入才有效果 -->
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<!-- 標頭專用 bottom end -->

</body>
</html>