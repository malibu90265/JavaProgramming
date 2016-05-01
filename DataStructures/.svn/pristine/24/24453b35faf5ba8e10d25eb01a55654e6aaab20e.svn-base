package com.sqisoft.iqs.humanResource.undecided.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.undecided.vo.UndecidedVO;

public interface UndecidedDAO {
	
	public List<UndecidedVO> getTeamList();
	public List<UndecidedVO> getUndecidedList(String tm_id);
	public List<UndecidedVO> getUndecidedModifyForm(String pj_id);
	public void insertUndecided(Map<String, Object> map);
	
	public int getPjRequiredNum(String tm_id);
	public int getPjDeployNum(String tm_id);
	public int getPrNameIsNull(String tm_id);
	public int getPdNameIsNull(String tm_id);
}
