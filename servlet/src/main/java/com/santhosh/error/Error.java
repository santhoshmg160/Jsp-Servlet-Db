package com.santhosh.error;

import com.santhosh.model.ContactModel;
import java.util.*;

public class Error {
	static ArrayList<String> errorMsg = new ArrayList<>();
	static ArrayList<ContactModel> cm = ContactModel.getList();
	
	public static ArrayList<String> getErrorList() {
		return errorMsg;
	}
	
	public static void checkNo(long contactNo) {
		for (ContactModel x : cm)  {
			if(x.getContactNo() == contactNo) {
				errorMsg.add("ContactNo Already Exists");
			}
		}
	}
	
	public static void checkEmail(String email, long contactNo, String method) {
		for (ContactModel x : cm)  {
			if(method.equals("create")) {
				if(x.getEmail().equals(email)) {
					errorMsg.add("EmailId Already Exists");
				}
			} else {
				if(x.getEmail().equals(email) && x.getContactNo != contactNo) {
					errorMsg.add("EmailId Already Exists");
				}
			}
		}
	}
	
	public static void clearList() {
		errorMsg.clear();
	}
}
