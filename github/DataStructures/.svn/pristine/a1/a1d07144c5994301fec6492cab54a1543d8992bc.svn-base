<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>humanResourceSearchForm</title>
<script type="text/javascript">

	var size = "${hrPriceList.size()}";
	$(document).ready(function() {
		
		if( $("#hp_mon_price").val() == "" ) {
			alert( "월단가를 입력해주세요" );
		}
		else if( $("#hp_mon_cost").val()  == "" ) {
			alert("월비용을 입력해주세요");
		}
		
		for(j = 1; j <= size; j++) {
			var priceId = "#hrPriceRow" + j + " .hp_mon_price";
			var costId = "#hrPriceRow" + j + " .hp_mon_cost";
			
			$(priceId).val( HPComma($(priceId).val()) );
			$(costId).val( HPComma($(costId).val()) );  
		} 
		
	});
	
</script>
</head>
<body>
	<form:form commandName="hrPriceInputVO" id="hrPriceInsertListForm" name="hrPriceInsertListForm" method="post">
	<table class="inputbordered">
		<tr>
			<th class="inputP">직급</th>
			<th class="inputMP">월 단가 (직접비)</th>
			<th class="inputMC">월 비용 (간접비 포함)</th>
		</tr>
		<c:forEach var="hrPrice" items="${hrPriceList}" varStatus="status">
			<tr id="hrPriceRow${status.count }" >
				<td class="inputP">${hrPrice.hp_position}
					<input type="hidden" id="hp_position" name="hp_position" value="${hrPrice.hp_position}"/>
				</td>
			 	<td class="inputMP"><input type="text" style="text-align: right; font-size: 17px;" class="hp_mon_price" name="hp_mon_price" size="8" value="${hrPrice.hp_mon_price}" onkeyup="numOnlyAndComma(this);"/></td>
				<td class="inputMC"><input type="text" style="text-align: right; font-size: 17px;" class="hp_mon_cost" name="hp_mon_cost" size="9" value="${hrPrice.hp_mon_cost}" onkeyup="numOnlyAndComma(this);"/></td> 
			</tr>
		</c:forEach>
	</table>

	<input type="hidden" id="hp_team" name="hp_team" value="${hrPrice.hp_team}"/>
	</form:form>
	
	<input type="hidden" id="hrListCount" value="${hrPriceList.size()}" />
		
	<div id="bottomLine">
		<span id="hrPriceInsertBtn">저장</span>
		<span id="hrPriceDeleteBtn">삭제</span>
		<span id="hrPriceResetBtn">비우기</span>
	</div>
</body>
</html>
