package com.sqisoft.iqs.hr.main.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.sqisoft.iqs.hr.main.dao.HrDAO;
import com.sqisoft.iqs.hr.main.service.HrService;
import com.sqisoft.iqs.hr.outsal.dao.OutSalHistoryDAO;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.MpPlaceVO;
import com.sqisoft.iqs.hr.vo.MppListVO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.ProjectCountVO;
import com.sqisoft.iqs.hr.vo.ProjectVO;
import com.sqisoft.iqs.hr.vo.SkillVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

public class HrServiceImpl implements HrService {

	private HrDAO hrDao;
	
	private OutSalHistoryDAO outSalHistoryDAO;
	
	public void setHrDao(HrDAO hrDao) {
		this.hrDao = hrDao;
	}

	public void setOutSalHistoryDAO(OutSalHistoryDAO outSalHistoryDAO) {
		this.outSalHistoryDAO = outSalHistoryDAO;
	}

	public void project_Insert(ProjectVO pjVO) {

		hrDao.project_Insert(pjVO);
	}

	// 전체 직원명부
	@Override
	public List<MppListVO> emp_MppList(String team_id) {

		return hrDao.emp_MppList(team_id);

	}

	@Override
	public void emp_Insert(Employee_VO employeeVO) {
		

		Map<String, String> hash =new HashMap<String, String>();
		hash.put("name", employeeVO.getName());
		Employee_VO vo=hrDao.emp_getEmp(hash);
		char a=65;
		if(vo!=null)
		{
			String name= hrDao.getMaxName(employeeVO.getName());
			if(name!=null){
			String[] res=name.split(" ");
			a=res[1].charAt(0);
			a++;
			res[1]=a+"";
			String result=res[0]+" "+res[1];
			employeeVO.setName(result);
			}
			else
				employeeVO.setName(employeeVO.getName()+" A");
		}
		
		employeeVO.setPhonenum(employeeVO.getPhonenum1()+"-"+employeeVO.getPhonenum2()+"-"+employeeVO.getPhonenum3());
		//hrDao.emp_Insert(employeeVO);

		hrDao.emp_Insert(employeeVO);
		hrDao.place_Insert(employeeVO.getName());
		if(employeeVO.getDivision().equals("직원")){
//			System.out.println(employeeVO.getDivision());
//			System.out.println(employeeVO.getName());
		hrDao.emppj_Insert(employeeVO);	//신규 인력 등록시 pj_history에 대기로 등록

		}
	}

	@Override
	public void emp_Update(Employee_VO empVO,String h_name) {

		empVO.setPhonenum(empVO.getPhonenum1()+"-"+empVO.getPhonenum2()+"-"+empVO.getPhonenum3());
		
		if(empVO.getArea().equals("/")){
			empVO.setArea(null);
		}
		else{
		String areas[]=empVO.getArea().split("/");
		String area=areas[0]+"/" + areas[1]+"/"+ areas[4];
		empVO.setArea(area);
		}
		
		//h_name -> 이름 변경전d DB에 저장되 있는 원래 이름 
		empVO.setH_name(h_name);
		hrDao.emp_UpdateWithHName(empVO);
//		hrDao.emppj_Update(empVO); // 입사일 수정시 pj_history에 '대기' 시작일 수정
		
	}

	@Override
	public void emp_Delete(String name) {

		hrDao.place_Delete(name);
		hrDao.emp_Delete(name);
	}

	@Override
	public Employee_VO emp_getEmp(String name) {
		// TODO Auto-generated method stub
		Map<String, String> hash =new HashMap<String, String>();
		hash.put("name", name);
		
		Employee_VO test = new Employee_VO();
		
		test =  hrDao.emp_getEmp(hash);
		
		if(!test.getPhonenum().equals("010--")){
		String[] phone=test.getPhonenum().split("-");
		test.setPhonenum1(phone[0]);
		test.setPhonenum2(phone[1]);
		test.setPhonenum3(phone[2]);
		}
		else {
			test.setPhonenum1("010");
			test.setPhonenum2("0000");
			test.setPhonenum3("0000");
		}
		String photo=test.getPhoto();
		/*if(photo==null || photo.isEmpty()){
			photo = CommonConstants.uploadPath + "emp_nophoto.jpg";
		}*/
		test.setPhoto(photo);

		
		return test;
	}

