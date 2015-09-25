jQuery.validator.addMethod("checkname", function(value, element) {
	var str = value;
	var result = false;
	
	var pattren = /^[\u4e00-\u9fa5_a-zA-Z]{1,}$/;
	var checkFormat = pattren.test(str);

	var checkLength = false;
	if(str.length < 32 && str.length >= 2 ){
		checkLength	= true;
	}
	
	if( checkFormat && checkLength ){
		result = true;
	}
	
	return result;
}, "姓名格式有誤");

jQuery.validator.addMethod("ddlCheck", function(value) {
	var result = false;
	if($("#ddlCity option:selected").val() != "" && $("#ddlArea option:selected").val() != "" ){
		result = true;
	}
	return result;
}, "請選擇地區");

jQuery.validator.addMethod("addressCheck", function(value) {
	var result = false;
	var str = value;
	
	var pattern = /^[\u4e00-\u9fa5]{1}.*/;
	var checkFormat = pattern.test(str);
	
	var checkLength = false;
	if(str.length <= 49 ){
		checkLength	= true;
	}
	
	if( checkFormat && checkLength ){
		result = true;
	}
	
	return result;
}, "地址格式有誤");

jQuery.validator.addMethod("mobileCheck", function(value) {
	var result = false;
	var str = value;
	
	var pattern = /^[0]{1}[9]{1}[0-9]{8}/;
	var checkFormat = pattern.test(str);
		
	if( checkFormat ){
		result = true;
	}
	
	return result;
}, "手機格式有誤");


jQuery.validator.addMethod("emailCheck", function(value) {
	var result = false;
	var str = value;

	var pattern = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4})*$/;
	var checkFormat = pattern.test(str);
	
	console.log(checkFormat);
	if (checkFormat) {
		result = true;
	}

	return result;
}, "E-mail格式有誤");



