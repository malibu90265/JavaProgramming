package com.sqisoft.iqs.humanResource.empStandBy.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.ManMonthVO;
import com.sqisoft.iqs.humanResource.empStandBy.service.EmpStandByService;
import com.sqisoft.iqs.humanResource.empStandBy.vo.EmpStandByVO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.team.service.TeamService;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionUtil;

@Controller
public class EmpStandByController {
	
	// TODO 이거 쓰는 건가요?????? 체크 바랍니다~
	// -> 사용하지 않는 패키지 입니다. 통째로 삭제해주세요.
	
	private EmpStandByService empStandByService;
	private TeamService teamService;

	public void setEmpStandByService(EmpStandByService empStandByService) {
		this.empStandByService = empStandByService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	//전체
	@RequestMapping("/empStandBy/empStandBy")
	public String empStandBy(HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO == null) {
			return "common/loginErrorPage";
		}
		
		return "/empStandBy/empStandBy";
	}
	
	//검색
	@RequestMapping("/empStandBy/getEmpStandBySearchFormAjax")
	public ModelAndView getEmpStandBySearchFormAjax(){
		ModelAndView view = new ModelAndView();
		List<TeamVO> teamList = this.teamService.getTeamEmpStandByList();
		view.addObject("teamList",teamList);
		view.setViewName("/empStandBy/empStandBySearchForm");
		return view;
	}
	
	@RequestMapping("/empStandBy/getEmpStandByListFormAjax")
	public ModelAndView getEmpStandByListFormAjax(HttpServletRequest request) throws ParseException{
		
		ModelAndView view = new ModelAndView();
		String tm_id = request.getParameter("tm_id");

		List<EmpStandByVO> empStandByVO = empStandByService.getEmpStandByTeamList(tm_id);
		empStandByVO = manMonthManage(empStandByVO);
		
		Collections.sort(empStandByVO, new TeamCompare());
		
		view.addObject("empStandByVO",empStandByVO);
		view.setViewName("JSON");
		
		return view;
	}
	
	public static List<EmpStandByVO> manMonthManage(List<EmpStandByVO> empStandByVOs) throws ParseException{
		
		List<String> names = new ArrayList<String>();
		Map<String, Map<String, ManMonthVO>> tempMap = new HashMap<String, Map<String, ManMonthVO>>();
		Map<String, ManMonthVO> tempMapValue = null;
		Map<String, ManMonthVO> manMonthMap = new HashMap<String, ManMonthVO>();
		
		Calendar now = Calendar.getInstance();
		int thisYear = now.get(Calendar.YEAR);
		float tempMm=0.0f;
		float entryMm=0.0f;
		float totalMm=0.0f;
		
		
		for(EmpStandByVO empStandByVO : empStandByVOs){
			
			//직원, 외주의 날짜계산 - 소속회사로 구분해야 할듯.
			//=>company가 SQI소프트(주)인 사람과 아닌사람으로 구분.
			
		}
		return null;
	}
	
	static public class TeamCompare implements Comparator<EmpStandByVO>{
		@Override
		public int compare(EmpStandByVO obj1, EmpStandByVO obj2) {
			return  obj1.getTm_id().compareTo(obj2.getTm_id());
		}
	}
	
}
