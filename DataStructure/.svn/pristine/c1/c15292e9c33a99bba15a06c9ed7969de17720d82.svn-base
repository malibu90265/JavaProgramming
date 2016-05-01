//배치 취소할 경우 pj_history 에서 삭제하기 위하여 삭제할 인원 정보를 담는 배열 
var deletelist={};

//errotTX -> 저장이 안됬을떄 문제 메세지를 다르게 하여 사용자에게 확인 시키게 하기 위하여 변수 선언 
// 다른 문제 발생시 각각 다른 글 출력 
var erroTX="";
$(document).ready(function(){
	
	search();
	getNoPlaceEmpList();
	
	//2015-01-27 추가 자동검색 
	$("#searchprog").change(function(){search()});
	$("#searchid").keyup(function(){search()});
	$("#searchstartday").change(function(){search()});
	$("#searchendday").change(function(){search()});
	
	$('#pjsearchbutton').click(function(){
		search();
		
		
	});

	
	$('#pjpostingsave').click(function(){
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
			/*
		$.ajax({//ap(배치예정 PJ)의 해당 정보 null 처리 
			type : "POST", 
			url:"/pjposting_Insert_bp.action",
			async : true,
			dataType : "json",
			data:{				
				pj_id:$("#pj_id_ret").val()
			},

			success : function() {
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
				}			
			});
*/
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
			/*data:{
				'deletelist':deletelist
			},*/
			/*
			 data:{
				deletelist:JSON.stringify(deletelist),
				division : $(v).children().eq(1).html()
			},
			*/
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
		/*$.ajax({//대기세팅 , 배치 예정중이던 인력 배치 취소 경우 pj_history 에서 삭제(move down)
			type : "POST", 
			url:"/pjposting_Insert_ap.action",
			async : true,
			dataType : "json",
			data:{				
				pj_id:$("#pj_id_ret").val()		//  pj기간 계산해서 pj_id="대기" insert하는 메소드실행 시 필요(없을 시 실행 x)
			},

			success : function() {*/
				alert("저장되었습니다.");
				refresh();
				getNoPlaceEmpList();
//				window.location.replace('http://localhost:8080/pjposting.do?pj_id='+$("#pj_id_ret").val())
				/*$.ajax({
					type : "POST",
					url : "/getNoPlaceEmpList.action",
					async : false,
					dataType : "json",
					data : {
					},
					success : function(data) {
						var list = data.list;
						var html = "";
						$.each(list, function (index, item) {
						
							   html += '<tr>';
							   html += '<td style="border-top:0; width: 21px;" align="center"><input type="checkbox"></td>';
							   html += '<td style="border-top:0; width: 106px;" align="center">'+item.name+'</td>';
							   html += '<td style="border-top:0; width: 72px;" align="center">'+item.division+'</td>';
							   html += '<td style="border-top:0; width: 72px;" align="center">'+item.grade.substring(1,3)+'</td>';
							   html += '<td style="border-top:0; width: 120px;" align="center">'+item.cpid+'</td>';
							   html += '<td style="border-top:0; width: 115px;" align="center">'+item.cpendday+'</td>';
							   html += '<td hidden style="border-top:0; width: 120px;" align="center">'+item.use_skill+'</td>';
							   html += '<td style="border:0; width: 75px;" align="center">'+""+'</td>';
							   html += '<td style="border-top:0; width: 120px;" align="center">'+item.apid+'</td>';
							   html += '<td style="border-top:0; width: 97px;" align="center">'+item.apstartday+'</td>';
							   html += '<td style="border-top:0;" align="center">'+item.skill_name+'</td>';
							   if(item.e_area==null || item.e_area=='' || item.e_area=="null"){
								   html += '<td style="border-top:0; width: 135px;" align="center">-</td>';
							   }
							   else{
						       html += '<td style="border-top:0; width: 135px;" align="center">'+item.e_area+'</td>';
							   }
							   html += '</tr>';
							   
							   $("#posting1_tbd").html(html);

						});
					},
					error : function(xhr) {
						alert("error html = " + xhr.statusText);
					}
				});
				*/
				
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
						
						/*
							var html= '<table border="1"  class="nohoverTable" id="info" style="width: 650px; margin-bottom: 10px;">'; 
							   html += '<tr>';
							   html += '<th align="center" style="width: 195px;" colspan="3">프로젝트 ID</th>';
							   html += '<td align="center" colspan="3" id="pj_id">' + pj_id + '</td>';
							   html += '<th align="center" style="width: 195px;" colspan="3">요구인원 수</th>';
							   html += '<td align="center" >' + peoplenum + '</td>';
							   html += '<p>';
							   html += '</tr>';
							   html += '<tr>';
							   html += '<th align="center" style="width: 65px;">특</th>';
							   html += '<td align="center" style="width: 65px;">' + special + '</td>';
							   html += '<th align="center" style="width: 65px;">고</th>';
							   html += '<td align="center" style="width: 65px;">' + advanced + '</td>';
							   html += '<th align="center" style="width: 65px;">중</th>';
							   html += '<td align="center" style="width: 65px;">' + intermidate + '</td>';
							   html += '<th align="center" style="width: 65px;">초</th>';
							   html += '<td align="center" style="width: 65px;">' + beginner + '</td>';
							   html += '<th align="center" style="width: 65px;">기능</th>';
							   html += '<td align="center" style="width: 65px;">' + engineer + '</td>';
							   html += '</tr>';
							   html += '<tr>';
							   html += '<th align="center" style="width: 130px; height: 63px" colspan="2">기술환경</th>';
							   html += '<td align="center" style="width: 520px" colspan="8">' + pj_needs_skill + '</td>';
							   html += '</tr>';
							   html += '<tr>';
							   html += '<th align="center" style="width: 130px" colspan="2">프로젝트 기간</th>';
							   html += '<td align="center" colspan="4" >' + pj_period + '</td>';
							   html += '<th align="center" style="width: 130px;" colspan="2">근무지</th>';
							   html += '<td style="text-overflow: ellipsis; overflow: hidden;" align="center" colspan="2"><nobr>' +  pj_loc + '<nobr></td>';
							   html += '</tr/>';
								   
							 
							   html += '</table>';
							   $("#pj_detail_res").html(html);
							*/
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
				
	
		/*	},
			error : function(xhr) {
				//alert("error html = " + xhr.statusText);
				alert(errorTX);
				}			
			});
		*/
		}else if(isOK == false) {
			//alert("배치 일자를 입력하세요.")
			alert(errorTX);
			}

	});
	
	// 저장 후 리스트 refresh
	function refresh(){
		if(document.getElementById("searchid").value!='')document.getElementById("searchid").value='';
		if(document.getElementById("searchprog").value!='')document.getElementById("searchprog").value='al';
		if(document.getElementById("searchstartday").value!='')document.getElementById("searchstartday").value='';
		if(document.getElementById("searchendday").value!='')document.getElementById("searchendday").value='';
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
			
				// alert("refresh!!");
				var html = '<table width="400px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'
				   
				   for (var i=0; i<item.length; i++){
//						   var id="140"+i;
//						   html += '<tr style="cursor:pointer;" id="'+id+'" onclick="getpjPostingDetail('+id+', '+item[i].id + ')">';
						   html += "<tr onclick=getpjPostingDetail('" + item[i].pj_id + "') style='cursor:pointer'>";
						   html += '<td style="border-top:0; width: 55px" align="center">'+item[i].pj_prog+'</td>';
						   html += '<td style="border-top:0; width: 95px" align="center">'+item[i].pj_id+'</td>';
						   html += '<td style="border-top:0; width: 210px" align="center">'+item[i].pj_start_day+"~"+item[i].pj_end_day+'</td>';
						   if (item[i].peoplenum == null)
							   item[i].peoplenum = 0;
						   html += '<td style="border-top:0; width: 40px" align="center">'+item[i].peoplenum+'</td>';
						   html += '</tr>';
					      }
					  		html += '</table>';
					   $("#search_result").html(html);
				   
				
			});
						
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
				}			
			});
	}

});

	




		function getpjPostingDetail(pj_id) {
			deletelist={};
			getNoPlaceEmpList();
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
					var pn_num=pjposting_detail.vo.pn_num;
					var pj_require=pjposting_detail.vo.pj_require;
					var pj_start_day=pjposting_detail.vo.pj_start_day;
					var pj_end_day=pjposting_detail.vo.pj_end_day;
					$("#pj_id").html(pj_id);
					$("#pj_require").html(pj_require);
					$("#pj_loc").html(pj_loc);
					$("#pj_num").html(pn_num);
					$("#pj_period").html(pj_start_day+" - "+pj_end_day);
					$(".needsTable").attr('class','nohoverTable');
					$("#pj_loc").attr('title',pj_loc);
					var html="";
			
					html+='<table border="1" class="nohoverTable">';
					html+='<colgroup>';
					html+='<col style="width: 27px;" />';
					html+='<col style="width: 78px;" />';
					html+='<col style="width: 78px;" />';
					html+='<col style="width: 225px;" />';
					html+='<col style="width: 241px;" />';
					html+='</colgroup>';
					html+='<tbody>';
					var detailVO = pjposting_detail.pn_list;
						$(detailVO).each(function(k,v){
							console.log(k+","+v);
							html+='<tr><td style="border-top:0" align="center"><input type="checkbox"/></td>'
						   html += '<td style="border-top:0" align="center">'+detailVO[k].pn_num+'</td>';
							html += '<td style="border-top:0" align="center">'+detailVO[k].pn_grade+'</td>';
							html += '<td style="border-top:0" align="center">'+detailVO[k].pn_skill+'</td>';
							html += '<td style="border-top:0" align="center">'+detailVO[k].pn_day_from+" - "+detailVO[k].pn_day_to+'</td>';
							
						/*$(v).find("[name=pn_num]").text(detailVO[k].pn_num);
						$(v).find("select[name=pn_grade]").val(detailVO[k].pn_grade);
						$(v).find("select[name=pn_skill]").val(detailVO[k].pn_skill);
						$(v).find("input[name=needstartday]").val(detailVO[k].pn_day_from);
						$(v).find("input[name=needendday]").val(detailVO[k].pn_day_to);
						*/});
						html+="</tbody>";
						html+="</table>";
						$("#pj_need_detail").html(html);
					/*
					$.each(pjposting_detail, function (index, item) {
						
							var html= '<table border="1"  class="nohoverTable" id="info" style="width: 650px; margin-bottom: 10px;">'; 
						   html += '<tr>';
						   html += '<th align="center" style="width: 195px;" colspan="3">프로젝트 ID</th>';
						   html += '<td align="center" colspan="3" id="pj_id">' + pj_id + '</td>';
						   html += '<th align="center" style="width: 195px;" colspan="3">요구인원 수</th>';
						   html += '<td align="center" >' + peoplenum + '</td>';
						   html += '<p>';
						   html += '</tr>';
						   html += '<tr>';
						   html += '<th align="center" style="width: 65px;">특</th>';
						   html += '<td align="center" style="width: 65px;">' + special + '</td>';
						   html += '<th align="center" style="width: 65px;">고</th>';
						   html += '<td align="center" style="width: 65px;">' + advanced + '</td>';
						   html += '<th align="center" style="width: 65px;">중</th>';
						   html += '<td align="center" style="width: 65px;">' + intermidate + '</td>';
						   html += '<th align="center" style="width: 65px;">초</th>';
						   html += '<td align="center" style="width: 65px;">' + beginner + '</td>';
						   html += '<th align="center" style="width: 65px;">기능</th>';
						   html += '<td align="center" style="width: 65px;">' + engineer + '</td>';
						   html += '</tr>';
						   html += '<tr>';
						   html += '<th align="center" style="width: 130px; height: 63px" colspan="2">기술환경</th>';
						   html += '<td align="center" style="width: 520px" colspan="8">' + pj_needs_skill + '</td>';
						   html += '</tr>';
						   html += '<tr>';
						   html += '<th align="center" style="width: 130px" colspan="2">프로젝트 기간</th>';
						   html += '<td align="center" colspan="4" >' + pj_period + '</td>';
						   html += '<th align="center" style="width: 130px;" colspan="2">근무지</th>';
						   if(pj_loc == null){
							   html += '<td style="text-overflow: ellipsis; overflow: hidden;" align="center" colspan="2"><nobr>-<nobr></td>';
						   }
						   else{
						   html += '<td style="text-overflow: ellipsis; overflow: hidden;" align="center" colspan="2"><nobr>' +  pj_loc + '<nobr></td>';
						   }
						   html += '</tr/>';
							   
						 
						   html += '</table>';
						   $("#pj_detail_res").html(html);
						
					   
					});
					*/	




					var html= '<table id ="posting2" width="1152px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'  // width:1152
					$.each(pjposting_detail.list, function (index, item) {
//								//cps =  item.cpstartday.replace(/-/g, "");
//								//cpe = item.cpendday.replace(/-/g, "");
//								
//								//if(cps > cpe){
//								//	alert("현재 프로젝트 투입 시작일보다 이전입니다. 투입 시작일 보다 이전 일을 선택하세요.")
//							//	}
							 
								if(item.cpid == null)
									item.cpid = '';
								if(item.cpstartday == null)
									item.cpstartday = '';
								if(item.cpendday==null)
									item.cpendday='';
								if(item.apstartday==null)
									item.apstartday='';
								if(item.apendday==null)
									item.apendday='';
								/*if(item.apid.equals("null"));
									item.apid='';*/
								if(item.apid == null)
									item.apid = '';
								
								if(item.use_skill==null)
									item.use_skill='';
								if(item.ap_use_skill==null)
									item.ap_use_skill='';
							
								
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
						       html += '<td style="border-top:0; width: 86px;"  align="center"><input  align="center" class="cpstartday"  style = "width :95%; height:100%;" type="text" disabled value="'+item.cpstartday+ '"/></td>';
//							   html += '<td style="border-top:0; width: 87px;"  align="center"><input  align="center" class="cpendday"  style = "width :95%; height:100%;" type="text" value="'+item.cpendday+ '"/></td>';
						       if(item.cpid !=pj_id){
							       html += '<td style="border-top:0; width: 87px;"  align="center"><input  align="center" class="cpendday"  style = "width :95%; height:100%;" type="text" disabled value="'+item.cpendday+ '"/></td>';
							   }
							   else{
								   html += '<td style="border-top:0; width: 87px;"  align="center"><input  align="center" class="cpendday"  style = "width :95%; height:100%;" type="text" value="'+item.cpendday+ '"/></td>';
							   }
						       html += '<td hidden style="border-top:0; width: 119px;" align="center"><input  align="center" style = "width :95%; height:100%;"  type="text"  value ="'+item.use_skill+'"/></td>';
							   html += '<td style="border:0; width: 29px;" align="center">'+""+'</td>';
							   html += '<td style="border-top:0; width: 101px;" align="center">'+item.apid+'</td>';
							   
							   if(item.apid !=pj_id){
								   html += '<td style="border-top:0; width: 86px;" align="center"><input align="center" class="apstartday" style = "width :95%; height:100%;"  type="text" disabled value="'+item.apstartday+'"/></td>';
								   html += '<td style="border-top:0; width: 85px;" align="center"><input  align="center" class = "apendday" style = "width :95%; height:100%;"  type="text" disabled value ="'+item.apendday+'"/></td>';
							   }
							   else{
							   html += '<td style="border-top:0; width: 86px;" align="center"><input align="center" class="apstartday"  style = "width :95%; height:100%;"  type="text"  value="'+item.apstartday+'"/></td>';
							   html += '<td style="border-top:0; width: 85px;"align="center"><input  align="center" class = "apendday" style = "width :95%; height:100%;" type="text"  value ="'+item.apendday+'"/></td>';
							   }

							   html += '<td style="border-top:0; width: 104px;" align="center"><input  align="center" style = "width :95%; height:100%;"  type="text"  value ="'+item.ap_use_skill+'"/></td>';
							   if(item.e_area==null){
								   html += '<td style="border-top:0; width: 144px;" align="center">-</td>';
							   }
							   else{
							   html += '<td style="border-top:0; width: 144px;" align="center">'+item.e_area+'</td>';
							   }
									 
							   html += '<td hidden>'+item.apid+'</td>';
							   html += '<td hidden>'+item.apstartday+'</td>';
							   html +='<td hidden id="state">fixed</td>'
							   html +='<td hidden>' + item.cpstartday + '</td>';
//							   html += '<td hidden>'+item.apid+'</td>';
//							   html += '<td hidden class = "cpstartday">'+item.cpstartday+'</td>';
							   html += '</tr>';
							   
							   
					});
			 		html += '</table>';
			 	

			 		var name = document.getElementById("pj_end_day");
			 		name.value = pj_end_day;
			 		
			 		var name = document.getElementById("pj_id_ret");
			 		name.value = pj_id;
			 		
			 
			 		
			 		
					   $("#pjposting_result").html(html);

					   
				//	  $(".cpstartday").datepicker();
					   $(".cpendday").datepicker();
					   $(".apstartday").datepicker();
					   $(".apendday").datepicker();
					   
//					 setpj_id(pj_id);
					
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}
			});
			
	
			
		}
		
		
