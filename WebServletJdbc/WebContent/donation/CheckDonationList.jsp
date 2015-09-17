<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="../styles/DonationBill.css">
<!-- <script type="text/javascript" src="scripts/CheckNumber.js"></script> -->

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
							<li class="tab col s3"><a id="page01" href="#test1" class="active">確認捐獻明細</a></li>
							<li class="tab col s3"><a id="page02" href="#test2">填寫收件人資料</a></li>
							<li class="tab col s3"><a id="page03" href="#test3">產生收據</a></li>
							<li class="tab col s3"><a id="page04" href="#test4">完成步驟</a></li>
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
									<c:forEach var='item' items='${DonationCart.content}' varStatus='vs'>
										<tr>
											<td><img class="imgBill" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.value.donationId}&schoolId=${item.value.schoolId}" alt="延長線" title="延長線"></td>
											<td>${item.value.supplyName}</td>
											<td>${item.value.schoolName}</td>
											<td>${item.value.supplyStatus}</td>

											<td style="word-break: break-all;"><div id="remark">${item.value.demandContent}</div></td>
											<td>
												<button type="button" id="buttonSub${vs.index}" class="btn btn-small btn-floating">
													<i class="small material-icons">navigate_before</i>
												</button> <input type="text" id="text${vs.index}" value="1" autocomplete="off"> <label for="text" id="textUnit">${item.value.originalDemandUnit}</label>
												<button type="button" id="buttonAdd${vs.index}" class="btn btn-small btn-floating">
													<i class="small material-icons">navigate_next</i>
												</button>
											</td>
										</tr>

										<script type="text/javascript">
// 										var buttonAdd${vs.index} = document.getElementById("buttonAdd${vs.index}");
// 										buttonAdd${vs.index}.addEventListener("click", function(){
											
											(function($) {
												var step = 1; // 默認步長
												var changeStepTimer = null; // 改變速度計數器
												var setValueTimer = null; // 設置值計數器

												/* 改變速度私有方法 */
												var changeStep = function() {
													// 每隔 2 秒速度加 5
													changeStepTimer = setInterval(function() {
														step += 5
													}, 2000);
												}

												/* 設置值私有方法 */
												var setAddValue = function() {
// 													var input = $("#text${vs.index}").val();
													$("#text${vs.index}").val(parseInt($("#text${vs.index}").val()) + step);
													setValueTimer = setTimeout(setAddValue, 200); // 每隔200毫秒更新文本框數值一次
												}

												/* 設置值私有方法 */
												var setSubValue = function() {
// 													var input = $("#text${vs.index}").val();
													$("#text${vs.index}").val(parseInt($("#text${vs.index}").val()) - step);
													setValueTimer = setTimeout(setSubValue, 200); // 每隔200毫秒更新文本框數值一次
												}

												/* 按下鼠標處理函數 */
												$("#buttonSub${vs.index}").mousedown(function() {
// 													var input = $("#text${vs.index}").val();
													// 正規表示法找整數
													if ((/^\d+$/.test($("#text${vs.index}").val())) && parseInt($("#text${vs.index}").val()) > 0 && parseInt($("#text${vs.index}").val()) < 10000) {
														changeStep();
														setSubValue();
													} else {
														Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800);
														$("#text${vs.index}").val(1);
													}

												});

												/* 按下鼠標處理函數 */
												$("#buttonAdd${vs.index}").mousedown(function() {
// 													var input = $("#text${vs.index}").val();
													// 正規表示法找整數
													if ((/^\d+$/.test($("#text${vs.index}").val())) && parseInt($("#text${vs.index}").val()) > 0 && parseInt($("#text${vs.index}").val()) < 10000) {
														changeStep();
														setAddValue();
														
													} else {
														Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800);
														$("#text${vs.index}").val(1);
													}

												});

												/* 鬆開鼠標處理函數 */
												$("*").mouseup(checkText).keydown(checkText).keyup(checkText);

												function checkText() {
													var input = $("#text${vs.index}").val();
													if ((/^\d+$/.test(input)) && parseInt(input) > 0 && parseInt(input) < 10000) {
													} else {
														Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800);
														$("#text${vs.index}").empty();
														$("#text${vs.index}").val(1);
													}
													clearInterval(changeStepTimer);
													clearTimeout(setValueTimer);
													step = 1;
												}
											}(jQuery));
// 										});
										</script>
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
									<div class="rightTitle">
										<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="將會員資料同步到收件人資料"><i class="Medium material-icons">autorenew</i></a>&nbsp;填寫收件人資料
									</div>
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
		
		<!-- 訂單送出 -->
		<form action='<c:url value="cart.do"/>' method='POST' target='#drop-a-line'>
			<input type='submit' name='fillOrder' value='booking' id='booking'>
		</form>
		
		<c:forEach var='item' items='${DonationCart.content}' varStatus='vs'>
			<form action='<c:url value="checkOrder.do"/>' method='POST'>
			<script type="text/javascript">
				(function($) {
					$("#booking").click(function() {
						var donationId = "${item.value.donationId}";
						var donateAmount = $("#text${vs.index}").val();			
						
						xhr = new XMLHttpRequest();
						if (xhr != null) {
							xhr.addEventListener("readystatechange", function(donateAmount){
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										lists = xhr.responseText;
									} else {
										alert("something is wrong!");
									}
								}
							});
							xhr.open("POST", "cart.do", true);
							xhr.setRequestHeader("Content-Type",
									"application/x-www-form-urlencoded")
							// 假設會員id為5
							xhr.send("toCart=update&donationId="+"${item.value.donationId}"+"&donateAmount="+donateAmount);
						}
// 						$("#page01").removeAttr("class");
// 						$(":active").removeAttr("class");
// 						$("#page02").attr("class","active");
					});
				}(jQuery));
			</script>
			</form>
		</c:forEach>
	</center>
	
</body>
</html>