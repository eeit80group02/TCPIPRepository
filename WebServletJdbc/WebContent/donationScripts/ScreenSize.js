$(window).load(function() {
	var winWidth = 0;
	var winHeight = 0;
	function findDimensions() {
		// 取得瀏覽器畫面寬度
		if (window.innerWidth)
			winWidth = window.innerWidth;
		else if ((document.body) && (document.body.clientWidth))
			winWidth = document.body.clientWidth;
		// 取得瀏覽器畫面高度
		if (window.innerHeight)
			winHeight = window.innerHeight;
		else if ((document.body) && (document.body.clientHeight))
			winHeight = document.body.clientHeight;
		/* nasty hack to deal with doctype swith in IE */
		// 透過深入Document内部對body進行檢測，獲取窗口大小
		if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) {
			winHeight = document.documentElement.clientHeight;
			winWidth = document.documentElement.clientWidth;
		}
		// 结果输出至兩個文本框
		// document.form1.availHeight.value = winHeight;
		// document.form1.availWidth.value = winWidth;
		if (winWidth < 765) {
			// 小畫面
			$("#trash").css("display", "none");
			$("#gallery").css("max-width", "90%");
			$("#headMarquee").css("margin-right", "0px");

		} else if (winWidth >= 750 && winWidth < 1125) {
			// 中畫面
			$("#trash").css("display", "inline").css("width", "230px");
			$("#gallery").css("max-width", "80%");
			$("#headMarquee").css("margin-right", "220px");
			$("#donateBagTitle").css("font-size", "0.8em");
		} else {
			// 大畫面
			$("#trash").css("display", "inline").css("width", "450px");
			$("#gallery").css("max-width", "60%");
			$("#headMarquee").css("margin-right", "440px");
			$("#donateBagTitle").css("font-size", "1.5em");
		}
	}
	findDimensions();
	window.onresize = findDimensions;
}(jQuery));
