package com.sqisoft.iqs.hr.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sqisoft.iqs.hr.vo.EmpMapVO;
import com.sqisoft.iqs.hr.vo.ManMonthVO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.hr.vo.StandByInfoVO;
import com.sqisoft.iqs.pf.comm.CalcUtil;

public class HrUtil {
	
	public static int getDiffDayCount(String fromDate, String toDate) {
		
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   try {
		    return (int) ((sdf.parse(toDate).getTime() - sdf.parse(fromDate)
		      .getTime()) / 1000 / 60 / 60 / 24);
		   } catch (Exception e) {
		    return 0;
		   } 
	}
	
	public static float getManMonth(String startDay,String endDay,float mpm){
		float resManMonth=0.0f;
		
		resManMonth= CalcUtil.getManMonth(startDay, endDay);
		resManMonth*=mpm;
		
		System.out.println(resManMonth);
		return resManMonth;
	}
	public static float getOutManMonth(StandByInfoVO standByInfoVO) throws ParseException{
		System.out.println("getOutManMonth In");
		System.out.println(standByInfoVO);
		Date dDate=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", java.util.Locale.KOREA);
		int outSalSize=standByInfoVO.getOutSal_history().size();
		List<OutSal_historyVO> outHisList=standByInfoVO.getOutSal_history();
		//최초계약일
		String outStartDay=standByInfoVO.getStartday();
		String outEndDay=standByInfoVO.getEndday();
		float resMM=0.0f;
		if(outSalSize!=0){
			System.out.println("-----------------------값이 있을 경우------------------------");
			int hisCnt=0;
			
			for(OutSal_historyVO his:outHisList){
			
				//계약을 한 번 맺은 경우
				if(outSalSize==1){
					if(outHisList.get(0).getHire_date().equals(standByInfoVO.getStartday())){
						resMM=getManMonth(his.getHire_date(), outEndDay, his.getMpm());
					}else if(!outHisList.get(0).getHire_date().equals(standByInfoVO.getStartday()) && Integer.parseInt(outHisList.get(0).getHire_date()) < Integer.parseInt(standByInfoVO.getStartday()) ){
						resMM=getManMonth(standByInfoVO.getStartday(), outEndDay, his.getMpm());
					}
					//계약을 두 번 이상 맺은 경우
				}else if(outSalSize > 1){
					
					//outHisList의 첫번째 값이 프로젝트 시작일과 같은경우
					if(outHisList.get(0).getHire_date().equals(standByInfoVO.getStartday())){
						
					System.out.println("outHisList의 첫번째 값이 프로젝트 시작일과 같은경우");
					
					
						if(hisCnt!=outSalSize-1){
							System.out.println("hisCnt1:"+hisCnt);
							dDate=sdf.parse(outHisList.get(hisCnt+1).getHire_date());
							String sToday = sdf.format(dDate);
							long lCurTime = dDate.getTime();
							dDate = new java.util.Date(lCurTime+(1000*60*60*24*-1));
							//어제날짜
							String sYesterDay = sdf.format(dDate);  
				
							System.out.println("sYesterDay:"+sYesterDay);
				
							resMM+=getManMonth(his.getHire_date(), sYesterDay, his.getMpm());
							System.out.println("startDay:"+his.getHire_date()+"endDay:"+sYesterDay+"mpm:"+his.getMpm());
							System.out.println("계약 중간resMM:"+resMM);
							hisCnt++;
						}else if(hisCnt==outSalSize-1){
							resMM+=getManMonth(his.getHire_date(), outEndDay, his.getMpm());
							System.out.println("startDay:"+his.getHire_date()+"endDay:"+outEndDay+"mpm:"+his.getMpm());
							System.out.println("계약 마지막resMM:"+resMM);
						}
						//outHisList의 첫번째 값이 프로젝트 시작일과 다른경우
					}else if(!outHisList.get(0).getHire_date().equals(standByInfoVO.getStartday()) && Integer.parseInt(outHisList.get(0).getHire_date()) < Integer.parseInt(standByInfoVO.getStartday()) ){
						
						if(hisCnt!=outSalSize-1){
							System.out.println("hisCnt2:"+hisCnt);
							dDate=sdf.parse(outHisList.get(hisCnt+1).getHire_date());
							String sToday = sdf.format(dDate);
							long lCurTime = dDate.getTime();
							dDate = new java.util.Date(lCurTime+(1000*60*60*24*-1));
							//어제날짜
							String sYesterDay = sdf.format(dDate);  
				
							System.out.println("sYesterDay:"+sYesterDay);
							if(hisCnt==0){
								resMM+=getManMonth(standByInfoVO.getStartday(), sYesterDay, his.getMpm());
							}else{
								resMM+=getManMonth(his.getHire_date(), sYesterDay, his.getMpm());
							}
							System.out.println("startDay:"+his.getHire_date()+"endDay:"+sYesterDay+"mpm:"+his.getMpm());
							System.out.println("계약 중간resMM:"+resMM);
							hisCnt++;
						}else if(hisCnt==outSalSize-1){
							resMM+=getManMonth(his.getHire_date(), outEndDay, his.getMpm());
							System.out.println("startDay:"+his.getHire_date()+"endDay:"+outEndDay+"mpm:"+his.getMpm());
							System.out.println("계약 마지막resMM:"+resMM);
						}
					}
					
				
				}//계약두번 if
			}
		System.out.println("TOTALresMM:"+resMM);
		
	}else{
		
		System.out.println("-----------------------값이 없을 경우------------------------");
		
	}
		return resMM;
	}
	
	
	//parametar: startdate,enddate return manMonthList;
	public static Map<String, ManMonthVO> getManMonth(StandByInfoVO standByInfoVO) throws ParseException{//parameterType 설정필요
		Map<String, ManMonthVO> manMonthMap=new HashMap<String, ManMonthVO>();
		manMonthMap.clear();
		Calendar now = Calendar.getInstance();
		Date dDate=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", java.util.Locale.KOREA);
		int thisYear=now.get(Calendar.YEAR);
	
		
			/*----------프로젝트 시작날짜,완료날짜 추출------------*/
			String startDate = standByInfoVO.getStartday();
			String  endDate= standByInfoVO.getEndday();
			
			
			
			String startYearForm = startDate.substring(0, 4);
			String startMonthForm = startDate.substring(4, 6);
			String startDayForm = startDate.substring(6, 8);

			int startYear = Integer.parseInt(startYearForm);
			int startMonth = Integer.parseInt(startMonthForm);
			int startDay = Integer.parseInt(startDayForm);
			
			String endYearForm = endDate.substring(0, 4);
			String endMonthForm = endDate.substring(4, 6);
			String endDayForm = endDate.substring(6, 8);
			
			int endYear = Integer.parseInt(endYearForm);
			int endMonth = Integer.parseInt(endMonthForm);
			int endDay = Integer.parseInt(endDayForm);
			
			
			//프로젝트기간 사이 달의 수
			int month = (endYear - startYear)* 12 + (endMonth - startMonth); 
			
			int lastday=0;
			float startMM=0.0f;
			float endMM=0.0f;
			
//			System.out.println(startDate+"~"+endDate+"의 사이 달 수:"+month);
			
			for(int i=0;i<=month;i++){
					
				now.set(startYear,startMonth-1,1);
				lastday=now.getActualMaximum(Calendar.DATE);
					if(i==0 && month > 0){
						startMM=(((float)lastday-(float)startDay+1.0f)/(float)lastday);
						if(standByInfoVO.getProject_id().equals("대기")){
							startMM = 0.0f;
						}
						manMonthMap.put(startYear+ String.format("%02d", startMonth),new ManMonthVO(startYear, startMonth, startMM));
					}else if(i==month && month > 0){
						now.set(endYear,endMonth-1,1);
						lastday=now.getActualMaximum(Calendar.DATE);
						endMM=(float)endDay / (float)lastday;
						if(standByInfoVO.getProject_id().equals("대기")){
							endMM = 0.0f;
						}
						manMonthMap.put(endYear+String.format("%02d", endMonth),new ManMonthVO(endYear, endMonth, endMM));
					}else if(i==0 && month == 0){
						startMM=(((float)endDay-(float)startDay+1.0f)/(float)lastday);
						if(standByInfoVO.getProject_id().equals("대기")){
							startMM = 0.0f;
						}
						manMonthMap.put(startYear+ String.format("%02d", startMonth),new ManMonthVO(startYear, startMonth, startMM));
					}else{
						if(standByInfoVO.getProject_id().equals("대기")){
							manMonthMap.put(startYear+ String.format("%02d", startMonth),new ManMonthVO(startYear, startMonth, 0.0f));
						}else{
							manMonthMap.put(startYear+ String.format("%02d", startMonth),new ManMonthVO(startYear, startMonth, 1.0f));
						}
						
					}
			    
					startMonth++;
			        
					if(startMonth==13){
						startYear++;
			        	
						startMonth=1;
					}
			}
			
			
		return manMonthMap;
	}
	
	
	public static List<StandByInfoVO> manMonthManage(List<StandByInfoVO> standByInfoVOs) throws ParseException {
		List<String> names = new ArrayList<String>();
		Map<String, Map<String, ManMonthVO>> tempMap = new HashMap<String, Map<String,ManMonthVO>>();
		List<StandByInfoVO> resultStandByInfos=new ArrayList<StandByInfoVO>();
		Map<String, ManMonthVO> tempMapValue=null;
		Map<String, ManMonthVO> manMonthMap=new HashMap<String, ManMonthVO>();
		
		Calendar now = Calendar.getInstance();
		int thisYear=now.get(Calendar.YEAR);
		float tempMm=0.0f;
		float entryMm=0.0f;
		float totalMm=0.0f;
		
		//외주, 직원의 날짜
		for (StandByInfoVO standByInfoVO : standByInfoVOs) {
			if(standByInfoVO.getDivision().equals("외주")){
//				System.out.println("외주일 경우");
				standByInfoVO.setTotalMm(getOutManMonth(standByInfoVO));
				resultStandByInfos.add(standByInfoVO);
			}else if(standByInfoVO.getDivision().equals("직원")){
				
				manMonthMap=getManMonth(standByInfoVO);
			
			if(names.contains(standByInfoVO.getName())){//프로젝트2개 이상
				//이름으로 mm리스트를 찾아온다.
				tempMapValue=tempMap.get(standByInfoVO.getName());
				for (Map.Entry<String, ManMonthVO> entry : manMonthMap.entrySet()) {
					
					if(tempMapValue.containsKey(entry.getKey())){
						
						tempMm=tempMapValue.get(entry.getKey()).getMM();
						entryMm=entry.getValue().getMM();
						totalMm=tempMm+entryMm;
					
						tempMapValue.get(entry.getKey()).setMM(totalMm);
						tempMap.put(standByInfoVO.getName(),tempMapValue);
						
					}else{
						tempMapValue.put(entry.getKey(), entry.getValue());
						
					}
				}
			}else{
				tempMap.put(standByInfoVO.getName(), manMonthMap);
				names.add(standByInfoVO.getName());
				resultStandByInfos.add(new StandByInfoVO(standByInfoVO.getName(), standByInfoVO.getTeam_id(),
						standByInfoVO.getTeam_name(), standByInfoVO.getPosition(), standByInfoVO.getDivision(), 
						standByInfoVO.getProject_id(), standByInfoVO.getStartday(), standByInfoVO.getEndday(), 
						standByInfoVO.getYear(), standByInfoVO.getSalary(),standByInfoVO.getMm()));
				
			}
		}
		
	}
		
	for (Map.Entry<String, Map<String, ManMonthVO>> entry : tempMap.entrySet()) {
			
		for (StandByInfoVO resultStandByInfo : resultStandByInfos) {
			
			if(resultStandByInfo.getName().equals(entry.getKey())){
				
				for (Map.Entry<String,ManMonthVO> entry2 : entry.getValue().entrySet()) {
					resultStandByInfo.setTotalMm(resultStandByInfo.getTotalMm()+entry2.getValue().getMM());
					
					
					for(int i=0; i<12; i++){
						if(Integer.toString(thisYear).equals(entry2.getKey().substring(0, 4))){
								
							if( i == Integer.parseInt(entry2.getKey().substring(4, 6))-1){
								float round=Math.round(entry2.getValue().getMM()*10.0f)/10.0f;
								resultStandByInfo.setMm(i, round);
							}
								
								
						}
							
					}
						
				}
			}
		}
	}//for
	return resultStandByInfos;
}
		
	

