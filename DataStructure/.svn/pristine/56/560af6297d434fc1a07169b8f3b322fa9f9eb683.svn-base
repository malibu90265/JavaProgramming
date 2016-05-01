// 검색 기본 폼
function getwaitingListSearchForm() {
   $.ajax({
      type : "POST",
      url : "/waitingList/searchForm",
      success : function(data) {
         $("#waitingListSearchForm").empty();
         $("#waitingListSearchForm").html(data);
      },
      error : function(xhr) {
         alert("error getwaitingListSearchForm = " + xhr.statusText);
      }
   });
}


// 검색 Do 
function getwaitingListSearchAction(fromMonth, toMonth) {
   if(fromMonth == null && toMonth == null) {
      getwaitingListJanuaryToDecember();
   }
   else if(fromMonth != null && toMonth != null) { // 검색 from이 있고, to가 있고
      // from == to
      // from > to
      // from < to
      getwaitingListJanuaryToDecember(fromMonth, toMonth);
      
   }
   else {
      getwaitingListJanuaryToDecember(fromMonth, toMonth);
   }
}

//리스트
//전체
//동일 구간 반복입니다. 길어서 죄송(_ _;)
function getwaitingListJanuaryToDecember(fromMonth, toMonth) {
   
   $.ajax({
         type : "POST",
         url : "/waitingList/januaryToDecember",
         async : true,
         dataType : "json",
         data : {
            "fromMonth" : fromMonth,
            "toMonth" : toMonth
         },
         success : function(data) {   
            var thisDate = new Date();
            var currentYear = thisDate.getFullYear();
            var test=document.getElementById("nowYear");
            
            var fullDate=new Date();
            var currentMonth = fullDate.getMonth()+1;
            var test1 = document.getElementById("nowMonth");
            
            var html = "", waitingFromMonth ="", waitingToMonth ="";
            
            // for문 안 내용
            function getRepeatwaitingListFunction(i, waitingListVO) {
               var waitingFromDate =waitingListVO.wa_from_date;
               waitingFromMonth = waitingFromDate.substr(5,2);
               var waitingToDate =waitingListVO.wa_to_date;
               waitingToMonth = waitingToDate.substr(5,2);
               
               // view : 시작달이 같으면 무조건 보여줌
               if(waitingFromMonth == i) {
                  html+='<td>'+waitingListVO.wa_name+'</td>';
                  html+='<td id="pjNameTd">'+waitingListVO.pj_name+'</td>';
                  html+='<td>'+waitingListVO.pd_end_date;
               }
               
               // view : 시작달이 작으면
               if(waitingFromMonth < i) {
                  if(waitingToMonth > i) {   // view : 끝달이 시작보다 크면
                     html+='<td>'+waitingListVO.wa_name+'</td>';
                     html+='<td id="pjNameTd">'+waitingListVO.pj_name+'</td>';
                     html+='<td>'+waitingListVO.pd_end_date;
                  }
                  else if(waitingToMonth < i) { // non : 끝달이 시작보다 작을 때
                  }
               }
               
               // non : 시작달이 크고, 끝달도 클 때
               if(waitingFromMonth > i) {
               }
            }

            /* 1월 */
            html+='<DIV id="waitingListJanuaryDiv">'
               if(fromMonth == 1 && toMonth > 1) {   // from 값이 1과 같고 and to 값이 1보다 클 때.
                     html+='<DIV id="waitingListJanuaryDiv" style="visibility:visible">';
               }
               else if(fromMonth > 1 || toMonth < 1){   // from 값이 1보다 크거나 or to 값이 1보다 작을 때.
                  html+='<DIV id="waitingListJanuaryDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {   // 둘 다 null일 경우
                  if(currentMonth > 01 ) {   // 현재 날짜보다 작으면 안 보이게 합니다.
                     html+='<DIV id="waitingListJanuaryDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListJanuaryDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListJanuary" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >1월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){
                                 
                                 for(var i=1; i<2; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                    
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
               
            /* 2월 */
            html+='<DIV id="waitingListFebruaryDiv">'
               if(fromMonth == 2 && toMonth > 2) {
                  html+='<DIV id="waitingListFebruaryDiv" style="visibility:visible">';
               }
               else if(fromMonth > 2 || toMonth < 2){
                  html+='<DIV id="waitingListFebruaryDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 02 ) {
                     html+='<DIV id="waitingListFebruaryDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListFebruaryDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListFebruary" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >2월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=2; i<3; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
               
            /* 3월 */
            html+='<DIV id="waitingListMarchDiv">'
               if(fromMonth == 3 && toMonth > 3) {
                  html+='<DIV id="waitingListMarchDiv" style="visibility:visible">';
               }
               else if(fromMonth > 3 || toMonth < 3){
                  html+='<DIV id="waitingListMarchDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 03 ) {
                     html+='<DIV id="waitingListMarchDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListMarchDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListMarch" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >3월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=3; i<4; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 4월 */
            html+='<DIV id="waitingListAprilDiv">'
               if(fromMonth == 4 && toMonth > 4) {
                  html+='<DIV id="waitingListAprilDiv" style="visibility:visible">';
               }
               else if(fromMonth > 4 || toMonth < 4){
                  html+='<DIV id="waitingListAprilDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 04 ) {
                     html+='<DIV id="waitingListAprilDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListAprilDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListApril" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >4월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=4; i<5; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 5월 */
            html+='<DIV id="waitingListMayDiv">'
               if(fromMonth == 5 && toMonth > 5) {
                  html+='<DIV id="waitingListMayDiv" style="visibility:visible">';
               }
               else if(fromMonth > 5 || toMonth < 5){
                  html+='<DIV id="waitingListMayDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 05 ) {
                     html+='<DIV id="waitingListMayDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListMayDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListMay" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >5월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=5; i<6; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
               
            /* 6월 */
            html+='<DIV id="waitingListJuneDiv">'
               if(fromMonth == 6 && toMonth > 6) {
                  html+='<DIV id="waitingListJuneDiv" style="visibility:visible">';
               }
               else if(fromMonth > 6 || toMonth < 6){
                  html+='<DIV id="waitingListJuneDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 06 ) {
                     html+='<DIV id="waitingListJuneDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListJuneDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListJune" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >6월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=6; i<7; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 7월 */
            html+='<DIV id="waitingListJulyDiv">'
               if(fromMonth == 7 && toMonth > 7) {
                  html+='<DIV id="waitingListJulyDiv" style="visibility:visible">';
               }
               else if(fromMonth > 7 || toMonth < 7){
                  html+='<DIV id="waitingListJulyDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 07 ) {
                     html+='<DIV id="waitingListJulyDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListJulyDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListJuly" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >7월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=7; i<8; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 8월 */
            html+='<DIV id="waitingListAugustDiv">'
               if(fromMonth == 8 && toMonth > 8) {
                  html+='<DIV id="waitingListAugustDiv" style="visibility:visible">';
               }
               else if(fromMonth > 8 || toMonth < 8){
                  html+='<DIV id="waitingListAugustDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 08 ) {
                     html+='<DIV id="waitingListAugustDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListAugustDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListAugust" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >8월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=8; i<9; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 9월 */
            html+='<DIV id="waitingListSeptemberDiv">'
               if(fromMonth == 9 && toMonth > 9) {
                  html+='<DIV id="waitingListSeptemberDiv" style="visibility:visible">';
               }
               else if(fromMonth > 9 || toMonth < 9){
                  html+='<DIV id="waitingListSeptemberDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 09 ) {
                     html+='<DIV id="waitingListSeptemberDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListSeptemberDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListSeptember" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >9월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=9; i<10; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 10월 */
            html+='<DIV id="waitingListOctoberDiv">'
               if(fromMonth == 10 && toMonth > 10) {
                  html+='<DIV id="waitingListOctoberDiv" style="visibility:visible">';
               }
               else if(fromMonth > 10 || toMonth < 10){
                  html+='<DIV id="waitingListOctoberDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 10 ) {
                     html+='<DIV id="waitingListOctoberDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListOctoberDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListOctober" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >10월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=10; i<11; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
            
            /* 11월 */
            html+='<DIV id="waitingListNovemberDiv">'
               if(fromMonth == 11 && toMonth > 11) {
                  html+='<DIV id="waitingListNovemberDiv" style="visibility:visible">';
               }
               else if(fromMonth > 11 || toMonth < 11){
                  html+='<DIV id="waitingListNovemberDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 11 ) {
                     html+='<DIV id="waitingListNovemberDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListNovemberDiv" style="visibility:visible">';
                  }
               }
            html+='<TABLE id="waitingListNovember" class="waitingListJanuary" >'
                     html+=   '<tr><th colspan="3" >11월</th></tr>';
                     html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                     html+='<TR>'
                              $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                                 
                                 for(var i=11; i<12; i++){
                                    getRepeatwaitingListFunction(i, waitingListVO);
                                 }
                              html+='</td>';
                  html+='</tr>'
            });
            html+='</TR>'
            html+='</TABLE>'
            html+='</DIV>'
               
            /* 12월 */
            html+='<DIV id="waitingListDecemberDiv">'
               if(fromMonth == 12 && toMonth > 12) {
                  html+='<DIV id="waitingListDecemberDiv" style="visibility:visible">';
               }
               else if(fromMonth > 12 || toMonth < 12){
                  html+='<DIV id="waitingListDecemberDiv" style="display: none; visibility:hidden">';
               }
               else if(fromMonth == null && toMonth == null) {
                  if(currentMonth > 12 ) {
                     html+='<DIV id="waitingListDecemberDiv" style="display: none; visibility:hidden">';
                  }
                  else {
                     html+='<DIV id="waitingListDecemberDiv" style="visibility:visible">';
                  }
               }
         html+='<TABLE id="waitingListDecember" class="waitingListJanuary" >'
                  html+=   '<tr><th colspan="3" >12월</th></tr>';
                  html+=   '<tr><th>성명</th><th>프로젝트</th><th>일자</th></tr>';
                  html+='<TR>'
                           $.each(data.waitingListVO,function(entryIndex, waitingListVO){ 
                              
                              for(var i=12; i<13; i++){
                                 getRepeatwaitingListFunction(i, waitingListVO);
                              }
                           html+='</td>';
               html+='</tr>'
         });
            html+='</TR>'
            html+='</TABLE>'
            
            $("#waitingListJanuaryToDecember").html(html);
            
            $(".show_result").text(currentYear+" 대기/예정자 조회");
            month_color(currentMonth);
            readyColor();

            return;
         },
         error : function(xhr) {
            alert("error html waitingListJanuaryToDecember = " + xhr.statusText);
         }
      });
   
   };