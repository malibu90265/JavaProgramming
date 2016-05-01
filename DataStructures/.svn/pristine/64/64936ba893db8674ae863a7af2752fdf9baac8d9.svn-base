package com.sqisoft.iqs.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.project.service.PjProgressService;
import com.sqisoft.iqs.project.service.ProjectService;
import com.sqisoft.iqs.project.vo.PjProgressSearchVO;
import com.sqisoft.iqs.project.vo.PjProgressVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class PjProgressController {

	private PjProgressService pjProgressService;
	private ProjectService projectService;
	private TeamService teamService;

	public void setPjProgressService(PjProgressService pjProgressService) {
		this.pjProgressService = pjProgressService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	// 주간보고
	@RequestMapping("/project/pjProgressMain")
	public String pjProgressMainPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		
		return "/project/progress/progress";
	}

	// 
	@RequestMapping("/project/getPjProgressSearchPageAjax")
	public ModelAndView getPjProgressSearchPageAjax() {
		
		// 팀
		String year = String.valueOf(CalendarUtil.getPresentYear());
		List<TeamVO> teamList = this.teamService.getTeamListAjax(year);
		
		// 추진상태
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();

		// 년 월 주
		List<String> weekList = CalendarUtil.getWeekListDuringPastVarMonth(7);
		String presentWeek = CalendarUtil.getPresentWeek();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("teamList", teamList);
		view.addObject("pjStatusList", pjStatusList);
		view.addObject("weekList", weekList);
		view.addObject("presentWeek", presentWeek);
		
		view.setViewName("/project/progress/progressSearchForm");

		return view;
	}
	
	//
	@RequestMapping("/project/getProjectListByPjProgressSearchConditionsPageAjax")
	public ModelAndView getProjectListByPjProgressSearchConditionsPageAjax(PjProgressSearchVO pjProgressSearchVO) {
		
		pjProgressSearchVO.setTm_year(pjProgressSearchVO.getPp_date().split("-")[0]);
		
		List<PjProgressVO> projectList = this.pjProgressService.getProjectListByPjProgressSearchConditions(pjProgressSearchVO);
		
		// 추진상태
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("projectList", projectList);
		view.addObject("pjStatusList", pjStatusList);
		view.setViewName("/project/progress/progressListForm");
		
		return view;
	}
	
	//
	@RequestMapping("/project/getPjProgressList")
	public ModelAndView getPjProgressList(PjProgressSearchVO pjProgressSearchVO) {
		
		String tm_id = pjProgressSearchVO.getTm_id();
		String pp_date = pjProgressSearchVO.getPp_date();
		String[] pp = pp_date.split("\\(");
		String lastWeek = CalendarUtil.getLastWeek(pp[0]);
		List<PjProgressVO> pjProgressList = this.pjProgressService.getPjProgressList(tm_id, pp[0]);
		for(PjProgressVO pjProgressVO : pjProgressList) {
			
			String pj_id = pjProgressVO.getPj_id();
			String pp_done_plan = this.getLastWeekPlan(pj_id, lastWeek);
			
			pjProgressVO.setPp_done_plan(pp_done_plan);
		}
		
		TeamVO team = this.teamService.getTeamInfo(pp[0].split("-")[0], tm_id);
		String teamName = team.getTm_name();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("teamName", teamName);
		view.addObject("pjProgressList", pjProgressList);
		view.addObject("pp_date", pp[0]);
		
		view.setViewName("/project/progress/progressListByYMWForm");
		
		return view;
	}
	
	@RequestMapping("/project/getPjProgressInputFormPageAjax")
	public ModelAndView getPjProgressModifyFormPageAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		SessionController.SessionReturn(view, request);	// 권한설정
		
		String pj_id = request.getParameter("pj_id");
		if(pj_id == null) pj_id = "";
		String tm_id = request.getParameter("tm_id");
		if(tm_id == null) tm_id = "";
		String pp_date = request.getParameter("pp_date");
		String[] pp = pp_date.split("\\(");
		//System.out.println(pp[0]);
		String lastWeek = CalendarUtil.getLastWeek(pp[0]);
		
		// 선택한 년월주의 전주에 계획을 작성했는지 안했는지 체크
		String pp_done_plan = this.getLastWeekPlan(pj_id, lastWeek);
		
		// 선택한 년월주의 계획을 작성했는지 안했는지 체크
		boolean selectedWeekResult = this.pjProgressService.existWeekProgress(pj_id, pp[0]);
		PjProgressVO pjProgress = null;
		if(selectedWeekResult) {
			pjProgress = this.pjProgressService.getPjProgressByConditions(pj_id, tm_id, pp[0]);
			System.out.println(pjProgress.getPp_done() + "모디 예정");
			pjProgress.setPp_done_plan(pp_done_plan);
			
			view.setViewName("/project/progress/progressModifyForm");
		} else {
			System.out.println("pj_id : " + pj_id);
			ProjectVO project = this.projectService.getProjectInfo(pj_id);
			
			pjProgress = new PjProgressVO();
			pjProgress.setPj_id(project.getPj_id());
			pjProgress.setPj_name(project.getPj_name());
			pjProgress.setPp_date(pp[0]);
			pjProgress.setPp_done_plan(pp_done_plan);
			if(pj_id != "" && tm_id.contains("4S")){
				pjProgress.setPp_done("<p class='MsoNormal' align='left'><span lang='EN-US' style='font-size:12.0pt;mso-ascii-font-family:'Nanum Gothic';mso-ascii-theme-font:='' major-fareast;mso-fareast-font-family:'Nanum Gothic';mso-fareast-theme-font:major-fareast;='' mso-hansi-font-family:'Nanum Gothic';mso-hansi-theme-font:major-fareast;mso-bidi-font-family:='Nanum Gothic';mso-font-kerning:0pt'=''>◆ "+  project.getPj_name() +  " : " + project.getPj_status_name() + " / </p>");
				//pjProgress.setPp_done("<p class='MsoNormal' align='left'><span style='font-family: 'Nanum Gothic'; font-size: 12.0pt; line-height: normal; white-space: nowrap; background-color: rgb(255, 255, 255);'>◆ </span><span style='font-family: 'Nanum Gothic'; font-size: 12.0pt; line-height: normal; white-space: nowrap; background-color: rgb(255, 255, 255);'>" + project.getPj_name() +  "</span> : " + project.getPj_status_name() + " / </span></p>");
			}
			
			System.out.println(pjProgress.getPp_done());
			
			view.setViewName("/project/progress/progressInsertForm");
		}
		
		view.addObject("pjProgress", pjProgress);
		
		return view;
	}
	
	private String getLastWeekPlan(String pj_id, String lastWeek) {
		boolean lastWeekResult = this.pjProgressService.existWeekProgress(pj_id, lastWeek);
		String pp_done_plan;
		if(lastWeekResult) {
			pp_done_plan = this.pjProgressService.getPjProgressDonePlan(pj_id, lastWeek);
		} else {
			pp_done_plan = "전주에 작성된 주간보고서가 없습니다.";
		}
		
		return pp_done_plan;
	}
	
	@RequestMapping("/project/insertPjProgressAjax")
	@ResponseBody
	public void insertPjProgressAjax(PjProgressVO pjProgressVO) {
		this.pjProgressService.insertPjProgress(pjProgressVO);
	}
	
	@RequestMapping("/project/modifyPjProgressAjax")
	@ResponseBody
	public void modifyPjProgressAjax(PjProgressVO pjProgressVO) {
		this.pjProgressService.modifyPjProgress(pjProgressVO);
	}
	
	@RequestMapping("/project/deletePjProgresAjax")
	@ResponseBody
	public void deletePjProgresAjax(HttpServletRequest request) {
		String pj_id = request.getParameter("pj_id");
		String pp_date = request.getParameter("pp_date");
		
		this.pjProgressService.deletePjProgres(pj_id, pp_date);
	}
	
	
}
