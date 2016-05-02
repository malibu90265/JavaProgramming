function getWeekendSearchPageAjax() {
	$.ajax({
		type : "post",
		url : "/total/getWeekendSearchPageAjax",
		success : function(data) {
			$("#weekend_SearchForm").empty();
			$("#weekend_SearchForm").html(data);
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error getWeekendSearchPageAjax = " + xhr.statusText);
		}
	});
}

function selectChangeFunction() {
	var weekend = $("#wr_date").val();

	getWeekendListBySearchConditionsAjax(weekend);
}

function getWeekendListBySearchConditionsAjax(weekend) {
	$.ajax({
		type:"post",
		url:"/getWeekReport",
		data:{
			"weekend" : weekend,
		},
		success : function(data) {
			$("#weekend_ListForm").empty();
			$("#weekend_ListForm").html(data);
		},
		error : function(xhr) {
			alert("error getWeekendListBySearchConditionsAjax = " + xhr.statusText);
		}
		
	});
}


