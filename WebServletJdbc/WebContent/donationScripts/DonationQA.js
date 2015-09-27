$(function() {
	$("#addItem").click(function() {
		Materialize.toast('<i class="tiny material-icons">check_circle</i>&nbsp;<span>加入一項物資</span>', 1800, 'rounded');
	});
	$("#send-message").click(function() {
		$("#drop-a-line").css("display", "none");
	});
}(jQuery));