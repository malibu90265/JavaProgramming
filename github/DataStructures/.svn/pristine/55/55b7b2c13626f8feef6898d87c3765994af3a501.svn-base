function setCu(){
	if(delete_btn.disabled==false){
		if($("#cu_day").attr("type")!="text"){
		var html="";
		html+='<input style="width:30%; height:100%;" type="text" value="" id="cu_day" placeholder="적용일" />';
		html+='<input type="button" value="History" id="history" title="외주 단가 히스토리" onClick="outSal_his()" />'
		$("#emp_salary").parents().find("td").eq(0).append(html);
		}
	}	
	$('#cu_day').datepicker();
}

function setMpm()
{
	if($("#mpm").attr("type")!="text")
	{
		var html="";
		html+='<input style="width:25%; height:100%;" type="text" id="mpm" placeholder="투입인원" value="1.00"  onKeyup="setCu()" />';
	
		$("#emp_salary").parents().find("td").eq(0).append(html);
		
	}
}
function outSal_his(){
	window.open('/outSal_history.do?name='+emp_name.value,'windows','width=350px,height=370px,scrollbars=yes');
}