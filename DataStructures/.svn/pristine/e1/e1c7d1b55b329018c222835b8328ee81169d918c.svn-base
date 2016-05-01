function getDeployRequirementsList(){
	$.ajax({
		type : "POST",
		url : "/getDeployRequirementsListAjax",
		success : function(data) {
			$("#deployRequirementsDiv").empty();
			$("#deployRequirementsDiv").html(data);
		},
		error : function(xhr) {
			alert("error html1 = " + xhr.statusText);
		}
	});
}

function getDeployRequirementsInsertForm() {
	$.ajax({
		type : "POST",
		url : "/getDeployRequirementsInsertFormAjax",
		success : function(data) {
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
		},
		error : function(xhr) {
			alert("error html2 = " + xhr.statusText);
		}
	});
}

function getDeployRequirementsDetailForm(pjId) {
	$.ajax({
		type : "POST",
		url : "/getDeployRequirementsDetailFormAjax",
		data : {"pjId" : pjId},
		success : function(data) {
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
		},
		error : function(xhr) {
			alert("error html3 = " + xhr.statusText);
		}
	});
}

function getDeployRequirementsModifyForm(pjId) {
	$.ajax({
		type : "POST",
		url : "/getDeployRequirementsModifyFormAjax",
		data : {"pjId" : pjId},
		success : function(data) {
			$("#deployRequirementsForm").empty();
			$("#deployRequirementsForm").html(data);
		},
		error : function(xhr) {
			alert("error html4 = " + xhr.statusText);
		}
	});
}

function getDeployRequirementsConditionsAjax(requirePerson, pjId) {
	$.ajax({
		type : "POST",
		url : "/getDeployRequirementsConditionsAjax",
		data : {
			"requirePerson" : requirePerson,
			"pjId" : pjId
		},
		success : function(data) {
			$("#deployRequirementsConditions").empty();
			$("#deployRequirementsConditions").html(data);
		},
		error : function(xhr) {
			//alert("error html5 = " + xhr.statusText);
		}
	});
}