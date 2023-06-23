package com.cake.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException {
		
		if(connection != null) {
			return connection;
		}
		else {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3307/cakedb?useSSL=false";
			String user  = "root";
			String password = "Shri@mys0l";
			
			Class.forName(driver);
			
			try {
				connection = DriverManager.getConnection(url, user, password);
			} 
			catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return connection;
		
	}
}
