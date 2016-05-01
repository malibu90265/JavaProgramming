package com.sqisoft.iqs.hr.pj.needs.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.hr.pj.needs.dao.PjNeedsDAO;
import com.sqisoft.iqs.hr.vo.BudgetVO;
import com.sqisoft.iqs.hr.vo.PjNeedsVO;

public class PjNeedsDAOImpl extends SqlSessionDaoSupport implements PjNeedsDAO {

	@Override
	public List<BudgetVO> pj_SearchList(Map<String, String> hash) {
		return getSqlSession().selectList("pjNeedsDao.pj_SearchList", hash);
	}
	
	@Override
	public BudgetVO pj_Datail(String pjId) {
		return getSqlSession().selectOne("pjNeedsDao.pj_Datail", pjId);
	}
	
	@Override
	public String searchArea(String pj_id) {
		return getSqlSession().selectOne("pjNeedsDao.searchArea", pj_id);
	}

	@Override
	public BudgetVO pjneeds_getPJ(String pj_id) {
		return getSqlSession().selectOne("pjNeedsDao.pjneeds_getPJ", pj_id);
	}

	@Override
	public List<PjNeedsVO> pjneeds_all(String pj_id) {
		return getSqlSession().selectList("pjNeedsDao.pjneeds_all", pj_id);
	}

	@Override
	public void pjneeds_merge(PjNeedsVO pjneedsVO) {
		getSqlSession().insert("pjNeedsDao.pjneeds_merge", pjneedsVO);
	}

	@Override
	public void pjneeds_resize(PjNeedsVO pjneedsVO) {
		getSqlSession().delete("pjNeedsDao.pjneeds_resize", pjneedsVO);
	}

}
