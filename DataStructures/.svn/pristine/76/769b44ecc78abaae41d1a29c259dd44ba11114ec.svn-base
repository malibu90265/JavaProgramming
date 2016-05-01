//option {year: "true"} or else
//index (1~)
//skill : String 1/1/1, 1/2/3

function getJob(){
	var result="";
	for(i=1;i<jobDivCnt;i++){
		result+=$('#job'+i).val()+" ";
	}
	return result;	
}
$.fn.setJobdiv=function(options){
	var htmlStr = "";
	htmlStr += '<div id="jobDiv' + 1 + '">';
	htmlStr += '<select id="job'
			+ 1
			+ '" value='
			+ 1
			+ ' name="job" title="job" style="width: 100px; height:100%;" ></select>';
	htmlStr += '&nbsp;<input type="button" value="추가" onclick="addJobDiv(this.parentNode)" /> ';
	htmlStr += '</div>';
	$(this).html(htmlStr);
	getSkillOptions($("#job" + 1), "2", "",{});
}

$.fn.setJob=function(index,job,options){
	console.log(job)
	var myString =job;
	var mySplitResult = myString.split("/");
	var htmlStr = "";
	if(index=='1')
	{
		var name = document.getElementById("job1");
		name.value="2/"+job.split("/")[1];
	}
	else{
		htmlStr += '<div id="jobDiv' + index + '">';
		htmlStr += '<select id="job'
				+ index
				+ '" value='
				+ index
				+ ' name="job" title="job" style="width: 100px;" ></select>';
		htmlStr += '&nbsp;<input type="button" value="추가" onclick="addJobDiv(this.parentNode,{year:\''+options.year+'\'})" /> <input type="button" value="삭제" onclick = "delJobDiv(\''
				+ jobDivCnt + '\',this.parentNode)"/>';
		htmlStr += '</div>';
		$(this).append(htmlStr);
		getSkillOptions($("#job" + index), "2", "",{selectVal:''+mySplitResult[0]+"/"+mySplitResult[1]+''});
		jobDivCnt++;
	}
}
jobDivCnt=2;
function addJobDiv(Obj) {
	var htmlStr = "";
	htmlStr += '<div id="jobDiv' + jobDivCnt + '">';
	htmlStr += '<select id="job'
			+ jobDivCnt
			+ '" value='
			+ jobDivCnt
			+ ' name="job" title="job" style="width: 100px;"></select>';
	htmlStr += '&nbsp;<input type="button" value="추가" onclick="addJobDiv(this.parentNode)" /> <input type="button" value="삭제" onclick = "delJobDiv(\''
			+ jobDivCnt + '\',this.parentNode)"/>';
	htmlStr += '</div>';
	$(Obj).append(htmlStr);
	getSkillOptions($("#job"+jobDivCnt), "2", "",{});
	jobDivCnt++;
}

function delJobDiv(divcnt,Obj) {
	$("#jobDiv"+divcnt,Obj.parentNode).remove();
	jobDivCnt--;
}


$.fn.setSkill=function(index,skill,options)
{
	var myString =skill;
	var mySplitResult = myString.split("/");
	var htmlStr = "";
	if(index==1)
	{
		var name = document.getElementById("skill1");
		name.value="1/"+skill.split("/")[1];
		getSkillOptions($("#skill" + index + "_1"), "1", skill.split("/")[1],{selectVal:name.value+"/"+skill.split("/")[2]});
		if(options&&options.year=="true")
		{
			var name = document.getElementById("year1");
			name.value=skill.split("/")[3];
		}
	}
	else{
		htmlStr += '<div id="skillDiv' + index + '">';
		htmlStr += '<select id="skill'
				+ index
				+ '" value='
				+ index
				+ ' name="skill" title="skill" style="width: 100px;" onchange="getFollowSkill(\''+ index + '\')"></select>';
		htmlStr += '&nbsp;<select id="skill' + index + '_1" name="skill1" style="width: 130px;" title="skill1"></select>';
		if(options && options.year=="true")
			htmlStr +='<input type="text" style="width: 50px";  id="year'+index+'"/>';
		htmlStr += '&nbsp;<input type="button" value="추가" onclick="addSkillDiv(this.parentNode,{year:\''+options.year+'\'})" /> <input type="button" value="삭제" onclick = "delSkillDiv(\''
				+ skillDivCnt + '\',this.parentNode)"/>';
		htmlStr += '</div>';
		$(this).append(htmlStr);
		getSkillOptions($("#skill" + index), "1", "",{selectVal:''+mySplitResult[0]+"/"+mySplitResult[1]+''});	
		getSkillOptions($("#skill" + index + "_1"), "1", skill.split("/")[1],{selectVal:''+mySplitResult[0]+"/"+mySplitResult[1]+"/"+skill.split("/")[2]});
		if(options && options.year=="true")
		{
			var name = document.getElementById("year"+index);
			name.value=skill.split("/")[3];
		}
	}
}

