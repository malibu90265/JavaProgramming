//헤더
function getMiniHeaderAjax() {
	$.ajax({
		type : "POST",
		url : "/admin/getMiniHeaderAjax",
		success : function(data) {
			$("#miniHeader").empty();
			$("#miniHeader").html(data);
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

//검색페이지
function getProject_settingSearchPageAjax(){
	$.ajax({
		type : "post",
		url : "/project_setting/getProject_settingSearchPageAjax",
		success : function(data) {
			$("#project_settingSearchForm").empty();
			$("#project_settingSearchForm").html(data);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error getProjectSearchPageAjax = " + xhr.statusText);
		}
	});
}

//검색 조건의 셀렉이 바뀔경우
function selectChangeFunction() {
	var tm_id = $("#tm_id_select option:selected").attr("id");
	getProjectListBySearchConditionsAjax(tm_id);
}

//검색 조건의 따른 리스트
function getProjectListBySearchConditionsAjax(tm_id) {
	$.ajax({
		type:"post",
		url:"/project_setting/getProject_settingListBySearchConditionsAjax",
		data:{
			"tm_id" : tm_id,
		},
		success : function(data) {
			$("#project_settingListForm").empty();
			$("#project_settingListForm").html(data);
		},
		error : function(xhr) {
			alert("error getProject_settingListBySearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}

//입력폼
function getInsertProject_settingAjax(){
	$.ajax({
		type : "POST",
		url : "/project_setting/project_settingInsert",
		success : function(data) {
			$("#project_settingForm").empty();
			$("#project_settingForm").html(data);
		},
		error : function(xhr) {
			alert("error insertProjectAjax = " + xhr.statusText);
		}
	});
}

//수정폼
function getProject_settingModifyFormAjax(tm_id,pj_id){
	$.ajax({
		type : "POST",
		url : "/project_setting/project_settingModify",
		data:{
			"tm_id" : tm_id,
			"pj_id" : pj_id,
		},
		success : function(data) {
			$("#project_settingForm").empty();
			$("#project_settingForm").html(data);
		},
		error : function(xhr) {
			alert("error ModifyProjectAjax = " + xhr.statusText);
		}
	});
}


//저장 버튼
function projectSettingModifyForm(formId){
	$.ajax({
		type : "POST",
		url : "/project_setting/project_settingModifyFormAjax",
		data : $(formId).serialize(),
		success : function(data) {
			alert("저장완료 되었습니다.");
			$("#project_settingForm").empty();
			$("#project_settingForm").html(data);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error getProjectSettinModifyForm = " + xhr.statusText);
		}
	});
	
}




