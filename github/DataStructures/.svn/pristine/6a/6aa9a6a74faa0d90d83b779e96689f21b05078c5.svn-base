package com.sqisoft.iqs.pf.schedule.service.impl;

import java.util.List;

import com.sqisoft.iqs.pf.project.dao.ProjectDAO;
import com.sqisoft.iqs.pf.schedule.dao.WeekBudgetDAO;
import com.sqisoft.iqs.pf.schedule.dao.WeekendDAO;
import com.sqisoft.iqs.pf.schedule.service.WeekBudgetServiceIF;
import com.sqisoft.iqs.pf.team.dao.TeamDAO;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.TeamVO;
import com.sqisoft.iqs.pf.vo.WeekBudgetVO;
import com.sqisoft.iqs.pf.vo.WeekChartVO;

public class WeekBudgetServiceImpl implements WeekBudgetServiceIF {

	private WeekendDAO weekend_dao;
	private ProjectDAO project_dao;
	private WeekBudgetDAO w_dao;
	private TeamDAO t_dao;

	public void setWeekend_dao(WeekendDAO weekend_dao) {
		this.weekend_dao = weekend_dao;
	}
	public void setProject_dao(ProjectDAO project_dao) {
		this.project_dao = project_dao;
	}
	public void setW_dao(WeekBudgetDAO w_dao) {
		this.w_dao = w_dao;
	}
	public void setT_dao(TeamDAO t_dao) {
		this.t_dao = t_dao;
	}

	@Override
	public void weekbudgetInsert(List<BudgetVO> list) {
		String 	team_id_s1 = "1S", team_id_s2 = "2S", team_id_energy = "3E"
				, team_id_security = "4N", team_id_ds = "5D", team_id_comm="6C";
		
		WeekBudgetVO wb_s1 = new WeekBudgetVO(team_id_s1);
		WeekBudgetVO wb_s2 = new WeekBudgetVO(team_id_s2);
		WeekBudgetVO wb_e = new WeekBudgetVO(team_id_energy);
		WeekBudgetVO wb_n = new WeekBudgetVO(team_id_security);
		WeekBudgetVO wb_d = new WeekBudgetVO(team_id_ds);
		WeekBudgetVO wb_c = new WeekBudgetVO(team_id_comm);
		
		for (BudgetVO b : list) {
			if (b.getTeam_id().equals(team_id_s1)) {
				wb_s1 = CalcWeekBudget(wb_s1, b);
			} else  if (b.getTeam_id().equals(team_id_s2)) {
				wb_s2 = CalcWeekBudget(wb_s2, b);
			} else  if (b.getTeam_id().equals(team_id_energy)) {
				wb_e = CalcWeekBudget(wb_e, b);
			} else  if (b.getTeam_id().equals(team_id_security)) {
				wb_n = CalcWeekBudget(wb_n, b);
			} else  if (b.getTeam_id().equals(team_id_ds)) {
				wb_d = CalcWeekBudget(wb_d, b);
			} else  if (b.getTeam_id().equals(team_id_comm)){
				wb_c = CalcWeekBudget(wb_c, b);
			}
		}
		
		//2014.12.26 공통 외주비 setting!!
		wb_e = SetTeamComm(wb_e);
		wb_n = SetTeamComm(wb_n);
		wb_d = SetTeamComm(wb_d);
		
		
		weekend_dao.insertWeekBudget(wb_s1);
		weekend_dao.insertWeekBudget(wb_s2);
		weekend_dao.insertWeekBudget(wb_e);
		weekend_dao.insertWeekBudget(wb_n);
		weekend_dao.insertWeekBudget(wb_d);
		weekend_dao.insertWeekBudget(wb_c);
	}
	
	private WeekBudgetVO SetTeamComm(WeekBudgetVO vo) {
		List<TeamVO> t_list = t_dao.getTeamList();
		
		for (TeamVO t : t_list) {
			if(vo.getTeam_id().equals(t.getTeam_id())) {
				vo.setWb_sales_cost(vo.getWb_sales_cost() + t.getTeam_comm());
				vo.setWb_sal(vo.getWb_sal() + t.getTeam_comm());
				
				vo.setWb_netincome(vo.getWb_netincome() - t.getTeam_comm());
				vo.setWb_ebit(vo.getWb_ebit() - t.getTeam_comm());
			}
		}
		
		return vo;
	}
	
