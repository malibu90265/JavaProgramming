package com.sqisoft.iqs.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		
		if("/login".equals(request.getRequestURI())) return true;
		if(request.getRequestURI().indexOf("/login_main")>-1) return true;
		
		if (session.getAttribute("_MEMBER_")== null) {

			response.sendRedirect("/login");
			return false;

		}

		return true;
	}

}