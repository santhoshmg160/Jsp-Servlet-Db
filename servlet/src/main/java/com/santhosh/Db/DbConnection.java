package com.santhosh.Db;

import java.sql.*;

public class DbConnection {
	private static String url = "jdbc:mysql://localhost:3306/Db";
	private static String user = "root";
	private static String pw = "san123!@#SAN";
	
	public static Connection getConnection() throws SQLException  {
		return DriverManager.getConnection(url, user, pw);
	}
}
