package com.sqisoft.iqs.humanResource.humanResource.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HumanResourceDAO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;

public class HumanResourceDAOImpl extends SqlSessionDaoSupport implements HumanResourceDAO{
	
	//직원 search (team, name)
	@Override
	public List<HumanResourceVO> getHumanResourceListSearchAjax(Map<String, Object> param) {
		return getSqlSession().selectList("humanResourceDAO.getHumanResourceListSearchAjax",param);
	}
	
	//외주 이름, 등급 검색
	public java.util.List<HumanResourceVO> getOutHumanResourceListSearchAjax(java.util.Map<String,Object> param) {
		return getSqlSession().selectList("humanResourceDAO.getOutHumanResourceListSearchAjax",param);
	}
	
	//직원 list
	@Override
	public List<HumanResourceVO> getHumanResourceListAjax() {
		return getSqlSession().selectList("humanResourceDAO.humanResourceList3");
	}
	
	//외주 list
	public java.util.List<HumanResourceVO> getOutHumanResourceListsAjax() {
		return getSqlSession().selectList("humanResourceDAO.outHumanResourceList");
	}
	
	//팀별 직급단가 등록
	@Override
	public void getUpriceUpdate(Map<String, Object> param) {
		getSqlSession().update("humanResourceDAO.getUpriceUpdate",param);
	}
	
	//팀별 직급단가 - 경영지원팀
	@Override
	public void getUpriceUpdate6M(Map<String, Object> param) {
		getSqlSession().update("humanResourceDAO.getUpriceUpdate6M",param);
	}
	
	// 수정 1
	@Override
	public HumanResourceVO getHumanResourceDetailFormAjax(String hr_name) {
		return getSqlSession().selectOne("humanResourceDAO.humanResourceDetail", hr_name);
	}
	// 수정 2
	@Override
	public int getHumanResourceModifyFormAjax(HumanResourceVO humanResourceVO) {
		return getSqlSession().update("humanResourceDAO.getHumanResourceModifyFormAjax", humanResourceVO);
	}
	
	// 삭제
	@Override
	public void getHumanResourceDeleteFormAjax(Map<String, Object> param) {
		getSqlSession().delete("humanResourceDAO.getHumanResourceDeleteFormAjax", param);
		getSqlSession().delete("humanResourceDAO.getAccountDelete",param);
	}
	
	//insert - 2015.10.16 account에도 업뎃 되게 해놨습니다. TODO 수정과 삭제에도 동일하게 적용해야 합니다.
	@Override
	public void getHumanResourceDoInsertForm(HumanResourceVO humanResourceVO) {
		getSqlSession().insert("humanResourceDAO.getHumanResourceDoInsertForm", humanResourceVO);
		getSqlSession().insert("humanResourceDAO.getInserAccount",humanResourceVO);
		getSqlSession().update("humanResourceDAO.getUpdateAccount",humanResourceVO);
	}
	//EmployeeInfo insert - 2015.11.24
	@Override
	public void insertEmployeeInfo(HumanResourceVO humanResourceVO) {
		getSqlSession().insert("humanResourceDAO.insertEmployeeInfo", humanResourceVO);
		getSqlSession().insert("humanResourceDAO.getInserAccount",humanResourceVO);
		getSqlSession().update("humanResourceDAO.getUpdateAccount",humanResourceVO);
	}
	
	
	//외주 insert
	@Override
	public void getOutHumanResourceDoInsertForm(HumanResourceVO humanResourceVO) {
		getSqlSession().insert("humanResourceDAO.getOutHumanResourceDoInsertForm", humanResourceVO);
	}
	
	// select options
	@Override
	public List<String> getTeamOptions() {
		return getSqlSession().selectList("humanResourceDAO.getTeamOptions");
	}
	
	@Override
	public List<String> getTeamIdOptions() {
		return getSqlSession().selectList("humanResourceDAO.getTeamIdOptions");
	}

	@Override
	public List<String> getJobSkillOptions() {
		return getSqlSession().selectList("humanResourceDAO.getJobSkillOptions");
	}

	@Override
	public List<String> getOsOptions() {
		return getSqlSession().selectList("humanResourceDAO.getOsOptions");
	}

	@Override
	public List<String> getDbOptions() {
		return getSqlSession().selectList("humanResourceDAO.getDbOptions");
	}

	@Override
	public List<String> getUiOptions() {
		return getSqlSession().selectList("humanResourceDAO.getUiOptions");
	}

	@Override
	public List<String> getLanguageOptions() {
		return getSqlSession().selectList("humanResourceDAO.getLanguageOptions");
	}

	@Override
	public List<String> getFrameWorkOptions() {
		return getSqlSession().selectList("humanResourceDAO.getFrameWorkOptions");
	}

	@Override
	public List<String> getMiddleWareOptions() {
		return getSqlSession().selectList("humanResourceDAO.getMiddleWareOptions");
	}

	@Override
	public List<String> getDomainOptions() {
		return getSqlSession().selectList("humanResourceDAO.getDomainOptions");
	}

	@Override
	public List<RoleVO> getRoleOptions() {
		return getSqlSession().selectList("humanResourceDAO.getRoleOptions");
	}

	// 등급 키
	@Override
	public List<String> getPositonOptionsKey() {
		return getSqlSession().selectList("humanResourceDAO.getPositonOptionsKey");
	}
	
	// 등급 밸류
	public List<String> getPositonOptionsValue() {
		return getSqlSession().selectList("humanResourceDAO.getPositonOptionsValue");
	}

	@Override
	public List<String> getJobSkillOptionsReturnList() {
		return getSqlSession().selectList("humanResourceDAO.getJobSkillOptionsReturnList");
	}
	
	//pj수행이력
	@Override
	public List<HumanResourceEachListVO> getPJWorkingHistoryPopupAjaxWithProject(String hr_name) {
		return getSqlSession().selectList("humanResourceDAO.getPJWorkingHistoryPopupAjaxWithProject", hr_name);
	}

	// 최종 수행 프로젝트
	@Override
	public String getPersonDeployHistory(String origin_hr_name) {
		return getSqlSession().selectOne("humanResourceDAO.getPersonDeployHistory", origin_hr_name);
	}

	@Override
	public String getPjName(String pj_id) {
		return getSqlSession().selectOne("humanResourceDAO.getTeamName", pj_id);
	}

	@Override
	public HumanResourceVO getouthumanResourceDetail(String hr_name) {
		return getSqlSession().selectOne("humanResourceDAO.outhumanResourceDetail", hr_name);
	}

	// 동명이인
	@Override
	public Boolean getSamePersonCheckAjax(String hr_name) {
		String hr = getSqlSession().selectOne("humanResourceDAO.getSamePersonCheckAjax", hr_name);
		if(hr == null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void updateHrInfo(HRPriceVO hrPriceVO) {
		getSqlSession().update("humanResourceDAO.updateHrInfo", hrPriceVO);
	}
	//직원 이미지 미리보기
	@Override
	public HumanResourceVO getHumanResourceInfo(String hr_name) {
		return getSqlSession().selectOne("humanResourceDAO.getHumanResourceInfo", hr_name);
	}
	
	//EmployeeUpdate - 2015.11.24
	@Override
	public void updateEmployeeInfo(HumanResourceVO humanResourceVO) {
		 this.getSqlSession().update("humanResourceDAO.getHumanResourceModifyFormAjax", humanResourceVO);
	}
}
