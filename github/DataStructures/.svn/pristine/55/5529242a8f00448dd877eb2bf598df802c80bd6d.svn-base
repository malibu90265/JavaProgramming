function getPjBudgetSearchPageAjax() {
	$.ajax({
		type : "post",
		url : "/project/getPjBudgetSearchPageAjax",
		success : function(data) {
			$("#pjBudgetSearchDiv").empty();
			$("#pjBudgetSearchDiv").html(data);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error getPjBudgetSearchPageAjax = " + xhr.statusText);
		}
	});
}

function selectChangeFunction() {
	var tm_id = $("#tm_id_select option:selected").attr("id");
	var pj_status_id = $("#pj_status_select option:selected").attr("id");
	
	getPjBudgetListBySearchConditionsAjax(tm_id, pj_status_id);
}

function getPjBudgetListBySearchConditionsAjax(tm_id, pj_status_id) {
	$.ajax({
		type:"post",
		url:"/project/getPjBudgetListBySearchConditionsAjax",
		data:{
			"tm_id" : tm_id,
			"pj_status_id" : pj_status_id
		},
		success : function(data) {
			$("#pjBudgetListForm").empty();
			$("#pjBudgetListForm").html(data);
		},
		error : function(xhr) {
			alert("error getPjBudgetListBySearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}

function getSelectedBudgetListAjax(pj_id) {
	$.ajax({
		type : "POST",
		url : "/project/getSelectedBudgetListAjax",
		data : {"pj_id" : pj_id},
		success : function(data) {
			$("#pjBudgetSelectedListForm").empty();
			$("#pjBudgetSelectedListForm").html(data);
		},
		error : function(xhr) {
			alert("error getSelectedBudgetListAjax = " + xhr.statusText);
		}
	});
}

function getBudgetInsertFormAjax(pj_id) {
	$.ajax({
		type : "POST",
		url : "/project/getBudgetInsertFormAjax",
		data : {"pj_id" : pj_id},
		success : function(data) {
			$("#pjBudgetForm").empty();
			$("#pjBudgetForm").html(data);
			
			$("#pjBudgetForm #pj_id").val(pj_id);
			$("#pjBudgetForm #pjId").text(pj_id);
			
			setSpanTagDisabled("pjBudgetInsertBtn");
		},
		error : function(xhr) {
			alert("error getBudgetInsertForm = " + xhr.statusText);
		}
	});
}

function getBudgetModifyFormAjax(pj_id) {
	$.ajax({
		type : "POST",
		url : "/project/getBudgetModifyFormAjax",
		data : {"pj_id" : pj_id},
		success : function(data) {
			$("#pjBudgetForm").empty();
			$("#pjBudgetForm").html(data);
			
		},
		error : function(xhr) {
			alert("error getBudgetModifyFormAjax = " + xhr.statusText);
		}
	});
}

function calculateNewBudgetInfoAjax(tm_id,pj_id,pb_no) {
	$.ajax({
		type : "POST",
		url : "/project/calculateNewBudgetInfoAjax",
		data : {
				"tm_id" : tm_id,
				"pj_id" : pj_id,
				"pb_no" : pb_no
			},
		success : function(data) {
			$("#pjBudgetForm").empty();
			$("#pjBudgetForm").html(data);
		},
		error : function(xhr) {
			alert("error getBudgetInsertForm = " + xhr.statusText);
		}
	});
}

//getBudgetInsertFormAjax에 넣어야함
function getBudgetInsertFormAjaxtest(pj_id,pb_no) {
	$.ajax({
		type : "POST",
		url : "/project/getBudgetInsertFormAjaxtest",
		data : {"pj_id" : pj_id,
				"pb_no" : pb_no},
		success : function(data) {
			$("#pjBudgetForm").empty();
			$("#pjBudgetForm").html(data);
			
			$("#pjBudgetForm #pj_id").val(pj_id);
			$("#pjBudgetForm #pb_no").val(pb_no);
		},
		error : function(xhr) {
			alert("error getBudgetInsertForm+1 = " + xhr.statusText);
		}
	});
}

function insertProjectBudgetInfoAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/project/insertProjectBudgetInfoAjax",
		data : $(formId).serialize(),
		success : function(data) {
			alert(data.message);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error insertProjectBudgetInfoAjax = " + xhr.statusText);
		}
	});
}

function modifyProjectBudgetInfoAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/project/modifyProjectBudgetInfoAjax",
		data : $(formId).serialize(),
		success : function(data) {
			
			$("#modifiedPbNum").val(data.pb_no);
			
			alert(data.message);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error modifyProjectBudgetInfoAjax = " + xhr.statusText);
		}
	});
}

function deleteBudgetInfoByPjIdAjax(pj_id, pb_no){
	$.ajax({
		type : "POST",
		url : "/project/deleteBudgetInfoByPjIdAjax",
		data : {"pj_id" : pj_id, "pb_no" : pb_no},
		success : function(data) {
			alert(data.message);
			
			selectChangeFunction();
			$("#pjBudgetForm").empty();
		},
		error : function(xhr) {
			alert("error deleteBudgetInfoByPjIdAjax = " + xhr.statusText);
		}
	});
}

