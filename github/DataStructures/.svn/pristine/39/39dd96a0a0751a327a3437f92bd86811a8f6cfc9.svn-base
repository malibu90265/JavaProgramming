<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>팀 목표관리</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/team_css/team-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/team/team.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getMiniHeaderAjax();
		
		$("#teamList").on("click", ".teamRow", function() {
			
			var tm_id = $(this).children().eq(0).attr("id");
			var tm_year = $("#tm_year").val();
			
			getTeamModifyFormAjax(tm_year, tm_id);
		});
		
		
		$("#teamForm").on("click", "#teamSaveBtn", function() {
			if(validationCheck()) {
				var formId = "#teamInsertForm";
				
				var tm_year = $(formId).find("[name=tm_year]").val();
				var tm_name = $(formId).find("[name=tm_name]").val();
				
				if(!isTmNameAjax(tm_year, "", tm_name)){
					checkDuplicate(formId);
				} else {
					alert("해당년도에 동일한 팀명이 있습니다.");
				}
			} 
		});
		
		$("#teamForm").on("click", "#teamModifyBtn", function() {
			if(validationCheck()) {
				var formId = "#modifyTeamForm";
				
				var tm_year = $(formId).find("[name=tm_year]").val();
				var tm_id = $(formId).find("[name=tm_id]").val();
				var tm_name = $(formId).find("[name=tm_name]").val();
				
				if(!isTmNameAjax(tm_year, tm_id, tm_name)) {
					if(confirm("정말 수정하시겠습니까??")) {
						modifyTeamInfoAjax(formId);
					}
				} else {
					alert("해당년도에 동일한 팀명이 있습니다.");
				}
			} 
		});
		
		$("#teamForm").on("click", "#teamDeleteBtn", function() {
			if(confirm("정말 삭제하시겠습니까??")) {
				
				var tm_year = $("#teamForm").find("#tm_year").val();
				var tm_id = $("#teamForm").find("#tm_id").val();
				
				deleteTeamInfoAjax(tm_year, tm_id);
			}
		});
		
		$("#teamForm").on("click", "#teamResetBtn", function() {
			getTeamInsertForm();
		});
		
		$("#teamForm").on("keyup", ".calcNetSales", function() {
			
			var teamNetSales = calcNetsales();
			$(".tm_net_sales").text(teamNetSales);
		});
		
	});

	function setDate(form, tm_year) {
		var current, tm_year, i, j;
		current = new Date();
		if (tm_year == null) {
			tm_year = current.getFullYear();
			for (i = 0, j = tm_year; j >= 1999; i++, j--)
				form.tm_year.options[i] = new Option(j, j);
		} else {
			tm_year = tm_year;
			//다시한번 볼 것 
			for (i = 0, j = current.getFullYear(); j >= 1999; i++, j--) {
				form.tm_year.options[i] = new Option(j, j);
			}
		}
		form.tm_year.value = tm_year;

		getTeamList(tm_year);
		getTeamInsertForm();
	}
</script>
</head>

<body onLoad="setDate(document.forms[0])">
	
	<div id="miniHeader">
	</div>
	
	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">팀 목표관리</h1>
			<div id="teamSearchDiv">
				<table class="search">
					<tr> 
						<th>년도</th>
						<td>
							<form name="team_year">
								<select id="tm_year" name="tm_year" onChange="setDate(this.form, this.value)"></select>
							</form>
						</td>
					</tr>
				</table>
			</div>
			<!-- 팀 목표 리스트 -->
			<div id="teamList"></div>
			
			<!-- 팀 목표 입력 관리 -->
			<div id="teamForm"></div>
		</section>
	</div>
</body>
</html>
