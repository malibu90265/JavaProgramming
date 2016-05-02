package com.sqisoft.iqs.team.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.team.dao.TeamDAO;
import com.sqisoft.iqs.team.vo.TeamVO;

public class TeamServiceImpl implements TeamService {

	private TeamDAO teamDAO;

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public List<TeamVO> getTeamListAjax(String tm_year){
		return teamDAO.getTeamList(tm_year);
	}
	
	@Override
	public boolean isTmName(String tm_year, String tm_id, String tm_name) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("tm_year", tm_year);
		params.put("tm_id", tm_id);
		params.put("tm_name", tm_name);
		
		return this.teamDAO.isTmName(params);
	}
	
	@Override
	public Map<String, Object> checkDuplicate(TeamVO teamVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("tm_id", teamVO.getTm_id());
		params.put("tm_year", teamVO.getTm_year());
		
		if( this.teamDAO.checkDuplicate(params) ) {
			// 중복이 되는 경우
			resultMap.put("result", false);
			resultMap.put("message", teamVO.getTm_year() + "년의 " + teamVO.getTm_id() + " 팀이 이미 생성되어 있습니다!");
			
		}
		else {
			resultMap.put("result", true);
		}
		
		return resultMap;
	}

	@Override
	public ModelAndView putNewTeamDetail(TeamVO teamVO) {
		ModelAndView view = new ModelAndView();
		
		if( this.teamDAO.putNewTeamDetail(teamVO) ) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("tm_id", teamVO.getTm_id());
			params.put("tm_year", teamVO.getTm_year());
			
			view.setViewName("team/teamModifyForm");
			view.addObject("teamVO", this.teamDAO.getTeamInfo(params));
		}
		
		return view;
	}
	
	@Override
	public TeamVO getTeamInfo(String tm_year, String tm_id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("tm_year", tm_year);
		params.put("tm_id", tm_id);
		
		TeamVO teamVO = this.teamDAO.getTeamInfo(params);
		if(teamVO == null) teamVO = new TeamVO();
		
		return teamVO;
	}
	
	@Override
	public void modifyTeamInfo(TeamVO teamVO) {
		this.teamDAO.modifyTeamInfo(teamVO);
	}
	
	@Override
	public void deleteTeamInfo(String tm_year, String tm_id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("tm_year", tm_year);
		params.put("tm_id", tm_id);
		
		this.teamDAO.deleteTeamInfo(params);
	}
	
	//teamList - selectBox용 - empStandBy에서 사용.
	@Override
	public List<TeamVO> getTeamEmpStandByList() {
		return teamDAO.getTeamEmpStandByList();
	}

	@Override
	public List<TeamVO> getTeamListAjax(int year) {
		return teamDAO.getTeamList(year);
	}
	
	//pj투입 map
	@Override
	public List<TeamVO> getTeamCheckList() {
		return teamDAO.getTeamCheckList();
	}
	
}
