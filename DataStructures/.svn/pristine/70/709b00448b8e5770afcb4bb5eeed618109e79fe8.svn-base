function getMiniHeaderAjax() {
	$.ajax({
		type : "POST",
		url : "/admin/getMiniHeaderAjax",
		success : function(data) {
			$("#miniHeader").empty();
			$("#miniHeader").html(data);
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}