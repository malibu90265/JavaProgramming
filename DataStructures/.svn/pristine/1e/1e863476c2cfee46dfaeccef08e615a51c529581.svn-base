package com.sqisoft.iqs.pf.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.pf.project.dao.ProjectDAO;
import com.sqisoft.iqs.pf.project.service.ProjectServiceIF;
import com.sqisoft.iqs.pf.vo.BizMileVO;
import com.sqisoft.iqs.pf.vo.ProjectVO;

public class ProjectServiceImpl implements ProjectServiceIF {

	ProjectDAO projectDao;
	
	public void setProjectDao(ProjectDAO projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public List<ProjectVO> getProjectList() {
		List<ProjectVO> project_list = projectDao.getProjectList();
		System.out.println("project!!!!!!!!!!!!!!" + project_list);
		for (ProjectVO p : project_list) {
			p.setBudget_sales((int) (p.getBudget_contract_sales()
					* p.getPj_operate() / (double) 100));
		}
		return project_list;
	}

	@Override
	public void projectUpdate(ProjectVO vo) {
		projectDao.projectUpdate(vo);
		projectDao.budgetUpdate(vo);
	}

	@Override
	public ProjectVO getProject(String pj_id) {
		return projectDao.getProject(pj_id);
	}

	@Override
	public List<BizMileVO> getBizMileList() {
		List<BizMileVO> list = projectDao.getBizMileList();
		return list;
	}

	@Override
	public void bizMileUpdate(BizMileVO vo) {
		 String step1 = "고객접촉";
		 String step2 = "니즈분석";
		 String step3 = "고객면담";
		 String step4 = "PT발표";
		 String step5 = "제안입찰";
		 String step6 = "계약";
		 String step7 = "수행";
		 String step8 = "사후관리(MA)";
		 
		 if (vo.getNeeds_anal().equals("")) {
			 vo.setBiz_stat(step1); 
		 } else if (vo.getCus_converse().equals("")) {
			 vo.setBiz_stat(step2);
		 } else if (vo.getPresent().equals("")) {
			 vo.setBiz_stat(step3);
		 } else if (vo.getPropose().equals("")) {
			 vo.setBiz_stat(step4);
		 } else if (vo.getContract().equals("")) {
			 vo.setBiz_stat(step5);
		 } else if (vo.getPerform().equals("")) {
			 vo.setBiz_stat(step6);
		 } else if (vo.getAfterservice().equals("")) {
			 vo.setBiz_stat(step7);
		 } else {
			 vo.setBiz_stat(step8);
		 }
		
		 projectDao.bizMileUpdate(vo);
	}

	@Override
	public BizMileVO getBizMile(String pj_id) {
		return projectDao.getBizMile(pj_id);
	}

	@Override
	public void insertProject(ProjectVO project) {
		projectDao.insertProject(project);
	}

	@Override
	public void insertPbudget(ProjectVO vo) {
		projectDao.insertPbudget(vo);
	}

	@Override
	public void insertPbiz_mile(String pj_id) {
		projectDao.insertPbiz_mile(pj_id);
	}
	
	

	@Override
	public void pjneeds_Insert(String pj_id) {
		projectDao.pjneeds_Insert(pj_id);
	}

	@Override
	public void moneyUpdate(ProjectVO vo) {
		projectDao.moneyUpdate(vo);
	}

	@Override
	public ProjectVO getMoney(String pj_id) {
		return projectDao.getMoney(pj_id);
	}

	@Override
	public void projectDelete(String pj_id) {
		projectDao.projectDelete(pj_id);
	}

	@Override
	public int pjCheck(String pj_id) {
		return projectDao.pjCheck(pj_id);
	}

	@Override
	public List<ProjectVO> projectSearch(String searchid,
			String searchteam, String searchprog) {
		ProjectVO list = new ProjectVO(searchid, searchteam, searchprog);
		return projectDao.projectSearch(list);
	}

	@Override
	public List<BizMileVO> bizmileSearch(BizMileVO vo) {
		List<BizMileVO> bizMileList = new ArrayList<BizMileVO>();  
		bizMileList = projectDao.bizmileSearch(vo);
		return bizMileList;
	}
	
	@Override
	public List<ProjectVO> getProjectListTest(Map<String, String> map) {
		return null;
	}
	
	@Override
	public ProjectVO getProjectDetailTest(Map<String, String> map) {
		return null;
	}
	
	@Override
	public void insertProjectTest(ProjectVO vo) {
		
	}
	
	@Override
	public void deleteProjectTest(ProjectVO vo) {
		
	}
	
}
