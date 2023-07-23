<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.santhosh.model.ContactModel, com.santhosh.Db.Database, com.santhosh.error.Error" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table {
        width: 100%;
    }

    th, td {
        padding: 10px;
        text-align: center;
    }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			ContactModel.clearArrayList();
			Database.loadContact();
		} catch(Exception e) {
			out.println("data  is not retrieved");
		}
	%>
	
	<div style="display:flex;justify-content:center;">
		<div style="border:3px solid cyan;padding:10px;">
		    <form action="add" method="post">
		        <div style="margin-top:5px;"> Enter Your Name: <input type="text" name="uname" required> </div>
		        <div style="margin-top:5px;"> Enter Your ContactNo: <input type="text" name="mobile" required> </div>
		        <div style="margin-top:5px;"> Enter Your Email: <input type="email" name="gmail" required> </div>
		        <button style="margin-top:5px; margin-left:35%; background-color:red;"> Add Contact </button>
		    </form>
		</div>
	</div>
	
	<%
		ArrayList<String> errorMsg = Error.getErrorList();
		for(int i=0; i<errorMsg.size(); i++) {
	%>
			<div> <%= errorMsg.get(i)  %> </div>
	<%
		}
	%>
	
	<%
		ArrayList<ContactModel> cm = ContactModel.getList();
		if (!cm.isEmpty()) {
	%>
		<div style="margin:50px;">
		    <table>
		        <tr>
		            <th> Name </th>
		            <th> ContactNo </th>
		           <th> EmailId </th>
		            <th> </th>
		            <th> </th>
		        </tr>
	        
	        	<%
	        		for(int i=0;  i<cm.size(); i++) {
	        			ContactModel contact = cm.get(i);
	        	%>
	        
	        			<tr>
	        				<td><%= contact.getName() %></td>
	        				<td><%= contact.getContactNo() %></td>
	        				<td><%= contact.getEmail() %></td>
	        				<td>
	        					<form action="Edit.jsp" method="post">
	        						<input type="hidden" name="index" value="<%= i %>">
        							<button> Edit </button>
	        					</form>
	        				</td>
	        				<td>
	        					<form action="add" method="post">
	        						<input type="hidden" name="contactNo" value="<%= contact.getContactNo() %>">
        							<button> Delete </button>
	        					</form>
	        				</td>
	        			</tr>
	        			
	        <%
	        		}
	        %>
	    	</table>
	  	</div>
  	<%
		}
   %>
</body>
</html>
