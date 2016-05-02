	function allowDrop(ev) {
		ev.preventDefault();
	}
	
	var parentClassName = "";
	function drag(ev) {
		ev.dataTransfer.setData("text", ev.target.id);
		var data = ev.dataTransfer.getData("text");
		parentClassName = document.getElementById(data).parentNode.className;
	}

	// 개별 항목을 즐겨찾기(상단바)에 올립니다.
	function drop(ev) {
		ev.preventDefault();
		var data = ev.dataTransfer.getData("text");
		// 데이터가 있을 경우. target은 위치를 바라봄.
		if(ev.target.firstChild != null) {
			if(confirm("이미 데이터가 있습니다. 북마크를 수정하시겠습니까??")) {
				
			} 
		} 
		else {
			
		}
	}
	
	// 즐겨찾기에 있는 데이터를 쓰레기통으로 넣습니다.
	function bookmarkDrop(ev) {
		
		 if (parentClassName == "grid") {
				ev.preventDefault();
				alert("original data");
			}
		else {
				ev.preventDefault();
				var data = ev.dataTransfer.getData("text");
				if( document.getElementById(data).parentNode.className == "drop-area__item") {
					alert(document.getElementById(data).parentNode.className 
							+"\n"+ document.getElementById(data).lastChild);
					ev.target.appendChild(document.getElementById(data));
					ev.target.removeChild(document.getElementById(data));
					alert("클론만 지운다고!!!");
				}
				else {
					alert(document.body.childNodes);
					// alert(ev.currentTarget.className +"\n"+ ev.target.localName +"\n"+ ev.target.nodeName
						//	 +"\n"+ ev.target.appendChild(document.getElementById(data))); 
					alert("클론 아니라고~~!!!");
				}
			}
		} 