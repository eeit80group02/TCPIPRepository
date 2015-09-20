(function($) {

	var step = 1; // 默認步長
	var changeStepTimer = null; // 改變速度計數器
	var setValueTimer = null; // 設置值計數器

	/* 改變速度私有方法 */
	var changeStep = function() {
		// 每隔 2 秒速度加 5
		changeStepTimer = setInterval(function() {
			step += 5
		}, 2000);
	}

	/* 設置值私有方法 */
	var setAddValue = function() {
		var input = $("#text").val();
		$("#text").val(parseInt(input) + step);
		setValueTimer = setTimeout(setAddValue, 200); // 每隔200毫秒更新文本框數值一次
	}

	/* 設置值私有方法 */
	var setSubValue = function() {
		var input = $("#text").val();
		$("#text").val(parseInt(input) - step);
		setValueTimer = setTimeout(setSubValue, 200); // 每隔200毫秒更新文本框數值一次
	}

	/* 按下鼠標處理函數 */
	$("#buttonSub").mousedown(function() {
		var input = $("#text").val();
		// 正規表示法找整數
		if ((/^\d+$/.test(input)) && parseInt(input) > 0 && parseInt(input) < 10000) {
			changeStep();
			setSubValue();
		} else {
			Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800, 'rounded');
			$("#text").val(1);
		}

	});

	/* 按下鼠標處理函數 */
	$("#buttonAdd").mousedown(function() {
		var input = $("#text").val();
		// 正規表示法找整數
		if ((/^\d+$/.test(input)) && parseInt(input) > 0 && parseInt(input) < 10000) {
			changeStep();
			setAddValue();
		} else {
			Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800, 'rounded');
			$("#text").val(1);
		}

	});

	/* 鬆開鼠標處理函數 */
	$("*").mouseup(checkText).keydown(checkText).keyup(checkText);

	function checkText() {
		var input = $("#text").val();
		if ((/^\d+$/.test(input)) && parseInt(input) > 0 && parseInt(input) < 10000) {
		} else {
			Materialize.toast('<span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;<span>請輸入正整數，且不可超過上限</span>', 1800, 'rounded');
			$("#text").empty();
			$("#text").val(1);
		}

		clearInterval(changeStepTimer);
		clearTimeout(setValueTimer);
		step = 1;
	}
}(jQuery));