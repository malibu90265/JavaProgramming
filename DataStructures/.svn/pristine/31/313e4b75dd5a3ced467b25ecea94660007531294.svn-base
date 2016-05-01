function getRoleListAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getRoleListAjax",
		success:function(data) {
			$("#RoleListDiv").empty();
			$("#RoleListDiv").html(data);
		}, error: function(xhr) {
			alert("error getRoleListAjax = " + xhr.statusText);
		}
	});
}

function getRoleInsertPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getRoleInsertPageAjax",
		success:function(data) {
			$("#RoleInputDiv").empty();
			$("#RoleInputDiv").html(data);
			
		}, error: function(xhr) {
			alert("error getRoleInsertPageAjax = " + xhr.statusText);
		}
	});
}

function getRoleModifyPageAjax(role_id, each_role) {
	$.ajax({
		type : "POST",
		url : "/admin/basicInfo/getRoleModifyPageAjax",
		success : function(data) {
			
			$("#RoleInputDiv").empty();
			$("#RoleInputDiv").html(data);
			
			$("#each_role").val(each_role);
			$("#role_id").val(role_id);
		},
		error : function(xhr) {
			alert("error getRoleModifyPageAjax = " + xhr.statusText);
		}
	})
}
function checkDuplicateYN(each_role) {
	var returnVal = false;
	$.ajax({
		type : "POST",
		async: false,
		url : "/admin/basicInfo/checkDuplicateYN",
		data : {"each_role" : each_role},
		success : function(data) {
			returnVal = data.result;
		},
		error : function(xhr) {
			alert("error insertPjStageAjax = " + xhr.statusText);
		}
	})
	
	return returnVal;
}

function insertRoleAjax(each_role) {
	$.ajax({
		type : "POST",
		url : "/admin/basicInfo/insertRoleAjax",
		data : {"each_role" : each_role},
		success : function(data) {
			alert(data.message);

			getRoleListAjax();
			getRoleModifyPageAjax(data.role_id, data.each_role);
		},
		error : function(xhr) {
			alert("error insertPjStageAjax = " + xhr.statusText);
		}
	})
}

function modifyRoleAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/admin/basicInfo/modifyRoleAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getRoleListAjax();
			getRoleModifyPageAjax(data.role_id, data.each_role);
			
			alert(data.message);
		},
		error : function(xhr) {
			alert("error insertPjStageAjax = " + xhr.statusText);
		}
	})
}

function deleteRoleAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/admin/basicInfo/deleteRoleAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getRoleListAjax();
			getRoleInsertPageAjax();
			
			alert(data.message);
		},
		error : function(xhr) {
			alert("error insertPjStageAjax = " + xhr.statusText);
		}
	})
}