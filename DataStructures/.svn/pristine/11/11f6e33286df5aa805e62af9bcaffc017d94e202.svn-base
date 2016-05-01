package com.sqisoft.iqs.humanResource.deployRequirements.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.humanResource.deployRequirements.service.DeployRequirementsService;
import com.sqisoft.iqs.humanResource.deployRequirements.vo.DeployRequirementsVO;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class DeployRequirementsController {
	
	private DeployRequirementsService deployRequirementsService;
	private HumanResourceService humanResourceService;
	
	public void setDeployRequirementsService( DeployRequirementsService deployRequirementsService) {
		this.deployRequirementsService = deployRequirementsService;
	}
	
	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}

	//배치소요 page mapping
	@RequestMapping("/deployRequirements/deployRequirements")
	public String deployRequirementsPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/deployRequirements/deployRequirements";
	}

	//selectBox에서 팀 종류 뿌려주기
	@RequestMapping("/deployRequirements/selectTeam")
	public ModelAndView getSelectTeam(){
		ModelAndView view = new ModelAndView();
		List<DeployRequirementsVO> searchTeamList = deployRequirementsService.getSearchTeamListAjax();
		
		view.addObject("searchTeamList", searchTeamList);
		view.setViewName("deployRequirements/deployRequirementsSearch");
		return view;
	}
	
	//팀별 프로젝트 검색
	@RequestMapping("/deployRequirements/searchTeamProject")
	public ModelAndView getSearchTeamProjectListAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		String tm_id = request.getParameter("tm_id");
		List<DeployRequirementsVO> searchTeamProjectList = deployRequirementsService.getSearchTeamProjectListAjax(tm_id);
		
		view.addObject("searchTeamProjectList", searchTeamProjectList);
		view.setViewName("deployRequirements/deployRequirementsList");
		return view;
	}
	
	//선택한 프로젝트의 정보를 출력
	@RequestMapping("/deployRequirements/getDeployRequirementsDetailForm")
	public ModelAndView getDeployRequirementsDetailForm(String pj_id, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturnMaSalPmHr(view, request);	//권한
		
		DeployRequirementsVO deployRequirementsDetailFormList 
			= deployRequirementsService.getDeployRequirementsDetailFormAjax(pj_id);
		
		view.addObject("deployRequirementsDetailFormList", deployRequirementsDetailFormList);
		view.setViewName("/deployRequirements/deployRequirementsDetail");
		return view;
	}
	
	@RequestMapping("/deployRequirements/getInsertPageAjax")
	public ModelAndView getInsertPageAjax(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		optionSelectForm(mav);
		int num = Integer.parseInt(request.getParameter("num"));
		String pj_id = request.getParameter("pj_id");
		
		List<DeployRequirementsVO> insertedRequired = deployRequirementsService.getDeployRequirementsInsertFormAjax(pj_id);
		List<String> rankOptions = deployRequirementsService.getRankOptions();
		DeployRequirementsVO vo = deployRequirementsService.getDeployRequirementsDetailFormAjax(pj_id);
		String pj_start_date = vo.getPj_start_date();
		String pj_end_date = vo.getPj_end_date();
		mav.addObject("num", num);
		mav.addObject("insertedRequired", insertedRequired);
		mav.addObject("count", insertedRequired.size());
		mav.addObject("rankOptions", rankOptions);
		mav.addObject("pj_start_date", pj_start_date);
		mav.addObject("pj_end_date", pj_end_date);
		mav.setViewName("/deployRequirements/deployRequirementsInsertForm");
		
		return mav;
	}
	
	private void optionSelectForm(ModelAndView view) {
		// 등급
		Map<String, String> gradeOptions = humanResourceService.getGradeOptions();
		// 직무기술
		Map<String, String> jobSkillOptions = humanResourceService.getJobSkillOptions();
		
		view.addObject("gradeOptions", gradeOptions);
		view.addObject("jobSkillOptions", jobSkillOptions);		
	}
	
	
	//배치예정자 입력시 해당 직원의 정보 가져오기
	@RequestMapping("/deployRequirements/getEmployeeInfo")
	@ResponseBody
	public Map<String, HumanResourceVO> getEmployeeInfo(HttpServletRequest request) {
		String pr_name = request.getParameter("pr_name");
		String pj_id = request.getParameter("pj_id");
		Map<String, String> map = new HashMap<String, String>();
		map.put("pr_name", pr_name);
		map.put("pj_id", pj_id);
		HumanResourceVO employeeInfoList = deployRequirementsService.getHrInfoByNameAjax(map);
		Map<String, HumanResourceVO> result = new HashMap<String, HumanResourceVO>();
		result.put("employeeInfoList", employeeInfoList);
		return result;
	}
	
	@RequestMapping("/deployRequirements/insertPjRequire")
	@ResponseBody
	public void insertPjRequire(HttpServletRequest request) {
		
		String pj_id = request.getParameter("pj_id");
		int pr_sq = Integer.parseInt(request.getParameter("pr_sq"));
		String pr_grade = request.getParameter("pr_grade");
		String pr_job_skill = request.getParameter("pr_job_skill");
		String pr_start_date = request.getParameter("pr_start_date");
		String pr_end_date = request.getParameter("pr_end_date");
		int pr_uprice = Integer.parseInt(request.getParameter("pr_uprice"));
		String pr_name = request.getParameter("pr_name");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pj_id", pj_id);
		map.put("pr_sq", pr_sq);
		map.put("pr_grade", pr_grade);
		map.put("pr_job_skill", pr_job_skill);
		map.put("pr_start_date", pr_start_date);
		map.put("pr_end_date", pr_end_date);
		map.put("pr_uprice", pr_uprice);
		map.put("pr_name", pr_name);
		
		deployRequirementsService.insertPjRequire(map);
	}
	
	@RequestMapping("/deployRequirements/deletePjRequireAfterInsert")
	@ResponseBody
	public void deletePjRequireAfterInsert(HttpServletRequest request) {
		String pj_id = request.getParameter("pj_id");
		int pr_sq = Integer.parseInt(request.getParameter("pr_sq"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pj_id", pj_id);
		map.put("pr_sq", pr_sq);
		
		deployRequirementsService.deletePjRequireAfterInsert(map);
	}
	
	@RequestMapping("/deployRequirements/deletePjRequire")
	@ResponseBody
	public void deletePjRequire(HttpServletRequest request) {
		String pj_id = request.getParameter("pj_id");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pj_id", pj_id);
		map.put("pr_sq", 0);
		
		deployRequirementsService.deletePjRequireAfterInsert(map);
	}
	
	@RequestMapping("/deployRequirements/checkNumAjax")
	@ResponseBody
	public int checkNumAjax(HttpServletRequest request) {
		String pj_id = request.getParameter("pj_id");
		int num = deployRequirementsService.checkNumAjax(pj_id);
		return num;
	}
	
	@RequestMapping("/deployRequirements/getDeployRequirementsMaxPrSq")
	@ResponseBody
	public int getDeployRequirementsMaxPrSq(HttpServletRequest request) {
		String pj_id = request.getParameter("pj_id");
		int num = deployRequirementsService.getDeployRequirementsMaxPrSq(pj_id);
		return num;
	}
	
}