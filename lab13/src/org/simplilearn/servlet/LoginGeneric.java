package org.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginGeneric implements Servlet
{
	
	ServletConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet destoryed");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet init");
		this.config = config;
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		
		out.print("<html><body>");
		
		out.print(username);
		out.print("<br>");
		out.print(password);
		
		out.print("</body></html>");
		
		System.out.println(getServletConfig().getInitParameterNames());
		
		
		
		
		
		
	}
	
	
	

}
