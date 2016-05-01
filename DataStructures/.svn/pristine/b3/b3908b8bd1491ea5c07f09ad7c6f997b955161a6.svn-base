package com.sqisoft.iqs.humanResource.candidate.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.vo.TestVO;
import com.sqisoft.iqs.humanResource.candidate.dao.CandidateDAO;
import com.sqisoft.iqs.humanResource.candidate.vo.CandidateVO;

public class CandidateDAOImpl extends SqlSessionDaoSupport implements CandidateDAO {
	
	@Override
	public List<CandidateVO> getAllCandidateList() {
		return getSqlSession().selectList("candidateDAO.getAllCandidateList");
	}
	
	@Override
	public List<CandidateVO> getCandidateConditionList(String pjId) {
		return getSqlSession().selectList("candidateDAO.getCandidateConditionList", pjId);
	}
    
	@Override
	public List<CandidateVO> getCandidateDetailClickList(String grade) {
		return getSqlSession().selectList("candidateDAO.getCandidateDetailClickList", grade);
	}
	
	@Override
	public List<TestVO> getFirstPriorityList(Map<String, String> map) {
		return getSqlSession().selectList("candidateDAO.test_VO1", map);
	}

	public List<TestVO> getSecondPriorityList(Map<String, String> map) {
		return getSqlSession().selectList("candidateDAO.test_VO2", map);
	}
	
	@Override
	public List<TestVO> getAllPjDayList() {
		// 팀id가 1S-5D , 퇴사한 직원은 걸러냄
		return getSqlSession().selectList("candidateDAO.allPjDayList");
	}
	
	@Override
	public List<TestVO> getNoHistoryPjDayList() {
		// employee 중에서 pj_history에 이력이 없는 사람 리스트
		return getSqlSession().selectList("candidateDAO.noHistoryPjDayList");
	}
	
	@Override
	public List<TestVO> getMaxPjDayList() {
		//max
		return getSqlSession().selectList("candidateDAO.maxPjEndDayList");
	}

	@Override
	public List<CandidateVO> getWholeHumanResourceOnCandidate() {
		return getSqlSession().selectList("candidateDAO.getWholeHumanResourceOnCandidate");
	}

	@Override
	public void insertRequireOnCandidate(Map<String, String> map) {
		getSqlSession().update("candidateDAO.insertRequireOnCandidate", map);
	}

	@Override
	public List<CandidateVO> getTeamNames() {
		return getSqlSession().selectList("candidateDAO.getTeamNames");
	}

	@Override
	public List<CandidateVO> getProjectList(String tm_id) {
		return getSqlSession().selectList("candidateDAO.getProjectList", tm_id);
	}

}

