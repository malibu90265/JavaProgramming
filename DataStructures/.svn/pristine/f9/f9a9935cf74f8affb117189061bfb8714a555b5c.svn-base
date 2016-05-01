package com.sqisoft.iqs.humanResource.humanResource.service.impl;

import java.util.List;

import com.sqisoft.iqs.humanResource.deployRequirements.dao.DeployRequirementsDAO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HRPriceDAO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HumanResourceDAO;
import com.sqisoft.iqs.humanResource.humanResource.service.HRPriceService;
import com.sqisoft.iqs.humanResource.vo.HRPriceVO;

public class HRPriceServiceImpl implements HRPriceService{

	private HRPriceDAO hrPriceDAO;
	private HumanResourceDAO humanResourceDAO;
	private DeployRequirementsDAO deployRequirementsDAO;
	
	public void setHrPriceDAO(HRPriceDAO hrPriceDAO) {
		this.hrPriceDAO = hrPriceDAO;
	}
	
	@Override
	public List<HRPriceVO> getHRPriceIfoByTeamId(String tm_id) {
		List<HRPriceVO> hrPriceList = this.hrPriceDAO.getHRPriceIfoByTeamId(tm_id);
		
		for(HRPriceVO hrPriceVO : hrPriceList) {
			String hp_position = this.subNumber(hrPriceVO.getHp_position()); 
			hrPriceVO.setHp_position(hp_position);
		}
		return hrPriceList;
	}
	
	private String subNumber(String str) {
		String subString = str;
		
		int numberLastIndex = 99;
		for(int i = 0; i < str.length(); i++) {
			if((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57) {
				numberLastIndex = i;
			}
		}
		
		if(numberLastIndex != 99) {
			subString = str.substring(numberLastIndex+1, str.length()); 
		}
		
		return subString;
	}
	
	@Override
	public boolean updateHRPriceInfoList(List<HRPriceVO> hrPriceList) {
		for(HRPriceVO hrPriceVO : hrPriceList) {
			boolean isSuccess = this.hrPriceDAO.updateHRPriceInfo(hrPriceVO);
			if(!isSuccess) {
				return false;
			}
		}
		return true;
	}

}

