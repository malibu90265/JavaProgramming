//tagId : 배치소요 혹은 투입 날짜가 들어간 input의 id
//tagId으 value가 프로젝트 시작일보다 작으면 false를 반환
function startDateCheck(tagId) {
	var pj_start_date = $("#pj_end_date").text().split("~")[0].trim();
	var pj_end_date = $("#pj_end_date").text().split("~")[1].trim();
	var pj_start_date_target = $("#" + tagId).val();
	
	if(pj_start_date > pj_start_date_target) {
		alert("선택한 날짜는 프로젝트 시작일 이전입니다.");
		return false;
	}else if(pj_start_date_target > pj_end_date){
		alert("선택한 날짜는 프로젝트 종료일 이후입니다. 날짜를 다시 선택해주세요.")
		$("#" + tagId).val(" ");
	}else {
		return true;
	}
}

//tagId : 배치소요 혹은 투입 날짜가 들어간 input의 id
//tagId으 value가 프로젝트 종료일보다 크면 false를 반환
function endDateCheck(tagId) {
	var pj_start_date = $("#pj_end_date").text().split("~")[0].trim();
	var pj_end_date = $("#pj_end_date").text().split("~")[1].trim();
	var pj_end_date_target = $("#" + tagId).val();
	
	if(pj_end_date < pj_end_date_target) {
		alert("선택한 날짜는 프로젝트 시작일 이후입니다. 날짜를 다시 선택해주세요.");
		$("#" + tagId).val(" ");
		return false;
	}else if(pj_end_date_target < pj_start_date){
		alert("선택한 날짜는 프로젝트 시작일 이전입니다.  날짜를 다시 선택해주세요.");
		$("#" + tagId).val(" ");
	}else {
		return true;
	}
}