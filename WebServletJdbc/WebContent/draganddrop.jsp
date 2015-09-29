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

	<c:import url="/template/header.jsp" context="${pageContext.request.contextPath}"></c:import>


  <div id="loadingmodal" class="modal" style="position:fixed;left:50%;width:200px;">
    <div class="modal-content">
	  <div class="progress">
	      <div class="indeterminate"></div>
	  </div>		
    </div>
  </div>	
  


	<!-- 主要任務集版面 -->
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
						class="addBoard btn-large red">
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
	
	<!-- 子任務板面 -->
	<div class="subMissionSettingsDialog">
		<div class="row">
			<h5 class="center-align">子任務選單</h5>
		</div>
		<div class="divider" style="margin:10px 0px;padding:1px 0px;">	
		</div>
		<div class="row">
			<div id="transferToMission" class="btn"><h6>轉為主任務</h6></div>
		</div>
		<div class="row">
			<div id="deleteSubMission" class=" btn"><h6>刪除子任務</h6></div>
		</div>
		<input type="hidden" class="subMissionLocation" value="">
	</div>
	
	<!-- 任務集操作版面 -->
	<div class="setMissionTitleDialog">
		<div class="row">
			<div class="input-field">
				<input type="text" class="missionTitle validate">
				<input type="hidden" class="titleLocation" value="">
			</div>
		</div>
		<div class="row">
			<div class="col l6">
				<div id="confirmMissionSet" class="btn"><h6>完成</h6></div>
			</div>
			<div class="col l6">
				<div id="deleteMissionSet" class="btn"><h6>刪除</h6></div>
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
							   				<div class="addSubMission btn #2196f3 blue" >新增</div>
											<div class="cancelSubMission btn #2196f3 blue" >取消</div>
										</div>
							   		</div>
							   	</li>
							</ul>
						</div>
					</div>
				</div>
		<input type="hidden" class="dataRowLocation" value="">
	</div>
	
	<c:import url="/template/footer.jsp" context="${pageContext.request.contextPath}"></c:import>
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/missionBoard.js"></script>
	
</body>
</html>