package com.sqisoft.iqs.pf.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.Employee_VO;

import javax.servlet.http.HttpServletResponse;

import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.pf.vo.ProjectVO;

public interface MemberService {
	// 멤버 정보 가져오기
	public LoginVO getMember(String email);
	
	public abstract int nameExist(String pj_biz);
	public abstract List<Employee_VO> nameSerch();
	public abstract List<ProjectVO> pjSearch(String search);
	
	// 로그인
	public ModelAndView doLogin(LoginVO loginVO, HttpServletRequest request);
	// 로그아웃
	public ModelAndView logout(HttpServletRequest request);
	// 수정
	public ModelAndView doChangePassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 프로젝트 가져오기
	public List<String> getLatestProject();

}
