<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>

<!-- 頁尾 -->	
<footer class="page-footer grey darken-4">
	<div class="container">
            <!-- footer上半部的container -->
            <div class="row">
              <!-- 「關於我」的div -->
              <div class="col l6 s12" id="aboutme">
                <h1 class="blue-text text-darken-2">TCPIP</h1>
                <p class="grey-text text-lighten-4">Taiwan Camp’s Project Innovation Platform </p>
                <p class="grey-text text-lighten-4" style="font-family:微軟正黑體">台灣志願服務營隊計畫創新平台 </p>
              </div>
              <!-- 放置連結處 -->
              <div class="col l4 offset-l2 s12">
                <h2 class="blue-text text-darken-2">Links</h2>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="https://www.flyingv.cc/">FlingV</a></li>
                  <li><a class="grey-text text-lighten-3" href="https://www.flyingv.cc/freebird">FlingV FreeBird</a></li>
                  <li><a class="grey-text text-lighten-3" href="http://thewall.tw/">這牆音樂 - The Wall Music</a></li>
                  <li><a class="grey-text text-lighten-3" href="http://www.indievox.com/">iNDIEVOX</a></li>
                  <li><a class="grey-text text-lighten-3" href="http://www.elivtw.com/">以立國際服務</a></li>
                </ul>
              </div>
            </div>
	</div>
          <!-- footer下半部的container -->
          <div class="footer-copyright">
            <div class="container">
            © 2015 Copyright
            </div>
          </div>
        </footer>
	
	
	
<!-- script -->	
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script
		src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
	<script>
		$(function() {
			//footer中的文字大小
			$("#aboutme > p").css("font-size", "1.2em");
			//footer中連結的文字大小
			$("a").css("font-size", "1.2em");
		})
	</script>
</body>
</html>