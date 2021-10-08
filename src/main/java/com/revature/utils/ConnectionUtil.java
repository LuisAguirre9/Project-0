package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.revature.utils.ConnectionUtil;

public class ConnectionUtil {

	private static ConnectionUtil connect;
	private static Properties props = new Properties();
	
	private ConnectionUtil() {
		//no arg constructor
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(connect == null) {
			return new ConnectionUtil();
		} 
		return connect;
	}
	
	//This gets my data from the jdbc file to start a connection
	public Connection getConnection() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
		String url = "";
		String password = "";
		String username = "";
	
		try {
			props.load(is);
			url = (String)props.getProperty("url");
			username = (String)props.getProperty("username");
			password = (String)props.getProperty("password");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Connection c;
		try {
			c = DriverManager.getConnection(url, username, password);
			return c;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
