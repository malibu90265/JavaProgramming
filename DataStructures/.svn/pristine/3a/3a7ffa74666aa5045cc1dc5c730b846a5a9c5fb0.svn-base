package com.sqisoft.iqs.pf.member.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.sqisoft.iqs.hr.vo.Employee_VO;
import com.sqisoft.iqs.pf.member.dao.MemberDAO;
import com.sqisoft.iqs.pf.member.service.MemberService;
import com.sqisoft.iqs.pf.project.dao.ProjectDAO;
import com.sqisoft.iqs.pf.vo.LoginVO;
import com.sqisoft.iqs.pf.vo.ProjectVO;
import com.sqisoft.iqs.utils.session.Session;
import com.sqisoft.iqs.utils.session.SessionStore;
import com.sqisoft.iqs.utils.session.SessionUtil;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDao;
	private ProjectDAO p_dao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	public void setP_dao(ProjectDAO p_dao) {
		this.p_dao = p_dao;
	}
	
	@Override
	public LoginVO getMember(String email) {
		return memberDao.getMember(email);
	}
	
	@Override
	public int nameExist(String pj_biz){
		return memberDao.nameExist(pj_biz);
	}
	
	@Override
	public List<Employee_VO> nameSerch(){
		return  memberDao.nameSerch();
	}
	
	@Override
	public List<ProjectVO> pjSearch(String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> con = new ArrayList<String>();
		String team_id = "";
		String pj_id="";
		String pj_remo="";
		StringTokenizer st1 = new StringTokenizer(search);
		List<String> result=new ArrayList<String>();
		while (st1.hasMoreElements()) { 
			result.add(st1.nextElement().toString());		//특정문자로 자를시 사용
		}
		
		for (int i = 0; i < result.size(); i++) {
			if (i==0) {
				team_id = result.get(i);
			}
			else if(i==1 && !result.get(i).equals("최신") && !result.get(i).equals("1이월")  && !result.get(i).equals("2완료")  && !result.get(i).equals("3대기")  && !result.get(i).equals("4A급")  && !result.get(i).equals("5B급")  && !result.get(i).equals("6C급") && !result.get(i).equals("7종결")){
				pj_id=result.get(i);
			}
			else if(result.get(i).equals("최신")){
				pj_remo="r";
			}
			else{
				con.add(result.get(i));
			} 
		}
		
		map.put("team_id", team_id);
		map.put("pj_id", pj_id);
		map.put("con", con);
		map.put("pj_remo",pj_remo);
		
		List<ProjectVO> list = p_dao.pjSearch(map);
		for (ProjectVO p :list) {
			p.setBudget_sales((int) (p.getBudget_contract_sales()
					* p.getPj_operate() / (double) 100));
		}
		return list;
		
	}
	
	// 로그인
	@Override
	public ModelAndView doLogin(LoginVO loginVO, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		LoginVO loginVOInfo = this.memberDao.login(loginVO);
		
		if (loginVOInfo != null) {
			HttpSession session = request.getSession();
			SessionStore sessionStore = SessionStore.getInstance();
			
			// 퇴사일
			if(loginVOInfo.getHr_quit_date() == null) {
				if (sessionStore.isExists(loginVOInfo.getEmail())) {
					// 중복로그인일때
					// 기존의 세션을 로그아웃 및 로그인 세션이 시간이 다되서 만료되었을때 sessionListener Class를
					// 사용하여 처리.
					session = sessionStore.getSession(loginVOInfo.getEmail());
					if(session != null) session.invalidate();
					sessionStore.removeSession(loginVO.getEmail());
					session = request.getSession();
				}
				
				SessionUtil.put(session, Session.MEMBER, loginVOInfo);
				sessionStore.putSession(loginVOInfo.getEmail(), session);
				
				// 로그인 권한 설정
				// y / s : 로그인, n : 다른 페이지로 로드
				String account = loginVOInfo.getAccount();
				if(account.equals("y") || account.equals("s")) {
					view.setViewName("redirect:/admin/main");
				}
				else {
					view.setViewName("/common/loginErrorPage");
				}
			}
			else {
				view.setViewName("/login/login_main");
				view.addObject("message", "관리자에게 문의해주세요.");
			}
			
		} else {
			view.setViewName("/login/login_main");
			view.addObject("message", "아이디 혹은 이메일을 잘못 입력하였습니다.");
		}
		
		return view;
	}
	
	// 로그아웃
	@Override
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		SessionStore sessionStore = SessionStore.getInstance();
		
		sessionStore.getSession(loginVO.getEmail()).invalidate();
		sessionStore.removeSession(loginVO.getEmail());
		
		view.setViewName("redirect:/login");
		return view;
	}
	
	// 비밀번호 변경
	@Override
	public ModelAndView doChangePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 기존 패스워드 확인
		HttpSession session = request.getSession();
		
		// 세션에서 이메일을 받아서
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		String email = loginVO.getEmail();
		
		// 맵에 넣어 비밀번호를 받아옴
		Map<String, String> params = new HashMap<String, String>();
		params.put("password", request.getParameter("chkPassword"));
		params.put("email", email);
		int memberInfo = memberDao.getMemberInfoByEmail(params);
		
		ModelAndView view = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 비밀번호를 제대로 받았을 경우
		if(memberInfo > 0) {
			// 새로 입력 받은 패스워드 입력
			String password = request.getParameter("password");
			String passwordConfirm = request.getParameter("passwordCon");
			
			// 입력 값과 다를 경우
			if( !password.equals(passwordConfirm) ) {
				PrintWriter writer = response.getWriter();
				writer.println("<script type='text/javascript'>");
			    writer.println("alert('입력하신 비밀번호와 확인 비밀번호가 다릅니다.');");
			    writer.println("history.back();");
			    writer.println("</script>");
			    writer.flush();
			}
			// 같을 경우
			else {
				loginVO.setPassword(password);
				
				this.memberDao.changePassword(loginVO);
				
				// vo에 내용이 있으면
				if(loginVO != null) {
					// 세션에 정보 업데이트
					SessionUtil.put(session, Session.MEMBER, loginVO);
				}
				// 다 끝나면 메인으로 보냄
				view.setViewName("redirect:/admin/main");
				return view;
			}
			
		}
		// 기존 패스워드가 틀렸을 경우 alert
		else {
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
		    writer.println("alert('현재 패스워드가 틀렸습니다.');");
		    writer.println("history.back();");
		    writer.println("</script>");
		    writer.flush();
		}
		return null;
	}
	
	// 프로젝트 가져오기
	@Override
	public List<String> getLatestProject() {
		return memberDao.getLatestProject();
	}
}
