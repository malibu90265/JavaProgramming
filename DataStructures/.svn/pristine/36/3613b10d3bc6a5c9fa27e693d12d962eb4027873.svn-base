package com.sqisoft.iqs.admin.basicinfo.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.admin.basicinfo.vo.DomainVO;
import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.admin.basicinfo.vo.JobSkillVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;

public interface BasicInfoService {

	// 기술 분류
	public List<String> getSkillEnvDivisionList();

	public List<Skill_envVO> getSkillEnvListByDivision(String skillEnvDivision);

	public Skill_envVO getSkillEnv(String skillEnvDivision, String skillEnvironment);

	public boolean isSkillEnv(String environment_division, String each_environment);
	
	public void insertSkillEnv(Skill_envVO skillEnv);

	public void deleteSkillEnv(Skill_envVO skillEnv);

	public void modifySkillEnv(String environment_division_origin,
			String each_environment_origin, String environment_division_modify,
			String each_environment_modify);

	// 직무기술
	public List<String> getJobSkillList();

	public List<JobSkillVO> getJobSkillListByDivision(String jobSkillDivision);
	
	public JobSkillVO getJobSkill(String jobSkillDivision, String jobSkill);
	
	public boolean isJobSkill(String business_division, String each_skill);
	
	public void insertJobSkill(JobSkillVO jobSkillVO);
	
	public void modifyJobSkill(String business_division_origin,
			String each_skill_origin, String business_division_modify,
			String each_skill_modify);
	
	public void deleteJobSkill(JobSkillVO jobSkillVO);
	// 업무분류
	public List<DomainVO> getDomainList();

	public DomainVO getDomain(String each_domain);

	public boolean isDoamin(String each_domain);

	public void insertDomain(String each_domain);

	public void modifyDomain(DomainVO domainVO);

	public void deleteDomain(String each_domain);
	
	// 역할분류
	public List<RoleVO> getRoleList();

	public Map<String, Object> checkDuplicateYN(String each_role);

	public Map<String, String> insertRoleAjax(String each_role);
	
	public Map<String, Object> modifyRoleAjax(RoleVO roleVO);

	public Map<String, Object> deleteRoleAjax(RoleVO roleVO);

	// 영업단계
	public List<ProjectStageVO> getAllPjStageList();

	public boolean isPjStage(String pj_stage_name);

	public boolean insertPjStage(String pj_stage_name);

	public boolean modifyPjStage(ProjectStageVO projectStageVO);

	public boolean deletePjStageAjax(String pj_stage_id);
		
	// 추진상태
	public ProjectStatusVO getProjectStatusById(int pj_status_id);

	public boolean isProjectStatus(String pj_status_name);
	
	public void insertPjStatus(ProjectStatusVO projectStatus);
	
	public void modifyProjectStatus(ProjectStatusVO projectStatusVO);
	
	public void deletePjStatus(int pj_status_id);




}
