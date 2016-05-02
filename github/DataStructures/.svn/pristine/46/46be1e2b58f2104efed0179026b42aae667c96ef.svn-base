//options : {selectedVal:"N", prepend:"ALL", callback:func}
function codeSelect(selObj, code, option){
	$.ajax({
		type : "POST",
		url:"/common/getCodeInfo",
		dataType : "json",
		data:{				
			code : code
		},
		success : function(result) {		
			var html ="";
			if(option && option.prepend){
				html += "<option value=''>" + option.prepend + "</option>";
			}
			$.each(result, function(k,v){
				html += "<option value='" + v.code + "' value2='" + v.value +"'";
				if(option && option.selectedVal && option.selectedVal == v.code){
					html += "selected";
				}
				html += ">" + v.name + "</option>";
			});
			$(selObj).html(html);
			if(option && option.callback){
				option.callback(result);
			}
		}
	});
}

function codeCallback(code, callback){
	$.ajax({
		type : "POST",
		url:"/common/getCodeInfo",
		dataType : "json",
		data:{				
			code : code
		},
		success : function(result) {
			callback(result);
		}
	});
}

//options : {selectedVal:"S1", prepend:"ALL"}
function teamSelect(selObj, option){
	$.ajax({
		type : "POST",
		url:"/common/getTeamInfo",
		dataType : "json",
		data:{},
		success : function(result) {		
			var html ="";
			if(option && option.prepend){
				html += "<option value=''>" + option.prepend + "</option>";
			}
			$.each(result, function(k,v){
				html += "<option value='" + v.team_id + "'";
				if(option && option.selectedVal && option.selectedVal == v.team_id){
					html += "selected";
				}
				html += ">" + v.team_name + "</option>";
			});
			$(selObj).html(html);
			if(option && option.callback){
				option.callback(result);
			}
		}
	});
}

function teamCallback(callback){
	$.ajax({
		type : "POST",
		url:"/common/getTeamInfo",
		dataType : "json",
		data:{				
			code : code
		},
		success : function(result) {
			callback(result);
		}
	});
}