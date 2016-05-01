<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
	<script src="resources/js/teamName.js" type="text/javascript"></script>
<script src="resources/js/skill.js" type="text/javascript"></script>
<script src="resources/js/area.js" type="text/javascript"></script>


<style type="text/css">
body {
	font-family: "NanumGothic", "Dotum", "Gulim", "Arial", sans-serif;
	width: 350px;
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
	var search = "";
	$(document).ready(function() {
		search="";
		console.log($(this).val())
		$('#team_id').setTeamdiv({all:true});
		$("#getCheckedAll").click(function() {
			search += $('#team').val()+" ";
			search += $('#pj_id').val();
			$("input[name=box]:checked").each(function() {
				var test = $(this).val();
				search += " " + test + "";
			});
			console.log(search)
			window.opener.check(search);
			self.close();
		});

	});
</script>

<title>Searching</title>
</head>
<body style="width: 350px; height: 250px; overflow-x:hidden;  overflow-y:hidden;">
	<div class="header" style="height: 50px; width: 350px;">
		<div class="header_area" height="50px">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 255px; height: 180px;">

		<!-- TODO -->
		<h2 class="contentsTitle" style="width: 255px; margin: 5px">검색조건</h2>
		<table>

			<thead>
				<tr>
					<th>팀 &nbsp;</th>
					<td><div id="team_id"></div></td>
				</tr>
				<tr>
				<th>프로젝트ID/명</th>
				<td><input type="text" id="pj_id"></div></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th colspan="2" style="width: 250px">진행상태</th>
				</tr>
				<tr>
					<td colspan="2">
						<form name="form1">
							<input type="checkbox" name="box" value="1이월">이월 <input
								type="checkbox" name="box" value="2완료">완료 <input
								type="checkbox" name="box" value="3대기">대기
							<P>
								<input type="checkbox" name="box" value="4A급">A급 <input
									type="checkbox" name="box" value="5B급">B급 <input
									type="checkbox" name="box" value="6C급">C급 <input
									type="checkbox" name="box" value="7종결">종결
							</p>
							<input type="checkbox" name="box" value="최신">최신 수정   <!-- pj_remo(수정일)에 따라 오름차순으로 정렬 -->
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="margin-top: 7px;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="button" id="getCheckedAll" value="완료" />
				<input type="button" value="닫기" onclick="self.close()"/>
		</div>
		
	</div>
</body>
</html>