package com.sqisoft.iqs.humanResource.estimate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.estimate.dao.EstimateDAO;
import com.sqisoft.iqs.humanResource.estimate.vo.EstimationVO;

public class EstimateDAOImpl extends SqlSessionDaoSupport implements EstimateDAO {

	@Override
	public List<EstimationVO> getEstViewPage(String hr_name) {
		return getSqlSession().selectList("EstimateDAO.getEstViewPage", hr_name);
	}

	@Override
	public List<EstimationVO> getSearchYearOptions(String hr_name) {
		return getSqlSession().selectList("EstimateDAO.getSearchYearOptions", hr_name);
	}

	@Override
	public List<String> getSearchPjOptions(String hr_name) {
		return getSqlSession().selectList("EstimateDAO.getSearchPjOptions", hr_name);
	}

	@Override
	public List<EstimationVO> getEstViewPageSearch(Map<String, Object> param) {
		return getSqlSession().selectList("EstimateDAO.getEstViewPageSearch", param);
	}
	
	//업데이트
	@Override
	public void doUpdateSignupdata(Map<String, Object> param) {
		getSqlSession().update("EstimateDAO.doUpdateSignupdata", param);
	}
	
	// 팀 검색 디폴트
	@Override
	public List<EstimationVO> getNonTeamEstViewPage() {
		return getSqlSession().selectList("EstimateDAO.getNonTeamEstViewPage");
	}
	
	@Override
	public List<EstimationVO> getTeamEstViewPageSearch(Map<String, Object> param) {
		return getSqlSession().selectList("EstimateDAO.getTeamEstViewPageSearch", param);
	}
	
}
