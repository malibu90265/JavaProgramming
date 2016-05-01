package com.sqisoft.iqs.project_setting.dao.impl;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.project_setting.dao.Project_settingDAO;
import com.sqisoft.iqs.project_setting.vo.Project_settingVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;



public class Project_settingDAOImpl extends SqlSessionDaoSupport implements Project_settingDAO {

	@Override
	public List<Project_settingVO> getProject_settingList(String tm_id) {
		return getSqlSession().selectList("project_settingDAO.getProject_settingList", tm_id);
	}

	@Override
	public Project_settingVO getProject_settingInfo(Map<String, Object> params) {
		return getSqlSession().selectOne("project_settingDAO.getProject_settingInfo", params);
	}


	@Override
	public List<Skill_envVO> getProject_settingDBList(String name) {
		return  getSqlSession().selectList("project_settingDAO.getProject_settingSkillList",name);
	}

	@Override
	public List<Skill_envVO> getProject_settingOSList(String name) {
		return  getSqlSession().selectList("project_settingDAO.getProject_settingSkillList",name);
	}

	@Override
	public List<Skill_envVO> getProject_settingUIList(String name) {
		return  getSqlSession().selectList("project_settingDAO.getProject_settingSkillList",name);
	}

	@Override
	public List<Skill_envVO> getProject_settingLangList(String name) {
		return  getSqlSession().selectList("project_settingDAO.getProject_settingSkillList",name);
	}

	@Override
	public List<Skill_envVO> getProject_settingFWList(String name) {
		return  getSqlSession().selectList("project_settingDAO.getProject_settingSkillList",name);
	}

	@Override
	public List<Skill_envVO> getProject_settingMWList(String name) {
		return  getSqlSession().selectList("project_settingDAO.getProject_settingSkillList",name);
	}

	@Override
	public void getProject_settingModifyForm(Project_settingVO project_settingVO) {
		getSqlSession().update("project_settingDAO.project_settingModifyForm", project_settingVO);
		
	}
	
	public Project_settingVO getproject_settingResetInfo(String pj_id){
		return getSqlSession().selectOne("project_settingDAO.getproject_settingResetInfo", pj_id);
	}
	
}
