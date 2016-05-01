package com.sqisoft.iqs.pf.schedule.service;

import java.util.List;

import com.sqisoft.iqs.pf.vo.BudgetVO;
import com.sqisoft.iqs.pf.vo.CompareVO;
import com.sqisoft.iqs.pf.vo.WeekendVO;

public interface WeekendServiceIF {
	public abstract void insertProject(String team_id,String pj_id,int budget_contract_sales,int pj_operate,String pj_prog,int budget_product_cost);
	public abstract void projectDelete(String pj_id);
	public abstract void updateProject(String team_id,String pj_id,int budget_contract_sales,int pj_operate,String pj_prog,int budget_product_cost);
	public abstract List<WeekendVO> getLog(String wb_date);
	public abstract void updateBugetCost(BudgetVO vo);
	public abstract CompareVO getWeekBudgetList(String wb_date);
	public abstract List<String> getWeekBudgetDateList();
	
}
