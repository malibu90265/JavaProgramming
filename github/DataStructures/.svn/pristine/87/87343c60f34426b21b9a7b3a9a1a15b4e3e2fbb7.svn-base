package com.sqisoft.iqs.humanResource.undecided.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.undecided.dao.UndecidedDAO;
import com.sqisoft.iqs.humanResource.undecided.vo.UndecidedVO;

public class UndecidedDAOImpl extends SqlSessionDaoSupport implements UndecidedDAO {

	@Override
	public List<UndecidedVO> getTeamList() {
		return getSqlSession().selectList("UndecidedDAO.getTeamList");
	}

	@Override
	public List<UndecidedVO> getUndecidedList(String tm_id) {
		return getSqlSession().selectList("UndecidedDAO.getUndecidedList", tm_id);
	}

	@Override
	public List<UndecidedVO> getUndecidedModifyForm(String pj_id) {
		return getSqlSession().selectList("UndecidedDAO.getUndecidedModifyList", pj_id);
	}

	@Override
	public void insertUndecided(Map<String, Object> map) {
		getSqlSession().insert("UndecidedDAO.insertUndecided", map);
	}
	
	public int getPjRequiredNum(String pj_id){
		return getSqlSession().selectOne("UndecidedDAO.getPjRequiredNum", pj_id);
	}
	
	public int getPjDeployNum(String pj_id){
		return getSqlSession().selectOne("UndecidedDAO.getPjDeployNum", pj_id);
	}
	
	public int getPrNameIsNull(String pj_id){
		return getSqlSession().selectOne("UndecidedDAO.getPrNameIsNull", pj_id);
	}
	
	public int getPdNameIsNull(String pj_id){
		return getSqlSession().selectOne("UndecidedDAO.getPdNameIsNull", pj_id);
	}
}
