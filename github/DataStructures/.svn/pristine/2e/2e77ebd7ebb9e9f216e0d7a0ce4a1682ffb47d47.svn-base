// 카테고리

function resetCategoryPage() {
	getCategoryListAjax();
	
	getCategoryInsertFormAjax();
}

function getCategoryListAjax() {
	$.ajax({
		type : "POST",
		url : "/admin/getCategoryListAjax",
		success : function(data) {
			$("#categoryDiv").empty();
			$("#categoryDiv").html(data);
			
			resetMenuPage();
		},
		error : function(xhr) {
			alert("error getCategoryListAjax = " + xhr.statusText);
		}
	});
}

function getCategoryInsertFormAjax() {
	$.ajax({
		type : "POST",
		url : "/admin/getCategoryInsertFormAjax",
		success : function(data) {
			$("#categoryForm").empty();
			$("#categoryForm").html(data);
		},
		error : function(xhr) {
			alert("error getCategoryInsertFormAjax = " + xhr.statusText);
		}
	});
}

function categoryValidationCheck() {
	if($("#categoryName").val() == "" || $("#categoryName").val() == null) {
		alert("대분류명을 입력해주세요.");
		return false;
	}
	
	return true;
}

function existCategoryNameAjax(formId, saveType) {
	var categoryName = $(formId).find("#categoryName").val();
	
	$.ajax({
		type : "POST",
		url : "/admin/existCategoryNameAjax",
		data : {
			"categoryName" : categoryName
		},
		success : function(data) {
			if(data.result) {
				alert("이미 존재하는 대분류명입니다.");
			} else {
				if(saveType == "insert")	insertCategoryAjax(formId);
				else if(saveType == "modify")	modifyCategoryAjax(formId);
			}
		},
		error : function(xhr) {
			alert("error insertCategoryAjax = " + xhr.statusText);
		}
	});
}

function insertCategoryAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/admin/insertCategoryAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getCategoryListAjax();
			
			getCategoryInsertFormAjax();
		},
		error : function(xhr) {
			alert("error insertCategoryAjax = " + xhr.statusText);
		}
	});
}

function getCategoryModifyFormAjax(categoryId) {
	$.ajax({
		type : "POST",
		url : "/admin/getCategoryModifyFormAjax/" + categoryId,
		success : function(data) {
			$("#categoryForm").empty();
			$("#categoryForm").html(data);
			
			resetMenuPage();
		},
		error : function(xhr) {
			alert("error getCategoryModifyFormAjax = " + xhr.statusText);
		}
	});
}

function modifyCategoryAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/admin/modifyCategoryAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getCategoryListAjax();
			
			getCategoryModifyFormAjax(data.id);
		},
		error : function(xhr) {
			alert("error modifyCategoryAjax = " + xhr.statusText);
		}
	});
}

function deleteCategoryAjax(categoryId) {
	$.ajax({
		type : "POST",
		url : "/admin/deleteCategoryAjax/" + categoryId,
		success : function(data) {
			getCategoryListAjax();
			
			getCategoryInsertFormAjax();
			
			resetMenuPage();
		},
		error : function(xhr) {
			alert("error deleteCategoryAjax = " + xhr.statusText);
		}
	});
}

// 메뉴

function resetMenuPage() {
	var categoryId = 0;
	getMenuSearchPageAjax(categoryId);
	
	getMenuInsertFormAjax();
}

function getMenuSearchPageAjax(categoryId) {
	$.ajax({
		type : "POST",
		url : "/admin/getMenuSearchPageAjax",
		data : {
			"categoryId" : categoryId
		},
		success : function(data) {
			$("#menuSearchDiv").empty();
			$("#menuSearchDiv").html(data);
			
			getMenuListAjax(categoryId);
		},
		error : function(xhr) {
			alert("error getMenuSearchPageAjax = " + xhr.statusText);
		}
	});
}

function getMenuListAjax(categoryId) {
	$.ajax({
		type : "POST",
		url : "/admin/getMenuListAjax",
		data : {
			"categoryId" : categoryId
		},
		success : function(data) {
			$("#menuDiv").empty();
			$("#menuDiv").html(data);
		},
		error : function(xhr) {
			alert("error getMenuListAjax = " + xhr.statusText);
		}
	});
}

function getMenuInsertFormAjax() {
	$.ajax({
		type : "POST",
		url : "/admin/getMenuInsertFormAjax",
		success : function(data) {
			$("#menuForm").empty();
			$("#menuForm").html(data);
		},
		error : function(xhr) {
			alert("error getMenuInsertFormAjax = " + xhr.statusText);
		}
	});
}

function existMenuNameAjax(formId) {
	var categoryId = $(formId).find("#categoryId").val();
	var menuName = $(formId).find("#menuName").val();
	
	$.ajax({
		type : "POST",
		url : "/admin/existMenuNameAjax",
		data : {
			"categoryId" : categoryId,
			"menuName" : menuName
		},
		success : function(data) {
			if(data.result) {
				alert("해당 메뉴명은 " + data.categoryName + "대분류에 존재합니다.");
			} else {
				insertMenuAjax(formId);
			}
		},
		error : function(xhr) {
			alert("error existMenuNameAjax = " + xhr.statusText);
		}
	});
}

function menuValidationCheck() {
	if($("#menuName").val() == "" || $("#menuName").val() == null) {
		alert("메뉴명을 입력해주세요.");
		return false;
	}
	if($("#menuURL").val() == "" || $("#menuURL").val() == null) {
		alert("메뉴URL을 입력해주세요.");
		return false;
	}
	
	return true;
}

function insertMenuAjax(formId) {
	var categoryId = $(formId).find("#categoryId").val();
	
	$.ajax({
		type : "POST",
		url : "/admin/insertMenuAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getMenuSearchPageAjax(categoryId);
			
			getMenuInsertFormAjax();
		},
		error : function(xhr) {
			alert("error insertMenuAjax = " + xhr.statusText);
		}
	});
}


function getMenuModifyFormAjax(categoryId, menuSq) {
	$.ajax({
		type : "POST",
		url : "/admin/getMenuModifyFormAjax/" + categoryId + "/" + menuSq,
		success : function(data) {
			$("#menuForm").empty();
			$("#menuForm").html(data);
		},
		error : function(xhr) {
			alert("error getMenuModifyFormAjax = " + xhr.statusText);
		}
	});
}

function modifyMenuAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/admin/modifyMenuAjax",
		data : $(formId).serialize(),
		success : function(data) {
			getMenuSearchPageAjax(data.categoryId);
			
			getMenuModifyFormAjax(data.categoryId, data.sq);
		},
		error : function(xhr) {
			alert("error modifyCategoryAjax = " + xhr.statusText);
		}
	});
}

function deleteMenuAjax(categoryId, menuSq) {
	$.ajax({
		type : "POST",
		url : "/admin/deleteMenuAjax/" + categoryId + "/" + menuSq,
		success : function(data) {
			getMenuSearchPageAjax(categoryId);
			
			getMenuInsertFormAjax();
		},
		error : function(xhr) {
			alert("error deleteCategoryAjax = " + xhr.statusText);
		}
	});
}
