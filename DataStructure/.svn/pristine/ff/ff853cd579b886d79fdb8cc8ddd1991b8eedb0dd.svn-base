package com.sqisoft.iqs.rp.service.impl;

import java.text.ParseException;
import java.util.List;

import com.sqisoft.iqs.hr.util.DateTime;
import com.sqisoft.iqs.rp.dao.ReportDAO;
import com.sqisoft.iqs.rp.service.ReportServiceIF;
import com.sqisoft.iqs.rp.vo.Report2VO;
import com.sqisoft.iqs.rp.vo.ReportVO;

public class ReportServiceImpl implements ReportServiceIF {
	
	ReportDAO reportDao;
	
	public void setReportDao(ReportDAO reportDao) {
		this.reportDao = reportDao;
	}

	@Override
	public ReportVO getReport(ReportVO vo) {
		return reportDao.getReport(vo);
	}

	@Override
	public List<String> getWeekDateList() {
		return reportDao.getWeekDateList();
	}
	
	public String weekReportDate(String str) throws NumberFormatException, ParseException {
		while(DateTime.whichDay(str)!=5){
			str = DateTime.addDays(str, 1, "yyyy-MM-dd");
		}
		return str;
	}

	@Override
	public void insertReport(ReportVO reportVO) {
		reportDao.insertReport(reportVO);
	}

	@Override
	public void updateReport(ReportVO reportVO) {
		reportDao.updateReport(reportVO);
	}

	@Override
	public List<Report2VO> getReport2() {
		return reportDao.getReport2();
	}

	@Override
	public List<String> getWeekDateList2() {
		return reportDao.getWeekDateList2();
	}
}
