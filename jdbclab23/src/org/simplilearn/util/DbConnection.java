package org.simplilearn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private Connection connection;
	
	public DbConnection(String dbURL,String dbUser,String dbPassword) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		this.connection = DriverManager.getConnection(dbURL,dbUser,dbPassword);		
		
	}
	
	
	public void closeConnection() throws Exception {
		if(this.connection!=null) {
			this.connection.close();
		}		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	

}
