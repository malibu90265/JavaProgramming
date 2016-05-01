package com.sqisoft.iqs.pf.customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.pf.customer.service.CustomerService;
import com.sqisoft.iqs.pf.member.service.MemberService;
import com.sqisoft.iqs.pf.project.service.ProjectServiceIF;
import com.sqisoft.iqs.pf.schedule.service.WeekendServiceIF;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.CustomerVO;

@Controller("customerController")
public class CustomerController {

	private TeamServiceIF team_service;
	private MemberService memberService;
	private WeekendServiceIF weekend_service;
	private ProjectServiceIF project_service;
	private CustomerService customer_service;
	
	public void setTeam_service(TeamServiceIF team_service) {
		this.team_service = team_service;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public void setWeekend_service(WeekendServiceIF weekend_service) {
		this.weekend_service = weekend_service;
	}
	public void setProject_service(ProjectServiceIF project_service) {
		this.project_service = project_service;
	}
	public void setCustomer_service(CustomerService customer_service) {
		this.customer_service = customer_service;
	}

	@RequestMapping("test")
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test");
		return mav;	
	}
	
	@RequestMapping("customerSerch.do")
	public ModelAndView customerSerch(@RequestParam String obj){
		ModelAndView mav = new ModelAndView();
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		
		if(!obj.equals("emp_company"))
			list=customer_service.customerSearch();
		else
			list=customer_service.getCustomerList();
		
		mav.addObject("Obj",obj);
		mav.addObject("list",list);
		mav.setViewName("customerlist");
		
		return mav;	
	}
	
	@RequestMapping("customerReg.do")
	public ModelAndView customerReg(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("customerReg");
		return mav;
	}
	
	@RequestMapping("customerManager.do")
	public ModelAndView customerManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customerManager");
		return mav;	
	}
	
	@RequestMapping("customerSearch.action")
	public ModelAndView customerSearch(HttpServletRequest req){	
		ModelAndView mav = new ModelAndView();	
		String customer_div = req.getParameter("div");
		String customer_name = req.getParameter("name");
		int div;
		if(customer_div.equals("수주계약"))
			div=0;
		else if(customer_div.equals("외주업체"))
			div=1;
		else if(customer_div.equals("")){
			div=-1;
		}
		else
			div=2;
		
		CustomerVO vo=new CustomerVO(div,customer_name);
		List<CustomerVO> list=customer_service.customerSearch(vo);
		
		mav.addObject("list",list);
		mav.setViewName("JSON");
		return mav;
	}
	
	@RequestMapping("getCustomer.action")
	public ModelAndView getCustomer(@RequestParam String name,@RequestParam String div)	{
		ModelAndView mav = new ModelAndView();
		CustomerVO vo=new CustomerVO();
		
		int cusDiv=1;
		if(div.equals("수주계약")){
			cusDiv=0;
		}
		else if(div.equals("외주업체")){
			cusDiv=1;
		}else{
			cusDiv=2;
		}
		
		vo.setCustomer_div(cusDiv);
		vo.setH_name(name);
		CustomerVO result=customer_service.getCustomer(vo);
		
		mav.addObject("vo",result);
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping("/customerUpdate.action")
	public ModelAndView customerUpdate(@RequestParam String customer_name,
										@RequestParam String  customer_div,
										@RequestParam String customer_head,
										@RequestParam String customer_loc,
										@RequestParam String customer_regno,
										@RequestParam String customer_credit,
										@RequestParam String h_name,
										@RequestParam String etc){
		System.out.println("들어왔나");
		ModelAndView mav=new ModelAndView();
		CustomerVO vo
			= new CustomerVO(	Integer.parseInt(customer_div),customer_name,customer_credit
								,customer_regno,customer_head,customer_loc,etc);
		vo.setH_name(h_name);
		
		
		if(customer_service.getCustomer(vo)!=null){
			customer_service.customerUpdate(vo);
		}
		else{
			customer_service.insertCustomer(vo);
		}
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping("/customerDelete.action")
	public ModelAndView customerDelete(@RequestParam String customer_div,
										@RequestParam String h_name){
		ModelAndView mav=new ModelAndView();
		CustomerVO vo=new CustomerVO();
		vo.setCustomer_div(Integer.parseInt(customer_div));
		vo.setH_name(h_name);
		
		customer_service.deleteCustomer(vo);
		
		mav.setViewName("JSON");
		return mav;
	}
}
