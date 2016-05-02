//selectBox에서 팀 선택
function selectTeam(){
	$.ajax({
		type : "POST",
		url : "/selectTeam",
		success : function(data) {
			$("#teamSearch").empty();
			$("#teamSearch").html(data);
		},
		error : function(xhr) {
			alert("selectTeam  = " + xhr.statusText);
		}
	});
	
}

//팀별 프로젝트 검색
function searchTeamProject(tm_id) {
	$.ajax({
		type : "POST",
		url : "/searchTeamProject",
		data : {
			tm_id : tm_id
		},
		success : function(data) {
			$("#candidateDiv").empty();
			$("#candidateDiv").html(data);
			$("#candidateDetailForm").hide();
			$("#candidateSearchForm").hide();
		},
		error : function(xhr) {
			alert("searchTeamProject " + xhr.statusText);
		}
	});
}


/*// 프로젝트 리스트
function getCandidateList(){
	$.ajax({
		type : "POST",
		url : "/getCandidateListAjax",
		success : function(data) {
			$("#candidateDiv").empty();
			$("#candidateDiv").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}
*/
// 요청된 인력소요 리스트
function getCandidateDetailForm(pjId) {
	$.ajax({
		type : "POST",
		url : "/getCandidateDetailFormAjax",
		data : {"pjId" : pjId,
				"testingVal" : "testingVal"},
		success : function(data) {
			$("#candidateDetailForm").show();
			$("#candidateSearchForm").show();
			$("#candidateDetailForm").empty();
			$("#candidateSearchForm").empty();
			$("#candidateDetailForm").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

// 우선순위 1~5 지정하는 form
function getCandidateSearchForm() {
	
	$.ajax({
		type : "POST",
		url : "/getCandidateSearchFormAjax",
	    data : $("#conditionForm").serialize(), 
		success : function(data) {
			$("#candidateSearchForm").empty();
			$("#candidateSearchForm").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

// 검색 결과 리스트 - candidateSearchDetailForm
function getCandidateSearchResultForm() {
	$.ajax({
		type : "POST",
		url : "/getCandidateSearchResultFormAjax",
		data : $("#candidateSelectSearchForm").serialize(),
		success : function(data) {
			$("#candidateSearchResultForm").empty();
			$("#candidateSearchResultForm").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function arrangeCandidate() {
	$.ajax({
		type : "POST",
		url : "/arrangeCandidateAjax",
		data : $("#resultForm").serialize(), 
		success : function(data) {
			getCandidateDetailForm(data.pjId);
		}
	});
}
// 여기까지

// 이욱진
// 분명히 오픈소스가 있을텐데
function setSelectOptions(idx) {
	var one = $("#" + 0).val();
	var two = $("#" + 1).val();
	var three = $("#" + 2).val();
	var four = $("#" + 3).val();
	
	$.ajax({
		type : "POST",
		url : "/candidateSelectFunctionAjax",
		data : {
			one : one,
			two : two,
			three : three,
			four : four,
			idx : idx
		},
		success : function(data) {
			$("#selectOptionsTr td:eq(" + (idx + 1) + ")").empty();
			$("#selectOptionsTr td:eq(" + (idx + 1) + ")").html(data);
			for(var subI = 4; subI >= idx + 2; subI--) {
				reflashSelect(subI);
			}
			reflashSelectForm(idx);
		},
		error : function(xhr) {
			alert("setSelectOptions : " + xhr.statusText);
		}
	});
}

function reflashSelect(idx) {
	$.ajax({
		type : "POST",
		url : "/candidateSelectOptionDefaultFunctionAjax",
		data : {
			idx : idx
		},
		success : function(subData) {
			$('#selectOptionsTr td:eq(' + idx + ")").empty();
			$('#selectOptionsTr td:eq(' + idx + ")").html(subData);
		},
		error : function(xhr) {
			alert("candidateSelectOptionDefaultFunctionAjax Error = " + xhr.statusText);
		}
	});
}

//하드코딩되어있음
//이렇게안하면 자꾸 뒤쪽밸류가 안바뀜
//이거 바꿔야함
function reflashSelectForm(idx) {
	switch(idx) {
	case 0 :
		$("#one").val($("#0").val());
		$("#two").val("선택");
		$("#three").val("선택");
		$("#four").val("선택");
		$("#five").val("선택");
		return;
	case 1 :
		$("#two").val($("#1").val());
		$("#three").val("선택");
		$("#four").val("선택");
		$("#five").val("선택");
		return;
	case 2 :
		$("#three").val($("#2").val());
		$("#four").val("선택");
		$("#five").val("선택");
		return;
	case 3 :
		$("#four").val($("#3").val());
		$("#five").val("선택");
		return;
	case 4 :
		$("#five").val($("#4").val());
		return;
	}
}

function insertRequireOnCandidate(pj_id, pr_sq, pr_name) {
	$.ajax({
		type : "POST",
		url : "/insertRequireOnCandidate",
		data : {
			pj_id : pj_id,
			pr_sq : pr_sq,
			pr_name : pr_name
		},
		success : function(data) {
			alert("배치되었습니다.");
		},
		error : function(xhr) {
			alert("insertRequireOnCandidate Error = " + xhr.statusText)
		}
	});
}