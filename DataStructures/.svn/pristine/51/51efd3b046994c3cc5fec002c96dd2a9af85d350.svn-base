package com.sqisoft.iqs.humanResource.deployRequirements.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.deployRequirements.dao.DeployRequirementsDAO;
import com.sqisoft.iqs.humanResource.deployRequirements.vo.DeployRequirementsVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;

public class DeployRequirementsDAOImpl extends SqlSessionDaoSupport implements DeployRequirementsDAO {

	@Override
	public List<DeployRequirementsVO> getTeamNames() {
		return getSqlSession().selectList("DeployRequirmentsDAO.getTeamNames");
	}

	@Override
	public List<DeployRequirementsVO> getProjectList(String tm_id) {
		return getSqlSession().selectList("DeployRequirmentsDAO.getProjectList", tm_id);
	}

	@Override
	public DeployRequirementsVO getProjectInfoByPjId(String pj_id) {
		return getSqlSession().selectOne("DeployRequirmentsDAO.getProjectInfoByPjId", pj_id);
	}

	@Override
	public List<DeployRequirementsVO> getPjRequiredInfoByPjId(String pj_id) {
		return getSqlSession().selectList("DeployRequirmentsDAO.getPjRequiredInfoByPjId", pj_id);
	}

	@Override
	public HumanResourceVO getHrInfoByName(Map<String, String> map) {
		return getSqlSession().selectOne("DeployRequirmentsDAO.getHrInfoByName", map);
	}

	@Override
	public void insertPjRequired(Map<String, Object> map) {
		getSqlSession().insert("DeployRequirmentsDAO.insertPjRequired", map);
	}
	
	@Override
	public void deleteRequire(Map<String, Object> map) {
		getSqlSession().delete("DeployRequirmentsDAO.deleteRequire", map);
	}

	@Override
	public int checkNum(String pj_id) {
		return getSqlSession().selectOne("DeployRequirmentsDAO.checkNum", pj_id);
	}

	@Override
	public int getDeployRequirementsMaxPrSq(String pj_id) {
		int num = getSqlSession().selectOne("DeployRequirmentsDAO.checkNum", pj_id);
		return num;
	}

	@Override
	public DeployRequirementsVO getDeployRequirementsListAjax(Map<String, Object> map) {
		return getSqlSession().selectOne("DeployRequirmentsDAO.checkList", map);
	}

	@Override
	public void updatePjDeployInfo(HRPriceVO hrPriceVO) {
		getSqlSession().update("DeployRequirmentsDAO.updatePjDeployInfo", hrPriceVO);
	}

}
