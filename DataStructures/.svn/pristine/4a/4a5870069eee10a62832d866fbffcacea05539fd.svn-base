package com.sqisoft.iqs.hr.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandByInfoVO {

	private String name;
	private String team_id;
	private String team_name;
	private String position;
	private String division;
	private String project_id;
	private String startday;
	private String endday;
	private String year;
	private int salary;
	float[] mm=new float[12];
	//2014.12.19 외주용 totalMm추가
	private float totalMm;
	private List<ManMonthVO> manMonthList=new ArrayList<ManMonthVO>();
	
	//2014.12.18추가
	private List<OutSal_historyVO> outSal_history=new ArrayList<OutSal_historyVO>();

	public StandByInfoVO() {
		super();
	}
	
	public StandByInfoVO(int i,float manMonth) {
		setMm(i, manMonth);
	}

	public StandByInfoVO(String name, String team_id, String team_name,
			String position, String division, String project_id,
			String startday, String endday, String year,int salary, float[] mm) {
		super();
		this.name = name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.position = position;
		this.division = division;
		this.project_id = project_id;
		this.startday = startday;
		this.endday = endday;
		this.year = year;
		this.mm = mm;
	}
	
	
	

	public StandByInfoVO(String name, String team_id, String team_name,
			String position, String division, String project_id,
			String startday, String endday, String year, int salary,
			float[] mm, List<ManMonthVO> manMonthList,
			List<OutSal_historyVO> outSal_history) {
		super();
		this.name = name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.position = position;
		this.division = division;
		this.project_id = project_id;
		this.startday = startday;
		this.endday = endday;
		this.year = year;
		this.salary = salary;
		this.mm = mm;
		this.manMonthList = manMonthList;
		this.outSal_history = outSal_history;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getStartday() {
		return startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	public String getEndday() {
		return endday;
	}

	public void setEndday(String endday) {
		this.endday = endday;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public int getSalary() {
		return salary;
	}



	public List<OutSal_historyVO> getOutSal_history() {
		return outSal_history;
	}

	public void setOutSal_history(List<OutSal_historyVO> outSal_history) {
		this.outSal_history = outSal_history;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float[] getMm() {
		return mm;
	}
	public float getMm(int i) {
		return mm[i];
	}

	public void setMm(int i, float manMonth) {
		this.mm[i]+= manMonth;
		if(this.mm[i]>1.0f){
			this.mm[i]=1.0f;
		}
	}
	
	

	public List<ManMonthVO> getManMonthList() {
		return manMonthList;
	}

	public void setManMonthList(List<ManMonthVO> manMonthList) {
		this.manMonthList = manMonthList;
	}
	
	

	public float getTotalMm() {
		return totalMm;
	}

	public void setTotalMm(float totalMm) {
		this.totalMm = totalMm;
	}

	@Override
	public String toString() {
		return "StandByInfoVO [name=" + name + ", team_id=" + team_id
				+ ", team_name=" + team_name + ", position=" + position
				+ ", division=" + division + ", project_id=" + project_id
				+ ", startday=" + startday + ", endday=" + endday + ", year="
				+ year + ", salary=" + salary + ", mm=" + Arrays.toString(mm)
				+ ", totalMm=" + totalMm + ", manMonthList=" + manMonthList
				+ ", outSal_history=" + outSal_history + "]";
	}

}
