<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.santhosh.model.ContactModel, java.util.*, com.santhosh.error.Error"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    int index = Integer.parseInt(request.getParameter("index"));
    ArrayList<ContactModel> cm = ContactModel.getList();
    ContactModel contact = cm.get(index); 
	%>
	
	<div style="display:flex;justify-content:center;">
		<div style="border:3px solid cyan;padding:10px;">
		    <form action="add" method="post">
		        <div style="margin-top:5px;"> Enter Your Name: <input type="text" name="uname" value="<%= contact.getName() %>" > </div>
		        <div style="margin-top:5px;"> Enter Your ContactNo: <input type="text" name="mobile" value="<%= contact.getContactNo() %>" disabled> </div>
		        <input type="hidden" name="mobiles" value="<%= contact.getContactNo() %>">
		        <div style="margin-top:5px;"> Enter Your Email: <input type="email" name="gmail" value="<%= contact.getEmail() %>" > </div>
		        <button style="margin-top:5px; margin-left:35%; background-color:red;"> Save </button>
		    </form>
		</div>
	</div>

</body>
</html>