$(function() {
	var txt; // 物件
	var xhr = null;
	var lists = null;
	
	$("*").click(div01hide);

	txt = document.getElementById("searchDonation");
	txt.addEventListener("keydown", getData, false);
	txt.addEventListener("keyup", getData, false);
	div01 = document.getElementById("div01");

	function getData() {
		xhr = new XMLHttpRequest();
		if (xhr != null) {
			xhr.addEventListener("readystatechange", function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					lists = xhr.responseText;
					datas = JSON.parse(lists);
					div01.style.display = "block";
					if (div01.childNodes.length > 0) {
						div01.removeChild(div01.childNodes[0]);
					}
					var eleUl = document.createElement("ul");
					for (var j = 0; j < datas.length; j++) {
						var txtLi = document.createTextNode(datas[j]);
						var eleLi = document.createElement("li");
						eleLi.appendChild(txtLi);
						eleLi.addEventListener("mouseover", function() {
						}, false)
						eleLi.addEventListener("mouseout", function() {
						}, false)

						eleLi.addEventListener("click", function() {
							var outPrint = this.firstChild.nodeValue;
							$("#searchDonation").val(outPrint);
							$("#searchDonation").trigger($.Event("focus"));
						}, false)

						eleUl.appendChild(eleLi);
					}
					if (datas.length != 0) {
						div01.appendChild(eleUl);
					} else {

					}

				} else {
					console.log(xhr.status + ":" + xhr.statusText);
				}

			});

			var input = txt.value;
			if (input.length != 0) {
				xhr.open("get", "jsimple.do?term=" + input, true);
			} else {
				input = "cmaxxx";
				xhr.open("get", "jsimple.do?term=" + input, true);
			}
			xhr.send();
		}

	}

	function div01show() {
		$("#div01").css("display", "block");
	}
	function div01hide() {
		$("#div01").css("display", "none");
	}

}(jQuery));
