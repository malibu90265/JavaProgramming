package com.sqisoft.iqs.demo.vo;

import java.util.ArrayList;
import java.util.List;


public class DeployRequirementsVO {

	private String pjStatus;
	private String pjId;
	private int pjDeployRequirements;

	private List<DeployRequirementsConditionVO> deployRequirementsList;

	//
	private List<String> ranks;
	private List<String> skills;

	public String getPjStatus() {
		return pjStatus;
	}

	public void setPjStatus(String pjStatus) {
		this.pjStatus = pjStatus;
	}

	public String getPjId() {
		return pjId;
	}

	public void setPjId(String pjId) {
		this.pjId = pjId;
	}

	public int getPjDeployRequirements() {
		return pjDeployRequirements;
	}

	public void setPjDeployRequirements(int pjDeployRequirements) {
		this.pjDeployRequirements = pjDeployRequirements;

	}

	public List<DeployRequirementsConditionVO> getDeployRequirementsList() {

		List<DeployRequirementsConditionVO> tempList = new ArrayList<DeployRequirementsConditionVO>();

		tempList.addAll(this.deployRequirementsList);

		return tempList;
	}

	public void setDeployRequirementsList(
			List<DeployRequirementsConditionVO> deployRequirementsList) {

		List<DeployRequirementsConditionVO> tempList = new ArrayList<DeployRequirementsConditionVO>();
		tempList.addAll(deployRequirementsList);

		this.deployRequirementsList = tempList;
	}

	public List<String> getRanks() {

		List<String> temps = new ArrayList<String>();
		temps = this.ranks;

		return temps;
	}

	public void setRanks(List<String> ranks) {

		List<String> temps = new ArrayList<String>();
		temps = ranks;

		this.ranks = temps;
	}

	public List<String> getSkills() {

		List<String> temps = new ArrayList<String>();
		temps = this.skills;

		return temps;
	}

	public void setSkills(List<String> skills) {
		List<String> temps = new ArrayList<String>();
		temps = skills;

		this.skills = temps;
	}

}
