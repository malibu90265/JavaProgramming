package com.sqisoft.iqs.humanResource.humanResource.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.humanResource.humanResource.service.HRPriceService;
import com.sqisoft.iqs.humanResource.vo.HRPriceInputVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class HRPriceController {
	
	private HRPriceService hrPriceService;
	private TeamService teamService;

	public void setHrPriceService(HRPriceService hrPriceService) {
		this.hrPriceService = hrPriceService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	// 직급단가 관리
	@RequestMapping("/humanResource/hrPriceMain")
	public String hrPriceMainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/hrPrice/hrPrice";
	}

	@RequestMapping("/humanResource/getHRPriceSearchFormAjax")
	public ModelAndView getHRPriceSearchFormAjax() {
		
		List<TeamVO> teamList = this.teamService.getTeamListAjax( String.valueOf(CalendarUtil.getPresentYear()) );
		
		ModelAndView view = new ModelAndView();
		view.addObject("teamList", teamList);
		view.setViewName("/humanResource/hrPrice/hrPriceSearchForm");
		return view;
	}
	
	@RequestMapping("/humanResource/getHRPriceList")
	public ModelAndView getHRPriceList() {
		
		List<TeamVO> teamList = this.teamService.getTeamListAjax( String.valueOf(CalendarUtil.getPresentYear()) );
		
		List<List<HRPriceVO>> hrPriceListByTeam = new ArrayList<List<HRPriceVO>>();
		List<String> teamNameList = new ArrayList<String>();
		
		List<HRPriceVO> hrPriceList = null;
		for(int i = 0; i < teamList.size(); i++) {
			TeamVO team = teamList.get(i);
			String tm_id = team.getTm_id();
			
			hrPriceList = this.hrPriceService.getHRPriceIfoByTeamId(tm_id);
			hrPriceListByTeam.add(hrPriceList);
			teamNameList.add(team.getTm_name());
		}
		
		ModelAndView view = new ModelAndView();

		view.addObject("teamNameList", teamNameList);
		view.addObject("hrPriceListByTeam", hrPriceListByTeam);
		view.setViewName("/humanResource/hrPrice/hrPriceList");
		
		return view;
	}
	
	@RequestMapping("/humanResource/getHRPriceInsertFormAjax")
	public ModelAndView getHRPriceInsertFormAjax(String tm_id) {
		
		List<HRPriceVO> hrPriceList = this.hrPriceService.getHRPriceIfoByTeamId(tm_id);
		
		ModelAndView view = new ModelAndView();
		view.addObject("hrPriceList", hrPriceList);
		view.setViewName("/humanResource/hrPrice/hrPriceInsertForm");
		return view;
	}
	
	@RequestMapping("/humanResource/insertHRPriceInfoAjax")
	@ResponseBody
	public Map<String, String> insertHRPriceInfoAjax(HRPriceInputVO vo) {

		List<HRPriceVO> hrPriceList = new ArrayList<HRPriceVO>();
		
		String tm_id = vo.getHp_team();
		
		HRPriceVO hrPriceVO = null;
		for(int i = 0; i < vo.getHp_position().size(); i++) {
			hrPriceVO = new HRPriceVO();
			hrPriceVO.setHp_team(tm_id);
			hrPriceVO.setHp_position( vo.getHp_position().get(i) );
			hrPriceVO.setHp_mon_price( Integer.parseInt(vo.getHp_mon_price().get(i)) );
			hrPriceVO.setHp_mon_cost( Integer.parseInt(vo.getHp_mon_cost().get(i)) );
			
			hrPriceList.add(hrPriceVO);
		}
		
		
		String message;
		if( this.hrPriceService.updateHRPriceInfoList(hrPriceList) ) {
			message = "직급단가가 수정되었습니다";
		}
		else{
			message = "직급단가 수정에 실패하였습니다";
		}
			
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("tm_id", tm_id);		
		params.put("message", message);
		return params;
	}
}
