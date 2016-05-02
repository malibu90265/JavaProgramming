<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>배치소요관리</title>
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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/deployRequirements/deployRequirements.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/endDateCheck.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var pj_start_date, pj_end_date;
		getMiniHeaderAjax();
		selectTeam();
		searchDeployRequirements("1S15");		

		$("#deployRequirementsDiv").on("click", ".deployRequirementsRow", function() {
			// ToDo 선택된 항목(this) 색 바꾸기
			var pj_id = $(this).children().eq(0).text();
						
			$(".selected").removeClass("selected");
			$(this).addClass("selected");
			
			getDeployRequirementsDetailForm(pj_id);
		});

		//저장버튼
		$("#deployRequirementsForm").on("click", "#deployRequirementsInsertBtn", function() {
					
			var cnt = $("#requirePerson").val();	if(cnt == null || cnt == "") {cnt = 0;}
			var pj_id = $("#pj_detail_id").text();
			
			var pr_sq;
			var pr_grade;
			var pr_job_skill;
			var pr_start_date;
			var pr_end_date;
			var pr_uprice;
			var pr_name;
			
			pj_start_date = $("#pj_start_date").val();
			pj_end_date = $("#pj_end_date").val();
					
			/* 배치예정자를 비워두지 않고 이름을 입력했는데 그 이름으로 등록된 사람이 없을때 체크 */
			for(var i=1; i<=cnt; i++) {
				if($('#pr_name' + i).val() != '' || $('pr_name' + i).val() != null) {
					var txtMerge = ($("#hr_grade" + i).text() + $("#hr_uprice" + i).text() + $("#hr_residence" + i).text()).replace(" ", "");
					if(txtMerge == null || txtMerge == '') {
						alert("인력 정보에 없는 데이터입니다.");
						$('#pr_name' + i).val('');
						$('#pr_name' + i).focus();
						return false;
					}
				}
			}
			
			/*등급과 직무기술을 선택했는지 확인*/
			for(var i=1; i<=cnt; i++) {
				if($('#ranks' + i).val() == '선택') {
					alert("등급을 선택해주세요.");
					return false;
				}
				if($('#skill'+i).val() == '선택') { //선택 앞에 빈칸 일부러 냅둔거! DB에 저렇게 저장되어있음
					alert("기술을 선택해주세요.");
					return false;
				}
			}
			
			var pr_name1, pr_name2, pr_start_date1, pr_start_date2, pr_end_date1, pr_end_date2;
			
			/* 같은 직원이 소요 기간이 겹치는지 확인*/
			for(var i=1; i<cnt; i++){
				for(var j=i+1; j<=cnt; j++){
					pr_name1 = $("#pr_name"+i).val();
					pr_name2 = $("#pr_name"+j).val();
					pr_start_date1 = $("#pr_start_date"+i).val().replace(/-/g, "");
					pr_end_date1 = $("#pr_end_date"+i).val().replace(/-/g, "");
					pr_start_date2 = $("#pr_start_date"+j).val().replace(/-/g, "");
					pr_end_date2 = $("#pr_end_date"+j).val().replace(/-/g, "");
					
					if((pr_name1==pr_name2) && (pr_name1 != null) && (pr_name1 != "")){
						if(pr_start_date1 <= pr_start_date2 && pr_start_date2 <= pr_end_date1){
							alert("소요번호 "+ i+ "와 "+ j +"의 소요 날짜가 중복됩니다. 날짜를 확인해주세요.");
							return false;
						}
						else if(pr_start_date1 <= pr_end_date2 && pr_end_date2 <= pr_end_date1){
							alert("소요번호 "+ i+ "와 "+ j +"의 소요 날짜가 중복됩니다. 날짜를 확인해주세요.");
							//alert("같은 직원의 소요 날짜가 중복됩니다. 날짜를 확인해주세요.")							
							return false;
						}
						else if(pr_start_date2 <= pr_start_date1 && pr_end_date2 <= pr_end_date1){
							alert("소요번호 "+ i+ "와 "+ j +"의 소요 날짜가 중복됩니다. 날짜를 확인해주세요.");
							//alert("같은 직원의 소요 날짜가 중복됩니다. 날짜를 확인해주세요.")							
							return false;
						}
					}
				}
			}
					
			/* 모든 유효성 검사가 끝나고 값을 입력하는 로직 */
			for(var i=1; i <= cnt; i++) {
				pr_sq = i;
				pr_grade = $("#ranks" + i + " option:selected").val();
				pr_job_skill = $("#skill" + i + " option:selected").val();
				pr_start_date = $("#pr_start_date" + i).val();
				pr_end_date = $("#pr_end_date" + i).val();
				pr_uprice = $("#pr_uprice" + i).val().replace(",", "");		if(pr_uprice == null || pr_uprice == "") {pr_uprice = 0;}	//Controller 에서 Integer형 변환을 위한 초기화
				pr_name = $("#pr_name" + i).val();
				
					insertPjRequire(pj_id, pr_sq, pr_grade, pr_job_skill, pr_start_date, pr_end_date, pr_uprice, pr_name);
			}
			deletePjRequireAfterInsert(pj_id, cnt);
			getDeployRequirementsDetailForm(pj_id);
			alert("저장되었습니다.");
		});
		
		//비우기 버튼
		$("#deployRequirementsForm").on("click","#deployRequirementsResetBtn", function() {
			resetBtnClick();
		});
		
	});
	
	function checkPjDate(id){
		alert(id);
		var pj_start_date = $("#deployRequirementsForm #pj_start_date").val();
		alert(pj_start_date);
	}
		
</script>
<style type="text/css">
#deployRequirementsSearch {
	width: 80%;
	font-size: 1.5vh;
	font-size: 1.5vm;
	float: left;
	clear: right;
}

#deployRequirementsDiv {
	clear: both;
	width: 80%;
	font-size: 1.5vh;
	font-size: 1.5vm;
}

#deployRequirementsForm {
	width: 100%;
	font-size: 1.5vh;
	font-size: 1.5vm;
}

</style>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader">
		
	</div>
	<div style="clear: right;"></div>
	
	<!-- 전체를 container div로 감싸야 footer가 아래로 붙습니다. -->
	<div class="container">
		<!-- 해당 page 이름 -->
		<table id="topTableName">
			<tr>
				<th><p id="topTableP">배치소요관리</p></th>
			</tr>
		</table>
		<div style="clear: both;"></div>
		<!-- 이전 버튼 : 직원정보 -->
			<%-- <a id="preEmployInfoAtag" href="<c:url value="/humanResource/humanResource"/>">
				<div id="preEmployInfo" >
					<div id="insidePreEmployInfo">직원정보</div>
				</div>
			</a> --%>
		<div style="clear: inherit;"></div>
		
		<div class="leftContents">
			<!-- Search form -->
		 	<div id="deployRequirementsSearch" class="search" >	</div> 
		 	
			<!-- List -->
			<div id="deployRequirementsDiv" class="bordered" ></div>
		</div>
		
		<div style="clear: inherit;"></div>
		
		<div class="rightContents">
			<!-- Detail & Insert Form -->
			<div id="deployRequirementsForm" class="inputbordered"></div>
			<div style="clear: both" ></div>
		</div>
		
		<div style="clear: inherit;"></div>
		<!-- 이전 버튼 : 직원정보 -->
			<a id="afterEmployInfoAtag" href="<c:url value="/humanResource/undecided"/>">
				<div id="afterEmployInfo" >
					<div id="insideAfterEmployInfo">인력<br/>미결현황</div>
				</div>
			</a>
		<div style="clear: both;"></div>
		
	</div><!-- container -->

</body>
</html>


