$(window).ready(function() {
	var tableWidth = $("#SI1team").css("width");
	var containerHeight = $(".container").outerHeight();
	// var tableheight= $("#projectWrap").height();
	var tableheight = $("#SI1team").outerHeight();
	teamList('1S');
	$(".input_check").click(function() {
		var team_id = $(this).val();
		if ($("#" + team_id + "chk").is(":checked") == false) {
			$("#" + team_id + "team").children().remove();
		}
		if ($("#" + team_id + "chk").is(":checked") == true) {
			teamList(team_id)
		}
									});

					function getEmpDetail(e) {
						$(e.currentTarget).attr("id");
						var elem = document.getElementById(e);
						var name = elem.children[0].innerHTML;
						var identification = elem.children[1].innerHTML;
						// alert(identification)
						$
								.ajax({
									type : "POST",
									url : "/emp_DetailList",
									async : true,
									dataType : "json",
									data : {
										name : name,
										identification : identification
									},

									success : function(emp_detail) {

										var emp_name = emp_detail.emp_detail.name;
										var idenetification = emp_detail.emp_detail.identification;
										var position = emp_detail.emp_detail.position.substring(1,3);
										var job = emp_detail.emp_detail.job;
										var team_id = emp_detail.emp_detail.team_id;
										var team_area = emp_detail.emp_detail.team_area;
										var salary = emp_detail.emp_detail.salary;
										var state = emp_detail.emp_detail.state;
										var skillD = emp_detail.emp_detail.skillD;
										var skillL = emp_detail.emp_detail.skillL;
										var skillO = emp_detail.emp_detail.skillO;
										var skillM = emp_detail.emp_detail.skillM;
										var skillN = emp_detail.emp_detail.skillN;
										var skillW = emp_detail.emp_detail.skillW;
										var skillF = emp_detail.emp_detail.skillF;
										var hire_date = emp_detail.emp_detail.hire_date;
										var quit_date = emp_detail.emp_detail.quit_date;
										var career_date = emp_detail.emp_detail.career_date;
										var division = emp_detail.emp_detail.division;
										var photo = emp_detail.emp_detail.photo;
										var email = emp_detail.emp_detail.email;

										var out_radio = document
												.getElementById("out_form");
										var emp_radio = document
												.getElementById("emp_form");
										emp_radio.disabled = true;
										out_radio.disabled = true;
										if (division == 'O') {
											out_radio.checked = true;
											$("#hire_date").prev().html(
													"계약일 : ");
											$("#quit_date").prev().html(
													"만료일 : ");
											$("#emp_position").prev().html(
													"등급 : ");
											$("#emp_salary").prev().html(
													"단가 : ");
											$("#mail_form").text(" ");

										}
										if (division == 'E') {
											emp_radio.checked = true;
											$("#hire_date").prev().html(
													"입사일 : ");
											$("#quit_date").prev().html(
													"퇴사일 : ");
											$("#emp_position").prev().html(
													"직급 : ");
											$("#emp_salary").prev().html(
													"연봉 : ");
											$("#mail_form")
													.text("@sqisoft.com");

										}

										var name = document
												.getElementById("emp_name");
										name.value = emp_name;
										name.disabled = true;
										var name = document
												.getElementById("emp_identification");
										name.value = idenetification;
										name.disabled = true;
										var name = document
												.getElementById("emp_photo");
										name.src = photo;
										var name = document
												.getElementById("upload");
										name.disabled = true;
										var name = document
												.getElementById("hire_date");
										name.value = hire_date;
										name.disabled = true;
										var name = document
												.getElementById("career_date");
										name.value = career_date;
										name.disabled = true;
										var name = document
												.getElementById("quit_date");
										name.value = quit_date;
										name.disabled = true;
										var name = document
												.getElementById("emp_position");
										name.value = position;
										name.disabled = true;
										var name = document
												.getElementById("emp_team_id");
										name.value = team_id;
										name.disabled = true;
										var name = document
												.getElementById("emp_job");
										name.value = job;
										name.disabled = true;
										var name = document
												.getElementById("emp_salary");
										name.value = salary;
										name.disabled = true;
										var name = document
												.getElementById("emp_email");
										name.value = email;
										name.disabled = true;
										var name = document
												.getElementById("skill_db");
										name.value = skillD;
										name.disabled = true;
										var name = document
												.getElementById("skill_lang");
										name.value = skillL;
										name.disabled = true;
										var name = document
												.getElementById("skill_os");
										name.value = skillO;
										name.disabled = true;
										var name = document
												.getElementById("skill_middle");
										name.value = skillM;
										name.disabled = true;
										var name = document
												.getElementById("skill_network");
										name.value = skillN;
										name.disabled = true;
										var name = document
												.getElementById("skill_web");
										name.value = skillW;
										name.disabled = true;
										var name = document
												.getElementById("skill_framework");
										name.value = skillF;
										name.disabled = true;
										var name = document
												.getElementById("modify_btn");
										name.hidden = false;

									},
									error : function(xhr) {
										alert("error html = " + xhr.statusText);
									}
								});
					}
				});

