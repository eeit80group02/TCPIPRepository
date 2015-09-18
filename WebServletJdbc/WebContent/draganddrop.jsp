<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
<link href="css/multiple-select.css" rel="stylesheet"/>

<style type="text/css">

.container {
}

.nested_with_switc {
	width: 100%;
}

.nested_with_switc>li {
	float: left;
	width: 300px;
	height: 100%;
	text-align: center;
	margin: 5px;
}

.nested_with_switc>li>div {
	width: 300px;
	height: 30px;
	text-align: center;
}

.nested_with_switc>li>ul {
	min-height: 30px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.nested_with_switc>li>ul>li>div {
	width: 300px;
	height: 30px;
	text-align: center;
	margin: 5px 5px;
}

.disable {
	text-decoration: line-through;
}

#trash-can {
	height:130px;
	width:130px;
}


</style>


</head>
<body>
	<script type="text/javascript">
		$(function() {
			$('.nested_with_switc').height($(window).height()*0.7);
			
			$("ul.nested_with_switc").sortable({
				cursor : 'move',
				toleranceElement : '> div',
				item : 'li', //Specifies which items inside the element should be sortable.
				connectWith : 'ul.nested_with_switc', //A selector of other sortable elements that the items from this list should be connected to.
				handle : 'div',
				placeholder : 'ui-state-highlight',


			}).droppable();
			

			$("ul.nested_with_switc > li > ul").sortable({
				cursor : 'move',
				toleranceElement : '> div',
				item : 'li', //Specifies which items inside the element should be sortable.
				handle : 'div',
				connectWith : 'ul.nested_with_switc > li > ul', //A selector of other sortable elements that the items from this list should be connected to.
				placeholder : "ui-state-default",
// 				update : function(event, ui) {

// 				}
			})

			$("#trash-can").droppable({
				hoverClass : "droppable-hover",
				drop : function(event, ui) {
					 var element = ui.draggable;
			         $(this).append(element);
					$(ui.draggable).fadeOut(300);

					
					/*
					
					            var element = $(ui.draggable).clone();
					            $(this).append(element);
					            element.fadeOut(1000);
					            $(ui.draggable).remove();
					 */
				}

			});
			
			var missionSetCount = 1;
			$('.addBoard').on('click', function(){
				var title = $('#nameTitle').val();
				if(title==""){
					title = "MissionSet";
				}
				var $li = $('<li class="#cddc39 lime"></li>').html('<div id="missionSet' + missionSetCount + '" class="missionTitle #ff5722 deep-orange">'+ title +
						  '</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
						  '<i class="large material-icons">add</i></div>');
				missionSetCount++;
				$('#nameTitle').val("");
				$('.nested_with_switc').append($li);
				var width = $('div > div > ul').width() + 310;
				$('.nested_with_switc').css('width', width);
			});
			
			
			
			var missionCount = 1;
			$(document).on('click','.addMission',function() {
				var $li = $("<li></li>").html("<div class='li_edit waves-effect waves-light btn'>Mission"+ missionCount +"</div>" +
						  "<div id='dataRow"+ missionCount + "' style='display:none'>" +
						  "<input type='text' class='missionExecutor' placeholder='執行人...' >" +
						  "<input type='text' class='missionDate'>" +
						  "<input type='text' class='missionPriority'></div>");
				missionCount++;
				$li.appendTo($(event.target).parent().siblings( "ul" ));
				$("ul.nested_with_switc > li > ul").sortable({
					cursor : 'move',
					toleranceElement : '> div',
					item : 'li', //Specifies which items inside the element should be sortable.
					handle : 'div',
					connectWith : 'ul.nested_with_switc > li > ul', //A selector of other sortable elements that the items from this list should be connected to.
					placeholder : "ui-state-default",
					update : function(event, ui) {

					}
				})

				
			});
			
			$('#commit').click(function(){
				$('.popupWindow').dialog( "close" );
			});
			
			$('#delete').click(function(){
// 				$('#'+$('.titleLocation').val()).parent().remove();
				$('#'+$('.titleLocation').val()).parent().hide('slow', function(){ $(this).remove(); });
				$('.popupWindow').dialog( "close" );			
			});
			
			
			
			
			$(document).on('dblclick','.missionTitle',function() {
				if($('.popupWindow').dialog( "isOpen" )){
					$('.popupWindow').dialog( "close" );
				}
				
				var pos =  $(this).position();
				$('.popupWindow').dialog("option", "position", {
                    my: "left",
                    at: "right",
                    of: event,
                });
				
				var title = $(this).text();
				var temp = $(this).attr('id');
				
				$('.popupWindow .missionTitle').val(title);
				$('.popupWindow .titleLocation').val(temp);
				$(".popupWindow").dialog("open");
				$(".ui-dialog-titlebar").hide();
				
			});
			
			
			
			$(document).on('click','.li_edit',function() {
				if($('.dialog').dialog( "isOpen" )){
					$('.dialog').dialog( "close" );
				}
				var div = event.target;
				var dataName = $(div).text();
				var dataExecutor = $(div).siblings("div").children(".missionExecutor").val();
				var dataDate = $(div).siblings("div").children(".missionDate").val();
				var dataPriority = $(div).siblings("div").children(".missionPriority").val();
				
				var temp = $(div).siblings("div").attr('id');
				$('.dialog .missionName').val(dataName);
				$('.dialog .missionExecutor').val(dataExecutor);
				$('.dialog .missionDate').val(dataDate);
				
				
				if(dataPriority == "普通" || dataPriority == "緊急" || dataPriority == "非常緊急" ){
					$('.dialog .missionPriority option[value=' + dataPriority + ']').prop('selected', true);
				} else {
					$('.dialog .missionPriority option[value="普通"]').attr("selected", "selected");
				}
				$('.dialog .dataRowLocation').val(temp);
				
				$('.dialog').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				
			
				
			});
			
			
			$('.popupWindow .missionTitle').on('change',function(){
				console.log($('.titleLocation').val());
				$('#'+$('.titleLocation').val()).text($(this).val());
			});
			
			
			$('.dialog .missionName').on('change',function(){
				$('#'+$('.dataRowLocation').val()).siblings("div").text($(this).val());
			});
			$('.dialog .missionExecutor').on('change',function(){
				$('#'+$('.dataRowLocation').val()).find('.missionExecutor').val($(this).val());
			});
			$('.dialog .missionPriority').on('change',function(){
				$('#'+$('.dataRowLocation').val()).find('.missionPriority').val($(this).val());
			});
			
			
			
			
			
			$('.popupWindow').dialog({
				autoOpen: false,
				modal: true,
				height: 250,
				width: 300,
				show: {
					effect: "slide",
					direction: "right",
					duration: 300
				},
				hide: {
			    	effect: "slide",
			    	direction: "right",
			    	duration: 300
				},
				open: function(){
		            $('.ui-widget-overlay').bind('click',function(){
		                $('.popupWindow').dialog('close');
		            })
		        }
			});
			
	
			
			$('.dialog').dialog({
				autoOpen: false,
				modal: true,
				height: $(window).height(),
				width: $(window).width() - 1000,
				position: { my: "right top", at: "right bottom", of: window },
				show: {
					effect: "slide",
					direction: "right",
					duration: 300
				},
				hide: {
			    	effect: "slide",
			    	direction: "right",
			    	duration: 300
				},
				open: function(){
		            $('.ui-widget-overlay').bind('click',function(){
		                $('.dialog').dialog('close');
		            })
		        }
			});
			
			
		});
	</script>

	<div class="">
		<div class="">
			<div class="row">
				<div class="col l2">
					<div class="input-field">
						<input id="nameTitle" type="text" class="validate">
					</div>
				</div>
				<div class="col l1">
					<div
						class="addBoard btn-large waves-effect waves-light red">
						<i class="large material-icons">add</i>
					</div>
				</div>
				<div class="col l1">
					<div id="trash-can">
						<img src="images/trash_can.png" style="height:100px; width:100px;">
					</div>
				</div>
			</div>
			<ul class="nested_with_switc #81d4fa light-blue lighten-3">
