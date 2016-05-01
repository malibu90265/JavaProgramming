package com.sqisoft.iqs.hr.pj.posting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.main.service.HrService;
import com.sqisoft.iqs.hr.pj.needs.service.PjNeedsService;
import com.sqisoft.iqs.hr.pj.posting.service.PjpostingService;
import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.hr.vo.PjpostingVO;
import com.sqisoft.iqs.pf.team.service.TeamServiceIF;
import com.sqisoft.iqs.pf.vo.PjHistoryVO;

@Controller
public class PjPostingController {

	private PjpostingService pjpostingService;
	private HrService hrService;
	private TeamServiceIF teamService;
	private PjNeedsService pjnService;

	public void setPjpostingService(PjpostingService pjpostingService) {
		this.pjpostingService = pjpostingService;
	}

	public void setHrService(HrService hrService) {
		this.hrService = hrService;
	}

	public void setTeamService(TeamServiceIF teamService) {
		this.teamService = teamService;
	}

	public void setPjnService(PjNeedsService pjnService) {
		this.pjnService = pjnService;
	}

	// 구배치page
	@RequestMapping("/pjpo.do")
	public ModelAndView pjposting(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView("pjposting");

		// List<Employee_VO> list = pjpostingService.getNoPlaceEmpList();

		mav.setViewName("pjposting");

		// mav.addObject("list", list);

		return mav;
	}

	// _2015-3-30 배치page controller 에서 메소드이름, jsp, js 파일명에 sample 붙어 있음 차후에 제거
	@RequestMapping("/pjposting.do")
	public ModelAndView pjpost(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pjPostingPlacement");

		return mav;
	}

	/*
	 * 프로젝트별(좌측) 검색
	 */
	@RequestMapping("/pjposting_Search.action")
	public ModelAndView pjposting_Search(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		String search_id = req.getParameter("search_id");
		String search_prog = req.getParameter("search_prog");
		String search_startday = req.getParameter("search_startday");
		String search_endday = req.getParameter("search_endday");

		List<PjpostingVO> posting = pjpostingService.pjposting_SearchList(search_id, search_prog, search_startday,
				search_endday);
		System.out.println("프로젝트 검색 목록 ~~~" + posting);
		mav.addObject("result_search", posting);

		mav.setViewName("JSON");

		return mav;
	}

	/*
	 * 프로젝트 배치된 사람 목록 조회
	 */

	@RequestMapping("/pjposting_Detail.action")
	public ModelAndView pjposting_Detail(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");

		// PjpostingVO pjposting_detail
		// =pjpostingService.pjposting_getPJ(pj_id);
		// BudgetVO pjposting_detail = pjnService.pjneeds_getPJ(pj_id);
		List<PjpostingVO> list = pjpostingService.pjposting_getEmp(pj_id);

		// logger.debug("pjposting_Detail:"+pj_id);
		// List<PjNeedsVO> pjneedsVO = pjnService.pjneeds_all(pj_id);
		// logger.debug("pjposting_detail"+pjposting_detail);
		// logger.debug("list"+list);
		// System.out.println("요가!!!!!!!!!!!"+list);
		// mav.addObject("vo", pjposting_detail);
		// mav.addObject("pn_list",pjneedsVO);
		mav.addObject("list", list);

		mav.setViewName("JSON");

		return mav;
	}
	/*
	 * 투입기간 이 현재를 지난 사람 목록 조회 (=투입이력조회)
	 */

	@RequestMapping("/pjposting_Detail_Past.action")
	public ModelAndView pjposting_Detail_Past(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		String pj_id = req.getParameter("pj_id");

		List<PjpostingVO> list = pjpostingService.pjposting_getEmpPast(pj_id);

		// logger.debug("list"+list);
		mav.addObject("list", list);

		mav.setViewName("JSON");

		return mav;
	}

	/*
	 * 투입이력조회 팝업_2015-03-30 배치 page에서 사용 x
	 */
	/*
	 * @RequestMapping("getPjHistory.action") public ModelAndView getPjHistory
	 * (HttpServletRequest req) throws Exception { ModelAndView mav = new
	 * ModelAndView(); String pj_id = req.getParameter("pj_id");
	 * 
	 * logger.debug("pj_id check : " + pj_id);
	 * 
	 * List<PjpostingVO> PjHistory
	 * =pjpostingService.pjposting_getPjHistory(pj_id);
	 * 
	 * mav.addObject("list",PjHistory);
	 * 
	 * mav.setViewName("JSON");
	 * 
	 * return mav; }
	 */
	/*
	 * 투입이력조회 팝업_2015-03-30 배치 page에서 사용 x
	 */
	/*
	 * @RequestMapping("getPJHistory.do") public String getPJHistory() { return
	 * "pjhistorypopup"; }
	 */

