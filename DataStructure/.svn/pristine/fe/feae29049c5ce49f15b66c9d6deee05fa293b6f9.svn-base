package com.sqisoft.iqs.hr.outsal.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.outsal.dao.OutSalHistoryDAO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public class OutSalHistoryDAOImpl extends SqlSessionDaoSupport implements OutSalHistoryDAO {

	@Override
	public List<OutSal_historyVO> getHistoryList(String name) {
		return getSqlSession().selectList("outSalHistoryDao.getHistoryList", name);
	}

	@Override
	public void deleteHistory(OutSal_historyVO vo) {
		getSqlSession().delete("outSalHistoryDao.deleteHistory", vo);
	}

	@Override
	public OutSal_historyVO getHistory(String name) {
		return getSqlSession().selectOne("outSalHistoryDao.getHistory", name);
	}

	@Override
	public void deleteHistoryAll(String name) {
		getSqlSession().delete("outSalhistoryDao.deleteHistoryAll", name);
	}

	@Override
	public OutSal_historyVO getOutSalHistory(PjHistoryVO vo) {
		return getSqlSession().selectOne("outSalHistoryDao.getOutSalHistory", vo);
	}

	@Override
	public PjHistoryVO checkHistory(OutSal_historyVO vo) {
		return getSqlSession().selectOne("outSalhistoryDao.checkHistory", vo);
	}

	@Override
	public void insertPjhistory(PjHistoryVO vo) {
		getSqlSession().insert("outSalhistoryDao.insertPjhistory", vo);
	}

	@Override
	public void deletePjhistory(PjHistoryVO vo) {
		getSqlSession().delete("outSalhistoryDao.deletePjhistory", vo);
	}

	@Override
	public int checkOutHis(OutSal_historyVO vo) {
		return getSqlSession().selectOne("outSalhistoryDao.checkOutHis", vo);
	}

	@Override
	public void out_hisUpdate(OutSal_historyVO vo) {
		getSqlSession().update("outSalhistoryDao.out_hisUpdate", vo);
	}

	@Override
	public int checkClear(String name) {
		return getSqlSession().selectOne("outSalhistoryDao.checkClear", name);
	}

	@Override
	public void adjustSal(String name) {
		getSqlSession().update("outSalhistoryDao.adjustSal", name);
	}

}
