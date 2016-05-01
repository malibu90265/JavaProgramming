package com.sqisoft.iqs.humanResource.waitingList.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.waitingList.dao.WaitingListDAO;
import com.sqisoft.iqs.humanResource.waitingList.vo.WaitingListVO;

public class WaitingListDAOImpl extends SqlSessionDaoSupport implements WaitingListDAO{

	// 전체 리스트
	@Override
	public List<WaitingListVO> getJanuaryToDecemberList() {
		return getSqlSession().selectList("waitingListDAO.getJanuaryToDecemberList");
	}

	@Override
	public List<WaitingListVO> getWaitList(String tm_id) {
		return getSqlSession().selectList("waitingListDAO.getWaitList",tm_id);
	}
	
}

/*
 * SELECT	w.wa_name as wa_name,
			w.tm_id as tm_id,
			w.wa_from_date as wa_from_date,
			w.wa_to_date as wa_to_date,
			hr.hr_position as hr_position,
			hr.hr_grade as hr_grade,
			hr.hr_company as hr_company,
			hr.hr_uprice as hr_uprice
	FROM	wait w, human_resource hr
	WHERE	w.tm_id = #{tm_id}
	AND		w.wa_name = hr.hr_name
	ORDER	BY w.wa_name
 */
