$(function() {
	$(":required").blur(function() {
		if ($(this).val() == null || $(this).val().trim().length == 0) {
			Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>必填欄位，請勿空白</span>', 1800, 'rounded');
		}
	});
}(jQuery));