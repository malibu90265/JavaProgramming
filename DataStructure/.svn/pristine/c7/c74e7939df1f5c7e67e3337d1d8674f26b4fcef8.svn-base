package com.sqisoft.iqs.humanResource.candidate.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.hr.pj.needs.dao.PjNeedsDAO;
import com.sqisoft.iqs.hr.vo.ConditionVO;
import com.sqisoft.iqs.hr.vo.TestVO;
import com.sqisoft.iqs.humanResource.candidate.dao.CandidateDAO;
import com.sqisoft.iqs.humanResource.candidate.service.CandidateService;
import com.sqisoft.iqs.humanResource.candidate.vo.CandidateVO;

public class CandidateServiceImpl implements CandidateService {

	private CandidateDAO candidateDAO;
	private PjNeedsDAO pjNeedsDAO;

	public void setCandidateDAO(CandidateDAO candidateDAO) {
		this.candidateDAO = candidateDAO;
	}
	public void setPjNeedsDAO(PjNeedsDAO pjNeedsDAO) {
		this.pjNeedsDAO = pjNeedsDAO;
	}
	
	private int parseIntegerCustomazing(String string) {
		int inte = 0;
		try {
			inte = Integer.parseInt(string);
		} catch(NumberFormatException nfe) {
			inte = 0;
		}
		return inte;
	}
	
	//select box에 넣을 팀 이름 가져오기
	@Override
	public List<CandidateVO> getSearchTeamListAjax() {
		return candidateDAO.getTeamNames();
	}

	//팀 선택시 해당 프로젝트 목록 가져오기.
	@Override
	public List<CandidateVO> getSearchTeamProjectListAjax(String tm_id) {
		List<CandidateVO> cv = candidateDAO.getProjectList(tm_id);
		return cv;
	}
	
	
	@Override
	public List<CandidateVO> getCandidateConditionList(String pjId) {
		List<CandidateVO> cv = this.candidateDAO.getCandidateConditionList(pjId);
		for(int i=0; i<cv.size(); i++){
			if(cv.get(i).getPr_grade()!=null)
				cv.get(i).setPr_grade(cv.get(i).getPr_grade().replaceAll("[0-9]", ""));
		}
		return cv;
	}
	
	@Override
	public List<CandidateVO> getCandidateDetailClickList(String grade) {
		return this.candidateDAO.getCandidateDetailClickList(grade);
	}
	
	/*검색 조건에 맞는 결과 리스트*/
	@Override
	public List<CandidateVO> arrangeCandidate(CandidateVO candidateVO) {
		List<CandidateVO> tmp= candidateDAO.getWholeHumanResourceOnCandidate();
		List<CandidateVO> l1 = new ArrayList<CandidateVO>();
		List<CandidateVO> l2 = new ArrayList<CandidateVO>();
		//Select Box에서 선택한 Option 5가지를 다 저장함.
		String selected[] = new String[5];
		selected[0] = candidateVO.getOne();
		selected[1] = candidateVO.getTwo();
		selected[2] = candidateVO.getThree();
		selected[3] = candidateVO.getFour();
		selected[4] = candidateVO.getFive();
				
		String pr_job_skill = candidateVO.getPr_job_skill();
		String pr_start_date = candidateVO.getPr_start_date();
		String pr_end_date = candidateVO.getPr_end_date().replace("-", "");
		String pr_grade = candidateVO.getPr_grade();
		String pj_loc = candidateVO.getPj_loc();
		
		for (int i=0; i<selected.length; i++) {
			switch (selected[i]) {
			case "선택": break;
			case "일자":
				for (int j = 0; j < tmp.size(); j++) {
					String pd_end_date = tmp.get(j).getPd_end_date().replace("-", "");
					if(!pd_end_date.contains(" ")){
						if(Integer.parseInt(pr_end_date)-Integer.parseInt(pd_end_date) > 0)
							l1.add(tmp.get(j));
					}
					else
						l1.add(tmp.get(j));
				}
				tmp.clear();
				tmp.addAll(l1);
				l1.clear();
				break;
				
			case "직원":
				for (int j = 0; j < tmp.size(); j++) {
					if((tmp.get(j).getHr_company().equals("직원"))) {
						l1.add(tmp.get(j));
					}
				}
				tmp.clear();
				tmp.addAll(l1);
				l1.clear();
				break;

			case "기술":
				for (int j = 0; j < tmp.size(); j++) {
					if((tmp.get(j).getHr_job_skill().equals(pr_job_skill))){
						l1.add(tmp.get(j));
					}
				}
				tmp.clear();
				tmp.addAll(l1);
				l1.clear();
				break;

			case "등급":
				for (int j = 0; j < tmp.size(); j++) {
					if((tmp.get(j).getHr_grade().contains(pr_grade))){
						l1.add(tmp.get(j));
					}
				}
				tmp.clear();
				tmp.addAll(l1);
				l1.clear();
				break;

			case "거주지":
				for (int j = 0; j < tmp.size(); j++) {
					if((tmp.get(j).getHr_residence().equals(pj_loc))) {
						l1.add(tmp.get(j));
					}
				}
				tmp.clear();
				tmp.addAll(l1);
				l1.clear();
				break;
			}
		}
		
		for(int p=0; p<tmp.size(); p++){
			if(tmp.get(p).getHr_grade()!=null)
				tmp.get(p).setHr_grade(tmp.get(p).getHr_grade().replaceAll("[0-9]", ""));
		}
		return tmp;
	}
	
	
	
