function getPjProfitAndLossSearchPageAjax() {
	$.ajax({
		type : "post",
		url : "/project/getPjProfitAndLossSearchPageAjax",
		success : function(data) {
			$("#pjProfitAndLossSearchDiv").empty();
			$("#pjProfitAndLossSearchDiv").html(data);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error getPjProfitAndLossSearchPageAjax = " + xhr.statusText);
		}
	});
}

function selectChangeFunction() {
	var tm_id = $("#tm_id_select option:selected").attr("id");
	var pj_status_id = $("#pj_status_select option:selected").attr("id");
	
	getPjProfitAndLossListBySearchConditionsAjax(tm_id, pj_status_id);
}

function getPjProfitAndLossListBySearchConditionsAjax(tm_id, pj_status_id) {
	$.ajax({
		type:"post",
		url:"/project/getPjProfitAndLossListBySearchConditionsAjax",
		data:{
			"tm_id" : tm_id,
			"pj_status_id" : pj_status_id
		},
		success : function(data) {
			$("#pjProfitAndLossListForm").empty();
			$("#pjProfitAndLossListForm").html(data);
		},
		error : function(xhr) {
			alert("error getPjProfitAndLossListBySearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}

//"선택"한 프로젝트 손익 수정 폼 가져오기
function getProfitAndLossModifyFormAjax(pj_id) {
	$.ajax({
		type : "POST",
		url : "/project/getProfitAndLossModifyFormAjax",
		data : {"pj_id" : pj_id},
		success : function(data) {
			$("#pjProfitAndLossForm").empty();
			$("#pjProfitAndLossForm").html(data);
		},
		error : function(xhr) {
			alert("error getProfitAndLossModifyFormAjax = " + xhr.statusText);
		}
	});
}

// 프로젝트 손익 수정하기
function modifyPjProfitAndLossInfoAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/project/modifyPjProfitAndLossInfoAjax",
		data : $(formId).serialize(),
		success : function(data) {
			
			alert("프로젝트 " + data.pj_id + "가 수정되었습니다");
			
			getPjProfitAndLossListBySearchConditionsAjax(data.tm_id, 0);
			getProfitAndLossModifyFormAjax(data.pj_id);
		},
		error : function(xhr) {
			alert("error modifyPjProfitAndLossInfoAjax = " + xhr.statusText);
		}
	});
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
		resultVal = resultVal[0] + resultVal.substring(2, resultVal.length);
	}
	
	return resultVal;
}

function removeComma(str) {
	return str = str.replace(/,/g, '');
}