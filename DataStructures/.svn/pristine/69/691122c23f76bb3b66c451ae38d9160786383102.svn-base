package com.sqisoft.iqs.team.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.team.vo.TeamVO;

public interface TeamService {

	public ModelAndView putNewTeamDetail(TeamVO teamVO);

	public TeamVO getTeamInfo(String tm_year, String tm_id);
	
	public void modifyTeamInfo(TeamVO teamVO);

	public void deleteTeamInfo(String tm_year, String tm_id);

	public Map<String, Object> checkDuplicate(TeamVO teamVO);

	//teamList - selectbox용 - empStandBy에서 사용.
	public List<TeamVO> getTeamEmpStandByList();

	public List<TeamVO> getTeamListAjax(String tm_year);

	public List<TeamVO> getTeamListAjax(int year);

	public boolean isTmName(String tm_year, String tm_id, String tm_name);

	public List<TeamVO> getTeamCheckList();
	
	//pj투입 map

	
}
