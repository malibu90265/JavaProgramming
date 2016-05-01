<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 기본관리</title>
<link rel="stylesheet" type="text/css" href="/resources/css/project_setting_css/project_setting-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script> 
<script type="text/javascript" src="<c:url value="/resources/js/project_setting/project_setting.js"/>"></script> 
<script type="text/javascript" src="<c:url value="/resources/js/project_settingValidCheck.js"/>"></script> 
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script> 
<script type="text/javascript">
	var tm_id;
	$(document).ready(function(){
	
		getMiniHeaderAjax();
		getProject_settingSearchPageAjax();
		getInsertProject_settingAjax();
		
		$("#project_settingListForm").on("click",".project_settingRow",function(){
			var pj_id = $(this).children().eq(0).text();
			tm_id = $("#project_settingSearchForm").find("#tm_id_select option:selected").attr("id");
			getProject_settingModifyFormAjax(tm_id,pj_id);
		})
		
		//저장
		$("#project_settingForm").on("click","#projectSaveBtn", function(){
			var formId = "#project_settingModifyForm";
			var pj_pm = $("#pj_pm").val();
			if(project_settingNullCheckData(formId)){
				if(isHangle(pj_pm)){
					if(checkLastWord(pj_pm)){
						if(confirm("저장하시겠습니까?")){
					    projectSettingModifyForm(formId);
					    getProjectListBySearchConditionsAjax(tm_id);
						}
					}else{
						alert("PM명을 정확히 입력해 주십시요.");
					}	
				}
				else{
					alert("한글로만 입력해 주십시요");
				}
			
			}
		})
		
		//비우기
		$("#project_settingForm").on("click","#projectResetBtn", function(){
			var formId = "#project_settingModifyForm";
			if(confirm("비우시겠습니까?")){
				$(':text:not([id=pj_id])').val('');
				$('select').each(function(){
					$(this).find('option:first').attr('selected','true');
				});
				$("input[name=pj_cwm_env_list]:checkbox").each(function() {
					  $(this).attr("checked", false);
					 });
			}
			
		})
	});
</script>
</head>
<body>
	<div id="miniHeader"></div>
	
	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">프로젝트 환경관리</h1>
			<!-- var d = new Date();
			var filename = d.getFullYear() + "년" + (d.getMonth() + 1) + "월" + d.getDate() + "일" + "직원&외주 배치";
			
			$("#ExcelExport").click(function() {
				getExcel($("#costmapList > #laborExcel"), filename);
			}); -->
			
			<div>
				<div id="project_settingSearchForm"></div>
				
				<div id="project_settingListForm"></div>
			</div>
				<div id="project_settingForm"></div>
		</section>
	</div>
	
</body>
</html>