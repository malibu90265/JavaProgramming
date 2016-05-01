package com.sqisoft.iqs.admin.menu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class SessionController {

	// 권한 설정
	
	// 임원, 영업
	// 사용 : PjProgressController(주간보고), ProjectController(영업관리)
	public static ModelAndView SessionReturn(ModelAndView view, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String message = "";
		
		String hr_positon = loginVO.getHr_position();	// 임원
		String hr_job_skill = loginVO.getHr_job_skill();	// 영업
		String email = loginVO.getEmail();	// 허원무 대리님 exception
		String account = loginVO.getAccount(); // 관리자
		String tm_id = loginVO.getTm_id();
		
		if(hr_positon.contains("임원") || hr_job_skill.contains("영업") || email.contains("hwmkmh") || account.contains("s") || tm_id.contains("6M15")) {
			message = "pass";
		}
		else {
			message = "권한이 없습니다.";
		}
		view.addObject("message", message);
		
		return view;
	}

	// 영업, 회계
	// 사용처 : PjProfitAndLossController(손익관리), PjBudgetController(예산관리)
	public static ModelAndView SessionReturnAccount(ModelAndView view, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String message = "";
		
		String hr_job_skill = loginVO.getHr_job_skill();	// 사업관리(영업), 회계담당
		String account = loginVO.getAccount(); // 관리자
		
		if(hr_job_skill.contains("영업") || hr_job_skill.contains("회계") || account.contains("s")) {
			message = "pass";
		}
		else {
			message = "권한이 없습니다";
		}
		view.addObject("message", message);
		return view;
		
	}

	// 영업, PM
	// 사용처 : Project_settingController(환경관리)
	public static ModelAndView SessionReturnSalAndPM(ModelAndView view, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String message = "";
		
		String hr_job_skill = loginVO.getHr_job_skill();	// 사업관리(영업)
		String hr_role = loginVO.getHr_role();	// PM
		String account = loginVO.getAccount(); // 관리자
		
		if(hr_job_skill.contains("영업") || hr_role.contains("PM") || account.contains("s")) {
			message = "pass";
		}
		else {
			message = "권한이 없습니다.";
		}
		view.addObject("message", message);
		return view;
	}
	
	// 인사
	// 사용처 : 직원정보, 외주정보
	public static ModelAndView SessionReturnHR(ModelAndView view, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String message = "";
		String hr_positon = loginVO.getHr_position();	// 임원
		String hr_job_skill = loginVO.getHr_job_skill();
		String email = loginVO.getEmail();	// 이미숙 차장님, 심은좌 차장님 exception
		String account = loginVO.getAccount(); // 관리자
		
		if(hr_positon.contains("임원") || hr_job_skill.contains("인사") || hr_job_skill.contains("영업") || 
							email.contains("dmsgktn07") || email.contains("lms") || account.contains("s")) {
			message = "pass";
		}
		else {
			message = "권한이 없습니다.";
		}
		
		view.addObject("message", message);
		return view;
	}
	
	// 임원, 사업관리, PM, 인사담당
	// 사용처 : DeployRequirementsController(배치소요관리)
	public static ModelAndView SessionReturnMaSalPmHr(ModelAndView view, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String message = "";
		
		String hr_job_skill = loginVO.getHr_job_skill();
		String hr_position = loginVO.getHr_position();
		String hr_role = loginVO.getHr_role();
		String account = loginVO.getAccount(); // 관리자
		
		if(hr_position.contains("임원") || hr_job_skill.contains("영업") || hr_job_skill.contains("인사") || hr_role.contains("PM") || account.contains("s")) {
			message = "pass";
		}
		else {
			message = "권한이 없습니다.";
		}
		view.addObject("message", message);
		return view;
	}
	
	// 임원, 사업관리, 인사담당
	// 사용처 : UndecidedController(미결현황)
	public static ModelAndView SessionReturnMaSalHr(ModelAndView view, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String message = "";
		
		String hr_job_skill = loginVO.getHr_job_skill();
		String hr_position = loginVO.getHr_position();
		String account = loginVO.getAccount(); // 관리자
		
		if(hr_position.contains("임원") || hr_job_skill.contains("영업") || hr_job_skill.contains("인사") || account.contains("s")) {
			message = "pass";
		}
		else {
			message = "권한이 없습니다.";
		}
		view.addObject("message", message);
		return view;
	}

}