// 배치대상자 리스트		
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
				   html += '<td style="border-top:0; width: 72px;" align="center">'+item.division+'</td>';
				   html += '<td style="border-top:0; width: 72px;" align="center">'+item.grade.substring(1,3)+'</td>';
				   html += '<td style="border-top:0; width: 120px;" align="center" id="cpid">'+""+'</td>';
//			       html += '<td style="border-top:0; width: 97px;" align="center">'+item.cpstartday+'</td>';
				   html += '<td style="border-top:0; width: 115px;" align="center" id="cpendday">'+""+'</td>';
				   html += '<td hidden style="border-top:0; width: 120px;" align="center" id="use_skill">'+""+'</td>';
				   html += '<td style="border:0; width: 75px;" align="center">'+""+'</td>';
				   html += '<td style="border-top:0; width: 120px;" align="center" id="apid">'+""+'</td>';
				   html += '<td style="border-top:0; width: 97px;" align="center" id="apendday">'+""+'</td>';
				   html += '<td style="border-top:0;" align="center">'+item.skill_name+'</td>';
				   if(item.e_area==null){
					   html += '<td style="border-top:0; width: 135px;" align="center">-</td>';
				   }
				   else{
			       html += '<td style="border-top:0; width: 135px;" align="center">'+item.e_area+'</td>';
				   }
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


