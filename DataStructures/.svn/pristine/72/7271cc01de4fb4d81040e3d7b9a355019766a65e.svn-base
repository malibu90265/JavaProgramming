package com.sqisoft.iqs.pf.schedule.service.impl;

import java.util.List;

import com.sqisoft.iqs.pf.project.dao.ProjectDAO;
import com.sqisoft.iqs.pf.schedule.dao.WeekendDAO;
import com.sqisoft.iqs.pf.schedule.service.WeekendServiceIF;
import com.sqisoft.iqs.pf.team.dao.TeamDAO;
import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.CompareVO;
import com.sqisoft.iqs.pf.vo.ProjectVO;
import com.sqisoft.iqs.pf.vo.WeekBudgetVO;
import com.sqisoft.iqs.pf.vo.WeekendVO;

public class WeekendServiceImpl implements WeekendServiceIF {

	private WeekendDAO weekendDao;
	private ProjectDAO project_dao;
	private TeamDAO team_dao;
	
	public void setWeekendDao(WeekendDAO weekendDao) {
		this.weekendDao = weekendDao;
	}
	public void setProject_dao(ProjectDAO project_dao) {
		this.project_dao = project_dao;
	}
	public void setTeam_dao(TeamDAO team_dao) {
		this.team_dao = team_dao;
	}
	
	public void insertProject(	String team_id, String pj_id, int budget_contract_sales
								,int pj_operate, String pj_prog, int budget_product_cost){
		//계약액은 계약액*상태
		//매출은 계약액*수행비율
		int contract=budget_contract_sales;
		int income;
		int netincome;
		int ebit;
		
		if(pj_prog.equals("4A급")){
			contract=(contract/10)*9;
		}
		else if(pj_prog.equals("5B급")){
			contract=(contract/2);
		}
		else if(pj_prog.equals("6C급")|| pj_prog.equals("7종결")){
			contract=0;
		}
		
		income=(contract*pj_operate)/100;
		netincome=income-budget_product_cost;
		ebit=netincome;
		WeekendVO vo=new WeekendVO(1,pj_id,team_id,null,"신규",contract,income,netincome,ebit,0);
		if(contract>1000)
			weekendDao.insertLog(vo);
	}
	
	public void projectDelete(String pj_id){
		ProjectVO vo=project_dao.getProject(pj_id);
		int contract=vo.getBudget_contract_sales();
		int income;
		int netincome;
		int ebit;
		
		if(vo.getPj_prog().equals("4A급")){
			contract=(contract/10)*9;
		}
		else if(vo.getPj_prog().equals("5B급")){
			contract=(contract/2);
		}
		else if(vo.getPj_prog().equals("6C급")|| vo.getPj_prog().equals("7종결")){
			contract=0;
		}
		
		income=(contract*vo.getPj_operate())/100;
		netincome=income-vo.getBudget_product_cost();
		ebit=netincome;
		WeekendVO result=new WeekendVO(1,vo.getPj_id(),vo.getTeam_id(),"삭제",null,-contract,-income,-netincome,-ebit,0);	
		
		if(contract>1000)
			weekendDao.insertLog(result);
	}
	
