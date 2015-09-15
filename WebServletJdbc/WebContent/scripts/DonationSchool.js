$(function() {

	$(":required").blur(function() {
		if ($(this).val() == null || $(this).val().trim().length == 0) {
			Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>必填欄位，請勿空白</span>', 1500);
		}
	});
});