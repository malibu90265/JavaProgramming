function blank_ck(options){
	//
	var emp_radio = document.getElementById("emp_form");
	 var out_radio = document.getElementById("out_form");
 
	 
//	직원	 
if($("#emp_form").prop("checked")){
	if(frm.name.value == ""){
		alert ("직원명을 입력하세요"); 
		frm.name.focus();
		return false;
		}
	
	if(frm.hire_date.value == "") {
		alert ("입사일을 입력하세요"); 
		frm.hire_date.focus();
		return false;
	}
	
	if(frm.career_date_Y.value == "") {
		alert ("경력(년)을 입력하세요"); 
		frm.career_date_Y.focus();	
		return false ;
	}
	
	if(frm.career_date_M.value == "") {
		alert ("경력(월)을 입력하세요"); 
		frm.career_date_M.focus();	
		return false ;
	}

	if(frm.position.value =="" ){ 
		alert ("직급을 선택하세요"); 
		frm.position.focus();		
		return false;
	}
	
	if(frm.grade.value =="" ){ 
		alert ("등급을 선택하세요"); 
		frm.grade.focus();		
		return false;
	}
	
	if(frm.team_id.value =="" ){ 
		alert ("팀을 선택하세요"); 
		frm.team_id.focus();		
		return false;
	}
	
	
	if(frm.area.value =="" ){ 
		alert ("거주지를 선택하세요"); 
		frm.area.focus();		
		return false;
	}
	
	if(frm.area1_1.value =="" ){ 
		alert ("거주지를 모두 선택하세요"); 
		frm.area1_1.focus();		
		return false;
	}
	
	if(frm.email.value == "") {
		alert ("e-mail을 입력하세요"); 
		frm.email.focus();
		return false;
	}
	
	
	
	
	//이메일 유효성 체크
	/*
	   ^[0-9a-zA-Z] --> 첫글자는 숫자또는 영문자
		[-_.]? --> - 또는 _ 또는 . 이 0번 또는 1번 .은 특수문자 이므로 . 으로
		[0-9a-zA-Z] --> 숫자또는 영문자
		([-_.]?[0-9a-zA-Z])*@ --> @ 앞에(-,_,. 이 0~1번, 그 뒤에는 숫자,영문자)이 한번 또는 여러번
		[0-9a-zA-Z] --> @ 뒤에는 숫자 또는 영문자
		[-_.]? --> - 또는 _ 또는 . 이 0번 또는 1번
		([-_.]?[0-9a-zA-Z])*. --> . 앞에(-,_,. 이 0~1번, 그 뒤에는 숫자,영문자)이 한번 또는 여러번
		[a-zA-Z]{2,3}$ --> . 뒤 마지막 문자열은 영문자가 2~3개
	 */
    var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
    var u_email = $("#emp_email").val()+"@sqisoft.com";
    if(frm.emp_email.value!=""){	//빈공백이 아닐 경우
	         if(!regEmail.test(u_email)) {
	                alert('이메일 주소가 유효하지 않습니다');
	                $("#emp_email").val("");
	                $("#emp_email").focus();
	                return false;
	            }
	}    
    $.ajax({
		type : "POST",
		url:"/checkEmail",
		async : true,
		dataType : "json",
		data:{				
			email:$("#emp_email").val(),
			name:$("#emp_name").val()
//			empemail:$("#emp").val()
			
		},
	//여기까지는 완성......................!!!!!!!!!!!!!!!!!!!!!!!!!
		success : function(data) {		
			//json으로 넘어오므로 파싱이 필요없음 data=JSON.parse(data);
	//		var html = '<table border="1">';
			var result = data.result_chkmail;
//			var empemail = document.getElementById("emp");
		
							
			if (data.result_chkmail == "OK") {
			
				var mp=1.00;
				if($("#mpm").attr("type")=="text")	
					mp=mpm.value;	
				$.ajax({
					type : "POST",
					url:"/insert.action",
					async : false,
					dataType : "json",
					data:{
						name : $("#emp_name").val(),
						company : $("#emp_company").val(),
						hire_date : $("#hire_date").val(),
						career_date :  careerdate(),
						quit_date : $("#quit_date").val(),
						position : $("#emp_position").val(),
						grade : $("#emp_grade").val(),
						phonenum1 : $("#emp_phonenum1").val(),
						phonenum2 : $("#emp_phonenum2").val(),
						phonenum3 : $("#emp_phonenum3").val(),
						division : $("#emp_form").val(),
						salary : $("#emp_salary").val(),
						team_id : $("#team").val(),
						area : area1.value +"/"+ area1_1.value,
						email : u_email,
//						etc:emp_etc.value,
						envclass : envclass.vlaue,
						skill : skill.value,
						photo : $("#emp_photo").attr("src"),
//					    skill : getVal({year :"true"}),
					    job : getJob(),
					    mpm : mp,
					    time_off : $("#time_off").val(),
					    to_start_day : $("#to_start_day").val(),
					    to_end_day : $("#to_end_day").val()
					},

					success : function() {			
						alert("저장되었습니다.")
						empSearch();
										
										
					},
					error : function(xhr) {
						alert("emp error html = " + xhr.statusText);
					}			
				});

			}
//			else if (options && result == "FAIL_E") {
//				alert("잘못된 메일 형식을 입력하였습니다")
//				$("#emp_email").val("");
//				return;
//			}
			else if (data.result_chkmail == "FAIL_D") {
				alert("중복된 메일이름이 있습니다");
				$("#emp_email").val("");
                $("#emp_email").focus();
				return;	
			}
			
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
				}			
			});
	return true;
		}
	

// 외주
if($("#out_form").prop("checked")){
	var mp=1.00;
	if($("#mpm").attr("type")=="text")	
		mp=mpm.value;	
	if(frm.name.value == ""){
		
		alert ("외주명을 입력하세요"); 
		frm.name.focus();
		return false;
		}
	
	if(frm.hire_date.value == "") {
		alert ("계약일을 입력하세요"); 
		frm.hire_date.focus();
		return false;
	}
	if(frm.career_date_Y.value == "") {
		alert ("경력(년)을 입력하세요"); 
		frm.career_date_Y.focus();	
		return false ;
	}
	if(frm.career_date_M.value == "") {
		alert ("경력(월)을 입력하세요"); 
		frm.career_date_M.focus();	
		return false ;
	}
	if(frm.quit_date.value == "") {
		alert ("만료일을 입력하세요"); 
		frm.quit_date.focus();
		return false;
	}
	if(frm.position.value =="" ){ 
		alert ("등급을 선택하세요"); 
		frm.position.focus();		
		return false ;
	}
	if(frm.emp_salary.value == ""){ 
		alert ("단가를 입력하세요"); 
		frm.emp_salary.focus();
		return false;
	}
	if(frm.team_id.value =="" ){ 
		alert ("팀을 선택하세요"); 
		frm.team_id.focus();		
		return false;
	}
	
	// 시만 선택 했을 경우
	if((frm.area.value !="") && (frm.area1_1.value =="")){ 
		alert ("거주지를 모두 선택하세요"); 
		frm.area1_1.focus();		
		return false;
	}
	
	// 구만 선택 했을 경우
	if((frm.area.value =="") && (frm.area1_1.value !="")){ 
		alert ("거주지를 모두 선택하세요"); 
		frm.area.focus();		
		return false;
	}



	$.ajax({
		type : "POST",
		url:"/checkEmail",
		async : true,
		dataType : "json",
		data:{				
			email:$("#emp_email").val(),
			name:$("#emp_name").val()
			//outemail:$("#out").val()
		},
	//여기까지는 완성......................!!!!!!!!!!!!!!!!!!!!!!!!!
		success : function(data) {		

			var result = data.result_chkmail;
					
			 var u_email = $("#emp_email");

			        // 정규식 - 이메일 유효성 검사
			        var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			 
			        if(!regEmail.test(u_email.val())) {
			        	if(u_email.val()==""){
			        		$.ajax({
								type : "POST",
								url:"/insert.action",
								async : false,
								dataType : "json",
								data:{
									
									name : $("#emp_name").val(),
									company : $("#emp_company").val(),
									hire_date : $("#hire_date").val(),
									career_date :  careerdate(),
									quit_date : $("#quit_date").val(),
									position : $("#emp_position").val(),
									grade : $("#emp_position").val(),
									phonenum1 : $("#emp_phonenum1").val(),
									phonenum2 : $("#emp_phonenum2").val(),
									phonenum3 : $("#emp_phonenum3").val(),
									division : $("#out_form").val(),
									salary : $("#emp_salary").val(),
									team_id : $("#team").val(),
									area : area1.value +"/"+ area1_1.value,
									email : emp_email.value,
//									etc:emp_etc.value,
									envclass : envclass.vlaue,
									skill : skill.value,
									photo : $("#emp_photo").attr("src"),
//								    skill : getVal({year :"true"}),
								    job : getJob(),
								    mpm : mp
								},

								success : function() {		
									 alert('저장되었습니다.');
									empSearch();
								
								},
								error : function(xhr) {
									alert("out error html = " + xhr.statusText);
								}			
							});
			        		
			        	}else{
			                alert('이메일 주소가 유효하지 않습니다');
			                $("#emp_email").val("");
			                u_email.focus();
			                return false;
			        	}
			            }
			      else
			    	  //if (result2 == "OK")
			    	  {
			            	$.ajax({
								type : "POST",
								url:"/insert.action",
								async : false,
								dataType : "json",
								data:{
									 
									
									name : $("#emp_name").val(),
									company :  $("#emp_company").val(),
									hire_date : $("#hire_date").val(),
									career_date :  careerdate(),
									quit_date : $("#quit_date").val(),
									position : $("#emp_position").val(),
									grade : $("#emp_position").val(),
									phonenum1 : $("#emp_phonenum1").val(),
									phonenum2 : $("#emp_phonenum2").val(),
									phonenum3 : $("#emp_phonenum3").val(),
									division : $("#out_form").val(),
									salary : $("#emp_salary").val(),
									team_id : $("#team").val(),
									area : area1.value +"/"+ area1_1.value,
									email : emp_email.value,
//									etc:emp_etc.value,
									envclass : envclass.vlaue,
									skill : skill.value,
									photo : $("#emp_photo").attr("src"),
//								    skill : getVal({year :"true"}),
								    job : getJob(),
								    mpm : mp
								
									 
								},

								success : function() {		
									 alert('저장되었습니다.');
									empSearch();
								
								},
								error : function(xhr) {
									alert("out error html = " + xhr.statusText);
								}			
							});
			            	  

			            }

		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
											}			
						});
	
	
				}

		}