	@Override
	public List<Employee_VO> emp_getEmpList() {
		hrDao.emp_getEmpList();
		return null;
	}

	@Override
	public List<ProjectCountVO> project_GetCount(String team_id) {
		return hrDao.project_GetCount(team_id);
	}

	@Override
	public List<Employee_VO> emp_SearchEmpList(String searchname,	String searchteam, String searchposition, String searchyear, String searcharea) {
	
		Map<String, String> hash =new HashMap<String, String>();
		 
		hash.put("name", searchname);
		hash.put("team", searchteam);
		hash.put("position", searchposition);
		hash.put("area", searcharea);
		hash.put("year", searchyear);

		return hrDao.emp_SearchEmpList(hash);
		
	}

	@Override
	public List<Employee_VO> emp_duplicheck(String name) {
		// TODO Auto-generated method stub
		
		return hrDao.emp_duplicheck(name);
	}
	
	
	@Override
	public String mailCheck(String mailID, String name) throws NullPointerException{
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("mailID", mailID);
		param.put("name", name);
		Employee_VO emp = hrDao.mailCheck(param);
		if(emp == null){
			return "OK";
		}else
			return "FAIL_D";	//중복 체크
		
//		}			
//	else return "FAIL_E";	//유효성체크 (js에서 하고있음)
//		
		
		
		/*	
			Map<String, String> hash =new HashMap<String, String>();
			hash.put("mailID", mailID);
			hash.put("name", name);
			String[] empVO= hrDao.mailCheck(hash);
	
			if(empVO!=null){
				for(int i=0;i<empVO.length;i++){
					StringTokenizer st1 = new StringTokenizer(empVO[i]);
					empVO[i]=st1.nextToken("@");
				}
			}
			else 
				for(int i=0;i<empVO.length;i++)empVO[i]="";
			int count=0;
			for(int i=0;i<empVO.length;i++){
			if(!(empVO.equals(mailID)))
			{
				count++;
			}
			}
			if(count==empVO.length)return "OK";
			else return "FAIL_D";  
			*/	
		

	}
	

	public List<Map<String, String>> getSkillOptions(String type, String val) {
	 if(type.equals("1")){
			if(val.isEmpty() || val.equals("")){
				return hrDao.getSkillOptionsPC();	//기술 - 부모카테고리
			}else{
				return hrDao.getSkillOptionsCC(val);	//기술 - 자식카테고리
			}
		}else if(type.equals("2")){
			return hrDao.getSkillOptionsDC();	//업무 카테고리
		}
		return null;
	}
	public List<Map<String, String>> getAreaOptions(String type, String val) {
		 if(type.equals("1")){
				if(val.isEmpty() || val.equals("")){
					return hrDao.getAreaOptionsPC();	//기술 - 부모카테고리
				}else{
					return hrDao.getAreaOptionsCC(val);	//기술 - 자식카테고리
				}
			}
			return null;
	}



	@Override
	public void emp_SkillInsert(String name,String skill) {
		StringTokenizer st1 = new StringTokenizer(skill);
		StringTokenizer res;
		String fieldcd="",groupcd="",skillcd="",year="";
		int i;
		SkillVO vo;
        while (st1.hasMoreElements()) { 
            String result = st1.nextElement().toString();  //공백으로 자를시 사용
            res=new StringTokenizer(result);
            i=0;
            while(res.hasMoreElements()){
            	switch (i)
            	{
            	case 1:
            		fieldcd=res.nextToken("/");
            		break;
            	case 2:
            		groupcd=res.nextToken("/");
            		break;
            	case 3: 
            		skillcd=res.nextToken("/");
            		break;
            	case 4: 
            		year=res.nextToken("/");
            		break;
            	}
            	i++;
            }
            if(fieldcd!=""&&groupcd!=""&&skillcd!=""&&year!=""){
            	vo = new SkillVO(name,fieldcd,groupcd,skillcd,Integer.parseInt(year));
            	hrDao.emp_SkillInsert(vo);
            }
            if(fieldcd.equals("2")){
            	vo = new SkillVO(name,fieldcd,groupcd,"",0);
            	hrDao.emp_SkillInsert(vo);
            }
            
	}

	}

	/*@Override
	public String getName(String email) {
		
		return hrDao.getName(email);
	}*/

