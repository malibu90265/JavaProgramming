package com.sqisoft.iqs.humanResource.humanResource.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HumanResourceDAO;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;

public class HumanResourceServiceImpl implements HumanResourceService{
	
	HumanResourceDAO humanResourceDAO;

	public void setHumanResourceDAO(HumanResourceDAO humanResourceDAO) {
		this.humanResourceDAO = humanResourceDAO;
	}
	
	//직원 list
	public List<HumanResourceVO> getHumanResourceListAjax() {
		List<HumanResourceVO> hr = humanResourceDAO.getHumanResourceListAjax();
		for(int i=0; i<hr.size(); i++){
			if(hr.get(i).getHr_position() != null){
				String position = hr.get(i).getHr_position();
				position = position.replaceAll("[0-9]", "");
				hr.get(i).setHr_position(position);
			}
		}
		return hr;
		
	}
	
	//외주 list
	@Override
	public List<HumanResourceVO> getOutHumanResourceListAjax() {
		List<HumanResourceVO> hr = humanResourceDAO.getOutHumanResourceListsAjax();
		for(int i=0; i<hr.size(); i++){
			if(hr.get(i).getHr_grade() != null){
				String position = hr.get(i).getHr_grade();
				position = position.replaceAll("[0-9]", "");
				hr.get(i).setHr_grade(position);
			}
		}
		return hr;
	}
	
	
	//직원 search (team, name)
	@Override
	public List<HumanResourceVO> getHumanResourceListSearchAjax(Map<String, Object> param) {
		List<HumanResourceVO> hr = humanResourceDAO.getHumanResourceListSearchAjax(param);
		for(int i=0; i<hr.size(); i++){
			if(hr.get(i).getHr_position() != null){
				String position = hr.get(i).getHr_position();
				position = position.replaceAll("[0-9]", "");
				hr.get(i).setHr_position(position);
			}
		}
		return hr;
	}
	
	//외주 이름, 등급 검색
	@Override
	public List<HumanResourceVO> getOutHumanResourceListSearchAjax(Map<String, Object> param) {
		List<HumanResourceVO> hr = humanResourceDAO.getOutHumanResourceListSearchAjax(param);
		for(int i=0; i<hr.size(); i++){
			if(hr.get(i).getHr_grade() != null){
				String position = hr.get(i).getHr_grade();
				position = position.replaceAll("[0-9]", "");
				hr.get(i).setHr_grade(position);
			}
		}
		return hr;
	}
	
	//팀별 직급단가 등록
	@Override
	public void getUpriceUpdate(Map<String, Object> param) {
		humanResourceDAO.getUpriceUpdate(param);
	}
	
	//팀별 직급단가 - 경영지원팀
	@Override
	public void getUpriceUpdate6M(Map<String, Object> param) {
		humanResourceDAO.getUpriceUpdate6M(param);
	}
	
	// 직원 수정 1
	@Override
	public HumanResourceVO getHumanResourceDetailFormAjax(String hr_name) {
		return humanResourceDAO.getHumanResourceDetailFormAjax(hr_name);
	}
	
	// 직원 수정 2
	@Override
	public boolean getHumanResourceModifyFormAjax(HumanResourceVO humanResourceVO) {
		int num = humanResourceDAO.getHumanResourceModifyFormAjax(humanResourceVO);
		if(num>0){
			return true;
		}else{
			return false;
		}
	}
	
	// 직원 삭제
	@Override
	public void getHumanResourceDeleteFormAjax(Map<String, Object> param) {
		humanResourceDAO.getHumanResourceDeleteFormAjax(param);
	}
	
	//직원 insert - 2015.09.07
	@Override
	public void getHumanResourceDoInsertForm(HumanResourceVO humanResourceVO) {
		humanResourceDAO.getHumanResourceDoInsertForm(humanResourceVO);
	}
	
	//EmployeeInfo insert - 2015.11.24
	@Override
	public void insertEmployeeInfo(HumanResourceVO humanResourceVO) {
		humanResourceDAO.insertEmployeeInfo(humanResourceVO);
	}
	
	//외주 insert
	public void getOutHumanResourceDoInsertForm(HumanResourceVO humanResourceVO) {
		humanResourceDAO.getOutHumanResourceDoInsertForm(humanResourceVO);
	}
	