function namekeycheck(mkey) // 키코드값을 매개변수로 받는다
	{	
		if ((mkey > 90 || mkey < 97) || mkey > 122) // 키값이 영자나 숫자, 특수기호가 입력되면
													// 경고문출력
		{
			alert("한글만 입력가능합니다.");
			event.returnValue = false; // 리턴값을 false로 주어 문자가 입력되는걸 방지
		
		}

	}

function salaykeycheck(){ // 키코드값을 매개변수로 받는다
		var code = window.event.keyCode;
		if((code >=48 && code <=57) || (code >=96 && code <=105) || code == 110 || code == 190 || code ==8 || code == 9 || code ==13 ||code ==46) {
			window.event.returnValue = true;
			return;
		}
		
		alert ("숫자만 입력 가능합니다.");
		window.event.returnValue =false;
}

function empPictureUpload(event){
	var formData = new FormData();
	formData.append("filefile",$("#upload")[0].files[0]);

	$.ajax({
		type : "POST",
		url:"/empPictureUpload.action",
		data:formData,
		processData:false,
		contentType:false,
		success : function(filepath) {		
			$("#emp_photo").attr("src",filepath);
		}
	});
}

function tock(){
	if($("#time_off").checked != true){
		$("#to_start_day").val ("");
		$("#to_end_day").val("");
	}
	else{
		
		
	}
	
}

	