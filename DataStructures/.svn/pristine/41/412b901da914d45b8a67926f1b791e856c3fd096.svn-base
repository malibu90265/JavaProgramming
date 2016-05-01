package com.sqisoft.iqs.hr.main.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.main.service.HrService;
import com.sqisoft.iqs.hr.outsal.service.OutSalHistoryService;
import com.sqisoft.iqs.hr.util.HrUtil;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
//import org.apache.commons.lang3.StringUtils;


@Controller
public class HrController {
	
	private OutSalHistoryService outSalService;
	
	private HrService hrService;
	
	public void setOutSalService(OutSalHistoryService outSalService) {
		this.outSalService = outSalService;
	}

	public void setHrService(HrService hrService) {
		this.hrService = hrService;
	}

	ProjectVO pjVO;

	HrUtil hrUtil;
	List<MppListVO> empList;
	List<ProjectCountVO> projectCount;

	
	@RequestMapping(value="/project_Insert.iqshr")
	public ModelAndView project_Insert(Model model) throws Exception
	{
		//ModelAndView nextPage= new ModelAndView();
		pjVO =new ProjectVO();
		
		ModelAndView mav=new ModelAndView();
		
		hrService.project_Insert(pjVO);

		mav.setViewName("home");
			
		return mav;
	}

	@RequestMapping("/emp_List.do")	
	public ModelAndView emp_List()
	{
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("emplist");
		
		return mav;
	}

	

	@RequestMapping("emp_List")	
	public ModelAndView emp_GetList(String team_id)
	{
		ModelAndView mav = new ModelAndView();
		hrUtil      = new HrUtil();
		projectCount= new ArrayList<ProjectCountVO>();
		
		empList = hrService.emp_MppList(team_id);
		projectCount= hrService.project_GetCount(team_id);
		
		
		mav.addObject("empList",empList);
		mav.addObject("projectCount",projectCount);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	
	@RequestMapping("/input.do")
	public String emp_input() throws Exception{		
			
		return "emp_enroll";
	}
	

	@RequestMapping("/insert.action")
	public ModelAndView emp_insert(Employee_VO employee, 
//								   @RequestParam String skill, 
								   @RequestParam String job, 
								   @RequestParam String mpm) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		if(employee.getQuit_date().equals("")){
			employee.setQuit_date(null);
		}
		
		if(employee.getTo_start_day()==""){
			employee.setTo_start_day(null);
		}
		
		if(employee.getTo_end_day()==""){
			employee.setTo_end_day(null);
		}
		
		if(employee.getDivision()=="외주"){
			employee.setTime_off("0");
//			employee.setTo_start_day(null);
//			employee.setTo_end_day(null);
		}
		
		if(employee.getArea().equals("/")){
			employee.setArea(null);
		}else{
			String areas[]=employee.getArea().split("/");
			String area=areas[0]+"/" + areas[1]+"/"+ areas[4];
			employee.setArea(area);
		}
		
		hrService.emp_Insert(employee);
		
		if(!(employee.getEmail().matches(".*@.*"))){
			employee.setEmail(employee.getEmail()+"@sqisoft.com");
		}else{
			employee.setGrade(employee.getPosition());
		}
		
		if(!employee.getDivision().equals("직원")){
			OutSal_historyVO hvo=new OutSal_historyVO(employee.getName(),employee.getHire_date(),employee.getSalary(),Float.parseFloat(mpm));
			hrService.out_hisReg(hvo);
		}
		
//		hrService.emp_SkillInsert(employee.getName(),skill); 	
		hrService.emp_SkillInsert(employee.getName(),job);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping("empSearch.action")
	@ResponseBody
	public List<Employee_VO> empSearch(HttpServletRequest req)
	{
		String area;
		String name= req.getParameter("name");
		String position= req.getParameter("position");
		String hire_date= req.getParameter("hire_date").split("-")[0];
		String area1= req.getParameter("area1");
		String area2= req.getParameter("area2");
		String e_area= req.getParameter("e_area");
		String team_id= req.getParameter("team_id");
		String groupcd= req.getParameter("groupcd"); 
		String skillcd= req.getParameter("skillcd");
		String jobcd=req.getParameter("jobcd");
		String division = req.getParameter("division");
		String team_name = req.getParameter("team_name");
		String major=req.getParameter("skill");
		String envclass=req.getParameter("envclass");
		
		if(area2==null || area2.equals("")){
			area=area1;
		}else{
			area=area2;
		}
//		System.out.println(envclass);
		SkillVO vo=new SkillVO(name,division,position,hire_date,area,team_id,"1",groupcd, skillcd,jobcd);
		vo.setSkill(major);
		vo.setEnvclass(envclass);
		List<Employee_VO> list=hrService.empSearch(vo);
		
		for(int i=0;i<list.size();i++){
			Employee_VO s = list.get(i);
//			if(s.getName().equals("고연경")){
//				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//				System.out.println("index : " + i);
//			}
			
		}
		
		return list;
	}  
	
	@RequestMapping(value="/empPictureUpload.action", method = RequestMethod.POST)
	public @ResponseBody String empPictureUpload(@RequestParam("filefile") MultipartFile file) throws IOException
	{
		byte[] fileData = file.getBytes();
		int now = (int)System.currentTimeMillis();
		String fileName = Integer.toString(now)+"_"+file.getOriginalFilename();
		//FileOutputStream fos = new FileOutputStream(CommonConstants.abUploadPath+ fileName);
//  		FileOutputStream fos = new FileOutputStream("http:\\211.232.57.248:8080\\resources\\emp_photo\\"+ fileName);
		
		/*fos.write(fileData);
		fos.close();*/
		return null; //CommonConstants.uploadPath + fileName;
	}
	
	@RequestMapping("EmpSearch")
	public ModelAndView emp_search(@RequestParam String search_name,
									@RequestParam String search_team,
									@RequestParam String search_position,
									@RequestParam String search_area,
									@RequestParam String search_year) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		List<Employee_VO> emp = hrService.emp_SearchEmpList(search_name, search_team, search_position, search_year,search_area);
		
		mav.addObject("result_search", emp);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	@RequestMapping("dupli_name")
	public ModelAndView emp_dupliname(@RequestParam String e_name) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		List<Employee_VO> member = hrService.emp_duplicheck(e_name);
		
		mav.addObject("count", member.size());
		
		mav.setViewName("JSON");
		
		return mav;		
	}
	
