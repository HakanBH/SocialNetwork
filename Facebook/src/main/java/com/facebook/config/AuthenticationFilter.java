package com.facebook.config;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.undertow.server.handlers.resource.ResourceHandler;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();

		boolean resourceRequest = request.getRequestURI().endsWith(".css") || request.getRequestURI().endsWith(".js")
				|| request.getRequestURI().endsWith(".jpg") || request.getRequestURI().endsWith(".png");
		boolean loggedIn = session.getAttribute("currentUser") != null;
		boolean isIndex = request.getRequestURI().endsWith("/index") || request.getRequestURI().endsWith("register") || request.getRequestURI().contains("login");
	
		if (loggedIn || isIndex || resourceRequest) {
			if (!resourceRequest) {
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
																							// 1.1.
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				response.setDateHeader("Expires", 0); // Proxies.
			}
			chain.doFilter(request, response);
		} else {
			response.sendRedirect("index");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}