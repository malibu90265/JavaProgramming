package com.sqisoft.iqs.humanResource.deployRequirements.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.deployRequirements.vo.DeployRequirementsVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;

public interface DeployRequirementsDAO {
	
	public List<DeployRequirementsVO> getTeamNames();
	public List<DeployRequirementsVO> getProjectList(String tm_id);
	public DeployRequirementsVO getProjectInfoByPjId(String pj_id);
	public List<DeployRequirementsVO> getPjRequiredInfoByPjId(String pj_id);
	public HumanResourceVO getHrInfoByName(Map<String, String> map);
	public void insertPjRequired(Map<String, Object> map);
	public void deleteRequire(Map<String, Object> map);
	public int checkNum(String pj_id);
	public int getDeployRequirementsMaxPrSq(String pj_id);
	public DeployRequirementsVO getDeployRequirementsListAjax( Map<String, Object> map);
	public void updatePjDeployInfo(HRPriceVO hrPriceVO);
	
}
