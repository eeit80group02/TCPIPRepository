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
						<li class="tab col s3" id="pageTab01"><a href="#test1" class="active">捐獻背包</a></li>
						<li class="tab col s3" id="pageTab02"><a href="#test2" class="">捐獻明細</a></li>
						<li class="tab col s3" id="pageTab03"><a href="#test3" class="">填寫資料</a></li>
						<li class="tab col s3" id="pageTab04"><a href="#test4" class="">完成捐獻</a></li>
					</ul>
					<br>

				</div>

				<!-- 第一頁 start -->
				<div id="test1" class="col s12">
					<div class="col s12">
						<div class="warnText">
							<span>確認捐獻背包</span>
							<!-- 操作小叮嚀 start -->
							<button type="button" data-target="modalNote01" class="btn btn-small btn-floating modal-trigger">
								<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
							</button>
							<!-- Modal Structure -->
							<div id="modalNote01" class="modal modal-fixed-footer">
								<div class="modal-content">
									<h4>操作小叮嚀：</h4>
									<ol>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">remove</i></a>&nbsp;、&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">add</i></a>&nbsp;單擊左鍵，可對數量做加減，若按壓不放，可以加速數字變動。
										</li>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">delete</i></a>&nbsp;雙擊左鍵，即可移除該筆捐獻物品。
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
									<td>捐獻物資</td>
									<td>受捐獻單位</td>
									<td>狀態</td>
									<td>物資備註</td>
									<td>數量</td>
									<td>移除</td>
								</tr>
							</thead>
							<tbody>

							<c:forEach var='item' items='${DonationCart.content}' varStatus='vs'>
										<tr>
											<td><img class="imgBill" src="${pageContext.servletContext.contextPath}/_00_init/ImageServletMVC?donationId=${item.value.donationId}&schoolId=${item.value.schoolId}" alt="${item.value.supplyName}" title="${item.value.supplyName}"></td>
											<td>${item.value.schoolName}<br> <br>屏東縣鹽埔鄉鹽南村勝利路30號</td>
											<td>${item.value.supplyStatus}</td>
											<td style="word-break: break-all;"><div id="remark" class="remark">${item.value.demandContent}</div></td>
											
											<td>
												<button type="button" id="buttonSub${vs.index}" class="btn btn-small btn-floating">
													<i class="small material-icons">remove</i>
												</button> <input type="text" id="text${vs.index}" value="1" autocomplete="off" class="textNeed"> <label for="text" id="textUnit" class="textUnit">${item.value.originalDemandUnit}</label>
												<button type="button" id="buttonAdd${vs.index}" class="btn btn-small btn-floating">
													<i class="small material-icons">add</i>
												</button>
											</td>
											<td class="deleteRow">
												<button type="button" class="btn btn-small btn-floating">
													<i class="small material-icons">delete</i>
												</button>
											</td>
									
											<script type="text/javascript">
											
												$(window).load(function() {
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
												});

												/* 按下鼠標處理函數 */
												$("#buttonAdd${vs.index}").mousedown(function() {
													// 													var input = $("#text${vs.index}").val();
													// 正規表示法找整數
													if ((/^\d+$/.test($("#text${vs.index}").val())) && parseInt($("#text${vs.index}").val()) > 0 && parseInt($("#text${vs.index}").val()) < 10000) {
														changeStep();
														setAddValue();

													} else {
														Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800, 'rounded');
														$("#text${vs.index}").val(1);
													}

												});

												/* 鬆開鼠標處理函數 */
												$("*").mouseup(checkText).keydown(checkText).keyup(checkText);

												function checkText() {
													var input = $("#text${vs.index}").val();
													if ((/^\d+$/.test(input)) && parseInt(input) > 0 && parseInt(input) < 10000) {
													} else {
														Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800, 'rounded');
														$("#text${vs.index}").empty();
														$("#text${vs.index}").val("1");
													}
													clearInterval(changeStepTimer);
													clearTimeout(setValueTimer);
													step = 1;
												}
											}(jQuery));
										</script>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br> <br>

						<button type="button" id="page01Prev" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="捐獻牆"><i class="small material-icons">keyboard_arrow_left</i></a>
						</button>
						<button type="button" id="page01Clear" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="全部清除"><i class="small material-icons">clear</i></a>
						</button>
						<button type="submit" id="page01Next" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
						</button>
					</form>
					<br>
				</div>
				<!-- 第一頁 end -->

				<!-- 第二頁 start -->
				<div id="test2" class="col s12">

					<div class="col s12">
						<div class="warnText">
							<span>確認捐獻物品明細</span>
							<!-- 操作小叮嚀 start -->
							<button type="button" data-target="modalNote02" class="btn btn-small btn-floating modal-trigger">
								<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
							</button>
							<!-- Modal Structure -->
							<div id="modalNote02" class="modal modal-fixed-footer">
								<div class="modal-content">
									<h4>操作小叮嚀：</h4>
									<ol>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">navigate_next</i></a>&nbsp;單擊左鍵，進入填寫資料。
										</li>
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
						<table id="donationBill02" class="responsive-table">
							<thead>
								<tr>
									<td>受捐獻單位</td>
									<td>捐獻物資</td>
									<td>移除</td>
									<td>下一步</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>屏東縣鹽埔鄉鹽埔國民小學<br> <br>屏東縣鹽埔鄉鹽南村勝利路30號
									</td>
									<td>延長線 30條<br>排球 20顆<br>籃球 40顆<br>DVD空白光碟片 100片
									</td>
									<td class="deleteRow">
										<button type="button" class="btn btn-small btn-floating">
											<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="移除"><i class="small material-icons">delete</i></a>
										</button>
									</td>
									<td>
										<button type="button" id="page02Next" class="btn btn-small btn-floating">
											<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
										</button>
									</td>
								</tr>
								<tr>
									<td>礁溪國民小學<br> <br>宜蘭縣礁溪鄉礁溪路四段135號
									</td>
									<td>延長線 30條<br>排球 20顆<br>籃球 40顆<br>DVD空白光碟片 100片
									</td>
									<td class="deleteRow">
										<button type="button" class="btn btn-small btn-floating">
											<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="移除"><i class="small material-icons">delete</i></a>
										</button>
									</td>
									<td>
										<button type="button" id="page02Next" class="btn btn-small btn-floating">
											<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
										</button>
									</td>
								</tr>
								<tr>
									<td>苗栗縣蓬萊國小<br> <br>苗栗縣南庄鄉蓬萊村19鄰118號
									</td>
									<td>延長線 30條<br>排球 20顆<br>籃球 40顆<br>DVD空白光碟片 100片
									</td>
									<td class="deleteRow">
										<button type="button" class="btn btn-small btn-floating">
											<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="移除"><i class="small material-icons">delete</i></a>
										</button>
									</td>
									<td>
										<button type="button" id="page02Next" class="btn btn-small btn-floating">
											<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
										</button>
									</td>
								</tr>
							</tbody>
						</table>
						<br> <br>

						<button type="button" id="page02Prev" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="上一步"><i class="small material-icons">keyboard_arrow_left</i></a>
						</button>
						<button type="button" id="page02Clear" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
						</button>

					</form>


				</div>
				<!-- 第二頁 end -->

				<!-- 第三頁 start -->
				<div id="test3" class="col s12">
					<div class="col s12">
						<div class="warnText">
							<span class="redStar"><i class="tiny material-icons">star</i></span>&nbsp;<span>本頁皆為必填欄位</span>
							<!-- 宅配小叮嚀 start -->
							<button type="button" data-target="modalNote03" class="btn btn-small btn-floating modal-trigger">
								<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
							</button>
							<!-- Modal Structure -->
							<div id="modalNote03" class="modal modal-fixed-footer">
								<div class="modal-content">
									<h4>宅配小叮嚀：</h4>
									<ol type="A">
										<li>宅配通須知：</li>
										<ol>
											<li><a href="https://www.e-can.com.tw/serviceNormalTemp.aspx?id=1&amp;sys_id=1" target="_blank" class="hrefToWebsite">無法收送貨件區域 </a></li>
											<li><a href="https://www.e-can.com.tw/search_Freight.aspx" target="_blank" class="hrefToWebsite">運費查詢</a></li>
											<li><a href="https://www.e-can.com.tw/serviceNormalTemp.aspx?id=6&amp;sys_id=15" class="hrefToWebsite">託運條款</a></li>
										</ol>
										<li>常溫貨件規格：長+寬+高≦150公分(含)以下。</li>
										<li>貨件重量：限20公斤(含)以下。</li>
										<li>超過交件時間配送時效順延一天。</li>
										<li>以下區域恕不提供宅配通貨件配送服務：</li>
										<ol>
											<li>澎湖地區：望安鄉、七美鄉、虎井島、桶盤島、大倉嶼、員貝嶼、鳥嶼、花嶼、吉貝嶼。</li>
											<li>金門地區：烏坵、烈嶼、大膽、二膽。</li>
											<li>馬祖地區(連江縣)：南竿鄉、北竿鄉、莒光鄉、東引鄉。</li>
											<li>澎湖地區：望安鄉、七美鄉、虎井島、桶盤島、大倉嶼、員貝嶼、鳥嶼、花嶼、吉貝嶼。</li>
										</ol>
										<li>宅配服務提供三段式四種彈性指定送達時段，配合收件人的時間，快速送件流程，於指定時段送達。</li>
									</ol>
								</div>
								<div class="modal-footer">
									<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
								</div>
							</div>
							<!-- 宅配小叮嚀 end -->

						</div>
						<br>
					</div>

					<div class="col s12 m12 l6">
						<br>
						<div class="leftTitle">
							會員基本資料&nbsp;
							<button type="button" id="buttonLeft01" class="btn btn-small btn-floating">
								<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="修改會員資料"><i class="small material-icons">account_box</i></a>
							</button>
						</div>
						<br>
						<!-- 左上 -->
						<div class="input-field col m12 s12">
							<!-- 會員基本姓名 -->
							<input type="text" id="textLeft01" disabled value="林大揚"><label for="textLeft01"><i class="tiny material-icons">account_circle</i><span class="DetailTitle">&nbsp;會員姓名&nbsp;</span></label>
							<!-- 會員基本性別 -->
							<select class="browser-default" id="textLeft06" disabled="disabled">
								<option value="先生">先生</option>
								<option value="小姐">小姐</option>
							</select>
						</div>
						<div class="input-field col m12 s12">
							<!-- 會員基本縣市別 -->
							<select class="browser-default" id="addressLeft01" name="address01">
								<option value="宜蘭縣">宜蘭縣</option>
							</select>
							<!-- 會員基本區域別 -->
							<select class="browser-default" id="addressLeft02" name="address02">
								<option value="礁溪鄉">礁溪鄉</option>
							</select> <br> <br> <br>
						</div>
						<div class="input-field col m12 s12">
							<!-- 會員基本地址 -->
							<input type="text" id="textLeft02" disabled value="武暖路159-1號"><label for="textLeft02"><i class="tiny material-icons">location_city</i><span class="DetailTitle">&nbsp;地址&nbsp;</span></label>
						</div>

						<div class="input-field col m12 s12">
							<!-- 會員基本電話 -->
							<input type="text" id="textLeft03" disabled value="0229888888"><label for="textLeft03"><i class="tiny material-icons">phone</i><span class="DetailTitle">&nbsp;電話&nbsp;</span></label>
						</div>
						<div class="input-field col m12 s12">
							<!-- 會員基本手機 -->
							<input type="text" id="textLeft04" disabled value="0973737373"><label for="textLeft04"><i class="tiny material-icons">smartphone</i><span class="DetailTitle">&nbsp;手機&nbsp;</span></label>
						</div>
						<div class="input-field col m12 s12">
							<!-- 會員基本 E-mail -->
							<input type="text" id="textLeft05" disabled value="eeit80group02@gmail.com"><label for="textLeft05"><i class="tiny material-icons">mail</i><span class="DetailTitle">&nbsp;E-mail&nbsp;</span></label>
						</div>
					</div>
					<div class="col s12 m12 l6">
						<br>
						<div class="rightTitle">
							<button type="button" id="buttonRight01" class="btn btn-small btn-floating">
								<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="將會員資料同步到寄件人資料"><i class="small material-icons">autorenew</i></a>
							</button>
							&nbsp;填寫寄件人資料
							<!-- 一鍵輸入 -->
							<button type="button" id="OneClick" class="btn btn-small btn-floating">一鍵填</button>
						</div>
						<br>
						<!-- 右上 寄件人系列 -->

						<div class="input-field col m12 s12">
							<!-- 寄件人姓名 -->
							<input class="required" required="required" autocomplete="off" type="text" id="txtOcname" name="txtOcname" maxlength="15"><label for="txtOcname" class="" id="textRightLable01"><i class="tiny material-icons">account_circle</i><span class="DetailTitle">&nbsp;姓名&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
							<!-- 寄件人姓別 -->
							<select class="browser-default" name="ddlOcname_ex" id="ddlOcname_ex">
								<option value="先生">先生</option>
								<option value="小姐">小姐</option>
							</select>
						</div>

						<div class="input-field col m12 s12">
							<label for="ddlCity"></label>
							<!-- 寄件人縣市別 -->
							<select class="browser-default" name="ddlCity" id="ddlCity">
								<option value="">請選擇縣市別</option>
								<option value="基隆市">基隆市</option>
								<option value="臺北市">臺北市</option>
								<option value="新北市">新北市</option>
								<option value="桃園市">桃園市</option>
								<option value="新竹市">新竹市</option>
								<option value="新竹縣">新竹縣</option>
								<option value="苗栗縣">苗栗縣</option>
								<option value="臺中市">臺中市</option>
								<option value="南投縣">南投縣</option>
								<option value="彰化縣">彰化縣</option>
								<option value="雲林縣">雲林縣</option>
								<option value="嘉義市">嘉義市</option>
								<option value="嘉義縣">嘉義縣</option>
								<option value="臺南市">臺南市</option>
								<option value="高雄市">高雄市</option>
								<option value="屏東縣">屏東縣</option>
								<option value="宜蘭縣">宜蘭縣</option>
								<option value="花蓮縣">花蓮縣</option>
								<option value="臺東縣">臺東縣</option>
								<option value="澎湖縣">澎湖縣</option>
								<option value="金門縣">金門縣</option>
							</select>
							<script type="text/javascript">
								$('#ddlCity').on("change", function() {
									$('#ddlArea option').remove();
									$('#txtPostno').attr("value", "");
									$('#ddlArea').append("<option value=''>請選擇區域別</option>");
									$.ajax({
										url : '../GetCityServlet',
										type : "post",
										data : {
											"city" : $('#ddlCity').val()
										},
										datatype : 'json',
										success : function(result) {
											var areas = (typeof result.d) == 'string' ? eval('(' + result.d + ')') : result.d;
											for (var i = 0; i < areas.length; i++) {
												$('#ddlArea').append("<option value='" + areas[i].Zip + "'>" + areas[i].Name + "</option>");
											}
										}
									});
								});
							</script>

							<!-- 寄件人區域別 -->
							<select class="browser-default" name="ddlArea" id="ddlArea">
								<option value="">請選擇區域別</option>
							</select> <input type="hidden" name="hidArea" id="hidArea"> <input name="txtPostno" type="text" maxlength="3" id="txtPostno" style="width: 25px; display: none;" value=""><br> <br> <br>
						</div>

						<div class="input-field col m12 s12">
							<!-- 寄件人地址 -->
							<input class="required" required="required" autocomplete="off" type="text" id="txtOaddress" name="txtOaddress"><label for="txtOaddress" class="" id="textRightLable02"><i class="tiny material-icons">location_city</i><span class="DetailTitle">&nbsp;地址&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
						</div>

						<div class="input-field col m12 s12">
							<!-- 寄件人電話 -->
							<input class="required" required="required" autocomplete="off" type="text" id="txtOtel" name="txtOtel" maxlength="16"><label for="txtOtel" class="" id="textRightLable03"><i class="tiny material-icons">phone</i><span class="DetailTitle">&nbsp;電話&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
						</div>

						<div class="input-field col m12 s12">
							<!-- 寄件人手機 -->
							<input class="required" required="required" autocomplete="off" type="text" id="txtOmobile" name="txtOmobile" maxlength="10"><label for="txtOmobile" class="" id="textRightLable04"><i class="tiny material-icons">smartphone</i><span class="DetailTitle">&nbsp;手機&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></label>
						</div>
						<div class="input-field col m12 s12">
							<!-- 寄件人E-mail -->
							<input class="required" required="required" autocomplete="off" type="text" id="txtOemail" name="txtOemail"><label for="txtOemail" class="" id="textRightLable05"><i class="tiny material-icons">mail</i><span class="DetailTitle">&nbsp;E-mail&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></label>
						</div>

					</div>
					<div class="col s12">
						<br>
						<hr>
						<br>
					</div>
					<div class="col s12 m12 l6">
						<!-- 左下 -->
						<div class="leftTitle">收件人資料</div>
						<br>
						<div class="input-field col m12 s12">
							<!-- 收件人姓名 -->
							<input name="txtGcname" type="text" id="txtGcname" class="required" disabled="disabled" value="大安高工"><label for="txtGcname"><i class="tiny material-icons">account_circle</i><span class="DetailTitle">&nbsp;捐獻單位&nbsp;</span></label>
							<!-- 收件人姓別 Hide -->
							<select class="browser-default" name="ddlGcname_ex" id="ddlGcname_ex" class="required">
								<option value="先生">先生</option>
								<option value="小姐">小姐</option>
							</select>
						</div>

						<div class="input-field col m12 s12">
							<label for="ddlCity1"></label>
							<!-- 收件人縣市別 disabled -->
							<select class="browser-default" name="ddlCity1" id="ddlCity1">
								<option value="">請選擇縣市別</option>
								<option value="基隆市">基隆市</option>
								<option value="臺北市">臺北市</option>
								<option value="新北市">新北市</option>
								<option value="桃園市">桃園市</option>
								<option value="新竹市">新竹市</option>
								<option value="新竹縣">新竹縣</option>
								<option value="苗栗縣">苗栗縣</option>
								<option value="臺中市">臺中市</option>
								<option value="南投縣">南投縣</option>
								<option value="彰化縣">彰化縣</option>
								<option value="雲林縣">雲林縣</option>
								<option value="嘉義市">嘉義市</option>
								<option value="嘉義縣">嘉義縣</option>
								<option value="臺南市">臺南市</option>
								<option value="高雄市">高雄市</option>
								<option value="屏東縣">屏東縣</option>
								<option value="宜蘭縣">宜蘭縣</option>
								<option value="花蓮縣">花蓮縣</option>
								<option value="臺東縣">臺東縣</option>
								<option value="澎湖縣">澎湖縣</option>
								<option value="金門縣">金門縣</option>
							</select>
							<script type="text/javascript">
								$('#ddlCity1').on("change", function() {
									$('#ddlArea1 option').remove();
									$('#txtPostno1').attr("value", "");
									$('#ddlArea1').append("<option value=''>請選擇區域別</option>");
									$.ajax({
										url : '../GetCityServlet',
										type : "post",
										data : {
											"city" : $('#ddlCity1').val()
										},
										datatype : 'json',
										success : function(result) {
											var areas = (typeof result.d) == 'string' ? eval('(' + result.d + ')') : result.d;
											for (var i = 0; i < areas.length; i++) {
												$('#ddlArea1').append("<option value='" + areas[i].Zip + "'>" + areas[i].Name + "</option>");
											}
										}
									});
								});
							</script>
							<!-- 收件人區域別 disabled -->
							<select class="browser-default" name="ddlArea1" id="ddlArea1">
								<option value="">請選擇區域別</option>
							</select><input type="hidden" name="hidArea1" id="hidArea1"> <input name="txtPostno1" type="text" maxlength="3" id="txtPostno1" style="display: none;" value=""><br> <br> <br>
						</div>

						<div class="input-field col m12 s12">
							<!-- 收件人地址 -->
							<input class="required" required="required" autocomplete="off" type="text" id="txtGaddress" name="txtGaddress" disabled="disabled" value="臺北市大安區復興南路二段"><label for="txtGaddress" class=""><i class="tiny material-icons">location_city</i><span class="DetailTitle">&nbsp;地址</span></label>
						</div>


					</div>
					<div class="col s12 m12 l6">
						<div class="rightTitle">
							確認收件資料<br>
						</div>

						<div class="input-field col m12 s12">
							<div class="DetailTitle01">
								<i class="tiny material-icons">edit</i><span class>&nbsp;件數&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span><br> <label for="ddlpkgCount"></label>
							</div>
							<!-- 件數 -->
							<select class="browser-default" name="ddlpkgCount" id="ddlpkgCount">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						<div class="input-field col m12 s12">
							<!-- 預定取件日 -->
							<div class="DetailTitle01">
								<i class="tiny material-icons">edit</i><span>&nbsp;預定取件日&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span><br>
							</div>
							<select class="browser-default" name="ddlGetdate" id="ddlGetdate"></select>
						</div>
						<div class="input-field col m12 s12">
							<!-- 指定送達時段 -->
							<div class="DetailTitle01">
								<i class="tiny material-icons">edit</i><span>&nbsp;指定送達時段&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span><br>
							</div>
							<span id="chkTrimtime"> <input id="chkTrimtime_0" type="checkbox" name="chkTrimtime$0" checked> <label for="chkTrimtime_0">不指定</label> <input id="chkTrimtime_1" type="checkbox" name="chkTrimtime$1"> <label for="chkTrimtime_1">上午時段</label> <input id="chkTrimtime_2" type="checkbox" name="chkTrimtime$2"> <label for="chkTrimtime_2">12~17時</label> <input id="chkTrimtime_3" type="checkbox" name="chkTrimtime$3"> <label for="chkTrimtime_3">17~20時</label></span>
						</div>
						<div class="input-field col m12 s12">
							<!-- 貨件規格 -->
							<div class="DetailTitle01">
								<i class="tiny material-icons">edit</i><span>&nbsp;貨件規格&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span> <br>
							</div>
							<span id="chkSpec"> <input id="chkSpec_0" type="checkbox" name="chkSpec$0" checked> <label for="chkSpec_0">s60</label> <input id="chkSpec_1" type="checkbox" name="chkSpec$1"> <label for="chkSpec_1">s90</label> <input id="chkSpec_2" type="checkbox" name="chkSpec$2"> <label for="chkSpec_2">s120</label> <input id="chkSpec_3" type="checkbox" name="chkSpec$3"> <label for="chkSpec_3">s150</label><br> <br></span>
						</div>
						<div class="input-field col m12 s12">
							<!-- 內容物 -->

							<input class="required" required="required" autocomplete="off" type="text" id="txtPkgexp" name="txtPkgexp" maxlength="25"><label for="txtPkgexp" class="" id="textRightLable06"><i class="tiny material-icons">edit</i><span class="DetailTitle">&nbsp;內容物&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
							<div class="DetailTitle01">
								<i class="tiny material-icons">edit</i><span>&nbsp;內容物分類&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span> <br>
							</div>
							<!-- 內容物分類 -->
							<select class="browser-default" name="ddlPkgtype01" id="ddlPkgtype01">
								<option value="其他類">其他類</option>
								<option value="文件">文件</option>
								<option value="易碎物">易碎物</option>
								<option value="精密儀器">精密儀器</option>
								<option value="3c類">3c類</option>
								<option value="食品類">食品類</option>
							</select>
						</div>

					</div>
					<div class="col s12">
						<hr>
					</div>


					<!-- 宅配被隱藏 start -->

					<form action="/" id="postForm">
						<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" /> <input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" /> <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="" /> <input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="" /> <input id="chkAgree" type="checkbox" name="chkAgree" checked style="display: none;"> <input id="chkSame" type="checkbox" name="chkSame" style="display: none;">


						<div class="form-group">
							<label for="txtGtel"></label> <input name="txtGtel" type="text" maxlength="16" id="txtGtel" class="required">
						</div>
						<div class="form-group">
							<label for="txtGmobile"></label> <input name="txtGmobile" type="text" maxlength="10" id="txtGmobile" class="required">
						</div>

						<div class="form-group">
							<label for="txtPkgremark"></label> <input name="txtPkgremark" type="text" value="" maxlength="20" id="txtPkgremark" title="限制20個字內" readonly>
						</div>
						<div class="form-group">
							<!-- 			<label for="CAPTCHA">辨識碼：</label>  -->
							<input name="CAPTCHA" type="text" id="CAPTCHA" style="display: none;">
						</div>
						<div class="form-group">
							<!-- 			<label for="">辨識碼：</label>  -->
							<img id="captchaImage" name="captchaImage" title="驗證碼圖片" src="" style="display: none;">
							<textarea id="captchaField" style="display: none;"></textarea>
						</div>

						<script type="text/javascript">
							var imageString = document.getElementById("captchaField").innerHTML;
							document.getElementById("captchaImage").src = imageString;
						</script>

						<script type="text/javascript">
							$('#ddlArea').on("change", function() {
								$("#hidArea").val($("#ddlArea").find(":selected").text());
								$('#txtPostno').val($("#ddlArea").find(":selected").val());
							});

							$('#ddlArea1').on("change", function() {
								$("#hidArea1").val($("#ddlArea1").find(":selected").text());
								$('#txtPostno1').val($("#ddlArea1").find(":selected").val());
							});
						</script>
						<!-- 宅配被隱藏end -->
						<button type="button" id="page03Prev" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="上一步"><i class="small material-icons">keyboard_arrow_left</i></a>
						</button>

						<button type="button" id="page03Clean" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
						</button>

						<button type="submit" id="btnSend" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="確認送出"><i class="small material-icons">done</i></a>
						</button>
					</form>
					<div id="result"></div>
					<button type="button" id="page03Ok" class="btn btn-small btn-floating">
						<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
					</button>


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
									<td>上杉謙信</td>
									<td>warCraftIII@gmail.com</td>
									<td>022222222</td>
									<td>0919191919</td>
									<td><span id="resultShow">1122334455</span></td>
								</tr>
							</tbody>
						</table>
					</form>

					<br>
					<button type="button" id="page04ToPage01" class="btn btn-small btn-floating">
						<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="到捐獻背包"><i class="small material-icons">card_giftcard</i></a>
					</button>
					<button type="button" id="page04ToPage02" class="btn btn-small btn-floating">
						<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="到捐獻清單"><i class="small material-icons">list</i></a>
					</button>

				</div>


			</div>
		</div>
	</center>

	<!-- 宅配通 bottom start -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#postForm").validate({
				submitHandler : function(form) {
					var chkTrimtime = $("input[name^='chkTrimtime']:checked").attr("name");
					var chkSpec = $("input[name^='chkSpec']:checked").attr("name");
					var ckhSameResult;
					if ($("#chkSame").prop('checked') == true) {
						ckhSameResult = "on"
					} else {
						ckhSameResult = "off"
					}
					$.ajax({
						url : '../PostDonationServlet',
						type : 'post',
						data : {
							"__EVENTTARGET" : $("#__EVENTTARGET").val(),
							"__EVENTARGUMENT" : $("#__EVENTARGUMENT").val(),
							"__VIEWSTATE" : $("#__VIEWSTATE").val(),
							"__VIEWSTATEGENERATOR" : $("#__VIEWSTATEGENERATOR").val(),
							"ddlpkgCount" : $("#ddlpkgCount").find(":selected").val(),
							"ddlGetdate" : $("#ddlGetdate").val(),
							chkTrimtime : chkTrimtime,
							chkSpec : chkSpec,
							"txtOcname" : $("#txtOcname").val(),
							"ddlOcname_ex" : $("#ddlOcname_ex").val(),
							"ddlCity" : $("#ddlCity").val(),
							"ddlArea" : $("#ddlArea").val(),
							"hidArea" : $("#hidArea").val(),
							"txtPostno" : $("#txtPostno").val(),
							"txtOaddress" : $("#txtOaddress").val(),
							"txtOtel" : $("#txtOtel").val(),
							"txtOmobile" : $("#txtOmobile").val(),
							"txtOemail" : $("#txtOemail").val(),
							"chkSame" : ckhSameResult,
							"txtGcname" : $("#txtGcname").val(),
							"ddlGcname_ex" : $("#ddlGcname_ex").val(),
							"ddlCity1" : $("#ddlCity1").val(),
							"ddlArea1" : $("#ddlArea1").val(),
							"hidArea1" : $("#hidArea1").val(),
							"txtPostno1" : $("#txtPostno1").val(),
							"txtGaddress" : $("#txtGaddress").val(),
							"txtGtel" : $("#txtGtel").val(),
							"txtGmobile" : $("#txtGmobile").val(),
							"txtPkgexp" : $("#txtPkgexp").val(),
							"ddlPkgtype01" : $("#ddlPkgtype01").val(),
							"txtPkgremark" : $("#txtPkgremark").val(),
							"chkAgree" : "on",
							"CAPTCHA" : $("#CAPTCHA").val(),
							"btnSend" : $("#btnSend").val(),
							"cookies" : document.cookie
						},
						dataType : 'text',
						success : function(result) {
							$("#result").text(result);
						}
					});

				},
				errorPlacement : function(error, element) {
					element.closest('.form-group').append(error);
				},
				rules : {
					txtOcname : {
						checkname : true
					},
					ddlArea : {
						ddlCheck : true
					},
					txtOaddress : {
						addressCheck : true
					},
					txtOmobile : {
						mobileCheck : true
					},
					txtOemail : {
						emailCheck : true
					},
					txtGcname : {
						checkname : true
					},
					ddlArea1 : {
						ddlCheck : true
					},
					txtGaddress : {
						addressCheck : true
					},
					txtGmobile : {
						mobileCheck : true
					}
				}
			});
		});
	</script>
	<script type="text/javascript">
		try {
			var pageTracker = _gat._getTracker("UA-8688999-2");
			pageTracker._trackPageview();
		} catch (err) {
		}

		$.get("../PostGetAllServlet", function(responseJson) {
			console.log(responseJson.d[0].Memo);
			$("#txtPkgremark").val(responseJson.d[0].Memo);
		});

		$("#btnClean").on("click", function() {
			$.get("PostGetAllServlet", function(responseJson) {
				console.log(responseJson.d[0].Memo);
				$("#txtPkgremark").val(responseJson.d[0].Memo);
			});
		});
	</script>
	<!-- 宅配通 bottom start -->

	<!-- 等畫面跑完，在載入 js 檔 -->
	<script type="text/javascript" src="../donationScripts/SexSwitch.js"></script>
	<script type="text/javascript" src="../donationScripts/DonationBill.js"></script>

	<!-- 標頭專用 bottom start -->
	<!-- 必須最後載入才有效果 -->
	<script type="text/javascript" src="../donationScripts/DonationWallHead.js"></script>
	<!-- 標頭專用 bottom end -->

	<!-- 一鍵Demo -->
	<script type="text/javascript" src="../donationScripts/OneClickDemo.js"></script>


</body>
</html>
