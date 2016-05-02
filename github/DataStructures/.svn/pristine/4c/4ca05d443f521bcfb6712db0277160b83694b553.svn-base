package com.sqisoft.iqs.pf.member.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.pf.member.dao.MemberDAO;
import com.sqisoft.iqs.pf.vo.LoginVO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {

	
	// 멤버 정보 가져오기
	@Override
	public LoginVO getMember(String email) {
		return getSqlSession().selectOne("memberDAO.getMember", email);
	}

	@Override
	public int nameExist(String pj_biz) {
		return getSqlSession().selectOne("memberDAO.nameExist", pj_biz);
	}

	@Override
	public List<Employee_VO> nameSerch() {
		return getSqlSession().selectList("memberDAO.nameSerch");
	}

	// 로그인
	@Override
	public LoginVO login(LoginVO loginVO) {
		LoginVO loginVOUser = getSqlSession().selectOne("memberDAO.login", loginVO);
		return loginVOUser;
	}

	// 수정
	@Override
	public void changePassword(LoginVO loginVO) {
		getSqlSession().update("memberDAO.changePassword", loginVO);
	}

	@Override
	public int getMemberInfoByEmail(Map<String, String> parmas) {
		return getSqlSession().selectOne("memberDAO.getMember", parmas);
	}
	// 프로젝트 리스트
	@Override
	public List<String> getLatestProject() {
		return getSqlSession().selectList("memberDAO.getLatestProject");
	}

}
