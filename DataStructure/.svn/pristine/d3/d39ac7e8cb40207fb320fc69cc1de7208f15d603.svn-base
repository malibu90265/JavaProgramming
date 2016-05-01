package com.sqisoft.iqs.humanResource.costmap.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.costmap.dao.CostMapDAO;
import com.sqisoft.iqs.humanResource.costmap.vo.CostMapVO;

public class CostMapDAOImpl extends SqlSessionDaoSupport implements CostMapDAO{

	// 리스트
	@Override
	public List<CostMapVO> getCostmapList(Map<String, String> params) {
		return getSqlSession().selectList("costMapDAO.getCostmapList", params);
	}
	
	public void updateMM(Map<String, String> map) {
		getSqlSession().update("costMapDAO.updateMM", map);
	}
	public String getHrUprice(Map<String, String> map){
		return getSqlSession().selectOne("costMapDAO.getHrUprice", map);
	}
	public String get6M15price(){
		return getSqlSession().selectOne("costMapDAO.get6M15price");
	}

	public void updatePjMMandCost(Map<String, String> map) {
		getSqlSession().update("costMapDAO.updatePjMMandCost", map);
	}

	@Override
	public void updateTmOutCost(Map<String, String> map) {
		getSqlSession().update("costMapDAO.updateTmOutCost", map);
		
	}
	@Override
	public void updatePjDirectCost(Map<String, String> map) {
		getSqlSession().update("costMapDAO.updatePjDirectCost", map);
		
	}
	
}
