<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/jobSkill.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/jobSkill.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getJobSkillSearchPageAjax("", "", "insert");
		
		$("#jobSkillSearchDiv").on("change", "#jobSkillSelectBox", function() {
			var jobSkillDivision = $(this).val();
			
			getJobSkillListPageAjax(jobSkillDivision, "", "insert");
		});
		
		$("#jobSkillListDiv").on("click", ".jobSkillRow", function() {
			
			var jobSkillDivision = $(this).children().eq(0).text();
			var jobSkill = $(this).children().eq(1).text();
			
			getJobSkillModifyPageAjax(jobSkillDivision, jobSkill);
		});
		
		$("#jobSkillInputDiv").on("click", "#jobSkillInsertBtn", function() {
			
			var insertFormId = $("#jobSkillInputDiv > form:first").attr("id");
			
			insertJobSkillAjax("#"+insertFormId);
		});
		
		$("#jobSkillInputDiv").on("click", "#jobSkillModifyBtn", function() {
			var modifyFormId = $("#jobSkillInputDiv > form:first").attr("id");
			
			modifyJobSkillAjax("#"+modifyFormId);
		});
		
		$("#jobSkillInputDiv").on("click", "#jobSkillDeleteBtn", function() {
			if(confirm("정말 삭제하시겠습니까??")) {
				var deleteFormId = $("#jobSkillInputDiv > form:last").attr("id");
				
				deleteJobSkillAjax("#"+deleteFormId);
			}
			
		});
		
		$("#jobSkillInputDiv").on("click", "#jobSkillResetBtn", function() {
			var selectedJobSkill = $("#jobSkillSearchDiv").find("#jobSkillSelectBox").val();
			
			getJobSkillInsertPageAjax(selectedJobSkill);
		}); 
		
	});
	
</script>

<h2 id="jobSkillContentsTitle">직무기술</h2>

<div id="jobSkillSearchDiv"></div>

<div id="jobSkillListDiv"></div>

<div id="jobSkillInputDiv"></div>
