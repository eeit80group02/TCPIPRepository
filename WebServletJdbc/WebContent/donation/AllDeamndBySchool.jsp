<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript" src="../donationScripts/picture-big.js"></script>

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
			<a href="#" class="brand-logo center">管理物資</a>

			<ul id="nav-mobile3" class="right hide-on-med-and-down">

				<li class="chooseItem" value="數量"><a href="<c:url value='schoolSearch.do?type=byAmount&range=oneSchool'/>">數量</a></li>
				<li><a class="dropdown-button" href="#!" data-activates="dropdownList01">時間<i class="mdi-navigation-arrow-drop-down right"></i></a>
					<ul id="dropdownList01" class="dropdown-content">
						<li class="chooseDropdownItem" value="最新發佈"><a href="<c:url value='schoolSearch.do?type=byDemandtime&range=oneSchool&schoolId=${OneAllDemands[0].schoolId}'/>">最新發佈</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="即將結束"><a href="<c:url value='schoolSearch.do?type=byExpiretime&range=oneSchool&schoolId=${OneAllDemands[0].schoolId}'/>">即將結束</a></li>
					</ul></li>
				<li><a class="dropdown-button" href="#!" data-activates="dropdownList02">物資狀態<i class="mdi-navigation-arrow-drop-down right"></i></a>
					<ul id="dropdownList02" class="dropdown-content">
						<li class="chooseDropdownItem" value="不拘"><a href="<c:url value='schoolSearch.do?supplyStatus=1&range=oneSchool&schoolId=${OneAllDemands[0].schoolId}'/>">不拘</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="全新"><a href="<c:url value='schoolSearch.do?supplyStatus=2&range=oneSchool&schoolId=${OneAllDemands[0].schoolId}'/>">全新</a></li>
						<li class="divider"></li>
						<li class="chooseDropdownItem" value="二手"><a href="<c:url value='schoolSearch.do?supplyStatus=3&range=oneSchool&schoolId=${OneAllDemands[0].schoolId}'/>">二手</a></li>
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

	<!-- 我就是標頭 end -->

	<center>
		<div id="donateBody">
			<br>
			<!-- 操作小叮嚀 start -->
			<button type="button" data-target="modalNote01" class="btn light-blue darken-4 btn-large btn-floating modal-trigger">
				<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
			</button>
			<!-- Modal Structure -->
			<div id="modalNote01" class="modal modal-fixed-footer">
				<div class="modal-content">
					<h4>操作小叮嚀：</h4>
					<ol>
						<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">assignment</i></a>&nbsp;單擊左鍵，可以查看捐獻記錄。
						</li>
						<br>
						<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">brush</i></a>&nbsp;單擊左鍵，可以進行修改內容。
						</li>
						<br>
						<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">help</i></a>&nbsp;單擊左鍵，進入管理問與答。
						</li>
					</ol>
				</div>
				<div class="modal-footer">
					<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
				</div>
			</div>
			<!-- 操作小叮嚀 end -->

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

								<div class="footIcin">

									<!-- 捐獻記錄 start -->

									<!-- Modal Structure -->
									<div id="modalNote01${vs.index}" class="modal modal-fixed-footer">
										<div class="modal-content">
											<h4>捐獻記錄</h4>
											<table class="donationRecorder">
												<thead>
													<tr>
														<td>捐獻者</td>
														<td>捐獻數量</td>
														<td>捐獻時間</td>
													</tr>
												</thead>
												<tbody>
													<c:forEach var='initem' items='${OneAllDetails}'>
														<c:choose>
															<c:when test="${item.donationId == initem.donationId}">
																<tr>
																	<td>${initem.name}</td>
																	<td>${initem.donationAmount}</td>
																	<td><fmt:formatDate value="${initem.donationOederDate}" pattern="yyyy-MM-dd hh:mm" /></td>
																</tr>
															</c:when>
														</c:choose>
													</c:forEach>
												</tbody>
											</table>
										</div>

										<div class="modal-footer">
											<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
										</div>
									</div>
									<!-- 捐獻記錄 end -->
									<span class="midText">${item.originalDemandNumber-item.demandNumber}/${item.originalDemandNumber}${item.originalDemandUnit}</span><br>
									<!-- 左 icon -->
									<span class="leftIcon"> <!-- data-target 跟底下的 id 要一樣 -->
										<button type="button" data-target="modalNote01${vs.index}" class="btn btn-small btn-floating modal-trigger">
											<i class="small material-icons">assignment</i>
										</button>
									</span>
									<!-- 中 icon -->

									<c:choose>
										<c:when test="${item.donationStatus == '否'}">
											<span class="midIcon"> <a href="<c:url value='demand.do?type=UpdateOneDemand&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" class="btn btn-tiny btn-floating"><i class="tiny material-icons">brush</i></a>
											</span>
										</c:when>
									</c:choose>

									<!-- 右 icon -->
									<span class="rightIcon"> <a href="<c:url value='demand.do?type=OneDeamndBySchool&donationId=${item.donationId}&schoolId=${item.schoolId}&manage=yes'/>" class="btn btn-tiny btn-floating"><i class="tiny material-icons">help</i></a>
									</span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div id="test2" class="col s12">

				<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
					<c:forEach var='item' items='${OneAllDemands}' varStatus='vs'>
						<c:choose>
							<c:when test="${item.donationStatus == '否'}">
								<li class="ui-widget-content ui-corner-tr" value="${item.donationId}">
									<div>
										<div class="fiximg">
											<!-- h5 標籤不能新增修改，後面設定會用 -->
											<div class="alert alert-info" role="alert">
												<h5>${item.supplyName}-${item.schoolName}</h5>
											</div>
											<img class="bigimg" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}" alt="${item.supplyName}" title="${item.supplyName}">
										</div>

										<div class="footIcin">

											<!-- 捐獻記錄 start -->
											<!-- Modal Structure -->
											<div id="modalNote02${vs.index}" class="modal modal-fixed-footer">
												<div class="modal-content">
													<h4>捐獻記錄</h4>
													<table class="donationRecorder">
														<thead>
															<tr>
																<td>捐獻者</td>
																<td>捐獻數量</td>
																<td>捐獻時間</td>
															</tr>
														</thead>

														<tbody>
															<c:forEach var='initem' items='${OneAllDetails}'>
																<c:choose>
																	<c:when test="${item.donationId == initem.donationId}">
																		<tr>
																			<td>${initem.name}</td>
																			<td>${initem.donationAmount}</td>
																			<%-- 																			<td>${initem.donationOederDate}</td> --%>
																			<td><fmt:formatDate value="${initem.donationOederDate}" pattern="yyyy-MM-dd hh:mm" /></td>
																		</tr>
																	</c:when>
																</c:choose>
															</c:forEach>
														</tbody>
													</table>
												</div>

												<div class="modal-footer">
													<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
												</div>
											</div>
											<!-- 捐獻記錄 end -->
											<span class="midText">${item.originalDemandNumber-item.demandNumber}/${item.originalDemandNumber}${item.originalDemandUnit}</span><br>
											<!-- 左 icon -->
											<span class="leftIcon"> <!-- data-target 跟底下的 id 要一樣 -->
												<button type="button" data-target="modalNote02${vs.index}" class="btn btn-small btn-floating modal-trigger">
													<i class="small material-icons">assignment</i>
												</button>
											</span>
											<!-- 中 icon -->
											<span class="midIcon"> <a href="#" class="btn btn-tiny btn-floating"><i class="tiny material-icons">brush</i></a>
											</span>

											<!-- 右 icon -->
											<span class="rightIcon"> <a href="<c:url value='demand.do?type=OneDeamndBySchool&donationId=${item.donationId}&schoolId=${item.schoolId}&manage=yes'/>" class="btn btn-tiny btn-floating"><i class="tiny material-icons">help</i></a>
											</span>
										</div>
									</div>
								</li>
							</c:when>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
			<div id="test3" class="col s12">
				<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
					<c:forEach var='item' items='${OneAllDemands}' varStatus='vs'>
						<c:choose>
							<c:when test="${item.donationStatus == '是'}">
								<li class="ui-widget-content ui-corner-tr" value="${item.donationId}">
									<div>
										<div class="fiximg">
											<!-- h5 標籤不能新增修改，後面設定會用 -->
											<div class="alert alert-info" role="alert">
												<h5>${item.supplyName}-${item.schoolName}</h5>
											</div>
											<img class="bigimg" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}" alt="${item.supplyName}" title="${item.supplyName}">
										</div>

										<div class="footIcin">

											<!-- 捐獻記錄 start -->
											<!-- Modal Structure -->
											<div id="modalNote03${vs.index}" class="modal modal-fixed-footer">
												<div class="modal-content">
													<h4>捐獻記錄</h4>
													<table class="donationRecorder">
														<thead>
															<tr>
																<td>捐獻者</td>
																<td>捐獻數量</td>
																<td>捐獻時間</td>
															</tr>
														</thead>
														<tbody>
															<c:forEach var='initem' items='${OneAllDetails}'>
																<c:choose>
																	<c:when test="${item.donationId == initem.donationId}">
																		<tr>
																			<td>${initem.name}</td>
																			<td>${initem.donationAmount}</td>
																			<%-- 																			<td>${initem.donationOederDate}</td> --%>
																			<td><fmt:formatDate value="${initem.donationOederDate}" pattern="yyyy-MM-dd hh:mm" /></td>
																		</tr>
																	</c:when>
																</c:choose>
															</c:forEach>
														</tbody>
													</table>
												</div>

												<div class="modal-footer">
													<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
												</div>
											</div>
											<!-- 捐獻記錄 end -->
											<span class="midText">${item.originalDemandNumber-item.demandNumber}/${item.originalDemandNumber}${item.originalDemandUnit}</span><br>
											<!-- 左 icon -->
											<span class="leftIcon"> <!-- data-target 跟底下的 id 要一樣 -->
												<button type="button" data-target="modalNote03${vs.index}" class="btn btn-small btn-floating modal-trigger">
													<i class="small material-icons">assignment</i>
												</button>
											</span>
											<!-- 中 icon -->
											<!-- <span class="midIcon"> <a href="#" class="btn btn-tiny btn-floating"><i class="tiny material-icons">brush</i></a> -->
											<!-- </span> -->

											<!-- 右 icon -->
											<span class="rightIcon"> <a href="<c:url value='demand.do?type=OneDeamndBySchool&donationId=${item.donationId}&schoolId=${item.schoolId}&manage=yes'/>" class="btn btn-tiny btn-floating"><i class="tiny material-icons">help</i></a>
											</span>
										</div>
									</div>
								</li>
							</c:when>
						</c:choose>
					</c:forEach>
				</ul>
			</div>

		</div>
	</center>
	<script type="text/javascript" src="../donationScripts/AllDeamnBySchool.js"></script>
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
</body>
</html>