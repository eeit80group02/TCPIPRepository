$(function() {

	var s1={
			cursor:pointer
			
	};
	
	$("*").click(function() {
		var pageTab01 = $("#pageTab01 a").attr("class");
		var pageTab02 = $("#pageTab02 a").attr("class");
		var pageTab03 = $("#pageTab03 a").attr("class");
		var pageTab04 = $("#pageTab04 a").attr("class");
		
		if(pageTab01=="active"){

			
		}		
		
		
		console.log("1="+pageTab01);
		console.log("2="+pageTab02);
		console.log("3="+pageTab03);
		console.log("4="+pageTab04);
	});

}(jQuery));