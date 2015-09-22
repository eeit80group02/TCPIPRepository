<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理捐獻物資</title>

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
<!-- 標頭css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- 預設 （本機）-->
<link rel="stylesheet" href="../donationStyles/jquery-ui.css">

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationWallSchool.css">
<!-- <script type="text/javascript" src="../donationScripts/DonationWallSchool.js"></script> -->
<script type="text/javascript" src="../donationScripts/picture-big.js"></script>

</head>
<body>
	<!-- 我就是標頭 start -->
	<div class="navbar-fixed">
		<nav>
			<div class="nav-wrapper">
				<ul id="nav-mobile1" class="left hide-on-med-and-down">
					<li><a href="#"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
				</ul>
				<a href="#" class="brand-logo center">管理捐獻物資</a>

				<ul id="nav-mobile3" class="right hide-on-med-and-down">

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

	<!-- 我就是標頭 end -->
	
	<center>
		<div id="donateBody">
			<br>
			<div class="col s12">
				<br>
				<ul class="tabs">
					<li class="tab col s4" id="pageTab01"><a href="#test1" class="active">全部物資</a></li>
					<li class="tab col s4" id="pageTab02"><a href="#test2" class="">上架中</a></li>
					<li class="tab col s4" id="pageTab03"><a href="#test3" class="">已下架</a></li>
				</ul>
				<br>
			</div>
			
			<br>
			
			<div id="test1" class="col s12">

				<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
					<li class="ui-widget-content ui-corner-tr">
						<div>
							<div class="fiximg">
								<!-- h5 標籤不能新增修改，後面設定會用 -->
								<div>
									<h5>延長線 - 屏東縣鹽埔鄉鹽埔國民小學</h5>
								</div>

								<img class="bigimg" src="../images/thing01.jpg" alt="延長線" title="延長線">
							</div>
							
							<div class="footIcin">
								<!-- 放大鏡的 title 跟上面 h5 的名稱要一模一樣 -->

								<!-- 捐獻記錄 start -->
								<span class="leftIcon"> <!-- data-target 跟底下的 id 要一樣 -->
									<button type="button" data-target="modalNote01" class="btn btn-small btn-floating modal-trigger">
										<i class="small material-icons">assignment</i>
									</button>
								</span>
								<!-- Modal Structure -->
								<div id="modalNote01" class="modal modal-fixed-footer">
									<div class="modal-content">
										<h4>捐獻記錄</h4>
										<table class="donationRecorder">
											<thead>
												<tr>
													<td>捐獻者</td>
													<td>物資名稱</td>
													<td>捐獻數量</td>
													<td>捐獻時間</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>石田三成</td>
													<td>足球</td>
													<td>20顆</td>
													<td>2015/09/22 14：30：22</td>
												</tr>
												<tr>
													<td>石田三成</td>
													<td>足球</td>
													<td>20顆</td>
													<td>2015/09/22 14：30：22</td>
												</tr>
												<tr>
													<td>石田三成</td>
													<td>足球</td>
													<td>20顆</td>
													<td>2015/09/22 14：30：22</td>
												</tr>
												<tr>
													<td>石田三成</td>
													<td>足球</td>
													<td>20顆</td>
													<td>2015/09/22 14：30：22</td>
												</tr>
												<tr>
													<td>石田三成</td>
													<td>足球</td>
													<td>20顆</td>
													<td>2015/09/22 14：30：22</td>
												</tr>
												<tr>
													<td>石田三成</td>
													<td>足球</td>
													<td>20顆</td>
													<td>2015/09/22 14：30：22</td>
												</tr>
											</tbody>
										</table>
									</div>

									<div class="modal-footer">
										<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
									</div>
								</div>
								<!-- 捐獻記錄 end -->
								<span class="midText">18 條</span> <span class="rightIcon"><a href="DonationQASchool.html" class="btn btn-tiny btn-floating"><i class="tiny material-icons">help</i></a></span>
							</div>
						</div>
					</li>
				</ul>
			</div>
	</center>
</body>
</html>