// 검색 기본 폼
function getWatingListSearchForm() {
	$.ajax({
		type : "POST",
		url : "/deployMap/searchForm",
		success : function(data) {
			$("#monthlyDeployMapSearchForm").empty();
			$("#monthlyDeployMapSearchForm").html(data);
		},
		error : function(xhr) {
			alert("error getWatingListSearchForm = " + xhr.statusText);
		}
	});
}

//팀 검색
function getTeamSearch(tm_name, radioId){
	$.ajax({
		type : "POST",
		url : "/deployMap/teamAndNameSearchForm",
		awync : true,
		dataType : "json",
		data : { "tm_name" : tm_name
				, "radioId" : radioId },
		success : function(data) {
			
			var thisDate = new Date();
			var currentYear = thisDate.getFullYear();
			var test=document.getElementById("nowYear");
			
			var fullDate=new Date();
			var currentMonth = fullDate.getMonth()+1;
			var test1 = document.getElementById("nowMonth");
			
			var html = "";

			html+='<TABLE id="deployMapTableName" class="deployMapTableName" cellpadding="0" cellspacing="0" border="0">'
						html+=	'<tr>';
						html+=	'<th rowspan="2">이 름</th>';
						html+=	'<th rowspan="2">직급</th>';
						html+=	'<th rowspan="2">현 소속팀</th>';
						html+=	'<th colspan="12" class="show_result"></th>';
						html+=	'<th rowspan="2">비고</th>';
						html+=	'</tr>';
						html+=	'<tr>';
						html+=	'<th>1월</th>';
						html+=	'<th>2월</th>';
						html+=	'<th>3월</th>';
						html+=	'<th>4월</th>';
						html+=	'<th>5월</th>';
						html+=	'<th>6월</th>';
						html+=	'<th>7월</th>';
						html+=	'<th>8월</th>';
						html+=	'<th>9월</th>';
						html+=	'<th>10월</th>';
						html+=	'<th>11월</th>';
						html+=	'<th>12월</th>';
						html+= 	'</tr>';	
									$.each(data.deployMapVO,function(entryIndex, deployMapVO){ 
										
										if(deployMapVO.hr_position != null){
											html+='<tr>'
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.pd_name+'</td>';
											html+='<td style="background-color:#fcfcfe">'+deployMapVO.hr_position.substring(1, 3)+'</td>';	
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.tm_name+'</td>';
										}else{
											html+='<tr>'
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.pd_name+'</td>';
											html+='<td style="background-color:#fcfcfe">'+'</td>';	
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.tm_name+'</td>';
										}
					
										for(var i=0; i<12; i++){
											var test = deployMapVO.pj[i];
											var quit = deployMapVO.hr_quit_date;
											if(deployMapVO.hr_quit_date!=null){
												var q_year = quit.substr(0,4);
												var qq_day = quit.substr(8,2);
											}
											
											var hire = deployMapVO.hr_hire_date;
											
											//외주의 경우 입사일이 null임
											var h_year = null;
											if(hire != null)
												h_year = hire.substr(0,4);
											else
												h_year = "";
											
											var date = new Date();
											var d_year  = date.getFullYear();
											
												if(deployMapVO.pj[i]==null){   // 프로젝트 무
													if((h_year==d_year)&&(q_year==d_year)){  // 입사, 퇴사 한 해 모두인 경우  
														var h_month = hire.substr(5,2);
														var q_month = quit.substr(5,2);
															
														if((i>=q_month)||(i<h_month-1)){
															html+='<td bgcolor="#bfbfbf">'+"";
														}else{
															html+='<td>'+"대기";	
														}
														html+='</td>';
													}else if(h_year==d_year){  // 현재년도 입사자 
														var h_month = hire.substr(5,2);
														if(i<h_month-1){   // 입사자 disabled 처리
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';
														}else{
															html+='<td>'+"대기"+'</td>';		
														}													
													}else if(q_year==d_year){  // 퇴사자
														var q_month = quit.substr(5,2);
														if((i>=q_month)){   // 퇴사자 disabled 처리(해당월 뒤로)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else if((i==q_month-1)&&(qq_day=="01")){   // 퇴사자 disabled 처리(1일퇴사자)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else{
																html+='<td>'+"대기"+'</td>';	
															  }				
													}else{// 퇴사, 입사 모두 아닌경우
														html+='<td>'+"대기"+'</td>';
													}
												}else{  // 프로젝트 유
													if((h_year==d_year)&&(q_year==d_year)){  // 입사, 퇴사 한 해 모두인 경우  
														var h_month = hire.substr(5,2);
														var q_month = quit.substr(5,2);
															
														if((i>=q_month)||(i<h_month-1)){
															html+='<td bgcolor="#bfbfbf">'+"";
														}else{
															html+='<td>'+test;	
														}
														html+='</td>';
													}else if(h_year==d_year){
														var h_month = hire.substr(5,2);
														if(i<h_month-1){
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';
														}else{
															html+='<td>'+test+'</td>';		
														}													
													}else if(q_year==d_year){
														var q_month = quit.substr(5,2);
														if((i>=q_month)){   // 퇴사자 disabled 처리(해당월 뒤로)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else if((i==q_month-1)&&(qq_day=="01")){   // 퇴사자 disabled 처리(1일퇴사자)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else{
																html+='<td>'+test+'</td>';		
															}			
													}else{ // 퇴사, 입사 모두 아닌경우
														html+='<td>'+test+'</td>';
													}
												}
											}
										
										var quit = deployMapVO.hr_quit_date;
										if(deployMapVO.hr_quit_date!=null){
											var q_year = quit.substr(0,4);
										}
										
										var hire = deployMapVO.hr_hire_date;
										//외주의 경우 입사일이 null임
										var h_year = null;
										if(hire != null)
											h_year = hire.substr(0,4);
										else
											h_year = "";
										
										var date = new Date();
										var d_year  = date.getFullYear();
										
										html+='<td>';
										
										if(h_year==d_year){
											var hh_year = hire.substr(2,2);
											var h_month = hire.substr(5,2);
											var h_day = hire.substr(8,2);
											
											html+=hh_year+"."+h_month+"."+h_day+" 입사";
										}

										
										if(q_year==d_year){
											var qq_year = quit.substr(2,2);
											var q_month = quit.substr(5,2);
											var q_day = quit.substr(8,2);
											
											html+=qq_year+"."+q_month+"."+q_day+" 퇴사";
										}else{
											html+="";
										}
										
										html+='</td>';
					
					html+='</tr>'
			});

						html+='</TABLE>'	
				
			$("#standByInfo").html(html);
		
			$(".show_result").text(currentYear+" 투입(예정)MM");
			month_color(currentMonth);   // 현재 달 color 표시
			readyColor();    //  현재달 이후 미배치표시

			return;
			
		},
		error : function(xhr) {
			alert("error = " + xhr.statusText);
		}
	});
}

