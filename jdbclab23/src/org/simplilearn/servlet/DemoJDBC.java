package org.simplilearn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.util.DbConnection;

/**
 * Servlet implementation class DemoJDBC
 */
@WebServlet("/DemoJDBC")
public class DemoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		
		Properties props = new Properties();
		props.load(in);
		
		
		try {
			DbConnection conn = new DbConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			
			Statement stmt = conn.getConnection().createStatement();
			
			stmt.executeUpdate("CREATE DATABASE simplilearn");
			
			System.out.println("Database has been created");
			
			stmt.close();
			
			conn.closeConnection();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	


}
