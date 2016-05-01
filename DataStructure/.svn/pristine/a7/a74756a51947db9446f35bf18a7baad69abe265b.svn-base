function insertSkillEnvAjax(insertFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/insertSkillEnvAjax",
		data : $(insertFormId).serialize(),
		success:function(data) {
			if(data.result) {
				getSkillEnvSearchPageAjax(data.skillEnvDivision, data.skillEnvironment, "modify");
			} else {
				alert(data.message);
			}
		}, error: function(xhr) {
			alert("error insertSkillEnvAjax = " + xhr.statusText);
		}
	});
}

function modifySkillEnvAjax(modifyFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/modifySkillEnvAjax",
		data : $(modifyFormId).serialize(),
		success:function(data) {
			if(data.result) {
				getSkillEnvSearchPageAjax(data.skillEnvDivision, data.skillEnvironment, "modify");
			} else {
				if(data.message != null) alert(data.message);
			}
		}, error: function(xhr) {
			alert("error modifySkillEnvAjax = " + xhr.statusText);
		}
	});
}

function deleteSkillEnvAjax(deleteFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/deleteSkillEnvAjax",
		data : $(deleteFormId).serialize(),
		success:function(data) {
			getSkillEnvSearchPageAjax(data.skillEnvDivision, "", "insert");
		}, error: function(xhr) {
			alert("error deleteSkillEnvAjax = " + xhr.statusText);
		}
	});
}

function getSkillEnvModifyPageAjax(skillEnvDivision, skillEnvironment) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getSkillEnvModifyPageAjax",
		data : {
			"skillEnvDivision" : skillEnvDivision,
			"skillEnvironment" : skillEnvironment
		},
		success:function(data) {
			$("#skillEnvInputDiv").empty();
			$("#skillEnvInputDiv").html(data);
		}, error: function(xhr) {
			alert("error getSkillEnvModifyPageAjax = " + xhr.statusText);
		}
	});
}

function getSkillEnvInsertPageAjax(skillEnvDivision) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getSkillEnvInsertPageAjax",
		data : {
			"skillEnvDivision" : skillEnvDivision
		},
		success:function(data) {
			$("#skillEnvInputDiv").empty();
			$("#skillEnvInputDiv").html(data);
		}, error: function(xhr) {
			alert("error getSkillEnvInsertPageAjax = " + xhr.statusText);
		}
	});
}

function getSkillEnvListPageAjax(skillEnvDivision, skillEnvironment, operationType) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getSkillEnvListPageAjax",
		data : {
			"skillEnvDivision" : skillEnvDivision
		},
		success:function(data) {
			$("#skillEnvListDiv").empty();
			$("#skillEnvListDiv").html(data);
			
			if(operationType == "insert") {
				getSkillEnvInsertPageAjax(skillEnvDivision);
			} else if(operationType == "modify") {
				getSkillEnvModifyPageAjax(skillEnvDivision, skillEnvironment);
			}
		}, error: function(xhr) {
			alert("error getSkillEnvListPageAjax = " + xhr.statusText);
		}
	});
}

function getSkillEnvSearchPageAjax(skillEnvDivision, skillEnvironment, operationType) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getSkillEnvSearchPageAjax",
		data: {
			"skillEnvDivision" : skillEnvDivision
		},
		success:function(data) {
			$("#skillEnvSearchDiv").empty();
			$("#skillEnvSearchDiv").html(data);
			
			var selectedSkillEnvDivision = skillEnvDivision;
			if(operationType == "insert") {
				selectedSkillEnvDivision = $("#skillEnvSearchDiv").find("#skillEnvSelectBox").val();
			} 
			
			getSkillEnvListPageAjax(selectedSkillEnvDivision, skillEnvironment, operationType);
		}, error: function(xhr) {
			alert("error getSkillEnvSearchPageAjax = " + xhr.statusText);
		}
	});
}
