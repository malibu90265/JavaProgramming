package com.sqisoft.iqs.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.demo.util.ConditionUtils;
import com.sqisoft.iqs.demo.vo.DeployRequirementsConditionVO;
import com.sqisoft.iqs.demo.vo.DeployRequirementsVO;
import com.sqisoft.iqs.demo.vo.TestStore;

@Controller
public class DemoController {
	
	@RequestMapping("/demo/deployRequirements")
	public String demoDeployRequirementsPage() {
		return "/demo/deployRequirements";
	}
	
	@RequestMapping("/demo/getSearchPage")
	public String getSearchPageAjax() {
		return "/demo/deployRequirementsSearch";
	}
	
	@RequestMapping("/demo/getDeployRequirementsListAjax")
	public ModelAndView getDeployRequirementsListAjax() {
		
		ModelAndView view = new ModelAndView();
		
		TestStore test = TestStore.getInstance();
		List<DeployRequirementsVO> deployReqList = new ArrayList<DeployRequirementsVO>();
		deployReqList = test.getAllDeployRequirements();
		
		view.addObject("deployRequirementsList", deployReqList);
		view.setViewName("/demo/deployRequirementsList");
		
		return view;
		
	}
	
	@RequestMapping("/demo/getDeployRequirementsConditionsAjax")
	public ModelAndView getDeployRequirementsConditionsAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String requirePerson = request.getParameter("requirePerson");
		if(requirePerson == null || requirePerson.equals("")) requirePerson = "0";
		
		Map<String, String> defaultRanks = ConditionUtils.getDefaultRanks();
		Map<String, String> defaultSkills = ConditionUtils.getDefaultSkills();
		
		view.addObject("defaultRanks", defaultRanks);
		view.addObject("defaultSkills", defaultSkills);
		view.addObject("requirePerson", Integer.parseInt(requirePerson));
		view.setViewName("/demo/deployRequirementsConditions");
		
