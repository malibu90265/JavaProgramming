package com.sqisoft.iqs.hr.outsal.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.outsal.service.OutSalHistoryService;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;

@Controller
public class outSalhistoryController {
	
	private OutSalHistoryService outSalHistoryService;
	
	public void setOutSalHistoryService(OutSalHistoryService outSalHistoryService) {
		this.outSalHistoryService = outSalHistoryService;
	}
	
	@RequestMapping(value="/outSal_history.do")
	public ModelAndView outSal_history(@RequestParam String name) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		
		List<OutSal_historyVO> list=outSalHistoryService.getHistoryList(name);
		
		mav.addObject("list",list);
		
		mav.setViewName("history");
		
		return mav;
	}
	
	@RequestMapping("deleteHistory.action")
	public ModelAndView deleteHistory(@RequestParam String name, @RequestParam String hire_date) throws ParseException
	{
		ModelAndView mav=new ModelAndView();
		OutSal_historyVO vo=new OutSal_historyVO();
		
		vo.setName(name);
		vo.setHire_date(hire_date);
		
		outSalHistoryService.deleteHistory(vo);
		
		mav.setViewName("JSON");
		
		return mav;
	}
}
