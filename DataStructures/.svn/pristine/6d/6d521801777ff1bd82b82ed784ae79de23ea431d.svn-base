package com.sqisoft.iqs.project.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.project.vo.PjBudgetInfoVO;
import com.sqisoft.iqs.project.vo.PjBudgetVO;
import com.sqisoft.iqs.project.vo.ProjectVO;

public interface PjBudgetDAO {

	public List<PjBudgetVO> getSelectedBudgetList(String pj_id);
	
	public List<PjBudgetVO> getProjectBudgetList(Map<String, Object> params);

	public List<EmployeeInputVO> getEmployeeListFromDeployAndProject(Map<String, String> params);

	public int getEachLaborCost(Map<String, String> conditionMap);

	public int getAllDeployCount(String pj_id);

	public int checkDuplicateYN(PjBudgetVO budgetVO);

	public boolean updateProjectBudgetInfo(PjBudgetVO budgetVO);

	public boolean insertProjectBudgetInfo(PjBudgetVO budgetVO);
	
	public List<PjBudgetVO> getProjectHistoryInfo(String pj_id);

	public PjBudgetVO getProjectHistoryInfo(Map<String, Object> params);
	
	public PjBudgetVO getpjBudgetInfo(String pj_id);

	public boolean deleteBudgetInfoByPjId(Map<String, String> params);

	public int checkPjNumInfo(String pj_id);

	public PjBudgetInfoVO getProjectBudgetInfoByProject(String pj_id);

}
