$(window).load(function() {
	
	// 管理物資操作小叮嚀
	$("button[data-target='modalNote01']").one('mouseover', function() {
		// 第一次移過去等同 click
		$(this).trigger($.Event("click"));
		Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按 Esc 或 <i class="tiny material-icons">done</i> 關閉視窗</span>', 2000, 'rounded');
	});

}(jQuery));