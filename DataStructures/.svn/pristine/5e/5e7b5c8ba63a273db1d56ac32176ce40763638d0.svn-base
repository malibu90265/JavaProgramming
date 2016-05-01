package com.sqisoft.iqs.pf.coment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.pf.comm.CalcUtil;
import com.sqisoft.iqs.pf.customer.service.CustomerService;
import com.sqisoft.iqs.pf.member.service.MemberService;
import com.sqisoft.iqs.pf.project.service.ProjectServiceIF;
import com.sqisoft.iqs.pf.schedule.service.WeekendServiceIF;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.ProjectVO;
import com.sqisoft.iqs.pf.vo.TeamVO;

@Controller("comentController")
public class ComentController {

	private TeamServiceIF team_service;
	private MemberService memberService;
	private WeekendServiceIF weekend_service;
	private ProjectServiceIF project_service;
	private CustomerService customer_service;
	
	public void setTeam_service(TeamServiceIF team_service) {
		this.team_service = team_service;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public void setWeekend_service(WeekendServiceIF weekend_service) {
		this.weekend_service = weekend_service;
	}
	public void setProject_service(ProjectServiceIF project_service) {
		this.project_service = project_service;
	}
	public void setCustomer_service(CustomerService customer_service) {
		this.customer_service = customer_service;
	}

	@RequestMapping("nameExist")
	public ModelAndView nameExist(	HttpServletRequest req
									, @RequestParam(value="pj_pm", required=false, defaultValue="") String pj_pm)	{
		ModelAndView mav = new ModelAndView();
		int res=0;
		
	//	if(!pj_pm.equals("")){
			res=memberService.nameExist(pj_pm);
	//	}
		
		mav.addObject("res", res);
		mav.addObject("pj_pm",pj_pm);
		mav.setViewName("JSON");
		return mav;	
	}
	
	@RequestMapping("pjCheck")
	public ModelAndView pjCheck(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		
		int res=0;
		if(!pj_id.equals("")){
			res=project_service.pjCheck(pj_id);
		}
		
		mav.addObject("res", res);
		mav.addObject("pj_id",pj_id);
		mav.setViewName("JSON");
		
		return mav;	
	}
	
	@RequestMapping("nameSerch")
	public ModelAndView nameSerch(){
		ModelAndView mav = new ModelAndView();
		List<Employee_VO> list=memberService.nameSerch();
		
		mav.addObject("list",list);
		mav.setViewName("memberlist");
		
		return mav;	
	}
	
	@RequestMapping("projectSearch")
	public ModelAndView projectSearch(	@RequestParam("searchid") String searchid
										, @RequestParam("searchteam") String searchteam
										, @RequestParam("searchprog") String searchprog){
		ModelAndView mav = new ModelAndView();		
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		
		list = project_service.projectSearch(searchid, searchteam,searchprog);
		mav.addObject("list",list);
		mav.setViewName("JSON");

		return mav;
	}
	
	@RequestMapping("getProject")
	public ModelAndView getProject(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		ProjectVO vo = project_service.getProject(pj_id);
		
		mav.addObject("vo", vo);
		mav.setViewName("JSON");
		
		return mav;
	}

	@RequestMapping("projectUpdate")
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
		String pj_loc = req.getParameter("pj_loc");
		String pj_etc = req.getParameter("pj_etc");
		String pj_require = req.getParameter("pj_require");
		String pj_sqimm = req.getParameter("pj_sqimm");
		String pj_outmm = req.getParameter("pj_outmm");

		System.out.println("pj_require :"+pj_require);
		
		if(pj_loc==null || pj_loc=="")
			pj_loc=null;
		ProjectVO vo = new ProjectVO(team_id, pj_id, pj_name, customer_name,top_customer,
				pj_start_day, pj_end_day, pj_prog, pj_pm, "", pj_etc,
				pj_operate, budget_contract_sales, budget_product_cost,
				pj_sqimm, pj_outmm, pj_loc,budget_outsource,0,pj_require);
		
		ProjectVO budget=new ProjectVO(pj_id,team_id,pj_prog,pj_operate,budget_contract_sales,budget_product_cost,budget_outsource);

		if(project_service.pjCheck(pj_id)==1){
			weekend_service.updateProject(team_id,pj_id,budget_contract_sales,pj_operate,pj_prog,budget_product_cost);
			project_service.projectUpdate(vo);	
		}
		else{
			project_service.insertProject(vo);
			project_service.insertPbudget(vo);   //dao,service모두 budget아닌 vo로 받고있음 (budget 쓴 이유, 영향)
			project_service.insertPbiz_mile(pj_id);
			project_service.pjneeds_Insert(pj_id);
			weekend_service.insertProject(team_id,pj_id,budget_contract_sales,pj_operate,pj_prog,budget_product_cost);
		}
		mav.setViewName("JSON");
		return mav;
	}
	
	@RequestMapping("/projectDelete")
	public ModelAndView projectDelete(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");
		
		weekend_service.projectDelete(pj_id);
		project_service.projectDelete(pj_id);

		mav.setViewName("JSON");
		
		return mav;
	}

	@RequestMapping("bizlist.action")
	public ModelAndView projectList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String search = req.getParameter("search");
		List<ProjectVO> list = memberService.pjSearch(search);
		
		mav.addObject("list", list);
		mav.setViewName("JSON");
		return mav;
	}
	
	@RequestMapping("getTeam.action")
	public ModelAndView teamSearch(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String team_id = req.getParameter("team_id");
		TeamVO vo=team_service.getTeam(team_id);
		
		mav.addObject("vo", vo);
		mav.setViewName("JSON");
		return mav;
	}
	
	@RequestMapping("/teamUpdate.action")
	public ModelAndView teamUpdate(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String team_id = req.getParameter("team_id");
		String team_name = req.getParameter("team_name");
		int team_contract = CalcUtil.getNumber(req.getParameter("team_contract"));
		int team_income = CalcUtil.getNumber(req.getParameter("team_income"));
		int team_profit_loss =CalcUtil.getNumber( req.getParameter("team_profit_loss"));
		int team_outsource =CalcUtil.getNumber( req.getParameter("team_outsource"));
		int team_product = CalcUtil.getNumber(req.getParameter("team_product"));
		float team_mm =CalcUtil.getDecimal( req.getParameter("team_mm"));
		float team_perofcost = CalcUtil.getDecimal(req.getParameter("team_perofcost"));
		int team_mem = CalcUtil.getNumber(req.getParameter("team_mem"));
		int team_normal_cost = CalcUtil.getNumber(req.getParameter("team_normal_cost"));
				
		TeamVO vo
			= new TeamVO(	team_id, team_name, team_contract
							,team_income, team_profit_loss, team_outsource
							, team_product, team_perofcost, team_mm
							, team_mem, team_normal_cost);

		int ret = team_service.teamExist(team_id);

		if(ret==1)
			team_service.teamUpdate(vo);
		else
			team_service.teamInsert(vo);
		
		mav.addObject("ret", ret);
		mav.addObject("team_name", team_name);
		mav.setViewName("JSON");

		return mav;
	}
	
	@RequestMapping("/teamSearch.action")
	public ModelAndView getTeamList(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		List<TeamVO> list=team_service.getTeamList();
		
		mav.addObject("list", list);
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping("/teamDelete.action")
	public ModelAndView teamDelete(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		String team_id = req.getParameter("team_id");

		team_service.teamDelete(team_id);
		
		mav.setViewName("JSON");
		return mav;
	}

}
