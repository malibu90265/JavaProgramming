$(document).ready(function(){	
	$("tr",".main_table").each(function(k,v){
		if($(v).children().eq(0).html()=="이월"){
			var ln=($(v).parents().find("tr").length+1)/2+k-5;
			$(v).children().css("background-color", "#B2EBF4");
			$(v).parents().find("tr").eq(ln).css("background-color", "#B2EBF4")
		}
		else if($(v).children().eq(0).html()=="대기"){
			var ln=($(v).parents().find("tr").length+1)/2+k-5;
			$(v).children().css("background-color", "#FCD5B4");
			$(v).parents().find("tr").eq(ln).css("background-color", "#FCD5B4")
		}
		else if($(v).children().eq(0).html()=="A급"){
			var ln=($(v).parents().find("tr").length+1)/2+k-5;
			$(v).children().css("background-color", "#C2D69A");
			$(v).parents().find("tr").eq(ln).css("background-color", "#C2D69A")
		}
		else if($(v).children().eq(0).html()=="B급"){
			var ln=($(v).parents().find("tr").length+1)/2+k-5;
			$(v).children().css("background-color", "#CCC0DA");
			$(v).parents().find("tr").eq(ln).css("background-color", "#CCC0DA")
		}
		else if($(v).children().eq(0).html()=="C급"){
			var ln=($(v).parents().find("tr").length+1)/2+k-5;
			$(v).children().css("background-color", "#F15F5F");
			$(v).parents().find("tr").eq(ln).css("background-color", "#F15F5F")
		}
		else if($(v).children().eq(0).html()=="종결"){
			var ln=($(v).parents().find("tr").length+1)/2+k-5;
			$(v).children().css("background-color", "#F15F5F");
			$(v).parents().find("tr").eq(ln).css("background-color", "#F15F5F")
		}
	});
	$('#pj_id').change(function(){
		$.ajax({
			type : "POST",
			url:"/pjCheck",
			async : false,
			dataType : "json",
			data:{pj_id:$("#pj_id").val()},
			success : function(data) {		
				 var html = '<tr>';
				if(data.res > 0){
					alert('중복된 ID입니다.');
					var test = document.getElementById("pj_id");
					 test.value="";
					 $("#pj_id").focus();
				}
				html += '</tr>'; 
				  
			    $("#duplres").html(html);

			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
	});	

	$('#pj_id').keyup(function(){
		if(pj_id.value.length>8)
		{
			alert('프로젝트ID의 최대 길이는 6자입니다.')
			var test = document.getElementById("pj_id");
			 test.value=pj_id.value.substr(0,8);
		}
	});	
	$('#pj_operate').keyup(function(){
		if(pj_operate.value.length>3 )
		{
			alert('프로젝트수행비율의 최대 값은 100입니다.')
			var test = document.getElementById("pj_operate");
			 test.value=pj_operate.value.substr(0,3);
		}
		if(pj_operate.value>100)
		{
			alert('프로젝트수행비율의 최대 값은 100입니다.')
			var test = document.getElementById("pj_operate");
			 test.value="";
		}
	});
	$('#pj_pm').click(function(){
		
		$.ajax({
			type : "POST",
			url:"/nameExist",
			async : false,
			dataType : "json",
			data:{
				pj_pm : $("#pj_pm").val()
			},
			success : function(data) {		
//				$.each(data,function(entryIndex, entry){	
				//json으로 넘어오므로 파싱이 필요없음 data=JSON.parse(data);
//				if($('#pj_pm').val()!="")$('#pj_pm').val("");
				 var html = '<tr>';
			/*	if(data.res > 0){
				}else{*/
					if(data.e_name == ""){
						 html += '<td id="duplresval" style="color:blue">' + '' + '</td>';
					}else{
						 
						 window.open('/nameSerch','windows','width=320px,height=550px,scrollbars=yes');

					}
			/*	}*/
				 html += '</tr>'; 
				  
			    $("#duplres").html(html);

			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
	});	

	$('#customer_name').click(function(){		
		var test="client";
		var Obj="customer_name";
		window.open('/customerSerch.do?obj='+Obj,'windows','width=450px,height=600px,scrollbars=yes');
		 
	})
	$('#top_customer').click(function(){		
		var test="client";
		var Obj="top_customer";
		window.open('/customerSerch.do?obj='+Obj,'windows','width=450px,height=600px,scrollbars=yes');
		 
	})
	$('#customer_reg').click(function(){
		window.open('/customerReg.do','windows','width=400px,height=300px,scrollbars=no');
	})


	
});
function getName(name)
{
	userForm.pj_pm.value=name;
}
function getReturnValue(result){
	var test = document.getElementById("customer_name");
	test= result;
}
function getReturnPm(result){
	var name = document.getElementById("pj_pm");
	name.value=result;
}

function strip_tags (input, allowed) {
    allowed = (((allowed || "") + "").toLowerCase().match(/<[a-z][a-z0-9]*>/g) || []).join(''); // making sure the allowed arg is a string containing only tags in lowercase (<a><b><c>)
    var tags = /<\/?([a-z][a-z0-9]*)\b[^>]*>/gi,
        commentsAndPhpTags = /<!--[\s\S]*?-->|<\?(?:php)?[\s\S]*?\?>/gi;
    return input.replace(commentsAndPhpTags, '').replace(tags, function ($0, $1) {        return allowed.indexOf('<' + $1.toLowerCase() + '>') > -1 ? $0 : '';
    });
}