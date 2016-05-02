package com.sqisoft.iqs.admin.basicinfo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.admin.basicinfo.vo.DomainVO;
import com.sqisoft.iqs.admin.basicinfo.vo.JobSkillVO;
import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;

public class BasicInfoDAOImpl extends SqlSessionDaoSupport implements BasicInfoDAO {

	// 기술 분류
	public List<String> getSkillEnvDivisionList() {
		return getSqlSession().selectList("basicInfoDAO.getSkillEnvDivisionList");
	};
	
	@Override
	public List<Skill_envVO> getSkillEnvListByDivision(Map<String, String> params) {
		return getSqlSession().selectList("basicInfoDAO.getSkillEnvListByDivision", params);
	}
	
	@Override
	public Skill_envVO getSkillEnv(Map<String, String> params) {
		return getSqlSession().selectOne("basicInfoDAO.getSkillEnv", params);
	}
	
	@Override
	public boolean isSkillEnv(Skill_envVO skillEnv) {
		int count = getSqlSession().selectOne("basicInfoDAO.isSkillEnv", skillEnv);
		return count > 0;
	}
	
	@Override
	public void insertSkillEnv(Skill_envVO skillEnv) {
		getSqlSession().insert("basicInfoDAO.insertSkillEnv", skillEnv);
	}
	
	@Override
	public void deleteSkillEnv(Skill_envVO skillEnv) {
		getSqlSession().delete("basicInfoDAO.deleteSkillEnv", skillEnv);
	}
	
	@Override
	public void modifySkillEnv(Map<String, String> params) {
		getSqlSession().update("basicInfoDAO.modifySkillEnv", params);
	}
	
	// 직무기술
		@Override
		public List<String> getJobSkillList() {
			return getSqlSession().selectList("basicInfoDAO.getJobSkillList");
		}
		
		@Override
		public List<JobSkillVO> getJobSkillListByDivision(String jobSkillDivision) {
			return getSqlSession().selectList("basicInfoDAO.getJobSkillListByDivision", jobSkillDivision);
		}
		
		@Override
		public JobSkillVO getJobSkill(Map<String, String> params) {
			return getSqlSession().selectOne("basicInfoDAO.getJobSkill", params);
		}
		
		@Override
		public boolean isJobSkill(Map<String, String> params) {
			int count = getSqlSession().selectOne("basicInfoDAO.isJobSkill", params);
			return count > 0;
		}
		
		@Override
		public void insertJobSkill(JobSkillVO jobSkillVO) {
			getSqlSession().insert("basicInfoDAO.insertJobSkill", jobSkillVO);
		}
		
		@Override
		public void modifyJobSkill(Map<String, String> params) {
			getSqlSession().update("basicInfoDAO.modifyJobSkill", params);
		}
		
		@Override
		public void deleteJobSkill(JobSkillVO jobSkillVO) {
			getSqlSession().delete("basicInfoDAO.deleteJobSkill", jobSkillVO);
		}

	//업무분류
	@Override
	public List<DomainVO> getDomainList() {
		return getSqlSession().selectList("basicInfoDAO.getDomainList");
	}

	@Override
	public DomainVO getDomain(String each_domain) {
		return getSqlSession().selectOne("basicInfoDAO.getDomain",each_domain);
	}
	
	@Override
	public boolean isDoamin(String each_domain) {
		int count = getSqlSession().selectOne("basicInfoDAO.isDoamin", each_domain);
		return count > 0;
	}
	
	@Override
	public void insertDomain(String each_domain) {
		getSqlSession().insert("basicInfoDAO.insertDomain", each_domain);
	}
	public void modifyDomain(DomainVO domainVO) {
		getSqlSession().update("basicInfoDAO.modifyDomain", domainVO);
	}
	public void deleteDomain(String each_domain) {
		getSqlSession().delete("basicInfoDAO.deleteDomain", each_domain);
	}
	
	// 역할분류
	
	@Override
	public int checkDuplicateYN(String each_role) {
		return getSqlSession().selectOne("basicInfoDAO.checkDuplicateYN", each_role);
	}
	
	@Override
	public boolean insertRoleAjax(String each_role) {
		return getSqlSession().insert("basicInfoDAO.insertRoleAjax", each_role) > 0;
	}
	
	@Override
	public String getRoleByEachRole(String each_role) {
		return getSqlSession().selectOne("basicInfoDAO.getRoleByEachRole", each_role);
	}
	
	@Override
	public boolean modifyRoleAjax(RoleVO roleVO) {
		return getSqlSession().update("basicInfoDAO.modifyRoleAjax", roleVO) > 0;
	}
	
	@Override
	public boolean deleteRoleAjax(RoleVO roleVO) {
		return getSqlSession().delete("basicInfoDAO.deleteRoleAjax", roleVO) > 0;
	}
	
	// 영업단계
	@Override
	public List<ProjectStageVO> getAllPjStageList() {
		return getSqlSession().selectList("projectDAO.getProjectStageList");
	}
	
	@Override
	public int isPjStage(String pj_stage_name) {
		return getSqlSession().selectOne("basicInfoDAO.isPjStage", pj_stage_name);
	}
	
	@Override
	public boolean insertPjStage(String pj_stage_name) {
		return getSqlSession().insert("basicInfoDAO.insertPjStage", pj_stage_name) > 0;
	}
	
	@Override
	public boolean modifyPjStage(ProjectStageVO projectStageVO) {
		return getSqlSession().update("basicInfoDAO.modifyPjStage", projectStageVO) > 0;
	}
	
	@Override
	public boolean deletePjStageAjax(String pj_stage_id) {
		return getSqlSession().delete("basicInfoDAO.deletePjStageAjax", pj_stage_id) > 0;
	}
			
	// 추진상태
	@Override
	public ProjectStatusVO getProjectStatusById(int pj_status_id) {
		return getSqlSession().selectOne("basicInfoDAO.getProjectStatusById", pj_status_id);
	}
	
	@Override
	public boolean isProjectStatus(String pj_status_name) {
		int count = getSqlSession().selectOne("basicInfoDAO.isProjectStatus", pj_status_name);
		return count > 0;
	}
	
	@Override
	public void insertPjStatus(ProjectStatusVO projectStatus) {
		getSqlSession().insert("basicInfoDAO.insertProjectStatus", projectStatus);
	}
	
	@Override
	public void modifyProjectStatus(ProjectStatusVO projectStatusVO) {
		getSqlSession().update("basicInfoDAO.modifyProjectStatus", projectStatusVO);
	}
	
	@Override
	public void deletePjStatus(int pj_status_id) {
		getSqlSession().delete("basicInfoDAO.deletePjStatus", pj_status_id);
	}
}