	public static void manPlaceManage(List<StandByInfoVO> standByInfoVOs) {

		List<String> names = new ArrayList<String>();
		Map<String, StandByInfoVO> standHash = new HashMap<String, StandByInfoVO>();

		for (StandByInfoVO standByInfoVO : standByInfoVOs) {
			/*----------프로젝트 시작날짜,완료날짜 추출------------*/
			String startDate = standByInfoVO.getStartday();
			// System.out.println("startDate"+startDate);
			String endDate = standByInfoVO.getEndday();

			String start_day[] = startDate.split("-");
			int startYear = Integer.parseInt(start_day[0]);
			int startMonth = Integer.parseInt(start_day[1]);
			int startDay = Integer.parseInt(start_day[2]);
			// System.out.println(Integer.parseInt(start_day[2]));

			String end_day[] = endDate.split("-");
			int endYear = Integer.parseInt(end_day[0]);
			int endMonth = Integer.parseInt(end_day[1]);
			int endDay = Integer.parseInt(end_day[2]);

			// 28,29,31일 월말을 30일로 고정
			if (startDay == 28 || startDay == 29 || startDay == 31) {
				startDay = 30;
			}
			if (endDay == 28 || endDay == 29 || endDay == 31) {
				endDay = 30;
			}
			/*----------프로젝트 시작MM,완료MM 계산 ------------*/
			float startMonMM = Math
					.round(((30.0 - startDay + 1.0) / 30.0) * 10) / 10.0f;
			// System.out.println(Math.round(((30.0-1+1.0)/30.0)*10)/10.0f);
			float endMonMM = Math.round(endDay / 30.0 * 10) / 10.0f;

			/*----------년도 setting ------------*/
			standByInfoVO.setYear(String.valueOf(startYear));

			StandByInfoVO standByInfoVOTemp = null;
			if (startYear == endYear) {// 프로젝트 시작년도와 종료년도가 같을 경우

				/*----------프로젝트를 하나만 수행했을 경우
				 * 즉,이름중복이 없을 경우------------*/
				if (!names.contains(standByInfoVO.getName())) {

					for (int i = 0; i < 12; i++) {
						if (startMonth == i + 1) {
							standByInfoVO.setMm(i, startMonMM);
						} else if (endMonth == i + 1) {
							standByInfoVO.setMm(i, endMonMM);

						} else if (startMonth < i + 1 && i + 1 <= endMonth) {
							standByInfoVO.setMm(i, 1.0f);// 사잇값은 1.0으로
						}
					}
					names.add(standByInfoVO.getName());
					standHash.put(standByInfoVO.getName(), standByInfoVO);
				}
				/*----------프로젝트를 두개이상 수행했을 경우
				 * 즉,이름중복이 있을 경우------------*/
				else if (names.contains(standByInfoVO.getName())) {

					standByInfoVOTemp = standHash.get(standByInfoVO.getName());

					for (int i = 0; i < 12; i++) {
						if (startMonth == i + 1) {
							/*----------set하기전 같은달에 두번 이상 수행 했을 경우
							 * 값을 합쳐서 set을 한다. 만약 1이 넘어가면 1.0으로 고정시킨다.------------*/
							if (standByInfoVO.getMm(i) > 0.0f) {
								startMonMM = standByInfoVO.getMm(i)
										+ startMonMM;
								if (startMonMM > 1.0f)
									startMonMM = 1.0f;
							}

							standByInfoVOTemp.setMm(i, startMonMM);

						} else if (endMonth == i + 1) {
							if (standByInfoVO.getMm(i) > 0.0f) {
								startMonMM = standByInfoVO.getMm(i)
										+ startMonMM;
								if (startMonMM > 1.0f)
									startMonMM = 1.0f;
							}

							standByInfoVOTemp.setMm(i, endMonMM);

						} else if (startMonth < i + 1 && endMonth > i + 1) {

							standByInfoVOTemp.setMm(i, 1.0f);// 사잇값은 1.0으로
						}
					}

					standHash.put(standByInfoVO.getName(), standByInfoVOTemp);
				}

			} else if (endYear > startYear) {// 시작년도보다 종료년도가 더 클 경우
				// endMonth가 12월로 고정(시작년도만 계산하므로)
				endMonth = 12;
				// System.out.println("startMonth:"+startMonth);
				/*----------프로젝트를 하나만 수행했을 경우
				 * 즉,이름중복이 없을 경우------------*/
				if (!names.contains(standByInfoVO.getName())) {

					for (int i = 0; i < 12; i++) {
						if (startMonth == i + 1) {
							// System.out.println("startMonMM:"+startMonMM);
							standByInfoVO.setMm(i, startMonMM);
						} else if (startMonth < i + 1 && i + 1 <= 12) {
							standByInfoVO.setMm(i, 1.0f);
						}
					}
					names.add(standByInfoVO.getName());
					standHash.put(standByInfoVO.getName(), standByInfoVO);
				}
				/*----------프로젝트를 두개이상 수행했을 경우
				 * 즉,이름중복이 있을 경우------------*/
				else if (names.contains(standByInfoVO.getName())) {

					standByInfoVOTemp = standHash.get(standByInfoVO.getName());

					for (int i = 0; i < 12; i++) {
						if (startMonth == i + 1) {
							/*----------set하기전 같은달에 두번 이상 수행 했을 경우
							 * 값을 합쳐서 set을 한다. 만약 1이 넘어가면 1.0으로 고정시킨다.------------*/
							if (standByInfoVO.getMm(i) > 0.0f) {
								startMonMM = standByInfoVO.getMm(i)
										+ startMonMM;
								if (startMonMM > 1.0f)
									startMonMM = 1.0f;
							}

							standByInfoVOTemp.setMm(i, startMonMM);

						} else if (endMonth == i + 1) {
							if (standByInfoVO.getMm(i) > 0.0f) {
								startMonMM = standByInfoVO.getMm(i)
										+ startMonMM;
								if (startMonMM > 1.0f)
									startMonMM = 1.0f;
							}

							standByInfoVOTemp.setMm(i, endMonMM);

						} else if (startMonth < i + 1 && i + 1 <= 12) {

							standByInfoVOTemp.setMm(i, 1.0f);// 사잇값은 1.0으로
						}
					}
					standHash.put(standByInfoVO.getName(), standByInfoVOTemp);
				}
			}
		}

		standByInfoVOs.clear();
		for (Map.Entry<String, StandByInfoVO> entry : standHash.entrySet()) {
			standByInfoVOs.add(entry.getValue());
		}

	}