// 검색 
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
		

			var html='<table width="400px"  cellspacing="1" cellpadding="0" border="0" class="hoverTable">'
			  for (var i=0; i<item.length; i++){
//				  var id="140"+i;
//				  html += '<tr style="cursor:pointer;" id="'+id+'" onclick="getpjPostingDetail('+id+', '+item[i].id + ')">';
				  html += "<tr onclick=getpjPostingDetail('" + item[i].pj_id + "') style='cursor:pointer'>";
				   html += '<td style="border-top:0; width: 55px" align="center">'+item[i].pj_prog+'</td>';
				   html += '<td style="border-top:0; width: 95px" align="center">'+item[i].pj_id+'</td>';
				   html += '<td style="border-top:0; width: 210px" align="center">'+item[i].pj_start_day+"~"+item[i].pj_end_day+'</td>';
				   if (item[i].peoplenum == null)
					   item[i].peoplenum = 0;
				   html += '<td style="border-top:0; width: 40px" align="center">'+item[i].peoplenum+'</td>';
				   html += '</tr>';
			      }
			  		html += '</table>';
			   $("#search_result").html(html);
			
		});
					
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
			}			
		});
}


// 인원검색 팝업 및 배치 대상자로 추가리스팅
function check(result) {
	$('#pjposting_ret tbody',winObject.document).empty();
	$.ajax({
		type : "POST",
		url : "/emppjposting_Search.action",
		async : false,
		dataType : "json",
		data : {
			
			name : result.name,
			division : result.division,
			grade : result.grade,
			area1:result.area1,
			area2:result.area2,
			groupcd : result.groupcd,
			skillcd : result.skillcd,
			endday : result.endday
		
		},
		
//		complete : function(a,b){
//			console.log(a);
//			console.log(b);
//		},
		
		success : function(pjposting_detail) {
			
		       var names=new Array();
		      names[0]="1";
		       
$.each(pjposting_detail, function (index, item) {
				
				//배치대상자에 출력되는 사람 제외 	
				var hasName = false;
					for (var i=0; i<item.length; i++){
						$("tr","#posting1_tbd").each(function(k,v){
							if($(v).children().eq(1).html() == item[i].name) {
							hasName = true;
						}
					})
					$("tr","#posting2").each(function(k,v){
							if($(v).children().eq(1).html() == item[i].name) {
							hasName = true;
						}
					})
					if (hasName == false) {
						
						//중복제거
						if(Arraycontains(names,item[i].name)==false){
							names.push(item[i].name);
						
							var html = '';
							html += '<tr>';
							html += '<td  style="border-top:0; width: 21px;" align="center"><input type="checkbox" /></td>';
							html += '<td  style="border-top:0; width: 106px;" align="center" >'+item[i].name+'</td>';
							html += '<td style="border-top:0; width: 72px;" align="center">'+item[i].division+'</td>';
							html += '<td style="border-top:0; width: 72px;" align="center">'+item[i].grade.substring(1, 3)+'</td>';
							if(item[i].cpid ==null || item[i].cpendday==null){//외주인 경우 대기개념이 없어  cpid 가 null 일수 있다. null 이면 '-'출력
								html += '<td hidden style="border-top:0; width: 120px;" align="center">-</td>';
								html += '<td hidden style="border-top:0; width: 115px;" align="center">-</td>';
							}
							else{
							html += '<td hidden style="border-top:0; width: 120px;" align="center">'+item[i].cpid+'</td>';
						//	html += '<td hidden style="border-top:0; width: 97px;" align="center">'+item[i].cpstartday+'</td>';
							html += '<td hidden style="border-top:0; width: 115px;" align="center">'+item[i].cpendday+'</td>';
							}		
							if(item[i].use_skill==null||item[i].use_skill==''){
								html += '<td hidden style="border-top:0; width: 120px;" align="center">-</td>';
							}
							else{
								html += '<td hidden style="border-top:0; width: 120px;" align="center">'+item[i].use_skill+'</td>';
							}
							html += '<td hidden style="border:0;  width: 75px;" align="center"></td>';
							if(item[i].apid ==null || item[i].apstartday==null){//외주인 경우  대기개념이 없어  apid가 null 일수 있다. null 이면 '-'출력 
								html += '<td hidden style="border-top:0; width: 120px;" align="center">-</td>';
								html += '<td hidden style="border-top:0; width: 97px;" align="center">-</td>';
							}
							else{
							html += '<td hidden style="border-top:0; width: 120px;" align="center">'+item[i].apid+'</td>';
							html += '<td hidden style="border-top:0; width: 97px;" align="center">'+item[i].apstartday+'</td>';
							}
							html += '<td style="border-top:0;" align="center">'+item[i].skill_name+'</td>';			
							if(item[i].e_area==null || item[i].e_area=='' || item[i].e_area=="null"){
								html += '<td hidden style="border-top:0; width: 135px;" align="center">-</td>';
							}
							else{
								html += '<td hidden style="border-top:0; width: 135px;" align="center">'+item[i].e_area+'</td>';
							}
							
							html += '<td hidden>' + item[i].cpstartday + '</td>';
							html += '</tr>';
							
							$('.searchcpendday').datepicker();
					
						$('#pjposting_ret_tbd', winObject.document).append(html);
						
						}
					} else {
						hasName = false;
					}
						
				}
					
			});
			
},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}	

/* 팝업 자동 검색 .ready 안에 없어서 실행되지 않음 
$("#searchdiv").change (function() {check(result) });
$("#searchetc").change (function() {check(result) });
$("#searchendday").change (function() {check(result) });
$("#search").change (function() {check(result) });
$("#area100").change (function() {check(result) });
$("#area100_1").change (function() {check(result) });
$("#skill100").change (function() {check(result) });
$("#skill100_1").change (function() {check(result) });
*/


function CheckDown(winObject){
$("tr","#pjposting_ret_tbd").each(function(k,v){
	if($(v).children().eq(0).find("input").attr("checked") =="checked"){
			var html = '';
			html += '<tr>';
			html+='<td style="border-top:0; width: 21px;" align="center">' + $(v).children().eq(0).html()+'</td>';
			html+='<td style="border-top:0; width: 80px;" align="center">' + $(v).children().eq(1).html() +'</td>';
			html+='<td style="border-top:0; width: 88px;" align="center">' + $(v).children().eq(2).html() +'</td>';
			html+='<td style="border-top:0; width: 55px;" align="center">' + $(v).children().eq(3).html() +'</td>';
			if($(v).children().eq(4).html()==null){
				$(v).children().eq(4).html('')
			}
			html+='<td style="border-top:0; width: 110px;" align="center">' + $(v).children().eq(4).html() +'</td>';
			if($(v).children().eq(5).html()==null){
				$(v).children().eq(5).html('')
			}
			html+='<td  style="border-top:0; width: 97px;" align="center">' + $(v).children().eq(5).html() +'</td>';
			html+='<td  hidden style="border-top:0; width: 120px;" align="center" >' + $(v).children().eq(6).html() +'</td>';
			html+='<td style="border:0; background-coler:white; width: 120px;" align="center">' + $(v).children().eq(7).html() +'</td>';
			html+='<td  style="border-top:0; width: 110px;" align="center">' + $(v).children().eq(8).html() +'</td>';
			html+='<td  style="border-top:0; width: 97px;" align="center">' + $(v).children().eq(9).html() +'</td>';
			html+='<td style="border-top:0;" align="center">' + $(v).children().eq(10).html() +'</td>';
			html+='<td  style="border-top:0; width: 120px;" align="center">' + $(v).children().eq(11).html() +'</td>';
			html+= '</tr>';
			
			 $('#posting1_tbd', opener.document).append(html);
			 
			 $(v).remove();
		}	
	
	

});

}


function pjpostingcancle(){
	
	location.reload(true);
};


// 투입이력조회 팝업
function getPjHistory(){
	//alert("load");
	var pj_id=$("#pj_id_ret").val();

	$('#pjposting_history tbody',winObject.document).empty();
	$.ajax({
		type : "POST", 
		url:"/getPjHistory.action",
		async : false,
		dataType : "json",
		data:{				
			
			pj_id:pj_id

		},

		success : function(pjposting_getPjHistory) {	
			
			//alert("함수 내부 접근 성공"+pj_id);
			var name = pjposting_getPjHistory.list.name;
			var position =pjposting_getPjHistory.list.position;
			var grade = pjposting_getPjHistory.list.grade;
			var salary=pjposting_getPjHistory.list.salary;
			var pj_start_day=pjposting_getPjHistory.list.pj_start_day;
			var pj_end_day=pjposting_getPjHistory.list.pj_end_day;
			var str="";
			var html="";
		$.each(pjposting_getPjHistory, function (index, item) {
			
			
		   for(var i=0;i<item.length;i++){ 
			   if(item[i].position=='특급'||item[i].position=='고급'||item[i].position=='중급'||item[i].position=='초급')
				   html += '<tr bgcolor="FFC19E">';
			   else
				   html += '<tr>';
			   html += '<td style="border-top:0; width: 101px;" align="center">'+item[i].name+'</td>';
			   html += '<td style="border-top:0; width: 101px;" align="center">'+item[i].position+'</td>';
			   html += '<td style="border-top:0; width: 101px;" align="center">'+item[i].grade+'</td>';
			   html += '<td style="border-top:0; width: 243px;" align="center">'+item[i].pj_start_day+'</td>';
			   html += '<td style="border-top:0; width: 243px;" align="center">'+item[i].pj_end_day+'</td>';
			   html += '</tr>';
		   }
		  // alert(html);
		   $('#pjposting_history_tbd', winObject.document).append(html);
			
		});
					
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
			}			
		});

}			
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
function OpenWindow(url, intWidth, intHeight) {
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



