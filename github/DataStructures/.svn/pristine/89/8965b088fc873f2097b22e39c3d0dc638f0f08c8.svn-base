package com.sqisoft.iqs.hr.pj.needs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.pj.needs.dao.PjNeedsDAO;
import com.sqisoft.iqs.hr.pj.needs.service.PjNeedsService;
import com.sqisoft.iqs.hr.vo.BudgetVO;
import com.sqisoft.iqs.hr.vo.PjNeedsVO;

public class PjNeedsServiceImpl implements PjNeedsService {

	PjNeedsDAO pjnDAO;
	
	public void setPjnDAO(PjNeedsDAO pjnDAO) {
		this.pjnDAO = pjnDAO;
	}

	@Override
	public List<BudgetVO> pj_SearchList(String searchid, String search_team, String searchprog) {

		Map<String, String> hash = new HashMap<String, String>();

		hash.put("pj_id", searchid);
		hash.put("team_id", search_team);
		hash.put("pj_prog", searchprog);

		return pjnDAO.pj_SearchList(hash);
	}
	
	@Override
	public BudgetVO pj_Datail(String pjId) {
		
		BudgetVO budgetVO = pjnDAO.pj_Datail(pjId);
		
		System.out.println("프로젝트 id: "+budgetVO.getPj_id());
		System.out.println("프로젝트 기간: "+budgetVO.getPj_start_day()+"+"+budgetVO.getPj_end_day());
		System.out.println("기반분류: "+budgetVO.getPj_require());
		System.out.println("소요인원수:" +budgetVO.getpn_num());
		
		return pjnDAO.pj_Datail(pjId);
	}
	
	@Override
	public BudgetVO pj_Modify(String pjId) {
		
		BudgetVO budgetVO = pjnDAO.pj_Datail(pjId);
		return budgetVO;

	}

	
	@Override
	public ModelAndView pjneedsReqCon(String pjId, String requirePerson) {
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		
		System.out.println("현재 날짜 : " +currentDate);
		
		ModelAndView view = new ModelAndView();
		
		List<PjNeedsVO> pjneedsVO = pjnDAO.pjneeds_all(pjId);
		
		int pn_num=1;
		for (PjNeedsVO pjNeedsVO2 : pjneedsVO) {
			if(pjNeedsVO2.getArea()==null){
				pjNeedsVO2.setArea(pjnDAO.searchArea(pjNeedsVO2.getPj_id()));
				pjNeedsVO2.setPn_num(pn_num++);
			}
			System.out.println("장소!! : "+pjNeedsVO2.getArea());
		
		}
		
		int count;
		
		// 소요인원수에 0을 입력했을 시
		if(requirePerson.equals("a")){
			System.out.println("requirePerson 안나와?:"+requirePerson);
			count=-1;
			view.addObject("requirePerson", count);
			view.addObject("pjNeedsVO", pjneedsVO);

			view.setViewName("/test/deployRequirementsConditions");

			return view;
		}
		
		count = Integer.parseInt(requirePerson);
		int pjneedsSize = pjneedsVO.size();

		PjNeedsVO temp = null;
		
		// 입력한 소요 인원수가 현재 저장되어 있는 소요인원수 보다 클 경우 
		if(pjneedsSize < count){
			for(int i = pjneedsSize; i<= count; i++){
				temp = new PjNeedsVO();
				temp.setPn_num(pjneedsVO.get(i-1).getPn_num()+1);
				temp.setArea("특급");
				temp.setPn_skill("SERVER");
				temp.setPn_day_from(currentDate);
				temp.setPn_day_to(currentDate);
				temp.setDivision("직원");
				temp.setArea(pjnDAO.searchArea(pjId));
				pjneedsVO.add(temp);
			}
		}
		
		// 처음 실행 시 저장되어 있는 소요인원수를 출력하기 위함
		if(pjneedsSize != 0 && count == 0){
			count = pjneedsVO.size();
		}
		
		view.addObject("requirePerson", count-1);
		view.addObject("pjNeedsVO", pjneedsVO);

		view.setViewName("/test/deployRequirementsConditions");

		return view;

	}
	
	
	@Override
	public List<PjNeedsVO> pjneeds_all(String pj_id) {
		
		return pjnDAO.pjneeds_all(pj_id);
	}
	
	@Override
	public BudgetVO pjneeds_getPJ(String pj_id) {
		return pjnDAO.pjneeds_getPJ(pj_id);
	}

	
	@Override
	public void pjneeds_merge(PjNeedsVO pjneedsVO) {
		pjnDAO.pjneeds_merge(pjneedsVO);
	}
	
	@Override
	public void pjneeds_resize(PjNeedsVO pjneedsVO) {
		pjnDAO.pjneeds_resize(pjneedsVO);
	}
	
}
