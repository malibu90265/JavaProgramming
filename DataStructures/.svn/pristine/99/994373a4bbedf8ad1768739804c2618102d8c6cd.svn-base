package com.sqisoft.iqs.humanResource.humanResource.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.admin.menu.controller.SessionController;
import com.sqisoft.iqs.admin.menu.vo.PhotoVO;
import com.sqisoft.iqs.humanResource.humanResource.service.HumanResourceService;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.humanResource.vo.HumanResourceEachListVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.service.TotalService;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller	
public class HumanResourceController {
	
	private HumanResourceService humanResourceService;
	private TeamService teamService;
	private TotalService totalService;

	public void setTotalService(TotalService totalService) {
		this.totalService = totalService;
	}
	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	// 직원 정보 전체 화면
	@RequestMapping("/humanResource/humanResource")
	public String humanResource(HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/humanResource/humanResource/humanResource";
	}
	
	// 직원 검색 화면
	@RequestMapping("/humanResource/getHumanResourceSearchFormAjax")
	public ModelAndView getHumanResourceSearchFormAjax(){
		ModelAndView view = new ModelAndView();
		this.optionSelectForm(view);
		view.setViewName("/humanResource/humanResource/humanResourceSearchForm");
		return view;
	}
	
	//직원 insert 화면
	@RequestMapping("/humanResource/getHumanResourceInsertFormAjax")
	public ModelAndView getHumanResourceInsertFormAjax(LoginVO loginVO, HttpServletRequest request){
		
		ModelAndView view = new ModelAndView();
		SessionController.SessionReturnHR(view, request);	// 권한
		
		this.optionSelectForm(view);
		
		view.setViewName("/humanResource/humanResource/humanResourceInsertForm");
		return view;
	}
	
	// 파일 경로 
	public String getFilePath(String FILE_PATH) {
		
		// 서버에서 사용하려고 바꾼 코드. 내부 프로젝트에서는 System.out.println 아래와 같은 결과값을 받습니다.
		ProtectionDomain pDomain = this.getClass().getProtectionDomain();
		CodeSource cSource = pDomain.getCodeSource();
		URL loc = cSource.getLocation();
		String url = loc.toString();
		
		FILE_PATH = url.substring(1, url.indexOf("classes"))+"/src/main/webapp/resources/employee";
		return FILE_PATH;
	}
	
	//직원 list 
	@RequestMapping("/humanResource/getHumanResourceListAjax")
	public ModelAndView getHumanResourceList(){
		ModelAndView view = new ModelAndView();
		List<HumanResourceVO> humanResourceList = humanResourceService.getHumanResourceListAjax();
		view.addObject("humanResourceList", humanResourceList);
		view.setViewName("/humanResource/humanResource/humanResourceList");
		return view;
	}
	
	//직원 팀, 이름 검색 list
	@RequestMapping("/humanResource/getHumanResourceSearchTeamAjax")
	public ModelAndView getHumanResourceListAjax(HttpServletRequest request){
		
		String tm_name = request.getParameter("tm_name");
		String hr_name = request.getParameter("hr_name");
		
		ModelAndView view = new ModelAndView();
		List<HumanResourceVO> humanResourceList = null;
		
		if(tm_name != null || hr_name != null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("tm_name", tm_name);
			param.put("hr_name", hr_name);
			humanResourceList = humanResourceService.getHumanResourceListSearchAjax(param);
		}
		view.addObject("humanResourceList", humanResourceList);
		view.setViewName("/humanResource/humanResource/humanResourceList");
		return view;
	}
	
/*	//직원 저장
	@RequestMapping(value="/humanResource/getHumanResourceInsertFormAjax2", method=RequestMethod.POST)
	public ModelAndView getHumanResourceDoInsertFormAjax(	@RequestParam("uploadFile") MultipartFile file
															, HumanResourceVO humanResourceVO,HttpServletRequest request) throws IOException{
		
		// 파일
		String FILE_PATH="";
		getFilePath(FILE_PATH);
		
		if(file.getOriginalFilename() == null || file.getOriginalFilename() == "") {
			humanResourceVO.setHr_img("emp_nophoto.jpg");	// 파일 입력 안 했을 경우
		}
		else {	
			MultipartFile uploadedFile = humanResourceVO.getUploadFile();
			
			File file2 = new File(FILE_PATH, file.getOriginalFilename());
			uploadedFile.transferTo(file2);
			humanResourceVO.setHr_img(uploadedFile.getOriginalFilename());
		}
		
		// 경력 년수 계산
		humanResourceVO = yearManage(humanResourceVO);
		this.humanResourceService.getHumanResourceDoInsertForm(humanResourceVO);
		
		String hr_name = request.getParameter("hr_name");
		String tm_id = request.getParameter("tm_id");
		String hr_position = request.getParameter("hr_position");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tm_id", tm_id);
		param.put("hr_position",hr_position);
		param.put("hr_name", hr_name);
		
		if(!tm_id.equals("6M15")){
			this.humanResourceService.getUpriceUpdate(param);
		}
		else{
			this.humanResourceService.getUpriceUpdate6M(param);
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/humanResource/humanResource/humanResource");
		return view;
	}*/
	
