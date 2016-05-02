package com.sqisoft.iqs.pf.team.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.team.dao.TeamDAO;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.DistribVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;
import com.sqisoft.iqs.pf.vo.TeamVO;

public class TeamDAOImpl extends SqlSessionDaoSupport implements TeamDAO {

	@Override
	public List<TeamVO> getTeamList() {
		return getSqlSession().selectList("teamDAO.getTeamList");
	}

	@Override
	public void teamInsert(TeamVO vo) {
		getSqlSession().insert("teamDAO.teamInsert", vo);
	}

	@Override
	public TeamVO getTeam(String team_id) {
		return getSqlSession().selectOne("teamDAO.getTeam", team_id);
	}

	@Override
	public void teamUpdate(TeamVO vo) {
		getSqlSession().update("teamDAO.teamUpdate", vo);
	}

	@Override
	public DistribVO getDistrib() {
		return getSqlSession().selectOne("teamDAO.getDistrib");
	}

	@Override
	public List<BudgetVO> getBudgetList() {
		return getSqlSession().selectList("teamDAO.getBudgetList");
	}

	@Override
	public void updateDistrib(DistribVO vo) {
		getSqlSession().update("teamDAO.updateDistrib", vo);
	}

	@Override
	public BudgetVO getBudgetCost(String pj_id) {
		return getSqlSession().selectOne("teamDAO.getBudgetCost", pj_id);
	}

	@Override
	public void updateBudgetCost(BudgetVO vo) {
		getSqlSession().update("teamDAO.updateBudgetCost", vo);
	}

	@Override
	public int teamExist(String team_id) {
		return getSqlSession().selectOne("teamDAO.teamExist", team_id);
	}

	@Override
	public void teamDelete(String team_id) {
		getSqlSession().delete("teamDAO.teamDelete", team_id);
	}

	@Override
	public List<PjHistoryVO> getPjHistoryList() {
		return getSqlSession().selectList("teamDAO.getPjHistoryList");
	}

	@Override
	public List<PjHistoryVO> getDistribCostList() {
		return getSqlSession().selectList("teamDAO.getDistribCostList");
	}

	@Override
	public PjHistoryVO getPjHistory(PjHistoryVO vo) {
		return getSqlSession().selectOne("teamDAO.getPjHistory", vo);
	}

	@Override
	public void updatePjHistory(PjHistoryVO vo) {
		getSqlSession().update("teamDAO.updatePjHistory", vo);
	}

	@Override
	public List<PjHistoryVO> getPjHistoryListByName(String name) {
		return getSqlSession().selectList("teamDAO.getPjHistoryListByName", name);
	}

	@Override
	public void deletePjHistoryWaiting(String name) {
		getSqlSession().delete("teamDAO.deletePjHistoryWaiting", name);
	}

	@Override
	public List<PjHistoryVO> getPjHistoryListByPJID(String pj_id) {
		return getSqlSession().selectList("teamDAO.getPjHistoryListByPJID", pj_id);
	}

	@Override
	public void deletePjHistory(PjHistoryVO vo) {
		getSqlSession().delete("teamDAO.deletePjHistory", vo);
	}

	@Override
	public List<PjHistoryVO> getWaitingList() {
		return getSqlSession().selectList("teamDAO.getWaitingList");
	}

	@Override
	public List<PjHistoryVO> getNoPlaceList() {
		return getSqlSession().selectList("teamDAO.getNoPlaceList");
	}

	@Override
	public void teamCommonUpdate(TeamVO vo) {
		getSqlSession().update("teamDAO.teamCommonUpdate", vo);
	}

	@Override
	public List<PjHistoryVO> salSearch(PjpostingVO vo) {
		return getSqlSession().selectList("teamDAO.salSearch", vo);
	}

}
