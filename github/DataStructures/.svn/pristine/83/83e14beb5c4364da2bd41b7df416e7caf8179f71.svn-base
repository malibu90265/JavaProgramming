//selectBox에 팀을 뿌려줌
function selectTeam(){
	$.ajax({
		type : "POST",
		url : "/humanResource/undecided/selectTeam",
		success : function(data) {
			$("#undecidedSearchForm").empty();
			$("#undecidedSearchForm").html(data);
			$("#undecidedModifyForm").hide();
		},
		error : function(xhr) {
			alert("selectTeam = " + xhr.statusText);
		}
	});
}

//셀렉트 박스의 팀에 해당하는 프로젝트들의 정보를 뿌려줌
function getUndecidedList(tm_id) {
	$.ajax({
		type : "POST",
		url : "/humanResource/undecided/getUndecidedList",
		data : {
			tm_id : tm_id
		},
		success : function(data) {
			$("#undecidedListForm").empty();
			$("#undecidedListForm").html(data);
		},
		error : function(xhr) {
			alert("getUndecidedList = " + xhr.statusText);
		}
	});
}

//프로젝트 리스트에서 특정 프로젝트를 클릭할 시 디테일 모디파이 폼을 띄워줌
function getUndecidedModifyForm(pj_id) {
	$("#undecidedModifyForm").show();
	$.ajax({
		type : "POST",
		url : "/humanResource/undecided/getUndecidedModifyForm",
		data : {
			pj_id : pj_id
		},
		success : function(data) {
			$("#undecidedModifyForm").empty();
			$("#undecidedModifyForm").html(data);
		},
		error : function(xhr) {
			alert("getUndecidedModifyForm = " + xhr.statusText);
		}
	});
}

//배치된 사람들을 투입함
function insertUndecided(pj_id, pr_sq, pr_start_date, pr_end_date, pr_uprice, pr_name) {
	var num;
	$.ajax({
		type : "POST",
		url : "/humanResource/undecided/insertUndecided",
		data : {
			pj_id			: pj_id,
			pr_sq			: pr_sq,
			pr_start_date	: pr_start_date,
			pr_end_date		: pr_end_date,
			pr_uprice		: pr_uprice,
			pr_name			: pr_name
		},
		success : function(data) {
			getUndecidedList($("#tm_name").val());
			getUndecidedModifyForm(pj_id);
		},
		error : function(xhr) {
			alert("insertUndecided = " + xhr.statusText);
		}
	});
}