function teamList(team_id){
	$.ajax({
		type : "POST",
		url : "/emp_List",
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
			/*
			 *  projectCount 는 여러개의 TEAM(SI1사업팀, 커머스사업팀 등)의 데이터가 이미 정렬되어 들어올것을 가정하고 반복한다.
			 *  데이터가 들어가는 순서 : DIV 초기화 -> HEADER 생성(팀명) -> 공간생성(정보 들어갈 Table) -> [각 프로젝트 정보 생성(ID,기간) -> [참여자 생성(참여자정보)]]
			 *  				: IF nowTRs와 maxTRs 같을 경우 옆에 동일한 테이블 생성 후 [각 프로젝..[참여..]]
			 */
			$.each(data.projectCount,function(entryIndex,projectCount) {
				
				//DIV 초기화
				if(projectCount.team_id != team_id_temp){
					
					if(team_id_temp != "" && html != ""){
						$("table:last","#" + team_id_temp + "team").append(html);
					}
					
					team_id_temp = projectCount.team_id;
					$("#" + team_id_temp + "team").empty();
				}
				
				//HEADER 생성
				if($("#" + projectCount.team_id + "team").is(':empty')){
					$("#" + projectCount.team_id + "team").prepend('<div style="display:block; bgcolor:#FAED7D">' + projectCount.team_name + '</div>');
					$("#" + projectCount.team_id + "team").append('<div style="float:left;"><table style="table-layout:fixed; width:255px;"></table></div>');
				}
				
				//Project Id 생성
				html += "<tr><td bgcolor='CEFBC9' style=' text-overflow: ellipsis; overflow: hidden; font-family:-webkit-pictograph'colspan='3'>"+ projectCount.pj_id+ "</td></tr>";
				if (++nowTRs == maxTRs) {
					//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
					createTeamTable(projectCount.team_id,html);
					html = "";
					nowTRs = 0;
				}
				
				//Project 기간 생성
				if(projectCount.pj_start_day==null || projectCount.pj_end_day== null){
					html += "<tr><td style='text-overflow: ellipsis; overflow: hidden;' bgcolor='#EAEAEA' colspan='3'><nobr>" + "-" + "<nobr></td></tr>";
				}else{
					html += "<tr><td style='text-overflow: ellipsis; overflow: hidden;' bgcolor='#EAEAEA' colspan='3'><nobr>" + projectCount.pj_start_day + "~" + projectCount.pj_end_day + "<nobr></td></tr>";
				}
				
				if (++nowTRs == maxTRs) {
					//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
					createTeamTable(projectCount.team_id,html);
					html = "";
					nowTRs = 0;
				}
				
				
				/*
				 *  empList는 projectCount의 리스트와 동일한 정렬로 있음을 가정하고(팀,프로젝트) slice 하여 사용한다.
				 *  slice 포인트는 프로젝트 아이디가 같을경우 다음 리스트부터 반복하기 위해 emp_idx에 저장하여 사용한다.
				 */
				$.each(data.empList.slice(emp_idx),function(k,	v) {
					//프로젝트 아이디가 같지 않으면 다음 리스트의 프로젝트에 참가한 직원을 의미함
					if (v.cpid != projectCount.pj_id){
						return false;
					}else{
						++emp_idx;
					}
					
					//2015-02-16 사람이 배치되지 않은 프로젝트 출력시 발생하는 예외 처리 
					if(projectCount.name_count==0){
						return false;
					}
					
					//사람 
					if(v.division=="외주"){
						html += "<tr style='background-color:#FFC19E'>";
					}else if(v.division=="직원"){
						html += "<tr>";
					}
					html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + v.name + "<nobr></td>";
					html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + v.position.substring(1) + "<nobr></td>";
					if(v.skill==null){
						
						html += "<td style='text-overflow: ellipsis; overflow: hidden;'><nobr>" + '-' + "<nobr></td></tr>";
					}else{
						html += "<td style='text-overflow: ellipsis; overflow: hidden;'><a title='" + v.skill + "'><nobr>" + v.skill + "<nobr></a></td></tr>";
					}
					
					if (++nowTRs == maxTRs) {
						//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
						createTeamTable(projectCount.team_id,html);
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
			$(".teamWrap table:empty").remove();
		},
		error : function(xhr) {
			alert("error html = "+ xhr.statusText);
		}
	});
}

function createTeamTable(teamId, bHtml){
	//maxTRs 일 경우 다음 Table 생성 및 관련 변수 초기화
	$("table:last", "#" + teamId + "team").append(bHtml);
	$("#" + teamId + "team").append("<div style='float:left;'><table style='table-layout:fixed;width:255px;'></table></div>");
}