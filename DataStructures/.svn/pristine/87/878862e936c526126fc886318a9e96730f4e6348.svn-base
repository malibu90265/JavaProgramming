/**
 * 입력값 패턴형식으로 체크
 * (해당 jsp파일에 현재 js파일을 선언해주지 않아도 ok)
 * 
 * <사용법>
 * 저장, 수정 버튼 클릭 시 function수행
 * 예) 
 * $(document).ready(function() {	//jsp파일의 <script>영역에 선언
 * if( !$.isValidPattern($("#pj_amount").val(), "NUM")) { ... } 
 * */

(function($){
	$.isValidPattern = function(str, patternType) {	
		
		var pattern = null;
		
		switch(patternType){			
		case "ALPHA":
			pattern = /^[a-zA-Z]+$/;
		    break;
		    
		case "ALPHA_BLANK":
			pattern = /^[a-zA-Z ]+$/;
		    break;
		    
	    case "NUM": // 숫자
	    	pattern = /^[0-9]+$/;
	    	break;
	      
	    case "NUM_POINT": // 숫자 + '.'
	    	pattern = /^[0-9.]+$/;
	    	break;

	    case "ALPHA_NUM": //영문 + 숫자
	    	pattern = /^[0-9.]+$/;
	    	break;	    	

	    case "URL":	
	    	pattern = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
	    	break;
	    	
	    case "PHONE": // 전화번호	형식 : 033-1234-5678
	    	pattern = /^[0-9]{2,4}-[0-9]{3,4}-[0-9]{4}$/;
	    	break;
	      
	    case "EMAIL": //메일
	    	pattern = /^[_a-zA-Z0-9-]+@[._a-zA-Z0-9-]+\.[a-zA-Z]+$/;
	    	break;

	    case "DOMAIN": //영자 숫자와	.	다음도 영자
	    	pattern = /^[.a-zA-Z0-9-]+.[a-zA-Z]+$/;
	    	break;

	    case "HOST": //영자	와 '-'
	    	pattern = /^[a-zA-Z-]+$/;
	    	break;

	    case "HANGUL": //한글인지
	    	pattern = /[가-힣]/;
	    	break;

	    case "HANGULENG	": //한글영어
	    	pattern = /[가-힣a-zA-Z]/;
	    	break;

	    case "HANGULONLY": //한글만
	    	pattern = /^[가-힣]*$/;
	    	break;

	    case "ID": //첫글자는	영자 그뒤엔	영어숫자 4이상 15자리	이하
	    	pattern = /^[a-zA-Z]{1}[a-zA-Z0-9_-]{4,15}$/;
	    	break;

	    case "ID2": //첫글자는	영자 그뒤엔	영어숫자 4이상 15자리	이하
	    	pattern = /^[a-zA-Z0-9._-]+$/;
	    	break;

	    case "DATE": //	형식 : 2002-08-15
	    	pattern = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
	    	break;

	    case "DATEONLY": //	형식 : 2002 or 200208 or 20020815
	    	pattern = /^([0-9]{4}|[0-9]{4}[0-9]{2}|[0-9]{4}[0-9]{2}[0-9]{2})$/;
	    	break;
		}
		
		if(pattern) return pattern.test(str);
		else false;
	};	
})(jQuery);