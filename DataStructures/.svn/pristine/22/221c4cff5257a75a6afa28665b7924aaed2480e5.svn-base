function getEmpDetail(e){

$(e.currentTarget).attr("id");

var elem = document.getElementById(e);

var name = elem.children[0].innerHTML;

	$('#skill_div').setSkilldiv({year:"true"});
	
	$(":checkbox[name='envclass']:checkbox").each(function() {
	    $(this).attr("checked", false);
	});
	
	$('#job_div').setJobdiv({});
	

$.ajax({
	type : "POST",
	url:"/emp_DetailList",
	async : true,
	dataType : "json",
	data:{				
		name:name
	    
	},

	success : function(emp_detail) {
		
		
		var emp_name =emp_detail.emp_detail.name;
		var company = emp_detail.emp_detail.company;
		var team_id= emp_detail.emp_detail.team_id;
	    var area = emp_detail.emp_detail.area;
		var salary = emp_detail.emp_detail.salary;
		var state = emp_detail.emp_detail.state;
		var hire_date = emp_detail.emp_detail.hire_date;
		var quit_date = emp_detail.emp_detail.quit_date;
		if(quit_date=="1900-01-01")
			quit_date="";
		var position = emp_detail.emp_detail.position;
		var phonenum1 = emp_detail.emp_detail.phonenum1;
		var phonenum2 = emp_detail.emp_detail.phonenum2;
		var phonenum3= emp_detail.emp_detail.phonenum3;
		var career_date = emp_detail.emp_detail.career_date;
		var division = emp_detail.emp_detail.division;
		var photo = emp_detail.emp_detail.photo;
		var email = emp_detail.emp_detail.email;
		var envclass = emp_detail.emp_detail.envclass?emp_detail.emp_detail.envclass:"";
		var skill = emp_detail.emp_detail.skill?emp_detail.emp_detail.skill:"";
		var job = emp_detail.skill;
		var grade=emp_detail.emp_detail.grade;
		var time_off=emp_detail.emp_detail.time_off;
		var to_start_day=emp_detail.emp_detail.to_start_day;
		var to_end_day=emp_detail.emp_detail.to_end_day;

		var result=career(career_date);
		var s=1;
		var j=1;	
		for(var i=0 ; job.split(",")[i] ;i++)
		{	
				$("#job_div").setJob(j++,job.split(",")[i],{year:"true"});
			
		}


			 var out_radio = document.getElementById("out_form");
			 var emp_radio = document.getElementById("emp_form");
			  emp_radio.disabled=true;
			  out_radio.disabled=true;
			  
			  
			  if(division=='직원') {		 
				  
				
			  		emp_radio.checked = true;
			  		$("#hire_title").text("입사일 *");
		    		$("#quit_title").text("퇴사일");
		    		$("#position_title").text("직 급 *");
		    		$("#email_title").text("E-mail * ");
		    		$("#mail_form").text("@sqisoft.com");
		    		
		    		
			    	
			    		var addhtml="";
			    		addhtml+='<option value="5사원">사원</option><option value="4대리">대리</option><option value="3과장">과장</option><option value="2차장">차장</option>';
						addhtml+='<option value="1부장">부장</option><option value="0임원">임원'
			    			$("#emp_position").html(addhtml);
						$("#emp_salary").setSal('E');
						
						
						if($('#emptable tr:eq(4)').children().eq(0).attr("id") =="to")
							$('#emptable tr:eq(5)').remove();
						
						if( $('#emptable tr:eq(4)').children().eq(0).attr("id") !="timeoff"){
					     	var html='<tr id = "to">';
					    	        html += '<th colspan="2" align="right" id=timeoff>휴&nbsp;직&nbsp;일&nbsp;&nbsp;</th>';
					    	        html += '<td  align="left"><input type = "checkbox" id = time_off value="0" onclick = "tock()">휴직';
					    	        html +='&nbsp;';
					    	        html +='<input type="text" id=to_start_day style="width: 38%; height: 100%" name="to_end_day"> ~ ';
					    	        html +='<input type="text" id=to_end_day style="width: 38%; height: 100%" name="to_end_day"></td>'
					    	        html +='</tr>';
					    	        $("#emptable tr:eq(4)").before(html);
						}
					
							var name = document.getElementById("emp_name");
				  			name.value=emp_name;
				  			var name = document.getElementById("h_name");//이름 변경여부 확인 용, 식별자 관리에 필요
				  			name.value=emp_name;
				  			//변경전 이름 값 세팅 
				  			$("#realName").text(emp_name);
				  			var name = document.getElementById("emp_company");
				  			name.value=company;
				  			name.disabled=true;
				  			var name = document.getElementById("emp_photo");
				  			name.src=photo;
				  			var name = document.getElementById("emp_grade");
				  			name.value=grade;
				  			name.hidden=false;
				  			var name = document.getElementById("upload");
				  			  			
				  			var name = document.getElementById("hire_date");
				  			name.value=hire_date;
				
//				  			var name = document.getElementById("career_date");
//				  			name.value=career_date;
				  			var name = document.getElementById("career_date_Y");
				  			name.value=result.split("/")[0];
				  			
				  			var name = document.getElementById("career_date_M");
				  			name.value=result.split("/")[1];
				  			
				  			var name = document.getElementById("quit_date");
				  			name.value=quit_date;
				  			
				  			var name = document.getElementById("emp_position");
				  			name.value=position;
				  			
				  			var name = document.getElementById("emp_salary");
				  			name.value=salary;
				  
				  			var name = document.getElementById("emp_phonenum1");
				  			name.value=phonenum1;
				  			
				  			var name = document.getElementById("emp_phonenum2");
				  			if(phonenum2 =='0000'){
				  					name.value="";
				  			}else{
				  				name.value=phonenum2;
				  			}
				  			
				  			var name = document.getElementById("emp_phonenum3");
				  			if(phonenum3 =='0000'){
			  					name.value="";
			  			}else{
			  				name.value=phonenum3;
			  			}
				  			if(area==null){
				  				 $('#area').setAreadiv({}); 
				  			}else{
				  			$("#area").setArea(1,area,{})
				  			}
				  			$('#team_name').setTeamdiv({hr:true,selectVal:team_id});
				  				  	
				  			
				  			var name = document.getElementById("emp_email");
				  			name.value=email;
				  			
				  			var cwm;
				  		    for(var i=0; i<envclass.length; i++){
				  		 
				  		    	cwm=envclass.substring( i,(i+1) );
				  		    	
				  		    	$(":checkbox[name='envclass'][value=" +cwm+ "]").attr('checked','checked');
				  					
				  					
				  		    }
				  			
				  			var name = document.getElementById("skill");
				  			name.value=skill;

				  			var name = document.getElementById("time_off");
				  			name.value = time_off;	
				  			if(name.value== "1"){
				  				document.getElementById("time_off").checked = true;
				  				
				  			}
				  			else if(name.value=="0"){
				  				document.getElementById("time_off").checked = false;
				  				
				  			}
				  			
				  			var name = document.getElementById("to_start_day");
				  			name.value=to_start_day;
				  			
				  			var name = document.getElementById("to_end_day");
				  			name.value=to_end_day;
				  			
				  			var name = document.getElementById("delete_btn");
				  			name.disabled=false;
				  			name._visible=true;
				  			
				  		
			  	}
		  				
		  
			  if(division=='외주') {
				  
				  var money=emp_detail.vo.salary;
					var mp=emp_detail.vo.mpm;
					out_radio.checked = true;
			  		$("#hire_title").text("계약일 *");
		    		$("#quit_title").text("만료일 *");
		    		$("#position_title").text("등 급 *");
		     		$("#area_title").text("거 주 지");
		    		$("#email_title").text("E-mail")
		    		$("#mail_form").text(" ");
		    		$("#emp_salary").setSal('O');
		    		
		     
		    		
		    		 if($('#emptable tr:eq(4)').children().eq(0).attr("id") =="timeoff"){
						 $('#emptable tr:eq(4)').remove()
						  }
		    	
				
		    		var html='';
	       				html+=	'<tr>'
	       				html+=	'<th style=" width:241px; height: 30px;" id=salary_title>단 가 *'
	       				html+=	'<td style="width:471px" colspan="2" align="left">'
		    		    html+=	 '<input  type="text" style="width:100px" id=emp_salary name=salary onKeyup=setCU() />'
		    		    html+=	'</tr>'
	    				setMpm();
					var out_grade = document.getElementById("emp_position");
		    		var addhtml="";
			    		addhtml+='<option value="B턴키">턴키</option><option value="6특급">특급</option><option value="7고급">고급</option><option value="8중급">중급</option>';
						addhtml+='<option value="9초급">초급</option><option value="A기능사">기능사</option>'
		    		$("#emp_position").html(addhtml);
				
					 
		    		var name = document.getElementById("emp_name");
		  			name.value=emp_name;
		  			
		  			
		  			var name = document.getElementById("h_name");//이름 변경여부 확인 용, 식별자 관리에 필요
		  			name.value=emp_name;
		  			//변경전 이름 값 세팅 
		  			$("#realName").text(emp_name);
		  			
		  			var name = document.getElementById("emp_company");
		  			name.value=company;
		  			name.disabled=false;
		  			
		  			var name = document.getElementById("emp_photo");
		  			name.src=photo;
		  		
		  			var name = document.getElementById("upload");
		  			var name = document.getElementById("emp_grade");
		  			name.hidden=true;
		  			var name = document.getElementById("hire_date");
		  			name.value=hire_date;
		
		  			var name = document.getElementById("career_date_Y");
		  			name.value=result.split("/")[0];
		  			
		  			var name = document.getElementById("career_date_M");
		  			name.value=result.split("/")[1];
		  			
		  			var name = document.getElementById("quit_date");
		  			name.value=quit_date;
		  			
		  			var name = document.getElementById("emp_position");
		  			name.value=position;
		  			
		  			var name = document.getElementById("emp_position");
		  			name.value=position;
		  			
		  			var name = document.getElementById("emp_phonenum1");
		  			name.value=phonenum1;
		  			
		  			var name = document.getElementById("emp_phonenum2");
		  			if(phonenum2 =='0000'){
		  					name.value="";
		  			}else{
		  				name.value=phonenum2;
		  			}
		  			
		  			var name = document.getElementById("emp_phonenum3");
		  			if(phonenum3 =='0000'){
	  					name.value="";
	  			}else{
	  				name.value=phonenum3;
	  			}
		  			
		  			$('#team_name').setTeamdiv({hr:true,selectVal:team_id});
		  				  	
		  			var name = document.getElementById("emp_salary");
		  			name.value=money;

		  			var name = document.getElementById("emp_email");
		  			name.value=email;
		  			
		  			var cwm;
		  		    for(var i=0;i<envclass.length;i++){
		  		 
		  		    	cwm=envclass.substring( i,(i+1) );
		  		    	
		  		    	$(":checkbox[name='envclass'][value=" +cwm+ "]").attr('checked','checked');
		  					
		  		    }
		  		    
		  			var name = document.getElementById("skill");
		  			name.value=skill;
		  			
		  			
		  	
		  			if(area==null){
		  				 $('#area').setAreadiv({}); 
		  			}else{
		  			$("#area").setArea(1,area,{})
		  			}
		  		 			
		  			var name = document.getElementById("delete_btn");
		  			name.disabled=false;
		  			name._visible=true;
		    		
				  	mpm.value=mp;
				  }
			
						
					
						
					//	$("#hideId").val(empid);
				
	},
	error : function(xhr) {
		alert("error html = " + xhr.statusText);
	}			
});
}


function career(date){
	// career_date가 null일 경우 split처리(임시)_필수값이므로 본래 값이 null일 수 없음
	if(date==null){
	      return "/";
	   }
	
	var d=new Date()
	var year=Number(d.getFullYear())-Number(date.split("-")[0]);
	var mon=Number(d.getMonth()+1)-Number(date.split("-")[1]);


	if(mon<0)
	{
		year--;
		mon=12+mon;
	}
	var result=year+"/"+mon;
	
	return result;
}
