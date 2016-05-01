package com.sqisoft.iqs.admin.basicinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.basicinfo.service.BasicInfoService;
import com.sqisoft.iqs.admin.basicinfo.vo.BasicSelectBox;
import com.sqisoft.iqs.admin.basicinfo.vo.DomainVO;
import com.sqisoft.iqs.admin.basicinfo.vo.JobSkillVO;
import com.sqisoft.iqs.admin.basicinfo.vo.RoleVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.project.service.ProjectService;
import com.sqisoft.iqs.project.vo.ProjectStageVO;
import com.sqisoft.iqs.project.vo.ProjectStatusVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class BasicInfoController {

	private BasicInfoService basicInfoService;
	
	private ProjectService projectService;

	public void setBasicInfoService(BasicInfoService basicInfoService) {
		this.basicInfoService = basicInfoService;
	}
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	// 전체 Main
	@RequestMapping("/admin/basicInfo/main")
	public ModelAndView basicInfoMainPage(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			view.setViewName("common/loginErrorPage");
		}
		else {
			Map<String, String> selectBoxItemsInfoMap = BasicSelectBox.getSelectBoxItems();
			
			view.addObject("selectBoxItems", selectBoxItemsInfoMap);
			view.setViewName("admin/basicInfo/main");
		}
		
		return view;
	}
	
	// 기술환경
	@RequestMapping("/admin/basicInfo/getSkillEnvMainPageAjax")
	public String getSkillEnvMainPageAjax() {
		return "admin/basicInfo/skillEnv/main";
	}
	
	@RequestMapping("/admin/basicInfo/getSkillEnvSearchPageAjax")
	public ModelAndView getSkillEnvSearchPageAjax(HttpServletRequest request) {
		String skillEnvDivision = request.getParameter("skillEnvDivision");
		
		List<String> skillEnvList = this.basicInfoService.getSkillEnvDivisionList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("skillEnvList", skillEnvList);
		view.addObject("skillEnvDivision", skillEnvDivision);
		view.setViewName("admin/basicInfo/skillEnv/searchPage");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getSkillEnvListPageAjax")
	public ModelAndView getSkillEnvListPageAjax(HttpServletRequest request) {
		String skillEnvDivision = request.getParameter("skillEnvDivision");
		
		List<Skill_envVO> skillEnvList = this.basicInfoService.getSkillEnvListByDivision(skillEnvDivision);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("skillEnvList", skillEnvList);
		view.setViewName("admin/basicInfo/skillEnv/list");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getSkillEnvInsertPageAjax")
	public ModelAndView getSkillEnvInsertPageAjax(HttpServletRequest request) {
		String skillEnvDivision = request.getParameter("skillEnvDivision");
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("skillEnvDivision", skillEnvDivision);
		view.setViewName("admin/basicInfo/skillEnv/insertForm");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/insertSkillEnvAjax")
	@ResponseBody
	public Map<String, Object> insertSkillEnvAjax(Skill_envVO skillEnv) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean result = this.basicInfoService.isSkillEnv(skillEnv.getEnvironment_division(), skillEnv.getEach_environment());
		if(result) {
			String message = "해당 분류에 같은 환경이 이미 존재합니다.";
			resultMap.put("message", message);
		} else {
			this.basicInfoService.insertSkillEnv(skillEnv);
			
			resultMap.put("skillEnvDivision", skillEnv.getEnvironment_division());
			resultMap.put("skillEnvironment", skillEnv.getEach_environment());
		}
		
		resultMap.put("result", !result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/modifySkillEnvAjax")
	@ResponseBody
	public Map<String, Object> modifySkillEnvAjax(HttpServletRequest request) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String business_division_origin = request.getParameter("business_division_origin"); 
		String each_skill_origin = request.getParameter("each_skill_origin");
		String business_division_modify = request.getParameter("business_division_modify"); 
		String each_skill_modify = request.getParameter("each_skill_modify");
		
		if(business_division_origin.equals(business_division_modify) && each_skill_origin.equals(each_skill_modify)) {
			resultMap.put("result", false);
			return resultMap;
		}
		
		boolean result = this.basicInfoService.isSkillEnv(business_division_modify, each_skill_modify);
		if(result) {
			String message = "해당 분류에 같은 환경이 이미 존재합니다.";
			resultMap.put("message", message);
		} else {
			this.basicInfoService.modifySkillEnv(business_division_origin, each_skill_origin, business_division_modify, each_skill_modify);
			
			resultMap.put("skillEnvDivision", business_division_modify);
			resultMap.put("skillEnvironment", each_skill_modify);
		}
		
		resultMap.put("result", !result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/getSkillEnvModifyPageAjax")
	public ModelAndView getSkillEnvModifyPageAjax(HttpServletRequest request) {
		String skillEnvDivision = request.getParameter("skillEnvDivision");
		String skillEnvironment = request.getParameter("skillEnvironment");
		
		Skill_envVO skillEnv = this.basicInfoService.getSkillEnv(skillEnvDivision, skillEnvironment);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("skillEnv", skillEnv);
		view.setViewName("admin/basicInfo/skillEnv/modifyForm");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/deleteSkillEnvAjax")
	@ResponseBody
	public Map<String, String> deleteSkillEnvAjax(Skill_envVO skillEnv) {
		
		this.basicInfoService.deleteSkillEnv(skillEnv);
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("skillEnvDivision", skillEnv.getEnvironment_division());
		
		return result;
	}
	
	
	// 직무기술
	@RequestMapping("/admin/basicInfo/getJobSkillMainPageAjax")
	public String getJobSkillMainPageAjax() {
		return "admin/basicInfo/jobSkill/main";
	}
	
	@RequestMapping("/admin/basicInfo/getJobSkillSearchPageAjax")
	public ModelAndView getJobSkillSearchPageAjax(HttpServletRequest request) {
		String jobSkillDivision = request.getParameter("jobSkillDivision");
		
		List<String> jobSkillList = this.basicInfoService.getJobSkillList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("jobSkillList", jobSkillList);
		view.addObject("jobSkillDivision", jobSkillDivision);
		view.setViewName("admin/basicInfo/jobSkill/searchPage");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getJobSkillListPageAjax")
	public ModelAndView getJobSkillListPageAjax(HttpServletRequest request) {
		String jobSkillDivision = request.getParameter("jobSkillDivision");
		
		List<JobSkillVO> jobSkillList = this.basicInfoService.getJobSkillListByDivision(jobSkillDivision);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("jobSkillList", jobSkillList);
		view.setViewName("admin/basicInfo/jobSkill/list");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getJobSkillInsertPageAjax")
	public ModelAndView getJobSkillInsertPageAjax(HttpServletRequest request) {
		String jobSkillDivision = request.getParameter("jobSkillDivision");
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("jobSkillDivision", jobSkillDivision);
		view.setViewName("admin/basicInfo/jobSkill/insertForm");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/insertJobSkillAjax")
	@ResponseBody
	public Map<String, Object> insertJobSkillAjax(JobSkillVO jobSkillVO) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean result = this.basicInfoService.isJobSkill(jobSkillVO.getBusiness_division(), jobSkillVO.getEach_skill());
		if(result) {
			String message = "해당 직무에 같은 기술이 이미 존재합니다.";
			resultMap.put("message", message);
		} else {
			this.basicInfoService.insertJobSkill(jobSkillVO);
			
			resultMap.put("jobSkillDivision", jobSkillVO.getBusiness_division());
			resultMap.put("jobSkill", jobSkillVO.getEach_skill());
		}
		
		resultMap.put("result", !result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/modifyJobSkillAjax")
	@ResponseBody
	public Map<String, Object> modifyJobSkillAjax(HttpServletRequest request) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String business_division_origin = request.getParameter("business_division_origin"); 
		String each_skill_origin = request.getParameter("each_skill_origin");
		String business_division_modify = request.getParameter("business_division_modify"); 
		String each_skill_modify = request.getParameter("each_skill_modify");
		
		if(business_division_origin.equals(business_division_modify) && each_skill_origin.equals(each_skill_modify)) {
			resultMap.put("result", false);
			return resultMap;
		}
		
		boolean result = this.basicInfoService.isJobSkill(business_division_modify, each_skill_modify);
		if(result) {
			String message = "해당 직무에 같은 기술이 이미 존재합니다.";
			resultMap.put("message", message);
		} else {
			this.basicInfoService.modifyJobSkill(business_division_origin, each_skill_origin, business_division_modify, each_skill_modify);
			
			resultMap.put("jobSkillDivision", business_division_modify);
			resultMap.put("jobSkill", each_skill_modify);
		}
		
		resultMap.put("result", !result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/getJobSkillModifyPageAjax")
	public ModelAndView getJobSkillModifyPageAjax(HttpServletRequest request) {
		String jobSkillDivision = request.getParameter("jobSkillDivision");
		String jobSkill = request.getParameter("jobSkill");
		
		JobSkillVO jobSkillVO = this.basicInfoService.getJobSkill(jobSkillDivision, jobSkill);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("jobSkill", jobSkillVO);
		view.setViewName("admin/basicInfo/jobSkill/modifyForm");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/deleteJobSkillAjax")
	@ResponseBody
	public Map<String, String> deleteJobSkillAjax(JobSkillVO jobSkillVO) {
		
		this.basicInfoService.deleteJobSkill(jobSkillVO);
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("jobSkillDivision", jobSkillVO.getBusiness_division());
		
		return result;
	}
	
	// 업무분류
	@RequestMapping("/admin/basicInfo/getDomainMainPageAjax")
	public String getDomainMainPageAjax() {
		return "admin/basicInfo/domain/main";
	}
	
	@RequestMapping("/admin/basicInfo/getDomainListAjax")
	public ModelAndView getDomainListAjax(){
		ModelAndView view = new ModelAndView();
		
		List<DomainVO> domainVO = this.basicInfoService.getDomainList();
		view.addObject("domainVO",domainVO);
		view.setViewName("admin/basicInfo/domain/list");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getDomainModifyPageAjax")
	public String getDomainModifyPageAjax(){
		return "admin/basicInfo/domain/modifyForm";
	}
	
	@RequestMapping("/admin/basicInfo/getDomainInsertPageAjax")
	public ModelAndView getDomainInsertPageAjax(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/basicInfo/domain/insertForm");
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getDomainModifyInsertPageAjax")
	public ModelAndView getDomainModifyInsertPageAjax(int domain_Id){
		ModelAndView view = new ModelAndView();
		view.addObject("domain_id", domain_Id);
		view.setViewName("admin/basicInfo/domain/modifyForm");
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/insertDomainAjax")
	@ResponseBody
	public  Map<String, Object> insertDomainAjax(String each_domain){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean result = this.basicInfoService.isDoamin(each_domain);
		if(result) {
			String message = "해당 분류에 같은 환경이 이미 존재합니다.";
			resultMap.put("message", message);
		} else {
			this.basicInfoService.insertDomain(each_domain);
			String message = "해당 분류에 " +each_domain+"가 생성되었습니다.";
			
			resultMap.put("each_domain", each_domain);
			resultMap.put("message", message);
		}
		
		resultMap.put("result", !result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/modifyDomainAjax")
	@ResponseBody
	public Map<String, Object> modifyDomainAjax(DomainVO domainVO) {
	Map<String, Object> resultMap = new HashMap<String, Object>();
	boolean result = this.basicInfoService.isDoamin(domainVO.getEach_domain());
	
	if(result) {
		String message = "해당 분류에 같은 환경이 이미 존재합니다.";
		resultMap.put("message", message);
	}  else {
		this.basicInfoService.modifyDomain(domainVO);
		String message = "해당 분류에 " +domainVO.getEach_domain()+"로 수정되었습니다.";
		
		resultMap.put("message", message);
		resultMap.put("each_domain", domainVO.getEach_domain());
	}
	
	resultMap.put("result", !result);
	
	return resultMap;
	}	
	
	@RequestMapping("/admin/basicInfo/deleteDomainAjax")
	@ResponseBody
	public void deleteDomainAjax(String each_domain) {
		this.basicInfoService.deleteDomain(each_domain);
	}
	
	// 역할분류
	@RequestMapping("/admin/basicInfo/getRoleMainPageAjax")
	public String getRoleMainPageAjax(){
		return "admin/basicInfo/role/main";
	}
	
	@RequestMapping("/admin/basicInfo/getRoleListAjax")
	public ModelAndView getRoleListAjax() {
		ModelAndView view = new ModelAndView();
		
		List<RoleVO> roleList = this.basicInfoService.getRoleList();
		
		view.addObject("roleList", roleList);
		view.setViewName("admin/basicInfo/role/list");
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getRoleInsertPageAjax")
	public ModelAndView getRoleInsertPageAjax() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("admin/basicInfo/role/insertForm");
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getRoleModifyPageAjax")
	public ModelAndView getRoleModifyPageAjax() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("admin/basicInfo/role/modifyForm");
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/checkDuplicateYN")
	@ResponseBody
	public Map<String, Object> checkDuplicateYN(String each_role){
		return this.basicInfoService.checkDuplicateYN(each_role);
	}
	
	@RequestMapping("/admin/basicInfo/insertRoleAjax")
	@ResponseBody
	public Map<String, String> insertRoleAjax(String each_role){
		return this.basicInfoService.insertRoleAjax(each_role);
	}
	
	@RequestMapping("/admin/basicInfo/modifyRoleAjax")
	@ResponseBody
	public Map<String, Object> modifyRoleAjax(RoleVO roleVO){
		return this.basicInfoService.modifyRoleAjax(roleVO);
	}
	
	@RequestMapping("/admin/basicInfo/deleteRoleAjax")
	@ResponseBody
	public Map<String, Object> deleteRoleAjax(RoleVO roleVO){
		return this.basicInfoService.deleteRoleAjax(roleVO);
	}
	
	
	// 영업단계
	@RequestMapping("/admin/basicInfo/getPjStageMainPageAjax")
	public String getPjStageMainPageAjax() {
		return "admin/basicInfo/pjStage/main";
	}
	
	@RequestMapping("/admin/basicInfo/getPjStagePageAjax")
	public ModelAndView getPjStagePageAjax() {
		
		List<ProjectStageVO> pjStageList = this.basicInfoService.getAllPjStageList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("pjStageList", pjStageList);
		view.setViewName("admin/basicInfo/pjStage/list");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getPjStageInsertPageAjax")
	public ModelAndView getPjStageInsertPageAjax() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/basicInfo/pjStage/insertForm");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/insertPjStageAjax")
	@ResponseBody
	public Map<String, Object> insertPjStageAjax(String pj_stage_name) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean result = this.basicInfoService.isPjStage(pj_stage_name);
		
		String message = "";
		if(result) {
			message = "해당 분류에 같은 영업단계가 이미 존재합니다.";
		} else {
			boolean isSuccess = this.basicInfoService.insertPjStage(pj_stage_name);
			if(isSuccess) {
				message = "영업단계 " + pj_stage_name + " 가 생성되었습니다.";
			}
			else {
				message = "영업단계 " + pj_stage_name + " 생성에 실패하였습니다.";
			}
		}
		
		resultMap.put("message", message);
		resultMap.put("pj_stage_name", pj_stage_name);
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/getPjStageModifyPageAjax")
	public String getPjStageModifyPageAjax() {
		return "admin/basicInfo/pjStage/modifyForm";
	}
	
	@RequestMapping("/admin/basicInfo/modifyPjStageAjax")
	@ResponseBody
	public Map<String, Object> modifyPjStageAjax(ProjectStageVO projectStageVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String pj_stage_name = projectStageVO.getPj_stage_name();
		boolean result = this.basicInfoService.isPjStage(pj_stage_name);
		
		String message = "";
		if(result) {
			message = "중복되는 이름의 영업단계입니다.";
		}
		else {
			boolean isSuccess = this.basicInfoService.modifyPjStage(projectStageVO);
			
			if(isSuccess) {
				message = "영업단계 " + pj_stage_name + "(으)로 수정되었습니다.";
			}
			else {
				message = "영업단계 " + pj_stage_name + " 수정에 실패하였습니다.";
			}
		}
		
		resultMap.put("message", message);
		resultMap.put("pj_stage_id",projectStageVO.getPj_stage_id());
		resultMap.put("pj_stage_name",pj_stage_name);
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/deletePjStageAjax")
	@ResponseBody
	public Map<String, String> deletePjStageAjax (String pj_stage_id) {
		Map<String, String> resultMap = new HashMap<String, String>();
		
		boolean isSuccess = this.basicInfoService.deletePjStageAjax(pj_stage_id); 
		
		String message = "";
		if(isSuccess) {
			message = "삭제되었습니다.";
		}
		else {
			message = "삭제에 실패하였습니다.";
		}
		resultMap.put("message", message);
		return resultMap;
	}
	
	// 추진상태
	@RequestMapping("/admin/basicInfo/getPjStatusMainPageAjax")
	public String getPjStatusMainPageAjax() {
		return "admin/basicInfo/pjStatus/main";
	}
	
	@RequestMapping("/admin/basicInfo/getPjStatusListPageAjax")
	public ModelAndView getPjStatusListPageAjax(HttpServletRequest request) {
		List<ProjectStatusVO> pjStatusList = this.projectService.getProjectStatusList();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("pjStatusList", pjStatusList);
		view.setViewName("admin/basicInfo/pjStatus/list");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/getPjStatusInsertPageAjax")
	public String getPjStatusInsertPageAjax() {
		return "admin/basicInfo/pjStatus/insertForm";
	}
	
	@RequestMapping("/admin/basicInfo/insertPjStatusAjax")
	@ResponseBody
	public Map<String, Object> insertPjStatusAjax(ProjectStatusVO projectStatusVO) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean result = this.basicInfoService.isProjectStatus(projectStatusVO.getPj_status_name());
		if(result) {
			String message = "같은 이름의 추진상태가 있습니다.";
			resultMap.put("message", message);
		} else {
			this.basicInfoService.insertPjStatus(projectStatusVO);
			
			resultMap.put("pj_status_id", projectStatusVO.getPj_status_id());
		}
		
		resultMap.put("result", !result);
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/modifyPjStatusAjax")
	@ResponseBody
	public Map<String, Object> modifyPjStatusAjax(ProjectStatusVO projectStatusVO) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		ProjectStatusVO originStatus = this.basicInfoService.getProjectStatusById(projectStatusVO.getPj_status_id());
		
		if(originStatus.getPj_status_name().equals(projectStatusVO.getPj_status_name()) 
				&& originStatus.getPj_status_color().equals(projectStatusVO.getPj_status_color())) {
			resultMap.put("result", false);
			return resultMap;
		}
		
		boolean result = this.basicInfoService.isProjectStatus(projectStatusVO.getPj_status_name());
		if(result && originStatus.getPj_status_color().equals(projectStatusVO.getPj_status_color())) {
			String message = "같은 이름의 추진상태가 있습니다.";
			resultMap.put("message", message);
			resultMap.put("result", false);
		} else {
			this.basicInfoService.modifyProjectStatus(projectStatusVO);
			
			resultMap.put("pj_status_id", projectStatusVO.getPj_status_id());
			resultMap.put("result", true);
		}
		
		return resultMap;
	}
	
	@RequestMapping("/admin/basicInfo/getPjStatusModifyPageAjax")
	public ModelAndView getPjStatusModifyPageAjax(HttpServletRequest request) {
		int pj_status_id = Integer.parseInt(request.getParameter("pj_status_id"));
		
		ProjectStatusVO projectStatus = this.basicInfoService.getProjectStatusById(pj_status_id);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("projectStatus", projectStatus);
		view.setViewName("admin/basicInfo/pjStatus/modifyForm");
		
		return view;
	}
	
	@RequestMapping("/admin/basicInfo/deletePjStatusAjax")
	@ResponseBody
	public void deletePjStatusAjax(HttpServletRequest request) {
		
		int pj_status_id = Integer.parseInt(request.getParameter("pj_status_id"));
		
		this.basicInfoService.deletePjStatus(pj_status_id);
	}
	
}
