package com.sqisoft.iqs.hr.pj.posting.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.pj.posting.dao.PjpostingDAO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public class PjpostingDAOImpl extends SqlSessionDaoSupport implements PjpostingDAO {

	@Override
	public PjpostingVO pjposting_getPJ(String pj_id) {
		return getSqlSession().selectOne("pjpostingDao.pjposting_getPJ", pj_id);
	}

	@Override
	public List<PjpostingVO> pjposting_SearchList(Map<String, String> hash) {
		return getSqlSession().selectList("pjpostingDao.pjposting_SearchList", hash);
	}

	@Override
	public List<Employee_VO> getNoPlaceEmpList() {
		return getSqlSession().selectList("pjpostingDao.getNoPlaceEmpList");
	}

	@Override
	public List<PjpostingVO> pjposting_getEmp(String pj_id) {
		return getSqlSession().selectList("pjpostingDao.pjposting_getEmp", pj_id);
	}

	@Override
	public List<String> getEmpSkillList(String empname) {
		return getSqlSession().selectList("pjpostingDao.getEmpSkillList", empname);
	}

	@Override
	public List<String> getPJSkillList(String pj_id) {
		return getSqlSession().selectList("pjpostingDao.getPJSkillList", pj_id);
	}

	@Override
	public String getCpstartday(String name) {
		return getSqlSession().selectOne("pjpostingDao.getCpstartday", name);
	}

	@Override
	public String getHireDateByYear(String name) {
		return getSqlSession().selectOne("pjpostingDao.getHireDateByYear", name);
	}

	@Override
	public String getQuitDateByYear(String name) {
		return getSqlSession().selectOne("pjpostingDao.getQuitDateByYear", name);
	}

	@Override
	public List<Employee_VO> emppjposting_Search(SkillVO vo) {
		return getSqlSession().selectList("pjpostingDao.emppjposting_Search");
	}

	@Override
	public List<PjpostingVO> getPJHistory(String pj_id) {
		return getSqlSession().selectList("pjpostingDao.getPJHistory", pj_id);
	}

	@Override
	public void pjposting_Update(PjHistoryVO ph_vo) {
		getSqlSession().update("pjpostingDao.pjposting_Update", ph_vo);
	}

	@Override
	public void pjposting_Insert(PjHistoryVO ph_vo) {
		getSqlSession().insert("pjpostingDao.pjposting_Insert", ph_vo);
	}

	@Override
	public void pjposting_delete(Map<String, String> map) {
		getSqlSession().delete("pjpostingDao.pjposting_delete", map);
	}

	@Override
	public Map<String, String> pjposting_empCheck(String name) {
		return getSqlSession().selectOne("pjpostingDao.pjposting_empCheck", name);
	}

	@Override
	public List<PjpostingVO> pjposting_getEmpPast(String pj_id) {
		return getSqlSession().selectList("pjpostingDao.pjposting_getEmpPast", pj_id);
	}

	@Override
	public void quithistoryDelete(Map<String, String> hash) {
		getSqlSession().delete("pjpostingDao.quithistoryDelete", hash);
	}

	@Override
	public void quitUpdate(Map<String, String> hash) {
		getSqlSession().update("pjpostingDao.quitUpdate", hash);
	}
	
	@Override
	public List<Employee_VO> pjposting_getEmployessByName(String name) {
		return getSqlSession().selectList("pjpostingDao.employeeList", name);
	}
	
	@Override
	public List<PjpostingVO> getPjIntersecDur(Map<String, String> map) {
		return getSqlSession().selectList("pjpostingDao.pjIntersecDur", map);
	}
}
