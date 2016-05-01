<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/skillEnv.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/skillEnv.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getSkillEnvSearchPageAjax("", "", "insert");
		
		$("#skillEnvSearchDiv").on("change", "#skillEnvSelectBox", function() {
			var skillEnvDivision = $(this).val();
			
			getSkillEnvListPageAjax(skillEnvDivision, "", "insert");
		});
		
		$("#skillEnvListDiv").on("click", ".skillEnvRow", function() {
			
			var skillEnvDivision = $(this).children().eq(0).text();
			var skillEnvironment = $(this).children().eq(1).text();
			
			getSkillEnvModifyPageAjax(skillEnvDivision, skillEnvironment);
		});
		
		$("#skillEnvInputDiv").on("click", "#skillEnvInsertBtn", function() {
			
			var insertFormId = $("#skillEnvInputDiv > form:first").attr("id");
			
			insertSkillEnvAjax("#"+insertFormId);
		});
		
		$("#skillEnvInputDiv").on("click", "#skillEnvModifyBtn", function() {
			var modifyFormId = $("#skillEnvInputDiv > form:first").attr("id");
			
			modifySkillEnvAjax("#"+modifyFormId);
		});
		
		$("#skillEnvInputDiv").on("click", "#skillEnvDeleteBtn", function() {
			if(confirm("정말 삭제하시겠습니까??")) {
				var deleteFormId = $("#skillEnvInputDiv > form:last").attr("id");
				
				deleteSkillEnvAjax("#"+deleteFormId);
			}
			
		});
		
		$("#skillEnvInputDiv").on("click", "#skillEnvResetBtn", function() {
			var selectedSkillEnv = $("#skillEnvSearchDiv").find("#skillEnvSelectBox").val();
			
			getSkillEnvInsertPageAjax(selectedSkillEnv);
		});
		
	});
	
</script>

<h2 id="skillEnvContentsTitle">기술환경</h2>

<div id="skillEnvSearchDiv"></div>

<div id="skillEnvListDiv"></div>

<div id="skillEnvInputDiv"></div>
