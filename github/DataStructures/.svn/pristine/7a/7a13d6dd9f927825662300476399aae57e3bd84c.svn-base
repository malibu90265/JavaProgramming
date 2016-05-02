package com.sqisoft.iqs.hr.vo;

public class BudgetVO {
	
	//Team table : team_id, team_name
	//Project table :pj_name, pj_id, pj_prog, pn_num, team_id,
	//               pj_start_day, pj_end_day, pj_require, pj_loc
	//Budget table : budget_product_cost, pj_extra_cost
	
	// 투입 인원
	private String emp_cnt;
	/*
	 * 2015.08.21
	 * 이욱진
	 * 배치인원 추가
	 */
	private String emp_cnt2;
	
	// 위치 : LEFT JOIN(Team table, Project table)
	// 사용처 : PjNeedsDao(pj_SearchList() / pjneeds_getPJ())
	// 중복 : 없음
	private String team_id;
	
	
	//Project table
	private String pj_id;
	private String pj_name;
	
	private String customer_name;
	
	//Project table
	private String pj_start_day;
	private String pj_end_day;
	private String pj_prog;
	
	private String pj_pm;
	private String pj_biz;
	private String pj_etc;
	
	//Project table
	private String pj_loc;	
	private String pj_require;
	
	private String pj_sqimm;
	private String pj_outmm;
	private String pj_frame;
	private String pj_db;
	private String pj_lang;
	private String pj_tool1;
	private String pj_tool2;
	private String pj_tool3;
	
	private int budget_outsource;
	private int pj_operate;	
	private int budget_contract_sales;// 怨꾩빟�븸
	private int budget_sales;// 留ㅼ텧�븸
	private int budget_outsource_cost;
	
	//Budget table
	private int budget_product_cost;
	
	private String pj_period;
	private String profit;

	//Project table
	private int pn_num;
	
	//Team table
	private String team_name;
	
	public BudgetVO() {
		super();
	}

	public BudgetVO(	String team_id, String pj_id, String pj_name,
						String customer_name, String pj_start_day, String pj_end_day,
						String pj_prog, String pj_pm, String pj_biz, String pj_etc,
						String pj_loc, String pj_require, String pj_sqimm, String pj_outmm,
						String pj_frame, String pj_db, String pj_lang, String pj_tool1,
						String pj_tool2, String pj_tool3, int budget_outsource,
						int pj_operate, int budget_contract_sales, int budget_sales,
						int budget_outsource_cost, int budget_product_cost,
						String pj_period, String profit, int pn_num, String team_name) {
		super();
		this.team_id = team_id;
		this.pj_id = pj_id;
		this.pj_name = pj_name;
		this.customer_name = customer_name;
		this.pj_start_day = pj_start_day;
		this.pj_end_day = pj_end_day;
		this.pj_prog = pj_prog;
		this.pj_pm = pj_pm;
		this.pj_biz = pj_biz;
		this.pj_etc = pj_etc;
		this.pj_loc = pj_loc;
		this.pj_require = pj_require;
		this.pj_sqimm = pj_sqimm;
		this.pj_outmm = pj_outmm;
		this.pj_frame = pj_frame;
		this.pj_db = pj_db;
		this.pj_lang = pj_lang;
		this.pj_tool1 = pj_tool1;
		this.pj_tool2 = pj_tool2;
		this.pj_tool3 = pj_tool3;
		this.budget_outsource = budget_outsource;
		this.pj_operate = pj_operate;
		this.budget_contract_sales = budget_contract_sales;
		this.budget_sales = budget_sales;
		this.budget_outsource_cost = budget_outsource_cost;
		this.budget_product_cost = budget_product_cost;
		this.pj_period = pj_period;
		this.profit = profit;
		this.pn_num = pn_num;
		this.team_name = team_name;
	}

	
	
	public String getEmp_cnt() {
		return emp_cnt;
	}

	public void setEmp_cnt(String emp_cnt) {
		this.emp_cnt = emp_cnt;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getPj_id() {
		return pj_id;
	}

	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}

	public String getPj_name() {
		return pj_name;
	}

