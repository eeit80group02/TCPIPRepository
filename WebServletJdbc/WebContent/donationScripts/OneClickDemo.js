(function($) {
	// InsertDonateGoods
	$("#OneClickInsertDonateGoods").click(function() {
		$("#supplyName").val("果皮刨刀");
		$("#originalDemandNumber").val("6");
		$("#originalDemandUnit").val("支");
		$("#size").val("寬口握把式");
		$("#demandContent").val("學校烹飪課上課用");
		$("#remark").val("衛生、乾淨為主，盡量在學校正常開放時間寄送");

		$("#textLable01").attr("class", "active");
		$("#textLable02").attr("class", "active");
		$("#textLable03").attr("class", "active");
		$("#textLable04").attr("class", "active");
		$("#textLable05").attr("class", "active");
		$("#textLable06").attr("class", "active");

	});

	// DonationBillFinal
	$("#txtGtel").val("0266318168");
	$("#txtGmobile").val("0911223344");
	$("#OneClickDonationBillFinal").click(function() {
		// 寄件人(會員方)
		$("#txtOcname").val("簡建文");
		$("#txtOaddress").val("台北市大安區信義路四段32號");
		$("#txtOtel").val("022540395");
		$("#txtOmobile").val("0987820258");
		$("#txtOemail").val("eeit8031@gmail.com");

		// 收件人(學校方)

		$("#txtPkgexp").val("搬運請小心！");
		$("#test2 #textRightLable01").attr("class", "active");
		$("#test2 #textRightLable02").attr("class", "active");
		$("#test2 #textRightLable03").attr("class", "active");
		$("#test2 #textRightLable04").attr("class", "active");
		$("#test2 #textRightLable05").attr("class", "active");
		$("#test2 #textRightLable06").attr("class", "active");

	});

	// OneDemandByMember
	$("#OneClickOneDemandByMember").click(function() {
		$("#your-message").val("一定用用白色的紙嗎？如果手邊有其他顏色的話可以接受嗎？");
		$("#sayBoardText").attr("class", "active");
	});
}(jQuery));