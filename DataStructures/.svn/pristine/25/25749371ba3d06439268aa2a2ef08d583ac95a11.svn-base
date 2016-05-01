//배치 취소할 경우 pj_history 에서 삭제하기 위하여 삭제할 인원 정보를 담는 배열 
//var deletelist={};

//errotTX -> 저장이 안됬을떄 문제 메세지를 다르게 하여 사용자에게 확인 시키게 하기 위하여 변수 선언 
// 다른 문제 발생시 각각 다른 글 출력 
var erroTX="";
$(document).ready(function(){
	search();
//	getNoPlaceEmpList();
	
	//2015-01-27 추가 자동검색 
	$("#searchprog").change(function(){search()});
	$("#searchid").keyup(function(){search()});
	$("#searchstartday").change(function(){search()});
	$("#searchendday").change(function(){search()});
	
	$('#pjsearchbutton').click(function(){
		search();		
	});
	document.getElementById("historydelete").disabled=true;
	//기간 첫번째 input에서 키를 누를때
	$("#inputperiod_1").keydown(function(e){
		// . 제외 code : 190
		// Allow:  -, 오른쪽 숫자 키보드의 - backspace, delete, tab, escape, enter 
		if ($.inArray(e.keyCode, [189, 109, 46, 8, 9, 27, 13, 110]) !== -1 ||
			// Allow: Ctrl+A
			(e.keyCode == 65 && e.ctrlKey === true) || 
			// Allow: home, end, left, right
			(e.keyCode >= 35 && e.keyCode <= 39)) {
				// let it happen, don't do anything
				return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        	e.preventDefault();
        }
	});
	//기간 두번째 input에서 키를 누를때
	$("#inputperiod_2").keydown(function(e){
		// . 제외 code : 190
		// Allow: -, 오른쪽 숫자 키보드의 - ,backspace, delete, tab, escape, enter 
		if ($.inArray(e.keyCode, [189, 109, 46, 8, 9, 27, 13, 110]) !== -1 ||
				// Allow: Ctrl+A
				(e.keyCode == 65 && e.ctrlKey === true) || 
				// Allow: home, end, left, right
				(e.keyCode >= 35 && e.keyCode <= 39)) {
			// let it happen, don't do anything
			return;
		}
		// Ensure that it is a number and stop the keypress
		if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
			e.preventDefault();
		}
	});
	$('#historycancle').click(function(){
		noSearchrefresh();
	});
	
	$('#historysave').click(function() {
		var saveInput = $(this);
		var updatecheck=0;
		if($("#division").html()!=''){
			var altMsg="수정하시겠습니까?";
			updatecheck=1;
		}
		else {
			var altMsg="저장하시겠습니까?";
		}
		
		
		var isOK = false;
		
			$("tr","#pjposting_result").each(function(k,v){
				if($(v).children().eq(0).html() == $("#inputname").val()&&altMsg!="수정하시겠습니까?") {
				alert($("#inputname").val()+"은(는) 이미 배치된 사람입니다.");
				noSearchrefresh();
			}
		});
		
		//수정 상태일 경우 중복 검사를 하지 않음
		var isModifyFlag = false; 
//		/console.log("VAL:" + $(saveInput).attr("value"));
		var division='';
		if($(saveInput).attr("value") == "수정") {
			isModifyFlag = true;
		}
		if(isModifyFlag!=true) {
			$.ajax({				
				type : "POST", 
				url:"/getPjIntersecDur.action",
				async : false,
				dataType : "json",
				data:{			
					name		:	$("#inputname").val(),
					startDate 	: 	$("#inputperiod_1").val(),
					endDate    	:   $("#inputperiod_2").val()
				},
				success : function(data) {
					//alert("데이터를 올바르게 가져왔습니다." + data.onPjFlag);
					var alreadyDoProject = "[";
					if(data.onPjFlag>0) {
						$.each(data.pjPostingVOList, function (index, item) {
							if(data.onPjFlag-1!=index) {
								alreadyDoProject = alreadyDoProject + item.pj_id + ", ";
							}
							else {
								alreadyDoProject = alreadyDoProject + item.pj_id;
							}
						});
						alreadyDoProject += "]";
						altMsg = "이미" + alreadyDoProject + "프로젝트를 수행중인 직원입니다. 투입 후 저장하시겠습니까?";
					}
				}
			});
		}
		var comfirmSave = confirm(altMsg);
		
		if(comfirmSave){
			if(pj_id_cur==''){alert("배치를 진행할 프로젝트를 선택해주세요.");return false;}
			else if($("#inputname").val()==''){alert("이름을 입력하여주세요.");return false;}
			else if($("#inputperiod_1").val()==''||$("#inputperiod_2").val()==''){alert("프로젝트기간을 입력하여주세요.");return false;}
			$.ajax({				
				type : "POST", 
				url:"/empcheck.action",
				async : true,
				dataType : "json",
				data:{			
					name		:	$("#inputname").val(),
				},

				success : function(map) {
				//	alert ("empcheck :"+division.division);
					if(map==null){
						isOK=false;	
						alert("인력 정보에 등록되지 않은 사람입니다.");
						noSearchrefresh();
					}
					else {
							
						division=map.division;
						hire_date=map.hire_date;
					//	alert(division+","+hire_date);
						var date1=$("#inputperiod_1").val().replace(/-/gi,"");
						var date2=hire_date.replace(/-/gi,"");
						var curyear = new Date();
					//	alert(date1);
					//	alert(date2);
						
						//입사일 == 올해 년도 이고 입사일 이전에 프로젝트 배치하려고 한경우 저장 x 
						if(parseInt(date2.substring(0,4))==curyear.getFullYear()&&parseInt(date1)<parseInt(date2))
							{
							alert("입사일인 "+hire_date+"보다 앞의 날짜를 선택해 주세요");
							isOK=false;
							$("#inputperiod_1").val(hire_date);
							return false;
							}
						else {
							isOK=true;
						}
						
						if(updatecheck==0){
							if(isOK==true){
//									alert("insert!");
								$.ajax({				
									type : "POST", 
									url:"/pjposting_Insert_sample.action",
									async : false,
									dataType : "json",
									data:{			
										pj_id       :    pj_id_cur,
										name		:	$("#inputname").val(),
										startday 	: 	$("#inputperiod_1").val(),
										endday    	:   $("#inputperiod_2").val(),
										division	: 	division
									},
									success : function() {
										isOK=true;	
										alert("저장이 완료되었습니다.");
										getpjPostingDetail(pj_id_cur);
									//	noSearchrefresh();
									},
									error : function(xhr) {
										//alert("error html = " + xhr.statusText);
										errorTX="저장이 완료되지 않았습니다.";
										alert(errorTX);
										isOK = false;
									}, 
									complete : function(xhr){
										}	
									});
							}
					}
					else if(updatecheck==1){
						if(isOK==true){
//						alert("update!!!!");
//						alert("updatedivision"+$("#division").html());
						$.ajax({				
						type : "POST", 
						url:"/pjposting_update_sample.action",
						async : false,
						dataType : "json",
						data:{			
							pj_id       :    pj_id_cur,
							name		:	$("#inputname").val(),
							startday 	: 	$("#inputperiod_1").val(),
							endday    	:   $("#inputperiod_2").val(),
							division	: 	$("#division").html()
						},

						success : function() {
							isOK=true;	
							alert("수정이 완료되었습니다.");
							getpjPostingDetail(pj_id_cur);
						//	noSearchrefresh();
						},
						error : function(xhr) {
							//alert("error html = " + xhr.statusText);
							errorTX="수정이 완료되지 않았습니다.";
							alert(errorTX);
							isOK = false;
						}, 
						complete : function(xhr){
							}	
						});
					}
					}
					}
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
					isOK = false;
				}
			});
		}
	});
	
	/*$('#historysave').click(function(){
		var updatecheck=0;
		if($("#division").html()!=''){
			var altMsg="수정하시겠습니까?";
			updatecheck=1;
		}
		else {
			var altMsg="저장하시겠습니까?";
		}
		
		
		var isOK = false;
		
			$("tr","#pjposting_result").each(function(k,v){
				if($(v).children().eq(0).html() == $("#inputname").val()&&altMsg!="수정하시겠습니까?") {
				alert($("#inputname").val()+"은(는) 이미 배치된 사람입니다.");
				noSearchrefresh();
			}
		});
		
	
		var division='';
	
		
		
		if(confirm(altMsg)){
			if(pj_id_cur==''){alert("배치를 진행할 프로젝트를 선택해주세요.");return false;}
			else if($("#inputname").val()==''){alert("이름을 입력하여주세요.");return false;}
			else if($("#inputperiod_1").val()==''||$("#inputperiod_2").val()==''){alert("프로젝트기간을 입력하여주세요.");return false;}
			$.ajax({				
				type : "POST", 
				url:"/empcheck.action",
				async : true,
				dataType : "json",
				data:{			
					name		:	$("#inputname").val(),
				},

				success : function(map) {
				//	alert ("empcheck :"+division.division);
					if(map==null){
						isOK=false;	
						alert("인력 정보에 등록되지 않은 사람입니다.");
						noSearchrefresh();
					}
					else {
							
						division=map.division;
						hire_date=map.hire_date;
					//	alert(division+","+hire_date);
						var date1=$("#inputperiod_1").val().replace(/-/gi,"");
						var date2=hire_date.replace(/-/gi,"");
						var curyear = new Date();
					//	alert(date1);
					//	alert(date2);
						
						//입사일 == 올해 년도 이고 입사일 이전에 프로젝트 배치하려고 한경우 저장 x 
						if(parseInt(date2.substring(0,4))==curyear.getFullYear()&&parseInt(date1)<parseInt(date2))
							{
							alert("입사일인 "+hire_date+"보다 앞의 날짜를 선택해 주세요");
							isOK=false;
							$("#inputperiod_1").val(hire_date);
							return false;
							}
						else {
							isOK=true;
						}
						
						if(updatecheck==0){
							if(isOK==true){
//									alert("insert!");
								$.ajax({				
									type : "POST", 
									url:"/pjposting_Insert_sample.action",
									async : false,
									dataType : "json",
									data:{			
										pj_id       :    pj_id_cur,
										name		:	$("#inputname").val(),
										startday 	: 	$("#inputperiod_1").val(),
										endday    	:   $("#inputperiod_2").val(),
										division	: 	division
									},
									success : function() {
										isOK=true;	
										alert("저장이 완료되었습니다.");
										getpjPostingDetail(pj_id_cur);
									//	noSearchrefresh();
									},
									error : function(xhr) {
										//alert("error html = " + xhr.statusText);
										errorTX="저장이 완료되지 않았습니다.";
										alert(errorTX);
										isOK = false;
									}, 
									complete : function(xhr){
										}	
									});
							}
					}
					else if(updatecheck==1){
						if(isOK==true){
//						alert("update!!!!");
//						alert("updatedivision"+$("#division").html());
						$.ajax({				
						type : "POST", 
						url:"/pjposting_update_sample.action",
						async : false,
						dataType : "json",
						data:{			
							pj_id       :    pj_id_cur,
							name		:	$("#inputname").val(),
							startday 	: 	$("#inputperiod_1").val(),
							endday    	:   $("#inputperiod_2").val(),
							division	: 	$("#division").html()
						},

						success : function() {
							isOK=true;	
							alert("수정이 완료되었습니다.");
							getpjPostingDetail(pj_id_cur);
						//	noSearchrefresh();
						},
						error : function(xhr) {
							//alert("error html = " + xhr.statusText);
							errorTX="수정이 완료되지 않았습니다.";
							alert(errorTX);
							isOK = false;
						}, 
						complete : function(xhr){
							}	
						});
					}
					}
					}
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
					isOK = false;
				}
			});
			
			
		}
		
	});*/
	$('#historydelete').click(function(){
		var altMsg=$("#inputname").val()+"를(을) "+pj_id_cur+"에서 삭제 하시겠습니까?";
		if(confirm(altMsg)){
			$.ajax({				
				type : "POST", 
				url:"/pjposting_delete_sample.action",
				async : false,
				dataType : "json",
				data:{			
					pj_id       :    pj_id_cur,
					name		:	$("#inputname").val(),
					pj_start_day:	$("#inputperiod_1").val(),
					pj_end_day   :	$("#inputperiod_2").val(),
					division 	: 	$("#division").html()
				},

				success : function() {
					isOK=true;	
					alert("삭제가 완료되었습니다.");
					getpjPostingDetail(pj_id_cur);
				//	noSearchrefresh();
				},
				error : function(xhr) {
					//alert("error html = " + xhr.statusText);
					errorTX="삭제가 완료되지 않았습니다.";
					alert(errorTX);
					isOK = false;
				}, 
				complete : function(xhr){
					}	
				});
			}
	});
/*	$('#pjpostingsave').click(function(){
		var isOK = false;
		var count=0;
		var altMsg="저장하시겠습니까?";
		//var check = 0;

		if(confirm(altMsg)){
			//2015-02-06 배치예정일, 배치 만료일 없어도 저장되는 오류 해결 
			//2015-02-09 추가 수정 완료 
			$("tr","#posting2").each(function(k,v){
			
				if(!($(v).children().eq(10).find("input").is(":disabled")&&$(v).children().eq(11).find("input").is(":disabled"))){
					if($(v).children().eq(10).find("input").val()==""||$(v).children().eq(10).find("input").val()=="null"||$(v).children().eq(10).find("input").val()==null||$(v).children().eq(11).find("input").val()==""||$(v).children().eq(11).find("input").val()=="null"||$(v).children().eq(11).find("input").val()==null)
					{ 
						count++;
						errorTX="배치일자를 입력하여주세요."
						isOK=false;
						return false;
					}
				}
			});
			
		if(count==0){
		$("tr","#posting2").each(function(k,v){
			if($(v).children().eq(0).html()=="")
			{ 
			
			}	
			
			$.ajax({				
				type : "POST", 
				url:"/pjposting_Insert.action",
				async : false,
				dataType : "json",
				data:{				
					pj_id		:	$("#pj_id_ret").val(),
					name 		: 	$(v).children().eq(1).html(),
					division    :   $(v).children().eq(2).html(),
					cpid 		: 	$(v).children().eq(4).html(),
					cpstartday	:	$(v).children().eq(5).find("input").val(),
					cpendday 	:	$(v).children().eq(6).find("input").val(),
					use_skill 	: 	$(v).children().eq(7).find("input").val(),    // hidden
					apid 		:	$(v).children().eq(9).html(),
					apstartday 	: 	$(v).children().eq(10).find("input").val(),
					apendday 	:	$(v).children().eq(11).find("input").val(),
					ap_use_skill : $(v).children().eq(12).find("input").val(),
					state : $(v).children().eq(16).html()
//					e_area : $(v).children().eq(11).find("input").val(), 		// 값 있는데 data왜 input x?
//					cpstartday : $(v).children().eq(14).find("input").val()
				},

				success : function() {
					isOK=true;					
				},
				error : function(xhr) {
					//alert("error html = " + xhr.statusText);
					errorTX="저장이 완료되지 않았습니다.";
					isOK = false;
				}, 
				complete : function(xhr){
					}	
				});
			
			});
			}
		}
		// 2015-02-09 저장하시겠습니까 ? 취소 클릭시 배치일자를 입력하세요 오류 메시지출력 하는거 해결 
		else return false;
		//alert(typeof(deletelist));
		//for(var k in deletelist) alert(k+"(키)랑 value :  "+deletelist[k]);
		
		//삭제할 인원이 없다면 함수 호출 불 필요 하므로 호출 x 
		if(deletelist!=null || deletelist!=""||deletelist!="null"){
		$.ajax({				
			type : "POST", 
			url:"/pjposting_delete.action",
			async : true,
			dataType : "json",
			data:{
				'deletelist':deletelist
			},
			
			 data:{
				deletelist:JSON.stringify(deletelist),
				division : $(v).children().eq(1).html()
			},
			
			data:deletelist,

			success : function() {
				isOK=true;					
			},
			error : function(xhr) {
				//alert("error html = " + xhr.statusText);
				isOK = false;
				errorTX="삭제가 완료되지 않았습니다."
				
			}, 
			});
		}
	if (isOK == true) {
		$.ajax({//대기세팅 , 배치 예정중이던 인력 배치 취소 경우 pj_history 에서 삭제(move down)
			type : "POST", 
			url:"/pjposting_Insert_ap.action",
			async : true,
			dataType : "json",
			data:{				
				pj_id:$("#pj_id_ret").val()		//  pj기간 계산해서 pj_id="대기" insert하는 메소드실행 시 필요(없을 시 실행 x)
			},

			success : function() {
				alert("저장되었습니다.");
				refresh();
				getNoPlaceEmpList();
//				window.location.replace('http://localhost:8080/pjposting.do?pj_id='+$("#pj_id_ret").val())
				
				
				var pj_id=$("#pj_id_ret").val();
				deletelist={};
				$.ajax({
					type : "POST",
					url : "/pjposting_Detail.action",
					async : false,
					dataType : "json",
					data : {
						pj_id : pj_id
					},
					
					
					success : function(pjposting_detail) {
						
						var pj_id = pjposting_detail.vo.pj_id;
						var peoplenum = pjposting_detail.vo.peoplenum;
						var master = pjposting_detail.vo.master;
						var special = pjposting_detail.vo.special;
						var advanced = pjposting_detail.vo.advanced;
						var intermidate = pjposting_detail.vo.intermidate;
						var beginner= pjposting_detail.vo.beginner;
						var engineer = pjposting_detail.vo.engineer;
						var peoplenum = pjposting_detail.vo.peoplenum;
						var pj_period = pjposting_detail.vo.pj_period;
						var pj_loc = pjposting_detail.vo.pj_loc;
						var pj_needs_skill = pjposting_detail.vo.skill_name;
						var pj_end_day = pjposting_detail.vo.pj_end_day;

						$("#pj_id").val(pj_id);
						$("#pj_period").val(pj_period);
						$("#pj_loc").val(pj_loc);
					$.each(pjposting_detail, function (index, item) {
					
						});
						



						var html= '<table id ="posting2" width="1152px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'
						$.each(pjposting_detail.list, function (index, item) {
							
									var cps=item.cpstartday;
									var cpe=item.cpendday;
									var aps=item.apstartday;
									var ape=item.apendday;
									if(cps==null)
										cps='';
									if(cpe==null)
										cpe='';
									if(aps==null||item.apid=="대기")
										aps='';
									if(ape==null||item.apid=="대기")
										ape='';
									if(item.apid==null||item.apid=="대기")
										item.apid='';
									if(item.apid==null||item.apid=="대기")
										item.apid='';
									if(item.use_skill==null)
										item.use_skill='';
									if(item.ap_use_skill==null)
										item.ap_use_skill='';
									if(item.cpid == null)
										item.cpid = '';
									
								   html+='<tr><td style="border-top:0; width: 20px;" align="center"><input type="checkbox"/></td>'
								  html += '<td style="border-top:0; width: 96px;" align="center">'+item.name+'</td>';
								   html += '<td style="border-top:0; width: 40px;" align="center">'+item.division+'</td>';
								   if(item.division == '외주'){
									   html += '<td style="border-top:0; width: 39px;" align="center">'+item.position.substring(1, 3)+'</td>';
								   }
								   else{
									   html += '<td style="border-top:0; width: 39px;" align="center">'+item.grade.substring(1, 3)+'</td>';
								   }
								   
								   html += '<td style="border-top:0; width: 100px;" align="center">'+item.cpid+'</td>';
								   html += '<td style="border-top:0; width: 86px;"  align="center"><input  align="center" class="cpstartday"  style = "width :95%; height:100%;" type="text" disabled value="'+cps+ '"/></td>';
								   if(item.cpid !=pj_id){
								       html += '<td style="border-top:0; width: 87px;"  align="center"><input  align="center" class="cpendday"  style = "width :95%; height:100%;" type="text" disabled value="'+cpe+ '"/></td>';
								   }
								   else{
									   html += '<td style="border-top:0; width: 87px;"  align="center"><input  align="center" class="cpendday"  style = "width :95%; height:100%;" type="text" value="'+cpe+ '"/></td>';
								   }
								   html += '<td hidden style="border-top:0; width: 119px;" align="center"><input  align="center" style = "width :95%; height:100%;"  type="text"  value ="'+item.use_skill+'"/></td>';
								   html += '<td style="border:0; width: 29px;" align="center"></td>';
								   html += '<td style="border-top:0; width: 101px;" align="center">'+item.apid+'</td>';
								   
								   if(item.apid !=pj_id){
									   html += '<td style="border-top:0; width: 86px;" align="center"><input align="center" class="apstartday" style = "width :95%; height:100%;"  type="text" disabled value="'+aps+'"/></td>';
									   html += '<td style="border-top:0; width: 85px;" align="center"><input  align="center" class = "apendday" style = "width :95%; height:100%;"  type="text" disabled value ="'+ape+'"/></td>';
								   }
								   else{
								   html += '<td style="border-top:0; width: 86px;" align="center"><input align="center" class="apstartday"  style = "width :95%; height:100%;"  type="text"  value="'+aps+'"/></td>';
								   html += '<td style="border-top:0; width: 85px;"align="center"><input  align="center" class = "apendday" style = "width :95%; height:100%;" type="text"  value ="'+ape+'"/></td>';
								   }

								   html += '<td style="border-top:0; width: 104px;" align="center"><input  align="center" style = "width :95%; height:100%;"  type="text"  value ="'+item.ap_use_skill+'"/></td>';

								   //2015-01-30 인력배치_거주지 null일 경우 저장 후에 null출력 해결 
								   if(item.e_area==null || item.e_area=='' || item.e_area=="null"){
									   html += '<td style="border-top:0; width: 144px;" align="center">-</td>';
								   }
								   else{
							       html += '<td style="border-top:0; width: 144px;" align="center">'+item.e_area+'</td>';
								   }
								   html += '<td hidden>'+item.apid+'</td>';
								   html += '<td hidden>'+aps+'</td>';
								   html +='<td hidden  style="border-top:0; width: 144px;" align="center" id="state">fixed</td>'
								 
								   
								   html += '</tr>';
								   
						});
				 		html += '</table>';
				 	

				 		var name = document.getElementById("pj_end_day");
				 		name.value = pj_end_day;
				 		
				 		var name = document.getElementById("pj_id_ret");
				 		name.value = pj_id;
				 		
				 
				 		
				 		
						   $("#pjposting_result").html(html);
//						   $(".cpstartday").datepicker();    
						   $(".cpendday").datepicker();
						   $(".apstartday").datepicker();
						   $(".apendday").datepicker();
	   

					},
					error : function(xhr) {
						alert("error html = " + xhr.statusText);
					}
				});
				
	
			},
			error : function(xhr) {
				//alert("error html = " + xhr.statusText);
				alert(errorTX);
				}			
			});
		
		}else if(isOK == false) {
			//alert("배치 일자를 입력하세요.")
			alert(errorTX);
			}

	});*/
	
	/* 저장 후 리스트 refresh
	function refresh(){
		if(document.getElementById("searchid").value!='')document.getElementById("searchid").value='';
		if(document.getElementById("searchprog").value!='')document.getElementById("searchprog").value='al';
		if(document.getElementById("searchstartday").value!='')document.getElementById("searchstartday").value='';
		if(document.getElementById("searchendday").value!='')document.getElementById("searchendday").value='';
		search();
		getpjPostingDetail(pj_id_cur);
		$("#inputname").val('');
		$("#inputperiod_1").val('');
		$("#inputperiod_2").val('');
		$("#division").text('');
		$("#historysave").attr("value","저장");
		document.getElementById("inputname").disabled=false;
		document.getElementById("historydelete").disabled=true;
		//$(".searchResult tr").css("background-color","#FFFFFF");
		
		$(".searchResult tr").css("background-color",function (index, value) {
             if (value == "rgb(199, 196, 255)") {
            return "";
             }
             
         });
		$(".searchResult tr").css("font-weight",function (index, value) {
			if (value == "bold") {
				return "";
			}
			
		});
		
	}*/

});

	
function noSearchrefresh(){
	$("#inputname").val('');
	$("#inputperiod_1").val('');
	$("#inputperiod_2").val('');
	$("#division").text('');
	$("#historysave").attr("value","저장");
	document.getElementById("inputname").disabled=false;
	document.getElementById("historydelete").disabled=true;
	$( "#inputperiod_1" ).datepicker( "option", "maxDate", null);
	$( "#inputperiod_2" ).datepicker( "option", "minDate", null);
//	$(".searchResult tr").css("background-color","#FFFFFF");
	/*$(".searchResult tr").css("background-color",function (index, value) {
        if (value == "rgb(199, 196, 255)") {
       return "";
        }
        
    });*/
	
}

	var pj_id_cur="";
	
		function getpjPostingDetail(pj_id) {
		
			//선택되어 효과적용되있던 tr 효과 해제 
			$(".searchResult tr").css("background-color",function (index, value) {
		        if (value == "rgb(199, 196, 255)") {
		       return "";
		        }
			});
			$(".searchResult tr").css("font-weight",function (index, value) {
				if (value == "bold") {
					return "";
				}
				
			});
//			console.log($(cur_tr));
			
			$("#"+pj_id).css("background-color","#C7C4FF");
			$("#"+pj_id).css("font-weight","bold");
			$("#"+pj_id).focus();
/*			$(cur_tr).css("background-color","#C7C4FF");
			$(cur_tr).css("font-weight","bold");
			$(cur_tr).focus();
			deletelist={};*/
//			getNoPlaceEmpList();
			noSearchrefresh();
			document.getElementById("inputname").disabled=false;
			pj_id_cur=pj_id;
			$.ajax({
				type : "POST",
				url : "/pjposting_Detail.action",
				async : false,
				dataType : "json",
				data : {
					pj_id : pj_id
				},
				
				
				success : function(pjposting_detail) {

				//	var html= '<table id ="posting2" width="1157px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'  // width:1152
					var html='';
					html+='<table class="nohoverTable" style="width:737px" >';
					html+='	<colgroup>';
					html+='<col style="width: 110px;" />';
					html+='<col style="width: 220px;" />';
					html+='<col style="width: 52px;" />';
					html+='<col style="width: 80px;" />';
					html+='<col style="width: 52px;" />';
					html+='<col style="width: 88px;" />';
					html+='<col style="width: *px;" />';
					html+='</colgroup>';
					html+='<tbody>';
					$.each(pjposting_detail.list, function (index, item) {
//								//cps =  item.cpstartday.replace(/-/g, "");
//								//cpe = item.cpendday.replace(/-/g, "");
//								
//								//if(cps > cpe){
//								//	alert("현재 프로젝트 투입 시작일보다 이전입니다. 투입 시작일 보다 이전 일을 선택하세요.")
//							//	}
							 
								/*if(item.cpid == null)
									item.cpid = '';
								if(item.cpstartday == null)
									item.cpstartday = '';
								if(item.cpendday==null)
									item.cpendday='';
								if(item.apstartday==null)
									item.apstartday='';
								if(item.apendday==null)
									item.apendday='';
								if(item.apid.equals("null"));
									item.apid='';
								if(item.apid == null)
									item.apid = '';
								
								if(item.use_skill==null)
									item.use_skill='';
								if(item.ap_use_skill==null)
									item.ap_use_skill='';*/
						
						 		if(item.division == '외주'){
						 			html += "<tr BGCOLOR=#FFC19E onclick=SettingUpdatePJHistory('"+item.name +"','"+item.division+"','"+item.cpstartday+"','"+item.cpendday+"')  style='cursor:pointer'>";}
						 		else{
						 			html += "<tr  onclick=SettingUpdatePJHistory('"+item.name +"','"+item.division+"','"+item.cpstartday+"','"+item.cpendday+"')  style='cursor:pointer'>";
						 		}
								html+='<td>'+item.name+'</td>';
								html+='<td>'+item.cpstartday+" ~ "+item.cpendday+'</td>';
								html+='<td>'+item.division+'</td>';
								if(item.envclass ==null||item.envclass =="null" ||item.envclass ==""){
									html+='<td></td>';
								}
								else {
									html+='<td>'+item.envclass+'</td>';
								}
							    if(item.division == '외주'){
									   html += '<td>'+item.position.substring(1, 3)+'</td>';
							     }
								 else{
									  html += '<td>'+item.grade.substring(1, 3)+'</td>';
								}
							    
							    if(item.skill ==null||item.skill =="null" ||item.skill ==""){
									html+='<td></td>';
								}
							    else {
							    	html+='<td>'+item.skill+'</td>';
							    }
								if(item.e_area==null){
									   html += '<td>-</td>';
								   }
								   else{
//								   html += '<td title="'+item.e_area+'"><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item.e_area+'</div></td></nobr>';
										if(item.e_area.length>8){
							   				html +='<td title="'+item.e_area+'"><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item.e_area+'</div></td></nobr>';
							   			}else{
							   				html +='<td><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item.e_area+'</div></td></nobr>';
							   			}
								   }
								 html += '</tr>';
				
							   
					});
					html+='</tbody>';
			 		html += '</table>';
			 	

			 		/*var name = document.getElementById("pj_end_day");
			 		name.value = pj_end_day;*/
			 		
			/* 		var name = document.getElementById("pj_id_ret");
			 		name.value = pj_id;
			 		*/
			 
			 		
			 		
					   $("#pjposting_result").html(html);

	
//					 setpj_id(pj_id);
					
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}
			});
			
			
			//투입기간 이 현재를 지난 경우 (=투입이력조회)
			$.ajax({
				type : "POST",
				url : "/pjposting_Detail_Past.action",
				async : false,
				dataType : "json",
				data : {
					pj_id : pj_id
				},
				
				
				success : function(pjposting_Detail_Past) {

				//	var html= '<table id ="posting2" width="1157px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'  // width:1152
					var html='';
//					var html='<br/>';
					
				
					if(pjposting_Detail_Past.list!=''||pjposting_Detail_Past.list!=null){
					html+='<table class="nohoverTable" style="width:737px" >';
					html+='	<colgroup>';
					html+='<col style="width: 110px;" />';
					html+='<col style="width: 220px;" />';
					html+='<col style="width: 52px;" />';
					html+='<col style="width: 80px;" />';
					html+='<col style="width: 52px;" />';
					html+='<col style="width: 88px;" />';
					html+='<col style="width: *px;" />';
					html+='</colgroup>';
					html+='<tbody>';
					 var count=1;
					$.each(pjposting_Detail_Past.list, function (index, item) {
							
						// 과거에 배치됬던 사람과 현재, 미래 배치된 사람 구분 
							if(count==1)html+='<tr BGCOLOR=#B26936 ><td  colspan="7"></td></tr>';
						
							
							if(item.division == '외주'){
						 			html += "<tr BGCOLOR=#FFC19E onclick=SettingUpdatePJHistory('"+item.name +"','"+item.division+"','"+item.cpstartday+"','"+item.cpendday+"')  style='cursor:pointer'>";}
						 		else{
						 			html += "<tr  onclick=SettingUpdatePJHistory('"+item.name +"','"+item.division+"','"+item.cpstartday+"','"+item.cpendday+"')  style='cursor:pointer'>";
						 		}
								html+='<td>'+item.name+'</td>';
								html+='<td>'+item.cpstartday+" ~ "+item.cpendday+'</td>';
								html+='<td>'+item.division+'</td>';
								if(item.envclass ==null||item.envclass =="null" ||item.envclass ==""){
									html+='<td></td>';
								}
								else {
									html+='<td>'+item.envclass+'</td>';
								}
							    if(item.division == '외주'){
									   html += '<td>'+item.position.substring(1, 3)+'</td>';
							     }
								 else{
									  html += '<td>'+item.grade.substring(1, 3)+'</td>';
								}
							    
							    if(item.skill ==null||item.skill =="null" ||item.skill ==""){
									html+='<td></td>';
								}
							    else {
							    	html+='<td>'+item.skill+'</td>';
							    }
								if(item.e_area==null){
									   html += '<td>-</td>';
								   }
								   else{
										if(item.e_area.length>8){
							   				html +='<td title="'+item.e_area+'"><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item.e_area+'</div></td></nobr>';
							   			}else{
							   				html +='<td><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item.e_area+'</div></td></nobr>';
							   			}
								   }
								 html += '</tr>';
				
							   count++;
					});
					html+='</tbody>';
			 		html += '</table>';
			 	

			 
			 		
			 		
					   $("#pjposting_history").html(html);

					}
					
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}
			});
	
			
		}

		
	//현재 배치대상자의 사람 클릭하면 입력 칸에 자동 값 setting -> 수정 삭제 가능해짐 
