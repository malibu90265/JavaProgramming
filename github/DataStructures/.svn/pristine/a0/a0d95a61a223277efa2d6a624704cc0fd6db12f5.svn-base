package com.sqisoft.iqs.team.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.team.vo.TeamVO;

public class TeamDAOImpl extends SqlSessionDaoSupport implements TeamDAO {
	
	@Override
	public boolean isTmName(Map<String, String> params) {
		int isTmNameCnt = getSqlSession().selectOne("teamDAO.isTmName", params);
		return isTmNameCnt > 0;
	}
	
	@Override
	public boolean checkDuplicate(Map<String, String> params) {
		int duplCount = getSqlSession().selectOne("teamDAO.checkDuplicate", params);
		return duplCount > 0;
	}
	
	@Override
	public boolean putNewTeamDetail(TeamVO teamVO) {
		int count = getSqlSession().insert("teamDAO.putNewTeamDetail", teamVO);
		return count > 0;
	}
	
	@Override
	public TeamVO getTeamInsertForm(String team_id) {
		return getSqlSession().selectOne("teamDAO.getTeamDetail", team_id);
	}
	
	@Override
	public float getTeamPJInfo(String tm_id){
		return getSqlSession().selectOne("teamDAO.getTeamPJInfo", tm_id);
	}
	
	@Override
	public TeamVO getTeamInfo(Map<String, String> params) {
		return getSqlSession().selectOne("teamDAO.getTeamInfo", params);
	}
	
	@Override
	public void modifyTeamInfo(TeamVO teamVO) {
		getSqlSession().update("teamDAO.modifyTeamInfo", teamVO);
	}
	
	@Override
	public void deleteTeamInfo(Map<String, String> params) {
		getSqlSession().delete("teamDAO.deleteTeamInfo", params);
	}
	@Override
	public List<TeamVO> getTeamList(String tm_year) {
		return getSqlSession().selectList("teamDAO.getTeamInfoList", tm_year);
	}

	//empStandBy사용 - teamList
	@Override
	public List<TeamVO> getTeamEmpStandByList() {
		return getSqlSession().selectList("teamDAO.getTeamListEmpStandBy");
	}
	
	@Override
	public List<TeamVO> getTeamList(int year) {
		return getSqlSession().selectList("teamDAO.getTeamInfo_settingList",year);
	}
	
	//pj투입map
	@Override
	public List<TeamVO> getTeamCheckList() {
		return getSqlSession().selectList("teamDAO.getTeamCheckList");
	}
	
	@Override
	public List<TeamVO> getTeamListByYear(int year) {
		return getSqlSession().selectList("teamDAO.getTeamListByYear", year);
	}
	
	

	
}
