function insertJobSkillAjax(insertFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/insertJobSkillAjax",
		data : $(insertFormId).serialize(),
		success:function(data) {
			if(data.result) {
				getJobSkillSearchPageAjax(data.jobSkillDivision, data.jobSkill, "modify");
			} else {
				alert(data.message);
			}
		}, error: function(xhr) {
			alert("error insertJobSkillAjax = " + xhr.statusText);
		}
	});
}

function modifyJobSkillAjax(modifyFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/modifyJobSkillAjax",
		data : $(modifyFormId).serialize(),
		success:function(data) {
			if(data.result) {
				getJobSkillSearchPageAjax(data.jobSkillDivision, data.jobSkill, "modify");
			} else {
				if(data.message != null) alert(data.message);
			}
		}, error: function(xhr) {
			alert("error modifyJobSkillAjax = " + xhr.statusText);
		}
	});
}

function deleteJobSkillAjax(deleteFormId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/deleteJobSkillAjax",
		data : $(deleteFormId).serialize(),
		success:function(data) {
			getJobSkillSearchPageAjax(data.jobSkillDivision, "", "insert");
		}, error: function(xhr) {
			alert("error deleteJobSkillAjax = " + xhr.statusText);
		}
	});
}

function getJobSkillModifyPageAjax(jobSkillDivision, jobSkill) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getJobSkillModifyPageAjax",
		data : {
			"jobSkillDivision" : jobSkillDivision,
			"jobSkill" : jobSkill
		},
		success:function(data) {
			$("#jobSkillInputDiv").empty();
			$("#jobSkillInputDiv").html(data);
		}, error: function(xhr) {
			alert("error getJobSkillModifyPageAjax = " + xhr.statusText);
		}
	});
}

function getJobSkillInsertPageAjax(jobSkillDivision) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getJobSkillInsertPageAjax",
		data : {
			"jobSkillDivision" : jobSkillDivision
		},
		success:function(data) {
			$("#jobSkillInputDiv").empty();
			$("#jobSkillInputDiv").html(data);
		}, error: function(xhr) {
			alert("error getJobSkillInsertPageAjax = " + xhr.statusText);
		}
	});
}

function getJobSkillListPageAjax(jobSkillDivision, jobSkill, operationType) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getJobSkillListPageAjax",
		data : {
			"jobSkillDivision" : jobSkillDivision
		},
		success:function(data) {
			$("#jobSkillListDiv").empty();
			$("#jobSkillListDiv").html(data);
			
			if(operationType == "insert") {
				getJobSkillInsertPageAjax(jobSkillDivision);
			} else if(operationType == "modify") {
				getJobSkillModifyPageAjax(jobSkillDivision, jobSkill);
			}
		}, error: function(xhr) {
			alert("error getJobSkillListPageAjax = " + xhr.statusText);
		}
	});
}

function getJobSkillSearchPageAjax(jobSkillDivision, jobSkill, operationType) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getJobSkillSearchPageAjax",
		data: {
			"jobSkillDivision" : jobSkillDivision
		},
		success:function(data) {
			$("#jobSkillSearchDiv").empty();
			$("#jobSkillSearchDiv").html(data);
			
			var selectedJobSkillDivision = jobSkillDivision;
			if(operationType == "insert") {
				selectedJobSkillDivision = $("#jobSkillSearchDiv").find("#jobSkillSelectBox").val();
			} 
			
			getJobSkillListPageAjax(selectedJobSkillDivision, jobSkill, operationType);
		}, error: function(xhr) {
			alert("error getJobSkillSearchPageAjax = " + xhr.statusText);
		}
	});
}
