package com.santhosh.model;

import java.sql.SQLException;
import java.util.*;

import com.santhosh.Db.Database;

public class ContactModel {
	private String name;
	private long contactNo;
	private String email;
	private static ArrayList<ContactModel> model;
	
	public static ArrayList<ContactModel> getList() {
		if (model == null) {
			model = new ArrayList<>();
		}
		return model;
	}
	
	public static void clearArrayList() {
		if(model!=null) {
			model.clear();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
