package com.sqisoft.iqs.team.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
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

public class TotalDAOImpl extends SqlSessionDaoSupport implements TotalDAO {

	/* 새로 만드는 계산식 */
	@Override
	public int getTotalNetSalesWithoutB() {
		return getSqlSession().selectOne("totalDAO.getTotalNetSalesWithoutB");
	}

	@Override
	public CostAndMMVO getCostAndMMFromDeploy(Map<String, String> deployParams) {
		return getSqlSession().selectOne("totalDAO.getCostAndMMFromDeploy",
				deployParams);
	}

	@Override
	public void updateAllProject(TotalVO totalVO) {
		getSqlSession().update("totalDAO.updateAllProject", totalVO);
	}

	/* 총괄표 */
	@Override
	public List<ProjectVO> getProjectListByConditions(Map<String, String> params) {
		return getSqlSession().selectList(
				"totalDAO.getProjectListByConditions", params);
	}

	@Override
	public PjBudgetVO getBudgetList(String pj_id) {
		return getSqlSession().selectOne("totalDAO.getBudgetList", pj_id);
	}

	@Override
	public List<EmployeeInputVO> getCommonHRList(String pj_id) {
		return getSqlSession().selectList("totalDAO.getCommonHRList", pj_id);
	}

	@Override
	public List<String> getWeekList() {
		return getSqlSession().selectList("totalDAO.getWeekList");
	}

	/* 전주대비표 */
	@Override
	public void insertTeamWeekReport(TotalVO totalVO) {
		getSqlSession().insert("totalDAO.insertTeamWeekReport", totalVO);
	}

	@Override
	public List<TotalVO> getWeekReportList(Map<String, String> params) {
		return getSqlSession().selectList("totalDAO.getWeekReportList", params);
	}

	@Override
	public TotalVO getWeekReport(Map<String, String> params) {
		return getSqlSession().selectOne("totalDAO.getWeekReport", params);
	}

	//
	@Override
	public List<WeekChartTotalVO> getWeekChartList(Map<String, String> params) {
		return getSqlSession().selectList("totalDAO.getWeekChartList", params);
	}

	@Override
	public WeekLogVO getWeekLogReportVO() {
		return getSqlSession().selectOne("totalDAO.getWeekLogReportVO");
	}

	/* 팀별손익정보 */
	@Override
	public List<ProjectVO> getProjectListByTeamId(String tm_id) {
		return getSqlSession().selectList("totalDAO.getProjectListByTeamId",
				tm_id);
	}

	@Override
	public List<EmployeeInputVO> getDeployList(String tm_id) {
		return getSqlSession().selectList("totalDAO.getDeployList", tm_id);
	}

	// 사업팀 총 순매출액
	public List<PjBudgetVO> getProjectList(String tm_id) {
		return getSqlSession().selectList("totalDAO.getProjectList", tm_id);
	}

	@Override
	public List<HumanResourceVO> getTeamPersonList(String tm_id) {
		return getSqlSession().selectList("totalDAO.getTeamPersonList", tm_id);
	}

	@Override
	public int getPersonUprice(Map<String, Object> params) {
		return getSqlSession().selectOne("totalDAO.getPersonUprice", params);
	}

	// 모든 사업팀의 순매출액 결과
	@Override
	public int getAllTeamNetSalesWithoutC(Map<String, String> params) {
		return getSqlSession().selectOne("totalDAO.getAllTeamNetSalesWithoutC",
				params);
	}

	@Override
	public List<DeployMapVO> getPjDeployList(Map<String, Object> params) {
		return getSqlSession().selectList("totalDAO.getPjDeployList", params);
	}

	@Override
	public HumanResourceVO getHumanInfo(String hr_name) {
		return getSqlSession().selectOne("totalDAO.getHumanInfo", hr_name);
	}

	@Override
	public void insertPjWaitInfo(Map<String, Object> params) {
		getSqlSession().insert("totalDAO.insertPjWaitInfo", params);
	}

	@Override
	public String getTm_id(Map<String, Object> params) {
		return getSqlSession().selectOne("totalDAO.getTm_id", params);
	}

	@Override
	public void deletPjDeploy(String b4_hr_name) {
		getSqlSession().delete("totalDAO.deletePjWaitInfo", b4_hr_name);
	}

	@Override
	public List<WaitVO> getWaitList(String tm_id) {
		return getSqlSession().selectList("totalDAO.getWaitList", tm_id);
	}

