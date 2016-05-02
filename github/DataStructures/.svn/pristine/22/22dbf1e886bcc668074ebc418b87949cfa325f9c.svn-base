package com.sqisoft.iqs.admin.basicinfo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.admin.basicinfo.dao.BasicInfoDAO;
import com.sqisoft.iqs.admin.basicinfo.vo.DomainVO;
import com.sqisoft.iqs.admin.basicinfo.vo.JobSkillVO;
import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HumanResourceDAO;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;

public class BasicInfoServiceImpl implements BasicInfoService {

	private BasicInfoDAO basicInfoDAO;
	private HumanResourceDAO humanResourceDAO;

	public void setBasicInfoDAO(BasicInfoDAO basicInfoDAO) {
		this.basicInfoDAO = basicInfoDAO;
	}
	
	public void setHumanResourceDAO(HumanResourceDAO humanResourceDAO) {
		this.humanResourceDAO = humanResourceDAO;
	}

	// 기술분류
	@Override
	public List<String> getSkillEnvDivisionList() {
		List<String> skillEnvList = this.basicInfoDAO.getSkillEnvDivisionList();
		if(skillEnvList == null) skillEnvList = new ArrayList<String>();
		
		return skillEnvList;
	}
	
	@Override
	public List<Skill_envVO> getSkillEnvListByDivision(String skillEnvDivision) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("skillEnvDivision", skillEnvDivision);
		
		List<Skill_envVO> skillEnvList = this.basicInfoDAO.getSkillEnvListByDivision(params);
		if(skillEnvList == null) skillEnvList = new ArrayList<Skill_envVO>();
		
