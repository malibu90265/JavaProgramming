package com.sqisoft.iqs.pf.comm;

import java.util.Calendar;

public class CalcUtil {
	public static int getNumber(String number) {
		if (number.equals("")) {
			number = "0";
		}
		return Integer.parseInt(number.replace(",", ""));
	}

	public static float getDecimal(String number) {
		if (number.equals(""))
			number = "0";
		return Float.parseFloat(number);
	}

	public static String setComma(int number) {
		String ret = "";
		ret = String.format("%,d", number);
		return ret;
	}
	
	/*
	 *  getManMonth메소드에 지정해주기
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	date_in = sdf.parse(vo.getPj_start_day());
	date_db = sdf.parse(ret_vo.getPj_end_day());
	
	*/
	public static float getManMonth(String pj_start_day,String pj_end_day){
		Calendar now = Calendar.getInstance();
		int lastday=0;
		float startMM=0.0f;
		float endMM=0.0f;
		float resMM=0.0f;
		
		
		String startYearForm = pj_start_day.replace("-", "").substring(0, 4);
		String startMonthForm = pj_start_day.replace("-", "").substring(4, 6);
		String startDayForm = pj_start_day.replace("-", "").substring(6, 8);
		
		String endYearForm = pj_end_day.replace("-", "").substring(0, 4);
		String endMonthForm = pj_end_day.replace("-", "").substring(4, 6);
		String endDayForm = pj_end_day.replace("-", "").substring(6, 8);

		int startYearNum = Integer.parseInt(startYearForm);
		int startMonthNum = Integer.parseInt(startMonthForm);
		int startDayNum = Integer.parseInt(startDayForm);
		
		int endYearNum = Integer.parseInt(endYearForm);
		int endMonthNum = Integer.parseInt(endMonthForm);
		int endDayNum = Integer.parseInt(endDayForm);
		
		int month = (endYearNum - startYearNum)* 12 + (endMonthNum - startMonthNum); 
		for(int i=0;i<=month;i++){
			
			now.set(startYearNum,startMonthNum-1,1);
			lastday=now.getActualMaximum(Calendar.DATE);
		    if(i==0 && month > 0){
		    	
		    	startMM=(((float)lastday-(float)startDayNum+1.0f)/(float)lastday);
		    	resMM+=startMM;
		    	
		    }else if(i==month && month > 0){
		    	now.set(endYearNum,endMonthNum-1,1);
				lastday=now.getActualMaximum(Calendar.DATE);
		    	endMM=(float)endDayNum / (float)lastday;
		    	resMM+=endMM;
		    }else if(i==0 && month == 0){
		    	
		    	startMM=(((float)endDayNum-(float)startDayNum+1.0f)/(float)lastday);
		    	resMM+=startMM;
		    	
		    }else{
		    	resMM+=1.0f;
		    }
		    
		    startMonthNum++;
		        
		    if(startMonthNum==13){
		    	endYearNum++;
		        	
		       startMonthNum=1;
		      }
		}
		if (resMM <= 0.1)
			resMM = 0.1f;
		
		return resMM;
	}
	
	/*
	 * 2차 방법
	 * */
	public static float getManMonthCustom(String pj_start_day,String pj_end_day){
		Calendar now = Calendar.getInstance();
		float lastday;
		float startMM;
		float endMM;
		float resMM;
		
		// 데이터가 둘중 하나라도 없을 경우
		if(pj_start_day == null || pj_end_day == null){
			return 0;
		}
		
		// 2014-02-02 -> 20140202 ::  test3fe1aa7 -> 317
		pj_start_day = pj_start_day.replaceAll("\\D+", "");
		pj_end_day = pj_end_day.replaceAll("\\D+", "");
		
		//날짜 형식 데이터가 완전하지 않을 경우
		if(pj_start_day.length() < 8 || pj_end_day.length() < 8){
			return 0;
		}/*
		else{ //지정된 문자열만 사용
			pj_start_day = pj_start_day.substring(0, 8);
			pj_end_day = pj_end_day.substring(0, 8);
		}*/
		
		int startYearNum = Integer.parseInt(pj_start_day.substring(0, 4));
		int startMonthNum = Integer.parseInt(pj_start_day.substring(4, 6));
		int startDayNum = Integer.parseInt(pj_start_day.substring(6, 8));
		
		int endYearNum = Integer.parseInt(pj_end_day.substring(0, 4));
		int endMonthNum = Integer.parseInt(pj_end_day.substring(4, 6));
		int endDayNum = Integer.parseInt(pj_end_day.substring(6, 8));
		
		int month = (endYearNum - startYearNum)* 12 + (endMonthNum - startMonthNum); 
		
		now.set(startYearNum,startMonthNum-1,1);
		lastday=now.getActualMaximum(Calendar.DATE);
		
		if(month == 0){
			//일수 계산
			int days = Math.abs(startDayNum-endDayNum);
			resMM=(days+1)/lastday;
		}else {
			//시작달 계산
			startMM=((lastday-startDayNum+1)/lastday);
			resMM=startMM;
			
			//마지막달 계산
			now.set(endYearNum,endMonthNum-1,1);
			lastday=now.getActualMaximum(Calendar.DATE);
	    	endMM=endDayNum / lastday;
	    	resMM+=endMM;
	    	
	    	// month = -2 -> result : month = 2 
	    	if(month<0){
	    		month = Math.abs(month);
	    	}
	    	
	    	//중간달 계산.
	    	if(month>1)
	    		resMM += (month - 1);
		}
		
		//minimum default
		if (resMM <= 0.1)
			resMM = 0.1f;
		
		return resMM;
	}
	
	
}