	/*
	 * @RequestMapping("/pjposting_delete.action") public @ResponseBody
	 * ModelAndView pjposting_delete(@RequestParam("deletelist") List<Object>
	 * deletelist ) throws Exception { // Object
	 * deletelist=req.getAttribute("deletelist"); // System.out.println(
	 * "삭제할 배열 "+deletelist); ModelAndView mav = new ModelAndView();
	 * mav.addObject("deletelist", deletelist); //
	 * mav.addObject("deletelist",req.getAttribute("deletelist")); //
	 * System.out.println("담아온것 : "+req.getParameter("deletelist"));
	 * System.out.println("담아온것2 : "+mav); mav.setViewName("JSON");
	 * 
	 * return mav; }
	 */
	/*
	 * @RequestMapping("/pjposting_delete.action") public ModelAndView
	 * pjposting_delete(HttpServletRequest req) throws Exception {
	 * System.out.println("여기왔다 ~"); System.out.println("담아온것2 : "
	 * +req.getAttribute("deletelist")); System.out.println("담아온것2 : "
	 * +req.getParameter("deletelist")); // Object
	 * deletelist=req.getAttribute("deletelist"); // System.out.println(
	 * "삭제할 배열 "+deletelist); ModelAndView mav = new ModelAndView(); //
	 * mav.addObject("deletelist", deletelist);
	 * mav.addObject("deletelist",req.getAttribute("deletelist")); //
	 * System.out.println("담아온것 : "+req.getParameter("deletelist"));
	 * System.out.println("담아온것2 : "+mav.getModel().toString());
	 * System.out.println("담아온것3 : "+mav); System.out.println("담아온것4 : "
	 * +mav.getClass());
	 * 
	 * mav.setViewName("JSON");
	 * 
	 * return mav; }
	 */

	/*
	 * // 프로젝트 배치 취소 시 pj_histroy 에서 삭제
	 * 
	 * @RequestMapping("/pjposting_delete.action") public @ResponseBody void
	 * pjposting_delete (HttpServletRequest req,@RequestParam Map<String,String>
	 * map) throws Exception { //배열로 key : 이름 , value : pj_id , division 가져와서
	 * service 호출 for(Map.Entry<String, String> elem :map.entrySet() ){
	 * System.out.println("delete key : "+elem.getKey()+"value : "
	 * +elem.getValue());
	 * pjpostingService.pjposting_delete(elem.getKey(),elem.getValue()); } //
	 * System.out.println("왔다네~~~~~"); // System.out.println("가져온 것 : "+
	 * req.getParameter("deletelist")); // String
	 * str=req.getParameter("deletelist"); // str = str.replace("{",""); // str
	 * = str.replace("}",""); // str = str.replace( "\"",""); // str =
	 * str.replace(":", ","); // // str = str.replaceAll('"',''); // String[]
	 * result = str.split(","); // for(int i=0; i<result.length; i+=2){ // //
	 * //System.out.println(i+"번째 방 : "+result[i]); //
	 * pjpostingService.pjposting_delete(result[i],result[i+1]); // // } }
	 */

	// 배치 _ 대기 삽입시 직원정보가 필요함, 직원인지 아닌지 정보 가져옴.직원이라면 hire_date 가져감 예외처리 위하여
	@RequestMapping("/empcheck.action")
	@ResponseBody
	public Map<String, String> empcheck(HttpServletRequest req) throws Exception {

		String name = req.getParameter("name").trim();

		System.out.println("emp check : ~~~~~~~" + name);
		Map<String, String> map = pjpostingService.empCheck(name);
		// String division = pjpostingService.empCheck(name);

		// map.put("division", division);
		// pjpostingService.pjposting_Insert(ph_vo);
		return map;
	}

	// 배치 insert_2015-3-30 배치page에서 사용
	@RequestMapping("/pjposting_Insert_sample.action")
	public @ResponseBody void pjposting_Insert_sample(HttpServletRequest req) throws Exception {
		String pj_id = req.getParameter("pj_id");
		String name = req.getParameter("name").trim();
		String pj_start_day = req.getParameter("startday").trim();
		String pj_end_day = req.getParameter("endday").trim();
		String division = req.getParameter("division");
		PjHistoryVO ph_vo = new PjHistoryVO(name, pj_id, pj_start_day, pj_end_day, division);
		// System.out.println("sample 저장 : ~~~~~~~"+ph_vo);
		pjpostingService.pjposting_Insert(ph_vo);

	}

