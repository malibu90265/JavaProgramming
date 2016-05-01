package com.sqisoft.iqs.team.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.project.dao.PjBudgetDAO;
import com.sqisoft.iqs.project.vo.PjBudgetInfoVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.dao.TeamDAO;
import com.sqisoft.iqs.team.dao.TotalDAO;
import com.sqisoft.iqs.team.vo.GageGoalVO;
import com.sqisoft.iqs.team.vo.GageRealVO;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.team.vo.TotalProjectByTeamVO;
import com.sqisoft.iqs.team.vo.TotalTeamVO;
import com.sqisoft.iqs.team.vo.TotalVO;
import com.sqisoft.iqs.team.vo.TotalWeekReportVO;
import com.sqisoft.iqs.team.vo.WaitVO;
import com.sqisoft.iqs.team.vo.WeekChartTotalVO;
import com.sqisoft.iqs.team.vo.WeekChartVO;
import com.sqisoft.iqs.team.vo.WeekLogVO;
import com.sqisoft.iqs.team.vo.totalChartVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;

public class TotalServiceImpl implements TotalService {

	private TotalDAO totalDAO;
	private TeamDAO teamDAO;
	private PjBudgetDAO pjBudgetDAO;

	public void setTotalDAO(TotalDAO totalDAO) {
		this.totalDAO = totalDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void setPjBudgetDAO(PjBudgetDAO pjBudgetDAO) {
		this.pjBudgetDAO = pjBudgetDAO;
	}

	Map<String, Object> pjNetSalesMap;
	Map<String, Object> totalPjNetSalesMap;

	@Override
	public Map<String, TotalTeamVO> getTotalChart() {

		Map<String, TotalTeamVO> totalList = new LinkedHashMap<String, TotalTeamVO>();

		TotalTeamVO totalTeamVO = new TotalTeamVO();
		totalList.put("합계", totalTeamVO);

		// 현재 년도 팀의 목표관리를 셋팅
		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList = this.teamDAO.getTeamListByYear(year);

		TotalTeamVO newTotalTeamVO = null;
		TotalVO totalGoalVO = new TotalVO();
		for (TeamVO team : teamList) {
			newTotalTeamVO = new TotalTeamVO();
			TotalVO goalVO = this.getGoalVOByTeamVO(team);
			newTotalTeamVO.setGoal(goalVO);
			// goalVO.setTotalSales(team.getTm_ind_lcost());
			this.calcTotalGoal(totalGoalVO, goalVO);

			totalList.put(team.getTm_name(), newTotalTeamVO);
		}
		// 합계에 모든 팀의 목표를 더한 값을 넣어줌.
		totalTeamVO.setGoal(totalGoalVO);

		// 팀별 추정실적 데이터를 가져오는 곳
		// 모든 팀을 가져와서 팀 리스트를 만들
		TotalVO totalEstimationResult = new TotalVO();
		TotalVO estimationResult = null;

		for (TeamVO teamVO : teamList) {
			estimationResult = this.getTeamTotalChart(teamVO);
			
			this.calcTotalEstimationResult(teamVO.getTm_id(), totalEstimationResult, estimationResult);

			TotalTeamVO totalTeamVOByTeamName = totalList.get(teamVO.getTm_name());
			totalTeamVOByTeamName.setEstimationResult(estimationResult);
			totalTeamVOByTeamName.setAchievementRate(this
					.getAchievementRate(totalTeamVOByTeamName.getEstimationResult(), totalTeamVOByTeamName.getGoal()));
			totalTeamVOByTeamName.setDifferenceResult(this
					.getDifferenceResult(totalTeamVOByTeamName.getEstimationResult(), totalTeamVOByTeamName.getGoal()));
		}
		//
		totalTeamVO.setEstimationResult(totalEstimationResult);

		totalTeamVO
				.setAchievementRate(this.getAchievementRate(totalTeamVO.getEstimationResult(), totalTeamVO.getGoal()));

		totalTeamVO.setDifferenceResult(
				this.getDifferenceResult(totalTeamVO.getEstimationResult(), totalTeamVO.getGoal()));

		return totalList;
	}

	@Override
	public WeekChartVO getWeekChart(String tm_id) {

		//올해 팀 List를 가져옴
		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList = this.teamDAO.getTeamList(year);

		//
		Map<String, String> params = new HashMap<String, String>();
		WeekChartVO weekChart = new WeekChartVO();
		List<WeekChartTotalVO> weekChartList = null;
		if (tm_id.equals("all")) { 												//전체 선택이면
			for (TeamVO team : teamList) {
				//weekChart에 팀 전체 목표 계약액, 매출액, 순매출액, 영업 이익 합계 계산
				this.putTeamGoalWeekChartFromTeam(weekChart, team);
			}
			weekChartList = this.totalDAO.getTotalWeekChartList();
			
			/*for (TeamVO team : teamList) {
				//weekChart에 팀 전체 목표 계약액, 매출액, 순매출액, 영업 이익 합계 계산
				this.putTeamGoalWeekChartFromTeam(weekChart, team);

				//각 팀의 날짜별 계약액, 매출액, 순매출액, 영업이익를 가져옴
				params.put("tm_id", team.getTm_id());
				weekChartList = this.totalDAO.getWeekChartList(params);
				//날짜 별로 계약액, 매출액, 순매출액, 영업이익 합계 계산
				this.putTotalListFromWeekChartList(weekChart, weekChartList);
			}*/
		} else { 																//팀 선택이면 

			TeamVO team = null;
			for (TeamVO tempTeam : teamList) {
				if (tempTeam.getTm_id().equals(tm_id))
					team = tempTeam;
			}
			this.putTeamGoalWeekChartFromTeam(weekChart, team);

			//
			params.put("tm_id", team.getTm_id());
			weekChartList = this.totalDAO.getWeekChartList(params);
		}

		if (weekChartList == null)
			weekChartList = new ArrayList<WeekChartTotalVO>();
		weekChart.setTotalList(weekChartList);

		return weekChart;
	}

	/*private void putTotalListFromWeekChartList(WeekChartVO weekChart, List<WeekChartTotalVO> weekChartList) {
		List<WeekChartTotalVO> totalWeekChartList = weekChart.getTotalList();
		int index = 0;
		WeekChartTotalVO totalWeekChart = new WeekChartTotalVO();
		
		if(totalWeekChartList.size() == 0){
			for (WeekChartTotalVO tempWeekChart : weekChartList) {
				totalWeekChart = new WeekChartTotalVO();
				totalWeekChart.setWr_date(tempWeekChart.getWr_date());
				totalWeekChartList.add(totalWeekChart);
			}
		}
		
		for (WeekChartTotalVO tempWeekChart : weekChartList) {
			for(WeekChartTotalVO t : totalWeekChartList){
				if(t.getWr_date().contains(tempWeekChart.getWr_date())){
					//index = totalWeekChartList.indexOf(tempWeekChart.getWr_date());
					//index = t.getWr_date().indexOf(tempWeekChart.getWr_date());
					//totalWeekChart = totalWeekChartList.get(index);
					t.setContract(t.getContract() + tempWeekChart.getContract());
					t.setYearSales(t.getYearSales() + tempWeekChart.getYearSales());
					t.setNetSales(t.getNetSales() + tempWeekChart.getNetSales());
					t.setProfit(t.getProfit() + tempWeekChart.getProfit());
					System.out.println("+++++++++들어옴++++++++++++++");
					System.out.println("tempWeekChart.getWr_date() : " + tempWeekChart.getWr_date());
					System.out.println("t.getWr_date() : " + t.getWr_date());
					System.out.println(t.getWr_date());
					System.out.println(t.getContract());
					System.out.println(t.getYearSales());
					System.out.println(t.getNetSales());
					System.out.println(t.getProfit());
				}
			}
		}
		for(int i=0; i <totalWeekChartList.size(); i++){
			System.out.println("+++++++++++++++++++++++");
			System.out.println(i);
			System.out.println(totalWeekChartList.get(i).getWr_date());
			System.out.println(totalWeekChartList.get(i).getContract());
			System.out.println(totalWeekChartList.get(i).getYearSales());
			System.out.println(totalWeekChartList.get(i).getNetSales());
			System.out.println(totalWeekChartList.get(i).getProfit());
		}
		weekChartList.add(totalWeekChart);
		weekChart.setTotalList(totalWeekChartList);
	}*/

	private void putTeamGoalWeekChartFromTeam(WeekChartVO weekChart, TeamVO team) {
		weekChart.setGoalContract(weekChart.getGoalContract() + team.getTm_contract());
		weekChart.setGoalYearSales(weekChart.getGoalYearSales() + team.getTm_sales());
		// 순매출 목표 = 매출액 - 예상상품비 - 예상외주비
		weekChart.setGoalNetSales( weekChart.getGoalNetSales() + team.getTm_sales() - team.getTm_matl_cost() - team.getTm_outsrc_cost());
		
		/*System.out.println(team.getTm_id());
		System.out.println("매출액 : "+ team.getTm_sales());
		System.out.println("상품비 : "+ team.getTm_matl_cost());
		System.out.println("외주비 : "+ team.getTm_outsrc_cost());
		System.out.println(weekChart.getGoalNetSales());
		System.out.println("------------------------------------");*/
		
		weekChart.setGoalSalesProfit(weekChart.getGoalSalesProfit() + team.getTm_profit());
	}

	// 전주 대비표
	@Override
	public Map<String, Object> getWeekReport(String presentWeek, String lastWeek) {

		//
		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList = this.teamDAO.getTeamListByYear(year);

		Map<String, TotalWeekReportVO> totalWeekReportList = new LinkedHashMap<String, TotalWeekReportVO>();
		TotalWeekReportVO totalWeekReport = new TotalWeekReportVO();
		totalWeekReportList.put("합계", totalWeekReport);

		//
		Map<String, String> params = new HashMap<String, String>();

		//
		TotalWeekReportVO weekReportByTeam = null;
		String team_id = "";
		for (TeamVO team : teamList) {
			weekReportByTeam = new TotalWeekReportVO();
			team_id = team.getTm_id();

			params.put("wr_date", presentWeek);
			params.put("tm_id", team_id);

			// 현재 주
			weekReportByTeam.setPresentWeekReportVO(this.totalDAO.getWeekReport(params));
			if (weekReportByTeam.getPresentWeekReportVO() == null)
				weekReportByTeam.setPresentWeekReportVO(new TotalVO());

			this.calcTotalWeekReport(totalWeekReport.getPresentWeekReportVO(),
					weekReportByTeam.getPresentWeekReportVO());

			// 전 주
			params.put("wr_date", lastWeek);

			weekReportByTeam.setLastWeekReportVO(this.totalDAO.getWeekReport(params));
			if (weekReportByTeam.getLastWeekReportVO() == null)
				weekReportByTeam.setLastWeekReportVO(new TotalVO());
			this.calcTotalWeekReport(totalWeekReport.getLastWeekReportVO(), weekReportByTeam.getLastWeekReportVO());

			// 차이
			weekReportByTeam.setDifferenceWeekReportVO(this.calcDifferenceWeekReportList(
					weekReportByTeam.getPresentWeekReportVO(), weekReportByTeam.getLastWeekReportVO()));
			this.calcTotalWeekReport(totalWeekReport.getDifferenceWeekReportVO(),
					weekReportByTeam.getDifferenceWeekReportVO());

			totalWeekReportList.put(team.getTm_name(), weekReportByTeam);
		}

		// 손익 변동 내역
		WeekLogVO weekLogReportVO = this.totalDAO.getWeekLogReportVO();

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("weekLogReportVO", weekLogReportVO);
		resultMap.put("totalWeekReportList", totalWeekReportList);

		return resultMap;
	}

	private void calcTotalWeekReport(TotalVO totalVO, TotalVO weekReportVO) {
		totalVO.setTotalContract(totalVO.getTotalContract() + weekReportVO.getTotalContract());
		totalVO.setYearSales(totalVO.getYearSales() + weekReportVO.getYearSales());
		totalVO.setNetSales(totalVO.getNetSales() + weekReportVO.getNetSales());
		totalVO.setProfitSales(totalVO.getProfitSales() + weekReportVO.getProfitSales());
		totalVO.setTotalSalesCost(totalVO.getTotalSalesCost() + weekReportVO.getTotalSalesCost());
		totalVO.setTotalLaborCost(totalVO.getTotalLaborCost() + weekReportVO.getTotalLaborCost());
		totalVO.setTotalMatlCost(totalVO.getTotalMatlCost() + weekReportVO.getTotalMatlCost());
		totalVO.setTotalCost(totalVO.getTotalCost() + weekReportVO.getTotalCost());
	}

	private TotalVO calcDifferenceWeekReportList(TotalVO presentWeekReport, TotalVO lastWeekReport) {

		TotalVO differenceWeekReport = new TotalVO();

		differenceWeekReport.setTotalContract(presentWeekReport.getTotalContract() - lastWeekReport.getTotalContract());
		differenceWeekReport.setYearSales(presentWeekReport.getYearSales() - lastWeekReport.getYearSales());
		differenceWeekReport.setNetSales(presentWeekReport.getNetSales() - lastWeekReport.getNetSales());
		differenceWeekReport.setProfitSales(presentWeekReport.getProfitSales() - lastWeekReport.getProfitSales());
		differenceWeekReport
				.setTotalSalesCost(presentWeekReport.getTotalSalesCost() - lastWeekReport.getTotalSalesCost());
		differenceWeekReport
				.setTotalLaborCost(presentWeekReport.getTotalLaborCost() - lastWeekReport.getTotalLaborCost());
		differenceWeekReport.setTotalMatlCost(presentWeekReport.getTotalMatlCost() - lastWeekReport.getTotalMatlCost());
		differenceWeekReport.setTotalCost(presentWeekReport.getTotalCost() - lastWeekReport.getTotalCost());

		return differenceWeekReport;
	}

	private void calcTotalGoal(TotalVO totalGoalVO, TotalVO goalVO) {
		totalGoalVO.setTotalContract(totalGoalVO.getTotalContract() + goalVO.getTotalContract());
		totalGoalVO.setYearSales(totalGoalVO.getYearSales() + goalVO.getYearSales());
		totalGoalVO.setNetSales(totalGoalVO.getNetSales() + goalVO.getNetSales());
		totalGoalVO.setProfitSales(totalGoalVO.getProfitSales() + goalVO.getProfitSales());
		totalGoalVO.setTotalSalesCost(totalGoalVO.getTotalSalesCost() + goalVO.getTotalSalesCost());
		totalGoalVO.setTotalSales(totalGoalVO.getTotalSales() + goalVO.getTotalSales());
		totalGoalVO.setTotalOutCost(totalGoalVO.getTotalOutCost() + goalVO.getTotalOutCost());
		totalGoalVO.setTotalMatlCost(totalGoalVO.getTotalMatlCost() + goalVO.getTotalMatlCost());
	}

	private void calcTotalEstimationResult(String tm_id, TotalVO totalEstimationResult, TotalVO estimationResult) {
		totalEstimationResult
				.setTotalContract(totalEstimationResult.getTotalContract() + estimationResult.getTotalContract());
		totalEstimationResult.setYearSales(totalEstimationResult.getYearSales() + estimationResult.getYearSales());
		totalEstimationResult.setNetSales(totalEstimationResult.getNetSales() + estimationResult.getNetSales());
		totalEstimationResult
				.setProfitSales(totalEstimationResult.getProfitSales() + estimationResult.getProfitSales());
		totalEstimationResult
				.setTotalSalesCost(totalEstimationResult.getTotalSalesCost() + estimationResult.getTotalSalesCost());
		totalEstimationResult.setTotalCost(totalEstimationResult.getTotalCost() + estimationResult.getTotalCost());
		totalEstimationResult
				.setTotalLaborCost(totalEstimationResult.getTotalLaborCost() + estimationResult.getTotalLaborCost());
		totalEstimationResult
				.setTotalDirectCost(totalEstimationResult.getTotalDirectCost() + estimationResult.getTotalDirectCost());
		totalEstimationResult.setTotalSales(totalEstimationResult.getTotalSales() + estimationResult.getTotalSales());
		totalEstimationResult
				.setTotalSupport(totalEstimationResult.getTotalSupport() + estimationResult.getTotalSupport());
		totalEstimationResult
				.setTotalOutCost(totalEstimationResult.getTotalOutCost() + estimationResult.getTotalOutCost());
		totalEstimationResult
				.setTotalMatlCost(totalEstimationResult.getTotalMatlCost() + estimationResult.getTotalMatlCost());
	}

	// 팀 VO에서 총괄표에 필요한 팀 목표 데이터를 셋팅하고, 각 팀별 목표 데이터를 합계 VO에 더해준다.
	private TotalVO getGoalVOByTeamVO(TeamVO team) {
		TotalVO goalVO = new TotalVO();

		goalVO.setTotalContract(team.getTm_contract());
		goalVO.setYearSales(team.getTm_sales());
		goalVO.setNetSales(team.getTm_sales() - team.getTm_outsrc_cost() - team.getTm_matl_cost());
		goalVO.setProfitSales(team.getTm_profit());
		goalVO.setTotalSalesCost(goalVO.getNetSales() - goalVO.getProfitSales());
		goalVO.setTotalOutCost(team.getTm_outsrc_cost());
		goalVO.setTotalMatlCost(team.getTm_matl_cost());

		return goalVO;
	}

	private TotalVO getEstimationResultByTeamVO(TeamVO teamVO) {
		pjNetSalesMap = new HashMap<String, Object>();
		totalPjNetSalesMap = new HashMap<String, Object>();

		double pjNetSalesWithB = 0;
		// tm별 B급 제외 순매출액
		double pjNetSalesWithoutB = this.totalDAO.getNetSaleswithoutB(teamVO.getTm_id());
		// tm별 B급 순매출액
		if (this.totalDAO.getNetSalesWithB(teamVO.getTm_id()) == 0) {
			pjNetSalesWithB = 0;
		} else
			pjNetSalesWithB = this.totalDAO.getNetSalesWithB(teamVO.getTm_id()) * 0.5;
		// tm별 총 순매출액
		double pjNetSales = pjNetSalesWithoutB + pjNetSalesWithB;

		pjNetSalesMap.put("pjNetSalesWithoutB", pjNetSalesWithoutB);
		pjNetSalesMap.put("pjNetSalesWithB", pjNetSalesWithB);
		pjNetSalesMap.put("pjNetSales", pjNetSales);
		// 회사 B급 제외 총 순매출액
		double totalPjNetWithoutB = this.totalDAO.getTotalComSaleswithoutB();
		// 회사 B급 총 순매출액
		double totalPjNetWithB = this.totalDAO.getTotalComNetSalesWithB() * 0.5;
		// 회사 총 순매출액
		double totalPjNetSales = totalPjNetWithoutB + totalPjNetWithB;
		System.out.println("totalPjNetWithoutB : " + totalPjNetWithoutB);
		totalPjNetSalesMap.put("totalPjNetWithoutB", totalPjNetWithoutB);
		totalPjNetSalesMap.put("totalPjNetWithB", totalPjNetWithB);
		totalPjNetSalesMap.put("totalPjNetSales", totalPjNetSales);

		// 계약금액, 금년매출액, 순매출액, 영업이익
		double totalContract = 0d;
		double yearSales = 0d;
		double netSales = 0d;
		double profitSales = 0d;

		// 매출원가(계), 인건비(계), PJ직접(개발), 영업, 지원, 외주
		double totalSalesCost = 0d;
		double totalLaborCost = 0d;
		double totalDirectCost = 0d;
		double totalSales = 0d;
		double totalSupport = 0d;
		double totalOutCost = 0d;

		// 상품비, 경비
		double totalMatlCost = 0d;
		double totalCost = 0d;

		// C급, 종결단계를 제외한 모든 프로젝트를 가져온다
		Map<String, String> params = new HashMap<String, String>();
		params.put("firstParam", "C급");
		params.put("secondParam", "종결");
		params.put("tm_id", teamVO.getTm_id());
		List<ProjectVO> projectList = this.totalDAO.getProjectListByConditions(params);
		for (ProjectVO projectVO : projectList) {
			TotalVO totalVO = new TotalVO();
			totalContract += totalVO.getTotalContract();
			yearSales += totalVO.getYearSales();

			netSales += totalVO.getNetSales();
			profitSales += totalVO.getProfitSales();

			totalSalesCost += totalVO.getTotalSalesCost();
			totalLaborCost += totalVO.getTotalLaborCost();
			totalDirectCost += totalVO.getTotalDirectCost();
			if (teamVO.getTm_id().contains("6M")) {
				totalSales = 0;
				profitSales = totalVO.getYearSales() - totalVO.getTotalSalesCost();
			} else {
				totalSales += totalVO.getTotalOutCost();
			}
			totalSupport += totalVO.getTotalSupport();
			totalOutCost += totalVO.getTotalOutCost();

			totalMatlCost += totalVO.getTotalMatlCost();

			totalCost += totalVO.getTotalCost();

		}

		TotalVO estimationResult = new TotalVO();
		estimationResult.setTotalContract(totalContract);
		estimationResult.setYearSales(yearSales);
		estimationResult.setNetSales(netSales);
		estimationResult.setProfitSales(profitSales);
		estimationResult.setTotalSalesCost(totalSalesCost);
		estimationResult.setTotalLaborCost(totalLaborCost);
		estimationResult.setTotalDirectCost(totalDirectCost);
		estimationResult.setTotalSales(totalSales);
		estimationResult.setTotalSupport(totalSupport);
		estimationResult.setTotalOutCost(totalOutCost);
		estimationResult.setTotalMatlCost(totalMatlCost);
		estimationResult.setTotalCost(totalCost);

		return estimationResult;
	}

	// ******************************************************20151101 임의 추가
	private TotalVO getTeamTotalChart(TeamVO teamVO) {
		String tm_id = teamVO.getTm_id();
		totalChartVO tv = totalDAO.getTotalChart(tm_id);

		// 인건비(계)
		int totalLaborCost = tv.getWr_labor_cost() + tv.getCommonWaitCost() + tv.getSalesCost() + tv.getSupportCost() + tv.getOutCost();
		// 매출원가(계)
		int totalSalesCost = totalLaborCost + tv.getWr_matl_cost() + tv.getWr_expense();

		TotalVO estimationResult = new TotalVO();
		estimationResult.setTm_id(tv.getTm_id());
		estimationResult.setWr_date(tv.getWr_date());
		estimationResult.setTotalContract(tv.getWr_contract());
		estimationResult.setYearSales(tv.getWr_sales());
		estimationResult.setNetSales(tv.getWr_netsales());
		estimationResult.setProfitSales(tv.getWr_profit());
		estimationResult.setTotalSalesCost(tv.getTotalSalesCost());
		estimationResult.setTotalLaborCost(totalLaborCost);
		//총괄표에서  직접(개발)은 PJ직접비+공통/대기 임.
		estimationResult.setTotalDirectCost(tv.getWr_labor_cost()+tv.getCommonWaitCost());
		estimationResult.setTotalCommonAndWaitCost(tv.getCommonWaitCost());
		estimationResult.setTotalSales(tv.getSalesCost());
		estimationResult.setTotalSupport(tv.getSupportCost());
		estimationResult.setTotalOutCost(tv.getOutCost());
		estimationResult.setTotalMatlCost(tv.getWr_matl_cost());
		estimationResult.setTotalCost(tv.getWr_expense());

		return estimationResult;
	}
	// 사업팀 총 B급 제외 총순매출액
	private double getNetSaledivWithoutB(double pjNetSalesWithoutB, ProjectVO projectVO) {
		double getNetSales = projectVO.getPj_year_sales() - projectVO.getPj_matl_cost() - projectVO.getPj_outsrc_cost();

		if (projectVO.getPj_status() == 4) {
			getNetSales = getNetSales * 0.9;
		}
		if (projectVO.getPj_status() == 5) {
			getNetSales = getNetSales * 1 / 2;
		}
		return getNetSales / pjNetSalesWithoutB;
	}

	// 목표와 추정실적을 가지고 달성률을 구하는 Method
	private TotalVO getAchievementRate(TotalVO estimationResult, TotalVO goal) {
		TotalVO achievementResult = new TotalVO();

		achievementResult
				.setTotalContract(Math.round((estimationResult.getTotalContract() / goal.getTotalContract()) * 100));
		achievementResult.setYearSales(Math.round((estimationResult.getYearSales() / goal.getYearSales()) * 100));
		achievementResult.setNetSales(Math.round((estimationResult.getNetSales() / goal.getNetSales()) * 100));
		achievementResult.setProfitSales(Math.round((estimationResult.getProfitSales() / goal.getProfitSales()) * 100));
		achievementResult
				.setTotalSalesCost(Math.round((estimationResult.getTotalSalesCost() / goal.getTotalSalesCost()) * 100));
		achievementResult.setTotalSales(Math.round((estimationResult.getTotalSales() / goal.getTotalSales()) * 100));
		achievementResult
				.setTotalOutCost(Math.round((estimationResult.getTotalOutCost() / goal.getTotalOutCost()) * 100));
		achievementResult
				.setTotalMatlCost(Math.round((estimationResult.getTotalMatlCost() / goal.getTotalMatlCost()) * 100));

		return achievementResult;
	}

	// 목표와 추정실적을 가지고 차이를 구하는 Method
	private TotalVO getDifferenceResult(TotalVO estimationResult, TotalVO goal) {
		TotalVO differenceResult = new TotalVO();

		differenceResult.setTotalContract(estimationResult.getTotalContract() - goal.getTotalContract());
		differenceResult.setYearSales(estimationResult.getYearSales() - goal.getYearSales());
		differenceResult.setNetSales(estimationResult.getNetSales() - goal.getNetSales());
		differenceResult.setProfitSales(estimationResult.getProfitSales() - goal.getProfitSales());
		differenceResult.setTotalSalesCost(estimationResult.getTotalSalesCost() - goal.getTotalSalesCost());
		differenceResult.setTotalSales(estimationResult.getTotalSales() - goal.getTotalSales());
		differenceResult.setTotalOutCost(estimationResult.getTotalOutCost() - goal.getTotalOutCost());
		differenceResult.setTotalMatlCost(estimationResult.getTotalMatlCost() - goal.getTotalMatlCost());

		return differenceResult;
	}

	@Override
	public void insertWeekReport() {

		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList = this.teamDAO.getTeamList(year);

		for (TeamVO teamVO : teamList) {
			TotalVO totalVO = new TotalVO();
			String tm_id = teamVO.getTm_id();

			totalVO = this.getEstimationResultByTeamVO(teamVO);
			totalVO.setTm_id(tm_id);
			totalVO.setWr_date(CalendarUtil.getPresentWeek());

			this.totalDAO.insertTeamWeekReport(totalVO);
		}
	}

	public List<String> getWeekList() {
		return this.totalDAO.getWeekList();
	}

	// 각 프로젝트 공통/대기 구하기
	public void getEmployWait(String b4_pd_name, String pd_name) {

		int year = CalendarUtil.getPresentYear();

		if (!b4_pd_name.equals("")) {
			this.totalDAO.deletPjDeploy(b4_pd_name);
			insertWaitInfo(b4_pd_name, year);
		}
		if (!pd_name.equals("")) {
			this.totalDAO.deletPjDeploy(pd_name);
			insertWaitInfo(pd_name, year);
		}
	}

	public void insertWaitInfo(String hr_name, int year) {
		Calendar temp = Calendar.getInstance();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hr_name", hr_name);
		params.put("year", year);
		List<DeployMapVO> pjDeployVO = this.totalDAO.getPjDeployList(params);
		// 직원의 입사일과 퇴사일
		HumanResourceVO humanResource = this.totalDAO.getHumanInfo(hr_name);
		String b4_from_date = "";
		String b4_to_date = "";
		String hire_date[] = null;
		String quit_date[] = null;
		String quit_date_str = null;

		if (humanResource.getHr_hire_date() != null)
			hire_date = humanResource.getHr_hire_date().split("-");
		if (humanResource.getHr_quit_date() != null) {
			quit_date = humanResource.getHr_quit_date().split("-");
			quit_date_str = humanResource.getHr_quit_date().replaceAll("-", "");
		}

		for (int i = 0; i < pjDeployVO.size(); i++) {
			params.put("hr_name", hr_name);
			params.put("pj_id", pjDeployVO.get(i).getPj_id());
			String tm_id = this.totalDAO.getTm_id(params);
			String[] firstPj_start_date = pjDeployVO.get(i).getPd_start_date().split("-");
			String[] pd_end_date = pjDeployVO.get(i).getPd_end_date().split("-");
			int startYear = 0;
			int startMonth = 0;
			int startDay = 0;
			String firstPj_start_date_str = pjDeployVO.get(i).getPd_start_date().replaceAll("-", "");// 현
																										// pj
																										// 시작일
			String pd_end_date_str = pjDeployVO.get(i).getPd_end_date().replaceAll("-", "");// 현
																							// pj종료일
			String pd_start_date_str = "";// 다음 pj 시작일

			// 마지막 프로젝트가 아닐 경우 다음 시작하는 프로젝트 시작일 받아오기
			if (i != (pjDeployVO.size() - 1)) {
				String[] pd_start_date = pjDeployVO.get(i + 1).getPd_start_date().split("-");
				pd_start_date_str = pjDeployVO.get(i + 1).getPd_start_date().replaceAll("-", "");
				startYear = Integer.parseInt(pd_start_date[0]);
				startMonth = Integer.parseInt(pd_start_date[1]) - 1;
				startDay = Integer.parseInt(pd_start_date[2]);
			}

			int firstPjYear = Integer.parseInt(firstPj_start_date[0]);
			int firstPjMonth = Integer.parseInt(firstPj_start_date[1]) - 1;
			int firstPjDay = Integer.parseInt(firstPj_start_date[2]);

			int endYear = Integer.parseInt(pd_end_date[0]);
			int endMonth = Integer.parseInt(pd_end_date[1]) - 1;
			int endDay = Integer.parseInt(pd_end_date[2]);
			temp.set(endYear, endMonth, endDay);

			// 프로젝트시작일 하고 현재 년도가 다를 경우
			if (year != firstPjYear) {
				params.put("wa_name", humanResource.getHr_name());
				params.put("tm_id", tm_id);
				// 퇴사자일 경우
				if (humanResource.getHr_quit_date() != null) {
					// 퇴사일이 프로젝트와 겹치지 않는 경우
					if (!((Integer.parseInt(firstPj_start_date_str) <= Integer.parseInt(quit_date_str))
							&& (Integer.parseInt(quit_date_str) <= Integer.parseInt(pd_end_date_str)))) {
						// pj한 개 일 때 || 마지막 일 때
						if (i == (pjDeployVO.size() - 1)) {
							b4_from_date = calendarCheck(endYear, endMonth, endDay, 0);
							params.put("wa_from_date", b4_from_date);
							params.put("wa_to_date", quit_date_str);
							this.totalDAO.insertPjWaitInfo(params);
						}
						// 뒤에 프로젝트가 또 있는 경우
						else {
							b4_from_date = calendarCheck(endYear, endMonth, endDay, 0);
							b4_to_date = calendarCheck(startYear, startMonth, startDay, 1);
							params.put("wa_from_date", b4_from_date);
							params.put("wa_to_date", b4_to_date);
							this.totalDAO.insertPjWaitInfo(params);
						}
					}
				}
				// 퇴사자 아닐경우
				else {
					b4_from_date = calendarCheck(endYear, endMonth, endDay, 0);
					b4_to_date = calendarCheck(startYear, startMonth, startDay, 1);
					params.put("wa_from_date", b4_from_date);
					params.put("wa_to_date", b4_to_date);
					this.totalDAO.insertPjWaitInfo(params);
				}
			}

			// 프로젝트 시작일하고 현재 년도가 같을 경우
			// 입사년도가 관계 있을 수 있음
			else {
				// 마지막프로젝트일 때
				if (i == (pjDeployVO.size() - 1)) {
					// 퇴사일이 있을 경우
					if (humanResource.getHr_quit_date() != null) {
						// 퇴사일이 프로젝트와 겹치지 않는 경우
						if (!((Integer.parseInt(firstPj_start_date_str) <= Integer.parseInt(quit_date_str))
								&& (Integer.parseInt(quit_date_str) <= Integer.parseInt(pd_end_date_str)))) {
							b4_from_date = calendarCheck(endYear, endMonth, endDay, 0);
							params.put("wa_name", humanResource.getHr_name());
							params.put("tm_id", tm_id);
							params.put("wa_from_date", b4_from_date);
							params.put("wa_to_date", quit_date_str);
							this.totalDAO.insertPjWaitInfo(params);
						}
					}
					// 퇴사일 없을 경우
					else {
						// 마지막 프로젝트가 올 해 끝나면
						if (endYear == year) {
							if (!((endMonth + 1) == 12 && endDay == 31)) {
								b4_from_date = calendarCheck(endYear, endMonth, endDay, 0);
								params.put("wa_name", humanResource.getHr_name());
								params.put("tm_id", tm_id);
								params.put("wa_from_date", b4_from_date);
								params.put("wa_to_date", year + "-12-31");
								this.totalDAO.insertPjWaitInfo(params);
							}
						}
					}
				}
				// 마지막 프로젝트 아닐 때
				else {
					// 처음 프로젝트의 경우
					if (i == 0) {
						// 입사년도가 올해인 경우
						if (hire_date[0].equals(Integer.toString(year))) {
							// 입사일 != 처음 프로젝트 시작일
							if (!humanResource.getHr_hire_date().equals(pjDeployVO.get(i).getPd_start_date())) {
								params.put("wa_name", humanResource.getHr_name());
								params.put("tm_id", humanResource.getTm_id());
								params.put("wa_from_date", humanResource.getHr_hire_date());
								params.put("wa_to_date", calendarCheck(firstPjYear, firstPjMonth, firstPjDay, 1));
								this.totalDAO.insertPjWaitInfo(params);
							}
						}
						// 입사년도가 올해가 아닌 경우
						else {
							// 해당년도.01.01 != 처음 프로젝트 시작일
							if (!(year + "-01-01").equals(pjDeployVO.get(i).getPd_start_date())) {
								params.put("wa_name", humanResource.getHr_name());
								params.put("tm_id", humanResource.getTm_id());
								params.put("wa_from_date", year + "-01-01");
								params.put("wa_to_date", calendarCheck(firstPjYear, firstPjMonth, firstPjDay, 1));
								this.totalDAO.insertPjWaitInfo(params);
							}
						}
					}
					b4_from_date = calendarCheck(endYear, endMonth, endDay, 0);
					if (!b4_from_date.equals(pjDeployVO.get(i + 1).getPd_start_date())) {
						b4_to_date = calendarCheck(startYear, startMonth, startDay, 1);
						params.put("wa_name", humanResource.getHr_name());
						params.put("tm_id", tm_id);
						params.put("wa_from_date", b4_from_date);
						params.put("wa_to_date", b4_to_date);
						this.totalDAO.insertPjWaitInfo(params);
					}
				}
			}
		}
	}

	// 그 달의 최대 일이 넘어가는지
	private String calendarCheck(int year, int month, int day, int check) {
		Calendar temp = Calendar.getInstance();
		if (check == 0) {
			temp.set(year, month, day);
			if (day == temp.getActualMaximum(Calendar.DATE)) {
				if (month + 2 < 10) {
					return Integer.toString(year) + "-" + "0" + Integer.toString(month + 2) + "-01";
				} else {
					return Integer.toString(year) + "-" + Integer.toString(month + 2) + "-01";
				}
			} else {
				if (month + 1 < 10) {
					if (day + 1 < 10) {
						return Integer.toString(year) + "-" + "0" + Integer.toString(month + 1) + "-" + "0"
								+ Integer.toString(day + 1);
					} else {
						return Integer.toString(year) + "-" + "0" + Integer.toString(month + 1) + "-"
								+ Integer.toString(day + 1);
					}
				} else {
					if (day + 1 < 10) {
						return Integer.toString(year) + "-" + Integer.toString(month + 1) + "-" + "0"
								+ Integer.toString(day + 1);
					} else {
						return Integer.toString(year) + "-" + Integer.toString(month + 1) + "-"
								+ Integer.toString(day + 1);
					}
				}
			}
		} else {
			temp.set(year, month - 1, day);
			if (day == 01) {
				day = temp.getActualMaximum(Calendar.DATE);
				if (month < 10) {
					return Integer.toString(year) + "-" + "0" + Integer.toString(month) + "-" + Integer.toString(day);
				} else {
					return Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day);
				}
			} else {
				if (month + 1 < 10) {
					if (day - 1 < 10) {
						return Integer.toString(year) + "-" + "0" + Integer.toString(month + 1) + "-" + "0"
								+ Integer.toString(day - 1);
					} else {
						return Integer.toString(year) + "-" + "0" + Integer.toString(month + 1) + "-"
								+ Integer.toString(day - 1);
					}
				} else {
					if (day - 1 < 10) {
						return Integer.toString(year) + "-" + Integer.toString(month + 1) + "-" + "0"
								+ Integer.toString(day - 1);
					} else {
						return Integer.toString(year) + "-" + Integer.toString(month + 1) + "-"
								+ Integer.toString(day - 1);
					}
				}
			}
		}
	}

