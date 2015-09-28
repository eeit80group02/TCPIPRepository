(function($) {
	// InsertDonateGoods
	$("#OneClickInsertDonateGoods").click(function() {
		$("#supplyName").val("2B 鉛筆/自動筆");
		$("#originalDemandNumber").val("80");
		$("#originalDemandUnit").val("枝");
		$("#size").val("筆芯 0.5 mm");
		$("#demandContent").val("作為獎品給學生，或提供給弱勢家庭的孩童");
		$("#remark").val("盡量在學校正常開放時間寄送");

		$("#textLable01").attr("class", "active");
		$("#textLable02").attr("class", "active");
		$("#textLable03").attr("class", "active");
		$("#textLable04").attr("class", "active");
		$("#textLable05").attr("class", "active");
		$("#textLable06").attr("class", "active");

	});

	// DonationBillFinal
	$("#OneClickDonationBillFinal").click(function() {
		// 寄件人(會員方)
		$("#txtOcname").val("簡小文");
		$("#txtOaddress").val("臺北市大安區復興南路一段");
		$("#txtOtel").val("02020202");
		$("#txtOmobile").val("0909090909");
		$("#txtOemail").val("dora@gmail.com");

		// 收件人(學校方)
		$("#txtGtel").val("02040204");
		$("#txtGmobile").val("0902022022");
		$("#txtPkgexp").val("跳繩和墊板");

		$("#test2 #textRightLable01").attr("class", "active");
		$("#test2 #textRightLable02").attr("class", "active");
		$("#test2 #textRightLable03").attr("class", "active");
		$("#test2 #textRightLable04").attr("class", "active");
		$("#test2 #textRightLable05").attr("class", "active");
		$("#test2 #textRightLable06").attr("class", "active");

	});

	// OneDemandByMember
	$("#OneClickOneDemandByMember").click(function() {
		$("#your-message").val("請問哪個時間方便收件呢？");
		$("#sayBoardText").attr("class", "active");
	});

}(jQuery));