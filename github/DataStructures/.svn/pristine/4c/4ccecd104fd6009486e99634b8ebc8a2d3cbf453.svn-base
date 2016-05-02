package com.sqisoft.iqs.project.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.project.dao.ProjectDAO;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;


public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	@Override
	public List<ProjectStatusVO> getProjectStatusList() {
		List<ProjectStatusVO> pjStatusList = this.projectDAO.getProjectStatusList();
		if(pjStatusList == null) pjStatusList = new ArrayList<ProjectStatusVO>();
		return pjStatusList;
	}
	
	@Override
	public List<ProjectVO> getProjectList(Map<String, Object> params) {
		
		List<ProjectVO> projectList = this.projectDAO.getProjectList(params);
		if(projectList == null) projectList = new ArrayList<ProjectVO>();
		
		return projectList;
	}
	
	@Override
	public ProjectVO getProjectInfo(String pj_id) {
		ProjectVO project = this.projectDAO.getProjectInfo(pj_id);
		if(project == null) project = new ProjectVO();
		
		return project;
	}

	@Override
	public List<ProjectStageVO> getProjectStageList() {
		return this.projectDAO.getProjectStageList();
	}
	
	@Override
	public void modifyProjectInfo(ProjectVO projectVO) {
		this.projectDAO.modifyProjectInfo(projectVO);
	}
	
	@Override
	public void modifyProjectProfitAndLossInfo(ProjectVO projectVO) {
		this.projectDAO.modifyProjectProfitAndLossInfo(projectVO);
	}
	
	@Override
	public void deleteProjectInfo(String pj_id) {
		this.projectDAO.deleteProjectInfo(pj_id);
	}
	
	@Override
	public Map<String, Object> checkDuplicate(String pjId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pjId);
		if( this.projectDAO.checkDuplicate(params) ) {
			// 중복이 되는 경우
			resultMap.put("result", false);
			resultMap.put("message", pjId + "가 이미 생성되어 있습니다!");
			
		}
		else {
			resultMap.put("result", true);
		}
		return resultMap;
	}
	
	public ModelAndView putNewProjectDetail(ProjectVO projectVO){
		ModelAndView view = new ModelAndView();
		
		if(this.projectDAO.putNewProjectDetail(projectVO)){
			Map<String, String> params = new HashMap<String, String>();
			params.put("pj_id", projectVO.getPj_id());
			
			view.setViewName("project/projectModifyForm");
			view.addObject("projectVO", this.projectDAO.getProjectInfo(params));
		}
		
		return view;
	}
	
	@Override
	public int setPjYearSalesAjax(Map<String, String> temp) {

		Calendar calendar = Calendar.getInstance();
		int this_year = calendar.get(Calendar.YEAR);
		int start_year = Integer.parseInt( temp.get("pj_start_date").split("-")[0] );
		int end_year = Integer.parseInt( temp.get("pj_end_date").split("-")[0] );
		
		if(start_year <= this_year) {
			
			// 해당 프로젝트의 전체 기간
			List<Integer> pj_start_date = CalendarUtil.convertStringDateToIntegerDate(temp.get("pj_start_date"));
			List<Integer> pj_end_date = CalendarUtil.convertStringDateToIntegerDate(temp.get("pj_end_date"));
			double totalday = CalendarUtil.getTotalDayToIntegerDate(pj_start_date, pj_end_date);
			
			// 현재 연도에 해당하는 기간
			String set_start_date = "";
			if(start_year == this_year) {
				set_start_date = temp.get("pj_start_date");
			}
			else {
				set_start_date = this_year + "-01-01";
			}
			
			String set_end_date = "";
			if(end_year == this_year) {
				set_end_date = temp.get("pj_end_date");
			}
			else if(this_year < end_year) {
				set_end_date = this_year + "-12-31";
			}
			
			List<Integer> start_date = CalendarUtil.convertStringDateToIntegerDate(set_start_date);
			List<Integer> end_date = CalendarUtil.convertStringDateToIntegerDate(set_end_date);
			double presentday = CalendarUtil.getTotalDayToIntegerDate(start_date, end_date);
			
			double performanceRate = Math.round( (presentday/totalday)*1000d ) / 1000d;

			// 금년 매출액 
			int pj_year_sales = (int) Math.round(Integer.parseInt( temp.get("pj_amount") ) * performanceRate);
			return pj_year_sales;
		}
		return 0;
	}
	
	public int getProjectNum(String pj_id){
		return this.projectDAO.getProjectNum(pj_id);
	}
}
