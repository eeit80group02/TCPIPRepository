<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>捐獻牆</title>

<!-- 一定要載入的 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
	!window.jQuery && document.write("<script src='scripts/jquery-2.1.4.min.js'><\/script>")
</script>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- Materialize -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- 預設 （本機）-->
<link rel="stylesheet" href="../styles/jquery-ui.css">
<script type="text/javascript" src="../scripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../scripts/jquery-ui.js"></script>

<!-- 預設（遠端） -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<!-- 自訂 -->
<script type="text/javascript" src="../scripts/Donation.js"></script>
<script type="text/javascript" src="../scripts/picture-big.js"></script>
<link rel="stylesheet" href="../styles/DonationWall.css">
<!-- 在多加載一次picture-big，比較保險 -->
<script type="text/javascript" src="../scripts/picture-big.js"></script>

</head>
<body>
	<!-- Header -->
	<div class="navbar navbar-inverse">
		<ul class="nav navbar-nav" id="headUl">
			<li class="active"><a href="#">捐獻牆</a></li>
			<li class="headList"><a href="#">熱門</a></li>
			<li class="headList"><a href="#">最新發佈</a></li>
			<li class="headList"><a href="#">即將結束</a></li>
			<li class="headList"><a href="#">需求數量</a></li>
			<li class="headList"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">物資狀態<span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">不拘</a></li>
					<li><a href="#">全新</a></li>
					<li><a href="#">二手</a></li>
				</ul></li>

		</ul>
		<form class="navbar-form navbar-left" role="search" id="headSearch">
			<div class="form-group">
				<input id="searchText" type="text" class="form-control" placeholder="輸入物品或學校" autocomplete="off">
			</div>

			<button type="submit" class="btn btn-small btn-floating">
				<i class="small material-icons">search</i>
			</button>
			<button type="reset" class="btn btn-small btn-floating">
				<i class="small material-icons">clear</i>
			</button>
		</form>
	</div>

	<!-- scrollamount 調整跑馬燈速度 -->
	<!-- 愛心圖示 + 感謝 + 捐獻者名字 +捐獻+ 捐獻物品 -->
	<marquee id="headMarquee" scrollamount="5">
		<img src="../images/heart.png" width="20px">感謝 <b> 簡小文 </b>捐獻 <b> 雨傘 </b><img src="../images/heart.png" width="20px">感謝 <b> 許阿瑋 </b>捐獻 <b> 50吋 液晶電視 </b><img src="../images/heart.png" width="20px">感謝 <b> 彭翔翔 </b>捐獻 <b> A4 影印紙 </b><img src="../images/heart.png" width="20px">感謝 <b> 郭豪豪 </b>捐獻 <b> 電風扇 </b>
	</marquee>

	<center>
	<!-- Content -->
	<div class="ui-widget ui-helper-clearfix" id="donateBody">
	<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
		
		<c:forEach var='item' items='${AllDemands}' varStatus='vs'>
			<li class="ui-widget-content ui-corner-tr" value="${item.donationId}">
				<div>
					<div class="fiximg">
						<!-- h5 標籤不能新增修改，後面設定會用 -->
						<div class="alert alert-info" role="alert">
							<h5>${item.supplyName} - ${item.schoolName}</h5>
						</div>
						<img class="bigimg" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}" alt="${item.supplyName}" title="${item.supplyName}" '>
					</div>
					<div>
						<div class="foottext">需求數量 : ${item.demandNumber}</div>
							<div class="footIcin">
								<div id=add${vs.index} >
								<a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" title="${item.supplyName} - ${item.schoolName}" class="ui-icon ui-icon-zoomin"></a> 
								<a href="link/to/trash/script/when/we/have/js/off" title="加入捐獻背包" class="ui-icon ui-icon-suitcase" ></a>
								</div>
								<script>
								var add${vs.index} = document.getElementById("add${vs.index}");
								add${vs.index}.addEventListener("click", function(){
									donationId = "${item.donationId}";
									schoolId = "${item.schoolId}";
									schoolName = "${item.schoolName}";
									donationStatus = "${item.donationStatus}";
									supplyName = "${item.supplyName}";
									originalDemandNumber = "${item.originalDemandNumber}";
									originalDemandUnit = "${item.originalDemandUnit}";
									demandNumber = "${item.demandNumber}";
									size = "${item.size}";
									demandContent = "${item.demandContent}";
									supplyStatus = "${item.supplyStatus}";
									demandTime = "${item.demandTime}";
									expireTime = "${item.expireTime}";
									remark = "${item.remark}";
									toCart="CheckDonationList.jsp";
									otherDemands = "<c:url value='demand.do?type=AllDeamndByMember&schoolId=${item.schoolId}&donationId=${item.donationId}&schoolName=${item.schoolName}'/>";
									imgLet = "${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}";
									link = "<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>"
								});
								</script>
							</div>
						</div>
				</div>
			</li>
		</c:forEach>
	</ul>
	
	<div id="trash" class="ui-widget-content ui-state-default">
		<div class="alert alert-success" role="alert">
			<h3 id="trashHead">
				<button type="reset" id="donateDelete" class="btn btn-small btn-floating">
					<i class="small material-icons">delete</i>
				</button>
				捐獻背包
				<a href="CheckDonationList.jsp">
				<button type="submit" id="donateTotal" class="btn btn-small btn-floating">
					<i class="small material-icons">card_giftcard</i>
				</button>
				</a>
			</h3>
		</div>
	</div>
</div>
<iframe name='hidden_frame' style='width:0px;height:0px'></iframe>
</center>
</body>
</html>