//날짜 선택시 달력 출력
function setDate(i){
	$("#pr_start_date"+i).datepicker({
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
			$("#pr_end_date"+i).datepicker( "option", "minDate", selectedDate );
		}
	});
	
	$("#pr_end_date"+i).datepicker({
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
			  $("#pr_start_date"+i).datepicker( "option", "maxDate", selectedDate );
		}
	});
	
}

//개월 수 계산
function setMonth(i){
	var start = $("#pr_start_date"+i).val();
	var end = $("#pr_end_date"+i).val();
	if(start!="" && end!=""){
		start = start.split('-');
		end = end.split('-');

		for (var j = 0; j < start.length; j++) {
			start[j] = parseInt(start[j]);
			end[j] = parseInt(end[j]);
		}

		var month = (end[0] - start[0]) * 12 + (end[1] - start[1] - 1);
		var day = 30 + end[2] - start[2];
		day = day.toFixed(1);
		day = day / 30;

		month += day;
		month = month.toFixed(1);

		$("#months" + i).text(month);
		
	}else{
		$("#months" + i).text("0");
	}
	
}


//selectBox에서 팀 선택
function selectTeam(){
	$.ajax({
		type : "POST",
		url : "/deployRequirements/selectTeam",
		success : function(data) {
			$("#deployRequirementsSearch").empty();
			$("#deployRequirementsSearch").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
	
}

//팀별 프로젝트 검색
function searchDeployRequirements(tm_id) {
	$.ajax({
		type : "POST",
		url : "/deployRequirements/searchTeamProject",
		data : {
			tm_id : tm_id
		},
		success : function(data) {
			$("#deployRequirementsDiv").empty();
			$("#deployRequirementsDiv").html(data);
			$("#deployRequirementsForm").hide();
		},
		error : function(xhr) {
			alert("searchDeployRequirements " + xhr.statusText);
		}
	});
}

//선택한 프로젝트의 정보 출력 
function getDeployRequirementsDetailForm(pj_id) {
	$.ajax({
		type : "POST",
		url : "/deployRequirements/getDeployRequirementsDetailForm",
		data : {
			pj_id : pj_id
		},
		success : function(data) {
			$("#deployRequirementsForm").show();
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
			
			$.ajax({
				type :"POST",
				url : "/deployRequirements/getDeployRequirementsMaxPrSq",
				data : {
					pj_id : pj_id
				},
				success : function(data) {
					$("#requirePerson").val(data);
					getInsertPageAjax(data, pj_id);
				}
			})
		},
		error : function(xhr) {
			alert("getDeployRequirementsDetailForm = " + xhr.statusText);
		}
	});
}

//insert form 출력
function getInsertPageAjax(num, pj_id) {
	$.ajax({
		type : "POST",
		url : "/deployRequirements/getInsertPageAjax",
		data : {
			num : num,
			pj_id : pj_id,
		},
		success : function(data) {
			if(num == 0) {
				$("#requireInsertForm").empty();
				return;
			}
			$("#requireInsertForm").empty();
			$("#requireInsertForm").html(data);
			for(var i=1; i <= num; i++) {
				getEmployeeInfo($("#pr_name" + i).val() ,i, pj_id);
				setDate(i);
				setMonth(i);
				pr_upriceIsNum(i);
			}
		},
		error : function(xhr) {
			alert("getInsertPageAjax = " + xhr.statusText) 
		}
	});
}

//직원 이름 입력시 해당 직원의 직급, 단가, 거주지 가져오기
function getEmployeeInfo(pr_name, hr_index, pj_id){
	$.ajax({
		type : "POST",
		url : "/deployRequirements/getEmployeeInfo",
		data : {
			"pr_name" : pr_name,
			"pj_id" : pj_id
		},
		success : function(data) {
			if(data.employeeInfoList != null) {
				$("#hr_grade"+hr_index).text(data.employeeInfoList.hr_grade);
				$("#hr_uprice"+hr_index).text(data.employeeInfoList.hr_uprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
				$("#hr_residence"+hr_index).text(data.employeeInfoList.hr_residence);
			} else {
				$("#hr_grade"+hr_index).text("");
				$("#hr_uprice"+hr_index).text("");
				$("#hr_residence"+hr_index).text("");
			}
		},
		error : function(xhr) {
			alert("getEmployeeInfoPageAjax = " + xhr.statusText) 
		}
	});	
}

//직원 이름 입력시 해당 직원의 직급, 단가, 거주지 가져오기
function getHr(hrIndex) {
	getEmployeeInfo($("#pr_name"+hrIndex).val(), hrIndex, $("#pj_detail_id").text());
}

// insert및 update를 실행하는 부분
function insertPjRequire(pj_id, pr_sq, pr_grade, pr_job_skill, pr_start_date, pr_end_date, pr_uprice, pr_name) {
	$.ajax({
		type : "POST",
		url : "/deployRequirements/insertPjRequire",
		data : {
			pj_id			: pj_id,
			pr_sq			: pr_sq,
			pr_grade 		: pr_grade,
			pr_job_skill	: pr_job_skill,
			pr_start_date	: pr_start_date,
			pr_end_date		: pr_end_date,
			pr_uprice		: pr_uprice,
			pr_name			: pr_name
		},
		success : function() {
		},
		error : function(xhr) {
			alert("insertPjRequire = " + xhr.statusText);
		}
	});
}

// insert가 다 끝나고 소요인원보다 pr_sq가 큰 데이터를 delete
function deletePjRequireAfterInsert(pj_id, pr_sq) {
	$.ajax({
		type : "POST",
		url : "/deployRequirements/deletePjRequireAfterInsert",
		data : {
			pj_id	: pj_id,
			pr_sq	: pr_sq
		},
		success : function() {
			var num = $("#requirePerson").val();
			if(num == "" || num == null) {num = 0;}
			getInsertPageAjax(num, pj_id)
		},
		error : function(xhr) {
			alert("deletePjRequireAfterInsert" + xhr.statusText);
		}
	});
}

// 삭제
function deletePjRequire(pj_id) {
	if(confirm("정말 삭제하시겠습니까?")){
		$.ajax({
			type : "POST",
			url : "/deployRequirements/deletePjRequire",
			data : {
				pj_id	: pj_id
			},
			success : function() {
				var num = $("#requirePerson").val();
				if(num == "" || num == null) {num = 0;}
				getInsertPageAjax(num, pj_id)
			},
			error : function(xhr) {
				alert("deletePjRequire" + xhr.statusText);
			}
		});
	}else{
		return false;
	}
}

// 비우기 버튼 클릭시 
function resetBtnClick() {
	var num = $("#requirePerson").val();
	var pj_id = $("#pj_detail_id").text();
	if(num == "" || num == null) {num = 0;}
	getInsertPageAjax(num, pj_id);
}

//소요 단가가 숫자인지 확인
function pr_upriceIsNum(number) {
	var pr_upriceVal = $("#pr_uprice" + number).val();
	var comma = /,/g;
	pr_upriceVal = pr_upriceVal.replace(comma,'');
	
	x = pr_upriceVal.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : "";
	
	var rgx = /(\d+)(\d{3})/;
	while(rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	$("#pr_uprice" + number).val(x1 + x2);
}

//직원 이름 입력시 human_resource 테이블에 존재하는 직원인지 확인
function checkPrNameExist(number) {
	for(var i=1; i<number; i++) {
		var txtMerge = $("#pr_name" + i).val() + $("#pr_uprice" + i).val() + $("#hr_residence" + i).val();
		if(txtMerge == null || txtMerge == '') {
			return false;
		}
	}
}

/*function getDeployRequirementsList(){
	$.ajax({
		type : "POST",
		url : "/deployRequirements/getDeployRequirementsListAjax",
		success : function(data) {
			$("#deployRequirementsDiv").empty();
			$("#deployRequirementsDiv").html(data);
		},
		error : function(xhr) {
			alert("getDeployRequirementsList = " + xhr.statusText);
		}
	});
	
}*/
