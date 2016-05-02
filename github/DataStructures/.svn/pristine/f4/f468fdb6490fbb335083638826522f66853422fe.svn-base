package com.sqisoft.iqs.utils.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sqisoft.iqs.pf.vo.LoginVO;

public class SessionListener implements HttpSessionListener { 

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		LoginVO loginVO = SessionUtil.get(session, Session.MEMBER);
		
		if(loginVO != null) {
			SessionStore sessionStore = SessionStore.getInstance();
			sessionStore.getSession(loginVO.getEmail()).invalidate();
			sessionStore.removeSession(loginVO.getEmail());
			
		}
		
	}
}
