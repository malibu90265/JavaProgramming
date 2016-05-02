function insertPjStatusAjax(insertFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/insertPjStatusAjax",
		data : $(insertFormId).serialize(),
		success:function(data) {
			if(data.result) {
				getPjStatusListPageAjax();
				
				getPjStatusModifyPageAjax(data.pj_status_id);
			} else {
				alert(data.message);
			}
		}, error: function(xhr) {
			alert("error insertPjStatusAjax = " + xhr.statusText);
		}
	});
}

function modifyPjStatusAjax(modifyFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/modifyPjStatusAjax",
		data : $(modifyFormId).serialize(),
		success:function(data) {
			if(data.result) {
				getPjStatusListPageAjax();
			} else {
				if(data.message != null) alert(data.message);
			}
		}, error: function(xhr) {
			alert("error modifySkillEnvAjax = " + xhr.statusText);
		}
	});
}

function deletePjStatusAjax(pj_status_id) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/deletePjStatusAjax",
		data : {"pj_status_id" : pj_status_id},
		success:function(data) {
			getPjStatusListPageAjax();
			
			getPjStatusInsertPageAjax();
		}, error: function(xhr) {
			alert("error deletePjStatusAjax = " + xhr.statusText);
		}
	});
}

function getPjStatusModifyPageAjax(pj_status_id) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getPjStatusModifyPageAjax",
		data : {
			"pj_status_id" : pj_status_id
		},
		success:function(data) {
			$("#pjStatusInputDiv").empty();
			$("#pjStatusInputDiv").html(data);
		}, error: function(xhr) {
			alert("error getPjStatusModifyPageAjax = " + xhr.statusText);
		}
	});
}

function getPjStatusInsertPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getPjStatusInsertPageAjax",
		success:function(data) {
			$("#pjStatusInputDiv").empty();
			$("#pjStatusInputDiv").html(data);
		}, error: function(xhr) {
			alert("error getPjStatusInsertPageAjax = " + xhr.statusText);
		}
	});
}

function getPjStatusListPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getPjStatusListPageAjax",
		success:function(data) {
			$("#pjStatusListDiv").empty();
			$("#pjStatusListDiv").html(data);
		}, error: function(xhr) {
			alert("error getPjStatusListPageAjax = " + xhr.statusText);
		}
	});
}

