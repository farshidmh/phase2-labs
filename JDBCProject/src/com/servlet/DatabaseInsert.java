package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.service.DBConnection;

/**
 * Servlet implementation class DatabaseInsert
 */
@WebServlet("/DatabaseInsert")
public class DatabaseInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatabaseInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties prop = new Properties();

		prop.load(in);

		try {

			DBConnection db = new DBConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("password"));

			

			String uname = request.getParameter("username");
			String pass = request.getParameter("password");
			String fName = request.getParameter("fname");
			int gender = Integer.parseInt(   request.getParameter("gender")   );
			
			
			PreparedStatement pstmt = db.getConnection().prepareStatement("insert into tbl_user (username,password,full_name,gender) values (?,?,?,?)");
			
			
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			pstmt.setString(3, fName);
			pstmt.setInt(4, gender);
			
			
			pstmt.executeUpdate();
			
			
			pstmt.close();

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
