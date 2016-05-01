package com.sqisoft.iqs.pf.project.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.pf.project.dao.ProjectDAO;
import com.sqisoft.iqs.pf.vo.BizMileVO;
import com.sqisoft.iqs.pf.vo.ExEmplMM;
import com.sqisoft.iqs.pf.vo.ProjectVO;

public class ProjectDAOImpl extends SqlSessionDaoSupport implements ProjectDAO {

	@Override
	public List<ProjectVO> getProjectList() {
		return getSqlSession().selectList("projectDAO.getProjectList");
	}

	@Override
	public List<BizMileVO> getBizMileList() {
		return getSqlSession().selectList("projectDAO.getBizMileList");
	}

	@Override
	public void bizMileUpdate(BizMileVO vo) {
		getSqlSession().update("projectDAO.bizMileUpdate", vo);
	}

	@Override
	public BizMileVO getBizMile(String pj_id) {
		return getSqlSession().selectOne("projectDAO.getBizMile", pj_id);
	}

	@Override
	public void insertProject(ProjectVO project) {
		getSqlSession().insert("projectDAO.insertProject", project);
	}

	@Override
	public void insertPbudget(ProjectVO vo) {
		getSqlSession().insert("projectDAO.insertPbudget", vo);
	}

	@Override
	public void insertPbiz_mile(String pj_id) {
		getSqlSession().insert("projectDAO.insertPbiz_mile", pj_id);
	}

	@Override
	public void pjneeds_Insert(String pj_id) {
		getSqlSession().insert("projectDAO.pjneeds_Insert", pj_id);
	}

	@Override
	public ProjectVO getMoney(String pj_id) {
		return getSqlSession().selectOne("projectDAO.getMoney", pj_id);
	}

	@Override
	public void moneyUpdate(ProjectVO vo) {
		getSqlSession().update("projectDAO.moneyUpdate", vo);
	}

	@Override
	public ProjectVO getProject(String pj_id) {
		return getSqlSession().selectOne("projectDAO.getProject", pj_id);
	}

	@Override
	public void projectUpdate(ProjectVO vo) {
		getSqlSession().update("projectDAO.projectUpdate", vo);
	}

	@Override
	public void projectDelete(String pj_id) {
		getSqlSession().delete("projectDAO.projectDelete", pj_id);
	}

	@Override
	public List<ExEmplMM> getExEmplList() {
		return getSqlSession().selectList("projectDAO.getExEmplList");
	}

	@Override
	public void budgetUpdate(ProjectVO vo) {
		getSqlSession().update("projectDAO.budgetUpdate", vo);
	}

	@Override
	public int pjCheck(String pj_id) {
		return getSqlSession().selectOne("projectDAO.pjCheck", pj_id);
	}

	@Override
	public List<ProjectVO> projectSearch(ProjectVO vo) {
		return getSqlSession().selectList("projectDAO.projectSearch", vo);
	}

	@Override
	public List<ProjectVO> pjSearch(Map<String, Object> map) {
		return getSqlSession().selectList("projectDAO.pjSearch", map);
	}

	@Override
	public List<BizMileVO> bizmileSearch(BizMileVO vo) {
		return getSqlSession().selectList("projectDAO.bizmileSearch", vo);
	}

	@Override
	public List<ProjectVO> getProjectListTest(Map<String, String> map) {
		return getSqlSession().selectList("projectDAO.getProjectListTest", map);
	}
	
	@Override
	public ProjectVO getProjectDetailTest(Map<String, String> map) {
		return getSqlSession().selectOne("projectDAO.getProjectDetailTest", map);
	}
	
	@Override
	public void insertProjectTest(ProjectVO vo) {
		getSqlSession().insert("projectDAO.insertProjectTest", vo);
	}
	
	@Override
	public void deleteProjectTest(ProjectVO vo) {
		getSqlSession().insert("projectDAO.deleteProjectTest", vo);
	}
}
