<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" name="frm" action="insert.iqshr" enctype="multipart/form-data">
<div align=center>
<table border=1>
	<tr>
		<td><h3><input type="radio" name="division" id=emp_form value="E" checked onchange="change('E')"> 직원
			<input type="radio" name="division" id=out_form value="O" onchange="change('O')"> 외주
			</h3>
		 </td>
		 <td>
		 	<div align = right><input type ="button" value="초기화" onclick="rst_click();" ></div>
		 </td>
	<tr>	
	<tr>
		<td ><br><h3>직 원 명 : <input type="text" id=emp_name name=name> </h3><br></td>
		<td rowspan="4"> &emsp;&emsp;&emsp;<img src ="resources/images/emp_nophoto.jpg" id=emp_photo name="photo22" width=177 height=236><br>
						 &emsp;&emsp;&emsp;<input type=file id="upload" name="photo11" onchange=img_input() />
		</td>
	</tr>
	<tr>
		<td>
		<h3>사원식별자 : <input type="text" id=emp_identification name=identification > </h3>
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4 >입사일 :  </font></b><input type="text" id=hire_date name="hire_date" />
		</td>
	</tr>
	<tr>
		<td>
		<h3>경력기준일 : <input type="text" id=career_date name="career_date"> </h3>
		</td>
		
	</tr>
	<tr>
		<td>
		<b><font size=3>퇴사일 : </font></b><input type="text" id=quit_date name="quit_date"> 
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4>직급 :</font></b> <select id="emp_position" name="position" title="emp_position">
						<option value="">선택하세요</option>
						<option value="사원">사원</option>
						<option value="대리">대리</option>
						<option value="과장">과장</option>
						<option value="부장">부장</option>
					</select>
		</td>
	</tr>
	<tr>
		<td>
		<h3>팀  명 : <select id="emp_team_id" name="team_id" title="emp_position">
						<option value="">선택하세요</option>
						<option value="1S">SI1팀</option>
						<option value="2S">SI2팀</option>
						<option value="3N">보안사업팀</option>
						<option value="4E">에너지사업팀</option>
						<option value="5D">DS사업팀</option>
						<option value="6M">경영지원팀</option>
					</select></h3>
		</td>
	</tr>
	<tr>
		<td>
		<h3>직  무 : <select id="emp_job" name="job" title="emp_job">
						<option value="">선택하세요</option>
						<option value="개발">개발</option>
						<option value="영업">영업</option>
						<option value="회계">회계</option>
						<option value="PM">PM</option>
												
					</select> </h3>
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4>연봉 : </font></b><input type="text" id=emp_salary name=salary>만원
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4>E-mail : </b></font><input type="text" id=emp_email name=email> <font size=4 id="mail_form">@sqisoft.com</font>
		</td>
	</tr>
	<tr>
		<td>
		<h3>전문분야 : &emsp;DBMS &emsp;&emsp; 언어&emsp;&emsp;&emsp;  OS &emsp;&emsp;Middleware&emsp; Network&emsp;&emsp; Web&emsp;&emsp; Framework </h3><br>
				   &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<select id="skill_db" name="skillD" title="skill_db">
						<option value="">선택하세요</option>
						<option value="Oracle">Oracle</option>
						<option value="Informix">Informix</option>
						<option value="Sybase">Sybase</option>
						<option value="My-SQL">My-SQL</option>	
						<option value="DB2">DB2</option>	
						<option value="과장">기타</option>							
					</select>
					 <select id="skill_lang" name="skillL" title="skill_lang">
						<option value="">선택하세요</option>
						<option value="C/C++">C/C++</option>
						<option value="JAVA">JAVA</option>
						<option value="VB/Delphi">VB/Delphi</option>
						<option value="Script">Script</option>
						<option value="PowerBuilder">PowerBuilder</option>
						<option value="과장">기타</option>						
					</select>
					 <select id="skill_os" name="skillO" title="skill_os">
						<option value="">선택하세요</option>
						<option value="HP">HP</option>
						<option value="Sun">Sun</option>
						<option value="Linux">Linux</option>
						<option value="WindowsNT">WindowsNT</option>
						<option value="과장">기타</option>						
					</select>
					 <select id="skill_middle" name="skillM" title="skill_middle">
						<option value="">선택하세요</option>
						<option value="Corbra">Corbra</option>
						<option value="Tuxedo">Tuxedo</option>
						<option value="EJB">EJB</option>	
						<option value="COM/DCOM">COM/DCOM</option>
						<option value="과장">기타</option>						
					</select>
					 <select id="skill_network" name="skillN" title="skill_network">
						<option value="">선택하세요</option>
						<option value="TCP/IP">TCP/IP</option>
						<option value="SNMP">SNMP</option>
						<option value="TMN(CMIP)">TMN(CMIP)</option>
						<option value="WAP">WAP</option>
						<option value="과장">기타</option>							
					</select>
					<select id="skill_web" name="skillW" title="skill_web">
						<option value="">선택하세요</option>
						<option value="HTML">HTML</option>
						<option value="ASP">ASP</option>
						<option value="JSP">JSP</option>	
						<option value="PHP">PHP</option>
						<option value="CGI">CGI</option>
						<option value="과장">기타</option>							
					</select>
					<select id="skill_framework" name="skillF" title="skill_framework">
						<option value="">선택하세요</option>
						<option value=".NET">.NET</option>
						<option value="MFC">MFC</option>
						<option value="SOA">SOA</option>	
						<option value="과장">기타</option>						
					</select>
		</td>
	</tr>
	<tr>
	<td></td>
	<td>
		<div align=right>
		<input type="submit" value="저장">
		<input type="button" value="수정" hidden id="modify_btn" >
		<input type="reset" value="취소">
		</div>
	</td>
	</tr>
</table>
</div>

</form>
</body>
</html>