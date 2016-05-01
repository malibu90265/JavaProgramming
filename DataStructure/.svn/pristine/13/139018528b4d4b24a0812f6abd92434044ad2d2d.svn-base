<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>외주 정보</title>

<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="<c:url value="/resources/js/humanResource/jquery-ui.css"/>">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResourceCalender.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/humanResource/outHumanResource.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResourcePopup.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/humanResourceVaildCheck.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var hr_name;
		//기본출력 : header, search, list, insert Form
		getMiniHeaderAjax();
		getOutHumanResourceSearchForm();
		getOutHumanResourceList();
		getOutHumanResourceInsertForm();
		// 리스트 td 클릭 : 수정 화면으로 넘어감
		$("#outHumanResourceList").on("click", ".humanResourcesTd", function() {
			
			$(".selected").removeClass("selected");
			$(this).addClass("selected");
			
			var hr_name = $(this).children().eq(0).text().trim();
			$("#outHumanResourceInsertFormDiv").hide();
			$("#outHumanResourceDetailForm").show();
//			getHumanResourceModifyForm(hr_name);
			getOutHumanResourceModifyForm(hr_name);
		});
		
		/*
			2015.10.08 할일
			1. insert 시 button 작동하는지
			2. 전체적인 UI
			3. detail Form
			4. detail 시 button 작동하는지.
			5. 외주에서 list 선택했을 때 선택한 표시 나오게.
			
		*/
		
		
		
		//$("#outHumanResourceDetailForm").hide();
		
		// 새로 저장 : 저장 버튼
		$("#outHumanResourceInsertFormDiv").on("click", "#humanResourceInsertBtn", function(){
			
			// validation Check
			var insertFormId = "#outHumanResourceInsertForm";
			hr_name = $(insertFormId).find("#hr_name").val();
			//inputChkOut(insertFormId);
			if(inputChkOut(insertFormId) == false) {
			}
			else {
				getSamePersonCheck2(hr_name);
				outHumanResourceInsertForm(insertFormId);
				alert("저장되었습니다.");
			}
		});
		
		// 동일인 체크
		$("#outHumanResourceInsertFormDiv").on("click", "#samePersonCheckBtn", function() {
			var form = "#outHumanResourceInsertForm";
			var hr_name = $(form).find("#hr_name").val();
			if(hr_name == null || hr_name == '') {
				alert("이름을 입력해 주세요.");
			}
			else {
				getSamePersonCheck(hr_name);
			}
		});
		
		// 새로 저장 : 비우기 버튼
		$("#outHumanResourceInsertFormDiv").on("click", "#humanResourceResetBtn", function() {
			document.humanResourceInsertForm.reset();
		});
		
		// 수정 : 저장 버튼
		$("#outHumanResourceDetailForm").on("click", "#humanResourceInsertBtn", function() {
			hr_name = $("#outHumanResourceModifyForm").find("#hr_name").val();
			// validation Check
			var formId = "#outHumanResourceModifyForm";
			//modifyChk(formId);
			if(modifyChk(formId) == false) {
			}
			else {
				getOutHumanResourceModifyForm2(formId, hr_name);
			}
		});

		// 수정 : 비우기 버튼
		$("#outHumanResourceDetailForm").on("click", "#humanResourceResetBtn", function() {
			$("#outHumanResourceInsertFormDiv").show();
			$("#outHumanResourceDetailForm").hide();
		});
		
		// 삭제
		$("#outHumanResourceDetailForm").on("click", "#humanResourceDeleteBtn", function() {
			var form = "#outHumanResourceDetailForm";
			var hr_name = $(form).find("#hr_name").val();
			if (confirm("정말 삭제하시겠습니까??")) {
				getOutHumanResourceDeleteFormAjax(hr_name);
				$("#outHumanResourceInsertFormDiv").show();
				$("#outHumanResourceDetailForm").hide();
				//document.humanResourceInsertForm.reset();
			}
			
		});
		
		// 프로젝트 수행이력 버튼
		$("#outHumanResourceDetailForm").on("click", "#humanResourceProjectHistoryBtn", function() {
			var form = "#outHumanResourceDetailForm";
			var hr_name = $(form).find("#hr_name").val();
			
			getPJWorkingHistoryPopupAjax(hr_name);
			
		});
	});
</script>
<style type="text/css">
	.search {width: 70%;}
	.leftContents, .rightContents {font-size: 1.5vh; font-size: 1.5vm; white-space: nowrap;}
	#outHumanResourceList {width: 100%; height: 70vh; height: 70vm; overflow-y:auto; overflow-x: hidden; }
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
					<th><p id="contentsTitle">외주정보관리</p></th>
				</tr>
			</table>
			<div class="leftContents">
				<!-- 검색 -->
				<div id="outHumanResourceSearchForm" class="search" ></div>
				<div style="clear: inherit;"></div>
				
				<!-- 팀별 인력 List -->
				<div id="outHumanResourceList"></div>
				<div style="clear: inherit;"></div>
			</div>
			<div class="rightContents">
				<div id="outHumanResourceInsertFormDiv" class="bordered" ></div>
				<div style="clear: inherit;"></div>
			
				<!-- 인력 상세 테이블 -->
				<div id="outHumanResourceDetailForm" class="bordered" ></div>
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