<!-- 				<li class="#cddc39 lime"> -->
<!-- 					<div id="missionSet1" class="missionTitle #ff5722 deep-orange">Section1</div> -->
<!-- 					<ul> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn" >Item 1</div>							 -->
<!-- 							<div id="dataRow1" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="緊急">	 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 2</div> -->
<!-- 							<div id="dataRow2" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">							 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 3</div> -->
<!-- 							<div id="dataRow3" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate"> -->
<!-- 								<input type="text" class="missionPriority" value="普通">								 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 					<div  -->
<!-- 						class="addMission sortable btn-floating btn-large waves-effect waves-light red"> -->
<!-- 						<i class="large material-icons">add</i> -->
<!-- 					</div></li> -->

<!-- 				<li class="#cddc39 lime"><div class="#ff5722 deep-orange">Section -->
<!-- 						2</div> -->
<!-- 					<ul> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 4</div> -->
<!-- 							<div id="dataRow4" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">	 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 5</div> -->
<!-- 							<div id="dataRow5" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">							 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 6</div> -->
<!-- 							<div id="dataRow6" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">							 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 					<div -->
<!-- 						class="addMission sortable btn-floating btn-large waves-effect waves-light red"> -->
<!-- 						<i class="large material-icons">add</i> -->
<!-- 					</div></li> -->
<!-- 				<li class="#cddc39 lime"><div class="#ff5722 deep-orange">Section -->
<!-- 						3</div> -->
<!-- 					<ul> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 7</div> -->
<!-- 							<div id="dataRow7" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">								 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 8</div> -->
<!-- 							<div id="dataRow8" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">							 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 						<li><div class="li_edit waves-effect waves-light btn">Item 9</div> -->
<!-- 							<div id="dataRow9" style="display:none"> -->
<!-- 								<input type="text" class="missionExecutor">	 -->
<!-- 								<input type="text" class="missionDate">	 -->
<!-- 								<input type="text" class="missionPriority" value="普通">							 -->
<!-- 							</div> -->
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 					<div -->
<!-- 						class="addMission sortable btn-floating btn-large waves-effect waves-light red"> -->
<!-- 						<i class="large material-icons">add</i> -->
<!-- 					</div></li> -->
			</ul>
			
			
		</div>

	</div>
	
	<div class="popupWindow">
		<div class="row">
			<div class="input-field">
				<input type="text" class="missionTitle validate">
				<input type="hidden" class="titleLocation" value="">
			</div>
		</div>
		<div class="row">
			<div class="col l6">
				<div id="commit" class="waves-effect waves-light btn"><h6>完成</h6></div>
			</div>
			<div class="col l6">
				<div id="delete" class="waves-effect waves-light btn"><h6>刪除</h6></div>
			</div>
		</div>
	</div>
	
	
	<div class="dialog">
				<div class="row">
					<div class="input-field col l1">
						<input type="checkbox" class="missionStatus filled-in" id="filled-in-box" >
      					<label for="filled-in-box"></label>
      				</div>
					<div class="input-field col l11">
						<input type="text" class="missionName validate" placeholder="任務名稱..." >
					</div>
				</div>
				<div class="row"> 
					<div class="input-field col l4">
						<label for="missionExecutor">執行者 </label>
						<input type="text" class="missionExecutor validate" placeholder="執行人...">
					</div>
					<div class="col l4">
						<label for="datepicker">截止日期 </label>
						<input type="text" id="datepicker" class="missionDate validate" readonly>
					</div>
					<div class="col l4">
						<label for="missionPriority">優先次序</label>
						<select class="missionPriority browser-default" placeholder="">
							<option value="普通">普通</option>
							<option value="緊急">緊急</option>
							<option value="非常緊急">非常緊急</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col l12">
						<label for="MissionParticipator">參與者 </label>
						<select multiple="multiple" class="MissionParticipator browser-default" placeholder="">
        					<option value="1">January</option>
        					<option value="12">December</option>
    					</select>
    					<script src="js/jquery.multiple.select.js"></script>
    					<script>
    						$(function() {
        						$('.MissionParticipator').multiSelect();
        					});
    					</script>
					</div>
				</div>
				

		<input type="hidden" class="dataRowLocation" value="">
	</div>
	
	<script type="text/javascript">
		$('.dialog .missionStatus').on('click',function() {
			$('.dialog .missionName').toggleClass('disable');
		});
	</script>
	
	
	<script type="text/javascript">
		var inputDate = $("#datepicker");
		var changeYearButtons = function() {
		setTimeout(function() {
	        var widgetHeader = inputDate.datepicker("widget").find(".ui-datepicker-header");
	        //you can opt to style up these simple buttons tho
	        var prevYrBtn = $('<button>前年</button>');
	        prevYrBtn.bind("click", function() {
	            $.datepicker._adjustDate(inputDate, -1, 'Y');
	        });
	        var nextYrBtn = $('<button>次年</button>');
	        nextYrBtn.bind("click", function() {
	            $.datepicker._adjustDate(inputDate, +1, 'Y');

	        });
	        prevYrBtn.appendTo(widgetHeader);
	        nextYrBtn.appendTo(widgetHeader);

	    	}, 1);
		};
	
		//datepicker 初始化
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
        		$(this).datepicker("widget").find(".ui-datepicker-buttonpane").children(":last").click(function (e) {
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
			beforeShow: changeYearButtons,
			onChangeMonthYear: changeYearButtons,
    		minDate: new Date(),
    		firstDay: 1, //0為星期天
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
        		
        		$('#'+$('.dataRowLocation').val()).find('.missionDate').val( dateFormate );
    		}
		});
	
		$.datepicker.regional['zh-TW'] = {
				prevText: '上月',
				nextText: '次月',
				monthNames: ['一月','二月','三月','四月','五月','六月',
				'七月','八月','九月','十月','十一月','十二月'],
				monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
				dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
				dayNamesMin: ['日','一','二','三','四','五','六'],
		};
		$.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
	</script>
</body>
</html>