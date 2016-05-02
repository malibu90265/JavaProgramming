// Team 목표 리스트
function getTeamList(tm_year) {
	$.ajax({
		type : "POST",
		url : "/team/getTeamListAjax",
		data : {
			"tm_year" : tm_year
		},
		success : function(data) {
			$("#teamList").empty();
			$("#teamList").html(data);
		},
		error : function(xhr) {
			alert("error getTeamList = " + xhr.statusText);
		}
	});
}

// 팀 목표 입력 폼
function getTeamInsertForm() {
	$.ajax({
		type : "POST",
		url : "/team/getTeamInsertFormAjax",
		success : function(data) {
			$("#teamForm").empty();
			$("#teamForm").html(data);
			
			$("#teamForm #tm_year").val( $("#tm_year option:selected").text() );
			
		},
		error : function(xhr) {
			alert("error getTeamInsertForm = " + xhr.statusText);
		}

	});
}

function checkDuplicate(formId) {
	
	removeAllComma();
	
	$.ajax({
		type: "POST",
		url : "/team/checkDuplicateAjax",
		data : $(formId).serialize(),
		success : function(data) {
			if(!data.result) {
				alert(data.message);
			}
			else {
				putNewTeamDetail(formId);
			}
		},
		error : function(xhr) {
			alert("error checkDuplicate = " + xhr.statusText);
		}
	});
}

function putNewTeamDetail(formId){
	var tm_year = $(formId).find("#tm_year").val();
	var tm_id = $(formId).find("#tm_id").val();
	
	$.ajax({
		type: "POST",
		url : "/team/putNewTeamDetailAjax",
		data : $(formId).serialize(),
		success : function(data) {
			alert(tm_id + " 팀이 생성되었습니다!");
			
			getTeamList(tm_year);
			getTeamModifyFormAjax(tm_year, tm_id);
		},
		error : function(xhr) {
			alert("error putNewTeamDetail = " + xhr.statusText);
		}
	});
}

// 팀 목표 수정
function getTeamModifyFormAjax(tm_year, tm_id) {
	$.ajax({
		type : "POST",
		url : "/team/getTeamModifyFormAjax",
		data : {
			"tm_year" : tm_year,
			"tm_id" : tm_id
		},
		success : function(data) {
			$("#teamForm").empty();
			$("#teamForm").html(data);
			
			putAllComma();
			
		},
		error : function(xhr) {
			alert("error getTeamModifyFormAjax = " + xhr.statusText);
		}
	});
}

function modifyTeamInfoAjax(formId) {
	
	removeAllComma();
	
	$.ajax({
		type : "POST",
		url : "/team/modifyTeamInfoAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getTeamList(data.tm_year);
			
			putAllComma();
		},
		error : function(xhr) {
			alert("error modifyTeamInfoAjax = " + xhr.statusText);
		}
	});
}

function deleteTeamInfoAjax(tm_year, tm_id) {
	$.ajax({
		type : "POST",
		url : "/team/deleteTeamInfoAjax",
		data : {
			"tm_year" : tm_year,
			"tm_id" : tm_id
		},
		success : function(data) {
			getTeamList(data.tm_year);
			
			getTeamInsertForm();
		},
		error : function(xhr) {
			alert("error getTeamModifyFormAjax = " + xhr.statusText);
		}
	});
}

function isTmNameAjax(tm_year, tm_id, tm_name) {
	var isResult = false;
	
	$.ajax({
		type:"POST",
		async: false,
		url : "/team/isTmNameAjax",
		data : {
			"tm_year" : tm_year,
			"tm_id" : tm_id,
			"tm_name" : tm_name
		},
		success : function(data) {
			isResult = data.result;
		},
		error : function(xhr) {
			alert("error isTmNameAjax = " + xhr.statusText);
		}
	});
	
	return isResult;
}

