package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DBConnection;

/**
 * Servlet implementation class DatabaseSelect
 */
@WebServlet("/DatabaseSelect")
public class DatabaseSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties prop = new Properties();

		prop.load(in);

		try {

			DBConnection db = new DBConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("password"));

			Statement stmt = db.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

		

			
			ResultSet rst = stmt.executeQuery("select * from tbl_user");
			
			
			
			response.getWriter().print("<html><body>");
			
			while(  rst.next()  ) {
				
				
				response.getWriter().print(  rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getString(4)
						+ "<a href='delete?userId="+rst.getInt(1)+"'>Delete</a>"
						+ " <br> " );
				
				
				
							
			}
			
			
			response.getWriter().print("</body></html>");
			
			
			
			stmt.close();
			
			db.closeConnection();
			
			
			
			
			
			

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