	// 경영지원팀의 공통경비
	private int getExpenseManage_part() {
		return this.totalDAO.getExpenseManage_part();
	}

	// 경영지원팀의 평균단가
	private int getManageMonPrice() {
		return this.totalDAO.getManageMonPrice();
	}

	private List<TotalProjectByTeamVO> resultList; //선택한 팀 손익 합계 저장한 List
	private TotalProjectByTeamVO[] projectByStatus; //상태별 손익 합계 저장한 List
	private List<ProjectVO> projectList;//선택한 팀의 프로젝트별 손익 저장한 List
	// 전체 합계
	@Override
	public Map<String, Object> getProjectBudgetInfo(String tm_id) {
		//상태별 손익 합계 저장한 List
		projectByStatus = new TotalProjectByTeamVO[5];
		
		
		/* 프로젝트 상태 별 TotalProjectByTeamVO */
		// 계약액
		double[] status_totalContract = new double[5];
		// 매출액
		double[] status_totalYearSales = new double[5];
		// 상품비
		double[] status_totalMatlCost = new double[5];
		// 영업이익
		double[] status_totalProfitSales = new double[5];
		// 외주비
		double[] status_totalOutCost = new double[5];
		// 순매출액
		double[] status_totalNetSales = new double[5];
		// (매출원가)합계
		double[] status_totalSalesCost = new double[5];
		// (인건비)계
		double[] status_totalLaborCost = new double[5];
		// pj직접
		double[] status_totalDirectCost = new double[5];
		// 직원/외주 mm
		double[] status_totalLaborMM = new double[5];
		double[] status_totalOutMM = new double[5];
		// 공통,대기
		double[] status_commonAndWaitCost = new double[5];
		// 영업
		double[] status_totalSales = new double[5];
		// 지원
		double[] status_totalSupport = new double[5];
		// 경비
		double[] status_totalCost = new double[5];
		
		for(int i=0; i<5; i++){
			projectByStatus[i] = new TotalProjectByTeamVO();
			status_totalContract[i] = 0d;
			status_totalYearSales[i] = 0d;
			status_totalMatlCost[i] = 0d;
			status_totalProfitSales[i] = 0d;
			status_totalOutCost[i] = 0d;
			status_totalNetSales[i] = 0d;
			status_totalSalesCost[i] = 0d;
			status_totalLaborCost[i] = 0d;
			status_totalDirectCost[i] = 0d;
			status_totalLaborMM[i] = 0d;
			status_totalOutMM[i] = 0d;
			status_commonAndWaitCost[i] = 0d;
			status_totalSales[i] = 0d;
			status_totalSupport[i] = 0d;
			status_totalCost[i] = 0d;
		}
		
		
		// 해당하는 팀의 정보를 가져온다
		Map<String, String> params = new HashMap<String, String>();
		params.put("tm_year", String.valueOf(CalendarUtil.getPresentYear()));
		params.put("tm_id", tm_id);

		TeamVO teamVO = this.teamDAO.getTeamInfo(params);
		TotalProjectByTeamVO totalProjectVO = new TotalProjectByTeamVO();

		// 팀의 C급, 종결을 제외한 프로젝트를 가져온다
		projectList = this.totalDAO.getProjectListByConditions(params);
		int num=0;
		// 계약액
		double totalContract = 0d;
		// 매출액
		double totalYearSales = 0d;
		// 상품비
		double totalMatlCost = 0d;
		// 영업이익
		double totalProfitSales = 0d;
		// 외주비
		double totalOutCost = 0d;
		// 순매출액
		double totalNetSales = 0d;
		double netSalesWithoutB = 0d;// 따로 미리 가져와야함
		// (매출원가)합계
		double totalSalesCost = 0d;
		// (인건비)계
		double totalLaborCost = 0d;
		// pj직접
		double totalDirectCost = 0d;
		// 직원/외주 mm
		double totalLaborMM = 0d;
		double totalOutMM = 0d;
		// 공통,대기
		double commonAndWaitCost = 0d;
		// 영업
		double totalSales = 0d;
		// 지원
		double totalSupport = 0d;
		// 경비
		double totalCost = 0d;
		// 특정 팀의 B급을 제외한 Pj에 해당하는 순매출액 합
		double netSaleswithoutB = this.totalDAO.getNetSaleswithoutB(tm_id);
		// 회사 전체 팀의 B급을 제외한 해당하는 PJ 순매출액 합
		double totalComSaleswithoutB = this.totalDAO.getTotalComSaleswithoutB();

		resultList = new ArrayList<TotalProjectByTeamVO>();

		for (ProjectVO projectVO : projectList) {
			double contract = 0d;
			double yearSales = 0d;
			double matlCost = 0d;
			double profitSales = 0d;
			double outCost = 0d;
			double netSales = 0d;
			double pjProfitSales = 0d; // 영업이익
			double pjSalesCost = 0d;// 매출원가 합계
			double laborCost = 0d; // 인건비 계
			double directCost = 0d; // 직접비
			double laborMM = 0.0; // 직주
			double outMM = 0d; // 외주
			double waitCost = 0d;
			double commonCost = 0d;
			double salesCost = 0d;// 영업비
			double supportCost = 0d;
			double cost = 0d;// 경비

			double eachSupportCost = 0;
			double supportCommonCost = 0;

			TotalProjectByTeamVO totalVO = new TotalProjectByTeamVO();

			// 상태, 프로젝트ID, 프로젝트명, 시작일, 완료일
			totalVO.setPj_status(projectVO.getPj_status_name());
			totalVO.setPj_id(projectVO.getPj_id());
			totalVO.setPj_name(projectVO.getPj_name());
			totalVO.setPj_start_date(projectVO.getPj_start_date());
			totalVO.setPj_end_date(projectVO.getPj_end_date());
			totalVO.setPj_status(projectVO.getPj_status_name());
			// 계약기대치
			double expectationPercentage = 1.0;
			double expectationRatio = 1.0;
			if (projectVO.getPj_status_name().equals("A급")) {
				expectationPercentage = 0.9;
			} else if (projectVO.getPj_status_name().equals("B급")) {
				expectationPercentage = 0.5;
				expectationRatio = 3.5;
			}

			// 1. 계약액(0)
			contract = projectVO.getPj_amount() * expectationPercentage;
			totalVO.setTotalContract(contract);
			totalContract += contract;

			// 2. 매출액(0)
			yearSales = projectVO.getPj_year_sales() * expectationPercentage;
			totalVO.setYearSales(yearSales);
			totalYearSales += yearSales;

			// 3. 상품비(0)
			if (projectVO.getPj_status_name().equals("B급")) {
				outCost = 0;
			} else {
				matlCost = projectVO.getPj_matl_cost() * expectationPercentage;
				totalMatlCost += matlCost;
			}
			totalVO.setTotalMatlCost(matlCost);

			// 4. 외주비
			if (!(projectVO.getPj_id().contains("영업"))) {
				if (projectVO.getPj_status_name().equals("B급")) {
					outCost = 0;
				} else {
					outCost = projectVO.getPj_outsrc_cost() * expectationPercentage;
					totalOutCost += outCost;
				}
				totalVO.setTotalOutCost(outCost);
			}

			// 5. 순매출액
			if (projectVO.getPj_status_name().equals("B급")) {
				netSales = (projectVO.getPj_year_sales() - projectVO.getPj_outsrc_cost() - projectVO.getPj_matl_cost())
						* 0.5;
			} else {
				netSales = yearSales - matlCost - outCost;
			}
			totalNetSales += netSales;
			totalVO.setNetSales(netSales);

			// 6. pj직접
			int hr_mon_price = 0;
			// 해당 tm_id에 pj별 직원 List 가져오기(직원 / 외주 포함)
			List<EmployeeInputVO> employeeList = this.totalDAO.getEmployeeList(projectVO.getPj_id());
			if (!(projectVO.getPj_id().contains("공통")) && !(projectVO.getPj_id().contains("영업"))) {
				if (projectVO.getPj_status_name().equals("B급")) {
					directCost = 0;
				} else {
					directCost = projectVO.getPj_direct();
				}
				totalVO.setTotalDirectCost(directCost);
			}
			totalDirectCost += directCost; // pj 직접비 총 합

			// 7. 공통 / 대기
			List<WaitVO> WaitList = this.totalDAO.getWaitList(tm_id);
			List<EmployeeInputVO> commonList = this.totalDAO.getTmCommonCost(tm_id);

			// 'SI / 커머스 / 에너지'의 경우
			for (WaitVO wa : WaitList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("tm_id", wa.getTm_id());
				map.put("hr_name", wa.getWa_name());
				int hr_price = 0;
				if (!tm_id.equals("6M15")) {
					hr_price = this.totalDAO.getHrPrice(map);
				} else {
					hr_price = this.totalDAO.get6M15Price();
				}

				double each_MM = CalendarUtil.calculateManMonth(wa.getWa_from_date(), wa.getWa_to_date());
				waitCost += Math.round(each_MM * hr_price);

				/*
				 * System.out.println("**+**+*+*+*+*+*+*+*+*+*+*+*+*+");
				 * System.out.println("pj_id : " + wa.getTm_id());
				 * System.out.println("hr_name : " + wa.getWa_name());
				 * System.out.println("each_MM : " + each_MM);
				 * System.out.println("hr_price : " + hr_price);
				 * System.out.println("대기인건비 : " + Math.round(each_MM *
				 * hr_price));
				 */

			}
			if (!projectVO.getPj_status_name().equals("B급")) {
				int wait = (int) (Math.round((waitCost * (netSales / netSaleswithoutB)) * 10) / 10.0);
				totalVO.setCommonAndWaitCost(wait);
			}
			// '미디어 / 보안'의 경우
			
			if (commonList.size() != 0) {
				for (EmployeeInputVO common : commonList) {
					if (common.getHr_company().contains("SQI") || common.getHr_quit_date() != null) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("tm_id", common.getTm_id());
						map.put("hr_name", common.getPd_name());
						int hr_price = this.totalDAO.getHrPrice(map);
						commonCost += Math.round(common.getPd_mm() * hr_price);
						/*
						 * System.out.println("pj_id : " + common.getPj_id());
						 * System.out.println("hr_name : " +
						 * common.getPd_name()); System.out.println(
						 * "common.getPd_mm() : " + common.getPd_mm());
						 * System.out.println("hr_price : " + hr_price);
						 * System.out.println("공통인건비 : " +
						 * Math.round(common.getPd_mm() * hr_price));
						 */
					}
				}
				int common = 0;
				if (!projectVO.getPj_status_name().equals("B급")) {
					if (!(projectVO.getPj_id().contains("공통"))) {
						//System.out.println("***"+commonCost);
						common = (int) (Math.round((commonCost * (netSales / netSaleswithoutB)) * 10) / 10.0);
						totalVO.setCommonAndWaitCost(common);
					}else{
						/*System.out.println(projectVO.getPj_id() + " : ");
						System.out.println("순매출액 : "+ netSales);*/
					}
				}
				
			}
			commonAndWaitCost = waitCost + commonCost;

			// 8. 영업
			List<EmployeeInputVO> salesList = this.totalDAO.getDeployList(tm_id); // 팀
																					// 영업
			if (!projectVO.getPj_status_name().equals("B급")) { // B급인 경우 인건비 = 0
				for (EmployeeInputVO sales : salesList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("tm_id", sales.getTm_id());
					map.put("hr_name", sales.getPd_name());
					int hr_price = 0;
					if (!tm_id.equals("6M15")) {
						hr_price = this.totalDAO.getHrPrice(map);
					} else {
						hr_price = this.totalDAO.get6M15Price();
					}
					salesCost += Math.round(sales.getPd_mm() * hr_price);

					/*
					 * System.out.println("**+**+*+*+*+*+*+*+*+*+*+*+*+*+");
					 * System.out.println("hr_name : " + sales.getPd_name());
					 * System.out.println("hr_price : " + hr_price);
					 * System.out.println("sales.getPd_mm() : " +
					 * sales.getPd_mm()); System.out.println("공통인건비 : " +
					 * Math.round(sales.getPd_mm() * hr_price));
					 */
				}
				totalVO.setTotalSales((int) (Math.round((salesCost * (netSales / netSaleswithoutB)) * 10) / 10.0));
				totalSales = salesCost;
			}

			// 9. 지원
			List<EmployeeInputVO> supportList = this.totalDAO.getSupportList();
			for (EmployeeInputVO support : supportList) {
				if (support.getHr_company().contains("SQI") || support.getHr_company().equals("")) {
					int manageMonPrice = this.totalDAO.getManageMonPrice();
					eachSupportCost += Math.round(support.getPd_mm() * manageMonPrice);
				}
			}
			
			supportCommonCost = (Math.round((eachSupportCost) * (netSaleswithoutB / totalComSaleswithoutB)) * 10)
					/ 10.0; // 지원공통비
			
			// System.out.println("*** : " + eachSupportCost);
			/*System.out.println("**+**+*+*+*+*+*+*+*+*+*+*+*+*+");
			 System.out.println("netSaleswithoutB : " + netSaleswithoutB);
			 System.out.println("totalComSaleswithoutB : " + totalComSaleswithoutB);*/
			 
			if (!tm_id.equals("6M15")) {
				totalSupport = supportCommonCost;
				if (!(projectVO.getPj_id().contains("공통") && !projectVO.getPj_id().contains("영업"))) {
					if (!projectVO.getPj_status_name().equals("B급")) {
						supportCost = Math.round((supportCommonCost * (netSales / netSaleswithoutB)) * 10) / 10.0;
						totalVO.setTotalSupport(supportCost);
					}
				}
			}

			// 10. 경비 if (!projectVO.getPj_status_name().equals("B급")) {
			double sumCost = 0d;
			if (projectVO.getPj_status_name().equals("B급")) {
				sumCost = 0;
			} else {
				if (!tm_id.equals("6M15")) {
					if (!(projectVO.getPj_id().contains("공통") && !projectVO.getPj_id().contains("영업"))) {
						// pj 경비 = (매출액 * tm 변동률)/100 + 추가경비 + pj간접경비(팀+전사)
						double tm_expnc_rate = this.totalDAO.getTmExpncRate(tm_id);
						double pj_cost = (projectVO.getPj_year_sales() * tm_expnc_rate) / 100
								+ projectVO.getPj_extra_cost();
						// ③ 간접(경비) = 경영지원팀 경비 * (tm B급 제외 / 총 tm B급 제외 순매출)
						double indirect = getExpenseManage_part() * (netSaleswithoutB / totalComSaleswithoutB);
						// ② 간접경비(팀/전사) = ③ + 고정(팀공통)
						double tmIndirectCost = indirect + this.totalDAO.getTmIndExpense(tm_id);
						// ① 간접 경비 = ② * (pj 순매출액 / tm B급 제외 순 매출액)
						double indirectCost = tmIndirectCost * (netSales / netSaleswithoutB);
						sumCost = Math.round(pj_cost + indirectCost);
						totalCost += sumCost;
					}
				} else {
					sumCost = projectVO.getPj_extra_cost();
					totalCost += sumCost;
				}

				/*
				 * System.out.println(
				 * "==========================================================="
				 * ); System.out.println("pj_id : " + projectVO.getPj_id());
				 * System.out.println("pj_cost : " + pj_cost);
				 * System.out.println("getExpenseManage_part()경영지원팀 : " +
				 * getExpenseManage_part()); System.out.println(
				 * "netSaleswithoutB : " + netSaleswithoutB);
				 * System.out.println("totalComSaleswithoutB : " +
				 * totalComSaleswithoutB); System.out.println("팀고정(공통) : " +
				 * this.totalDAO.getTmIndExpense(tm_id)); System.out.println(
				 * "간접 경비 : " + indirectCost); System.out.println("sumCost : " +
				 * sumCost); System.out.println("totalCost : " + totalCost);
				 */

			}
			totalVO.setTotalCost(sumCost);

			// 직원MM
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tm_id", tm_id);
			map.put("pj_id", projectVO.getPj_id());

			laborMM = this.totalDAO.getLaborMM(map);

			double waitLaborMM = 0d;
			if (projectVO.getPj_id().contains("영업")) {
				// 대기,미배치 MM도 같이 더해줌
				List<WaitVO> waitLabor = this.totalDAO.getWaitLaborMM(tm_id);
				for (int i = 0; i < waitLabor.size(); i++) {
					waitLaborMM += CalendarUtil.calculateManMonth(waitLabor.get(i).getWa_from_date(),
							waitLabor.get(i).getWa_to_date());
				}
				laborMM += waitLaborMM;
			}
			/*
			 * System.out.println("==================================");
			 * System.out.println("pj_id : " + projectVO.getPj_id());
			 * System.out.println("waitLaborMM : " + waitLaborMM);
			 */
			totalVO.setTotalLaborMM(laborMM);
			totalLaborMM += laborMM;

			// 외주MM
			outMM = this.totalDAO.getOutMM(map);
			totalVO.setTotalOutMM(outMM);
			totalOutMM += outMM;

			// 인건비 계
			laborCost = totalVO.getTotalDirectCost() + totalVO.getCommonAndWaitCost() + totalVO.getTotalSales()
					+ totalVO.getTotalSupport() + totalVO.getTotalOutCost();
			totalVO.setTotalLaborCost(laborCost);

			// 영업이익
			if (projectVO.getPj_status_name().equals("B급")) {
				pjProfitSales = (yearSales * 3.5) / 100;
				pjSalesCost = yearSales - pjProfitSales;
				totalSalesCost += pjSalesCost;
				totalVO.setProfitSales(pjProfitSales);
				totalVO.setTotalSalesCost(pjSalesCost);
			} else {
				pjSalesCost = laborCost + totalVO.getTotalMatlCost() + totalVO.getTotalCost();
				pjProfitSales = yearSales - pjSalesCost;
				totalVO.setProfitSales(pjProfitSales);
				totalVO.setTotalSalesCost(pjSalesCost);
			}

			if (!(projectVO.getPj_id().contains("공통")) && !(projectVO.getPj_id().contains("영업"))) {
				resultList.add(totalVO);
			}
			
			
			//각 상태별 손익 합계 저장
			if(projectVO.getPj_status_name().equals("이월")){
				num=0;
			}else if(projectVO.getPj_status_name().equals("완료")){
				num=1;
			}else if(projectVO.getPj_status_name().equals("대기")){
				num=2;
			}else if(projectVO.getPj_status_name().equals("A급")){
				num=3;
			}if(projectVO.getPj_status_name().equals("B급")){
				num=4;
			}
			
			
			status_totalContract[num] += (int)contract;
			status_totalYearSales[num] += (int)yearSales;
			status_totalNetSales[num] += (int)netSales;
			status_totalProfitSales[num] += (int)pjProfitSales;
			status_totalSalesCost[num] += (int)pjSalesCost;
			status_totalLaborCost[num] += (int)laborCost;
			status_totalDirectCost[num] += (int)directCost;
			if(commonAndWaitCost != projectByStatus[num].getCommonAndWaitCost())
				status_commonAndWaitCost[num] += (int)commonAndWaitCost;
			if(salesCost != projectByStatus[num].getTotalSales())
				status_totalSales[num] += (int)salesCost;
			status_totalSupport[num] += (int)supportCost;
			status_totalOutCost[num] += (int)outCost;
			status_totalMatlCost[num] += (int)matlCost;
			status_totalCost[num] += (int)sumCost;
			
			status_totalLaborMM[num] += laborMM;
			status_totalOutMM[num] += outMM;
			
			if(num==4){
				status_commonAndWaitCost[4] = 0;
			}
			
			projectByStatus[num].setTotalContract(status_totalContract[num]);
			projectByStatus[num].setYearSales(status_totalYearSales[num]);
			projectByStatus[num].setNetSales(status_totalNetSales[num]);
			projectByStatus[num].setProfitSales(status_totalProfitSales[num]);
			projectByStatus[num].setTotalMatlCost(status_totalMatlCost[num]);
			projectByStatus[num].setTotalOutCost(status_totalOutCost[num]);
			projectByStatus[num].setTotalSalesCost(status_totalSalesCost[num]);
			projectByStatus[num].setTotalLaborCost(status_totalLaborCost[num]);
			projectByStatus[num].setTotalDirectCost(status_totalDirectCost[num]);
			projectByStatus[num].setCommonAndWaitCost(status_commonAndWaitCost[num]);
			projectByStatus[num].setTotalSales(status_totalSales[num]);
			projectByStatus[num].setTotalSupport(status_totalSupport[num]);
			projectByStatus[num].setTotalCost(status_totalCost[num]);
			projectByStatus[num].setTotalLaborMM(status_totalLaborMM[num]);
			projectByStatus[num].setTotalOutMM(status_totalOutMM[num]);
			
			
			
		}
		totalLaborCost = totalDirectCost + commonAndWaitCost + totalSales + totalSupport + totalOutCost;
		totalSalesCost += (totalLaborCost + totalCost + totalMatlCost);
		totalProfitSales = totalYearSales - totalSalesCost;

