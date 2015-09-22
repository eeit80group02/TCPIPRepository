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

		} else {
			count = 1;
		}
	});
}(jQuery));
