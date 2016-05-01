package com.sqisoft.iqs.pf.team.service;

import java.util.List;

import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.DistribVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;
import com.sqisoft.iqs.pf.vo.TeamVO;
import com.sqisoft.iqs.pf.vo.TotalVO;
import com.sqisoft.iqs.pf.vo.WeekChartVO;

public interface TeamServiceIF {
	public abstract List<TeamVO> getTeamList();
	public abstract void teamInsert(TeamVO vo);
	public abstract TeamVO getTeam(String team_id);
	public abstract void teamUpdate(TeamVO vo);
	public abstract DistribVO getDistrib();
	public abstract void updateDistrib(DistribVO vo);
	public abstract List<BudgetVO> getBudgetInfoList();
	public abstract List<BudgetVO> getTeamBudgetInfoList(String team_id);
	public abstract TotalVO getTotal();
	public abstract BudgetVO getBudgetCost(String pj_id);
	public abstract void updateBudgetCost(BudgetVO vo);
	public abstract TeamVO getTeamForChart(String team_id);
	public abstract List<WeekChartVO> getWeekChartList(String team_id);
	public abstract int teamExist(String team_id);
	public abstract void teamDelete(String team_id);
	public abstract List<PjHistoryVO> salSearch(PjpostingVO vo);
//	public abstract void insertPjHistory(PjHistoryVO vo);
	
	
}