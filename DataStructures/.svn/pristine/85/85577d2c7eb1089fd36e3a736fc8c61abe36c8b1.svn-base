package com.sqisoft.iqs.humanResource.deployRequirements.service;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.deployRequirements.vo.DeployRequirementsVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;

public interface DeployRequirementsService {
	
	public List<DeployRequirementsVO> getSearchTeamListAjax();
	public List<DeployRequirementsVO> getSearchTeamProjectListAjax(String tm_id);
	public DeployRequirementsVO getDeployRequirementsDetailFormAjax(String pj_id);
	public HumanResourceVO getHrInfoByNameAjax(Map<String, String> map);
	public List<DeployRequirementsVO> getDeployRequirementsInsertFormAjax(String pj_id);
	
	public List<String> getRankOptions();
	public void insertPjRequire(Map<String, Object> map);
	public void deletePjRequireAfterInsert(Map<String, Object> map);
	public int checkNumAjax(String pj_id);
	public int getDeployRequirementsMaxPrSq(String pj_id);
	public DeployRequirementsVO getDeployRequirementsListAjax(Map<String, Object> map);

}
