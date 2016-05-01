package com.sqisoft.iqs.humanResource.deployMap.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.humanResource.deployMap.service.DeployMapService;
import com.sqisoft.iqs.humanResource.deployMap.vo.DeployMapVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class DeployMapController {
	
	private DeployMapService deployMapService;
	private TeamService teamService;

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	public void setDeployMapService(DeployMapService deployMapService) {
		this.deployMapService = deployMapService;
	}
	
	/*직원 외주 투입맵 >> 월별 투입 map */
	@RequestMapping(value="/deployMap/monthly")
	public String monthlyDeployMapForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		return "/deployMap/monthlyDeployMap";
	}
	
	// 검색
	@RequestMapping("/deployMap/searchForm")
	public ModelAndView getHumanResourceSearchFormAjax(){
		ModelAndView view = new ModelAndView();
		List<TeamVO> teamList = this.teamService.getTeamEmpStandByList();
		view.addObject("teamList",teamList);
		view.setViewName("/deployMap/deployMapSearch");
		return view;
	}
	
	//팀, 이름 검색
	@RequestMapping("/deployMap/teamAndNameSearchForm")
	public ModelAndView getTeamAndNameSearch(HttpServletRequest request){
		String tm_name = request.getParameter("tm_name");
		String radioId = request.getParameter("radioId");
		String hr_name = request.getParameter("hr_name");
		System.out.println("라디오 버튼 아이디~ : "+radioId);
		
		ModelAndView view = new ModelAndView();
		List<DeployMapVO> teamAndNameSearchList = null;
		
		if(radioId == null) {
			radioId = "직원";
		}
		if(tm_name != null || hr_name != null){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("tm_name", tm_name);
			param.put("radioId", radioId);
			param.put("hr_name", hr_name);
			
			teamAndNameSearchList = deployMapService.getTeamAndNameSearch(param);
		}
		List<DeployMapVO> list = mapManage(teamAndNameSearchList);
		
		
		view.addObject("deployMapVO", list);
		view.setViewName("JSON");
		
		return view;
	}
	

	@RequestMapping(value="/deployMap/monthlyDeployMap")
	public ModelAndView monthlyDeployMap(HttpServletRequest req) throws Exception{
		
		ModelAndView view = new ModelAndView();
		
		List<DeployMapVO> deployMapVOInfo = deployMapService.getMonthlyDeployMap();
		List<DeployMapVO> list = mapManage(deployMapVOInfo);
		
		view.addObject("deployMapVO", list);
		view.setViewName("JSON");
		return view;
	}

	@RequestMapping(value="/deployMap/outDeployMap")
	public ModelAndView outDeployMap() throws Exception{

		ModelAndView view = new ModelAndView();

		List<DeployMapVO> deployMapVOInfo = deployMapService.getOutDeployMap();
		List<DeployMapVO> list = mapManage(deployMapVOInfo);
		
		view.addObject("deployMapVO", list);
		view.setViewName("JSON");
		return view;
		
	}
	
	
	public static List<DeployMapVO> mapManage(List<DeployMapVO> DeployMapVOs) {
		
		List<String> names = new ArrayList<String>();
		Map<String, DeployMapVO> standHash = new HashMap<String, DeployMapVO>();
		List<DeployMapVO> ret_list = new ArrayList<DeployMapVO>();
		Calendar cal = Calendar.getInstance();

		for (DeployMapVO e : DeployMapVOs) {
			/*----------프로젝트 시작날짜,완료날짜 추출------------*/

			String startDate = e.getPd_start_date();
			String endDate = e.getPd_end_date();

			String start_day[] = startDate.split("-");
			int startYear = Integer.parseInt(start_day[0]);
			int startMonth = Integer.parseInt(start_day[1]);

			String end_day[] = endDate.split("-");
			int endYear = Integer.parseInt(end_day[0]);
			int endMonth = Integer.parseInt(end_day[1]);
			
			
			int year = cal.get(Calendar.YEAR);
			if (endYear !=  year)
				endMonth = 12;
			if(startYear != year)
				startMonth=1;
			

			DeployMapVO DeployMapVOTemp = null;
			// System.out.println(DeployMapVO.getpj());
			/*----------프로젝트를 하나만 수행했을 경우
			 * 즉,이름중복이 없을 경우------------*/
			
			if (!names.contains(e.getPd_name())) {
				for (int i = 0; i < 12; i++) {
					if (startMonth == i + 1) {
						e.setpj(i, e.getPj_id());
					} else if (endMonth == i + 1) {
						e.setpj(i, e.getPj_id());

					} else if (startMonth < i + 1 && endMonth > i + 1) {
						e.setpj(i, e.getPj_id());// 사잇값은 1.0으로
					}
				}
				standHash.put(e.getPd_name(), e);
				names.add(e.getPd_name());
				ret_list.add(e);
			} else {
				/*----------프로젝트를 두개이상 수행했을 경우
				 * 즉,이름중복이 있을 경우------------*/
				DeployMapVOTemp = standHash.get(e.getPd_name());

				int Startday_r = Integer.parseInt(e.getStartday_r());
				int Endday_r = Integer.parseInt(DeployMapVOTemp.getEndday_r());

				for (int i = 0; i < 12; i++) {

					if (startMonth == i + 1 && DeployMapVOTemp.getpj(i) != null) {// startMonth에
																				// 수행한
																				// 프로젝트가
																				// 있을
																				// 경우

						// 먼저 수행한 프로젝트 일수가 클 경우
						if ((Endday_r) > (Startday_r)) {
							DeployMapVOTemp.setpj(i, DeployMapVOTemp.getpj(i));

						} else {// 그 외의 경우
							DeployMapVOTemp.setpj(i, e.getPj_id());

						}

					} else if (startMonth == i + 1
							&& DeployMapVOTemp.getpj(i) == null) {// startMonth에
																// 수행한 프로젝트가 없을
																// 경우
						DeployMapVOTemp.setpj(i, e.getPj_id());

					} else if (startMonth < i + 1 && endMonth >= i + 1) {
						DeployMapVOTemp.setpj(i, e.getPj_id());

					}
				}
				DeployMapVOTemp.setPd_start_date(e.getPd_start_date());
				DeployMapVOTemp.setStartday_r(e.getStartday_r());
				DeployMapVOTemp.setPd_end_date(e.getPd_end_date());
				DeployMapVOTemp.setEndday_r(e.getEndday_r());
				DeployMapVOTemp.setPj_id(e.getPj_id());

				standHash.put(DeployMapVOTemp.getPd_name(), DeployMapVOTemp);
				for (DeployMapVO em : ret_list) {
					if (em.getPd_name().equals(DeployMapVOTemp.getPd_name())) {
						em = DeployMapVOTemp;
					}
				}

			}

		}
		SimpleDateFormat formatter = new SimpleDateFormat ( "MM", Locale.KOREA );
		Date currentTime = new Date ( );
		int dTime = Integer.parseInt(formatter.format ( currentTime ));
		
		for (DeployMapVO em : ret_list) {
			for (int j = 0; j < 12; j++) {
				if (em.getpj(j) == null && dTime-1 < j) {
					if (em.getHr_company().equals("SQIsoft")) {
						em.setpj(j, "미배치");
					} else {
						em.setpj(j, "");
					}
				} else if (em.getpj(j) == null && dTime-1 >= j) {
					if (em.getHr_company().equals("SQIsoft")) {
						em.setpj(j, "대기");
					} else {
						em.setpj(j, "");
					}
				}
			}
		}
		
		return ret_list;

	}
	

}
