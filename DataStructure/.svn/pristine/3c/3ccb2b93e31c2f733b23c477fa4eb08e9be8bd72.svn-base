package com.sqisoft.iqs.humanResource.costmap.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.costmap.dao.CostMapDAO;
import com.sqisoft.iqs.humanResource.costmap.service.CostMapService;
import com.sqisoft.iqs.humanResource.costmap.vo.CostMapVO;
import com.sqisoft.iqs.humanResource.employeeInput.dao.EmployeeInputDAO;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HumanResourceDAO;
import com.sqisoft.iqs.humanResource.waitingList.dao.WaitingListDAO;
import com.sqisoft.iqs.humanResource.waitingList.vo.WaitingListVO;
import com.sqisoft.iqs.project.dao.ProjectDAO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.dao.TeamDAO;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;

public class CostMapServiceImpl implements CostMapService {

	private CostMapDAO costMapDAO;
	private TeamDAO teamDAO;
	private ProjectDAO projectDAO;
	private EmployeeInputDAO employeeInputDAO;
	private WaitingListDAO waitingListDAO;

	public void setCostMapDAO(CostMapDAO costMapDAO) {
		this.costMapDAO = costMapDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	public void setEmployeeInputDAO(EmployeeInputDAO employeeInputDAO) {
		this.employeeInputDAO = employeeInputDAO;
	}
	
	public void setWaitingListDAO(WaitingListDAO waitingListDAO) {
		this.waitingListDAO = waitingListDAO;
	}

	// 리스트
	@Override
	public List<CostMapVO> getCostmapList(String tm_id) throws ParseException {
		String hp_mon_price="";
		
		// 투입테이블에서 project 불러오기
		List<String> projectListByTeam = this.employeeInputDAO.getProjectNamesByTeamId(tm_id);
		
		// project 별로 CostMAPVO에 담는다.
		Map<String, String> params = new HashMap<String, String>();
		
		List<CostMapVO> totalList = new ArrayList<CostMapVO>();
		CostMapVO costMapVO = null;
		
		// 합계 계산
		double totalMM = 0d;
		double totalCost = 0d;
		List<CostMapVO> tempList = new ArrayList<CostMapVO>();
		double hr_mm = 0d;
		
		//프로젝트별 직원/외주 인건비
		int pj_emp_mm_cost = 0;
		int pj_out_mm_cost = 0;
		
		//프로젝트별 직원/외주 mm 
		double pj_emp_mm_sum = 0d;
		double pj_out_mm_sum = 0d;
		
		
		//팀 별 프로젝트
		for(String pj_id : projectListByTeam) {
			pj_out_mm_cost = 0;
			pj_emp_mm_cost = 0;
			pj_emp_mm_sum = 0;
			pj_out_mm_sum = 0;
			totalCost = 0;
			
			//해당 프로젝트에 투입된 직원 list를 가져옴
			params.put("pj_id", pj_id);
			List<CostMapVO> hrList = this.costMapDAO.getCostmapList(params);
			tempList.addAll(hrList);
			
			if(hrList.size() != 0) { 
				totalMM = 0.0d;
				for(CostMapVO hr : hrList) {
					//직원의 mm 계산
					hr_mm = hr.getPd_mm();
					/*hr_mm = CalendarUtil.calculateManMonth(hr.getPd_start_date(), hr.getPd_end_date());
					hr_mm = Math.round(hr_mm * 10d)/10d;
					hr.setPd_mm(hr_mm);*/
					//System.out.println(hr.getPd_name()+"의 MM : " + hr_mm);
					
					if(hr.getHr_position() != null) { //직원의 경우
						if(!tm_id.equals("6M15")){ //경영지원팀이 아닌 경우
							//해당 tm에 맞는 직급 단가를 가져와 setting
							Map<String, String> map = new HashMap<String, String>();
							map.put("tm_id", tm_id);
							map.put("hr_name", hr.getPd_name());
							map.put("pd_mm", Double.toString(hr_mm));
							map.put("pd_sq", Integer.toString(hr.getPd_sq()));
							
							//this.costMapDAO.updateMM(map);
							
							hp_mon_price = this.costMapDAO.getHrUprice(map);
							hr.setHp_mon_price(Integer.parseInt(hp_mon_price));
							
						}else{ //경영지원팀의 경우 직급 상관없이 평균 단가 적용
							hp_mon_price = this.costMapDAO.get6M15price();
							hr.setHp_mon_price(Integer.parseInt(hp_mon_price));
							
						}
						
						//pj 직접비
						pj_emp_mm_cost += hr_mm * hr.getHp_mon_price();
						
						//직원의 인건비 계 
						hr.setCost((Math.round(hr_mm * 10d)/10d) * hr.getHp_mon_price());
						
						//직원 MM
						pj_emp_mm_sum += hr_mm;
						
						// 직급 숫자 없애기
						hr.setHr_position(hr.getHr_position().replaceAll("[0-9]", ""));
						
					}
					
					if(hr.getHr_grade() != null) { 
						//등급 숫자 없애기
						hr.setHr_grade(hr.getHr_grade().replaceAll("[0-9]", ""));
					}
					
					//외주인 경우
					if(!hr.getHr_company().contains("SQI")){ //프로젝트 별 외주비 계산
						if(hr.getHr_company().length() != 0){
							//외주 MM 합
							pj_out_mm_sum += hr_mm;
								
							//외주비 합 
							if(hr.getPj_status().contains("A")){
								//보여줄 때만 0.9를 곱해주고 DB에는 안곱해주고 저장
								hr.setCost(hr_mm * hr.getHp_mon_price()*0.9);									
							}else{
								hr.setCost(hr_mm * hr.getHp_mon_price());
							}
							pj_out_mm_cost += hr_mm * hr.getHp_mon_price();	
						}
					}
					
					//전체 MM(직원+외주) 
					totalMM += hr_mm;
					
				}
				//전체 인건비(직원+외주)
				double sumCost = pj_emp_mm_cost + pj_out_mm_cost;
				totalCost += sumCost;
				
				//합계 출력
				costMapVO = new CostMapVO();
				costMapVO.setTm_name(hrList.get(0).getTm_name());
				costMapVO.setPj_id("합계");
				//System.out.println("합계 : totalCost ----------"+ totalCost);
				costMapVO.setCost(totalCost);				
				costMapVO.setPd_mm(Math.round(totalMM*10d)/10d);
				
								
				if(tempList.size() != 0) {
					totalList.addAll(tempList);
					tempList.clear();
					totalList.add(costMapVO);
				}
			}
			
			System.out.println(pj_id + "의 직접비 : " + Math.round(pj_emp_mm_cost));
			System.out.println(pj_id + "의 외주비 : " + Math.round(pj_out_mm_cost));
			System.out.println(pj_id + "의 직원 mm 합 : " + Math.round(pj_emp_mm_sum*10d)/10d);
			System.out.println(pj_id + "의 외주 mm 합 : " + Math.round(pj_out_mm_sum*10d)/10d);
			System.out.println("*****************************************************");
			
		}
		
		totalMM = 0d;
		totalCost = 0d;
		
		//대기 테이블
		List<WaitingListVO> waitList = waitingListDAO.getWaitList(tm_id);
		CostMapVO cm;
		for(int i=0; i<waitList.size(); i++){
			cm = new CostMapVO();
			//프로젝트 명
			cm.setPj_id("대기/미배치");
			
			//성명
			cm.setPd_name(waitList.get(i).getWa_name());
			
			//직급or등급
			if(waitList.get(i).getHr_position() != null)
				cm.setHr_position(waitList.get(i).getHr_position().replaceAll("[0-9]", ""));
			if(waitList.get(i).getHr_grade() != null)
				cm.setHr_grade(waitList.get(i).getHr_grade().replaceAll("[0-9]", ""));
			
			//직급단가
			cm.setHp_mon_price(waitList.get(i).getHr_uprice());
			
			//대기 기간
			cm.setPd_start_date(waitList.get(i).getWa_from_date());
			cm.setPd_end_date(waitList.get(i).getWa_to_date());
				
			//투입률X
			cm.setPd_ratio(0);
			
			//MM
			double manMonth = Math.round(CalendarUtil.calculateManMonth
						(waitList.get(i).getWa_from_date(), waitList.get(i).getWa_to_date())* 10d)/ 10d;
			/*System.out.println(cm.getPd_name()+"의 manMonth : "+manMonth);*/
			cm.setPd_mm(manMonth);
			
			//인건비 계
			totalMM += manMonth;
			totalCost += manMonth * cm.getHp_mon_price();
			cm.setCost(Math.round(manMonth * cm.getHp_mon_price()));
			
			totalList.add(cm);
			
			System.out.println("888888888888888888888888888888888888888888");
			System.out.println("대기/미배치 직원 이름 : "+cm.getPd_name());
			System.out.println("단가 : "+cm.getHp_mon_price());
			
		}
		
		costMapVO = new CostMapVO();
		costMapVO.setTm_name(tm_id);
		costMapVO.setPj_id("합계");
		costMapVO.setCost(Math.round(totalCost));
		costMapVO.setPd_mm(Math.round(totalMM*10d)/10d);
		totalList.add(costMapVO);
		
		return totalList;
	}
	
	
	
	
	/*private boolean isLabor(String hr_name, String deploy_end_date) throws ParseException {
		
		HumanResourceVO hr = this.humanResourceDAO.getHumanResourceDetailFormAjax(hr_name);
		
		SimpleDateFormat transferDate = new SimpleDateFormat("yyyy-MM-dd");
		Date quitDate = null;
		Date endDate = transferDate.parse(deploy_end_date);
		
		if(hr == null || ( hr.getHr_company() == null && hr.getHr_quit_date() == null ) ) return false;
		
		if(hr.getHr_company().contains("SQI") && (hr.getHr_quit_date() == null || hr.getHr_quit_date() == "") ) {
			return true;
		} else {
			if(hr.getHr_quit_date() != null && hr.getHr_quit_date() != "") {
				
				quitDate = transferDate.parse(hr.getHr_quit_date());
				
				if(endDate.before(quitDate) || endDate.equals(quitDate)) return true;
			}
		}
		
		return false;
	}*/

	@Override
	public void mmupdate() {
		String tm_id;
		int year = CalendarUtil.getPresentYear();
		List<TeamVO> teamList = this.teamDAO.getTeamListByYear(year);
		List<ProjectVO> projectList = null;
		List<EmployeeInputVO> deployList = null;
		String pd_start_date = "";
		String pd_end_date = "";
		String pj_id = "";
		
		Map<String, Object> params = new HashMap<String, Object>();
		for(TeamVO team : teamList) {
			projectList = this.projectDAO.getProjectListByTeamId(team.getTm_id());
			tm_id = team.getTm_id();
			for(ProjectVO project: projectList) {
				deployList = this.employeeInputDAO.getDeployListByPjId(project.getPj_id());
				pj_id = project.getPj_id();
				for(EmployeeInputVO deploy : deployList) {
					pd_start_date = deploy.getPd_start_date();
					pd_end_date = deploy.getPd_end_date();
					params.put("pj_id", pj_id);
					params.put("pd_sq", deploy.getPd_sq());
					params.put("pd_mm", (Math.round((Math.round(CalendarUtil.calculateManMonth(pd_start_date, pd_end_date)*deploy.getPd_ratio()))/10d)/10d));
					this.employeeInputDAO.updateMM(params);
				}
			}
		}
	}
}