	public static List<EmpMapVO> mapManage(List<EmpMapVO> EmpMapVOs) {
		List<String> names = new ArrayList<String>();
		Map<String, EmpMapVO> standHash = new HashMap<String, EmpMapVO>();
		List<EmpMapVO> ret_list = new ArrayList<EmpMapVO>();
		Calendar cal = Calendar.getInstance();

		for (EmpMapVO e : EmpMapVOs) {
			/*----------프로젝트 시작날짜,완료날짜 추출------------*/

			String startDate = e.getPj_start_day();
			String endDate = e.getPj_end_day();

			String start_day[] = startDate.split("-");
			int startYear = Integer.parseInt(start_day[0]);
			int startMonth = Integer.parseInt(start_day[1]);

			String end_day[] = endDate.split("-");
			int endYear = Integer.parseInt(end_day[0]);
			int endMonth = Integer.parseInt(end_day[1]);
			
			
			int year = cal.get(Calendar.YEAR);
			if (endYear !=  year)
				endMonth = 12;
			if(startYear != year)
				startMonth=1;
			

			EmpMapVO EmpMapVOTemp = null;
			// System.out.println(EmpMapVO.getpj());
			/*----------프로젝트를 하나만 수행했을 경우
			 * 즉,이름중복이 없을 경우------------*/
			
			if (!names.contains(e.getName())) {
				for (int i = 0; i < 12; i++) {
					if (startMonth == i + 1) {
						e.setpj(i, e.getPj_id());
					} else if (endMonth == i + 1) {
						e.setpj(i, e.getPj_id());

					} else if (startMonth < i + 1 && endMonth > i + 1) {
						e.setpj(i, e.getPj_id());// 사잇값은 1.0으로
					}
				}
				standHash.put(e.getName(), e);
				names.add(e.getName());
				ret_list.add(e);
			} else {
				/*----------프로젝트를 두개이상 수행했을 경우
				 * 즉,이름중복이 있을 경우------------*/
				EmpMapVOTemp = standHash.get(e.getName());

				int Startday_r = Integer.parseInt(e.getStartday_r());
				int Endday_r = Integer.parseInt(EmpMapVOTemp.getEndday_r());

				for (int i = 0; i < 12; i++) {

					if (startMonth == i + 1 && EmpMapVOTemp.getpj(i) != null) {// startMonth에
																				// 수행한
																				// 프로젝트가
																				// 있을
																				// 경우

						// 먼저 수행한 프로젝트 일수가 클 경우
						if ((Endday_r) > (Startday_r)) {
							EmpMapVOTemp.setpj(i, EmpMapVOTemp.getpj(i));

						} else {// 그 외의 경우
							EmpMapVOTemp.setpj(i, e.getPj_id());

						}

					} else if (startMonth == i + 1
							&& EmpMapVOTemp.getpj(i) == null) {// startMonth에
																// 수행한 프로젝트가 없을
																// 경우
						EmpMapVOTemp.setpj(i, e.getPj_id());

					} else if (startMonth < i + 1 && endMonth >= i + 1) {
						EmpMapVOTemp.setpj(i, e.getPj_id());

					}
				}
				EmpMapVOTemp.setPj_start_day(e.getPj_start_day());
				EmpMapVOTemp.setStartday_r(e.getStartday_r());
				EmpMapVOTemp.setPj_end_day(e.getPj_end_day());
				EmpMapVOTemp.setEndday_r(e.getEndday_r());
				EmpMapVOTemp.setPj_id(e.getPj_id());

				standHash.put(EmpMapVOTemp.getName(), EmpMapVOTemp);
				for (EmpMapVO em : ret_list) {
					if (em.getName().equals(EmpMapVOTemp.getName())) {
						em = EmpMapVOTemp;
					}
				}

			}

		}
		SimpleDateFormat formatter = new SimpleDateFormat ( "MM", Locale.KOREA );
		Date currentTime = new Date ( );
		int dTime = Integer.parseInt(formatter.format ( currentTime ));
		
		for (EmpMapVO em : ret_list) {
			for (int j = 0; j < 12; j++) {
				if (em.getpj(j) == null && dTime-1 < j) {
					if (em.getDivision().equals("직원")) {
						em.setpj(j, "미배치");
					} else {
						em.setpj(j, "");
					}
				} else if (em.getpj(j) == null && dTime-1 >= j) {
					if (em.getDivision().equals("직원")) {
						em.setpj(j, "대기");
					} else {
						em.setpj(j, "");
					}
				}
			}
		}
		
		return ret_list;

	}