function popupWindow(formId){
	window.open("", "pjBudgetHistoryList", 
	"width=1100, height=900, resizable=yes, scrollbar=yes, status=no, location=no, menubar=no, toolbar=no, left=50, top=20");
	
	document.getElementById(formId).target = "pjBudgetHistoryList";
	document.getElementById(formId).method = "post";
	document.getElementById(formId).action = "/project/getBudgetHistoryList";
	document.getElementById(formId).submit();
}

/* pjBudgetModifyForm */

//modify form에 처음 들어왔을 때 작동
function initProfitAndLoss() {
	// input 태그에 Comma 넣기
	$("#pb_sales").val(Comma($("#pb_sales").val()));
	$("#pb_matl_cost").val(Comma($("#pb_matl_cost").val()));
	$("#pb_extra_cost").val(Comma($("#pb_extra_cost").val()));
	
	// 총 MM
	$("#mmResult").text( calcMMResult() );
	
	// 순매출액 
	$("#netSales").text( calcNetsales() );
	
	// 직접경비 
	$("#pjDirectCost").text( calcPbDirectCost() );
	
	// 영업이익 
	$("#salesProfit").text( calcSalesProfit() );
}

// 총 MM 계산
function calcMMResult() {
	var mmResult = $("#pb_emp_mm").val()*1 + $("#pb_outEmp_mm").val()*1;
	return mmResult;
}

// 순매출액 계산 = 매출액 - 상품비 - 외주비
function calcNetsales() {
	var netSales = removeComma($("#pb_sales").val())*1 - removeComma($("#pb_matl_cost").val())*1 - $("#pb_outsrc_cost").val()*1;
	return Comma(netSales.toString());
}

// 직접경비 계산 = 매출액 * 기본경비율 : 현재 페이지에서 변하지 않는 값
function calcPbDirectCost() {
	var pbDirectCost = ( Math.round(removeComma($("#pb_sales").val()) * ($("#tm_expnc_rate").val()*1) / 100));
	return Comma(pbDirectCost.toString());
}

// 영업이익 계산 = 순매출액 - 인건비 - 경비 
function calcSalesProfit() {
	var salesProfit = (removeComma(calcNetsales())*1) - $("#pb_labor_cost").val() - ( (removeComma(calcPbDirectCost())*1) + removeComma($("#pb_extra_cost").val())*1 );
	return Comma(salesProfit.toString());
}

function Comma(str) {
	
	str = str.replace(/,/g, '');
	var resultVal = "";
	for (i = 1; i <= str.length; i++) {
		 if(i > 1 && (i % 3) == 1) {
			resultVal = str.charAt(str.length - i) + "," + resultVal;
		}
		else {
			resultVal = str.charAt(str.length - i) + resultVal;
		} 
	} 
	
	if(resultVal[0] == "-" && resultVal[1] == ",") {
		resultVal = resultVal[0] + resultVal.substring(2);
	}
	
	return resultVal;
}

function removeComma(str) {
	return str = str.replace(/,/g, '');
}

function num_onlyAndComma(obj) {
	if (event.keyCode != 45 && (event.keyCode != 46) && (event.keyCode != 8)
			&& (event.keyCode < 48) || (event.keyCode > 57) && ((event.keyCode < 96) || (event.keyCode > 105))) {
		event.returnValue = false;
	}
	
	obj.value = obj.value.replace(/[ㄱ-ㅣ가-힣a-zA-Z]/,'');
	CommaObj(obj);
}

function CommaObj(obj) {
	var str = obj.value.replace(/,/g, '');
	var resultVal = "";
	for (i = 1; i <= str.length; i++) {
		 if(i > 1 && (i % 3) == 1) {
			resultVal = str.charAt(str.length - i) + "," + resultVal;
		}
		else {
			resultVal = str.charAt(str.length - i) + resultVal;
		} 
	} 
	obj.value = resultVal;
}

function validationCheck() {
	if($("#pjBudgetForm #pb_no").val() == "" || $("#pjBudgetForm #pb_no").val() == null) {
		alert("예산번호를 입력하세요.");
		return false;
	}
	
	if($("#pb_start_date").val() == "" || $("#pb_start_date").val() == null) {
		alert("프로젝트 시작일을 입력하세요.");
		return false;
	}
	
	if($("#pb_end_date").val() == "" || $("#pb_end_date").val() == null) {
		alert("프로젝트 종료일을 입력하세요.");
		return false;
	}
	
	if($("#pb_sales").val() == "" || $("#pb_sales").val() == null) {
		alert("총 매출액을 입력하세요.");
		return false;
	}
	
	if($("#pb_matl_cost").val() == "" || $("#pb_matl_cost").val() == null) {
		alert("상품비를 입력하세요.");
		return false;
	}
	
	if($("#pb_extra_cost").val() == "" || $("#pb_extra_cost").val() == null) {
		alert("추가경비를 입력하세요.");
		return false;
	}
	
	return true;
}

