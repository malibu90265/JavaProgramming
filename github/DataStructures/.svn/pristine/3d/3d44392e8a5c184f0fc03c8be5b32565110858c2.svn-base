// 검색 폼
function getDeployProjectMapSearchForm() {
	$.ajax({
		type : "POST",
		url : "/deployProjectMap/searchForm",
		success : function(data) {
			$("#deployProjectMapSearchForm").empty();
			$("#deployProjectMapSearchForm").html(data);
		},
		error : function(xhr) {
			alert("error getDeployProjectMapSearchForm = " + xhr.statusText);
		}
	});
}


// 리스트

function getDeployProjectMapInfoList(tm_id) {

	 $.ajax({
		type : "POST",
		url : "/deployProjectMap/project",
		async : true,
		dataType : "json",
		
		data : {
			tm_id : tm_id
		},
		success : function(data) {
			
			var html = "";
			html+='<TABLE id="deployProjectMapTable" class="deployProjectMapTable" cellpadding="0" cellspacing="0" border="0">'
				html+='<TR>'
					html+='<TD>'
						html+='<table width="413px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'
							html+='<tr>'
								html+='<th rowspan="2" style="width: 124px; height:53px">프로젝트ID</th>'
								html+='<th colspan="2" style="width: 209px; height:26px">프로젝트 기간</th>'
								html+='<th rowspan="2" style="width: 80px; ">배치 인원</th>'	
							html+=	'</tr>'
							html+=	'<tr>'										
								html+='<th style="width: 105px; height:36px">시 작 일</th>'
								html+='<th style="width: 105px">종 료 일</th>'
							html+='</tr>'
						html+='</table>'
					html+='</TD>'
				html+='</TR>'
				html+='<TR>'
					html+='<TD>'						
					html+='<div style="width: 434px; height: 600px; overflow-y: auto">'
						html+='<table id="standbytable"  width="412px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">'
							$.each(data.deployProjectInfo,function(entryIndex, deployProjectInfo){ 
								var params=deployProjectInfo.pj_id+","+tm_id;
								var unplaceTotal=0.0;
								var standbyTotal=0.0;
								var MMTotal=0.0;
									html+='<tr style="cursor:pointer;" id="'+deployProjectInfo.pj_id+'" onClick=getDeployProjectEachInfoList("'+deployProjectInfo.pj_id+'","'+tm_id+'")>'
									html+='<td align="center" style="border-top:0; width:124px; cursor:pointer;">'+deployProjectInfo.pj_id+'</td>';	
									html+='<td style="border-top:0; width: 104px" align="center">'+deployProjectInfo.pj_start_date+'</td>';
									html+='<td style="border-top:0; width: 104px" align="center">'+deployProjectInfo.pj_end_date+'</td>';
									html+='<td style="border-top:0; width: 80px; "align="center">'+deployProjectInfo.emp_cnt+'명</td>';		
									html+='</tr>'								
							});
						html+='</table>'
					html+='</div>'
				    html+='</TD>'							
				html+='</TR>'
		html+='</TABLE>'
			
			
			$("#deployProjectMapInfo").html(html);
			return;
		},
		error : function(xhr) {
			alert("error deployProjectMapInfo = " + xhr.statusText);
		}
	});
	
}
	
	
//상세 정보 페이지
function getDeployProjectEachInfoList(pj_id,tm_id){
	$.ajax({
		type : "POST",
		url : "/deployProjectMap/detail",
		async : true,
		dataType : "json",
		data : {
			pj_id: pj_id,
			tm_id: tm_id,
		},
		success : function(data) {	
			var html = "";
			html+='<TABLE class="deployProjectMapTable">'
						html+=	'<tr>'
							html+=	'<th>프로젝트ID</th>'
							html+=	'<th rowspan="2" style="width:90px;">이름</th>'
							html+=	'<th>등급(소속)</th>'
							html+=	'<th>단 가</th>'
							html+=	'<th colspan="2">투입기간</th>'
							html+=	'<th>MM합계</th>'
							html+=	'</tr>'
							html+=	'<tr>'
							html+=	'<th>시작일</th>'
							html+=	'<th>종료일</th>'
								
							html+= 	'</tr>'
								
								if(data.size==0){
									html+='<tr>'
									html+='<th colspan="7">'+"데이터가 없습니다."+'</th>';
									html+='</tr>'
									$("#detailProject").html(html);					
									return;	
								}	
					html+='<TR>'
					html+='<TD>'
					html+='<div>'
						html+='<table id="standbytable" class="hoverTable">'
							
							var unpleToTotal=0.0;
							var standToTotal=0.0;
							var mmToTotal=0.0;
							var monthTotal=new Array(0,0,0,0,0,0,0,0,0,0,0,0);
							var tm_id='';
							$.each(data.detaildeployProjectInfo,function(entryIndex, detaildeployProjectInfo){ 
								var unplaceTotal=0.0;
								var standbyTotal=0.0;
								var MMTotal=0.0;
								tm_id=detaildeployProjectInfo.tm_id;
								MMTotal=parseFloat(Number(detaildeployProjectInfo.totalMm).toFixed(1));
								mmToTotal+=MMTotal;
								
									html+='<tr >' 
										
									if(detaildeployProjectInfo.division=='직원'){
										html+='<td>'+detaildeployProjectInfo.pj_id+'</td>';	
										html+='<td>'+'<a href="#" style="text-decoration:none;" class="big-link" id="'+detaildeployProjectInfo.name+":"+pj_id+'" data-reveal-id="myModal" data-animation="fade">'+detaildeployProjectInfo.name+'</a></td>';
										html+='<td>'+detaildeployProjectInfo.position.substring(1, 3)+'</td>';
										html+='<td>-</td>';
										html+='<td>'+detaildeployProjectInfo.startday.substring(0,4)+'-'+detaildeployProjectInfo.startday.substring(4,6)+'-'+detaildeployProjectInfo.startday.substring(6,9)+'</td>';
										html+='<td>'+detaildeployProjectInfo.endday.substring(0,4)+'-'+detaildeployProjectInfo.endday.substring(4,6)+'-'+detaildeployProjectInfo.endday.substring(6,9)+'</td>';
										html+='<td>'+parseFloat(MMTotal).toFixed(1)+'</td>';
									}else{
										html+='<td>'+detaildeployProjectInfo.pj_id+'</td>';	
										html+='<td>'+'<a href="#" style="text-decoration:none;" class="big-link" id="'+detaildeployProjectInfo.name+":"+pj_id+'" data-reveal-id="myModal" data-animation="fade">'+detaildeployProjectInfo.name+'</a></td>';
										html+='<td>'+detaildeployProjectInfo.position.substring(1, 3)+'</td>';
										html+='<td>'+detaildeployProjectInfo.salary+'</td>';
										html+='<td>'+detaildeployProjectInfo.startday.substring(0,4)+'-'+detaildeployProjectInfo.startday.substring(4,6)+'-'+detaildeployProjectInfo.startday.substring(6,9)+'</td>';
										html+='<td>'+detaildeployProjectInfo.endday.substring(0,4)+'-'+detaildeployProjectInfo.endday.substring(4,6)+'-'+detaildeployProjectInfo.endday.substring(6,9)+'</td>';
										html+='<td>'+parseFloat(MMTotal).toFixed(1)+'</td>';
									}
//									for(var i=0; i<12; i++){
//												 monthTotal[i]+=parseFloat(Number(detaildeployProjectInfo.mm[i]).toFixed(1));
//												 MMTotal+=parseFloat(Number(detaildeployProjectInfo.mm[i]).toFixed(1));
//									}
//									if(detaildeployProjectInfo.division=='외주'){
										
//									}
									
									
									
							});
							html+='<tr><th>계</th>';
							html+='<th>'+parseFloat(mmToTotal).toFixed(1)+'</th>';	
							
							html+='</tr>'	
							html+='</table>'

							html+='</div>'	
					html+='</TD>'	
					html+='</TR>'
					html+='</TABLE>'
			
			$("#detailProject").html(html);			
		
			return;
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
	
}