<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="resources/css/common.css" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/js/pjpostingSearch.js" type="text/javascript"></script>
<script src="resources/js/skill.js" type="text/javascript"></script>
<script src="resources/js/area.js" type="text/javascript"></script>


<style type="text/css">
body {
	font-family: "NanumGothic", "Dotum", "Gulim", "Arial", sans-serif;
	width: 750px;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
}

.header {
	width: 100%;
	height: 70px;
	background-color: #02458B;
}

.header_area {
	width: 90%;
	height: 100%;
	left: 5%;
	position: relative;
}

.container {
	width: 90%;
	min-height: 820px;
	left: 5%;
	position: relative;
}

.header_area img {
	top: 8px;
	position: relative;
}

.header_area div {
	display: inline-block;
	height: 100%;
}

.header_area h1 {
	display: inline-block;
	color: white;
	margin-left: 30px;
}

.contents {
	display: inline-block;
	width: 1400px;
	vertical-align: top;
}

.contentsTitle {
	border-bottom: 1px solid grey;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

table th {
	background-color: rgb(232, 232, 232);
	border: 1px solid grey;
}

table td {
	border: 1px solid grey;
}
</style>

<script type="text/javascript">
	function popseach(){
		var result = {
				name : $("#searchname").val(),
				division : $("#searchdiv option:selected").val(),
				grade : $("#searchgrade option:selected").val(),
				area1 : $("#area100 option:selected").val(),
				area2 : $("#area100_1 option:selected").val(),
				groupcd : $("#skill100 option:selected").val(),
				skillcd : $("#skill100_1 option:selected").val(),
				endday : $("#searchcpendday").val()
				
			}
		
		//alert(result.endday);
			window.opener.check(result);
	}
	$(document).ready(function() {

		function calendar() {
			$.datepicker.regional['ko'] = {
				closeText : '닫기',
				prevText : '이전달',
				nextText : '다음달',
				currentText : '오늘',
				monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)',
						'5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)', '9월(SEP)',
						'10월(OCT)', '11월(NOV)', '12월(DEC)' ],
				monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
						'9월', '10월', '11월', '12월' ],
				dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
				dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
				weekHeader : 'Wk',
				dateFormat : 'yy-mm-dd',
				firstDay : 0,
				isRTL : false,
				showMonthAfterYear : true,
				yearSuffix : '',
				//         showOn: 'both',
				//         buttonText: "달력",
				changeMonth : true,
				changeYear : true,
				showButtonPanel : true,
				yearRange : 'c-99:c+99',
			};
			$.datepicker.setDefaults($.datepicker.regional['ko']);

			$('.searchcpendday').datepicker();
			
		}
	
		
		$('#searcharea').setSearchAreadiv();
		$('#searchSkill').setSearchSkilldiv();
		
		$("#getCheckedAll").click(function() {
			/* var result = {
				name : $("#searchname").val(),
				division : $("#searchdiv option:selected").val(),
				grade : $("#searchgrade option:selected").val(),
				area1 : $("#area100 option:selected").val(),
				area2 : $("#area100_1 option:selected").val(),
				groupcd : $("#skill100 option:selected").val(),
				skillcd : $("#skill100_1 option:selected").val(),
				endday : $("#searchcpendday").val()
				
			}
		
		
			window.opener.check(result); */
			popseach();
			
			
		});
		
 		calendar();
	});
	
</script>



<title>배치인원검색</title>
</head>
<body style="width: 450px; height: 150px;overflow-x:hidden;  overflow-y:auto;">
	<div class="header" style="height: 50px; width: 640px;">
		<div class="header_area" height="50px">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 600px; height: 300px;">

		<!-- TODO -->
		<h2 class="contentsTitle" style="width: 550px; margin: 5px">검색조건</h2>
		<form name="userForm">
			<input type="hidden" id="ldh" value="hello!"/>
			<table id="emptable"style="width: 550px">
				<tr>
				<th style="height: 30px" align="center">이름</th>
				<td style="width: 150px"><input style="height: 30px; width: 97%" type = "text" id= "searchname" name = "searchname"></td>
				<th style="height: 30px" align="center">직원구분</th>
					<td style="width: 150px"><select id="searchdiv"
						style="height: 30px; width: 100%" name="searchdiv">
							<option value="al">전체</option>
							<option value="직원">직원</option>
							<option value="외주">외주</option>
					</select></td>
				</tr>
				
				<tr>
					
					<th style="height: 30px" align="center">등급</th>
					<td style="width: 150px"><select id="searchgrade"
						style="height: 30px; width: 100%" name="searchgrade">
							<option value="al">전체</option>
							<option value="9초급">초급</option>
							<option value="8중급">중급</option>
							<option value="7고급">고급</option>
							<option value="6특급">특급</option>
					</select></td>
					<th style="height: 30px; width: 150px">투입가능일</th>
					<td colspan="4"><input type="text" style="height: 30px; width: 97%" class="searchcpendday" id="searchcpendday" ></td>
				</tr>



				<tr>
					<th style="height: 30px" align="center">보 유 기 술</th>
						<td colspan="3"><div id="searchSkill"></div></td>
				</tr>
				
				<tr>
					<th style="height: 30px" align="center">거주지</th>
					<td  colspan="3"> <div id="searcharea"></div>  </td>
				</tr>
				
			</table>
		</form>
		<div style="margin-top: 7px; margin-bottom: 7px ">
			<input type="button" id="getCheckedAll" value="검색" />
			
			<input type="button" value="배치하기" onclick="CheckDown()" />
			
			<input type="button" value="닫기" onclick="self.close()"/>
		</div>
		<div>
			<table style="width: 550px" id="pjposting_ret">
				<thead>
					<tr>
						<th style="width: 21px" align="center" ></th>
						<th style="width: 101px" align="center" >성명</th>
						<th style="width: 89px" align="center">직원/외주</th>
						<th style="width: 66px" align="center">등급</th>
						<th style="width: 243px" align="center">보유기술</th>
					</tr>
				</thead>
				<tbody id="pjposting_ret_tbd">
				
				</tbody>	
			</table>
		</div>
	</div>
</body>

</html>