function validationCheck() {
	
	if($("#tm_year").val() == "") {
		alert("팀 년도를 입력해주세요.");
		return false;
	}
	
	if($("#tm_id").val() == "") {
		alert("팀 ID를 입력해주세요.");
		return false;
	}
	
	if($("#tm_name").val() == "") {
		alert("팀명을 입력해주세요.");
		return false;
	} 
	
	if($("#tm_contract").val() == "") {
		alert("계약목표를 입력해주세요.");
		return false;
	}
	
	if($("#tm_sales").val() == "") {
		alert("매출목표를 입력해주세요.");
		return false;
	}
	
	if($("#tm_profit").val() == "") {
		alert("이익목표를 입력해주세요.");
		return false;
	}
	
	if($("#tm_outsrc_cost").val() == "") {
		/*alert("예상외주비를 입력해주세요.");
		return false;*/
		$("#tm_outsrc_cost").val(0);
	}
	
	if($("#tm_matl_cost").val() == "") {
		/*alert("예상상품비를 입력해주세요.");
		return false;*/
		$("#tm_matl_cost").val(0);
	}
	
	if($("#tm_expnc_rate").val() == "") {
		/*alert("기본경비율을 입력해주세요.");
		return false;*/
		$("#tm_expnc_rate").val(0);
	}
	
	if($("#tm_mm").val() == "") {
		/*alert("MM목표를 입력해주세요.");
		return false;*/
		$("#tm_mm").val(0);
	}
	
	if($("#tm_num").val() == "") {
		/*alert("인원목표를 입력해주세요.");
		return false;*/
		$("#tm_num").val(0);
	}
	
	if($("#tm_ind_lcost").val() == "") {
		/*alert("팀 공통인건비를 입력해주세요.");
		return false;*/
		$("#tm_ind_lcost").val(0);
	}
	
	if($("#tm_ind_expense").val() == "") {
		/*alert("팀 공통경비를 입력해주세요.");
		return false;*/
		$("#tm_ind_expense").val(0);
	}
	
	if($("#tm_sqi_mm_cost").val() == "") {
		/*alert("팀 직원MM단가를 입력해주세요.");
		return false;*/
		$("#tm_sqi_mm_cost").val(0);
	}
	
	if($("#tm_out_mm_cost").val() == "") {
		/*alert("팀 외주MM단가를 입력해주세요.");
		return false;*/
		$("#tm_out_mm_cost").val(0);
	}
	
	return true;
}


function num_range(expnc_rate) {
	var obj = expnc_rate.value;
	if(obj < 0 || obj > 100){
		alert("0 ~ 100 사이의 값을 입력해주세요");
		expnc_rate.value = '';
	}
}

function num_only(obj) {
	if (event.keyCode != 45 && (event.keyCode != 46) && (event.keyCode != 8)
			&& (event.keyCode < 48) || (event.keyCode > 57) && ((event.keyCode < 96) || (event.keyCode > 105))) {
		event.returnValue = false;
	}
	obj.value = obj.value.replace(/[가-힣a-zA-Z]/,'');
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

function CommaVar(str) {
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
	return resultVal;
}

function num_onlyAndComma(obj) {
	if (event.keyCode != 45 && (event.keyCode != 46) && (event.keyCode != 8)
			&& (event.keyCode < 48) || (event.keyCode > 57) && ((event.keyCode < 96) || (event.keyCode > 105))) {
		event.returnValue = false;
	}
	obj.value = obj.value.replace(/[ㄱ-ㅣ가-힣a-zA-Z]/,'');
	CommaObj(obj);
}

function putAllComma() {
	$("#tm_contract").val( CommaVar($("#tm_contract").val()) );
	$("#tm_sales").val( CommaVar($("#tm_sales").val()) );
	$("#tm_profit").val( CommaVar($("#tm_profit").val()) );
	$("#tm_outsrc_cost").val( CommaVar($("#tm_outsrc_cost").val()) );
	$("#tm_matl_cost").val( CommaVar($("#tm_matl_cost").val()) );

	$("#tm_ind_lcost").val( CommaVar($("#tm_ind_lcost").val()) );
	$("#tm_ind_expense").val( CommaVar($("#tm_ind_expense").val()) );
	$("#tm_out_mm_cost").val( CommaVar($("#tm_out_mm_cost").val()) );
	$("#tm_sqi_mm_cost").val( CommaVar($("#tm_sqi_mm_cost").val()) );
}

function removeAllComma() {
	$("#tm_contract").val( $("#tm_contract").val().replace(/,/g, '') );
	$("#tm_sales").val( $("#tm_sales").val().replace(/,/g, '') );
	$("#tm_profit").val( $("#tm_profit").val().replace(/,/g, '') );
	$("#tm_outsrc_cost").val( $("#tm_outsrc_cost").val().replace(/,/g, '') );
	$("#tm_matl_cost").val( $("#tm_matl_cost").val().replace(/,/g, '') );
	
	$("#tm_ind_lcost").val( $("#tm_ind_lcost").val().replace(/,/g, '') );
	$("#tm_ind_expense").val( $("#tm_ind_expense").val().replace(/,/g, '') );
	$("#tm_out_mm_cost").val( $("#tm_out_mm_cost").val().replace(/,/g, '') );
	$("#tm_sqi_mm_cost").val( $("#tm_sqi_mm_cost").val().replace(/,/g, '') );
}

/*순매출 목표 계산에 필요*/
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

function calcNetsales() {
	var netSales = removeComma($("#tm_sales").val())*1 - removeComma($("#tm_matl_cost").val())*1 - removeComma($("#tm_outsrc_cost").val())*1;
	return Comma(netSales.toString());
}

