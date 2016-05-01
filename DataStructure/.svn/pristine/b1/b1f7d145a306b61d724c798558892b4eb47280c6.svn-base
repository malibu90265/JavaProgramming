<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/domain.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/domain.js"/>"></script>
<script type="text/javascript">
	var domain_id;
	
	$(document).ready(function() {
			getDomainListAjax();
			getDomainInsertPageAjax();
			
			$("#domainInputDiv").on("click", "#domainInsertBtn", function() {
				var each_domain = $("#each_domain").val();
				if(validcheck(each_domain)){
					insertDomainAjax(each_domain);
				}
			});
			
			$("#domainListDiv").on("click", ".domainRow", function() {
				domain_id = $(this).children().eq(0).attr('id');
				var each_domain = $(this).children().eq(0).text();
				
				getDomainModifyPageAjax(domain_id,each_domain);
			});
			
			$("#domainInputDiv").on("click", "#domainModifyInsertBtn", function() {
				var formId = "#domainModifyForm";
				modifyDomainAjax(formId);
			});
			
			$("#domainInputDiv").on("click", "#domainModifyResetBtn", function() {
				getDomainInsertPageAjax();
			});
			
			$("#domainInputDiv").on("click", "#domainModifyDeleteBtn", function() {
				if(confirm("정말 삭제하시겠습니까??")) {
					var each_domain = $("#each_domain").val();
					deleteDomainAjax(each_domain);
				}
			});
	});	
</script>

<h2 id="domainContentsTitle">업무분류</h2>

<div id="domainListDiv" style="float:left;"></div>
<div id="domainInputDiv" style="float:left;"></div>	
