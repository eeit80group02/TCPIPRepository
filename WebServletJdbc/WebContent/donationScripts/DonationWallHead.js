$(function() {
	// searchIcon
	$("#searchIcon").click(function() {
		// 按 searchIcon 搜尋
		var input = $("#searchDonation").val();
		if (input != null && input.trim().length != 0) {
			$("#searchDonation").val("" + input);
			// alert("按 Icon 搜尋 " + input);
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
				// alert("按Enter 搜尋 " + input);
			}
		}
	});

	$(".chooseItem").click(getPressValue);

	$(".chooseDropdownItem").click(getPressValue);

	function getPressValue() {
		var input = $(this).attr("value");
		// alert("以 " + input + " 排序");
	}

}(jQuery));