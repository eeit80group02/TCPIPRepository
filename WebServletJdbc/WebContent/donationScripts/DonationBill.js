$(window).load(function() {

	// 雙擊左鍵刪除一整列
	$("#test1 #donationBill tbody .deleteRow button").dblclick(function() {
		$(this).parents('tr').css("display","none");
		Materialize.toast('<i class="tiny material-icons">done</i>&nbsp;<span>成功移除一項物品</span>', 1800, 'rounded');
	});

	// 第一頁的小叮嚀
	$("#test1 button[data-target='modalNote02']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});

	// 第二頁的小叮嚀
	$("#test2 button[data-target='modalNote01']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});
	// 第三頁的小叮嚀
	$("#test3 button[data-target='modalNote03']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});

	// 換頁系列 start
	var $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');

	$("#test1 #page01Next").click(function() {
		// 開二
		$(".tabs li[id=pageTab02]").attr("class", "tab col s3");
		$("#pageTab02 a").trigger($.Event("click"));
		// 關一
		$(".tabs li[id=pageTab01]").attr("class", "tab col s3 disabled");

		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});

	$("#test2 #page02Prev").click(function() {
		// 開一
		$(".tabs li[id=pageTab01]").attr("class", "tab col s3");
		$("#pageTab01 a").trigger($.Event("click"));
		// 關二
		$(".tabs li[id=pageTab02]").attr("class", "tab col s3 disabled");

		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	$("#test2 #page02Next").click(function() {
		// 開三
		$(".tabs li[id=pageTab03]").attr("class", "tab col s3");
		$("#pageTab03 a").trigger($.Event("click"));

		$(".tabs li[id=pageTab02]").attr("class", "tab col s3 disabled");
		// 關二
		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	$("#test3 #page03Prev").click(function() {
		// 開二
		$(".tabs li[id=pageTab02]").attr("class", "tab col s3");
		$("#pageTab02 a").trigger($.Event("click"));
		// 關三
		$(".tabs li[id=pageTab03]").attr("class", "tab col s3 disabled");

		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	$("#test3 #page03Next").click(function() {
		// 開四
		$(".tabs li[id=pageTab04]").attr("class", "tab col s3");
		$("#pageTab04 a").trigger($.Event("click"));
		// 關三
		$(".tabs li[id=pageTab03]").attr("class", "tab col s3 disabled");

		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	// 換頁系列 end

	// 同步會員資料
	$("#test2 #buttonRight01").click(function() {
		var textLeft01 = $("#test2 input[id='textLeft01']").val();
		var textLeft02 = $("#test2 input[id='textLeft02']").val();
		var textLeft03 = $("#test2 input[id='textLeft03']").val();
		var textLeft04 = $("#test2 input[id='textLeft04']").val();
		var textLeft05 = $("#test2 input[id='textLeft05']").val();

		$("#test2 input[id='textRight01']").val(textLeft01);
		$("#test2 input[id='textRight02']").val(textLeft02);
		$("#test2 input[id='textRight03']").val(textLeft03);
		$("#test2 input[id='textRight04']").val(textLeft04);
		$("#test2 input[id='textRight05']").val(textLeft05);

		$("#test2 #textRightLable01").attr("class", "active");
		$("#test2 #textRightLable02").attr("class", "active");
		$("#test2 #textRightLable03").attr("class", "active");
		$("#test2 #textRightLable04").attr("class", "active");
		$("#test2 #textRightLable05").attr("class", "active");

		var addressLeft01 = $("#test2 #addressLeft01").val();
		var addressLeft02 = $("#test2 #addressLeft02").val();

		$("#test2 #addressRight01").val(addressLeft01);
		$("#test2 #addressRight02").val(addressLeft02);

		Materialize.toast('<i class="tiny material-icons">done</i>&nbsp;<span>已同步資料</span>', 1800, 'rounded');
	});
	
}(jQuery));