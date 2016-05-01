//초기값 0, 이름 중복시 1
var nameState=0;
//초기값 0, 중복된 사람의 수
var count=0;
function setHiredate(){
	var date=new Date();
	var html='<option value="">전체</option>';
	for(i=1999;i<=Number(date.getFullYear());i++){
		html+='<option value="'+i+'">'+i+'</option>';
	}
	$("#searchyear").html(html);
}
$(document).ready(function(){	

/*	$('#emp_name').change(function(){
	var ascii=64;
		
		if(nameState==1){
			var name=$('#emp_name').val()
			//1명이 있을때 최대영A 2명이 있을때 최대영  B
			var identify=String.fromCharCode(ascii+count);
		//	alert(name+identify)
			$('#emp_name').val(name+identify);
		}
	});*/
	//name duplication
	setHiredate();
	$('#emp_name').keyup(function(){
		$.ajax({
			type : "POST",
			url:"/dupli_name",
			async : true,
			dataType : "json",
			data:{				
				e_name:$("#emp_name").val()
			},
			success : function(data) {
			nameState=0;
			count = data.count;
				if(count ==0)
				{
					
					var name = document.getElementById("emp_name");
					$(".emp_duplication").text("중복된 이름이 없습니다").css("color","blue");
					$(".emp_duplication").css("margin-left","39%");
					nameState=0;
				}
				if(count > 0)
				{
					
					var name = document.getElementById("emp_name");
					$(".emp_duplication").text("중복된 이름이 있습니다").css("color","red");
					$(".emp_duplication").css("margin-left","39%");
					nameState=1;
				}
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
	});	
});
