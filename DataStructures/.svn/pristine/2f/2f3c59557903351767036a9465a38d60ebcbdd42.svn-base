
// 검색
function getCostmapSearchForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/costmapSearch",
		success : function(data) {
			$("#costmapSearchForm").empty();
			$("#costmapSearchForm").html(data);
		},
		error : function(xhr) {
			alert("error getCostmapSearchForm = " + xhr.statusText);
		}
	});
}

//팀 검색
function getCostmapSearchTeamAjax(tm_id){
	$.ajax({
		type: "POST" ,
		url : "/humanResource/costmapList" ,
		data : { 
			"tm_id" : tm_id,
		},
		success : function(data){
			$("#costmapList").empty();
			$("#costmapList").html(data);
		},
		error : function(xhr) {
			alert("getCostmapSearchTeamAjax html = " + xhr.statusText);
		}
	});
}
