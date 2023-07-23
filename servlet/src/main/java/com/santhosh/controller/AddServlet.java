package com.santhosh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import com.santhosh.Db.Database;
import com.santhosh.model.ContactModel;
import com.santhosh.error.Error;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("uname");
	    Long contactNo;
		String email = req.getParameter("gmail");
		PrintWriter out = res.getWriter();
		String referrer = req.getHeader("referer");
		if(Error.getErrorList().size() > 0) {
			Error.clearList();
		}
		if (req.getParameterMap().containsKey("contactNo")) {
			try {
				contactNo = Long.parseLong(req.getParameter("contactNo"));
				Database.deleteContact(contactNo);
				res.sendRedirect("inbox.jsp");
			} catch (SQLException | ClassNotFoundException e) {
				out.println(e.getMessage());
			}
		}
		else if(referrer.contains("inbox.jsp")) {
			try {
				contactNo = Long.parseLong(req.getParameter("mobile"));
				Error.checkEmail(email);
				Error.checkNo(contactNo);
				if(Error.getErrorList().size() == 0) {
					Database.createContact(name, contactNo, email);
				}
				res.sendRedirect("inbox.jsp");
			} catch (SQLException | ClassNotFoundException e) {
				out.println(e.getMessage());
			}
		} else if (referrer.contains("Edit.jsp")){
			try {
				contactNo = Long.parseLong(req.getParameter("mobiles"));
				Error.checkEmail(email);
				if(Error.getErrorList().size() == 0) {
					Database.updateContact(name, contactNo, email);
				}
				res.sendRedirect("inbox.jsp");
			} catch (SQLException | ClassNotFoundException e) {
				out.println(e.getMessage());
			}
		} 
	}
}