	//우선순위에 따라 조건에따라 분리된 List 합치기
	private List<TestVO> combine_result(Map<String, List<TestVO>> resultMap, List<TestVO> firstList, List<TestVO> secondList, List<TestVO> resultList) {
		firstList = resultMap.get("firstList");
		secondList = resultMap.get("secondList");

		// resultList 기록 모두 삭제하고 다시 넣어주기
		resultList.clear();
		resultList.addAll(firstList);
		resultList.addAll(secondList);
		return resultList;

	}

	private Map<String, List<TestVO>> editList(List<TestVO> firstList, List<TestVO> secondList, ConditionVO conditionVO, String priority) {
		Map<String, List<TestVO>> resultMap = new HashMap<String, List<TestVO>>();
		List<TestVO> tempList = new ArrayList<TestVO>();

		if (priority.equals("pjDay")) {
			// TODO
			// employee 중에서 pj_history에 이력이 없는 사람 리스트
			// no_history에 이력이 없는 사람이 최우선이므로 먼저 넣어주는 작업 미완성
			
			for (TestVO vo : firstList) {
				
				int personalStart = Integer.parseInt( vo.getPersonalStart().split("-")[0] + vo.getPersonalStart().split("-")[1] + vo.getPersonalStart().split("-")[2] );
				int personalEnd = Integer.parseInt( vo.getPersonalEnd().split("-")[0] + vo.getPersonalEnd().split("-")[1] + vo.getPersonalEnd().split("-")[2] );
				int pjStart = Integer.parseInt( conditionVO.getCv_pjStart().split("-")[0] + conditionVO.getCv_pjStart().split("-")[1] + conditionVO.getCv_pjStart().split("-")[2].split(" ")[0] );
				int pjEnd = Integer.parseInt( conditionVO.getCv_pjEnd().split("-")[0] + conditionVO.getCv_pjEnd().split("-")[1] + conditionVO.getCv_pjEnd().split("-")[2].split(" ")[0] );
				
				if( (personalEnd < pjStart) || (pjEnd < personalStart) ) {
					tempList.add(vo);
				}
			}
			
			firstList.removeAll(tempList);
			secondList.addAll(0, firstList);
			
			resultMap.put("firstList", tempList);
			resultMap.put("secondList", secondList);
			
			return resultMap;
		}
		
		else if(priority.equals("division")) {
		
			for(TestVO vo : firstList) {
				if( !vo.getDivision().equals(conditionVO.getCv_division()) ) {
					tempList.add(vo);
				}
			}
		} else if (priority.equals("skill")) {
			for (TestVO vo : firstList) {
				if ((vo.getSkill() == null)
						|| !(vo.getSkill().equals(conditionVO.getCv_skill())) || ("".equals(vo.getSkill())) ) {
					tempList.add(vo);
				}
			}
		} else if (priority.equals("grade")) {
			for (TestVO vo : firstList) {
				if (vo.getGrade().charAt(1) != conditionVO.getCv_grade().charAt(0)) {
					tempList.add(vo);
				}
			}
		}
		else if(priority.equals("area")) {
			
			for(TestVO vo : firstList) {
				if( (vo.getArea() == null) || (!vo.getArea().equals(conditionVO.getCv_area())) ) {
					tempList.add(vo);
				}
			}
		}
		
		firstList.removeAll(tempList);
		secondList.addAll(0, tempList);
		
		resultMap.put("firstList", firstList);
		resultMap.put("secondList", secondList);
		
		return resultMap;
	}

	@Override
	public void insertRequireOnCandidate(Map<String, String> map) {
		candidateDAO.insertRequireOnCandidate(map);
	}
	

}
