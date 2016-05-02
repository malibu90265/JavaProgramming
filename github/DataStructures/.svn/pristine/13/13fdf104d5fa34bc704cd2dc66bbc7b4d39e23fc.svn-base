package com.sqisoft.iqs.pf.customer.service.impl;

import java.util.List;

import com.sqisoft.iqs.pf.customer.dao.CustomerDAO;
import com.sqisoft.iqs.pf.customer.service.CustomerService;
import com.sqisoft.iqs.pf.vo.CustomerVO;

public class CustomerServiceImpl implements CustomerService{

	CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public List<CustomerVO> getCustomerList() {
		return customerDAO.getCustomerList();
	}
	
	@Override
	public List<CustomerVO> customerSearch() {
		List<CustomerVO> list=customerDAO.customerSearchCont();
		return list;
	}
	
	@Override
	public void insertCustomer(CustomerVO vo) {
		customerDAO.insertCustomer(vo);		
	}
	
	@Override
	public List<CustomerVO> customerSearch(CustomerVO vo) {
		return customerDAO.customerSearchList(vo);
	}
	
	@Override
	public CustomerVO getCustomer(CustomerVO vo) {
		System.out.println(vo);
		return customerDAO.getCustomer(vo);
	}
	
	@Override
	public void customerUpdate(CustomerVO vo) {
		customerDAO.customerUpdate(vo);
	}
	
	@Override
	public void deleteCustomer(CustomerVO vo) {
		customerDAO.deleteCustomer(vo);
	}

}
