package com.sqisoft.iqs.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.project.vo.PjBudgetInfoVO;
import com.sqisoft.iqs.project.vo.PjBudgetVO;
import com.sqisoft.iqs.project.vo.ProjectVO;

public class PjBudgetDAOImpl extends SqlSessionDaoSupport implements PjBudgetDAO{

	@Override
	public List<PjBudgetVO> getSelectedBudgetList(String pj_id) {
		return getSqlSession().selectList("pjBudgetDAO.getSelectedBudgetList", pj_id);
	}
	
	@Override
	public List<PjBudgetVO> getProjectBudgetList(Map<String, Object> params) {
		return getSqlSession().selectList("pjBudgetDAO.getProjectBudgetList", params);
	}
	
	public PjBudgetVO getpjBudgetInfo(String pj_id) {
		return getSqlSession().selectOne("pjBudgetDAO.getpjBudgetInfo", pj_id);
	}
	
	@Override
	public List<EmployeeInputVO> getEmployeeListFromDeployAndProject(Map<String, String> params) {
		return getSqlSession().selectList("pjBudgetDAO.getEmployeeListFromDeployAndProject", params);
	}
	
	@Override
	public int getEachLaborCost(Map<String, String> conditionMap) {
		return getSqlSession().selectOne("pjBudgetDAO.getEachLaborCost", conditionMap);
	}
	
	@Override
	public int getAllDeployCount(String pj_id) {
		return getSqlSession().selectOne("pjBudgetDAO.getAllDeployCount", pj_id);
	}
	
	@Override
	public int checkDuplicateYN(PjBudgetVO budgetVO) {
		return getSqlSession().selectOne("pjBudgetDAO.checkDuplicateYN", budgetVO);
	}
	
	@Override
	public boolean updateProjectBudgetInfo(PjBudgetVO budgetVO) {
		return getSqlSession().update("pjBudgetDAO.updateProjectBudgetInfo", budgetVO) > 0;
	}
	
	@Override
	public boolean insertProjectBudgetInfo(PjBudgetVO budgetVO) {
		return getSqlSession().insert("pjBudgetDAO.insertProjectBudgetInfo", budgetVO) > 0;
	}
	
	@Override
	public List<PjBudgetVO> getProjectHistoryInfo(String pj_id){
		return getSqlSession().selectList("pjBudgetDAO.getProjectHistoryInfo",pj_id);
	}

	@Override
	public PjBudgetVO getProjectHistoryInfo(Map<String, Object> params) {
		return getSqlSession().selectOne("pjBudgetDAO.getProjectHistoryListtest", params);
	}
	
	@Override
	public boolean deleteBudgetInfoByPjId(Map<String, String> params) {
		return getSqlSession().delete("pjBudgetDAO.deleteBudgetInfoByPjId", params) > 0;
	}

	@Override
	public int checkPjNumInfo(String pj_id) {
		return getSqlSession().selectOne("pjBudgetDAO.getPjCount", pj_id);
	}

	@Override
	public PjBudgetInfoVO getProjectBudgetInfoByProject(String pj_id) {
		return getSqlSession().selectOne("pjBudgetDAO.getProjectBudgetInfoByProject",pj_id);
	}
}
