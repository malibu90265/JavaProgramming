package com.sqisoft.iqs.pf.project.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.pf.vo.BizMileVO;
import com.sqisoft.iqs.pf.vo.ExEmplMM;
import com.sqisoft.iqs.pf.vo.ProjectVO;

public interface ProjectDAO {
	public abstract List<ProjectVO> getProjectList();
	public abstract List<BizMileVO> getBizMileList();
	public abstract void bizMileUpdate(BizMileVO vo);
	public abstract BizMileVO getBizMile(String pj_id);
	public abstract void insertProject(ProjectVO project);
	public abstract void insertPbudget(ProjectVO vo);
	public abstract void insertPbiz_mile(String pj_id);
	public abstract void pjneeds_Insert(String pj_id);
	public abstract ProjectVO getMoney(String pj_id);
	public abstract void moneyUpdate(ProjectVO vo);
	public abstract ProjectVO getProject(String pj_id);
	public abstract void projectUpdate(ProjectVO vo);
	public abstract void projectDelete(String pj_id);
	public abstract List<ExEmplMM> getExEmplList();
	void budgetUpdate(ProjectVO vo);
	public abstract int pjCheck(String pj_id);
	public abstract List<ProjectVO> projectSearch(ProjectVO vo);
	public abstract List<ProjectVO> pjSearch(Map<String, Object> map);
	public abstract List<BizMileVO> bizmileSearch(BizMileVO vo);

	public abstract List<ProjectVO> getProjectListTest(Map<String, String> map);
	public abstract ProjectVO getProjectDetailTest(Map<String, String> map);
	public abstract void insertProjectTest(ProjectVO vo);
	public abstract void deleteProjectTest(ProjectVO vo);

}
