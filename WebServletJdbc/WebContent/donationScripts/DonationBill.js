$(window).load(function() {

	// 雙擊左鍵刪除一整列
	$("#test1 #donationBill01 tbody .deleteRow button").dblclick(deleteTableRow);
	$("#test2 #donationBill02 tbody .deleteRow button").dblclick(deleteTableRow);

	function deleteTableRow() {
		$(this).parents('tr').css("display", "none");
		Materialize.toast('<i class="tiny material-icons">check_circle</i>&nbsp;<span>移除成功</span>', 1800, 'rounded');
	}

	// 第一頁的小叮嚀
	$("#test1 button[data-target='modalNote01']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});

	// 第二頁的小叮嚀
	$("#test2 button[data-target='modalNote02']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});
	// 第三頁的小叮嚀
	$("#bodyContent button[data-target='modalNote03']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});

	// 換頁系列 start
	// var $body = (window.opera) ? (document.compatMode == "CSS1Compat" ?
	// $('html') : $('body')) : $('html,body');
	//
	// $("#test1 #page01Next").click(function() {
	// // 開二
	// $(".tabs li[id=pageTab02]").attr("class", "tab col s3");
	// $("#pageTab02 a").trigger($.Event("click"));
	// // 關一
	// $(".tabs li[id=pageTab01]").attr("class", "tab col s3 disabled");
	//
	// $body.animate({
	// scrollTop : 0
	// }, 600);
	// return false;
	// });
	//
	// $("#test2 #page02Prev").click(function() {
	// // 開一
	// $(".tabs li[id=pageTab01]").attr("class", "tab col s3");
	// $("#pageTab01 a").trigger($.Event("click"));
	// // 關二
	// $(".tabs li[id=pageTab02]").attr("class", "tab col s3 disabled");
	//
	// $body.animate({
	// scrollTop : 0
	// }, 600);
	// return false;
	// });
	// $("#test2 #page02Next").click(function() {
	// // 開三
	// $(".tabs li[id=pageTab03]").attr("class", "tab col s3");
	// $("#pageTab03 a").trigger($.Event("click"));
	//
	// $(".tabs li[id=pageTab02]").attr("class", "tab col s3 disabled");
	// // 關二
	// $body.animate({
	// scrollTop : 0
	// }, 600);
	// return false;
	// });
	// $("#test3 #page03Prev").click(function() {
	// // 開二
	// $(".tabs li[id=pageTab02]").attr("class", "tab col s3");
	// $("#pageTab02 a").trigger($.Event("click"));
	// // 關三
	// $(".tabs li[id=pageTab03]").attr("class", "tab col s3 disabled");
	//
	// $body.animate({
	// scrollTop : 0
	// }, 600);
	// return false;
	// });
	// $("#test3 #btnSend").click(function() {
	// // 開四
	// $(".tabs li[id=pageTab04]").attr("class", "tab col s3");
	// $("#pageTab04 a").trigger($.Event("click"));
	// // 關三
	// $(".tabs li[id=pageTab03]").attr("class", "tab col s3 disabled");
	//
	// $body.animate({
	// scrollTop : 0
	// }, 600);
	// return false;
	// });
	// 換頁系列 end

	// 同步會員資料
	$("#test2 #buttonRight01").click(function() {
		var textLeft01 = $("#test2 input[id='textLeft01']").val();
		var textLeft02 = $("#test2 input[id='textLeft02']").val();
		var textLeft03 = $("#test2 input[id='textLeft03']").val();
		var textLeft04 = $("#test2 input[id='textLeft04']").val();
		var textLeft05 = $("#test2 input[id='textLeft05']").val();

		$("#test2 input[id='txtOcname']").val(textLeft01);
		$("#test2 input[id='txtOaddress']").val(textLeft02);
		$("#test2 input[id='txtOtel']").val(textLeft03);
		$("#test2 input[id='txtOmobile']").val(textLeft04);
		$("#test2 input[id='txtOemail']").val(textLeft05);

		$("#test2 #textRightLable01").attr("class", "active");
		$("#test2 #textRightLable02").attr("class", "active");
		$("#test2 #textRightLable03").attr("class", "active");
		$("#test2 #textRightLable04").attr("class", "active");
		$("#test2 #textRightLable05").attr("class", "active");

		Materialize.toast('<i class="tiny material-icons">check_circle</i>&nbsp;<span>已同步資料</span>', 1800, 'rounded');
	});

	// 第二頁輸入資料判斷
	$("#test2 input[id='txtOcname']").blur(checkTxtOcname);

	function checkTxtOcname() {
		// 名字判斷
		var txtOcname = $("#test2 input[id='txtOcname']").val();
		if (/^[a-zA-Z\u4e00-\u9fa5]{2,15}$/.test(txtOcname)) {
		} else {
			Materialize.toast('<i class="tiny material-icons">info</i>&nbsp;<span>姓名格式錯誤</span>', 1800, 'rounded');
		}
	}

	$("#test2 input[id='txtOaddress']").blur(checkTxtOaddress);

	function checkTxtOaddress() {
		// 地址判斷
		var txtOaddress = $("#test2 input[id='txtOaddress']").val();
		if (/^[\u4e00-\u9fa5]/.test(txtOaddress) && /[a-zA-Z0-9\u4e00-\u9fa5].{3,25}$/.test(txtOaddress)) {
		} else {
			Materialize.toast('<i class="tiny material-icons">info</i>&nbsp;<span>地址格式錯誤</span>', 1800, 'rounded');
		}
	}

	$("#test2 input[id='txtOtel']").blur(checkTxtOtel).keyup(checkTxtOtelKey).keydown(checkTxtOtelKey);

	function checkTxtOtel() {
		// 電話判斷
		var txtOtel = $("#test2 input[id='txtOtel']").val();

		if (/^[0-9\-\ \#\.\(\)].{5,12}/.test(txtOtel) && /^[0-9]/.test(txtOtel)) {
		} else {
			Materialize.toast('<i class="tiny material-icons">info</i>&nbsp;<span>電話格式錯誤</span>', 1800, 'rounded');
		}
	}

	function checkTxtOtelKey() {
		// 電話判斷變空白
		var checkTxtOtelKey = $("#test2 input[id='txtOtel']").val();
		if (/[a-z]/.test(checkTxtOtelKey) || /[\u4e00-\u9fa5]/.test(checkTxtOtelKey)) {
			$("#test2 input[id='txtOtel']").val(checkTxtOtelKey.substring(0, checkTxtOtelKey.length - 1));
		}
	}

	$("#test2 input[id='txtOmobile']").blur(checkTxtOmobile).keyup(checkTxtOmobileKey).keydown(checkTxtOmobileKey);
	function checkTxtOmobile() {
		// 手機判斷
		var checkTxtOmobile = $("#test2 input[id='txtOmobile']").val();

		if (/^09/.test(checkTxtOmobile) && /^[0-9]{10}$/.test(checkTxtOmobile)) {
		} else {
			Materialize.toast('<i class="tiny material-icons">info</i>&nbsp;<span>手機格式錯誤</span>', 1800, 'rounded');
		}
	}
	function checkTxtOmobileKey() {
		// 手機判斷變空白
		var checkTxtOmobile = $("#test2 input[id='txtOmobile']").val();

		if (isNaN(checkTxtOmobile)) {
			$("#test2 input[id='txtOmobile']").val(checkTxtOmobile.substring(0, checkTxtOmobile.length - 1));
		}
	}

	$("#test2 input[id='txtOemail']").blur(checkTxtOemail);
	function checkTxtOemail() {
		// E-mail判斷
		var checkTxtOemail = $("#test2 input[id='txtOemail']").val();

		if (/^[a-zA-Z0-9._-]+@([a-zA-Z0-9.-]+\.)+[a-zA-Z0-9.-]{2,4}$/.test(checkTxtOemail)) {
		} else {
			Materialize.toast('<i class="tiny material-icons">info</i>&nbsp;<span>E-mail 格式錯誤</span>', 1800, 'rounded');
		}
	}

//	$("#page02Next").css("display", "none");
	$("#btnSend").click(function() {
//		$(this).css("display", "none");
		$("#page02Next").css("display", "inline");
	});

}(jQuery));