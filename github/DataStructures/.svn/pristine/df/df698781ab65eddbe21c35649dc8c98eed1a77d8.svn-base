package com.sqisoft.iqs.hr.manplace.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.manplace.dao.ManPlaceDAO;
import com.sqisoft.iqs.hr.vo.EmpMapVO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
import com.sqisoft.iqs.hr.vo.StandByInfoVO;

public class ManPlaceDAOImpl extends SqlSessionDaoSupport implements ManPlaceDAO {

	@Override
	public List<StandByInfoVO> getStandByList() {
		return getSqlSession().selectList("manPlaceDao.getStandByList");
	}

	@Override
	public List<StandByInfoVO> getTeamProjectList(String team_id) {
		return getSqlSession().selectList("manPlaceDao.getTeamProjectList", team_id);
	}

	@Override
	public List<Employee_VO> getPersonalInfo(String name) {
		return getSqlSession().selectList("manPlaceDao.getPersonalInfo", name);
	}

	@Override
	public List<SkillVO> getPersonalSkill(String name) {
		return getSqlSession().selectList("manPlaceDao.getPersonalSkill", name);
	}

	@Override
	public List<SkillVO> getJob(String name) {
		return getSqlSession().selectList("manPlaceDao.getJob", name);
	}

	@Override
	public List<EmpMapVO> getEmpMapList() {
		return getSqlSession().selectList("manPlaceDao.getEmpMapList");
	}

	@Override
	public List<EmpMapVO> getOutMapList() {
		return getSqlSession().selectList("manPlaceDao.getOutMapList");
	}

	@Override
	public List<ProjectVO> getProjectList(String team_id) {
		return getSqlSession().selectList("manPlaceDao.getProjectList", team_id);
	}

	@Override
	public List<StandByInfoVO> getDetailProjectList(Map<String, String> hs) {
		return getSqlSession().selectList("manPlaceDao.getDetailProjectList", hs);
	}

	@Override
	public List<OutSal_historyVO> getOutSalList(Map<String, String> hs) {
		return getSqlSession().selectList("manPlaceDao.getOutSalList", hs);
	}

}
