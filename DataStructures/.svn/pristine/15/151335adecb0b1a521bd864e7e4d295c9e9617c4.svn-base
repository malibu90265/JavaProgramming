
//file등록 버튼 눌렀을시 자동으로 image 삽입
function img_input(){
	
	var input = document.getElementById("upload");
	var fReader = new FileReader();
	fReader.readAsDataURL(input.files[0]);
	fReader.onloadend = function(event){
	var img = document.getElementById("emp_photo");

	img.src = event.target.result;
	}
}

function change(val){
	
	var f = document.frm;
		f.emp_name.value="";
		f.emp_company.value="";
		f.emp_photo.src = "resources/images/emp_nophoto.jpg";
	    f.hire_date.value="";
	    f.career_date_Y.value="";
	    f.career_date_M.value="";
	    f.quit_date.value="";
        f.emp_position.value="";
	    f.team_id.value="";
	    $('#area').setAreadiv();
	  //f.emp_salary.value="";
	    f.emp_email.value="";
//	    f.emp_etc.value="";
	   f.emp_phonenum1.value="010";
	   f.emp_phonenum2.value="";
	   f.emp_phonenum3.value="";
	   f.envclass.value="";
	   f.skill.value="";
	 
	    
	if(val == 'E'){
		//직원 입력 폼에 맞게 입력명 변경
			$("#emp_phonenum1").val( "010");
    		$("#hire_title").text("입사일 *");
    		$("#quit_title").text("퇴사일");
    		$("#position_title").text("직 급 * ");
    		$("#area_title").text("거 주 지 * ");
    		$("#email_title").text("E-mail * ");
    		$("#mail_form").text("@sqisoft.com");
    		f.emp_company.value="SQI소프트(주)";
    		f.emp_company.disabled=true;
    		f.emp_grade.hidden=false;
    
    		
    	
    		
    		//외주 radio button 활성화
    		var emp_radio = document.getElementById("emp_form");
    		emp_radio.checked = true;
    
   		//직원 직급 표현 할 부분
    		var addhtml='<option value="">선택하세요';
    		addhtml+='<option value="5사원">사원</option><option value="4대리">대리</option><option value="3과장">과장</option><option value="2차장">차장</option>';
			addhtml+='<option value="1부장">부장</option><option value="0임원">임원</option>'
    			$("#emp_position").html(addhtml);
    			$("#emp_salary").setSal('E');
    			
    			 
    			//휴직일처리
    		if( $('#emptable tr:eq(4)').children().eq(0).attr("id") !="to"){
     	var html='<tr id = "to">';
        html += '<th colspan="2" align="right" id=timeoff>휴&nbsp;직&nbsp;일&nbsp;&nbsp;</th>';
        html += '<td  align="left"><input type = "checkbox" id = time_off value="0" onclick = "tock()">휴직';
        html +='&nbsp;';
        html +='<input type="text" id=to_start_day style="width: 38%; height: 100%" name="to_end_day"> ~ ';
        html +='<input type="text" id=to_end_day style="width: 38%; height: 100%" name="to_end_day"></td>'
    	        html +='</tr>';
    	        $("#emptable tr:eq(4)").before(html);
	}
      				
    		
    	        
		    //calendar();
	}else if(val == 'O'){
		  $('#emptable tr:eq(4)').remove(); 
			$("#emp_phonenum1").val( "010");
    		$("#hire_title").text("계약일 *");
    		$("#quit_title").text("만료일 *");
    		$("#position_title").text("등 급 *");
    		$("#area_title").text("거 주 지");
    		$("#email_title").text("E-mail ");
    		$("#mail_form").text(" ");
    		f.emp_company.value="";
    		f.emp_company.disabled=false;
    		f.emp_grade.hidden=true;
    		var html='';
    		
       		html+=	'<tr>'
    		 html+=	'<th id=salary_title>단 가 *'
    		 html+=	'<td style="width:471px" colspan="2" align="left">'
    		 html+=	 '<input style="width: 100%; height: 100%"  type="text" id=emp_salary  name=salary  onkeydown="salaykeycheck()" />'
    		html+=	'</tr>';
    		
       		
  		
    		var out_radio = document.getElementById("out_form");
    		out_radio.checked = true;
    		
    		
    		$("emp_salary").setSal('O');
//    		$("emp_salary").setSal('O').css("width","100%");
    		
    		
   		//외주 직급 표현 할 부분\\
    		var addhtml='<option value="">선택하세요';
    		addhtml+='<option value="B턴키">턴키</option><option value="6특급">특급</option><option value="7고급">고급</option><option value="8중급">중급</option>';
			addhtml+='<option value="9초급">초급</option><option value="A기능사">기능사</option>'
    		$("#emp_position").html(addhtml); 
			
			
		

			
	}

}

