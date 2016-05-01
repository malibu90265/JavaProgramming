package com.sqisoft.iqs.humanResource.employeeInput.service;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;

public interface EmployeeInputService {
	public List<EmployeeInputVO> getSearchTeamListAjax();
	public List<EmployeeInputVO> getSearchTeamProjectListAjax(String tm_id);
	public EmployeeInputVO getEmployeeInputDetailForm1Ajax(String pj_id);
	public HumanResourceVO getHrInfoByNameAjax(String pr_name);
	public List<EmployeeInputVO> getEmployeeInputDetailForm2(String pj_id);
	public void insertPjDeploy(Map<String, Object> map);
	public EmployeeInputVO getEmployeeInputInfoForm(Map<String, Object> map);
	public void deletePjRequire(Map<String, Object> map);
	public boolean checkDuplicate(Map<String, Object> map);
	public boolean checkDuplicate_mod(Map<String, Object> map);
	public void updateCost(String pj_id);
}
