//option {year: "true"} or else
//index (1~)
//skill : String 1/1/1, 1/2/3
$.fn.setArea=function(index,area,options)
{
	var myString =area;
	var mySplitResult = myString.split("/");
	var htmlStr = "";
	if(index=='1')
	{
		var name = document.getElementById("area1");
		if(name==null){
			this.setAreadiv({});
			name = document.getElementById("area1");
		}
		name.value="1/"+area.split("/")[1];
		getAreaOptions($("#area" + index + "_1"), "1", area.split("/")[1],{selectVal:name.value+"/"+area.split("/")[2]});
	}
	else{
		htmlStr += '<div id="areaDiv' + index + '" style="height: 100%;" >';
		htmlStr += '<select id="area'
				+ index
				+ '" value='
				+ index
				+ ' name="area" title="area" style="width: 100px;" onchange="getFollowArea(\''+ index + '\')"></select>';
		htmlStr += '&nbsp;<select id="area' + index + '_1" name="area1" style="width: 130px;" title="area1"></select>';
		htmlStr += '&nbsp;<input type="button" value="추가" onclick="addAreaDiv(this.parentNode,{})" /> <input type="button" value="삭제" onclick = "delAreaDiv(\''
				+ areaDivCnt + '\',this.parentNode)"/>';
		htmlStr += '</div>';
		$(this).append(htmlStr);
		getSkillOptions($("#area" + index), "1", "",{selectVal:''+mySplitResult[0]+"/"+mySplitResult[1]+''});	
		getSkillOptions($("#area" + index + "_1"), "1", area.split("/")[1],{selectVal:''+mySplitResult[0]+"/"+mySplitResult[1]+"/"+area.split("/")[2]});
	}
}

function getAreaVal(){
	var result="";
	if (areaDivCnt==null)
		result=null;
	else{
	for(i=1;i<areaDivCnt;i++){
			result+=$('#area'+i+'_1').val()+"";
	}
}
	return result;
}


$.fn.setAreadiv=function(options){
	var htmlStr = "";
	htmlStr += '<div id="areaDiv' + 1 + '" style="height: 100%" >';
	htmlStr += '<select id="area'
			+ 1
			+ '" value='
			+ 1
				+ ' name="area" title="area" style="width: 48%; height:100%;" onchange="getFollowArea(\''+ 1 + '\')"></select>';
	htmlStr += '&nbsp;<select id="area' + 1 + '_1" style="width: 48%; height:100%;" name="area1" style="width: 130px;" title="area1"></select>';
//	htmlStr += '&nbsp;<input type="button" value="추가" onclick="addAreaDiv(this.parentNode,{})" /> ';
	htmlStr += '</div>';
	$(this).html(htmlStr);
	getAreaOptions($("#area" + 1), "1", "",{});
}
$.fn.setSearchAreadiv=function(){
	var htmlStr = "";
	htmlStr += '<div id="areaDiv' + 100 + '">';
	htmlStr += '<select id="area'
			+ 100
			+ '" value='
			+ 100
			+ ' name="area" title="area" style="width: 49%;height:100%;" onchange="getFollowArea(\''+ 100 + '\')"></select>';
	htmlStr += '&nbsp;<select id="area' + 100 + '_1" name="area1" style="width: 49%;height:100%;" title="area1"></select>';
	htmlStr += '</div>';
	$(this).html(htmlStr);
	getAreaOptions($("#area" + 100), "1", "",{});
}
function getFollowArea(cnt){
	console.log( $("#area" + cnt).val().split("/")[1])
	console.log( $("#area" + cnt).val().split("/")[2])
	getAreaOptions($("#area" + cnt + "_1"), "1", $("#area" + cnt).val().split("/")[1],{});
}

//option {selectVal:skill(ex:1/1/1)}
function getAreaOptions(selectObj, type, val,options) {
		$.ajax({
			type : "POST",
			url : "/getAreaOptions",
			async : false,
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
					getFollowArea($(selectObj).attr("id").split("area")[1]);
				}
			}
		});
	}


	function getAreas() {
		getAreaOptions($("#area1"), "1", "");
	}
	
	
	
	var areaDivCnt = 2;
	
	
	
	function addAreaDiv(Obj,options) {
		var htmlStr = "";
		htmlStr += '<div id="areaDiv' +areaDivCnt + '">';
		htmlStr += '<select id="area'
				+ areaDivCnt
				+ '" value='
				+ areaDivCnt
				+ ' name="area" title="area" style="width: 100px;" onchange="getFollowSkill(\''
				+ areaDivCnt + '\')"></select>';
		htmlStr += '&nbsp;<select id="area' + areaDivCnt + '_1" name="area" style="width: 130px;" title="area"></select>';
		htmlStr += '&nbsp;<input type="button" value="추가" onclick="addAreaDiv(this.parentNode,{})" /> <input type="button" value="삭제" onclick = "delAreaDiv(\''
				+ areaDivCnt + '\',this.parentNode)"/>';
		htmlStr += '</div>';
		$(Obj).append(htmlStr);
		getSkillOptions($("#skill" + areaDivCnt), "1", "",{});
		areaDivCnt++;
	}

	function delAreaDiv(areaDivCnt,Obj) {
		$("#areaDiv"+areaDivCnt,Obj.parentNode).remove();

	}