	@RequestMapping("empUpdate")
	public ModelAndView emp_UpdateView(HttpServletRequest req, @ModelAttribute Employee_VO empvo) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		/*String name = req.getParameter("name");
		String company = req.getParameter("company");
		String position = req.getParameter("position");
		String phonenum = req.getParameter("phonenum");
		String phonenum1 = req.getParameter("phonenum1");
		String phonenum2 = req.getParameter("phonenum2");
		String phonenum3 = req.getParameter("phonenum3");
		String team_id = req.getParameter("team_id");
		String team_name = req.getParameter("team_name");
		String area = req.getParameter("area");
		String job=req.getParameter("job");
		int salary = Integer.parseInt(req.getParameter("salary"));
		String hire_date = req.getParameter("hire_date");
		String career_date = req.getParameter("career_date");
		String quit_date = req.getParameter("quit_date");
		String division = req.getParameter("division");
		String photo = req.getParameter("photo");
		String email = req.getParameter("email");
		String etc = req.getParameter("etc");
		String skill = req.getParameter("skill");
		String h_name=req.getParameter("h_name");
		String grade=req.getParameter("grade");
		String time_off =req.getParameter("time_off");
		String to_start_day = req.getParameter("to_start_day");
		String to_end_day = req.getParameter("to_end_day");*/
		
		
		// ?????????????????? emp_getTimeoff 필요?///////////////////
		String name = req.getParameter("h_name");
		Employee_VO dbTimeoff=hrService.emp_getTimeoff(name);
		
		String h_name = req.getParameter("h_name");
		
	/*	Employee_VO empVO = new Employee_VO(name, company, position, grade,team_id, area,null,null,
							salary,phonenum,phonenum1,phonenum2,phonenum3,
							hire_date, quit_date, career_date, division,photo,email,etc, 
							null, null,skill,null,null,time_off,to_start_day,to_end_day);
	*/

		
		
		/*  DATE타입의 경우 'null' -> 'null' / '0000-00-00' / '' 등으로 표현되기 때문에
		 *  리스팅 시 문제가 되어 (구분어려움) 주석처리
		 *  	==> 쿼리에서 if문으로 대신 처리
		 *   */
		
