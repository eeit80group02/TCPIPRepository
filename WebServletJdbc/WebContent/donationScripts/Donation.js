$(function() {
	// there's the gallery and the trash
	var $gallery = $("#gallery"), $trash = $("#trash"), $head5 = $(".ui-widget-header");

	// 小圖片放大控制速度
	$(document).ready(function() {
		$(".bigimg").hoverpulse({
			size : 30, // number of pixels to pulse element (in each direction)
			speed : 200	// speed of the animation
		});
	});

	// let the gallery items be draggable
	$("li", $gallery).draggable({
		cancel : "a.ui-icon", // clicking an icon won't initiate dragging
		revert : "invalid", // when not dropped, the item will revert back to
		// its initial position
		containment : "document",
		helper : "clone",
		cursor : "move"
	});

	// let the trash be droppable, accepting the gallery items
	$trash.droppable({
		accept : "#gallery > li",
		activeClass : "ui-state-highlight",
		drop : function(event, ui) {
			deleteImage(ui.draggable);
		}
	});

	// let the gallery be droppable as well, accepting items from the trash
	$gallery.droppable({
		accept : "#trash li",
		activeClass : "custom-state-active",
		drop : function(event, ui) {
			recycleImage(ui.draggable);
		}
	});

	// image deletion function
	// 點到捐獻包包
	function deleteImage($item) {
		Materialize.toast('<i class="tiny material-icons">check_circle</i>&nbsp;<span>加入一項物資</span>', 1800, 'rounded');
		var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='取消選取' class='ui-icon ui-icon-refresh' style='float: right'></a>";
		var donationId = $item.attr("value");
		addToCart(donationId);

		$item.fadeOut(function() {
			var $list = $("ul", $trash).length ? $("ul", $trash) : $("<ul class='gallery ui-helper-reset'/>").appendTo($trash);

			$item.find("a.ui-icon-suitcase").remove();
			$item.append(recycle_icon).appendTo($list).fadeIn(function() {
				$item.animate({
					width : "190px"
				}).find("img").animate({
					height : "124px"
				});
			});
		});
		$item.find(".fiximg div").css('visibility', 'hidden').css('height', '45px');
	}

	// image recycle function
	// 從捐獻背包回到大的捐獻牆
	function recycleImage($item) {
		Materialize.toast('<i class="tiny material-icons">check_circle</i>&nbsp;<span>移除一項物資</span>', 1800, 'rounded');
		var trash_icon = "<a href='link/to/trash/script/when/we/have/js/off' title='加入捐獻背包' class='ui-icon ui-icon-suitcase' style='float:right;'></a>";

		var donationToken = $item.attr("value");
		deleteFromCart(donationToken);

		$item.fadeOut(function() {
			$item.find("a.ui-icon-refresh").remove().end().css("width", "190px").find("img").css("height", "124px").end().appendTo($gallery).fadeIn().find(".footIcin").append(trash_icon);
		});
		$item.find(".fiximg div").css('visibility', 'visible').css('height', '45px');
	}

	// image preview function, demonstrating the ui.dialog used as a modal
	// 放大鏡 Dialog
	function viewLargerImage($link) {
		var src = $link.attr("href");
		var title = $link.attr("title");
		var $modal = $("img[src$='" + src + "']");

		var getID = $link.attr("id");

		var datas = getID.match(/[^\+]+/g);
		donationId = datas[0];
		schoolId = datas[1];
		supplyName = datas[4];// 物資名
		demandNumber = datas[7];
		supplyStatus = datas[3];
		schoolName = datas[2];
		// demandTime = datas[11];
		// expireTime = datas[12];
		size = datas[8];
		demandContent = datas[9];
		remark = datas[11];
		imgSrc = datas[12];// 圖片路徑
		originalDemandUnit = datas[13];

		var img = $('<center><table><tr><td rowspan="7"><img alt=' + supplyName + ' title=' + supplyName + ' src=' + imgSrc + ' width="300" height="300" style="border:1px solid black"></td><td style="text-align: right; width: 180px;">物資名稱：</td><td style="width: 350px; word-break: break-all;">' + supplyName + '</td></tr><tr><td style="text-align: right; width: 180px;">需求數量：</td><td style="width: 350px;">' + demandNumber + ' ' + originalDemandUnit + '</td></tr><tr><td style="text-align: right; width: 180px;">尺寸規格：</td><td style="width: 350px;">' + size + '</td></tr><tr><td style="text-align: right; width: 180px;">物資狀態：</td><td style="width: 350px;">' + supplyStatus + '</td></tr><tr><td style="text-align: right; width: 180px;">需求單位：</td><td style="width: 350px;"><a href="https://www.google.com.tw/maps/search/' + schoolName + '" target="_new" style="color:#5599FF;font-weight:bold;">' + schoolName + '</a></td></tr><tr><td style="text-align: right; width: 180px;">募集原因：</td><td style="width: 350px; word-break: break-all;">' + demandContent + '</td></tr><tfoot><tr><td style="text-align: center; vertical-align: text-top; padding-top: 20px;"><a href="demand.do?donationId=' + datas[0] + '&schoolId=' + datas[1] + '&type=OneDemandByMember" target="_blank"><img alt="問與答" title="問與答" src="../images/QA.png" width="80px" border="2px solid black"></a></td><td style="text-align: right; width: 180px; vertical-align: top; padding-top: 10px;">備註：</td><td style="border: 1px solid black; padding: 5px; word-break: break-all;"><div style="width: 350px; height: 120px; overflow: auto;">' + remark + '</div></td></tr></tfoot></table></center>').appendTo("body");

		setTimeout(function() {
			img.dialog({
				title : title,
				position : {
					my : "center",
					at : "center bottom",
					of : window
				},
				maxHeight : 550,
				width : 900,
				hide : 'scale',
				show : 'blind',
				modal : true

			}).css('background-color', '#FFEBEB').animate({
				scrollTop : 0
			}, 500);
			;
		}, 1);
	}

	function addToCart(donationId) {

		var xhr = new XMLHttpRequest();
		if (xhr != null) {
			xhr.addEventListener("readystatechange", function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						lists = xhr.responseText;

						// 設定cookie值
						var now = new Date();
						now.setTime(now.getTime() + 1000 * 60 * 60 * 24 * 30);
						document.cookie = "Items=" + lists + ";expire=" + now.toUTCString();

					} else {
						// alert("something is wrong!");
					}
				}
			});
			xhr.open("POST", "cart.do", true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("toCart=insert&returnJson=true&donationId=" + donationId);
		}
	}

	function deleteFromCart(data) {
		var xhr = new XMLHttpRequest();
		if (xhr != null) {
			xhr.addEventListener("readystatechange", function(data) {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						lists = xhr.responseText;

						// 設定cookie值
						var now = new Date();
						now.setTime(now.getTime() + 1000 * 60 * 60 * 24 * 30);
						document.cookie = "Items=" + lists + ";expire=" + now.toUTCString();

						// alert("刪除購物車品項一");
					} else {
						// alert("something is wrong!");
					}
				}
			});
			xhr.open("POST", "cart.do", true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
			xhr.send("toCart=delete&returnJson=true&donationId=" + data);
		}
	}

	// resolve the icons behavior with event delegation

	/** 原始設定* */
	$("ul.gallery > li").click(function(event) {
		var $item = $(this), $target = $(event.target);
		if ($target.is("a.ui-icon-suitcase")) {
			deleteImage($item);
		} else if ($target.is("a.ui-icon-zoomin")) {
			viewLargerImage($target);
			Materialize.toast('<i class="tiny material-icons">info_outline</i>&nbsp;<span>按&nbsp;Esc&nbsp;或右上方&nbsp;<i class="tiny material-icons">clear</i>&nbsp;以關閉視窗</span>', 3000, 'rounded');
		} else if ($target.is("a.ui-icon-refresh")) {
			recycleImage($item);
		}
		return false;
	});
});