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
							</c:if>
						</c:if>
						<li class="divider"></li>
						<!-- 沒登入時，必須看到登入按鈕 -->
						<c:choose>
							<c:when test="${empty LoginOK}">
								<li><a href="#modal1" class="modal-trigger">登入</a></li>
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
						<li class="tab col s3 disabled" id="pageTab02"><a href="#test2" class="">填寫寄件人資料</a></li>
						<li class="tab col s3 disabled" id="pageTab03"><a href="#test3" class="">確認收件人資料</a></li>
						<li class="tab col s3 disabled" id="pageTab04"><a href="#test4" class="">完成步驟</a></li>
					</ul>
					<br>

				</div>

				<!-- 第一頁 -->
				<div id="test1" class="col s12">
					<div class="col s12">
						<div id="warnText">
							<span>確認捐獻物品明細</span>
							<!-- 小叮嚀 start -->
							<button type="button" data-target="modalNote02" class="btn btn-small btn-floating modal-trigger">
								<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
							</button>
							<!-- Modal Structure -->
							<div id="modalNote02" class="modal modal-fixed-footer">
								<div class="modal-content">
									<h4>小叮嚀：</h4>
									<ol>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">navigate_before</i></a>&nbsp;、&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">navigate_next</i></a>&nbsp;單擊左鍵，可對數量做加減，若按壓不放，可以加速數字變動。
										</li>
										<li>對著&nbsp;<a class="btn btn-tiny btn-floating"><i class="tiny material-icons">delete</i></a>&nbsp;雙擊左鍵，即可移除捐獻物品。
										</li>
									</ol>
								</div>
								<div class="modal-footer">
									<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
								</div>
							</div>
							<!-- 小叮嚀 end -->

						</div>
						<br>
					</div>

					<form action="">
						<table id="donationBill" class="responsive-table">
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
										<td>${item.value.schoolName}<br> <br>屏東縣鹽埔鄉鹽南村勝利路30號
										</td>
										<td>${item.value.supplyStatus}</td>
										<td style="word-break: break-all;"><div id="remark" class="remark">${item.value.demandContent}</div></td>

										<td>
											<button type="button" id="buttonSub${vs.index}" class="btn btn-small btn-floating">
												<i class="small material-icons">navigate_before</i>
											</button> <input type="text" id="text${vs.index}" value="1" autocomplete="off" class="textNeed"> <label for="text" id="textUnit" class="textUnit">${item.value.originalDemandUnit}</label>
											<button type="button" id="buttonAdd${vs.index}" class="btn btn-small btn-floating">
												<i class="small material-icons">navigate_next</i>
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
														Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800, 'rounded');
														$("#text${vs.index}").val("1");
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
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="捐獻牆"><i class="small material-icons">favorite</i></a>
						</button>
						<button type="button" id="page01Mid" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
						</button>
						<button type="submit" id="page01Next" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
						</button>
					</form>
					<br>
				</div>

				<!-- 第二頁 -->
				<div id="test2" class="col s12">
					<form id="xxx" action="#">
						<div class="row">
							<div class="col s12">
								<div id="warnText">
									<span class="redStar"><i class="tiny material-icons">star</i></span>&nbsp;<span>本頁皆為必填欄位</span>
									<!-- 宅配小叮嚀 start -->
									<button type="button" data-target="modalNote01" class="btn btn-small btn-floating modal-trigger">
										<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
									</button>
									<!-- Modal Structure -->
									<div id="modalNote01" class="modal modal-fixed-footer">
										<div class="modal-content">
											<h4>宅配小叮嚀：</h4>
											<ol type="A">
												<li>常溫貨件規格：長+寬+高≦150公分(含)以下。</li>
												<li>貨件重量：限20公斤(含)以下。</li>
												<li>超過交件時間配送時效順延一天。</li>
												<li>以下區域恕不提供宅配通貨件配送服務。</li>
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
									<input type="text" id="textLeft01" disabled value='${LoginOK.lastName}${LoginOK.firstName}'><label for="textLeft01"><i class="tiny material-icons">account_circle</i><span class="DetailTitle">&nbsp;會員姓名&nbsp;</span></label>
								</div>

								<div class="switch">
									<br> <label><span id="Male">先生</span><input checked type="checkbox" id="checkboxLeft" disabled="disabled"> <span class="lever"></span><span id="Female">小姐</span> </label> <br>
								</div>
								<br> <select class="browser-default" id="addressLeft01" name="address01" disabled="disabled">
									<option value="${LoginOK.address}">${LoginOK.address}</option>
								</select> <select class="browser-default" id="addressLeft02" name="address02" disabled="disabled">
									<option value="礁溪鄉">礁溪鄉</option>
								</select><br> <br> <br>
								<div class="input-field col m12 s12">
									<input type="text" id="textLeft02" disabled value="${LoginOK.address}"><label for="textLeft02"><i class="tiny material-icons">location_city</i><span class="DetailTitle">&nbsp;地址&nbsp;</span></label>
								</div>

								<div class="input-field col m12 s12">
									<input type="text" id="textLeft03" disabled value="${LoginOK.phone}"><label for="textLeft03"><i class="tiny material-icons">phone</i><span class="DetailTitle">&nbsp;電話&nbsp;</span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="textLeft04" disabled value="${LoginOK.cellPhone}"><label for="textLeft04"><i class="tiny material-icons">smartphone</i><span class="DetailTitle">&nbsp;手機&nbsp;</span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="textLeft05" disabled value="${LoginOK.email}"><label for="textLeft05"><i class="tiny material-icons">mail</i><span class="DetailTitle">&nbsp;E-mail&nbsp;</span></label>
								</div>
							</div>
							<div class="col s12 m12 l6">
								<br>
								<div class="rightTitle">
									<button type="button" id="buttonRight01" class="btn btn-small btn-floating">
										<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="將會員資料同步到寄件人資料"><i class="small material-icons">autorenew</i></a>
									</button>
									&nbsp;填寫寄件人資料

								</div>
								<br>
								<!-- 右上 -->
								<div class="input-field col m12 s12">
									<input type="text" id="textRight01" required="required" autofocus="autofocus" autocomplete="off"><label for="textRight01" class="" id="textRightLable01"><i class="tiny material-icons">account_circle</i><span class="DetailTitle">&nbsp;姓名&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
								</div>

								<div class="switch">
									<br> <label><span id="Male">先生</span><input checked type="checkbox" id="checkboxRight"> <span class="lever"></span><span id="Female">小姐</span> </label> <br>
								</div>
								<br> <select class="browser-default" id="addressRight01" name="address01">
									<option value="台南縣">台南縣</option>
									<option value="宜蘭縣">宜蘭縣</option>
								</select> <select class="browser-default" id="addressRight02" name="address02">
									<option value="白河區">白河區</option>
									<option value="礁溪鄉">礁溪鄉</option>
								</select> <br> <br> <br>
								<div class="input-field col m12 s12">
									<input type="text" id="textRight02" required="required" autofocus="autofocus" autocomplete="off"><label for="textRight02" class="" id="textRightLable02"><i class="tiny material-icons">location_city</i><span class="DetailTitle">&nbsp;地址&nbsp;<span class="glyphicon glyphicon-info-sign" id="infoForDonate"></span>&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="textRight03" required="required" autofocus="autofocus" autocomplete="off"><label for="textRight03" class="" id="textRightLable03"><i class="tiny material-icons">phone</i><span class="DetailTitle">&nbsp;電話&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="text" id="textRight04" required="required" autofocus="autofocus" autocomplete="off"><label for="textRight04" class="" id="textRightLable04"><i class="tiny material-icons">smartphone</i><span class="DetailTitle">&nbsp;手機&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></label>
								</div>
								<div class="input-field col m12 s12">
									<input type="email" id="textRight05" required="required" autofocus="autofocus" autocomplete="off"><label for="textRight05" class="" id="textRightLable05"><i class="tiny material-icons">mail</i><span class="DetailTitle">&nbsp;E-mail&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></label>
								</div>
							</div>
						</div>
						<button type="button" id="page02Prev" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="上一步"><i class="small material-icons">keyboard_arrow_left</i></a>
						</button>

						<button type="button" id="page02Mid" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="清除"><i class="small material-icons">clear</i></a>
						</button>

						<button type="submit" id="page02Next" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
						</button>
					</form>
				</div>

				<!-- 第三頁 -->
				<div id="test3" class="col s12">

					<div class="col s12">
						<div id="warnText">
							<span class="redStar"><i class="tiny material-icons">star</i></span>&nbsp;<span>本頁皆為必填欄位</span>
							<!-- 運費小叮嚀 start -->
							<button type="button" data-target="modalNote03" class="btn btn-small btn-floating modal-trigger">
								<a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="小叮嚀"><i class="small material-icons">local_library</i></a>
							</button>
							<!-- Modal Structure -->
							<div id="modalNote03" class="modal modal-fixed-footer">
								<div class="modal-content">
									<h4>運費小叮嚀：</h4>
									<table id="normalMoney">
										<tr>
											<td>規格</td>
											<td>s60</td>
											<td>s90</td>
											<td>s120</td>
											<td>s150</td>
										</tr>
										<tr>
											<td>尺寸</td>
											<td>60公分(含)以下</td>
											<td>61 cm~90cm</td>
											<td>91 cm~120cm</td>
											<td>121cm~150cm</td>
										</tr>
										<tr>
											<td>本島</td>
											<td>110元</td>
											<td>150元</td>
											<td>190元</td>
											<td>230元</td>
										</tr>
										<tr>
											<td>金門、澎湖</td>
											<td>220元</td>
											<td>280元</td>
											<td>320元</td>
											<td>360元</td>
										</tr>
									</table>
									<ol>
										<li>常溫貨件規格：長+寬+高≦150公分(含)以下。</li>
										<li>貨件重量：限20公斤(含)以下。</li>
									</ol>
								</div>

								<div class="modal-footer">
									<a href="#!" class=" modal-action modal-close btn btn-tiny btn-floating"><i class="tiny material-icons">check</i></a>
								</div>
							</div>
							<!-- 運費小叮嚀 end -->
						</div>
						<br>
					</div>

					<form action="">
						<table id="donationBillStep03" class="responsive-table">
							<thead>
								<tr>
									<td>受捐獻單位</td>
									<td>單位負責人</td>
									<td>詳細內容</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><span class="schoolName"><b>礁溪國小</b></span><br> <select class="browser-default" id="address01" disabled="disabled">
											<option value="宜蘭縣">宜蘭縣</option>
									</select> <select class="browser-default" id="address02" disabled="disabled">
											<option value="礁溪鄉">礁溪鄉</option>
									</select><br> <br>大忠村礁溪路四段 135 號</td>
									<td>本多忠勝</td>
									<td>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="單位正常開放日期"><i class="tiny material-icons">today</i>&nbsp;預定取件日&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<!-- 出現7天 -->
											<select class="browser-default" id="page03Select01">
												<option value="2015-09-22">2015-09-22</option>
												<option value="2015-09-23">2015-09-23</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="單位正常開放時間"><i class="tiny material-icons">access_time</i>&nbsp;指定送達時段&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select02">
												<option value="不指定">不指定</option>
												<option value="上午時段">上午時段</option>
												<option value="12~17時">12~17時</option>
												<option value="17~20時">17~20時</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="常溫貨件規格計算方式(長+寬+高之三邊總和)"><i class="tiny material-icons">photo_size_select_small</i>&nbsp;貨件規格&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select03">
												<option value="s60">s60</option>
												<option value="s90">s90</option>
												<option value="s120">s120</option>
												<option value="s150">s150</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="捐獻物資類型"><i class="tiny material-icons">shopping_basket</i>&nbsp;內容物&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select04">
												<option value="其他類">其他類</option>
												<option value="文件">文件</option>
												<option value="易碎物">易碎物</option>
												<option value="精密儀器">精密儀器</option>
												<option value="3c類">3c類</option>
												<option value="食品類">食品類</option>
											</select>
										</div>

									</td>
								</tr>
								<tr>
									<td><span class="schoolName"><b>桃園市大溪區內柵國民小學</b></span><br> <select class="browser-default" id="address01" disabled="disabled">
											<option value="桃園市">桃園市</option>
									</select> <select class="browser-default" id="address02" disabled="disabled">
											<option value="大溪鎮">大溪鎮</option>
									</select><br> <br>義和里安和路38號</td>
									<td>織田信長</td>
									<td>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="單位正常開放日期"><i class="tiny material-icons">today</i>&nbsp;預定取件日&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<!-- 出現7天 -->
											<select class="browser-default" id="page03Select01">
												<option value="2015-09-22">2015-09-22</option>
												<option value="2015-09-23">2015-09-23</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="單位正常開放時間"><i class="tiny material-icons">access_time</i>&nbsp;指定送達時段&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select02">
												<option value="不指定">不指定</option>
												<option value="上午時段">上午時段</option>
												<option value="12~17時">12~17時</option>
												<option value="17~20時">17~20時</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="常溫貨件規格計算方式(長+寬+高之三邊總和)"><i class="tiny material-icons">photo_size_select_small</i>&nbsp;貨件規格&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select03">
												<option value="s60">s60</option>
												<option value="s90">s90</option>
												<option value="s120">s120</option>
												<option value="s150">s150</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="捐獻物資類型"><i class="tiny material-icons">shopping_basket</i>&nbsp;內容物&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select04">
												<option value="其他類">其他類</option>
												<option value="文件">文件</option>
												<option value="易碎物">易碎物</option>
												<option value="精密儀器">精密儀器</option>
												<option value="3c類">3c類</option>
												<option value="食品類">食品類</option>
											</select>
										</div>

									</td>
								</tr>
								<tr>
									<td><span class="schoolName"><b>台南市白河區白河國小</b></span><br> <select class="browser-default" id="address01" disabled="disabled">
											<option value="台南市">台南市</option>
									</select> <select class="browser-default" id="address02" disabled="disabled">
											<option value="白河區">白河區</option>
									</select><br> <br>永安里三民路448號</td>
									<td>淺井長政</td>
									<td>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="單位正常開放日期"><i class="tiny material-icons">today</i>&nbsp;預定取件日&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<!-- 出現7天 -->
											<select class="browser-default" id="page03Select01">
												<option value="2015-09-22">2015-09-22</option>
												<option value="2015-09-23">2015-09-23</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
												<option value="2015-09-24">2015-09-24</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="單位正常開放時間"><i class="tiny material-icons">access_time</i>&nbsp;指定送達時段&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select02">
												<option value="不指定">不指定</option>
												<option value="上午時段">上午時段</option>
												<option value="12~17時">12~17時</option>
												<option value="17~20時">17~20時</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="常溫貨件規格計算方式(長+寬+高之三邊總和)"><i class="tiny material-icons">photo_size_select_small</i>&nbsp;貨件規格&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select03">
												<option value="s60">s60</option>
												<option value="s90">s90</option>
												<option value="s120">s120</option>
												<option value="s150">s150</option>
											</select>
										</div>
										<div class="input-field col s12">
											<div class="page03SelectTitle">
												<a class="text tooltipped" data-position="left" data-delay="20" data-tooltip="捐獻物資類型"><i class="tiny material-icons">shopping_basket</i>&nbsp;內容物&nbsp;<span class="redStar"><i class="tiny material-icons">star</i></span></a>
											</div>
											<select class="browser-default" id="page03Select04">
												<option value="其他類">其他類</option>
												<option value="文件">文件</option>
												<option value="易碎物">易碎物</option>
												<option value="精密儀器">精密儀器</option>
												<option value="3c類">3c類</option>
												<option value="食品類">食品類</option>
											</select>
										</div>

									</td>
								</tr>
							</tbody>
						</table>
						<br>

						<button type="button" id="page03Prev" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="上一步"><i class="small material-icons">keyboard_arrow_left</i></a>
						</button>
						<button type="submit" id="page03Next" class="btn btn-small btn-floating">
							<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="下一步"><i class="small material-icons">keyboard_arrow_right</i></a>
						</button>
					</form>



				</div>

				<!-- 第四頁 -->
				<div id="test4" class="col s12">

					<button type="button" id="page04Next" class="btn btn-small btn-floating">
						<a class="text tooltipped" data-position="top" data-delay="20" data-tooltip="查詢捐獻狀態"><i class="small material-icons">search</i></a>
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

	<!-- 檢查是否被刪除 -->
	<script type="text/javascript">
		$("#page01Mid").click(function() {
			var qqq = $("#donationBill tr:eq(1) ").attr("style");
			alert(qqq);
		});
	</script>

	<!-- 訂單送出 -->
	<form action='<c:url value="checkOrder.do?linkto=checkBooking"/>' method='POST' target='#drop-a-line'>
		<input type='submit' name='fillOrder' value='booking' id='booking'>
	</form>

	<c:forEach var='item' items='${DonationCart.content}' varStatus='vs'>
		<form action='<c:url value="checkOrder.do?linkto=checkBooking"/>' method='POST'>
			<script type="text/javascript">
				(function($) {
					$("#page01Next").click(function() {
						var kk = $('#donationBill tr:eq("${vs.index+1}")').attr("style");
						if (!kk) {
							var donationId = "${item.value.donationId}";
							var donateAmount = $("#text${vs.index}").val();

							xhr = new XMLHttpRequest();
							if (xhr != null) {
								xhr.addEventListener("readystatechange", function(donateAmount) {
									if (xhr.readyState == 4) {
										if (xhr.status == 200) {
											lists = xhr.responseText;
										} else {
											alert("something is wrong!");
										}
									}
								});
								xhr.open("POST", "cart.do", true);
								xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
								xhr.send("toCart=update&donationId=" + "${item.value.donationId}" + "&donateAmount=" + donateAmount);
							}
						}
					});
				}(jQuery));
			</script>
		</form>
	</c:forEach>

</body>
</html>