package com.sqisoft.iqs.utils.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CalendarUtil {
	
	public static final int YEAR = 0;
	public static final int MONTH = 1;
	public static final int DAY = 2;
	
	// 투입율을 곱하지 않은 MM
	public static double calculateManMonth(String pd_start_date, String pd_end_date) {
		int year = CalendarUtil.getPresentYear();
		double notRoundMM = 0;
		
		List<Integer> pb_start_integer_date = CalendarUtil.convertStringDateToIntegerDate(pd_start_date);
		List<Integer> pb_end_integer_date = CalendarUtil.convertStringDateToIntegerDate(pd_end_date);
	
		//시작일과 종료일 둘다 올해가 아닐 경우 MM = 0;
		if((pb_start_integer_date.get(0) != year) && (pb_end_integer_date.get(0) != year)){
			notRoundMM = 0.0;
			return notRoundMM;
		}
		else{
		//작년과 다르면
		if(pb_start_integer_date.get(0) != year){
			pb_start_integer_date.clear();
			pb_start_integer_date.add(0, year);
			pb_start_integer_date.add(1, 01);
			pb_start_integer_date.add(2, 01);
		}
		if(pb_end_integer_date.get(0) != year){
			pb_end_integer_date.clear();
			pb_end_integer_date.add(0, year);
			pb_end_integer_date.add(1, 12);
			pb_end_integer_date.add(2, 31);
		}
		
		
		
		
		List<Integer> start_integer_date = new ArrayList<Integer>();
		start_integer_date.addAll(pb_start_integer_date);
		start_integer_date.set(CalendarUtil.DAY, 1);
		
		List<Integer> end_integer_date = new ArrayList<Integer>();
		end_integer_date.addAll(pb_end_integer_date);
		Calendar temp = Calendar.getInstance();
		temp.set(end_integer_date.get(CalendarUtil.YEAR), end_integer_date.get(CalendarUtil.MONTH)-1, end_integer_date.get(CalendarUtil.DAY));
		end_integer_date.set(CalendarUtil.DAY, temp.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		double pd_total_day = CalendarUtil.getTotalDayToIntegerDate(pb_start_integer_date, pb_end_integer_date);
		double total_day = CalendarUtil.getTotalDayToIntegerDate(start_integer_date, end_integer_date);
		
		double betweenMonth = (CalendarUtil.getStartMonthBetweenEndMonth(pb_start_integer_date.get(CalendarUtil.YEAR), pb_start_integer_date.get(CalendarUtil.MONTH), pb_end_integer_date.get(CalendarUtil.YEAR), pb_end_integer_date.get(CalendarUtil.MONTH)))+1d;
		
		notRoundMM = (pd_total_day/total_day) * betweenMonth; 
		return notRoundMM;
		}
	}
	
	public static List<String> getTotalWeekByYear(int year) {
		
		Calendar firstDay = Calendar.getInstance(Locale.FRANCE);
		firstDay.set(year, 0, 1);
		System.out.println(firstDay.get(Calendar.YEAR) + "-" + (firstDay.get(Calendar.MONTH)+1) + "-" + firstDay.get(Calendar.DATE));
		String week = "";
		List<String> weekList = new ArrayList<String>();
		firstDay.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		while(true){
			// ex) 15-01-1
			week = String.valueOf(firstDay.get(Calendar.YEAR)).substring(2) + "-" + (firstDay.get(Calendar.MONTH)+1) + "-" + firstDay.get(Calendar.DAY_OF_WEEK_IN_MONTH);
			if(firstDay.get(Calendar.YEAR) > year) break;
			weekList.add(week);
			firstDay.add(Calendar.DATE, 7);
		}
		
		return weekList;
	}
	
	public static double getTotalDayToIntegerDate(List<Integer> startIntegerDate, List<Integer> endIntegerDate) {
		
		int startYear = startIntegerDate.get(CalendarUtil.YEAR);
		int startMonth = startIntegerDate.get(CalendarUtil.MONTH);
		int startDay = startIntegerDate.get(CalendarUtil.DAY);
		int endYear = endIntegerDate.get(CalendarUtil.YEAR);
		int endMonth = endIntegerDate.get(CalendarUtil.MONTH);
		int endDay = endIntegerDate.get(CalendarUtil.DAY);
		
		// 첫 달과 마지막달을 넣어주는 것.
		Calendar publicCalendar = Calendar.getInstance();
		publicCalendar.set(startYear, startMonth-1, startDay);
		
		Calendar compareCalendar = Calendar.getInstance();
		compareCalendar.set(endYear, endMonth-1, endDay);
		
		// 
		if(publicCalendar.compareTo(compareCalendar) == 0) {
			// startDate와 endDate 가 같으면 총 일수는 1을 반환한다.
			return 1;
		} else if(publicCalendar.compareTo(compareCalendar) == 1) {
			// startDate가 endDate 보다 클 경우 총 일수는 0을 반환한다.
			return 0;
		}
		
		int totalDay;
		if(startYear == endYear && startMonth == endMonth) {
			totalDay = endDay - startDay +1;
		} else {
			totalDay = publicCalendar.getActualMaximum(Calendar.DATE) - startDay + 1 + endDay;
		}
		
		int betweenMonth =  CalendarUtil.getStartMonthBetweenEndMonth(startYear, startMonth, endYear, endMonth);
		for(int i = 1; i < betweenMonth; i++) {
			publicCalendar.add(Calendar.MONTH, 1);
			totalDay += publicCalendar.getActualMaximum(Calendar.DATE);
		}
		
		return totalDay;
	}
	
	public static int getStartMonthBetweenEndMonth(int startYear, int startMonth, int endYear, int endMonth) {
		int betweenYear = endYear - startYear;
		
		int betweenMonth = 0;
		if(betweenYear == 0) {
			// 시작 년도와 끝나는 년도가 같은 경우
			betweenMonth = endMonth - startMonth;
		} else {
			// 시작 년도가 끝나는 년도보다 작을 경우
			for(int i = 0; i <= betweenYear; i++) {
				if(i == 0) { 
					// 시작 년도인 경우 : 시작하는 년도의 다음 월부터 필요함.
					betweenMonth += 12 - startMonth; 
				} else if(i == betweenYear) {
					// 끝나는 년도의 경우 끝나는 년도의 전월 까지만 필요함.
					betweenMonth += endMonth;
				} else {
					// 시작 년도와 끝나는 년도의 사이인 경우
					betweenMonth += 12;
				}
			}
		}
		
		return betweenMonth;
	}
	
	public static int getPresentYear() {
		Calendar now = Calendar.getInstance();
		
		return now.get(Calendar.YEAR);
	}
	
	public static List<Integer> getPresentIntegerDate() {
		Calendar now = Calendar.getInstance();
		
		List<Integer> presentIntegerDate = new ArrayList<Integer>();
		presentIntegerDate.add(now.get(Calendar.YEAR));
		presentIntegerDate.add(now.get(Calendar.MONTH) +1);
		presentIntegerDate.add(now.get(Calendar.DAY_OF_MONTH));
		
		return presentIntegerDate;
	}
	
	public static List<Integer> convertStringDateToIntegerDate(String stringDate) {
		List<Integer> convertDate = new ArrayList<Integer>();
		for(String temp : stringDate.split("-")) {
			convertDate.add(Integer.parseInt(temp)); 
		}
		
		return convertDate;
	}
	
	public static String getPresentWeek() {
		Calendar now = Calendar.getInstance(Locale.FRANCE);
		now.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int week = now.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		String presentWeek = year + "-";
		if(month < 10) {
			presentWeek += "0";
		}
		presentWeek += month + "-";
		presentWeek += week;
		
		return presentWeek;
	}
	
	// 전주를 반환하는 Method
	public static String getLastWeek(String year_month_week) {
		
		Calendar now = Calendar.getInstance(Locale.FRANCE);
		String[] splitDate = year_month_week.split("-");
		
		int year = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]);
		int week = Integer.parseInt(splitDate[2]);
		
		String lastWeek = "";
		// 월에 첫 째주가 1 이기때문에 1이 아니면 그냥 바로 밑의 숫자를 해당 전 주로 한다.
		if(week != 1) {
			lastWeek = year_month_week.substring(0, year_month_week.length()-1);
			lastWeek += (week-1);
		} else {
			// 해당 주가 첫 째주이면 그 전 달의 마지막주를 해당 전 주로 한다.
			if(month != 1) {
				// 해당 월이 1월이 아니면 전 달로 세팅하고
				now.set(year, month-2, 1);
				lastWeek = year + "-";
				if(month-1 < 10) lastWeek += "0";
				lastWeek += (month-1) + "-";
			} else {
				// 해당 월이 1월이면 전 년도 12월로 세팅해준다.
				now.set(year-1, 12, 1);
				lastWeek = (year-1) + "-" + 12 + "-";
			}
			// 세팅 된 년도와 월을 가지고 마지막날로 Calendar를 세팅한다.
			now.set(Calendar.DATE, now.getActualMaximum(Calendar.DATE));
			// 한번 사용하지 않으면 값이 이상하게 나와서 뿌려준다.
			System.out.println(now.get(Calendar.YEAR) + "년 " + (now.get(Calendar.MONTH)+1) + "월 " + now.get(Calendar.DAY_OF_MONTH) + "일 ");
			// 마지막날로 세팅한 Calendar를 마지막날을 끼고 있는 월요일로 다시 세팅한다.
			now.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			
			// 세팅한 월요일의 주차를 전년도 or 전월의 주차로 한다. 
			lastWeek += now.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		}
		
		return lastWeek;
	}
	
	// 현재의 +7일 부터 과거 pastVarMonth까지의 년월주 리스트를 반환하는 Method
	public static List<String> getWeekListDuringPastVarMonth(int pastVarMonth) {
		// 우리나라나는 일요일 ~ 토요일을 한 주로 인식하고,  
		// FRANCE는 월요일 ~ 일요일을 한 주로 인식하기 때문에 프로젝트에 적합한 FRANCE Locale로 세팅한다.
		Calendar now = Calendar.getInstance(Locale.FRANCE);
		now.add(Calendar.DATE, 7);
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		
		// 현재부터 -6개월까지 구하기
		int endConditionYear, endConditionMonth;
		int subMonth = month-pastVarMonth;
		if(subMonth < 0) {
			endConditionYear = year -1;
			endConditionMonth = 12 + subMonth;
		} else {
			endConditionYear = year;
			endConditionMonth = subMonth;
		}
		
		List<String> weekList = new ArrayList<String>();
		String tempWeek = "";
		while(true){
			
			// 해당 주의 월요일을 셋팅한다.
			now.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			tempWeek = String.valueOf(now.get(Calendar.YEAR)) + "-";
			if((now.get(Calendar.MONTH)+1) < 10) {
				tempWeek +=  "0"; ;
			} 
			tempWeek += (now.get(Calendar.MONTH)+1) + "-" + now.get(Calendar.DAY_OF_WEEK_IN_MONTH) +"("+(now.get(Calendar.MONTH)+1)+"/"+ (now.get(Calendar.DATE)) +")";
			
			weekList.add(tempWeek);
			
			// -7을 하면 일주일 전임.
			now.add(Calendar.DATE, -7);
			if(endConditionYear == now.get(Calendar.YEAR) && endConditionMonth > now.get(Calendar.MONTH) ) {
				break;
			}
		}
		
		return weekList;
	}
}
