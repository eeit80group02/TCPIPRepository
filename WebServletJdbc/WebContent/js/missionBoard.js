		$(function() {
			//Set mission board container height fit with window
			$('.nested_with_switc').height($(window).height()*0.7);
			
			//Set mouseenter event
			$(document).on('mouseenter','.addSubMissionExecutor', function(){
				$(this).css({'cursor':'pointer'});
			});
			
			//Set subMissionDatepicker
			function setSubMissionDatepicker(){
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
		        		
		        		var missionId = $(this).parent().siblings('input.missionId').val();
		        		updateSubMission(missionId);
		        		
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
			}
			
			
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
					
					$("#loadingmodal").openModal();
					$.each(temp, function(index, value){
						console.log(index + ":" + value);
						var lastIndex = temp.length - 1;
						var missionSetPos = index+1;
						var missionSetId = $('#'+value+' div:first-child').attr('id').substring(10);
						var name = $('#'+value+' > div:first-child').text();
						var missionBoardId = boardInformation.missionBoard.missionBoardId;
						
						//Update database
						$.ajax({
		    			    url:'DynamicUpdateBoardServlet',
		    			    type:'post',
		    			    data:{'action':'UpdateMissionSetOrder',
		    			    	  'missionSetOrder':missionSetPos,
		    			    	  'missionSetId':missionSetId,
		    			    	  'name':name,
		    			    	  'missionBoardId':missionBoardId},
		    			    dataType:'json',
		    			    success:function(result){
		    			    	console.log(result);
		    			    	if(result.result == "succeed"){
		    			    		$('#'+value+' > input.missionSetOrder').val(result.missionSet.missionSetOrder);
		    			    	}
		    			    },
		    			    error:function(result){
		    			    	console.log(result);
		    			    },
		        	   		complete:function(){
		        	   			if( missionSetPos == lastIndex + 1 ){
		        	   				$("#loadingmodal").closeModal();
		        	   			}
		        	   		}
		    			});

					});
				}
			})
			
			//Set trash can
			$("#trash-can").droppable({
				hoverClass : "droppable-hover",
				drop : function(event, ui) {
					
					var element = ui.draggable;
					var missionId = element.children('div:last-child').attr('id').substring(9);
					$.ajax({
	    			    url:'DynamicUpdateBoardServlet',
	    			    type:'post',
	    			    data:{'action':'DeleteMission',
	    			    	  'missionId':missionId},
	    			    success:function(responseText){
	    			    	console.log(responseText);
	    			    	if( responseText == "succeed"){
		    			    	$(ui.draggable).fadeOut(300);
		    					element.remove();
	    			    	}
	    			    },
	    			    error:function(result){
	    			    	console.log("error!!!!!",result);
	    			    }
	    			});
					
					
				}

			});
			
			//Set subMissionSortable
			function setSubMissionSortable(){
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
					},
	    			stop: function(event, ui){
	    				var orderArray = new Array();
	    				var child = $('.subMissionContainer ul > li').each(function(){
	    					orderArray.push($(this).children().attr("id")+":"+$(this).children('div').children('input.mainDataRowLocation').val());
	    				});
	    				console.log("order",orderArray);  
	    					
	    				var mainMissionId;
	    				var count = 1;
	    				for(var i = 0; i < orderArray.length; i++){
	    					var pair = orderArray[i].split(":");
		    					console.log("pair",pair);
		    						
		    				if( mainMissionId != pair[1] ){
	    						mainMissionId = pair[1];
	    						count = 1;
	    					}
	    						
		    				//Get last missionId, when last mission ajax send back close modal
		    				var lastIndex = orderArray.length-2;
		    				if( i == lastIndex ){
		    					var lastSubMissionId = $('#'+pair[0]+' .missionId').val();
		    				}
		    				
	    					console.log( "1.Position",$('#'+pair[0]+' input.subMissionPosition').val() );
	    					if(pair[0] != "undefined" ){
		    					var missionId = $('#'+pair[0]+' .missionId').val();
		    					var missionSetId = $('#'+$('#'+pair[0]+' > input.mainDataRowLocation').val()+' > input.missionSetId').val();
		    					var name = $('#'+pair[0]+' > textarea').val();
			    				var host = $('#'+pair[0]+' .subMissionExecutor').attr('name');
			    				var date = $('#'+pair[0]+' .subMissionDate').val();
			    				var sep = date.split('-');
			    				var endTime = (parseInt(sep[0])+1911) + "-" + sep[1] + "-" + sep[2];
			    				var missionPriority = "普通";
			    				console.log( "2.Position",$('#'+pair[0]+' input.subMissionPosition').val() );
			    				var missionPosition = count;
			    				console.log( "3.Position",$('#'+pair[0]+' input.subMissionPosition').val() );
			    				var missionStatus = $('#'+pair[0]+' .subMissionStatus').val();
			    				var mainMissionId2 = $('#'+pair[0]+' .mainDataRowLocation').val().substring(9);
			    				console.log("missionId",missionId);
			    				console.log("missionSetId",missionSetId);
			    				console.log("mainMissionId",mainMissionId);
		 				    	//Update database
			    	    		$.ajax({
			    		    		url:'DynamicUpdateBoardServlet',
			    		    		type:'post',
			    		    		data:{'action':'UpdateMissionPosition',
			    		    			  'missionId':missionId,
			    		    		      'missionSetId':missionSetId,
			    		    		      'name':name,
			    		    		      'host':host,
			    		    		      'endTime':endTime,
			    		    		      'missionPriority':missionPriority,
			    		    		      'missionPosition':missionPosition,
			    		    		      'missionStatus':missionStatus,
			    		    		      'mainMissionId':mainMissionId2},
			    		    		dataType:'json',
			    		    		success:function(result){
			    		    			console.log(result);
			    		    			if(result.result=="succeed"){
			    		    		    	$('#missionId'+ result.mission.missionId +' > input.subMissionPosition').val(result.mission.missionPosition);
			    		    		    }
			    		    			
			    		    			console.log("lastSubMissionId",lastSubMissionId);
			    		    			if( result.mission.missionId == lastSubMissionId ){
			    		    				$("#loadingmodal").closeModal();
			    		    			}
			    		    		},
			    		    		error:function(result){
			    		    		    console.log(result);
			    		    		},
			    		    		beforeSend:function(){
			    		    			if( i == 0 ){
			    		    				$("#loadingmodal").openModal();
			    		    			}
				    	   			}
			    		    	});
	    					}
	    					console.log( "Position",$('#'+pair[0]+' input.subMissionPosition').val() );
							count++;
	    				} 	    					
	    			}
				})
			}
			
			//Set Initail Board from database
			var boardInformation;
			var participatorList;
			var substrStart = window.location.search.lastIndexOf("=") + 1;
			var substrRes =  window.location.search.substr(substrStart);
			var fullProjId = substrRes;
			$.ajax({
    			url:"GetMissionBoardServlet",
    	   		type:'get',
    	   		data:{'fullProjId':fullProjId},
    	   		dataType:'json',
	   			beforeSend:function(){
	   				$("#loadingmodal").openModal();
	   			},
    	   		success:function(result){
    	   			boardInformation = result;
    	   			console.log(result);
    	   			$('#pagetitle > h1').text(boardInformation.missionBoard.boardName);
    	   			
	    	   		//ajax get all participator
	    			$.ajax({
	    				url:'GetParticipatorServlet',
	    		   		type:'get',
	    		   		data:{'missionBoardId':boardInformation.missionBoard.missionBoardId,
	    		   			  'fullProjId':boardInformation.missionBoard.fullProjId },
	    		   		dataType:'json',
	    		   		success:function(result){
	    		   			console.log(result);
	    		   			participatorList = result;
	    				},
	    				error:function(result){
	    					console.log(result);
	    				}
	    			});
	    	   			
	    			if(boardInformation.result == "succeed"){
	    	   			$('.boardName').val(result.missionBoard.boardName);
	    	   			$('.fullProjId').val(result.missionBoard.fullProjId);
	    	   			$('.missionBoardId').val(result.missionBoard.missionBoardId);
	    	   			
	    	   			//Add missionSet from database
	    				$.each(result.missionSets, function(){
	    					var $ul = $('.nested_with_switc');
	    					var title = this.missionSetName;
	    					console.log(title);
	    	    			var $missionSet = $('<li id="missionSetOrderId' + this.missionSetId + '" class="#fff9c4 yellow lighten-4" style=""></li>').html('<div id="missionSet' + this.missionSetId + 
	    	    						'" class="missionTitle #d7ccc8 brown lighten-4" style="height:60px;font-size:22px;line-height:60px;">'+ title +
	    	    						'</div><ul></ul><div class="addMission sortable btn-floating btn-large red">' +
	    	    						'<i class="large material-icons">add</i></div><input type="hidden" class="missionSetOrder" value="' + this.missionSetOrder + '">');
	    	    			
	    	    			console.log("ul element length="+$ul.children('li').length);
	    	    			if( $ul.children('li').length == 0 ){
	    	    				console.log("ul no child! " + title + " append directly");
	    	    				$ul.append($missionSet);
	    	    			} else if( $ul.children('li').length > 0 ){
	    	    				var missionSetOrder = this.missionSetOrder;
	    	    				
	    	    				var temp = 0;
	    	    				$.each($('ul.nested_with_switc .missionSetOrder'),function(){
	    	    					if( this.value < missionSetOrder){
	    	    						temp = Math.max(temp, this.value);
	    	    					}
	    	    				});
	    	    				
	    	    				console.log("temp",temp)
	    	    				if(temp == 0 ){
	    	    					console.log("append at first!");
	    	    					$('ul.nested_with_switc').first().prepend($missionSet);
	    	    				} else {
	    	    					$('ul.nested_with_switc input.missionSetOrder[value=' + temp + ']').parent().after($missionSet);
	    	    				}
	    	    			}
	    	    			var width = $('div > div > ul').width() + 310;
	    	    			$ul.css('width', width);
	    	    			
	    				});
	    	   			
	    				setMissionSortable();
	    	   			
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
	    	   					var $mainMission = $("<li id='missionOrderId" + this.missionId + "'></li>").html("<div class='li_edit btn' style='font-weight:600;'>" + this.name + "</div>" +
	      													  "<div id='missionId"+ this.missionId + "' style='display:none'>" +
	      													  "<input type='text' class='missionExecutor' value='" + this.host + "' name='" + this.memberId + "' >" +
	      													  "<input type='text' class='missionDate' value=" + dateFormat + ">" +
	      													  "<input type='text' class='missionPriority' value=" + this.missionPriority + ">"+
	      													  "<input type='text' class='mainMissionId' value=" + this.mainMissionId + ">" +
	      													  "<input type='text' class='missionPosition' value=" + this.missionPosition + ">" +
	      													  "<input type='text' class='missionStatus' value='" + this.missionStatus + "'>" +
	      													  "<input type='text' class='missionSetId' value='" + this.missionSetId + "'></div>");
	    	   					
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
	    	   					
	    	   					if( this.missionPriority == "非常緊急" && $('#'+$('.dataRowLocation').val()).siblings("div").hasClass('disable') == false ){
	    	   						$('#missionId'+this.missionId).siblings('div').removeClass('#1a237e indigo darken-4');
	    	   						$('#missionId'+this.missionId).siblings('div').addClass('#f44336 red');
	    	   					} else if( this.missionPriority == "緊急" && $('#'+$('.dataRowLocation').val()).siblings("div").hasClass('disable') == false ) {
	    	   						$('#missionId'+this.missionId).siblings('div').removeClass('#f44336 red');
	    	   						$('#missionId'+this.missionId).siblings('div').addClass('#1a237e indigo darken-4');
	    	   					} else {
	    	   						$('#missionId'+this.missionId).siblings('div').removeClass('#1a237e indigo darken-4');
	    	   						$('#missionId'+this.missionId).siblings('div').removeClass('#f44336 red');
	    	   					}

	    	   					if(this.missionStatus=="已完成"){
	        						console.log('主任務: '+this.name+' 已完成');
	        						$('#missionId'+this.missionId).siblings('div').removeClass('#1a237e indigo darken-4');
	    	   						$('#missionId'+this.missionId).siblings('div').removeClass('#f44336 red');
	        						$('#missionId'+this.missionId).siblings('div').addClass('#bdbdbd grey lighten-1 disable').css('text-decoration','line-through');
	        					}
	    	   					
	    	   					
	    	   					
	    	   				} else {
	    	   					//Set subMission sortable
	    	   					setSubMissionSortable();
	    	   					
	    	    	   			//add subMission from database
	    	    	   			var $ul = $('.subMissionContainer ul');
	    	    	   			var $subMission = $('<li class="#81d4fa light-blue lighten-3" style="width:585.906px;height:60px;margin:2px 0px;"></li>').html('<div id="subDataRow' + this.missionId + '" class="row" style="width:585.906px;height:60px;">' +
															'<div class="subMissionSettings col l1"><i class="material-icons" style="padding:10px 0px;font-size:40px;">settings</i></div>' +
															'<div class="col l1" style="padding:15px 12px;"><input type="checkbox" id="subMissionCheckbox'+ this.missionId +'" class="subMissionStatus filled-in" value="' + this.missionStatus + '" >'+
															'<label for="subMissionCheckbox'+ this.missionId +'"></label></div>' +
															'<textarea class="subMissionName col l4 materialize-textarea" placeholder="請輸入子任務內容" style="max-height:45px;">'+ this.name +'</textarea>' +
															'<div class="subMissionDateContainer col l4"><input type="text" class="subMissionDate subDatepicker col l10" value="'+ dateFormat +'" readonly>' +
															'</div>' + '<div class="addSubMissionExecutor col l2"><div class="subMissionExecutor" style="padding:15px 0px;" name="' + this.memberId + '" >'+ this.host +'</div></div>' +
															'<input type="hidden" class="subMissionPriority" value="' + this.missionPriority + '" >' +
															'<input type="hidden" class="subMissionPosition" value="' + this.missionPosition + '" >' +
															'<input type="hidden" class="mainDataRowLocation" value="missionId'+ mainMissionId +'">' + 
															'<input type="hidden" class="missionId" value="' + this.missionId + '"></div>');
	        					
	    	    	   			
	    	    	   			if( $ul.children('li').length == 1 ){
	        	    				$ul.prepend($subMission);
	        	    			} else if( $ul.children('li').length > 1 ){
		    	   					var missionPosition = this.missionPosition;
		    	   					
		    	    				var temp = 0;
		    	    				$.each($('.mainDataRowLocation[value=missionId' + mainMissionId + ']'),function(){
		    	    					if( $(this).siblings('input.subMissionPosition').val() < missionPosition){
		    	    						temp = Math.max(temp, $(this).siblings('input.subMissionPosition').val());
		    	    						console.log(temp);
		    	    					}
		    	    				});
		    	    				
		    	    				//MainMission no child under, just append!
									if( temp == 0 ){
										$ul.prepend($subMission);
									} else {
										$('input[value='+ temp +'].subMissionPosition + input[value=missionId'+ mainMissionId +'].mainDataRowLocation').parent().parent().after($subMission);	
									}
	        	    			}
	    	   					
	    	    	   			if(this.missionStatus=="已完成"){
	    	    					console.log('子任務: ' + this.name + ' 已完成');
	    	    					console.log($('#subDataRow'+this.missionId+' .subMissionStatus'));
	    	    					$('#subDataRow'+this.missionId).parent().removeClass('#81d4fa light-blue lighten-3');
	    	    					$('#subDataRow'+this.missionId).parent().addClass('#bdbdbd grey lighten-1');
	    	    					$('#subDataRow'+this.missionId+' .subMissionStatus').prop('checked',true);
	    	    					$('#subDataRow'+this.missionId).children('textarea').css({'text-decoration':'line-through',
										   													   'color':'#9e9e9e grey'})
	    	    				}
	    	    	   			
								setSubMissionDatepicker();    
								
	    	    				//Set datapicker icon position
	    	    				$('.subMissionDateContainer').siblings('.ui-datepicker-trigger').appendTo('.subMissionDateContainer')
	    	    				
	    	    				$('.subMissionDateContainer img').css({'padding':'15px 0px',
	    	    					  'cursor':'pointer'}).addClass('col l2');
	    	    				
	    	    				$('.subMissionSettings').css({'cursor':'pointer'});
	    	   				}
	    	   			});
    	   			}
    	   		},
    	   		error:function(result){
    	   			console.log(result);
    	   		},
    	   		complete:function(){
    	   			$("#loadingmodal").closeModal();
    	   		}
    	   
       		});
			
			//Define mission sortable in MissionSet
			function setMissionSortable(){
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
    					var orderArray = new Array();
    					var child = $('ul.nested_with_switc > li > ul > li').each(function(){
    						orderArray.push($(this).attr("id")+":"+$(this).parent().siblings('input').val());
    					});
    					console.log("order",orderArray);  
    					
    					var missionSet;
    					var count = 1;
    					for(var i = 0; i < orderArray.length; i++){
    						var pair = orderArray[i].split(":");
    						$('#'+pair[0]+' input.missionSetId').val(pair[1]);
    						
    						
    						if( missionSet != pair[1] ){
    							missionSet = pair[1];
    							count = 1;
    						}
    						
    						//Get last missionId, when last mission ajax send back close modal
    						if( i == orderArray.length - 1  ){
    							var lastMission = $('#'+pair[0]+ ' > div:last-child').attr('id').substring(9);
    						}
    						
    						var missionId = $('#'+pair[0]+ ' > div:last-child').attr('id').substring(9);
    						var missionSetId = $('input[value=' + pair[1] + '].missionSetOrder').siblings('div').first().attr('id').substring(10);
    						console.log("missionSetId!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",missionSetId);
    						var name = $('#'+pair[0]+ ' > div:first-child').text();
    						var host = $('#'+pair[0]+ ' > div:last-child > input.missionExecutor').attr('name');
    						var date =$('#'+pair[0]+ ' > div:last-child > input.missionDate').val();
    						var sep = date.split('-');
    						var endTime = (parseInt(sep[0])+1911) + "-" + sep[1] + "-" + sep[2];
    						var missionPriority = $('#'+pair[0]+ ' > div:last-child > input.missionPriority').val();
    						var missionPosition = count;
    						var missionStatus =  $('#'+pair[0]+ ' > div:last-child > input.missionStatus').val();
    						var mainMissionId = $('#'+pair[0]+ ' > div:last-child > input.mainMissionId').val();
    						
    						console.log("i1",i);
    						
    						//Update database
    	    				$.ajax({
    		    			    url:'DynamicUpdateBoardServlet',
    		    			    type:'post',
    		    			    data:{'action':'UpdateMissionPosition',
    		    			    	  'missionId':missionId,
    		    			    	  'missionSetId':missionSetId,
    		    			    	  'name':name,
    		    			    	  'host':host,
    		    			    	  'endTime':endTime,
    		    			    	  'missionPriority':missionPriority,
    		    			    	  'missionPosition':missionPosition,
    		    			    	  'missionStatus':missionStatus,
    		    			    	  'mainMissionId':mainMissionId},
    		    			    dataType:'json',
    		    			    success:function(result){
    		    			    	console.log(result);
    		    			    	if(result.result == "succeed"){
    		    			    		$('#'+pair[0]+ ' input.missionPosition').val(result.mission.missionPosition);
    		    			    	}
    		    			    	try {
    		    			    		if( result.mission.missionId == lastMission ){
    		        	   				$("#loadingmodal").closeModal();
    		    			    		}
    		    			    	} catch(err){
    		    			    		$("#loadingmodal").closeModal();
    		    			    	}
    		    			    },
    		    			    error:function(result){
    		    			    	console.log("error");
    		    			    	console.log(result);
    		    			    },
    		    			    beforeSend:function(){
    		    			    	if( i == 0 ){
    		    			    		$("#loadingmodal").openModal();
    		    			    	}
    		    	   			}
    		    			});
    						count++;
    					}
    				}
    			})
			}
				
			//Add missionSet
			function addMissionSet() {
				var title = $('#nameTitle').val();
				var missionSetOrder = $('ul.nested_with_switc > li').size() + 1;
				if(title==""){
					title = "MissionSet";
				}
				var missionBoardId = boardInformation.missionBoard.missionBoardId;
				console.log("missionBoardId",missionBoardId);
				var name = title;
				console.log("name",name);
				var missionSetOrder = missionSetOrder;
				console.log("missionSetOrder",missionSetOrder);
				//Update database
				$.ajax({
    			    url:'DynamicUpdateBoardServlet',
    			    type:'post',
    			    data:{'action':'InsertMissionSet',
    			    	  'missionBoardId':missionBoardId,
    			    	  'name':name,
    			    	  'missionSetOrder':missionSetOrder},
    			    dataType:'json',
    			    success:function(result){
    			    	console.log(result);
    			    	if(result.result == "succeed"){
    			    		var $missionSet = $('<li id="missionSetOrderId' + result.missionSet.missionSetId + '" class="#fff9c4 yellow lighten-4"></li>').html('<div id="missionSet' + result.missionSet.missionSetId + 
    								  '" class="missionTitle #d7ccc8 brown lighten-4" style="height:60px;font-size:22px;line-height:60px;">'+ result.missionSet.name +
    								  '</div><ul></ul><div class="addMission sortable btn-floating btn-large red">' +
    								  '<i class="large material-icons">add</i></div></div><input type="hidden" class="missionSetOrder" value="'+ result.missionSet.missionSetOrder + '" >');
	    			    	
    			    		$('.nested_with_switc').append($missionSet);
	    					$('#nameTitle').val("");
	    					setMissionSortable();
    			    	}
    			    },
    			    error:function(result){
    			    	console.log(result);
    			    	console.log("Insert new missionSet failed!");
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});
				
			}
			
			//Add missionSet
			$(document).on('click', '.addBoard', function(){
				addMissionSet();
			});
			
			//Accept add missionSet with enter pressed at input field 
			$(document).on('keypress', '#nameTitle', function(e) {
			    if(e.which == 13) {
			    	addMissionSet();
			    }
			});
			
			//Update mission
			function updateMission(missionId) {
				var missionId = missionId;
				var missionSetId = $('#missionId'+missionId+' > input.missionSetId').val();
				var name = $('#missionId'+missionId).siblings('div').text();
				var host = $('#missionId'+missionId+' > input.missionExecutor').attr('name');
				var date = $('#missionId'+missionId+' > input.missionDate').val();
				var sep = date.split('-');
				var endTime = (parseInt(sep[0])+1911) + "-" + sep[1] + "-" + sep[2];
				var missionPriority = $('#missionId'+missionId+' > input.missionPriority').val();
				var missionPosition = $('#missionId'+missionId+' > input.missionPosition').val();
				var missionStatus =  $('#missionId'+missionId+' > input.missionStatus').val();
				var mainMissionId = $('#missionId'+missionId+' > input.mainMissionId').val();
				
				console.log("missionId",missionId);
				console.log("missionSetId",missionSetId);
				console.log("name",name);
				console.log("host",host);
				console.log("endTime",endTime);
				console.log("missionPriority",missionPriority);
				console.log("missionPosition",missionPosition);
				console.log("missionStatus",missionStatus);
				console.log("mainMissionId",mainMissionId);
				//Update database
				$.ajax({
    			    url:'DynamicUpdateBoardServlet',
    			    type:'post',
    			    data:{'action':'UpdateMission',
    			    	  'missionId':missionId,
    			    	  'missionSetId':missionSetId,
    			    	  'name':name,
    			    	  'host':host,
    			    	  'endTime':endTime,
    			    	  'missionPriority':missionPriority,
    			    	  'missionPosition':missionPosition,
    			    	  'missionStatus':missionStatus,
    			    	  'mainMissionId':mainMissionId},
    			    dataType:'json',
    			    success:function(result){
    			    	console.log(result);
    			    	if(result.result == "succeed"){
    			    		console.log('succeed in!');
    			    		$('#missionId'+missionId+' > input.missionSetId').val(result.mission.missionSetId);
    			    		$('#missionId'+missionId).siblings('div').text(result.mission.name);
    			    		
    			    		$.each(participatorList,function(){
    			    			if(result.mission.host == this.memberId){
    			    				$('#missionId'+missionId+' > input.missionExecutor').val(this.memberName);	
    			    			}
    			    		});
    			    		
    			    		var newDate = result.mission.endTime.split("-");
    			    		$('#missionId'+missionId+' > input.missionDate').val( parseInt(newDate[0]-1911) + "-" + newDate[1] + "-" + newDate[2] );
    			    		$('#missionId'+missionId+' > input.missionPriority').val(result.mission.missionPriority);
    			    		$('#missionId'+missionId+' > input.missionPosition').val(result.mission.missionPosition);
    			    		$('#missionId'+missionId+' > input.missionStatus').val(result.mission.missionStatus);
    			    		$('#missionId'+missionId+' > input.mainMissionId').val(result.mission.mainMissionId);
    			    		
    	   					if( result.mission.missionPriority == "非常緊急" && $('#'+$('.dataRowLocation').val()).siblings("div").hasClass('disable') == false ){
    	   						$('#missionId'+missionId).siblings('div').removeClass('#1a237e indigo darken-4');
    	   						$('#missionId'+missionId).siblings('div').addClass('#f44336 red');
    	   					} else if( result.mission.missionPriority == "緊急" && $('#'+$('.dataRowLocation').val()).siblings("div").hasClass('disable') == false ) {
    	   						$('#missionId'+missionId).siblings('div').removeClass('#f44336 red');
    	   						$('#missionId'+missionId).siblings('div').addClass('#1a237e indigo darken-4');
    	   					} else {
    	   						$('#missionId'+missionId).siblings('div').removeClass('#1a237e indigo darken-4');
    	   						$('#missionId'+missionId).siblings('div').removeClass('#f44336 red');
    	   					}
    			    		
    			    		
    			    	}
    			    },
    			    error:function(result){
    			    	console.log("error");
    			    	console.log(result);
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});
			}
			
			//Add mission
			$(document).on('click','.addMission',function() {
				//ajax get random participator in this fullProj, set to host
				
				var $this = $(this);
    	   		var host = "待認領";
    	   		var hostName = "姓名";
    	   		
    	   		$.each(participatorList.members,function(){
    	   			host = this.memberId;
    	   			hostName = this.memberName;
    	   		})
    	   				
    	   		var missionSetId = $(this).parent().attr('id').substring(17);
    	   		console.log('check missionSetId = '+missionSetId);
    			var name = "新任務";
    			var date = new Date();
    			var endTime = parseInt(date.getYear()+1900) + "-" + parseInt(date.getMonth()+1) + "-" + parseInt(date.getDate());
    			var missionPriority = "普通";
    			var missionPosition = $(this).siblings('ul').children('li').size()+1;
    			var missionStatus =  "進行中";
    			var mainMissionId = "";
    					
    			//Update database
    			$.ajax({
    	    		url:'DynamicUpdateBoardServlet',
    	    		type:'post',
    	    		data:{'action':'InsertMission',
    	    			  'missionSetId':missionSetId,
    	    			  'name':name,
    	    			  'host':host,
    	    			  'endTime':endTime,
    	    			  'missionPriority':missionPriority,
    	    			  'missionPosition':missionPosition,
    	    			  'missionStatus':missionStatus,
    	    			  'mainMissionId':mainMissionId},
    	    		dataType:'json',
    	    		success:function(result){
    	    			console.log(result);
    	    			if(result.result == "succeed"){
    	    				var date = result.mission.endTime.split('-');
							var endTime = parseInt(date[0]-1911) + "-" + date[1] + "-" + date[2];
    	    			    		
    	    			    var $mission = $("<li id='missionOrderId" + result.mission.missionId + "'></li>").html("<div class='li_edit btn'  style='font-weight:600;'>"+ result.mission.name +"</div>" +
    	    								  "<div id='missionId"+ result.mission.missionId + "' style='display:none'>" +
    	    								  "<input type='text' class='missionExecutor' value='" + hostName + "' name='" + result.mission.host + "'>" +
    	    								  "<input type='text' class='missionDate' value='" + endTime + "' >" +
    	    								  "<input type='text' class='missionPriority' value='" + result.mission.missionPriority + "'>"+
    	    								  "<input type='text' class='mainMissionId' value='" + result.mission.mainMissionId + "' >" + 
    	    								  "<input type='text' class='missionPosition' value='" + result.mission.missionPosition + "'>" + 
    	    								  "<input type='text' class='missionStatus' value='" + result.mission.missionStatus + "' >" +
    	    								  "<input type='text' class='missionSetId' value='" + result.mission.missionSetId + "'></div>");
    	    			    		
    	    						
    	    				$mission.appendTo($this.siblings( "ul" ));
    	    				
    	    			    		
    	    			}
    	    		},
    	    		error:function(result){
    	    			console.log("error");
    	    			console.log(result);
    	    		},
    	    		beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    	    	});
				
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
				
				var missionId = $(this).parent().parent().parent().siblings('input.dataRowLocation').val().substring(9);

    	   		$.each(participatorList.members, function(){
    	   					
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
    	   		
    	   		//Assign executor from participator list
    			$('.participator').on('click',function(){
    				$('.missionDetailDialog .missionExecutor').removeClass($('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name'));
    				$('.missionParticipator ul .' + $('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name') + '').remove();
    						
    				$('.missionDetailDialog .missionExecutor').text($(this).children('div').text());
    				$('.missionDetailDialog .missionExecutor').addClass($(this).children('div').attr('class'));
    				$('.missionDetailDialog .missionExecutor').attr('name',$(this).children('div').attr('class'));
    						
    				$('#'+$('.dataRowLocation').val()).find('.missionExecutor').val( $(this).children('div').text() );
    				$('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name',$(this).children('div').attr('class'));
    						
    				if(!$('.missionParticipator ul div').hasClass($(this).children('div').attr('class'))){
    					$('.missionParticipator ul').prepend('<div class="' + $(this).children('div').attr('class') + '" style="width:100px;display:inline-block;">' + $(this).children('div').text() + '</div>');						
    				}
    				$('.popupParticipatorWindow').dialog( "close" );
    			
    				updateMission(missionId);
    				
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
				
				
    	   		$.each(participatorList.members, function(){
    	   			var participatorName = this.memberName;
        			var memberID= this.memberId;
        					
        			var $li = $('<li class="participator"></li>').html('<div class='+ memberID +'>' + participatorName + '</div>');
        			$('.popupParticipatorWindow ul').append($li);
    	   					
        					
        			//Assign subMission executor from participator list
        			$('.participator').unbind().click(function(){
        				var subDataRowId = $(target).parent().parent().attr('id');
        				console.log("subDataRowId="+$(target).parent().parent().attr('id'));
						
        				if(subDataRowId!= void 0 ){
							console.log('this is submission executor!');
							$('#'+subDataRowId+' .addSubMissionExecutor').empty();
							$('#'+subDataRowId+' .addSubMissionExecutor').append('<div class="subMissionExecutor" style="padding:15px 0px;" name="' + $(this).children('div').attr('class') + '">'+ $(this).text() +'</div>');
						} else {
							console.log("main input field for select executor!");
        					$('.subMission .addSubMissionExecutor').empty();
        					$('.subMission .addSubMissionExecutor').append('<div class="subMissionExecutor" name="' + $(this).children('div').attr('class') + '" >'+ $(this).text() +'</div>');
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
    	   				
				
			});
			
			
			//Add missionParticipator
			$(document).on('click', '.addParticipator', function(){
				var missionId =$(this).parent().parent().parent().parent().siblings('input').val();
				
				var pos =  $(this).position();
				$('.popupParticipatorWindow').dialog("option", "position", {
                    my: "top",
                    at: "center",
                    of: event,
                });
				$('.popupParticipatorWindow').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				$('.popupParticipatorWindow ul').empty();
				
    	   		$.each(participatorList.members, function(){
    	   					
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
    					console.log("remove participator from list");
    							
    					var memberId = $(this).children('div').attr('class');
    					$.ajax({
    			    		url:'MissionParticipatorControllerServlet',
    			    		type:'post',
    			    		data:{'action':'delete',
    			    		  	  'memberId':$(this).children('div').attr('class'),
    			    		      'missionId':missionId.substring(9) },
    			    		success:function(result){
    			    	   		console.log(result);
    			    	   		
    			    	   		
    			    	   		$('.missionParticipator > ul > div.' + memberId + '').remove();
    			    		},
    			    		error:function(result){
    			    	   		console.log(result);
    			    		},
    			    		beforeSend:function(){
    			   				$("#loadingmodal").openModal();
    			   			},
    		    	   		complete:function(){
    		    	   			$("#loadingmodal").closeModal();
    		    	   		}
    					});
    							
    							
    				} else {
    					console.log("add participator to list");
    							
    					$.ajax({
    			    		url:'MissionParticipatorControllerServlet',
    			    		type:'post',
    			    		data:{'action':'insert',
    			    	   	  	  'memberId':$(this).children('div').attr('class'),
    			    	   	  	  'missionId':missionId.substring(9) },
    			    		dataType:'json',
    			    		success:function(result){
    			    	   		console.log(result);
    			    	   		
    			    	   		var participatorName;
    			    	   		$.each(participatorList.members, function(){
    			    	   			if(result.participator.memberId == this.memberId){
    			    	   				participatorName = this.memberName;
    			    	   			}
    			    	   		});
    			    	   		
    			    	   		$('.missionParticipator ul').prepend('<div class="' + result.participator.memberId + '" style="width:100px;display:inline-block;">' + participatorName + '</div>');
    			    		},
    			    		error:function(result){
    			    	   		console.log(result);
    			    		},
    			    		beforeSend:function(){
    			   				$("#loadingmodal").openModal();
    			   			},
    		    	   		complete:function(){
    		    	   			$("#loadingmodal").closeModal();
    		    	   		}
    					});
    				}
    						
    			});
				
			});
			
			//Add subMission
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
				$(event.target).siblings('div').find('.subMissionName').val('');
				$(event.target).siblings('div').find('.subMissionDate').val('');
				$(event.target).siblings('div').find('.addSubMissionExecutor').html('<img src="images/memberIcon.png">');

				$('.subMission').show();
			})
			
			$('.addSubMission').on('click',function(){
				var missionSetId = $('#'+$('.dataRowLocation').val()).children('input.missionSetId').val();
				var name = $('.subMission .subMissionName').val();
				var host = $('.subMission .subMissionExecutor').attr('name');
				var date = $('.subMission .subMissionDate').val().split('-');
				var endTime = parseInt(date[0])+1911 + "-" + date[1] + "-" + date[2];
				var missionPriority = "普通";
				var missionPosition = $('.subMissionContainer ul li div input[value=' + $('.dataRowLocation').val() + '].mainDataRowLocation').size()+1;
				var missionStatus =  "進行中";
				var mainMissionId = $('.dataRowLocation').val().substring(9);
				
				console.log('test',$('.dataRowLocation').val());
				console.log("missionSetId",missionSetId);
				console.log("name",name);
				console.log("host",host);
				console.log("endTime",endTime);
				console.log("missionPriority",missionPriority);
				console.log("missionPosition",missionPosition);
				console.log("missionStatus",missionStatus);
				console.log("mainMissionId",mainMissionId);
				//Update database
				$.ajax({
    			    url:'DynamicUpdateBoardServlet',
    			    type:'post',
    			    data:{'action':'InsertMission',
    			    	  'missionSetId':missionSetId,
    			    	  'name':name,
    			    	  'host':host,
    			    	  'endTime':endTime,
    			    	  'missionPriority':missionPriority,
    			    	  'missionPosition':missionPosition,
    			    	  'missionStatus':missionStatus,
    			    	  'mainMissionId':mainMissionId},
    			    dataType:'json',
    			    success:function(result){
    			    	console.log(result);
    			    	if(result.result == "succeed"){
    			    		var date = result.mission.endTime.split('-');
							var endTime = parseInt(date[0]-1911) + "-" + date[1] + "-" + date[2];
    			    		
							var hostName;
							$.each(participatorList.members,function(){
								if(this.memberId == result.mission.host){
									hostName = this.memberName;
									console.log('hostName',hostName);
								}
							});
							
    						var $subMission = $('<li class="#81d4fa light-blue lighten-3" style="width:585.906px;height:60px;margin:2px 0px;"></li>').html('<div id="subDataRow' + result.mission.missionId + '" class="row" style="width:585.906px;height:60px;">' +
									'<div class="subMissionSettings col l1"><i class="material-icons" style="padding:10px 0px;font-size:40px;">settings</i></div>' +
									'<div class="col l1" style="padding:15px 12px;"><input type="checkbox" id="subMissionCheckbox'+ result.mission.missionId +'" class="subMissionStatus filled-in" value="進行中" >'+
									'<label for="subMissionCheckbox'+ result.mission.missionId +'"></label></div>' +
									'<textarea class="subMissionName col l4 materialize-textarea" placeholder="請輸入子任務內容" style="max-height:45px;">'+ result.mission.name +'</textarea>' +
									'<div class="subMissionDateContainer col l4"><input type="text" class="subMissionDate subDatepicker col l10" value="'+ endTime +'" readonly>' +
									'</div>' + '<div class="addSubMissionExecutor col l2"><div class="subMissionExecutor" style="padding:15px 0px;" name="' + result.mission.host + '">'+
									hostName +'</div></div>' +
									'<input type="hidden" class="subMissionPriority" value="普通" >' +
									'<input type="hidden" class="subMissionPosition" value="' + result.mission.missionPosition + '">' +
									'<input type="hidden" class="mainDataRowLocation" value="missionId'+ result.mission.mainMissionId +'">' +
									'<input type="hidden" class="missionId" value="' + result.mission.missionId + '"></div>');
							
    						$('.subMissionContainer ul li.notSortable').before($subMission);
							$('.subMission').hide();
							$('.openSubMissionWindow').css('display','block');
							
							setSubMissionSortable();
							setSubMissionDatepicker();
							
							//Set datapicker icon position
							$('.subMissionDateContainer').siblings('.ui-datepicker-trigger').appendTo('.subMissionDateContainer')
							
							$('.subMissionDateContainer img').css({'padding':'15px 0px',
							  'cursor':'pointer'}).addClass('col l2');
							
							$('.subMissionSettings').css({'cursor':'pointer'});
							
    			    	}
    			    },
    			    error:function(result){
    			    	console.log("error");
    			    	console.log(result);
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});
				
				
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
			
			
			
			//Transfer subMission to Mission
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
				var date = $('#'+subMissionId+' .subMissionDate').val().split("-");
				var subMissionDate = parseInt(date[0])+1911 + "-" + date[1] + "-" + date[2];
				console.log("subMissionDate="+subMissionDate);
				var subMissionExecutor = $('#'+subMissionId+' .subMissionExecutor').attr('name');
				console.log("subMissionExecutor="+subMissionExecutor);
				
				var missionSetId = $('#'+mainMissionId).parent().parent().siblings('div.missionTitle').attr('id').substring(10);
				console.log("missionSetId="+missionSetId);
				
				var missionId = $('#'+$('.subMissionLocation').val()).children('input[class="missionId"]').val();
				console.log("missionId="+missionId);
				var subDataRowId = $('.subMissionLocation').val().substring(10);
				//NewPos contain parent li itself +1, and next Pos will be the slot to put +1
				var newPos = $('#'+mainMissionId).parent().siblings().size() + 1 + 1;
				
				//Update database
    			$.ajax({
    	    		url:'DynamicUpdateBoardServlet',
    	    		type:'post',
    	    		data:{'action':'UpdateMission',
    	    			  'missionId':missionId,
    	    			  'missionSetId':missionSetId,
    	    			  'name':subMissionName,
    	    			  'host':subMissionExecutor,
    	    			  'endTime':subMissionDate,
    	    			  'missionPriority':"普通",
    	    			  'missionPosition':newPos,
    	    			  'missionStatus':subMissionStatus,
    	    			  'mainMissionId':""},
    	    		dataType:'json',
    	    		success:function(result){
    	    			console.log(result);
    	    			if(result.result == "succeed"){
    	    				
    	    				var date = result.mission.endTime.split('-');
							var endTime = parseInt(date[0]-1911) + "-" + date[1] + "-" + date[2];
							
							var hostName;
							$.each(participatorList.members,function(){
								if(this.memberId == result.mission.host){
									hostName = this.memberName;
									console.log('hostName',hostName);
								}
							});
							
    	    				var $mission = $("<li id='missionOrderId" + result.mission.missionId + "'></li>").html("<div class='li_edit btn'  style='font-weight:600;'>"+ result.mission.name +"</div>" +
    	  						  "<div id='missionId"+ result.mission.missionId + "' style='display:none'>" +
    	  						  "<input type='text' class='missionExecutor' value='" + hostName + "' name='" + result.mission.host + "'>" +
    	  						  "<input type='text' class='missionDate' value='" + endTime + "' >" +
    	  						  "<input type='text' class='missionPriority' value='" + result.mission.missionPriority + "'>"+
    	  						  "<input type='text' class='mainMissionId' value='" + result.mission.mainMissionId + "' >" + 
    	  						  "<input type='text' class='missionPosition' value='" + result.mission.missionPosition + "'>" + 
    	  						  "<input type='text' class='missionStatus' value='" + result.mission.missionStatus + "' >" +
    	  						"<input type='text' class='missionSetId' value='" + result.mission.missionSetId + "'></div>");
    	    				

    	    				$('#missionSet'+result.mission.missionSetId).siblings('ul').append($mission);
    	    				
    	    				if( result.mission.missionStatus == "已完成" ){
    	    					console.log('任務已完成');
    	    					console.log($('#missionId'+missionId).siblings('div'));
    	    					$('#missionId'+result.mission.missionId).siblings('div').addClass('#bdbdbd grey lighten-1 disable').css('text-decoration','line-through');
    	    				}
    			    		
    	    				$('#'+$('.subMissionLocation').val()).parent().remove();
    			    		$('.subMissionSettingsDialog').dialog( "close" );		
    	    					
    	    			}
    	    		},
    	    		error:function(result){
    	    			console.log("error");
    	    			console.log(result);
    	    		},
    	    		beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    	    	});
				
				
			});			
			
			//DeleteSubMission
			$('#deleteSubMission').click(function(){
				var deletePos = $('#'+$('.subMissionLocation').val()).children('input.subMissionPosition').val();
				console.log("deletePos",deletePos);
				var mainMission = $('#'+$('.subMissionLocation').val()).children('input.mainDataRowLocation').val();
				console.log("mainMission",mainMission);
				
				$('div.subMissionContainer > ul > li > div > input[value=' + mainMission + '].mainDataRowLocation').each(function(){
					var oldPos = $(this).siblings('input.subMissionPosition').val();
					console.log("oldPos",oldPos);
					
					if( oldPos > deletePos ){
						var newPos = oldPos -1;
						$(this).siblings('input.subMissionPosition').val(newPos);
					}
					console.log("newPos",$(this).siblings('input.subMissionPosition').val());
					
				});
				
				var missionId = $('#'+$('.subMissionLocation').val()+' input.missionId').val();
				$.ajax({
    			    url:'DynamicUpdateBoardServlet',
    			    type:'post',
    			    data:{'action':'DeleteMission',
    			    	  'missionId':missionId},
    			    success:function(responseText){
    			    	console.log(responseText);
    			    	if( responseText == "succeed"){
    			    		$('#'+$('.subMissionLocation').val()).parent().remove();
    			    		$('.subMissionSettingsDialog').dialog( "close" );		
    			    	}
    			    },
    			    error:function(result){
    			    	console.log("error!!!!!",result);
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});
				
				
			});			
			
			
			
			//Set missionTitle dialog close condition
			$('#confirmMissionSet').click(function(){
				$('.setMissionTitleDialog').dialog( "close" );
			});			
			$('#deleteMissionSet').click(function(){
				var deletePos = $('#'+$('.titleLocation').val()).siblings('input').val();
				console.log("deleteMissionSetPos",deletePos);
				
				var deleteCondition = true;
				$('ul.nested_with_switc > li').each(function(index, value){
					var oldPos = $(this).children('input.missionSetOrder').val();
					console.log("oldPos",oldPos);
					var newPos = oldPos;
					if( oldPos > deletePos){
						newPos = oldPos -1;
					}
					console.log("newPos",newPos);
					
					var $this = $(this);
					var missionSetOrder = newPos;
					console.log("missionSetOrder",missionSetOrder);
					var missionSetId = $(this).children('div:first-child').attr('id').substring(10);
					console.log("missionSetId",missionSetId);
					var name =$(this).children('div:first-child').text();
					console.log("name",name);
					var missionBoardId = boardInformation.missionBoard.missionBoardId;
					console.log("missionBoardId",missionBoardId);
					$.ajax({
	    			    url:'DynamicUpdateBoardServlet',
	    			    type:'post',
	    			    data:{'action':'UpdateMissionSetOrder',
	    			    	  'missionSetOrder':missionSetOrder,
	    			    	  'missionSetId':missionSetId,
	    			    	  'name':name,
	    			    	  'missionBoardId':missionBoardId},
	    			    dataType:'json',
	    			    success:function(result){
	    			    	console.log(result);
	    			    	if(result.result == "succeed"){
	    			    		$this.children('input.missionSetOrder').val(result.missionSet.missionSetOrder);
	    			    	} else {
	    			    		deleteCondition = false;
	    			    	}
	    			    },
	    			    error:function(result){
	    			    	console.log(result);
	    			    }
	    			});
					
				});
				
				
					
				var missionSetId = $('.titleLocation').val().substring(10);
				$.ajax({
	    			url:'DynamicUpdateBoardServlet',
	    			type:'post',
	    			data:{'action':'DeleteMissionSet',
	    			      'missionSetId':missionSetId},
	    			success:function(result){
	    				console.log(result);
	    				if(result == "succeed"){
	    					$('#'+$('.titleLocation').val()).parent().hide('slow', function(){ $(this).remove(); });
	    		    		$('.setMissionTitleDialog').dialog( "close" );
	    				} else {
	    			    console.log("delete failed");
	    				}
	    			},
	    			error:function(result){
	    			    console.log(result);
	    			},
	    			beforeSend:function(){
		   				$("#loadingmodal").openModal();
		   			},
	    	   		complete:function(){
	    	   			$("#loadingmodal").closeModal();
	    	   		}
	    		});

				
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
				var missionId = $(div).siblings('div').attr('id');
				var dataName = $(div).text();
				var dataExecutor = $(div).siblings("div").children(".missionExecutor").val();
				var dataDate = $(div).siblings("div").children(".missionDate").val();
				var dataPriority = $(div).siblings("div").children(".missionPriority").val();
				var dataExecutorId = $(div).siblings("div").children(".missionExecutor").attr("name");
				
				//Ajax get missionParticipator
				$.ajax({
    			    url:'MissionParticipatorControllerServlet',
    			    type:'post',
    			    data:{'action':'get',
    			    	  'missionId':missionId.substring(9)},
    			    dataType:'json',
    			    success:function(result){
    			    	$('.missionParticipator ul').empty();
    			    	
    			    	$.each(result,function(){
    			    		console.log(this.memberName);
    			    		console.log(this.memberId);
    			    		$('.missionParticipator ul').append('<div class="' + this.memberId + '" style="width:100px;display:inline-block;">' + this.memberName + '</div>');
    			    	});
    			    	
    					$('.missionParticipator ul').first().prepend('<div class="' + dataExecutorId + '" style="width:100px;display:inline-block;">' + dataExecutor + '</div>');
    					$('.missionParticipator ul').last().append('<div class="addParticipator btn-floating btn #2196f3 blue"><i class="material-icons">add</i></div>')
    			    },
    			    error:function(result){
    			    	console.log(result);
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});


				
				
				var temp = $(div).siblings("div").attr('id');
				$('.missionDetailDialog .missionName').val(dataName);
				$('.missionDetailDialog .missionExecutor').text(dataExecutor);
				$('.missionDetailDialog .missionExecutor').attr('name',dataExecutorId);
				$('.missionDetailDialog .missionDate').val(dataDate);
				
				
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
			
			//Set dialog change to missionSet
			$('.setMissionTitleDialog .missionTitle').on('change',function(){
				console.log($('.titleLocation').val());
				$('#'+$('.titleLocation').val()).text($(this).val());
				
				var missionSetOrder = $('#'+$('.titleLocation').val()).siblings('input.missionSetOrder').val();
				console.log("missionSetOrder",missionSetOrder);
				var missionSetId = $('#'+$('.titleLocation').val()).attr('id').substring(10);
				console.log("missionSetId",missionSetId);
				var name = $(this).val();
				console.log("name",name);
				var missionBoardId = boardInformation.missionBoard.missionBoardId;
				console.log("missionBoardId",missionBoardId);
				$.ajax({
    			    url:'DynamicUpdateBoardServlet',
    			    type:'post',
    			    data:{'action':'UpdateMissionSetName',
    			    	  'missionSetOrder':missionSetOrder,
    			    	  'missionSetId':missionSetId,
    			    	  'name':name,
    			    	  'missionBoardId':missionBoardId},
    			    dataType:'json',
    			    success:function(result){
    			    	console.log(result);
    			    	if(result.result == "succeed"){
    			    		$('#'+$('.titleLocation').val()).text(result.missionSet.name);
    			    	} else {
    			    		console.log(name);
    			    		deleteCondition = false;
    			    		console.log("Update missionSet order failed!");
    			    	}
    			    },
    			    error:function(result){
    			    	console.log(result);
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});
			});
			
			
			//Set dialog change to mission
			$('.missionDetailDialog .missionName').on('change',function(){
				$('#'+$('.dataRowLocation').val()).siblings("div").text($(this).val());
				updateMission($('.dataRowLocation').val().substring(9));
			});
			$('.missionDetailDialog .missionPriority').on('change',function(){
				$('#'+$('.dataRowLocation').val()).find('.missionPriority').val($(this).val());
				updateMission($('.dataRowLocation').val().substring(9));
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
					$('#'+$('.dataRowLocation').val()).siblings("div").css('text-decoration','none');
					$('#'+$('.dataRowLocation').val()+' .missionStatus').val('進行中');
					
					console.log($('#'+$('.dataRowLocation').val()+' .missionStatus').val());
					
					updateMission($('.dataRowLocation').val().substring(9));
				} else {
					$('#missionId'+this.missionId).siblings('div').removeClass('#1a237e indigo darken-4');
					$('#missionId'+this.missionId).siblings('div').removeClass('#f44336 red');
					$('#'+$('.dataRowLocation').val()).siblings("div").addClass('disable');
					$('.missionDetailDialog .missionName').addClass('disable');
					$(event.target).prop('checked',true);
					$('#'+$('.dataRowLocation').val()).siblings("div").addClass('#bdbdbd grey lighten-1');
					$('#'+$('.dataRowLocation').val()).siblings("div").css('text-decoration','line-through');
					$('#'+$('.dataRowLocation').val()+' .missionStatus').val('已完成');
					
					console.log($('#'+$('.dataRowLocation').val()+' .missionStatus').val());
					
					updateMission($('.dataRowLocation').val().substring(9));
				}
			});
			
			//Update subMission
			function updateSubMission(missionId){
				var missionId = missionId;
				var missionSetId = $('#'+$('input[value=' + missionId + '].missionId').siblings('input.mainDataRowLocation').val()).children('input.missionSetId').val();
				var name = $('input[value=' + missionId + '].missionId').siblings('textarea').val();
				var host = $('input[value=' + missionId + '].missionId').siblings('div.addSubMissionExecutor').children('div').attr('name');
				var date = $('input[value=' + missionId + '].missionId').siblings('div.subMissionDateContainer').children('input').val();
				var sep = date.split('-');
				var endTime = (parseInt(sep[0])+1911) + "-" + sep[1] + "-" + sep[2];
				var missionPriority = $('input[value=' + missionId + '].missionId').siblings('input.subMissionPriority').val();
				var missionPosition = $('input[value=' + missionId + '].missionId').siblings('input.subMissionPosition').val();
				var missionStatus =  $('input[value=' + missionId + '].missionId').siblings('div').children('input.subMissionStatus').val();
				
				var mainMissionId = $('input[value=' + missionId + '].missionId').siblings('input.mainDataRowLocation').val().substring(9);
				
				console.log("missionId",missionId);
				console.log("missionSetId",missionSetId);
				console.log("name",name);
				console.log("host",host);
				console.log("endTime",endTime);
				console.log("missionPriority",missionPriority);
				console.log("missionPosition",missionPosition);
				console.log("missionStatus",missionStatus);
				console.log("mainMissionId",mainMissionId);
				//Update database
				$.ajax({
    			    url:'DynamicUpdateBoardServlet',
    			    type:'post',
    			    data:{'action':'UpdateMission',
    			    	  'missionId':missionId,
    			    	  'missionSetId':missionSetId,
    			    	  'name':name,
    			    	  'host':host,
    			    	  'endTime':endTime,
    			    	  'missionPriority':missionPriority,
    			    	  'missionPosition':missionPosition,
    			    	  'missionStatus':missionStatus,
    			    	  'mainMissionId':mainMissionId},
    			    dataType:'json',
    			    success:function(result){
    			    	console.log(result);
    			    	if(result.result == "succeed"){
    			    		console.log('succeed in!');
    			    		
    						$('input[value=' + missionId + '].missionId').siblings('textarea').val(result.mission.name);
    						
    						$.each(participatorList,function(){
    			    			if(result.mission.host == this.memberId){
    			    				$('input[value=' + missionId + '].missionId').siblings('div.addSubMissionExecutor').children('div').text(this.memberName);
    			    				$('input[value=' + missionId + '].missionId').siblings('div.addSubMissionExecutor').children('div').attr('name',this.memberId);
    			    			}
    			    		});
    						
    						var newDate = result.mission.endTime.split("-");
    						$('input[value=' + missionId + '].missionId').siblings('div.subMissionDateContainer').children('input').val(parseInt(newDate[0]-1911) + "-" + newDate[1] + "-" + newDate[2]);
    						$('input[value=' + missionId + '].missionId').siblings('input.subMissionPriority').val(result.mission.missionPriority);
    						$('input[value=' + missionId + '].missionId').siblings('input.subMissionPosition').val(result.mission.missionPosition);
    						$('input[value=' + missionId + '].missionId').siblings('div').children('input.subMissionStatus').val(result.mission.missionStatus);
    						$('input[value=' + missionId + '].missionId').siblings('input.mainDataRowLocation').val("missionId"+result.mission.mainMissionId);
    			    		
    			    		
    			    		console.log("main Mission ID",$('input[value=' + missionId + '].missionId').siblings('input.mainDataRowLocation').val());
    			    		
    			    		
    			    	}
    			    },
    			    error:function(result){
    			    	console.log("error");
    			    	console.log(result);
    			    },
    			    beforeSend:function(){
    	   				$("#loadingmodal").openModal();
    	   			},
        	   		complete:function(){
        	   			$("#loadingmodal").closeModal();
        	   		}
    			});
			}
			
			
			//Set checkbox status, define add line-through to subMissionTitle or not
			$(document).on('click','.subMissionStatus',function() {
				console.log(event.target);
				if( $(event.target).prop('checked') == true ){
					$(event.target).val('已完成');
					$(event.target).parent().parent().parent().removeClass('#81d4fa light-blue lighten-3');
					$(event.target).parent().parent().parent().addClass('#bdbdbd grey lighten-1');
					$(event.target).parent().siblings('textarea').css({'text-decoration':'line-through',
																	   'color':'#9e9e9e grey'});
					
					updateSubMission($(event.target).parent().siblings('input.missionId').val());
				} else {
					$(event.target).val('進行中');
					$(event.target).parent().parent().parent().removeClass('#bdbdbd grey lighten-1');
					$(event.target).parent().parent().parent().addClass('#81d4fa light-blue lighten-3');
					$(event.target).parent().siblings('textarea').css({'text-decoration':'none',
																	   'color':'black'});
					
					updateSubMission($(event.target).parent().siblings('input.missionId').val());
				}
			});
			
			//Send change when subMissionName changed 
			$(document).on('change','.subMissionName',function(){
				updateSubMission($(event.target).siblings('input.missionId').val());
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
	        			updateMission($('.dataRowLocation').val().substring(9));
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