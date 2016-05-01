
function getMyMenuHeaderAjax() {
	$.ajax({
		type : "POST",
		url : "/admin/getMyMenuHeaderAjax",
		success : function(data) {
			$("#mymenuHeader").empty();
			$("#mymenuHeader").html(data);
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

function existMyMenuAjax(categoryId, menuSq, seq) {
	$.ajax({
		type : "POST",
		url : "/admin/existMyMenuAjax",
		data : {
			"categoryId" : categoryId
			, "menuSq" : menuSq
		},
		success : function(data) {
			if(data.result) {
				updateMyMenuAjax(categoryId, menuSq, seq);
			} else {
				insertMyMenuAjax(categoryId, menuSq, seq);
			}
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

function insertMyMenuAjax(categoryId, menuSq, seq) {
	$.ajax({
		type : "POST",
		url : "/admin/insertMyMenuAjax",
		data : {
			"categoryId" : categoryId,
			"menuSq" : menuSq,
			"seq" : seq 
		},
		success : function(data) {
			getMyMenuHeaderAjax();
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

function deleteMyMenuAjax(seq) {
	$.ajax({
		type : "POST",
		url : "/admin/deleteMyMenuAjax",
		data : {
			"seq" : seq
		},
		success : function(data) {
			getMyMenuHeaderAjax();
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

function updateMyMenuAjax(categoryId, menuSq, seq) {
	$.ajax({
		type : "POST",
		url : "/admin/updateMyMenuAjax",
		data : {
			"categoryId" : categoryId,
			"menuSq" : menuSq,
			"seq" : seq,
		},
		success : function(data) {
			getMyMenuHeaderAjax();
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}