//이름 검색
function getNameSearch(hr_name){
	$.ajax({
		type : "POST",
		url : "/deployMap/teamAndNameSearchForm",
		awync : true,
		dataType : "json",
		data : { "hr_name" : hr_name },
		success : function(data) {
			var thisDate = new Date();
			var currentYear = thisDate.getFullYear();
			var test=document.getElementById("nowYear");
			
			
			var fullDate=new Date();
			var currentMonth = fullDate.getMonth()+1;
			var test1 = document.getElementById("nowMonth");
			
			
			var html = "";

			html+='<TABLE id="deployMapTableName" class="deployMapTableName" cellpadding="0" cellspacing="0" border="0">'
						html+=	'<tr>';
						html+=	'<th rowspan="2">이 름</th>';
						html+=	'<th rowspan="2">직급</th>';
						html+=	'<th rowspan="2">현 소속팀</th>';
						html+=	'<th colspan="12" class="show_result"></th>';
						html+=	'<th rowspan="2">비고</th>';
						html+=	'</tr>';
						html+=	'<tr>';
						html+=	'<th>1월</th>';
						html+=	'<th>2월</th>';
						html+=	'<th>3월</th>';
						html+=	'<th>4월</th>';
						html+=	'<th>5월</th>';
						html+=	'<th>6월</th>';
						html+=	'<th>7월</th>';
						html+=	'<th>8월</th>';
						html+=	'<th>9월</th>';
						html+=	'<th>10월</th>';
						html+=	'<th>11월</th>';
						html+=	'<th>12월</th>';
						html+= 	'</tr>';	
									$.each(data.deployMapVO,function(entryIndex, deployMapVO){ 
										
				
										if(deployMapVO.hr_position != null){
											html+='<tr>'
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.pd_name+'</td>';
											html+='<td style="background-color:#fcfcfe">'+deployMapVO.hr_position.substring(1, 3)+'</td>';	
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.tm_name+'</td>';
										}else{
											html+='<tr>'
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.pd_name+'</td>';
											html+='<td style="background-color:#fcfcfe">'+'</td>';	
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.tm_name+'</td>';
										}
											
					
										for(var i=0; i<12; i++){
											var test = deployMapVO.pj[i];
											var quit = deployMapVO.hr_quit_date;
											if(deployMapVO.hr_quit_date!=null){
												var q_year = quit.substr(0,4);
												var qq_day = quit.substr(8,2);
											}
											
											var hire = deployMapVO.hr_hire_date;
											//외주의 경우 입사일이 null임
											var h_year = null;
											if(hire != null)
												h_year = hire.substr(0,4);
											else
												h_year = "";
											
											var date = new Date();
											var d_year  = date.getFullYear();
											
												if(deployMapVO.pj[i]==null){   // 프로젝트 무
													if((h_year==d_year)&&(q_year==d_year)){  // 입사, 퇴사 한 해 모두인 경우  
														var h_month = hire.substr(5,2);
														var q_month = quit.substr(5,2);
															
														if((i>=q_month)||(i<h_month-1)){
															html+='<td bgcolor="#bfbfbf">'+"";
														}else{
															html+='<td>'+"대기";	
														}
														html+='</td>';
													}else if(h_year==d_year){  // 현재년도 입사자 
														var h_month = hire.substr(5,2);
														if(i<h_month-1){   // 입사자 disabled 처리
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';
														}else{
															html+='<td>'+"대기"+'</td>';		
														}													
													}else if(q_year==d_year){  // 퇴사자
														var q_month = quit.substr(5,2);
														if((i>=q_month)){   // 퇴사자 disabled 처리(해당월 뒤로)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else if((i==q_month-1)&&(qq_day=="01")){   // 퇴사자 disabled 처리(1일퇴사자)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else{
																html+='<td>'+"대기"+'</td>';	
															  }				
													}else{// 퇴사, 입사 모두 아닌경우
														html+='<td>'+"대기"+'</td>';
													}
												}else{  // 프로젝트 유
													if((h_year==d_year)&&(q_year==d_year)){  // 입사, 퇴사 한 해 모두인 경우  
														var h_month = hire.substr(5,2);
														var q_month = quit.substr(5,2);
															
														if((i>=q_month)||(i<h_month-1)){
															html+='<td bgcolor="#bfbfbf">'+"";
														}else{
															html+='<td>'+test;	
														}
														html+='</td>';
													}else if(h_year==d_year){
														var h_month = hire.substr(5,2);
														if(i<h_month-1){
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';
														}else{
															html+='<td>'+test+'</td>';		
														}													
													}else if(q_year==d_year){
														var q_month = quit.substr(5,2);
														if((i>=q_month)){   // 퇴사자 disabled 처리(해당월 뒤로)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else if((i==q_month-1)&&(qq_day=="01")){   // 퇴사자 disabled 처리(1일퇴사자)
															html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
														}else{
																html+='<td>'+test+'</td>';		
															}			
													}else{ // 퇴사, 입사 모두 아닌경우
														html+='<td>'+test+'</td>';
													}
												}
											}
										
										var quit = deployMapVO.hr_quit_date;
										if(deployMapVO.hr_quit_date!=null){
											var q_year = quit.substr(0,4);
										}
										
										var hire = deployMapVO.hr_hire_date;
										//외주의 경우 입사일이 null임
										var h_year = null;
										if(hire != null)
											h_year = hire.substr(0,4);
										else
											h_year = "";
										
										var date = new Date();
										var d_year  = date.getFullYear();
										
										html+='<td>';
										
										if(h_year==d_year){
											var hh_year = hire.substr(2,2);
											var h_month = hire.substr(5,2);
											var h_day = hire.substr(8,2);
											
											html+=hh_year+"."+h_month+"."+h_day+" 입사";
										}

										
										if(q_year==d_year){
											var qq_year = quit.substr(2,2);
											var q_month = quit.substr(5,2);
											var q_day = quit.substr(8,2);
											
											html+=qq_year+"."+q_month+"."+q_day+" 퇴사";
										}else{
											html+="";
										}
										
										html+='</td>';
					
					html+='</tr>'
			});

						html+='</TABLE>'	
				
			$("#standByInfo").html(html);
		
			$(".show_result").text(currentYear+" 투입(예정)MM");
			month_color(currentMonth);   // 현재 달 color 표시
			readyColor();    //  현재달 이후 미배치표시

			return;
			
		},
		error : function(xhr) {
			alert("error = " + xhr.statusText);
		}
	});
}

