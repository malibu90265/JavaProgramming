package com.sqisoft.iqs.hr.main.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.main.dao.HrDAO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.MpPlaceVO;
import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;

public class HrDAOImpl extends SqlSessionDaoSupport implements HrDAO {

	@Override
	public void project_Insert(ProjectVO pjVO) {
		getSqlSession().insert("hrDao.project_Insert", pjVO);
	}

	@Override
	public List<MppListVO> emp_MppList(String team_id) {
		return getSqlSession().selectList("hrDao.emp_MppList", team_id);
	}

	@Override
	public List<ProjectCountVO> project_GetCount(String team_id) {
		return getSqlSession().selectList("hrDao.project_GetCount", team_id);
	}

	@Override
	public void emp_Insert(Employee_VO employeeVO) {
		getSqlSession().insert("hrDao.emp_Insert", employeeVO);
	}

	@Override
	public void emp_TimeoffInsert(Map<String, String> hs) {
		getSqlSession().insert("hrDao.emp_TimeoffInsert", hs);
	}

	@Override
	public void pjHistory_TimeoffUpdate(Map<String, String> hs) {
		getSqlSession().update("hrDao.pjHistory_TimeoffUpdate", hs);
	}

	@Override
	public void emp_TimeoffUpdate2(Map<String, String> hs) {
		getSqlSession().update("hrDao.emp_TimeoffUpdate2", hs);
	}

	@Override
	public void emp_TimeoffUpdate3(Map<String, String> hs) {
		getSqlSession().update("hrDao.emp_TimeoffUpdate3", hs);
	}

	@Override
	public void pjHistory_TimeoffDayUpdate(Map<String, String> hs) {
		getSqlSession().update("hrDao.pjHistory_TimeoffDayUpdate", hs);
	}

	@Override
	public Employee_VO emp_getTimeoff(String name) {
		return getSqlSession().selectOne("hrDao.emp_getTimeoff", name);
	}

	@Override
	public void emp_SkillInsert(SkillVO vo) {
		getSqlSession().insert("hrDao.emp_SkillInsert", vo);
	}

	@Override
	public void emp_Update(Employee_VO empVO) {
		getSqlSession().update("hrDao.emp_Update", empVO);
	}

	@Override
	public void emp_TimeoffUpdate(Map<String, String> hs) {
		getSqlSession().update("hrDao.emp_TimeoffUpdate", hs);
	}

	@Override
	public MpPlaceVO getMpplaceInfo(String name) {
		return getSqlSession().selectOne("hrDao.getMpplaceInfo", name);
	}

	@Override
	public void emp_Delete(String name) {
		getSqlSession().delete("hrDao.emp_Delete", name);
	}

	@Override
	public Employee_VO emp_getEmp(Map<String, String> hash) {
		return getSqlSession().selectOne("hrDao.emp_getEmp", hash);
	}

	@Override
	public List<Employee_VO> emp_getEmpList() {
		return getSqlSession().selectList("hrDao.emp_getEmpList");
	}

	@Override
	public List<Employee_VO> emp_SearchEmpList(Map<String, String> hash) {
		return getSqlSession().selectList("hrDao.emp_SearchEmpList", hash);
	}

	@Override
	public Employee_VO mailCheck(Map<String, Object> param) {
		return getSqlSession().selectOne("hrDao.mailCheck", param);
	}

	@Override
	public String getMaxName(String name) {
		return getSqlSession().selectOne("hrDao.getMaxName", name);
	}

	@Override
	public List<Map<String, String>> getSkillOptionsPC() {
		return getSqlSession().selectList("hrDao.getSkillOptionsPC");
	}

	@Override
	public List<Map<String, String>> getSkillOptionsCC(String val) {
		return getSqlSession().selectList("hrDao.getSkillOptionsCC", val);
	}

	@Override
	public List<Map<String, String>> getSkillOptionsDC() {
		return getSqlSession().selectList("hrDao.getSkillOptionsDC");
	}

	@Override
	public List<Map<String, String>> getAreaOptionsPC() {
		return getSqlSession().selectList("hrDao.getAreaOptionsPC");
	}

	@Override
	public List<Map<String, String>> getAreaOptionsCC(String val) {
		return getSqlSession().selectList("hrDao.getAreaOptionsCC", val);
	}

	@Override
	public List<Employee_VO> emp_duplicheck(String name) {
		return getSqlSession().selectList("hrDao.emp_duplicheck", name);
	}

	@Override
	public void emp_SkillDel(String name) {
		getSqlSession().delete("hrDao.emp_SkillDel", name);
	}

	@Override
	public List<SkillVO> getSkill(String name) {
		return getSqlSession().selectList("hrDao.getSkill", name);
	}

	@Override
	public void place_Insert(String name) {
		getSqlSession().insert("hrDao.place_Insert", name);
	}

	@Override
	public void place_Delete(String name) {
		getSqlSession().delete("hrDao.place_Delete", name);
	}

	@Override
	public int teamExist(String team_id) {
		return getSqlSession().selectOne("hrDao.teamExist", team_id);
	}

	@Override
	public void emppj_Insert(Employee_VO empvo) {
		getSqlSession().insert("hrDao.emppj_Insert", empvo);
	}

	@Override
	public List<Employee_VO> empSearch(SkillVO vo) {
		return getSqlSession().selectList("hrDao.empSearch", vo);
	}

	@Override
	public void out_hisReg(OutSal_historyVO hvo) {
		getSqlSession().insert("hrDao.out_hisReg", hvo);
	}

	@Override
	public void out_hisDel(OutSal_historyVO hvo) {
		getSqlSession().delete("hrDao.out_hisDel", hvo);
	}

	@Override
	public void emp_UpdateWithHName(Employee_VO empVO) {
		getSqlSession().update("hrDao.emp_Update", empVO);
	}

	
}
