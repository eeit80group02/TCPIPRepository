<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建立活動花絮</title>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css" media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
	.error{
		color:#FF0000;
	}
	
	.forinput {
		font-size:1.6em;
		font-weight:600;
		color:black;
		font-family:微軟正黑體;		
	}
	
</style>
</head>
<body class="amber lighten-5">
	<!-- 頁首 -->
		<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}" />
	<!-- 頁首 -->
	
	<!-- 頁面主題提示 -->
	<div class="row black valign-wrapper" id="pagetitle">
		
		<h1 class="valign center-align white-text"
			style="font-family: 微軟正黑體; margin: 0 auto; font-size: 5em;">建立活動花絮</h1>
	</div>	
	
	<!-- 內容 -->
<main>
	<div class="row" id="mainboard">
		<!-- 填資料的區塊 -->
		<div class="col l8">
			<div class="row">
				<!-- 印出來、不能更動 -->
					<div class="orange lighten-2 card-panel hoverable ">
						<!-- 完整計畫名稱 -->
						<div class="row">
								<div class="forinput col l3 right-align">完整計畫名稱:</div>
								<input class="col l7 black-text" name=" projName" id="projName" type="text" readonly="readonly" style="font-size:1.6em;font-family:微軟正黑體;">
						</div>
						<!-- 計畫編號 -->
						<div class="row">
								<div class="forinput col l3 right-align">活動發起人:</div>
								<input class="col l7 black-text"name="memberName" id="memberName" type="text" readonly="readonly" style="font-size:1.6em;font-family:微軟正黑體;">
						</div>
					</div>
			</div>
			
			<div class="row deep-purple lighten-5 hoverable" style="padding:2em;">
				<form action="ActivityHighlightPostServlet" id="postForm" method="post">
					<div class="row">
						<div class="forinput">影片網址(請輸入YouTube完整網址)</div>
						<input id="videoURL" type="text" class="validate col l8" name="videoURL" style="padding:0;font-size:1.6em;font-family:微軟正黑體;"/>
					</div>				
					
					
					<div class="row file-field">
						<div class="forinput">
							<div>
								封面上傳
								<input type="file" id="picture" style="width:35%;">
								<i class="material-icons blue-text">search</i>
							</div>
						</div>						
						<div class="col l4 file-path-wrapper" style="padding:0">
							<input class="file-path validate" id="frontCoverName"  type="text">
						</div>
					</div>				
					
					<div class="row">
						<div class="forinput">
							花絮內容
						</div>
						<div class="input-field">
							<textarea name="content" id="content" style="min-height:50vh;"></textarea>
						</div>
					</div>
									
					
					<div class="row">
						<input id="fullProjId" type="hidden">
						<input id="memberId" type="hidden">
						<button class="btn-large red right" type="submit" name="action">
							<span style="font-size:1.5em;font-weight:600">
								送出
							</span>
							<i class="material-icons right">
								send
							</i>
						</button>
						<a class="btn-large red right" id="preview" style="font-size:1.5em;font-weight:600">預覽</a>
					</div>				
				</form>
			</div>
		</div>
		<!-- 預覽的區塊 -->
		<div class="col l4">
				<div class="input-field row">
					<h4 class="row center-align">花絮封面預覽</h4>
					<div class="row center-align">
						<img class="card-panel hoverable" id="frontCover" src="" style="height: 340px; width: 420px;border:5px solid black;padding:0;" >					
					</div>
				</div>
				
				<div class="input-field row">
					<h4 class="row center-align">影片預覽</h4>
					<div class="input-field row center-align">
						<div class="video-container" style="border:5px solid black;">
		        			<iframe id="YouTubeURL" src="" frameborder="0" allowfullscreen></iframe>
		      			</div>	
		      		</div>
				</div>
				
		
		</div>
	</div>


<!-- 	<div class="row"> -->
		
<!-- 		<form action="/" id="postForm"> -->

<!-- 		<div class="row" style="padding:10px;"> -->
		
		
<!-- 			<!-- 左半邊填資料處 --> 
<!-- 			<div class="col s12 m4 l8 deep-purple lighten-5" style="padding:2em;"> -->
<!-- 				<div class="input-field col s12"> -->
<!-- 					<input id="videoURL" type="text" class="validate" name="videoURL" > -->
<!-- 					<label for="videoURL" class="active">影片網址(請輸入YouTube完整網址)</label> -->
<!-- 				</div> -->
<!-- 				<div class="col s12" > -->
<!-- 							<div class="file-field input-field"> -->
<!-- 								<div class="btn"> -->
<!-- 									<span>封面上傳</span> -->
<!-- 									<input type="file" id="picture"> -->
<!-- 								</div> -->
<!-- 								<div class="file-path-wrapper"> -->
<!-- 									<input class="file-path validate" type="text" placeholder="請上傳封面圖片..." id="frontCoverName"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- <!-- 				<div class="input-field col s12"> --> 
<!-- <!-- 					<textarea class="ckeditor" name="content" id="content"></textarea> --> 
<!-- <!-- 				</div> --> 
<!-- 				<div class="input-field col s12"> -->
<!-- 					<input id="fullProjId" type="hidden"> -->
<!-- 					<input id="memberId" type="hidden"> -->
<!-- 					<button class="btn waves-effect waves-light" type="submit" name="action"> -->
<!-- 						送出 <i class="material-icons right">send</i> -->
<!-- 					</button> -->
<!-- 					<a class="waves-effect waves-light btn" id="preview">預覽</a> -->
<!-- 				</div> -->
				
