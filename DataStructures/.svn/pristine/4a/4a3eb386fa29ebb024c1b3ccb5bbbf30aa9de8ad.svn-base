package com.sqisoft.iqs.demo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStore /*implements Serializable */{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 5816201540182774221L;

	private Map<String, DeployRequirementsVO> test;
	
	private static TestStore testStore;
	
	private TestStore() {
		test = new HashMap<String, DeployRequirementsVO>();
	}
	
	public static synchronized TestStore getInstance() {
		
		if(TestStore.testStore == null) {
			TestStore.testStore = new TestStore();
		}
		
		return TestStore.testStore;
	}
	
	public synchronized void putDeployRequirements(String id, DeployRequirementsVO deployRequirementsVO) {
		this.test.put(id, deployRequirementsVO);
	}
	
	public synchronized DeployRequirementsVO getDeployRequirements(String id) {
		return this.test.get(id);
	}
	
	public synchronized void removeDeployRequirements(String id) {
		this.test.remove(id);
	}
	
	public synchronized List<DeployRequirementsVO> getAllDeployRequirements() {
		
		List<DeployRequirementsVO> deployRequirements = new ArrayList<DeployRequirementsVO>();
		for(String key : this.test.keySet()) {
			DeployRequirementsVO temp = this.test.get(key);
			deployRequirements.add(temp);
		}
		
		return deployRequirements;
	}
	
}
