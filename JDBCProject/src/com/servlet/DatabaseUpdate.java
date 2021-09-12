package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DBConnection;

/**
 * Servlet implementation class DatabaseUpdate
 */
@WebServlet("/DatabaseUpdate")
public class DatabaseUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int uid = Integer.parseInt( request.getParameter("uid") );
			String uname = request.getParameter("new_username");
		
		
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

			Properties prop = new Properties();

			prop.load(in);

			try {

				DBConnection db = new DBConnection(prop.getProperty("url"), prop.getProperty("user"),
						prop.getProperty("password"));

		
				PreparedStatement preparedStatement = db.getConnection().prepareStatement("update tbl_user set username=? where user_id=?  ");
				preparedStatement.setString(1, uname);
				preparedStatement.setInt(2, uid);
				
				preparedStatement.executeUpdate();
							

				db.closeConnection();

				response.sendRedirect("select");

			} catch (ClassNotFoundException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
		
		
		
	}

}
