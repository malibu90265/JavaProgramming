package com.sqisoft.iqs.project_setting.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.project_setting.service.Project_settingService;
import com.sqisoft.iqs.project_setting.vo.Project_settingVO;
import com.sqisoft.iqs.project_setting.vo.Skill_envVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class Project_settingController {

	private Project_settingService project_settingService;
	private TeamService teamService;

	public void setProject_settingService(Project_settingService project_settingService) {
		this.project_settingService = project_settingService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	// 메인 project_setting.jsp
	@RequestMapping("/project_setting/project_setting")
	public String project_setting(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/project_setting/project_setting";
	}

	// 검색 project_settingSearchForm.jsp
	@RequestMapping("/project_setting/getProject_settingSearchPageAjax")
	public ModelAndView getProjcet_settingSearchpageAjax() {
		Calendar oCalendar = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기
		int year =  oCalendar.get(Calendar.YEAR);
		List<TeamVO> teamList = this.teamService.getTeamListAjax(year);

		ModelAndView view = new ModelAndView();
		view.addObject("teamList", teamList);
		view.setViewName("/project_setting/project_settingSearchForm");

		return view;
	}

	// 검색 리스트 출력 project_settingListForm.jsp
	@RequestMapping("/project_setting/getProject_settingListBySearchConditionsAjax")
	public ModelAndView getProject_settingListBySearchConditionsAjax(String tm_id) {
		List<Project_settingVO> project_settingList = this.project_settingService.getProject_settingList(tm_id);

		ModelAndView view = new ModelAndView();

		view.addObject("project_settingList", project_settingList);

		view.setViewName("/project_setting/project_settingListForm");

		return view;
	}

	// 입력 양식 project_settingInsertForm.jsp
	@RequestMapping("/project_setting/project_settingInsert")
	public ModelAndView getInsertProject_settingAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturnSalAndPM(view, request);	// 권한설정
		
		view.setViewName("/project_setting/project_settingInsertForm");
		return view;
	}
	
	// 셀렉트 옵션 정리
	private void optionSelectForm(ModelAndView view) {
		List<Skill_envVO> skill_envDBList = this.project_settingService.getProject_settingDBList("DB");
		List<Skill_envVO> skill_envOSList = this.project_settingService.getProject_settingOSList("OS");
		List<Skill_envVO> skill_envUIList = this.project_settingService.getProject_settingUIList("UI");
		List<Skill_envVO> skill_envLangList = this.project_settingService.getProject_settingLangList("Language");
		List<Skill_envVO> skill_envFWList = this.project_settingService.getProject_settingFWList("Framework");
		List<Skill_envVO> skill_envMWList = this.project_settingService.getProject_settingMWList("MiddleWare");
		
		view.addObject("skill_envDBList", skill_envDBList);
		view.addObject("skill_envOSList", skill_envOSList);
		view.addObject("skill_envUIList", skill_envUIList);
		view.addObject("skill_envLangList", skill_envLangList);
		view.addObject("skill_envFWList", skill_envFWList);
		view.addObject("skill_envMWList", skill_envMWList);
	}

	// 수정 양식 project_settingModifyForm.jsp
	@RequestMapping("/project_setting/project_settingModify")
	public ModelAndView getModifyProject_settingAjax(String tm_id, String pj_id, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturnSalAndPM(view, request);	// 권한설정
		
		Project_settingVO project_settingInfo = this.project_settingService.getproject_settingInfo(tm_id, pj_id);

		// 체크박스 분리
		Map<String, Boolean> resultCwm = checkBoxDivide(project_settingInfo);
		
		this.optionSelectForm(view);
		view.addObject("resultCwm", resultCwm);
		view.addObject("project_settingInfo", project_settingInfo);
		view.setViewName("/project_setting/project_settingModifyForm");
		return view;
	}

	// 저장
	@RequestMapping("/project_setting/project_settingModifyFormAjax")
	public ModelAndView project_settingModifyFormAjax(Project_settingVO project_settingVO, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		SessionController.SessionReturnSalAndPM(view, request);	// 권한설정
		
		String pj_id = project_settingVO.getPj_id();
		
		// CWM 리스트
		String temp = "";
		if (project_settingVO.getPj_cwm_env_list() != null) {
			for (String env : project_settingVO.getPj_cwm_env_list()) {
				temp += env;
			}
			project_settingVO.setPj_cwm_env(temp);
		}
		//OS/DB/언어 등이 선택으로 되어있으면 null로 넣어주기
		setOptionListCheck(project_settingVO);

		this.project_settingService.project_settingModifyFormAjax(project_settingVO);

		Project_settingVO project_settingInfo = this.project_settingService.getproject_settingResetInfo(pj_id);
		
		// 체크박스 분리
		Map<String, Boolean> resultCwm = checkBoxDivide(project_settingInfo);
		
		this.optionSelectForm(view);
		view.addObject("resultCwm", resultCwm);
		view.addObject("project_settingInfo", project_settingInfo);
		view.setViewName("/project_setting/project_settingModifyForm");

		return view;

	}

	private Map<String, Boolean> checkBoxDivide(Project_settingVO project_settingInfo){
		// 체크박스 분리
		Map<String, Boolean> resultCwm = new HashMap<String, Boolean>();
		resultCwm.put("C", false);
		resultCwm.put("W", false);
		resultCwm.put("M", false);
		resultCwm.put("O", false);
		
		if ((project_settingInfo.getPj_cwm_env() == null) || (project_settingInfo.getPj_cwm_env().equals(""))) {
			resultCwm.put("C", false);
			resultCwm.put("W", false);
			resultCwm.put("M", false);
			resultCwm.put("O", false);
		} else {
			for (int i = 0; i < project_settingInfo.getPj_cwm_env().length(); i++) {

				String key = String.valueOf(project_settingInfo.getPj_cwm_env().charAt(i));
				if (resultCwm.containsKey(key)) {
					resultCwm.put(key, true);
				}
			}
		}
		
		return resultCwm;
	}

	private void setOptionListCheck(Project_settingVO project_settingVO) {
		if(project_settingVO.getPj_os().equals("선택")){
			project_settingVO.setPj_os(null);
		}
		
		if(project_settingVO.getPj_DB().equals("선택")){
			project_settingVO.setPj_DB(null);
		}
		
		if(project_settingVO.getPj_ui().equals("선택")){
			project_settingVO.setPj_ui(null);
		}
		
		if(project_settingVO.getPj_lang().equals("선택")){
			project_settingVO.setPj_lang(null);
		}
		
		if(project_settingVO.getPj_fw().equals("선택")){
			project_settingVO.setPj_fw(null);
		}
		
		if(project_settingVO.getPj_mw().equals("선택")){
			project_settingVO.setPj_mw(null);
		}
	}

}
