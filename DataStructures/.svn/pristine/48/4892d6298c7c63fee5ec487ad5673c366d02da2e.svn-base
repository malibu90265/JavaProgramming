package com.sqisoft.iqs.humanResource.empStandBy.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sqisoft.iqs.hr.vo.ManMonthVO;
import com.sqisoft.iqs.hr.vo.OutSal_historyVO;

public class EmpStandByVO {
	
	private String hr_hire_date;
	private String hr_quit_date;
	
	private String hr_name;
	private String pj_name;
	private String tm_id;
	private String tm_name;
	private String hr_position;
	private String pj_id;
	private String pd_start_date;
	private String pd_end_date;
	private String startday_r;
	private String endday_r;
	private String year;
	private int salary;
	float[] mm = new float[12];
	
	private float totalMm;
	private List<ManMonthVO> manMonthList = new ArrayList<ManMonthVO>();
	
	private List<OutSal_historyVO> outSal_history = new ArrayList<OutSal_historyVO>();
	
	public EmpStandByVO() {
		super();
	}
	
	public EmpStandByVO(int i,float manMonth) {
		setMm(i, manMonth);
	}
	
	public EmpStandByVO(String hr_name, String pj_name, String tm_id, String tm_name,
			String hr_position,  String pj_id,
			String startday_r, String endday_r, String year,int salary, float[] mm) {
		super();
		this.hr_name = hr_name;
		this.pj_name = pj_name;
		this.tm_id = tm_id;
		this.tm_name = tm_name;
		this.hr_position = hr_position;
		this.pj_id = pj_id;
		this.startday_r = startday_r;
		this.endday_r = endday_r;
		this.year = year;
		this.mm = mm;
	}
	
	public EmpStandByVO(String hr_name,String pj_name, String tm_id, String tm_name,
			String hr_position,  String pj_id,
			String startday_r, String endday_r, String year, int salary,
			float[] mm, List<ManMonthVO> manMonthList,
			List<OutSal_historyVO> outSal_history) {
		super();
		this.hr_name = hr_name;
		this.pj_name=pj_name;
		this.tm_id = tm_id;
		this.tm_name = tm_name;
		this.hr_position = hr_position;
		this.pj_id = pj_id;
		this.startday_r = startday_r;
		this.endday_r = endday_r;
		this.year = year;
		this.salary = salary;
		this.mm = mm;
		this.manMonthList = manMonthList;
		this.outSal_history = outSal_history;
	}
	
	
	
	public String getHr_hire_date() {
		return hr_hire_date;
	}

	public void setHr_hire_date(String hr_hire_date) {
		this.hr_hire_date = hr_hire_date;
	}

	public String getHr_quit_date() {
		return hr_quit_date;
	}

	public void setHr_quit_date(String hr_quit_date) {
		this.hr_quit_date = hr_quit_date;
	}

	public String getPj_name() {
		return pj_name;
	}
	public void setPj_name(String pj_name) {
		this.pj_name = pj_name;
	}
	public String getHr_name() {
		return hr_name;
	}
	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}

	public String getTm_id() {
		return tm_id;
	}

	public void setTm_id(String tm_id) {
		this.tm_id = tm_id;
	}

	public String getTm_name() {
		return tm_name;
	}

	public void setTm_name(String tm_name) {
		this.tm_name = tm_name;
	}

	public String getHr_position() {
		return hr_position;
	}

	public void setHr_position(String hr_position) {
		this.hr_position = hr_position;
	}

	public String getPj_id() {
		return pj_id;
	}

	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}

	public String getPd_start_date() {
		return pd_start_date;
	}

	public void setPd_start_date(String pd_start_date) {
		this.pd_start_date = pd_start_date;
	}

	public String getPd_end_date() {
		return pd_end_date;
	}

	public void setPd_end_date(String pd_end_date) {
		this.pd_end_date = pd_end_date;
	}

	public String getStartday_r() {
		return startday_r;
	}

	public void setStartday_r(String startday_r) {
		this.startday_r = startday_r;
	}

	public String getEndday_r() {
		return endday_r;
	}

	public void setEndday_r(String endday_r) {
		this.endday_r = endday_r;
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

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float[] getMm() {
		return mm;
	}

	public void setMm(int i, float manMonth) {
		this.mm[i]+= manMonth;
		if(this.mm[i]>1.0f){
			this.mm[i]=1.0f;
		}
	}

	public float getTotalMm() {
		return totalMm;
	}

	public void setTotalMm(float totalMm) {
		this.totalMm = totalMm;
	}

	public List<ManMonthVO> getManMonthList() {
		return manMonthList;
	}

	public void setManMonthList(List<ManMonthVO> manMonthList) {
		this.manMonthList = manMonthList;
	}

	public List<OutSal_historyVO> getOutSal_history() {
		return outSal_history;
	}

	public void setOutSal_history(List<OutSal_historyVO> outSal_history) {
		this.outSal_history = outSal_history;
	}
	
	@Override
	public String toString(){
		return "EmpStandByVO [hr_name=" + hr_name + ", pj_name=" + pj_name + ", tm_id=" + tm_id
				+ ", tm_name=" + tm_name + ", hr_position=" + hr_position
				+ ", pj_id=" + pj_id + ", startday_r=" + startday_r + ", endday_r=" + endday_r + ", year="
				+ year + ", salary=" + salary + ", mm=" + Arrays.toString(mm)
				+ ", totalMm=" + totalMm + ", manMonthList=" + manMonthList
				+ ", outSal_history=" + outSal_history + "]";
	}
	
}
