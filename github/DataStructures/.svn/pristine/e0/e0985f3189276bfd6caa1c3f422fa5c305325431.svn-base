package com.sqisoft.iqs.humanResource.estimate.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.estimate.vo.EstimationVO;

public interface EstimateDAO {

	public List<EstimationVO> getEstViewPage(String hr_name);

	// 년도 구하기
	public List<EstimationVO> getSearchYearOptions(String hr_name);
	// 플젝 구하기
	public List<String> getSearchPjOptions(String hr_name);
	// 검색
	public List<EstimationVO> getEstViewPageSearch(Map<String, Object> param);
	// 업데이트
	public void doUpdateSignupdata(Map<String, Object> param);
	// 팀 검색 디폴트 : 전체
	public List<EstimationVO> getNonTeamEstViewPage();
	// 팀 검색
	public List<EstimationVO> getTeamEstViewPageSearch(Map<String, Object> param);

}
