package com.sqisoft.iqs.pf.team.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sqisoft.iqs.hr.outsal.dao.OutSalHistoryDAO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;
import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.comm.CalcUtil;
import com.sqisoft.iqs.pf.schedule.dao.WeekBudgetDAO;
import com.sqisoft.iqs.pf.team.dao.TeamDAO;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.DistribVO;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;
import com.sqisoft.iqs.pf.vo.TeamVO;
import com.sqisoft.iqs.pf.vo.TotalVO;
import com.sqisoft.iqs.pf.vo.WeekChartVO;

public class TeamServiceImpl implements TeamServiceIF {

	private TeamDAO teamDao;
	private WeekBudgetDAO wb_dao;
	private OutSalHistoryDAO out_sal_dao;
	
	public void setTeamDao(TeamDAO teamDao) {
		this.teamDao = teamDao;
	}
	public void setWb_dao(WeekBudgetDAO wb_dao) {
		this.wb_dao = wb_dao;
	}
	public void setOut_sal_dao(OutSalHistoryDAO out_sal_dao) {
		this.out_sal_dao = out_sal_dao;
	}

	@Override
	public List<TeamVO> getTeamList() {
		return teamDao.getTeamList();
	}

	@Override
	public void teamInsert(TeamVO vo) {
		teamDao.teamInsert(vo);
	}

	@Override
	public TeamVO getTeam(String team_id) {
		TeamVO vo = teamDao.getTeam(team_id);
		return vo;
	}

	@Override
	public void teamUpdate(TeamVO vo) {
		teamDao.teamUpdate(vo);
	}
	
	
	/* 
	 * 배부금액 계산
	 * */
	@Override
	public DistribVO getDistrib() {
		int	di_net_incomde_s1 = 0, di_net_incomde_s1_b = 0, di_net_incomde_s2 = 0
			, di_net_incomde_s2_b = 0, di_net_incomde_energy = 0, di_net_incomde_energy_b = 0
			, di_net_incomde_security = 0, di_net_incomde_security_b = 0, di_net_incomde_ds = 0
			, di_net_incomde_ds_b = 0;
		
		String team_id_s1 = "1S", team_id_s2 = "2S", team_id_energy = "3E", team_id_security = "4N", team_id_ds = "5D", team_id_comm = "6C";
		String pj_prog_a = "4A급";
		String pj_prog_b = "5B급";
		OutSal_historyVO out_vo = null;
		
		DistribVO vo = new DistribVO();
		List<BudgetVO> list = teamDao.getBudgetList();
		List<PjHistoryVO> pc_list = teamDao.getPjHistoryList();
		// List<EmplVO> empl_list = dao.getEmplList();
		/*
		 * 0. 프로젝트별 외주비/전사 구하기 대기인건비 팀별로 합산 영업인건비 팀별로 합산 지원전사는 합계를 구한 뒤 배부기준으로
		 * 나눔
		 */

		/*
		 * 1. 순매출액 계산 순매출액 = 매출액(계약액 * 수행비율) - 외주비 - 상품비 1.1 A급인 경우 90%만 계산
		 */
		
		for (BudgetVO b : list) {
			// b급일때랑 a급일때랑 외주비 계산 값 다르므로
			if(!b.getPj_prog().equals(pj_prog_b)) {
				b.setBudget_outsource_cost(0);
			}
			
			for (PjHistoryVO p : pc_list) {
					if (b.getPj_id().equals(p.getPj_id())) {
						if (p.getDivision().equals("직원")) {
							b.setBudget_sqi_cost(b.getBudget_sqi_cost()
								+ (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost()  ));
							
						} else {
							
							if (!b.getPj_prog().equals(pj_prog_b)) {
								out_vo = out_sal_dao.getOutSalHistory(p);
								b.setBudget_outsource_cost(b.getBudget_outsource_cost()
										+ (int) (out_vo.getSalary() * out_vo.getMpm() * CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())));
								b.setPj_outsource_mm((CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())*out_vo.getMpm()) + b.getPj_outsource_mm());
							}
						
						}
					}
			}

			b.setPj_income((int) (b.getBudget_contract_sales()
					* (float) b.getPj_operate() / 100));
			b.setPj_net_income(b.getPj_income() - b.getBudget_outsource_cost()
					- b.getBudget_product_cost());
			
			if (b.getPj_prog().equals(pj_prog_b)) {
				b.setBudget_contract_sales(b.getBudget_contract_sales() / 2);
				b.setPj_income(b.getPj_income() / 2);
				b.setPj_net_income(b.getPj_net_income() / 2);
			} else if (b.getPj_prog().equals(pj_prog_a)) {
				b.setBudget_product_cost((int) (b.getBudget_product_cost() * 0.9));
				b.setBudget_contract_sales((int) (b.getBudget_contract_sales() * 0.9));
				b.setPj_income((int) (b.getPj_income() * 0.9));
				b.setBudget_outsource_cost((int)(b.getBudget_outsource_cost() * 0.9));
				b.setPj_net_income((int) ((b.getPj_income()
						- b.getBudget_outsource_cost() - b
						.getBudget_product_cost())));
			}
			

