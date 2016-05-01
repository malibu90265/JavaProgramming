package com.sqisoft.iqs.humanResource.deployMap.service.impl;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.deployMap.dao.DeployMapDAO;
import com.sqisoft.iqs.humanResource.deployMap.service.DeployMapService;
import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;

public class DeployMapServiceImpl implements DeployMapService {
	
	DeployMapDAO deployMapDAO;

	public void setDeployMapDAO(DeployMapDAO deployMapDAO) {
		this.deployMapDAO = deployMapDAO;
	}

	/* 월별 투입 map */
	@Override
	public List<DeployMapVO> getMonthlyDeployMap() {
		return deployMapDAO.getMonthlyDeployMap();
	}

	@Override
	public List<DeployMapVO> getOutDeployMap() {
		List<DeployMapVO> dm = deployMapDAO.getOutDeployMap();
		for(DeployMapVO d : dm){
			if(d.getHr_grade() != null)
				d.setHr_grade(d.getHr_grade().replaceAll("[0-9]", ""));
		}
		return dm;
	}
	
	//팀, 이름 검색
	@Override
	public List<DeployMapVO> getTeamAndNameSearch(Map<String, Object> param) {
		return deployMapDAO.getTeamAndNameSearch(param);
	}
	

}
