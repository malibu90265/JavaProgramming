package com.sqisoft.iqs.rp.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sqisoft.iqs.rp.service.ReportServiceIF;
import com.sqisoft.iqs.rp.vo.Report2VO;
import com.sqisoft.iqs.rp.vo.ReportVO;

@Controller("reportController")
public class ReportController {
	
	private ReportServiceIF reportServiceImpl;
		
	public void setReportServiceImpl(ReportServiceIF reportServiceImpl) {
		this.reportServiceImpl = reportServiceImpl;
	}

	@RequestMapping("viewReport.do")
	public ModelAndView viewReport(HttpServletRequest req) throws NumberFormatException, ParseException {
		
		ModelAndView mav=new ModelAndView();
		
		String w_date = req.getParameter("w_date");
		String team_id = req.getParameter("team_id");
		
		List<String> date_list = reportServiceImpl.getWeekDateList2();
		
		if(team_id == null) { team_id = "1S"; }
		if(w_date == null) { w_date = date_list.get(0);}
		
		Report2VO vo=new Report2VO();
		vo.setTeam_id(team_id);
		vo.setW_date(w_date);

		
		mav.addObject("vo", vo);
		mav.addObject("date_list", date_list);
		
		List<Report2VO> vo_list;
		
		vo_list = reportServiceImpl.getReport2();
		mav.addObject("vo_list", vo_list);
		mav.setViewName("viewReport");
		
		return mav;
	}
	
	@RequestMapping("insertReport.do")
	public ModelAndView insertReport(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("insertReport");
		return mav;
	}
	
	@RequestMapping("updateReport.do")
	public ModelAndView updateReport(HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		
		String w_date = req.getParameter("w_date");
		String team_id = req.getParameter("team_id");
		
		Report2VO reportVO = new Report2VO();
		
		reportVO.setW_date(w_date);
		reportVO.setTeam_id(team_id);

		mav.addObject("vo", reportVO);
		mav.setViewName("updateReport");
		return mav;
	}
	
	@RequestMapping("insertingReport.do")
	public ModelAndView insertingReport(HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		
		String team_id = req.getParameter("team_id");
		String w_date = req.getParameter("w_date");
		String report_txt = req.getParameter("report_txt");
		
		ReportVO reportVO=new ReportVO();
		
		reportVO.setW_date(w_date);
		reportVO.setTeam_id(team_id);
		reportVO.setReport_txt(report_txt);
		
		reportServiceImpl.insertReport(reportVO);
		
		mav.setView(new RedirectView("viewReport.do"));
		return mav;
	}
	
	@RequestMapping("updatingReport.do")
	public ModelAndView updateingReport(HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		
		String team_id = req.getParameter("team_id");
		String w_date = req.getParameter("w_date");
		String report_txt = req.getParameter("report_txt");
		
		ReportVO reportVO=new ReportVO();
		
		reportVO.setW_date(w_date);
		reportVO.setTeam_id(team_id);
		reportVO.setReport_txt(report_txt);
		
		reportServiceImpl.updateReport(reportVO);
		mav.setView(new RedirectView("viewReport.do"));
		return mav;
	}
	
	@RequestMapping("viewReportFiles.do")
	public ModelAndView viewReportFiles(HttpServletRequest req/*,FileVO vo*/) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewReportFiles");
		return mav;
	}
	
	/*@RequestMapping("uploadDocs")		//잠시 주석처리
	public ModelAndView uploadDocs(HttpServletRequest req, FileVO vo) throws IllegalStateException, IOException {
		
		ModelAndView mav = new ModelAndView();
		
		MultipartFile uploadfile = vo.getUploadfile();
		
		String team_id = req.getParameter("team_id");
		String w_date = req.getParameter("w_date");
		
		mav.addObject("team_id", team_id);
		mav.addObject("w_date", w_date);
		
//		String fileName = uploadfile.getOriginalFilename();
		String fileName = w_date + "_" + team_id;
		
		File file = new File("D:/test/"+fileName);
		
		uploadfile.transferTo(file);
		
		vo.setFileName(fileName);

		mav.setViewName("viewReportFiles");
		
		return mav;
	}*/
	
	@RequestMapping(value = "/uploadDocs", method = RequestMethod.POST)
	public String uploadDocs(@RequestParam("filefile") MultipartFile file, HttpServletRequest req) throws IOException {
		
		byte[] fileData = file.getBytes();
		String team_id = req.getParameter("team_id");
		String w_date = req.getParameter("w_date");
		String fileName = team_id + "_" + w_date;
		
		return null; //CommonConstants.uploadPath + fileName;
	}
	
	@RequestMapping("downloadDocs")
	public ModelAndView downloadDocs(HttpServletRequest req) throws FileNotFoundException {
		
		ModelAndView mav = new ModelAndView();
		
		String team_id = req.getParameter("team_id");
		String w_date = req.getParameter("w_date");
		String file_name = req.getParameter("file_name");
		Report2VO re2vo;
		if(team_id!=null&&w_date!=null&&file_name!=null)
			re2vo = new Report2VO(team_id, w_date, file_name);
		else
			re2vo = new Report2VO("1S", "2015-07-13", "2015-07-13_1S");
		
		
		List<Report2VO> vo = reportServiceImpl.getReport2();
		
		
		mav.setView(new RedirectView("viewReport.do"));
		return mav;
	}
	
	@RequestMapping("deleteDocs")	//ajax로 바꾸기
	public ModelAndView deleteDocs(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewReportFiles");
		return mav;
	}
}
