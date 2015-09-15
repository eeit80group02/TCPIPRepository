$(function() {
	// there's the gallery and the trash
	var $gallery = $("#gallery"), $trash = $("#trash"), $head5 = $(".ui-widget-header");

	// 小圖片放大控制速度
	$(document).ready(function() {
		$(".bigimg").hoverpulse({
			size : 30, // number of pixels to pulse element (in each direction)
			speed : 200
		// speed of the animation
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
		var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='取消選取' class='ui-icon ui-icon-refresh' style='float: right'></a>";

		$item.find(".fiximg div").css('visibility', 'hidden');
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
	}

	// image recycle function
	// 從捐獻背包回到大的捐獻牆
	function recycleImage($item) {
		var trash_icon = "<a href='link/to/trash/script/when/we/have/js/off' title='加入捐獻背包' class='ui-icon ui-icon-suitcase' style='float:right;'></a>";
		
		$item.find(".fiximg div").css('visibility', 'visible');		
		$item.fadeOut(function() {
			// $item.find("a.ui-icon-refresh").remove().end().css("width",
			// "190px").find("img").css("height",
			// "124px").end().appendTo($gallery).fadeIn().find("h5").append(trash_icon);
			$item.find("a.ui-icon-refresh").remove().end().css("width", "190px").find("img").css("height", "124px").end().appendTo($gallery).fadeIn().find(".footIcin").append(trash_icon);
		});
	}

	// image preview function, demonstrating the ui.dialog used as a modal
	// 放大鏡 Dialog
	function viewLargerImage($link) {
		var src = $link.attr("href");
		var title = $link.attr("title");
		var $modal = $("img[src$='" + src + "']");

		// alert(title);
		// var data = $("<img alt='" + title + "' width='984' height='1288'
		// style='display: none; padding: 8px;' />").attr("src",
		// src).appendTo("body");
		var img = $(
				'<center><table><tr><td rowspan="10"><img alt="延長線" title="延長線" src="images/thing01.jpg" width="300"></td><td style="text-align: right; width: 150px;">物資名稱：</td><td style="width: 350px; word-break: break-all;">延長線</td></tr><tr><td style="text-align: right; width: 150px;">需求數量：</td><td style="width: 350px;">18</td></tr><tr><td style="text-align: right; width: 150px;">尺寸規格：</td><td style="width: 350px;">10米</td></tr><tr><td style="text-align: right; width: 150px;">物資狀態：</td><td style="width: 350px;">不拘</td></tr><tr><td style="text-align: right; width: 150px;">需求單位：</td><td style="width: 350px;">屏東縣鹽埔鄉鹽埔國民小學</td></tr><tr><td style="text-align: right; width: 150px;">需求單位地址：</td><td style="width: 350px;">屏東縣鹽埔鄉鹽南村勝利路30號</td></tr><tr><td style="text-align: right; width: 150px;">募集起始時間：</td><td style="width: 350px;">2015/10/05 14:38:28</td></tr><tr><td style="text-align: right; width: 150px;">募集結束時間：</td><td style="width: 350px;">2016/01/06</td></tr><tr><td style="text-align: right; width: 150px;">募集原因：</td><td style="width: 350px; word-break: break-all;">教室電風扇插頭線長不足</td></tr><tfoot><tr><td style="text-align: center; vertical-align: text-top; padding-top: 20px;"><a href="DonationQA.html" target="_blank"><img alt="問與答" title="問與答" src="images/QA.png" width="80px" border="2px solid black"></a> <br> <a href="DonationWall.html" target="_blank"><img alt="查看同學校的其他物資" title="查看同學校的其他物資" src="images/search.png" width="35px" style="float: left;"></a> <a href="DonationWall.html" target="_blank"><img alt="加入捐獻背包" title="加入捐獻背包" src="images/buy.png" width="35px" style="float: right;"></a></td><td style="text-align: right; width: 150px; vertical-align: top; padding-top: 10px;">備註：</td><td style="border: 1px solid black; padding: 5px; word-break: break-all;"><div style="width: 350px; height: 120px; overflow: auto;">室電風扇插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插插頭線長不教室電風扇插頭線長不足</div></td></tr></tfoot></table></center>')
				.appendTo("body");
		setTimeout(function() {
			img.dialog({
				title : title,
				width : 850,
				modal : true
			});
		}, 1);

	}

	// resolve the icons behavior with event delegation

	/** 原始設定* */
	$("ul.gallery > li").click(function(event) {
		var $item = $(this), $target = $(event.target);
		if ($target.is("a.ui-icon-suitcase")) {
			deleteImage($item);
		} else if ($target.is("a.ui-icon-zoomin")) {
			viewLargerImage($target);
		} else if ($target.is("a.ui-icon-refresh")) {
			recycleImage($item);
		}
		return false;
	});

});