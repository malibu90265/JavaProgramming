package com.sqisoft.iqs.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;


public interface ProjectService {

	public List<ProjectStatusVO> getProjectStatusList();
	
	public Map<String, Object> checkDuplicate(String pjID);

	public ModelAndView putNewProjectDetail(ProjectVO projectVO);
	
	public List<ProjectVO> getProjectList(Map<String, Object> params);

	/*^^*/
	public ProjectVO getProjectInfo(String pj_id);

	public List<ProjectStageVO> getProjectStageList();

	public void modifyProjectInfo(ProjectVO projectVO);

	public void deleteProjectInfo(String pj_id);

	public int setPjYearSalesAjax(Map<String, String> temp);

	public int getProjectNum(String pj_id);

	public void modifyProjectProfitAndLossInfo(ProjectVO projectVO);

}
