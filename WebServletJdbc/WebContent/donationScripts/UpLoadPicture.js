$(window).load(function() {
	$(function() {
		$("#imageName").change(function() {
			var fileName = $("#imageName").val();
			var lowercaseFileName = fileName.toLowerCase();
			var checkFileType = lowercaseFileName.match(/\.(jpg|gif|jpeg|png)$/g);
			
			console.log(fileName);

			if (checkFileType != null) {
				if (this.files && this.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						var Base64 = e.target.result;
						$('#donationPicture').attr('src', Base64).attr('style', 'vertical-align:middle');
					}
					reader.readAsDataURL(this.files[0]);
				}
			} else {
				$('#donationPicture').attr('src', "");
				Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>請上傳正確圖片格式</span>', 1800, 'rounded');
			}
		});
	});

	$("#cancelMessage").click(function() {
		$('#donationPicture').attr('src', "");
	});

	$("#sendMessage").click(function() {
		var imgBase64 = $('#donationPicture').attr('src');
		if (imgBase64.trim().length == 0) {
			Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>請上傳封面圖片</span>', 1800, 'rounded');
		}
	});
});
