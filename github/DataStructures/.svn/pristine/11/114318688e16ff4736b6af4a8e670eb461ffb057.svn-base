package com.sqisoft.iqs.humanResource.employeeInput.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.deployRequirements.dao.DeployRequirementsDAO;
import com.sqisoft.iqs.humanResource.employeeInput.dao.EmployeeInputDAO;
import com.sqisoft.iqs.humanResource.employeeInput.service.EmployeeInputService;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;

public class EmployeeInputServiceImpl implements EmployeeInputService {
	
	EmployeeInputDAO employeeInputDAO;
	DeployRequirementsDAO deployRequirementsDAO;
	
	public void setEmployeeInputDAO(EmployeeInputDAO employeeInputDAO) {
		this.employeeInputDAO = employeeInputDAO;
	}

	// team list 출력
	@Override
	public List<EmployeeInputVO> getSearchTeamListAjax() {
		return employeeInputDAO.getTeamNames();
	}

	// tm_name으로 프로젝트 검색하기
	@Override
	public List<EmployeeInputVO> getSearchTeamProjectListAjax(String tm_id) {
		return employeeInputDAO.getProjectList(tm_id);
	}

	// pj_id로 프로젝트 정보 가져오기
	@Override
	public EmployeeInputVO getEmployeeInputDetailForm1Ajax(String pj_id) {
		return employeeInputDAO.getProjectInfoByPjId(pj_id);
	}

	// 직원 이름 입력시 해당 직원의 정보 출력
	@Override
	public HumanResourceVO getHrInfoByNameAjax(String pr_name) {
		
		HumanResourceVO hr = employeeInputDAO.getHrInfoByName(pr_name);
		String grade = "";
		String position = "";
		if(hr!=null){
			System.out.println(hr.getHr_name());
			if(hr.getHr_grade() != null)
				grade = hr.getHr_grade().replaceAll("[0-9]", "");
			if(hr.getHr_position() != null)
				position = hr.getHr_position().replaceAll("[0-9]", "");
			hr.setHr_grade(grade);
			hr.setHr_position(position);
		}
		return hr;
	}
	
	//프로젝트의 투입 + 배치소요 테이블에 있는 직원 List를 가져옴
	@Override
	public List<EmployeeInputVO> getEmployeeInputDetailForm2(String pj_id) {
		List<EmployeeInputVO> l1 = employeeInputDAO.getDeployL1(pj_id);
		for(int i=0; i<l1.size(); i++){
			if(l1.get(i).getHr_grade() != null)
				l1.get(i).setHr_grade(l1.get(i).getHr_grade().replaceAll("[0-9]", ""));
		}
		List<EmployeeInputVO> l2 = employeeInputDAO.getDeployL2(pj_id);
		for(int j=0; j<l2.size(); j++){
			if(l2.get(j).getPr_name() != null){
				if(l2.get(j).getPr_grade() != null){
					l2.get(j).setPr_grade(l2.get(j).getPr_grade().replaceAll("[0-9]", ""));
					l2.get(j).setPd_name(l2.get(j).getPr_name());
				}
				
			}
		}
		l1.addAll(l2);	
		return l1;
	}
	
	//저장
	@Override
	public void insertPjDeploy(Map<String, Object> map) {
		int hr_mon_price = 0;
		String tm_id = employeeInputDAO.getTm_id(map.get("pj_id").toString());
		HumanResourceVO hr = employeeInputDAO.getHrInfoByName(map.get("pd_name").toString());
		
		if (hr.getHr_company().contains("SQI") || hr.getHr_company().length() == 0) {
			//해당 직급 단가 구하기
			if(!tm_id.equals("6M15")){ //경영지원팀이 아닌 경우
				//해당 tm에 맞는 직급 단가를 가져와 setting
				hr_mon_price = employeeInputDAO.getHr_mon_price(map);
			}else{ //경영지원팀의 경우 직급 상관없이 평균 단가 적용
				hr_mon_price = employeeInputDAO.get6M15price();
			}
		}else{
			hr_mon_price = Integer.parseInt(hr.getHr_uprice());
		}
		
		double mm = 0d;
		mm = CalendarUtil.calculateManMonth(map.get("pd_start_date").toString(), map.get("pd_end_date").toString());
		mm = Math.round(mm * 10d)/10d;
		
		map.put("pd_uprice", hr_mon_price);
		map.put("pd_mm", mm);
		

		//저장 및 update
		employeeInputDAO.insertPjDeploy(map);
		
	}
	
