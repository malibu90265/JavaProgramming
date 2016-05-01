<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/role.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/role.js"/>"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		getRoleListAjax();
		getRoleInsertPageAjax();
		
		$("#RoleListDiv").on("click", ".roleRow", function(){
			var role_id = $(this).eq(0).attr("id");
			var each_role = $(this).eq(0).text();
			
			getRoleModifyPageAjax(role_id, each_role);
		});
		
		// 저장
		$("#RoleInputDiv").on("click", "#roleInsertBtn", function() {
			if($("#each_role").val() == "") {
				alert("역할을 입력해주세요.");
			}
			else {
				
				var each_role = $("#each_role").val();
				
				if( checkDuplicateYN(each_role) ){
					insertRoleAjax(each_role);
				}
				else {
					alert("이미 중복되는 역할이 존재합니다");
					$("#RoleInputDiv #each_role").focus();
				}
			}
		});
		
		// 수정
		$("#RoleInputDiv").on("click", "#roleModifyBtn", function() {
			if($("#each_role").val() == "") {
				alert("역할을 입력해주세요.");
			}
			else {
				var formId = "#roleModifyForm";
				var each_role = $("#each_role").val();
				
				if( checkDuplicateYN(each_role) ){
					modifyRoleAjax(formId);
				}
				else {
					alert("이미 중복되는 역할이 존재합니다");
				}
			}
		});
		
		// 삭제
		$("#RoleInputDiv").on("click", "#roleDeleteBtn", function() {
			var formId = "#roleModifyForm";
			deleteRoleAjax(formId);
		});
		
		// 비우기
		$("#RoleInputDiv").on("click", "#roleResetBtn", function() {
			getRoleInsertPageAjax();
		});
	});
		
</script>

<h2 id="roleContentsTitle">역할분류</h2>
<div id="RoleListDiv"></div>
<div id="RoleInputDiv"></div>	
