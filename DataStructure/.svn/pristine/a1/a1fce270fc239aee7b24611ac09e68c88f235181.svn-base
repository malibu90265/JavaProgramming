package com.sqisoft.iqs.project.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;


public interface ProjectDAO {

	public ProjectVO getProjectInfo(String pj_id);

	public List<ProjectStageVO> getProjectStageList();

	public List<ProjectStatusVO> getProjectStatusList();

	public void modifyProjectInfo(ProjectVO projectVO);

	public boolean checkDuplicate(Map<String, String> params);

	public ProjectVO getProjectInfo(Map<String, String> params);

	public boolean putNewProjectDetail(ProjectVO projectVO);
	
	public List<ProjectVO> getProjectList(Map<String, Object> params);

	public void deleteProjectInfo(String pj_id);

	public int getProjectNum(String pj_id);

	public void modifyProjectProfitAndLossInfo(ProjectVO projectVO);

	public List<ProjectVO> getProjectListByTeamId(String tm_id);

}
