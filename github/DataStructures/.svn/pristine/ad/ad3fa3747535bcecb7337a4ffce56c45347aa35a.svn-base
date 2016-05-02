package com.sqisoft.iqs.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;

public class ProjectDAOImpl extends SqlSessionDaoSupport implements ProjectDAO {

	@Override
	public ProjectVO getProjectInfo(String pj_id) {
		return getSqlSession().selectOne("projectDAO.getProjectInfo", pj_id);
	}
	
	
	@Override
	public List<ProjectStageVO> getProjectStageList() {
		return getSqlSession().selectList("projectDAO.getProjectStageList");
	}
	
	@Override
	public List<ProjectStatusVO> getProjectStatusList() {
		return getSqlSession().selectList("projectDAO.getProjectStatusList");
	}
	
	@Override
	public void modifyProjectInfo(ProjectVO projectVO) {
		getSqlSession().update("projectDAO.modifyProjectInfo", projectVO);
	}
	
	@Override
	public void modifyProjectProfitAndLossInfo(ProjectVO projectVO) {
		getSqlSession().update("projectDAO.modifyProjectProfitAndLossInfo", projectVO);
	}
	
	
	@Override
	public void deleteProjectInfo(String pj_id) {
		getSqlSession().delete("projectDAO.deleteProjectInfo", pj_id);
	}
	
	@Override
	public List<ProjectVO> getProjectList(Map<String, Object> params) {
		return getSqlSession().selectList("projectDAO.getProjectList", params);
	}

	@Override
	public boolean checkDuplicate(Map<String, String> params) {
		int duplCount = getSqlSession().selectOne("projectDAO.checkDuplicate", params);
		return duplCount > 0;
	}
	
	@Override
	public ProjectVO getProjectInfo(Map<String, String> params) {
		return getSqlSession().selectOne("projectDAO.getProjectInfo", params);
	}

	@Override
	public boolean putNewProjectDetail(ProjectVO projectVO) {
		int count = getSqlSession().insert("projectDAO.putNewProjectDetail", projectVO);
		return count > 0;
	}

	@Override
	public int getProjectNum(String pj_id) {
		return this.getSqlSession().selectOne("projectDAO.getProjectNum",pj_id);
	}
	
	@Override
	public List<ProjectVO> getProjectListByTeamId(String tm_id) {
		return getSqlSession().selectList("projectDAO.getProjectListByTeamId", tm_id);
	}
}
