<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckDonationList</title>
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

<!-- 自訂 -->
<link rel="stylesheet" href="styles/DonationBill.css">
<script type="text/javascript" src="scripts/CheckNumber.js"></script>

</head>
<body>
<center>
<div class="navbar navbar-inverse">
		<ul class="nav navbar-nav" id="headUl">
			<li class="active"><a href="#">捐獻明細</a></li>
			<li class="headList"><a href="#"></a></li>
		</ul>
	</div>

	<center>
		<div id="bodyContent">
			<div class="row">
				<div class="col s12">
					<ul class="tabs">
						<li class="tab col s3"><a href="#test1" class="active">確認捐獻明細</a></li>
						<li class="tab col s3"><a href="#test2">填寫收件人資料</a></li>
						<li class="tab col s3"><a href="#test3">產生收據</a></li>
						<li class="tab col s3"><a href="#test4">完成步驟</a></li>
					</ul>
					<br>
				</div>

				<!-- 第一步驟 -->
				<div id="test1" class="col s12">
					<form action="">
						<table id="donationBill" class="responsive-table">
							<thead>
								<tr>
									<td>捐獻物資</td>
									<td>物資名稱</td>
									<td>受捐獻單位</td>
									<td>物資狀態</td>
									<td>物資備註</td>
									<td>數量</td>
								</tr>
							</thead>
							<tbody>
							<c:forEach var='item' items='${DonationCart.content}'>
								<tr>
									<td><img class="imgBill" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.value.donationId}&schoolId=${item.value.schoolId}" alt="延長線" title="延長線"></td>
									<td>${item.value.supplyName}</td>
									<td>${item.value.schoolName}</td>
									<td>${item.value.supplyStatus}</td>

									<td style="word-break: break-all;"><div id="remark">${item.value.demandContent}</div></td>
									${item.value.originalDemandUnit}
									${item.value.originalDemandUnit}
									<td>
										<button type="button" id="buttonSub" class="btn btn-small btn-floating">
											<i class="small material-icons">navigate_before</i>
										</button> <input type="text" id="text" value="1" autocomplete="off"> <label for="text" id="textUnit">${item.value.originalDemandUnit}</label>
										<button type="button" id="buttonAdd" class="btn btn-small btn-floating">
											<i class="small material-icons">navigate_next</i>
										</button> <script type="text/javascript" src="scripts/CheckNumber.js"></script>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</form>



					<!-- 第二步驟 -->
				</div>

				<div id="test2" class="col s12">

					<form id="drop-a-line" action="#">

						<div id="warnText">
							<span class="glyphicon glyphicon-star" style="float: left;"></span>&nbsp;<span>符號為必填欄位</span>
						</div>


						<div class="row">
							<div class="col-md-6">
								<br> <br>
								<div class="leftTitle">會員基本資料</div>
								<!-- 上左 -->
								<div class="input-field col m12 s12">
									<input type="text" id="schoolName" disabled value="林大揚"><label for="schoolName"><span class="glyphicon glyphicon-pencil"></span><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="會員名稱"><span class="DetailTitle">&nbsp;會員姓名&nbsp;</span></a></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="schoolName" disabled value="262宜蘭縣礁溪鄉武暖路159-1號"><label for="schoolName"><span class="glyphicon glyphicon-pencil"></span><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="會員名稱"><span class="DetailTitle">&nbsp;地址&nbsp;</span></a></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="schoolName" disabled value="林大揚"><label for="schoolName"><span class="glyphicon glyphicon-pencil"></span><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="會員名稱"><span class="DetailTitle">&nbsp;會員姓名&nbsp;</span></a></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="schoolName" disabled value="林大揚"><label for="schoolName"><span class="glyphicon glyphicon-pencil"></span><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="會員名稱"><span class="DetailTitle">&nbsp;會員姓名&nbsp;</span></a></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="schoolName" disabled value="林大揚"><label for="schoolName"><span class="glyphicon glyphicon-pencil"></span><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="會員名稱"><span class="DetailTitle">&nbsp;會員姓名&nbsp;</span></a></span></label>
								</div>

							</div>
							
							
							<div class="col-md-6">
								<br> <br>
								<div class="rightTitle"><a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="將會員資料同步到收件人資料"><i class="Medium material-icons">autorenew</i></a>&nbsp;填寫收件人資料</div>
								<!-- 右上 -->

								<div class="input-field col m12 s12">
									<input type="text" id="supplyName" length="25" required="required" autofocus="autofocus" autocomplete="off"><label for="supplyName"><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="最多輸入 25 個字"><span class="DetailTitle">&nbsp;物資名稱&nbsp;<span class="glyphicon glyphicon-star"></span></span></a></label>
								</div>

								<div class="input-field col m12 s12">
									<input type="number" id="originalDemandNumber" required="required" autofocus="autofocus" autocomplete="off" max="9999" min="1"><label for="originalDemandNumber"><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="輸入數字"><span class="DetailTitle">&nbsp;需求物品數量&nbsp;<span
												class="glyphicon glyphicon-star"></span></span></a></label>
								</div>

								<div class="input-field col m12 s12">
									<input type="text" id="originalDemandUnit" required="required" autofocus="autofocus" autocomplete="off"><label for="originalDemandUnit"><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="例如：包、打、張、隻、箱"><span class="DetailTitle">&nbsp;需求物品單位&nbsp;<span class="glyphicon glyphicon-star"></span></span></a></label>
								</div>

								<div class="input-field col m12 s12">
									<input type="text" id="size" autofocus="autofocus" autocomplete="off"><label for="size"><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="例如：物品大小的長.寬.高、電壓 110V 或 220V"><span class="DetailTitle">&nbsp;尺寸規格&nbsp;</span></a></label>
								</div>

								<div class="input-field col m12 s12">
									<label><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="不拘、全新、二手"><span class="DetailTitle">&nbsp;物資狀態&nbsp;</span></a></label><br> <br> <select class="browser-default" id="supplyStatus" name="supplyStatus">
										<option value="1">不拘</option>
										<option value="2">全新</option>
										<option value="3">二手</option>
									</select> <br>
								</div>

								<div class="input-field col m12 s12">
									<textarea id="demandContent" class="materialize-textarea" required="required" autofocus="autofocus"></textarea>
									<label for="demandContent"><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="說明為什麼需要這項物資"><span class="DetailTitle">&nbsp;需求說明&nbsp;<span class="glyphicon glyphicon-star"></span></span></a></label>
								</div>

							</div>
						</div>

						<!-- 備註 -->
						<div class="input-field col m12 s12">
							<textarea id="remark" class="materialize-textarea" autofocus="autofocus"></textarea>
							<label for="remark"><span class="glyphicon glyphicon-pencil"></span><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="補充說明"><span class="DetailTitle">&nbsp;備註&nbsp;</span></a></label>
						</div>

						<button type="submit" id="send-message" class="btn btn-large btn-success waves-effect waves-light">
							<i class="large material-icons">done</i>
						</button>

						<button type="reset" id="cancel-message" class="btn btn-large btn-success waves-effect waves-light">
							<i class="large material-icons">loop</i>
						</button>
					</form>

				</div>

				<!-- 第三步驟 -->
				<div id="test3" class="col s12">xxTest 3</div>

				<!-- 第四步驟 -->
				<div id="test4" class="col s12">xxTest 4</div>


			</div>
	</center>




























	<h3>確認捐贈清單</h3>
	<a href='index.jsp'>回首頁</a>|
	<table style="width:1000px;height:60px;background-color:#FFD382;border:1px solid black;">