function SettingUpdatePJHistory(name,division,startday,endday){
	
	$("#inputname").val(name);
	$("#inputperiod_1").val(startday);
	$("#inputperiod_2").val(endday);
	$("#division").html(division);
	$("#historysave").attr("value","수정");
	document.getElementById("inputname").disabled=true;
	document.getElementById("historydelete").disabled=false;
	$( "#inputperiod_1" ).datepicker( "option", "maxDate", endday);
	$( "#inputperiod_2" ).datepicker( "option", "minDate", startday);
}


/* 배치대상자 리스트		
function getNoPlaceEmpList(){
	$.ajax({
		type : "POST",
		url : "/getNoPlaceEmpList.action",
		async : false,
		dataType : "json",
		data : {
		},
		success : function(data) {
			var list = data.list;
			var   html = "";
			$.each(list, function (index, item) {		      
				   html += '<tr>';
				   html += '<td style="border-top:0; width: 21px;" align="center"><input type="checkbox"></td>';
				   html += '<td style="border-top:0; width: 106px;" align="center">'+item.name+'</td>';
				   html += '<td style="border-top:0; width: 50px;" align="center">'+item.division+'</td>';
				   html += '<td style="border-top:0; width: 82px;" align="center">'+'기반분류'+'</td>';
				   html += '<td style="border-top:0; width: 50px;" align="center">'+item.grade.substring(1,3)+'</td>';
				   html += '<td style="border-top:0; width: 82px;" align="center">'+'전문기술'+'</td>';
				   if(item.e_area==null){
					   html += '<td style="border-top:0; width: 135px;" align="center">-</td>';
				   }
				   else{
			       html += '<td style="border-top:0; width: 135px;" align="center">'+item.e_area+'</td>';
				   }
				   html += '<td style="border:0; width: 65px;" align="center">'+""+'</td>';
				   html += '<td style="border-top:0; width: 120px;" align="center" id="cpid">'+""+'</td>';
//			       html += '<td style="border-top:0; width: 97px;" align="center">'+item.cpstartday+'</td>';
				   html += '<td style="border-top:0; width: 115px;" align="center" id="cpendday">'+""+'</td>';
				   html += '<td hidden style="border-top:0; width: 120px;" align="center" id="use_skill">'+""+'</td>';
				   html += '<td style="border:0; width: 35px;" align="center">'+""+'</td>';
				   html += '<td style="border-top:0; width: 120px;" align="center" id="apid">'+""+'</td>';
				   html += '<td style="border-top:0; width: 97px;" align="center" id="apendday">'+""+'</td>';
				   html += '<td hidden style="border-top:0;" align="center">'+item.skill_name+'</td>';
				   
				   html += '</tr>';
				   
				   $("#posting1_tbd").html(html);
				   
					//move down 시 배치 대상자의 상단부에 오던 배치 취소대상자들목록 refresh
				   $("#posting1_tbd_movedown").html("");
				   
				
			});
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}
*/