	// 배치 update_2015-3-30 배치page에서 사용
	@RequestMapping("/pjposting_update_sample.action")
	public @ResponseBody void pjposting_update_sample(HttpServletRequest req) throws Exception {
		String pj_id = req.getParameter("pj_id");
		String name = req.getParameter("name").trim();
		String pj_start_day = req.getParameter("startday").trim();
		String pj_end_day = req.getParameter("endday").trim();
		String division = req.getParameter("division");
		PjHistoryVO ph_vo = new PjHistoryVO(name, pj_id, pj_start_day, pj_end_day, division);
		// System.out.println("sample 저장 : ~~~~~~~"+ph_vo);
		pjpostingService.pjposting_Update(ph_vo);

	}

	// 배치 delete_2015-3-30 배치page에서 사용
	@RequestMapping("/pjposting_delete_sample.action")
	public @ResponseBody void pjposting_delete_sample(@RequestParam Map<String, String> map) throws Exception {
		/*
		 * String pj_id = req.getParameter("pj_id"); String name =
		 * req.getParameter("name").trim(); String division =
		 * req.getParameter("division");
		 */
		System.out.println(map);
		pjpostingService.pjposting_delete(map);

	}
	
	@RequestMapping("/getEmployeeByName.action")
	public ModelAndView getEmployeeByName(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		
		List<Employee_VO> employeeList = pjpostingService.pjposting_getEmployessByName(name);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", employeeList);
		mav.setViewName("JSON");
		return mav;
	}
	
