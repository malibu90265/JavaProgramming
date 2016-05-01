package com.sqisoft.iqs.humanResource.deployMap.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.deployMap.dao.DeployMapDAO;
import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;

public class DeployMapDAOImpl extends SqlSessionDaoSupport implements DeployMapDAO {

	/* 월별 투입 map */
	@Override
	public List<DeployMapVO> getMonthlyDeployMap() {
		return getSqlSession().selectList("deployMapDAO.getMonthlyDeployMap");
	}

	@Override
	public List<DeployMapVO> getOutDeployMap() {
		return getSqlSession().selectList("deployMapDAO.getOutDeployMap");
	}
	
	//팀, 이름 검색
	@Override
	public List<DeployMapVO> getTeamAndNameSearch(Map<String, Object> param) {
		return getSqlSession().selectList("deployMapDAO.getTeamAndNameSearch", param);
	}
}
