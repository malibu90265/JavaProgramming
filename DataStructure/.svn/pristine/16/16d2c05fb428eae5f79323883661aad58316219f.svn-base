package com.sqisoft.iqs.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project.dao.ProjectDAO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.dao.TeamDAO;
import com.sqisoft.iqs.team.vo.TeamVO;

public class PjProfitAndLossServiceImpl implements PjProfitAndLossService{
	
	private ProjectDAO projectDAO;
	private TeamDAO teamDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public ProjectVO getProfitAndLossModifyForm(String pj_id) {
		
		ProjectVO projectVO = this.projectDAO.getProjectInfo(pj_id);

		return projectVO;
	}
	
	@Override
	public List<ProjectVO> getProjectListAndProfitLoss(Map<String, Object> params) {
		
		List<ProjectVO> projectList = this.projectDAO.getProjectList(params);
		
		Map<String, String> scndParams = new HashMap<String, String>();
		scndParams.put("tm_id", params.get("tm_id").toString());
		scndParams.put("tm_year", params.get("tm_year").toString());
		TeamVO teamVO = this.teamDAO.getTeamInfo(scndParams);
		
		List<Integer> salesProfitList = new ArrayList<Integer>();
		
		for(ProjectVO projectVO : projectList) {
			double douNetSales = projectVO.getPj_year_sales() - projectVO.getPj_matl_cost() - (projectVO.getPj_out_mm() * teamVO.getTm_out_mm_cost());
			int netSales = Integer.parseInt(String.valueOf(Math.round(douNetSales)));
			double douSalesProfit = netSales- (projectVO.getPj_sqi_mm() * teamVO.getTm_sqi_mm_cost()) 
					- projectVO.getPj_extra_cost() - (teamVO.getTm_expnc_rate() * projectVO.getPj_year_sales() / 100); 
			int salesProfit = Integer.parseInt(String.valueOf(Math.round(douSalesProfit)));
			projectVO.setSalesProfit(salesProfit);
		}
		
		return projectList;
	}
	
}
