<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<script src="resources/js/jquery-1.11.0.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="resources/js/jquery-1.11.0.js"></script>

<script src="resources/js/teamlist.js" type="text/javascript"></script>
<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    		return false;
    }
    return true;
}
function isFloat(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        if (charCode == 46)
        	return true;
        else 
    		return false;
    }
    return true;
}
	$(window).ready(function() {
		setTeam();
		//TODO
		setNav(0, 3);
	});
	function getTeam(team_id) {
		var formData = document.teamForm;
		formData.action = "getTeam.iqspf?team_id=" + team_id;
		formData.submit();
	}
</script>
<style type="text/css">
.hover tr:hover {
        background-color: #ffff99;font-weight:bold;
 }
</style>
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">연간목표</h1>

		<div id="left_main"
			style="width: 600px; background: white; margin-right: 20px; float: left;">
		</div>

		<div id="right_main"
			style="width: 600px; background: white; margin-right: 20px; float: left;">
			<p style="margin-top: 0px">
				<팀 목표 상세정보>
			</p>
			<table>
				<tr>

					<th width="150">팀 ID</th>
					<td width="150" align="center"><input type="text" class="text"
						name="team_id" id="team_id"
						style="ime-mode: disabled; text-align: center; width: 98%;" /></td>
				</tr>
				<tr>
					<th width="150">팀&nbsp;&nbsp;이름</th>
					<td width="150" align="center"><input type="text" class="text"
						name="team_name" id="team_name"
						style="ime-mode: disabled; text-align: center; center; width: 98%;" /></td>
				</tr>
				<tr>
					<th>계약목표</th>
					<td align="center"><input type="text" class="text"
						name="team_contract" id="team_contract"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)" /></td>
				</tr>
				<tr>
					<th>매출목표</th>
					<td align="center"><input type="text" class="text"
						name="team_income" id="team_income"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)" /></td>
				</tr>
				<tr>
					<th>순매출목표</th>
					<td align="center"><input type="text" class="text"
						name="team_netincome" id="team_netincome"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<th>이익목표</th>
					<td align="center"><input type="text" class="text"
						name="team_profit_loss" id="team_profit_loss"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)" /></td>
				</tr>
				<tr>
					<th>순매출BEP</th>
					<td align="center"><input type="text" class="text"
						name="team_bep" id="team_bep"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<th>예상 매출원가</th>
					<td align="center"><input type="text" class="text"
						name="team_netsales" id="team_netsales"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)" disabled="disabled" /></td>
				</tr>
				<tr>
					<th>예상 외주비</th>
					<td align="center"><input type="text" class="text"
						name="team_outsource" id="team_outsource"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)"
						value="${requestScope.vo.team_biz_cost_str}" /></td>
				</tr>
				<tr>
					<th>예상 상품비</th>
					<td align="center"><input type="text" class="text"
						name="team_product" id="team_product"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)"
						value="${requestScope.vo.team_indirect_cost_str}" /></td>
				</tr>
				<tr>
					<th>M/M</th>
					<td align="center"><input type="text" name="team_mm"
						id="team_mm"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						value="${requestScope.vo.team_mm}"
						onkeypress="return isFloat(event)" /></td>
				</tr>
				<tr>
					<th>목표 인원</th>
					<td align="center"><input type="text" class="text"
						name="team_mem" id="team_mem"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)"
						value="${requestScope.vo.team_mem}" /></td>
				</tr>
				<tr>
					<th>기본경비율</th>
					<td align="right"><input type="text" class="text"
						name="team_perofcost" id="team_perofcost"
						style="ime-mode: disabled; text-align: right; width: 89%"
						onkeypress="return isFloat(event)" />%</td>
				</tr>
				<tr>
					<th>팀공통경비</th>
					<td align="center"><input type="text" class="text"
						name="team_normal_cost" id="team_normal_cost"
						style="ime-mode: disabled; text-align: right; width: 98%;"
						onkeypress="return isNumber(event)"
						onkeyup="this.value=SetComma(this.value)"
						value="${requestScope.vo.team_normal_cost}" /></td>
				</tr>
			</table>
			<br />
			<div style="text-align: right; margin-top: 7px;">
				<input type="button" id="update" value="저장" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="delete" value="삭제" disabled /> <input
					type="button" id="cancel" value="취소" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>

		</div>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>