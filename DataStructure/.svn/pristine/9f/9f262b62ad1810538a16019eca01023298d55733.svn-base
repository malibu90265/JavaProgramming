package com.sqisoft.iqs.pf.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.pf.comm.CalcUtil;
import com.sqisoft.iqs.pf.project.service.ProjectServiceIF;
import com.sqisoft.iqs.pf.schedule.service.WeekendServiceIF;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.CompareVO;
import com.sqisoft.iqs.pf.vo.ProjectVO;
import com.sqisoft.iqs.pf.vo.TeamVO;
import com.sqisoft.iqs.pf.vo.WeekendVO;

@Controller("projectController")
public class ProjectController {/* extends MultiActionController {*/

	private ProjectServiceIF project_service;
	private WeekendServiceIF weekend_service;
	private TeamServiceIF team_service;
	
	public void setProject_service(ProjectServiceIF project_service) {
		this.project_service = project_service;
	}
	public void setWeekend_service(WeekendServiceIF weekend_service) {
		this.weekend_service = weekend_service;
	}
	public void setTeam_service(TeamServiceIF team_service) {
		this.team_service = team_service;
	}

	@RequestMapping("/iqspMain.iqspf")
	public String viewMain(){
		return "iqspf_main";
	}
	
	@RequestMapping("/searchPopup.iqspf")
	public String searchPopup(){
		return "searchpopup";
	}
	
	@RequestMapping("/bizList.iqspf")
	public ModelAndView projectList(){
		ModelAndView mav = new ModelAndView();
		List<ProjectVO> project_list = project_service.getProjectList();

		mav.addObject("list", project_list);
		mav.setViewName("bizlist");
		return mav;
	}

	@RequestMapping("/getProject.iqspf")
	public ModelAndView getProject(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		
		List<TeamVO> list = team_service.getTeamList();
		ProjectVO vo = project_service.getProject(pj_id);
		
		mav.addObject("vo", vo);
		mav.addObject("list", list);
		mav.setViewName("projectupdate");
		return mav;
	}
	
	@RequestMapping("/projectUpdate.iqspf")
	public ModelAndView projectUpdate(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		String pj_name = req.getParameter("pj_name");
		String team_id = req.getParameter("team_id");
		String customer_name = req.getParameter("customer_name");
		String top_customer = req.getParameter("top_customer");
		String pj_start_day = req.getParameter("pj_start_day");
		String pj_end_day = req.getParameter("pj_end_day");
		String pj_prog = req.getParameter("pj_prog");
		String pj_pm = req.getParameter("pj_pm");
		int pj_operate = CalcUtil.getNumber(req.getParameter("pj_operate"));
		int budget_contract_sales = CalcUtil.getNumber(req.getParameter("budget_contract_sales"));
		int budget_product_cost = CalcUtil.getNumber(req.getParameter("budget_product_cost"));
		int budget_outsource=CalcUtil.getNumber(req.getParameter("budget_outsource"));
		int pj_extra_cost=CalcUtil.getNumber(req.getParameter("pj_extra_cost"));
		String pj_loc = req.getParameter("pj_loc");
		String pj_etc = req.getParameter("pj_etc");
		String pj_sqimm = req.getParameter("pj_sqimm");
		String pj_outmm = req.getParameter("pj_outmm");
		String pj_require=req.getParameter("pj_require");
		ProjectVO vo 
				= new ProjectVO(	team_id, pj_id, pj_name, customer_name,top_customer
									, pj_start_day, pj_end_day, pj_prog, pj_pm, "", pj_etc
									, pj_operate, budget_contract_sales, budget_product_cost
									, pj_sqimm, pj_outmm, pj_loc,budget_outsource,pj_extra_cost,pj_require);
		
		weekend_service.updateProject(team_id,pj_id,budget_contract_sales,pj_operate,pj_prog,budget_product_cost);
		project_service.projectUpdate(vo);
		List<ProjectVO> list = project_service.getProjectList();
		
		System.out.println("dskfsldfisdf" + vo);
	
		mav.addObject("list", list);
		mav.setViewName("bizlist");
		return mav;
	}
	
	@RequestMapping("/projectDelete.iqspf")
	public ModelAndView projectDelete(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		
		project_service.projectDelete(pj_id);
		List<ProjectVO> project_list = project_service.getProjectList();
		
		mav.addObject("list", project_list);
		mav.setViewName("bizlist");
		return mav;
	}

	@RequestMapping("/budgetList.iqspf")
	public ModelAndView budgetList(){
		ModelAndView mav = new ModelAndView();
		List<ProjectVO> list = project_service.getProjectList();

		mav.addObject("list", list);
		mav.setViewName("budgetlist");
		return mav;
	}
	
	// 추가한거...
	@RequestMapping("/insertProject")
	public ModelAndView insertProject(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("pj_id", request.getParameter("pj_id"));
		view.setViewName("insertproject2");
		return view;
	}
	
	// 페이지 경로
	@RequestMapping("/insertproject.iqspf")
	public ModelAndView input(	HttpServletRequest request
								, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		String pj_id=request.getParameter("pj_id");
//		
//		List<TeamVO> list = team_service.getTeamList();
//		ProjectVO vo = project_service.getProject(pj_id);
//		
//		mav.addObject("vo", vo);
//		mav.addObject("list", list);
		mav.addObject("pj_id", request.getParameter("pj_id"));
		mav.setViewName("insertproject");
		return mav;
	}

