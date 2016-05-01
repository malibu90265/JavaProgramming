// 입력값 체크
function inputChk(insertFormId) {
	var check = true;
	
	// 필수입력 : 이름
	if(check) {
		var hr_name = $(insertFormId).find("#hr_name").val();
		if(hr_name == null || hr_name == ''){
			alert("이름을 입력해 주세요.");
			check = false;
		}
		else {
			check = true;
		}
	}
	
	// 필수입력 : 이메일 검증
	if(check) {
		var hr_email = $(insertFormId).find("#hr_email").val();
		if(hr_email == null || hr_email == ''){
			alert("이메일을 입력해 주세요.");
			check = false;
		}
		else {
			check = true;
		}
	}
	
	// 필수입력 : 핸드폰 검증
	if(check) {
		var hr_mobile = $(insertFormId).find("#hr_mobile").val();
		if(hr_mobile == null || hr_mobile == '') {
			alert("핸드폰 번호를 입력해주세요");
			check = false;
		}
		else {
			// 핸드폰 번호 검증
			var regexMobile = /^[0-9]{2,4}-[0-9]{3,4}-[0-9]{4}$/;
			if(regexMobile.test( $("#hr_mobile").val() ) == false) {
				alert("전화번호 형식으로 입력해주세요. ex) 010-0000-0000");
				$("#hr_mobile").focus();
				check = false;
			}
			else {
				check = true;
			}
		}
	}
	
	// 필수입력 : 입사일
	if(check) {
		var hr_hire_date = $(insertFormId).find("#hr_hire_date").val();
		if(hr_hire_date == null || hr_hire_date == '') {
			alert("입사일을 입력해주세요.");
			check = false;
		}
		else {
			check= true;
		}
	}
	
	// 입력 안해도 통과
	// 경력 기준일
	if(check) {
		var hr_career_date = $(insertFormId).find("#hr_career_date").val();
		if(hr_career_date == null || hr_career_date == '') {
			check = true;
		}
	}
	
	// 퇴사일
	if(check) {
		var hr_quit_date = $(insertFormId).find("#hr_quit_date").val();
		if(hr_quit_date == null || hr_quit_date == '') {
			check = true;
		}
	}
	
	// 차기 프로젝트 가능일
	if(check) {
		var hr_nextpj_date = $(insertFormId).find("#hr_nextpj_date").val();
		if(hr_nextpj_date == null || hr_nextpj_date == '') {
			check = true;
		}
	}
	
	// 최종 수행 project
	if(check) {
		var hr_last_project = $(insertFormId).find("#hr_last_project").val();
		if(hr_last_project == null || hr_last_project == '') {
			check = true;
		}
	}
	
	// 기반분류
	if(check) {
		var hr_cwm_env_list = $(insertFormId).find("#hr_cwm_env_list").val();
		if(hr_cwm_env_list == null || hr_cwm_env_list == '') {
			check = true;
		}
	}
	
	// 이전단가
	if(check) {
		var hr_b4_uprice = $(insertFormId).find("#hr_b4_uprice").val();
		if(hr_b4_uprice == null || hr_b4_uprice == '') {
			check = true;
		}
	}
	
	// 거주지
	if(check) {
		var hr_residence = $(insertFormId).find("#hr_residence").val();
		if( !(hr_residence == null || hr_residence == '')) {
			var regexResidence = /^[ㄱ-ㅣ가-힣]{1,4}$/;
			if(regexResidence.test( hr_residence ) == false) {
				alert("한글 4자 이하로 서울은 '구'를 그 외 지역은 '시'를 입력해주세요.");
				$("#hr_residence").focus();
			}
		}
	}
	

	
	// 최종 출신교
	if(check) {
		var hr_last_school = $(insertFormId).find("#hr_last_school").val();
		if(hr_last_school == null || hr_last_school == '') {
			check = true;
		}
	}
	
	// 전공
	if(check) {
		var hr_major = $(insertFormId).find("#hr_major").val();
		if(hr_major == null || hr_major == '') {
			check = true;
		}
	}
	
	return check;
}



