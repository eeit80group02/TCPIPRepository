<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.css" />



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
.demo-card-image.mdl-card {
	height: 340px;
	margin: 10px;
}

</style>
<title>TCPIP</title>
</head>


<body class="deep-orange lighten-5">
<header> <!-- 頁首 --> <nav>
	<div class="nav-wrapper grey darken-3">
		<a href="#!" class="brand-logo"> <img alt="TCPIP" title="TCPIP"
			src="picture/LOGO.PNG" />
		</a>


		<ul class="right hide-on-med-and-down" style="font-size:1.5em;">
			<li><a href="sass.html">瀏覽</a></li>
			<li><a href="badges.html">捐贈</a></li>
			<li><a href="#modal1" class="modal-trigger">登入</a></li>
			<li><a href="#!"><i class="material-icons">search</i></a></li>
		</ul>
	</div>
	</nav>
</header>
  
 <!-- 登入用modal --> 
  <div id="modal1" class="modal">
    <div class="modal-content blue lighten-5" style="height:80%;width:100%;">
    	<div class="row" style="margin-top:0px;">
	      <h4 class="center-align" style="font-family:微軟正黑體;font-weight:600;">登入TCPIP</h4>
	    </div>
	    <div class="divider" style="display:block;"></div>
			    <div style="width:60%;margin:0 auto;">  
			      <form class="col l6 offset-l3" id="login">
			      	<div class="input-field" style="margin-top:10%;">
			          	<input id="account" type="text" class="validate">
			          	<label for="account" style="font-size:1.5em;">帳號</label>
		        	</div>
		        	<div class="input-field">
				         <input id="password" type="password" class="validate">
				         <label for="password" style="font-size:1.5em;">密碼</label>
		        	</div>
			      </form>
		    	</div>
    </div>
    <div class="modal-footer blue lighten-5 valign-wrapper" style="height:20%;padding:0;">
    	<div class="row valign" style="font-family:微軟正黑體;font-weight:600;">
	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">登入</a>
		  <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">忘記密碼</a>	      
	      <a href="#!" class="modal-action modal-close waves-effect waves-yellow btn-large amber darken-2">註冊帳號</a>
    	</div>
    </div>
  </div>


