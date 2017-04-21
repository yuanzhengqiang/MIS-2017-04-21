package com.framework.system.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		//权限过滤器销毁
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String username = (String)httpRequest.getSession().getAttribute("loginname");
		String weixin = (String)request.getParameter("weixin");
		
		if (username == null && (!httpRequest.getRequestURI().contains("systemLogin.do"))&&!"weixin".equals(weixin)) {
			httpResponse.sendRedirect("systemLogin.do?loginpage"); 
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//权限过滤器初始化
	}

}
