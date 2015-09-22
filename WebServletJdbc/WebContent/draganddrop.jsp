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
			
			//Set datepicker icon position
			$('.missionDate').siblings('.ui-datepicker-trigger').css({'position':'relative',
												'top':'-45px',
												'left':'150px',
												'cursor':'pointer'});
			
			$('.subMission .ui-datepicker-trigger').css({'position':'relative',
														 'top':'20px',
														 'left':'-20px',
														 'cursor':'pointer'});
			//Set mouseenter event
			$('.addSubMissionExecutor').mouseenter(function(){
				$(this).css({'cursor':'pointer'});
			})
			
			
			
			//Define container for mission board
			$("ul.nested_with_switc").sortable({
				cursor : 'move',
				toleranceElement : '> div',
				item : 'li', //Specifies which items inside the element should be sortable.
				connectWith : 'ul.nested_with_switc', //A selector of other sortable elements that the items from this list should be connected to.
				handle : 'div',
				placeholder : 'ui-state-highlight',
			})
			
			
			//Set trash can
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
    					var title = this.missionSetName;
    					console.log(title);
    	    			var $li = $('<li class="#cddc39 lime" style=""></li>').html('<div id="missionSet' + this.missionSetId + 
    	    						'" class="missionTitle #ff5722 deep-orange" style="height:60px;font-size:22px;line-height:60px;">'+ title +
    	    						'</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
    	    						'<i class="large material-icons">add</i></div>');
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
    	    			
    	    			
    	    			missionSetCount++;
    				});
    	   			
    	   			
    	   			//Add mission from database
    	   			$.each(result.missions, function(){
    	   				//format date from yyyy-mm-dd to 民國
    	   				var date = new Date(Date.parse(this.missionEndTime));
    	   				var year = date.getYear()-11;
    	   				var month = date.getMonth() + 1;
    	   				var day = date.getDate();
    	   				var dateFormat = year + "-" + month + "-" + day;
    	   				
    	   				var $li = $("<li></li>").html("<div class='li_edit waves-effect waves-light btn'>" + this.name + "</div>" +
    							  "<div id='dataRow"+ this.missionId + "' style='display:none'>" +
    							  "<input type='text' class='missionExecutor' value='" + this.host + "' name='" + this.memberId + "' >" +
    							  "<input type='text' class='missionDate' value=" + dateFormat + ">" +
    							  "<input type='text' class='missionPriority' value=" + this.missionPriority + ">"+
    							  "<input type='text' class='mainMissionId' value=" + this.mainMissionId + "></div>");
    	   				$('#missionSet'+ this.missionSetId +'').siblings('ul').append($li);
    	   				
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
				var $li = $('<li class="#cddc39 lime" style=""></li>').html('<div id="missionSet' + missionSetCount + 
						  '" class="missionTitle #ff5722 deep-orange" style="height:60px;font-size:22px;line-height:60px;">'+ title +
						  '</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
						  '<i class="large material-icons">add</i></div>');
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
					var $li = $('<li class="#cddc39 lime"></li>').html('<div id="missionSet' + missionSetCount + 
							  '" class="missionTitle #ff5722 deep-orange" style="height:60px;font-size:22px;line-height:60px;">'+ title +
							  '</div><ul></ul><div class="addMission sortable btn-floating btn-large waves-effect waves-light red">' +
							  '<i class="large material-icons">add</i></div>');
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
				var $li = $("<li></li>").html("<div class='li_edit waves-effect waves-light btn'>Mission"+ missionCount +"</div>" +
						  "<div id='dataRow"+ missionCount + "' style='display:none'>" +
						  "<input type='text' class='missionExecutor' value='待認領' >" +
						  "<input type='text' class='missionDate'>" +
						  "<input type='text' class='missionPriority'>"+
						  "<input type='text' class='mainMissionId' ></div>");
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
        						$('.dialog .missionExecutor').removeClass($('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name'));
        						$('.missionParticipator ul .' + $('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name') + '').remove();
        						
        						$('.dialog .missionExecutor').text($(this).children('div').text());
        						$('.dialog .missionExecutor').addClass($(this).children('div').attr('class'));
        						
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
        						
        						$('.addSubMissionExecutor').empty();
        						$('.addSubMissionExecutor').append('<div>'+ $(this).text() +'</div>');
//         						$('.dialog .missionExecutor').removeClass($('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name'));
//         						$('.missionParticipator ul .' + $('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name') + '').remove();
        						
//         						$('.dialog .missionExecutor').text($(this).children('div').text());
//         						$('.dialog .missionExecutor').addClass($(this).children('div').attr('class'));
        						
//         						$('#'+$('.dataRowLocation').val()).find('.missionExecutor').val( $(this).children('div').text());
//         						$('#'+$('.dataRowLocation').val()).find('.missionExecutor').attr('name',$(this).children('div').attr('class'));
        						
//         						if(!$('.missionParticipator ul div').hasClass($(this).children('div').attr('class'))){
//         							$('.missionParticipator ul').prepend('<div class="' + $(this).children('div').attr('class') + '" style="width:100px;display:inline-block;">' + $(this).children('div').text() + '</div>');						
//         						}
        						
        						
        						$('.popupParticipatorWindow').dialog( "close" );
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
//     							$('.missionParticipator ul').prepend($(this));
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
			$('.addSubMission').mouseenter(function(){
					$(this).css({'font-weight':'bold',
								 'cursor':'pointer',
								 'color':'#0d47a1 blue darken-4'});
				}).mouseleave(function(){
					$(this).css({'font-weight':'normal',
						 		 'color':'black'});
				});
			$('.addSubMission').on('click',function(){
				var parent = $(this).parent();
				$(this).remove();
				$('.subMission').show();
				
				
			})
			
			
			
			
			
			//Set popup dialog close condition
			$('#commit').click(function(){
				$('.popupWindow').dialog( "close" );
			});			
			$('#delete').click(function(){
				$('#'+$('.titleLocation').val()).parent().hide('slow', function(){ $(this).remove(); });
				$('.popupWindow').dialog( "close" );			
			});			
			$(document).on('keypress', '.missionTitle', function(e) {
				if(e.which == 13) {
					$('.popupWindow').dialog( "close" );
				}
			});
			
			
			//Change missionTitle, define popup dialog position
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
			
			
			//Get initial mission information and set to dialog
			$(document).on('click','.li_edit',function() {
				if($('.dialog').dialog( "isOpen" )){
					$('.dialog').dialog( "close" );
				}
				var div = event.target;
				var dataName = $(div).text();
				var dataExecutor = $(div).siblings("div").children(".missionExecutor").val();
				var dataDate = $(div).siblings("div").children(".missionDate").val();
				var dataPriority = $(div).siblings("div").children(".missionPriority").val();
				var dataExecutorId = $(div).siblings("div").children(".missionExecutor").attr("name");
				
				var temp = $(div).siblings("div").attr('id');
				$('.dialog .missionName').val(dataName);
				$('.dialog .missionExecutor').text(dataExecutor);
				$('.dialog .missionDate').val(dataDate);
				
				$('.missionParticipator ul').empty();
				
				$('.missionParticipator ul').prepend('<div class="' + dataExecutorId + '" style="width:100px;display:inline-block;">' + dataExecutor + '</div>');
				$('.missionParticipator ul').append('<div class="addParticipator btn-floating btn waves-effect waves-light #2196f3 blue"><i class="material-icons">add</i></div>')
				
				if($(event.target).hasClass('disable')){
					$('.dialog .missionStatus').prop('checked', true);
					$('.dialog .missionName').addClass('disable');
				} else {
					$('.dialog .missionStatus').prop('checked', false);
					if($('.dialog .missionName').hasClass('disable')) {
						$('.dialog .missionName').removeClass('disable');
					}
				}
				if(dataPriority == "普通" || dataPriority == "緊急" || dataPriority == "非常緊急" ){
					$('.dialog .missionPriority option[value=' + dataPriority + ']').prop('selected', true);
				} else {
					$('.dialog .missionPriority option[value="普通"]').attr("selected", "selected");
				}
				$('.dialog .dataRowLocation').val(temp);
				
				$('.dialog').dialog( "open" );
				$(".ui-dialog-titlebar").hide();
				
			
				
			});
			
			
			
			$('.cancelSubMission').on('click',function(){
				$('.subMission').hide();
			})
			
			
			
			//Set dialog change to dataRow
			$('.popupWindow .missionTitle').on('change',function(){
				console.log($('.titleLocation').val());
				$('#'+$('.titleLocation').val()).text($(this).val());
			});			
			$('.dialog .missionName').on('change',function(){
				$('#'+$('.dataRowLocation').val()).siblings("div").text($(this).val());
			});
			$('.dialog .missionPriority').on('change',function(){
				$('#'+$('.dataRowLocation').val()).find('.missionPriority').val($(this).val());
			});
			
			
			
			//Set popup dialog
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
			
	
			//Set mission dialog		
			$('.dialog').dialog({
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
		                $('.dialog').dialog('close');
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
	
	<div class="popupParticipatorWindow">
		<ul style="list-style:url('images/memberIcon.png') none inside;">
		</ul>
	</div>
	
	
	<div class="dialog">
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
							<ul class="col l12" style="column-count:4;column-gap:0;">
								<li>
									<div class="addSubMission">添加子任務</div>
									<div class="subMission row" style="display:none">
										<div class="row">
											<textarea class="col l7" placeholder="請輸入子任務內容"></textarea> 
							    			<input type="text" id="subDatepicker" class="col l3" readonly>
							    			<div class="addSubMissionExecutor col l2">
							   					<img src="images/memberIcon.png">
							   				</div>
							   			</div>
							   			<div class="row">
							   			<div class="btn waves-effect waves-light #2196f3 blue" >新增</div>
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
	
	<script type="text/javascript">
		//Set checkbox status, define add line-through to missionTitle or not
		$('.dialog .missionStatus').on('click',function() {
			if($('#'+$('.dataRowLocation').val()).siblings("div").hasClass('disable')) {
				$('.dialog .missionName').removeClass('disable');
				$('#'+$('.dataRowLocation').val()).siblings("div").removeClass('disable');
				$(event.target).prop('checked',false);
				$('#'+$('.dataRowLocation').val()).siblings("div").removeClass('#616161 grey darken-2');
			} else {
				$('#'+$('.dataRowLocation').val()).siblings("div").addClass('disable');
				$('.dialog .missionName').addClass('disable');
				$(event.target).prop('checked',true);
				$('#'+$('.dataRowLocation').val()).siblings("div").addClass('#616161 grey darken-2');
			}
		});
	</script>
	
	
	<script type="text/javascript">
		//JQuery datepicker
		var inputDate = $("#datepicker,#subDatepicker");
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

		$("#datepicker,#subDatepicker").datepicker({
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