package com.sqisoft.iqs.pf.schedule.controller;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.sqisoft.iqs.pf.schedule.service.WeekBudgetServiceIF;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.BudgetVO;

@Controller("scheduleController")
public class ScheduleController {/* extends BaseController {*/
	
	private WeekBudgetServiceIF weekbudget_service;
	private TeamServiceIF team_service;

	public void setWeekbudget_service(WeekBudgetServiceIF weekbudget_service) {
		this.weekbudget_service = weekbudget_service;
	}
	public void setTeam_service(TeamServiceIF team_service) {
		this.team_service = team_service;
	}

	//@Scheduled(cron="0 * * * * *")
	@Scheduled(cron="0 0 0 * * 1")
	public void weekbudgetInsert(){
		List<BudgetVO> list = team_service.getBudgetInfoList();
		weekbudget_service.weekbudgetInsert(list);
	}
	
	@Scheduled(cron="0 0 0 * * 1")
	//@Scheduled(cron="0 * * * * *")
	public void weekChartInsert(){
		List<BudgetVO> list = team_service.getBudgetInfoList();
		weekbudget_service.weekChartInsert(list);
	}
}
