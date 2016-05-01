var test;

function getProjectBudgetInfoSearchFormAjax() {
		$.ajax({
			type: "POST",
			url : "/total/getProjectBudgetInfoSearchFormAjax",
			success: function(data) {
				$("#projectBudgetInfoSearchForm").empty();
				$("#projectBudgetInfoSearchForm").html(data);
			}, 
			error: function(xhr) {
				alert("error getProjectBudgetInfoSearchFormAjax = " + xhr.statusText);
			}
		});
	}

function getProjectBudgetInfoDetail(id){
	var pj_id = $("#" + id).children().eq(1).text();
	$.ajax({
		type: "POST",
		url : "/total/getProjectBudgetInfoDetailFormAjax",
		data: {	pj_id : pj_id,
			  },
		success: function(data) {
			$("#projectBudgetInfoListForm").empty();
			$("#projectBudgetInfoListForm").html(data);
		}, 
		error: function(xhr) {
			alert("error projectBudgetInfoDetailForm = " + xhr.statusText);
		}
	});
}

function getProjectBudgetInfoListFormAjax(tm_id) {
	$.ajax({
		type: "POST",
		url : "/total/getProjectBudgetInfoListFormAjax",
		data: {"tm_id" : tm_id},
		success: function(data) {
			clearInterval(test);
			$("#circle0").hide();
			$("#circle1").hide();
			$("#circle2").hide();
			$("#circle3").hide();
			$("#circle4").hide();
			$("#circle5").hide();
			$("#circle6").hide();
			$("#projectBudgetInfoListForm").empty();
			$("#projectBudgetInfoListForm").html(data);
		}, 
		error: function(xhr) {
			alert("error getProjectBudgetInfoListFormAjax = " + xhr.statusText);
		}
	});
}

function changeFunc(){
	$("#circle0").show();
	var status = "";
	$("input[type=checkbox]").prop("checked",false);
	var tm_id = $("#teamSelect option:selected").attr("id");
	getProjectBudgetInfoListFormAjax(tm_id);
	
	var result = 1;
	var color = ["red", "orange", "yellow", "green", "blue", "navy", "purple"];
	$("#circle0").circleProgress({
	    value: 1,
	    size: 30,
	    fill: {
	        gradient: ["red"]
	    },
	    thickness: 3
	});
	
	test = setInterval(function() {
		$("#circle" + result).show();
		if(result!=0){
			$("#circle"+result).circleProgress({
			    value: 1,
			    size: 30,
			    fill: {
			        gradient: [color[result]]
			    },
			    thickness: 3,
			    animation: {
		            duration: 1800,
		            easing: 'circleProgressEasing'
		        },
			})
			if(result>7){
				result = 0;
				$("#circle0").hide();
				$("#circle1").hide();
				$("#circle2").hide();
				$("#circle3").hide();
				$("#circle4").hide();
				$("#circle5").hide();
				$("#circle6").hide();
			}
				
			else	
				result++;
		}else{
			$("#circle0").circleProgress({
			    value: 1,
			    size: 30,
			    fill: {
			        gradient: ["red"]
			    },
			    thickness: 3
			});
			result++;
		}
		
			
	}, 1500); 
	
}


//checkbox 값
function getCheckBoxValue(status){
	$.ajax({
		type : "POST" ,
		url : "/total/getCheckBoxValueAjax" ,
		data : {"status" : status} ,
		success : function(data){
			$("#projectBudgetInfoListForm").empty();
			$("#projectBudgetInfoListForm").html(data);
		} ,
		error : function(xhr){
			//alert("error empPjMapCheckBox = " + xhr.statusText);
		}
	});
}


