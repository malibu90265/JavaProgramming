package com.sqisoft.iqs.humanResource.waitingList.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.humanResource.waitingList.service.WaitingListService;
import com.sqisoft.iqs.humanResource.waitingList.vo.WaitingListVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class WaitingListController {

	private WaitingListService waitingListService;
	
	public void setWaitingListService(WaitingListService waitingListService) {
		this.waitingListService = waitingListService;
	}
	
	// 월 별 리스트 전체
	@RequestMapping("/waitingList/list")
	public String getwaitingListList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/waitingList/waitingList";
	}
	
	// 검색
	@RequestMapping("/waitingList/searchForm")
	public ModelAndView getHumanResourceSearchFormAjax(){
		ModelAndView view = new ModelAndView();
		
		// monthOption
		Map<String, String> waitingListOptions = waitingListService.getwaitingListOptions();
		view.addObject("waitingListOptions", waitingListOptions);
		
		view.setViewName("/waitingList/waitingListSearch");
		return view;
	}
	
	// 개별 리스트
	@RequestMapping("/waitingList/januaryToDecember")
	public ModelAndView getJanuaryToDecemberList(HttpServletRequest request) throws Exception {
		
		ModelAndView view = new ModelAndView();
		
		List<WaitingListVO> waitingListVO = waitingListService.getJanuaryToDecemberList();
		
		///List<waitingListVO> list = mapManage(waitingListVO);
		view.addObject("waitingListVO", waitingListVO);
		view.setViewName("JSON");
		
		return view;
		
	}
	
	
}