			if (b.getTeam_id().equals(team_id_s1)) {

				if (b.getPj_prog().equals(pj_prog_a)) {
					di_net_incomde_s1 += b.getPj_net_income();
					
					
				} else if (b.getPj_prog().equals(pj_prog_b)) {
					di_net_incomde_s1_b += b.getPj_net_income();
				} else {
					di_net_incomde_s1 += b.getPj_net_income();
				}

			} else if (b.getTeam_id().equals(team_id_s2)) {

				if (b.getPj_prog().equals(pj_prog_a)) {
					di_net_incomde_s2 += b.getPj_net_income();
				} else if (b.getPj_prog().equals(pj_prog_b)) {
					di_net_incomde_s2_b += b.getPj_net_income();
				} else {
					di_net_incomde_s2 += b.getPj_net_income();
				}

			} else if (b.getTeam_id().equals(team_id_energy)) {

				if (b.getPj_prog().equals(pj_prog_a)) {
					di_net_incomde_energy += b.getPj_net_income();
				} else if (b.getPj_prog().equals(pj_prog_b)) {
					di_net_incomde_energy_b += b.getPj_net_income();
				} else {
					di_net_incomde_energy += b.getPj_net_income();
				}

			} else if (b.getTeam_id().equals(team_id_security)) {

				if (b.getPj_prog().equals(pj_prog_a)) {
					di_net_incomde_security += b.getPj_net_income();
				} else if (b.getPj_prog().equals(pj_prog_b)) {
					di_net_incomde_security_b += b.getPj_net_income();
				} else {
					di_net_incomde_security += b.getPj_net_income();
				}

			} else if (b.getTeam_id().equals(team_id_ds)) {

				if (b.getPj_prog().equals(pj_prog_a)) {
					di_net_incomde_ds += b.getPj_net_income();
				} else if (b.getPj_prog().equals(pj_prog_b)) {
					di_net_incomde_ds_b += b.getPj_net_income();
				} else {
					di_net_incomde_ds += b.getPj_net_income();
				}

			} else if (!b.getTeam_id().equals(team_id_comm)) {
				
			}
		}
		
		/* 계산값 객체에 Setting!! */
		vo.setDi_net_incomde_s1(di_net_incomde_s1);
		vo.setDi_net_incomde_s1_b(di_net_incomde_s1_b);
		vo.setDi_net_incomde_s2(di_net_incomde_s2);
		vo.setDi_net_incomde_s2_b(di_net_incomde_s2_b);
		vo.setDi_net_incomde_security(di_net_incomde_security);
		vo.setDi_net_incomde_security_b(di_net_incomde_security_b);
		vo.setDi_net_incomde_energy(di_net_incomde_energy);
		vo.setDi_net_incomde_energy_b(di_net_incomde_energy_b);
		vo.setDi_net_incomde_ds(di_net_incomde_ds);
		vo.setDi_net_incomde_ds_b(di_net_incomde_ds_b);

		vo.setDi_net_incomde_tot(di_net_incomde_s1 + di_net_incomde_s2
				+ di_net_incomde_energy + di_net_incomde_security
				+ di_net_incomde_ds);
		vo.setDi_net_incomde_tot_b(di_net_incomde_s1_b + di_net_incomde_s2_b
				+ di_net_incomde_energy_b + di_net_incomde_security_b
				+ di_net_incomde_ds_b);

		/* 배부 비율 구하기 */
		int distrib_std = vo.getDi_net_incomde_tot()
				- vo.getDi_net_incomde_tot_b();

		vo.setDi_standard_s1((float) (di_net_incomde_s1 - di_net_incomde_s1_b)
				/ distrib_std);
		vo.setDi_standard_s2((float) (di_net_incomde_s2 - di_net_incomde_s2_b)
				/ distrib_std);
		vo.setDi_standard_energy((float) (di_net_incomde_energy - di_net_incomde_energy_b)
				/ distrib_std);
		vo.setDi_standard_security((float) (di_net_incomde_security - di_net_incomde_security_b)
				/ distrib_std);
		vo.setDi_standard_ds((float) (di_net_incomde_ds - di_net_incomde_ds_b)
				/ distrib_std);

		return vo;
	}

	@Override
	public void updateDistrib(DistribVO vo) {
		teamDao.updateDistrib(vo);

	}
	
	/*팀별 손익 정보 계산*/
	@Override
	public List<BudgetVO> getBudgetInfoList() {
		List<BudgetVO> budget_list = teamDao.getBudgetList(); // 프로젝트 기본 정보 List
		List<PjHistoryVO> dc_list = teamDao.getDistribCostList(); // 배부 정보 List from pj_history
		List<PjHistoryVO> pc_list = teamDao.getPjHistoryList();  //pj_직접, 외주비 계산을 위한 List from pj_history
		List<PjHistoryVO> wait_list = teamDao.getWaitingList(); //대기 정보 List from pj_history
		DistribVO distrib_vo = getDistrib();
		List<TeamVO> team_list = teamDao.getTeamList();
		
		String team_id_s1 = "1S", team_id_s2 = "2S", team_id_energy = "3E", team_id_security = "4N", team_id_ds = "5D", team_id_comm = "6C";
		String pj_prog_delay = "1이월";
		String pj_prog_a = "4A급";
		String pj_prog_b = "5B급";
		String pj_prog_c = "6C급";
		String sales_s1_flag = "영업S";
		String sales_s2_flag = "영업C";
		String sales_e_flag = "영업E";
		String sales_n_flag = "영업B";
		String sales_d_flag = "영업M";
		
		String common_e_flag = "공통/개발E";
		String common_n_flag = "공통/개발B";
		String common_d_flag = "공통/개발M";
		
		
		String wait_flag = "대기";
		
		
		float common_cost_ratio_s1 = 0, common_cost_ratio_s2 = 0, common_cost_ratio_energy = 0, common_cost_ratio_security = 0, common_cost_ratio_ds = 0, common_cost_ratio_comm = 0;

		// 1.팀별 영업비 합산
		int sales_cost_s1 = 0;
		int sales_cost_s2 = 0;
		int sales_cost_e = 0;
		int sales_cost_s = 0;
		int sales_cost_d = 0;

		int distrib_s1 = 0;
		int distrib_s2 = 0;
		int distrib_e = 0;
		int distrib_s = 0;
		int distrib_d = 0;
		int waiting_cost = 0;
		
		int common_cost = 0;
		
		int common_out_e =0;
		int common_out_n =0;
		int common_out_d =0;
		
		OutSal_historyVO out_vo = null;
		
		if(!wait_list.isEmpty()) {
			for(PjHistoryVO p : wait_list) {
				if (p.getPj_id().equals(wait_flag)) {
					//대기 인건비 총합 구하기
					if (!p.getTeam_id().equals(team_id_comm)) {
						waiting_cost += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost());	
					}
				}
			}																																																																																																																																																																																	
		} 
		
		for (PjHistoryVO p : dc_list) {
			if (p.getPj_id().equals(sales_s1_flag)) {
				//si1 영업인건비 총합
				sales_cost_s1 += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost()  );
			} else if (p.getPj_id().equals(sales_s2_flag)) {
				//si2 영업인건비 총합
				sales_cost_s2 += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
			} else if (p.getPj_id().equals(sales_e_flag)) {
				//energy 영업인건비 총합
				
				sales_cost_e += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
			} else if (p.getPj_id().equals(sales_n_flag)) {
				//보안 영업인건비 총합
				
				sales_cost_s += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
			} else if (p.getPj_id().equals(sales_d_flag)) {
				//ds 영업인건비 총합
				sales_cost_d += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
			} else if (p.getPj_id().equals(common_e_flag)) {
				//energy 공통인건비 총합
				if (p.getDivision().equals("직원")) {
					distrib_e += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
				} else {
					//공통 개발 외주 총합
					//팀 table 의 컬럼으로 관리
					out_vo = out_sal_dao.getOutSalHistory(p);
					common_out_e += (int) ((out_vo.getSalary() *out_vo.getMpm() * CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())));
				}
				
			} else if (p.getPj_id().equals(common_n_flag)) {
				//보안 공통인건비 총합
				if (p.getDivision().equals("직원")) {
				distrib_s += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
				} else {
					out_vo = out_sal_dao.getOutSalHistory(p);
					common_out_n += (int) ((out_vo.getSalary() *out_vo.getMpm() * CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())));
				}
			} else if (p.getPj_id().equals(common_d_flag)) {
				//ds 공통인건비 총합
				if (p.getDivision().equals("직원")) {
				distrib_d += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
				} else {
					out_vo = out_sal_dao.getOutSalHistory(p);
					common_out_d += (int) ((out_vo.getSalary() *out_vo.getMpm() * CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())));
				}
			} else if (p.getTeam_id().equals(team_id_comm) || p.getTeam_id().equals("ON")){
				//전사공통 총합
				if (!p.getDivision().equals("외주")) {
					//전사공통의 대기는 계산에서 제외(반일근무를 대기로 처리할 경우)
					if(!p.getPj_id().equals(wait_flag) && (p.getPj_id().equals("전사공통") || p.getPj_id().equals("사장실"))) {
						System.out.println("전사공통 check : " + p);
						common_cost += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost() );
					}
				} 
			} 
			
		}
		
		//팀 공통 인건비(공통 외주) update!
		teamDao.teamCommonUpdate(new TeamVO(team_id_energy, common_out_e));
		teamDao.teamCommonUpdate(new TeamVO(team_id_security, common_out_n));
		teamDao.teamCommonUpdate(new TeamVO(team_id_ds, common_out_d));
		
		
		//대기 인건비 si1/si2로 분배
		distrib_s1 = waiting_cost/2;
		distrib_s2 = waiting_cost/2;
		
		// 2014.12.13 기본경비 추가
		int normal_cost_tot = 0;
		
		// 2014.12.18 팀공통경비 추가
		int team_cost_s1 =0;
		int team_cost_s2 =0;
		int team_cost_e =0;
		int team_cost_n =0;
		int team_cost_d =0;
		
		
		// 1. 기본 경비율, 팀공통경비 가져오기
		// 경비 계산을 위한 data (기본경비율, 팀공통경비 등)
		
		//2015.01.20 팀 경비 계산방식 수정
		//기존 프로젝트 순매출기준 -> 변경 팀목표순매출기준
		
		int team_net_income_s=0;
		int team_net_income_c=0;
		int team_net_income_e=0;
		int team_net_income_n=0;
		int team_net_income_d=0;
		
		for (TeamVO t : team_list) {
			if (t.getTeam_id().equals(team_id_s1)) {
				
				common_cost_ratio_s1 = t.getTeam_perofcost() / 100;
				team_cost_s1 = t.getTeam_normal_cost();
				
				//팀별 목표 순매출액 계산 = 매출목표 - 예상 외주비 - 예상 상품비
				team_net_income_s = t.getTeam_income() - t.getTeam_outsource() - t.getTeam_product();
				
			} else if (t.getTeam_id().equals(team_id_s2)) {
				
				common_cost_ratio_s2 = t.getTeam_perofcost() / 100;
				team_cost_s2 = t.getTeam_normal_cost();
				
				team_net_income_c = t.getTeam_income() - t.getTeam_outsource() - t.getTeam_product();
				
			} else if (t.getTeam_id().equals(team_id_energy)) {
				
				common_cost_ratio_energy = t.getTeam_perofcost() / 100;
				team_cost_e = t.getTeam_normal_cost();
				
				team_net_income_e = t.getTeam_income() - t.getTeam_outsource() - t.getTeam_product();
				
			} else if (t.getTeam_id().equals(team_id_security)) {
				
				common_cost_ratio_security = t.getTeam_perofcost() / 100;
				team_cost_n = t.getTeam_normal_cost();
				
				team_net_income_n = t.getTeam_income() - t.getTeam_outsource() - t.getTeam_product();
				
			} else if (t.getTeam_id().equals(team_id_ds)) {
				
				common_cost_ratio_ds = t.getTeam_perofcost() / 100;
				team_cost_d = t.getTeam_normal_cost();
				
				team_net_income_d = t.getTeam_income() - t.getTeam_outsource() - t.getTeam_product();
				
			} else if (t.getTeam_id().equals(team_id_comm)) {
				
				common_cost_ratio_comm = t.getTeam_perofcost() / 100;
				normal_cost_tot = t.getTeam_normal_cost();
				
			} else if (!t.getTeam_id().equals("ON")
					|| !t.getTeam_id().equals("TT")) {
				System.out.println("Error : 팀 기본 경비율 team_id 오류");
			}
		}
		
		int team_net_income_tt = team_net_income_s + team_net_income_c + team_net_income_e + team_net_income_n + team_net_income_d;
		
		
		// 팀당 지원인건비 배부
		int empl_cost_s1 = (int) (common_cost * distrib_vo.getDi_standard_s1());
		int empl_cost_s2 = (int) (common_cost * distrib_vo.getDi_standard_s2());
		int empl_cost_energy = (int) (common_cost * distrib_vo
				.getDi_standard_energy());
		int empl_cost_security = (int) (common_cost * distrib_vo
				.getDi_standard_security());
		int empl_cost_ds = (int) (common_cost * distrib_vo.getDi_standard_ds());
		