	private WeekBudgetVO CalcWeekBudget(WeekBudgetVO w, BudgetVO b) {
		w.setWb_contract(w.getWb_contract() + b.getBudget_contract_sales());
		w.setWb_income(w.getWb_income() + b.getPj_income());
		w.setWb_netincome(w.getWb_netincome() + b.getPj_net_income());
		w.setWb_ebit(w.getWb_ebit() + b.getEbit());
		w.setWb_sales_cost(w.getWb_sales_cost() + b.getBudget_sales());
		w.setWb_sal(w.getWb_sal() + b.getEmpl_cost_tot());
		w.setWb_product(w.getWb_product() + b.getBudget_product_cost());
		w.setWb_charge(w.getWb_charge() + b.getBudget_normal_cost());
		
		return w;
	}
	
	/* 추세분석 data insert!*/
	@Override
	public void weekChartInsert(List<BudgetVO> list) {
		String 	team_id_s1 = "1S", team_id_s2 = "2S", team_id_energy = "3E"
				, team_id_security = "4N", team_id_ds = "5D";
		String pj_prog_forward = "1이월", pj_prog_complete ="2완료";
		
		WeekChartVO wc_s1 = new WeekChartVO(team_id_s1);
		WeekChartVO wc_s2 = new WeekChartVO(team_id_s2);
		WeekChartVO wc_e = new WeekChartVO(team_id_energy);
		WeekChartVO wc_n = new WeekChartVO(team_id_security);
		WeekChartVO wc_d = new WeekChartVO(team_id_ds);
		
		for (BudgetVO b : list) {
			if (b.getPj_prog().equals(pj_prog_forward) || b.getPj_prog().equals(pj_prog_complete)) {
				if (b.getTeam_id().equals(team_id_s1)) {
					wc_s1 = CalcWeekBudget(wc_s1, b);
				} else  if (b.getTeam_id().equals(team_id_s2)) {
					wc_s2 = CalcWeekBudget(wc_s2, b);
				} else  if (b.getTeam_id().equals(team_id_energy)) {
					wc_e = CalcWeekBudget(wc_e, b);
				} else  if (b.getTeam_id().equals(team_id_security)) {
					wc_n = CalcWeekBudget(wc_n, b);
				} else  if (b.getTeam_id().equals(team_id_ds)) {
					wc_d = CalcWeekBudget(wc_d, b);
				} else  {
				}
			}
		}
		
		wc_e = SetTeamComm(wc_e);
		wc_n = SetTeamComm(wc_n);
		wc_d = SetTeamComm(wc_d);
		
		w_dao.insertWeekChart(wc_s1);
		w_dao.insertWeekChart(wc_s2);
		w_dao.insertWeekChart(wc_e);
		w_dao.insertWeekChart(wc_n);
		w_dao.insertWeekChart(wc_d);
		
		
	}
	
	private WeekChartVO SetTeamComm(WeekChartVO vo) {
		List<TeamVO> t_list = t_dao.getTeamList();
		
		for (TeamVO t : t_list) {
			if(vo.getTeam_id().equals(t.getTeam_id())) {
				vo.setWc_netincome(vo.getWc_netincome() - t.getTeam_comm());
				vo.setWc_ebit(vo.getWc_ebit() - t.getTeam_comm());
			}
		}
		return vo;
	}
	
	private WeekChartVO CalcWeekBudget(WeekChartVO w, BudgetVO b) {
		w.setWc_contract(w.getWc_contract() + b.getBudget_contract_sales());
		w.setWc_income(w.getWc_income() + b.getPj_income());
		w.setWc_netincome(w.getWc_netincome() + b.getPj_net_income());
		w.setWc_ebit(w.getWc_ebit() + b.getEbit());
		return w;
	}
	
}
