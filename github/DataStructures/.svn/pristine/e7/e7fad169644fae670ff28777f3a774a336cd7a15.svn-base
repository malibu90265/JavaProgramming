package com.sqisoft.iqs.humanResource.undecided.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.humanResource.deployRequirements.service.DeployRequirementsService;
import com.sqisoft.iqs.humanResource.deployRequirements.vo.DeployRequirementsVO;
import com.sqisoft.iqs.humanResource.undecided.service.UndecidedService;
import com.sqisoft.iqs.humanResource.undecided.vo.UndecidedVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class UndecidedController {
	
	private UndecidedService undecidedService;
	private DeployRequirementsService deployRequirementsService;
	
	public void setUndecidedService(
			UndecidedService undecidedService) {
		this.undecidedService = undecidedService;
	}
	
	public void setDeployRequirementsService(
			DeployRequirementsService deployRequirementsService) {
		this.deployRequirementsService =  deployRequirementsService;
	}
	
	// 미결현황
	@RequestMapping("/humanResource/undecided")
	public String undecided(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/undecided/undecided";
	}
	
	@RequestMapping("/humanResource/undecided/selectTeam")
	public ModelAndView selectTeam() {
		
		ModelAndView mav = new ModelAndView();
		List<DeployRequirementsVO> teams = deployRequirementsService.getSearchTeamListAjax();
		
		mav.addObject("teams", teams);
		mav.setViewName("/humanResource/undecided/undecidedSearch");
		return mav;
	}
	
	@RequestMapping("/humanResource/undecided/getUndecidedList")
	public ModelAndView getUndecidedList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String tm_id = request.getParameter("tm_id");
		List<UndecidedVO> UndecidedList = undecidedService.getUndecidedList(tm_id);
		
		mav.addObject("UndecidedList", UndecidedList);	
		mav.setViewName("/humanResource/undecided/undecidedList");
		return mav;
	}
	
	@RequestMapping("/humanResource/undecided/getUndecidedModifyForm")
	public ModelAndView getUndecidedModifyForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		SessionController.SessionReturnMaSalHr(mav, request);	// 권한
		
		String pj_id = request.getParameter("pj_id");
		List<UndecidedVO> deployList = undecidedService.getUndecidedModifyForm(pj_id);
		
		mav.addObject("deployList", deployList);
		mav.setViewName("/humanResource/undecided/undecidedModifyForm");
		return mav;
	}
	
	@RequestMapping("/humanResource/undecided/insertUndecided")
	@ResponseBody
	public void insertUndecided(HttpServletRequest request) {
		
		String pj_id = request.getParameter("pj_id");
		String pr_sq = request.getParameter("pr_sq");
		String pr_start_date = request.getParameter("pr_start_date");
		String pr_end_date = request.getParameter("pr_end_date");
		String pr_uprice = request.getParameter("pr_uprice");
		String pr_name = request.getParameter("pr_name");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pj_id", pj_id);
		map.put("pr_sq", pr_sq);
		map.put("pr_start_date", pr_start_date);
		map.put("pr_end_date", pr_end_date);
		map.put("pr_uprice", pr_uprice);
		map.put("pr_name", pr_name);
		
		undecidedService.insertUndecided(map);
	}
}
