package com.sqisoft.iqs.hr.pj.needs.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.BudgetVO;
import com.sqisoft.iqs.hr.vo.PjNeedsVO;

public interface PjNeedsDAO {

	public List<BudgetVO> pj_SearchList(Map<String, String> hash);
	public abstract BudgetVO pjneeds_getPJ(String pj_id);
	public abstract List<PjNeedsVO> pjneeds_all(String pj_id);
	
	public void pjneeds_merge(PjNeedsVO pjneedsVO);
	public void pjneeds_resize(PjNeedsVO pjneedsVO);
	public BudgetVO pj_Datail(String pjId);
	public String searchArea(String pj_id);
	
//	public abstract void insertSkill(SkillVO vo);
//	public abstract void delSkill(String pj_id);
// public abstract List<SkillVO> getSkill(String pj_id);
	

}
