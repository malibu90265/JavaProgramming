package com.sqisoft.iqs.project.controller;

import java.util.Calendar;
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
import com.sqisoft.iqs.project.service.ProjectService;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;
@Controller
public class ProjectController {

	private ProjectService projectService;

	private TeamService teamService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	// 영업관리
	@RequestMapping("/project/main")
	public String projectMainPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		
		return "project/project";
	}
	
	@RequestMapping("/project/getProjectSearchPageAjax")
	public ModelAndView getProjectSearchPageAjax() {
		
		Calendar now = Calendar.getInstance();
		String tm_year = String.valueOf(now.get(Calendar.YEAR));
		
		List<TeamVO> teamList = this.teamService.getTeamListAjax(tm_year);
		
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();
		Map<Integer, String> pjStatusMap = new HashMap<Integer, String>();
		for(ProjectStatusVO status : pjStatusList) {
			pjStatusMap.put(status.getPj_status_id(), status.getPj_status_name());
		}
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("teamList", teamList);
		view.addObject("pjStatusMap", pjStatusMap);
		view.setViewName("/project/projectSearchForm");
		
		return view;
	}
	
	@RequestMapping("/project/checkDuplicateAjax")
	@ResponseBody
	public Map<String, Object> checkDuplicate(String pjId){
		Map<String, Object> resultMap = this.projectService.checkDuplicate(pjId);
		return resultMap;
	}

	@RequestMapping("/project/putNewProjectDetailAjax")
	public ModelAndView putNewProjectDetailAjax(ProjectVO projectVO) {
		
		//제안일 계약일 비필수값 처리
		String proposeD = projectVO.getPj_propose_date();
		String contractD = projectVO.getPj_contract_date();
		
		if(proposeD == ""){ proposeD = null;}
		if(contractD == ""){ contractD = null;}
		
		projectVO.setPj_propose_date(proposeD);
		projectVO.setPj_contract_date(contractD);
		
		return this.projectService.putNewProjectDetail(projectVO);
	}
	
	@RequestMapping("/project/getProjectListBySearchConditionsAjax")
	public ModelAndView getProjectListBySearchConditionsAjax(HttpServletRequest request) {
		
		Calendar now = Calendar.getInstance();
		String tm_year = String.valueOf(now.get(Calendar.YEAR));
		
		String tm_id = request.getParameter("tm_id");
		int pj_status = Integer.parseInt(request.getParameter("pj_status_id"));
		String pj_modify = request.getParameter("pj_modify_id");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tm_year", tm_year);
		params.put("tm_id", tm_id);
		params.put("pj_status", pj_status);
		params.put("pj_modify", pj_modify);
		
		List<ProjectVO> projectList = this.projectService.getProjectList(params);
		
		for(ProjectVO projectlist : projectList){
			if((!projectlist.getPj_start_date().split("-")[0].equals(tm_year)) && (projectlist.getPj_end_date().split("-")[0].equals(tm_year))){
				projectlist.setPj_amount(0);
			}
		}
		
		List<ProjectStageVO> projectStageList = this.projectService.getProjectStageList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("projectList", projectList);
		view.addObject("projectStageList", projectStageList);
		view.setViewName("/project/projectListForm");
		
		return view;
	}

	// 저장
	@RequestMapping("/project/projectInsert")
	public ModelAndView projectInsertForm(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		SessionController.SessionReturn(view, request);	// 권한설정
		
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();
		List<ProjectStageVO> pjStageList = this.projectService.getProjectStageList();
		
		view.addObject("pjStatusList", pjStatusList);
		view.addObject("pjStageList",pjStageList);
		view.setViewName("/project/projectInsertForm");
		return view;			
	}
	
	// 수정
	@RequestMapping("/project/getProjectModifyFormAjax")
	public ModelAndView getProjectModifyFormAjax(String pj_id, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturn(view, request);	// 권한설정
		
		ProjectVO projectVO = this.projectService.getProjectInfo(pj_id);		// 프로젝트 정보
		List<ProjectStageVO> pjStageList = this.projectService.getProjectStageList();	// 상태
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();	// 영업단계
		
		view.addObject("projectVO", projectVO);
		view.addObject("pjStageList", pjStageList);
		view.addObject("pjStatusList", pjStatusList);
		
		view.setViewName("project/projectModifyForm");
		return view;
	}
	
	// 수정
	@RequestMapping("/project/modifyProjectInfoAjax")
	@ResponseBody
	public Map<String, String> modifyProjectInfoAjax(ProjectVO projectVO) {
		
		this.projectService.modifyProjectInfo(projectVO);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", projectVO.getPj_id());
		params.put("tm_id", projectVO.getTm_id());
		
		return params;
	}
	
	// 삭제
	@RequestMapping("/project/deleteProjectInfoAjax")
	@ResponseBody
	public Map<String, String> deleteProjectInfoAjax(HttpServletRequest request) {
		
		String pj_id = request.getParameter("pj_id");
		String tm_id = request.getParameter("tm_id");
		this.projectService.deleteProjectInfo(pj_id);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("tm_id", tm_id);
		return params;
	}
	
	@RequestMapping("/project/setPjYearSalesAjax")
	@ResponseBody
	public Map<String, String> setPjYearSalesAjax(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();

		Map<String, String> temp = new HashMap<String, String>();
		temp.put("pj_amount", request.getParameter("pj_amount"));
		temp.put("pj_start_date", request.getParameter("pj_start_date"));
		temp.put("pj_end_date", request.getParameter("pj_end_date"));
		
		int result = this.projectService.setPjYearSalesAjax(temp);
		
		params.put("result", String.valueOf( this.projectService.setPjYearSalesAjax(temp) ));
		return params;
	}
}
