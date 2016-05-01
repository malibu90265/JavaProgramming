<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	// from to 검색
/* 	$('#monthSelectTo').change(function() {
		if($("#monthSelectFrom option:selected").val() == null) { // To 값을 선택하지 않아 키 값이 없는 경우 1을 넣습니다.
			var forMonth = "01";
			var fromMonth = parseInt(forMonth);	// 숫자로 변환합니다.
		}else {	// To 값을 선택했을 경우
			var forMonth = $("#monthSelectFrom option:selected").val();
			var fromMonth = parseInt(forMonth);
		}
		var tooMonth = $("#monthSelectTo option:selected").val();	// from 값은 null 상관 없이 변환합니다.
		var toMonth = parseInt(tooMonth);
		
		getwaitingListSearchAction(fromMonth, toMonth);
	}); */
	
	// radio button 검색
	$("input[name=w8Radio]").change(function () {
		var radioValue = $(this).val();
		var sysDateForW8 = new Date();
		var sysMonth = sysDateForW8.getMonth() + 1;
		
		var fromMonth ="", toMonth = "";
		
		if(radioValue == "now") {
			fromMonth = sysMonth;
			toMonth = sysMonth;
			getwaitingListSearchAction(fromMonth, toMonth);
		} else if(radioValue == "b4") {
			fromMonth = "01";
			toMonth = sysMonth;
			getwaitingListSearchAction(fromMonth, toMonth);
		} else if(radioValue == "after") {
			fromMonth = sysMonth;
			toMonth = "12";
			getwaitingListSearchAction(fromMonth, toMonth);
		}
	});
	
</script>
<style type="text/css">
	#waitingListSearchTable{width:100%; text-align: left;}
</style>
</head>
<body>

	<table id="waitingListSearchTable">
		<tr>
			<td>
				<input type="radio" name="w8Radio" value="now"  checked="checked"/>금월 대기/예정자조회
				<input type="radio" name="w8Radio" value="b4"/>대기자 조회
				<input type="radio" name="w8Radio" value="after"/>대기예정자조회
			</td>
		</tr>
	</table>
	
</body>
</html>