//입력폼 초기화 함수
$(document).ready(function(){
	$("#career_date_Y").keyup(function(){
		console.log($("#emp_form").prop("checked")?"직원":"외주")
		if($("#emp_form").prop("checked"))
			emp_salary.value=getSal();
	});
	$("#career_date_M").keyup(function(){
		console.log($("#emp_form").prop("checked")?"직원":"외주")
		if($("#emp_form").prop("checked"))
			emp_salary.value=getSal();
	});
$('#rst_btn').click(function(){
	
	$("#team_id").setTeamdiv({hr:true, opt:true})	
	var emp_radio = document.getElementById("emp_form");
	var out_radio = document.getElementById("out_form");
	
	if($("#emp_form").prop("checked")){
		
		emp_radio.disabled=false;
		out_radio.disabled=false;
		emp_radio.checked=true;
		
		$("#hire_title").text("입사일 *");
		$("#quit_title").text("퇴사일");
		$("#position_title").text("직 급 *");
		$("#email_title").text("E-mail * ");
		emp_grade.hidden=false;
		$("#mail_form").text("@sqisoft.com");

		
		

		var addhtml='<option value="" selected>선택하세요';
		addhtml+='<option value="5사원">사원</option><option value="4대리">대리</option><option value="3과장">과장</option><option value="2차장">차장</option>';
		addhtml+='<option value="1부장">부장</option><option value="0임원">임원</option>'
		$("#emp_position").html(addhtml);
		
		var addhtml='<option value="" selected>선택하세요';
		addhtml+='<option value="9초급">초급</option><option value="8중급">중급</option><option value="7고급">고급</option><option value="6특급">특급</option>';
		$("#emp_grade").html(addhtml);
		$("#emp_salary").setSal('E');

		//휴직일처리
			if( $('#emptable tr:eq(5)').children().eq(0).attr("id") =="to"){
			 			$('#emptable tr:eq(5)').remove() }
			
//			if($('#emptable tr:eq(4)').children().eq(0).attr("id")=="to"){
//			 	var html='<tr id = "to">';
//    	        html += '<th style="height: 30px;" id=time_off>휴직일</th>';
//    	        html += '<td colspan="2" align="left"><input type = "checkbox" id = time_off value="0" style="height: 50%">휴직';
//    	        html +='&nbsp;&nbsp;';
//    	        html +='<input type="text" id=to_start_day style="width: 170px; height: 70%" name="to_end_day"> ~ ';
//    	        html +='<input type="text" id=to_end_day style="width: 170px; height: 70%" name="to_end_day"></td>'
//    	        html +='</tr>';
//    	        $("#emptable tr:eq(4)").before(html);
//				
//			}
		
		var name = document.getElementById("emp_name");
		name.value ="";
		name.disabled=false;
		var emp_company = document.getElementById("emp_company");
		emp_company.value ="SQI소프트(주)";
		emp_company.disabled=true;
		var emp_photo = document.getElementById("emp_photo");
		$(emp_photo).attr("src", "resources/images/emp_nophoto.jpg");
		emp_photo.disabled=false;
		var upload = document.getElementById("upload");
		upload.value ="";
		upload.disabled=false;
		var emp_hire_date = document.getElementById("hire_date");
		emp_hire_date.value="";
		emp_hire_date.disabled=false;
		var emp_carrer_date = document.getElementById("career_date_Y");
		emp_carrer_date.value="";
		emp_carrer_date.disabled=false;
		var emp_carrer_date = document.getElementById("career_date_M");
		emp_carrer_date.value="";
		emp_carrer_date.disabled=false;
		var emp_retire_date = document.getElementById("quit_date");
		emp_retire_date.value="";
		emp_retire_date.disabled=false;
		var emp_position = document.getElementById("emp_position");
		 emp_position.value="";	
		 emp_position.disabled=false;
		 
		 var emp_phonenum1 = document.getElementById("emp_phonenum1");
		 emp_phonenum1.value="010";	
		 emp_phonenum1.disabled=false;
		 var emp_phonenum2 = document.getElementById("emp_phonenum2");
		 emp_phonenum2.value="";	
		 emp_phonenum2.disabled=false;
		 var emp_phonenum3 = document.getElementById("emp_phonenum3");
		 emp_phonenum3.value="";	
		 emp_phonenum3.disabled=false;
		 
	
			$('#skill_div').setSkilldiv({year:"true"});
			$('#area').setAreadiv({});
			
			
		var emp_email = document.getElementById("emp_email");
		emp_email.value="";	
		emp_email.disabled=false;

		var envclass = document.getElementById("envclass");
		envclass.value="";
		envclass.disabled=false;
		
		var skill = document.getElementById("skill");
		skill.value="";
		skill.disabled=false;

		var time_off = document.getElementById("time_off");
		document.getElementById("time_off").checked=false;
		
		var to_start_day = document.getElementById("to_start_day");
		to_start_day.value="";
		
		var to_end_day = document.getElementById("to_end_day");
		to_end_day.value="";
		
		var delete_btn = document.getElementById("delete_btn");
		delete_btn.disabled=true;
		delete_btn._visible=false;
		


	}
	
	if($("#out_form").prop("checked")){
		
		  if($('#emptable tr:eq(4)').children().eq(0).attr("id") =="to"){
		 $('#emptable tr:eq(4)').remove()
		  }
		$('#skill_div').setSkilldiv({year:"true"});
		$("#team_id").setTeamdiv({hr:true, opt:true})
		$('#area').setAreadiv({}); 
		

		 
		emp_radio.disabled=false;
		out_radio.disabled=false;
		//emp_radio.checked=true;
		emp_grade.hidden=true;

		$("emp_salary").setSal('O');
		var addhtml='<option value="">선택하세요';
		addhtml+='<option value="B턴키">턴키</option><option value="6특급">특급</option><option value="7고급">고급</option><option value="8중급">중급</option>';
		addhtml+='<option value="9초급">초급</option><option value="A기능사">기능사</option>'
    		$("#emp_position").html(addhtml); 
			//$("#emp_salary").parents("td").html(salhtml);
		
		var out_radio = document.getElementById("out_form");
		out_radio.disabled=false;	
		var emp_name = document.getElementById("emp_name");
		emp_name.value ="";
		emp_name.disabled=false;
		var emp_company = document.getElementById("emp_company");
		emp_company.value ="";
		emp_company.disabled=false;
		var emp_photo = document.getElementById("emp_photo");
		$(emp_photo).attr("src", "resources/images/emp_nophoto.jpg");
		emp_photo.disabled=false;
		var upload = document.getElementById("upload");
		upload.value ="";
		upload.disabled=false;
		var emp_hire_date = document.getElementById("hire_date");
		emp_hire_date.value="";
		emp_hire_date.disabled=false;
		var emp_carrer_date = document.getElementById("career_date_Y");
		emp_carrer_date.value="";
		emp_carrer_date.disabled=false;
		var emp_carrer_date = document.getElementById("career_date_M");
		emp_carrer_date.value="";
		emp_carrer_date.disabled=false;
		var emp_retire_date = document.getElementById("quit_date");
		emp_retire_date.value="";
		emp_retire_date.disabled=false;
		var emp_position = document.getElementById("emp_position");
		 emp_position.value="";	
		 emp_position.disabled=false;
		 setMpm();
		 var emp_phonenum1 = document.getElementById("emp_phonenum1");
		 emp_phonenum1.value="010";	
		 emp_phonenum1.disabled=false;
		 var emp_phonenum2 = document.getElementById("emp_phonenum2");
		 emp_phonenum2.value="";	
		 emp_phonenum2.disabled=false;
		 var emp_phonenum3 = document.getElementById("emp_phonenum3");
		 emp_phonenum3.value="";	
		 emp_phonenum3.disabled=false;
		 
		var team_id= document.getElementById("team_id");
		team_id.value="";
		team_id.disabled=false;

		
		var emp_email = document.getElementById("emp_email");
		emp_email.value="";	
		emp_email.disabled=false;

		var envclass = document.getElementById("envclass");
		envclass.value="";
		envclass.disabled=false;
		
		var skill = document.getElementById("skill");
		skill.value="";
		skill.disabled=false;

		var delete_btn = document.getElementById("delete_btn");
		delete_btn.disabled=true;
		delete_btn._visible=false;
			}
	
	});

})


$.fn.setSal=function(div){
	
	if(div=='O')
	{
		var salhtml='<input type="text" id="emp_salary" style="width: 20%; height:100%;" onKeyup="setCu()" onkeydown="salaykeycheck()">';
		$("#emp_salary").parents("td").html(salhtml);

	}
	else
	{
		var salhtml='<select style="width: 100%; height:100%;" id="emp_salary" name="emp_salary" >';
		for(var i=2;i<=50;i+=2)
		{
			salhtml+='<option value="'+i+'">'+i+'년이하';
		}
		salhtml+='</select>';
		$("#emp_salary").parents("td").html(salhtml);
	}
	
		
}