//		// 팀당 기본경비 배부(기존방식, 팀별 순매출액 기준, 아마도 9월 이후에 다시 원래 방식대로 바뀔 듯 함)
//		int normal_cost_s1 = (int) (normal_cost_tot * distrib_vo
//				.getDi_standard_s1());
//		int normal_cost_s2 = (int) (normal_cost_tot * distrib_vo
//				.getDi_standard_s2());
//		int normal_cost_energy = (int) (normal_cost_tot * distrib_vo
//				.getDi_standard_energy());
//		int normal_cost_security = (int) (normal_cost_tot * distrib_vo
//				.getDi_standard_security());
//		int normal_cost_ds = (int) (normal_cost_tot * distrib_vo
//				.getDi_standard_ds());
		
		//2015.01.20 팀당 기본경비 배부 방식(팀당 목표순매출액 기준)
		
		int normal_cost_s1 = (int) (normal_cost_tot * ((float)team_net_income_s/(float)team_net_income_tt));
		int normal_cost_s2 = (int) (normal_cost_tot * ((float)team_net_income_c/(float)team_net_income_tt));
		int normal_cost_energy = (int) (normal_cost_tot * ((float)team_net_income_e/(float)team_net_income_tt));
		int normal_cost_security = (int) (normal_cost_tot * ((float)team_net_income_n/(float)team_net_income_tt));
		int normal_cost_ds = (int) (normal_cost_tot * ((float)team_net_income_d/(float)team_net_income_tt));
		
	
		
		for (BudgetVO b : budget_list) {
			//b급인 경우는 db의 예상 외주비를 가지고 순매출액을 계산
			//그 외의 경우는 실제 배치된 외주인력의 인건비를 통해서 계산
			//그렇기 때문에 b급을 제외한 프로젝트는 외주비를 0으로 default setting을 해줘야 함.
			if(!b.getPj_prog().equals(pj_prog_b)) {
				b.setBudget_outsource_cost(0);
			}
				

			///0.0 프로젝트별 pj직접/외주/sqi_mm/out_mm setting!!!

			for (PjHistoryVO p : pc_list) {
				//if (!p.getTeam_id().equals(team_id_comm)) {
				
					if (b.getPj_id().equals(p.getPj_id())) {
						if (p.getDivision().equals("직원")) {
							if (!p.getTeam_id().equals(team_id_comm)) {
								b.setBudget_sqi_cost(b.getBudget_sqi_cost()
										+ (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost()  ));
								b.setPj_sqi_mm(b.getPj_sqi_mm() + CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()));
							}
						} else {
							if (!b.getPj_prog().equals(pj_prog_b)) {
								out_vo = out_sal_dao.getOutSalHistory(p);
								//외주비 계산 =  외주 단가 *  Mpm * MM 
								b.setBudget_outsource_cost(b.getBudget_outsource_cost()
										+ (int) (out_vo.getSalary() *out_vo.getMpm() * CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())));
								b.setPj_outsource_mm((CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day())*out_vo.getMpm()) + b.getPj_outsource_mm());
								
								if(b.getPj_id().equals("POKS")) {
									System.out.println("외주비 확인 : " + out_vo);
									System.out.println(p);
									System.out.println(b);
									
								}
									
								
							}
						}
					}
			//	}
			}
			
			/*
			 * * 1. 순매출액 계산 순매출액 = 매출액(계약액 * 수행비율) - 외주비 - 상품비 
			 * 1.1 A급인 경우는 90%
			 * 1.2 B급인 경우는 50%
			 */
			/* 1. 매출액 계산 매출액 = 계약액 * 진행율 */

			
			b.setPj_income((int) (b.getBudget_contract_sales()
					* (float) b.getPj_operate() / 100));
			b.setPj_net_income(b.getPj_income() - b.getBudget_outsource_cost()
					- b.getBudget_product_cost());
			
			if (b.getPj_prog().equals(pj_prog_b)) {
				if (b.getPj_id().equals("DCIM2"))
					System.out.println("before : " + b);
				b.setBudget_contract_sales(b.getBudget_contract_sales() / 2);
				
				b.setPj_net_income((b.getPj_income() - b.getBudget_product_cost() - b.getBudget_outsource_cost()) / 2);
				
				b.setPj_income(b.getPj_income() / 2);
				if (b.getPj_id().equals("DCIM2"))
					System.out.println("after : " + b);
				
			} else if (b.getPj_prog().equals(pj_prog_a)) {
				b.setBudget_product_cost((int) (b.getBudget_product_cost() * 0.9));
				b.setBudget_contract_sales((int) (b.getBudget_contract_sales() * 0.9));
				b.setPj_income((int) (b.getPj_income() * 0.9));
				b.setBudget_outsource_cost((int)(b.getBudget_outsource_cost() * 0.9));   //A급의 경우 외주비 90% 반영
				
				b.setPj_net_income((int) ((b.getPj_income()
						- b.getBudget_outsource_cost() - b
						.getBudget_product_cost())));
				
			}

			/*
			 * 2. 팀별 프로젝트를 배부기준으로 대기/영업/지원 인건비 구하기!! 2.1 경비 : ( PJ매출액*팀의 변동율 ) +
			 * ( 팀에 배부된 고정경비 계 * PJ의 순매출액 비중 )
			 */
			
			// 이월, 완료, 대기, A급인 경우의 계산
			if (!b.getPj_prog().equals(pj_prog_b)) {

				if (b.getTeam_id().equals(team_id_s1)) {
					/* 배부기준 : 프로젝트별 순매출액 / 팀별 순매출액 */
					float distrib_std_s1 = (float) b.getPj_net_income()
							/ (distrib_vo.getDi_net_incomde_s1());
			
					b.setEmpl_cost_sales((int) (sales_cost_s1 * distrib_std_s1));
					b.setEmpl_cost_wait((int) (distrib_s1 * distrib_std_s1));
					b.setEmpl_cost_comm((int) (empl_cost_s1 * distrib_std_s1));
					
					// 2.2 경비 계산 : (프로젝트별 매출액 * 기본경비율) + (팀공통경비 + 전사경비 팀 배부금액) * 배부기준
					b.setBudget_normal_cost((int) ((b.getPj_income() * common_cost_ratio_s1)
							+ b.getPj_extra_cost() + ((normal_cost_s1+ team_cost_s1) * distrib_std_s1)));
				
				} else if (b.getTeam_id().equals(team_id_s2)) {
					float distrib_std_s2 = (float) b.getPj_net_income()
							/ (distrib_vo.getDi_net_incomde_s2());
					
					b.setEmpl_cost_sales((int) (sales_cost_s2 * distrib_std_s2));
					b.setEmpl_cost_wait((int) (distrib_s2 * distrib_std_s2));
					b.setEmpl_cost_comm((int) (empl_cost_s2 * distrib_std_s2));

					b.setBudget_normal_cost((int) ((b.getPj_income() * common_cost_ratio_s2)
							+ b.getPj_extra_cost() + ((normal_cost_s2 + team_cost_s2) * distrib_std_s2)));
				

				} else if (b.getTeam_id().equals(team_id_energy)) {
					float distrib_std_energy = (float) b.getPj_net_income()
							/ (distrib_vo.getDi_net_incomde_energy());
		
					b.setEmpl_cost_sales((int) (sales_cost_e * distrib_std_energy));
					b.setEmpl_cost_wait((int) (distrib_e * distrib_std_energy));
					b.setEmpl_cost_comm((int) (empl_cost_energy * distrib_std_energy));

					b.setBudget_normal_cost((int) ((b.getPj_income() * common_cost_ratio_energy)
							+ b.getPj_extra_cost() + ((normal_cost_energy + team_cost_e) * distrib_std_energy)));
					
				

				} else if (b.getTeam_id().equals(team_id_security)) {
					float distrib_std_security = (float) b.getPj_net_income()
							/ (distrib_vo.getDi_net_incomde_security());
		
					b.setEmpl_cost_sales((int) (sales_cost_s * distrib_std_security));
					b.setEmpl_cost_wait((int) (distrib_s * distrib_std_security));
					b.setEmpl_cost_comm((int) (empl_cost_security * distrib_std_security));

					b.setBudget_normal_cost((int) ((b.getPj_income() * common_cost_ratio_security)
							+ b.getPj_extra_cost() + ((normal_cost_security + team_cost_n) * distrib_std_security)));
					
					

				} else if (b.getTeam_id().equals(team_id_ds)) {
					float distrib_std_ds = (float) b.getPj_net_income()
							/ (distrib_vo.getDi_net_incomde_ds());
		
					b.setEmpl_cost_sales((int) (sales_cost_d * distrib_std_ds));
					b.setEmpl_cost_wait((int) (distrib_d * distrib_std_ds));
					b.setEmpl_cost_comm((int) (empl_cost_ds * distrib_std_ds));

					b.setBudget_normal_cost((int) ((b.getPj_income() * common_cost_ratio_ds)
							+ b.getPj_extra_cost() + ((normal_cost_ds + team_cost_d) * distrib_std_ds)));
	
				} else if (b.getTeam_id().equals(team_id_comm)) {
					b.setBudget_normal_cost((int) (b.getPj_income() * common_cost_ratio_comm)
							+ b.getPj_extra_cost());

				} else {
					System.out.println("ERROR : getBudgetInfoList() : team_id matching error!!");
				}

				/* 3. 인건비 합계/매출원가/영업 이익 Setting */
				/* 3.1 인건비 합계 = pj직접, 대기, 영업, 지원 */
				/* 3.2 매출원가 = 인건비 합계 + 상품비 + 경비 */
				/* 3.3. 영업이익 = 매출액 - 매출원가 */

				b.setEmpl_cost_tot(b.getBudget_sqi_cost()
						+ b.getBudget_outsource_cost() + b.getEmpl_cost_comm()
						+ b.getEmpl_cost_wait() + b.getEmpl_cost_sales());
				b.setBudget_sales(b.getEmpl_cost_tot()
						+ b.getBudget_product_cost()
						+ b.getBudget_normal_cost());
				b.setEbit(b.getPj_income() - b.getBudget_sales());

				
				// 2014.12.03 이월인 경우 계약을 0으로 setting!!
				if (b.getPj_prog().equals(pj_prog_delay) || b.getPj_prog().equals(pj_prog_c) || b.getTeam_id().equals(team_id_comm)) {
					b.setBudget_contract_sales(0);
				}
			} else {
				// B급인 경우
				// 영업이익 = 매출액 * 0.035 * 계약기대치
				// 매출원가 = 매출액 - 영업이익

				double ebit_ratio_b = 0.035;
				
				b.setEbit((int) (b.getPj_income() * ebit_ratio_b * 0.5));
				b.setBudget_sales(b.getPj_income() - b.getEbit());
				b.setBudget_outsource_cost(0);   // B급경우 외주비 0으로 세팅(반영x)
				b.setBudget_product_cost(0);     // B급경우 상품비 0으로 세팅(반영x)

			}
			

		}
		
	
		return budget_list;
	}

	@Override
	public List<BudgetVO> getTeamBudgetInfoList(String team_id) {
		List<BudgetVO> list = getBudgetInfoList();
		List<BudgetVO> ret_list = new ArrayList<BudgetVO>();

		for (BudgetVO v : list) {
			if (v.getTeam_id().equals(team_id)) {
				v.setPj_prog(v.getPj_prog().substring(1));
				ret_list.add(v);
			}
		}
		return ret_list;
	}

	@Override
	public TotalVO getTotal() {
		List<BudgetVO> b_list = getBudgetInfoList();
		String team_id_s1 = "1S", team_id_s2 = "2S", team_id_energy = "3E", team_id_security = "4N", team_id_ds = "5D", team_id_comm = "6C";
		List<TeamVO> t_list = teamDao.getTeamList();
		TotalVO vo = new TotalVO();
		int sum_contract_cost = 0;
		int sum_income = 0;
		int sum_net_income = 0;
		int sum_ebit = 0;
		int sum_sales_cost = 0;
		int sum_empl_cost_tot = 0;
		int sum_empl_cost_sqi = 0;
		int sum_empl_cost_wait = 0;
		int sum_empl_cost_sales = 0;
		int sum_empl_cost_comm = 0;
		int sum_empl_cost_outsource = 0;
		int sum_product_cost = 0;
		int sum_normal_cost = 0;

		// 팀별 합계 금액 setting
		for (BudgetVO b : b_list) {
			if (b.getTeam_id().equals(team_id_s1)) {
				vo.setS1_contract_cost(vo.getS1_contract_cost()
						+ b.getBudget_contract_sales());
				vo.setS1_income(vo.getS1_income() + b.getPj_income());
				vo.setS1_net_income(vo.getS1_net_income()
						+ b.getPj_net_income());
				vo.setS1_ebit(vo.getS1_ebit() + b.getEbit());
				vo.setS1_sales_cost(vo.getS1_sales_cost() + b.getBudget_sales());
				vo.setS1_empl_cost_tot(vo.getS1_empl_cost_tot()
						+ b.getEmpl_cost_tot());
				vo.setS1_empl_cost_sqi(vo.getS1_empl_cost_sqi()
						+ b.getBudget_sqi_cost());
				vo.setS1_empl_cost_wait(vo.getS1_empl_cost_wait()
						+ b.getEmpl_cost_wait());
				vo.setS1_empl_cost_sales(vo.getS1_empl_cost_sales()
						+ b.getEmpl_cost_sales());
				vo.setS1_empl_cost_comm(vo.getS1_empl_cost_comm()
						+ b.getEmpl_cost_comm());
				vo.setS1_product_cost(vo.getS1_product_cost()
						+ b.getBudget_product_cost());
				vo.setS1_normal_cost(vo.getS1_normal_cost()
						+ b.getBudget_normal_cost());
				vo.setS1_empl_cost_outsource(vo.getS1_empl_cost_outsource()
						+ b.getBudget_outsource_cost());

			} else if (b.getTeam_id().equals(team_id_s2)) {
				vo.setS2_contract_cost(vo.getS2_contract_cost()
						+ b.getBudget_contract_sales());
				vo.setS2_income(vo.getS2_income() + b.getPj_income());
				vo.setS2_net_income(vo.getS2_net_income()
						+ b.getPj_net_income());
				vo.setS2_ebit(vo.getS2_ebit() + b.getEbit());
				vo.setS2_sales_cost(vo.getS2_sales_cost() + b.getBudget_sales());
				vo.setS2_empl_cost_tot(vo.getS2_empl_cost_tot()
						+ b.getEmpl_cost_tot());
				vo.setS2_empl_cost_sqi(vo.getS2_empl_cost_sqi()
						+ b.getBudget_sqi_cost());
				vo.setS2_empl_cost_wait(vo.getS2_empl_cost_wait()
						+ b.getEmpl_cost_wait());
				vo.setS2_empl_cost_sales(vo.getS2_empl_cost_sales()
						+ b.getEmpl_cost_sales());
				vo.setS2_empl_cost_comm(vo.getS2_empl_cost_comm()
						+ b.getEmpl_cost_comm());
				vo.setS2_product_cost(vo.getS2_product_cost()
						+ b.getBudget_product_cost());
				vo.setS2_normal_cost(vo.getS2_normal_cost()
						+ b.getBudget_normal_cost());
				vo.setS2_empl_cost_outsource(vo.getS2_empl_cost_outsource()
						+ b.getBudget_outsource_cost());

			} else if (b.getTeam_id().equals(team_id_energy)) {
				vo.setE_contract_cost(vo.getE_contract_cost()
						+ b.getBudget_contract_sales());
				vo.setE_income(vo.getE_income() + b.getPj_income());
				vo.setE_net_income(vo.getE_net_income() + b.getPj_net_income());
				vo.setE_ebit(vo.getE_ebit() + b.getEbit());
				vo.setE_sales_cost(vo.getE_sales_cost() + b.getBudget_sales());
				vo.setE_empl_cost_tot(vo.getE_empl_cost_tot()
						+ b.getEmpl_cost_tot());
				vo.setE_empl_cost_sqi(vo.getE_empl_cost_sqi()
						+ b.getBudget_sqi_cost());
				vo.setE_empl_cost_wait(vo.getE_empl_cost_wait()
						+ b.getEmpl_cost_wait());
				vo.setE_empl_cost_sales(vo.getE_empl_cost_sales()
						+ b.getEmpl_cost_sales());
				vo.setE_empl_cost_comm(vo.getE_empl_cost_comm()
						+ b.getEmpl_cost_comm());
				vo.setE_product_cost(vo.getE_product_cost()
						+ b.getBudget_product_cost());
				vo.setE_normal_cost(vo.getE_normal_cost()
						+ b.getBudget_normal_cost());
				vo.setE_empl_cost_outsource(vo.getE_empl_cost_outsource()
						+ b.getBudget_outsource_cost());
			} else if (b.getTeam_id().equals(team_id_security)) {
				vo.setN_contract_cost(vo.getN_contract_cost()
						+ b.getBudget_contract_sales());
				vo.setN_income(vo.getN_income() + b.getPj_income());
				vo.setN_net_income(vo.getN_net_income() + b.getPj_net_income());
				vo.setN_ebit(vo.getN_ebit() + b.getEbit());
				vo.setN_sales_cost(vo.getN_sales_cost() + b.getBudget_sales());
				vo.setN_empl_cost_tot(vo.getN_empl_cost_tot()
						+ b.getEmpl_cost_tot());
				vo.setN_empl_cost_sqi(vo.getN_empl_cost_sqi()
						+ b.getBudget_sqi_cost());
				vo.setN_empl_cost_wait(vo.getN_empl_cost_wait()
						+ b.getEmpl_cost_wait());
				vo.setN_empl_cost_sales(vo.getN_empl_cost_sales()
						+ b.getEmpl_cost_sales());
				vo.setN_empl_cost_comm(vo.getN_empl_cost_comm()
						+ b.getEmpl_cost_comm());
				vo.setN_product_cost(vo.getN_product_cost()
						+ b.getBudget_product_cost());
				vo.setN_normal_cost(vo.getN_normal_cost()
						+ b.getBudget_normal_cost());
				vo.setN_empl_cost_outsource(vo.getN_empl_cost_outsource()
						+ b.getBudget_outsource_cost());

			} else if (b.getTeam_id().equals(team_id_ds)) {
				vo.setD_contract_cost(vo.getD_contract_cost()
						+ b.getBudget_contract_sales());
				vo.setD_income(vo.getD_income() + b.getPj_income());
				vo.setD_net_income(vo.getD_net_income() + b.getPj_net_income());
				vo.setD_ebit(vo.getD_ebit() + b.getEbit());
				vo.setD_sales_cost(vo.getD_sales_cost() + b.getBudget_sales());
				vo.setD_empl_cost_tot(vo.getD_empl_cost_tot()
						+ b.getEmpl_cost_tot());
				vo.setD_empl_cost_sqi(vo.getD_empl_cost_sqi()
						+ b.getBudget_sqi_cost());
				vo.setD_empl_cost_wait(vo.getD_empl_cost_wait()
						+ b.getEmpl_cost_wait());
				vo.setD_empl_cost_sales(vo.getD_empl_cost_sales()
						+ b.getEmpl_cost_sales());
				vo.setD_empl_cost_comm(vo.getD_empl_cost_comm()
						+ b.getEmpl_cost_comm());
				vo.setD_product_cost(vo.getD_product_cost()
						+ b.getBudget_product_cost());
				vo.setD_normal_cost(vo.getD_normal_cost()
						+ b.getBudget_normal_cost());
				vo.setD_empl_cost_outsource(vo.getD_empl_cost_outsource()
						+ b.getBudget_outsource_cost());
			} else if (b.getTeam_id().equals(team_id_comm)) {
				vo.setC_contract_cost(vo.getC_contract_cost()
						+ b.getBudget_contract_sales());
				vo.setC_income(vo.getC_income() + b.getPj_income());
				vo.setC_net_income(vo.getC_net_income() + b.getPj_net_income());
				vo.setC_ebit(vo.getC_ebit() + b.getEbit());
				vo.setC_sales_cost(vo.getC_sales_cost() + b.getBudget_sales());
				vo.setC_empl_cost_tot(vo.getC_empl_cost_tot()
						+ b.getEmpl_cost_tot());
				vo.setC_empl_cost_sqi(vo.getC_empl_cost_sqi()
						+ b.getBudget_sqi_cost());
				vo.setC_empl_cost_wait(vo.getC_empl_cost_wait()
						+ b.getEmpl_cost_wait());
				vo.setC_empl_cost_sales(vo.getC_empl_cost_sales()
						+ b.getEmpl_cost_sales());
				vo.setC_empl_cost_comm(vo.getC_empl_cost_comm()
						+ b.getEmpl_cost_comm());
				vo.setC_product_cost(vo.getC_product_cost()
						+ b.getBudget_product_cost());
				vo.setC_normal_cost(vo.getC_normal_cost()
						+ b.getBudget_normal_cost());
				vo.setC_empl_cost_outsource(vo.getC_empl_cost_outsource()
						+ b.getBudget_outsource_cost());
			} else {
				System.out.println("Error : getTotal : team_id 에러");
			}
			sum_contract_cost += b.getBudget_contract_sales();
			sum_income += b.getPj_income();
			sum_net_income += b.getPj_net_income();
			sum_ebit += b.getEbit();
			sum_sales_cost += b.getBudget_sales();
			sum_empl_cost_tot += b.getEmpl_cost_tot();
			sum_empl_cost_sqi += b.getBudget_sqi_cost();
			sum_empl_cost_wait += b.getEmpl_cost_wait();
			sum_empl_cost_sales += b.getEmpl_cost_sales();
			sum_empl_cost_comm += b.getEmpl_cost_comm();
			sum_empl_cost_outsource += b.getBudget_outsource_cost();
			sum_product_cost += b.getBudget_product_cost();
			sum_normal_cost += b.getBudget_normal_cost();
		}
		// 팀별 목표금액 setting
		TeamVO t_vo = new TeamVO();
		for (TeamVO t : t_list) {

			// 팀 순매출액, 매출원가, 순매출 BEP 계산, 영업이익
			t.setTeam_net_income(t.getTeam_income() - t.getTeam_product()
					- t.getTeam_outsource());
			t.setTeam_sales_cost(t.getTeam_income() - t.getTeam_profit_loss());
			t.setTeam_net_income_bep(t.getTeam_sales_cost()
					- t.getTeam_product() - t.getTeam_outsource());
			t.setTeam_ebit(t.getTeam_income() - t.getTeam_sales_cost());

			if (t.getTeam_id().equals(team_id_s1)) {
				/* 팀 공통외주비 계산 */
				/* 팀 외주비 합계/팀 매출원가/팀 인건비 합계 합산 */
				/* 팀 영업이익/팀 순매출 차감 */
				vo.setS1_empl_cost_outsource(vo.getS1_empl_cost_outsource()
						+ t.getTeam_comm());
				vo.setS1_sales_cost(vo.getS1_sales_cost() + t.getTeam_comm());
				vo.setS1_empl_cost_tot(vo.getS1_empl_cost_tot()
						+ t.getTeam_comm());

				vo.setS1_ebit(vo.getS1_ebit() - t.getTeam_comm());
				vo.setS1_net_income(vo.getS1_net_income() - t.getTeam_comm());

				vo.setS1_team_vo(t);
			} else if (t.getTeam_id().equals(team_id_s2)) {
				vo.setS2_empl_cost_outsource(vo.getS2_empl_cost_outsource()
						+ t.getTeam_comm());
				vo.setS2_sales_cost(vo.getS2_sales_cost() + t.getTeam_comm());
				vo.setS2_empl_cost_tot(vo.getS2_empl_cost_tot()
						+ t.getTeam_comm());

				vo.setS2_ebit(vo.getS2_ebit() - t.getTeam_comm());
				vo.setS2_net_income(vo.getS2_net_income() - t.getTeam_comm());

				vo.setS2_team_vo(t);
			} else if (t.getTeam_id().equals(team_id_energy)) {
				vo.setE_empl_cost_outsource(vo.getE_empl_cost_outsource()
						+ t.getTeam_comm());
				vo.setE_sales_cost(vo.getE_sales_cost() + t.getTeam_comm());
				vo.setE_empl_cost_tot(vo.getE_empl_cost_tot()
						+ t.getTeam_comm());

				vo.setE_ebit(vo.getE_ebit() - t.getTeam_comm());
				vo.setE_net_income(vo.getE_net_income() - t.getTeam_comm());

				vo.setE_team_vo(t);
			} else if (t.getTeam_id().equals(team_id_security)) {
				vo.setN_empl_cost_outsource(vo.getN_empl_cost_outsource()
						+ t.getTeam_comm());
				vo.setN_sales_cost(vo.getN_sales_cost() + t.getTeam_comm());
				vo.setN_empl_cost_tot(vo.getN_empl_cost_tot()
						+ t.getTeam_comm());

				vo.setN_ebit(vo.getN_ebit() - t.getTeam_comm());
				vo.setN_net_income(vo.getN_net_income() - t.getTeam_comm());

				vo.setN_team_vo(t);
			} else if (t.getTeam_id().equals(team_id_ds)) {
				vo.setD_empl_cost_outsource(vo.getD_empl_cost_outsource()
						+ t.getTeam_comm());
				vo.setD_sales_cost(vo.getD_sales_cost() + t.getTeam_comm());
				vo.setD_empl_cost_tot(vo.getD_empl_cost_tot()
						+ t.getTeam_comm());
				vo.setD_ebit(vo.getD_ebit() - t.getTeam_comm());
				vo.setD_net_income(vo.getD_net_income() - t.getTeam_comm());

				vo.setD_team_vo(t);
			} else {
				System.out.println("Error : getTotal : team_id 에러");
			}
			t_vo.setTeam_contract(t_vo.getTeam_contract()
					+ t.getTeam_contract());
			t_vo.setTeam_sales_cost(t_vo.getTeam_sales_cost()
					+ t.getTeam_sales_cost());
			t_vo.setTeam_income(t_vo.getTeam_income() + t.getTeam_income());
			t_vo.setTeam_product(t_vo.getTeam_product() + t.getTeam_product());
			t_vo.setTeam_outsource(t_vo.getTeam_outsource()
					+ t.getTeam_outsource());
			t_vo.setTeam_profit_loss(t_vo.getTeam_profit_loss()
					+ t.getTeam_profit_loss());
			t_vo.setTeam_ebit(t_vo.getTeam_ebit() + t.getTeam_ebit());
			t_vo.setTeam_net_income(t_vo.getTeam_net_income()
					+ t.getTeam_net_income());

			if (!t.getTeam_id().equals(team_id_comm))
				t_vo.setTeam_net_income_bep(t_vo.getTeam_net_income_bep()
						+ t.getTeam_net_income_bep());

			// 팀 공통 외주비를 인건비 합계/매출원가 합계에 합산
			sum_empl_cost_tot += t.getTeam_comm();
			sum_sales_cost += t.getTeam_comm();
			sum_empl_cost_outsource += t.getTeam_comm();
			
			
			// 팀 공통 외주비를 영억이익 합계/순매출 합계에서 차감
			sum_ebit -= t.getTeam_comm();
			sum_net_income -= t.getTeam_comm();
		}

		// 총 합계 금액 setting
		vo.setSum_contract_cost(sum_contract_cost);
		vo.setSum_income(sum_income);
		vo.setSum_net_income(sum_net_income);
		vo.setSum_ebit(sum_ebit);
		vo.setSum_sales_cost(sum_sales_cost);
		vo.setSum_empl_cost_tot(sum_empl_cost_tot);

		// 직접개발 = 공통/대기 + pj 직접
		vo.setSum_empl_cost_sqi(sum_empl_cost_sqi + sum_empl_cost_wait);

		vo.setSum_empl_cost_sales(sum_empl_cost_sales);
		vo.setSum_empl_cost_comm(sum_empl_cost_comm);
		vo.setSum_empl_cost_outsource(sum_empl_cost_outsource);
		vo.setSum_product_cost(sum_product_cost);
		vo.setSum_normal_cost(sum_normal_cost);

		vo.setSum_team_vo(t_vo);
		
		/*2015.01.05 미배치 인건비 추가
		 * 참고사항 값 setting
		 * */
		List<PjHistoryVO> np_list = teamDao.getNoPlaceList();
		int no_place_cost =0;
		
		for(PjHistoryVO p : np_list) {
			no_place_cost += (int) (CalcUtil.getManMonth(p.getPj_start_day(), p.getPj_end_day()) * p.getMonth_unit_cost());	
		}
		
		vo.setNo_place_cost(no_place_cost);

		return vo;
	}

	@Override
	public BudgetVO getBudgetCost(String pj_id) {

		return teamDao.getBudgetCost(pj_id);
	}

	@Override
	public void updateBudgetCost(BudgetVO vo) {

		teamDao.updateBudgetCost(vo);

	}

	@Override
	public TeamVO getTeamForChart(String team_id) {
		List<TeamVO> list = teamDao.getTeamList();
		TeamVO ret_vo = new TeamVO();
		TeamVO sum_vo = new TeamVO();
		String team_id_all = "all";
		for (TeamVO t : list) {
			// 팀 순매출액, 매출원가, 순매출 BEP 계산, 영업이익
			t.setTeam_net_income(t.getTeam_income() - t.getTeam_product()
					- t.getTeam_outsource());
			t.setTeam_sales_cost(t.getTeam_income() - t.getTeam_profit_loss());
			t.setTeam_net_income_bep(t.getTeam_sales_cost()
					- t.getTeam_product() - t.getTeam_outsource());
			t.setTeam_ebit(t.getTeam_income() - t.getTeam_sales_cost());

			// t.setTeam_ebit(team_ebit);
			if (team_id.equals(team_id_all)) {
				// 합계 구하기
				sum_vo.setTeam_contract(sum_vo.getTeam_contract()
						+ t.getTeam_contract());
				sum_vo.setTeam_sales_cost(sum_vo.getTeam_sales_cost()
						+ t.getTeam_sales_cost());
				sum_vo.setTeam_income(sum_vo.getTeam_income()
						+ t.getTeam_income());
				sum_vo.setTeam_product(sum_vo.getTeam_product()
						+ t.getTeam_product());
				sum_vo.setTeam_outsource(sum_vo.getTeam_outsource()
						+ t.getTeam_outsource());
				sum_vo.setTeam_profit_loss(sum_vo.getTeam_profit_loss()
						+ t.getTeam_profit_loss());
				sum_vo.setTeam_ebit(sum_vo.getTeam_ebit() + t.getTeam_ebit());
				sum_vo.setTeam_net_income(sum_vo.getTeam_net_income()
						+ t.getTeam_net_income());
				sum_vo.setTeam_net_income_bep(sum_vo.getTeam_net_income_bep()
						+ t.getTeam_net_income_bep());

			} else if (t.getTeam_id().equals(team_id)) {
				ret_vo = t;
				break;
			} else if (t.getTeam_id().equals(team_id)) {
				ret_vo = t;
				break;
			} else if (t.getTeam_id().equals(team_id)) {
				ret_vo = t;
				break;
			} else if (t.getTeam_id().equals(team_id)) {
				ret_vo = t;
				break;
			} else if (t.getTeam_id().equals(team_id)) {
				ret_vo = t;
				break;
			}
		}

		if (team_id.equals(team_id_all))
			ret_vo = sum_vo;

		return ret_vo;
	}

	@Override
	public List<WeekChartVO> getWeekChartList(String team_id) {

		List<WeekChartVO> ret_list = null;
		String team_id_all = "all";
		if (team_id.equals(team_id_all)) {
			ret_list = wb_dao.getWeekChartListTot();
		} else {
			List<WeekChartVO> list = wb_dao.getWeekChartList();
			ret_list = new ArrayList<WeekChartVO>();
			for (WeekChartVO w : list) {
				if (w.getTeam_id().equals(team_id)) {
					ret_list.add(w);
				}
			}
		}

		return ret_list;
	}

	@Override
	public int teamExist(String team_id) {
		return teamDao.teamExist(team_id);
	}

	@Override
	public void teamDelete(String team_id) {
		teamDao.teamDelete(team_id);
	}
	@Override
	public List<PjHistoryVO> salSearch(PjpostingVO vo){
		return teamDao.salSearch(vo);
		
	}

