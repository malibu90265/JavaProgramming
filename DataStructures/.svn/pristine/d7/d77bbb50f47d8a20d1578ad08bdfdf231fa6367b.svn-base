package com.sqisoft.iqs.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.project.vo.PjProgressSearchVO;
import com.sqisoft.iqs.project.vo.PjProgressVO;

public class PjProgressDAOImpl extends SqlSessionDaoSupport implements PjProgressDAO {

	@Override
	public List<PjProgressVO> getProjectListByPjProgressSearchConditions(PjProgressSearchVO pjProgressSearchVO) {
		return getSqlSession().selectList("pjProgressDAO.getProjectListByPjProgressSearchConditions", pjProgressSearchVO);
	}
	
	@Override
	public boolean existWeekProgress(Map<String, String> params) {
		int count = getSqlSession().selectOne("pjProgressDAO.existWeekProgress", params);
		return count > 0;
	}
	
	@Override
	public String getPjProgressDonePlan(Map<String, String> params) {
		return getSqlSession().selectOne("pjProgressDAO.getPjProgressDonePlan", params);
	}
	
	@Override
	public PjProgressVO getPjProgressByConditions(Map<String, String> params) {
		return getSqlSession().selectOne("pjProgressDAO.getPjProgressByConditions", params);
	}
	
	@Override
	public void insertPjProgress(PjProgressVO pjProgressVO) {
		getSqlSession().insert("pjProgressDAO.insertPjProgress", pjProgressVO);
	}
	
	@Override
	public void modifyPjProgress(PjProgressVO pjProgressVO) {
		getSqlSession().update("pjProgressDAO.modifyPjProgress", pjProgressVO);
	}
	
	@Override
	public void deletePjProgres(Map<String, String> params) {
		getSqlSession().delete("pjProgressDAO.deletePjProgres", params);
	}
	
	@Override
	public List<PjProgressVO> getPjProgressList(Map<String, String> params) {
		return getSqlSession().selectList("pjProgressDAO.getPjProgressList", params);
	}
}
