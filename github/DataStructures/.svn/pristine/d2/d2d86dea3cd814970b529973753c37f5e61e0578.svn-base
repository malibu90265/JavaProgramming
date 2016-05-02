package com.sqisoft.iqs.humanResource.waitingList.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sqisoft.iqs.humanResource.waitingList.dao.WaitingListDAO;
import com.sqisoft.iqs.humanResource.waitingList.service.WaitingListService;
import com.sqisoft.iqs.humanResource.waitingList.vo.WaitingListVO;

public class WaitingListServiceImpl implements WaitingListService{

	WaitingListDAO waitingListDAO;

	public void setWaitingListDAO(WaitingListDAO waitingListDAO) {
		this.waitingListDAO = waitingListDAO;
	}

	// 전체 리스트
	@Override
	public List<WaitingListVO> getJanuaryToDecemberList() {
		return waitingListDAO.getJanuaryToDecemberList();
	}

	// month option
	@Override
	public Map<String, String> getwaitingListOptions() {
		Map<String, String> ranks = new HashMap<String, String>();
		
		ranks.put("01", "1월");
		ranks.put("02", "2월");
		ranks.put("03", "3월");
		ranks.put("04", "4월");
		ranks.put("05", "5월");
		ranks.put("06", "6월");
		ranks.put("07", "7월");
		ranks.put("08", "8월");
		ranks.put("09", "9월");
		ranks.put("10", "10월");
		ranks.put("11", "11월");
		ranks.put("12", "12월");
		
		// 정렬 전
		printMap(ranks);

		// 정렬 후
		Map<String, String> treeMap = new TreeMap<String, String>(ranks);
		printMap(treeMap);

		return treeMap;
	}
	
	// sort month
	public static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
		}
	}

	
	
}