	public void updateProject(	String team_id, String pj_id, int budget_contract_sales
								, int pj_operate, String pj_prog, int budget_product_cost){
		ProjectVO vo=project_dao.getProject(pj_id);
		int pre_contract=budget_contract_sales;
		int post_contract=vo.getBudget_contract_sales();
		int contract;
		int income;
		int netincome;
		int ebit;
		int product=0;
		int flag=0;
		String post="",pre="";
		//변경사항 확인
		if(Math.abs(pre_contract-post_contract)>1000){
			flag=1;
			pre="계약액("+post_contract+")";
			post="계약액("+pre_contract+")";
			//계산하는 로직
			contract=pre_contract-post_contract;
			if(vo.getPj_prog().equals("4A급")){
				contract=(contract/10)*9;
			}
			else if(vo.getPj_prog().equals("5B급")){
				contract=(contract/2);
			}
			else if(vo.getPj_prog().equals("6C급")|| vo.getPj_prog().equals("7종결")){
				contract=0;
			}
			income=(contract*pj_operate)/100;
			netincome=income;
			ebit=netincome;
			WeekendVO result=new WeekendVO(flag,pj_id,team_id,pre,post,contract,income,netincome,ebit,0);
			
			weekendDao.insertLog(result);

		}
		if(!pj_prog.equals(vo.getPj_prog())){
			flag=1;
			post_contract=pre_contract;
			pre="상태("+vo.getPj_prog()+")";
			post="상태("+pj_prog+")";
			if(vo.getPj_prog().equals("4A급")){
				post_contract=(post_contract/10)*9;
			}
			else if(vo.getPj_prog().equals("5B급")){
				post_contract=(post_contract/2);
			}
			else if(vo.getPj_prog().equals("6C급")|| vo.getPj_prog().equals("7종결")){
				post_contract=0;
			}
			if(pj_prog.equals("4A급")){
				pre_contract=(pre_contract/10)*9;
			}
			else if(pj_prog.equals("5B급")){
				pre_contract=(pre_contract/2);
			}
			else if(pj_prog.equals("6C급")|| pj_prog.equals("7종결")){
				pre_contract=0;
			}	
			//계산하는 로직
			contract=pre_contract-post_contract;
			income=(contract*pj_operate)/100;
			netincome=income;
			ebit=netincome;
			WeekendVO result=new WeekendVO(flag,pj_id,team_id,pre,post,contract,income,netincome,ebit,0);
			if(Math.abs(contract)>1000)
				weekendDao.insertLog(result);

		}
		if(Math.abs(budget_product_cost-vo.getBudget_product_cost())>1000){
				flag=2;
			//계산하는 로직
			product=0;
			contract=0;
			product=budget_product_cost-vo.getBudget_product_cost();
			netincome=-product;
			ebit=netincome;
			pre="상품비("+vo.getBudget_product_cost()+")";
			post="상품비("+budget_product_cost+")";			
			WeekendVO result=new WeekendVO(flag,pj_id,team_id,pre,post,0,0,netincome,ebit,0);
			weekendDao.insertLog(result);
		}
	}
	
	@Override
	public List<WeekendVO> getLog(String wb_date){
		List<WeekendVO> list = weekendDao.getLog(wb_date);
		return list;
	}
	
	@Override
	public void updateBugetCost(BudgetVO vo) {
		String pj_id=vo.getPj_id();
		int post_product=vo.getBudget_product_cost();
		int post_pj_extra=vo.getPj_extra_cost();
		String team_id=vo.getTeam_id();
		ProjectVO project=project_dao.getProject(pj_id);
		int pre_product=project.getBudget_product_cost();
		int pre_pj_extra=project.getPj_extra_cost();
		int product=0;
		int extra=0;
		String pre="";
		String post="";
		boolean flag=true;
		if(Math.abs(post_product-pre_product)!=0){
			pre+="상품비";
			post+="상품비";
			product=post_product-pre_product;
			flag=false;
		}
		if(Math.abs(post_pj_extra-pre_pj_extra)!=0){
			if(!pre.equals("")){
				post+="/";
				pre+="/";
			}
			pre+="추가경비";
			post+="추가경비";
			extra=post_pj_extra-pre_pj_extra;
			flag=false;
		}
		if(flag==false){
		WeekendVO result=new WeekendVO(2,pj_id,team_id,pre,post,0,0,-(product),-(product+extra),0);	
		weekendDao.insertLog(result);
		}
	}
	
