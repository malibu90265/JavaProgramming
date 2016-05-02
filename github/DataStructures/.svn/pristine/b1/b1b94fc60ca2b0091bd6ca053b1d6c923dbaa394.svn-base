// PJNeeds 검색
$(document).ready(function(){
	$('#searchteam').setTeamdiv({all:true});
	
	PjneedsSearch();
	
	$('#searchbtn').click(function(){
		PjneedsSearch();
	});	
	//2015-01-27 자동검색 추가
	$("#searchprog").change(function(){PjneedsSearch()});
	$("#searchteam").change(function(){PjneedsSearch()});
	$("#searchid").keyup(function(){PjneedsSearch()});
});

// 인력소요 정보 리스트 출력
function PjneedsSearch(){
	$.ajax({
		type : "POST",
		url:"/Pjneeds_Search",
		async : true,
		dataType : "json",
		data:{				
			searchid:$("#searchid").val(),
			search_team:team.value,
			searchprog:$("#searchprog").val()
		},
		success : function(search) {		
			$.each(search, function (index, item) {
				var html = '<table width="477px" cellspacing="1" cellpadding="0" border="0" class="hoverTable"  style="text-align: center; ">'; 
				for (var i=0; i<item.length; i++){
					html += "<tr onclick=getProjectDetail('"+item[i].pj_id+"') style='cursor:pointer'>";
					html += '<td style="border-top:0; width: 114px; text-align:center;">'+item[i].team_name+'</td>';
					html += '<td style="border-top:0; width: 173px; text-align:center;">'+item[i].pj_id+'</td>';
					html += '<td style="border-top:0; width: 90px; text-align:center;">'+item[i].pj_prog+'</td>';
					html += '<td style="border-top:0; width: 97px; text-align:center;">'+item[i].pn_num+'</td>';
					html += '</tr>';
				}
				html += '</table>';
				$("#search_list").html(html);
			});
		},
		error : function(xhr) {
			alert("error html8 = " + xhr.statusText);
		}			
	});
}

