package com.sqisoft.iqs.pf.schedule.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.pf.schedule.dao.WeekendDAO;
import com.sqisoft.iqs.pf.vo.WeekBudgetVO;
import com.sqisoft.iqs.pf.vo.WeekendVO;

public class WeekendDAOImpl extends SqlSessionDaoSupport implements WeekendDAO {

	@Override
	public void insertLog(WeekendVO vo) {
		getSqlSession().insert("weekendDAO.insertLog", vo);
	}

	@Override
	public List<WeekendVO> getLog(String wb_date) {
		return getSqlSession().selectList("weekendDAO.getLog", wb_date);
	}

	@Override
	public List<WeekBudgetVO> getWeekBudgetListCurrent(String date) {
		return getSqlSession().selectList("weekendDAO.getWeekBudgetListCurrent", date);
	}

	@Override
	public List<WeekBudgetVO> getWeekBudgetListLast(String date) {
		return getSqlSession().selectList("weekendDAO.getWeekBudgetListLast", date);
	}

	@Override
	public String getWeekBudgetDate() {
		return getSqlSession().selectOne("weekendDAO.getWeekBudgetDate");
	}

	@Override
	public List<String> getWeekBudgetDateList() {
		return getSqlSession().selectList("weekendDAO.getWeekBudgetDateList");
	}

	@Override
	public void insertWeekBudget(WeekBudgetVO vo) {
		getSqlSession().insert("weekendDAO.insertWeekBudget", vo);
	}

}
