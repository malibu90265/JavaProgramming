package com.sqisoft.iqs.humanResource.estimate.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.estimate.vo.EstimationVO;

public interface EstimateService {

	// 조회 list
	public List<EstimationVO> getEstViewPage(String hr_name);
	// 년도 검색 옵션
	public List<Integer> getSearchYearOptions(String hr_hire_date);
	// 프로젝트 옵션
	public Map<String, String> getPjIDOptions(String hr_name);
	// 검색
	public List<EstimationVO> getEstViewPageSearch(Map<String, Object> param);
	// 업데이트
	public void doUpdateSignupdata(Map<String, Object> param);
	
	// 팀 검색 디폴트 : 전체 보여주기
	public List<EstimationVO> getNonTeamEstViewPage();
	// 팀 검색
	public List<EstimationVO> getTeamEstViewPageSearch(Map<String, Object> param);
}