		return skillEnvList;
	}
	
	@Override
	public Skill_envVO getSkillEnv(String skillEnvDivision, String skillEnvironment) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("skillEnvDivision", skillEnvDivision);
		params.put("skillEnvironment", skillEnvironment);
		
		Skill_envVO skillEnv = this.basicInfoDAO.getSkillEnv(params);
		if(skillEnv == null) skillEnv = new Skill_envVO();
		
		return skillEnv;
	}
	
	@Override
	public boolean isSkillEnv(String environment_division, String each_environment) {
		Skill_envVO skillEnv = new Skill_envVO();
		skillEnv.setEnvironment_division(environment_division);
		skillEnv.setEach_environment(each_environment);
		
		return this.basicInfoDAO.isSkillEnv(skillEnv);
	}
	
	@Override
	public void insertSkillEnv(Skill_envVO skillEnv) {
		this.basicInfoDAO.insertSkillEnv(skillEnv);
	}
	
	@Override
	public void modifySkillEnv(String environment_division_origin,
			String each_environment_origin, String environment_division_modify,
			String each_environment_modify) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("environment_division_origin", environment_division_origin);
		params.put("each_environment_origin", each_environment_origin);
		params.put("environment_division_modify", environment_division_modify);
		params.put("each_environment_modify", each_environment_modify);
		
		this.basicInfoDAO.modifySkillEnv(params);
	}
	
	@Override
	public void deleteSkillEnv(Skill_envVO skillEnv) {
		this.basicInfoDAO.deleteSkillEnv(skillEnv);
	}
	
	// 직무기술
	@Override
	public List<String> getJobSkillList() {
		List<String> jobSkillList = this.basicInfoDAO.getJobSkillList();
		if(jobSkillList == null) jobSkillList = new ArrayList<String>();
		
		return jobSkillList;
	}
	
	@Override
	public List<JobSkillVO> getJobSkillListByDivision(String jobSkillDivision) {
		List<JobSkillVO> jobSkillList = this.basicInfoDAO.getJobSkillListByDivision(jobSkillDivision);
		if(jobSkillList == null) jobSkillList = new ArrayList<JobSkillVO>();
		
		return jobSkillList;
	}
	
	@Override
	public JobSkillVO getJobSkill(String jobSkillDivision, String jobSkill) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("business_division", jobSkillDivision);
		params.put("each_skill", jobSkill);
		
		JobSkillVO jobSkillVO = this.basicInfoDAO.getJobSkill(params);
		if(jobSkillVO == null) jobSkillVO = new JobSkillVO();
		
		return jobSkillVO;
	}
	
	@Override
	public boolean isJobSkill(String business_division, String each_skill) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("business_division", business_division);
		params.put("each_skill", each_skill);
		
		return this.basicInfoDAO.isJobSkill(params);
	}
	
	@Override
	public void insertJobSkill(JobSkillVO jobSkillVO) {
		this.basicInfoDAO.insertJobSkill(jobSkillVO);
	}
	
	@Override
	public void modifyJobSkill(String business_division_origin,
			String each_skill_origin, String business_division_modify,
			String each_skill_modify) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("business_division_origin", business_division_origin);
		params.put("each_skill_origin", each_skill_origin);
		params.put("business_division_modify", business_division_modify);
		params.put("each_skill_modify", each_skill_modify);
		
		this.basicInfoDAO.modifyJobSkill(params);
	}
	
	@Override
	public void deleteJobSkill(JobSkillVO jobSkillVO) {
		this.basicInfoDAO.deleteJobSkill(jobSkillVO);
	}
	// 업무분류

	// 역할분류
	@Override
	public List<RoleVO> getRoleList() {
		return this.humanResourceDAO.getRoleOptions();
	}
	
	@Override
	public Map<String, Object> checkDuplicateYN(String each_role) {

		int count = this.basicInfoDAO.checkDuplicateYN(each_role);
		boolean result = false;
		
		if( count < 1 ) {
			result = true;
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@Override
	public Map<String, String> insertRoleAjax(String each_role) {
		
		boolean result = this.basicInfoDAO.insertRoleAjax(each_role);
		
		Map<String, String> resultMap = new HashMap<String, String>();
		String message = "";

		if(result){
			message = each_role + "이 역할분류로 등록되었습니다.";
			
			String role_id = this.basicInfoDAO.getRoleByEachRole(each_role);
			resultMap.put("role_id", role_id);
		}
		else {
			message = each_role + " 등록이 실패하였습니다.";
		}
		
		resultMap.put("message", message);
		resultMap.put("each_role", each_role);
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> modifyRoleAjax(RoleVO roleVO) {
		
		boolean result = this.basicInfoDAO.modifyRoleAjax(roleVO);
		
		String message = "";
		if(result){
			message = "역할이 " + roleVO.getEach_role() + "으로 변경되었습니다.";
		}
		else {
			message = roleVO.getEach_role() + "으로 역할 변경이 실패하였습니다.";
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("message", message);
		resultMap.put("each_role", roleVO.getEach_role());
		resultMap.put("role_id", roleVO.getRole_id());
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> deleteRoleAjax(RoleVO roleVO) {
		
		boolean result = this.basicInfoDAO.deleteRoleAjax(roleVO);
		
		String message = "";
		if(result){
			message = "역할 " + roleVO.getEach_role() + "이(가) 삭제되었습니다.";
		}
		else {
			message = roleVO.getEach_role() + "의 삭제를 실패하였습니다.";
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("message", message);
		
		return resultMap;
	}
	
	

	// 영업단계
	@Override
	public List<ProjectStageVO> getAllPjStageList() {
		return this.basicInfoDAO.getAllPjStageList();
	}
	
	@Override
	public boolean isPjStage(String pj_stage_name) {
		return this.basicInfoDAO.isPjStage(pj_stage_name) > 0;
	}

	@Override
	public boolean insertPjStage(String pj_stage_name) {
		return this.basicInfoDAO.insertPjStage(pj_stage_name);
	}
	
	@Override
	public boolean modifyPjStage(ProjectStageVO projectStageVO) {
		return this.basicInfoDAO.modifyPjStage(projectStageVO);
	}
	
	@Override
	public boolean deletePjStageAjax(String pj_stage_id) {
		return this.basicInfoDAO.deletePjStageAjax(pj_stage_id);
	}
	// 추진상태
	@Override
	public ProjectStatusVO getProjectStatusById(int pj_status_id) {
		ProjectStatusVO projectStatus = this.basicInfoDAO.getProjectStatusById(pj_status_id);
		if(projectStatus == null) projectStatus = new ProjectStatusVO();
		
		return projectStatus;
	}
	
	@Override
	public boolean isProjectStatus(String pj_status_name) {
		return this.basicInfoDAO.isProjectStatus(pj_status_name);
	}
	
	@Override
	public void insertPjStatus(ProjectStatusVO projectStatus) {
		this.basicInfoDAO.insertPjStatus(projectStatus);
	}
	
	@Override
	public void modifyProjectStatus(ProjectStatusVO projectStatusVO) {
		this.basicInfoDAO.modifyProjectStatus(projectStatusVO);
	}
	
	@Override
	public void deletePjStatus(int pj_status_id) {
		this.basicInfoDAO.deletePjStatus(pj_status_id);
	}
	
	//업무분류
	public List<DomainVO> getDomainList(){
		return this.basicInfoDAO.getDomainList();
	}
	
	@Override
	public DomainVO getDomain(String each_domain) {
		
		DomainVO domain = this.basicInfoDAO.getDomain(each_domain);
		if(domain == null) domain = new DomainVO();
		
		return domain;
	}
	
	//업무 중복 체크
	public boolean isDoamin(String each_domain) {
		return this.basicInfoDAO.isDoamin(each_domain);
	}
	
	@Override
	public void insertDomain(String each_domain) {
		this.basicInfoDAO.insertDomain(each_domain);
	}
	
	@Override
	public void modifyDomain(DomainVO domainVO) {
		this.basicInfoDAO.modifyDomain(domainVO);
	}
	
	public void deleteDomain(String each_domain) {
		this.basicInfoDAO.deleteDomain(each_domain);
	}
}
