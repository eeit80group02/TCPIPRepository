<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"
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
	<!-- 頁首 -->
	<c:import url="/template/header.jsp"
		context="${pageContext.request.contextPath}"></c:import>


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
			<div class="card-panel yellow accent-2 z-depth-6 projinfos "
				style="width: 15%;">
				<h4 style="margin: 0;" class="center-align">募集資訊</h4>
			</div>
		</div>
		<!-- 卡片列區塊的container -->
		<div>
			<div class="centerdiv">
				<c:forEach var="aVar" items="${bean}" varStatus="par">
					<div class="touche">
						<div class="card medium left hoverable light-green lighten-5"
							style="margin: 10px">
							<div class="card-image activator"
								style="background-image: url(${aVar.base64String}); background-size: 100%; background-repeat: no-repeat; cursor: pointer;">
							</div>
							<div class="card-content">
								<p style="font-size: 20pt" class="truncate">${aVar.title}</p>
							</div>
							<div class="card-action right-align">
								<span>需求人數:${numbers[par.index]}/${aVar.estMember}</span>
							</div>
							<div class="card-reveal lime lighten-5" style="height: 100%">
								<span class="card-title grey-text text-darken-4"
									style="height: 15%;"> 計畫摘要 <span
									class="waves-effect waves-light btn right amber lighten-3"
									style="padding: 0 10px 0 10px; color: black;"> Follow </span>
								</span>
								<div class="divider"></div>
								<p style="height: 55%">${aVar.projAbstract}</p>
								<div class="divider"></div>
								<div class="center-align">
									<a href="#"><h5>more...</h5></a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 卡片列 -->
			<!-- 			<div class="centerdiv"> -->
			<!-- 				卡片1 -->
			<!-- 				<div class="touche"> -->
			<!-- 					<div class="card medium left hoverable light-green lighten-5" -->
			<!-- 						style="margin: 10px"> -->
			<!-- 						<div class="card-image activator" -->
			<!-- 							style="background-image: url('picture/DEMO_Proj.PNG'); background-size: 100%; background-repeat: no-repeat; cursor: pointer;"> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-content"> -->
			<!-- 							<p style="font-size: 20pt" class="truncate">上學真好，部落孩子攜手教學計劃</p> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-action right-align"> -->
			<!-- 							<span>需求人數:10/20</span> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-reveal lime lighten-5" style="height: 100%"> -->
			<!-- 							<span class="card-title grey-text text-darken-4" -->
			<!-- 								style="height: 15%;"> 計畫摘要 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
			<!-- 									      						Follow 	      						</span> -->
			<!-- 							</span> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<p style="height: 55%"> -->
			<!-- 								「部落孩子攜手教學計劃」中黃老師已參與計畫近5年。每周四和五都特地上山到部落為部份孩子進行一對一的教學輔導。黄老師花費了相當多的時間與精力設計課程與互動方式，利用生動有趣的說明讓孩子學習起來輕鬆有自信，降低挫折感，提升學習的樂趣，並且認真地紀錄每個孩子的學習情況和進度，課程和教材都是依他們的程度而量身訂做 -->
			<!-- 							</p> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<div class="center-align"> -->
			<!-- 								<a href="#"><h5>more...</h5></a> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->


			<!-- 				卡片2 -->
			<!-- 				<div class="touche"> -->
			<!-- 					<div class="card medium left hoverable light-green lighten-5" -->
			<!-- 						style="margin: 10px"> -->
			<!-- 						<div class="card-image activator" -->
			<!-- 							style="background-image: url('picture/DEMO_Proj2.PNG'); background-size: 100%; background-repeat: no-repeat; cursor: pointer;"> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-content"> -->
			<!-- 							<p style="font-size: 20pt" class="truncate">讓醫院充滿笑聲:紅鼻子醫生計畫</p> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-action right-align"> -->
			<!-- 							<span>需求人數:10/20</span> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-reveal lime lighten-5" style="height: 100%"> -->
			<!-- 							<span class="card-title grey-text text-darken-4" -->
			<!-- 								style="height: 15%"> 計畫摘要 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
			<!-- 									      						Follow 	      						</span> -->
			<!-- 							</span> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<p style="height: 55%"> -->
			<!-- 								每個人的成長過整裡不一定都有長期住院的經驗，但我們都曾有過陪伴在病床旁邊照護親人的時刻，甚至我們的朋友家人就是在醫院裡一起揮汗工作的一群人。 -->
			<!-- 								小丑醫生的存在不只是讓病床上的孩子有機會看到歡笑逗趣的演出，也是讓在場的每顆緊張的心，可以暫時放下緊繃與壓力，漾起一抹微笑，得以放鬆。 -->
			<!-- 							</p> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<div class="center-align"> -->
			<!-- 								<a href="#"><h5>more...</h5></a> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->

			<!-- 				卡片3 -->
			<!-- 				<div class="touche"> -->
			<!-- 					<div class="card medium left hoverable light-green lighten-5" -->
			<!-- 						style="margin: 10px"> -->
			<!-- 						<div class="card-image activator" -->
			<!-- 							style="background-image: url('picture/DEMO_Proj3.PNG'); background-size: 100%; background-repeat: no-repeat; cursor: pointer;"> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-content"> -->
			<!-- 							<p style="font-size: 20pt" class="truncate">歡迎回家【小花門裏門外家寫真】</p> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-action right-align"> -->
			<!-- 							<span>需求人數:10/20</span> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-reveal lime lighten-5" style="height: 100%"> -->
			<!-- 							<span class="card-title grey-text text-darken-4" -->
			<!-- 								style="height: 15%"> 計畫摘要 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
			<!-- 									      						Follow 	      						</span> -->
			<!-- 							</span> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<p style="height: 55%"> -->
			<!-- 								眷村曾是大時代下的文化，人們共同的記憶，但時代的洪流並沒有讓珍貴的文化資產得以保存，而是淹沒在都市叢林與商業開發之中。隨著眷改條例施行，老眷村紛紛頹圮、改建，喚醒人們對於眷村特殊文化價值與歷史記憶保存的反思。 -->
			<!-- 							</p> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<div class="center-align"> -->
			<!-- 								<a href="#"><h5>more...</h5></a> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->

			<!-- 			</div> -->



			<!-- 			<!-- 	卡片列2 -->
			-->

			<!-- 			<div class="centerdiv"> -->
			<!-- 				卡片1 -->
			<!-- 				<div class="touche"> -->
			<!-- 					<div class="card medium left hoverable light-green lighten-5" -->
			<!-- 						style="margin: 10px"> -->
			<!-- 						<div class="card-image activator" -->
			<!-- 							style="background-image: url('picture/DEMO_Proj4.PNG'); background-size: 100%; background-repeat: no-repeat; cursor: pointer;"> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-content"> -->
			<!-- 							<p style="font-size: 20pt" class="truncate">「來自小漁村的台灣代表隊」-國際參賽</p> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-action right-align"> -->
			<!-- 							<span>需求人數:10/20</span> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-reveal lime lighten-5" style="height: 100%"> -->
			<!-- 							<span class="card-title grey-text text-darken-4" -->
			<!-- 								style="height: 15%"> 計畫摘要 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
			<!-- 									      						Follow 	      						</span> -->
			<!-- 							</span> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<p style="height: 55%">日本廣域躲避盤大賽10月3日即將展開，然而，一個更大的問題又再次出現。 -->

			<!-- 								由於比賽地點位於日本栃木縣小山市的比賽場地周遭並非觀光地區，不僅旅館很有限，從台灣到東京、東京到小山市的交通費用也十分棘手，社團志工老師坦言，旅費經過估算以後，所需的費用並不如想像中的樂觀...</p> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<div class="center-align"> -->
			<!-- 								<a href="#"><h5>more...</h5></a> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->


			<!-- 				卡片2 -->
			<!-- 				<div class="touche"> -->
			<!-- 					<div class="card medium left hoverable light-green lighten-5" -->
			<!-- 						style="margin: 10px"> -->
			<!-- 						<div class="card-image activator" -->
			<!-- 							style="background-image: url('picture/DEMO_Proj5.PNG'); background-size: 100%; background-repeat: no-repeat; cursor: pointer;"> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-content"> -->
			<!-- 							<p style="font-size: 20pt" class="truncate">【一趟重量不減的旅程 - -->
			<!-- 								把愛找回來紀錄片】</p> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-action right-align"> -->
			<!-- 							<span>需求人數:10/20</span> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-reveal lime lighten-5" style="height: 100%"> -->
			<!-- 							<span class="card-title grey-text text-darken-4" -->
			<!-- 								style="height: 15%"> 計畫摘要 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
			<!-- 									      						Follow 	      						</span> -->
			<!-- 							</span> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<p style="height: 55%">你認識台灣第五大族群嗎？ 你曾留心路過身旁，說著不同語言的人群嗎？ -->

			<!-- 								從今開始，放下我們的漠視、不再只是擦肩， 讓我們重新認識這群，獨在異鄉的越南新住民。 -->



			<!-- 								基於工作、家庭等因素，使得這些新住民無法回家 於是我們拍片、當信差。 -->

			<!-- 								寄送在台灣的新住民對越南家鄉的思念、一句「不用掛心」或為他們做一道簡單的菜。</p> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<div class="center-align"> -->
			<!-- 								<a href="#"><h5>more...</h5></a> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->

			<!-- 				卡片3 -->
			<!-- 				<div class="touche"> -->
			<!-- 					<div class="card medium left hoverable light-green lighten-5" -->
			<!-- 						style="margin: 10px"> -->
			<!-- 						<div class="card-image activator" -->
			<!-- 							style="background-image: url('picture/DEMO_Proj6.PNG'); background-size: 100%; background-repeat: no-repeat; cursor: pointer;"> -->
			<!-- 													<img src="picture/DEMO_Proj3.PNG"> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-content"> -->
			<!-- 							<p style="font-size: 20pt" class="truncate">悅讀晨光－與一群孩子的午後約定</p> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-action right-align"> -->
			<!-- 							<span>需求人數:10/20</span> -->
			<!-- 						</div> -->
			<!-- 						<div class="card-reveal lime lighten-5" style="height: 100%"> -->
			<!-- 							<span class="card-title grey-text text-darken-4" -->
			<!-- 								style="height: 15%"> 計畫摘要 	      						<span class="waves-effect waves-light btn right amber lighten-3" style="padding:0 10px 0 10px;color:black;"> -->
			<!-- 									      						Follow 	      						</span> -->
			<!-- 							</span> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<p style="height: 55%"> -->
			<!-- 								閱讀，早已在升學導向的台灣走了調，許多人在考試壓力的催逼下，對閱讀失去了興致。應付課內的教科書都來不及了，哪還有時間去閱讀其他的書籍？這樣的教育體制，使我們漸漸忘卻讀書的真諦，忘記了閱讀到一本好書的感覺。 -->

			<!-- 								舉辦這次活動，我們要的其實很簡單，我們希望讓下一代的孩子，有機會不要再向我們一樣，只是為了升學而讀書，而是因為書中的奧秘和驚奇，真正地愛上閱讀。 -->
			<!-- 							</p> -->
			<!-- 							<div class="divider"></div> -->
			<!-- 							<div class="center-align"> -->
			<!-- 								<a href="#"><h5>more...</h5></a> -->
			<!-- 							</div> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->

			<!-- 			</div> -->
			<!-- 			<!-- 卡片列區塊的container -->
			-->
			<!-- 		</div> -->
			<!-- 		<!--募集資訊區塊的container  -->
			-->
			<!-- 	</div> -->


			<!-- 活動花絮區塊的container -->
			<div class="teal lighten-5">
				<div class="row valign-wrapper">
					<!-- 段落提示 -->
					<div class="card-panel yellow accent-2 z-depth-6 projinfos "
						style="width: 15%;">
						<h4 style="margin: 0" class="center-align">花絮剪影</h4>
					</div>
				</div>
				<!-- 	花絮圖片列 -->
				<div class="activity" style="height: 400px; clear: both;">

					<img
						class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
						src="picture/result1.PNG" name="activity"> <img
						class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
						src="picture/result2.PNG" name="activity"> <img
						class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
						src="picture/result3.PNG" name="activity"> <img
						class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
						src="picture/result4.PNG" name="activity"> <img
						class="demo-card-image mdl-card mdl-shadow--6dp hoverable circle"
						src="picture/result5.PNG" name="activity">

				</div>
				<!-- 活動花絮區塊的conytainer -->
			</div>
	</main>


	<!-- 頁尾 -->
	<c:import url="/template/footer.jsp"
		context="${pageContext.request.contextPath}"></c:import>

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.5.7/slick.min.js"></script>
	<script>
		$(function() {

			//觸發卡片翻轉事件
			$(".touche").each(function() {
				$(this).mouseover(function() {
					$(".activator", this).trigger("click");
				})
				$(this).mouseout(function() {
					$(".card-title", this).trigger("click");
				})
			});
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
			//提示區塊的按鈕
			$(".projinfos").css("margin", "0px auto");
			//navagation上logo的高度
			$("img[title='TCPIP']").attr("height", "70");
			//設定body寬度為100%
			$("body").css("width", "100%");
			//讓投影片的圖片寬度保持100%
			$("img[name='sliderpic']").css("width", "100%");
			//註冊modal事件
			// 			$(".modal-trigger").leanModal();
			//帳號、密碼欄focus的背景色變化
			$("#login > div > input").each(function() {
				$(this).on({
					"focus" : function() {
						$(this).addClass("cyan lighten-4");
					},
					"blur" : function() {
						$(this).removeClass("cyan lighten-4");
					}
				})
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
				swipeToSlide : true,
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
