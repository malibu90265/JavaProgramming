package com.sqisoft.iqs.hr.pj.posting.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public interface PjpostingDAO {
	
	public abstract PjpostingVO pjposting_getPJ(String pj_id);
	public abstract List<PjpostingVO> pjposting_SearchList(Map<String, String> hash);
	public abstract List<Employee_VO> getNoPlaceEmpList();
	public abstract List<PjpostingVO> pjposting_getEmp(String pj_id);
	
	public abstract List<String> getEmpSkillList(String empname);
	public abstract List<String> getPJSkillList(String pj_id);
	
//	public abstract List<PjpostingVO> empposting_SearchList(Map<String, String> hash);
//	public abstract List<Employee_VO> getPlacedEmpList(Map<String, String> map);
	
//	public abstract void pjposting_Insert(PjpostingVO pjvo);
	
//	public abstract void pjposting_Insert_bp_ap(String pj_id);
//	public abstract void pjposting_Insert_bp_cp(String pj_id);
	
	//2014.12.16 추가
	public abstract String getCpstartday(String name);
	
	//2014.12.17 추가
	public abstract String getHireDateByYear(String name);
	public abstract String getQuitDateByYear(String name);
	
	//2014.12.18추가
	public abstract List<Employee_VO> emppjposting_Search(SkillVO vo); 
	
	//2014.01.03추가
	public abstract List<PjpostingVO> getPJHistory(String pj_id);
	
	//2015.03.05 추가 
	public abstract void pjposting_Update(PjHistoryVO ph_vo);
	public abstract void pjposting_Insert(PjHistoryVO ph_vo);
	
	//2015.03.11 추가
	public abstract void pjposting_delete(Map<String, String> map);
	
	//2015.03.11 추가
	public abstract Map<String, String> pjposting_empCheck(String name);
	//2015.03.31 추가
	
	public abstract List<PjpostingVO> pjposting_getEmpPast(String pj_id);
	public abstract void quithistoryDelete(Map<String, String> hash);
	public abstract void quitUpdate(Map<String, String> hash);
	/**
	 * DB에서 비슷한 이름을 가지는 직원의 목록들을 불러온다.   
	 * @param name
	 */
	public abstract List<Employee_VO> pjposting_getEmployessByName(String name);
	/**
	 * 기간이 겹치는 직원이 있는지 확인한다.
	 * @see pjPosting_mapper-sql.xml
	 * @param name
	 * @return
	 */
	public abstract List<PjpostingVO> getPjIntersecDur(Map<String, String> map);
}