<!-- 				<div class="input-field col s12"> -->
<!-- 					<div id="result"></div> -->
<!-- 				</div> -->
			
<!-- 			</div> -->
			
			
<!-- 			<!-- 右半邊預覽處 --> 
<!-- 			<div class="col s12 m4 l4"> -->
<!-- 				<div class="input-field col s12"> -->
<!-- 					<h4>花絮封面預覽</h4> -->
<!-- 					<img class="card-panel hoverable" id="frontCover" src="" style="height: 340px; width: 420px;border:5px solid black;padding:0;" > -->
<!-- 				</div> -->
<!-- 				<div class="input-field col s12"> -->
<!-- 					<h4>影片預覽</h4> -->
<!-- 				</div> -->
<!-- 				<div class="input-field col s12"> -->
<!-- 					<div class="video-container"> -->
<!-- 	        			<iframe id="YouTubeURL" src="" frameborder="0" allowfullscreen></iframe> -->
<!-- 	      			</div>	 -->
<!-- 	      		</div>		 -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</form> -->
<!-- 	</div> -->
	</main>


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	<!-- 頁尾 -->



	<!-- script -->

	<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
	<script>
		$(function() {
			//初始化ckeditor
			CKEDITOR.replace( 'content', {
		    	customConfig: 'config.js'
			} );
			//點預覽處也能上傳
			$("#frontCover").on("click",function(){
				$("#picture").trigger("click");
			});
			
			//提示頁面主題欄的高度
			var pagetitleheight = ($(window).height() * 0.25);
			$("#pagetitle").css("height", pagetitleheight);
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%").css("height", "100%");
			$(".centerdiv").css("height", "385px");
			$(".card").css("width", "310px");
			
			// upload picture
			$("#picture").change(function(){
				var file = $("#picture")[0].files[0];
				var reader  = new FileReader();
				reader.onloadend = function () {
					console.log(reader.result);
					$("#frontCover").attr("src", reader.result);
				}
				if(file){
					reader.readAsDataURL(file);
				}
			})
			
			$("#videoURL").on("focusout",function(){
				var offset = $("#videoURL").val().indexOf("watch?v=")+8;
				console.log(offset);
				$("#YouTubeURL").attr("src","//www.youtube.com/embed/"+$("#videoURL").val().substring(offset, offset+11));
				console.log($("#YouTubeURL").attr("src"));
			});
				
			
			$.get("<c:url value='/ActivityHighlightCreateInitServlet?fullProjId=${param.fullProjId}&memberId=${param.memberId}' />", function(responseJson) {
				console.log(responseJson);
				$("#projName").val(responseJson.projName);	
				$("#memberName").val(responseJson.memberName);
				$("#fullProjId").val(responseJson.fullProjId);
				$("#memberId").val(responseJson.memberId);
			}); 
			
			
			$( "#postForm" ).submit(function( event ) {
				event.preventDefault();
				var check = false;
				if($("#content").val() != "" && $("#frontCover").attr("src") != "" && $("#videoURL").val() != "" ) {
					check = true;
				}
				if(check){
					$.ajax({
    					url:'<c:url value="/ActivityHighlightPostServlet" />',
    	   				type:'post',
    	   				data:{	"content" : $("#content").val(),
    	   		  	   	    	"frontCover" : $("#frontCover").attr("src"), 
    	   		  	   	    	"fullProjId" : $("#fullProjId").val(),
    	   		  	   	    	"memberId" : $("#memberId").val(),
    	   		  	   	    	"frontCoverName" : $("#frontCoverName").val(),
    	   		  	   	    	"videoURL" : $("#videoURL").val() },
    	   				dataType:'text',
    	   				success:function(result){
//     						alert("花絮創建成功!");
    	   					window.location = "<c:url value='/Activity/ActivityHighlightDisplay.jsp?fullProjId=" + $("#fullProjId").val() + "&memberId=" + $("#memberId").val() + "' />";
    	   				}
    	   
       				});
				} else {
					alert("確認資料填齊，請稍候再試!");
				}
			});
			
			$("#preview").on("click",function(){
				var newWindow = window.open('<c:url value="/Activity/ActivityHighlightPreview.jsp" />');
				newWindow.window.content = $("#content").val();
				newWindow.window.frontCover = $("#frontCover").attr("src");
				newWindow.window.fullProjName = $("#projName").val();
				newWindow.window.memberName = $("#memberName").val();
				newWindow.window.videoURL = $("#videoURL").val();			
			});
			
		})
	</script>
</body>
</html>