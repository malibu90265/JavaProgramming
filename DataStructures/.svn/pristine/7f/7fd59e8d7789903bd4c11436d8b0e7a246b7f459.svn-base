package com.sqisoft.iqs.hr.pj.posting.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.sqisoft.iqs.hr.pj.posting.dao.PjpostingDAO;
import com.sqisoft.iqs.hr.pj.posting.service.PjpostingService;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.team.dao.TeamDAO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public class PjpostingServiceImpl implements PjpostingService {

	private PjpostingDAO pjpostingDao;

	private TeamDAO t_dao;
	
	public void setPjpostingDao(PjpostingDAO pjpostingDao) {
		this.pjpostingDao = pjpostingDao;
	}

	public void setT_dao(TeamDAO t_dao) {
		this.t_dao = t_dao;
	}

	@Override
	public List<PjpostingVO> getPjIntersecDur(Map<String, String> map) {
		return pjpostingDao.getPjIntersecDur(map);
	}
	
	@Override
	public List<Employee_VO> pjposting_getEmployessByName(String name) {
		return pjpostingDao.pjposting_getEmployessByName(name);
	}
	
	//프로젝트 목록 검색 
	@Override
	public List<PjpostingVO> pjposting_SearchList(String searchid,
			String searchprog, String searchstartday, String searchendday) {

		Map<String, String> hash = new HashMap<String, String>();

		hash.put("pj_id", searchid);
		hash.put("pj_prog", searchprog);
		hash.put("pj_start_day", searchstartday);
		hash.put("pj_end_day", searchendday);

		List<PjpostingVO> list = pjpostingDao.pjposting_SearchList(hash);

		return list;
	}
/*
	@Override
	public PjpostingVO pjposting_getPJ(String pj_id) {
		PjpostingVO vo = pjpostingDao.pjposting_getPJ(pj_id);
		String skill_name = "";
		List<String> skill_list = pjpostingDao.getPJSkillList(pj_id);
		if (skill_list.isEmpty()) {
			vo.setSkill_name("-");
		} else {
			for (int i = 0; i < skill_list.size(); i++) {
				if (i == skill_list.size() - 1) {
					skill_name += skill_list.get(i);
				} else {
					skill_name += (skill_list.get(i) + ", ");
				}
			}
			vo.setSkill_name(skill_name);
		}
		if (vo.getPj_loc() == null) {
			vo.setPj_loc("");
		}
		vo.setPj_period(vo.getPj_start_day() + "~" + vo.getPj_end_day());
		return vo;
	}*/

	
	/* 투입이력조회 팝업 */
	public List<PjpostingVO> pjposting_getPjHistory(String pj_id) {/////////////////
		
		List<PjpostingVO> list = pjpostingDao.getPJHistory(pj_id);
		System.out.println("returnLIST--------"+list);
	
		return list;
	}
	
	/*@Override
	public List<Employee_VO> getNoPlaceEmpList() {
		List<Employee_VO> list = pjpostingDao.getNoPlaceEmpList();

		// SQI직원 직급을 등급으로 바꾸는 함수
		// 차후 코드 테이블로 바뀌어야 함
		list = PositionToGrade(list);

		// 2014.11.27 보유기술 name setting
		list = SkillNameSet(list);

		// pj_id, end_day default value set!
		list = SetDafaultValue(list);

		return list;
	}*/

	/*public List<Employee_VO> SetDafaultValue(List<Employee_VO> list) {
		String default_value = " ";
		for (Employee_VO e : list) {
			if (e.getCpid() == null) {
				e.setCpid(default_value);
			}
			if (e.getCpstartday() == null) {
				e.setCpstartday(default_value);
			}
			if (e.getCpendday() == null) {
				e.setCpendday(default_value);
			}
			if (e.getApid() == null) {
				e.setApid(default_value);
			}
			if (e.getApstartday() == null) {
				e.setApstartday(default_value);
			}
			if (e.getApendday() == null) {
				e.setApendday(default_value);
			}
			if (e.getUse_skill() == null) {
				e.setUse_skill(default_value);
			}
			if (e.getArea() == null) {
				e.setArea(default_value);
			}

		}
		return list;
	}
*/
	
	//스킬 관련된거 전부 사용되지 않음  
	public List<Employee_VO> SkillNameSet(List<Employee_VO> list) {
		
		for (Employee_VO e : list) {
			String skill_name = "";
			List<String> skill_list = pjpostingDao.getEmpSkillList(e
					.getName());

			for (int i = 0; i < skill_list.size(); i++) {
				if (i == skill_list.size() - 1) {
					skill_name += skill_list.get(i);
				} else {
					skill_name += (skill_list.get(i) + ", ");
				}
			}
			e.setSkill_name(skill_name);
		}

		return list;
	}

	public List<Employee_VO> PositionToGrade(List<Employee_VO> list) {
		String p1 = "부장", p2 = "차장", p3 = "과장", p4 = "대리", p5 = "사원";
		String g1 = "특급+", g2 = "특급", g3 = "고급", g4 = "중급", g5 = "초급";
		String div_sqi = "직원";

		for (Employee_VO e : list) {

			if (e.getDivision().equals(div_sqi)) {
				if (e.getPosition().equals(p1)) {
					e.setPosition(g1);
				} else if (e.getPosition().equals(p2)) {
					e.setPosition(g2);
				} else if (e.getPosition().equals(p3)) {
					e.setPosition(g3);
				} else if (e.getPosition().equals(p4)) {
					e.setPosition(g4);
				} else if (e.getPosition().equals(p5)) {
					e.setPosition(g5);
				}
			}
		}

		return list;
	}

	/*@Override
	public List<Employee_VO> empposting_SearchList(String searchposition,
			String searcharea1,String searcharea2,String area, String etc, String searchendday, String searchdiv) {

		
		// 직위, 등급 Setting
		Map<String, String> map = new HashMap<String, String>();
		map.put("position", searchposition);
		map.put("end_day", searchendday);
		map.put("area1", searcharea1);
		map.put("area2", searcharea2);
		map.put("div", searchdiv);
		
		
		System.out.println("22222222222222222" + map);
		List<Employee_VO> ret_list = new ArrayList<Employee_VO>();
		
		List<Employee_VO> placed_list = pjpostingDao.getPlacedEmpList(map);
		String all_value = "al";
		List<String> needs_skill = new ArrayList<String>();
//
//		if (!searchserver.equals(all_value)) {
//			needs_skill.add(searchserver);
//		} else if (!searchdb.equals(all_value)) {
//			needs_skill.add(searchdb);
//		} else if (!searchui.equals(all_value)) {
//			needs_skill.add(searchui);
//		} else if (!searchlanguage.equals(all_value)) {
//			needs_skill.add(searchlanguage);
//		} else if (!searchframework.equals(all_value)) {
//			needs_skill.add(searchframework);
//		} else if (!searchetc.equals("")) {
//			needs_skill.add(searchetc);
//		}

		placed_list = PositionToGrade(placed_list);
		placed_list = SkillNameSet(placed_list);
		placed_list = SetDafaultValue(placed_list);

		boolean hasSkill = false;

		// 기술을 가지고 있는 사람만 ret_list에 add!!
		for (Employee_VO e : placed_list) {
			// 모두 all 인경우에는 무조건 리스트에 더해 준다.
			if (needs_skill.isEmpty()) {
				ret_list.add(e);
			} else {
				List<String> skill_list = pjpostingDao.getEmpSkillList(e
						.getName());

				for (String s : skill_list) {
					for (String ns : needs_skill) {
						if (s.equals(ns)) {
							hasSkill = true;
							break;
						}
					}
				}
				if (hasSkill == true) {
					ret_list.add(e);
					hasSkill = false;
				}

			}
		}

		return ret_list;
	}
*/
	//프로젝트 투입 현황 
	@Override
	public List<PjpostingVO> pjposting_getEmp(String pj_id) {
		List<PjpostingVO> list = pjpostingDao.pjposting_getEmp(pj_id);
		System.out.println(list);
		/*for (PjpostingVO e : list) {
			String skill_name = "";
			List<String> skill_list = pjpostingDao.getEmpSkillList(e
					.getName());

			for (int i = 0; i < skill_list.size(); i++) {
				if (i == skill_list.size() - 1) {
					skill_name += skill_list.get(i);
				} else {
					skill_name += (skill_list.get(i) + ", ");
				}
			}
			e.setSkill_name(skill_name);
		}*/
		
		return list;
	}
	//투입기간 이 현재를 지난 사람 목록 조회 (=투입이력조회)
	@Override
	public List<PjpostingVO> pjposting_getEmpPast(String pj_id) {
		List<PjpostingVO> list = pjpostingDao.pjposting_getEmpPast(pj_id);
		System.out.println(list);
			
		return list;
	}

	//직원여부 , 올해입사자 체크 (js)
	@Override
	public Map<String, String> empCheck(String name){
		Map<String, String> map= pjpostingDao.pjposting_empCheck(name);
		System.out.println(map);
		return map;
	}
	
	@Override
	public void pjposting_Update(PjHistoryVO ph_vo) {
		pjpostingDao.pjposting_Update(ph_vo);
		
		//직원인 경우 대기 정보 insert 
		if (ph_vo.getDivision().equals("직원")){
			setPjHistoryWaiting(ph_vo.getName());	
		}
	}
	
	@Override
	public void pjposting_Insert(PjHistoryVO ph_vo) {

		pjpostingDao.pjposting_Insert(ph_vo);
		
		//직원인 경우 대기 정보 insert 
		if (ph_vo.getDivision().equals("직원")){
			setPjHistoryWaiting(ph_vo.getName());	
		}
	}
	
	@Override
	public void pjposting_delete(Map<String,String> map){
		//System.out.println(name+" "+pj_id);
		
		//value =pj_id,division 의 string 형태이기에 , 으로  split
		/*String[] data=value.split(",");*/
				
	//	Map<String, String> hash = new HashMap<String, String>();
	
		/*for(int i=0; i<data.length; i++){
			System.out.println("delete pj_id :"+data[0]);
			System.out.println("delete division :"+data[1]);
		}*/
/*		hash.put("name", name);
		hash.put("pj_id", pj_id);*/
		
	
		pjpostingDao.pjposting_delete(map);
		
		//직원인 경우 대기 정보 insert 
			if (map.get("division").equals("직원")){
				setPjHistoryWaiting(map.get("name"));	
			}
			
		
	}
/*	 mpplace 참조하던 옛날 insert 
	@Override
	public void pjposting_Insert(PjpostingVO pjvo) {
		// apstartday 가 현재 날짜 보다 앞서는 경우 apid, apstartday, apendday,
		// ap_use_skill을
		// cpid, cpstartday, cpendday, use_skill로 값을 옮겨준다.

		if (pjvo.getApstartday() != null && !pjvo.getApstartday().equals("")) {
			SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMdd",
					Locale.KOREA);
			Date currentTime = new Date();
			int dTime = Integer.parseInt(formatter.format(currentTime));
			int ap_start_day = Integer.parseInt(pjvo.getApstartday().replace("-", ""));

			if (dTime - ap_start_day >= 0) {
				// ap value -> cp value
				pjvo.setCpid(pjvo.getApid());
				pjvo.setCpstartday(pjvo.getApstartday());
				pjvo.setCpendday(pjvo.getApendday());
				pjvo.setUse_skill(pjvo.getAp_use_skill());

				// ap value 기본값 setting
				pjvo.setApid(null);
				pjvo.setApstartday(null);
				pjvo.setApendday(null);
				pjvo.setAp_use_skill(null);
			}
			

		}
		
		if(pjvo.getCpendday() != null  && pjvo.getCpendday().length()>=8){
			int cp_end_day = Integer.parseInt(pjvo.getCpendday().replace("-", ""));
			SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMdd", Locale.KOREA);
			Date currentTime = new Date();
			int dTime = Integer.parseInt(formatter.format(currentTime));
			
			if(pjvo.getCpstartday() != null){
				int cp_start_day = Integer.parseInt(pjvo.getCpstartday().replace("-", ""));
				
			
				if (cp_start_day <= cp_end_day && cp_end_day<=dTime){
					pjvo.setCpid(null);
					pjvo.setCpstartday(null);
					pjvo.setCpendday(null);
					pjvo.setUse_skill(null);
					pjvo.setAp_use_skill(null);
					pjvo.setApstartday(null);
					pjvo.setApendday(null);
					pjvo.setAp_use_skill(null);
				}
			}
	}
		pjpostingDao.pjposting_Insert(pjvo);
		
		
}*/
/*  mapplace 의 인원에 대한 cpid 초기화 하는 메소드 
 * mpplace 사용 x이므로 사용 x 
	@Override
	public void pjposting_Insert_bp(String pj_id) {
		// 프로젝트 update 전에 해당 프로젝트 ap/cp values default setting!

		pjpostingDao.pjposting_Insert_bp_ap(pj_id);

	}
*/
	
	//사용 x
/*	@Override
	public String getCpstartday(String name) {

		return pjpostingDao.getCpstartday(name);
	}
*/
	/*@Override
	 * 
	 * pj_histioy와 mpplace 동기화 후 대기 insert 하던 메소
	public void pjposting_Insert_ap(String pj_id) {
//
//		 1. mpplace table과 pj_history table 동기화 
		List<PjpostingVO> p_list = pjpostingDao.pjposting_getEmp(pj_id);
		System.out.println(p_list);
//		List<PjHistoryVO> h_list = t_dao.getPjHistoryListByPJID(pj_id);
//		Map<String, PjHistoryVO> map = new HashMap<String, PjHistoryVO>();
//		
//		for (PjHistoryVO p : h_list) {
//			map.put(p.getName(), p);
//		}
		 1.1 pj_id에 속한 mpplace의 인원과 pj_history 인원 비교 

//		for (PjpostingVO p : p_list) {
//			System.out.println("pj_post list : " + p);
//			for (PjHistoryVO h : h_list) {
//				System.out.println("pj_history list : " + h);
//				if (p.getName().equals(h.getName())) {
//					map.remove(h.getName());
//					break;
//				}
//			}
//		}
//		 1.2. mpplace에 삭제 된 인원(배치예정 인원)을 pj_history에서 삭제 
//		Iterator<String> keys = map.keySet().iterator();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMdd", Locale.KOREA);
		Date currentTime = new Date();
		int dTime = Integer.parseInt(formatter.format(currentTime));
		while (keys.hasNext()) {
			String temp = keys.next();
			int pj_end_day = Integer.parseInt(map.get(temp).getPj_end_day().replace(
					"-", ""));
		
			
			오늘날짜와 이전이후 비교 
			오늘날짜 이후에 배치 예정되있는 인력을 mpplace에서 뺄 경우 Pj_history에도 남으면 안되기 때문(투입된것 x)
			if(dTime < pj_end_day) {
				System.out.println("delete test : "  + temp);
				t_dao.deletePjHistory(map.get(temp));
			} 
			if (map.get(temp).getDivision().equals("직원")){
				setPjHistoryWaiting(temp);	
			}
			
		}
		
		 pj_id value '대기' Insert!! 
		
		for (PjpostingVO p : p_list) {
			System.out.println("대기 method 전 : " + p);
			if (p.getDivision().equals("직원")){
				setPjHistoryWaiting(p.getName());	
			}
			
		}
	
	}*/
	
	
	
	
	/* 3. pj_history에 대기 적용*/
	public void setPjHistoryWaiting(String name) {
		
		System.out.println("대기 적용 method 시작!");
		//3.1.1 name의모든 대기 정보 삭제 
		t_dao.deletePjHistoryWaiting(name);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/* 3.1.2 input data name에 대항하는 db data를 모두 가져오기(날짜 순서대로)*/
		List<PjHistoryVO> ph_list = t_dao.getPjHistoryListByName(name);
		GregorianCalendar pre_cal = new GregorianCalendar();
		GregorianCalendar post_cal = new GregorianCalendar();
		Date pre_date = null;
		Date post_date = null;
		
		//올해 입사자의 입사일 ('yyyy-mm-dd 00:00')
		String hire_date = pjpostingDao.getHireDateByYear(name);    
		//올해 퇴사자의 퇴사일 ('yyyy-mm-dd 00:00')
		String quit_date = pjpostingDao.getQuitDateByYear(name);
	
		
		
		if (!ph_list.isEmpty()) {
			
			/*1. 올해 입사자의 경우 입사일을 시작일로 첫 프로젝트 투입 전까지 대기 setting */
			if (hire_date != null) {  
				try {
					post_date = sdf.parse(ph_list.get(0).getPj_start_day()); 
					post_cal.setTime(post_date);
					post_cal.add(Calendar.DATE, -1);
					  
					// PJ배치기간 입사일이 시작일일 경우 '대기' (입사일) ~ (입사일-1)로 입력되는 경우 방지 
					if(!hire_date.equals(sdf.format(post_date))){  
						pjpostingDao.pjposting_Insert(new PjHistoryVO(ph_list.get(0).getName(), "대기", hire_date, sdf.format(post_cal.getTime())));
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
				
			} else {
				//올해 초부터 대기인 인원은 첫 프로젝트 시작일 전까지 대기로 insert!
//				???????????????????
				try {
					post_date = sdf.parse(ph_list.get(0).getPj_start_day());
					
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
				post_cal.setTime(post_date);
				post_cal.add(Calendar.DATE, -1);
				String year_start_date = sdf.format(post_cal.getTime()).substring(0,4)+"-01-01";
					
	//			System.out.println("year start day check : " + year_start_date);
	//			System.out.println("default start : " + new PjHistoryVO(ph_list.get(0).getName(), "대기",year_start_date, sdf.format(post_cal.getTime()), ""));
				pjpostingDao.pjposting_Insert(new PjHistoryVO(ph_list.get(0).getName(), "대기",year_start_date, sdf.format(post_cal.getTime())));
			}
			
			//employee -> 퇴사일 등록시 호출 해야함 
			if(quit_date!=null){
				Map<String, String> hash = new HashMap<String, String>();

				hash.put("name", name);
				hash.put("quit_date", quit_date);
				//퇴사일 있는 경우 퇴사 이후 배치된 프로젝트에서 배치 취소
				pjpostingDao.quithistoryDelete(hash);
				// 퇴사일이후로 진행중인 프로젝트의 pjendday를 퇴사일로 setting 
				pjpostingDao.quitUpdate(hash);
			}
			
			//중복 대기 합치기 
			List<PjHistoryVO> mergeList = null;
			for(int i=0,j=ph_list.size();i<j;i++){
				System.out.println(ph_list.get(i));
				
				PjHistoryVO mrow =  ph_list.get(i);
				
				//합칠 데이터가 없을경우 현 데이터 삽입
				if(mergeList == null || mergeList.size()==0){
					mergeList = new ArrayList<PjHistoryVO>();
					mergeList.add(mrow);
				}else{
					//merge
					boolean adder = false;
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date cStDt = null,cEdDt = null,tStDt = null,tEdDt = null;
					for(PjHistoryVO compareRow : mergeList){
						try {
							cStDt = format.parse(compareRow.getPj_start_day());
							cEdDt = format.parse(compareRow.getPj_end_day());
							tStDt = format.parse(mrow.getPj_start_day());
							tEdDt = format.parse(mrow.getPj_end_day());
						} catch (ParseException e) {
							e.printStackTrace();
						}
					
						
						if(cEdDt.getTime() >= tStDt.getTime()){
							
							if(cEdDt.getTime() <= tEdDt.getTime()){
								compareRow.setPj_end_day(mrow.getPj_end_day());
							}
							
							adder = true;
							break;
						}
					}
					if(!adder){
						mergeList.add(mrow);
					}
				}
			}
			
//			System.out.println(mergeList);
			
			ph_list=mergeList;
			for(PjHistoryVO p : ph_list) {
				System.out.println("pj_list check : " + p.toString());
			}
			
			for (int i = 1; i <ph_list.size(); i++) {
					/* 3.2 i번째 data의 pj_end_day와 i+1 번째의 pj_start_day와 비교*/
					try {
				//		int addnum=1;
					/*	while (ph_list.size() > i+addnum && ph_list.get(i).getPj_id().equals("대기")&&ph_list.get(i+addnum).getPj_id().equals("대기")){
							
							if(!(ph_list.get(i).getPj_id().equals("대기"))&&!(ph_list.get(i+addnum).getPj_id().equals("대기")))break;
							addnum++;
						}*/
						
						pre_date = sdf.parse(ph_list.get(i-1).getPj_end_day());
						post_date = sdf.parse(ph_list.get(i).getPj_start_day());
						pre_cal.setTime(pre_date);
						post_cal.setTime(post_date);
						/* 3.2.1 비교값을 통해 대기 pj_start_day, pj_end_day 계산*/
						post_cal.add(Calendar.DATE, -1);
						
						if (post_cal.after(pre_cal)) {
							pre_cal.add(Calendar.DATE, 1);
							
							System.out.println("loop : " + new PjHistoryVO(ph_list.get(i).getName(), "대기", sdf.format(pre_cal.getTime()), sdf.format(post_cal.getTime()), ""));
							
							/* 3.2.2 계산 된 대기 프로젝트를 pj_history에 insert!*/
							pjpostingDao.pjposting_Insert(new PjHistoryVO(ph_list.get(i).getName(), "대기", sdf.format(pre_cal.getTime()), sdf.format(post_cal.getTime())));
							}
					//	addnum++;
						} catch (ParseException e) {
							
							e.printStackTrace();
						}
					}
			
					try {
						
						pre_date = sdf.parse(ph_list.get(ph_list.size()-1).getPj_end_day());
						pre_cal.setTime(pre_date);
						pre_cal.add(Calendar.DATE, 1);
						
						//올해 퇴사자의 경우 최종 프로젝트 종료일과 퇴사일이 같지 않은경우 
						//최종 프로젝트 종료 후 퇴사일까지 대기 상태 setting
						if (quit_date != null && !ph_list.get(ph_list.size()-1).getPj_end_day().equals(quit_date)) {
							pjpostingDao.pjposting_Insert(new PjHistoryVO(ph_list.get(0).getName(), "대기", sdf.format(pre_cal.getTime())
								, quit_date));
						} else {
						//default 최종 프로젝트 종료 후 해당년도 12월 31일까지 대기	
							String year_end_date = sdf.format(pre_cal.getTime()).substring(0,4)+"-12-31";
							
							if (!year_end_date.equals(sdf.format(pre_cal.getTime()))) {
								pjpostingDao.pjposting_Insert(new PjHistoryVO(ph_list.get(0).getName(), "대기", sdf.format(pre_cal.getTime()), year_end_date));
								}
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
		 
			
		} else {
			// 해당년도 프로젝트 투입이 하나도 결정되지 않은 인원
			// 올해 1월 1일부터 12월 31일까지 대기로 insert!
			
		/* 확인요망 
		 * ----> 스케줄러 사용 여부결정
		 * ---> 언제 실행되는지 */
			
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY", Locale.KOREA);
			Date currentTime = new Date();
			String current_year = formatter.format(currentTime);
			String year_start_day="";
			if(hire_date!=null)year_start_day =hire_date;
			else year_start_day = current_year + "-01-01";
			String yaer_last_day = current_year + "-12-31";
			
			pjpostingDao.pjposting_Insert(new PjHistoryVO(name, "대기", year_start_day, yaer_last_day));

		}
		
	
	}

	
	
/*	 배치 ui바뀌기 전 대기 method
	// 3. pj_history에 대기 적용
	public void setPjHistoryWaiting(String name) {
		
		System.out.println("대기 적용 method 시작!");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 3.1 input data name에 대항하는 db data를 모두 가져오기(날짜 순서대로)
		List<PjHistoryVO> ph_list = t_dao.getPjHistoryListByName(name);
		GregorianCalendar pre_cal = new GregorianCalendar();
		GregorianCalendar post_cal = new GregorianCalendar();
		Date pre_date = null;
		Date post_date = null;
		
		//올해 입사자의 입사일 ('yyyy-mm-dd 00:00')
		String hire_date = pjpostingDao.getHireDateByYear(name);    
		//올해 퇴사자의 퇴사일 ('yyyy-mm-dd 00:00')
		String quit_date = pjpostingDao.getQuitDateByYear(name);
		
		for(PjHistoryVO p : ph_list) {
			System.out.println("pj_list check : " + p);
		}
		
		
		if (!ph_list.isEmpty()) {
			
			//1. 올해 입사자의 경우 입사일을 시작일로 첫 프로젝트 투입 전까지 대기 setting 
			if (hire_date != null) {  
				try {
					post_date = sdf.parse(ph_list.get(0).getPj_start_day()); 
					post_cal.setTime(post_date);
					post_cal.add(Calendar.DATE, -1);
					  
					// PJ배치기간 입사일이 시작일일 경우 '대기' (입사일) ~ (입사일-1)로 입력되는 경우 방지 
					if(!hire_date.equals(sdf.format(post_date))){  
						t_dao.insertPjHistory(new PjHistoryVO(ph_list.get(0).getName(), "대기", hire_date, sdf.format(post_cal.getTime()), ""));
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
				
			} else {
				//올해 초부터 대기인 인원은 첫 프로젝트 시작일 전까지 대기로 insert!
//				???????????????????
				try {
					post_date = sdf.parse(ph_list.get(0).getPj_start_day());
					
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
				post_cal.setTime(post_date);
				post_cal.add(Calendar.DATE, -1);
				String year_start_date = sdf.format(post_cal.getTime()).substring(0,4)+"-01-01";
					
	//			System.out.println("year start day check : " + year_start_date);
	//			System.out.println("default start : " + new PjHistoryVO(ph_list.get(0).getName(), "대기",year_start_date, sdf.format(post_cal.getTime()), ""));
				t_dao.insertPjHistory(new PjHistoryVO(ph_list.get(0).getName(), "대기",year_start_date, sdf.format(post_cal.getTime()), ""));
			}
			
			for (int i = 1; i <ph_list.size(); i++) {
					// 3.2 i번째 data의 pj_end_day와 i+1 번째의 pj_start_day와 비교
					try {
//						int addnum=1;
//						while (ph_list.size() > i+addnum && ph_list.get(i).getPj_id().equals("대기")&&ph_list.get(i+addnum).getPj_id().equals("대기")){
//							
//							if(!(ph_list.get(i).getPj_id().equals("대기"))&&!(ph_list.get(i+addnum).getPj_id().equals("대기")))break;
//							addnum++;
//						}
						
						pre_date = sdf.parse(ph_list.get(i-1).getPj_end_day());
						post_date = sdf.parse(ph_list.get(i).getPj_start_day());
						pre_cal.setTime(pre_date);
						post_cal.setTime(post_date);
						// 3.2.1 비교값을 통해 대기 pj_start_day, pj_end_day 계산
						post_cal.add(Calendar.DATE, -1);
						
						if (post_cal.after(pre_cal)) {
							pre_cal.add(Calendar.DATE, 1);
							
							System.out.println("loop : " + new PjHistoryVO(ph_list.get(i).getName(), "대기", sdf.format(pre_cal.getTime()), sdf.format(post_cal.getTime()), ""));
							
							// 3.2.2 계산 된 대기 프로젝트를 pj_history에 insert!
							t_dao.insertPjHistory(new PjHistoryVO(ph_list.get(i).getName(), "대기", sdf.format(pre_cal.getTime()), sdf.format(post_cal.getTime()), ""));
							}
					//	addnum++;
						} catch (ParseException e) {
							
							e.printStackTrace();
						}
					}
			
					try {
						
						pre_date = sdf.parse(ph_list.get(ph_list.size()-1).getPj_end_day());
						pre_cal.setTime(pre_date);
						pre_cal.add(Calendar.DATE, 1);
						
						//올해 퇴사자의 경우 최종 프로젝트 종료일과 퇴사일이 같지 않은경우 
						//최종 프로젝트 종료 후 퇴사일까지 대기 상태 setting
						if (quit_date != null && !ph_list.get(ph_list.size()-1).getPj_end_day().equals(quit_date)) {
							t_dao.insertPjHistory(new PjHistoryVO(ph_list.get(0).getName(), "대기", sdf.format(pre_cal.getTime())
								, quit_date, ""));
						} else {
						//default 최종 프로젝트 종료 후 해당년도 12월 31일까지 대기	
							String year_end_date = sdf.format(pre_cal.getTime()).substring(0,4)+"-12-31";
							
							if (!year_end_date.equals(sdf.format(pre_cal.getTime()))) {
								t_dao.insertPjHistory(new PjHistoryVO(ph_list.get(0).getName(), "대기", sdf.format(pre_cal.getTime()), year_end_date, ""));
								}
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
		 
			
		} else {
			// 해당년도 프로젝트 투입이 하나도 결정되지 않은 인원
			// 올해 1월 1일부터 12월 31일까지 대기로 insert!
			
//		  확인요망 
//		  ----> 스케줄러 사용 여부결정
//		   ---> 언제 실행되는지 
			
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY", Locale.KOREA);
			Date currentTime = new Date();
			String current_year = formatter.format(currentTime);
			String year_start_day;
			if (hire_date != null)
				year_start_day=hire_date;
			else year_start_day = current_year + "-01-01";
			String yaer_last_day = current_year + "-12-31";
			
			t_dao.insertPjHistory(new PjHistoryVO(name, "대기", year_start_day, yaer_last_day, ""));

		}
		
	
	}
*/


/*	@Override
	public List<Employee_VO> emppjposting_Search(SkillVO vo) {
	
		return pjpostingDao.emppjposting_Search(vo);
	}
*/

	
}
