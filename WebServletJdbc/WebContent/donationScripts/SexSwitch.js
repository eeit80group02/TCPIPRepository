<<<<<<< HEAD
$(window).load(function() {

	var count = 0;
	var male = "先生";
	var female = "小姐";

	$(".switch input[id='checkboxRight']").click(function() {
		count++;
		 console.log(count);
		 if (count % 2 == 0) {
		 console.log(female);
		 } else {
		 console.log(male);
		 }
	});

	$("#page02Mid").click(function() {
		if (count % 2 == 0) {
			count = 0;
			// 最後取值的地方
//			alert(female);

		} else {
			count = 1;
			// 最後取值的地方
//			alert(male);
		}
	});
}(jQuery));
=======
$(window).load(function() {

	var count = 0;
	var male = "先生";
	var female = "小姐";

	$(".switch input[id='checkboxRight']").click(function() {
		count++;
		 console.log(count);
		 if (count % 2 == 0) {
		 console.log(female);
		 } else {
		 console.log(male);
		 }
	});

	$("#page02Mid").click(function() {
		if (count % 2 == 0) {
			count = 0;
			// 最後取值的地方
//			alert(female);

		} else {
			count = 1;
			// 最後取值的地方
//			alert(male);
		}
	});
}(jQuery));
>>>>>>> branch 'master' of https://github.com/eeit80group02/TCPIPRepository.git
