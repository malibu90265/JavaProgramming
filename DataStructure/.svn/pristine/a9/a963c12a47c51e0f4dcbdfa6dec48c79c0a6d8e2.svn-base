<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>인력투입관리</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/bottom-area.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/employee_css/standardform.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/employeeInput/employeeInput.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script> 
<script type="text/javascript">

	$(document).ready(function() {
		var pj_id, pd_sq;
		var b4_pd_name="";
		var pd_name;
		var pd_start_date;
		var pd_end_date;
		
		getMiniHeaderAjax(); //나중에 마이메뉴 완성되면 주석없애기!
		selectTeam();
		searchEmployeeInput("1S15");
		
		
		//프로젝트 선택시
		$("#employeeInputList").on("click", ".employeeInputRow",function() {
			
			$(".selected").removeClass("selected");
			$(this).addClass("selected");
			
			pj_id = $(this).children().eq(0).text();

			getEmployeeInputDetailForm1(pj_id);
			getEmployeeInputInsertForm();
			getEmployeeInputDetailForm2(pj_id);
		});
				
		//직원 선택시
		$("#employeeInputDetailForm2").on("click", ".employeeInputRow", function() {
			
			$(".selectedemp").removeClass("selectedemp");
			$(this).addClass("selectedemp");
			b4_pd_name = $(this).children().eq(1).text();
			pd_sq = $(this).children().eq(0).text();
			pd_name = $(this).children().eq(1).text();
			pr_sq = $(this).children().eq(2).text(); 
			getEmployeeInputInfoForm(pd_sq, pj_id, pd_name,pr_sq); 
			if(pd_sq == 0) {
				$("#pd_start_date").val($(this).children().eq(4).text());
				$("#pd_end_date").val($(this).children().eq(6).text());
				pd_start_date = $("#pd_start_date").val();
				pd_end_date = $("#pd_end_date").val();
			}
		});
				
		//저장 버튼
		$("#employeeInputInsertForm").on("click","#employeeInputInsertBtn",function() {
			pd_sq = $("#pd_sq").text();
			pd_name = $("#pd_name").val();
			var pr_sq = $("#pr_sq").text();
			pd_start_date = $("#pd_start_date").val();
			pd_end_date = $("#pd_end_date").val();
			var pd_uprice = $("#pd_uprice").text().replace(",", "");
			var pd_ratio = $("#pd_ratio").val();
			
			if(pd_start_date == '')
				pd_start_date = '0000-00-00';
			if(pd_end_date == '')
				pd_end_date = '0000-00-00';
			
			
			
			/* 투입 예정자를 비워두지 않고 이름을 입력했는데 그 이름으로 등록된 사람이 없을때 체크 */
			if($('#pd_name').val() != '' || $('pd_name').val() != null) {
				var txtMerge = ($("#pd_uprice").text() + $("#hr_grade").text() + $("#hr_cwm_env").text()
								+ $("#hr_job_skill").text() + $("#hr_abc").text() + $("#hr_residence").text()).replace(" ", "");
				if(txtMerge == null || txtMerge == '') {
					alert("인력 정보에 없는 데이터입니다.");
					$('#pd_name').val('');
					$('#pd_name').focus();
					return false;
				}
			}
			
			insertPjDeploy(b4_pd_name,pj_id, pd_sq, pd_name, pr_sq,pd_start_date, pd_end_date, pd_uprice, pd_ratio);
			//updateCost(pj_id);
			
			//기간 중복 검사
			/* checkDuplicate(b4_pd_name, pj_id, pd_sq, pr_sq, pd_uprice, pd_ratio, pd_name, pd_start_date, pd_end_date); */
			
		});
				
		//삭제 버튼
		$("#employeeInputInsertForm").on("click", "#employeeInputDeleteBtn", function() {
					
			if(confirm("정말 삭제하시겠습니까?")) {
				deletePjDeploy(b4_pd_name, pd_name,pj_id,pd_sq);
				alert("삭제되었습니다.");
				getEmployeeInputInsertForm();
				getEmployeeInputDetailForm2(pj_id);
			}				
		});

		//비우기 버튼
		$("#employeeInputInsertForm").on("click", "#employeeInputResetBtn", function() {
			//resetEmployeeInputInsertForm();
			getEmployeeInputInsertForm();
			/* $("#pd_name").val("");
			$("#pd_start_date").val("");
			$("#pd_end_date").val("");
			$("#pd_uprice").text("");
			$("#hr_grade").text("");
			$("#hr_cwm_env").text("");
			$("#hr_job_skill").text("");
			$("#hr_abc").text("");
			$("#hr_residence").text(""); */
		});

	});

</script>
<style type="text/css">
	#employeeInputSearch {border:none; width:80%; font-size: 1.5vh; font-size: 1.5vm;}
	#employeeInputList {clear: both; width:80%; font-size: 1.5vh; font-size: 1.5vm;}
	#employeeInputDetailForm1 {width:100%; font-size: 1.5vh; font-size: 1.5vm;}
	#employeeInputInsertForm {width:100%; margin-top:20px; font-size: 1.5vh; font-size: 1.5vm;}
	#employeeInputDetailForm2 {width:100%; overflow-y:scroll; max-height:50vh; max-height:50vm; margin-top:20px; font-size: 1.5vh; font-size: 1.5vm;}
	.leftContents {float:left; display: inline-block; width : 23%; margin-left:7%; margin-top: 50px; clear: inherit; }
	.rightContents {float:left; display: inline-block; text-align: center; width : 60%; margin-left:3%; margin-top: 6.5%; clear: inherit; }
</style>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader">
	</div>
	<div style="border:none; clear: right;"></div>
	
	<div class="container">
		<!-- 해당 page 이름 -->
		<div class="leftContents">
			<table id="topTableName">
				<tr>
					<th id="topTableP">인력 투입 관리</th>
				</tr>
			</table>
			<!-- Search form -->
		 	<div id="employeeInputSearch" class="search"></div> 
		 	<div style="clear: right;" ></div>
			<!-- List -->
			<div id="employeeInputList" class="bordered" ><br></div>
			<div style="clear: right;" ></div>
		</div>
		
		<div class="rightContents">
			<!-- DetailForm1 -->
			<div id="employeeInputDetailForm1" class="inputbordered" style="width:500px;"></div>
			<div style="clear: both" ></div>
			<!-- InsertForm -->
			<div id="employeeInputInsertForm" class="inputbordered" ></div>
			<div style="clear: both" ></div>
			<!-- DetailForm2 -->
			<div id="employeeInputDetailForm2" class="inputbordered" ></div>
		</div>
		<div style="clear: both" ></div>
	</div>

</body>
</html>


