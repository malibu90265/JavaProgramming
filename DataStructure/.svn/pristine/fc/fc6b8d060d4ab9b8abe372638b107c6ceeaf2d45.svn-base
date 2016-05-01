package com.sqisoft.iqs.hr.outsal.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sqisoft.iqs.hr.outsal.dao.OutSalHistoryDAO;
import com.sqisoft.iqs.hr.outsal.service.OutSalHistoryService;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public class OutSalHistoryServiceImpl implements OutSalHistoryService {
	private OutSalHistoryDAO outSalHistoryDAO;
	
	public void setOutSalHistoryDAO(OutSalHistoryDAO outSalHistoryDAO) {
		this.outSalHistoryDAO = outSalHistoryDAO;
	}
	@Override
	public List<OutSal_historyVO> getHistoryList(String name) {
		
		return outSalHistoryDAO.getHistoryList(name);
	}
	@Override
	public void deleteHistory(OutSal_historyVO vo) throws ParseException {
		outSalHistoryDAO.deleteHistory(vo);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date=dateFormat.parse(vo.getHire_date());
        cal.setTime(date);
        cal.add(Calendar.DATE, 1); 
        OutSal_historyVO temp=new OutSal_historyVO(vo.getName(),dateFormat.format(cal.getTime()),0,0);
        PjHistoryVO first=outSalHistoryDAO.checkHistory(temp);
        cal.add(Calendar.DATE, -3); 
        temp=new OutSal_historyVO(vo.getName(),dateFormat.format(cal.getTime()),0,0);
        PjHistoryVO second=outSalHistoryDAO.checkHistory(temp);
        if(first!=null && second!=null && first.getPj_id().equals(second.getPj_id()))
        {
        	PjHistoryVO result=new PjHistoryVO(vo.getName(),second.getPj_id(),second.getPj_start_day(),first.getPj_end_day(),"");
        	outSalHistoryDAO.deletePjhistory(first);
        	outSalHistoryDAO.deletePjhistory(second);
        	outSalHistoryDAO.insertPjhistory(result);
        }
		if(outSalHistoryDAO.checkClear(vo.getName())==0){
			outSalHistoryDAO.adjustSal(vo.getName());
		}
		
	}
	@Override
	public OutSal_historyVO getHistory(String name) {
		return outSalHistoryDAO.getHistory(name);
	}
	@Override
	public void deleteHistoryAll(String name){
		outSalHistoryDAO.deleteHistoryAll(name);
	}
}
