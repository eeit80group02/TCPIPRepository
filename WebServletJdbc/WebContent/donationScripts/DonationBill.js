$(window).load(function() {
	$("#test1 #donationBill tbody .deleteRow button").dblclick(function() {
		$(this).parents('tr').remove();
		Materialize.toast('<i class="tiny material-icons">done</i>&nbsp;<span>成功移除一項物品</span>', 1800, 'rounded');
	});

	$("#test1 button[data-target='modalNote02']").one('mouseover', function() {
		// 第一頁的小叮嚀
		// 第一次移過去等同 click
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
		$(this).trigger($.Event("click"));
	});

	$("#test2 button[data-target='modalNote01']").one('mouseover', function() {
		// 第二頁的小叮嚀
		// 第一次移過去等同 click
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
		$(this).trigger($.Event("click"));
	});
	$("#test3 button[data-target='modalNote03']").one('mouseover', function() {
		// 第二頁的小叮嚀
		// 第一次移過去等同 click
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
		$(this).trigger($.Event("click"));
	});

	// 換頁系列 start
	var $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');

	$("#test1 #page01Next").click(function() {
		
		$("#pageTab02 a").trigger($.Event("click"));
		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});

	$("#test2 #page02Prev").click(function() {
		$("#pageTab01 a").trigger($.Event("click"));
		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	$("#test2 #page02Next").click(function() {
		$("#pageTab03 a").trigger($.Event("click"));
		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	$("#test3 #page03Prev").click(function() {
		$("#pageTab02 a").trigger($.Event("click"));
		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	$("#test3 #page03Next").click(function() {
		$("#pageTab04 a").trigger($.Event("click"));
		$body.animate({
			scrollTop : 0
		}, 600);
		return false;
	});
	// 換頁系列 end
}(jQuery));