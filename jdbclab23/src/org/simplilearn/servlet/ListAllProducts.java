package org.simplilearn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.util.DbConnection;

/**
 * Servlet implementation class ListAllProducts
 */
@WebServlet("/ListAllProducts")
public class ListAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllProducts() {
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
			
		
			Statement stmt2 = conn.getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY					
					);
			
			int a = 3;
			
			
			ResultSet rSet =  stmt2.executeQuery("select * from eproduct where pid>="+a);
			
			
			
		
			while(rSet.next()) {								
				System.out.println(  rSet.getInt("pid")+" | "+ rSet.getString("name")+" | "+rSet.getString("price")  );								
			}
			
		
			
			stmt2.close();
			conn.closeConnection();
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
