package com.sqisoft.iqs.pf.team.dao;

import java.util.List;

import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.DistribVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;
import com.sqisoft.iqs.pf.vo.TeamVO;

public interface TeamDAO {
	public abstract List<TeamVO> getTeamList();
	public abstract void teamInsert(TeamVO vo);
	public abstract TeamVO getTeam(String team_id);
	public abstract void teamUpdate(TeamVO vo);
	public abstract DistribVO getDistrib();
	public abstract List<BudgetVO> getBudgetList();
	public abstract void updateDistrib(DistribVO vo);
//	public abstract List<EmplVO> getEmplList();     // serviceImpl에서 미사용중(주석처리되어있음)
	public abstract BudgetVO getBudgetCost(String pj_id);
	public abstract void updateBudgetCost(BudgetVO vo);
	public abstract int teamExist(String team_id);
	public abstract void teamDelete(String team_id);
//	public abstract PjEmplCostVO getPjEmplCost(String pj_id);   // DAO와 쿼리만 존재
	public abstract List<PjHistoryVO> getPjHistoryList();
	public abstract List<PjHistoryVO> getDistribCostList();
	public abstract PjHistoryVO getPjHistory(PjHistoryVO vo);
//	public abstract void insertPjHistory(PjHistoryVO vo);
	public abstract void updatePjHistory(PjHistoryVO vo);
	public abstract List<PjHistoryVO> getPjHistoryListByName(String name);
	public abstract void deletePjHistoryWaiting(String name);
	public abstract List<PjHistoryVO> getPjHistoryListByPJID(String pj_id);
	public abstract void deletePjHistory(PjHistoryVO vo);
	public abstract List<PjHistoryVO> getWaitingList();
	public abstract List<PjHistoryVO> getNoPlaceList();
	
	
	public abstract void teamCommonUpdate(TeamVO vo);
	
	public abstract List<PjHistoryVO> salSearch(PjpostingVO vo);
}