function getVal(options){
	var result="";
	for(i=1;i<skillDivCnt;i++){
		if(options&&options.year=="true"){
			result+=$('#skill'+i+'_1').val()+"/"+$('#year'+i+'').val()+" ";
		}
		else{
			result+=$('#skill'+i+'_1').val()+" ";
		}
	}
	return result;
}


$.fn.setSkilldiv=function(options){
	var htmlStr = "";
	htmlStr += '<div id="skillDiv' + 1 + '">';
	htmlStr += '<select id="skill'
			+ 1
			+ '" value='
			+ 1
			+ ' name="skill" title="skill" style="width: 100px;" onchange="getFollowSkill(\''+ 1 + '\')"></select>';
	htmlStr += '&nbsp;<select id="skill' + 1 + '_1" name="skill1" style="width: 130px;" title="skill1"></select>';
	if(options && options.year=="true")
		htmlStr +='<input type="text" style="width: 50px;" placeholder="경력(년)" id="year'+1+'" name="year"/>';
	
	htmlStr += '&nbsp;<input type="button" value="추가" onclick="addSkillDiv(this.parentNode,{year:\''+options.year+'\'})" /> ';
	htmlStr += '</div>';
	$(this).html(htmlStr);
	getSkillOptions($("#skill" + 1), "1", "",{});
}
$.fn.setSearchSkilldiv=function(){
	var htmlStr = "";
	htmlStr += '<div id="skillDiv' + 100 + '">';
	htmlStr += '<select id="skill'
			+ 100
			+ '" value='
			+ 100
			+ ' name="skill" title="skill" style="width: 49%;height:100%;" onchange="getFollowSkill(\''+ 100 + '\')"></select>';
	htmlStr += '&nbsp;<select id="skill' + 100 + '_1" name="skill1" style="width: 49%;height:100%;" title="skill1"></select>';
	htmlStr += '</div>';
	$(this).html(htmlStr);
	getSkillOptions($("#skill" + 100), "1", "",{});
}
function getFollowSkill(cnt){
	getSkillOptions($("#skill" + cnt + "_1"), "1", $("#skill" + cnt).val().split("/")[1],{});
}

//option {selectVal:skill(ex:1/1/1)}
function getSkillOptions(selectObj, type, val,options) {
		$.ajax({
			type : "POST",
			url : "/getSkillOptions",
			async : true,
			dataType : "json",
			data : {
				type : type,
				val : val
			},
			success : function(result) {

				var html = "";
				html += '<option value="">선택하세요</option>';

				$.each(result, function(k, v) {

					html += '<option value="' + v.code +'"';
					if(options&&options.selectVal&&options.selectVal==v.code)
					{
						html+="selected";
					}
					html += '>' + v.name+ '</option>';
				});

				$(selectObj).html(html);

				if (type == "1" && val == "0") {

					getFollowSkill($(selectObj).attr("id").split("skill")[1]);
				}
				if(type == "2"){
					
				}
			}
		});
	}


	function getSkills() {
		getSkillOptions($("#skill1"), "1", "");
		getSkillOptions($("#skill2nd"), "2", "");
	}
	
	var skillDivCnt = 2;
	
	function addSkillDiv(Obj,options) {
		var htmlStr = "";
		htmlStr += '<div id="skillDiv' + skillDivCnt + '">';
		htmlStr += '<select id="skill'
				+ skillDivCnt
				+ '" value='
				+ skillDivCnt
				+ ' name="skill" title="skill" style="width: 100px;" onchange="getFollowSkill(\''
				+ skillDivCnt + '\')"></select>';
		htmlStr += '&nbsp;<select id="skill' + skillDivCnt + '_1" name="skill1" style="width: 130px;" title="skill1"></select>';
		if(options && options.year=="true")
			htmlStr +='<input type="text" style="width: 50px"; placeholder="경력(년)" id="year'+skillDivCnt+'"/>';
		htmlStr += '&nbsp;<input type="button" value="추가" onclick="addSkillDiv(this.parentNode,{year:\''+options.year+'\'})" /> <input type="button" value="삭제" onclick = "delSkillDiv(\''
				+ skillDivCnt + '\',this.parentNode)"/>';
		htmlStr += '</div>';
		$(Obj).append(htmlStr);
		getSkillOptions($("#skill" + skillDivCnt), "1", "",{});
		skillDivCnt++;
	}

	function delSkillDiv(skillDivCnt,Obj) {
		$("#skillDiv"+skillDivCnt,Obj.parentNode).remove();

	}