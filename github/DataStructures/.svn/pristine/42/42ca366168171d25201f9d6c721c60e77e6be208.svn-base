$(document).ready(function(){
	$("#emp_salary").setSal('E');
	$("#teamsearch").setSearchTeamdiv({hr:true,all:true});
	$("#team_id").setTeamdiv({hr:true, opt:true});
//	$('#skill_div').setSkilldiv({year:"true"});
	$('#job_div').setJobdiv({});
	$('#searchSkill').setSearchSkilldiv();
	$("#area").setAreadiv({})
	$('#searcharea').setSearchAreadiv({all:true});
//
	getSkillOptions($("#searchskill2"), "2", "",{});	
	var addhtml='<option value="">선택하세요';
	addhtml+='<option value="5사원">사원</option><option value="4대리">대리</option><option value="3과장">과장</option><option value="2차장">차장</option>';
	addhtml+='<option value="1부장">부장</option><option value="0임원">임원</option>'
		$("#emp_position").html(addhtml)
		
		$.ajax({
		type : "POST",
		url:"/empSearch.action",
		async : true,
		dataType : "json",
		data:{				
			name:searchname.value,
			division:'al',
			team_id:'al',
			position:searchposition.value,
			hire_date:searchyear.value,
			area1:'',
			area2:'',
			skillcd:'',
			groupcd:'',
			jobcd:'',
			// 15.04.08 skillcode 참조하던 skill아닌 전문기술(employee) 단독검색
			skill :''/*,
			
			envclass_c:'',
			envclass_w:'',
			envclass_m:''
			*/
		},

		success : function(search) {		
			var html = '<table width="580px" cellspacing="1" cellpadding="0" border="0" class="hoverTable"  style="text-align: center; " >'; 
			console.log(search)
			$.each(search, function (index, item) {
				  var id="140"+index;
//				   html+="<input type='hidden' id=" +'id'+ item[i].id+" value='"+item[i].id+ "'/>";
				   html += '<tr  style="cursor:pointer" id="'+id+'" onclick="getEmpDetail('+id+')">';
				   html += '<td align="center" style="border-top:0; width:99px">'+item.name+'</td>';
				   html += '<td style="border-top:0; width: 112px" align="center">'+item.team_name+'</td>';
				   html += '<td style="border-top:0; width: 56px" align="center">'+item.position+'</td>';
				   if(item.e_area==null){
					   item.e_area= '';
				   }
				   html += '<td style="border-top:0; width: 122px" align="center">'+item.hire_date+'</td>';
				   if(item.quit_date==null){
					   html += '<td style="border-top:0; width: 122px" align="center">-</td>';
				   }else{
					   html += '<td style="border-top:0; width: 122px" align="center">'+item.quit_date+'</td>';
				   }
				
				   html += '<td style="border-top:0; width: 55px" align="center">'+item.division+'</td>';
				   html += '</tr>';
				
				   
			});
			html += '</table>';
			   $("#search_result").html(html);	
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}			
	});


	$("#searchteam").change(function(){empSearch()});
	$("#searchdiv").change(function(){empSearch()});
	$("#searchposition").change(function(){empSearch()});
	$("#skill100").change(function(){empSearch()});
	$("#skill100_1").change(function(){empSearch()});
	$("#searchyear").change(function(){empSearch()});
	$("#searchname").keyup(function(){empSearch()});
//	$("#searcharea").change(function(){empSearch()});
	$("#area100").change(function(){empSearch()});
	$("#area100_1").change(function(){empSearch()});
	$("#searchskill2").change(function(){empSearch()});
	$('#cancel').click(function(){empSearch()});
	$('#envclass_c').click(function(){empSearch()});
	$('#envclass_w').click(function(){empSearch()});
	$('#envclass_m').click(function(){empSearch()});
	// 15.04.08 skillcode 참조하던 skill아닌 전문기술(employee) 단독검색
	$('#searchskill').click(function(){empSearch()});
	
	$('#update_btn').click(function(){
		
		var envclass="";
		
		$(":checkbox[name='envclass']:checked").each(function(){
			
			envclass += $(this).val(); 
			});
		
		
		
			var name= document.getElementById("delete_btn");
			var del;
			if(name.disabled==true){
				//입력
				del = confirm('저장 하시겠습니까');
				if(del==true){
					blank_ck();
					
							}				
				//입력ajax
				
								}
			
			else {
				del = confirm('수정 하시겠습니까');
			//	var update=blank_ck();
						if(del==false){
							}
							else
							{
				//수정 ajax
									var name=$("#emp_name").val(); 
									var emp_radio = document.getElementById("emp_form");
									var out_radio = document.getElementById("out_form");
									var mp="1.00";
									var cu="2014-01-01";
									if($("#mpm").attr("type")=="text")	
										mp=mpm.value;
									if($("#cu_day").attr("type")=="text")
										cu=$("#emp_salary").parents().find("input").eq(2).val()
				if($("#emp_form").prop("checked")){
					
					var f = document.frm; 
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
					
					if(frm.emp_email.value!=""){//빈공백이 아닐 경우
						
						 var u_email = $("#emp_email").val()+"@sqisoft.com";
					        // 정규식 - 이메일 유효성 검사
					        var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
					 
					        if(!regEmail.test(u_email)) {
					                alert('이메일 주소가 유효하지 않습니다');
					                $("#emp_email").val("");
					                $("#emp_email").focus();
					                return false;
					            }
				
					}      

					if (f.time_off.checked!=true) { 
						time_off.value ="0";

					 }else {
						time_off.value="1";
						
					}
					if(time_off.value=="1"&&( to_start_day.value=="" ||to_end_day.value=="")){
						alert("휴직기간을 입력하세요")
						return;
						
					}
					if(time_off.value=="0"&&( to_start_day.value !="" || to_end_day.value!="")){
						alert("휴직여부를 체크하세요")
						return;
						
					}
					
					
					var chName;
					if($("#realName").text()==$("#emp_name").val())chName=$("#emp_name").val();
					else chName=$("#realName").text();
					//alert(chName+" , "+$("#emp_name").val());
					 $.ajax({
							type : "POST",
							url:"/checkEmail",
							async : true,
							dataType : "json",
							data:{				
								email:$("#emp_email").val(),
								name:chName
//								empemail:$("#emp").val()
								
							},
						//여기까지는 완성......................!!!!!!!!!!!!!!!!!!!!!!!!!
							success : function(data) {
								
								if (data.result_chkmail=="OK") {
									$.ajax({
										type : "POST",
										url:"/empUpdate",
										async : false,
										dataType : "json",
										data:{
										    name : $("#emp_name").val(),
//										    h_name : $("#h_name").val(),
										    h_name : $("#realName").text(),
										    company: $("#emp_company").val(),
											hire_date : $("#hire_date").val(),
											career_date :  careerdate(),
											quit_date : $("#quit_date").val(),
											position : $("#emp_position").val(),
											grade : $("#emp_grade").val(),
											phonenum1 : $("#emp_phonenum1").val(),
											phonenum2 : $("#emp_phonenum2").val(),
											phonenum3 : $("#emp_phonenum3").val(),
											division : $("#emp_form").val(),
											area : area1.value +"/"+ area1_1.value,
											team_id : $("#team").val(),
										//	area: getAreaVal(),
											salary : $("#emp_salary").val(),
											email : u_email,
//											etc : emp_etc.value,
											envclass : envclass ,
											skill : $("#skill").val(),
											photo : $("#emp_photo").attr("src"),
//											skill : getVal({year:"true"}),
											job : getJob(),
											time_off : $("#time_off").val(),
											to_start_day : $("#to_start_day").val(),
											to_end_day : $("#to_end_day").val(),
											//etc:etc.value
											
										},

										success : function() {			
											alert("수정되었습니다.")
											empSearch();
											
												
										},
										
										error : function(xhr) {
											alert("error html = " + xhr.statusText);
										}
										
									});
								}
								
								else if ( data.result_chkmail == "FAIL_D") {
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
								
				
				}

				else if($("#out_form").prop("checked")){	
					if(cu!=$("#emp_salary").parents().find("input").eq(2).val())
						cu=null;
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

					
					
		
		if(frm.emp_email.value!=""){//빈공백이 아닐 경우
			
			 var u_email = $("#emp_email");
		        // 정규식 - 이메일 유효성 검사
		        var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		 
		        if(!regEmail.test(u_email.val())) {
		                alert('이메일 주소가 유효하지 않습니다');
		                $("#emp_email").val("");
		                u_email.focus();
		                return false;
		            }
		      else
		    	  //if (result2 == "OK")
		    	  {
		
	$.ajax({
						
						type : "POST",
						url:"/empUpdate",
						async : false,
						dataType : "json",
						data:{
							name : $("#emp_name").val(),
							h_name : $("#realName").text(),
//							h_name : $("#h_name").val(),
							company: $("#emp_company").val(),
							hire_date : $("#hire_date").val(),
							career_date :  careerdate(),
							quit_date : $("#quit_date").val(),
							position : $("#emp_position").val(),
							grade : $("#emp_position").val(),
							phonenum1 : $("#emp_phonenum1").val(),
							phonenum2 : $("#emp_phonenum2").val(),
							phonenum3 : $("#emp_phonenum3").val(),
							division : $("#out_form").val(),
							area : area1.value +"/"+ area1_1.value,
							team_id : $("#team").val(),
							salary : $("#emp_salary").val(),
							email : $("#emp_email").val(),
//							etc : emp_etc.value,
							envclass : envclass,
							skill : $("#skill").val(),
							photo : $("#emp_photo").attr("src"),
//							skill : getVal({year:"true"}),
							job : getJob(),
							mpm : mp,
							cu_day: cu
						
						},

						success : function() {			
							alert("수정되었습니다.")
							empSearch();
						},
						
						error : function(xhr) {
							alert("error html = " + xhr.statusText);
						}			
					});
		    	  }
			
			
		}else{	//빈공백일 경우
			
			$.ajax({
				
				type : "POST",
				url:"/empUpdate",
				async : false,
				dataType : "json",
				data:{
					name : $("#emp_name").val(),
					h_name : $("#realName").text(),
//					h_name : $("#h_name").val(),
					company: $("#emp_company").val(),
					hire_date : $("#hire_date").val(),
					career_date :  careerdate(),
					quit_date : $("#quit_date").val(),
					position : $("#emp_position").val(),
					grade : $("#emp_position").val(),
					phonenum1 : $("#emp_phonenum1").val(),
					phonenum2 : $("#emp_phonenum2").val(),
					phonenum3 : $("#emp_phonenum3").val(),
					division : $("#out_form").val(),
					area : area1.value +"/"+ area1_1.value,
					team_id : $("#team").val(),
					salary : $("#emp_salary").val(),
					email : $("#emp_email").val(),
//					etc : emp_etc.value,
					envclass : envclass,
					skill : $("#skill").val(),
					photo : $("#emp_photo").attr("src"),
//					skill : getVal({year:"true"}),
					job : getJob(),
					mpm : mp,
					cu_day: cu
					
					//etc:etc.value
					
				},

				success : function() {			
					alert("수정되었습니다.")
					empSearch();
				},
				
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}			
			});
			
			
		}
					
			}
		}
			}		
			
	});	
	
	

	
	
	$('#delete_btn').click(function(){
	var del;
	del = confirm('삭제 하시겠습니까');
	if(del == true){
	$('#skill_div').setSkilldiv({year:"true"});
		
		$.ajax({
			type : "POST",
			url:"/empDelete",
			async : false,
			dataType : "json",
			data:{
				name:$("#emp_name").val(),
			},

			success : function() {			
				empSearch();
						
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
		   $("#team_id").setTeamdiv({hr:true, opt:true})	
			var emp_radio = document.getElementById("emp_form");
			var out_radio = document.getElementById("out_form");
			
			if($("#emp_form").prop("checked")){
				
				emp_radio.disabled=false;
				out_radio.disabled=false;
				emp_radio.checked=true;
				$("#hire_title").text("입사일 ");
				$("#quit_title").text("퇴사일");
				$("#position_title").text("직 급 ");
				$("#email_title").text("E-mail * ");
				emp_grade.hidden=false;
				$("#mail_form").text("@sqisoft.com");
			/*	var out_radio = document.getElementById("out_form");
				out_radio.disabled=false;	*/
				


				var addhtml='<option value="" selected>선택하세요';
				addhtml+='<option value="5사원">사원</option><option value="4대리">대리</option><option value="3과장">과장</option><option value="2차장">차장</option>';
				addhtml+='<option value="1부장">부장</option><option value="0임원">임원</option>'
				$("#emp_position").html(addhtml);
				
				var addhtml='<option value="" selected>선택하세요';
				addhtml+='<option value="9초급">초급</option><option value="8중급">중급</option><option value="7고급">고급</option><option value="6특급">특급</option>';
				$("#emp_grade").html(addhtml);
				$("#emp_salary").setSal('E');
				
								
				var emp_name = document.getElementById("emp_name");
				emp_name.value ="";
				emp_name.disabled=false;
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
				
				
				$('#skill_div').setSkilldiv({year:"true"});
				$("#team_id").setTeamdiv({hr:true, opt:true})
				 $('#area').setAreadiv({}); 
				
				out_radio.checked=true;
			 // emp_radio.checked=true;
				emp_grade.hidden=true;
				
				$("emp_salary").setSal('O');
				var addhtml='<option value="">선택하세요';
				addhtml+='<option value="B턴키">턴키</option><option value="6특급">특급</option><option value="7고급">고급</option><option value="8중급">중급</option>';
				addhtml+='<option value="9초급">초급</option><option value="A기능사">기능사</option>'
		    		$("#emp_position").html(addhtml); 
				
			
				
				var out_radio = document.getElementById("out_form");
				out_radio.disabled=false;	
				var emp_radio = document.getElementById("emp_form");
				emp_radio.disabled=false;	
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
		}

	});
	
	$.fn.setSal=function(div){
		
		if(div=='O')
		{
			var salhtml='<input type="text" id="emp_salary" style="width:20%; height:100%;" onKeyup="setCu()" onkeydown="salaykeycheck()">';
			$("#emp_salary").parents("td").html(salhtml);

		}
		
		else
		{
			var salhtml='<select style="width:100%; height:100%;" id="emp_salary" name="emp_salary">';
			for(var i=2;i<=50;i+=2)
			{
				salhtml+='<option value="'+i+'">'+i+'년이하';
			}
			salhtml+='</select>';
			$("#emp_salary").parents("td").html(salhtml);
		}
			
	}
	
	$('#cancel').click(function(){
	/*	
		var envclass_c="";
		
		$(":checkbox[name='envclass']:checked").each(function(){
			
			envclass_c += $(this).val(); 
			});
		*/
		
		var name = document.getElementById("searchteam");
		name.value="al";	  
		var name = document.getElementById("searchdiv");
		name.value="al";	 
		var name = document.getElementById("searchyear");
		name.value="";
		var name = document.getElementById("searchposition");
		name.value="";
		var name = document.getElementById("searchname");
		name.value="";
		/*var name = document.getElementById("searcharea");
		name.value="";*/
		var name = document.getElementById("area100");
		name.value="";
		var name = document.getElementById("area100_1");
		name.value="";
		/*var name = document.getElementById("skill100");
		name.value="";
		var name = document.getElementById("skill100_1");
		name.value="";*/
		var name = document.getElementById("searchskill2");
		name.value="";
		// 15.04.08 skillcode 참조하던 skill아닌 전문기술(employee) 단독검색
		var name = document.getElementById("searchskill");
		name.value="";
		var name = document.getElementById("envclass_c");
		name.value="";
		var name = document.getElementById("envclass_w");
		name.value="";
		var name = document.getElementById("envclass_m");
		name.value="";
		
		$(":checkbox[name='envclass_c']:checkbox").each(function() {
		    $(this).attr("checked", false);
		});

		$(":checkbox[name='envclass_w']:checkbox").each(function() {
		    $(this).attr("checked", false);
		});

		$(":checkbox[name='envclass_m']:checkbox").each(function() {
		    $(this).attr("checked", false);
		});


	//	$('#team_id').setTeamdiv({hr:true,size:true,opt:true});
		
		$.ajax({
			type : "POST",
			url:"/empSearch.action",
			async : true,
			dataType : "json",
			data:{				
				name:searchname.value,
				division:'al',
				team_id:'al',
				position:searchposition.value,
				hire_date:searchyear.value,
				area1:'',
				area2:'',
				skillcd:'',
				groupcd:'',
				jobcd:'',
				// 15.04.08 skillcode 참조하던 skill아닌 전문기술(employee) 단독검색
				skill:'' /* ,
				envclass_c:'',
				envclass_w:'',
				envclass_m:''
				*/
			},

			success : function(search) {		
				var html = '<table width="580px" cellspacing="1" cellpadding="0" border="0" class="hoverTable"  style="text-align: center; " >'; 
				console.log(search)
				$.each(search, function (index, item) {
					  var id="140"+index;
//					   html+="<input type='hidden' id=" +'id'+ item[i].id+" value='"+item[i].id+ "'/>";
					   html += '<tr  style="cursor:pointer" id="'+id+'" onclick="getEmpDetail('+id+')">';
					   html += '<td align="center" style="border-top:0; width:99px">'+item.name+'</td>';
					   html += '<td style="border-top:0; width: 112px" align="center">'+item.team_name+'</td>';
					   html += '<td style="border-top:0; width: 56px" align="center">'+item.position+'</td>';
					   if(item.e_area==null){
						   item.e_area= '';
					   }
					   html += '<td style="border-top:0; width: 122px" align="center">'+item.hire_date+'</td>';
					   if(item.quit_date==null){
						   html += '<td style="border-top:0; width: 122px" align="center">-</td>';
					   }else{
						   html += '<td style="border-top:0; width: 122px" align="center">'+item.quit_date+'</td>';
					   }
					
					   html += '<td style="border-top:0; width: 55px" align="center">'+item.division+'</td>';
					   html += '</tr>';
					
					   
				});
				html += '</table>';
				   $("#search_result").html(html);	
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
	});
	
});

function careerdate(){
	var date=new Date();
	var y=Number(date.getFullYear())-Number(career_date_Y.value);
	var m=Number(date.getMonth()+1)-Number(career_date_M.value);
	if(m<0)
	{
		y--;
		m=12+m;
	}
	if(m<10)
	{
		return y+"-0"+m+"-01";
	}
	else
		return y+"-"+m+"-01";
}

function getSal(){
	var y=Number(career_date_Y.value);
	var m=Number(career_date_M.value);
	if(y%2==1)
	{
		return y+1;
	}
	else
	{
		if(y==0)
		{
			return y+2;
		}
		else if(m==0)
		{
			return y;
		}
		else
			return y+2;
	}
	
}
function empSearch(){
	var year=searchyear.value+"-01-01";
	
	var groupcd="";
	var skillcd="";
	var jobcd="";
	/*
	if($('#skill100').val()!=null)
	{	
		groupcd=($('#skill100').val()).split("/")[1];
	}
	if($('#skill100_1').val()!=null)
	{ 
		skillcd=($('#skill100_1').val()).split("/")[2];
	}
	*/
	if($("#searchskill2").val()!=null)
		jobcd=searchskill2.value.split("/")[1];
	if(searchyear.value=='')
		year="1900-01-01";
	console.log(searchteam.value+year+searchyear.value)
	var envclass="";
	$("#searchtable input:checked").each(function(k,v){
		envclass+=$(v).val()
			});
	
	$.ajax({
		type : "POST",
		url:"/empSearch.action",
		async : true,
		dataType : "json",
		data:{				
			name:searchname.value,
			division:searchdiv.value,
			team_id:searchteam.value,
			position:searchposition.value,
			hire_date:searchyear.value,
			area1:area100.value ,
			area2:area100_1.value,
			skillcd:skillcd,
			groupcd:groupcd,
			jobcd :jobcd,
			// 15.04.08 skillcode 참조하던 skill아닌 전문기술(employee) 단독검색
			skill : searchskill.value,
			envclass : envclass
		},

		success : function(search) {		
	
			var html = '<table width="580px" cellspacing="1" cellpadding="0" border="0" class="hoverTable"  style="text-align: center; " >'; 
			$.each(search, function (index, item) {
				  var id="140"+index;
//				   html+="<input type='hidden' id=" +'id'+ item[i].id+" value='"+item[i].id+ "'/>";
				   html += '<tr  style="cursor:pointer" id="'+id+'" onclick="getEmpDetail('+id+')">';
				   html += '<td align="center" style="border-top:0; width:99px">'+item.name+'</td>';
				   html += '<td style="border-top:0; width: 112px" align="center">'+item.team_name+'</td>';
				   html += '<td style="border-top:0; width: 56px" align="center">'+item.position+'</td>';
				   if(item.area==null){
					   item.area= '';
				   }
				   html += '<td style="border-top:0; width: 122px" align="center">'+item.hire_date+'</td>';
				   if(item.quit_date==null){
					   html += '<td style="border-top:0; width: 122px" align="center">-</td>';
				   }else{
					   html += '<td style="border-top:0; width: 122px" align="center">'+item.quit_date+'</td>';
				   }
				   html += '<td style="border-top:0; width: 55px" align="center">'+item.division+'</td>';
				   html += '</tr>';
				
				   
			});
			html += '</table>';
			   $("#search_result").html(html);	
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}			
	});
}



 