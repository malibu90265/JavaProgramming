<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 예산관리</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/project_css/pjBudget-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src='<c:url value="/resources/js/project/pjBudget.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/project/projectCalender.js"/>'></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getMiniHeaderAjax();
		
		getPjBudgetSearchPageAjax();
		
		$("#pjBudgetForm").on("click", "#pjBudgetInsertBtn", function() {
			if(validationCheck()) {
				
				$("#pb_sales").val($("#pb_sales").val().replace(/,/g, ''));
				$("#pb_matl_cost").val($("#pb_matl_cost").val().replace(/,/g, ''));
				$("#pb_extra_cost").val($("#pb_extra_cost").val().replace(/,/g, ''));
				
				var formId  = "#pjBudgetInsertForm";
				insertProjectBudgetInfoAjax(formId);
			}
		});
		
		$("#pjBudgetForm").on("click", "#pjBudgetModifyBtn", function() {
			if(validationCheck()) {
				
				$("#pb_sales").val($("#pb_sales").val().replace(/,/g, ''));
				$("#pb_matl_cost").val($("#pb_matl_cost").val().replace(/,/g, ''));
				$("#pb_extra_cost").val($("#pb_extra_cost").val().replace(/,/g, ''));
				
				var formId  = "#pjBudgetModifyForm";
				modifyProjectBudgetInfoAjax(formId);
			}
		});
		
		//신규추가 버튼
		$("#pjBudgetForm").on("click", "#makeNewPjBudgetBtn", function() {
			var pb_no =$("#pjBudgetListForm").find("#modifiedPbNum").val();
			var tm_id = $("#pjBudgetSearchDiv").find("#tm_id_select option:selected").attr('id');
			var pj_id = $("#pjBudgetListForm").find("#changedPjId").val();
			calculateNewBudgetInfoAjax(tm_id,pj_id,pb_no);
		});
		
		$("#pjBudgetForm").on("click","#pjBudgetDeleteBtn", function() {
			$("#modifiedPbNum").val("");
			
			if(confirm("정말 삭제하시겠습니까?")) {
				var pj_id = $("#pjBudgetForm #pj_id").val();
				var pb_no = $("#pjBudgetForm #pb_no").val();
				
				deleteBudgetInfoByPjIdAjax(pj_id, pb_no);
			}
		});
		
	});
	
</script>
</head>
<body>
	<div id="miniHeader"></div>
	
	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">프로젝트 예산관리</h1>
			<div>
				<div id="pjBudgetSearchDiv" ></div>
				<div id="pjBudgetListForm"></div>
			</div>
			<div id="pjBudgetForm"></div>
		</section>
	</div>
</body>
</html>