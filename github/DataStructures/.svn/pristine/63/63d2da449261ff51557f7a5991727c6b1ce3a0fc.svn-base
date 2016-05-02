function getDomainListAjax() {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getDomainListAjax",
		success:function(data) {
			$("#domainListDiv").empty();
			$("#domainListDiv").html(data);
		
		}, error: function(xhr) {
			alert("error getDomainListAjax = " + xhr.statusText);
		}
	});
}

function getDomainInsertPageAjax(){
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getDomainInsertPageAjax",
		success:function(data) {
			$("#domainInputDiv").empty();
			$("#domainInputDiv").html(data);
		
		}, error: function(xhr) {
			alert("error getDomainInsertPageAjax = " + xhr.statusText);
		}
	});
}

function insertDomainAjax(each_domain){
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/insertDomainAjax",
		data : {"each_domain" : each_domain},
		success:function(data) {
			alert(data.message);
			getDomainListAjax();
			getDomainModifyPageAjax(each_domain);
		
		}, error: function(xhr) {
			alert("error insertDomainAjax = " + xhr.statusText);
		}
	});
}

function getDomainModifyPageAjax(domain_id,each_domain) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/getDomainModifyPageAjax",
		success:function(data) {
			$("#domainInputDiv").empty();
			$("#domainInputDiv").html(data);
			
			$("#domain_id").val(domain_id);
			$("#each_domain").val(each_domain);
			
		}, error: function(xhr) {
			alert("error getDomainModifyPageAjax = " + xhr.statusText);
		}
	});
}

function modifyDomainAjax(formId) {
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/modifyDomainAjax",
		data : $(formId).serialize(),
		success:function(data) {
			alert(data.message);
			
			getDomainListAjax();
			getDomainInsertPageAjax();
		}, error: function(xhr) {
			alert("error modifyDomainAjax = " + xhr.statusText);
		}
	});
}


function deleteDomainAjax(each_domain){
	$.ajax({
		type:"post",
		url:"/admin/basicInfo/deleteDomainAjax",
		data : {
			"each_domain" : each_domain
		},
		success:function(data) {
			alert("삭제되었습니다.");
			getDomainListAjax();
			getDomainInsertPageAjax();
		}, error: function(xhr) {
			alert("error insertDomainAjax = " + xhr.statusText);
		}
	});
}


function validcheck(each_domain){
	if(each_domain == "" || each_domain == null){
		alert("업무분류를 입력해주세요.");
		return false;
	}
	return true;
}
