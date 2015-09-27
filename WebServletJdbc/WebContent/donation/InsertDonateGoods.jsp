<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>捐獻物品輸入</title>

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
<!-- 標頭專用 top end -->

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationSchool.css">
<script type="text/javascript" src="../donationScripts/DonationSchool.js"></script>

<!-- 上傳圖片用 -->
<link rel="stylesheet" type="text/css" href="../donationStyles/UpLoadPicture.css">
<script type="text/javascript" src="../donationScripts/UpLoadPicture.js"></script>

</head>
<body>
	<center>
		<!-- 我就是標頭 start -->
		<div class="navbar-fixed">
			<nav>
				<div class="nav-wrapper">
					<ul id="nav-mobile1" class="left hide-on-med-and-down">
						<li><a href="../index.jsp"><img alt="TCPIP" title="TCPIP" id="TCPIP" src="../images/DonationHeader01.png"></a></li>
						<li><a href="FindGoods.jsp"><img alt="捐獻牆" title="捐獻牆" id="DonationWallIcon" src="../images/DonationHeader02.png"></a></li>
					</ul>

					<a href="#" class="brand-logo center">填寫捐獻需求</a>
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
									</c:if>
								</c:if>
								<li class="divider"></li>
								<!-- 沒登入時，必須看到登入按鈕 -->
								<c:choose>
									<c:when test="${empty LoginOK}">
										<li><a href="<c:url value="/index.jsp" />" class="modal-trigger">登入</a></li>
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

		<form id="drop-a-line" enctype='multipart/form-data' action='donate.do' method='POST'>
			<div id="warnText">
				<i class="tiny material-icons">star</i>&nbsp;<span>符號為必填欄位</span>
				<button type="button" id="OneClickInsertDonateGoods" class="btn btn-small btn-floating">
					<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="自動填入"><i class="tiny material-icons">whatshot</i></a>
				</button>
			</div>
			<div class="row">
				<div class="col s12 m12 l6">
					<!-- 左上 -->
					<br> <br>
					<div class="input-field col m12 s12">
						<input type="text" id="schoolName" disabled value="${LoginOK.name}"><label for="schoolName"><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="學校名稱"><span class="DetailTitle"><i class="tiny material-icons">location_city</i>&nbsp;申請單位&nbsp;</span></a></span></label>
					</div>



					<!-- 上傳圖片 -->
					<div id="basicDataHead">
						<div class="input-field col m12 s12">
							<input type="file" id="imageName" required="required"><label for="imageName"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="點我上傳圖片，建議最佳上傳圖片大小為 400 * 400"><span class="DetailTitle"><i class="tiny material-icons">image</i>&nbsp;上傳封面&nbsp;<i class="tiny material-icons" id="requiredStar01">star</i></span></a><br> <br> <a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="點我上傳圖片，建議最佳上傳圖片大小為 400 * 400">
									<div id="donationPictureFrame">
										<center>
											<!-- 強迫img在div內部置中 -->
											<img id="donationPicture" src="" alt="" title="上傳圖片">
										</center>

									</div>
							</a> </label>
						</div>
					</div>
					<br> <br> <br> <br>

				</div>
				<div class="col s12 m12 l6">
					<!-- 右上 -->
					<br> <br>
					<!-- 物資名稱 -->
					<div class="input-field col m12 s12">
						<input type="text" id="supplyName" name='supplyName' value='${param.supplyName}' maxlength="25" required="required" autocomplete="off"><label for="supplyName" class="" id="textLable01"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="最多輸入 25 個字"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;物資名稱&nbsp;<i class="tiny material-icons" id="requiredStar02">star</i></span></a></label>
					</div>

					<!-- 需求數量(數量) -->
					<div class="input-field col m12 s12">
						<input type="number" id="originalDemandNumber" name='originalDemandNumber' value='${param.originalDemandNumber}' required="required" autocomplete="off" max="9999" min="1"><label for="originalDemandNumber" class="" id="textLable02"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="輸入數字"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;需求物品數量&nbsp;<i class="tiny material-icons" id="requiredStar03">star</i></span></a></label>
					</div>

					<!-- 原始輸入需求數量(單位) -->
					<div class="input-field col m12 s12">
						<input type="text" id="originalDemandUnit" name='originalDemandUnit' value='${param.originalDemandUnit}' required="required" autocomplete="off"><label for="originalDemandUnit" class="" id="textLable03"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="例如：包、打、張、隻、箱"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;需求物品單位&nbsp;<i class="tiny material-icons" id="requiredStar04">star</i></span></a></label>
					</div>

					<!-- 尺寸規格(例如:物品的大小>長*寬*高) -->
					<div class="input-field col m12 s12">
						<input type="text" id="size" name='size' value='${param.size}' autocomplete="off"><label for="size" class="" id="textLable04"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="例如：物品大小的長.寬.高、電壓 110V 或 220V"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;尺寸規格&nbsp;</span></a></label>
					</div>

					<!-- 物資狀態(全新/二手/不拘) -->
					<div class="input-field col m12 s12">
						<label><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="不拘、全新、二手"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;物資狀態&nbsp;</span></a></label><br> <br> <select class="browser-default" id="supplyStatus" name="supplyStatus">
							<option value="1">全新</option>
							<option value="2">不拘</option>
							<option value="3">二手</option>
						</select> <br>
					</div>

					<!-- 需求說明(為什麼需要這項物資) -->
					<div class="input-field col m12 s12">
						<textarea id="demandContent" name='demandContent' value='${param.demandContent}' class="materialize-textarea" required="required"></textarea>
						<label for="demandContent" class="" id="textLable05"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="說明為什麼需要這項物資"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;需求說明&nbsp;<i class="tiny material-icons" id="requiredStar05">star</i></span></a></label>
					</div>
				</div>

				<!-- 備註 -->
				<div class="input-field col s12 m12 l12" id="bottomDiv">
					<textarea id="remark" name='remark' value='${param.remark}' class="materialize-textarea"></textarea>
					<label for="remark" class="" id="textLable06"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="補充說明"><span class="DetailTitle"><i class="tiny material-icons">create</i>&nbsp;備註&nbsp;</span></a></label>
					<button type="submit" id="sendMessage" name='hidden' value='insert' class="btn btn-small btn-floating">
						<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="送出"><i class="small material-icons">done</i></a>
					</button>
					<button type="submit" id="cancelMessage" class="btn btn-small btn-floating">
						<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
					</button>

				</div>



			</div>
		</form>

	</center>

	<!-- 標頭專用 bottom start -->
	<!-- 必須最後載入才有效果 -->
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<!-- 標頭專用 bottom end -->
	<!-- 一鍵填入 -->
	<script type="text/javascript" src="../donationScripts/OneClickDemo.js"></script>
</body>
</html>
