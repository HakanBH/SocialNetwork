package com.facebook.controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
    	
    	HttpServletRequest request = (HttpServletRequest) req;
    	boolean isJsp = true;
    	
    	if(request.getRequestURI().contains(".") || !request.getRequestURI().contains("jsp")){
    		isJsp=false;
    	}
    	
    	HttpSession session = request.getSession();
    	if(isJsp && (session.getAttribute("firstName") == null && !request.getServletPath().contains("/index"))){
    		HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect("index");
    	}else{
        	chain.doFilter(req, res);
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