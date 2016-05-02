package com.sqisoft.iqs.hr.pj.posting.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public interface PjpostingService {
	
//	public abstract PjpostingVO pjposting_getPJ(String pj_id);
	public abstract List<PjpostingVO>  pjposting_SearchList(String searchid, String searchprog, String searchstartday, String searchendday);
//	public abstract List<Employee_VO> getNoPlaceEmpList();
	public abstract List<PjpostingVO> pjposting_getEmp(String pj_id);
//	public abstract void pjposting_Insert(PjpostingVO pjvo);
//	public abstract List<Employee_VO> empposting_SearchList(String searchposition, String searcharea1,String searcharea2,String area,String searchetc,String searchendday, String searchdiv);
//	public abstract void pjposting_Insert_bp(String pj_id);
	
	//2014.12.16 추가
//	public abstract String getCpstartday(String name);
	
	//public abstract void pjposting_Insert_ap(String pj_id);
	
//	public abstract List<Employee_VO> emppjposting_Search(SkillVO vo); 
	
	public List<PjpostingVO> pjposting_getPjHistory(String pj_id);
	
	//2015.03.05 추가
	public abstract void pjposting_Update(PjHistoryVO ph_vo);
	public abstract void pjposting_Insert(PjHistoryVO ph_vo);
	
	
	//2015.03.11추가
	public abstract void pjposting_delete(Map<String,String> map);
	//2015.03.23추가
	public abstract Map<String, String> empCheck(String name);
	
	//2015.03.31추가 
	public abstract List<PjpostingVO> pjposting_getEmpPast(String pj_id);
	
	/***********************************************
	 * 이름으로부터 조건이 일치하는 사용자의 리스트를 가져온다.
	 * @param name
	 * @return 사용자 리스트
	 ***********************************************/
	public abstract List<Employee_VO> pjposting_getEmployessByName(String name);
	/**
	 * 기간이 겹치는 직원이 있는지 확인한다.
	 * @param map
	 * @return List
	 */
	public abstract List<PjpostingVO> getPjIntersecDur(Map<String, String> map);
}
