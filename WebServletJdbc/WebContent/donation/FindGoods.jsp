<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 標頭css -->
<link rel="stylesheet" href="../donationStyles/DonationHeader.css">
<!-- 標頭專用 top end -->

<!-- 預設 （本機）-->
<link rel="stylesheet" href="../donationStyles/jquery-ui.css">
<script type="text/javascript" src="../donationScripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../donationScripts/jquery-ui.js"></script>

<!-- 預設（遠端） -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<!-- 自訂 -->
<link rel="stylesheet" href="../donationStyles/DonationWall.css">
<script type="text/javascript" src="../donationScripts/Donation.js"></script>
<script type="text/javascript" src="../donationScripts/picture-big.js"></script>


<!-- 在多加載一次picture-big，比較保險 -->

<script type="text/javascript" src="../donationScripts/picture-big.js"></script>

	<script>
	  //將資料存到陣列中
	  var datas = ["a"];
	  var show;
	  window.addEventListener("load",init);
	  var txt; // 物件
	  var xhr = null;
	  var lists = null;
	  
	  function init(){
		  txt = document.getElementById("searchDonation");
		  txt.addEventListener("keyup",getData,false);
		  show = document.getElementById("div1");
		  
	  }
	  
	  function getData(){
		  xhr = new XMLHttpRequest();
		  if (xhr != null) {
			  xhr.addEventListener("readystatechange", function() {
				  if (xhr.readyState == 4 && xhr.status == 200) {
					 lists = xhr.responseText;
					 datas = JSON.parse(lists);
					 
				     show.style.display="block";
				     if(show.childNodes.length > 0){
				    	 show.removeChild(show.childNodes[0]);
				     }
				     var eleUl = document.createElement("ul");
				     for(var j=0;j<datas.length;j++){
				  	    var txtLi = document.createTextNode(datas[j]);
				  	    var eleLi = document.createElement("li");
				  	    eleLi.appendChild(txtLi);
				  	    eleLi.addEventListener("mouseover",function(){this.className='s1'},false)
				  	    eleLi.addEventListener("mouseout",function(){this.className='s2'},false)
				  	    eleLi.addEventListener("click",function(){
				  	    	 document.myData.keyword.value = this.firstChild.nodeValue;  		  	  
				  		  	 show.style.display="none";
				  	    },false)
				  	    eleUl.appendChild(eleLi);
				     }
				     if (datas.length != 0) {
					     show.appendChild(eleUl);
				     } else {
				    	 
				     }
				     
				  } else {
					  console.log(xhr.status + ":" + xhr.statusText);			  }
				  
			  });
			  
			  var input = txt.value;
			  if (input.length != 0) {
				  xhr.open("get", "jsimple.do?term="+input, true);
			  } else {
				  input = "cmaxxx";
				  xhr.open("get", "jsimple.do?term="+input, true);
			  }
			  xhr.send();
		  }	
	  }
	</script>

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
						<form action="#">
							<div class="input-field">														  
								<input id="searchDonation" type="search" required placeholder="輸入物品或學校"> <label for="searchDonation"><i class="large material-icons" id="searchIcon">search</i></label>
								<div id="div1" style="background-color: white;"></div>
							</div>
						</form>
					</li>
					<li><i class="large material-icons" id="clearIcon">clear</i></li>
					<li class="chooseItem" value="熱門"><a href="#">熱門</a></li>
					<li class="chooseItem" value="需求數量"><a href="<c:url value='search.do?type=byAmount'/>">需求數量</a></li>
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
					<li><a href="#"><i class="large material-icons">person</i></a></li>
				</ul>
			</div>
		</nav>
	</div>
	<br>
	<!-- 我就是標頭 end -->

	<!-- scrollamount 調整跑馬燈速度 -->
	<!-- 愛心圖示 + 感謝 + 捐獻者名字 +捐獻+ 捐獻物品 -->
	<marquee id="headMarquee" scrollamount="8">
		<img src="../images/heart.png" width="20px">感謝 <b> 許阿瑋 </b>捐獻 <b> 50吋 液晶電視 </b><img src="../images/heart.png" width="20px">感謝 <b> 彭翔翔 </b>捐獻 <b> A4 影印紙 </b><img src="../images/heart.png" width="20px">感謝 <b> 郭豪豪 </b>捐獻 <b> 電風扇 </b>
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
									<a href="<c:url value='demand.do?type=OneDemandByMember&donationId=${item.donationId}&schoolId=${item.schoolId}'/>" title="${item.supplyName} - ${item.schoolName}" class="ui-icon ui-icon-zoomin" id="${item.donationId}+${item.schoolId}+${item.schoolName}+${item.supplyStatus}+${item.supplyName}+${item.originalDemandNumber}+${item.originalDemandUnit}+${item.demandNumber}+${item.size}+${item.demandContent}+${item.supplyStatus}+${item.demandTime}+${item.expireTime}+${item.remark}+${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.donationId}&schoolId=${item.schoolId}+${item.originalDemandUnit}" ></a> 
									<a href="link/to/trash/script/when/we/have/js/off" title="加入捐獻背包" class="ui-icon ui-icon-suitcase"></a>
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
							<a href="CheckDonationList.jsp" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="加入捐獻背包"><i class="tiny material-icons">card_giftcard</i></a>
						</button>
					</span> <span id="trashHeadRightBtn">
						<button type="button" id="donateDelete" class="btn btn-small btn-floating">
							<a a href="cart.do?toCart=deleteAll" class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清空背包"><i class="tiny material-icons">delete</i></a>
						</button>
					</span>
				</div>

				<div class="alert alert-success" role="alert" id="trashBody">

					<h3 id="trashHead">
						<span id="donateBagTitle">捐獻背包</span>
					</h3>
				</div>
			</div>
		</div>

	</center>
	<!-- 標頭專用 bottom start -->
	<!-- 必須最後載入才有效果 -->
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js" type="text/javascript"></script>
	<!-- 標頭專用 bottom end -->
	
	<script>
	// deleteAll
	$('#donateDelete').click(function(){
		// 設定cookie值
		var now = new Date();
		now.setTime(now.getTime()-1);
		document.cookie="Items=;expire="+now.toUTCString();
	});
	
	// 取出指定name的value
	var objName = "Items";
	var tempvalue = getCookie(objName);
	console.log("!   "+tempvalue);
	var value = tempvalue.match(/[0-9]+/g);
	for(var c=0;c<value.length; c++) {
		console.log(value[c]);
		// 傳入已加入購物車的清單
		var i = value[c];
		var data = $("#"+i+"");
		deleteImage(data);
	}
	//獲取指定名稱的cookie的值 
	function getCookie(objName){
		var arrStr = document.cookie.split("; "); 
		for(var i = 0;i < arrStr.length;i ++){ 
		var temp = arrStr[i].split("="); 
		if(temp[0] == objName) 
		return unescape(temp[1]); 
		} 
	}
	// 傳入已加入購物車的清單
	var i = "${item}";
	var data = $("#"+i+"");
	deleteImage(data);
	
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
						now.setTime(now.getTime()+1000*60*60*24*30);
						document.cookie="Items="+lists+";expire="+now.toUTCString();
						
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
	
<!-- 	<script type="text/javascript" src="../donationScripts/Maquee.js"></script> -->
	<script type="text/javascript" src="../donationScripts/ScreenSize.js"></script>
	</center>
	
	<script type="text/javascript">
	
	  $("#div1 ul li .s2").css("border","2px solid blue");
	  $("#div1").css("border","2px solid blue");
	  $("#div1").click(function () {
// 		alert($(this).val());
	});
	</script>
</body>
</html>