// 수정 체크
//입력값 체크
function modifyChk(formId) {
	var check = true;
	
	// 필수입력 해제 : 이름
	if(check) {
		var hr_name = $(formId).find("#hr_name").val();
		if(hr_name == null || hr_name == ''){
			check = true;
		}
	}
	
	// 필수입력 해제 : 이메일 검증
	if(check) {
		var hr_email = $(formId).find("#hr_email").val();
		if(hr_email == null || hr_email == ''){
			check = true;
		}
	}
	
	// 필수입력 해제 : 핸드폰 검증
	if(check) {
		var hr_mobile = $(formId).find("#hr_mobile").val();
		if(hr_mobile == null || hr_mobile == '') {
			check = true;
		}
	}
	
	// 필수입력 해제 : 입사일
	if(check) {
		var hr_hire_date = $(formId).find("#hr_hire_date").val();
		if(hr_hire_date == null || hr_hire_date == '') {
			check = true;
		}
	}
	
	// 입력 안해도 통과
	// 경력 기준일
	if(check) {
		var hr_career_date = $(formId).find("#hr_career_date").val();
		if(hr_career_date == null || hr_career_date == '') {
			check = true;
		}
	}
	
	// 퇴사일
	if(check) {
		var hr_quit_date = $(formId).find("#hr_quit_date").val();
		if(hr_quit_date == null || hr_quit_date == '') {
			
			check = true;
		}
	}
	
	// 차기 프로젝트 가능일
	if(check) {
		var hr_nextpj_date = $(formId).find("#hr_nextpj_date").val();
		if(hr_nextpj_date == null || hr_nextpj_date == '') {
			check = true;
		}
	}
	
	// 최종 수행 project
	if(check) {
		var hr_last_project = $(formId).find("#hr_last_project").val();
		if(hr_last_project == null || hr_last_project == '') {
			check = true;
		}
	}
	
	// 기반분류
	if(check) {
		var hr_cwm_env_list = $(formId).find("#hr_cwm_env_list").val();
		if(hr_cwm_env_list == null || hr_cwm_env_list == '') {
			check = true;
		}
	}
	
	// 이전단가
	if(check) {
		var hr_b4_uprice = $(formId).find("#hr_b4_uprice").val();
		if(hr_b4_uprice == null || hr_b4_uprice == '') {
			check = true;
		}
	}
	
/*	// 필수입력 : 현재단가
	if(check) {
		var hr_uprice = $(formId).find("#hr_uprice").val();
		if(hr_uprice == null || hr_uprice == '') {
			check = true;
		}
	}*/
	
	// 거주지
	if(check) {
		var hr_residence = $(formId).find("#hr_residence").val();
		if( hr_residence == null || hr_residence == '') {
			check = true;
		}
	}
	
	
	// 최종 출신교
	if(check) {
		var hr_last_school = $(formId).find("#hr_last_school").val();
		if(hr_last_school == null || hr_last_school == '') {
			check = true;
		}
	}
	
	// 전공
	if(check) {
		var hr_major = $(formId).find("#hr_major").val();
		if(hr_major == null || hr_major == '') {
			check = true;
		}
	}
	
	return check;
}


//외주 입력값 체크
function inputChkOut(insertFormId) {
	var check = true;
	
	// 필수입력 : 이름
	if(check) {
		var hr_name = $(insertFormId).find("#hr_name").val();
		if(hr_name == null || hr_name == ''){
			alert("이름을 입력해 주세요.");
			check = false;
		}
		else {
			check = true;
		}
	}
	
	// 필수입력 : 소속회사
	if(check) {
		var hr_company = $(insertFormId).find("#hr_company").val();
		if(hr_company == null || hr_company == ''){
			alert("소속회사를 입력해 주세요.");
			check = false;
		}
		else {
			check = true;
		}
	}
	
	// 이메일 입력값 검증
	if(check) {
		var hr_email = $(insertFormId).find("#hr_email").val();
		if( !(hr_email == null || hr_email == '')) {
			var regexEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; 
			if(regexEmail.test( hr_email ) == false) {
				alert("이메일 형식으로 입력해주세요. ex) id@email.com");  
				$("#hr_email").focus();
				check = false;
			}
		}
		else {
			check = true;
		}
	}
	
	// 필수입력 : 핸드폰 검증
	if(check) {
		var hr_mobile = $(insertFormId).find("#hr_mobile").val();
		if(hr_mobile == null || hr_mobile == '') {
			check = true;
		}
	}
	
	// 입력 안해도 통과
	// 경력 기준일
	if(check) {
		var hr_career_date = $(insertFormId).find("#hr_career_date").val();
		if(hr_career_date == null || hr_career_date == '') {
			check = true;
		}
	}
	
	// 차기 프로젝트 가능일
	if(check) {
		var hr_nextpj_date = $(insertFormId).find("#hr_nextpj_date").val();
		if(hr_nextpj_date == null || hr_nextpj_date == '') {
			check = true;
		}
	}
	
	// 최종 수행 project
	if(check) {
		var hr_last_project = $(insertFormId).find("#hr_last_project").val();
		if(hr_last_project == null || hr_last_project == '') {
			check = true;
		}
	}
	
	// 기반분류
	if(check) {
		var hr_cwm_env_list = $(insertFormId).find("#hr_cwm_env_list").val();
		if(hr_cwm_env_list == null || hr_cwm_env_list == '') {
			check = true;
		}
	}
	
	// 이전단가
	if(check) {
		var hr_b4_uprice = $(insertFormId).find("#hr_b4_uprice").val();
		if(hr_b4_uprice == null || hr_b4_uprice == '') {
			check = true;
		}
	}
	
	// 필수입력 : 현재단가
	if(check) {
		var hr_uprice = $(insertFormId).find("#hr_uprice").val();
		if(hr_uprice == null || hr_uprice == '') {
			check = true;
		}
	}
	
	// 거주지
	if(check) {
		var hr_residence = $(insertFormId).find("#hr_residence").val();
		if( !(hr_residence == null || hr_residence == '')) {
			var regexResidence = /^[ㄱ-ㅣ가-힣]{1,4}$/;
			if(regexResidence.test( hr_residence ) == false) {
				alert("한글 4자 이하로 서울은 '구'를 그 외 지역은 '시'를 입력해주세요.");
				$("#hr_residence").focus();
			}
		}
	}
	
	// 최종 출신교
	if(check) {
		var hr_last_school = $(insertFormId).find("#hr_last_school").val();
		if(hr_last_school == null || hr_last_school == '') {
			check = true;
		}
	}
	
	// 전공
	if(check) {
		var hr_major = $(insertFormId).find("#hr_major").val();
		if(hr_major == null || hr_major == '') {
			check = true;
		}
	}
	
	return check;
}
