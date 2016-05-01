package com.sqisoft.iqs.utils.session;

import javax.servlet.http.HttpSession;

public class SessionUtil {

	public static <T> void put(HttpSession session, Session sessionType, T value) {
		session.setAttribute(sessionType.getKey(), value);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(HttpSession session, Session sessionType) {
		return (T) session.getAttribute(sessionType.getKey());
	}
	
}
