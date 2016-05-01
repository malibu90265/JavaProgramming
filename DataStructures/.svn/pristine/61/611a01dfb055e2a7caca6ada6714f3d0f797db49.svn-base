package com.sqisoft.iqs.hr.main.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

//import com.sqisoft.iqs.hr.vo.MpPlaceVO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.MpPlaceVO;
import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;

public interface HrService {
	
	public void project_Insert(ProjectVO pjVO);
	public 	List<MppListVO> emp_MppList(String team_id);
	public 	List<ProjectCountVO> project_GetCount(String team_id);
	
	//public 	List<MpPlaceVO> emp_List();
	
	public abstract void emp_Insert(Employee_VO employeeVO);
	public abstract void emp_TimeoffInsert(String name,String to_start_day,String to_end_day);
	public void pjHistory_TimeoffUpdate(String name, String to_start_day);
	public void pjHistory_TimeoffDayUpdate(String name, String to_start_day,String to_end_day);
	public Employee_VO emp_getTimeoff(String name);
	public MpPlaceVO getMpplaceInfo(String name);
	public void emp_Update(Employee_VO empVO,String h_name);
	public void emp_TimeoffUpdate(String name,String to_start_day,String to_end_day);
	public void emp_TimeoffUpdate2(String name,String to_start_day,String to_end_day);
	public void emp_TimeoffUpdate3(String name,String to_start_day,String to_end_day);
	public abstract void emp_Delete(String name);
	public abstract List<Employee_VO> emp_duplicheck(String name);
	public abstract Employee_VO emp_getEmp(String name);
	public abstract List<Employee_VO> empSearch(SkillVO vo);
	public abstract List<Employee_VO> emp_getEmpList();
	public List<Employee_VO> emp_SearchEmpList(String searchname, String searchteam,String searchposition, String searchyear,String searcharea);
	public abstract String  mailCheck(String mailID,String name);
	public List<Map<String, String>> getSkillOptions(String type, String val) ;
	public List<Map<String, String>> getAreaOptions(String type, String val) ;
	public void emp_SkillInsert(String name,String skill);
	public void emp_SkillDel(String name);
	public String getSkill(String name);
	public abstract void out_hisReg(OutSal_historyVO hvo) throws ParseException;
	


}