	@Override
	public void emp_SkillDel(String name) {
		hrDao.emp_SkillDel(name);
		
	}

	@Override
	public String getSkill(String name) {
		List<SkillVO> vo=hrDao.getSkill(name);
		String result="";
		
		for(SkillVO s : vo)
		{
			result+=s.toString()+",";
		}
		return result;
	}

	@Override
	public List<Employee_VO> empSearch(SkillVO vo) {
		
		return hrDao.empSearch(vo);
	}

	@Override
	public void out_hisReg(OutSal_historyVO hvo) throws ParseException {
		PjHistoryVO vo=outSalHistoryDAO.checkHistory(hvo);
		PjHistoryVO first,second=null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date=dateFormat.parse(hvo.getHire_date());
        cal.setTime(date);
        cal.add(Calendar.DATE, -1); 
        System.out.println("checkHistory : " + vo);
		if(vo!=null)
		{
			first=new PjHistoryVO(hvo.getName(),vo.getPj_id(),vo.getPj_start_day(),dateFormat.format(cal.getTime()),"");
			second=new PjHistoryVO(hvo.getName(),vo.getPj_id(),hvo.getHire_date(),vo.getPj_end_day(),"");
			outSalHistoryDAO.deletePjhistory(vo);
			outSalHistoryDAO.insertPjhistory(first);
			outSalHistoryDAO.insertPjhistory(second);
		}
		if(outSalHistoryDAO.checkOutHis(hvo)==0)
			hrDao.out_hisReg(hvo);
		else
			outSalHistoryDAO.out_hisUpdate(hvo);
	}

	@Override
	public void emp_TimeoffUpdate(String name, String to_start_day,String to_end_day) {
		Map<String, String> hs=new HashMap<String, String>();
		System.out.println("to_start_day"+to_start_day);
		System.out.println("to_end_day"+to_end_day);
		
		hs.put("name", name);
		hs.put("to_start_day", to_start_day);
		hs.put("to_end_day", to_end_day);
		
		hrDao.emp_TimeoffUpdate(hs);
		
	}

	@Override
	public void emp_TimeoffInsert(String name, String to_start_day,String to_end_day) {
		Map<String, String> hs=new HashMap<String, String>();
		
		hs.put("name", name);
		hs.put("to_start_day", to_start_day);
		hs.put("to_end_day", to_end_day);
		System.out.println("emp_TimeoffInsert---1");
		hrDao.emp_TimeoffInsert(hs);
		System.out.println("emp_TimeoffInsert---2");
	}

	@Override
	public void pjHistory_TimeoffUpdate(String name, String to_start_day) {
		Map<String, String> hs=new HashMap<String, String>();
		
		hs.put("name", name);
		hs.put("to_start_day", to_start_day);
		hrDao.pjHistory_TimeoffUpdate(hs);
	}

	@Override
	public Employee_VO emp_getTimeoff(String name) {
		return hrDao.emp_getTimeoff(name);
	}

	@Override
	public void pjHistory_TimeoffDayUpdate(String name, String to_start_day,String to_end_day) {
		Map<String, String> hs=new HashMap<String, String>();
		
		hs.put("name", name);
		hs.put("to_start_day", to_start_day);
		hs.put("to_end_day", to_end_day);

		hrDao.pjHistory_TimeoffUpdate(hs);
		
		System.out.println("pjHistory_Timeoff" + hs);
		
	}

	@Override
	public MpPlaceVO getMpplaceInfo(String name) {
		return hrDao.getMpplaceInfo(name);
	}

	@Override
	public void emp_TimeoffUpdate2(String name, String to_start_day,String to_end_day) {
		Map<String, String> hs=new HashMap<String, String>();
		
		hs.put("name", name);
		hs.put("to_start_day", to_start_day);
		hs.put("to_end_day", to_end_day);
		
		hrDao.emp_TimeoffUpdate2(hs);
		
	}	
	@Override
	public void emp_TimeoffUpdate3(String name, String to_start_day,String to_end_day) {
		Map<String, String> hs=new HashMap<String, String>();
		
		hs.put("name", name);
		hs.put("to_start_day", to_start_day);
		hs.put("to_end_day", to_end_day);
		
		System.out.println("emp_TimeoffUpdate3"+hs);
		
		hrDao.emp_TimeoffUpdate3(hs);
		
	}	



}




