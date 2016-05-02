$(document).ready(function(){
	var d = new Date();
	var filename=d.getFullYear()+"년"+(d.getMonth() + 1)+"월"+d.getDate()+"일"+"팀별 재무정보";
	console.log(filename)
		$("#excelExport").click(function(){
			getExcel($("#budget"),filename);
		});

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
})