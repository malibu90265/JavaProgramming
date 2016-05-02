function getPjProgressSearchPageAjax(searchFormId) {
	$.ajax({
		type : "post",
		url : "/project/getPjProgressSearchPageAjax",
		success : function(data) {
			$("#pjProgressSearchDiv").empty();
			$("#pjProgressSearchDiv").html(data);
			
			getProjectListByPjProgressSearchConditionsPageAjax(searchFormId);
			
			var pp_date = $("#pjProgressSearchDiv").find("#pp_date").val();
			getPjProgressInputFormPageAjax("", "", pp_date);
		},
		error : function(xhr) {
			alert("error getPjProgressSearchPageAjax = " + xhr.statusText);
		}
	});
}

function getProjectListByPjProgressSearchConditionsPageAjax(searchFormId) {
	$.ajax({
		type:"post",
		url:"/project/getProjectListByPjProgressSearchConditionsPageAjax",
		data: $(searchFormId).serialize(),
		success : function(data) {
			$("#pjProgressListForm").empty();
			$("#pjProgressListForm").html(data);
			
			var tm_id = $(searchFormId).find("#tm_id").val();
			var pp_date = $(searchFormId).find("#pp_date").val();
			popupWindow(tm_id, pp_date);
		},
		error : function(xhr) {
			alert("error getProjectListByPjProgressSearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}

function getPjProgressInputFormPageAjax(pj_id, tm_id, pp_date) {
	$.ajax({
		type : "POST",
		url : "/project/getPjProgressInputFormPageAjax",
		data : {
			"pj_id" : pj_id,
			"tm_id" : tm_id,
			"pp_date" : pp_date
		},
		success : function(data) {
			$("#pjProgressForm").empty();
			$("#pjProgressForm").html(data);
		},
		error : function(xhr) {
			alert("error getPjProgressInputFormPageAjax = " + xhr.statusText);
		}
	});
}

function insertPjProgressAjax(formId, searchFormId) {
	$.ajax({
		type : "POST",
		url : "/project/insertPjProgressAjax",
		data : $(formId).serialize(),
		success : function(data) {
			var date = $(searchFormId).find("#pp_date").val().split("(");
			getPjProgressInputFormPageAjax("", "", date[0]);
			
			var tm_id = $(searchFormId).find("#tm_id").val();
			popupWindow(tm_id, date[0]);
		},
		error : function(xhr) {
			alert("error insertPjProgressAjax = " + xhr.statusText);
		}
	});
}

function modifyPjProgressAjax(formId, searchFormId) {
	$.ajax({
		type : "POST",
		url : "/project/modifyPjProgressAjax",
		data : $(formId).serialize(),
		success : function(data) {
			var pp_date = $(formId).find("#pp_date").val();
			var tm_id = $(searchFormId).find("#tm_id").val();
			var pj_id = $(formId).find("#pj_id").val();
			
			getPjProgressInputFormPageAjax(pj_id, tm_id, pp_date);
			
			var tm_id = $(searchFormId).find("#tm_id").val();
			popupWindow(tm_id, pp_date);
		},
		error : function(xhr) {
			alert("error SSImodifyPjProgressAjax = " + xhr.statusText);
		}
	});
}

function deletePjProgresAjax(pj_id, pp_date, searchFormId) {
	$.ajax({
		type : "POST",
		url : "/project/deletePjProgresAjax",
		data : {
			"pj_id" : pj_id,
			"pp_date" : pp_date
		},
		success : function(data) {
			getPjProgressInputFormPageAjax("", "", pp_date);
			
			var tm_id = $(searchFormId).find("#tm_id").val();
			popupWindow(tm_id, pp_date);
		},
		error : function(xhr) {
			alert("error ddmodifyPjProgressAjax = " + xhr.statusText);
		}
	});
}

function popupWindow(tm_id, pp_date) {
	window.open("", "pjProgressList", 
			"location = no, width=1800, height=700, resizable=yes, scrollbar=yes, status=no, location=no, menubar=no, toolbar=no, left=20, top=20");
	
	document.getElementById("pjProgressSearchForm").target = "pjProgressList";
	document.getElementById("pjProgressSearchForm").method = "post";
	document.getElementById("pjProgressSearchForm").action = "/project/getPjProgressList";
	document.getElementById("pjProgressSearchForm").submit();
}

function num_only(obj) {
	if (event.keyCode != 45 && (event.keyCode != 46) && (event.keyCode != 8)
			&& (event.keyCode < 48) || (event.keyCode > 57) && ((event.keyCode < 96) || (event.keyCode > 105))) {
		event.returnValue = false;
	}
	obj.value = obj.value.replace(/[가-힣a-zA-Z]/,'');
}

function num_range(expnc_rate, defaultNum) {
	var obj = expnc_rate.value;
	if(obj < 1 || obj > 99){
		alert("1 ~ 99 사이의 값을 입력해주세요");
		expnc_rate.value = defaultNum;
	}
}

function pjProgressFormValidationCheck() {
	if($("#pj_id").val() == "") {
		alert("프로젝트를 선택해주세요.");
		return false;
	}
	
	var alertMessage = "";
	if($("#pp_done").val() == "" || $("#pp_done").val().trim() == "") {
		alertMessage += "전주 활동을 입력하지 않으셨습니다.\n";
	}
	
	if($("#pp_plan").val() == "" || $("#pp_plan").val().trim() == "") {
		alertMessage += "금주 계획을 입력하지 않으셨습니다.\n";
	}
	
	if($("#pp_issue").val() == "" || $("#pp_issue").val().trim() == "") {
		alertMessage += "이슈 / 정보를 입력하지 않으셨습니다.\n";
	}
	
	if($("#pp_priority").val() == "") {
		alertMessage += "우선순위를 입력하지 않으셨습니다.\n";
	}
	
	if(alertMessage != ""){
		alertMessage += "이대로 저장하시겠습니까??";
		if(confirm(alertMessage)) return true;
		else return false;
	}

	return true;
}