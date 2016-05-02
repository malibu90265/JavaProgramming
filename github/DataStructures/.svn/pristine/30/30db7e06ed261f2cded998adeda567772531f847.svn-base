function getDemoDeployRequirementsList(){
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsListAjax",
		success : function(data) {
			$("#deployRequirementsDiv").empty();
			$("#deployRequirementsDiv").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsInsertForm() {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsInsertFormAjax",
		success : function(data) {
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function insertDemoDeployRequirements(insertFormId) {
	
	$.ajax({
		type : "POST",
		url : "/demo/insertDeployRequirementsAjax",
		data : $("#"+insertFormId).serialize(),
		success : function(data) {
			
			getDemoDeployRequirementsList();
			
			getDemoDeployRequirementsInsertForm();
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsDetailForm(pjId) {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsDetailFormAjax",
		data : {"pjId" : pjId},
		success : function(data) {
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsModifyForm(pjId) {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsModifyFormAjax",
		data : {"pjId" : pjId},
		success : function(data) {
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsDelete(pjId) {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsDeleteAjax",
		data : {
			"pjId" : pjId
		},
		success : function(data) {
			getDemoDeployRequirementsList();
			getDemoDeployRequirementsInsertForm();
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsSave(modifyFormId) {
	$.ajax({
		type : "POST",
		url : "/demo/saveDeployRequirementsAjax",
		data : $("#"+modifyFormId).serialize(),
		success : function(data) {
			
			getDemoDeployRequirementsList();
			
			var pjId = data.pjId;
			getDemoDeployRequirementsDetailForm(pjId);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsConditionsAjax(requirePerson) {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsConditionsAjax",
		data : {
			"requirePerson" : requirePerson
		},
		success : function(data) {
			$("#deployRequirementsConditions").empty();
			$("#deployRequirementsConditions").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsConditionsDetailAjax(pjId) {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsConditionsDetailAjax",
		data : {
			"pjId" : pjId
		},
		success : function(data) {
			$("#deployRequirementsConditions").empty();
			$("#deployRequirementsConditions").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}

function getDemoDeployRequirementsConditionsModifyAjax(pjId) {
	$.ajax({
		type : "POST",
		url : "/demo/getDeployRequirementsConditionsModifyAjax",
		data : {
			"pjId" : pjId
		},
		success : function(data) {
			$("#deployRequirementsConditions").empty();
			$("#deployRequirementsConditions").html(data);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}