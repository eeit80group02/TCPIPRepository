(function($) {
	$("#OneClick").click(function() {

		// 寄件人(會員方)
		$("#txtOcname").val("簡小文");
		$("#txtOaddress").val("臺北市大安區復興南路一段");
		$("#txtOtel").val("02020202");
		$("#txtOmobile").val("0909090909");
		$("#txtOemail").val("dora@gmail.com");

		// 收件人(學校方)
		$("#txtGtel").val("02040204");
		$("#txtGmobile").val("0902022022");
		$("#txtPkgexp").val("雜物");

		$("#test3 #textRightLable01").attr("class", "active");
		$("#test3 #textRightLable02").attr("class", "active");
		$("#test3 #textRightLable03").attr("class", "active");
		$("#test3 #textRightLable04").attr("class", "active");
		$("#test3 #textRightLable05").attr("class", "active");
		$("#test3 #textRightLable06").attr("class", "active");

	});
}(jQuery));