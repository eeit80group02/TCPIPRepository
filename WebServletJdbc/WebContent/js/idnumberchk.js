  $(function () {
	    var old_generateMonthYearHeader = $.datepicker._generateMonthYearHeader;
	    var old_get = $.datepicker._get;
	    var old_CloseFn = $.datepicker._updateDatepicker;
	    $.extend($.datepicker, {
	        _generateMonthYearHeader:function (a,b,c,d,e,f,g,h) {
	            var htmlYearMonth = old_generateMonthYearHeader.apply(this, [a, b, c, d, e, f, g, h]);
	            if ($(htmlYearMonth).find(".ui-datepicker-year").length > 0) {
	                htmlYearMonth = $(htmlYearMonth).find(".ui-datepicker-year").find("option").each(function (i, e) {
	                    if (Number(e.value) - 1911 > 0) $(e).text(Number(e.innerText) - 1911);
	                }).end().end().get(0).outerHTML;
	            }
	            return htmlYearMonth;
	        },
	        _get:function (a, b) {
	            a.selectedYear = a.selectedYear - 1911 < 0 ? a.selectedYear + 1911 : a.selectedYear;
	            a.drawYear = a.drawYear - 1911 < 0 ? a.drawYear + 1911 : a.drawYear;
	            a.curreatYear = a.curreatYear - 1911 < 0 ? a.curreatYear + 1911 : a.curreatYear;
	            return old_get.apply(this, [a, b]);
	        },
	        _updateDatepicker:function (inst) {
	            old_CloseFn.call(this, inst);
	            $(this).datepicker("widget").find(".ui-datepicker-buttonpane").children(":last")
	                   .click(function (e) {
	                        inst.input.val("");
	                    });
	        },
	        _setDateDatepicker: function (a, b) {
	            if (a = this._getInst(a)) { this._setDate(a, b); this._updateDatepicker(a); this._updateAlternate(a) }
	        },
	        _widgetDatepicker: function () {
	            return this.dpDiv
	        }

	    });
	    
	    $("#datepicker").datepicker({
	        yearSuffix: "", //將年改為空白
	        yearRange: "2005:2015",
	        changeYear: true, //手動修改年
	        changeMonth: true, //手動修改月
	        firstDay: 1, //0為星期天
	        showButtonPanel: true, //顯示bottom bar
	        closeText: '清除', //將離開改為清除
	        dateFormat: "yy-m-d",
	        onSelect: function (dateText, inst) {
	            var dateFormate = inst.settings.dateFormat == null ? "yy/mm/dd" : inst.settings.dateFormat; //取出格式文字
	            var reM = /m+/g;
	            var reD = /d+/g;
	            var objDate = { y: inst.selectedYear - 1911 < 0 ? inst.selectedYear : inst.selectedYear - 1911,
	                m: String(inst.selectedMonth).length != 1 ? inst.selectedMonth + 1 :  String(inst.selectedMonth + 1),
	                d: String(inst.selectedDay).length != 1 ? inst.selectedDay : String(inst.selectedDay)
	            };
	            $.each(objDate, function (k, v) {
	                var re = new RegExp(k + "+");
	                dateFormate = dateFormate.replace(re, v);
	            });
	            inst.input.val(dateFormate);
	            
	           $("#applyTWY").val(objDate.y);
	           $("#applyMM").val(objDate.m);
	           $("#applyDD").val(objDate.d);
	        }
	    });
	});
  
	function checkID(id) {
  		var id = document.getElementById("idnum").value;
		//建立字母分數陣列(A~Z)
		var city = new Array(1, 10, 19, 28, 37, 46, 55, 64, 39, 73, 82,
				2, 11, 20, 48, 29, 38, 47, 56, 65, 74, 83, 21, 3, 12,
				30)
		id = id.toUpperCase();
		// 使用「正規表達式」檢驗格式
		if (id.search(/^[A-Z](1|2)\d{8}$/i) == -1) {
			console.log('基本格式錯誤');
			$("#checkImg").attr("style","");
			$("#checkImg").attr("src","http://www.webhostingspree.com/magento/wp-content/themes/Magento/images/no.png");
		} else {
			//將字串分割為陣列(IE必需這麼做才不會出錯)
			id = id.split('');
			//計算總分
			var total = city[id[0].charCodeAt(0) - 65];
			for (var i = 1; i <= 8; i++) {
				total += eval(id[i]) * (9 - i);
			}
			//補上檢查碼(最後一碼)
			total += eval(id[9]);
			//檢查比對碼(餘數應為0);
			if( ((total % 10 == 0)) ) {
				$("#checkImg").attr("style","");
				$("#checkImg").attr("src","https://ojooo.com/img/packages/yes.png");
			} else {
				$("#checkImg").attr("style","");
				$("#checkImg").attr("src","http://www.webhostingspree.com/magento/wp-content/themes/Magento/images/no.png");
			}
		}
	};

	$(function () {
		$.get("GetIdCheckerCaptchaServlet", function(responseJson) {
			console.log(responseJson);
			$("#captchaKey").val(responseJson.captchaKey);
			$("#captchaField").text(responseJson.captchaImage);
			$("#captchaImage").attr("src",$("#captchaField").val());
		}); 
	});
	
 	function refresh() {
		$.get("GetIdCheckerCaptchaServlet", function(responseJson) {
			console.log(responseJson);
			$("#captchaKey").val(responseJson.captchaKey);
			$("#captchaField").text(responseJson.captchaImage);
			$("#captchaImage").attr("src",$("#captchaField").val());
		}); 
				
	}
 	
	var imageString = document.getElementById("captchaField").innerHTML;
	document.getElementById("captchaImage").src = imageString;	
	
	$( "#postForm" ).submit(function( event ) {
		event.preventDefault();
		$("#num").text("");
		$("#date").text("");
		$("#site").text("");
		$("#reason").text("");
		$("#captcha").text("");
		
		var check = true;
		if($("#checkImg").attr("src") == "http://www.webhostingspree.com/magento/wp-content/themes/Magento/images/no.png" || $("#checkImg").attr("src") == undefined ) {
			$("#num").text("輸入身分證有誤!");
			check = false;
		}
		if($("#datepicker").val() == "" ) {
			$("#date").text("請選擇發證日期!");
			check = false;
		}
		if($("#siteId").val() == "" ) {
			$("#site").text("請選擇發證地點!");			
			check = false;
		}
		if($("#applyReason").val() == "" ) {
			$("#reason").text("請選擇類別!");
			check = false;
		}
		if($("#captchaInput").val() == "" || $("#captchaInput").val().length < 5 ) {
			$("#captcha").text("驗證碼格式錯誤!");
			check = false;
		}
		
		if(check == true) {					
			$.ajax({
    			url:'PostIdCheckerServlet',
    	   		type:'post',
    	   		data:{ "captchaKey" : $("#captchaKey").val() ,
    	   		  	   "idnum" : $("#idnum").val() , 
    	   		       "applyTWY" : $("#applyTWY").val() ,
    	   		       "applyMM" : $("#applyMM").val() ,
    	   		       "applyDD" : $("#applyDD").val() ,
    	   		       "siteId" : $("#siteId").val() ,
    	   		       "applyReason" : $("#applyReason").val() ,
    	   		       "captchaInput" : $("#captchaInput").val() },
    	   		dataType:'text',
    	   		success:function(result){
    					$("#result").text(result);
    	   		}
    	   
       		});
		}
	});