		totalProjectVO.setTm_id(tm_id);
		totalProjectVO.setTotalContract(totalContract); // 전체계약액
		totalProjectVO.setYearSales(totalYearSales); // 전체 매출액
		totalProjectVO.setNetSales(totalNetSales); // 전체 순매출액
		totalProjectVO.setProfitSales(totalProfitSales);// 전체 영업 이익
		totalProjectVO.setTotalMatlCost(totalMatlCost); // 전체 상품비
		totalProjectVO.setTotalOutCost(totalOutCost); // 전체 외주비
		totalProjectVO.setTotalSalesCost(totalSalesCost); // 전체 합계
		totalProjectVO.setTotalLaborCost(totalLaborCost); // 인건비 계
		totalProjectVO.setTotalDirectCost(totalDirectCost); // 전체 pj_직접
		totalProjectVO.setCommonAndWaitCost(commonAndWaitCost); // 전체 공통/대기
		totalProjectVO.setTotalSales(totalSales); // 전체 영업
		totalProjectVO.setTotalSupport(totalSupport); // 전체 지원
		totalProjectVO.setTotalCost(totalCost); // 전체 경비
		totalProjectVO.setTotalLaborMM(totalLaborMM);// 전체 직원MM
		totalProjectVO.setTotalOutMM(totalOutMM);// 전체 외주MM
		/*
		 * System.out.println("setTotalLaborMM : " +
		 * totalProjectVO.getTotalLaborMM()); System.out.println(
		 * "setTotalOutMM : " + totalProjectVO.getTotalOutMM());
		 */