// 검색 
// 프로젝트맵핑인원(배치된인력수) 보여줘야 함  , 개발자 와 사용자 모두에게 직관성 떨어지므로 추가해야하는 항목 
function search(){
	$.ajax({
		type : "POST", 
		url:"/pjposting_Search.action",
		async : true,
		dataType : "json",
		data:{				
			
			search_id:$("#searchid").val(),
			search_prog:$("#searchprog").val(),
			search_startday:$("#searchstartday").val(),
			search_endday:$("#searchendday").val()

		},

		success : function(search) {		
		$.each(search, function (index, item) {
		
			var html='';
			html+='<table class="searchResult" style="width:617px" >';
			html+='	<colgroup>';
			html+='<col style="width: 57px;" />';
			html+='<col style="width: 96px;" />';
			html+='<col style="width: 185px;" />';
			html+='<col style="width: 50px;" />';
			html+='<col style="width: 50px;" />';
			html+='<col style="width: 125px;" />';
			html+='</colgroup>';
			html+='<tbody " >';
			//var html='<table width="400px"  cellspacing="1" cellpadding="0" border="0" class="hoverTable">'
			  for (var i=0; i<item.length; i++){
				  var id="140"+i;
//				   html += '<tr style="cursor:pointer;" id="'+id+'" onclick="getpjPostingDetail('+id+', '+item[i].id + ')">';
				/*   html += "<tr onclick=getpjPostingDetail('" + item[i].pj_id + "') style='cursor:pointer'>";
				   html += '<td style="border-top:0; width: 55px" align="center">'+item[i].pj_prog+'</td>';
				   html += '<td style="border-top:0; width: 95px" align="center">'+item[i].pj_id+'</td>';
				   html += '<td style="border-top:0; width: 210px" align="center">'+item[i].pj_start_day+"~"+item[i].pj_end_day+'</td>';
				   if (item[i].peoplenum == null)
					   item[i].peoplenum = 0;
				   html += '<td style="border-top:0; width: 40px" align="center">'+item[i].peoplenum+'</td>';
				   html += '</tr>';*/
				   //html += '<tr style="cursor:pointer;" id="'+id+'" onclick="getpjPostingDetail('+id+', '+item[i].id + ')">';
			   		html += "<tr id='"+ item[i].pj_id +"' onclick=getpjPostingDetail('" + item[i].pj_id + "') style='cursor:pointer'>";
//			   		html += "<tr id='"+ item[i].pj_id +"' onclick=getpjPostingDetail('" + item[i].pj_id + "',this) style='cursor:pointer'>";
			   		html += '<td>'+item[i].pj_prog+'</td>';
			   		html += '<td >'+item[i].pj_id+'</td>';
			   		html += '<td >'+item[i].pj_start_day+"~"+item[i].pj_end_day+'</td>';
			/*   if (item[i].peoplenum == null)
				   item[i].peoplenum = 0;
			   html += '<td style="border-top:0; width: 40px" align="center">'+item[i].peoplenum+'</td>';*/
			   		if(item[i].pj_require==null || item[i].pj_require=='' || item[i].pj_require=="null"){
			   			html += '<td >-</td>';
			   		}
			   		else{
			   			html+= '<td >'+item[i].pj_require+'<nobr></td>';
			   		}
			   		html+= '<td>'+item[i].peoplenum+'</td>';
			   		if(item[i].pj_loc==null || item[i].pj_loc=='' || item[i].pj_loc=="null"){
						html += '<td class="pj_loc">-</td>';
					}
			   		else{ 
//			   			html+= '<td title="'+item[i].pj_loc+'"><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item[i].pj_loc+'</div></td></nobr>';
//			   			html+= '<td id="'+item[i].pj_id+'_loc" ><nobr><div  style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item[i].pj_loc+'</div></td></nobr>';
//			   			var tmp = '<td><nobr><div  style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item[i].pj_loc+'</div></td></nobr>';
			   			if(item[i].pj_loc.length>8){
			   				html +='<td title="'+item[i].pj_loc+'"><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item[i].pj_loc+'</div></td></nobr>';
			   			}else{
			   				html +='<td><nobr><div style="width:125px;height:21px;text-overflow: ellipsis; overflow: hidden;" align="center">'+item[i].pj_loc+'</div></td></nobr>';
			   			}
			   		}
			   		html += '</tr>';
			      }
			  html+='<tbody >';
			  html += '</table>';
			  $("#search_result").html(html);
			  
			  $.each($("#search_result table tr"),function(index, item){
				/*  console.log($(item).eq(5).offsetWidth);
				  console.log($(item).eq(5).scrollWidth);*/
			  });
			
		});
					
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
			}			
		});
}




/*function pjpostingcancle(){
	
	location.reload(true);
};
*/
	
function calendar1() {
	$.datepicker.regional['ko'] = {
		closeText : '닫기',
		prevText : '이전달',
		nextText : '다음달',
		currentText : '오늘',
		monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)',
				'5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)', '9월(SEP)',
				'10월(OCT)', '11월(NOV)', '12월(DEC)' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		weekHeader : 'Wk',
		dateFormat : 'yy-mm-dd',
		firstDay : 0,
		isRTL : false,
		showMonthAfterYear : true,
		yearSuffix : '',
		//         showOn: 'both',
		//         buttonText: "달력",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true,
		yearRange : 'c-99:c+99',
	};
	$.datepicker.setDefaults($.datepicker.regional['ko']);
	
}
/*function OpenWindow(url, intWidth, intHeight) {
	winObject = window.open(url, "_blank", "width=" + intWidth + ",height="
			+ intHeight + ", resizable=no, scrollbars=no");
}
function Arraycontains (elements,element) {
	var res;
	for (var i = 0; i < elements.length; i++) {

		if (elements[i] == element) {
			return true;
		}
	}

	return false;

}
*/