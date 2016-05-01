// 검색
function getOutHumanResourceSearchForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/getOutHumanResourceSearchFormAjax",
		success : function(data) {
			$("#outHumanResourceSearchForm").empty();
			$("#outHumanResourceSearchForm").html(data);
			
		},
		error : function(xhr) {
			//alert("error outHumanResourceSearchForm = " + xhr.statusText);
		}
	});
}

//외주 list
function getOutHumanResourceList(){
	$.ajax({
		type : "POST",
		url : "/humanResource/getOutHumanResourceListAjax",
		success : function(data) {
			$("#outHumanResourceList").empty();
			$("#outHumanResourceList").html(data);
			
		},
		error : function(xhr) {
			//alert("error outHumanResourceSearchForm = " + xhr.statusText);
		}
	});
}

//외주 insert
function getOutHumanResourceInsertForm(){
	$.ajax({
		type : "POST",
		url : "/humanResource/getOutHumanResourceInsertFormAjax",
		success : function(data) {
			$("#outHumanResourceInsertFormDiv").empty();
			$("#outHumanResourceInsertFormDiv").html(data);
		},
		error : function(xhr) {
			alert("error outHumanResourceInsertFormDiv = " + xhr.statusText);
		}
	});
}

//외주 DoInsert
function outHumanResourceInsertForm(insertFormId){
	
	var form = new FormData(document.getElementById("#outHumanResourceInsertForm"));
	alert(form);
	$.ajax({
		url : "/humanResource/getOutHumanResourceInsertFormAjax2",
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(response) {
			getOutHumanResourceSearchForm();
			getOutHumanResourceList();
			getOutHumanResourceInsertForm();
			alert("저장되었습니다.");
		}
		,error : function(jqXHR) {
			alert("error getHumanResourceInsertForm = " + jqXHR.statusText);
		}
		,error:function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
	});
}

//외주 이름 검색
function getOutHumanResourceSearchNameAjax(hr_name){
	$.ajax({
		type: "POST" ,
		url : "/humanResource/getOutHumanResourceSearchTeamAjax" ,
		data : { "hr_name" : hr_name },
		success : function(data){
			$("#outHumanResourceList").empty();
			$("#outHumanResourceList").html(data);
			getOutHumanResourceInsertForm();
		},
		error : function(xhr) {
			//alert("error outHumanResourceList = " + xhr.statusText);
		}
	});
}

//외주 등급 검색
function getOutHumanResourceSearchGradeAjax(hr_grade){
	$.ajax({
		type: "POST" ,
		url : "/humanResource/getOutHumanResourceSearchTeamAjax" ,
		data : { "hr_grade" : hr_grade },
		success : function(data){
			$("#outHumanResourceList").empty();
			$("#outHumanResourceList").html(data);
			getOutHumanResourceInsertForm();
		},
		error : function(xhr) {
			//alert("error outHumanResourceList = " + xhr.statusText);
		}
	});
}

//pj수행이력 pop-up
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

//DoInsert
function outHumanResourceInsertForm(insertFormId){
	
	var form = new FormData(document.getElementById("outHumanResourceInsertForm"));
	$.ajax({
		url : "/humanResource/getOutHumanResourceInsertFormAjax2",
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(response) {
			getOutHumanResourceSearchForm();
			getOutHumanResourceList();
			getOutHumanResourceInsertForm();
		}
		,error : function(jqXHR) {
			alert("error getHumanResourceInsertForm = " + xhr.statusText);
		}
	});
}

// 수정
function getOutHumanResourceModifyForm(hr_name) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getOutHumanResourceDetailFormAjax",
		data : {"hr_name" : hr_name},
		success : function(data) {
			$("#outHumanResourceDetailForm").empty();
			$("#outHumanResourceDetailForm").html(data);
		},
		error : function(xhr) {
			alert("error getOutHumanResourceModifyForm = " + xhr.statusText);
		}
	});
}

// 수정 2
function getOutHumanResourceModifyForm2(formId, hr_name) {
	
	var form = new FormData(document.getElementById("outHumanResourceModifyForm"));
	
	$.ajax({
		url : "/humanResource/getOutHumanResourceModifyFormAjax",
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(data) {
			alert("수정 완료했습니다.");
			getOutHumanResourceList();
			//document.outHumanResourceModifyForm.change();
			getOutHumanResourceModifyForm(hr_name);
		}
		,error : function(xhr) {
			alert("error getHumanResourceModifyForm2 = " + xhr.statusText);
		}
	});
}

// 삭제
function getOutHumanResourceDeleteFormAjax(hr_name) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHumanResourceDeleteFormAjax",
		data : {hr_name : hr_name},
		success : function(data) {
			//getOutHumanResourceSearchForm();
			//getOutHumanResourceList();
			getOutHumanResourceInsertForm();
		},
		error : function(xhr) {
			alert("error getOutHumanResourceDeleteFormAjax = " + xhr.statusText);
		}
	});
}

// 동명이인 검색
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

//저장 버튼 눌렀을 때 동명이인 검색
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

