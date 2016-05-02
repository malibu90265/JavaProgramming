package com.sqisoft.iqs.humanResource.empStandBy.service.impl;

import java.util.List;

import com.sqisoft.iqs.humanResource.empStandBy.dao.EmpStandByDAO;
import com.sqisoft.iqs.humanResource.empStandBy.service.EmpStandByService;
import com.sqisoft.iqs.humanResource.empStandBy.vo.EmpStandByVO;

public class EmpStandByServiceImpl implements EmpStandByService{
	
	private EmpStandByDAO empStandByDAO;

	public void setEmpStandByDAO(EmpStandByDAO empStandByDAO) {
		this.empStandByDAO = empStandByDAO;
	}
	
	public List<EmpStandByVO> getEmpStandByTeamList(String tm_id) {
		return empStandByDAO.getEmpStandByTeamList(tm_id);
	}
	
}
