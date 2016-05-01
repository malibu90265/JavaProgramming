package com.sqisoft.iqs.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.project.service.PjBudgetService;
import com.sqisoft.iqs.project.service.ProjectService;
import com.sqisoft.iqs.project.vo.PjBudgetVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class PjBudgetController {

	private PjBudgetService pjBudgetService;
	private ProjectService projectService;
	private TeamService teamService;

	public void setPjBudgetService(PjBudgetService pjBudgetService) {
		this.pjBudgetService = pjBudgetService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	// 예산관리
	@RequestMapping("/project/budgetMain")
	public String pjBudgetMainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/project/budget/budget";
	}
	
	@RequestMapping("/project/getPjBudgetSearchPageAjax")
	public ModelAndView getPjBudgetSearchPageAjax(HttpServletRequest request) {
		//여기 3줄 selectbox 자기집 찾아가게 해줌.  
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String tm_id = loginVO.getTm_id();
		
		String tm_year = String.valueOf(CalendarUtil.getPresentYear());
		
		List<TeamVO> teamList = this.teamService.getTeamListAjax(tm_year);
		
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();
		Map<Integer, String> pjStatusMap = new HashMap<Integer, String>();
		for(ProjectStatusVO status : pjStatusList) {
			pjStatusMap.put(status.getPj_status_id(), status.getPj_status_name());
		}
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("teamList", teamList);
		view.addObject("pjStatusMap", pjStatusMap);
		view.addObject("tm_id", tm_id);
		view.setViewName("/project/budget/pjBudgetSearchForm");
		
		return view;
	}

	@RequestMapping("/project/getPjBudgetListBySearchConditionsAjax")
	public ModelAndView getBudgetListBySearchConditionsAjax(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();

		String tm_year = String.valueOf(CalendarUtil.getPresentYear());
		String tm_id = request.getParameter("tm_id");
		int pj_status = Integer.parseInt(request.getParameter("pj_status_id"));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tm_year", tm_year);
		params.put("tm_id", tm_id);
		params.put("pj_status", pj_status);
		params.put("firstParam", "B급");
		params.put("secondParam", "C급");
		params.put("thirdParam", "종결");
		
		List<PjBudgetVO> projectBudgetList = this.pjBudgetService.getProjectBudgetList(params);
		
		
		view.addObject("projectBudgetList", projectBudgetList);
		view.setViewName("/project/budget/pjBudgetListForm");
		return view;
	}

	@RequestMapping("/project/getSelectedBudgetListAjax")
	public ModelAndView getSelectedBudgetListAjax(String pj_id) {

		ModelAndView view = new ModelAndView();

		List<PjBudgetVO> budgetList = this.pjBudgetService.getSelectedBudgetList(pj_id);

		view.addObject("budgetList", budgetList);
		view.setViewName("/project/budget/pjBudgetSelectedListForm");
		return view;
	}

	@RequestMapping("/project/getBudgetInsertFormAjax")
	public String getBudgetInsertFormAjax() {
		return "/project/budget/pjBudgetInsertForm";
	}

	@RequestMapping("/project/calculateNewBudgetInfoAjax")
	public ModelAndView calculateNewBudgetInfoAjax(String tm_id, String pj_id, String pb_no, HttpServletRequest request) {
		java.text.NumberFormat nf = new java.text.DecimalFormat("000");
		java.text.NumberFormat nf2 = new java.text.DecimalFormat("00");
		ModelAndView view = new ModelAndView();

		SessionController.SessionReturnAccount(view, request);	// 권한설정
		
		// 각 사업팀의 프로젝트의 수
		int projectNum = this.projectService.getProjectNum(pj_id);
		TeamVO teamVO = this.teamService.getTeamInfo(String.valueOf(CalendarUtil.getPresentYear()), tm_id);

		
		PjBudgetVO budgetVO = this.pjBudgetService.getCalculatedBudgetResult(pj_id);
			
		if ((pb_no == null) || (pb_no.equals(""))){
			if (projectNum == 0) {
				pb_no = checkTeam_id(tm_id) + "-" + String.valueOf(CalendarUtil.getPresentYear()).substring(2, 4) + "-000-00";
				budgetVO.setPb_no(pb_no);
			}else{
				projectNum += 000;
				pb_no = checkTeam_id(tm_id) + "-" + String.valueOf(CalendarUtil.getPresentYear()).substring(2, 4) + "-" + nf.format(projectNum) + "-00";
				budgetVO.setPb_no(pb_no);
			}
		}	
		else {
				pb_no = pb_no.split("-")[0] + "-" + String.valueOf(CalendarUtil.getPresentYear()).substring(2, 4) + "-"
						+ pb_no.split("-")[2] + "-"
						+ nf2.format((Integer.parseInt(pb_no.split("-")[3]) + 1));
				budgetVO.setPb_no(pb_no);
		}
	
		view.addObject("pj_id", pj_id);
		view.addObject("teamVO", teamVO);
		view.addObject("budgetVO", budgetVO);
		view.setViewName("/project/budget/pjBudgetInsertForm");
		return view;
	}

	private String checkTeam_id(String tm_id) {
		tm_id = tm_id.substring(0, 2);
		if (tm_id.equals("1S")) {
			return "SI";
		} else if (tm_id.equals("2C")) {
			return "커머스";
		} else if (tm_id.equals("3E")) {
			return "에너지";
		} else if (tm_id.equals("4S")) {
			return "보안";
		} else {
			return "미디어";
		}
	}

	@RequestMapping("/project/insertProjectBudgetInfoAjax")
	@ResponseBody
	public Map<String, String> insertProjectBudgetInfoAjax(PjBudgetVO budgetVO) {
		Map<String, String> resultMap = new HashMap<String, String>();

		String message = "";
		if (this.pjBudgetService.checkDuplicateYN(budgetVO)) {
			// 중복이 있으면
			message = "프로젝트에 이미 해당 예산번호가 존재합니다.";
		} else {
			// 중복이 없으면
			message = this.pjBudgetService.insertProjectBudgetInfo(budgetVO);
			//this.pjBudgetService.changeProjectDBByBudget(budgetVO);
		}

		resultMap.put("message", message);
		resultMap.put("pj_id", budgetVO.getPj_id());
		resultMap.put("pb_no", budgetVO.getPb_no());
		return resultMap;
	}

	@RequestMapping("/project/modifyProjectBudgetInfoAjax")
	@ResponseBody
	public Map<String, String> modifyProjectBudgetInfoAjax(PjBudgetVO budgetVO) {
		Map<String, String> resultMap = new HashMap<String, String>();
		System.out.println("모디로 들어오너라!");
		String message = this.pjBudgetService.updateProjectBudgetInfo(budgetVO);

		resultMap.put("message", message);
		resultMap.put("pj_id", budgetVO.getPj_id());
		resultMap.put("pb_no", budgetVO.getPb_no());
		return resultMap;
	}

	@RequestMapping("/project/deleteBudgetInfoByPjIdAjax")
	@ResponseBody
	public Map<String, String> deleteBudgetInfoByPjIdAjax(String pj_id, String pb_no) {
		return this.pjBudgetService.deleteBudgetInfoByPjId(pj_id, pb_no);
	}

	// 프로젝트 예산 변경 내역
	@RequestMapping("/project/getBudgetHistoryList")
	public ModelAndView getBudgetHistoryList(String pj_id) {
		List<PjBudgetVO> pjBudgetList = this.pjBudgetService.getProjectHistoryInfo(pj_id);

		ModelAndView view = new ModelAndView();

		view.addObject("pj_id", pj_id);
		view.addObject("pjBudgetList", pjBudgetList);
		view.setViewName("/project/budget/pjBudgetHistoryList");
		return view;
	}

	// getBudgetInsertFormAjax에 넣어야함
	@RequestMapping("/project/getBudgetInsertFormAjaxtest")
	public ModelAndView getBudgetInsertFormAjaxtest(String pj_id, String pb_no, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();

		SessionController.SessionReturnAccount(view, request);	// 권한설정
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pj_id", pj_id);
		params.put("pb_no", pb_no);
			
		PjBudgetVO budgetVO = this.pjBudgetService.getProjectHistoryListtest(params);
		budgetVO.setPj_id(pj_id);

		view.addObject("pj_id", pj_id);
		view.addObject("budgetVO", budgetVO);
		view.setViewName("/project/budget/pjBudgetModifyForm");
		return view;

	}
}
