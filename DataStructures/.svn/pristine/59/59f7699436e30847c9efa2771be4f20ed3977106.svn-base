package com.sqisoft.iqs.project.service;

import java.util.List;

import com.sqisoft.iqs.project.vo.PjProgressSearchVO;
import com.sqisoft.iqs.project.vo.PjProgressVO;

public interface PjProgressService {
	
	public static final int READ = 1;
	public static final int WRITE = 2;
	
	List<PjProgressVO> getProjectListByPjProgressSearchConditions(PjProgressSearchVO pjProgressSearchVO);

	boolean existWeekProgress(String pj_id, String week);
	
	String getPjProgressDonePlan(String pj_id, String lastWeek);
	
	PjProgressVO getPjProgressByConditions(String pj_id, String tm_id, String pp_date);

	void insertPjProgress(PjProgressVO pjProgressVO);

	void modifyPjProgress(PjProgressVO pjProgressVO);

	void deletePjProgres(String pj_id, String pp_date);

	List<PjProgressVO> getPjProgressList(String tm_id, String pp_date);



}
