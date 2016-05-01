package com.sqisoft.iqs.pf.team.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.pf.comm.CalcUtil;
import com.sqisoft.iqs.pf.project.service.ProjectServiceIF;
import com.sqisoft.iqs.pf.schedule.service.WeekendServiceIF;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.BizMileVO;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.DistribVO;
import com.sqisoft.iqs.pf.vo.TeamVO;
import com.sqisoft.iqs.pf.vo.TotalVO;
import com.sqisoft.iqs.pf.vo.WeekChartVO;

@Controller("teamController")
public class TeamController {

	private TeamServiceIF teamService;
	private ProjectServiceIF project_service;
	private WeekendServiceIF weekend_service;

	public void setTeamService(TeamServiceIF teamService) {
		this.teamService = teamService;
	}
	public void setProject_service(ProjectServiceIF project_service) {
		this.project_service = project_service;
	}
	public void setWeekend_service(WeekendServiceIF weekend_service) {
		this.weekend_service = weekend_service;
	}

	@RequestMapping("/teamList.iqspf")
	public ModelAndView getTeamList(){
		ModelAndView mav = new ModelAndView();
		List<TeamVO> list = teamService.getTeamList();

		mav.addObject("list", list);
		mav.setViewName("team_list");
		return mav;
	}

	@RequestMapping("distibView.iqspf")
	public ModelAndView distibView(){
		ModelAndView mav = new ModelAndView();
		DistribVO vo = teamService.getDistrib();
		
		mav.addObject("vo", vo);
		mav.setViewName("distrib_view");
		return mav;
	}

	@RequestMapping("distribUpdatePage.iqspf")
	public ModelAndView distribUpdatePage(){
		ModelAndView mav = new ModelAndView();
		DistribVO vo = teamService.getDistrib();
		
		mav.addObject("vo", vo);
		mav.setViewName("distrib_update");
		return mav;
	}

	@RequestMapping("projectBudgetinfo.iqspf")
	public ModelAndView projectBudgetinfo(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String team_id = req.getParameter("team_id");
		
//		 default value 설정 
		if (team_id == null)
			team_id = "1S";

		List<BudgetVO> list = teamService.getTeamBudgetInfoList(team_id);
		TeamVO team_vo = teamService.getTeam(team_id);

//		 2014.12.05 팀 공통 외주비 계산	
//		 순매출액/영업이익 합계에 차감	
//		 매출원가/총인건비/외주비 합계에 합산 	
		mav.addObject("team_comm", team_vo.getTeam_comm());
		mav.addObject("team_id", team_id);
		mav.addObject("list", list);
		mav.setViewName("projectbudgetinfo");
		return mav;
	}

	@RequestMapping("/totalChart.iqspf")
	public ModelAndView totalChart(){
		ModelAndView mav = new ModelAndView();
		TotalVO vo = teamService.getTotal();

		mav.addObject("vo", vo);
		mav.setViewName("totalchart");
		return mav;
	}

	@RequestMapping("compareChart.iqspf")
	public ModelAndView compareChart(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("comparechart");
		return mav;
	}

	@RequestMapping("viewBudgetCost.iqspf")
	public ModelAndView viewBudgetCost(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("budget_cost_update");
		String pj_id = req.getParameter("pj_id");
		BudgetVO vo = teamService.getBudgetCost(pj_id);
		
		mav.addObject("vo", vo);
		return mav;
	}
	
	@RequestMapping("updateBudgetCost.iqspf")
	public ModelAndView updateBudgetCost(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("budget_cost_update");
		String pj_id = req.getParameter("pj_id");
		String team_id = req.getParameter("team_id");
		int budget_product_cost = CalcUtil.getNumber(req.getParameter("budget_product_cost"));
		int pj_extra_cost = CalcUtil.getNumber(req.getParameter("pj_extra_cost"));
		
		BudgetVO vo = new BudgetVO();
		vo.setPj_id(pj_id);
		vo.setBudget_product_cost(budget_product_cost);
		vo.setPj_extra_cost(pj_extra_cost);
		vo.setTeam_id(team_id);

		weekend_service.updateBugetCost(vo);
		teamService.updateBudgetCost(vo);
		
		BudgetVO vo_ret = teamService.getBudgetCost(pj_id);
		List<BudgetVO> list = teamService.getTeamBudgetInfoList(vo_ret.getTeam_id());

		mav.addObject("team_id", vo.getTeam_id());
		mav.addObject("list", list);
		mav.setViewName("projectbudgetinfo");

		return mav;
	}

	@RequestMapping("bizmileSearch.action")
	public ModelAndView bizMileList(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		String team_id = req.getParameter("team_id");
		String pj_prog = req.getParameter("pj_prog");
		String biz_stat = req.getParameter("biz_stat");
		
		List<BizMileVO> list = project_service.bizmileSearch(new BizMileVO(pj_id, biz_stat, team_id, pj_prog));
		
		mav.addObject("list", list);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/bizMileView.iqspf")
	public ModelAndView bizMileView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bizmile_view");
		return mav;
	}

	@RequestMapping("/bizmileUpdate.action")
	public ModelAndView bizMileInsert(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		String cus_meet = req.getParameter("cus_meet");
		String needs_anal = req.getParameter("needs_anal");
		String cus_converse = req.getParameter("cus_converse");
		String present = req.getParameter("present");
		String propose = req.getParameter("propose");
		String contract = req.getParameter("contract");
		String perform = req.getParameter("perform");
		String afterservice = req.getParameter("afterservice");
		BizMileVO vo 
			= new BizMileVO(pj_id, cus_meet, needs_anal, cus_converse, present, propose, contract, perform, afterservice);
		project_service.bizMileUpdate(vo);

		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/getBizMile.action")
	public ModelAndView getBizMil(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		BizMileVO vo = project_service.getBizMile(pj_id);
		
		mav.addObject("vo", vo);
		mav.setViewName("JSON");
		return mav;
	}
	
	@RequestMapping("/Chart.do")
	public ModelAndView Chart(	HttpServletRequest req,
								@RequestParam(value="team_id", required=false, defaultValue="all") String team_id) {
		ModelAndView mav = new ModelAndView("chart");
		TeamVO team_vo = teamService.getTeamForChart(team_id);
		
		//2.week_chart List 가져오기
		List<WeekChartVO> list = teamService.getWeekChartList(team_id);
		
		mav.addObject("team_id", team_id);
		mav.addObject("vo", team_vo);
		mav.addObject("list", list);
		
		return mav;
	}
}
