package com.santhosh.Db;

import java.sql.*;
import java.util.*;

import com.santhosh.model.ContactModel;

public class Database {

	public static void createContact(String name, long contactNo, String email) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DbConnection.getConnection();
		String query = "INSERT INTO Contacts VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setLong(2, contactNo);
		ps.setString(3, email);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public static void loadContact() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DbConnection.getConnection();
		String query = "SELECT *  FROM Contacts";
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ContactModel mod;
		ArrayList<ContactModel> cm = ContactModel.getList();
		while(rs.next()) {
			mod =  new ContactModel();
			mod.setName(rs.getString(1));
			mod.setContactNo(rs.getLong(2));
			mod.setEmail(rs.getString(3));
			cm.add(mod);	
		}
		st.close();
		con.close();
	}
	
	public static void updateContact(String name, long contactNo, String email) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DbConnection.getConnection();
		String query = "UPDATE Contacts SET Name = ?, emailId = ? WHERE contactNo = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setLong(3, contactNo);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public static void deleteContact(long contactNo) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DbConnection.getConnection();
		String query = "DELETE FROM Contacts WHERE contactNo = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, contactNo);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}
