<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/pjStatus.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/pjStatus.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/colorpicker/jscolor.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getPjStatusListPageAjax();
		
		getPjStatusInsertPageAjax();
		
		$("#pjStatusListDiv").on("click", ".pjStatusRow", function() {
			var pj_status_id = $(this).children().eq(0).attr("id");
			getPjStatusModifyPageAjax(pj_status_id);
		});
		
		 
		$("#pjStatusInputDiv").on("click", "#pjStatusInsertBtn", function() {
			
			var insertFormId = $("#pjStatusInputDiv > form").attr("id");
			
			insertPjStatusAjax("#"+insertFormId);
		});
		
		$("#pjStatusInputDiv").on("click", "#pjStatusModifyBtn", function() {
			var modifyFormId = $("#pjStatusInputDiv > form").attr("id");
			
			modifyPjStatusAjax("#"+modifyFormId);
		});
		
		$("#pjStatusInputDiv").on("click", "#pjStatusDeleteBtn", function() {
			if(confirm("정말 삭제하시겠습니까??")) {
				var pj_status_id = $("#pjStatusInputDiv").find("#pj_status_id").val();
				
				deletePjStatusAjax(pj_status_id);
			}
			
		});
		
		$("#pjStatusInputDiv").on("click", "#pjStatusResetBtn", function() {
			getPjStatusInsertPageAjax();
		}); 
		
	});
	
</script>

<h2 id="pjStatusContentsTitle">추진상태</h2>

<div id="pjStatusListDiv"></div>

<div id="pjStatusInputDiv"></div>
