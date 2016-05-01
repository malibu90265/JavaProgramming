package com.sqisoft.iqs.pf.customer.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sqisoft.iqs.pf.customer.dao.CustomerDAO;
import com.sqisoft.iqs.pf.vo.CustomerVO;

public class CustomerDAOImpl extends SqlSessionDaoSupport implements CustomerDAO {

	@Override
	public List<CustomerVO> getCustomerList() {
		return getSqlSession().selectList("customerDAO.getCustomerList");
	}

	@Override
	public List<CustomerVO> customerSearchCont() {
		return getSqlSession().selectList("customerDAO.customerSearchCont");
	}

	@Override
	public void insertCustomer(CustomerVO vo) {
		getSqlSession().insert("customerDAO.insertCustomer", vo);
	}

	@Override
	public List<CustomerVO> customerSearchList(CustomerVO vo) {
		return getSqlSession().selectList("customerDAO.customerSearchList", vo);
	}

	@Override
	public CustomerVO getCustomer(CustomerVO vo) {
		return getSqlSession().selectOne("customerDAO.getCustomer", vo);
	}

	@Override
	public void customerUpdate(CustomerVO vo) {
		getSqlSession().update("customerDAO.customerUpdate", vo);
	}

	@Override
	public void deleteCustomer(CustomerVO vo) {
		getSqlSession().delete("customerDAO.deleteCustomer", vo);
	}

}
