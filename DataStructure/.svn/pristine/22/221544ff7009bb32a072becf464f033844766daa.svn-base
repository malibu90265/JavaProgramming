package com.sqisoft.iqs.team.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class TeamController {

	private TeamService teamService;

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	@RequestMapping("/team/main")
	public String candidateSearch(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "team/team";
	}

	@RequestMapping("/team/getTeamListAjax")
	public ModelAndView getTeamListAjax(String tm_year) {
		ModelAndView view = new ModelAndView();
		List<TeamVO> teamList = this.teamService.getTeamListAjax(tm_year);
		TeamVO total = new TeamVO();
		int tm_num=0;
		int tm_contract = 0;
		int tm_sales = 0;
		int tm_profit = 0;
		int tm_outsrc_cost = 0;
		int tm_matl_cost = 0;
		
		for(TeamVO team : teamList){
			tm_num +=team.getTm_num();
			tm_contract += team.getTm_contract();
			tm_sales += team.getTm_sales();
			tm_profit += team.getTm_profit();
			tm_outsrc_cost += team.getTm_outsrc_cost();
			tm_matl_cost += team.getTm_matl_cost();
		}
		
		total.setTm_name("합계");
		total.setTm_num(tm_num);
		total.setTm_contract(tm_contract);
		total.setTm_sales(tm_sales);
		total.setTm_profit(tm_profit);
		total.setTm_outsrc_cost(tm_outsrc_cost);
		total.setTm_matl_cost(tm_matl_cost);
		teamList.add(total);
		
		view.addObject("teamList", teamList);
		view.setViewName("/team/teamListForm");
		return view;
	}

	
	@RequestMapping("/team/getTeamInsertFormAjax")
	public ModelAndView getTeamInsertFormAjax(){
		ModelAndView view = new ModelAndView();
		
		view.setViewName("team/teamInsertForm");
		return view;
	}
	
	@RequestMapping("/team/isTmNameAjax")
	@ResponseBody
	public Map<String, Boolean> isTmNameAjax(HttpServletRequest request) {
		String tm_year = request.getParameter("tm_year");
		String tm_id = request.getParameter("tm_id");
		String tm_name = request.getParameter("tm_name");
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		boolean isTmName = this.teamService.isTmName(tm_year, tm_id, tm_name);
		result.put("result", isTmName);
		
		return result;
	}

	@RequestMapping("/team/checkDuplicateAjax")
	@ResponseBody
	public Map<String, Object> checkDuplicate(TeamVO teamVO) {
		Map<String, Object> resultMap = this.teamService.checkDuplicate(teamVO);
		return resultMap;
	}
	
	@RequestMapping("/team/putNewTeamDetailAjax")
	public ModelAndView putNewTeamDetailAjax(TeamVO teamVO) {
		return this.teamService.putNewTeamDetail(teamVO);
	}
	
	@RequestMapping("/team/getTeamModifyFormAjax")
	public ModelAndView getTeamModifyFormAjax(HttpServletRequest request){
		
		String tm_year = request.getParameter("tm_year");
		String tm_id = request.getParameter("tm_id");
		
		TeamVO teamVO = this.teamService.getTeamInfo(tm_year, tm_id);
		
		ModelAndView view = new ModelAndView();

		view.addObject("team", teamVO);
		view.setViewName("/team/teamModifyForm");

		return view;
	}
	
	@RequestMapping("/team/modifyTeamInfoAjax")
	@ResponseBody
	public Map<String, String> modifyTeamInfoAjax(TeamVO teamVO) {
		
		this.teamService.modifyTeamInfo(teamVO);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("tm_year", teamVO.getTm_year());
		result.put("tm_id", teamVO.getTm_id());
		
		return result;
	}
	
	@RequestMapping("/team/deleteTeamInfoAjax")
	@ResponseBody
	public Map<String, String> deleteTeamInfoAjax(HttpServletRequest request) {
		
		String tm_year = request.getParameter("tm_year");
		String tm_id = request.getParameter("tm_id");
		
		this.teamService.deleteTeamInfo(tm_year, tm_id);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("tm_year", tm_year);
		
		return result;
	}	
}
