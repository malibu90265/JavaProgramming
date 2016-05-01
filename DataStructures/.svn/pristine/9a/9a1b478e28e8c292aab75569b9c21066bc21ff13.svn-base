package com.sqisoft.iqs.team.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.service.TotalService;
import com.sqisoft.iqs.team.vo.GageGoalVO;
import com.sqisoft.iqs.team.vo.GageRealVO;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.team.vo.TotalProjectByTeamVO;
import com.sqisoft.iqs.team.vo.TotalTeamVO;
import com.sqisoft.iqs.team.vo.WeekChartByWeekVO;
import com.sqisoft.iqs.team.vo.WeekChartTotalVO;
import com.sqisoft.iqs.team.vo.WeekChartVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class TotalController {
	
	private TotalService totalService;
	private TeamService teamService;

	public void setTotalService(TotalService totalService) {
		this.totalService = totalService;
	}
	
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	

	//총괄표
	@RequestMapping("/totalChart")
	private ModelAndView getTotalChart() {
		ModelAndView view = new ModelAndView();
		
		Map<String, TotalTeamVO> totalTeamList = this.totalService.getTotalChart();
		
		view.addObject("totalList", totalTeamList);
		view.setViewName("total/totalchart");
		
		return view;
	}
	
	//게이지
	@RequestMapping("/gage")
	private ModelAndView getGage(){
		ModelAndView view = new ModelAndView();

		//실제 계약, 매출, 순매출 이익구하기
		GageGoalVO gageGoalVO = this.totalService.getGageGoal();
		//목표 계약, 매출, 순매출 이익구하기
		GageRealVO gageRealVO = this.totalService.getGageReal();
		
		view.addObject("gageGoalVO", gageGoalVO);
		view.addObject("gageRealVO", gageRealVO);
		
		view.setViewName("admin/main/gage");
		return view;
	}
	
	@RequestMapping("/weekend")
	private String getWeekend(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "total/weekend/weekend";
	}
	
	//전주대비표 search
	@RequestMapping("/total/getWeekendSearchPageAjax")
	private ModelAndView getWeekendSearchPageAjax(){
		ModelAndView view = new ModelAndView();
		
		List<String> weekList = this.totalService.getWeekList();
		view.addObject("weekList",weekList);
		view.setViewName("total/weekend/weekend_Search");
		
		return view;
	}
	
	@RequestMapping("/insertWeekReport")
	private void insertWeekReport() {
		this.totalService.insertWeekReport();
	}
	
	
	@RequestMapping("/getWeekReport")
	private ModelAndView getWeekReport(HttpServletRequest request) {
		
		ModelAndView view =  new ModelAndView();
		
		String selectedWeek = request.getParameter("weekend");
		if(selectedWeek.length() == 0) {
			Calendar calendar = Calendar.getInstance();
			int thisYear = calendar.get(Calendar.YEAR);
			int thisMonth = calendar.get(Calendar.MONTH);
			int thisWeek = calendar.get(Calendar.WEEK_OF_MONTH);
			selectedWeek = thisYear + "-" + thisMonth + "-" + thisWeek;
		}
		String lastWeek = CalendarUtil.getLastWeek(selectedWeek);
		Map<String, Object> resultMap = this.totalService.getWeekReport(selectedWeek, lastWeek);
		
		view.addObject("weekLogReportVO", resultMap.get("weekLogReportVO"));
		view.addObject("totalWeekReportList", resultMap.get("totalWeekReportList"));
		view.addObject("presentWeek", selectedWeek);
		view.addObject("lastWeek", lastWeek);
		view.setViewName("total/weekend/weekend_List");
		
		return view;
	}
	
	// 추세 분석
	@RequestMapping("/total/weekChart")
	private String weekChart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "total/weekend/week_chart";
	}
	
	@RequestMapping("/total/getWeekChartSearchPageAjax")
	private ModelAndView getWeekChartSearchPageAjax(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String tm_id = loginVO.getTm_id();
		
		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList=  this.teamService.getTeamListAjax(year);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("teamList", teamList);
		view.addObject("tm_id", tm_id);
		view.setViewName("total/weekend/week_chart_search");
		
		return view;
	}
	
	@RequestMapping("/total/getWeekChart")
	private ModelAndView getWeekChart(HttpServletRequest request) {
		String tm_id = request.getParameter("tm_id");
		
		//선택한 팀의 계약목표, 매출 목표, 이익 목표 값을 가져옴
		WeekChartVO weekChart = this.totalService.getWeekChart(tm_id);
		
		//올 해의 주 List를 가져옴
		List<String> weekList = CalendarUtil.getTotalWeekByYear(CalendarUtil.getPresentYear());
		
		String currentWeek = CalendarUtil.getPresentWeek();
		
		Map<String, Integer> weekChartIndexList = new LinkedHashMap<String, Integer>();
		int chartIndex = -1;
		List<WeekChartTotalVO> tempList = weekChart.getTotalList();
		for(String week : weekList) {
			chartIndex = -1;
			for(int i = 0; i < tempList.size(); i++) {
				if(tempList.get(i).getWr_date() != null && tempList.get(i).getWr_date().contains(week)){
						chartIndex = i;
						weekChartIndexList.put(week, chartIndex);
						break;
				}else{
					weekChartIndexList.put(week, chartIndex);
				}
			}
		}
		
		Map<String, WeekChartByWeekVO> weekChartList = new LinkedHashMap<String, WeekChartByWeekVO>();
		WeekChartByWeekVO weekChartByWeekVO = null;
		WeekChartTotalVO total = null;
		int index = 0;
		for(String week : weekList) {
			weekChartByWeekVO = new WeekChartByWeekVO();
			weekChartByWeekVO.setGoalContract(Math.round(weekChart.getGoalContract()/1000));
			weekChartByWeekVO.setGoalYearSales(Math.round(weekChart.getGoalYearSales()/1000));
			weekChartByWeekVO.setGoalNetSales(Math.round(weekChart.getGoalNetSales()/1000));
			weekChartByWeekVO.setGoalSalesProfit(Math.round(weekChart.getGoalSalesProfit()/1000));
			
			index = weekChartIndexList.get(week);
			if(index != -1) {
				
				total = tempList.get(index);
			/*	System.out.println("***********************");
				System.out.println(total.getWr_date());
				System.out.println(total.getContract());
				System.out.println(total.getYearSales());
				System.out.println(total.getNetSales());
				System.out.println(total.getProfit());*/
				weekChartByWeekVO.setContract(Math.round(total.getContract()/1000));
				weekChartByWeekVO.setYearSales(Math.round(total.getYearSales()/1000));
				weekChartByWeekVO.setNetSales(Math.round(total.getNetSales()/1000));
				weekChartByWeekVO.setProfit(Math.round(total.getProfit()/1000));
			}
			weekChartList.put(week, weekChartByWeekVO);
		}
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("weekList", weekList);
		view.addObject("weekChartList", weekChartList);
		view.addObject("tm_id", tm_id);
		view.setViewName("total/weekend/week_chart_list");
		
		return view;
	}
	
	
	
	/*팀별손익정보*/
	Map<String, Object> resultMap = new HashMap<String, Object>();
	TotalProjectByTeamVO project;
	TotalProjectByTeamVO totalChecked;
	
	@RequestMapping("/projectBudgetInfo")
	private String projectBudgetInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "total/projectBudgetInfo/projectBudgetInfo";
	}
	
	// 손익관리 search
	@RequestMapping("/total/getProjectBudgetInfoSearchFormAjax")
	private ModelAndView getProjectBudgetInfoSearchFormAjax() {
		ModelAndView view = new ModelAndView();
		resultMap = null;
		project = null;
		totalChecked = null;
		
		List<TeamVO> teamList = this.teamService.getTeamListAjax(CalendarUtil.getPresentYear());
		view.addObject("teamList", teamList);
		view.setViewName("total/projectBudgetInfo/projectBudgetInfoSearch");
		return view;
	}
	
	//손익관리 리스트
	@RequestMapping("/total/getProjectBudgetInfoListFormAjax")
	private ModelAndView getProjectBudgetInfoListFormAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		resultMap = null;
		project = null;
		totalChecked = null;
		
		String tm_id = request.getParameter("tm_id");
		
		if(tm_id == null) {
			List<TeamVO> teamList = this.teamService.getTeamListAjax(CalendarUtil.getPresentYear());
			tm_id = teamList.get(0).getTm_id();
		}

		resultMap = this.totalService.getProjectBudgetInfo(tm_id);
		
		view.addObject("totalSumList", resultMap.get("totalSumList"));
		view.addObject("totalChecked", totalChecked);
		view.addObject("resultList", resultMap.get("resultList"));
		view.setViewName("total/projectBudgetInfo/projectBudgetInfoList");
		return view;
	}
	
	
	
	//손익관리 디테일 폼
	@RequestMapping("/total/getProjectBudgetInfoDetailFormAjax")
	@ResponseBody
	private ModelAndView getProjectBudgetInfoDetailFormAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		String pj_id = request.getParameter("pj_id");
		project = totalService.getProjectBudgetInfoByProject(pj_id);
		
		view.addObject("totalSumList", resultMap.get("totalSumList"));
		view.addObject("project", project);
		view.addObject("totalChecked", totalChecked);
		view.addObject("resultList", resultMap.get("resultList"));
		view.setViewName("total/projectBudgetInfo/projectBudgetInfoList");
		return view;
		
	}
	
	//checkbox 선택 결과에 따른 손익 합계
	@RequestMapping("/total/getCheckBoxValueAjax")
	@ResponseBody
	public ModelAndView getCheckBoxValueAjax(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		
		String status = request.getParameter("status");
		totalChecked = new TotalProjectByTeamVO();
		
		
		Map<String, TotalProjectByTeamVO> result = new HashMap<String, TotalProjectByTeamVO>();
		
		/* 프로젝트 상태 별 TotalProjectByTeamVO */
		// 계약액
		double status_totalContract = 0d;
		// 매출액
		double status_totalYearSales = 0d;
		// 상품비
		double status_totalMatlCost = 0d;
		// 영업이익
		double status_totalProfitSales = 0d;
		// 외주비
		double status_totalOutCost = 0d;
		// 순매출액
		double status_totalNetSales = 0d;
		// (매출원가)합계
		double status_totalSalesCost = 0d;
		// (인건비)계
		double status_totalLaborCost = 0d;
		// pj직접
		double status_totalDirectCost = 0d;
		// 직원/외주 mm
		double status_totalLaborMM = 0d;
		double status_totalOutMM = 0d;
		// 공통,대기
		double status_commonAndWaitCost = 0d;
		// 영업
		double status_totalSales = 0d;
		// 지원
		double status_totalSupport = 0d;
		// 경비
		double status_totalCost = 0d;
		
		
		for(int i=0; i<status.length(); i++){
			char c = status.charAt(i);
			int s = Character.getNumericValue(c);
				TotalProjectByTeamVO statusList = totalService.getProjectListbyChecked(s);
				status_totalContract += statusList.getTotalContract();
				status_totalYearSales += statusList.getYearSales();
				status_totalNetSales += statusList.getNetSales();
				status_totalProfitSales += statusList.getProfitSales();
				status_totalSalesCost += statusList.getTotalSalesCost();
				status_totalLaborCost += statusList.getTotalLaborCost();
				status_totalDirectCost += statusList.getTotalDirectCost();
				if(status_commonAndWaitCost != statusList.getCommonAndWaitCost())
					status_commonAndWaitCost += statusList.getCommonAndWaitCost();
				if(c==4)
					status_commonAndWaitCost = 0;
				if(status_totalSales != statusList.getTotalSales())
					status_totalSales += statusList.getTotalSales();
				status_totalSupport += statusList.getTotalSupport();
				status_totalOutCost += statusList.getTotalOutCost();
				status_totalMatlCost += statusList.getTotalMatlCost();
				status_totalCost += statusList.getTotalCost();
				
				status_totalLaborMM += statusList.getTotalLaborMM();
				status_totalOutMM += statusList.getTotalOutMM();
		}
		/*System.out.println("-------------------");
		System.out.println(status_totalContract);
		System.out.println(status_totalYearSales);
		System.out.println(status_totalMatlCost);
		System.out.println(status_totalProfitSales);
		System.out.println(status_totalOutCost);
		System.out.println(status_totalNetSales);
		System.out.println(status_totalSalesCost);
	*/
		totalChecked.setTotalContract(status_totalContract);//계약액
		totalChecked.setYearSales(status_totalYearSales);//매출액
		totalChecked.setNetSales(status_totalNetSales);//순매출액
		totalChecked.setProfitSales(status_totalProfitSales);//영업이익
		totalChecked.setTotalSalesCost(status_totalSalesCost);//매출원가
		totalChecked.setTotalLaborCost(status_totalLaborCost);//인건비합계
		totalChecked.setTotalDirectCost(status_totalDirectCost);//직접비
		totalChecked.setCommonAndWaitCost(status_commonAndWaitCost);//공통.대기
		totalChecked.setTotalSales(status_totalSales);//엽업
		totalChecked.setTotalSupport(status_totalSupport);//지원
		totalChecked.setTotalOutCost(status_totalOutCost);//외주비
		totalChecked.setTotalMatlCost(status_totalMatlCost);//상품비
		totalChecked.setTotalCost(status_totalCost);//경비
		totalChecked.setTotalLaborMM(status_totalLaborMM);//직원MM
		totalChecked.setTotalOutMM(status_totalOutMM);//외주MM
		
		view.addObject("totalSumList", resultMap.get("totalSumList"));
		view.addObject("project", project);
		view.addObject("totalChecked", totalChecked);
		view.addObject("resultList", resultMap.get("resultList"));
		view.setViewName("total/projectBudgetInfo/projectBudgetInfoList");
		
		return view;
	}
	
}
