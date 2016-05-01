<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>소요배치</title>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Codrops" />
	<link rel="shortcut icon" href="../favicon.ico">
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/bottom-area.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/standardform.css" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/test/demoDeployRequirements.js"/>"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			getDemoDeployRequirementsList();
			
			getDemoDeployRequirementsInsertForm();
			
			$("#deployRequirementsDiv").on("click", ".deployRequirementsRow", function(){
				// ToDo 선택된 항목(this) 색 바꾸기
				
				var pjId = $(this).children().eq(1).text(); 
				
				getDemoDeployRequirementsDetailForm(pjId);
				
				$(".deployRequirementsRow").css({
					"background-color" : "white"
				});
				
				$(this).css({
					"background-color" : "#dcf3f1"
				});
				
			})
			 
			// 추가버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsInsertBtn", function(){
				var insertFormId = "deployRequirementsInsertForm";
				
				insertDemoDeployRequirements(insertFormId);
			});
			
			// 수정버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsModifyBtn", function(){
				var pjId = $("#deployRequirementsForm").find("#pjId").text();
				
				getDemoDeployRequirementsModifyForm(pjId);
			});
			
			// 삭제버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsDeleteBtn", function(){
				var pjId = $("#deployRequirementsForm").find("#pjId").text();
				
				getDemoDeployRequirementsDelete(pjId);
				
			});
			
			// 초기화 & 처음으로 버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsResetBtn", function(){
				getDemoDeployRequirementsInsertForm();
			});
			
			
			// 저장버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsSaveBtn", function(){
				var modifyFormId = "deployRequirementsModifyForm";
				
				getDemoDeployRequirementsSave(modifyFormId);
			});
			
			
			// 취소버튼 - 상세보기 상황으로 돌아가야함
			$("#deployRequirementsForm").on("click", "#deployRequirementsCancelBtn", function(){
				var pjId = $("#deployRequirementsForm").find("#pjId").val();
				
				getDemoDeployRequirementsDetailForm(pjId);
			});
			
			
			// 되돌리기버튼 - 수정하다가 수정하기 전의 input 상황으로 되돌리기
			$("#deployRequirementsForm").on("click", "#deployRequirementsBackBtn", function(){
				var pjId = $("#deployRequirementsForm").find("#pjId").val();
				
				getDemoDeployRequirementsModifyForm(pjId);
			}); 
			
		});
	</script>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<jsp:include page="./../common/login_header.jsp"></jsp:include>
	<div style="clear:both;"></div>
	
	<!-- 상단 (로고 + 즐겨찾기 + 쓰레기통) -->
	<jsp:include page="./../common/bookmark_header.jsp"></jsp:include>
	<div style="clear:both;"></div>

	<table id="topTableName">
		<tr>
			<th><p id="topTableP">소요배치</p></th>
		</tr>
		<tr>
			<td id="topTableTd"><span id="wholeBtn">전체</span><span id="unBatch">미배치</span><span id="miTuip">미투입</span></td>
		</tr>
	</table>
	<!-- List -->
	<div id="deployRequirementsDiv" class="bordered" >
	
	</div>
	
	<!-- 입력 Form -->
	<div id="deployRequirementsForm" class="inputbordered" >
	
	</div>
	<div style="clear: both"></div>
	
	<!-- 바닥 -->
	<jsp:include page="./../common/footer.jsp"></jsp:include>
</body>
</html>