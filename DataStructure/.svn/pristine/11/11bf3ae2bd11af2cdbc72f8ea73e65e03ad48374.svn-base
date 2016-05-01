package com.sqisoft.iqs.hr.main.dao;

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

public interface HrDAO {
	public void project_Insert(ProjectVO pjVO);

	public 	List<MppListVO> emp_MppList(String team_id);
	public 	List<ProjectCountVO> project_GetCount(String team_id);
	//public 	List<MpPlaceVO> emp_MppList();

	//���� ���� DAO
	public void emp_Insert(Employee_VO employeeVO);
	public void emp_TimeoffInsert(Map<String, String> hs);
	public void pjHistory_TimeoffUpdate(Map<String, String> hs);
	public void emp_TimeoffUpdate2(Map<String, String> hs);
	public void emp_TimeoffUpdate3(Map<String, String> hs);
	public void pjHistory_TimeoffDayUpdate(Map<String, String> hs);
	public Employee_VO emp_getTimeoff(String name);
	public void emp_SkillInsert(SkillVO vo);
	public void emp_Update(Employee_VO empVO);
	public void emp_TimeoffUpdate(Map<String, String> hs);
	public MpPlaceVO getMpplaceInfo(String name);
	public void emp_Delete(String name);	
	public Employee_VO emp_getEmp(Map<String, String> hash);
	public List<Employee_VO> emp_getEmpList();
	public List<Employee_VO> emp_SearchEmpList(Map<String, String> hash);
	public Employee_VO mailCheck(Map<String,Object> param);
	public String getMaxName(String name);
	//----------------------------------------------------------

	public List<Map<String, String>> getSkillOptionsPC();
	public List<Map<String, String>> getSkillOptionsCC( String val);
	public List<Map<String, String>> getSkillOptionsDC();
	
	public List<Map<String, String>> getAreaOptionsPC();
	public List<Map<String, String>> getAreaOptionsCC( String val);

	public List<Employee_VO> emp_duplicheck(String name);
	public void emp_SkillDel(String name);
	public List<SkillVO> getSkill(String name);
	
	public void place_Insert(String name);
	public void place_Delete(String name);
	public int teamExist(String team_id);
	
	public void emppj_Insert(Employee_VO empvo); // 신규 인력 등록시 pj_history에 대기로 등록
//	public void emppj_Update(Employee_VO empvo); // 입사일 수정시 pj_history에 '대기' 시작일 수정
	

	public List<Employee_VO> empSearch(SkillVO vo);
	
	public abstract void out_hisReg(OutSal_historyVO hvo);
	public abstract void out_hisDel(OutSal_historyVO hvo);

	public void emp_UpdateWithHName(Employee_VO empVO);
	
	


}
