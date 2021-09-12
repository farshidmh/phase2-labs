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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		
		Properties props = new Properties();
		props.load(in);
		
	
		try {
			DbConnection conn = new DbConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			
	

			String pid= request.getParameter("pid");
			
			String name = request.getParameter("name");
			
			String price = request.getParameter("price");
	
			
			Statement stmt = conn.getConnection().createStatement();
			
			
			stmt.executeUpdate("update eproduct set  name='"+name+"' , price="+price+"  where pid="+pid);
			
			
			
			
			stmt.close();
			
			
			conn.closeConnection();
			
			
			response.sendRedirect("index.html");
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	

	
	
}
