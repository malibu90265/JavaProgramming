package com.sqisoft.iqs.utils.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionStore implements Serializable {

	private static final long serialVersionUID = -1628109799405190817L;
	
	private Map<String, HttpSession> sessions;
	private static SessionStore sessionStore;
	
	private SessionStore() {
		sessions = new HashMap<String, HttpSession>();
	}
	public static synchronized SessionStore getInstance() {
		if(SessionStore.sessionStore == null) {
			SessionStore.sessionStore = new SessionStore();
		}
		return SessionStore.sessionStore;
	}
	
	public synchronized void putSession(String id, HttpSession session) {
		this.sessions.put(id, session);
	}
	public synchronized HttpSession getSession(String id) {
		return this.sessions.get(id);
	}
	public synchronized boolean isExists(String id) {
		return this.sessions.containsKey(id);
	}
	public synchronized void removeSession(String id) {
		this.sessions.remove(id);
	}
	public synchronized int getAccessUsers() {
		return this.sessions.size();
	}
}
