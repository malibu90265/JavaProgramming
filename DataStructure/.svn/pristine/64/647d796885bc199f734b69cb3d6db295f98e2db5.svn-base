package com.sqisoft.iqs.humanResource.humanResource.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionStore;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller	
public class OutHumanResourceController {
	
	private HumanResourceService humanResourceService;

	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}
	
	//String FILE_PATH = "C:/Users/Administrator/Documents/ProjectSpace/iqs_pj_test/src/main/webapp/resources/employee";
	// 파일 경로 
	// TODO MIME typetext/html로 들어감 shit
	public String getFilePath(String FILE_PATH) {
		
		 //내부 프로젝트에서 사용했던 코드
		 /*String url = this.getClass().getResource("").getPath();
		FILE_PATH = url.substring(1, url.indexOf(".metadata"))+"iqs_pj_test/src/main/webapp/resources/employee";*/
		
		// 서버에서 사용하려고 바꾼 코드. 내부 프로젝트에서는 System.out.println 아래와 같은 결과값을 받습니다.
		ProtectionDomain pDomain = this.getClass().getProtectionDomain();
		CodeSource cSource = pDomain.getCodeSource();
		URL loc = cSource.getLocation();
		String url = loc.toString();
		
		// file:/usr/local/tomcat/webapps/test/ROOT/WEB-INF/classes/com/sqisoft/iqs/humanResource/controller/HumanResourceController.class/Koala.jpg
		// /var/lib/jenkins/workspace/IQSTEST/iqs_pj_test/target/iqshr-1.0.0-BUILD-SNAPSHOT.war
		FILE_PATH = url.substring(1, url.indexOf("classes"))+"/src/main/webapp/resources/employee";
		// 위의 방법은 콘솔로 보면 데이터가 text로 저장됨.
		return FILE_PATH;
	}
	
	//외주정보전체
	@RequestMapping("/humanResource/outHumanResource/outHumanResource")
	public String outHumanResource(HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/outHumanResource/outHumanResource";
	}
	
	//외주검색
	@RequestMapping("/humanResource/getOutHumanResourceSearchFormAjax")
	public ModelAndView getOutHumanResourceSearchFormAjax(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/humanResource/outHumanResource/outHumanResourceSearchForm");
		return view;
	}
	
	//외주 list
	@RequestMapping("/humanResource/getOutHumanResourceListAjax")
	public ModelAndView getOutHumanResourceList(){
		ModelAndView view = new ModelAndView();
		List<HumanResourceVO> outHumanResourceList = humanResourceService.getOutHumanResourceListAjax();
		view.addObject("outHumanResourceList", outHumanResourceList);
		view.setViewName("/humanResource/outHumanResource/outHumanResourceList");
		return view;
	}
	
	//외주 이름, 등급 검색 list
	@RequestMapping("/humanResource/getOutHumanResourceSearchTeamAjax")
	public ModelAndView getOutHumanResourceListAjax(HttpServletRequest request){
		
		String hr_name = request.getParameter("hr_name");
		String hr_grade = request.getParameter("hr_grade");
		
		ModelAndView view = new ModelAndView();
		List<HumanResourceVO> outHumanResourceList = null;
		
		if(hr_name != null || hr_grade != null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("hr_name", hr_name);
			param.put("hr_grade", hr_grade);
			outHumanResourceList = humanResourceService.getOutHumanResourceListSearchAjax(param);
		}
		view.addObject("outHumanResourceList", outHumanResourceList);
		view.setViewName("/humanResource/outHumanResource/outHumanResourceList");
		return view;
		
	}
	
	//외주 insert
	@RequestMapping("/humanResource/getOutHumanResourceInsertFormAjax")
	public ModelAndView getOutHumanResourceInsertFormAjax(LoginVO loginVO, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		SessionController.SessionReturnHR(view, request);	// 권한
		
		this.optionSelectForm(view);
		view.setViewName("/humanResource/outHumanResource/outHumanResourceInsertForm");
		return view;
	}
	
	//외주 DoInsert
	@RequestMapping("/humanResource/getOutHumanResourceInsertFormAjax2")
	public ModelAndView getOutHumanResourceDoInsertFormAjax(@RequestParam("uploadFile") MultipartFile file
															, HumanResourceVO humanResourceVO, HttpServletRequest request)throws IOException{
		
		// 파일
		String FILE_PATH="";
		getFilePath(FILE_PATH);
		
		if(file.getOriginalFilename() == null || file.getOriginalFilename() == "") {
			humanResourceVO.setHr_img("emp_nophoto.jpg");	// 파일 입력 안 했을 경우
		}
		else {	// 파일 입력했을 경우
			MultipartFile uploadedFile = humanResourceVO.getUploadFile();
			
			File file2 = new File(FILE_PATH, file.getOriginalFilename());
			uploadedFile.transferTo(file2);
			humanResourceVO.setHr_img(uploadedFile.getOriginalFilename());
		}
		
		// 외주 평가 합치기
		String softAbc = humanResourceVO.getHr_soft_abc();
		String nomalAbc = humanResourceVO.getHr_nomal_abc();
		humanResourceVO.setHr_abc(nomalAbc+softAbc);
		
		
		this.humanResourceService.getOutHumanResourceDoInsertForm(humanResourceVO);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/humanResource/outHumanResource/outHumanResource");
		return view;
	}
	
	// 외주 개별 보기 : 수정 1단계
	@RequestMapping("/humanResource/getOutHumanResourceDetailFormAjax")
	public ModelAndView getOutHumanResourceDetailFormAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		SessionController.SessionReturnHR(view, request);	// 권한
		
		String hr_name = request.getParameter("hr_name").trim();
		HumanResourceVO humanResourceVO = humanResourceService.getouthumanResourceDetail(hr_name);
		
		// 체크박스 분리
		Map<String, Boolean> resultCwm = new HashMap<String, Boolean>();
		if(humanResourceVO.getHr_cwm_env() == null) {
			resultCwm.put("C", false);
			resultCwm.put("W", false);
			resultCwm.put("M", false);
			resultCwm.put("O", false);
		}
		else {
			resultCwm.put("C", false);
			resultCwm.put("W", false);
			resultCwm.put("M", false);
			resultCwm.put("O", false);
			
			for (int i = 0; i < humanResourceVO.getHr_cwm_env().length(); i++) {
				String key = String.valueOf(humanResourceVO.getHr_cwm_env().charAt(i));
				if(resultCwm.containsKey(key)) {
					resultCwm.put(key, true);
				}
			}
		}
		
		// 외주 평가 나눠서 가져오기
		if(humanResourceVO.getHr_abc()==null ||humanResourceVO.getHr_abc()=="") {
			humanResourceVO.setHr_nomal_abc("");
			humanResourceVO.setHr_soft_abc("");
		}
		else {
			for(int i=0; i<humanResourceVO.getHr_abc().length(); i++) {
				String result = String.valueOf(humanResourceVO.getHr_abc().charAt(i));
				if(result.length()==0) {
					humanResourceVO.setHr_nomal_abc(result);
				}
				else {
					humanResourceVO.setHr_soft_abc(result);
				}
			}
		}
		
		this.optionSelectForm(view);
		
		view.addObject("resultCwm", resultCwm);
		view.addObject("humanResourceVO", humanResourceVO);
		view.setViewName("/humanResource/outHumanResource/outHumanResourceModifyForm2");
		
		return view;
	}
	
	// 외주 수정
	@RequestMapping(value="/humanResource/getOutHumanResourceModifyFormAjax", method=RequestMethod.POST)
	public ModelAndView getOutHumanResourceModifyFormAjax( @RequestParam("uploadFile") MultipartFile file
														, HumanResourceVO humanResourceVO
														, HttpServletRequest request) throws IOException{
		
		// 파일 주소
		String FILE_PATH="";
		getFilePath(FILE_PATH);
		
		// 1 현재 단가 정보 불러오기
		String origin_hr_name = humanResourceVO.getHr_name();
		HumanResourceVO originalVO = humanResourceService.getHumanResourceDetailFormAjax(origin_hr_name);
		
		String hrUpdSave = originalVO.getHr_upd();
		String hrUpriceSave = originalVO.getHr_uprice();
		
		String hrb4UpdSave = originalVO.getHr_b4_upd();
		String hrb4UpriceSave = originalVO.getHr_b4_uprice();
		
		if(humanResourceVO.getHr_uprice().equals(hrUpriceSave)) {	// 만약 값이 같다면 안 넣고, 다르면 넣기
			humanResourceVO.setHr_b4_upd(hrb4UpdSave);
			humanResourceVO.setHr_b4_uprice(hrb4UpriceSave);
		}
		else {	// 1의 현재 단가를 이전 단가에 넣음
			humanResourceVO.setHr_b4_upd(hrUpdSave);
			humanResourceVO.setHr_b4_uprice(hrUpriceSave);
		}
		
		String temp = "";	// CWM 리스트
		if(humanResourceVO.getHr_cwm_env_list() != null) {
			for(String env : humanResourceVO.getHr_cwm_env_list()){
				temp += env;
			}
			humanResourceVO.setHr_cwm_env(temp);
		}
		
		// TODO 입력 값이 이미 있을 경우
		if(file.getOriginalFilename() == null || file.getOriginalFilename() == "") {
			humanResourceVO.setHr_img(originalVO.getHr_img());
		}
		else {	// 파일 입력했을 경우
			MultipartFile uploadedFile = humanResourceVO.getUploadFile();
			
			File file2 = new File(FILE_PATH, file.getOriginalFilename());
			uploadedFile.transferTo(file2);
			humanResourceVO.setHr_img(uploadedFile.getOriginalFilename());
		}
		
		// 외주 평가 나누기
		String softAbc = humanResourceVO.getHr_soft_abc();
		String nomalAbc = humanResourceVO.getHr_nomal_abc();
		humanResourceVO.setHr_abc(nomalAbc+softAbc);
		
		// 경력 년수 계산
//		humanResourceVO = yearManage(humanResourceVO);
		
		// 최종 수행 프로젝트
		// 투입 테이블에서 종료일이 가장 나중인 프로젝트 이름을 가져옵니다.
		humanResourceVO.setHr_last_project(humanResourceService.getPersonDeployHistory(origin_hr_name));
				
		// 수정
		humanResourceService.getHumanResourceModifyFormAjax(humanResourceVO);
		
		// 이름 받아서 디테일
		String hr_name = humanResourceVO.getHr_name();
		HumanResourceVO humanResourceVODetail = humanResourceService.getHumanResourceDetailFormAjax(hr_name);
		
		// 외주 평가 나눠서 가져오기
		if(humanResourceVO.getHr_abc()==null ||humanResourceVO.getHr_abc()=="") {
			humanResourceVO.setHr_nomal_abc("");
			humanResourceVO.setHr_soft_abc("");
		}
		else {
			for(int i=0; i<humanResourceVO.getHr_abc().length(); i++) {
				String result = String.valueOf(humanResourceVO.getHr_abc().charAt(i));
				if(result.length()==0) {
					humanResourceVO.setHr_nomal_abc(result);
				}
				else {
					humanResourceVO.setHr_soft_abc(result);
				}
			}
		}
		
		ModelAndView view = new ModelAndView();
		view.addObject("humanResourceVO", humanResourceVODetail);
		view.setViewName("/humanResource/outHumanResource/outHumanResourceModifyForm2");
		
		return view;
	}
	
	// 동명이인 검색
	@RequestMapping("/humanResource/getSamePersonCheck")
	@ResponseBody
	public Boolean getSamePersonCheckAjax (HttpServletRequest request) {
		String hr_name = request.getParameter("hr_name");
		Boolean result = humanResourceService.getSamePersonCheckAjax(hr_name);
		return result;
	}
	
	
	// 셀렉트 옵션 정리
	private void optionSelectForm(ModelAndView view) {
		
		// 팀
		Map<String, String> teamOptions = humanResourceService.getTeamOptions();
		// 직급
		Map<String, String> positonOptions = humanResourceService.getPositonOptions();
		// 등급
		Map<String, String> gradeOptions = humanResourceService.getGradeOptions();
		// CWM
		Map<String, String> hrCwmEnvListOptions = humanResourceService.getHrCwmEnvListOptions();
		// 직무기술
		Map<String, String> jobSkillOptions = humanResourceService.getJobSkillOptions();
		// OS
		Map<String, String> osOptions = humanResourceService.getOsOptions();
		// DB
		Map<String, String> dbOptions = humanResourceService.getDbOptions();
		// UI
		Map<String, String> uiOptions = humanResourceService.getUiOptions();
		// language
		Map<String, String> languageOptions = humanResourceService.getLanguageOptions();
		// frameWork
		Map<String, String> frameWorkOptions = humanResourceService.getFrameWorkOptions();
		// MiddleWare
		Map<String, String> middleWareOptions = humanResourceService.getMiddleWareOptions();
		// domain
		Map<String, String> domainOptions = humanResourceService.getDomainOptions();
		// role
		Map<String, String> roleOptions = humanResourceService.getRoleOptions();
		// 외주 평가
		Map<String, String> pdAbcOptions = humanResourceService.getPdAbcOptions();
		
		view.addObject("teamOptions", teamOptions);
		view.addObject("positonOptions", positonOptions);
		view.addObject("gradeOptions", gradeOptions);
		view.addObject("hrCwmEnvListOptions", hrCwmEnvListOptions);
		view.addObject("jobSkillOptions", jobSkillOptions);
		view.addObject("osOptions", osOptions);
		view.addObject("dbOptions", dbOptions);
		view.addObject("uiOptions", uiOptions);
		view.addObject("languageOptions", languageOptions);
		view.addObject("frameWorkOptions", frameWorkOptions);
		view.addObject("middleWareOptions", middleWareOptions);
		view.addObject("domainOptions", domainOptions);
		view.addObject("roleOptions", roleOptions);
		view.addObject("pdAbcOptions", pdAbcOptions);
	}
	
}
