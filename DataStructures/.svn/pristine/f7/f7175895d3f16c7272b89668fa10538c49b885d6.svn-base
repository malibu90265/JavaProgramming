// 검색 화면
function getHumanResourceSearchForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHumanResourceSearchFormAjax",
		success : function(data) {
			$("#humanResourceSearchForm").empty();
			$("#humanResourceSearchForm").html(data);
			
		},
		error : function(xhr) {
			//alert("error getHumanResourceSearchForm = " + xhr.statusText);
		}
	});
}

// 팀 검색
function getHumanResourceSearchTeamAjax(tm_name){
	$.ajax({
		type: "POST" ,
		url : "/humanResource/getHumanResourceSearchTeamAjax" ,
		data : { "tm_name" : tm_name },
		success : function(data){
			$("#humanResourceList").empty();
			$("#humanResourceList").html(data);
			getHumanResourceInsertForm();
		},
		error : function(xhr) {
			//alert("error html = " + xhr.statusText);
		}
	});
}

// 이름 검색
function getHumanResourceSearchNameAjax(hr_name){
	$.ajax({
		type: "POST" ,
		url : "/humanResource/getHumanResourceSearchTeamAjax" ,
		data : { "hr_name" : hr_name },
		success : function(data){
			$("#humanResourceList").empty();
			$("#humanResourceList").html(data);
			getHumanResourceInsertForm();
		},
		error : function(xhr) {
			//alert("error html = " + xhr.statusText);
		}
	});
}

// 직원 List
function getHumanResourceList() {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHumanResourceListAjax",
		success : function(data) {
			$("#humanResourceList").empty();
			$("#humanResourceList").html(data);
		},
		error : function(xhr) {
			alert("error getHumanResourceList = " + xhr.statusText); 
		}
	});
}

//Insert 화면 가져오기
function getHumanResourceInsertForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHumanResourceInsertFormAjax",
		success : function(data) {
			$("#humanResourceInsertFormDiv").empty();
			$("#humanResourceInsertFormDiv").html(data);
		},
		error : function(xhr) {
			//alert("error getHumanResourceInsertForm = " + xhr.statusText);
		}
	});
}

// 저장 버튼
function humanResourceInsertForm(insertFormId){
	
	var form = new FormData(document.getElementById("humanResourceInsertForm"));
	$.ajax({
		url : "/humanResource/getHumanResourceInsertFormAjax2",
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(response) {
			getHumanResourceSearchForm();
			getHumanResourceList();
			getHumanResourceInsertForm();
		}
		,error:function(request,status,error){
			alert("저장 오류 입니다.");}
	});
}

// 수정
function getHumanResourceModifyForm(hr_name) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHumanResourceDetailFormAjax",
		data : {"hr_name" : hr_name},
		success : function(data) {
			$("#humanResourceDetailForm").empty();
			$("#humanResourceDetailForm").html(data);
		},
		error : function(xhr) {
			alert("error getHumanResourceModifyForm = " + xhr.statusText);
		}
	});
}

// 수정 2
function getHumanResourceModifyForm2(formId) {
	
	var form = new FormData(document.getElementById("humanResourceModifyForm"));
	
	$.ajax({
		url : "/humanResource/getHumanResourceModifyFormAjax",
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(data) {
			$("#humanResourceModifyForm").empty();
			$("#humanResourceModifyForm").html(data);
		}
		,error:function(request,status,error){
			alert(request + " : 오류 : " + status + " : 오류 : " +error);}
	});
}

// 삭제
function getHumanResourceDeleteFormAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHumanResourceDeleteFormAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getHumanResourceSearchForm();
			getHumanResourceList();
			getHumanResourceInsertForm();
		},
		error : function(xhr) {
			alert("error getHumanResourceDeleteFormAjax = " + xhr.statusText);
		}
	});
}

// pj수행이력 pop-up
function getPJWorkingHistoryPopupAjax(hr_name) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getPJWorkingHistoryPopupAjax",
		data : {
			"hr_name" : hr_name
		},
		success : function(data) {
			$("#pjWorkingHistoryDiv").empty();
			$("#pjWorkingHistoryDiv").html(data);
			layer_open('layer2');
			return false;
		},
		error : function(xhr) {
			alert("error getPJWorkingHistoryPopupAjax = " + xhr.statusText);
		}
	});
}

//동명이인 검색
function getSamePersonCheck(hr_name) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getSamePersonCheck",
		data : {"hr_name" : hr_name},
		success : function(data) {
			if(data == true) {
				alert("사용 가능한 이름입니다.");
			}
			else {
				alert("같은 이름이 있습니다. 다른 이름을 써주세요.");
			}
		},
		error : function(xhr) {
			alert("error getOutHumanResourceDeleteFormAjax = " + xhr.statusText);
		}
	});
}

//저장버튼 눌렀을 때 동명이인 검색
function getSamePersonCheck2(hr_name) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getSamePersonCheck",
		data : {"hr_name" : hr_name},
		success : function(data) {
		},
		error : function(xhr) {
			alert("error getOutHumanResourceDeleteFormAjax = " + xhr.statusText);
		}
	});
}
