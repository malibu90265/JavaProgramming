package com.sqisoft.iqs.pf.schedule.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.pf.schedule.dao.WeekBudgetDAO;
import com.sqisoft.iqs.pf.vo.WeekChartVO;

public class WeekBudgetDAOImpl extends SqlSessionDaoSupport implements WeekBudgetDAO {

	@Override
	public void insertWeekChart(WeekChartVO vo) {
		getSqlSession().insert("weekBudgetDAO.insertWeekChart", vo);
	}

	@Override
	public List<WeekChartVO> getWeekChartList() {
		return getSqlSession().selectList("weekBudgetDAO.getWeekChartList");
	}

	@Override
	public List<WeekChartVO> getWeekChartListTot() {
		return getSqlSession().selectList("weekBudgetDAO.getWeekChartListTot");
	}

}
