// 검색 - 기본
function getEmpStandBySearchFormAjax() {
	$.ajax({
		type : "POST",
		url : "/empStandBy/getEmpStandBySearchFormAjax",
		success : function(data) {
			$("#empStandBySearchForm").empty();
			$("#empStandBySearchForm").html(data);
		},
		error : function(xhr) {
			alert("error empStandBySearchForm = " + xhr.statusText);
		}
	});
}

//리스트 뿌리기.(검색한 결과)
function getEmpStandBySearchTeam(tm_id){
	$.ajax({
		type : "POST" ,
		url : "/empStandBy/getEmpStandByListFormAjax" ,
		async : true ,
		data : {"tm_id" : tm_id} ,
		dataType : "JSON" ,
		success : function(data){
			alert("데이터 검색에 성공했군요...");
			
			
			
		} ,
		error : function(xhr) {
			alert("데이터 검색에 실패했군요...ㅠㅠㅠㅠㅠ");
		}
		
	});
}

/*
//팀 검색
function getEmpStandBySearchTeam(tm_id){
	alert("list검색 되라");
	$.ajax({
		type : "POST" ,
		url : "/empStandBy/getEmpStandByListFormAjax" ,
		async : true,
		data : {"tm_id" : tm_id} ,
		dataType : "json",
		success : function(data){
			alert("list검색 성공??????????");
			
			alert("tm_name" + tm_name);
			
			
			var thisDate = new Date();
			var currentYear = thisDate.getFullYear();
			var test = document.getElementById("nowYear");
			
			var fullDate = new Date();
			var currentMonth = fullDate.getMonth() + 1;
			var test1 = document.getElementById("nowMonth");
			
			var html = "";
			
				html += '<Table id="empStandByForm" name="empStandByForm" border="1">'
				html +=		'<TR>'
				html +=			'<TD>'
				
				html +=				'<table class="nohoverTable">'
				html +=					'<tr>'
				html +=						'<th rowspan="2">사업팀명</th>'
				html +=						'<th rowspan="2">최종PJ</th>'
				html +=						'<th rowspan="2">이름</th>'
				html +=						'<th rowspan="2">직위/직급</th>'
				html +=						'<th>대기</th>'
				html +=						'<th>총대기월수</th>'
				//새창 띄울 부분"
				html +=						'<th colspan="12" class="show_result"></th>'
				html +=					'</tr>'
				
				//1~12월 ( 새창 띄울시 새창에서... 그렇다면 위에 rowspan도 없애야...)
				html +=					'<tr>'
				html +=						'<th><h class="state1" />1월</th>'
				html +=						'<th><h class="state2" />2월</th>'
				html +=						'<th><h class="state3" />3월</th>'
				html +=						'<th><h class="state4" />4월</th>'
				html +=						'<th><h class="state5" />5월</th>'
				html +=						'<th><h class="state6" />6월</th>'
				html +=						'<th><h class="state7" />7월</th>'
				html +=						'<th><h class="state8" />8월</th>'
				html +=						'<th><h class="state9" />9월</th>'
				html +=						'<th><h class="state10" />10월</th>'
				html +=						'<th><h class="state11" />11월</th>'
				html +=						'<th><h class="state12" />12월</th>'
				html +=					'</tr>'
				html +=				'</table>'
				
				html +=			'</TD>'
				html += 	'</TR>'	
				
				html +=		'<TR>'
				html +=			'<TD>'	
				html +=				'<div style="overflow-y: auto;">'	
				
				html += 			'<table id="standByTable" class="nohoverTable">'	
				
				
				
					MMTotal = 금년합계,
					standByTotal = 대기,
					unplaceTotal = 미배치,
				
				var unpleToTotal = 0.0f;
				var standToTotal = 0.0f;
				var mmToTotal = 0.0f;
				var monthTotal = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
				
				$.each(data.standByInfo,function(entryIndex, standByInfo){
					
					var unplaceTotal = 0.0f;
					var standByTotal = 0.0f;
					var MMTotal=0.0f;
					
					for(var i=0; i<12 ; i++){
						
						if(i<=data-1){
							if(parseFloat(Number(standByInfo.mm[i])).toFixed(1) == 0.0){
								standByTotal += Number(1.0);
								monthTotal[i] += Number(1.0);
							}
							else{
								standByTotal += parseFloat(Number(1-standByInfo.mm[i]).toFixed(1));
								monthTotal[i] += parseFloat(Number(1-standByInfo.mm[i]).toFixed(1));
							}
						}
						else{
							if(parseFloat(Number(standByInfo.mm[i])).toFixed(1) == 0.0){
								unplaceTotal += Number(1.0);
								monthTotal[i] += Number(1.0);
							}
							else{
								unplaceTotal += parseFloat(Number(1-standByInfo.mm[i]).toFixed(1));
								monthTotla[i] += parseFloat(Number(1-standByInfo.mm[i]).toFixed(1));
							}
						}
					}
					
					MMTotal = Number(parseFloat(Number(standByTotal) + Number(unplaceTotal)).toFixed(1));
					unpleToTotal += unplaceTotal;
					standToTotal += standByTotal;
					mmToTotal += MMTotal;
					
					if(MMTotal != 0){
						html += 		'<tr>'
						
						html +=				'<td>'+standByInfo.tm_name+'</td>';
						html +=				'<td>'+standByInfo.pj_id+'</td>';
						html +=				'<td>'+standByInfo.hr_name+'</td>';
						html +=				'<td>'+standByInfo.hr_position+'</td>';
						
						//대기
						html+=				'<td>'+parseFloat(Number(standByTotal)).toFixed(1) +'</td>'
						//미배치
						html+=				'<td>'+parseFloat(Number(standByTotal)).toFixed(1) +'</td>'
						
						//1~12월 for문
						for(var i=0 ; i<12; i++){
							
							MMTotal += Number(parseFloat(standByInfo.mm[i]).toFixed(1));
							if(parseFloat(Number(standByInfo.mm[i])).toFixed(1) == 1.0){
								html += 	'<td class="state>'+i+'">'+"" +'</td>';
							}
							else if(parseFloat(Number(standByInfo.mm[i])).toFixed(1) == 0.0){
								html += 	'<td class="state>'+i+'">'+"1.0" +'</td>';
							}
							else{
								var val = parseFloat(1.0-Number(standByInfo.mm[i])).toFixed(1);
								html += 	'<td>'+i+'">'+val +'</td>'
							}
							
						}
						html +=			'</tr>'
					}
				});
				
				html +=					'<tr>'
				html +=						'<th>'+parseFloat(standToTotal).toFixed(1)+'</th>';
				html +=						'<th>'+parseFloat(unpleToTotal).toFixed(1)+'</th>';
				html +=						'<th>'+parseFloat(mmToTotal).toFixed(1)+'</th>';
				
				for(var i=0; i<12; i++){
					html +=					'<th>'+ parseFloat(monthTotal[i]).toRFixed(1)+'</th>';
				}
				
				html +=					'</tr>'
				html +=				'</table>'	
				html += 		'</TD>'	
				html +=		'</TR>'
				
					
				html +=	'</Table>'
				
				$("#standByInfo3").html(html);
				$(".show_result").text(currentYear+" 투입(예정)MM");
				$(".show_result1").text(date);
				
				var out = ['.state0','.state1','.state2','.state3','.state4','.state5','.state6','.state7','.state8','.state9','.state10','.state11'];
				
				for (var i=0; i<12; i++){
					if(i<date-1){
						$(out[i]).css('background-color','#FAF4C0')
					}  
					if(i==date-1){ 
						$(out[i]).css('background-color','#B2CCFF')
					}
					if(i>date-1){ 
						$(out[i]).css('background-color','#FFD9EC')
					}
				}
				return;
			},	
			error : function(xhr){
				alert("list검색 실패ㅠㅠㅠㅠ??????????");
				alert("error html = " + xhr.statusText);
			}	
	});
}
*/

/*
//list
function getEmpStandByListFormAjax(){
	$.ajax({
		type : "POST" ,
		url : "/empStandBy/getEmpStandByListFormAjax" ,
		success : function(data){
			$("#empStandByListForm").empty();
			$("#empStandByListForm").html(data);
		},
		error : function(xhr){
			alert("error empStnadByList = " + xhr.statusText);
		}
	});
}*/