/*	@Override
	public void insertPjHistory(PjHistoryVO vo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_db = null;
		Date date_in = null;
		 1. input date name에 대한 pj_history의 대기 정보 삭제
		dao.deletePjHistoryWaiting(vo.getName());
		 2. pj_hitory에 input data 적용
		 2.0 input name, pj_id 관련 db data get!
		PjHistoryVO ret_vo = dao.getPjHistory(vo);
		
		 2.1 data가 null 이면 input data insert!
		System.out.println(ret_vo+"/"+vo);
		if (ret_vo == null) {
			System.out.println("null insert check : " + vo);
			dao.insertPjHistory(vo);
			
		} else {
			 2.2 data가 존재하면 db data의 pj_end_day와 input data의 pj_start_day 비교
			 * test 요망
			try {
				date_in = sdf.parse(vo.getPj_start_day());
				date_db = sdf.parse(ret_vo.getPj_end_day());
				
				if (date_db.after(date_in)) {
					System.out.println("update check : " + vo);
					 2.2.1 db data의 pj_end_day의 값이 더 작으면 update!!
					dao.updatePjHistory(vo);
				} else {
					 2.2.2 input data의 pj_start_day 가 더 크면 insert!!	
					System.out.println("not null insert check : " + vo);
					dao.insertPjHistory(vo);
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
			
		}
		
	}*/

}
	