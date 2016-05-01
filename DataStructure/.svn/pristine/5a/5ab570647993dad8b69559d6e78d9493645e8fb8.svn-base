package com.sqisoft.iqs.humanResource.employeeInput.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.project.vo.ProjectVO;

public interface EmployeeInputDAO {
	
	public List<EmployeeInputVO> getTeamNames();
	public List<EmployeeInputVO> getProjectList(String tm_id);
	public EmployeeInputVO getProjectInfoByPjId(String pj_id);
	public HumanResourceVO getHrInfoByName(String pr_name);
	public void insertPjDeploy(Map<String, Object> map);
	public EmployeeInputVO getEmployeeInputInfoForm(Map<String, Object> map);
	public void deleteRequire(Map<String, Object> map);
	public List<EmployeeInputVO> getDeployL1(String pj_id);
	public List<EmployeeInputVO> getDeployL2(String pj_id);
	public List<EmployeeInputVO> getDeployListByPjId(String pj_id);
	public void updateMM(Map<String, Object> params);
	public int getLastSqByPjId(String pj_id);
	public List<String> getProjectNamesByTeamId(String tm_id);
	public List<EmployeeInputVO> getEmployeeInputInfo(Map<String, Object> map);
	public List<EmployeeInputVO> getPjDeployInfoByPjId(String pj_id);
	public int getHr_mon_price(Map<String, Object> map);
	public String getTm_id(String tm_id);
	public int get6M15price();
	public void updateCost(Map<String, Object> result);
	
}
