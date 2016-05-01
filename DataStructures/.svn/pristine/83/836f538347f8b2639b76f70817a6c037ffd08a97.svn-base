<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>팀별 직급단가 관리</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/humanResource_css/price/hr-price-form.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/humanResource/hrPrice.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {

		getMiniHeaderAjax();

		getHRPriceSearchForm();

		// 저장 버튼
		$("#hrPriceForm").on("click", "#hrPriceInsertBtn", function() {
			var frm = document.getElementById('hrPriceInsertListForm');
			if (textEmptyValidcheck(frm)) {
				if (confirm("저장하시겠습니까?")) {
					var size = $("#hrListCount").val();

					for (j = 1; j <= size; j++) {
						var priceId = "#hrPriceRow" + j + " .hp_mon_price";
						var costId = "#hrPriceRow" + j + " .hp_mon_cost";

						$(priceId).val($(priceId).val().replace(/,/g, ''));
						$(costId).val($(costId).val().replace(/,/g, ''));
					}

					var formId = "#hrPriceInsertListForm";
					insertHRPriceInfoAjax(formId);
				}
				else{
					selectChangeFunction();
				}
			}
		});

		$("#hrPriceSearchForm").on("click", "#allTeamPriceBtn", function() {
			getHRPriceListAjax();
		});

		// 비우기 버튼
		$("#hrPriceForm").on("click", "#hrPriceResetBtn", function() {
			var frm = document.getElementById('hrPriceInsertListForm');
			var em = frm.elements;
			frm.reset();
			for (var i = 0; i < em.length; i++) {
				if (em[i].type == 'text')
					em[i].value = '';
			}
			return;
		});

	});
</script>
</head>
<body>
	<div id="miniHeader"></div>

	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">직급 단가 관리</h1>
			<div id="hrPriceSearchForm"></div>

			<div id="hrPriceForm"></div>

			<div id="hrPriceList"></div>
		</section>
	</div>
</body>
</html>