	@RequestMapping("/moneyList.iqspf")
	public ModelAndView moneyList(){
		ModelAndView mav = new ModelAndView();
		List<ProjectVO> list = project_service.getProjectList();
		
		mav.addObject("list", list);
		mav.setViewName("budget_view");
		return mav;
	}

	@RequestMapping("/getMoney.iqspf")
	public ModelAndView getMoney(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		ProjectVO vo = project_service.getMoney(pj_id);

		mav.addObject("vo", vo);
		mav.setViewName("budget_view");
		return mav;
	}

	@RequestMapping("/moneyUpdate.iqspf")
	public ModelAndView moneyInsert(
										@RequestParam("pj_id") String pj_id,
										@RequestParam("budget_contract_sales") String budget_contract_sales,
										@RequestParam("budget_sales") String budget_sales,
										@RequestParam("budget_product_cost") String budget_product_cost,
										@RequestParam("budget_outsource_cost") String budget_outsource_cost){
		ModelAndView mav = new ModelAndView();
		int contract_sales = Integer.parseInt(budget_contract_sales);
		int sales = Integer.parseInt(budget_sales);
		int product_cost = Integer.parseInt(budget_product_cost);
		int outsource_cost = Integer.parseInt(budget_outsource_cost);
		ProjectVO vo = new ProjectVO(pj_id, contract_sales, sales,
				product_cost, outsource_cost);

		project_service.moneyUpdate(vo);

		mav.setViewName("iqspf_main");
		return mav;
	}
	
	@RequestMapping("weekend.do")
	public ModelAndView weekend(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String wb_date = req.getParameter("wb_date");
		
		CompareVO vo = weekend_service.getWeekBudgetList(wb_date);
		List<String> date_list = weekend_service.getWeekBudgetDateList();
		
		if (wb_date == null) {
			wb_date = date_list.get(0);
		}
		
		List<WeekendVO> log_list = weekend_service.getLog(wb_date);
		
		mav.addObject("wb_date", wb_date);
		mav.addObject("date_list", date_list);
		mav.addObject("vo", vo);
		mav.addObject("list", log_list);
		mav.setViewName("weekend");
		return mav;
	}
	@RequestMapping("/projectTestEuj")
	public String projectTestEuj() {
		
		return "project/project";
	}
	
	@RequestMapping("/getProjectListAjax")
	public ModelAndView getProjectListAjax(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("project/projectListForm");
		
		return mav;
	}
	
	@RequestMapping("/getProjectDetailAjax")
	public ModelAndView getProjectDetailAjax(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("project/projectDetailForm");
		
		return mav;
	}
	
	@RequestMapping("/insertProjectAjax")
	@ResponseBody
	public void insertProjectAjax(HttpServletRequest req) {
		
		ProjectVO vo = new ProjectVO();
		
		project_service.insertProjectTest(vo);
		
	}
	
	@RequestMapping("/updateProjectAjax")
	@ResponseBody
	public void updateProjectAjax(HttpServletRequest req) {
		ProjectVO vo = new ProjectVO();
		
		project_service.insertProjectTest(vo);
	}
	
	@RequestMapping("/deleteProjectAjax")
	@ResponseBody
	public void deleteProjectAjax(HttpServletRequest req) {
		
		ProjectVO vo = new ProjectVO();
		
		project_service.deleteProjectTest(vo);
	}
	/*
	프로젝트 손익 관리 만드는 중 - cbm 
	
	@RequestMapping("/pjProfitAndLoss")
	public String getPjProfitAndLossPage() {
		return "project/pl/pjProfitAndLoss";
	}
	
	@RequestMapping("/getPjProfitAndLossSearchAjax")
	public ModelAndView getPjProfitAndLossSearchAjax() {
		ModelAndView view = new ModelAndView();
		
		List<com.sqisoft.iqs.pf.project.vo.TeamVO> teamList =  this.team_service.getAllTeamList();
		
		for(com.sqisoft.iqs.pf.project.vo.TeamVO teamVO : teamList) {
			System.out.println(teamVO.getTeamID());
		}
		view.addObject("teamList", teamList);
		view.setViewName("project/pl/pjProfitAndLossSearch");
		return view;
	}
	
	@RequestMapping("/getPjProfitAndLossListAjax")
	public ModelAndView getPjProfitAndLossListAjax(String teamId) {
		ModelAndView view = new ModelAndView();
		
		//List<> = this.project_service.getProfitAndLossList(teamId);
		
		view.setViewName("project/pl/pjProfitAndLossList");
		return view;
	}
	
	@RequestMapping("/getPjProfitAndLossInsertFormAjax")
	public ModelAndView getPjProfitAndLossInsertFormAjax() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("project/pl/pjProfitAndLossInsertForm");
		return view;
	}
	
	@RequestMapping("/getPjProfitAndLossModifyFormAjax")
	public ModelAndView getPjProfitAndLossModifyFormAjax() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("project/pl/pjProfitAndLossModifyForm");
		return view;
	}*/
	
}
