package com.sqisoft.iqs.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqisoft.iqs.humanResource.employeeInput.vo.EmployeeInputVO;
import com.sqisoft.iqs.humanResource.humanResource.dao.HumanResourceDAO;
import com.sqisoft.iqs.humanResource.humanResource.vo.HumanResourceVO;
import com.sqisoft.iqs.project.dao.PjBudgetDAO;
import com.sqisoft.iqs.project.dao.ProjectDAO;
import com.sqisoft.iqs.project.vo.PjBudgetVO;
import com.sqisoft.iqs.project.vo.ProjectVO;
import com.sqisoft.iqs.team.dao.TeamDAO;
import com.sqisoft.iqs.team.dao.TotalDAO;
import com.sqisoft.iqs.team.vo.TeamVO;
import com.sqisoft.iqs.utils.calendar.CalendarUtil;

public class PjBudgetServiceImpl implements PjBudgetService {

	private PjBudgetDAO pjBudgetDAO;
	private ProjectDAO projectDAO;
	private TeamDAO teamDAO;
	private TotalDAO totalDAO;

	public TeamDAO getTeamDAO() {
		return teamDAO;
	}

	public PjBudgetDAO getPjBudgetDAO() {
		return pjBudgetDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public HumanResourceDAO getHumanResourceDAO() {
		return humanResourceDAO;
	}

	private HumanResourceDAO humanResourceDAO;

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void setPjBudgetDAO(PjBudgetDAO pjBudgetDAO) {
		this.pjBudgetDAO = pjBudgetDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setHumanResourceDAO(HumanResourceDAO humanResourceDAO) {
		this.humanResourceDAO = humanResourceDAO;
	}

	public void setTotalDAO(TotalDAO totalDAO) {
		this.totalDAO = totalDAO;
	}

	@Override
	public List<PjBudgetVO> getSelectedBudgetList(String pj_id) {
		return this.pjBudgetDAO.getSelectedBudgetList(pj_id);
	}

	@Override
	public List<PjBudgetVO> getProjectBudgetList(Map<String, Object> params) {
		return this.pjBudgetDAO.getProjectBudgetList(params);
	}

	// list에서 선택된 마지막 예산번호에 따른 프로젝트 가져오기
	public PjBudgetVO getpjBudgetInfo(String pj_id) {
		return this.pjBudgetDAO.getpjBudgetInfo(pj_id);
	}

	@Override
	public PjBudgetVO getCalculatedBudgetResult(String pj_id) {

		ProjectVO projectVO = this.projectDAO.getProjectInfo(pj_id);

		/* budgetVO */
		PjBudgetVO budgetVO = new PjBudgetVO();

		/* 프로젝트ID */
		budgetVO.setPj_id(pj_id);

		/* PJ 시작일, 종료일 */
		budgetVO.setPb_start_date(projectVO.getPj_start_date());
		budgetVO.setPb_end_date(projectVO.getPj_end_date());

		/* 투입 인원수 */
		int pd_put_number = this.pjBudgetDAO.getAllDeployCount(pj_id);
		budgetVO.setPb_put_num(pd_put_number);

		/* 총 매출액 (=계약액) */
		budgetVO.setPb_sales( projectVO.getPj_amount() );
		//budgetVO.setPb_sales(projectVO.getPj_year_sales());

		/* 상품비 */
		budgetVO.setPb_matl_cost(projectVO.getPj_matl_cost());
		
		// 간접경비
		
		
		/* 추가경비 */
		budgetVO.setPb_extra_cost(projectVO.getPj_extra_cost());

		/* 외주비 */
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("division", "외주");

		List<EmployeeInputVO> outsrcList = this.pjBudgetDAO.getEmployeeListFromDeployAndProject(params);

		float totalOutsrcMM = 0.0f;
		int pb_outsrc_cost = 0;
		for (EmployeeInputVO employee : outsrcList) {
			double manMonth = CalendarUtil.calculateManMonth(
					employee.getPd_start_date(), employee.getPd_end_date());			
			totalOutsrcMM += employee.getPd_mm()* (employee.getPd_ratio() / 100);
			System.out.println("(Math.round(manMonth * 100) / 100.0) : " + (Math.round(manMonth * 100) / 100.0));
			System.out.println("totalOutsrcMM : " + totalOutsrcMM);
			pb_outsrc_cost += manMonth * employee.getPd_uprice();
		}
		// 외주 MM
		budgetVO.setPb_outEmp_mm(projectVO.getPj_outEmp_mm());

		// 외주비
		if(projectVO.getPj_status() == 4) pb_outsrc_cost = (int)( Math.round(0.9d * pb_outsrc_cost *100) / 100 );
		else if(projectVO.getPj_status() == 5) pb_outsrc_cost = (int)( Math.round(0.5d * pb_outsrc_cost *100) / 100 ); 
		budgetVO.setPb_outsrc_cost(pb_outsrc_cost);

		params.put("division", "직원");
		List<EmployeeInputVO> laborList = this.pjBudgetDAO
				.getEmployeeListFromDeployAndProject(params);

		/* 인건비 */
		float totalLaborMM = 0;
		int pb_labor_cost = 0;
		for (EmployeeInputVO employee : laborList) {

			double manMonth = CalendarUtil.calculateManMonth(
					employee.getPd_start_date(), employee.getPd_end_date())
					* (employee.getPd_ratio() / 100);
			totalLaborMM += (Math.round(manMonth * 100) / 100.0);
			System.out.println("(Math.round(manMonth * 100) / 100.0) : " + (Math.round(manMonth * 100) / 100.0));
			System.out.println("totalLaborMM : " + totalLaborMM);

			HumanResourceVO humanResourceVO = this.humanResourceDAO
					.getHumanResourceDetailFormAjax(employee.getPd_name());

			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("tm_id", humanResourceVO.getTm_id());
			conditionMap.put("hr_position", humanResourceVO.getHr_position());

			int personal_labor_cost = 0;
			if (humanResourceVO.getTm_id().equals("6M15"))
				personal_labor_cost = employee.getPd_uprice();
			else
				personal_labor_cost = this.pjBudgetDAO
						.getEachLaborCost(conditionMap);

			pb_labor_cost += (int) Math.round(manMonth * personal_labor_cost);
		}
		// 직원 MM
		budgetVO.setPb_emp_mm(projectVO.getPj_emp_mm());
		// 인건비
		budgetVO.setPb_labor_cost(pb_labor_cost);

		return budgetVO;
	}

	@Override
	public boolean checkDuplicateYN(PjBudgetVO budgetVO) {
		return this.pjBudgetDAO.checkDuplicateYN(budgetVO) > 0;
	}

	@Override
	public String updateProjectBudgetInfo(PjBudgetVO budgetVO) {
		boolean isUpdateYN = this.pjBudgetDAO.updateProjectBudgetInfo(budgetVO);
		int pj_num = this.pjBudgetDAO.checkPjNumInfo(budgetVO.getPj_id());
		String message = "";
		if (isUpdateYN) {
			message = budgetVO.getPj_id() + "(" + budgetVO.getPb_no()
					+ ") 업데이트에 성공하였습니다";
			System.out.println(Math.round(budgetVO.getPb_outsrc_cost() / 1000) + "외주비");
			//this.changeProjectDBByBudget(budgetVO);
		} else {
			if (pj_num == 0) {
				message = "신규추가부터 해주십시요.";
			} else {
				message = budgetVO.getPj_id() + "(" + budgetVO.getPb_no()
						+ ") 업데이트에 실패하였습니다";
			}
		}

		return message;
	}

	@Override
	public String insertProjectBudgetInfo(PjBudgetVO budgetVO) {
		boolean isInsertYN = this.pjBudgetDAO.insertProjectBudgetInfo(budgetVO);

		String message = "";
		if (isInsertYN) {
			message = budgetVO.getPj_id() + "(" + budgetVO.getPb_no()
					+ ") 생성에 성공하였습니다";
		} else {
			message = budgetVO.getPj_id() + "(" + budgetVO.getPb_no()
					+ ") 생성에 실패하였습니다";
		}

		return message;
	}

	@Override
	public void changeProjectDBByBudget(PjBudgetVO budgetVO) {

		ProjectVO projectVO = new ProjectVO();
		projectVO.setPj_id(budgetVO.getPj_id());
		projectVO.setPj_amount(budgetVO.getPb_sales());
		projectVO.setPj_matl_cost(budgetVO.getPb_matl_cost());
		projectVO.setPj_extra_cost(budgetVO.getPb_extra_cost());
		projectVO.setPj_start_date(budgetVO.getPb_start_date());
		projectVO.setPj_end_date(budgetVO.getPb_end_date());

		this.projectDAO.modifyProjectInfo(projectVO);
	}

	@Override
	public Map<String, String> deleteBudgetInfoByPjId(String pj_id, String pb_no) {

		//System.out.println("서비스, " + pj_id + ", " + pb_no);
		Map<String, String> params = new HashMap<String, String>();
		params.put("pj_id", pj_id);
		params.put("pb_no", pb_no);

		// 성공 여부 메세지
		String message = "";
		boolean result = this.pjBudgetDAO.deleteBudgetInfoByPjId(params);
		if (result) {
			message = pj_id + "(" + pb_no + ") 프로젝트가 삭제되었습니다.";
		} else {
			message = pj_id + "(" + pb_no + ") 프로젝트가 삭제에 실패하였습니다.";
		}

		Map<String, String> resultParams = new HashMap<String, String>();
		resultParams.put("message", message);

		return resultParams;
	}

	// 프로젝트 예산 변경 내역
	public List<PjBudgetVO> getProjectHistoryInfo(String pj_id) {

		List<PjBudgetVO> pjBudgetVO = this.pjBudgetDAO
				.getProjectHistoryInfo(pj_id);
		ProjectVO projectVO = this.projectDAO.getProjectInfo(pj_id);

		float tm_expnc_rate = this.teamDAO.getTeamPJInfo(projectVO.getTm_id());
		for (PjBudgetVO pjHistoryBudgetVO : pjBudgetVO) {

			// 총mm
			double mmNum = (pjHistoryBudgetVO.getPb_emp_mm() * 1)
					+ (pjHistoryBudgetVO.getPb_outEmp_mm() * 1);
			String mmResult = String.format("%.2f", mmNum);

			// 순매출
			int netSales = pjHistoryBudgetVO.getPb_sales()
					- pjHistoryBudgetVO.getPb_matl_cost()
					- (pjHistoryBudgetVO.getPb_outsrc_cost() * 1);
			// 직접경비
			int pjDirectCost = (int) (pjHistoryBudgetVO.getPb_sales() * (tm_expnc_rate * 1));
			// 영업이익
			int salesProfit = netSales
					- (pjHistoryBudgetVO.getPb_labor_cost() * 1)
					- (pjHistoryBudgetVO.getPb_extra_cost() * 1) - pjDirectCost;
			pjHistoryBudgetVO.setMmResult(mmResult);
			pjHistoryBudgetVO.setNetSales(netSales);
			pjHistoryBudgetVO.setPjDirectCost(pjDirectCost);
			pjHistoryBudgetVO.setSalesProfit(salesProfit);
		}
		return pjBudgetVO;
	}

	// 프로젝트 예산번호에 따른 리스트 출력
	public PjBudgetVO getProjectHistoryListtest(Map<String, Object> params) {
		PjBudgetVO pjBudgetVO = this.pjBudgetDAO.getProjectHistoryInfo(params);
		if (pjBudgetVO == null)
			pjBudgetVO = new PjBudgetVO();
		return pjBudgetVO;
	}
}
