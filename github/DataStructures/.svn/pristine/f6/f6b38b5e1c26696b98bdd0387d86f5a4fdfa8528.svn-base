package com.sqisoft.iqs.project.dao;

import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.project.vo.PjProgressSearchVO;
import com.sqisoft.iqs.project.vo.PjProgressVO;

public interface PjProgressDAO {

	List<PjProgressVO> getProjectListByPjProgressSearchConditions(PjProgressSearchVO pjProgressSearchVO);

	boolean existWeekProgress(Map<String, String> params);
	
	String getPjProgressDonePlan(Map<String, String> params);
	
	PjProgressVO getPjProgressByConditions(Map<String, String> params);

	void insertPjProgress(PjProgressVO pjProgressVO);

	void modifyPjProgress(PjProgressVO pjProgressVO);

	void deletePjProgres(Map<String, String> params);

	List<PjProgressVO> getPjProgressList(Map<String, String> params);



}
