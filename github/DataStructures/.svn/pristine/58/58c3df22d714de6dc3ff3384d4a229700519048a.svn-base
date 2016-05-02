package com.sqisoft.iqs.hr.emp.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.sqisoft.iqs.hr.emp.service.EmpScheduleService;

@Controller
public class EmpScheduleController {

	private EmpScheduleService empScheduleService;
	
	public void setEmpScheduleService(EmpScheduleService empScheduleService) {
		this.empScheduleService = empScheduleService;
	}

	@Scheduled(cron="0 0 0 * * *") //매일 0시에 실행 
//	@Scheduled(cron="0 * * * * *") //분 시 일 월 요일 (매 분마다 실행)
	public void pjposting_Update(){
		this.empScheduleService.PjPostingUpdate();
	}
	
	@Scheduled(cron="0 0 0 * * *") //매일 0시에 실행 
//	@Scheduled(cron="0 * * * * *") //분 시 일 월 요일 (매 분마다 실행)
	public void pjpostingcp_Update(){
		this.empScheduleService.PjPostingcpUpdate();
	}
	
	
	@Scheduled(cron="0 0 0 * * *")
//	@Scheduled(cron="0 * * * * *")
	public void timeoff_Mpplace_Update(){
		this.empScheduleService.timeoff_Mpplace_Update();
	}
	
	@Scheduled(cron="0 0 0 * * *")
//	@Scheduled(cron="0 * * * * *")
	public void timeoff_employee_Update(){
		this.empScheduleService.timeoff_employee_Update();
	}
}
