function getMainPageAjax() {
	getSkillEnvMainPageAjax();
	getDomainMainPageAjax();
	getJobSkillMainPageAjax();
	getRoleMainPageAjax();
	getPjStageMainPageAjax();
	getPjStatusMainPageAjax();
}

function getSkillEnvMainPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getSkillEnvMainPageAjax",
		success:function(data) {
			$("#skillEnvMainDiv").empty();
			$("#skillEnvMainDiv").html(data);
		}, error: function(xhr) {
			alert("error getSkillEnvMainPageAjax = " + xhr.statusText);
		}
		
	});
}

function getDomainMainPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getDomainMainPageAjax",
		success:function(data) {
			$("#domainMainDiv").empty();
			$("#domainMainDiv").html(data);
		}, error: function(xhr) {
			alert("error getDomainMainPageAjax = " + xhr.statusText);
		}
		
	});
}

function getJobSkillMainPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getJobSkillMainPageAjax",
		success:function(data) {
			$("#jobSkillMainDiv").empty();
			$("#jobSkillMainDiv").html(data);
		}, error: function(xhr) {
			alert("error getJobSkillMainPageAjax = " + xhr.statusText);
		}
		
	});
}

function getRoleMainPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getRoleMainPageAjax",
		success:function(data) {
			$("#roleMainDiv").empty();
			$("#roleMainDiv").html(data);
		}, error: function(xhr) {
			alert("error getRoleMainPageAjax = " + xhr.statusText);
		}
		
	});
}

function getPjStageMainPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getPjStageMainPageAjax",
		success:function(data) {
			$("#pjStageMainDiv").empty();
			$("#pjStageMainDiv").html(data);
		}, error: function(xhr) {
			alert("error getPjStageMainPageAjax = " + xhr.statusText);
		}
		
	});
}

function getPjStatusMainPageAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getPjStatusMainPageAjax",
		success:function(data) {
			$("#pjStatusMainDiv").empty();
			$("#pjStatusMainDiv").html(data);
		}, error: function(xhr) {
			alert("error getPjStatusMainPageAjax = " + xhr.statusText);
		}
		
	});
}