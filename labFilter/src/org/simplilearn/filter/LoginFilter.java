package org.simplilearn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String uid = request.getParameter("userId");
		
		if(uid != null ) {
			
			chain.doFilter(request, response);
			
			
		}else {
			
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;

			httpServletResponse.sendRedirect("error.html");
								
			
			
		}
		
		
		
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
