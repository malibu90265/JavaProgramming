package com.sqisoft.iqs.humanResource.empPjMap.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.humanResource.empPjMap.service.EmpPjMapService;
import com.sqisoft.iqs.humanResource.empPjMap.vo.EmpPjMapVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class EmpPjMapController {
	
	private EmpPjMapService empPjMapService;
	private TeamService teamService;
	
	public void setEmpPjMapService(EmpPjMapService empPjMapService) {
		this.empPjMapService = empPjMapService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	
	//전체
	@RequestMapping("/empPjMap/empPjMap")
	public ModelAndView empPjMap(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			mav.setViewName("common/loginErrorPage");
		}
		else {
			List<TeamVO> teamList = this.teamService.getTeamCheckList();
			mav.addObject("teamList", teamList);
			mav.setViewName("/empPjMap/empPjMap");
		}
		
		return mav;
	}
	
	//checkbox team list.
	@RequestMapping("/empPjMap/getEmpPjMapCheckBoxAjax")
	public ModelAndView getEmpPjMap(){
		ModelAndView view = new ModelAndView();
		List<TeamVO> teamList = this.teamService.getTeamCheckList();
		view.addObject("teamList",teamList);
		view.setViewName("/empPjMap/empPjMapCheckBox");
		return view;
	}
	
	//checkboxt선택 결과에 따른 list
	@RequestMapping("/empPjMap/getCheckBoxValueAjax")
	public ModelAndView getCheckBoxValueAjax(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		String team_id = request.getParameter("team_id");
		
		List<EmpPjMapVO> empList = this.empPjMapService.getEmpList(team_id);
		List<ProjectCountVO> projectCount = this.empPjMapService.getProjectCount(team_id);
		
		mav.addObject("empList", empList);
		mav.addObject("projectCount", projectCount);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	//list
	@RequestMapping("/empPjMap/getEmpPjMapListAjax")
	public ModelAndView getEmpPjMapListAjax(){
		ModelAndView view = new ModelAndView();
		
		return view;
	}
	
}