<!-- 	<tr><td>donationId</td><td>schoolId</td><td>schoolName</td><td>supplyName</td><td>originalDemandNumber</td><td>originalDemandUnit</td><td>demandNumber</td><td>donateAmount</td><td>size</td><td>demandContent</td><td>supplyStatus</td><td>捐贈數量</td></tr> -->
	<tr><td>學校</td><td>需求物資</td><td>原始需求</td><td>單位</td><td>剩餘需求</td><td>捐獻數量</td><td>尺寸</td><td>物品狀態</td></tr>
	<c:forEach var='item' items='${DonationCart.content}'>
<%-- 	<tr><td>${item.value.donationId}</td></tr> --%>
	<tr>
<%-- 	<td>${item.value.donationId}</td> --%>
<%-- 	<td>${item.value.schoolId}</td> --%>
	<td>${item.value.schoolName}</td>
<%-- 	<tr><td>${item.value.donationStatus}</td></tr> --%>
	<td>${item.value.supplyName}</td>
	<td>${item.value.originalDemandNumber}</td>
	<td>${item.value.originalDemandUnit}</td>
	<td>${item.value.demandNumber}</td>
	<form action='<c:url value="cart.do"/>' method='POST'>
	<td>
	<input type='submit' name='toCart' value='delete'>
	<input type='text' name='donateAmount' value='${item.value.donateAmount}' style='width:50px'>
	<input type='hidden' name='donationId' value='${item.value.donationId}'>
	<input type='submit' name='toCart' value='update'>
	</td>
	<td>${item.value.size}</td>
<%-- 	<td>${item.value.demandContent}</td> --%>
	<td>${item.value.supplyStatus}</td>
	</form>
	</tr>
	</c:forEach>
	</table>
	<form action='<c:url value="checkOrder.do"/>' method='POST'>
	<input type='submit' name='fillOrder' value='booking'>
	</form>
</center>
</body>
</html>