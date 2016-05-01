package com.sqisoft.iqs.humanResource.humanResource.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;

public interface HumanResourceDAO {

	// 수정
	public HumanResourceVO getHumanResourceDetailFormAjax(String hr_name);
	public int getHumanResourceModifyFormAjax(HumanResourceVO humanResourceVO);
	public HumanResourceVO getouthumanResourceDetail(String hr_name);

	// 삭제
	public void getHumanResourceDeleteFormAjax(Map<String, Object> param);

	// select options
	public List<String> getTeamIdOptions();
	public List<String> getTeamOptions();
	public List<String> getJobSkillOptions();
	public List<String> getOsOptions();
	public List<String> getDbOptions();
	public List<String> getUiOptions();
	public List<String> getLanguageOptions();
	public List<String> getFrameWorkOptions();
	public List<String> getMiddleWareOptions();
	public List<String> getDomainOptions();
	public List<RoleVO> getRoleOptions();
	public List<String> getPositonOptionsKey();
	public List<String> getPositonOptionsValue();
	
	
	//직원 search (team, name)
	public List<HumanResourceVO> getHumanResourceListSearchAjax(Map<String, Object> param);
	//외주 이름, 등급 검색
	public List<HumanResourceVO> getOutHumanResourceListSearchAjax(Map<String, Object> param);
	
	//직원 list
	public List<HumanResourceVO> getHumanResourceListAjax();
	//외주 list
	public List<HumanResourceVO> getOutHumanResourceListsAjax();
	
	
	//insert - 2015.09.07
	public void getHumanResourceDoInsertForm(HumanResourceVO humanResourceVO);
	//EmployeeInfo insert - 2015.11.24
	public void insertEmployeeInfo(HumanResourceVO humanResourceVO);
	
	public List<String> getJobSkillOptionsReturnList();
	
	//pj수행이력
	public List<HumanResourceEachListVO> getPJWorkingHistoryPopupAjaxWithProject(String hr_name);
	
	// 최종 수행 프로젝트
	public String getPersonDeployHistory(String origin_hr_name);
	
	public String getPjName(String pj_id);
	
	// 동명이인
	public Boolean getSamePersonCheckAjax(String hr_name);
	
	//팀별 직급단가 등록
	public void getUpriceUpdate(Map<String, Object> param);
	
	//팀별 직급단가 - 경영지원팀
	public void getUpriceUpdate6M(Map<String, Object> param);
	public void updateHrInfo(HRPriceVO hrPriceVO);
	
	//외주 insert
	public void getOutHumanResourceDoInsertForm(HumanResourceVO humanResourceVO);
	
	//직원 이미지 미리보기
	public HumanResourceVO getHumanResourceInfo(String hr_name);
	
	//Employee Update - 2015.11.24
	public void updateEmployeeInfo(HumanResourceVO humanResourceVO);
	
	
}
