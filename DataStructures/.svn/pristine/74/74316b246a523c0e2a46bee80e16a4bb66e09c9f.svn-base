package com.sqisoft.iqs.pf.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.comm.CalcUtil;
import com.sqisoft.iqs.pf.member.service.MemberService;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

@Controller
public class MemberContorller {
	
	private MemberService memberService;
	private TeamServiceIF team_service;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public void setTeam_service(TeamServiceIF team_service) {
		this.team_service = team_service;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		
		// 최근 프로젝트 가져오기
		// 프로젝트 종료일이 현재보다 후인 것만 가져왔습니다.
		List<String> projectList = memberService.getLatestProject();
		for(String project : projectList) {
			System.out.println(project);
		}
		
		ModelAndView view = new ModelAndView();
		view.addObject("projectList", projectList);
		view.setViewName("/login/login_main");
		
		return view;
	}
	
	// 로그인 기본 메소드
	@RequestMapping("/login/project")
	public ModelAndView loginProjet() {
		ModelAndView view = new ModelAndView();
		
		// 최근 프로젝트 가져오기
		// 프로젝트 종료일이 현재보다 후인 것만 가져왔습니다.
		List<String> projectList = memberService.getLatestProject();
		for(String project : projectList) {
			//System.out.println(project);
		}
		
		view.addObject("projectList", projectList);
		view.setViewName("/login/login_main");

		return view;
	}

	
	// 실제 로그인 로직
	@RequestMapping("/login_main")
	public ModelAndView loginMain(LoginVO loginVO, HttpServletRequest request) {
		return this.memberService.doLogin(loginVO, request);
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		return this.memberService.logout(request);
	}
	
	// 비밀번호 변경
	@RequestMapping("/changePwd/modify")
	public ModelAndView doChangePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.memberService.doChangePassword(request, response);
	}
	
	@RequestMapping("/salSearch")
	public ModelAndView salSearch(@RequestParam String pj_id,@RequestParam String division){
		ModelAndView mav = new ModelAndView();
		PjpostingVO vo=new PjpostingVO();
		vo.setDivision(division);
		vo.setPj_id(pj_id);
		List<PjHistoryVO> list=team_service.salSearch(vo);
		
		for(PjHistoryVO p : list){
			p.setMm(CalcUtil.getManMonth(p.getPj_start_day(),p.getPj_end_day()));
		}
		
		mav.addObject("list", list);
		mav.setViewName("JSON");
		return mav;
	}
	
}
