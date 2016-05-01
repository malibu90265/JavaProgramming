package com.sqisoft.iqs.humanResource.undecided.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.undecided.dao.UndecidedDAO;
import com.sqisoft.iqs.humanResource.undecided.service.UndecidedService;
import com.sqisoft.iqs.humanResource.undecided.vo.UndecidedVO;

public class UndecidedServiceImpl implements UndecidedService {
	UndecidedDAO undecidedDAO;
	
	public void setUndecidedDAO(UndecidedDAO undecidedDAO) {
		this.undecidedDAO = undecidedDAO;
	}

	@Override
	public List<UndecidedVO> selectTeam() {
		return undecidedDAO.getTeamList();
	}

	//해당 팀의 프로젝트 list를 가져옴
	@Override
	public List<UndecidedVO> getUndecidedList(String tm_id) {
		
		List<UndecidedVO> list = undecidedDAO.getUndecidedList(tm_id);
		
		for(int i=0; i<list.size(); i++){
			String pj_id = list.get(i).getPj_id();
			//소요
			list.get(i).setRequire_num(undecidedDAO.getPjRequiredNum(pj_id));
			//미배치
			list.get(i).setPlacements_num(undecidedDAO.getPrNameIsNull(pj_id));
			//미투입
			list.get(i).setDeployless_num(undecidedDAO.getPdNameIsNull(pj_id));
			//과투입
			list.get(i).setDeploy_num(undecidedDAO.getPjDeployNum(pj_id) - undecidedDAO.getPjRequiredNum(pj_id));
			/*
			System.out.println("소요:" + list.get(i).getRequire_num());
			System.out.println("미배치:" + list.get(i).getPlacements_num());
			System.out.println("미투입:" + list.get(i).getDeployless_num());
			System.out.println("과투입:" + list.get(i).getDeploy_num());*/
		}
		
		/* 
		"require_num" ${UndecidedList.require_num } -> 소요
		"placements_num" ${UndecidedList.placements_num } -> 미배치
		"deployless_num" ${UndecidedList.deployless_num } -> 미투입
		"deploy_num" ${UndecidedList.deploy_num } -> 과투입
		*/
		/*synchronized(list) {
			Iterator<UndecidedVO> it = list.iterator(); 
			
			while(it.hasNext()) {
				UndecidedVO vo2 = it.next();
				
				if(vo2.getRequire_num() > 0) {
					if(vo2.getPlacements_num() == 0 && vo2.getDeployless_num() == 0) {
						it.remove();
					}
				}
			}
		}*/
		return list;
	}

	@Override
	public List<UndecidedVO> getUndecidedModifyForm(String pj_id) {
		List<UndecidedVO> und = undecidedDAO.getUndecidedModifyForm(pj_id);
		for(int i=0; i<und.size(); i++){
			String pr_grade = und.get(i).getPr_grade().replaceAll("[0-9]", "");
			und.get(i).setPr_grade(pr_grade);
		}
		return und;
	}

	@Override
	public void insertUndecided(Map<String, Object> map) {
		undecidedDAO.insertUndecided(map);
	}
}