		/*
		if(empvo.getQuit_date().equals("")){
			empvo.setQuit_date("0000-00-00");
		}
		*/
		
		/*
		if(empvo.getDivision().equals("직원")){
			if(empvo.getTo_start_day().equals("")){
				empvo.setTo_start_day("0000-00-00");
			}
			if(empvo.getTo_end_day().equals("")){
				empvo.setTo_end_day("0000-00-00");
			}
		}
		*/
		
		if(empvo.getDivision().equals("외주")){
			empvo.setGrade(empvo.getPosition());
			empvo.setTime_off("0");
//			empvo.setTo_start_day("0000-00-00");
//			empvo.setTo_end_day("0000-00-00");
			
		}
		
//		logger.debug("dbTimeoff.getTo_start_day()"+dbTimeoff.getTo_start_day());
//		logger.debug("to_start_day"+empvo.getTo_start_day());
//		logger.debug("dbTimeoff.getTo_end_day()"+dbTimeoff.getTo_end_day());
//		logger.debug("to_end_day"+empvo.getTo_end_day());
//		logger.debug("dbTimeoff.getTime_off()"+dbTimeoff.getTime_off());
//		logger.debug("time_off"+time_off);
		
		//h_name-> 이름 변경 전 이름
		//이름 변경 후 update 쿼리니까 변경 후 이름을 보냄 
		hrService.emp_Update(empvo, h_name);
		hrService.emp_SkillDel(empvo.getName());
//		hrService.emp_SkillInsert(name, empvo.getSkill());
		hrService.emp_SkillInsert(empvo.getName(), empvo.getJob());
		
		//직원 휴직처리
			
		
		//mpplace정보
		/*MpPlaceVO mpplace=hrService.getMpplaceInfo(name);
		String cpstartday=mpplace.getCpstartday();
		String cpendday=mpplace.getCpendday();
		String cpid=mpplace.getCpid();
		String apid=mpplace.getApid();
		*/
		/*
		if(dbTimeoff.getTo_start_day()==null){
			dbTimeoff.setTo_start_day("0000-00-00");
		}
		if(dbTimeoff.getTo_end_day()==null){
			dbTimeoff.setTo_end_day("0000-00-00");
		}
		*/
			/*
		if(!dbTimeoff.getTo_start_day().equals(to_start_day)){
			logger.debug("true");
		}else{
			logger.debug("false");
		}
		
		if(!dbTimeoff.getTo_end_day().equals(to_end_day)){
			logger.debug("true");
		}else{
			logger.debug("false");
		}
		
		if(!dbTimeoff.getTime_off().equals(time_off)){
			logger.debug("true");
		}else{
			logger.debug("false");
		}
		
		if(division.equals("직원")){
			logger.debug("true");
		}else{
			logger.debug("false");
		}
			
		logger.debug("apid"+apid);
			*/
		
		//휴직처리의 값이 변동이 있을 때
		
/*		
 * 		if(empvo.getDivision().equals("직원") && (!StringUtils.equals(dbTimeoff.getTo_start_day(), empvo.getTo_start_day()) || !StringUtils.equals(dbTimeoff.getTo_end_day(), empvo.getTo_end_day()) || !dbTimeoff.getTime_off().equals(empvo.getTime_off()) )){
			logger.debug("직원휴직처리!!!!!!!!!!!!1");
			
			//직원일 경우 DB에 있는 휴직기간과 휴직 상태가 입력값과 다를경우 mpplace의 휴직상태 업데이트
			//현재프로젝트를 수행할 경우
			if(cpid!=null && cpid.equals("휴직")){
				//휴직일과 프로젝트 수행일이 같을 경우
				if(cpstartday.compareTo(empvo.getTo_start_day())==0){
				
				}else if(cpstartday.compareTo(empvo.getTo_start_day())>0 && cpendday.compareTo(empvo.getTo_start_day()) < 0){
					logger.debug("휴직일과 프로젝트 수행일이 같지 않을 경우");
					
					hrService.emp_TimeoffUpdate(name,empvo.getTo_start_day(),empvo.getTo_end_day());
					hrService.pjHistory_TimeoffUpdate(name,empvo.getTo_start_day());
				}
			}else if(cpid!=null && cpid.equals("휴직")){
				logger.debug("현재 프로젝트를 수행하지 않을 경우1");
				
				hrService.emp_TimeoffUpdate3(name,empvo.getTo_start_day(),empvo.getTo_end_day()); //mpplace 휴직날짜만 update
				hrService.pjHistory_TimeoffDayUpdate(name,empvo.getTo_start_day(),empvo.getTo_end_day());//pj_history 휴직정보 update
			}else if(cpid==null){//현재 프로젝트를 수행하지 않을 경우
				logger.debug("현재 프로젝트를 수행하지 않을 경우");
				
				if(apid==null){
					hrService.emp_TimeoffUpdate(name, empvo.getTo_start_day(), empvo.getTo_end_day());
					hrService.emp_TimeoffInsert(name,empvo.getTo_start_day(),empvo.getTo_end_day());
				}else{
					logger.debug("apid가 null이 아닐경우");
					
					hrService.emp_TimeoffUpdate(name, empvo.getTo_start_day(), empvo.getTo_end_day());
					hrService.pjHistory_TimeoffDayUpdate(name,empvo.getTo_start_day(),empvo.getTo_end_day());//pj_history 휴직정보 update
					
					logger.debug("apid가 null이 아닐경우 pjhistory업데이트" + name +"::::"+ empvo.getTo_start_day() +"::::"+ empvo.getTo_end_day());
				}
			}
		}
		
	*/
		
