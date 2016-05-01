<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/pjStage.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/pjStage.js"/>"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		getPjStagePageAjax();
		getPjStageInsertPageAjax();
		
		// 저장
		$("#pjStageInputDiv").on("click", "#pjStageInsertBtn", function() {
			var pj_stage_name = $("#pj_stage_name").val();
			insertPjStageAjax(pj_stage_name);
		});
		
		// 리스트 클릭 시
		$("#pjStageListDiv").on("click", ".pjStageRow", function() {
			var pj_stage_name = $(this).parent().children().eq(0).text();
			var pj_stage_id = $(this).parent().children().eq(0).attr("id");
			
			getPjStageModifyPageAjax(pj_stage_name, pj_stage_id);
		});

		$("#pjStageInputDiv").on("click", "#pjStageModifyBtn", function() {
			var formId = "#pjStageModifyForm";
			modifyPjStageAjax(formId);
		});
		
		$("#pjStageInputDiv").on("click", "#pjStageDeleteBtn", function() {
			var pj_stage_id = $("#pj_stage_id").val();
			deletePjStageAjax(pj_stage_id);
		});
		
		$("#pjStageInputDiv").on("click", "#pjStageResetBtn", function() {
			getPjStageInsertPageAjax();
		});
	});
		
</script>

<h2 id="pjStageContentsTitle">영업단계</h2>

<div id="pjStageListDiv" style="float:left;"></div>

<div id="pjStageInputDiv" style="float:left;"></div>
			
