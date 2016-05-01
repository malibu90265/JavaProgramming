package com.sqisoft.iqs.humanResource.humanResource.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;

public interface HumanResourceService {

	// 수정
	public HumanResourceVO getHumanResourceDetailFormAjax(String hr_name);
	public boolean getHumanResourceModifyFormAjax(HumanResourceVO humanResourceVO);
	public HumanResourceVO getouthumanResourceDetail(String hr_name);
	
	// 삭제
	public void getHumanResourceDeleteFormAjax(Map<String, Object> param);

	// select options
	public Map<String, String> getTeamOptions();
	public Map<String, String> getPositonOptions();
	public Map<String, String> getGradeOptions();
	public Map<String, String> getHrCwmEnvListOptions();
	public Map<String, String> getJobSkillOptions();
	public Map<String, String> getOsOptions();
	public Map<String, String> getDbOptions();
	public Map<String, String> getUiOptions();
	public Map<String, String> getLanguageOptions();
	public Map<String, String> getFrameWorkOptions();
	public Map<String, String> getMiddleWareOptions();
	public Map<String, String> getDomainOptions();
	public Map<String, String> getRoleOptions();
	public Map<String, String> getPdAbcOptions();
	
	
	//직원 search (team, name)
	public List<HumanResourceVO> getHumanResourceListSearchAjax(Map<String, Object> param);
	//외주 이름,등급 검색
	public List<HumanResourceVO> getOutHumanResourceListSearchAjax(Map<String, Object> param);
	
	
	//직원 list
	public List<HumanResourceVO> getHumanResourceListAjax();
	//외주 list
	public List<HumanResourceVO> getOutHumanResourceListAjax();
	
	
	
	//insert - 2015.09.07
	public void getHumanResourceDoInsertForm(HumanResourceVO humanResourceVO);
	
	//EmployeeInfo insert - 2015.11.24
	public void insertEmployeeInfo(HumanResourceVO humanResourceVO);
	
	//이욱진 추가 List로 받겠음 2015.09.09
	public List<String> getJobSkillOptionsReturnList();
	
	//pj수행이력
	public List<HumanResourceEachListVO> getPJWorkingHistoryPopupAjaxWithProject(String hr_name);
	
	// 최종 수행 프로젝트
	public String getPersonDeployHistory(String origin_hr_name);
	
	// 동명이인
	public Boolean getSamePersonCheckAjax(String hr_name);

	//팀별 직급단가 등록
	public void getUpriceUpdate(Map<String, Object> param);
	
	//팀별 직급단가 - 경영지원팀
	public void getUpriceUpdate6M(Map<String, Object> param);
	
	//외주 insert
	public void getOutHumanResourceDoInsertForm(HumanResourceVO humanResourceVO);
	
	//직원 이미지 미리보기 이미지 이름 가져오기. 
	public HumanResourceVO getHumanResourceInfo(String hr_name);
	
	//EmployeeUpdate - 2015.11.24
	public void updateEmployeeInfo(HumanResourceVO humanResourceVO);
	
	
	

}
