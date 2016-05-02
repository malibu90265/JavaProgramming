$(document).ready(function(){
	$("#delete").click(function(){
		var count=0;
		var chcnt=0;
		$("tr","table").each(function(k,v){	
			count++;
			if($(v).children().eq(0).find("input:checked").val()=="on")
			{
				chcnt++;
			}
		});
		if(count-chcnt<2)
		{
			alert("한개 이상의 단가정보가 필요합니다.");
		}	
		else{
		$("tr","table").each(function(k,v){
			if($(v).children().eq(0).find("input:checked").val()=="on")
			{
				$.ajax({
					type : "POST",
					url:"/deleteHistory.action",
					async : false,
					dataType : "json",
					data:{		
						hire_date:$(v).children().eq(1).html(),
						name:$("h2").html().split("의")[0]
					},

					success : function() {
						javascript:location.href='/outSal_history.do?name='+$("h2").html().split("의")[0];
					},
					error : function(xhr) {
						alert("error html = " + xhr.statusText);
					}			
				});
			}
		});
		}
	});
})