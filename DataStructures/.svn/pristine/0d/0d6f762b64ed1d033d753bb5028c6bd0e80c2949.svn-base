package com.sqisoft.iqs.rp.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.rp.dao.ReportDAO;
import com.sqisoft.iqs.rp.vo.Report2VO;
import com.sqisoft.iqs.rp.vo.ReportVO;

public class ReportDAOImpl extends SqlSessionDaoSupport implements ReportDAO {

	@Override
	public ReportVO getReport(ReportVO vo) {
		return getSqlSession().selectOne("reportDAO.getReport", vo);
	}

	@Override
	public List<String> getWeekDateList() {
		return getSqlSession().selectList("reportDAO.getWeekDateList");
	}

	@Override
	public void insertReport(ReportVO reportVO) {
		getSqlSession().insert("reportDAO.insertReport", reportVO);
	}

	@Override
	public void updateReport(ReportVO reportVO) {
		getSqlSession().update("reportDAO.updateReport", reportVO);
	}

	@Override
	public List<Report2VO> getReport2() {
		return getSqlSession().selectList("reportDAO.getReport2");
	}

	@Override
	public List<String> getWeekDateList2() {
		return getSqlSession().selectList("reportDAO.getWeekDateList2");
	}

}
