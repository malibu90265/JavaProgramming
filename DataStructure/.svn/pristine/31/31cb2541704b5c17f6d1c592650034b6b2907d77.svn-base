package com.sqisoft.iqs.hr.manplace.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.manplace.dao.ManPlaceDAO;
import com.sqisoft.iqs.hr.manplace.service.ManPlaceService;
import com.sqisoft.iqs.hr.vo.EmpMapVO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
import com.sqisoft.iqs.hr.vo.StandByInfoVO;

public class ManPlaceServiceImpl implements ManPlaceService {
	
	
	private ManPlaceDAO manPlaceDao;
	
	public void setManPlaceDao(ManPlaceDAO manPlaceDao) {
		this.manPlaceDao = manPlaceDao;
	}
	
	@Override
	public List<StandByInfoVO> getStandByList() {
		return manPlaceDao.getStandByList();
	}
	
	@Override
	public List<StandByInfoVO> getTeamProjectList(String team_id) {
		return manPlaceDao.getTeamProjectList(team_id);
	}

	@Override
	public List<EmpMapVO> getEmpMapList() {
		return manPlaceDao.getEmpMapList();
	}
	
	@Override
	public List<EmpMapVO> getOutMapList() {
		return manPlaceDao.getOutMapList();
	}

	@Override
	public List<Employee_VO> getPersonalInfo(String name) {
		List<String> names=new ArrayList<String>();
		List<Employee_VO> res=new ArrayList<Employee_VO>();
		Map<String,Employee_VO> temp=new HashMap<String,Employee_VO>();
		
		for(Employee_VO emp:manPlaceDao.getPersonalInfo(name)){
			if(names.contains(emp.getName())){
				temp.get(emp.getName()).setSkill_name(temp.get(emp.getName()).getSkill_name()+","+emp.getSkill_name());
			}else{
				names.add(emp.getName());
				temp.put(emp.getName(), emp);
				
			}
		}
		
		for (Map.Entry<String, Employee_VO> entry : temp.entrySet()) {
			res.add(entry.getValue());
		}
		
		
		return res;
	}

	@Override
	public List<ProjectVO> getProjectList(String team_id) {
		return manPlaceDao.getProjectList(team_id);
	}

	@Override
	public List<StandByInfoVO> getDetailProjectList(String pj_id,String rate_value) {
		Map<String,String> hs=new HashMap<String, String>();
		hs.put("pj_id", pj_id);
		hs.put("team_id", rate_value);
		return manPlaceDao.getDetailProjectList(hs);
	}
	
	@Override
	public List<OutSal_historyVO> getOutSalList(String startDay,String endDay,String name) {
		System.out.println("manplaceServiceImpl");
		Map<String,String> hs=new HashMap<String, String>();
		hs.put("startDay", startDay);
		hs.put("endDay", endDay);
		hs.put("name", name);
//		hs.put("startDay", startDay.substring(0, 4)+"-"+startDay.substring(4, 6)+"-"+startDay.substring(6,8));
//		hs.put("endDay", endDay.substring(0, 4)+"-"+endDay.substring(4, 6)+"-"+endDay.substring(6,8));
		System.out.println("startDay"+startDay+"endDay"+endDay+"name"+name);
		return manPlaceDao.getOutSalList(hs);
	}

	@Override
	public String getPersonalSkill(String name) {
		List<SkillVO> vo=manPlaceDao.getPersonalSkill(name);
		String result="";
		int cnt=0;
		for(SkillVO s : vo)
		{
			if(cnt>0){
				result+=",";
			}
			result+=s.getName();
			cnt++;
		}
		System.out.println("getPersonalSkill"+result);
		return result;
	}

	@Override
	public String getJob(String name) {
		List<SkillVO> vo=manPlaceDao.getJob(name);
		String result="";
		int cnt=0;
		for(SkillVO s : vo)
		{
			if(cnt>0){
				result+=",";
			}
			result+=s.getName();
			cnt++;
		}
		
		System.out.println("getJob"+result);
		
		return result;
	}
}
