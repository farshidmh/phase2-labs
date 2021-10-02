package com.simplilearn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminAuthFilter
 */
@WebFilter("/admin/*")
public class AdminAuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AdminAuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession(false);

		boolean isLoggedIn = false;

		if (session != null && session.getAttribute("logged") != null && session.getAttribute("userId") != null) {
			isLoggedIn = true;
		}

		System.out.println(isLoggedIn);
		
		
		if (isLoggedIn) {

			chain.doFilter(request, response);

		} else {

			HttpServletResponse httpServletResponse = (HttpServletResponse) response;

			httpServletResponse.sendRedirect("../login.jsp?error=2");

		}
		
		System.out.println("Hit");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
