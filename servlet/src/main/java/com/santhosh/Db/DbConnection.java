package com.santhosh.Db;

import java.sql.*;

public class DbConnection {
    //Provide your database url and username and password;
	private static String url = "";
	private static String user = "";
	private static String pw = "";
	
	public static Connection getConnection() throws SQLException  {
		return DriverManager.getConnection(url, user, pw);
	}
}