	@Override
	public int getHrPrice(Map<String, Object> map) {
		return getSqlSession().selectOne("totalDAO.getHrPrice", map);
	}

	// 회사 전체 팀의 순매출액
	@Override
	public int getTotalComNetSalesWithB() {
		return getSqlSession().selectOne("totalDAO.getTotalComNetSalesWithB");
	}

	// 회사 전체 팀의 B급을 제외한 해당하는 PJ 순매출액 합
	@Override
	public int getTotalComSaleswithoutB() {
		return getSqlSession().selectOne("totalDAO.getTotalComSaleswithoutB");
	}

	// 특정 팀의 B급 PJ에 해당하는 순매출액 합
	@Override
	public int getNetSalesWithB(String tm_id) {
		int result = getSqlSession().selectOne("totalDAO.getNetSalesWithB",
				tm_id);
		return result;
	}

	// 특정 팀의 B급을 제외한 PJ에 해당하는 순매출액 합
	@Override
	public int getNetSaleswithoutB(String tm_id) {
		return getSqlSession().selectOne("totalDAO.getNetSaleswithoutB", tm_id);
	}

	// 경영지원팀의 공통경비
	@Override
	public int getExpenseManage_part() {
		return getSqlSession().selectOne("totalDAO.getExpenseManage_part");
	}

	@Override
	public List<EmployeeInputVO> getSupportList() {
		return getSqlSession().selectList("totalDAO.getSupportList");
	}

	// 경영지원팀 평균 단가
	@Override
	public int getManageMonPrice() {
		return getSqlSession().selectOne("totalDAO.getManageMonPrice");
	}

	// 외주 MM, 인건비 || 직원 MM, 인건비 (if문으로 나눠서 계산)
	@Override
	public List<EmployeeInputVO> getEmployeeList(String pj_id) {
		return getSqlSession().selectList("totalDAO.getEmployeeList", pj_id);
	}

	@Override
	public double getEachManMonth(Map<String, Object> params) {
		return getSqlSession().selectOne("totalDAO.getEachManMonth", params);
	}

	@Override
	public List<EmployeeInputVO> getTmCommonCost(String tm_id) {
		return getSqlSession().selectList("totalDAO.getTmCommonCost", tm_id);
	}

	@Override
	public double getHrUprice(Map<String, String> map) {
		return getSqlSession().selectOne("totalDAO.getHrUprice", map);
	}

	@Override
	public double getTmExpncRate(String tm_id) {
		return getSqlSession().selectOne("totalDAO.getTmExpncRate", tm_id);
	}

	@Override
	public double getTmIndExpense(String tm_id) {
		return getSqlSession().selectOne("totalDAO.getTmIndExpense", tm_id);
	}

	@Override
	public double getLaborMM(Map<String, Object> map) {
		return getSqlSession().selectOne("totalDAO.getLaborMM", map);
	}

	@Override
	public double getOutMM(Map<String, Object> map) {
		return getSqlSession().selectOne("totalDAO.getOutMM", map);
	}

	// 20151101 박정현 추가
	@Override
	public totalChartVO getTotalChart(String tm_id) {
		totalChartVO tv = getSqlSession().selectOne("totalDAO.getTotalChart", tm_id);
		return tv;
	}

	@Override
	public int get6M15Price() {
		return getSqlSession().selectOne("totalDAO.getManageMonPrice");
	}

	@Override
	public List<WaitVO> getWaitLaborMM(String tm_id) {
		return getSqlSession().selectList("totalDAO.getWaitList", tm_id);
	}

	@Override
	public void updateTotalCost(TotalProjectByTeamVO totalProjectVO) {
		getSqlSession().insert("totalDAO.updateTotalCost", totalProjectVO);
	}

	@Override
	public List<WeekChartTotalVO> getTotalWeekChartList() {
		return getSqlSession().selectList("totalDAO.getTotalWeekChartList");
	}
	
	//목표 계약액, 매출, 순매출
	@Override
	public GageGoalVO getGageGoal() {
		return getSqlSession().selectOne("totalDAO.getGageGoal");
	}
	//실제 계약액, 매출, 순매출, 이익
	@Override
	public GageRealVO getGageReal(String currentWeek) {
		return getSqlSession().selectOne("totalDAO.getGageReal", currentWeek);
	}
}