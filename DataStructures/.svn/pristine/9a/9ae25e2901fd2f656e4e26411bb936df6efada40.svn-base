<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>소요관리</title>
	<link	rel="stylesheet"
			href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
			type="text/css" />
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/test/deployRequirements.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/common/calender.js"/>"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			getDeployRequirementsList();
			//달력을 사용하기 위해 초기화 한다.
			//한국식 달력의 월, 일, 날짜가 모두 포함된 상태로 초기화된다.
			initCalendar();
			
			getDeployRequirementsInsertForm();
			
					
			$("#deployRequirementsDiv").on("click", ".deployRequirementsRow", function(){
				var pjId = $(this).children().eq(2).text(); 
				getDeployRequirementsModifyForm(pjId);
			})
			
			// 추가버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsInsertBtn", function(){
				
				//
				var insertFormId = $("#deployRequirementsForm").find("#deployRequirementsInsertForm").attr("id"); 
				alert(insertFormId);
				
				// ajax serializable
				
				/* getDeployRequirementsList();
				getDeployRequirementsInsertForm(); */
			});
			
			// 수정버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsModifyBtn", function(){
				var pjId = $("#deployRequirementsForm").find("#pj_id").text();
				//alert(pjId);
				getDeployRequirementsModifyForm(pjId);
			});
			
			// 삭제버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsDeleteBtn", function(){
				alert("삭제");
			});
			
			// 초기화 & 처음으로 버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsResetBtn", function(){
				getDeployRequirementsInsertForm();
			});
			
			// 저장버튼
			$("#deployRequirementsForm").on("click", "#deployRequirementsSaveBtn", function(){
				var needsData = [];
				var indexOfTable = 0;	//전체 컬럼의 인원번호를 저장하는 인덱스
				
				$("#pjNeedsTable tbody tr").each(function(k,v){
					var saveTr = {};
					
					var pjNeedsArea		= $(v).find("[id=pjNeedsArea]").val();
					var pjNeedsDivision = $(v).find("[id=pjNeedsDivision]").val();
					var pjSkill			= $(v).find("[id=pjSkill]").val();
					var pjGrade			= $(v).find("[id=pjGrade]").val();

					var startNeedsDate	= $(v).find("[id=startNeedsDate]").val();
					var endNeedsDate	= $(v).find("[id=endNeedsDate]").val();
							
					console.log(pjNeedsArea + "/" + pjNeedsDivision + "/" + pjSkill + "/" 
											+ pjGrade + "/" + startNeedsDate + "/" + endNeedsDate);
					
					saveTr['pj_id']			= $("#deployRequirementsForm").find("#pj_id").text();
					
					saveTr['pn_num']		= indexOfTable;
					saveTr['pn_grade']		= pjGrade;
					saveTr['pn_skill']		= pjSkill;
					saveTr['pn_day_from']	= startNeedsDate;
					saveTr['pn_day_to']		= endNeedsDate;
					saveTr['area']			= pjNeedsArea;
					saveTr['division']		= pjNeedsDivision;
					
					indexOfTable++;
					needsData.push(saveTr);

				});
				//alert(needsData);
				//alert("저장");
				
				//데이터를 저장하기 전에 기존의 테이블을 삭제 후 저장
				if(confirm("저장하시겠습니까?")) {
					$.ajax({
						type : "POST",
						url:"/pjNeedsInsertData.ajax.action",
						async : false,
						dataType : "json",
						data:{
							pj_id		: $("#pj_id").val()
							, pn_num	: indexOfTable
							, list		: JSON.stringify(needsData)
						},
						success : function(data) {
							//저장후 프로젝트 재검색		pjneeds_search.js
							if(data.result) {
								alert("저장되었습니다.");
								getDeployRequirementsList();
							};
						},
						error : function(xhr) {
							alert("error html = " + xhr.statusText);
						}
					});
				}
				
			});
			
			// 취소버튼 - 상세보기 상황으로 돌아가야함
			$("#deployRequirementsForm").on("click", "#deployRequirementsCancelBtn", function(){
				alert("취소");
			});
			
			// 되돌리기버튼 - 수정하다가 수정하기 전의 input 상황으로 되돌리기
			$("#deployRequirementsForm").on("click", "#deployRequirementsBackBtn", function(){
				alert("되돌리기");
			});
			
		});
	</script>
</head>
<body>
	
	<h3>소요배치</h3>
	
	<span>전체</span><span>미배치</span><span>미투입</span>
	
	<!-- List -->
	<div id="deployRequirementsDiv"style="padding-top: 50px;">
	
	</div>
	
	<!-- 입력 Form -->
	<div id="deployRequirementsForm" style="float: left; padding-left: 200px">
	
	</div>
	
	<div style="clear: both"></div>
</body>
</html>