// 직원 맵
function emp_map(){		 //=========================================직원 선택시
	 $("standByInfo").show();

	 $.ajax({
			type : "POST",
			url : "/deployMap/monthlyDeployMap",
			async : true,
			dataType : "json",
			data : {
				
			},

			success : function(data) {	
				var thisDate = new Date();
				var currentYear = thisDate.getFullYear();
				var test=document.getElementById("nowYear");
				
				
				var fullDate=new Date();
				var currentMonth = fullDate.getMonth()+1;
				var test1 = document.getElementById("nowMonth");
				
				
				var html = "";

				html+='<TABLE id="deployMapTableName" class="deployMapTableName" cellpadding="0" cellspacing="0" border="0">'
							html+=	'<tr>';
							html+=	'<th rowspan="2">이 름</th>';
							html+=	'<th rowspan="2">직급</th>';
							html+=	'<th rowspan="2">현 소속팀</th>';
							html+=	'<th colspan="12" class="show_result"></th>';
							html+=	'<th rowspan="2">비고</th>';
							html+=	'</tr>';
							html+=	'<tr>';
							html+=	'<th>1월</th>';
							html+=	'<th>2월</th>';
							html+=	'<th>3월</th>';
							html+=	'<th>4월</th>';
							html+=	'<th>5월</th>';
							html+=	'<th>6월</th>';
							html+=	'<th>7월</th>';
							html+=	'<th>8월</th>';
							html+=	'<th>9월</th>';
							html+=	'<th>10월</th>';
							html+=	'<th>11월</th>';
							html+=	'<th>12월</th>';
							html+= 	'</tr>';	
										$.each(data.deployMapVO,function(entryIndex, deployMapVO){ 
											
					
											html+='<tr>'
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.pd_name+'</td>';
											html+='<td style="background-color:#fcfcfe">'+deployMapVO.hr_position.substring(1, 3)+'</td>';	
											html+='<td style="background-color:#f2f4fb">'+deployMapVO.tm_name+'</td>';
												
						
											for(var i=0; i<12; i++){
												var test = deployMapVO.pj[i];
												var quit = deployMapVO.hr_quit_date;
												if(deployMapVO.hr_quit_date!=null){
													var q_year = quit.substr(0,4);
													var qq_day = quit.substr(8,2);
												}
												
												var hire = deployMapVO.hr_hire_date;
												var h_year = hire.substr(0,4);
												
												var date = new Date();
												var d_year  = date.getFullYear();
												
													if(deployMapVO.pj[i]==null){   // 프로젝트 무
														if((h_year==d_year)&&(q_year==d_year)){  // 입사, 퇴사 한 해 모두인 경우  
															var h_month = hire.substr(5,2);
															var q_month = quit.substr(5,2);
																
															if((i>=q_month)||(i<h_month-1)){
																html+='<td bgcolor="#bfbfbf">'+"";
															}else{
																html+='<td>'+"대기";	
															}
															html+='</td>';
														}else if(h_year==d_year){  // 현재년도 입사자 
															var h_month = hire.substr(5,2);
															if(i<h_month-1){   // 입사자 disabled 처리
																html+='<td bgcolor="#bfbfbf">'+""+'</td>';
															}else{
																html+='<td>'+"대기"+'</td>';		
															}													
														}else if(q_year==d_year){  // 퇴사자
															var q_month = quit.substr(5,2);
															if((i>=q_month)){   // 퇴사자 disabled 처리(해당월 뒤로)
																html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
															}else if((i==q_month-1)&&(qq_day=="01")){   // 퇴사자 disabled 처리(1일퇴사자)
																html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
															}else{
																	html+='<td>'+"대기"+'</td>';	
																  }				
														}else{// 퇴사, 입사 모두 아닌경우
															html+='<td>'+"대기"+'</td>';
														}
													}else{  // 프로젝트 유
														if((h_year==d_year)&&(q_year==d_year)){  // 입사, 퇴사 한 해 모두인 경우  
															var h_month = hire.substr(5,2);
															var q_month = quit.substr(5,2);
																
															if((i>=q_month)||(i<h_month-1)){
																html+='<td bgcolor="#bfbfbf">'+"";
															}else{
																html+='<td>'+test;	
															}
															html+='</td>';
														}else if(h_year==d_year){
															var h_month = hire.substr(5,2);
															if(i<h_month-1){
																html+='<td bgcolor="#bfbfbf">'+""+'</td>';
															}else{
																html+='<td>'+test+'</td>';		
															}													
														}else if(q_year==d_year){
															var q_month = quit.substr(5,2);
															if((i>=q_month)){   // 퇴사자 disabled 처리(해당월 뒤로)
																html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
															}else if((i==q_month-1)&&(qq_day=="01")){   // 퇴사자 disabled 처리(1일퇴사자)
																html+='<td bgcolor="#bfbfbf">'+""+'</td>';	
															}else{
																	html+='<td>'+test+'</td>';		
																}			
														}else{ // 퇴사, 입사 모두 아닌경우
															html+='<td>'+test+'</td>';
														}
													}
												}
											
											var quit = deployMapVO.hr_quit_date;
											if(deployMapVO.hr_quit_date!=null){
												var q_year = quit.substr(0,4);
											}
											
											var hire = deployMapVO.hr_hire_date;
											var h_year = hire.substr(0,4);
											
											var date = new Date();
											var d_year  = date.getFullYear();
											
											html+='<td>';
											
											if(h_year==d_year){
												var hh_year = hire.substr(2,2);
												var h_month = hire.substr(5,2);
												var h_day = hire.substr(8,2);
												
												html+=hh_year+"."+h_month+"."+h_day+" 입사";
											}

											
											if(q_year==d_year){
												var qq_year = quit.substr(2,2);
												var q_month = quit.substr(5,2);
												var q_day = quit.substr(8,2);
												
												html+=qq_year+"."+q_month+"."+q_day+" 퇴사";
											}else{
												html+="";
											}
											
											html+='</td>';
						
						html+='</tr>'
				});

							html+='</TABLE>'	
					
				$("#standByInfo").html(html);
			
				$(".show_result").text(currentYear+" 투입(예정)MM");
				month_color(currentMonth);   // 현재 달 color 표시
				readyColor();    //  현재달 이후 미배치표시

				return;
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}
		});

};

