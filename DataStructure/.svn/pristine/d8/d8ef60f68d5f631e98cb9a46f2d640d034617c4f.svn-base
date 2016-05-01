/*
 * jQuery Reveal Plugin 1.0
 * www.ZURB.com
 * Copyright 2010, ZURB
 * Free to use under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
*/



(function($) {

/*---------------------------
 Defaults for Reveal33	
----------------------------*/
	 
/*---------------------------
 Listener for data-reveal-id attributes
----------------------------*/

	$('a[data-reveal-id]').live('click', function(e) {
		var rate_value = $(this).attr('id');;
		$.ajax({
			type : "POST",
			url : "/emp_outList.action",
			async : true,
			dataType : "json",
			data : {
				rate_value: rate_value
			},

			success : function(data) {	
				var html = "";
				html+='<h1>직원/외주 상세정보</h1>'
				html+='<a class="close-reveal-modal">&#215;</a>'
				html+='<table id="standbytable" cellpadding="5" cellspacing="5" border="1" style="background-color:#ffff99;">'
				if(data.size==0){
					html+='<tr>'
					html+='<td colspan="21" align="center">'+"데이터가 없습니다."+'</td>';
					html+='</tr>'
					html+='</table>'
					$("#myModal").html(html);					
						
					return;
						
				}	
				var  thisDate = new Date();
				var currentYear = thisDate.getFullYear();
				var team_id=data.team_id;
			
				
				
				
				$.each(data.personalInfo,function(entryIndex, personalInfo){ 
					if(personalInfo.career_date){
						var date=career(personalInfo.career_date);
					}
					
						html+='<tr>'
							if(personalInfo.photo==null){
								html+='<td rowspan="4">&nbsp;&nbsp;&nbsp;&nbsp; <img src="resources/images/emp_nophoto.jpg" id=emp_photo name="photo22" width=177 height=236 align="middle"><br>'
							}else{
								html+='<td rowspan="4">&nbsp;&nbsp;&nbsp;&nbsp; <img src="'+personalInfo.photo+'" id=emp_photo name="photo22" width=177 height=236 align="middle"><br>'
							}
						html+='</td>'
						html+='<th >직원명</th>'
						html+='<td align="center">'+personalInfo.name+'</td>';
						html+='<th style="width:80px;">소속</th>'
						if(personalInfo.company==null){
							html+='<td align="center">-</td>';	
						}else{
							html+='<td align="center">'+personalInfo.company+'</td>';	
						}
						html+='</tr>'
						html+='<tr>'
						html+='<th style="width: 100px">입사일</th>'	
						html+='<td align="center">'+personalInfo.hire_date.substring(0,4)+'-'+personalInfo.hire_date.substring(5,7)+'-'+personalInfo.hire_date.substring(8,10)+'</td>';	
						html+=	'<th  style="width: 100px">퇴사일</th>'
						if(personalInfo.quit_date==null){
							html+='<td align="center">-</td>';		
						}else{
							html+='<td align="center">'+personalInfo.quit_date+'</td>';		
						}
						html+='</tr>'
							
							
						html+='<tr>'
						html+=	'<th >직급(등급)</th>'
						html+='<td align="center">'+personalInfo.position.substring(1, 3)+'</td>';		
						html+=	'<th>경력</th>'	
						if(date){
							html+='<td align="center">'+date.split("/")[0]+'년'+date.split("/")[1]+'개월</td>';	
						}else{
							html+='<td align="center">-</td>';	
						}
						
						html+='</tr>'
						html+='<tr>'
						html+='<th>팀명</th>'	
						html+='<td align="center" >'+personalInfo.team_name+'</td>';			
						html+='<th>거주지</th>'	
						if(personalInfo.area==null){
							html+='<td align="center" >-</td>';	
						}else{
							html+='<td align="center" >'+personalInfo.e_area+'</td>';				
						}
						
						html+='</tr>'
						if(personalInfo.division=='외주'){
							html+='<tr>'
							html+='<th>단가</th>'	
							html+='<td align="center" colspan="4">'+personalInfo.salary+'</td>';
							html+='</tr>'
						}
						html+='<tr>'
						html+='<th>E-mail</th>'
							if(personalInfo.email == null){
								html+='<td align="center" colspan="4">-</td>';		
							}else if(personalInfo.division=='직원'){
								html+='<td align="center" colspan="4">'+personalInfo.email+'@sqisoft.com</td>';			
							}else if(personalInfo.division=='외주'){
								html+='<td align="center" colspan="4">'+personalInfo.email+'</td>';				
							}
						html+='</tr>'
						html+='<tr>'
						html+='<th>연락처</th>'
						html+='<td align="center" colspan="4">'+personalInfo.phonenum+'</td>';
						html+='</tr>'
						html+='<tr>'
						html+='<th>기술분야</th>'
						if(personalInfo.skill_name==null || personalInfo.skill_name==""){
							html+='<td align="center" colspan="4">-</td>';
						}else{
							html+='<td align="center" colspan="4">'+personalInfo.skill_name+'</td>';
						}
						html+='</tr>'
						html+='<tr>'
						html+='<th>대상업무분야</th>'
							if(personalInfo.job==null|| personalInfo.job==""){
								html+='<td align="center" colspan="4">'+'-'+'</td>';	
							}else{
								html+='<td align="center" colspan="4">'+personalInfo.job+'</td>';
							}
						html+='</tr>'
						html+='<tr>'
						html+='<th>특수업무분야</th>'
						if(personalInfo.etc==null|| personalInfo.etc==""){
							html+='<td align="center" colspan="4">'+'-'+'</td>';	
						}else{
							html+='<td align="center" colspan="4">'+personalInfo.etc+'</td>';	
						}
						html+='</tr>'
							
				var team_id='';
					team_id=personalInfo.team_id;
				});
				html+='</table>'
				html+='<a class="close-reveal-modal">&#215;</a>'
				$("#myModal").html(html);				
				
				return;
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}
		});
		
		e.preventDefault();
		
		var modalLocation = $(this).attr('data-reveal-id');;
		$('#'+modalLocation).reveal($(this).data());
	});

/*---------------------------
 Extend and Execute
----------------------------*/

    $.fn.reveal = function(options) {
        
        var defaults = {  
	    	animation: 'fadeAndPop', //fade, fadeAndPop, none
		    animationspeed: 300, //how fast animtions are
		    closeonbackgroundclick: true, //if you click background will modal close?
		    dismissmodalclass: 'close-reveal-modal' //the class of a button or element that will close an open modal
    	}; 
    	
        //Extend dem' options
        var options = $.extend({}, defaults, options); 
	
        return this.each(function() {
/*---------------------------
 Global Variables
----------------------------*/
        	var modal = $(this),
        		topMeasure  = parseInt(modal.css('top')),
				topOffset = modal.height() + topMeasure,
          		locked = false,
				modalBG = $('.reveal-modal-bg');

/*---------------------------
 Create Modal BG
----------------------------*/
			if(modalBG.length == 0) {
				modalBG = $('<div class="reveal-modal-bg" />').insertAfter(modal);
			}		    
     
/*---------------------------
 Open & Close Animations
----------------------------*/
			//Entrance Animations
			modal.bind('reveal:open', function () {
			  modalBG.unbind('click.modalEvent');
				$('.' + options.dismissmodalclass).unbind('click.modalEvent');
				if(!locked) {
					lockModal();
					if(options.animation == "fadeAndPop") {
						modal.css({'top': $(document).scrollTop()-topOffset, 'opacity' : 0, 'visibility' : 'visible'});
						modalBG.fadeIn(options.animationspeed/2);
						modal.delay(options.animationspeed/2).animate({
							"top": $(document).scrollTop()+topMeasure + 'px',
							"opacity" : 1
						}, options.animationspeed,unlockModal());					
					}
					if(options.animation == "fade") {
						modal.css({'opacity' : 0, 'visibility' : 'visible', 'top': $(document).scrollTop()+topMeasure});
						modalBG.fadeIn(options.animationspeed/2);
						modal.delay(options.animationspeed/2).animate({
							"opacity" : 1
						}, options.animationspeed,unlockModal());					
					} 
					if(options.animation == "none") {
						modal.css({'visibility' : 'visible', 'top':$(document).scrollTop()+topMeasure});
						modalBG.css({"display":"block"});	
						unlockModal()				
					}
				}
				modal.unbind('reveal:open');
			}); 	

			//Closing Animation
			modal.bind('reveal:close', function () {
			  if(!locked) {
					lockModal();
					if(options.animation == "fadeAndPop") {
						modalBG.delay(options.animationspeed).fadeOut(options.animationspeed);
						modal.animate({
							"top":  $(document).scrollTop()-topOffset + 'px',
							"opacity" : 0
						}, options.animationspeed/2, function() {
							modal.css({'top':topMeasure, 'opacity' : 1, 'visibility' : 'hidden'});
							unlockModal();
						});					
					}  	
					if(options.animation == "fade") {
						modalBG.delay(options.animationspeed).fadeOut(options.animationspeed);
						modal.animate({
							"opacity" : 0
						}, options.animationspeed, function() {
							modal.css({'opacity' : 1, 'visibility' : 'hidden', 'top' : topMeasure});
							unlockModal();
						});					
					}  	
					if(options.animation == "none") {
						modal.css({'visibility' : 'hidden', 'top' : topMeasure});
						modalBG.css({'display' : 'none'});	
					}		
				}
				modal.unbind('reveal:close');
			});     
   	
/*---------------------------
 Open and add Closing Listeners
----------------------------*/
        	//Open Modal Immediately
    	modal.trigger('reveal:open')
			
			//Close Modal Listeners
			var closeButton = $('.' + options.dismissmodalclass).bind('click.modalEvent', function () {
			  modal.trigger('reveal:close')
			});
			
			if(options.closeonbackgroundclick) {
				modalBG.css({"cursor":"pointer"})
				modalBG.bind('click.modalEvent', function () {
				  modal.trigger('reveal:close')
				});
			}
			$('body').keyup(function(e) {
        		if(e.which===27){ modal.trigger('reveal:close'); } // 27 is the keycode for the Escape key
			});
			
			
/*---------------------------
 Animations Locks
----------------------------*/
			function unlockModal() { 
				locked = false;
			}
			function lockModal() {
				locked = true;
			}	
			
        });//each call
    }//orbit plugin call
})(jQuery);
        
