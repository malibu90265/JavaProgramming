/**
 * @author Win7-12-PC
 */

/* 각브라우저에서 각부우러져 환경에 맞는 XMLHttpRequest 객체생성후 리턴 */


function RtnHttpReturn(){
	 
	var req;
	
    //alert("테스트");
    /* httpRequest객체 생성 : 서버어플리케이션 (서블릿, jsp)와 통신 */
    
    
    if (window.ActiveXObject) {
    
        //IE인경우	
        try {
		    //IE최근인경우
            req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
        
            try {
			//IE예전인경우	
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }catch (e1) {
                req = null;
            }
        }
    } else  if (windows.XMLHttpRequest) {
          req = new XMLHttpRequest();
			
    } else {
        
		//alert(req);
		req = null;
    }
    
	//alert("테스트!");
	//alert(req == null); 
    
    return req;
	
}

/* 키들을 할당한 배열객체를 전달받아  URL과 request객체, 콜백함수를 전달받아 Get방식의 sed처리,  */

function sendGet(pUrl, pArray, pReq, pCallBack){
	//pArray : ["키이름","키값",....]
	var keys = "";
	//배열에 바번문을 통해 키이름 = 기값으로 나열함
		
	if(!isNaN(eval(pArray))){
		if(pArray != null){
			//인수가 있는경우
				
			keys="?";
			
			for(var i=0; i<pArray.length;i=i+2){
				keys += pArray[i] + "=" + pArray[i+1] +"&";
							
			  }
			}
	}else{
		keys="value="+pArray;		
	}
		
	//마지막에 잇는 &없애기
	keys = keys.substr(0, keys.lastIndexOf("&"));
	alert(pUrl+keys);
	pReq.open("Get",pUrl+keys,true);
	pReq.onreadystatechange=pCallBack;
	pReq.send(null);
	
	
	
}


/* 키들을 할당한 배열객체를 전달받아  URL과 req객체, 콜백함수를 전달받아 Post방식의 send처리,  */

function sendPost(pUrl, pArray, pReq, pCallBack){
	//pArray : ["키이름","키값",....]
	var keys = "";
	//배열에 바번문을 통해 키이름 = 기값으로 나열함
		
		if(pArray != null){
		//인수가 있는경우
			
		//keys="?";
			for(var i=0; i<pArray.length;i=i+2){
			keys += pArray[i] + "=" + pArray[i+1] +"&";
						
		  }
		}
		
	//마지막에 잇는 &없애기
	keys = keys.substr(0, keys.lastIndexOf("&"));
	alert(pUrl+keys);
	pReq.open("post",pUrl,true);
	pReq.setRequestHeader('Content-Type','application/x-www-form-urlencoded'); //문서헤더 셋팅
	
	pReq.onreadystatechange=pCallBack;
	pReq.send(keys);
	
}


/* 콜백해서 성공한 경우 값 리턴 */

function ReturnResponse(pReq){
	
	if(pReq.readyState==4){
		if(pReq.status ==200){
			alert("테스트"+pReq.readyState +"/" + pReq.status);
			
			return pReq.responseText;
		}else{
			alert("페이지 로드를 실패하였습니다\n오류번호 :"+pReq.status);
			return null;
		}
	}
}