package com.sqisoft.iqs.admin.basicinfo.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.admin.basicinfo.vo.DomainVO;
import com.sqisoft.iqs.admin.basicinfo.vo.JobSkillVO;
import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;

public interface BasicInfoDAO {
	
	// 기술 분류
	List<String> getSkillEnvDivisionList();

	List<Skill_envVO> getSkillEnvListByDivision(Map<String, String> params);

	Skill_envVO getSkillEnv(Map<String, String> params);

	boolean isSkillEnv(Skill_envVO skillEnv);

	void insertSkillEnv(Skill_envVO skillEnv);

	void deleteSkillEnv(Skill_envVO skillEnv);

	void modifySkillEnv(Map<String, String> params);


	// 직무기술
	List<String> getJobSkillList();

	List<JobSkillVO> getJobSkillListByDivision(String jobSkillDivision);
	
	JobSkillVO getJobSkill(Map<String, String> params);
	
	boolean isJobSkill(Map<String, String> params);
	
	void insertJobSkill(JobSkillVO jobSkillVO);
	
	void modifyJobSkill(Map<String, String> params);
	
	void deleteJobSkill(JobSkillVO jobSkillVO);

	// 역할분류
	public int checkDuplicateYN(String each_role);

	public boolean insertRoleAjax(String each_role);

	public boolean modifyRoleAjax(RoleVO roleVO);
	
	public boolean deleteRoleAjax(RoleVO roleVO);

	public String getRoleByEachRole(String each_role);

	// 영업단계
	public List<ProjectStageVO> getAllPjStageList();

	public int isPjStage(String pj_stage_name);

	public boolean insertPjStage(String pj_stage_name);

	public boolean modifyPjStage(ProjectStageVO projectStageVO);

	public boolean deletePjStageAjax(String pj_stage_id);
	
	
			
	// 추진상태
	ProjectStatusVO getProjectStatusById(int pj_status_id);

	boolean isProjectStatus(String pj_status_name);
	
	void insertPjStatus(ProjectStatusVO projectStatus);
	
	void modifyProjectStatus(ProjectStatusVO projectStatusVO);
	
	void deletePjStatus(int pj_status_id);


	//업무분류
	public List<DomainVO> getDomainList();

	public DomainVO getDomain(String each_domain);

	public boolean isDoamin(String each_domain);

	public void insertDomain(String each_domain);

	public void modifyDomain(DomainVO domainVO);

	public void deleteDomain(String each_domain);



}
