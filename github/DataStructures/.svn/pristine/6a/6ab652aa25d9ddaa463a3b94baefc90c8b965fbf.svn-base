function getProjectSearchPageAjax() {
	$.ajax({
		type : "post",
		url : "/project/getProjectSearchPageAjax",
		success : function(data) {
			$("#projectSearchDiv").empty();
			$("#projectSearchDiv").html(data);
			selectChangeFunction();
			insertProjectAjax();
		},
		error : function(xhr) {
			alert("error getProjectSearchPageAjax = " + xhr.statusText);
		}
	});
}
var tm_id ;
var pj_status_id ;
var pj_modify_id ;

function selectChangeFunction() {
	tm_id = $("#tm_id_select option:selected").attr("id");
	pj_status_id = $("#pj_status_select option:selected").attr("id");
	pj_modify_id = $("#pj_modify_select option:selected").attr("id");
	
	getProjectListBySearchConditionsAjax(tm_id, pj_status_id, pj_modify_id);
}

function getProjectListBySearchConditionsAjax(tm_id, pj_status_id, pj_modify_id) {
	$.ajax({
		type:"post",
		url:"/project/getProjectListBySearchConditionsAjax",
		data:{
			"tm_id" : tm_id,
			"pj_status_id" : pj_status_id,
			"pj_modify_id" : pj_modify_id
		},
		success : function(data) {
			$("#projectListForm").empty();
			$("#projectListForm").html(data);
		},
		error : function(xhr) {
			alert("error getProjectListBySearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}

function getProjectListAjax() {
	$.ajax({
		type : "POST",
		url : "/getProjectListAjax",
		data : {
			pj_id : pj_id,
			tm_id : tm_id
		},
		success : function(data) {
			$("#projectListForm").empty();
			$("#projectListForm").html(data);
		},
		error : function(xhr) {
			alert("error getProjectListAjax = " + xhr.statusText);
		}
	});
}

function getProjectDetailAjax() {
	$.ajax({
		type : "POST",
		url : "/getProjectDetailAjax",
		data : {
			
		},
		success : function(data) {
			$("#projectDetailForm").empty();
			$("#projectDetailForm").html(data);
		},
		error : function(xhr) {
			alert("error getProjectDetailAjax = " + xhr.statusText + "getProjectDetailAjax");
		}
	});
}

//중복확인 한 저장된 데이터 출력
function putNewProjectDetail(formId){
	$("#pj_amount").val( $("#pj_amount").val().replace(/,/g, '') );
	$("#pj_year_sales").val( $("#pj_year_sales").val().replace(/,/g, '') );
	$.ajax({
		type: "POST",
		url : "/project/putNewProjectDetailAjax",
		data : $(formId).serialize(),
		success : function(data) {
			alert($("#pj_id").val() + " 프로젝트가 생성되었습니다!");
			getProjectListBySearchConditionsAjax($("#tm_id").val(), 0);
			getProjectModifyFormAjax($("#pj_id").val());
		},
		error : function(xhr) {
			alert("error putNewProjectDetail = " + xhr.statusText);
		}
	});
}

//프로젝트 목표 수정
function getProjectModifyFormAjax(pj_id) {
	$.ajax({
		type : "POST",
		url : "/project/getProjectModifyFormAjax",
		data : {"pj_id" : pj_id},
		success : function(data) {
			$("#projectForm").empty();
			$("#projectForm").html(data);
		},
		error : function(xhr) {
			alert("error getProjectModifyFormAjax = " + xhr.statusText);
		}
	});
}

// 수정
function modifyProjectInfoAjax(formId) {
	$("#pj_amount").val( $("#pj_amount").val().replace(/,/g, '') );
	$("#pj_year_sales").val( $("#pj_year_sales").val().replace(/,/g, '') );
	
	$.ajax({
		type : "POST",
		url : "/project/modifyProjectInfoAjax",
		data : $(formId).serialize(),
		success : function(data) {
			alert(data.pj_id + "가 수정되었습니다.");
			
			getProjectListBySearchConditionsAjax(tm_id, pj_status_id,pj_modify_id);
			getProjectModifyFormAjax(data.pj_id);

			
		},
		error : function(xhr) {
			alert("error modifyProjectInfoAjax = " + xhr.statusText);
		}
	});
}

// 삭제
function deleteProjectInfoAjax(pj_id, tm_id) {
	$.ajax({
		type : "POST",
		url : "/project/deleteProjectInfoAjax",
		data : {"pj_id" : pj_id, "tm_id" : tm_id},
		success : function(data) {
			alert("프로젝트 " + data.pj_id + "가 삭제되었습니다.");
			
			getProjectListBySearchConditionsAjax(data.tm_id, 0);
			insertProjectAjax();
		},
		error : function(xhr) {
			alert("error deleteProjectInfoAjax = " + xhr.statusText);
		}
	});
}



function insertProjectAjax() {
	$.ajax({
		type : "POST",
		url : "/project/projectInsert",
		success : function(data) {
			$("#projectForm").empty();
			$("#projectForm").html(data);
			
			var tm_id = $("#tm_id_select option:selected").attr("id");
			var tm_name = $("#tm_id_select option:selected").text();
			$("#projectForm #tm_name").text( tm_name );
			$("#projectForm #tm_id").val(tm_id);
		},
		error : function(xhr) {
			alert("error insertProjectAjax = " + xhr.statusText);
		}
	});
}

function updateProjectAjax() {
	$.ajax({
		type : "POST",
		url : "/getProjectListAjax",
		data : {
			
		},
		success : function() {
			
		},
		error : function(xhr) {
			alert("error updateProjectAjax = " + xhr.statusText);
		}
	});
}

function deleteProjectAjax() {
	$.ajax({
		type : "POST",
		url : "/getProjectListAjax",
		data : {
			
		},
		success : function() {
			
		},
		error : function(xhr) {
			alert("error deleteProjectAjax = " + xhr.statusText);
		}
	});
}


//중복확인
function checkDuplicate(formId) {
	$.ajax({
		type: "POST",
		url : "/project/checkDuplicateAjax",
		data : {
			pjId : $("#pj_id").val()
		},
		success : function(data) {
			
			if(!data.result) {
				alert(data.message);
			}
			else {
				putNewProjectDetail(formId);
			}
			
		},
		error : function(xhr) {
			alert("error checkDuplicate = " + xhr.statusText);
		}
	});
}

function setPjYearSalesAjax(pj_amount, pj_start_date, pj_end_date) {
	if( (pj_amount != "") && (pj_start_date != "") && (pj_end_date != "") ) {
		pj_amount = pj_amount.replace(/,/g, '');
	
		$.ajax({
			type : "POST",
			url : "/project/setPjYearSalesAjax",
			data : {"pj_amount" : pj_amount
					,"pj_start_date" : pj_start_date
					, "pj_end_date" : pj_end_date },
			success : function(data) {
				
			var result = Comma(data.result);
				$("#pj_year_sales").attr( "placeholder", result );
	
				if(confirm("금년 매출액에 계산된 값을 넣으시겠습니까?") == true) {
					$("#pj_year_sales").val( result );
				}
			},
			error : function(xhr) {
				alert("error setPjYearSalesAjax = " + xhr.statusText);
			}
		})
	}
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
	return resultVal;
}

function validationCheck() {
	
	if($("#pj_id").val() == "") {
		alert("프로젝트 ID를 입력해주세요.");
		return false;
	}
	
	if($("#pj_name").val() == "") {
		alert("프로젝트명을 입력해주세요.");
		return false;
	}
	
	if($("#pjStatusSelect").val() == 0) {
		alert("상태를 선택해주세요.");
		return false;
	}
	
	if($("#pj_sign_client").val() == "") {
		alert("계약고객명을 입력해주세요.");
		return false;
	}
	
	if($("#pj_order_client").val() == "") {
		alert("발주고객명을 입력해주세요.");
		return false;
	}
	
	if($("#pj_amount").val() == "") {
		alert("계약액을 입력해주세요.");
		return false;
	}
	
	if($("#pj_start_date").val() == "") {
		alert("프로젝트 시작일을 입력해주세요.");
		return false;
	}
	
	if($("#pj_end_date").val() == "") {
		alert("프로젝트 종료일을 입력해주세요.");
		return false;
	}
	
	if($("#pjStageSelect").val() == 0) {
		alert("영업단계를 선택해주세요.");
		return false;
	}
	
	return true;
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
