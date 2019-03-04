package io.gdiazs.mybank.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {


	
	private String appContextPath = null;
	
	private String publicKeyPath;
	
	
	

	public SecurityInterceptor(String applicationContext, String publicKeyResourcePath) {
		this.appContextPath = applicationContext;
		this.publicKeyPath = publicKeyResourcePath;
	}




	/**
	 * Validates cookie from browker, extracts the token and use public key to validate it
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		String jwt = "";

		String requestURI = request.getRequestURI();

		// Cause we are avoiding spring security, we will need a least a permitted login url
		if (requestURI.contains(this.appContextPath +"/login") || requestURI.contains("resources")
				|| requestURI.contains("errors")) {
			return true;
		}

		if (cookies == null) {
			response.sendRedirect(this.appContextPath +"/login");
			return false;

		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(SecurityUtils.USER_COOKIE)) {
					jwt = cookie.getValue();
					return SecurityUtils.isValidToken(jwt, this.publicKeyPath);
				}
			}
			request.setAttribute("jwt", jwt);
		}

		return true;

	}
	

	
	



}
