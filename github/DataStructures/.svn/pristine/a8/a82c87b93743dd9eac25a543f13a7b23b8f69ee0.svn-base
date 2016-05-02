package com.sqisoft.iqs.humanResource.deployRequirements.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.deployRequirements.dao.DeployRequirementsDAO;
import com.sqisoft.iqs.humanResource.deployRequirements.service.DeployRequirementsService;
import com.sqisoft.iqs.humanResource.deployRequirements.vo.DeployRequirementsVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;

public class DeployRequirementsServiceImpl implements DeployRequirementsService{
	DeployRequirementsDAO deployRequirementsDAO;
	public void setDeployRequirementsDAO(DeployRequirementsDAO deployRequirementsDAO) {
		this.deployRequirementsDAO = deployRequirementsDAO;
	}
	
	//tm list 출력
	@Override
	public List<DeployRequirementsVO> getSearchTeamListAjax() {
		return deployRequirementsDAO.getTeamNames();
	}

	//tm_name으로 프로젝트 검색하기
	@Override
	public List<DeployRequirementsVO> getSearchTeamProjectListAjax(String tm_id) {
		return deployRequirementsDAO.getProjectList(tm_id);
	}

	@Override
	public DeployRequirementsVO getDeployRequirementsDetailFormAjax(String pj_id) {
		return deployRequirementsDAO.getProjectInfoByPjId(pj_id);
	}

	@Override
	public List<DeployRequirementsVO> getDeployRequirementsInsertFormAjax(String pj_id) {
		List<DeployRequirementsVO> list  = deployRequirementsDAO.getPjRequiredInfoByPjId(pj_id);
		for(DeployRequirementsVO vo : list) {
			if(vo.getPr_grade() != null)
				vo.setPr_grade(vo.getPr_grade().replaceAll("[0-9]", ""));
		}
		
		return list;
	}

	@Override
	public HumanResourceVO getHrInfoByNameAjax(Map<String, String> map) {
		HumanResourceVO dr = deployRequirementsDAO.getHrInfoByName(map);
		if(dr!=null){
			String grade = dr.getHr_grade().replaceAll("[0-9]", "");
			dr.setHr_grade(grade);
		}
		return dr;
	}

	@Override
	public List<String> getRankOptions() {
		List<String> list = new ArrayList<String>();
		list.add("선택");
		list.add("특급");
		list.add("고급");
		list.add("중급");
		list.add("초급");
		return list;
	}

	@Override
	public void insertPjRequire(Map<String, Object> map) {
		deployRequirementsDAO.insertPjRequired(map);
	}

	@Override
	public void deletePjRequireAfterInsert(Map<String, Object> map) {
		deployRequirementsDAO.deleteRequire(map);
	}

	@Override
	public int checkNumAjax(String pj_id) {
		return deployRequirementsDAO.checkNum(pj_id);
	}

	@Override
	public int getDeployRequirementsMaxPrSq(String pj_id) {
		return deployRequirementsDAO.getDeployRequirementsMaxPrSq(pj_id);
	}

	@Override
	public DeployRequirementsVO getDeployRequirementsListAjax(Map<String, Object> map) {
		return deployRequirementsDAO.getDeployRequirementsListAjax(map);
	}
	
	
}