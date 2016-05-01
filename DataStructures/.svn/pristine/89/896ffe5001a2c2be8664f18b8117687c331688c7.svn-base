var parentClassName = "";
var deleteSeqId = "";

function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
	var data = ev.dataTransfer.getData("text");
	parentClassName = document.getElementById(data).parentNode.className;
	deleteSeqId = document.getElementById(data).parentNode.id.split(" ")[1];
}

//
function getSeqIdByTargetClassName(ev) {
	if(ev.target.tagName == "SPAN") {
		return ev.target.parentNode.id.split(" ")[1];
	}
	// targetTagName에 따른 seqId return
	else {
		var targetTagName = ev.target.tagName;
		if(targetTagName == "DIV") {
			return ev.target.parentNode.id.split(" ")[1];
		} else if(targetTagName == "P" || targetTagName == "A") {
			var targetTagId = ev.target.id;
			return  $("#"+targetTagId).closest("div").parent().attr("id").split(" ")[1];
		}
	}
}

//
function isBelongTransfer(ev, data) {
	
	var targetCategoryId, targetMenuSq;
	
	var targetTagName = ev.target.tagName; 
	if(targetTagName == "DIV") {
		targetCategoryId = ev.target.id.split(" ")[1]; 
		targetMenuSq = ev.target.id.split(" ")[2]; 
	} else if(targetTagName == "P" || targetTagName == "A") {
		targetCategoryId = ev.target.id.split("_")[1]; 
		targetMenuSq = ev.target.id.split("_")[2]; 
	}
	
	var dataCategoryId = data.split(" ")[1];
	var dataMenuSq = data.split(" ")[2];
	
	if(targetCategoryId == dataCategoryId && targetMenuSq == dataMenuSq) {
		return true;
	}
	
	return false;
}

//개별 항목을 즐겨찾기(상단바)에 올립니다.
function mymenuDrop(ev) {
	ev.preventDefault();
	
	// 전송되는 tag data 
	var data = ev.dataTransfer.getData("text");
	// 
	if(ev.target.firstChild != null) {
		if(isBelongTransfer(ev, data)) return;
	} 
	
	//
	var seq = getSeqIdByTargetClassName(ev);
	
	// 전송된 tag data 의 id
	var categoryId = document.getElementById(data).id.split(" ")[1];
	var menuSq = document.getElementById(data).id.split(" ")[2];
	
	// 이미 등록된 마이메뉴인지 아닌지 확인
	existMyMenuAjax(categoryId, menuSq, seq);
} 


// 즐겨찾기에 있는 데이터를 쓰레기통으로 넣습니다.
function trashBoxDrop(ev) {
	
	ev.preventDefault();
	
	if (parentClassName != "grid") {
		deleteMyMenuAjax(deleteSeqId);
	}
}
