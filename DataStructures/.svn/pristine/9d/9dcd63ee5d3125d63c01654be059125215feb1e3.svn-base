<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 주간보고</title>

<link rel="stylesheet" type="text/css"
	href="/resources/css/project_css/progress-form.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/project/progress.js"/>'></script>
<script type="text/javascript">
	var win = null;
	$(document).ready(function() {
		
		getMiniHeaderAjax();
		
		getPjProgressSearchPageAjax("#pjProgressSearchForm");
		
		$("#pjProgressSearchDiv").on("change", "#tm_id", function() {
			var tm_id = $(this).val();
			var pp_date = $("#pjProgressSearchDiv > form").find("#pp_date").val();
			
			getPjProgressInputFormPageAjax("", tm_id, pp_date);
			
			popupWindow(tm_id, pp_date);
		});
		
		$("#pjProgressSearchDiv").on("change", "#pp_date", function() {
			var pp_date = $(this).val();
			var pj_id = $("#pjProgressForm").find("#pj_id").val();
			var tm_id = $("#pjProgressSearchDiv").find("#tm_id").val();
				
			getPjProgressInputFormPageAjax(pj_id, tm_id, pp_date);
			
			popupWindow();
		});
		
		$("#pjProgressListForm").on("click", ".pjProgress", function() {
			var pj_id = $(this).attr("id");
			var tm_id = $("#pjProgressSearchDiv").find("#tm_id").val();
			var pp_date = $("#pjProgressSearchDiv").find("#pp_date").val();
			
			getPjProgressInputFormPageAjax(pj_id, tm_id, pp_date);
		});
		
		$("#pjProgressForm").on("click", "#pjProgressSaveBtn", function() {
			oEditors.getById["pp_done"].exec("UPDATE_CONTENTS_FIELD", []);
			oEditors2.getById["pp_plan"].exec("UPDATE_CONTENTS_FIELD", []);
			oEditors3.getById["pp_issue"].exec("UPDATE_CONTENTS_FIELD", []);
 		// 에디터의 내용에 대한 값 검증은 이곳에서
 			// document.getElementById("ir1").value를 이용해서 처리한다.
 					try {
					 elClickedObj.form.submit();
 					 } catch(e) {}
			
			if(pjProgressFormValidationCheck()) {
				var formId = "#" + $("#pjProgressForm > form").attr("id");
				var searchFormId = "#" + $("#pjProgressSearchDiv > form").attr("id");
				
				if($(formId).find("#pp_priority").val()== 0) $(formId).find("#pp_priority").val(99);
				
				insertPjProgressAjax(formId, searchFormId);
			}
		});
		
		$("#pjProgressForm").on("click", "#pjProgressModifyBtn", function() {
			oEditors.getById["pp_done"].exec("UPDATE_CONTENTS_FIELD", []);
			oEditors2.getById["pp_plan"].exec("UPDATE_CONTENTS_FIELD", []);
			oEditors3.getById["pp_issue"].exec("UPDATE_CONTENTS_FIELD", []);
			
 		// 에디터의 내용에 대한 값 검증은 이곳에서
			// document.getElementById("ir1").value를 이용해서 처리한다.
					try {
				 elClickedObj.form.submit();
					 } catch(e) {}
			if(pjProgressFormValidationCheck()) {
				var formId = "#" + $("#pjProgressForm > form").attr("id");
				var searchFormId = "#" + $("#pjProgressSearchDiv > form").attr("id");
				
				modifyPjProgressAjax(formId, searchFormId);
			}
		});
		
		$("#pjProgressForm").on("click", "#pjProgressDeleteBtn", function() {
			
			if(confirm("주간보고를 삭제하시겠습니까??")) {
				var pj_id = $("#pjProgressForm").find("#pj_id").val();
				var pp_date = $("#pjProgressForm").find("#pp_date").val();
				
				var searchFormId = "#" + $("#pjProgressSearchDiv > form").attr("id");
				
				deletePjProgresAjax(pj_id, pp_date, searchFormId);
			}
			
		});
		
		$("#pjProgressForm").on("click", "#pjProgressResetBtn", function() {
			var pp_date = $("#pjProgressSearchDiv").find("#pp_date").val();
			
			getPjProgressInputFormPageAjax("", "", pp_date);
		});
		
		$("#pjProgressForm").on("click", "#pjReportBtn", function(){
			var tm_id = $("#pjProgressSearchDiv").find("#tm_id").val();
			var pp_date = $("#pjProgressSearchDiv").find("#pp_date").val();
			var popWin = popupWindow(tm_id, pp_date);
			if(!popWin || popWin.closed) {
				popupWindow(tm_id, pp_date);
			}
		});
	});
	
</script>
</head>
<body>
	<div id="miniHeader"></div>

	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">프로젝트 주간보고</h1>
			<div id="pjProgressSearchDiv"></div>

			<div id="pjProgressListForm"></div>

			<div id="pjProgressForm"></div>
		</section>
	</div>

</body>

</html>