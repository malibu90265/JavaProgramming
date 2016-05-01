function getPjStagePageAjax() {
			$.ajax({
				type: "POST",
				url: "/admin/basicInfo/getPjStagePageAjax",
				success: function(data) {
					$("#pjStageListDiv").empty();
					$("#pjStageListDiv").html(data);
				},
				error: function(xhr) {
					alert("error getPjStagePageAjax = " + xhr.statusText);
				}
			});
		}
		
function getPjStageInsertPageAjax() {
	$.ajax({
		type: "POST",
		url: "/admin/basicInfo/getPjStageInsertPageAjax",
		success: function(data) {
			$("#pjStageInputDiv").empty();
			$("#pjStageInputDiv").html(data);
		},
		error: function(xhr) {
			alert("error getPjStageInsertPageAjax = " + xhr.statusText);
		}
	});
}

function insertPjStageAjax(pj_stage_name) {
	$.ajax({
		type: "POST",
		url: "/admin/basicInfo/insertPjStageAjax",
		data: {"pj_stage_name" : pj_stage_name},
		success: function(data) {
			alert(data.message);
			getPjStagePageAjax();
			getPjStageModifyPageAjax(pj_stage_name, data.pj_stage_id);
		},
		error: function(xhr) {
			alert("error insertPjStageAjax = " + xhr.statusText);
		}
	});
}

function getPjStageModifyPageAjax(pj_stage_name, pj_stage_id) {
	$.ajax({
		type: "POST",
		url: "/admin/basicInfo/getPjStageModifyPageAjax",
		success: function(data) {
			$("#pjStageInputDiv").empty();
			$("#pjStageInputDiv").html(data);
			
			$("#pj_stage_name").val(pj_stage_name);
			$("#pj_stage_id").val(pj_stage_id);
		},
		error: function(xhr) {
			alert("error getPjStageInsertPageAjax = " + xhr.statusText);
		}
	});
}

function modifyPjStageAjax(formId) {
	$.ajax({
		type: "POST",
		url: "/admin/basicInfo/modifyPjStageAjax",
		data: $(formId).serialize(),
		success: function(data) {
			alert(data.message);
			
			getPjStagePageAjax();
			getPjStageModifyPageAjax(data.pj_stage_name, data.pj_stage_id);
		},
		error: function(xhr) {
			alert("error modifyPjStageAjax = " + xhr.statusText);
		}
	});
}

function deletePjStageAjax(pj_stage_id) {
	$.ajax({
		type: "POST",
		url: "/admin/basicInfo/deletePjStageAjax",
		data: {"pj_stage_id": pj_stage_id},
		success: function(data) {
			alert(data.message);
			
			getPjStagePageAjax();
			getPjStageInsertPageAjax();
		},
		error: function(xhr) {
			alert("error modifyPjStageAjax = " + xhr.statusText);
		}
	});
}