		if(empvo.getDivision().equals("외주")){
			float mpm=Float.parseFloat(req.getParameter("mpm"));
			String cu_day=req.getParameter("cu_day");
			
			OutSal_historyVO hvo=new OutSal_historyVO(name,cu_day,empvo.getSalary(),mpm);
			
			if((!cu_day.equals(""))&&(!cu_day.equals("null"))){
				hrService.out_hisReg(hvo);
			}
		}
		
		mav.setViewName("JSON");
		
		return mav;
	}
	/*	hrService.emp_Update(empVO);
		
		mav.setViewName("JSON");
		
		return mav;
	}*/
	
	@RequestMapping("update.iqshr")
	public ModelAndView emp_Update(HttpServletRequest req, Employee_VO empVO)
	{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/insert.iqshr?name="+req.getParameter("name"));
		
		return mav;
	}

	
	
	@RequestMapping("empDelete")
	public ModelAndView emp_Delete(HttpServletRequest req )throws Exception
	{
		ModelAndView mav = new ModelAndView();
		//int id =Integer.parseInt(hideId);
		String name = req.getParameter("name");
		
		hrService.emp_Delete(name);
		hrService.emp_SkillDel(name);
		outSalService.deleteHistoryAll(name);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping("emp_DetailList")
	public ModelAndView  emp_detail (HttpServletRequest req) throws Exception
	{
		ModelAndView mav = new ModelAndView();		
		int chk=1;
		String name = req.getParameter("name");
		
		OutSal_historyVO vo = outSalService.getHistory(name);
		Employee_VO emp_detail = hrService.emp_getEmp(name);
		String skill = hrService.getSkill(name);
		//2015-04-23
		// 직원의 경우 @sqisoft.com 이 붙은 채로 db에 저장되므로 출력시 이메일 형식 제거  
		if(emp_detail.getDivision().equals("직원")){
			StringTokenizer st1 = new StringTokenizer(emp_detail.getEmail());
			emp_detail.setEmail(st1.nextToken("@"));
		}
		mav.addObject("vo",vo);
		mav.addObject("emp_detail", emp_detail);
		mav.addObject("skill",skill);
		mav.addObject("chk",chk);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping("checkEmail")
	public ModelAndView email_check(@RequestParam String email, @RequestParam String name) throws Exception
	{
		ModelAndView mav = new ModelAndView();
//		System.out.println(email);
		
		String result = hrService.mailCheck(email,name);
		
		mav.addObject("result_chkmail", result);
		
		mav.setViewName("JSON");

		return mav;
	}

	
	@RequestMapping("/getSkillOptions")
	public @ResponseBody List<Map<String, String>> getSkillOptions(@RequestParam String type,
			  													@RequestParam String val) throws Exception
	{
		return hrService.getSkillOptions(type, val);
	}
	
	@RequestMapping("/getAreaOptions")
	public @ResponseBody List<Map<String, String>> getAreaOptions(@RequestParam String type,
			  													@RequestParam String val) throws Exception
	{
		return hrService.getAreaOptions(type, val);
	}
}
