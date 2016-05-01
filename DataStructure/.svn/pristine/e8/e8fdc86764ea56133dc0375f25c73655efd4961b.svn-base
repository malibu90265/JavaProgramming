<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 영업관리</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/project_css/project-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" /> 
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script> 
<script type="text/javascript" src='<c:url value="/resources/js/project/project.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/project/projectCalender.js"/>'></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getMiniHeaderAjax();
		
		getProjectSearchPageAjax();
		
		 $("#projectSearchDiv").on("change", "#tm_id_select", function() {
			insertProjectAjax();
		}); 
		
		$("#projectListForm").on("click", ".projectRow", function() {
			var pj_id = $(this).children().eq(1).text();
			getProjectModifyFormAjax(pj_id);
		});
		
		//저장버튼
		$("#projectForm").on("click","#projectSaveBtn",function() {
			var tDate = new Date();
			if (validationCheck())	checkDuplicate("#projectInsertForm");
		});
		
		$("#projectForm").on("click", "#projectModifyBtn", function() {
			if(validationCheck()) {
				var formId = "#projectModifyForm";
				
				modifyProjectInfoAjax(formId);
				
			}
		});
		
		$("#projectForm").on("click","#projectResetBtn",function(){
			insertProjectAjax();
		});
		
		$("#projectForm").on("click","#projectDeleteBtn",function(){
			
 			if(confirm("정말 삭제하시겠습니까?")) {
				var pj_id = $("#pj_id").val();
				var tm_id = $("#tm_id").val();
				deleteProjectInfoAjax(pj_id, tm_id);
 			}
		});
		
		/* $("#projectForm").on("change", "#pj_amount", function(){
			alert("ddd");
			alert($("#projectForm").find("#pj_amount").val());
			var pj_amount = $("#projectForm").find("pj_amount").val();
			var pj_start_date = $("#projectForm").find("pj_start_date").val();
			var pj_end_date = $("#projectForm").find("pj_end_date").val();
			
			setPjYearSalesAjax(pj_amount, pj_start_date, pj_end_date);
		}); */
		
		$("#projectForm").on("change", ".setYearSales", function() {
			var pj_amount = $("#projectForm").find("#pj_amount").val();
			pj_amount = removeComma( pj_amount.toString() );
			var pj_start_date = $("#projectForm").find("#pj_start_date").val();
			var pj_end_date = $("#projectForm").find("#pj_end_date").val();
			
			setPjYearSalesAjax(pj_amount, pj_start_date, pj_end_date);
			
			$("#projectForm").find("#pj_amount").val(Comma(pj_amount));
		});
		
		/* $("#projectForm").on("keyup", "#pj_amount", function(){
			$("#pj_amount").val( Comma( $("#pj_amount").val() ) );
		}); */
		
		/* $("#projectForm").on("focusout", "#pj_amount", function(){
			//setPjYearSalesAjax();
		}); */
		
		$("#projectForm").on("keyup", "#pj_year_sales", function(){
			$("#pj_year_sales").val( Comma( $("#pj_year_sales").val() ) );
		}); 
		 
	});
	
	function removeComma(str) {
		return str = str.replace(/,/g, '');
	}
	
</script>
</head>
<body>
	<div id="miniHeader" style="width: 100%;"></div>
	
	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">프로젝트 영업관리</h1>
			<div id="projectSearchDiv"></div>
			<div style="clear: inherit;"></div>
			
			<div id="projectListForm"></div>
			<div style="clear: inherit;"></div>
			
			<div id="projectForm"></div>
			<div style="clear: inherit;"></div>
		</section>
	</div>
</body>
</html>