	//Define: 
	//			Project		: Pj
	//			Duration	: Dur
	//			Intersection: Intersec		
	@RequestMapping("/getPjIntersecDur.action")
	public ModelAndView getPjIntersecDur(HttpServletRequest request) {
		
		String name  = request.getParameter("name");
		
		String startDate	= request.getParameter("startDate");
		String endDate		= request.getParameter("endDate");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("startDate",startDate);
		map.put("endDate",	endDate);
		map.put("name",		name); 
		
		System.out.println(startDate + " / " + endDate + "/" + name);
		
		List<PjpostingVO> pjPostingVO = pjpostingService.getPjIntersecDur(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("onPjFlag", pjPostingVO.size());
		mav.addObject("pjPostingVOList", pjPostingVO);
		mav.setViewName("JSON");
		return mav;
	}
	
	/*
	 * 프로젝트 투입현황(+배치예정)
	 */
	/*
	 * @RequestMapping("/pjposting_Insert.action") public @ResponseBody void
	 * pjposting_Insert(HttpServletRequest req, Object String) throws Exception
	 * { String pj_id = req.getParameter("pj_id"); String name =
	 * req.getParameter("name").trim(); String cpid =
	 * req.getParameter("cpid").trim(); String cpendday
	 * =req.getParameter("cpendday").trim(); String apid =
	 * req.getParameter("apid").trim(); String apstartday =
	 * req.getParameter("apstartday").trim(); String apendday =
	 * req.getParameter("apendday").trim(); String use_skill =
	 * req.getParameter("use_skill").trim(); String ap_use_skill =
	 * req.getParameter("ap_use_skill").trim(); String division =
	 * req.getParameter("division"); String state = req.getParameter("state");
	 * logger.debug("상태는 ~~~~~~~~~~~"+state); //String cpstartday =
	 * pjpostingService.getCpstartday(name); String cpstartday
	 * =req.getParameter("cpstartday").trim(); // PjpostingVO pjvo = new
	 * PjpostingVO(name, cpid, cpstartday, cpendday, apid, apstartday,
	 * apendday,use_skill,ap_use_skill); // System.out.println("pjvo + "+pjvo);
	 * //2014.12.16 pj_history process 추가
	 * 
	 * PjHistoryVO ph_vo;
	 * 
	 * //현재프로젝트 - > update // 배치프로젝트 - > insert 하기 위해 // 구분 /// if
	 * (pj_id.equals(cpid)){ ph_vo = new PjHistoryVO(name, cpid, cpstartday,
	 * cpendday, use_skill, division); }else { ph_vo = new PjHistoryVO(name,
	 * apid, apstartday, apendday, ap_use_skill, division); }
	 * 
	 * if(state.equals("fixed")){ logger.debug("여길 할태야 "); logger.debug(
	 * "저장할 거는 이거지 : "+ph_vo); pjpostingService.pjposting_Update(ph_vo); } else
	 * if(state.equals("move")){ logger.debug("여길 할태야 "); logger.debug(
	 * "저장할 거는 이거지 : "+ph_vo); pjpostingService.pjposting_Insert(ph_vo);
	 * 
	 * }
	 * 
	 * // teamService.insertPjHistory(ph_vo);
	 * 
	 * // pjpostingService.pjposting_Insert(pjvo); }
	 * 
	 */
	// mpplace 해당 id null 처리 // ap(배치예정 PJ)의 해당 정보 null 처리
	/*
	 * @RequestMapping("/pjposting_Insert_bp.action") public ModelAndView
	 * pjposting_Insert_bp(HttpServletRequest req) { ModelAndView mav = new
	 * ModelAndView("JSON"); String pj_id = req.getParameter("pj_id");
	 * 
	 * pjpostingService.pjposting_Insert_bp(pj_id);
	 * 
	 * return mav; }
	 */

	/*
	 * // pj_history 대기 setting
	 * 
	 * @RequestMapping("pjposting_Insert_ap.action") public ModelAndView
	 * pjposting_Insert_ap(HttpServletRequest req) { ModelAndView mav = new
	 * ModelAndView("JSON"); String pj_id = req.getParameter("pj_id");
	 * 
	 * pjpostingService.pjposting_Insert_ap(pj_id);
	 * 
	 * return mav; }
	 */

	/*
	 * @RequestMapping("/empposting_Search.action") public ModelAndView
	 * empposting_Search(HttpServletRequest req) throws Exception { ModelAndView
	 * mav = new ModelAndView(); String area; String search_position =
	 * req.getParameter("search_position"); String search_area1 =
	 * req.getParameter("search_area1"); String search_area2 =
	 * req.getParameter("search_area2"); String search_etc =
	 * req.getParameter("search_etc"); String search_endday =
	 * req.getParameter("search_endday"); //2014.12.12 검색조건 추가 String search_div
	 * = req.getParameter("search_div");
	 * 
	 * 
	 * if(search_area2==null){ area=search_area1; logger.debug("if1:"+area);
	 * }else{ area=search_area2; logger.debug("if2:"+area); }
	 * 
	 * List<Employee_VO> posting =
	 * pjpostingService.empposting_SearchList(search_position,
	 * search_area1,search_area2,area, search_etc, search_endday, search_div);
	 * 
	 * 
	 * mav.addObject("list",posting);
	 * 
	 * mav.setViewName("JSON");
	 * 
	 * return mav; }
	 */

	/*
	 * 배치대상자 List _2015-3-30 배치page에서는 사용 x
	 */
	/*
	 * @RequestMapping("/getNoPlaceEmpList.action") public ModelAndView
	 * getNoPlaceEmpList()throws Exception { ModelAndView mav = new
	 * ModelAndView("pjposting");
	 * 
	 * List<Employee_VO> list = pjpostingService.getNoPlaceEmpList();
	 * logger.debug("getNoPlaceEmpList.action"+list);
	 * 
	 * for(Employee_VO list3:list){
	 * if(list3.getName().equals("오주환"))System.out.println("오주환있다."); }
	 * 
	 * mav.addObject("list", list);
	 * 
	 * mav.setViewName("JSON");
	 * 
	 * return mav; }
	 */

	/*
	 * 인원검색(외주중심) 팝업 _2015-3-30 배치page에서는 사용 x
	 */
	/*
	 * @RequestMapping("/emppjposting_Search.action") public ModelAndView
	 * emppjposting_Search(HttpServletRequest req) { String area; String name=
	 * req.getParameter("name"); String division = req.getParameter("division");
	 * String grade = req.getParameter("grade"); String area1=
	 * req.getParameter("area1"); String area2= req.getParameter("area2");
	 * String endday= req.getParameter("endday"); String groupcd=
	 * req.getParameter("groupcd"); String skillcd= req.getParameter("skillcd");
	 * 
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * if(area2==null){ area=area1; logger.debug("if1:"+area); }else{
	 * area=area2; logger.debug("if2:"+area); }
	 * 
	 * SkillVO vo = new
	 * SkillVO(name,division,grade,endday,area,"1",groupcd,skillcd);
	 * List<Employee_VO> list = pjpostingService.emppjposting_Search(vo);
	 * //System.out.println("검색!!!!!!!!!!" + list); logger.debug("검색~~~~~~~~" +
	 * list); //logger.debug(""+list.size());
	 * pjpostingService.SkillNameSet(list);
	 * 
	 * mav.addObject("list", list);
	 * 
	 * mav.setViewName("JSON");
	 * 
	 * return mav; }
	 */
	/*
	 * 인원검색(외주중심) 팝업_2015-3-30 배치page에서는 사용 x
	 */
	/*
	 * @RequestMapping("searchEmpl.do") public String searchEmpl() { return
	 * "serchpostingpopup"; }
	 */

}