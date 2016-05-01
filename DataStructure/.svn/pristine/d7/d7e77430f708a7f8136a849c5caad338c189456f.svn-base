function setDate(){
	$("#pd_start_date").datepicker({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월','7월', '8월', '9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년',
		onClose: function( selectedDate ) {
			  $("#pd_end_date").datepicker( "option", "minDate", selectedDate );
		}
	});
	
	$("#pd_end_date").datepicker({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월','7월', '8월', '9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년',
		onClose: function( selectedDate ) {
			  $("#pd_start_date").datepicker( "option", "maxDate", selectedDate );
		}
	});
}

//selectBox에서 팀 선택
function selectTeam(){
	$.ajax({
		type : "POST",
		url : "/employeeInput/selectTeam",
		success : function(data) {
			$("#employeeInputSearch").empty();
			$("#employeeInputSearch").html(data);
			$("#employeeInputDetailForm1").hide();
			$("#employeeInputInsertForm").hide();
			$("#employeeInputDetailForm2").hide();
			
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
	
}

//팀별 프로젝트 검색
function searchEmployeeInput(tm_id) {
	$.ajax({
		type : "POST",
		url : "/employeeInput/searchTeamProject",
		data : {
			tm_id : tm_id
		},
		success : function(data) {
			$("#employeeInputList").empty();
			$("#employeeInputList").html(data);
			
		},
		error : function(xhr) {
			alert("searchEmployeeInput " + xhr.statusText);
		}
	});
}

function getEmployeeInputList(){
	$.ajax({
		type : "POST",
		url : "/employeeInput/getEmployeeInputListAjax",
		success : function(data) {
			$("#employeeInputList").empty();
			$("#employeeInputList").html(data);
		},
		error : function(xhr) {
			alert("getEmployeeInputList = " + xhr.statusText);
		}
	});
	
}

//선택한 프로젝트의 정보 출력 
function getEmployeeInputDetailForm1(pj_id) {
	$.ajax({
		type : "POST",
		url : "/employeeInput/getEmployeeInputDetailForm1",
		data : {
			"pj_id" : pj_id
		},
		success : function(data) {
			$("#employeeInputDetailForm1").show();
			$("#employeeInputInsertForm").show();
			$("#employeeInputDetailForm2").show();
			$("#employeeInputDetailForm1").empty();
			$("#employeeInputDetailForm1").html(data);
		},
		error : function(xhr) {
			alert("getEmployeeInputDetailForm1 = " + xhr.statusText);
		}
	});
}


//프로젝트 인력 투입 화면 출력
function getEmployeeInputInsertForm() {
	$.ajax({
		type : "POST",
		url : "/employeeInput/getEmployeeInputInsertForm",
		success : function(data) {
			$("#employeeInputInsertForm").empty();
			$("#employeeInputInsertForm").html(data);
			setDate();
		},
		error : function(xhr) {
			alert("getEmployeeInputInsertForm = " + xhr.statusText);
		}
	});
}

//투입할 직원 이름 입력시 단가, 등급, 기반분류, 직무기술, 외주평가, 거주지 출력
function getEmployeeInfo(pr_name, hr_index){
	$.ajax({
		type : "POST",
		url : "/employeeInput/getEmployeeInfo",
		data : {
			"pr_name" : pr_name
		},
		success : function(data) {
			if(data.employeeInfoList != null) {
				$("#pd_uprice"+hr_index).text(data.employeeInfoList.hr_uprice);
				$("#hr_grade"+hr_index).text(data.employeeInfoList.hr_grade); 
				$("#hr_cwm_env"+hr_index).text(data.employeeInfoList.hr_cwm_env);
				$("#hr_job_skill"+hr_index).text(data.employeeInfoList.hr_job_skill);
				$("#hr_abc"+hr_index).text(data.employeeInfoList.hr_abc);
				$("#hr_residence"+hr_index).text(data.employeeInfoList.hr_residence);
			} else {
				$("#pd_uprice"+hr_index).text("");
				$("#hr_grade"+hr_index).text("");
				$("#hr_cwm_env"+hr_index).text("");
				$("#hr_job_skill"+hr_index).text("");
				$("#hr_abc"+hr_index).text("");
				$("#hr_residence"+hr_index).text("");
			}
		},
		error : function(xhr) {
			alert("getEmployeeInfoPageAjax = " + xhr.statusText) 
		}
	});	
}

function getHr(hr_index) {
	getEmployeeInfo($("#pd_name").val(), hr_index);
}

//투입 테이블을 리스트에 출력
function getEmployeeInputDetailForm2(pj_id) {
	$.ajax({
		type : "POST",
		url : "/employeeInput/getEmployeeInputDetailForm2",
		data : {
			"pj_id" : pj_id
		},
		success : function(data) {
				$("#employeeInputDetailForm2").empty();
				$("#employeeInputDetailForm2").html(data);
			
		},
		error : function(xhr) {
			alert("getEmployeeInputDetailForm2 = " + xhr.statusText);
		}
	});
}
var pd_start_date_origin;
var pd_end_date_origin;
// 직원 선택시 해당 직원의 인력투입 insert창에 정보 출력
function getEmployeeInputInfoForm(pd_sq, pj_id, pd_name, pr_sq){
	$.ajax({
		type : "POST",
		url : "/employeeInput/getEmployeeInputInfoForm",
		data : {
			"pd_sq" : pd_sq,
			"pj_id" : pj_id,
			"pd_name" : pd_name,
			"pr_sq" : pr_sq
		},
		success : function(data) {
			if(data.employeeInputInfoForm != null) {
				$("#pd_sq").text(data.employeeInputInfoForm.pd_sq);
				$("#pd_name").val(data.employeeInputInfoForm.pd_name);
				$("#pr_sq").text(data.employeeInputInfoForm.pr_sq);
				$("#pd_start_date").val(data.employeeInputInfoForm.pd_start_date);
				$("#pd_end_date").val(data.employeeInputInfoForm.pd_end_date);
				$("#pd_ratio").val(data.employeeInputInfoForm.pd_ratio);
				pd_start_date_origin = data.employeeInputInfoForm.pd_start_date;
				pd_end_date_origin = data.employeeInputInfoForm.pd_end_date;
				getEmployeeInfo(data.employeeInputInfoForm.pd_name,"");
			}else {
				$("#pd_sq").text(pd_sq);
				$("#pd_name").val(pd_name);
				$("#pr_sq").text(pr_sq);
				getEmployeeInfo(pd_name,"");
			}
		},
		error : function(xhr) {
			alert("인력 정보에 없는 이름입니다.");
		}
	});	
	
	
}


//저장 및 update 기능
function insertPjDeploy(b4_pd_name,pj_id, pd_sq, pd_name, pr_sq,pd_start_date, pd_end_date, pd_uprice, pd_ratio) {
	$.ajax({
		type : "POST",
		url : "/employeeInput/insertPjDeploy",
		data : {
			b4_pd_name		: b4_pd_name,
			pj_id			: pj_id,
			pd_sq			: pd_sq,
			pd_name			: pd_name,
			pr_sq			: pr_sq,
			pd_start_date	: pd_start_date,
			pd_end_date		: pd_end_date,
			pd_uprice		: pd_uprice,
			pd_ratio		: pd_ratio
		},
		success : function(data) {
			alert(data.message);
			updateCost(pj_id);
			getEmployeeInputDetailForm2(pj_id);
		},
		error : function(xhr) {
			alert("인력 투입 저장 에러입니다.");
		}
	});
}

function updateCost(pj_id){
	$.ajax({
		type : "POST",
		url : "/employeeInput/updateAllCost",
		data : {
			pj_id	: pj_id,
		},
		success : function() {
		}
	});
}

//삭제 버튼 -- 직원 삭제
function deletePjDeploy(b4_pd_name, pd_name, pj_id, pd_sq) {
	$.ajax({
		type : "POST",
		url : "/employeeInput/deletePjDeploy",
		data : {
			b4_pd_name	: b4_pd_name,
			pd_name	: pd_name,
			pj_id	: pj_id,
			pd_sq	: pd_sq
		},
		success : function() {
			getEmployeeInputDetailForm2(pj_id);
		},
		error : function(xhr) {
			alert("인력 투입 삭제 에러입니다.");
		}
	});
}

/*//기간 중복 검사
function checkDuplicate(b4_pd_name, pj_id, pd_sq, pr_sq, pd_uprice, pd_ratio, pd_name, pd_start_date, pd_end_date){
	var result;
	$.ajax({
		type : "POST",
		url : "/employeeInput/checkDuplicate",
		data : {
			b4_pd_name	: b4_pd_name,
			pj_id	: pj_id,
			pd_sq	: pd_sq,
			pr_sq	: pr_sq,
			pd_uprice	: pd_uprice,
			pd_ratio	: pd_ratio,
			pd_name	: pd_name,
			pd_start_date	: pd_start_date,
			pd_end_date		: pd_end_date
		},
		success : function(data) {
			if(data.checkDup == "true"){
				alert("해당 직원은 투입 기간이 다른 프로젝트와 중복됩니다. 다시 선택해주세요.");
				$("#pd_start_date").val("");
				$("#pd_end_date").val("");
				return false;
			}else{
				insertPjDeploy(b4_pd_name,pj_id, pd_sq, pd_name, pr_sq,pd_start_date, pd_end_date, pd_uprice, pd_ratio);
				alert("저장되었습니다.");
				getEmployeeInputInsertForm();
				getEmployeeInputDetailForm2(pj_id);
			}
			
		},
		error : function(xhr) {
			alert("기간 중복검사 에러" + xhr.statusText);
		}
	});
	
	return result;
}
*/

