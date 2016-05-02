package com.sqisoft.iqs.humanResource.employeeInput.controller;

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
import com.sqisoft.iqs.humanResource.employeeInput.service.EmployeeInputService;
import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TotalService;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class EmployeeInputController {
	private EmployeeInputService employeeInputService;
	private DeployRequirementsService deployRequirementsService;
	private HumanResourceService humanResourceService;
	private TotalService totalService;
	
	public void setTotalService(TotalService totalService) {
		this.totalService = totalService;
	}
	public void setEmployeeInputService(EmployeeInputService employeeInputService) {
		this.employeeInputService = employeeInputService;
	}
	public void setDeployRequirementsService(DeployRequirementsService deployRequirementsService) {
		this.deployRequirementsService = deployRequirementsService;
	}
	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}
	
	//인력투입 page mapping
	@RequestMapping("/employeeInput/employeeInput")
	public String employeeInputPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/employeeInput/employeeInput";
	}

	// selectBox에서 팀 종류 뿌려주기
	@RequestMapping("/employeeInput/selectTeam")
	public ModelAndView getSelectTeam() {
		ModelAndView view = new ModelAndView();
		List<EmployeeInputVO> searchTeamList = employeeInputService.getSearchTeamListAjax();
		view.addObject("searchTeamList", searchTeamList);
		view.setViewName("employeeInput/employeeInputSearch");
		
		return view;
	}

	// 팀별 프로젝트 검색
	@RequestMapping("/employeeInput/searchTeamProject")
	public ModelAndView getSearchTeamProjectListAjax(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		String tm_id = request.getParameter("tm_id");
		List<EmployeeInputVO> searchTeamProjectList = employeeInputService.getSearchTeamProjectListAjax(tm_id);
		view.addObject("searchTeamProjectList", searchTeamProjectList);
		view.setViewName("employeeInput/employeeInputList");

		return view;
	}

	// 선택한 프로젝트의 정보를 출력
	@RequestMapping("/employeeInput/getEmployeeInputDetailForm1")
	public ModelAndView getEmployeeInputDetailForm1(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		String pj_id = request.getParameter("pj_id");
		SessionController.SessionReturnMaSalPmHr(view, request);	//권한
		
		EmployeeInputVO employeeInputDetailForm1List = employeeInputService.getEmployeeInputDetailForm1Ajax(pj_id);
		view.addObject("employeeInputDetailForm1List", employeeInputDetailForm1List);
		view.setViewName("/employeeInput/employeeInputDetail");
		
		return view;
	}

	// 배치예정자 입력시 해당 직원의 정보 가져오기
	@RequestMapping("/employeeInput/getEmployeeInfo")
	@ResponseBody
	public Map<String, Object> getEmployeeInfo(HttpServletRequest request) {

		String pr_name = request.getParameter("pr_name");
		HumanResourceVO employeeInfoList = employeeInputService.getHrInfoByNameAjax(pr_name);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("employeeInfoList", employeeInfoList);

		return result;
	}
	
	// insert form 화면
	@RequestMapping("/employeeInput/getEmployeeInputInsertForm")
	public ModelAndView getEmployeeInputInsertForm(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturnMaSalPmHr(view, request);	// 권한
		
		view.setViewName("/employeeInput/employeeInputInsertForm");
		return view;
	}
	
	// 저장 버튼
	@RequestMapping("/employeeInput/insertPjDeploy")
	@ResponseBody
	public Map<String, Object> insertPjDeploy(HttpServletRequest request) {
		//b4_pd_name,pj_id, pd_sq, pd_name, pr_sq,pd_start_date, pd_end_date, pd_uprice, pd_ratio
		
		//수정시 이전 직원 이름
		String b4_pd_name = "";
		b4_pd_name = request.getParameter("b4_pd_name");
		
		String pj_id = request.getParameter("pj_id");
		
		int pd_sq;
		String pd_sqString = request.getParameter("pd_sq");
		if(pd_sqString=="")
			pd_sqString="0";
		pd_sq = Integer.parseInt(pd_sqString);
		
		String pd_name = request.getParameter("pd_name");
		
		int pr_sq;
		String pr_sqString = request.getParameter("pr_sq");
		if(pr_sqString=="")
			pr_sqString = "0";
		pr_sq = Integer.parseInt(pr_sqString);
		
		String pd_start_date = request.getParameter("pd_start_date");
		String pd_end_date = request.getParameter("pd_end_date");
		String uprice = request.getParameter("pd_uprice");
		
		/*String ratio = request.getParameter("pd_ratio");*/
		int pd_ratio = 100;
		/*if(ratio != null)
			pd_ratio = Integer.parseInt(ratio);*/
		
		if(uprice == null || uprice.trim().equals("")){
			uprice = "0";
		}
		int pd_uprice = Integer.parseInt(uprice);
		
		double mm = CalendarUtil.calculateManMonth(pd_start_date, pd_end_date);
		mm = Math.round(mm*10d)/10d;
		String pd_mm = Double.toString(mm);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("b4_pd_name", b4_pd_name);
		map.put("pj_id", pj_id);
		map.put("pd_sq", pd_sq);
		map.put("pd_name", pd_name);
		map.put("pr_sq", pr_sq);
		map.put("pd_start_date", pd_start_date);
		map.put("pd_end_date", pd_end_date);
		map.put("pd_uprice", pd_uprice);
		map.put("pd_ratio", pd_ratio);
		map.put("pd_mm", pd_mm);
		
		
		String b4_company=null;
		String message = null;
		Map<String, Object> result = new HashMap<String, Object>();
		HumanResourceVO pd_name_info = employeeInputService.getHrInfoByNameAjax(pd_name);
		String company = pd_name_info.getHr_company();
		
		//신규 투입일 경우 
		if(b4_pd_name == ""){
			if(employeeInputService.checkDuplicate(map)){
				message = "투입 기간이 중복됩니다. 날짜를 다시 확인하세요.";
			}
			else{
				employeeInputService.insertPjDeploy(map);
				if(company.contains("SQI"))
					totalService.getEmployWait("", pd_name);
				message = "저장되었습니다.";
			}
			
		}else{//수정일 경우
			HumanResourceVO b4_pd_name_info = employeeInputService.getHrInfoByNameAjax(b4_pd_name);
			b4_company = b4_pd_name_info.getHr_company();
			
			if(employeeInputService.checkDuplicate_mod(map)){
				message = "투입 기간이 중복됩니다. 날짜를 다시 확인하세요.";
			}
			else{
				employeeInputService.insertPjDeploy(map);
				
				if(b4_company.contains("SQI") && company.contains("SQI")){			//직원->직원
					totalService.getEmployWait(b4_pd_name, pd_name);
				}
				else if(b4_company.contains("SQI") && !(company.contains("SQI"))){	//직원->외주
					totalService.getEmployWait(b4_pd_name, "");
				}
				else if(!(b4_company.contains("SQI")) && company.contains("SQI")){	//외주->직원
					totalService.getEmployWait("", pd_name);
				}
				else{}														//외주->외주는 wait 테이블 수정할 필요 없음.
				
				message = "저장되었습니다.";
			}
		}
		result.put("message", message);
		
		return result;
	}
	
	@RequestMapping("/employeeInput/updateAllCost")
	public void updateCost(HttpServletRequest request) {
		String pj_id = request.getParameter("pj_id");
		employeeInputService.updateCost(pj_id);
	}
	
	
	// 삭제 버튼
	@RequestMapping("/employeeInput/deletePjDeploy")
	@ResponseBody
	public void deletePjRequire(HttpServletRequest request) {
		String b4_pd_name = "";
		b4_pd_name = request.getParameter("b4_pd_name");
		String pd_name = request.getParameter("pd_name");
		
		String pj_id = request.getParameter("pj_id");
		int pd_sq = Integer.parseInt(request.getParameter("pd_sq"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pj_id", pj_id);
		map.put("pd_sq", pd_sq);
		
		employeeInputService.deletePjRequire(map);
		
		HumanResourceVO pd_name_info = employeeInputService.getHrInfoByNameAjax(pd_name);
		String company = pd_name_info.getHr_company();
		
		if(company.contains("SQI"))
			totalService.getEmployWait("", pd_name);

		employeeInputService.updateCost(pj_id);
	}
	
	//투입 테이블과 배치소요 테이블에 있는 직원 명단을 List에 출력
	@RequestMapping("/employeeInput/getEmployeeInputDetailForm2")
	public ModelAndView getEmployeeInputDetailForm2(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		String pj_id = request.getParameter("pj_id");
		String hr_company=null;

		List<EmployeeInputVO> employeeInputDetailForm2List = employeeInputService.getEmployeeInputDetailForm2(pj_id);
		view.addObject("employeeInputDetailForm2List", employeeInputDetailForm2List);
		view.setViewName("/employeeInput/employeeInputDetail2");
		return view;

	}
	
	// 리스트에서 직원 선택시 해당 직원 정보를 insert form에 출력
	@RequestMapping("/employeeInput/getEmployeeInputInfoForm")
	@ResponseBody
	public Map<String, Object> getEmployeeInputInfoForm(HttpServletRequest request) {
		String sq = request.getParameter("pd_sq");
		String pr = request.getParameter("pr_sq");
		int pd_sq = Integer.parseInt(sq);
		int pr_sq = Integer.parseInt(pr);
		String pj_id = request.getParameter("pj_id");
		String pd_name = request.getParameter("pd_name");
		String ratio = request.getParameter("pd_ratio");
		int pd_ratio = 0;
		if(ratio != null)
			pd_ratio = Integer.parseInt(ratio);
		
		Map<String, Object> map = new HashMap<String, Object>();
				
		map.put("pd_sq", pd_sq);
		map.put("pj_id", pj_id);
		map.put("pd_name", pd_name);
		map.put("pr_sq", pr_sq);
		map.put("pd_ratio", pd_ratio);
		
		EmployeeInputVO employeeInputInfoForm = employeeInputService.getEmployeeInputInfoForm(map);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("employeeInputInfoForm", employeeInputInfoForm);

		return result;
	}
	
}