	public static void personalManage(List<StandByInfoVO> standByInfoVOs) {
		List<String> names = new ArrayList<String>();
		Map<String, StandByInfoVO> standHash = new HashMap<String, StandByInfoVO>();

		for (StandByInfoVO standByInfoVO : standByInfoVOs) {
			/*----------프로젝트 시작날짜,완료날짜 추출------------*/
			String startDate = standByInfoVO.getStartday();
			// System.out.println("startDate"+startDate);
			String endDate = standByInfoVO.getEndday();

			String start_day[] = startDate.split("-");
			int startYear = Integer.parseInt(start_day[0]);
			int startMonth = Integer.parseInt(start_day[1]);
			int startDay = Integer.parseInt(start_day[2]);
			// System.out.println(Integer.parseInt(start_day[2]));

			String end_day[] = endDate.split("-");
			int endYear = Integer.parseInt(end_day[0]);
			int endMonth = Integer.parseInt(end_day[1]);
			int endDay = Integer.parseInt(end_day[2]);

			// 28,29,31일 월말을 30일로 고정
			if (startDay == 28 || startDay == 29 || startDay == 31) {
				startDay = 30;
			}
			if (endDay == 28 || endDay == 29 || endDay == 31) {
				endDay = 30;
			}
			// System.out.println("startDay:"+startDay);
			/*----------프로젝트 시작MM,완료MM 계산 ------------*/
			float startMonMM = Math
					.round(((30.0 - startDay + 1.0) / 30.0) * 10) / 10.0f;
			// System.out.println(Math.round(((30.0-1+1.0)/30.0)*10)/10.0f);
			float endMonMM = Math.round(endDay / 30.0 * 10) / 10.0f;

			/*----------년도 setting ------------*/
			standByInfoVO.setYear(String.valueOf(startYear));

			StandByInfoVO standByInfoVOTemp = null;
			if (startYear == endYear) {// 프로젝트 시작년도와 종료년도가 같을 경우

				for (int i = 0; i < 12; i++) {
					if (startMonth == i + 1) {
						standByInfoVO.setMm(i, startMonMM);
					} else if (endMonth == i + 1) {
						standByInfoVO.setMm(i, endMonMM);

					} else if (startMonth < i + 1 && i + 1 <= endMonth) {
						standByInfoVO.setMm(i, 1.0f);// 사잇값은 1.0으로
					}
				}

				/*----------프로젝트를 하나만 수행했을 경우
				 * 즉,이름중복이 없을 경우------------*/
				// if(!names.contains(standByInfoVO.getName())){

				// standHash.put(standByInfoVO.getName(), standByInfoVO);
				// }
				/*----------프로젝트를 두개이상 수행했을 경우
				 * 즉,이름중복이 있을 경우------------*/
				/*
				 * if(names.contains(standByInfoVO.getName())){
				 * 
				 * standByInfoVOTemp=standHash.get(standByInfoVO.getName());
				 * 
				 * for(int i=0;i<12;i++){ if(startMonth == i+1){
				 * ----------set하기전 같은달에 두번 이상 수행 했을 경우 값을 합쳐서 set을 한다. 만약 1이
				 * 넘어가면 1.0으로 고정시킨다.------------
				 * if(standByInfoVO.getMm(i)>0.0f){
				 * startMonMM=standByInfoVO.getMm(i)+startMonMM;
				 * if(startMonMM>1.0f)startMonMM=1.0f; }
				 * 
				 * standByInfoVOTemp.setMm(i,startMonMM);
				 * 
				 * }else if(endMonth == i+1){ if(standByInfoVO.getMm(i)>0.0f){
				 * startMonMM=standByInfoVO.getMm(i)+startMonMM;
				 * if(startMonMM>1.0f)startMonMM=1.0f; }
				 * 
				 * standByInfoVOTemp.setMm(i,endMonMM);
				 * 
				 * }else if(startMonth < i+1 && endMonth > i+1){
				 * 
				 * standByInfoVOTemp.setMm(i, 1.0f);//사잇값은 1.0으로 } }
				 * 
				 * standHash.put(standByInfoVO.getName(), standByInfoVOTemp); }
				 */

			} else if (endYear > startYear) {// 시작년도보다 종료년도가 더 클 경우
				// endMonth가 12월로 고정(시작년도만 계산하므로)
				endMonth = 12;
				// System.out.println("startMonth:"+startMonth);
				/*----------프로젝트를 하나만 수행했을 경우
				 * 즉,이름중복이 없을 경우------------*/
				// if(!names.contains(standByInfoVO.getName())){

				for (int i = 0; i < 12; i++) {
					if (startMonth == i + 1) {
						// System.out.println("startMonMM:"+startMonMM);
						standByInfoVO.setMm(i, startMonMM);
					} else if (startMonth < i + 1 && i + 1 <= 12) {
						standByInfoVO.setMm(i, 1.0f);
					}
				}
				standHash.put(standByInfoVO.getName(), standByInfoVO);
				// }
				/*----------프로젝트를 두개이상 수행했을 경우
				 * 즉,이름중복이 있을 경우------------*/
				// if(names.contains(standByInfoVO.getName())){
				//
				// standByInfoVOTemp=standHash.get(standByInfoVO.getName());
				//
				// for(int i=0;i<12;i++){
				// if(startMonth == i+1){
				// /*----------set하기전 같은달에 두번 이상 수행 했을 경우
				// * 값을 합쳐서 set을 한다. 만약 1이 넘어가면 1.0으로 고정시킨다.------------*/
				// if(standByInfoVO.getMm(i)>0.0f){
				// startMonMM=standByInfoVO.getMm(i)+startMonMM;
				// if(startMonMM>1.0f)startMonMM=1.0f;
				// }
				//
				// standByInfoVOTemp.setMm(i,startMonMM);
				//
				// }else if(endMonth == i+1){
				// if(standByInfoVO.getMm(i)>0.0f){
				// startMonMM=standByInfoVO.getMm(i)+startMonMM;
				// if(startMonMM>1.0f)startMonMM=1.0f;
				// }
				//
				// standByInfoVOTemp.setMm(i,endMonMM);
				//
				// }else if(startMonth < i+1 && i+1 <= 12){
				//
				// standByInfoVOTemp.setMm(i, 1.0f);//사잇값은 1.0으로
				// }
				// }
				//
				// standHash.put(standByInfoVO.getName(), standByInfoVOTemp);
				// }
			}

			// names.add(standByInfoVO.getName());
		}

		// standByInfoVOs.clear();
		// for (Map.Entry<String, StandByInfoVO> entry: standHash.entrySet()) {
		// standByInfoVOs.add(entry.getValue());
		// }
		//
	}

