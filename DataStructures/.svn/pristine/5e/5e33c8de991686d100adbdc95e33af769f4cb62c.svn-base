<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 정보 관리</title>

<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="<c:url value="/resources/js/humanResource/jquery-ui.css"/>">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResourceCalender.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResource.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResourcePopup.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResourceVaildCheck.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var hr_name;
		// 기본 출력 : 헤더, 검색, 리스트, 새로저장 폼
		getMiniHeaderAjax();
		// 검색 화면
		getHumanResourceSearchForm();
		// 직원 List
		getHumanResourceList();
		//Insert 화면 가져오기 
		getHumanResourceInsertForm();
		
		
		$("#humanResourceDetailForm").hide();
		
		// 리스트 td 클릭 : 수정 화면으로 넘어감
		$("#humanResourceList").on("click", "#humanResourceTd", function() {
			
			$(".selected").removeClass("selected");
			$(this).addClass("selected");
			
			hr_name = $(this).children().eq(1).text();
			$("#humanResourceInsertFormDiv").hide();
			$("#humanResourceDetailForm").show();
			getHumanResourceModifyForm(hr_name);
		});
		
		// 새로 저장 : 저장 버튼
		/* $("#humanResourceInsertFormDiv").on("click", "#humanResourceInsertBtn", function(){
			
			// validation Check
			var insertFormId = "#humanResourceInsertForm";
			var hr_name = $(insertFormId).find("#hr_name").val();
			//inputChk(insertFormId);
			if(inputChk(insertFormId) == false) {
			}
			else {
				getSamePersonCheck2(hr_name);
				humanResourceInsertForm(insertFormId);
				alert("저장되었습니다.");
			}
		});
		 */
		// 동일인 체크
		$("#humanResourceInsertFormDiv").on("click", "#samePersonCheckBtn", function() {
			var form = "#humanResourceInsertForm";
			var hr_name = $(form).find("#hr_name").val();
			if(hr_name == null || hr_name == '') {
				alert("이름을 입력해 주세요.");
			}
			else {
				getSamePersonCheck(hr_name);
			}
		});
		
		// 새로 저장 : 비우기 버튼
		$("#humanResourceInsertFormDiv").on("click", "#humanResourceResetBtn", function() {
			document.humanResourceInsertForm.reset();
		});
		
		 /* // 수정 : 저장 버튼
 		$("#humanResourceDetailForm").on("click", "#humanResourceModifyBtn", function() {
			
			// validation Check
			var formId = "#humanResourceModifyForm";
			//modifyChk(formId);
			if(modifyChk(formId) == false) {
			}
			else {
					getHumanResourceModifyForm2(formId);
					alert("저장되었습니다.");
					$("#humanResourceModifyForm").empty();
					getHumanResourceModifyForm(hr_name);
				 } 
			
		});  */
		
		// 수정 : 비우기 버튼
		$("#humanResourceDetailForm").on("click", "#humanResourceResetBtn", function() {
			$("#humanResourceInsertFormDiv").show();
			$("#humanResourceDetailForm").hide();
		});
		
		// 삭제
		$("#humanResourceDetailForm").on("click", "#humanResourceDeleteBtn", function() {
			if (confirm("정말 삭제하시겠습니까??")) {
				getHumanResourceDeleteFormAjax("#humanResourceModifyForm");
				getHumanResourceInsertForm();
			}
		});
		
		// 프로젝트 수행이력 버튼
		$("#humanResourceDetailForm").on("click", "#humanResourceProjectHistoryBtn", function() {
			var form = "#humanResourceModifyForm";
			var hr_name = $(form).find("#hr_name").val();
			
			getPJWorkingHistoryPopupAjax(hr_name);
			
		});
		
	});
</script>
<style type="text/css">
	.search {width: 100%;}
	#humanResourceList {width: 100%; height: 60vh; height: 60vm; overflow-y:auto; overflow-x: hidden;}
	.leftContents, .rightContents {font-size: 1.5vh; font-size: 1.5vm;}
</style>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader"></div>
	
	<div style="clear: inherit;"></div>
	
	<div class="container">
		<div class="contents">
			<table id="topTableName">
				<tr>
					<th><p id="contentsTitle">직원정보관리</p></th>
				</tr>
			</table>
			<div class="leftContents">
				<!-- 검색 -->
				<div id="humanResourceSearchForm" class="search" ></div>
				<div style="clear: inherit;"></div>
				
				<!-- 팀별 인력 List -->
				<div id="humanResourceList"></div>
				<div style="clear: inherit;"></div>
			</div>
			<div class="rightContents">
				<div id="humanResourceInsertFormDiv" class="bordered" ></div>
				<div style="clear: inherit;"></div>
			
				<!-- 인력 상세 테이블 -->
				<div id="humanResourceDetailForm" class="bordered" ></div>
				<div style="clear: inherit;"></div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
</body>

	<!-- PJ수행이력 팝업 -->
	<div id="pjWorkingHistoryDiv" >
	</div>	
</html>