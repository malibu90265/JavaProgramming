package com.sqisoft.iqs.team.dao;
 
import java.util.List;
import java.util.Map;
 





import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.project.vo.PjBudgetVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.vo.CostAndMMVO;
import com.sqisoft.iqs.team.vo.GageGoalVO;
import com.sqisoft.iqs.team.vo.GageRealVO;
import com.sqisoft.iqs.team.vo.TotalProjectByTeamVO;
import com.sqisoft.iqs.team.vo.TotalVO;
import com.sqisoft.iqs.team.vo.WaitVO;
import com.sqisoft.iqs.team.vo.WeekChartTotalVO;
import com.sqisoft.iqs.team.vo.WeekLogVO;
import com.sqisoft.iqs.team.vo.totalChartVO;
 
public interface TotalDAO {
 
	/* 새로 만드는 계산식 */
	public int getTotalNetSalesWithoutB();
 
	public CostAndMMVO getCostAndMMFromDeploy(Map<String, String> deployParams);
 
	public void updateAllProject(TotalVO totalVO);
 
	public List<ProjectVO> getProjectListByConditions(Map<String, String> params);
 
	public PjBudgetVO getBudgetList(String pj_id);
 
	public List<EmployeeInputVO> getCommonHRList(String pj_id);
 
	public List<String> getWeekList();
 
	public void insertTeamWeekReport(TotalVO totalVO);
 
	public List<TotalVO> getWeekReportList(Map<String, String> params);
 
	public TotalVO getWeekReport(Map<String, String> params);
 
	public List<ProjectVO> getProjectListByTeamId(String tm_id);
 
	public List<WeekChartTotalVO> getWeekChartList(Map<String, String> params);
 
	public WeekLogVO getWeekLogReportVO();
 
	public List<EmployeeInputVO> getDeployList(String tm_id);
 
	public List<PjBudgetVO> getProjectList(String tm_id);
 
	public List<HumanResourceVO> getTeamPersonList(String tm_id);
 
	public int getAllTeamNetSalesWithoutC(Map<String, String> params);
 
	public int getPersonUprice(Map<String, Object> params);
 
	public List<DeployMapVO> getPjDeployList(Map<String, Object> params);
 
	public HumanResourceVO getHumanInfo(String hr_name);
 
	public void insertPjWaitInfo(Map<String, Object> params);
 
	public String getTm_id(Map<String, Object> params);
 
	void deletPjDeploy(String b4_hr_name);
 
	public List<WaitVO> getWaitList(String tm_id);
 
	public int getHrPrice(Map<String, Object> map);
 
	// 회사 전체 팀의 B급 순매출액 합
	public int getTotalComNetSalesWithB();
 
	// 회사 전체 팀의 B급을 제외한 해당하는 PJ 순매출액 합
	public int getTotalComSaleswithoutB();
 
	// 특정 팀의 B급에 해당하는 PJ 순매출액 합
	public int getNetSalesWithB(String tm_id);
 
	// 특정 팀의 B급을 제외한 PJ에 해당하는 순매출액 합
	public int getNetSaleswithoutB(String tm_id);
 
	// 경영지원팀의 공통경비
	public int getExpenseManage_part();
 
	// 지원(인건비) 전사공통팀의 총 MM 합계
	public List<EmployeeInputVO> getSupportList();
 
	// 경영지원팀 평균 단가
	public int getManageMonPrice();
 
	// 외주 MM, 인건비 || 직원 MM, 인건비 (if문으로 나눠서 계산)
	public List<EmployeeInputVO> getEmployeeList(String pj_id);
 
	// 각각 사람의 MM
	public double getEachManMonth(Map<String, Object> params);
 
	// 공통 인건비를 가져오는 부분
	public List<EmployeeInputVO> getTmCommonCost(String tm_id);
 
	// 팀에 해당하는 직급단가 가져오기
	public double getHrUprice(Map<String, String> map);
 
	public double getTmExpncRate(String tm_id);
 
	public double getTmIndExpense(String tm_id);
 
	public double getLaborMM(Map<String, Object> map);
 
	public double getOutMM(Map<String, Object> map);
	
	public totalChartVO getTotalChart(String tm_id);

	public int get6M15Price();

	public List<WaitVO> getWaitLaborMM(String tm_id);

	public void updateTotalCost(TotalProjectByTeamVO totalProjectVO);

	public List<WeekChartTotalVO> getTotalWeekChartList();
	//목표  계약액, 매출, 순매출, 이익 구하기
	public GageGoalVO getGageGoal();
	//실제 계약액, 매출, 순매출, 이익 구하기
	public GageRealVO getGageReal(String currentWeek);

 
}