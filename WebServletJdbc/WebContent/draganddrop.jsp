<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	min-height:600px;
}

.nested_with_switc>li {
	float: left;
	width: 300px;
	height: 100%;
	text-align: center;
	margin: 5px;
	padding:0px;
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
	color: #616161 grey darken-2;
}

#trash-can {
	height: 130px;
	width: 130px;
}

</style>


</head>
<body>
	<script type="text/javascript">
		$(function() {
			//Set mission board container height fit with window
			$('.nested_with_switc').height($(window).height()*0.7);
			
			//Set mouseenter event
			$(document).on('mouseenter','.addSubMissionExecutor', function(){
				$(this).css({'cursor':'pointer'});
			});
			
			
			//Define container for mission board
			$("ul.nested_with_switc").sortable({
				cursor : 'move',
				toleranceElement : '> div',
				item : 'li', //Specifies which items inside the element should be sortable.
				connectWith : 'ul.nested_with_switc', //A selector of other sortable elements that the items from this list should be connected to.
				handle : 'div',
				placeholder : 'ui-state-highlight',
				stop: function(event, ui){
					var temp = $("ul.nested_with_switc").sortable("toArray");
					
					$.each(temp, function(index, value){
						console.log(index + ":" + value);
						$('#'+value+' input').val(index+1);
					});
				}
			})
			
			
			//Set trash can
			$("#trash-can").droppable({
				hoverClass : "droppable-hover",
				drop : function(event, ui) {
					 var element = ui.draggable;
			         $(this).append(element);
					$(ui.draggable).fadeOut(300);
				}

			});
			
			
			//Set Initail Board from database
			$.ajax({
    			url:'<c:url value="/GetMissionBoardServlet" />',
    	   		type:'get',
    	   		dataType:'json',
    	   		success:function(result){
    	   			console.log(result);
    	   			$('.boardName').val(result.missionBoard.boardName);
    	   			$('.fullProjId').val(result.missionBoard.fullProjId);
    	   			$('.missionBoardId').val(result.missionBoard.missionBoardId);
    	   			
    	   			//Add missionSet from database
    				$.each(result.missionSets, function(){
    					var $ul = $('.nested_with_switc');
    					var title = this.missionSetName;
    					console.log(title);
    	    			var $li = $('<li id="missionSetOrderId' + missionSetCount + '" class="#cddc39 lime" style=""></li>').html('<div id="missionSet' + this.missionSetId + 
    	    						'" class="missionTitle #ff5722 deep-orange" style="height:60px;font-size:22px;line-height:60px;">'+ title +
    	    						'</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
    	    						'<i class="large material-icons">add</i></div><input type="hidden" class="missionSetOrder" value="' + this.missionSetOrder + '">');
    	    			
    	    			console.log("ul element length="+$ul.children('li').length);
    	    			if( $ul.children('li').length == 0 ){
    	    				console.log("ul no child! " + title + " append directly");
    	    				$ul.append($li);
    	    			} else if( $ul.children('li').length > 0 ){
//     	    				console.log("need sort order: " + title + " position:" + this.missionSetOrder);
//     	    				console.log( $ul.children('li').closest('li:lt('+this.missionSetOrder+')') );
//     	    				console.log(" order="+parseInt(this.missionSetOrder) + ", length="+parseInt($ul.children('li').length) );
    	    				var missionSetOrder = this.missionSetOrder;
    	    				
    	    				var temp = 0;
    	    				$.each($('ul.nested_with_switc .missionSetOrder'),function(){
    	    					if( this.value < missionSetOrder){
    	    						temp = Math.max(temp, this.value);
    	    					}
    	    				});
    	    				
//     	    				console.log("temp="+temp);
							
							
							
    	    				$('ul.nested_with_switc input.missionSetOrder[value=' + temp + ']').parent().after($li);
    	    			}
    	    			
    	    			var width = $('div > div > ul').width() + 310;
    	    			$ul.css('width', width);
    	    			
    	    			$("ul.nested_with_switc > li > ul").sortable({
    	    				cursor : 'move',
    	    				toleranceElement : '> div',
    	    				item : 'li', //Specifies which items inside the element should be sortable.
    	    				handle : 'div',
    	    				connectWith : 'ul.nested_with_switc > li > ul', //A selector of other sortable elements that the items from this list should be connected to.
    	    				placeholder : "placeholder",
    	    				forcePlaceholderSize: true,
    	    				start: function(e, ui){
    	    					ui.placeholder.height(ui.helper.outerHeight());
    	    					$('.placeholder').css('background-color','#afb42b lime darken-2');
    	    				},
    	    				stop: function(event, ui){
    	    					var temp = $("ul.nested_with_switc > li > ul").sortable("toArray");
    	    					
    	    					$.each(temp, function(index, value){
    	    						console.log(index + ":" + value);
    	    						console.log($('#'+value+' .missionPosition').val());
    	    						$('#'+value+' .missionPosition').val(index+1);
    	    						console.log($('#'+value+' .missionPosition').val());
    	    					});
    	    				}
    	    			})
    	    			
    	    			
    	    			missionSetCount++;
    				});
    	   			
    	   			
    	   			//Add mission from database
    	   			$.each(result.missions, function(){
    	   				//check is subMission or not
    	   				var mainMissionId = this.mainMissionId;
    	   				//format date from yyyy-mm-dd to 民國
    	   				var date = new Date(Date.parse(this.missionEndTime));
    	   				var year = date.getYear()-11;
    	   				var month = date.getMonth() + 1;
    	   				var day = date.getDate();
    	   				var dateFormat = year + "-" + month + "-" + day;
    	   				
    	   				//Check if this is subMission or not
    	   				if( mainMissionId == void 0){
    	   					var $ul = $('#missionSet'+this.missionSetId).siblings('ul');
//     	   					console.log("name="+this.name);
    	   					var $mainMission = $("<li id='missionOrderId" + missionCount + "'></li>").html("<div class='li_edit waves-effect waves-light btn'>" + this.name + "</div>" +
      													  "<div id='dataRow"+ this.missionId + "' style='display:none'>" +
      													  "<input type='text' class='missionExecutor' value='" + this.host + "' name='" + this.memberId + "' >" +
      													  "<input type='text' class='missionDate' value=" + dateFormat + ">" +
      													  "<input type='text' class='missionPriority' value=" + this.missionPriority + ">"+
      													  "<input type='text' class='mainMissionId' value=" + this.mainMissionId + ">" +
      													  "<input type='text' class='missionPosition' value=" + this.missionPosition + ">" +
      													  "<input type='text' class='missionStatus' value='" + this.missionStatus + "'></div>");
    	   					
    	   					if( $ul.children('li').length == 0 ){
    	   						console.log("null with "+this.missionSetId);
    	   						console.log("name is "+this.name);
        	    				$ul.append($mainMission);
        	    			} else if( $ul.children('li').length > 0 ){
	    	   					var missionPosition = this.missionPosition;
	    	   					
	    	    				var temp = 0;
	    	    				$.each($('#missionSet'+ this.missionSetId +' ~ ul .missionPosition'),function(){
	    	    					if( this.value < missionPosition){
	    	    						temp = Math.max(temp, this.value);
	    	    					}
	    	    				});
	    	    				
								if( temp == 0 ){
									console.log(temp + ":" +this.name);
									console.log($('#missionSet'+ this.missionSetId + ' ~ ul input.missionPosition[value=' + missionPosition + ']').parent().parent().html());
									$('#missionSet'+ this.missionSetId + ' ~ ul input.missionPosition').first().parent().parent().before($mainMission);
									console.log($('#missionSet'+ this.missionSetId + ' ~ ul input.missionPosition[value=' + missionPosition + ']').parent().parent().html());
								} else{    	    				
	    	    					$('#missionSet'+ this.missionSetId + ' ~ ul input.missionPosition[value=' + temp + ']').parent().parent().after($mainMission);
								}
        	    			}
    	   					
    	   					if(this.missionStatus=="已完成"){
        						console.log('主任務: '+this.name+' 已完成');
        						$('#dataRow'+this.missionId).siblings('div').addClass('#bdbdbd grey lighten-1 disable');
        					}
    	   					
    	   				} else {
    	   					//Set subMission sortable
    	   					$(".subMissionContainer ul").sortable({
								cursor : 'move',
								toleranceElement : '> div',
								item : 'li', //Specifies which items inside the element should be sortable.
								handle : 'div',
								placeholder : "placeholder",
								forcePlaceholderSize: true,
								start: function(e, ui){
							        ui.placeholder.height(ui.helper.outerHeight());
							        $('.placeholder').css('background-color','#3f51b5 indigo');
							    }
							})
    	   					
    	   					
    	    	   			//add subMission
    	    	   			var $ul = $('.subMissionContainer ul');
    	    	   			var $subMission = $('<li class="#81d4fa light-blue lighten-3" style="width:585.906px;height:60px;margin:2px 0px;"></li>').html('<div id="subDataRow' + subMissionCount + '" class="row" style="width:585.906px;height:60px;">' +
														'<div class="subMissionSettings col l1"><i class="material-icons" style="padding:10px 0px;font-size:40px;">settings</i></div>' +
														'<div class="col l1" style="padding:15px 12px;"><input type="checkbox" id="subMissionCheckbox'+ subMissionCount +'" class="subMissionStatus filled-in" value="' + this.missionStatus + '" >'+
														'<label for="subMissionCheckbox'+ subMissionCount +'"></label></div>' +
														'<textarea class="subMissionName col l5 materialize-textarea" placeholder="請輸入子任務內容" style="max-height:45px;">'+ this.name +'</textarea>' +
														'<div class="subMissionDateContainer col l3"><input type="text" class="subMissionDate subDatepicker col l10" value="'+ dateFormat +'" readonly>' +
														'</div>' + '<div class="addSubMissionExecutor col l2"><div class="subMissionExecutor" style="padding:15px 0px;">'+ this.host +'</div></div>' +
														'<input type="hidden" class="subMissionPosition" value="' + this.missionPosition + '" >' +
														'<input type="hidden" class="mainDataRowLocation" value="dataRow'+ mainMissionId +'"></div>');
        					
    	    	   			
    	    	   			if( $ul.children('li').length == 1 ){
        	    				$ul.prepend($subMission);
        	    			} else if( $ul.children('li').length > 1 ){
	    	   					var missionPosition = this.missionPosition;
	    	   					
	    	    				var temp = 0;
	    	    				$.each($('.mainDataRowLocation[value=dataRow' + mainMissionId + ']'),function(){
	    	    					if( $(this).siblings('input.subMissionPosition').val() < missionPosition){
	    	    						temp = Math.max(temp, $(this).siblings('input.subMissionPosition').val());
	    	    						console.log(temp);
	    	    					}
	    	    				});
	    	    				
	    	    				//MainMission no child under, just append!
								if( temp == 0 ){
									$ul.prepend($subMission);
								} else {
									$('input[value='+ temp +'].subMissionPosition + input[value=dataRow'+ mainMissionId +'].mainDataRowLocation').parent().parent().after($subMission);	
								}
        	    			}
    	   					
    	    	   			if(this.missionStatus=="已完成"){
    	    					console.log('子任務: ' + this.name + ' 已完成');
    	    					console.log($('#subDataRow'+subMissionCount+' .subMissionStatus'));
    	    					$('#subDataRow'+subMissionCount).parent().removeClass('#81d4fa light-blue lighten-3');
    	    					$('#subDataRow'+subMissionCount).parent().addClass('#bdbdbd grey lighten-1');
    	    					$('#subDataRow'+subMissionCount+' .subMissionStatus').prop('checked',true);
    	    					$('#subDataRow'+subMissionCount).children('textarea').css({'text-decoration':'line-through',
									   													   'color':'#9e9e9e grey'})
    	    				}
    	    	   			subMissionCount++;
    	    	   			
    	    	   			
    	    	   			//JQuery datepicker
    	    				var inputDate = $(".subDatepicker");
    	    				var changeYearButtons = function() {
    	    					setTimeout(function() {
    	    				        var widgetHeader = inputDate.datepicker("widget").find(".ui-datepicker-header");
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
    	    				
    	    				
    	    				$(".subDatepicker").datepicker({
    	    					beforeShow: changeYearButtons,
    	    					onChangeMonthYear: changeYearButtons,
    	    		    		minDate: new Date(),
    	    		    		firstDay: 1, 
    	    		    		dateFormat: "yy-m-d",
    	    		    		showOn: "button",
    	    		    	    buttonImage: "images/calendar.png",
    	    		    	    buttonImageOnly: true,
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
    	    	   			
    	    				//Set datapicker icon position
    	    				$('.subMissionDateContainer').siblings('.ui-datepicker-trigger').appendTo('.subMissionDateContainer')
    	    				
    	    				$('.subMissionDateContainer img').css({'padding':'15px 0px',
    	    					  'cursor':'pointer'}).addClass('col l2');
    	    				
    	    				$('.subMissionSettings').css({'cursor':'pointer'});
    	    				
    	    				
    	   				}
    	   				
    	   				
    	   				missionCount++;
    	   			});
    	   			
    	   		},
    	   		error:function(result){
    	   			console.log(result);
    	   		}
    	   
       		});
			
			
			
			//Add missionSet
			var missionSetCount = 1;
			$(document).on('click', '.addBoard', function(){
				var title = $('#nameTitle').val();
				if(title==""){
					title = "MissionSet";
				}
				var $li = $('<li id="missionSetOrderId' + missionSetCount + '" class="#cddc39 lime"></li>').html('<div id="missionSet' + missionSetCount + 
						  '" class="missionTitle #ff5722 deep-orange" style="height:60px;font-size:22px;line-height:60px;">'+ title +
						  '</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
						  '<i class="large material-icons">add</i></div></div><input type="hidden" class="missionSetOrder" value="">');
				missionSetCount++;
				$('#nameTitle').val("");
				$('.nested_with_switc').append($li);
				var width = $('div > div > ul').width() + 310;
				$('.nested_with_switc').css('width', width);
				
				$("ul.nested_with_switc > li > ul").sortable({
					cursor : 'move',
					toleranceElement : '> div',
					item : 'li', //Specifies which items inside the element should be sortable.
					handle : 'div',
					connectWith : 'ul.nested_with_switc > li > ul', //A selector of other sortable elements that the items from this list should be connected to.
					placeholder : "placeholder",
					forcePlaceholderSize: true,
					start: function(e, ui){
				        ui.placeholder.height(ui.helper.outerHeight());
				        $('.placeholder').css('background-color','#afb42b lime darken-2');
				    }
				})
				
			});
			
			//Accept add missionSet with enter pressed at input field 
			$(document).on('keypress', '#nameTitle', function(e) {
			    if(e.which == 13) {
			    	var title = $('#nameTitle').val();
					if(title==""){
						title = "MissionSet";
					}
					var $li = $('<li id="missionSetOrderId' + missionSetCount + '" class="#cddc39 lime"></li>').html('<div id="missionSet' + missionSetCount + 
							  '" class="missionTitle #ff5722 deep-orange" style="height:60px;font-size:22px;line-height:60px;">'+ title +
							  '</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
							  '<i class="large material-icons">add</i></div><input type="hidden" class="missionSetOrder" value="">');
					missionSetCount++;
					$('#nameTitle').val("");
					$('.nested_with_switc').append($li);
					var width = $('div > div > ul').width() + 310;
					$('.nested_with_switc').css('width', width);
					
			    }
			});
			
			
			
			//Add mission
			var missionCount = 1;
			$(document).on('click','.addMission',function() {
				var $li = $("<li id='missionOrderId" + missionCount + "'></li>").html("<div class='li_edit waves-effect waves-light btn'>Mission"+ missionCount +"</div>" +
						  "<div id='dataRow"+ missionCount + "' style='display:none'>" +
						  "<input type='text' class='missionExecutor' value='待認領' >" +
						  "<input type='text' class='missionDate'>" +
						  "<input type='text' class='missionPriority'>"+
						  "<input type='text' class='mainMissionId' >" + 
						  "<input type='text' class='missionPosition' >" + 
						  "<input type='text' class='missionStatus' ></div>");
				missionCount++;
				$li.appendTo($(event.target).parent().siblings( "ul" ));
			});
			
			
			//Assign Executor
			$(document).on('click', '.missionExecutor', function(){
				var pos =  $(this).position();
				$('.popupParticipatorWindow').dialog("option", "position", {
                    my: "top",
                    at: "center",
                    of: event,
                });
				$('.popupParticipatorWindow').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				$('.popupParticipatorWindow ul').empty();
				
				//ajax get all participator
				$.ajax({
    				url:'<c:url value="/GetParticipatorServlet" />',
    	   			type:'get',
    	   			data:{'missionBoardId':$('.missionBoardId').val(),
    	   				  'fullProjId':$('.fullProjId').val() },
    	   			dataType:'json',
    	   			success:function(result){
    	   				console.log(result);
    	   				$.each(result.members, function(){
    	   					
    	   					var participatorName = this.memberName;
        					var memberID= this.memberId;
        					
        					var $li = $('<li class="participator"></li>').html('<div class='+ memberID +'>' + participatorName + '</div>');
        					$('.popupParticipatorWindow ul').append($li);
    	   					
        					$('.popupParticipatorWindow ul li').mouseenter(function(){
        						$(this).css({'background-color':'#cfd8dc blue-grey lighten-4',
        									 'font-weight':'bold',
        									 'cursor':'pointer'});
        					}).mouseleave(function(){
        						$(this).css({'background-color':'',
        							 		 'font-weight':'normal'});
        					});
        					
        					
        					
        					$('.participator').on('click',function(){
        						$('.missionDetailDialog .missionExecutor').removeClass($('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name'));
        						$('.missionParticipator ul .' + $('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name') + '').remove();
        						
        						$('.missionDetailDialog .missionExecutor').text($(this).children('div').text());
        						$('.missionDetailDialog .missionExecutor').addClass($(this).children('div').attr('class'));
        						
        						$('#'+$('.dataRowLocation').val()).find('.missionExecutor').val( $(this).children('div').text());
        						$('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name',$(this).children('div').attr('class'));
        						
        						if(!$('.missionParticipator ul div').hasClass($(this).children('div').attr('class'))){
        							$('.missionParticipator ul').prepend('<div class="' + $(this).children('div').attr('class') + '" style="width:100px;display:inline-block;">' + $(this).children('div').text() + '</div>');						
        						}
        						$('.popupParticipatorWindow').dialog( "close" );
        					});
    	   				});
    	   				
    	   			},
    	   			error:function(result){
    	   				console.log(result);
    	   			}
    	   
       			});
								
			});
			
			//Assign subMission Executor
			$(document).on('click', '.addSubMissionExecutor', function(){
				
				var target = event.target;
				var pos =  $(this).position();
				$('.popupParticipatorWindow').dialog("option", "position", {
                    my: "top",
                    at: "center",
                    of: event,
                });
				$('.popupParticipatorWindow').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				$('.popupParticipatorWindow ul').empty();
				
				//ajax get all participator
				$.ajax({
    				url:'<c:url value="/GetParticipatorServlet" />',
    	   			type:'get',
    	   			data:{'missionBoardId':$('.missionBoardId').val(),
    	   				  'fullProjId':$('.fullProjId').val() },
    	   			dataType:'json',
    	   			success:function(result){
//     	   				console.log(result);
    	   				$.each(result.members, function(){
    	   					
    	   					var participatorName = this.memberName;
        					var memberID= this.memberId;
        					
        					var $li = $('<li class="participator"></li>').html('<div class='+ memberID +'>' + participatorName + '</div>');
        					$('.popupParticipatorWindow ul').append($li);
    	   					
        					$('.participator').unbind().click(function(){
        						var subDataRowId = $(target).parent().parent().attr('id');
        						console.log("subDataRowId="+$(target).parent().parent().attr('id'));
								if(subDataRowId!= void 0 ){
									console.log('this is submission executor!');
									$('#'+subDataRowId+' .addSubMissionExecutor').empty();
									$('#'+subDataRowId+' .addSubMissionExecutor').append('<div class="subMissionExecutor" style="padding:15px 0px;">'+ $(this).text() +'</div>');
								} else {
									console.log("main input field for select executor!");
        							$('.subMission .addSubMissionExecutor').empty();
        							$('.subMission .addSubMissionExecutor').append('<div class="subMissionExecutor">'+ $(this).text() +'</div>');
								}        						
        						$('.popupParticipatorWindow').dialog( "close" );
        						
        					});
        					
        					$('.popupParticipatorWindow ul li').mouseenter(function(){
        						$(this).css({'background-color':'#cfd8dc blue-grey lighten-4',
        									 'font-weight':'bold',
        									 'cursor':'pointer'});
        					}).mouseleave(function(){
        						$(this).css({'background-color':'',
        							 		 'font-weight':'normal'});
        					});
        					
        					
        					
        					
    	   				});
    	   				
    	   			},
    	   			error:function(result){
    	   				console.log(result);
    	   			}
    	   
       			});
				
				
			});
			
			
			//Add participator
			$(document).on('click', '.addParticipator', function(){
				
				var pos =  $(this).position();
				$('.popupParticipatorWindow').dialog("option", "position", {
                    my: "top",
                    at: "center",
                    of: event,
                });
				$('.popupParticipatorWindow').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				$('.popupParticipatorWindow ul').empty();
				
				
				//ajax get all participator
				$.ajax({
    				url:'<c:url value="/GetParticipatorServlet" />',
    	   			type:'get',
    	   			data:{'missionBoardId':$('.missionBoardId').val(),
    	   				  'fullProjId':$('.fullProjId').val() },
    	   			dataType:'json',
    	   			success:function(result){
    	   				console.log(result);
    	   				$.each(result.members, function(){
    	   					
    	   					var participatorName = this.memberName;
        					var memberID= this.memberId;
        					
        					var $li = $('<li class="participator"></li>').html('<div class='+ memberID +'>' + participatorName + '</div>');
        					$('.popupParticipatorWindow ul').append($li);
    	   					
        					$('.popupParticipatorWindow ul li').mouseenter(function(){
        						$(this).css({'background-color':'#cfd8dc blue-grey lighten-4',
        									 'font-weight':'bold',
        									 'cursor':'pointer'});
        					}).mouseleave(function(){
        						$(this).css({'background-color':'',
        							 		 'font-weight':'normal'});
        					});
        					
    	   				});
    	   				
    	   				//need to find executor,and remove out of list
    					var executor = $('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name');
    					console.log(executor);
    					$('.popupParticipatorWindow ul .'+ executor +'').parent().remove();
    					
    					
    					$('.participator').on('click',function(){
    						console.log($(event.target).attr('class'));
    						
    						if($('.missionParticipator ul div').hasClass($(event.target).attr('class'))){
    							console.log("hasClass! remove");
    							$('.missionParticipator ul .'+ $(event.target).attr('class') +'').remove();
    						} else {
    							$('.missionParticipator ul').prepend('<div class="' + $(this).children('div').attr('class') + '" style="width:100px;display:inline-block;">' + $(this).children('div').text() + '</div>');
    						}
    					});
    	   				
    	   			},
    	   			error:function(result){
    	   				console.log(result);
    	   			}
    	   
       			});
				
				
				
			});
			
			//Add subMission
			var subMissionCount = 1;
			$('.openSubMissionWindow').mouseenter(function(){
					$(this).css({'font-weight':'bold',
								 'cursor':'pointer',
								 'color':'#0d47a1 blue darken-4'});
				}).mouseleave(function(){
					$(this).css({'font-weight':'normal',
						 		 'color':'black'});
				});
			$('.openSubMissionWindow').on('click',function(){
				var parent = $(this).parent();
				$(this).css('display','none');
// 				console.log($(event.target).siblings('div').find('.subMissionName').val() );
				$(event.target).siblings('div').find('.subMissionName').val('');
				$(event.target).siblings('div').find('.subMissionDate').val('');
				$(event.target).siblings('div').find('.addSubMissionExecutor').html('<img src="images/memberIcon.png">');

				$('.subMission').show();
			})
			$('.addSubMission').on('click',function(){
				var subMissionName = $('.subMission .subMissionName').val();
				console.log(subMissionName);
				var subMissionDate = $('.subMission .subMissionDate').val();
				var subMissionExecutor = $('.subMission .subMissionExecutor').text();
				if(subMissionExecutor==""){
					subMissionExecutor = "待認領"
				}

				var $subMission = $('<li class="#81d4fa light-blue lighten-3" style="width:585.906px;height:60px;margin:2px 0px;"></li>').html('<div id="subDataRow' + subMissionCount + '" class="row" style="width:585.906px;height:60px;">' +
														'<div class="subMissionSettings col l1"><i class="material-icons" style="padding:10px 0px;font-size:40px;">settings</i></div>' +
														'<div class="col l1" style="padding:15px 12px;"><input type="checkbox" id="subMissionCheckbox'+ subMissionCount +'" class="subMissionStatus filled-in" value="進行中" >'+
														'<label for="subMissionCheckbox'+ subMissionCount +'"></label></div>' +
														'<textarea class="subMissionName col l5 materialize-textarea" placeholder="請輸入子任務內容" style="max-height:45px;">'+ subMissionName +'</textarea>' +
														'<div class="subMissionDateContainer col l3"><input type="text" class="subMissionDate subDatepicker col l10" value="'+ subMissionDate +'" readonly>' +
														'</div>' + '<div class="addSubMissionExecutor col l2"><div class="subMissionExecutor" style="padding:15px 0px;">'+
														subMissionExecutor +'</div></div>' +
														'<input type="hidden" class="subMissionPosition" >' +
														'<input type="hidden" class="mainDataRowLocation" value="'+ $('.dataRowLocation').val() +'"></div>');
				$('.subMissionContainer ul').prepend($subMission);
				$('.subMission').hide();
				$('.openSubMissionWindow').css('display','block');
				
				//Set subMission sortable
// 				$(".subMissionContainer ul").sortable({
// 					cursor : 'move',
// 					toleranceElement : '> div',
// 					item : 'li', //Specifies which items inside the element should be sortable.
// 					handle : 'div',
// 					placeholder : "placeholder",
// 					forcePlaceholderSize: true,
// 					start: function(e, ui){
// 				        ui.placeholder.height(ui.helper.outerHeight());
// 				        $('.placeholder').css('background-color','#3f51b5 indigo');
// 				    }
// 				})
				
				
				//JQuery datepicker
				var inputDate = $(".subDatepicker");
				var changeYearButtons = function() {
					setTimeout(function() {
				        var widgetHeader = inputDate.datepicker("widget").find(".ui-datepicker-header");
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
				
				
				$(".subDatepicker").datepicker({
					beforeShow: changeYearButtons,
					onChangeMonthYear: changeYearButtons,
		    		minDate: new Date(),
		    		firstDay: 1, 
		    		dateFormat: "yy-m-d",
		    		showOn: "button",
		    	    buttonImage: "images/calendar.png",
		    	    buttonImageOnly: true,
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
				
				//Set datapicker icon position
				$('.subMissionDateContainer').siblings('.ui-datepicker-trigger').appendTo('.subMissionDateContainer')
				
				$('.subMissionDateContainer img').css({'padding':'15px 0px',
					  'cursor':'pointer'}).addClass('col l2');
				
				$('.subMissionSettings').css({'cursor':'pointer'});
				
				subMissionCount++;
			});
			
			
			//Set subMissionSettings dialog for subMission
			$(document).on('click','.subMissionSettings',function(){
				if($('.subMissionSettingsDialog').dialog( "isOpen" )){
					$('.subMissionSettingsDialog').dialog( "close" );
				}
				
				var pos =  $(this).position();
				$('.subMissionSettingsDialog').dialog("option", "position", {
                    my: "left",
                    at: "right",
                    of: event,
                });
				
				var subMissionId = $(this).parent().attr('id');
				$('.subMissionLocation').val(subMissionId);
				$(".subMissionSettingsDialog").dialog("open");
				$(".ui-dialog-titlebar").hide();
				
			});
			
			
			//Set subMissionSettings dialog close condition
			$('#transferToMission').click(function(){
				var mainMissionId = $('#'+$('.subMissionLocation').val()).children('input[class="mainDataRowLocation"]').val();
				console.log("mainMissionId="+mainMissionId);
				var subMissionId = $('.subMissionLocation').val();
				console.log("subMissionId="+subMissionId);
				console.log($('#'+subMissionId));
				var subMissionStatus = $('#'+subMissionId+' .subMissionStatus').val();
				console.log("subMissionStatus="+subMissionStatus);
				var subMissionName = $('#'+subMissionId+' .subMissionName').val();
				console.log("subMissionName="+subMissionName);
				var subMissionDate = $('#'+subMissionId+' .subMissionDate').val();
				console.log("subMissionDate="+subMissionDate);
				var subMissionExecutor = $('#'+subMissionId+' .subMissionExecutor').text();
				console.log("subMissionExecutor="+subMissionExecutor);
				var subMissionPosition = $('#'+subMissionId+' .subMissionPosition').val();
				console.log("subMissionPosition="+subMissionPosition);
				//******************************************************************************
				//******************************************************************************
				//******************************************************************************
				var $li = $("<li></li>").html("<div class='li_edit waves-effect waves-light btn'>"+ subMissionName +"</div>" +
						  "<div id='dataRow"+ missionCount + "' style='display:none'>" +
						  "<input type='text' class='missionExecutor' value='" + subMissionExecutor + "' >" +
						  "<input type='text' class='missionDate' value='" + subMissionDate + "'>" +
						  "<input type='text' class='missionPriority' value='普通'>"+
						  "<input type='text' class='mainMissionId' >" + 
						  "<input type='text' class='missionPosition' >" + 
						  "<input type='text' class='missionStatus' value='" + subMissionStatus + "'></div>");
				
				$('#'+mainMissionId).parent().parent().append($li);
				$('#'+subMissionId).parent().remove();
				
				if(subMissionStatus=="已完成"){
					console.log('任務已完成');
					console.log($('#dataRow'+missionCount).siblings('div'));
					$('#dataRow'+missionCount).siblings('div').addClass('#bdbdbd grey lighten-1 disable');
				}
				
				missionCount++;
				$('.subMissionSettingsDialog').dialog( "close" );
			});			
			$('#deleteSubMission').click(function(){
				$('#'+$('.subMissionLocation').val()).parent().remove();
				$('.subMissionSettingsDialog').dialog( "close" );			
			});			
			
			
			
			//Set missionTitle dialog close condition
			$('#confirmMission').click(function(){
				$('.setMissionTitleDialog').dialog( "close" );
			});			
			$('#deleteMission').click(function(){
				$('#'+$('.titleLocation').val()).parent().hide('slow', function(){ $(this).remove(); });
				$('.setMissionTitleDialog').dialog( "close" );			
			});			
			$(document).on('keypress', '.missionTitle', function(e) {
				if(e.which == 13) {
					$('.setMissionTitleDialog').dialog( "close" );
				}
			});
			
			
			//Change missionTitle, define popup dialog position
			$(document).on('dblclick','.missionTitle',function() {
				if($('.setMissionTitleDialog').dialog( "isOpen" )){
					$('.setMissionTitleDialog').dialog( "close" );
				}
				
				var pos =  $(this).position();
				$('.setMissionTitleDialog').dialog("option", "position", {
                    my: "left",
                    at: "right",
                    of: event,
                });
				
				var title = $(this).text();
				var temp = $(this).attr('id');
				
				$('.setMissionTitleDialog .missionTitle').val(title);
				$('.setMissionTitleDialog .titleLocation').val(temp);
				$(".setMissionTitleDialog").dialog("open");
				$(".ui-dialog-titlebar").hide();
				
			});
			
			
			//Get initial mission information and set to dialog
			$(document).on('click','.li_edit',function() {
				if($('.missionDetailDialog').dialog( "isOpen" )){
					$('.missionDetailDialog').dialog( "close" );
				}
				var div = event.target;
				var dataName = $(div).text();
				var dataExecutor = $(div).siblings("div").children(".missionExecutor").val();
				var dataDate = $(div).siblings("div").children(".missionDate").val();
				var dataPriority = $(div).siblings("div").children(".missionPriority").val();
				var dataExecutorId = $(div).siblings("div").children(".missionExecutor").attr("name");
// 				var dataStatus = $(div).siblings("div").children(".missionStatus").val();
				
				var temp = $(div).siblings("div").attr('id');
				$('.missionDetailDialog .missionName').val(dataName);
				$('.missionDetailDialog .missionExecutor').text(dataExecutor);
				$('.missionDetailDialog .missionDate').val(dataDate);
				
				$('.missionParticipator ul').empty();
				
				$('.missionParticipator ul').prepend('<div class="' + dataExecutorId + '" style="width:100px;display:inline-block;">' + dataExecutor + '</div>');
				$('.missionParticipator ul').append('<div class="addParticipator btn-floating btn waves-effect waves-light #2196f3 blue"><i class="material-icons">add</i></div>')
				
				if($(event.target).hasClass('disable')){
					$('.missionDetailDialog .missionStatus').prop('checked', true);
					$('.missionDetailDialog .missionName').addClass('disable');
				} else {
					$('.missionDetailDialog .missionStatus').prop('checked', false);
					if($('.missionDetailDialog .missionName').hasClass('disable')) {
						$('.missionDetailDialog .missionName').removeClass('disable');
					}
				}
				if(dataPriority == "普通" || dataPriority == "緊急" || dataPriority == "非常緊急" ){
					$('.missionDetailDialog .missionPriority option[value=' + dataPriority + ']').prop('selected', true);
				} else {
					$('.missionDetailDialog .missionPriority option[value="普通"]').attr("selected", "selected");
				}
				$('.missionDetailDialog .dataRowLocation').val(temp);
				
				
				
				$.each($('.subMissionContainer ul li') ,function(){
					if( $(this).children('div').children('input[class="mainDataRowLocation"]').val() == temp ){
						$(this).css('display','block');						
					} else if( $(this).children('div').children('input[class="mainDataRowLocation"]').val() != void 0 ) {
						$(this).css('display','none');
					} else {
						console.log('this is creater!');
					}
				});

				
				
				
				$('.missionDetailDialog').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				
			
				
			});
			
			
			//Cancel subMission
			$('.cancelSubMission').on('click',function(){
				$('.subMission').hide();
				$('.openSubMissionWindow').css('display','block');
			})
			
			
			
			//Set dialog change to dataRow
			$('.setMissionTitleDialog .missionTitle').on('change',function(){
				console.log($('.titleLocation').val());
				$('#'+$('.titleLocation').val()).text($(this).val());
			});			
			$('.missionDetailDialog .missionName').on('change',function(){
				$('#'+$('.dataRowLocation').val()).siblings("div").text($(this).val());
			});
			$('.missionDetailDialog .missionPriority').on('change',function(){
				$('#'+$('.dataRowLocation').val()).find('.missionPriority').val($(this).val());
			});
			
			
			//Set subMissionSettings dialog
			$('.subMissionSettingsDialog').dialog({
				autoOpen: false,
				modal: true,
				height: 230,
				width: 200,
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
		                $('.subMissionSettingsDialog').dialog('close');
		            })
		        }
			});
			
			
			
			//Set missionTitle dialog
			$('.setMissionTitleDialog').dialog({
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
		                $('.setMissionTitleDialog').dialog('close');
		            })
		        }
			});
			
	
			//Set mission dialog		
			$('.missionDetailDialog').dialog({
				autoOpen: false,
				modal: true,
				autoResize:true,
				height: $(window).height(),
				width: $(window).width()*0.5,
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
		                $('.missionDetailDialog').dialog('close');
		            })
		        }
			});
			
			
			//Set Participator dialog
			$('.popupParticipatorWindow').dialog({
				autoOpen: false,
				modal: true,
				height: 200,
				width: 170,
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
		                $('.popupParticipatorWindow').dialog('close');
		            })
		        }
			});
			
			
			//Set checkbox status, define add line-through to missionTitle or not
			$('.missionDetailDialog .missionStatus').on('click',function() {
				if($('#'+$('.dataRowLocation').val()).siblings("div").hasClass('disable')) {
					$('.missionDetailDialog .missionName').removeClass('disable');
					$('#'+$('.dataRowLocation').val()).siblings("div").removeClass('disable');
					$(event.target).prop('checked',false);
					$('#'+$('.dataRowLocation').val()).siblings("div").removeClass('#bdbdbd grey lighten-1');
					$('#'+$('.dataRowLocation').val()+' .missionStatus').val('進行中');
					
					console.log($('#'+$('.dataRowLocation').val()+' .missionStatus').val());
				} else {
					$('#'+$('.dataRowLocation').val()).siblings("div").addClass('disable');
					$('.missionDetailDialog .missionName').addClass('disable');
					$(event.target).prop('checked',true);
					$('#'+$('.dataRowLocation').val()).siblings("div").addClass('#bdbdbd grey lighten-1');
					$('#'+$('.dataRowLocation').val()+' .missionStatus').val('已完成');
					
					console.log($('#'+$('.dataRowLocation').val()+' .missionStatus').val());
				}
			});
			
			//Set checkbox status, define add line-through to subMissionTitle or not
			$(document).on('click','.subMissionStatus',function() {
				console.log(event.target);
				if( $(event.target).prop('checked') == true ){
					$(event.target).val('已完成');
					$(event.target).parent().parent().parent().removeClass('#81d4fa light-blue lighten-3');
					$(event.target).parent().parent().parent().addClass('#bdbdbd grey lighten-1');
					$(event.target).parent().siblings('textarea').css({'text-decoration':'line-through',
																	   'color':'#9e9e9e grey'});
				} else {
					$(event.target).val('進行中');
					$(event.target).parent().parent().parent().removeClass('#bdbdbd grey lighten-1');
					$(event.target).parent().parent().parent().addClass('#81d4fa light-blue lighten-3');
					$(event.target).parent().siblings('textarea').css({'text-decoration':'none',
																	   'color':'black'});
				}
			});
			
			
			//JQuery datepicker
			var inputDate = $("#datepicker, .subDatepicker");
			var changeYearButtons = function() {
			setTimeout(function() {
		        var widgetHeader = inputDate.datepicker("widget").find(".ui-datepicker-header");
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
			
			
			$("#datepicker, .subDatepicker").datepicker({
				beforeShow: changeYearButtons,
				onChangeMonthYear: changeYearButtons,
	    		minDate: new Date(),
	    		firstDay: 1, 
	    		dateFormat: "yy-m-d",
	    		showOn: "button",
	    	    buttonImage: "images/calendar.png",
	    	    buttonImageOnly: true,
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
	        		
	        		if($(this).hasClass('subDatepicker')){
	        			//.subDatepicker
	        			
	        		} else {
	        			//#datepicker
	        			$('#'+$('.dataRowLocation').val()).find('.missionDate').val( dateFormate );
	        		}
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
			
			
			//Set datepicker icon position
			$('.missionDate').siblings('.ui-datepicker-trigger').css({'position':'relative',
												'top':'-45px',
												'left':'150px',
												'cursor':'pointer'});
			
			$('.subMissionDate').siblings('.ui-datepicker-trigger').css({'position':'relative',
														 'top':'15px',
														 'left':'-20px',
														 'cursor':'pointer'});
			
			
		});
	</script>

	<div class="">
		<div class="">
			<div class="row">
				<input type="hidden" class="boardName">
				<input type="hidden" class="fullProjId">
				<input type="hidden" class="missionBoardId">
				
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
				<!-- Mission Board here!! -->
			</ul>
		</div>

	</div>
	
	<div class="subMissionSettingsDialog">
		<div class="row">
			<h5 class="center-align">子任務選單</h5>
		</div>
		<div class="divider" style="margin:10px 0px;padding:1px 0px;">	
		</div>
		<div class="row">
			<div id="transferToMission" class="waves-effect waves-light btn"><h6>轉為主任務</h6></div>
		</div>
		<div class="row">
			<div id="deleteSubMission" class="waves-effect waves-light btn"><h6>刪除子任務</h6></div>
		</div>
		<input type="hidden" class="subMissionLocation" value="">
	</div>
	
	<div class="setMissionTitleDialog">
		<div class="row">
			<div class="input-field">
				<input type="text" class="missionTitle validate">
				<input type="hidden" class="titleLocation" value="">
			</div>
		</div>
		<div class="row">
			<div class="col l6">
				<div id="confirmMission" class="waves-effect waves-light btn"><h6>完成</h6></div>
			</div>
			<div class="col l6">
				<div id="deleteMission" class="waves-effect waves-light btn"><h6>刪除</h6></div>
			</div>
		</div>
	</div>
	
	<div class="popupParticipatorWindow">
		<ul style="list-style:url('images/memberIcon.png') none inside;">
		</ul>
	</div>
	
	
	<div class="missionDetailDialog">
				<div class="row" style="border:1px dotted gray;">
					<div class="input-field col l1">
						<input type="checkbox" class="missionStatus filled-in" id="filled-in-box" >
      					<label for="filled-in-box"></label>
      				</div>
					<div class="input-field col l11">
						<input type="text" class="missionName validate" placeholder="任務名稱..." >
					</div>
				</div>
				<div class="row" style="border:1px dotted gray;"> 
					<div class="col l4">
						<label for="missionExecutor">執行者 </label>
						<ul style="list-style:url('images/memberIcon.png') none inside;">
							<li class="missionExecutor" style="cursor:pointer"></li>
						</ul>
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
				<div class="row" style="border:1px dotted gray;">
					<div class="col l12">
						<label for="missionParticipator">參與者 </label>
						<div class="missionParticipator">
							<ul class="col l12" style="column-count:4;column-gap:0;">
							</ul>
						</div>
					</div>
				</div>
				<div class="row" style="border:1px dotted gray;">
					<div class="col l12">
						<label for="subMissionContainer">子任務 </label>
						<div class="subMissionContainer">
							<ul class="col l12" style="column-count:4;column-gap:0;width:605.906px;">
								<li class="notSortable">
									<div class="openSubMissionWindow">添加子任務</div>
									<div class="subMission row" style="display:none">
										<div class="row input-field">
											<textarea class="subMissionName col l7 materialize-textarea" placeholder="請輸入子任務內容" style="max-height:45px;"></textarea> 
							    			<input type="text" class="subMissionDate subDatepicker col l3" readonly>
							    			<div class="addSubMissionExecutor col l2">
							   					<img src="images/memberIcon.png">
							   				</div>
							   			</div>
							   			<div class="row">
							   				<div class="addSubMission btn waves-effect waves-light #2196f3 blue" >新增</div>
											<div class="cancelSubMission btn waves-effect waves-light #2196f3 blue" >取消</div>
										</div>
							   		</div>
							   	</li>
							</ul>
						</div>
					</div>
				</div>
		<input type="hidden" class="dataRowLocation" value="">
	</div>
</body>
</html>