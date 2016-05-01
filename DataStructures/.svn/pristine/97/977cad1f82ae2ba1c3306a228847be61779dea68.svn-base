package com.sqisoft.iqs.humanResource.candidate.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.TestVO;
import com.sqisoft.iqs.humanResource.candidate.vo.CandidateVO;

public interface CandidateDAO {
    
	public List<CandidateVO> getAllCandidateList();
	
	public List<TestVO> getFirstPriorityList(Map<String, String> map);
	
	public List<TestVO> getSecondPriorityList(Map<String, String> map);
	
	public List<TestVO> getAllPjDayList();
	
	public List<TestVO> getNoHistoryPjDayList();

	public List<TestVO> getMaxPjDayList();

	public List<CandidateVO> getCandidateConditionList(String pjId);
	
	public List<CandidateVO> getCandidateDetailClickList(String grade);
	
	/* 0922이욱진 추가 모든 후보자 검색에서 필요한 컬럼 정보를 가져온다 */
	public List<CandidateVO> getWholeHumanResourceOnCandidate();

	public void insertRequireOnCandidate(Map<String, String> map);

	public List<CandidateVO> getTeamNames();

	public List<CandidateVO> getProjectList(String tm_id);
}
