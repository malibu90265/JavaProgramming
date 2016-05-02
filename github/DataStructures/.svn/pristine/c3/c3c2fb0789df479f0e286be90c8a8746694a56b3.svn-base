package com.sqisoft.iqs.project.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project.vo.PjBudgetVO;

public interface PjBudgetService {

	public List<PjBudgetVO> getSelectedBudgetList(String pj_id);
	
	public List<PjBudgetVO> getProjectBudgetList(Map<String, Object> params);

	public PjBudgetVO getCalculatedBudgetResult(String pj_id);
	
	public boolean checkDuplicateYN(PjBudgetVO budgetVO);

	public String updateProjectBudgetInfo(PjBudgetVO budgetVO);

	public String insertProjectBudgetInfo(PjBudgetVO budgetVO);

	public void changeProjectDBByBudget(PjBudgetVO budgetVO);

	public List<PjBudgetVO> getProjectHistoryInfo(String pj_id);

	public PjBudgetVO getProjectHistoryListtest(Map<String, Object> params);
	
	public PjBudgetVO getpjBudgetInfo(String pj_id);

	public Map<String, String> deleteBudgetInfoByPjId(String pj_id, String pb_no);

}
