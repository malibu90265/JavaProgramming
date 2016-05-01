package com.sqisoft.iqs.humanResource.humanResource.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HRPriceDAO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;

public class HRPriceDAOImpl extends SqlSessionDaoSupport implements HRPriceDAO{

	@Override
	public List<HRPriceVO> getHRPriceIfoByTeamId(String tm_id) {
		return getSqlSession().selectList("hrPriceDAO.getHRPriceIfoByTeamId", tm_id);
	}
	
	@Override
	public boolean updateHRPriceInfo(HRPriceVO hrPriceVO) {
		int result =getSqlSession().update("hrPriceDAO.updateHRPriceInfo", hrPriceVO);	// hr_price 업데이트
		if(result ==1) {
			getSqlSession().update("hrPriceDAO.updateHumanResourceInfo", hrPriceVO);	//human_resource
		}
		return true;
	}
}
