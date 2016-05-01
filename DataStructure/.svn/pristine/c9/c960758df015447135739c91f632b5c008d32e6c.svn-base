package com.sqisoft.iqs.pf.member.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.pf.vo.LoginVO;

public interface MemberDAO {
	public LoginVO getMember(String email);
	public abstract int nameExist(String pj_biz);
	public abstract List<Employee_VO> nameSerch();
	
	// 로그인
	public LoginVO login(LoginVO loginVO);
	
	// 비밀번호 수정
	public void changePassword(LoginVO loginVO);
	public int getMemberInfoByEmail(Map<String, String> parmas);
	
	// 프로젝트 가져오기
	public List<String> getLatestProject();
}