		return view;
	}
	
	@RequestMapping("/demo/getDeployRequirementsConditionsDetailAjax")
	public ModelAndView getDeployRequirementsConditionsDetailAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		TestStore dataStore = TestStore.getInstance();
		DeployRequirementsVO deployRequirementsVO = dataStore.getDeployRequirements(pjId);
		List<DeployRequirementsConditionVO> conditions = deployRequirementsVO.getDeployRequirementsList();
		
		view.addObject("conditions", conditions);
		view.setViewName("/demo/deployRequirementsConditionsDetail");
		
		return view;
	}
	
	@RequestMapping("/demo/getDeployRequirementsConditionsModifyAjax")
	public ModelAndView getDeployRequirementsConditionsModifyAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		TestStore dataStore = TestStore.getInstance();
		DeployRequirementsVO deployRequirementsVO = dataStore.getDeployRequirements(pjId);
		List<DeployRequirementsConditionVO> conditions = deployRequirementsVO.getDeployRequirementsList();
		
		Map<String, String> defaultRanks = ConditionUtils.getDefaultRanks();
		Map<String, String> defaultSkills = ConditionUtils.getDefaultSkills();
		
		view.addObject("conditions", conditions);
		view.addObject("defaultRanks", defaultRanks);
		view.addObject("defaultSkills", defaultSkills);
		view.setViewName("/demo/deployRequirementsConditionsModify");
		
		return view;
	}
	
	@RequestMapping("/demo/getDeployRequirementsInsertFormAjax")
	public String getDeployRequirementsInsertFormAjax() {
		return "/demo/deployRequirementsInsertForm";
	}
	
	@RequestMapping("/demo/getDeployRequirementsInsertFormAjax2")
	public String getDeployRequirementsInsertFormAjax2() {
		return "/demo/deployRequirementsInsertForm2";
	}
	
	@RequestMapping("/demo/insertDeployRequirementsAjax")
	@ResponseBody
	public Map<String, Boolean> insertDeployRequirementsAjax(DeployRequirementsVO deployRequirements) {
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		if(deployRequirements != null) {
			boolean flag = false;
			List<String> ranks = deployRequirements.getRanks();
			if(ranks != null) {
				flag = true;
			} else System.out.println("rank null");
			List<String> skills = deployRequirements.getSkills();
			if(skills != null) {
				flag = true;
			} else System.out.println("skill null");
			flag = (ranks.size() == skills.size());
			if(flag) {
				List<DeployRequirementsConditionVO> conditions = new ArrayList<DeployRequirementsConditionVO>();
				DeployRequirementsConditionVO condition = null;
				for(int i = 0; i < ranks.size(); i++) {
					condition = new DeployRequirementsConditionVO();
					condition.setRank(ranks.get(i));
					condition.setProfessionalSkill(skills.get(i));
					
					conditions.add(condition);
				}
				deployRequirements.setDeployRequirementsList(conditions);
			}
			
			TestStore dataStore = TestStore.getInstance();
			dataStore.putDeployRequirements(deployRequirements.getPjId(), deployRequirements);
			
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		
		return result;
	}
	
	@RequestMapping("/demo/saveDeployRequirementsAjax")
	@ResponseBody
	public Map<String, Object> saveDeployRequirementsAjax(DeployRequirementsVO deployRequirements) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(deployRequirements != null) {
			boolean flag = false;
			List<String> ranks = deployRequirements.getRanks();
			if(ranks != null) {
				flag = true;
			}
			List<String> skills = deployRequirements.getSkills();
			if(skills != null) {
				flag = true;
			}
			flag = (ranks.size() == skills.size());
			if(flag) {
				List<DeployRequirementsConditionVO> conditions = new ArrayList<DeployRequirementsConditionVO>();
				DeployRequirementsConditionVO condition = null;
				for(int i = 0; i < ranks.size(); i++) {
					condition = new DeployRequirementsConditionVO();
					condition.setRank(ranks.get(i));
					condition.setProfessionalSkill(skills.get(i));
					
					conditions.add(condition);
				}
				deployRequirements.setDeployRequirementsList(conditions);
			}
			
			TestStore dataStore = TestStore.getInstance();
			dataStore.putDeployRequirements(deployRequirements.getPjId(), deployRequirements);
			
			result.put("result", true);
			result.put("pjId", deployRequirements.getPjId());
		} else {
			result.put("result", false);
		}
		
		return result;
	} 
	
	@RequestMapping("/demo/getDeployRequirementsDetailFormAjax")
	public ModelAndView getDeployRequirementsDetailFormAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		// id를 가지고 data를 뽑을 로직
		TestStore dataStore = TestStore.getInstance();
		DeployRequirementsVO deployRequirements = dataStore.getDeployRequirements(pjId);
		for(DeployRequirementsConditionVO deployRequirementsConditionVO : deployRequirements.getDeployRequirementsList()) {
			deployRequirementsConditionVO.getRank();
		}
		
		view.setViewName("/demo/deployRequirementsDetailForm");
		view.addObject("deployRequirements", deployRequirements);
		List<DeployRequirementsConditionVO> conditions = deployRequirements.getDeployRequirementsList(); 
		view.addObject("conditions", conditions);
		
		return view;
		
	}
	
	@RequestMapping("/demo/getDeployRequirementsModifyFormAjax")
	public ModelAndView getDeployRequirementsModifyFormAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		TestStore store = TestStore.getInstance();
		DeployRequirementsVO deRequirementsVO = store.getDeployRequirements(pjId);
		
		view.setViewName("/demo/deployRequirementsModifyForm");
		view.addObject("deployRequirements", deRequirementsVO);
		
		return view;
		
	}
	
	@RequestMapping("/demo/getDeployRequirementsModifyFormAjax2")
	public ModelAndView getDeployRequirementsModifyFormAjax2(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		String pjId = request.getParameter("pjId");
		
		TestStore store = TestStore.getInstance();
		DeployRequirementsVO deRequirementsVO = store.getDeployRequirements(pjId);
		
		view.setViewName("/demo/deployRequirementsModifyForm2");
		view.addObject("deployRequirements", deRequirementsVO);
		
		return view;
		
	}
	
	@RequestMapping("/demo/getDeployRequirementsDeleteAjax")
	@ResponseBody
	public Map<String, Boolean> getDeployRequirementsDeleteAjax(HttpServletRequest request) {
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		String pjId = request.getParameter("pjId");
		System.out.println("pjId: "+pjId);
		
		TestStore dataStore = TestStore.getInstance();
		dataStore.removeDeployRequirements(pjId);
		
		result.put("result", true);
		
		return result;
	}
}
