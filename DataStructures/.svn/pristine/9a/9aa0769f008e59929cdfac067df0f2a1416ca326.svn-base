package com.sqisoft.iqs.demo.util;

import java.util.HashMap;
import java.util.Map;

public class ConditionUtils implements Cloneable {
	
	public static Map<String, String> getDefaultRanks() {
		
		Map<String, String> ranks = new HashMap<String, String>();
		
		String optionValue = "";
		String value = "";
		for(int i = 1; i < 4; i++) {
			optionValue = "rank" + i;
			value = "등급" + i;
			ranks.put(optionValue, value);
		}
		
		return ranks;
	}

	public static Map<String, String> getDefaultSkills() {
		
		Map<String, String> skills = new HashMap<String, String>();
		
		String optionValue = "";
		String value = "";
		for(int i = 4; i < 7; i++) {
			optionValue = "skill" + i;
			value = "전문기술" + i;
			skills.put(optionValue, value);
		}
		
		return skills;
	}
	
}
