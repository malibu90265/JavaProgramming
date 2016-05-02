package com.sqisoft.iqs.humanResource.candidate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.humanResource.candidate.service.CandidateService;
import com.sqisoft.iqs.humanResource.candidate.vo.CandidateVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class CandidateController {
	
	private CandidateService candidateService;
	
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	// 배치대상자 검색
	// 후보자 검색 페이지로 가기
	@RequestMapping("/candidateSearch")
	public String candidateSearch(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "candidateTest/candidate";
	}
	
	//selectBox에서 팀 종류 뿌려주기
	@RequestMapping("/selectTeam")
	public ModelAndView getSelectTeam(){
		ModelAndView view = new ModelAndView();
		List<CandidateVO> searchTeamList = candidateService.getSearchTeamListAjax();
		
		view.addObject("searchTeamList", searchTeamList);
		view.setViewName("candidateTest/candidateSearchTeam");
		return view;
	}
	
	//팀별 프로젝트 검색
	@RequestMapping("/searchTeamProject")
	public ModelAndView getSearchTeamProjectListAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		String tm_id = request.getParameter("tm_id");
		List<CandidateVO> searchTeamProjectList = candidateService.getSearchTeamProjectListAjax(tm_id);
		
		view.addObject("searchTeamProjectList", searchTeamProjectList);
		view.setViewName("candidateTest/candidateList");
		return view;
	}
	
	@RequestMapping("/getCandidateListAjax")
	public ModelAndView getCandidateListAjax2(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		return view;
	}
	
	// 2. 선택된 프로젝트별 인력소요 디테일 리스트
	@RequestMapping("getCandidateDetailFormAjax")
	public ModelAndView getCandidateDetailFormAjax(String pjId, String testingVal) {
		
		
		ModelAndView view = new ModelAndView();

		if(pjId == null || pjId == "") {
			view.setViewName("/candidateTest/candidateDetailForm");
		}
		else {
			List<CandidateVO> candidateConditionList = candidateService.getCandidateConditionList(pjId);
			view.addObject("candidateConditionList", candidateConditionList);
			view.addObject("pjId", pjId);
			view.setViewName("/candidateTest/candidateDetailForm");
		}
		
		return view;
	}
	
	@RequestMapping("getCandidateDetailClickAjax")
	public ModelAndView getCandidateDetailClickAjax(String grade) {
		ModelAndView view = new ModelAndView();
		List<CandidateVO> candidateDetailClickList = candidateService.getCandidateDetailClickList(grade);
		view.addObject("candidateResultList", candidateDetailClickList);
		view.setViewName("/candidateTest/candidateSearchResultForm");
		
		return view;
	}
	
	//우선순위 지정 Form
	@RequestMapping("/getCandidateSearchFormAjax")
	public ModelAndView getCandidateSearchFormAjax(CandidateVO candidateVO){
		ModelAndView view = new ModelAndView();
		view.addObject("candidateVO", candidateVO);
		view.setViewName("candidateTest/candidateSearchForm");
		return view;
	}
	
	// 결과 리스트
	@RequestMapping("/getCandidateSearchResultFormAjax")
	public ModelAndView arrangeCandidate(CandidateVO candidateVO) {
		ModelAndView view = new ModelAndView();
		List<CandidateVO> candidateResultList = this.candidateService.arrangeCandidate(candidateVO);
		view.addObject("candidateResultList", candidateResultList);
		view.setViewName("/candidateTest/candidateSearchResultForm");

		return view;
	}
	
	//이욱진 9.21 추가
	@RequestMapping("/candidateSelectFunctionAjax")
	public ModelAndView candidateSelectFunctionAjax(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		int idx = Integer.parseInt(request.getParameter("idx"));

		List<String> list = new ArrayList<String>();
		
		list.add("일자");
		list.add("직원");
		list.add("기술");
		list.add("등급");
		list.add("거주지");
		
		switch(idx) {
		case 3 :
			String four = request.getParameter("four");
			if(list.indexOf(four) >= 0)	list.remove(list.indexOf(four));
		case 2 :
			String three = request.getParameter("three");
			if(list.indexOf(three) >= 0)	list.remove(list.indexOf(three));
		case 1 :
			String two= request.getParameter("two");
			if(list.indexOf(two) >= 0)	list.remove(list.indexOf(two));
		case 0 :
			String one = request.getParameter("one");
			if(list.indexOf(one) >= 0)	list.remove(list.indexOf(one));
		}
		
		list.add(0, "선택");

		mav.addObject("selectOptionList", list);
		mav.addObject("idx", idx);
		mav.setViewName("/candidateTest/candidateSelectOptionsPage");
		return mav;
	}
	
	@RequestMapping("/candidateSelectOptionDefaultFunctionAjax")
	public ModelAndView candidateSelectOptionDefaultFunctionAjax(String idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("idx", Integer.parseInt(idx));
		mav.setViewName("/candidateTest/candidateSelectOptionDefault");
		return mav;
	}
	
	@RequestMapping("/insertRequireOnCandidate")
	@ResponseBody
	public void insertRequireOnCandidate(String pj_id, String pr_sq, String pr_name) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("pj_id", pj_id);
		map.put("pr_sq", pr_sq);
		map.put("pr_name", pr_name);
		
		candidateService.insertRequireOnCandidate(map);
	}
	
}
