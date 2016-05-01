package com.sqisoft.iqs.humanResource.empPjMap.service.impl;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.humanResource.empPjMap.dao.EmpPjMapDAO;
import com.sqisoft.iqs.humanResource.empPjMap.service.EmpPjMapService;
import com.sqisoft.iqs.humanResource.empPjMap.vo.EmpPjMapVO;

public class EmpPjMapServiceImpl implements EmpPjMapService{
	
	private EmpPjMapDAO empPjMapDAO;

	public void setEmpPjMapDAO(EmpPjMapDAO empPjMapDAO) {
		this.empPjMapDAO = empPjMapDAO;
	}
	
	//checkbox 선택 list
	@Override
	public List<EmpPjMapVO> getEmpList(String team_id) {
		List<EmpPjMapVO> e = empPjMapDAO.getCheckBoxValue(team_id);
		for(EmpPjMapVO emp : e){
			System.out.println(emp.getPj_id());
			System.out.println(emp.getPd_name());
			System.out.println("-----------------");
		}
		return e;
	}

	@Override
	public List<ProjectCountVO> getProjectCount(String team_id) {
		return empPjMapDAO.getProject_GetCount(team_id);
	}
}