	public void setPj_name(String pj_name) {
		this.pj_name = pj_name;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPj_start_day() {
		return pj_start_day;
	}

	public void setPj_start_day(String pj_start_day) {
		this.pj_start_day = pj_start_day;
	}

	public String getPj_end_day() {
		return pj_end_day;
	}

	public void setPj_end_day(String pj_end_day) {
		this.pj_end_day = pj_end_day;
	}

	public String getPj_prog() {
		return pj_prog;
	}

	public void setPj_prog(String pj_prog) {
		this.pj_prog = pj_prog;
	}

	public String getPj_pm() {
		return pj_pm;
	}

	public void setPj_pm(String pj_pm) {
		this.pj_pm = pj_pm;
	}

	public String getPj_biz() {
		return pj_biz;
	}

	public void setPj_biz(String pj_biz) {
		this.pj_biz = pj_biz;
	}

	public String getPj_etc() {
		return pj_etc;
	}

	public void setPj_etc(String pj_etc) {
		this.pj_etc = pj_etc;
	}

	public String getPj_loc() {
		return pj_loc;
	}

	public void setPj_loc(String pj_loc) {
		this.pj_loc = pj_loc;
	}

	public String getPj_require() {
		return pj_require;
	}

	public void setPj_require(String pj_require) {
		this.pj_require = pj_require;
	}

	public String getPj_sqimm() {
		return pj_sqimm;
	}

	public void setPj_sqimm(String pj_sqimm) {
		this.pj_sqimm = pj_sqimm;
	}

	public String getPj_outmm() {
		return pj_outmm;
	}

	public void setPj_outmm(String pj_outmm) {
		this.pj_outmm = pj_outmm;
	}

	public String getPj_frame() {
		return pj_frame;
	}

	public void setPj_frame(String pj_frame) {
		this.pj_frame = pj_frame;
	}

	public String getPj_db() {
		return pj_db;
	}

	public void setPj_db(String pj_db) {
		this.pj_db = pj_db;
	}

	public String getPj_lang() {
		return pj_lang;
	}

	public void setPj_lang(String pj_lang) {
		this.pj_lang = pj_lang;
	}

	public String getPj_tool1() {
		return pj_tool1;
	}

	public void setPj_tool1(String pj_tool1) {
		this.pj_tool1 = pj_tool1;
	}

	public String getPj_tool2() {
		return pj_tool2;
	}

	public void setPj_tool2(String pj_tool2) {
		this.pj_tool2 = pj_tool2;
	}

	public String getPj_tool3() {
		return pj_tool3;
	}

	public void setPj_tool3(String pj_tool3) {
		this.pj_tool3 = pj_tool3;
	}

	public int getBudget_outsource() {
		return budget_outsource;
	}

	public void setBudget_outsource(int budget_outsource) {
		this.budget_outsource = budget_outsource;
	}

	public int getPj_operate() {
		return pj_operate;
	}

	public void setPj_operate(int pj_operate) {
		this.pj_operate = pj_operate;
	}

	public int getBudget_contract_sales() {
		return budget_contract_sales;
	}

	public void setBudget_contract_sales(int budget_contract_sales) {
		this.budget_contract_sales = budget_contract_sales;
	}

	public int getBudget_sales() {
		return budget_sales;
	}

	public void setBudget_sales(int budget_sales) {
		this.budget_sales = budget_sales;
	}

	public int getBudget_outsource_cost() {
		return budget_outsource_cost;
	}

	public void setBudget_outsource_cost(int budget_outsource_cost) {
		this.budget_outsource_cost = budget_outsource_cost;
	}

	public int getBudget_product_cost() {
		return budget_product_cost;
	}

	public void setBudget_product_cost(int budget_product_cost) {
		this.budget_product_cost = budget_product_cost;
	}

	public String getPj_period() {
		return pj_period;
	}

	public void setPj_period(String pj_period) {
		this.pj_period = pj_period;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public int getpn_num() {
		return pn_num;
	}

	public void setpn_num(int pn_num) {
		this.pn_num = pn_num;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getEmp_cnt2() {
		return emp_cnt2;
	}

	public void setEmp_cnt2(String emp_cnt2) {
		this.emp_cnt2 = emp_cnt2;
	}

	@Override
	public String toString() {
		return "BudgetVO [team_id=" + team_id + ", pj_id=" + pj_id
				+ ", pj_name=" + pj_name + ", customer_name=" + customer_name
				+ ", pj_start_day=" + pj_start_day + ", pj_end_day="
				+ pj_end_day + ", pj_prog=" + pj_prog + ", pj_pm=" + pj_pm
				+ ", pj_biz=" + pj_biz + ", pj_etc=" + pj_etc + ", pj_loc="
				+ pj_loc + ", pj_require=" + pj_require + ", pj_sqimm="
				+ pj_sqimm + ", pj_outmm=" + pj_outmm + ", pj_frame="
				+ pj_frame + ", pj_db=" + pj_db + ", pj_lang=" + pj_lang
				+ ", pj_tool1=" + pj_tool1 + ", pj_tool2=" + pj_tool2
				+ ", pj_tool3=" + pj_tool3 + ", budget_outsource="
				+ budget_outsource + ", pj_operate=" + pj_operate
				+ ", budget_contract_sales=" + budget_contract_sales
				+ ", budget_sales=" + budget_sales + ", budget_outsource_cost="
				+ budget_outsource_cost + ", budget_product_cost="
				+ budget_product_cost + ", pj_period=" + pj_period
				+ ", profit=" + profit + ", pn_num=" + pn_num
				+ ", team_name=" + team_name + "]";
	}

}
