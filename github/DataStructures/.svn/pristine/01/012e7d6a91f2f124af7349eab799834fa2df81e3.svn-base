package com.sqisoft.iqs.humanResource.empStandBy.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.humanResource.empStandBy.dao.EmpStandByDAO;
import com.sqisoft.iqs.humanResource.empStandBy.vo.EmpStandByVO;

public class EmpStandByDAOImpl extends SqlSessionDaoSupport implements EmpStandByDAO{
	
	@Override
	public List<EmpStandByVO> getEmpStandByTeamList(String tm_id) {
		return getSqlSession().selectList("empStandByDAO.getEmpStandByTeamList",tm_id);
	}
	
}
