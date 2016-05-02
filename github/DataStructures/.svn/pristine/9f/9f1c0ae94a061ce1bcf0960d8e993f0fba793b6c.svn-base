// 평가 등록 기본 폼
function getEstimateForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/estSignupUpdate",
		success : function(data) {
			$("#mainDiv").empty();
			$("#mainDiv").html(data);
		},
		error : function(xhr) {
			/*alert("평가 등록 Error : " + xhr.statusText);*/
		}
	});
}

// 등록 폼 :  서치 기본
function getEstimationSignupSearchForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/estSignupSearch",
		success : function(data) {
			$("#dontHaveIdeaInThisDivName").empty();
			$("#dontHaveIdeaInThisDivName").html(data);
		},
		error : function(xhr) {
			alert("평가 조회 getEstimationSignupSearchForm Error : " + xhr.statusText);
		}
	});
}

// 등록 폼 : 년도 서치
function getEstimationSignupYearAjax(searchYear) {
	$.ajax({
		type : "POST",
		url : "/humanResource/estSignupUpdate",
		data : {
			"searchYear" : searchYear
		},
		success : function(data) {
			$("#mainDiv").empty();
			$("#mainDiv").html(data);
		},
		error : function(xhr) {
			alert("평가 조회 getEstimationSignupYearAjax Error : " + xhr.statusText);
		}
	});
}

// 등록 폼 : 프로젝트 아이디 서치
function getEstimationSignupProjectAjax(pj_id) {
	$.ajax({
		type : "POST",
		url : "/humanResource/estSignupUpdate",
		data : {
			"pj_id" : pj_id
		},
		success : function(data) {
			$("#mainDiv").empty();
			$("#mainDiv").html(data);
		},
		error : function(xhr) {
			alert("평가 조회 getEstimationSignupProjectAjax Error : " + xhr.statusText);
		}
	});
}

// 수정
function estimationModifyFormAjax(pd_name, pj_id, pd_abc, pd_soft_abc, pd_abc_desc) {
	$.ajax({
		type: "POST",
		url : "/humanResource/estSigupUpdateAjax",
		data : {
			pd_name			:	pd_name
			, pj_id			:	pj_id
			, pd_abc		:	pd_abc
			, pd_soft_abc	:	pd_soft_abc
			, pd_abc_desc	:	pd_abc_desc
		},
		success : function(data) {
		},
		error : function(xhr) {
			alert("평가 조회 estimationModifyFormAjax Error : " + xhr.statusText);
		}
	});
}

//글자수 제한 체크 
function pdAbcDescLength(comment, maxLength) {
	
	var str = comment.value;
	var str_length = str.length;
	
	var max_length = maxLength;
	var i = 0;
	var ko_byte = 0;
	var li_len = 0;
	var one_char ="";
	var str2 ="";
	
	for(i=0; i<str_length; i++) {
		one_char = str.charAt(i);
		
		if(escape(one_char).length > 4) {
			ko_byte += 2;
		}
		else {
			ko_byte++;
		}
		if(ko_byte <= max_length) {
			li_len = i+1;
		}
	}
	
	if(ko_byte > max_length) {
		alert("평가 설명은 300글자 내로 입력해주세요.");
		str2 = str.substr(0, li_len);
		comment.value = str2;
	}
	comment.focus();
}
// ----------------------------	
// 평가 조회 기본 폼
function getEstimationListForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/estViewList",
		success : function(data) {
			$("#mainDiv").empty();
			$("#mainDiv").html(data);
		},
		error : function(xhr) {
			alert("리스트 getEstimationListForm Error : " + xhr.statusText);
		}
	});
}

// pm평가 조회 서치 기본
function getEstimationSearchForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/estViewSearch",
		success : function(data) {
			$("#dontHaveIdeaInThisDivName").empty();
			$("#dontHaveIdeaInThisDivName").html(data);
		},
		error : function(xhr) {
			alert("평가 조회  getEstimationSearchForm Error : " + xhr.statusText);
		}
	});
}

// 팀명 서치
function getEstimationSearchTeamAjax(tm_id) {
	$.ajax({
		type : "POST",
		url : "/humanResource/estViewList",
		data : {
			"tm_id" : tm_id
		},
		success : function(data) {
			$("#mainDiv").empty();
			$("#mainDiv").html(data);
		},
		error : function(xhr) {
			//alert("평가 조회 getEstimationSearchTeamAjax Error : " + xhr.statusText);
		}
	});
}

//이름 search
function getEstimationSearchNameAjax(hr_name){
	$.ajax({
		type : "POST" ,
		url : "/humanResource/estViewList",
		data : {
			"hr_name" : hr_name
		},
		success : function(data){
			$("#mainDiv").empty();
			$("#mainDiv").html(data);
		},
		error : function(xhr){
			
		}
	});
}