	//저장, 수정시 해당 PJ의 PJ직접비, 외주비 update
	public void updateCost(String pj_id){
		System.out.println("pj_id : "+ pj_id);

		//mm 합
		double emp_mm_sum = 0d;
		double out_mm_sum = 0d;
		
		//인건비(PJ직접 & 외주비)
		double emp_cost = 0d;
		double empOut_cost = 0d;
		
		// 해당 프로젝트에 투입된 사람들을 모두 불러옴
		List<EmployeeInputVO> ev = employeeInputDAO.getPjDeployInfoByPjId(pj_id);
		
		for(int i=0; i<ev.size();i++){
			HumanResourceVO hr = employeeInputDAO.getHrInfoByName(ev.get(i).getPd_name());
			double mm = ev.get(i).getPd_mm();
			
			// 직원인 경우
			if (hr.getHr_company().contains("SQI") || hr.getHr_company().equals("")) {
				
				//직원 mm 합
				emp_mm_sum += mm;
				
				//PJ직접비
				emp_cost += ev.get(i).getPd_uprice() * mm;
				
				System.out.println("직원 이름: " + ev.get(i).getPd_name());
				System.out.println(" 단가 : " +ev.get(i).getPd_uprice());
				System.out.println("mm : " + mm);
				System.out.println("인건비 : " + ev.get(i).getPd_uprice() * mm);
				System.out.println("------------------");
				
			} 
			else{ //외주인 경우
				
				//외주 mm 합
				out_mm_sum += mm;
				
				//외주비
				empOut_cost += ev.get(i).getPd_uprice() * mm;
				
				System.out.println("외주 이름: " + ev.get(i).getPd_name());
				System.out.println(" 단가 : " + ev.get(i).getPd_uprice());
				System.out.println("mm : " + mm);
				System.out.println("인건비 : " + ev.get(i).getPd_uprice() * mm);
				System.out.println("------------------");
				
			}
		}
		
		System.out.println("직원 mm : " + emp_mm_sum);
		System.out.println("외주 mm : " + out_mm_sum);
		System.out.println("PJ 직접비 : " + emp_cost);
		System.out.println("외주비 : " + empOut_cost);
		System.out.println("************************************");

		// project DB에 update해줌.
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pj_id", pj_id);
		result.put("emp_mm_sum", emp_mm_sum);
		result.put("out_mm_sum", out_mm_sum);
		result.put("emp_cost", emp_cost);
		result.put("empOut_cost", empOut_cost);
		
		employeeInputDAO.updateCost(result);
		
	}

	//List에서 직원 선택시, 해당 직원 정보를 가져옴
	@Override
	public EmployeeInputVO getEmployeeInputInfoForm(Map<String, Object> map) {
		return employeeInputDAO.getEmployeeInputInfoForm(map);
	}

	//삭제
	@Override
	public void deletePjRequire(Map<String, Object> map) {
		employeeInputDAO.deleteRequire(map);
	}

	
	//신규 투입인 경우 중복 검사
	@Override
	public boolean checkDuplicate(Map<String, Object> map) {
		List<EmployeeInputVO> ev = employeeInputDAO.getEmployeeInputInfo(map); 
		boolean checkDup = false;
		String pd_start, pd_end = null;
		
		//insert form에 입력한 투입일, 투입 만료일
		String cur_start_date = map.get("pd_start_date").toString().replaceAll("-", "");
		int cur_st = Integer.parseInt(cur_start_date);
		String cur_end_date = map.get("pd_end_date").toString().replaceAll("-", "");
		int cur_end = Integer.parseInt(cur_end_date);
		
		for(int i=0; i<ev.size(); i++){
			pd_start = ev.get(i).getPd_start_date().replaceAll("-", "");
			pd_end = ev.get(i).getPd_end_date().replaceAll("-", "");
			
			int pd_start_date = Integer.parseInt(pd_start);
			int pd_end_date = Integer.parseInt(pd_end);
			
			//내가 속한 프로젝트의 시작일과 종료일 사이에 현재 입력한 투입일과 만료일이 들어갈 경우 중복!
			if((cur_st >= pd_start_date && cur_st <=pd_end_date) || (cur_end >=pd_start_date && cur_end <=pd_end_date)){
				System.out.println("중복걸림");
				checkDup = true;
				break;
			}
			else
				checkDup = false;
		}
		
		return checkDup;
	}
	
	// 수정인 경우 중복 검사 
	public boolean checkDuplicate_mod(Map<String, Object> map) {
		List<EmployeeInputVO> ev = employeeInputDAO.getEmployeeInputInfo(map); 
		boolean checkDup = false;
		String pd_start, pd_end = null;
		
		//insert form에 입력한 투입일, 투입 만료일
		String cur_start_date = map.get("pd_start_date").toString().replaceAll("-", "");
		int cur_st = Integer.parseInt(cur_start_date);
		String cur_end_date = map.get("pd_end_date").toString().replaceAll("-", "");
		int cur_end = Integer.parseInt(cur_end_date);
		
		for(int i=0; i<ev.size(); i++){
			if(ev.get(i).getPj_id().equals(map.get("pj_id").toString())){
				continue;
			}else{
				pd_start = ev.get(i).getPd_start_date().replaceAll("-", "");
				pd_end = ev.get(i).getPd_end_date().replaceAll("-", "");
				
				int pd_start_date = Integer.parseInt(pd_start);
				int pd_end_date = Integer.parseInt(pd_end);
				
				//내가 속한 프로젝트의 시작일과 종료일 사이에 현재 입력한 투입일과 만료일이 들어갈 경우 중복!
				if((cur_st >= pd_start_date && cur_st <=pd_end_date) || (cur_end >=pd_start_date && cur_end <=pd_end_date)){
					checkDup = true;
					break;
				}
				else
					checkDup = false;
			}
				
			
		}
		
		return checkDup;
	}
	
		
}

