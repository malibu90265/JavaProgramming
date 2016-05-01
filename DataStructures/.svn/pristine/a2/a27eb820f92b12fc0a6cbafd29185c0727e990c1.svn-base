<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		
		getDeployRequirementsConditionsAjax(0);
		
		$("   ").keyup(function(){
			
			var requirePerson = $(" ").val();
			
			getDeployRequirementsConditionsAjax(requirePerson);
			
		});
		
	});
</script>
</head>
<body>
	
	<div>
		<form:form commandName="deployManagementSearchForm" id="deployManagementSearchForm" name="deployManagementSearchForm" method="post">
		<span>인력 배치 관리</span>
<%-- 
		<table>
			<tr>
				<th>성명</th>
				<td>${ }</td>
				<th>투입기간</th>
				<td>${ }</td>		<!-- 시작일/종료일 -->
				<td>${ }</td>
			</tr>
			
		</table>
 --%>		
		<button>등록</button>
		<button>검색</button>
		<button>삭제</button>
		<button>취소</button>
		
		
		<div id="deployManagementSearchDetailForm">

		</div>


		</form:form>
	</div>

	
</body>
</html>