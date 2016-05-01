package com.sqisoft.iqs.hr.pj.needs.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.BudgetVO;
import com.sqisoft.iqs.hr.vo.PjNeedsVO;

public interface PjNeedsService {
	public List<BudgetVO> pj_SearchList(String searchid, String search_team, String searchprog);
	public abstract BudgetVO pjneeds_getPJ(String pj_id);
	public abstract List<PjNeedsVO> pjneeds_all(String pj_id);
	
	
	public abstract void pjneeds_merge(PjNeedsVO pjneedsVO);
	public abstract void pjneeds_resize(PjNeedsVO pjneedsVO);
//	public abstract void insertSkill(String pj_id,String skill);
//	public abstract void delSkill(String pj_id);
//	public abstract String getSkill(String pj_id);
	public BudgetVO pj_Datail(String pjId);
	public BudgetVO pj_Modify(String pjId);
	public ModelAndView pjneedsReqCon(String pjId, String requirePerson);

}