	public static void locationCountManage(List<ProjectCountVO> pjCount) {
		/*
		 * codeConvert=new CodeConvert();
		 * 
		 * for(ProjectCountVO pj : pjCount){ //decode
		 * pj.setLocation(codeConvert.location_Code(pjCount)); }
		 */
	}

	public static void UploadPhoto(MultipartFile file) {
		// D:\IQSHR\workspace\iqs_pj\src\main\webapp\resources\emp_photo
		String path = "D:\\IQSHR\\workspace\\iqs_pj\\src\\main\\webapp\\resources\\emp_photo\\";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		try {
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(dir + File.separator
					+ file.getOriginalFilename());

			while ((bytesRead = is.read(buffer, 0, 1023)) != -1) {
				fos.write(buffer, 0, bytesRead);
			}
			fos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static public class Compare implements Comparator<StandByInfoVO>{

		@Override
		public int compare(StandByInfoVO obj1, StandByInfoVO obj2) {
			return  obj2.getPosition().compareTo(obj1.getPosition());
		}

	}
	static public class ProjectCompare implements Comparator<StandByInfoVO>{

		@Override
		public int compare(StandByInfoVO obj1, StandByInfoVO obj2) {
			return  obj2.getProject_id().compareTo(obj1.getProject_id());
		}

	}
	static public boolean checkDate(String str)
	{
	boolean dateValidity = true;

	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss",Locale.KOREA); //20041102101244
	df.setLenient(false); // false 로 설정해야 엄밀한 해석을 함.

	try {
	Date dt = df.parse(str);
	}
	catch(ParseException pe){
	dateValidity = false;
	}catch(IllegalArgumentException ae){
	dateValidity = false;
	}

	return dateValidity;
	}

}


