package com.sqisoft.iqs.team.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project.vo.PjBudgetInfoVO;
import com.sqisoft.iqs.project.vo.PjBudgetVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.vo.GageGoalVO;
import com.sqisoft.iqs.team.vo.GageRealVO;
import com.sqisoft.iqs.team.vo.TotalProjectByTeamVO;
import com.sqisoft.iqs.team.vo.TotalTeamVO;
import com.sqisoft.iqs.team.vo.TotalWeekReportVO;
import com.sqisoft.iqs.team.vo.WeekChartVO;


public interface TotalService {
	public Map<String, TotalTeamVO> getTotalChart();

	public void insertWeekReport();
	
	public List<String> getWeekList();

	
	public WeekChartVO getWeekChart(String tm_id);
	
	public Map<String, Object> getWeekReport(String searchYear, String lastWeek);

	public void getEmployWait(String b4_pd_name, String pd_name);

	public void insertWaitInfo(String hr_name, int year);

	public TotalProjectByTeamVO getProjectBudgetInfoByProject(String pj_id);

	public TotalProjectByTeamVO getProjectListbyChecked(int num);

	public Map<String, Object> getProjectBudgetInfo(String tm_id);
	//목표 계약, 매출, 순매출 구하기 
	public GageGoalVO getGageGoal();
	//실제 계약, 매출, 순매출 구하기
	public GageRealVO getGageReal();

}