	// select options
	@Override
	public Map<String, String> getTeamOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		
		 String optionValue = "";
		 String value = "";
		 List<String> optionValues = humanResourceDAO.getTeamIdOptions();
		 List<String> values = humanResourceDAO.getTeamOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);

		return ranks;
	}

	@Override
	public Map<String, String> getPositonOptions() {
		
		Map<String, String> ranks = new HashMap<String, String>();
		
		String optionValue = "";
		String value = "";
		List<String> optionValues = humanResourceDAO.getPositonOptionsKey();
		List<String> values = humanResourceDAO.getPositonOptionsValue();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getGradeOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		ranks.put("", "선택");
		ranks.put("6특급", "특급");
		ranks.put("7고급", "고급");
		ranks.put("8중급", "중급");
		ranks.put("9초급", "초급");
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getHrCwmEnvListOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		ranks.put("M", "M");
		ranks.put("W", "W");
		ranks.put("C", "C");
		ranks.put("O", "O");
		return ranks;
	}

	@Override
	public Map<String, String> getJobSkillOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getJobSkillOptions();
		//List<String> optionValues = humanResourceDAO.getJobSkillOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = "option" + forTreeMapIdx(values.size(), i);
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			//getNullCorrector(ranks , optionValue);
		}
		//getDefalutValueInteger(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}
	
	private static final String forTreeMapIdx(int endIdx, int key) {
		
		String tree = "";
		
		int leng = String.valueOf(endIdx).length();
		
		int keyLeng = String.valueOf(key).length();
		
		for(int i = 0; i < leng - keyLeng; i++) {
			tree += "0";
		}
		
		tree += key;
		
		return tree;
	}

	@Override
	public Map<String, String> getOsOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getOsOptions();
		List<String> optionValues = humanResourceDAO.getOsOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getDbOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getDbOptions();
		List<String> optionValues = humanResourceDAO.getDbOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getUiOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getUiOptions();
		List<String> optionValues = humanResourceDAO.getUiOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getLanguageOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getLanguageOptions();
		List<String> optionValues = humanResourceDAO.getLanguageOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getFrameWorkOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getFrameWorkOptions();
		List<String> optionValues = humanResourceDAO.getFrameWorkOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getMiddleWareOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getMiddleWareOptions();
		List<String> optionValues = humanResourceDAO.getMiddleWareOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getDomainOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		List<String> values = humanResourceDAO.getDomainOptions();
		List<String> optionValues = humanResourceDAO.getDomainOptions();
		for(int i = 0; i < values.size(); i++) {
			optionValue = String.valueOf(optionValues.get(i));
			value = String.valueOf(values.get(i));
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}

	@Override
	public Map<String, String> getRoleOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		String optionValue = "";
		String value = "";
		// 수정 이후 : each_role을 List<String> 으로 받아오던 것을 List<RoleVO>로 수정했음 - 보미
		List<RoleVO> roleList = humanResourceDAO.getRoleOptions();
		for(RoleVO roleVO : roleList) {
			optionValue = roleVO.getEach_role();
			value = roleVO.getEach_role();
			ranks.put(optionValue, value);
			getNullCorrector(ranks , optionValue);
		}
		getDefalutValue(ranks);
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}
	
	// TODO pj_deploy(인력 투입) 에서 빼와야 함
	@Override
	public Map<String, String> getPdAbcOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		getDefalutValue(ranks);
		ranks.put("A", "A");
		ranks.put("B", "B");
		ranks.put("C", "C");
		// 정렬 전
		printMap(ranks);
		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);
		return treeMap;
	}
	
	// sort TODO TreeMap class에서 NULL 뱉음
	@SuppressWarnings("unused")
	public static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
		}
	}
	
	// sort TODO TreeMap class에서 NULL 뱉음
	@SuppressWarnings("unused")
	public static void printMapInteger(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
		}
	}
	
	// treemap sort null 오류 수정
	public Map<String, String> getNullCorrector(Map<String, String> ranks , String optionValue) {
		// TODO treemap이 null이나 공백을 받지 않음. but 받게 하고 싶음. 일단 고민
		String count = ranks.get(optionValue);
		if (count == null || count == "") count = "";
		ranks.put(optionValue, count);
		return ranks;
	}
	
	// 옵션 기본 값
	public Map<String, String> getDefalutValue(Map<String, String> ranks) {
		String defalutOptionValue = "";
		String defalutValue = "선택";
		ranks.put(defalutOptionValue, defalutValue);
		getNullCorrector(ranks , defalutOptionValue);
		return ranks;
	}
	
	// 옵션 기본 값
	public Map<Integer, String> getDefalutValueInteger(Map<Integer, String> ranks) {
		int defalutOptionValue = 0;
		String defalutValue = "선택";
		ranks.put(defalutOptionValue, defalutValue);
		return ranks;
	}

	@Override
	public List<String> getJobSkillOptionsReturnList() {
		return humanResourceDAO.getJobSkillOptionsReturnList();
	}

	//pj수행이력
	@Override
	public List<HumanResourceEachListVO> getPJWorkingHistoryPopupAjaxWithProject(String hr_name) {
		String pj_name = null;
		List<HumanResourceEachListVO> hr = humanResourceDAO.getPJWorkingHistoryPopupAjaxWithProject(hr_name);
		for(int i=0; i<hr.size(); i++){
			pj_name = humanResourceDAO.getPjName(hr.get(i).getPj_id());
			if(pj_name==null) //프로젝트 테이블에 없는 프로젝트id인경우 프로젝트 명을 프로젝트id로 지정
				pj_name = hr.get(i).getPj_id();
			hr.get(i).setPj_name(pj_name);
		}
		return hr;
	}

	// 최종 수행 프로젝트
	@Override
	public String getPersonDeployHistory(String origin_hr_name) {
		return humanResourceDAO.getPersonDeployHistory(origin_hr_name);
	}

	@Override
	public HumanResourceVO getouthumanResourceDetail(String hr_name) {
		return humanResourceDAO.getouthumanResourceDetail(hr_name);
	}

	// 동명이인
	@Override
	public Boolean getSamePersonCheckAjax(String hr_name) {
		return humanResourceDAO.getSamePersonCheckAjax(hr_name);
	}
	
	//직원 이미지 미리보기
	@Override
	public HumanResourceVO getHumanResourceInfo(String hr_name) {
		return humanResourceDAO.getHumanResourceInfo(hr_name);
	}
	//Employee Update - 2015.11.24
	@Override
	public void updateEmployeeInfo(HumanResourceVO humanResourceVO) {
		this.humanResourceDAO.updateEmployeeInfo(humanResourceVO);
	}

}
