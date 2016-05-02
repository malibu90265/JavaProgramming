package com.sqisoft.iqs.hr.pj.needs.controller;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sqisoft.iqs.hr.pj.needs.service.PjNeedsService;
import com.sqisoft.iqs.hr.vo.BudgetVO;
import com.sqisoft.iqs.hr.vo.PjNeedsVO;

// 인력소요_인력요구조건 컨트롤러

@Controller
public class PjNeedsController {
	
	private PjNeedsService pjnService;
	
	public void setPjnService(PjNeedsService pjnService) {
		this.pjnService = pjnService;
	}

	@RequestMapping("/Pjneeds.do")
	public String pjNeeds(HttpServletRequest req) throws Exception
	{
		String pj_id = req.getParameter("pj_id");
		String nextPage="";
		
		if(pj_id==null){
			nextPage="pjneeds";
		}
		
		
		return nextPage;
		
	}
	
	@RequestMapping("/Pjneeds_Insert.action")
	public @ResponseBody Map<String, Object> pjneeds_Insert( HttpServletRequest req, @ModelAttribute PjNeedsVO vo, @RequestParam(value="list") String list) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PjNeedsVO>>() {}.getType();
		
		List<PjNeedsVO> needList = gson.fromJson(list, listType);
		
		for(PjNeedsVO pjVo : needList){
			pjnService.pjneeds_merge(pjVo);
		}
		
		pjnService.pjneeds_resize(vo);
		
		return result;
	}
	
	
	@RequestMapping("Pjneeds_Search")
	public @ResponseBody Map<String, Object> pjneeds_Search( @RequestParam("searchid") String searchid,
										@RequestParam("search_team") String search_team, 
										@RequestParam("searchprog") String searchprog) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<BudgetVO> budgetVO = pjnService.pj_SearchList(searchid, search_team, searchprog);
		
		result.put("budgetVO", budgetVO);
		
		return result;
	}
	
	// 추가
	
	@RequestMapping("/deployRequirements")
	public ModelAndView deployRequirementsPage() {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/test/deployRequirements");
		
		return view;
		
	}
	
	@RequestMapping("/getDeployRequirementsListAjax")
	public ModelAndView getDeployRequirementsListAjax() {
		
		ModelAndView view = new ModelAndView();
		
		List<BudgetVO> budgetVO = pjnService.pj_SearchList("", "al", "");
		
		view.setViewName("/test/deployRequirementsList");
		view.addObject("budgetVO", budgetVO);
		
		return view;
		
	}
	
	@RequestMapping("/getDeployRequirementsDetailFormAjax")
	public ModelAndView getDeployRequirementsDetailFormAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		// id를 가지고 data를 뽑을 로직
		BudgetVO budgetVO = pjnService.pj_Datail(pjId);

		view.setViewName("/test/deployRequirementsDetailForm");
		view.addObject("budgetVO", budgetVO);
		
		return view;
		
	}
	

	@RequestMapping("/getDeployRequirementsModifyFormAjax")
	public ModelAndView getDeployRequirementsModifyFormAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		// id를 가지고 data를 뽑을 로직
		BudgetVO budgetVO = pjnService.pj_Modify(pjId);

		view.setViewName("/test/deployRequirementsModifyForm");
		view.addObject("budgetVO", budgetVO);
		
		return view;
		
	}
	
	@RequestMapping("/getDeployRequirementsConditionsAjax")
	public ModelAndView getDeployRequirementsConditionsAjax(HttpServletRequest request) {
		
		String requirePerson = request.getParameter("requirePerson");
		String pjId = request.getParameter("pjId");
		
		return pjnService.pjneedsReqCon(pjId, requirePerson); 

	}
	
	
	
	@RequestMapping("/getDeployRequirementsInsertFormAjax")
	public ModelAndView getDeployRequirementsInsertFormAjax() {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/test/deployRequirementsInsertForm");
		
		return view;
		
	}
	
	
	/*@RequestMapping("/getDeployRequirementsDeleteAjax")
	public ModelAndView getDeployRequirementsDeleteAjax() {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/test/deployRequirementsList");
		
		return view;
		
	}*/
	
	@RequestMapping("Pjneeds_DetailList")
	public @ResponseBody Map<String, Object>  pjneeds_getPJ (HttpServletRequest req) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		String pj_id = req.getParameter("pj_id");
		
		BudgetVO budgetVO = pjnService.pjneeds_getPJ(pj_id);
		List<PjNeedsVO> pjneedsVO = pjnService.pjneeds_all(pj_id);
		
		result.put("budgetVO", budgetVO);
		result.put("pjneedsVO", pjneedsVO);
		
		return result;
	}
}


