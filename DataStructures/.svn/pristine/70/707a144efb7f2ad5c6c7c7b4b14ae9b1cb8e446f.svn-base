package com.sqisoft.iqs.hr.manplace.contorller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.manplace.service.ManPlaceService;
import com.sqisoft.iqs.hr.util.HrUtil;
import com.sqisoft.iqs.hr.vo.EmpMapVO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.StandByInfoVO;

//인력배치현황 컨트롤러
@Controller
public class ManPlaceController {

	private ManPlaceService manPlaceService;
	
	public void setManPlaceService(ManPlaceService manPlaceService) {
		this.manPlaceService = manPlaceService;
	}
	
	@RequestMapping(value="/emp_standBy.do")
	public ModelAndView emp_standByForm(Model model) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("emp_standby");
		return mav;
	}
	
	@RequestMapping(value="/emp_standBy.action")
	public ModelAndView emp_standByView(Model model) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		//HrUtil hrUtil=new HrUtil();
		
		List<StandByInfoVO> standByInfo = new ArrayList<StandByInfoVO>();
		
		standByInfo = manPlaceService.getStandByList();
		
		standByInfo=HrUtil.manMonthManage(standByInfo);
		
		Collections.sort(standByInfo, new TeamCompare());
		
		mav.addObject("standByInfo", standByInfo);
		
		mav.setViewName("JSON");
			
		return mav;
	}
	
	
	/*
	@RequestMapping(value="/emp_teamProjectList.action")
	public ModelAndView emp_teamProjectListView(String rate_value) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		hrUtil=new HrUtil();
		String team_id=rate_value;
		
		standByInfo = manPlaceService.getTeamProjectList(team_id);
		
		hrUtil.manPlaceManage(standByInfo);
		int size=standByInfo.size();
		
		mav.addObject("standByInfo", standByInfo);
		mav.addObject("size", size);
		
		mav.setViewName("JSON");
			
		return mav;
	}*/
	
	
	@RequestMapping(value="/emp_projectList.action")
	public ModelAndView emp_projectList(String rate_value) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		String team_id=rate_value;
		
		List<ProjectVO> projectInfo = new ArrayList<ProjectVO>();
		projectInfo = manPlaceService.getProjectList(team_id);
		int size=projectInfo.size();
		
		mav.addObject("projectInfo", projectInfo);
		mav.addObject("size", size);
		
		mav.setViewName("JSON");
			
		return mav;
	}
	
	@RequestMapping(value="/emp_detailProjectList.action")
	public ModelAndView emp_detailProjectList(String pj_id,String rate_value) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		
		List<StandByInfoVO> standByInfo = new ArrayList<StandByInfoVO>();
		
		standByInfo = manPlaceService.getDetailProjectList(pj_id,rate_value);
		
		List<OutSal_historyVO> outSalList = new ArrayList<OutSal_historyVO>();
		for(StandByInfoVO standByInfoVO:standByInfo){
			outSalList=manPlaceService.getOutSalList(standByInfoVO.getStartday(),standByInfoVO.getEndday(),standByInfoVO.getName());
			standByInfoVO.setOutSal_history(outSalList);//외주 데이터 저장 
		}
		
		
		standByInfo=HrUtil.manMonthManage(standByInfo);
		Collections.sort(standByInfo, new PositionCompare());
		
		
		int size=standByInfo.size();
		mav.addObject("detailProjectInfo", standByInfo);
		mav.addObject("size", size);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value="/emp_outList.action")
	public ModelAndView emp_outListView(String rate_value) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		String[] arg=rate_value.split(":");
		String name=arg[0];
		
		List<Employee_VO> personalInfo = new ArrayList<Employee_VO>();
		personalInfo= manPlaceService.getPersonalInfo(name);
		
		for(Employee_VO pInfo:personalInfo){
			pInfo.setSkill_name(manPlaceService.getPersonalSkill(name));
			pInfo.setJob(manPlaceService.getJob(name));
		}
		
		
		int size=personalInfo.size();
	
		mav.addObject("personalInfo", personalInfo);
		mav.addObject("size", size);
		
		mav.setViewName("JSON");
			
		return mav;
	}
	
	
	/*직원 외주 투입맵*/

	@RequestMapping(value="/Emp_Map.action")
	public ModelAndView empMap_View(HttpServletRequest req) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		List<EmpMapVO> EmpMapInfo=manPlaceService.getEmpMapList();
	
		List<EmpMapVO> list = HrUtil.mapManage(EmpMapInfo);
		
		mav.addObject("EmpMapInfo", list);
		
		mav.setViewName("JSON");
		
		return mav;
	}

	@RequestMapping(value="/Out_Map.action")
	public ModelAndView outMap_View() throws Exception
	{
		ModelAndView mav = new ModelAndView();

		List<EmpMapVO> EmpMapInfo=manPlaceService.getOutMapList();
		
		List<EmpMapVO> list = HrUtil.mapManage(EmpMapInfo);
		
		mav.addObject("EmpMapInfo", list);
		
		mav.setViewName("JSON");
		
		return mav;
		
	}
	
	static public class PositionCompare implements Comparator<StandByInfoVO>{

		@Override
		public int compare(StandByInfoVO obj1, StandByInfoVO obj2) {
			return  obj1.getPosition().compareTo(obj2.getPosition());
		}

	}
	static public class NameCompare implements Comparator<StandByInfoVO>{

		@Override
		public int compare(StandByInfoVO obj1, StandByInfoVO obj2) {
			return  obj1.getName().compareTo(obj2.getName());
		}

	}
	static public class TeamCompare implements Comparator<StandByInfoVO>{

		@Override
		public int compare(StandByInfoVO obj1, StandByInfoVO obj2) {
			return  obj1.getTeam_id().compareTo(obj2.getTeam_id());
		}

	}
	
}