		// 팀 손익정보->총괄표로 update
		String currentWeek = CalendarUtil.getPresentWeek();
		System.out.println("**********************************************************" + currentWeek);
		totalProjectVO.setCurrentWeek(currentWeek);
		totalDAO.updateTotalCost(totalProjectVO);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultList", resultList);
		resultMap.put("totalSumList", totalProjectVO);

		return resultMap;
	}

	@Override
	public TotalProjectByTeamVO getProjectBudgetInfoByProject(String pj_id) {
		PjBudgetInfoVO pbiv = new PjBudgetInfoVO();
		for(int i=0; i<resultList.size(); i++){
			if(resultList.get(i).getPj_id().equals(pj_id)){
				double profitSales = resultList.get(i).getProfitSales();
				resultList.get(i).setProfitSales((int)profitSales);
				return resultList.get(i);
			}
		}
		return null;
	}

	@Override
	public TotalProjectByTeamVO getProjectListbyChecked(int num) {
		return projectByStatus[num-1];
	}
	
	
	//목표 계약, 매출, 순매출, 이익 구하기(게이지에 사용됨)
	@Override
	public GageGoalVO getGageGoal() {
		return this.totalDAO.getGageGoal();
	}
	//실제 계약, 매출, 순매출, 이익 구하기(게이지에 사용됨)
	@Override
	public GageRealVO getGageReal() {
		String currentWeek = CalendarUtil.getPresentWeek();
		return this.totalDAO.getGageReal(currentWeek);
	}




}
