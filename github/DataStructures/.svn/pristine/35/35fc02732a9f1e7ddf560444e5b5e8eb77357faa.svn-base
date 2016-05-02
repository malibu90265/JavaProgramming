package com.sqisoft.iqs.humanResource.costmap.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.humanResource.costmap.service.CostMapService;
import com.sqisoft.iqs.humanResource.costmap.vo.CostMapVO;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.project.service.ProjectService;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class CostMapController {

	private CostMapService costMapService;
	private HumanResourceService humanResourceService;
	private TeamService teamService;
	private ProjectService projectService;

	public void setCostMapService(CostMapService costMapService) {
		this.costMapService = costMapService;
	}

	public void setHumanResourceService(
			HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	// 통합
	@RequestMapping("/humanResource/costmap")
	public String costmapTotal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/costmap/costmap";
	}

	// 리스트
	@RequestMapping("/humanResource/costmapList")
	public ModelAndView getCostmapList(HttpServletRequest request) throws ParseException {
		
		String tm_id = request.getParameter("tm_id");
		
		ModelAndView view = new ModelAndView();

		if(!tm_id.equals(0)) {
			List<CostMapVO> costmapList = costMapService.getCostmapList(tm_id);
			view.addObject("costmapList", costmapList);
		}
		view.setViewName("/humanResource/costmap/costmapList");

		return view;
	}

	// 서치
	@RequestMapping("/humanResource/costmapSearch")
	public ModelAndView getCostmapSearch() {
		ModelAndView view = new ModelAndView();
		
		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList = this.teamService.getTeamListAjax(year);
		
		view.addObject("teamList", teamList);
		view.setViewName("/humanResource/costmap/costmapSearch");

		return view;
	}

	@RequestMapping("/mmupdate")
	@ResponseBody
	public void mmupdate() {
		this.costMapService.mmupdate();
	}
}
