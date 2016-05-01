function getWeekChartSearchPageAjax() {
	$.ajax({
		type : "post",
		url : "/total/getWeekChartSearchPageAjax",
		success : function(data) {
			$("#week_chart_searchForm").empty();
			$("#week_chart_searchForm").html(data);
			weekChartSelectChangeFunction();
		},
		error : function(xhr) {
			alert("error getWeekChartSearchPageAjax = " + xhr.statusText);
		}
	});
}

function weekChartSelectChangeFunction() {
	var tm_id = $("#tm_id").val();
	getWeekChartBySearchConditionsAjax(tm_id);
}

function getWeekChartBySearchConditionsAjax(tm_id) {
	$.ajax({
		type:"post",
		url:"/total/getWeekChart",
		data:{
			"tm_id" : tm_id,
		},
		success : function(data) {
			$("#week_chart").empty();
			$("#week_chart").html(data);
		},
		error : function(xhr) {
			alert("error getWeekChartBySearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}
	




