<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	
	/* //checkbox 값 받아서 넘기기.
	function checkFunction(){
		var tm_id = $("input[type=checkbox][name=tmCheckbox]:checked").val();
		getCheckBoxValueAjax(tm_id);
	}
	 */
	
	var check = false;
	//check된 값 가져오기
	function checkFunction(){
		var chk = document.getElementsByName("tmCheckbox[]");
		var len = chk.length;
		var checkRow = "";
		var checkCnt = 0;
		var checkLast = "";
		var rowid = "";
		var cnt = 0;
		
		for(var i=0; i<len;i++){
			if(chk[i].checked == true){
				checkCnt++;
				checkLast = i;
			}
		}
		
		for(var i=0; i<len;i++){
			if(chk[i].checked==true){
				checkRow = chk[i].value;
				
				if(checkCnt == 1){
					rowid += "" + checkRow+"";
				}
				else{
					if( i== checkLast){
						rowid += "" + checkRow + "";
					}
					else{
						rowid += "" + checkRow + "";
					}
				}
				cnt ++;
				checkRow ="";
			}
		}
		
		getCheckBoxValueAjax(rowid);
	}
	
</script>
</head>
<body>
	
<%-- 	<!-- checkbox부분 -->
	<h2>Pj투입 Map</h2>
	
	<form>
		<table>
			<tr>
				<c:forEach var="team" items="${teamList }">
				<td>
					<input type="checkbox" id="tmCheckbox" class="input" name="tmCheckbox[]" onchange="checkFunction()" value="${team.tm_id }" />${team.tm_name }
				</td>
				</c:forEach>
			</tr>
		</table>
	</form>
	
	<c:forEach var="team" items="${teamList }">
		<div class="teamWrap" style=" display: block; border: 1px solid black; float: left;" id="${team.tm_id}"></div>
	</c:forEach>
 --%>
 </body>
</html>