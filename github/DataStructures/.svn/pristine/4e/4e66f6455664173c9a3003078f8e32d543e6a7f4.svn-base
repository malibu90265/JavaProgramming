package com.sqisoft.iqs.team.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.team.vo.TeamVO;

public interface TeamDAO {

	public TeamVO getTeamInsertForm(String team_id);

	public List<TeamVO> getTeamList(String tm_year);

	public TeamVO getTeamInfo(Map<String, String> params);

	public void modifyTeamInfo(TeamVO teamVO);

	public void deleteTeamInfo(Map<String, String> params);

	public boolean checkDuplicate(Map<String, String> params);

	public boolean putNewTeamDetail(TeamVO teamVO);

	// teamList - selectBox용 - empStandBy에서 사용.
	public List<TeamVO> getTeamEmpStandByList();

	// 기본 경비율 가져오기 위해 사용
	public float getTeamPJInfo(String tm_id);

	public List<TeamVO> getTeamList(int year);

	public boolean isTmName(Map<String, String> params);
	
	//pj투입map
	public List<TeamVO> getTeamCheckList();

	public List<TeamVO> getTeamListByYear(int year);

}
