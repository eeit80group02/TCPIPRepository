$(function() {

	$("#QQQ").click(function() {
		$("#searchDonation").trigger($.Event.keyCode=13);
	});

	$("#searchForm").submit(function() {
		alert("你成功砂密特了");
	});

	// searchIcon
	$("#searchIcon").click(function() {
		// 按 searchIcon 搜尋
		var input = $("#searchDonation").val();
		if (input != null && input.trim().length != 0) {
			$("#searchDonation").val("" + input);
		}
	});

	// clearIcon
	$("#clearIcon").click(function() {
		// 按 clearIcon 清除
		$("#searchDonation").val("");

	});

	$("#searchDonation").keydown(function(evt) {
		// 按Enter 搜尋
		if (evt.keyCode == 13) {
			var input = $("#searchDonation").val();
			if (input != null && input.trim().length != 0) {
				$("#searchDonation").val("" + input);
			}
		}
	});

	$(".chooseItem").click(getPressValue);

	$(".chooseDropdownItem").click(getPressValue);

	function getPressValue() {
		var input = $(this).attr("value");
	}

}(jQuery));