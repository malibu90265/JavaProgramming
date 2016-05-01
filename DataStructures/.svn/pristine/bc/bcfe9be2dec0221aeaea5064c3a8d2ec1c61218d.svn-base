package com.sqisoft.iqs.humanResource.estimate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.humanResource.estimate.service.EstimateService;
import com.sqisoft.iqs.humanResource.estimate.vo.EstimationVO;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class EstimateController {
	
	// PM 평가 등록 / 조회 관련 패키지 입니다.
	
	private EstimateService estimateService;
	private HumanResourceService humanResourceService;
	
	public void setEstimateService(EstimateService estimateService) {
		this.estimateService = estimateService;
	}
	
	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}


	// PM 평가 등록
	@RequestMapping("/humanResource/estSignup")
	public String getEstSignupPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/estimate/estSignup/estSignup";
	}
	
	// PM 등록 검색 기본
	@RequestMapping("/humanResource/estSignupSearch")
	public ModelAndView getEstSignupSearch(HttpServletRequest request) {
		
		// 세션에서 이메일, 역할, 이름 받아옵니다.
		HttpSession session = request.getSession();
		LoginVO loginVO =  SessionUtil.get(session, Session.MEMBER);
		String hr_name = loginVO.getHr_name();
		String hr_role = loginVO.getHr_role();
		String hire_date = loginVO.getHr_hire_date();
		
		// 년도 옵션
		List<Integer> yearSearch = estimateService.getSearchYearOptions(hire_date);
		Map<String, String> pjIDOptions = new HashMap<String, String>();
		if(hr_role.equals("PM")) {
			// 프로젝트 옵션
			pjIDOptions = estimateService.getPjIDOptions(hr_name);
		}
		else {
			pjIDOptions.put("자료가 없습니다.", "자료가 없습니다.");
		}

		ModelAndView view = new ModelAndView();
		view.addObject("yearSearch", yearSearch);
		view.addObject("pjIDOptions", pjIDOptions);
		
		view.setViewName("/humanResource/estimate/estSignup/estSignupSearch");
		return view;
	}
	
	// PM평가 등록리스트
	@RequestMapping("/humanResource/estSignupUpdate")
	public ModelAndView getEstSignupUpdateForm(HttpServletRequest request) {
		
		String searchYear = request.getParameter("searchYear");
		String pj_id = request.getParameter("pj_id");
		
		// 세션에서 이름, 권한을 받아옵니다.
		HttpSession session = request.getSession();
		LoginVO loginVO =  SessionUtil.get(session, Session.MEMBER);
		String hr_name = loginVO.getHr_name();
		String hr_role = loginVO.getHr_role();
		
		List<EstimationVO> pmsEstimationList = null;
		if(hr_role.equals("PM")) {
			if(searchYear == null && pj_id == null) {
				pmsEstimationList = estimateService.getEstViewPage(hr_name);
			}
			else {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("hr_name", hr_name);
				param.put("searchYear", searchYear);
				param.put("pj_id", pj_id);
				pmsEstimationList = estimateService.getEstViewPageSearch(param);
			}
		}
		else {
			pmsEstimationList = null;
		}
		
		// 카운트
		int count= 0;
		for(int i=0; i<pmsEstimationList.size(); i++) {
			count++;
		}
		
		
		// 평가 셀렉트박스 옵션
		Map<String, String> pdAbcOptions = humanResourceService.getPdAbcOptions();
		
		ModelAndView view = new ModelAndView();
		view.addObject("count", count);
		view.addObject("pdAbcOptions", pdAbcOptions);
		view.addObject("pmsEstimationList", pmsEstimationList);
		view.setViewName("/humanResource/estimate/estSignup/estSignupList");
		
		return view;
	}
	
	// 평가 등록 업데이트
	@RequestMapping("/humanResource/estSigupUpdateAjax")
	@ResponseBody
	public ModelAndView doUpdateSignupdata(HttpServletRequest request) {
		
		// pd_name, pj_id, pd_abc, pd_soft_abc, pd_abc_desc
		String pd_name		= request.getParameter("pd_name");
		String pj_id		= request.getParameter("pj_id");
		String pd_abc		= request.getParameter("pd_abc");
		String pd_soft_abc	= request.getParameter("pd_soft_abc");
		String pd_abc_desc	= request.getParameter("pd_abc_desc");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pd_name"		,pd_name);
		param.put("pj_id"		,pj_id);
		param.put("pd_abc"		,pd_abc);
		param.put("pd_soft_abc"	,pd_soft_abc);
		param.put("pd_abc_desc"	,pd_abc_desc);
		
		estimateService.doUpdateSignupdata(param);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/humanResource/estSignupUpdate");
		return view;
	}
	
	
	// ------------------------------------
	// PM 평가 조회
	@RequestMapping("/humanResource/estView")
	public String getEstViewPageTitle(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/estimate/estView/estView";
	}
	
	// PM 조회/등록 검색 기본
	@RequestMapping("/humanResource/estViewSearch")
	public ModelAndView getEstViewSearch(HttpServletRequest request) {
		
		// 팀 옵션
		Map<String, String> teamOptions = humanResourceService.getTeamOptions();
		
		ModelAndView view = new ModelAndView();
		view.addObject("teamOptions", teamOptions);
		
		view.setViewName("/humanResource/estimate/estView/estViewSearch");
		return view;
	}
	
	// PM 조회 / 검색
	@RequestMapping("/humanResource/estViewList")
	public ModelAndView getEstViewPage(HttpServletRequest request) {

		String tm_id = request.getParameter("tm_id");
		String hr_name = request.getParameter("hr_name");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tm_id", tm_id);
		param.put("hr_name", hr_name);
		
		List<EstimationVO> pmsEstimationList = null;
		
		if(tm_id == null && hr_name == null) {
			pmsEstimationList = estimateService.getNonTeamEstViewPage(); // 팀 검색 디폴트 : 전체 보여주기
		}
		else if(tm_id != null || hr_name != null){
			pmsEstimationList = estimateService.getTeamEstViewPageSearch(param); // 팀 검색
		}
		
		ModelAndView view = new ModelAndView();
		view.addObject("pmsEstimationList", pmsEstimationList);
		view.setViewName("/humanResource/estimate/estView/estViewList");
		return view;
	}
}
