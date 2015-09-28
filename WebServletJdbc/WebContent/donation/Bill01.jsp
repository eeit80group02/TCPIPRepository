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

</head>

<body>
	<!-- 驗證是否為會員 -->
	<c:if test="${LoginOK.beanName.equals('school') }">
		<c:redirect url="/error/permission.jsp" />
	</c:if>

	<!-- 我就是標頭 start -->
	<div class="navbar-fixed">
		<nav>
		<div class="nav-wrapper">
			<ul id="nav-mobile1" class="left hide-on-med-and-down">
				<li><a href="../index.jsp"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
				<li><a href="<c:url value="/donation/demand.do?type=FindGoods" />"><img alt="捐獻牆" title="捐獻牆" id="DonationWallIcon" src="../images/DonationHeader02.png"></a></li>
			</ul>

			<a href="#" class="brand-logo center">捐獻明細</a>
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
		<div id="bodyContent">
			<div class="row">
				<div class="col s12">
					<br>
					<ul class="tabs">
						<li class="tab col s3" id="pageTab01"><a href="#test1" class="active">捐獻明細</a></li>
						<li class="tab col s3 disabled" id="pageTab02"><a href="#test2">填寫資料</a></li>
						<li class="tab col s3 disabled" id="pageTab03"><a href="#test3">完成捐獻</a></li>
					</ul>
					<br>

				</div>

				<!-- 第一頁 start -->
				<div id="test1" class="col s12">

					<div class="col s12">
						<div class="warnText">
							<span>確認捐獻物品明細</span>
							<!-- 操作小叮嚀 start -->
							<button type="button" data-target="modalNote01" class="btn btn-small btn-floating modal-trigger">
								<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
							</button>
							<!-- Modal Structure -->
							<div id="modalNote01" class="modal modal-fixed-footer">
								<div class="modal-content">
									<h4>操作小叮嚀：</h4>
									<ol>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">navigate_next</i></a>&nbsp;單擊左鍵，進入填寫資料。
										</li>
										<br>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">delete</i></a>&nbsp;雙擊左鍵，即可移除該筆捐獻。
										</li>
									</ol>
								</div>
								<div class="modal-footer">
									<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
								</div>
							</div>
							<!-- 操作小叮嚀 end -->

						</div>
						<br>
					</div>

					<form action="">
						<table id="donationBill01" class="responsive-table">
							<thead>
								<tr>
									<td>受捐獻單位</td>
									<td>捐獻物資</td>
									<td>移除</td>
									<td>下一步</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var='item' items='${DemandOBSchool}'>
									<tr>
										<td>${item.name}<br> <br>${item.addressComplete}</td>
										<td>
											<table>
												<c:forEach var='initem' items='${item.dbdList}'>
													<tr>
														<td>${initem.supplyName}${initem.demandNumber}${initem.originalDemandUnit}</td>
													</tr>
												</c:forEach>
											</table>
										</td>
										<td class="deleteRow">
											<button type="button" class="btn btn-small btn-floating">
												<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="移除"><i class="small material-icons">delete</i></a>
											</button>
										</td>
										<td>
											<form action='<c:url value="checkOrder.do"/>' method='GET'>
												<button type="submit" id="page02Next" class="btn btn-small btn-floating">
													<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
												</button>
												<input type='hidden' name='linkto' value='stepTwo'> <input type='hidden' name='schoolId' value='${item.schoolId}'>
											</form>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<br> <br>
					</form>


				</div>
				<!-- 第一頁 end -->
	</center>

	<!-- 宅配通 bottom start -->

	<!-- 等畫面跑完，在載入 js 檔 -->
	<script type="text/javascript" src="../donationScripts/DonationBill.js"></script>
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<!-- 一鍵Demo -->
	<script type="text/javascript" src="../donationScripts/OneClickDemo.js"></script>


</body>
</html>
