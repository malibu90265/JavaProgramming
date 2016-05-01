package com.sqisoft.iqs.humanResource.employeeInput.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.employeeInput.dao.EmployeeInputDAO;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.project.vo.ProjectVO;

public class EmployeeInputDAOImpl extends SqlSessionDaoSupport implements EmployeeInputDAO{

	//Team 이름 가져오기
	@Override
	public List<EmployeeInputVO> getTeamNames() {
		return getSqlSession().selectList("EmployeeInputDAO.getTeamNames");
	}

	//해당 Team에 대한 프로젝트 List 가져오기
	@Override
	public List<EmployeeInputVO> getProjectList(String tm_id) {
		return getSqlSession().selectList("EmployeeInputDAO.getProjectList", tm_id);
	}

	//프로젝트 정보 가져오기
	@Override
	public EmployeeInputVO getProjectInfoByPjId(String pj_id) {
		return getSqlSession().selectOne("EmployeeInputDAO.getProjectInfoByPjId", pj_id);
	}

	//해당 PJ에 대한 투입 인력 List 가져오기
	@Override
	public List<EmployeeInputVO> getPjDeployInfoByPjId(String pj_id) {
		return getSqlSession().selectList("EmployeeInputDAO.getPjDeployInfoByPjId", pj_id);
	}
	
	//직원 정보 가져오기
	@Override
	public HumanResourceVO getHrInfoByName(String hr_name) {
		return getSqlSession().selectOne("EmployeeInputDAO.getHrInfoByName", hr_name);
	}
	
	//저장
	@Override
	public void insertPjDeploy(Map<String, Object> map) {
		int pd_sq = Integer.parseInt(map.get("pd_sq").toString());
		
		if(pd_sq==0){
			String pj_id = map.get("pj_id").toString();
			if(getSqlSession().selectOne("EmployeeInputDAO.changePd_sqMax", pj_id)==null)
				pd_sq = 1;
			else
				pd_sq = getSqlSession().selectOne("EmployeeInputDAO.changePd_sqMax", pj_id);
			map.put("pd_sq", pd_sq);
		}
		getSqlSession().insert("EmployeeInputDAO.insertPjDeploy", map);
	}

	
	
	//직원 선택시 해당 직원의 정보를 insert form에 출력하기 위해 가져옴
	@Override
	public EmployeeInputVO getEmployeeInputInfoForm(Map<String, Object> map) {
		return getSqlSession().selectOne("EmployeeInputDAO.getEmployeeInputInfo", map);
	}

	//삭제
	@Override
	public void deleteRequire(Map<String, Object> map) {
		getSqlSession().delete("EmployeeInputDAO.deletePjDeploy", map);
	}

	//투입 table과 배치소요 table에서 소요번호가 같은 직원 List를 가져옴
	@Override
	public List<EmployeeInputVO> getDeployL1(String pj_id) {
		List<EmployeeInputVO> d1 = getSqlSession().selectList("EmployeeInputDAO.getDeployL1", pj_id);
		for(int i=0; i<d1.size(); i++){
			if(d1.get(i).getPr_grade() != null){
				d1.get(i).setPr_grade(d1.get(i).getPr_grade().replaceAll("[0-9]", ""));
			}
			
		}
		return d1;
	}

	//투입 table과 배치소요 table에서 서로 없는 직원 List를 가져옴
	@Override
	public List<EmployeeInputVO> getDeployL2(String pj_id) {
		List<EmployeeInputVO> d2 = getSqlSession().selectList("EmployeeInputDAO.getDeployL2", pj_id);
		for(int i=0; i<d2.size(); i++){
			if(d2.get(i).getPr_grade() != null){
				d2.get(i).setPr_grade(d2.get(i).getPr_grade().replaceAll("[0-9]", ""));
			}
			
		}
		return d2;
	}
	
	@Override
	public List<EmployeeInputVO> getDeployListByPjId(String pj_id) {
		return getSqlSession().selectList("EmployeeInputDAO.getDeployListByPjId", pj_id);
	}
	
	@Override
	public void updateMM(Map<String, Object> params) {
		getSqlSession().update("EmployeeInputDAO.updateMM", params);
	}
	
	@Override
	public int getLastSqByPjId(String pj_id) {
		return getSqlSession().selectOne("EmployeeInputDAO.getLastSqByPjId", pj_id);
	}
	
	@Override
	public List<String> getProjectNamesByTeamId(String tm_id) {
		return getSqlSession().selectList("EmployeeInputDAO.getProjectNamesByTeamId", tm_id);
	}
	
	@Override
	public List<EmployeeInputVO> getEmployeeInputInfo(Map<String, Object> map) {
		return getSqlSession().selectList("EmployeeInputDAO.getEmployeeInfo", map);
	}

	//해당 PJ의 팀에 대한 직급단가 가져오기
	@Override
	public int getHr_mon_price(Map<String, Object> map) {
		return getSqlSession().selectOne("EmployeeInputDAO.getHr_mon_price", map);
	}

	@Override
	public String getTm_id(String pj_id) {
		return getSqlSession().selectOne("EmployeeInputDAO.getTm_id", pj_id);
	}

	@Override
	public int get6M15price() {
		return getSqlSession().selectOne("EmployeeInputDAO.get6M15price");
	}

	@Override
	public void updateCost(Map<String, Object> result) {
		getSqlSession().update("EmployeeInputDAO.updateCost", result);
	}
	
}