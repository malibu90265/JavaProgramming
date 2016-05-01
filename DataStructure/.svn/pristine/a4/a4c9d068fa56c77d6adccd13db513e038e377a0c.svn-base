package com.sqisoft.iqs.hr.manplace.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.vo.EmpMapVO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
import com.sqisoft.iqs.hr.vo.StandByInfoVO;

public interface ManPlaceDAO {
	
	public List<StandByInfoVO> getStandByList();
	public List<StandByInfoVO> getTeamProjectList(String team_id);
	public List<Employee_VO> getPersonalInfo(String name);
	public List<SkillVO> getPersonalSkill(String name);
	public List<SkillVO> getJob(String name);
	public List<EmpMapVO> getEmpMapList();
	public List<EmpMapVO> getOutMapList();
	public List<ProjectVO> getProjectList(String team_id);
	public List<StandByInfoVO> getDetailProjectList(Map<String, String> hs);
	public List<OutSal_historyVO> getOutSalList(Map<String, String> hs);

}
