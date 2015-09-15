<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertGoods</title>
<!-- 一定要載入的 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
	!window.jQuery && document.write("<script src='scripts/jquery-2.1.4.min.js'>_$tag_____")
</script>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- Materialize -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- 自訂 -->
<link rel="stylesheet" href="styles/DonationSchool.css">
<script type="text/javascript" src="scripts/DonationSchool.js"></script>

<!-- 上傳圖片用 -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.9.1.js"></script>
<link rel="stylesheet" type="text/css" href="styles/UpLoadPicture.css">
<script type="text/javascript" src="scripts/UpLoadPicture.js"></script>
</head>
<body>
<center>
	<div class="navbar navbar-inverse">
			<ul class="nav navbar-nav" id="headUl">
				<li class="active"><a href="#">捐獻牆</a></li>
				<li class="headList"><a href="#">熱門</a></li>
				<li class="headList"><a href="#">最新發佈</a></li>
				<li class="headList"><a href="#">即將結束</a></li>
				<li class="headList"><a href="#">需求數量</a></li>
				<li class="headList"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">物資狀態<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">不拘</a></li>
						<li><a href="#">全新</a></li>
						<li><a href="#">二手</a></li>
					</ul></li>

			</ul>
			<form class="navbar-form navbar-left" role="search" id="headSearch">
				<div class="form-group">
					<input id="searchText" type="text" class="form-control" placeholder="輸入物品或學校">
				</div>

				<button type="submit" class="btn btn-small btn-floating">
					<i class="small material-icons">search</i>
				</button>
				<button type="reset" class="btn btn-small btn-floating">
					<i class="small material-icons">clear</i>
				</button>
			</form>
		</div>
		<br>


	<form id="drop-a-line" enctype='multipart/form-data' action='donate.do' method='POST'>
			
			<div id="warnText">
				<span class="glyphicon glyphicon-star" style="float: left;"></span>&nbsp;<span>符號為必填欄位</span>
			</div>


			<div class="row">
				<div class="col-md-6">
					<!-- 上左 -->
					<br> <br>
					<!-- 額外 -->
 					<input type='text' name='schoolId' value='${param.schoolId}'>
 					
					<div class="input-field col m12 s12">
						<input type="text" id="schoolName"  name='schoolName' disabled value='${param.schoolName}'><label for="schoolName"><span class="DetailTitle"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="學校名稱"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;申請單位&nbsp;</span></a></span></label>
					</div>
					<!-- 上傳圖片 -->
					<div id="basicDataHead">
						<div class="input-field col m12 s12">
							<input type="file" id="imageName" name='imageName' required="required"><label for="imageName"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="點我上傳圖片，建議最佳上傳圖片大小為 400 * 400"><span class="DetailTitle"><span class="glyphicon glyphicon-picture"></span>&nbsp;上傳封面&nbsp;<span class="glyphicon glyphicon-star"></span></span></a><br> <br> <a
								class="text tooltipped" data-position="right" data-delay="20" data-tooltip="點我上傳圖片，建議最佳上傳圖片大小為 400 * 400">
									<div id="donationPictureFrame">
										<center>
											<!-- 強迫img在div內部置中 -->
											<img id="donationPicture" src="" alt="" title="上傳圖片">
										</center>
									</div>
							</a> </label>
						</div>

					</div>

				</div>
				<div class="col-md-6">
					<br> <br>
					<!-- 物資名稱 -->
					<div class="input-field col m12 s12">
						<input type="text" id="supplyName" name='supplyName' value='${param.supplyName}' maxlength="25" length="25" required="required" autofocus="autofocus" autocomplete="off"><label for="supplyName"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="最多輸入 25 個字"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;物資名稱&nbsp;<span class="glyphicon glyphicon-star"></span></span></a></label>
					</div>

					<!-- 需求數量(數量) -->
					<div class="input-field col m12 s12">
						<input type="number" id="originalDemandNumber" name='originalDemandNumber' value='${param.originalDemandNumber}' required="required" autofocus="autofocus" autocomplete="off" max="9999" min="1"><label for="originalDemandNumber"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="輸入數字"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;需求物品數量&nbsp;<span
									class="glyphicon glyphicon-star"></span></span></a></label>
					</div>

					<!-- 原始輸入需求數量(單位) -->
					<div class="input-field col m12 s12">
						<input type="text" id="originalDemandUnit" name='originalDemandUnit' value='${param.originalDemandUnit}' required="required" autofocus="autofocus" autocomplete="off"><label for="originalDemandUnit"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="例如：包、打、張、隻、箱"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;需求物品單位&nbsp;<span class="glyphicon glyphicon-star"></span></span></a></label>
					</div>

					<!-- 尺寸規格(例如:物品的大小>長*寬*高) -->
					<div class="input-field col m12 s12">
						<input type="text" id="size" name='size' value='${param.size}' autofocus="autofocus" autocomplete="off"><label for="size"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="例如：物品大小的長.寬.高、電壓 110V 或 220V"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;尺寸規格&nbsp;</span></a></label>
					</div>

					<!-- 物資狀態(全新/二手/不拘) -->
					<div class="input-field col m12 s12">
						<label><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="不拘、全新、二手"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;物資狀態&nbsp;</span></a></label><br> <br>
						 <select class="browser-default" id="supplyStatus" name="supplyStatus">
							<option value="1">不拘</option>
							<option value="2">全新</option>
							<option value="3">二手</option>
						</select> <br>
					</div>

					<!-- 需求說明(為什麼需要這項物資) -->
					<div class="input-field col m12 s12">
						<textarea id="demandContent" name='demandContent' value='${param.demandContent}' class="materialize-textarea" required="required" autofocus="autofocus"></textarea>
						<label for="demandContent"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="說明為什麼需要這項物資"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;需求說明&nbsp;<span class="glyphicon glyphicon-star"></span></span></a></label>
					</div>

				</div>
			</div>

			<!-- 備註 -->
			<div class="input-field col m12 s12">
				<textarea id="remark" name='remark' value='${param.remark}' class="materialize-textarea" autofocus="autofocus"></textarea>
				<label for="remark"><a class="text tooltipped" data-position="right" data-delay="20" data-tooltip="補充說明"><span class="DetailTitle"><span class="glyphicon glyphicon-pencil"></span>&nbsp;備註&nbsp;</span></a></label>
			</div>

			<button type="submit" id="send-message" name='hidden' value='insert' class="btn btn-small btn-floating">
				<i class="small material-icons">done</i>
			</button>


			<button type="reset" id="cancel-message" class="btn btn-small btn-floating">
				<i class="small material-icons">clear</i>
			</button>
	</form>
</center>
</body>
</html>