<!-- 網頁主體 -->
<main>
	<div class="row">
		<div class="sliders1">
			<div>
				<img src="slider/slider1.png" name="sliderpic">
			</div>
			<div>
				<img src="slider/slider2.png" name="sliderpic">
			</div>
			<div>
				<img src="slider/slider3.png" name="sliderpic">
			</div>
			<div>
				<img src="slider/slider4.png" name="sliderpic">
			</div>
			<div>
				<img src="slider/slider5.png" name="sliderpic">
			</div>
		</div>
	</div>
	<!-- 募集資訊區塊的container -->
	<div class="row">

		<div class="row valign-wrapper">
			<!-- 段落提示 -->
			<div
				class="card-panel waves-effect waves-red yellow accent-2 z-depth-6 projinfos "
				style="width: 15%;">
				<h4 style="margin: 0;" class="center-align">募集資訊</h4>
			</div>
		</div>
		<!-- 卡片列區塊的container -->
		<div>
			<!-- 卡片列 -->
			<div class="centerdiv">
				<!-- 卡片1 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('picture/DEMO_Proj.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">上學真好，部落孩子攜手教學計劃</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/20</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
      						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      							<p style="height:55%">摘要內容</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>
					</div>
				</div>


				<!-- 卡片2 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('picture/DEMO_Proj2.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">讓醫院充滿笑聲:紅鼻子醫生計畫</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/20</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
      						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      						<p style="height:55%">摘要內容</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>
					</div>
				</div>

				<!-- 卡片3 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('picture/DEMO_Proj3.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">歡迎回家【小花門裏門外家寫真】</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/20</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
      						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      						<p style="height:55%">摘要內容</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>					
					</div>
				</div>

			</div>



			<!-- 	卡片列2 -->

			<div class="centerdiv">
				<!-- 卡片1 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('picture/DEMO_Proj4.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">「來自小漁村的台灣代表隊」-國際參賽</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/20</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
      						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      						<p style="height:55%">摘要內容</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>					
					</div>
				</div>


				<!-- 卡片2 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('picture/DEMO_Proj5.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">【一趟重量不減的旅程 -
								把愛找回來紀錄片】</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/20</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
       						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      						<p style="height:55%">摘要內容</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>					
					</div>
				</div>

				<!-- 卡片3 -->
				<div class="touche">
					<div class="card medium left hoverable light-green lighten-5" style="margin: 10px">
						<div class="card-image activator"
							style="background-image: url('picture/DEMO_Proj6.PNG'); background-size: 100%; background-repeat: no-repeat;cursor:pointer;">
							<!-- 						<img src="picture/DEMO_Proj3.PNG"> -->
						</div>
						<div class="card-content">
							<p style="font-size: 20pt" class="truncate">悅讀晨光－與一群孩子的午後約定</p>
						</div>
						<div class="card-action right-align">
							<span>需求人數:10/20</span>
						</div>
						<div class="card-reveal lime lighten-5" style="height:100%">
      						<span class="card-title grey-text text-darken-4" style="height:15%">
      						計畫摘要
	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;">
	      						Follow
	      						</span>
      						</span>
      						<div class="divider"></div>
      						<p style="height:55%">摘要內容</p>
      						<div class="divider"></div>
      						<div class="center-align">
								<a href="#"><h5>more...</h5></a>
							</div>
    					</div>					
					</div>
				</div>

			</div>
			<!-- 卡片列區塊的container -->
		</div>
		<!--募集資訊區塊的container  -->
	</div>


	<!-- 活動花絮區塊的container -->
	<div class="teal lighten-5">
		<div class="row valign-wrapper">
			<!-- 段落提示 -->
			<div
				class="card-panel waves-effect waves-red yellow accent-2 z-depth-6 projinfos "
				style="width: 15%;">
				<h4 style="margin:0" class="center-align">花絮剪影</h4>
			</div>
		</div>
		<!-- 	花絮圖片列 -->
		<div class="activity" style="height: 400px; clear: both;">

			<img
				class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
				src="picture/result1.PNG" name="activity">
			<img
				class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
				src="picture/result2.PNG" name="activity">
			<img
				class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
				src="picture/result3.PNG" name="activity">
			<img
				class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
				src="picture/result4.PNG" name="activity">
			<img
				class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
				src="picture/result5.PNG" name="activity">

		</div>
		<!-- 活動花絮區塊的conytainer -->
	</div>
</main>

        <footer class="page-footer grey darken-4" style="margin:0">
          <div class="container">
            <!-- footer上半部的container -->
			<!-- footer左半邊 -->
			<div>
                <h2 class="blue-text text-darken-2 left" style="display:inline;margin:0 10px 0 5px;">TCPIP</h2>
              	<div class="left" id="taiwan">
              		<p class="grey-text text-lighten-4 ">Taiwan Camp’s Project Innovation Platform </p>
              	</div>
            </div>
			  <div class="right" style="color:white;">
				<h2 class="blue-text text-darken-2 left" style="display:inline;margin:0 10px 0 5px;">LINKS</h2>
              	<div class="left">
              	  <a class="grey-text text-lighten-3" href="https://www.flyingv.cc/">FlingV</a><br/>
                  <a class="grey-text text-lighten-3" href="http://www.indievox.com/">iNDIEVOX</a><br/>
                  <a class="grey-text text-lighten-3" href="http://www.elivtw.com/">以立國際服務</a>
			  </div>
          </div>
          <!-- footer下半部的container -->
          <div class="footer-copyright valign-wrapper" style="clear:both;">
            <div class="container center-align">
          		 台灣志願服務營隊計畫創新平台 © 2015 Copyright 
            </div>
          </div>
          </div>
          
        </footer>

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		$(function() {
			//觸發卡片翻轉事件
			$(".touche").each(function(){
				$(this).mouseover(function(){
					$(".activator",this).trigger("click");
				})
				$(this).mouseout(function(){
					$(".card-title",this).trigger("click");
				})
			});
			//footer中連結的文字大小
			$("a").css("font-size","1.2em");
			//提示區塊的按鈕
			$(".projinfos").css("margin","0px auto");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%");
			//讓投影片的圖片寬度保持100%
			$("img[name='sliderpic']").css("width", "100%");
			//註冊modal事件
			$(".modal-trigger").leanModal();
			//帳號、密碼欄focus的背景色變化
			$("#login > div > input").each(function(){
				$(this).on({"focus":function(){
					$(this).addClass("cyan lighten-4");
				},"blur":function(){
					$(this).removeClass("cyan lighten-4");
				}})
			})
			//廣告投影片的事件
			$(".sliders1").slick({
				autoplay : true,
				autoplaySpeed : 2000,
				centerMode : true,
				fade : true,
				prevArrow : null,
				nextArrow : null
			});
			//花絮播放事件
			$(".activity").slick({
				centerMode : true,
				slidesToShow : 3,
				swipeToSlide:true,
				arrows : false,
				lazyLoad : 'ondemand',
				responsive : [ {
					breakpoint : 768,
					settings : {
						arrows : false,
						centerMode : true,
						centerPadding : '40px',
						slidesToShow : 3
					}
				}, {
					breakpoint : 480,
					settings : {
						arrows : false,
						centerMode : true,
						centerPadding : '40px',
						slidesToShow : 1
					}
				} ]
			})
			$(".centerdiv").css("width", "1000px").css("margin", "0px auto")
					.css("height", "385px");
			$(".card").css("width", "310px");
		})
	</script>


</body>
</html>