function getLoginHeaderAjax() {
	$.ajax({
		type : "POST",
		url : "/common/getLoginHeaderAjax",
		success : function(data) {
			$("#loginHeaderDiv").empty();
			$("#loginHeaderDiv").html(data);
		},
		error : function(xhr) {
			alert("error getLoginHeaderAjax = " + xhr.statusText);
		}
	});
}	

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

function getGagePage(){
	$.ajax({
		type : "POST",
		url : "/gage",
		success : function(data) {
			$("#gage").empty();
			$("#gage").html(data);
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

function getMenuListPage() {
	var categoryId = "0";
	
	$.ajax({
		type:"post",
		url : "/admin/getMenuListPage",
		data : {
			"categoryId" : categoryId
		},
		success : function(data) {
			$(".content").empty();
			$(".content").html(data);
		},
		error : function(xhr) {
			alert("error getMenuListPage = " + xhr.statusText);
		}
	});
	
}

function getChangePasswordPageAjax() {
	$.ajax({
		type : "POST",
		url : "/common/getChangePasswordPageAjax",
		success : function(data) {
			$("#changePasswordDiv").empty();
			$("#changePasswordDiv").html(data);
		},
		error : function(xhr) {
			alert("error getChangePasswordPageAjax = " + xhr.statusText);
		}
	});
}

function setDeleteSpanTagDisabled(id){
	document.getElementById(id).disabled = true;
}
