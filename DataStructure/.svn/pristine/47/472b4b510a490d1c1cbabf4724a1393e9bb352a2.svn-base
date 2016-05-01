package com.sqisoft.iqs.project_setting.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project_setting.dao.Project_settingDAO;
import com.sqisoft.iqs.project_setting.service.Project_settingService;
import com.sqisoft.iqs.project_setting.vo.Project_settingVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;

public class Project_settingServiceImpl implements Project_settingService {

	private Project_settingDAO project_settingDAO;
	
	public void setProject_settingDAO(Project_settingDAO project_settingDAO) {
		this.project_settingDAO = project_settingDAO;
	}

	@Override
	public List<Project_settingVO> getProject_settingList(String tm_id) {
		return this.project_settingDAO.getProject_settingList(tm_id);
	}
	
	@Override
	public Project_settingVO getproject_settingInfo(String tm_id, String pj_id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tm_id", tm_id);
		params.put("pj_id", pj_id);
		
		Project_settingVO project_settingInfo = this.project_settingDAO.getProject_settingInfo(params);
		return project_settingInfo;
	}

	@Override
	public List<Skill_envVO> getProject_settingDBList(String name) {
		return this.project_settingDAO.getProject_settingDBList(name);
	}

	@Override
	public List<Skill_envVO> getProject_settingOSList(String name) {
		return this.project_settingDAO.getProject_settingOSList(name);
	}

	@Override
	public List<Skill_envVO> getProject_settingUIList(String name) {
		return this.project_settingDAO.getProject_settingUIList(name);
	}

	@Override
	public List<Skill_envVO> getProject_settingLangList(String name) {
		return this.project_settingDAO.getProject_settingLangList(name);
	}

	@Override
	public List<Skill_envVO> getProject_settingFWList(String name) {
		return this.project_settingDAO.getProject_settingFWList(name);
	}

	@Override
	public List<Skill_envVO> getProject_settingMWList(String name) {
		return this.project_settingDAO.getProject_settingMWList(name);
	}

	@Override
	public void project_settingModifyFormAjax(Project_settingVO project_settingVO) {
		this.project_settingDAO.getProject_settingModifyForm(project_settingVO);
	}
	
	public Project_settingVO getproject_settingResetInfo(String pj_id){
		return this.project_settingDAO.getproject_settingResetInfo(pj_id);
	}

}
