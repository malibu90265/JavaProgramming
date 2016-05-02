<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재무 정보</title>
<script type="text/javascript">
	
	function moneyUpdate(pj_id) {
		var formData = document.userForm;
		formData.action = "moneyUpdate.iqspf?pj_id=" + pj_id;
		formData.submit();
	}
</script>
</head>
<body>
	<center>
		<h2>재무 정보 수정</h2>
		<form name="userForm" method="post" action="budgetUpdate.iqspf">
			<table border="1">
				<tr>
					<td>프로젝트&nbsp;ID</td>
					<td>${requestScope.vo.pj_id}</td>
				</tr>
				<tr>
					<td>계약액</td>
					<td><input type="text" name="budget_contract_sales"
						value="${requestScope.vo.budget_contract_sales}" /></td>
				</tr>
				<tr>
					<td>매출액</td>
					<td><input type="text" name="budget_sales"
						value="${requestScope.vo.budget_sales}" /></td>
				</tr>
				<tr>
					<td>상품비</td>
					<td><input type="text" name="budget_product_cost"
						value="${requestScope.vo.budget_product_cost}" /></td>
				</tr>
				<tr>
					<td>외주비</td>
					<td><input type="text" name="budget_outsource_cost"
						value="${requestScope.vo.budget_outsource_cost}" /></td>
				</tr>
				<tr>
					<td align="center"><input type="button" value="입력"
						onclick="moneyUpdate('${requestScope.vo.pj_id}')"/></td>
					<td align="center"><input type="button" value="취소"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>