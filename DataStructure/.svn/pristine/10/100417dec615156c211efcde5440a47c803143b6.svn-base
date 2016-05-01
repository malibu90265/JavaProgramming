//
//$(document).ready(function(){
//	$('#team_name').setSelectTeam({all:true});
//});

//{selectVal:"team_id",opt:true,all:true,size:true,hr:true}
//$("#team_name").setSelectTeam({all:true})
//select 

	
	function selectAll(){
		if($("input:checkbox").eq(0).attr("checked")=="checked")
		{
			$("input:checkbox").each(function(k,v){
				$(v).attr("checked", true);
			});
		}
		else
		{
			$("input:checkbox").each(function(k,v){
				$(v).attr("checked",false);
			});
		}
	}

$.fn.setTeamdiv=function(options){
	
	var htmlStr = "";
	htmlStr += '<select id="team" value="" name="team_id" title="skill"';
	if(options.size==true)
		htmlStr +='style="width: 165px;"';
	else
		htmlStr+='style="width: 100%;height:100%;"';
	htmlStr +='></select>';
	$(this).html(htmlStr);
	getTeamOptions(("#team"),options);
}
//checkBox
$.fn.setSelectTeam=function(options,selObj){
	alert("dd123");
	
	$.ajax({
		type : "POST", 
		url : "/common/getTeamInfo",
		async : false,
		dataType : "json",
		data : {
		},
		success : function(result) {
			
			var html = "";
			if(options&&options.all==true)
				html += '<input type="checkbox" class="input_check" id="al" value="al"/>전체';
			$.each(result, function(k, v) {
				html += '<input type="checkbox" class="input_check" id="'+ v.team_id +'" value="' + v.team_id +'"';
				html += '/>' + v.team_name+ '';
			});
			$("#inputContent").html(html);
		}
	});
	
}

//검색조건 select
$.fn.setSearchTeamdiv=function(options){
	
	var htmlStr = "";
	htmlStr += '<select style="width: 100%;  height:30px" id="searchteam" value="" name="searchteam" title="skill"';
	if(options.disabled=true)
		htmlStr += 'disabled=true';
	if(options.size!=true)
		htmlStr +='style="width: 100px;"';
	htmlStr +='></select>';
	
	$(this).html(htmlStr);
	getTeamOptions(("#searchteam"),options);
}
//select value얻기


function getTeamOptions(selectObj,options) {
	$.ajax({
		type : "POST", 
		url : "/common/getTeamInfo",
		async : false,
		dataType : "json",
		data : {
		},
		success : function(result) {
			var html = "";
			if(options&&options.all==true)
				html += '<option value="al">전체</option>';
			if(options&&options.opt==true)
				html += '<option value="">선택하세요</option>';
			$.each(result, function(k, v) {
			if(options.hr!=true && (v.team_id=="ON" || v.team_id=="TT") )
				{}
				else{
				html += '<option value="' + v.team_id +'"';
				if(options&&options.selectVal&&options.selectVal==v.team_id)
				{
					html+="selected";
				}
				html += '>' + v.team_name+ '</option>';
				}
			});
			$(selectObj).html(html);

		}
	});
}


