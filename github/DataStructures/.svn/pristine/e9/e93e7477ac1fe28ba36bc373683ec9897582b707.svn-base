package com.sqisoft.iqs.humanResource.estimate.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.sqisoft.iqs.humanResource.estimate.dao.EstimateDAO;
import com.sqisoft.iqs.humanResource.estimate.service.EstimateService;
import com.sqisoft.iqs.humanResource.estimate.vo.EstimationVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;

public class EstimateServiceImpl implements EstimateService {
	private EstimateDAO estimateDAO;
	
	public void setEstimateDAO(EstimateDAO estimateDAO) {
		this.estimateDAO = estimateDAO;
	}

	@Override
	public List<EstimationVO> getEstViewPage(String hr_name) {
		List<EstimationVO> estimation = estimateDAO.getEstViewPage(hr_name);
		for(int i=0; i<estimation.size(); i++){
			if(estimation.get(i).getHr_grade() != null){
				estimation.get(i).setHr_grade(estimation.get(i).getHr_grade().replaceAll("[0-9]", ""));
			}
			
		}
		return estimation;
	}

	@Override
	public List<Integer> getSearchYearOptions(String hr_hire_date) {
		
		int startYear;

		if(hr_hire_date == null || hr_hire_date == "") {
			startYear = 2015;
		}
		else {
			startYear = Integer.parseInt(hr_hire_date.split("-")[0]);
		}
		
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
			
		
		List<Integer> yearSearch = new ArrayList<Integer>();
		for(int i = startYear; i <= nowYear; i++) {
			yearSearch.add(i);
		}
		
		Collections.reverse(yearSearch);	// DESC 정렬
		
		return yearSearch;
		
		// 퇴사일이 있는 경우는 아예 iqsbz에 로그인을 하지 못하도록 해야함!!
	
	}
	
	// 프로젝트 아이디 옵션
	@Override
	public Map<String, String> getPjIDOptions(String hr_name) {
		Map<String, String> ranks = new HashMap<String, String>();
		
		String value = "";
		List<String> values = estimateDAO.getSearchPjOptions(hr_name);
		
		for(int i = 0; i < values.size(); i++) {
			value = String.valueOf(values.get(i));
			ranks.put(value, value);
		}
		/*String defalutValue = "선택";
		ranks.put(defalutValue, defalutValue);*/
		
		return ranks;
	}
	// 검색
	@Override
	public List<EstimationVO> getEstViewPageSearch(Map<String, Object> param) {
		List<EstimationVO> d2 = estimateDAO.getEstViewPageSearch(param);
		for(int i=0; i<d2.size(); i++){
			if(d2.get(i).getHr_grade() != null){
				d2.get(i).setHr_grade(d2.get(i).getHr_grade().replaceAll("[0-9]", ""));
			}
			
		}
		return d2;
	}

	// 업데이트
	@Override
	public void doUpdateSignupdata(Map<String, Object> param) {
		estimateDAO.doUpdateSignupdata(param);
	}

	// 팀 검색 디폴트 : 전체
	@Override
	public List<EstimationVO> getNonTeamEstViewPage() {
		List<EstimationVO> d2 = estimateDAO.getNonTeamEstViewPage();
		for(int i=0; i<d2.size(); i++){
			if(d2.get(i).getHr_grade() != null){
				d2.get(i).setHr_grade(d2.get(i).getHr_grade().replaceAll("[0-9]", ""));
			}
			
		}
		return d2;
	}
	
	@Override
	public List<EstimationVO> getTeamEstViewPageSearch(Map<String, Object> param) {
		return estimateDAO.getTeamEstViewPageSearch(param);
	}
	
}
