$(window).ready(function() {
	var tableWidth = $("#SI1team").css("width");
	var containerHeight = $(".container").outerHeight();
	var tableheight = $("#SI1team").outerHeight();
	$(".input_check").click(function() {
		var team_id = $(this).val();
		if ($("#" + team_id + "chk").is(":checked") == false) {
			$("#" + team_id + "team").children().remove();
		}
		if ($("#" + team_id + "chk").is(":checked") == true) {
			teamList(team_id)
		}
	});
});


function teamList(team_id){
	$.ajax({
		type : "POST",
		url : "/empPjMap/getCheckBoxValueAjax",
		async : true,
		dataType : "json",
		data : {
			team_id : team_id
		},
		success : function(data) {
			var team_id_temp = "";	//projectCount 에 여러 팀이 들어 왔을 경우 each에서 활용
			var emp_idx = 0;		//empList each에서 활용
			var maxTRs = 30;		//HEAD 를 제외한 프로젝트 정보(각 2row:ID,기간),참여자 정보(각 1row)의 
			var nowTRs = 0;
			var html = "";
			var d = new Date();
			var year = d.getFullYear();
			var month = d.getMonth() + 1;
			var date = d.getDate();
			
			year *= 1;
			month *= 1;
			date *= 1;
			
			var sysDate = year*10000 + month*100 + date;
			/*
			 *  projectCount 는 여러개의 TEAM(SI1사업팀, 커머스사업팀 등)의 데이터가 이미 정렬되어 들어올것을 가정하고 반복한다.
			 *  데이터가 들어가는 순서 : DIV 초기화 -> HEADER 생성(팀명) -> 공간생성(정보 들어갈 Table) -> [각 프로젝트 정보 생성(ID,기간) -> [참여자 생성(참여자정보)]]
			 *  				: IF nowTRs와 maxTRs 같을 경우 옆에 동일한 테이블 생성 후 [각 프로젝..[참여..]]
			 */
			$.each(data.projectCount,function(entryIndex,projectCount) {
				
				//DIV 초기화
				if(projectCount.tm_id != team_id_temp){
					
					if(team_id_temp != "" && html != ""){
						$("table:last","#" + team_id_temp + "team").append(html);
					}
					
					team_id_temp = projectCount.tm_id;
					$("#" + team_id_temp + "team").empty();
				}
				
				//HEADER 생성
				if($("#" + projectCount.tm_id + "team").is(':empty')){
					$("#" + projectCount.tm_id + "team").prepend('<div style="display:block; bgcolor:#FAED7D"><b>' + projectCount.tm_name + '</div>');
					$("#" + projectCount.tm_id + "team").append('<div style="float:left;width:255px"><table style="table-layout:fixed; width:255px;"></table></div>');
				}
				
				//Project Id 생성
				html += "<tr><td bgcolor='dce9f9' style=' text-overflow: ellipsis; overflow: hidden; font-family:-webkit-pictograph'colspan='3'><b>"+ projectCount.pj_id+ "</td></tr>";
				if (++nowTRs == maxTRs) {
					//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
					createTeamTable(projectCount.tm_id,html);
					html = "";
					nowTRs = 0;
				}
				
				//Project 기간 생성
				if(projectCount.pj_start_date==null || projectCount.pj_end_date== null){
					html += "<tr><td style='text-overflow: ellipsis; overflow: hidden;' bgcolor='dce9f9' colspan='3'><nobr>" + "-" + "<nobr></td></tr>";
				}else{
					html += "<tr><td style='text-overflow: ellipsis; overflow: hidden;' bgcolor='dce9f9' colspan='3'><nobr>" + projectCount.pj_start_date + "~" + projectCount.pj_end_date + "<nobr></td></tr>";
				}
				
				if (++nowTRs == maxTRs) {
					//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
					createTeamTable(projectCount.tm_id,html);
					html = "";
					nowTRs = 0;
				}
				
				
				/*
				 *  empList는 projectCount의 리스트와 동일한 정렬로 있음을 가정하고(팀,프로젝트) slice 하여 사용한다.
				 *  slice 포인트는 프로젝트 아이디가 같을경우 다음 리스트부터 반복하기 위해 emp_idx에 저장하여 사용한다.
				 */
				$.each(data.empList.slice(emp_idx),function(k,	v) {
					//프로젝트 아이디가 같지 않으면 다음 리스트의 프로젝트에 참가한 직원을 의미함
					if (v.pj_id != projectCount.pj_id){
						return false;
					}else{
						++emp_idx;
					}
					
					/*//2015-02-16 사람이 배치되지 않은 프로젝트 출력시 발생하는 예외 처리 
					if(projectCount.name_count==0){
						return false;
					}*/
					
					var start_date = v.pd_start_date;
					var end_date = v.pd_end_date;
					
					var strArray = start_date.split('-');
					var pd_start_date = strArray[0] + strArray[1] + strArray[2];
					strArray = end_date.split('-');
					var pd_end_date = strArray[0] + strArray[1] + strArray[2];
					
					pd_start_date *= 1;
					pd_end_date *= 1;
					
					/*console.log(v.hr_name);
					console.log(sysDate);
					console.log(pd_start_date);
					console.log(sysDate-pd_start_date);
					console.log("----------------");*/
					
					if(sysDate-pd_start_date < 0){ //투입 예정인 사람이면 글씨를 초록색으로
						//사람 
						html += "<tr style='background-color:#CEF279; '>";
						html += "<td style='text-overflow: ellipsis; overflow: hidden; background-color:#CEF279;'><nobr>" + v.pd_name + "<nobr></td>";
						html += "<td style='text-overflow: ellipsis; overflow: hidden; background-color:#CEF279;'><nobr>" + v.hr_position + "<nobr></td>";
						if(v.hr_job_skill==null){
							html += "<td style='text-overflow: ellipsis; overflow: hidden; background-color:#CEF279;'><nobr>" + '-' + "<nobr></td></tr>";
						}else{
							html += "<td style='text-overflow: ellipsis; overflow: hidden; background-color:#CEF279;'><nobr>" + v.hr_job_skill + "<nobr></td></tr>";
						}
					}else{ //투입 중인 사람이면 default!
						//사람 
						if(v.hr_division=="외주"){
							html += "<tr style='background-color:#EAEAEA; '>";	//8AD272,EAD499,8AD292,98EAA2,B1B7B2,B0D0B6,FFDEAD
						}else if(v.hr_division=="직원"){
							html += "<tr style='background-color:#FFDEAD; '>";
						}
						
						html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + v.pd_name + "<nobr></td>";
						html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + v.hr_position + "<nobr></td>";
						if(v.hr_job_skill==null){
							html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + '-' + "<nobr></td></tr>";
						}else{
							html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + v.hr_job_skill + "<nobr></td></tr>";
						}
					}
					
					
					
					if (++nowTRs == maxTRs) {
						//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
						createTeamTable(projectCount.tm_id,html);
						html = "";
						nowTRs = 0;
					}
				});
			});
			
			//반복문 뒤에 남는 HTML 삽입
			if(html != ""){
				$("table:last","#" + team_id_temp + "team").append(html);
			}
			
			//데이터가 없는 빈공간 삭제.
			$(".bordered table:empty").remove();
		},
		error : function(xhr) {
			alert("teamList Error = "+ xhr.statusText);
		}
	});
}

function createTeamTable(teamId, bHtml){
	//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
	$("table:last", "#" + teamId + "team").append(bHtml);
	$("#" + teamId + "team").append("<div style='float:left;width:255px'><table style='table-layout:fixed;width:255px;'></table></div>");
}
