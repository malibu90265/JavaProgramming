package com.sqisoft.iqs.team.vo;

import java.util.ArrayList;
import java.util.List;

public class WeekChartVO {

	private int goalContract;
	private int goalYearSales;
	private int goalNetSales;
	private int goalSalesProfit;

	private List<WeekChartTotalVO> totalList;

	public WeekChartVO() {
		this.totalList = new ArrayList<WeekChartTotalVO>();
	}
	
	public int getGoalContract() {
		return goalContract;
	}

	public void setGoalContract(int goalContract) {
		this.goalContract = goalContract;
	}

	public int getGoalYearSales() {
		return goalYearSales;
	}

	public void setGoalYearSales(int goalYearSales) {
		this.goalYearSales = goalYearSales;
	}

	public int getGoalNetSales() {
		return goalNetSales;
	}

	public void setGoalNetSales(int goalNetSales) {
		this.goalNetSales = goalNetSales;
	}

	public int getGoalSalesProfit() {
		return goalSalesProfit;
	}

	public void setGoalSalesProfit(int goalSalesProfit) {
		this.goalSalesProfit = goalSalesProfit;
	}

	public List<WeekChartTotalVO> getTotalList() {
		/*List<WeekChartTotalVO> temp = new ArrayList<WeekChartTotalVO>();
		temp.addAll(this.totalList);

		return temp;*/
		return this.totalList;
	}

	public void setTotalList(List<WeekChartTotalVO> totalList) {
		List<WeekChartTotalVO> temp = new ArrayList<WeekChartTotalVO>();
		temp.addAll(totalList);

		this.totalList = temp;
	}

}
