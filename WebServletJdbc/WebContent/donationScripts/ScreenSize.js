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

		var noneBag = 650;
		var smallBag = 880;
		var bigBag = 1180;
		var donationSmallBagWidth = "230px";
		var donationBigBagWidth = "460px";

		if (winWidth < noneBag) {
			// 小畫面
			$("#trash").css("display", "none");
			$("#gallery").css("max-width", "90%").css("padding-left", "5%").css("margin-left", "5%");
			$("#headMarquee").css("margin-right", "0px");

		} else if (winWidth >= noneBag && winWidth < smallBag) {
			// 中畫面
			$("#trash").css("display", "inline").css("width", donationSmallBagWidth).css("border-left", "5px solid #ff7575");
			$("#gallery").css("max-width", "70%").css("padding", "0px").css("margin-left", "0px");
			$("#headMarquee").css("margin-right", donationSmallBagWidth);
			$("#donateBagTitle").css("font-size", "0.8em");
		} else if (winWidth >= smallBag && winWidth < bigBag) {
			// 大畫面
			$("#trash").css("display", "inline").css("width", donationBigBagWidth).css("border-left", "5px solid #ff7575");
			$("#gallery").css("max-width", "58%").css("padding", "0px").css("margin-left", "0px");
			$("#headMarquee").css("margin-right", donationBigBagWidth);
			$("#donateBagTitle").css("font-size", "1.5em");
		} else {
			// 完整畫面
			
			$("#trash").css("display", "inline").css("width", donationBigBagWidth).css("border-left", "10px solid #ff7575");
			$("#gallery").css("max-width", "65%").css("padding", "0px").css("margin-left", "0px");
			$("#headMarquee").css("margin-right", donationBigBagWidth);
			$("#donateBagTitle").css("font-size", "1.5em");
		}

		var hideNavBar = 1100;
		if (winWidth >= hideNavBar) {
			$("#nav-mobile3").css("display", "inline");
		} else {
			$("#nav-mobile3").css("display", "none");
		}
	}
	findDimensions();
	window.onresize = findDimensions;
}(jQuery));