	@Override
	public CompareVO getWeekBudgetList(String wb_date) {
		CompareVO vo = new CompareVO();
		String t1 = "1S";
		String t2 = "2S";
		String t3 = "3E";
		String t4 = "4N";
		String t5 = "5D";
		String t6 = "6C";
		
		if (wb_date == null) {
			wb_date = weekendDao.getWeekBudgetDate();
		}
		//가장 최근 data 팀별로 가져오기
		List<WeekBudgetVO> p_list = weekendDao.getWeekBudgetListCurrent(wb_date);
		
		//1주전 data 팀별로 가져오기
		List<WeekBudgetVO> l_list = weekendDao.getWeekBudgetListLast(wb_date);
		
		WeekBudgetVO current_tot = new WeekBudgetVO();
		
		for (WeekBudgetVO w : p_list) {
			w.setWb_sales_cost(w.getWb_sal() + w.getWb_product() + w.getWb_charge());
			if (w.getTeam_id().equals(t1)) {
				vo.setCurrent_s1(w);
			} else if (w.getTeam_id().equals(t2)) {
				vo.setCurrent_s2(w);
			} else if (w.getTeam_id().equals(t3)) {
				vo.setCurrent_e(w);
			} else if (w.getTeam_id().equals(t4)) {
				vo.setCurrent_n(w);
			} else if (w.getTeam_id().equals(t5)) {
				vo.setCurrent_d(w);
			} else if (w.getTeam_id().equals(t6)){
				vo.setCurrent_c(w);
			}
			
			current_tot.setWb_contract(current_tot.getWb_contract() + w.getWb_contract());
			current_tot.setWb_income(current_tot.getWb_income() + w.getWb_income());
			current_tot.setWb_netincome(current_tot.getWb_netincome() + w.getWb_netincome());
			current_tot.setWb_ebit(current_tot.getWb_ebit() + w.getWb_ebit());
			current_tot.setWb_product(current_tot.getWb_product() + w.getWb_product());
			current_tot.setWb_sal(current_tot.getWb_sal() + w.getWb_sal());
			current_tot.setWb_charge(current_tot.getWb_charge() + w.getWb_charge());
			current_tot.setWb_sales_cost(current_tot.getWb_sales_cost() + w.getWb_sales_cost());
		}
		
		vo.setCurrent_tot(current_tot);
		
		WeekBudgetVO last_tot = new WeekBudgetVO();
		
		for (WeekBudgetVO w : l_list) {
			w.setWb_sales_cost(w.getWb_sal() + w.getWb_product() + w.getWb_charge());
			if (w.getTeam_id().equals(t1)) {
				vo.setLast_s1(w);
			} else if (w.getTeam_id().equals(t2)) {
				vo.setLast_s2(w);
			} else if (w.getTeam_id().equals(t3)) {
				vo.setLast_e(w);
			} else if (w.getTeam_id().equals(t4)) {
				vo.setLast_n(w);
			} else if (w.getTeam_id().equals(t5)) {
				vo.setLast_d(w);
			} else if (w.getTeam_id().equals(t6)){
				vo.setLast_c(w);
			}
			
			last_tot.setWb_contract(last_tot.getWb_contract() + w.getWb_contract());
			last_tot.setWb_income(last_tot.getWb_income() + w.getWb_income());
			last_tot.setWb_netincome(last_tot.getWb_netincome() + w.getWb_netincome());
			last_tot.setWb_ebit(last_tot.getWb_ebit() + w.getWb_ebit());
			last_tot.setWb_product(last_tot.getWb_product() + w.getWb_product());
			last_tot.setWb_sal(last_tot.getWb_sal() + w.getWb_sal());
			last_tot.setWb_charge(last_tot.getWb_charge() + w.getWb_charge());
			last_tot.setWb_sales_cost(last_tot.getWb_sales_cost() + w.getWb_sales_cost());
		}
		vo.setLast_tot(last_tot);
		return vo;
	}
	
	@Override
	public List<String> getWeekBudgetDateList() {
		return weekendDao.getWeekBudgetDateList();
	}
	
}
