package com.sqisoft.iqs.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project.dao.PjProgressDAO;
import com.sqisoft.iqs.project.vo.PjProgressSearchVO;
import com.sqisoft.iqs.project.vo.PjProgressVO;

public class PjProgressServiceImpl implements PjProgressService {

	private PjProgressDAO pjProgressDAO;

	public void setPjProgressDAO(PjProgressDAO pjProgressDAO) {
		this.pjProgressDAO = pjProgressDAO;
	}

	@Override
	public List<PjProgressVO> getProjectListByPjProgressSearchConditions(PjProgressSearchVO pjProgressSearchVO) {
		List<PjProgressVO> projectList = this.pjProgressDAO.getProjectListByPjProgressSearchConditions(pjProgressSearchVO);
		if(projectList == null) projectList = new ArrayList<PjProgressVO>();
		
		return projectList;
	}
	
	@Override
	public boolean existWeekProgress(String pj_id, String week) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("week", week);
		
		return this.pjProgressDAO.existWeekProgress(params);
	}
	
	@Override
	public String getPjProgressDonePlan(String pj_id, String lastWeek) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("lastWeek", lastWeek);
		
		return this.pjProgressDAO.getPjProgressDonePlan(params);
	}
	
	@Override
	public PjProgressVO getPjProgressByConditions(String pj_id, String tm_id, String pp_date) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("tm_id", tm_id);
		
		String[] pp = pp_date.split("\\(");
		params.put("pp_date", pp[0]);
		
		PjProgressVO pjProgressVO = this.pjProgressDAO.getPjProgressByConditions(params); 
		if(pjProgressVO == null) pjProgressVO = new PjProgressVO();
		this.stringReplaceAll(PjProgressService.READ, pjProgressVO);
		
		return pjProgressVO;
	}
	
	@Override
	public void insertPjProgress(PjProgressVO pjProgressVO) {
		this.stringReplaceAll(PjProgressService.WRITE, pjProgressVO);
		
		this.pjProgressDAO.insertPjProgress(pjProgressVO);
	}
	
	@Override
	public void modifyPjProgress(PjProgressVO pjProgressVO) {
		this.stringReplaceAll(PjProgressService.WRITE, pjProgressVO);
		
		this.pjProgressDAO.modifyPjProgress(pjProgressVO);
	}
	
	private void stringReplaceAll(int type, PjProgressVO pjProgressVO) {
		if(type == PjProgressService.READ) {
			pjProgressVO.setPp_done(pjProgressVO.getPp_done().replaceAll("<br/>", "\r\n"));
			pjProgressVO.setPp_plan(pjProgressVO.getPp_plan().replaceAll("<br/>", "\r\n"));
			pjProgressVO.setPp_issue(pjProgressVO.getPp_issue().replaceAll("<br/>", "\r\n"));
		} else if(type == PjProgressService.WRITE) {
			pjProgressVO.setPp_done(pjProgressVO.getPp_done().replaceAll("\r\n", "<br/>"));
			pjProgressVO.setPp_plan(pjProgressVO.getPp_plan().replaceAll("\r\n", "<br/>"));
			pjProgressVO.setPp_issue(pjProgressVO.getPp_issue().replaceAll("\r\n", "<br/>"));
		}
	}
	
	@Override
	public void deletePjProgres(String pj_id, String pp_date) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("pp_date", pp_date);
		
		this.pjProgressDAO.deletePjProgres(params);
	}
	
	@Override
	public List<PjProgressVO> getPjProgressList(String tm_id, String pp_date) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("tm_id", tm_id);
		params.put("pp_date", pp_date);
		
		List<PjProgressVO> pjProgressList = this.pjProgressDAO.getPjProgressList(params);
		if(pjProgressList == null) pjProgressList = new ArrayList<PjProgressVO>();
		
		return pjProgressList;
	}
}