	//직원 저장 By yujin2015.11.24
	@RequestMapping(value="/humanResource/doInsertEmployeeInformation" ,method=RequestMethod.POST)
	public ModelAndView doInsertEmployeeInformation(@Valid HumanResourceVO humanResourceVO, Errors errors){
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()){
			view.setViewName("common/loginErrorPage");
		}
		//업로드된 파일을 가져온다. 
		MultipartFile uploadedFile = humanResourceVO.getUploadFile();
		
		if(uploadedFile != null){
			//파일이 저장될 결로는 지정한다. 
			String uploadedFileName = uploadedFile.getOriginalFilename();
			
			humanResourceVO.setHr_img(uploadedFileName);
			
			//Local Path
			/*File destFileDir = new File("C:\\Users\\Administrator\\Documents\\workspace-sts-3.6.1.RELEASE\\iqs_pj_test\\src\\main\\webapp\\resources\\employee\\");*/
			//Linux Path
			//File destFileDir = new File("//usr//local//tomcat//webapps//test//ROOT//resources//employee//");
			File destFileDir = new File("//employee//");
			
			if(!destFileDir.exists()){
				destFileDir.mkdirs();
			}
			
			File destFile = new File("//employee//", uploadedFileName);
			try{
				uploadedFile.transferTo(destFile);
			}catch(IllegalStateException | IOException e){
				throw new RuntimeException(e.getMessage(), e);
			}	
		}
		this.humanResourceService.insertEmployeeInfo(humanResourceVO);
		view.setViewName("/humanResource/humanResource/humanResource");
		return view;
	}
	
	//이미지 미리보기 링크 만들기. 
	//꼭 이미지 이름이 아닌 다른걸로 이미지 이름을 가져와야한다. .(점)이 사라지기 때문에. 
	@RequestMapping("/humanResource/download/{hr_name}")
	public void fileDownload(@PathVariable String hr_name, HttpServletRequest request, HttpServletResponse response){
		
		HumanResourceVO humanResourceInfo = this.humanResourceService.getHumanResourceInfo(hr_name);
		String realFileName = humanResourceInfo.getHr_img().trim();
		
		File downloadFile = new File("//employee//"+realFileName);
		
		try{
			if(downloadFile == null){
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			response.setContentType("application/download; charset=UTF-8");
		    response.setContentLength((int)downloadFile.length());
			//사용자의 브라우저 종류를 가져온다.
			String userAgent = request.getHeader("User-Agent");
			boolean isMsie = userAgent.indexOf("MSIE") >-1;
			
			String fileName = null;
			if(isMsie){
				fileName = URLEncoder.encode(humanResourceInfo.getHr_img(), "UTF-8");
			}
			else{
				fileName = new String (humanResourceInfo.getHr_img().getBytes("UTF-8"),"ISO-8859-1");
			}
			response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			
			try{
				fis = new FileInputStream(downloadFile);
				FileCopyUtils.copy(fis, out);
				out.flush();
			}
			finally{
				if(fis != null){
					fis.close();
				}
				if(out != null){
					out.close();
				}
			}
			}
			catch(Exception e){
				throw new RuntimeException(e.getMessage(), e);
			}

	}
	
	
	// 해당 직원의 정보를 insert form에 뿌려줌
	@RequestMapping("/humanResource/getHumanResourceDetailFormAjax")
	public ModelAndView getHumanResourceDetailFormAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		SessionController.SessionReturnHR(view, request);	// 권한
		
		String hr_name = request.getParameter("hr_name").trim();
		HumanResourceVO humanResourceVO = humanResourceService.getHumanResourceDetailFormAjax(hr_name);
		
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
		humanResourceVO = yearManage(humanResourceVO);
		
		this.optionSelectForm(view);
		
		view.addObject("resultCwm", resultCwm);
		view.addObject("humanResourceVO", humanResourceVO);
		view.setViewName("/humanResource/humanResource/humanResourceModifyForm");
		
		return view;
	}
	
	/*// 직원 정보 수정 후 저장 .수정 전 코드. 나중에 지우기. 
	@RequestMapping(value="/humanResource/getHumanResourceModifyFormAjax", method=RequestMethod.POST)
	public ModelAndView getHumanResourceModifyFormAjax( @RequestParam("uploadFile") MultipartFile file
														, HumanResourceVO humanResourceVO
														, HttpServletRequest request) throws IOException{
		
		// 파일 주소
		String FILE_PATH="";
		getFilePath(FILE_PATH);
		
		// 1 현재 단가 정보 불러오기
		String origin_hr_name = humanResourceVO.getHr_name();
		//기존에 DB에 저장 되어 있는 외주 정보
		HumanResourceVO originalVO = humanResourceService.getHumanResourceDetailFormAjax(origin_hr_name);
		
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
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		// 경력 년수 계산
		humanResourceVO = yearManage(humanResourceVO);
		
		// 최종 수행 프로젝트
		// 투입 테이블에서 종료일이 가장 나중인 프로젝트 이름을 가져옵니다.
		humanResourceVO.setHr_last_project(humanResourceService.getPersonDeployHistory(origin_hr_name));
						
		// 이름 받아서 디테일
		String hr_name = humanResourceVO.getHr_name();
		HumanResourceVO humanResourceVODetail = humanResourceService.getHumanResourceDetailFormAjax(hr_name);
		
		
		//팀별 단가를 가져와서 humanResource의 현재단가에 update.
		String tm_id = request.getParameter("tm_id");
		String hr_position = request.getParameter("hr_position");
		
		param.put("tm_id", tm_id);
		param.put("hr_position",hr_position);
		param.put("hr_name", hr_name);
		
		this.humanResourceService.getUpriceUpdate(param);
		
		//퇴사일 있으면 퇴사자 -> 소속회사 = null
		if(humanResourceVO.getHr_quit_date().length()!=0){
			humanResourceVO.setHr_company("");
			
			if(humanResourceService.getHumanResourceModifyFormAjax(humanResourceVO)){
				totalService.getEmployWait("",hr_name);
			}
		}else{
			humanResourceVO.setHr_company("SQIsoft");
			humanResourceService.getHumanResourceModifyFormAjax(humanResourceVO);
		}

		ModelAndView view = new ModelAndView();
		view.addObject("humanResourceVO", humanResourceVODetail);
		view.setViewName("/humanResource/humanResource/humanResourceModifyForm");
		return view;
	}*/
	
	//직원정보 수정 후 저장.-2015.11.24
	@RequestMapping(value="/humanResource/doUpdateEmployeeInformation",method=RequestMethod.POST)
	public ModelAndView doUpdateEmployeeInformation(@Valid HumanResourceVO humanResourceVO, Errors errors){
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()){
			view.setViewName("common/loginErrorPage");
		}
		//업로드된 파일을 가져온다. 
		MultipartFile uploadedFile = humanResourceVO.getUploadFile();
		
		if(uploadedFile != null){
			//파일이 저장될 결로는 지정한다. 
			String uploadedFileName = uploadedFile.getOriginalFilename();
			
			humanResourceVO.setHr_img(uploadedFileName);
			
			File destFileDir = new File("//employee//");
			
			if(!destFileDir.exists()){
				destFileDir.mkdirs();
			}
			
			//c:\\uploadedFiles에 저장한다. 
			File destFile = new File("//employee//", uploadedFileName);
			try{
				uploadedFile.transferTo(destFile);
			}catch(IllegalStateException | IOException e){
				throw new RuntimeException(e.getMessage(), e);
			}	
		}
		this.humanResourceService.updateEmployeeInfo(humanResourceVO);
		view.setViewName("/humanResource/humanResource/humanResource");
		return view;
	}
	
	
	// 경력 년수 계산
	@SuppressWarnings("null")
	private HumanResourceVO yearManage(HumanResourceVO humanResourceVO) {
		
		int it_career = 0, hire_date = 0, quit_date=0; //IT 경력 [단위: 년]
		String hr_career_date = humanResourceVO.getHr_career_date();	// 경력 기준일
		String hr_hire_date = humanResourceVO.getHr_hire_date();	// 직원 : 입사일
		String hr_quit_date = humanResourceVO.getHr_quit_date();	// 직원 : 퇴사일
		
		//현재 날짜 구하기
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		int now_date = Integer.parseInt(sdf.format(d).toString()); //현재 년월
		
		if(hr_hire_date!=null || hr_hire_date.length()!=0) {
			hr_hire_date = hr_hire_date.replaceAll("-", "").substring(0,6);
			hire_date = Integer.parseInt(hr_hire_date);
		}
		
		//직원일 경우
		if(humanResourceVO.getHr_company().contains("SQI")){
			//기존 IT 경력이 있는 경우 (즉, 재입사의 경우)
			if(humanResourceVO.getHr_it_career()!=0){
				//IT 경력 = 기존 IT 경력 + (현재 날짜 - 입사일)
				it_career = humanResourceVO.getHr_it_career() + (now_date - hire_date);
			}else{//기존 IT 경력이 없는 경우(신규 입사의 경우)
				//경력 기준일이 있을 경우 
				if(hr_career_date == null || hr_career_date.length() == 0){
					it_career = now_date - hire_date;
					
				}else{//경력 기준일이 없을 경우
					hr_career_date = hr_career_date.replaceAll("-", "").substring(0,6);//2015-10-06 인 경우 201510 으로..
					int career_date = Integer.parseInt(hr_career_date);
					
					//경력 기준일이 입사일보다 빠른 경우 : IT경력 = 현재 날짜 - 경력 기준일
					if(hire_date - career_date > 0){
						it_career = now_date - career_date;
					}else{//경력 기준일이 입사일보다 느린 경우 : IT경력 = 현재 날짜 - 입사일
						it_career = now_date - hire_date;
					}
				}
			}
		}else{//퇴사자의 경우
			if(hr_quit_date != null || hr_quit_date.length()!=0) {
				hr_quit_date = hr_quit_date.replaceAll("-", "").substring(0,6);
				quit_date = Integer.parseInt(hr_quit_date);
			}
			
			//경력 기준일이 없을 경우 
			if(hr_career_date == null || hr_career_date.length() == 0){
				it_career = quit_date - hire_date;
			}else{//경력 기준일이 있을 경우
				hr_career_date = hr_career_date.replaceAll("-", "").substring(0,6);//2015-10-06 인 경우 201510 으로..
				int career_date = Integer.parseInt(hr_career_date);
				
				//경력 기준일이 입사일보다 빠른 경우 : IT경력 = 퇴사일 - 경력 기준일
				if(hire_date - career_date > 0){
					it_career = quit_date - career_date;
				}else{//경력 기준일이 입사일보다 느린 경우 : IT경력 = 퇴사일 - 입사일
					it_career = quit_date - hire_date;
				}
			}
		}
		
		it_career = it_career/100;
		humanResourceVO.setHr_it_career(it_career);
		
		return humanResourceVO;
	}
	
	
	// 직원 삭제
	@RequestMapping("/humanResource/getHumanResourceDeleteFormAjax")
	public ModelAndView getHumanResourceDeleteFormAjax(HttpServletRequest request){
		
		String hr_name = request.getParameter("hr_name").trim();
		String hr_email = request.getParameter("hr_email");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("hr_name", hr_name);
		param.put("hr_email", hr_email);
		
		humanResourceService.getHumanResourceDeleteFormAjax(param);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/humanResource/humanResource/humanResourceInsertForm");
		
		return view;
	}
	
	//pj수행이력
	@RequestMapping("/humanResource/getPJWorkingHistoryPopupAjax")
	public ModelAndView getPJWorkingHistoryPopupAjax(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		String hr_name = request.getParameter("hr_name").trim();
		
		List<HumanResourceEachListVO> humanResourceEachList = humanResourceService.getPJWorkingHistoryPopupAjaxWithProject(hr_name);
		List<HumanResourceEachListVO> humanMonthEachList = monthManage(humanResourceEachList);
		
		view.addObject("humanResourceEachList", humanMonthEachList);
		view.setViewName("/humanResource/humanResource/humanResourcePopupList");
		
		return view;
	}
	
	// 근무 월수 계산
	private List<HumanResourceEachListVO> monthManage(List<HumanResourceEachListVO> humanResourceEachList) {
		
		List<HumanResourceEachListVO> list = new ArrayList<HumanResourceEachListVO>();
		
		for(HumanResourceEachListVO e : humanResourceEachList) {
			String startDate = e.getPd_start_date();
			String endDate = e.getPd_end_date();
			
			String start_day[] = startDate.split("-");
			int startYear = Integer.parseInt(start_day[0]);
			int startMonth = Integer.parseInt(start_day[1]);

			String end_day[] = endDate.split("-");
			int endYear = Integer.parseInt(end_day[0]);
			int endMonth = Integer.parseInt(end_day[1]);
			
			if(startYear == endYear) {	// 같은 해, 끝나는 달에서 현재 달을 뺌
				e.setSpan_of_work_date(endMonth-startMonth); 
			}
			else {	// 다른 해
				int yearCount = endYear-startYear;
				int yearToMonth = 0;
				int firstMonth = 0;
				if(yearCount == 1) {	// 1년 차이는 시작 달은 12에서 빼주고, 끝 달을 더해줌
					firstMonth = 12-startMonth;
					e.setSpan_of_work_date(firstMonth + endMonth);
				}
				else {	// 2년 이상 차이는 끝 해 에서 시작 해를 빼고, -1한 값에 *12를 해서 달 수를 구함. 시작 달은 12에서 빼주고, 끝 달을 더해줌
					yearToMonth = (yearCount-1)*12;
					firstMonth = 12-startMonth;
					e.setSpan_of_work_date(firstMonth + endMonth + yearToMonth);
				}
			}
			
			list.add(e);
		}
		return list;
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

