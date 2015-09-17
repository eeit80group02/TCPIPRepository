$(window).load(function() {
	$(function() {
		$("#imageName").change(function() {
			var fileName = $("#imageName").val();
			var lowercaseFileName = fileName.toLowerCase();
			var checkFileType = lowercaseFileName.match(/\.(jpg|gif|jpeg|png)$/g);

			if (checkFileType != null) {
				if (this.files && this.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$('#donationPicture').attr('src', e.target.result);
					}
					reader.readAsDataURL(this.files[0]);
				}
			} else {
				Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請上傳圖片格式</span>', 1800);
			}
		});
	});
});