// 외주
function out_map(){

	$("standByInfo").show();
	 
	 $.ajax({
			type : "POST",
			url : "/deployMap/outDeployMap",
			async : true,
			dataType : "json",
			data : {
				
			},

			success : function(data) {	
				var thisDate = new Date();
				var currentYear = thisDate.getFullYear();
				var test=document.getElementById("nowYear");
				
				
				var fullDate=new Date();
				var currentMonth = fullDate.getMonth()+1;
				var test1 = document.getElementById("nowMonth");
				
				
				var html = "";
				
				html+='<TABLE id="deployMapTableName" class="deployMapTableName" cellpadding="0" cellspacing="0" border="0">'
							html+=	'<tr>';
							html+=	'<th rowspan="2">이 름</th>';
							html+=	'<th rowspan="2">등 급</th>';
							html+=	'<th rowspan="2">현 PJ팀</th>';
							html+=	'<th colspan="12" class="show_result"></th>';
							html+=	'<th rowspan="2">비고</th>';
							html+=	'</tr>';
							html+=	'<tr>';
							html+=	'<th>1월</th>';
							html+=	'<th>2월</th>';
							html+=	'<th>3월</th>';
							html+=	'<th>4월</th>';
							html+=	'<th>5월</th>';
							html+=	'<th>6월</th>';
							html+=	'<th>7월</th>';
							html+=	'<th>8월</th>';
							html+=	'<th>9월</th>';
							html+=	'<th>10월</th>';
							html+=	'<th>11월</th>';
							html+=	'<th>12월</th>';
							html+= 	'</tr>';	
										$.each(data.deployMapVO,function(entryIndex, deployMapVO){ 
											var num = /[0-9]/
					
											html+='<tr>'
												html+='<td style="background-color:#f2f4fb; text-align:left;">'+deployMapVO.pd_name+'</td>';
												html+='<td style="background-color:#fcfcfe">'+deployMapVO.hr_grade+'</td>';	
												html+='<td style="background-color:#f2f4fb; text-align:left;">'+deployMapVO.tm_name+'</td>';
					
												for(var i=0; i<12; i++){
													var test = deployMapVO.pj[i];
														if(deployMapVO.pj[i]==null){
															html+='<td>'+""+'</td>';
														}else{
															html+='<td>'+test+'</td>';
														}
												}
												
												var hr_company = deployMapVO.hr_company;
												if(deployMapVO.hr_company==null){
													html+='<td >'+""+'</td>';
												}else{
													html+='<td >'+hr_company+'</td>';
												}
												
												html+='</tr>'
			});

							html+='</TABLE>'		
				
			$("#standByInfo").html(html);
		
			$(".show_result").text(currentYear+" 투입(예정)MM");
			month_color(currentMonth);   // 현재 달 color 표시

			return;
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

	function month_color(mon)    // 현재 달 이후  color 표시
	{
		var date=new Date();
		var currentMonth=date.getMonth()+1;
		$("tr","table").each(function(i,v){
			for(k=currentMonth+3;k<15;k++){
				$(v).children().eq(k).css("background-color","#f2f4fb");
			}
		})
	}
	function readyColor()     // 현재 달 이후 '대기'/'미배치' 표시
	{
			var date=new Date();
			var currentMonth=date.getMonth()+1;
			$("tr","table").each(function(i,v){
				for(k=currentMonth+3;k<15;k++){
				if($(v).children().eq(k).html()=="대기")
					$(v).children().eq(k).html("미배치");
				}
			})
	}
	