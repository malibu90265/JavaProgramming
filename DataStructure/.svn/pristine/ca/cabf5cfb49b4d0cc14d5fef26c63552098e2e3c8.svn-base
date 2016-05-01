<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 예상 손익</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/project_css/pjProfitAndLoss-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src='<c:url value="/resources/js/project/pjProfitAndLoss.js"/>'></script>
<script type="text/javascript">
	var pj_status_name;
	var pj_id;
	$(document).ready(function() {
		
		getMiniHeaderAjax();
		
		getPjProfitAndLossSearchPageAjax();
	
		$("#pjProfitAndLossListForm").on("click", ".pjProfitAndLossRow", function() {
			pj_status_name = $(this).children().eq(0).text();
			pj_id = $(this).children().eq(1).text();
			getProfitAndLossModifyFormAjax(pj_id);
		});
		
		$("#pjProfitAndLossForm").on("click", "#pjProfitAndLossModifyBtn", function() {
			if(validationCheck() && confirm("수정하시겠습니까??")) {
				$("#pj_status_name").val(pj_status_name);
				$("#pj_sqi_mm").val( removeComma($("#pj_sqi_mm").val()) );
				$("#pj_out_mm").val( removeComma($("#pj_out_mm").val()) );
				$("#pj_matl_cost").val( removeComma($("#pj_matl_cost").val()) );
				$("#pj_extra_cost").val( removeComma($("#pj_extra_cost").val()) );
				$("#outsrc_cost").val( removeComma($("#pj_outsrc_cost").text()) );
				var formId = "#pjProfitAndLossModifyForm";
				modifyPjProfitAndLossInfoAjax(formId);	
			}
		});
		
	});
	
</script>
</head>
<body>
	<div id="miniHeader"></div>
	
	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">프로젝트 손익관리</h1>
			<div id="pjProfitAndLossSearchDiv"></div>
			
			<div id="pjProfitAndLossListForm"></div>
			
			<div id="pjProfitAndLossForm"></div>
		</section>
	</div>
</body>
</html>