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
import com.sqisoft.iqs.project.service.PjProfitAndLossService;
import com.sqisoft.iqs.project.service.ProjectService;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class PjProfitAndLossController {
	
	private PjProfitAndLossService pjProfitAndLossService;
	private TeamService teamService;
	private ProjectService projectService;

	public void setPjProfitAndLossService(
			PjProfitAndLossService pjProfitAndLossService) {
		this.pjProfitAndLossService = pjProfitAndLossService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	// 손익관리
	@RequestMapping("/project/profitAndLossMain")
	public String profitAndLossMainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/project/profitAndLoss/profitAndLoss";
	}
	
	@RequestMapping("/project/getPjProfitAndLossSearchPageAjax")
	public ModelAndView getPjProfitAndLossSearchPageAjax() {
		
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
		view.setViewName("/project/profitAndLoss/pjProfitAndLossSearchForm");
		
		return view;
	}
	
	@RequestMapping("/project/getPjProfitAndLossListBySearchConditionsAjax")
	public ModelAndView getPjProfitAndLossListBySearchConditionsAjax(HttpServletRequest request) {
		
		String tm_year = String.valueOf(CalendarUtil.getPresentYear());

		String tm_id = request.getParameter("tm_id");
		int pj_status = Integer.parseInt(request.getParameter("pj_status_id"));
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tm_year", tm_year);
		params.put("tm_id", tm_id);
		params.put("pj_status", pj_status);
		
		List<ProjectVO> projectList = this.pjProfitAndLossService.getProjectListAndProfitLoss(params);
		
		ModelAndView view = new ModelAndView();
		view.addObject("projectList", projectList);
		view.setViewName("/project/profitAndLoss/pjProfitAndLossListForm");
		
		return view;
	}
	
	@RequestMapping("/project/getProfitAndLossModifyFormAjax")
	public ModelAndView getProfitAndLossModifyFormAjax(String pj_id, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturnAccount(view, request);	// 권한설정
		
		ProjectVO projectVO = this.pjProfitAndLossService.getProfitAndLossModifyForm(pj_id);
		view.addObject("projectVO", projectVO);

		
		TeamVO teamVO = this.teamService.getTeamInfo( String.valueOf(CalendarUtil.getPresentYear()), projectVO.getTm_id() );
		view.addObject("teamVO", teamVO);
		
		// 외주비
		double  douPj_outsrc_cost  = teamVO.getTm_out_mm_cost() * projectVO.getPj_out_mm();
		projectVO.setPj_outsrc_cost( Integer.parseInt(String.valueOf(Math.round(douPj_outsrc_cost))));
		
		view.setViewName("/project/profitAndLoss/pjProfitAndLossModifyForm");
		return view;
	}
	
	@RequestMapping("/project/modifyPjProfitAndLossInfoAjax")
	@ResponseBody
	public Map<String, String> modifyProfitAndLossInfoAjax(ProjectVO projectVO) {
		
		this.projectService.modifyProjectProfitAndLossInfo(projectVO);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", projectVO.getPj_id());
		params.put("tm_id", projectVO.getTm_id());
		
		return params;
	}
	

}
