package com.sqisoft.iqs.hr.manplace.service;

import java.util.List;

import com.sqisoft.iqs.hr.vo.EmpMapVO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.StandByInfoVO;

public interface ManPlaceService {

	public List<StandByInfoVO> getStandByList();
	public List<StandByInfoVO> getTeamProjectList(String team_id);
	public List<Employee_VO> getPersonalInfo(String name);
	public String getPersonalSkill(String name);
	public String getJob(String name);
	public List<EmpMapVO> getEmpMapList();
	public List<EmpMapVO> getOutMapList();
	public List<ProjectVO> getProjectList(String team_id);
	public List<StandByInfoVO> getDetailProjectList(String pj_id,String rate_value);
	public List<OutSal_historyVO> getOutSalList(String startDay,String endDay,String name);
}
