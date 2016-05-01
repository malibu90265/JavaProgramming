package com.sqisoft.iqs.hr.outsal.dao;

import java.util.List;

import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public interface OutSalHistoryDAO {
	abstract public List<OutSal_historyVO> getHistoryList(String name);
	abstract public void deleteHistory(OutSal_historyVO vo);
	abstract public OutSal_historyVO getHistory(String name);
	abstract public void deleteHistoryAll(String name);
	abstract OutSal_historyVO getOutSalHistory(PjHistoryVO vo);

	public abstract PjHistoryVO checkHistory(OutSal_historyVO vo);

	public abstract void insertPjhistory(PjHistoryVO vo);
	public abstract void deletePjhistory(PjHistoryVO vo);
	
	public abstract int checkOutHis(OutSal_historyVO vo);
	public abstract void out_hisUpdate(OutSal_historyVO vo);
	public abstract int checkClear(String name);
	public abstract void adjustSal(String name);
}
